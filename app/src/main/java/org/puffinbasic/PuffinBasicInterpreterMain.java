package org.puffinbasic;

import com.google.common.base.Strings;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.puffinbasic.antlr4.PuffinBasicLexer;
import org.puffinbasic.antlr4.PuffinBasicParser;
import org.puffinbasic.domain.PuffinBasicSymbolTable;
import org.puffinbasic.error.PuffinBasicRuntimeError;
import org.puffinbasic.error.PuffinBasicSyntaxError;
import org.puffinbasic.file.PuffinBasicFile;
import org.puffinbasic.file.SystemInputOutputFile;
import org.puffinbasic.parser.LinenumberListener;
import org.puffinbasic.parser.LinenumberListener.ThrowOnDuplicate;
import org.puffinbasic.parser.PuffinBasicIR;
import org.puffinbasic.parser.PuffinBasicIRListener;
import org.puffinbasic.parser.PuffinBasicImportPath;
import org.puffinbasic.parser.PuffinBasicSourceFile;
import org.puffinbasic.runtime.Environment;
import org.puffinbasic.runtime.Environment.SystemEnv;
import org.puffinbasic.runtime.PuffinBasicRuntime;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.stream.Stream;

import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.IMPORT_ERROR;
import static org.puffinbasic.error.PuffinBasicRuntimeError.ErrorCode.IO_ERROR;
import static org.puffinbasic.parser.LinenumberListener.ThrowOnDuplicate.LOG;
import static org.puffinbasic.parser.LinenumberListener.ThrowOnDuplicate.THROW;

import android.os.Build;

import androidx.annotation.RequiresApi;

public final class PuffinBasicInterpreterMain {

    private static final String UNKNOWN_SOURCE_FILE = "<UNKNOWN>";

    private enum SourceFileMode {
        MAIN,
        LIB
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String... args) {
        var userOptions = parseCommandLineArgs(args);

        String mainSource = userOptions.filename;

        Instant t0 = Instant.now();
        var sourceCode = loadSource(mainSource);
        logTimeTaken("LOAD", t0, userOptions.timing);

        var stdinout = new SystemInputOutputFile(System.in, System.out);
        try {
            interpretAndRun(userOptions, mainSource, sourceCode, stdinout, new SystemEnv());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static UserOptions parseCommandLineArgs(String... args) {
        var parser = ArgumentParsers
                .newFor("PuffinBasic")
                .build();
        parser.addArgument("-d", "--logduplicate")
                .help("Log error on duplicate")
                .action(Arguments.storeTrue());
        parser.addArgument("-l", "--list")
                .help("Print Sorted Source Code")
                .action(Arguments.storeTrue());
        parser.addArgument("-i", "--ir")
                .help("Print IR")
                .action(Arguments.storeTrue());
        parser.addArgument("-t", "--timing")
                .help("Print timing")
                .action(Arguments.storeTrue());
        parser.addArgument("-g", "--graphics")
                .help("Enable graphics")
                .action(Arguments.storeTrue());
        parser.addArgument("file").nargs(1);
        Namespace res = null;
        try {
            res = parser.parseArgs(args);
        } catch (ArgumentParserException e) {
            parser.handleError(e);
            System.exit(1);
        }
        if (res == null) {
            throw new IllegalStateException();
        }

        return new UserOptions(
                res.getBoolean("logduplicate"),
                res.getBoolean("list"),
                res.getBoolean("ir"),
                res.getBoolean("timing"),
                res.getBoolean("graphics"),
                (String) res.getList("file").get(0)
        );
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static String loadSource(String filename) {
        var sb = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(filename), StandardCharsets.US_ASCII)) {
            stream.forEach(s -> sb.append(s).append(System.lineSeparator()));
        } catch (IOException e) {
            throw new PuffinBasicRuntimeError(
                    IO_ERROR,
                    "Failed to read source code: " + filename + ", error: " + e.getMessage()
            );
        }
        return sb.toString();
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    static void interpretAndRun(
            UserOptions userOptions,
            String sourceCode,
            PuffinBasicFile stdinout,
            Environment env) throws PuffinBasicRuntimeError
    {
        interpretAndRun(userOptions, UNKNOWN_SOURCE_FILE, sourceCode, stdinout, env);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void interpretAndRun(
            UserOptions userOptions,
            String sourceFilename,
            String sourceCode,
            PuffinBasicFile stdinout,
            Environment env) throws PuffinBasicRuntimeError
    {
        var importPath = new PuffinBasicImportPath(sourceFilename);

        Instant t1 = Instant.now();
        var sourceFile = syntaxCheckAndSortByLineNumber(
                importPath,
                sourceFilename,
                sourceCode,
                userOptions.logOnDuplicate ? LOG : THROW,
                SourceFileMode.MAIN);
        if (sourceFile.getSourceCode().isEmpty()) {
            throw new PuffinBasicSyntaxError(
                    "Failed to parse source code! Check if a linenumber is missing");
        }
        logTimeTaken("SORT", t1, userOptions.timing);

        log("LIST", userOptions.listSourceCode);
        log(sourceFile.getSourceCode(), userOptions.listSourceCode);

        Instant t2 = Instant.now();
        var ir = generateIR(sourceFile, userOptions.graphics);
        logTimeTaken("IR", t2, userOptions.timing);
        log("IR", userOptions.printIR);
        if (userOptions.printIR) {
            int i = 0;
            for (var instruction : ir.getInstructions()) {
                log(i++ + ": " + instruction, true);
            }
        }

        log("RUN", userOptions.timing);
        Instant t3 = Instant.now();
        PuffinBasicRuntime runtime = new PuffinBasicRuntime(ir, stdinout, env);
        runtime.run();
        logTimeTaken("RUN", t3, userOptions.timing);
    }

    private static void log(String s, boolean log) {
        if (log) {
            System.out.println(s);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void logTimeTaken(String tag, Instant t1, boolean log) {
        var duration  = Duration.between(t1, Instant.now());
        var timeSec = duration.getSeconds() + duration.getNano() / 1000_000_000.0;
        log("[" + tag + "] time taken = " + timeSec + " s", log);
    }

    private static void run(PuffinBasicIR ir, PuffinBasicFile out, Environment env) {
        var runtime = new PuffinBasicRuntime(ir, out, env);
        try {
            runtime.run();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static PuffinBasicIR generateIR(PuffinBasicSourceFile sourceFile, boolean graphics) {
        var symbolTable = new PuffinBasicSymbolTable();
        var ir = new PuffinBasicIR(symbolTable);
        for (var importFile : sourceFile.getImportFiles()) {
            generateIR(importFile, ir, graphics);
        }
        generateIR(sourceFile, ir, graphics);
        return ir;
    }

    private static void generateIR(PuffinBasicSourceFile sourceFile, PuffinBasicIR ir, boolean graphics) {
        var in = sourceFile.getSourceCodeStream();
        var lexer = new PuffinBasicLexer(in);
        var tokens = new CommonTokenStream(lexer);
        var parser = new PuffinBasicParser(tokens);
        var tree = parser.prog();
        var walker = new ParseTreeWalker();
        var irListener = new PuffinBasicIRListener(sourceFile, in, ir, graphics);
        walker.walk(irListener, tree);
        irListener.semanticCheckAfterParsing();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static PuffinBasicSourceFile syntaxCheckAndSortByLineNumber(
            PuffinBasicImportPath importPath,
            String sourceFile,
            String input,
            ThrowOnDuplicate throwOnDuplicate,
            SourceFileMode sourceFileMode)
    {
        var in = CharStreams.fromString(input);
        var syntaxErrorListener = new ThrowingErrorListener(input);
        var lexer = new PuffinBasicLexer(in);
        lexer.removeErrorListeners();
        lexer.addErrorListener(syntaxErrorListener);
        var tokens = new CommonTokenStream(lexer);
        var parser = new PuffinBasicParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(syntaxErrorListener);
        var tree = parser.prog();
        var walker = new ParseTreeWalker();
        var linenumListener = new LinenumberListener(in, throwOnDuplicate);
        walker.walk(linenumListener, tree);

        if (sourceFileMode == SourceFileMode.LIB) {
            if (linenumListener.hasLineNumbers()) {
                throw new PuffinBasicRuntimeError(
                        IMPORT_ERROR,
                        "Lib " + sourceFile + " should not have line numbers!"
                );
            }
            if (linenumListener.getLibtag() == null) {
                throw new PuffinBasicRuntimeError(
                        IMPORT_ERROR,
                        "Lib " + sourceFile + " should set a LIBTAG!"
                );
            }
        }

        LinkedHashSet<PuffinBasicSourceFile> importSourceFiles = new LinkedHashSet<>();
        for (String importFilename : linenumListener.getImportFiles()) {
            var importedInput = loadSource(importPath.find(importFilename));
            var importSourceFile = syntaxCheckAndSortByLineNumber(
                    importPath, importFilename, importedInput,
                    throwOnDuplicate, SourceFileMode.LIB);
            importSourceFiles.add(importSourceFile);
            importSourceFiles.addAll(importSourceFile.getImportFiles());
        }

        String sortedCode = linenumListener.getSortedCode();
        return new PuffinBasicSourceFile(
                sourceFile,
                linenumListener.getLibtag(),
                sortedCode,
                CharStreams.fromString(sortedCode),
                importSourceFiles);
    }

    private static final class ThrowingErrorListener extends BaseErrorListener {

        private final String input;

        ThrowingErrorListener(String input) {
            this.input = input;
        }

        @Override
        public void syntaxError(
                Recognizer<?, ?> recognizer,
                Object offendingSymbol,
                int line,
                int charPositionInLine,
                String msg,
                RecognitionException e)
        {
            var lineIndex = line - 1;
            var lines = input.split(System.lineSeparator());
            String inputLine;
            if (lineIndex >= 0 && lineIndex < lines.length) {
                inputLine = lines[lineIndex];
                if (charPositionInLine >= 0 && charPositionInLine <= inputLine.length()) {
                    inputLine = inputLine + System.lineSeparator()
                            + Strings.repeat(" ", Math.max(0, charPositionInLine)) + '^';
                }
            } else {
                inputLine = "<LINE OUT OF RANGE>";
            }
            throw new PuffinBasicSyntaxError(
                    "[" + line + ":" + charPositionInLine + "] " + msg + System.lineSeparator()
                    + inputLine
            );
        }

    }

    public static final class UserOptions {

        static UserOptions ofTest() {
            return new UserOptions(
                    false, false, false, false, false, null
            );
        }

        final boolean logOnDuplicate;
        final boolean listSourceCode;
        final boolean printIR;
        final boolean timing;
        final boolean graphics;
        public final String filename;

        public UserOptions(
                boolean logOnDuplicate,
                boolean listSourceCode,
                boolean printIR,
                boolean timing,
                boolean graphics,
                String filename)
        {
            this.logOnDuplicate = logOnDuplicate;
            this.listSourceCode = listSourceCode;
            this.printIR = printIR;
            this.timing = timing;
            this.graphics = graphics;
            this.filename = filename;
        }
    }

}

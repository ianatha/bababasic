package org.puffinbasic.parser;

import org.puffinbasic.error.PuffinBasicRuntimeError;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PuffinBasicImportPath {
    private static final String PUFFIN_BASIC_PATH_ENVVAR = "PUFFIN_BASIC_PATH";

    private final String mainModulePath;
    private final List<String> searchPaths;

    public PuffinBasicImportPath(String mainPath) {
        this.mainModulePath = mainPath != null
                ? new File(mainPath).getParent()
                : ".";
        this.searchPaths = getSearchPaths();
    }

    private List<String> getSearchPaths() {
        List<String> searchPaths = new ArrayList<>();
        var paths = System.getenv(PUFFIN_BASIC_PATH_ENVVAR);
        if (paths != null) {
            searchPaths.addAll(
                    Arrays.stream(paths.split(File.pathSeparator)).collect(Collectors.toList()));
        }
        searchPaths.add(mainModulePath);
        return searchPaths;
    }

    public String find(String relativePath) {
        for (String searchPath : searchPaths) {
            var file = Paths.get(searchPath, relativePath).toFile();
            if (file.exists()) {
                return file.getPath();
            }
        }
        throw new PuffinBasicRuntimeError(
                PuffinBasicRuntimeError.ErrorCode.IMPORT_ERROR,
                "Search failed for relative path: " + relativePath
        );
    }
}

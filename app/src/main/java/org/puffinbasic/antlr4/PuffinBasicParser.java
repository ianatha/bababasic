// Generated from org/puffinbasic/antlr4/PuffinBasic.g4 by ANTLR 4.13.1
package org.puffinbasic.antlr4;

import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PuffinBasicParser extends Parser {
    public static final int
            T__0 = 1, COMMENT = 2, LIST = 3, DICT = 4, SET = 5, EQGT = 6, LOCATE = 7, DEFAULT = 8,
            LETTERRANGE = 9, LET = 10, AUTO = 11, PRINT = 12, PRINTHASH = 13, USING = 14, IF = 15,
            THEN = 16, ELSE = 17, GOTO = 18, FOR = 19, NEXT = 20, TO = 21, STEP = 22, REM = 23, FUNCTION = 24,
            LIBTAG = 25, IMPORT = 26, END = 27, SIN = 28, COS = 29, TAN = 30, ATN = 31, SQR = 32,
            ABS = 33, ASC = 34, DEF = 35, DIM = 36, ALLOCARRAY = 37, REALLOCARRAY = 38, LTRIMDLR = 39,
            RTRIMDLR = 40, GOSUB = 41, RETURN = 42, LSET = 43, RSET = 44, CINT = 45, CLNG = 46,
            CSNG = 47, CDBL = 48, CHRDLR = 49, WHILE = 50, WEND = 51, MKIDLR = 52, MKLDLR = 53,
            MKSDLR = 54, MKDDLR = 55, CVI = 56, CVL = 57, CVS = 58, CVD = 59, SPACEDLR = 60, STRDLR = 61,
            VAL = 62, INT = 63, FIX = 64, LOG = 65, LEN = 66, RIGHTDLR = 67, LEFTDLR = 68, MIDDLR = 69,
            INSTR = 70, HEXDLR = 71, OCTDLR = 72, RND = 73, SGN = 74, TIMER = 75, TIMERMILLIS = 76,
            STRINGDLR = 77, SWAP = 78, OPEN = 79, CLOSE = 80, ACCESS = 81, AS = 82, LINE = 83, INPUT = 84,
            INPUTHASH = 85, INPUTDLR = 86, OUTPUT = 87, APPEND = 88, RANDOM = 89, RANDOMIZE = 90,
            READ = 91, WRITE = 92, WRITEHASH = 93, SHARED = 94, LOCK = 95, PUT = 96, GET = 97, EOFFN = 98,
            LOC = 99, LOF = 100, FIELD = 101, DATA = 102, RESTORE = 103, DEFINT = 104, DEFLNG = 105,
            DEFSNG = 106, DEFDBL = 107, DEFSTR = 108, ENVIRONDLR = 109, SCREEN = 110, CIRCLE = 111,
            SLEEP = 112, COLOR = 113, INKEYDLR = 114, PAINT = 115, PSET = 116, DRAW = 117, FONT = 118,
            DRAWSTR = 119, LOADIMG = 120, SAVEIMG = 121, LOADWAV = 122, PLAYWAV = 123, STOPWAV = 124,
            LOOPWAV = 125, CLS = 126, BEEP = 127, MANUAL_REPAINT = 128, DOUBLE_BUFFER = 129,
            REPAINT = 130, ASIN = 131, ACOS = 132, SINH = 133, COSH = 134, TANH = 135, EULERE = 136,
            PI = 137, MIN = 138, MAX = 139, FLOOR = 140, CEIL = 141, ROUND = 142, LOG10 = 143, LOG2 = 144,
            EXP = 145, TORAD = 146, TODEG = 147, TRUE = 148, FALSE = 149, ARRAYFILL = 150, ARRAY1DMIN = 151,
            ARRAY1DMAX = 152, ARRAY1DMEAN = 153, ARRAY1DSUM = 154, ARRAY1DSTD = 155, ARRAY1DMEDIAN = 156,
            ARRAY1DPCT = 157, ARRAY1DSORT = 158, ARRAY1DBINSEARCH = 159, ARRAY2DFINDROW = 160,
            ARRAY2DFINDCOLUMN = 161, ARRAYCOPY = 162, ARRAY1DCOPY = 163, ARRAY2DSHIFTHOR = 164,
            ARRAY2DSHIFTVER = 165, HSB2RGB = 166, LABEL = 167, BEGIN = 168, MOUSEMOVEDX = 169,
            MOUSEMOVEDY = 170, MOUSEDRAGGEDX = 171, MOUSEDRAGGEDY = 172, MOUSEBUTTONCLICKED = 173,
            MOUSEBUTTONPRESSED = 174, MOUSEBUTTONRELEASED = 175, ISKEYPRESSED = 176, FRONT = 177,
            BACK1 = 178, BUFFERCOPYHOR = 179, STRUCT = 180, SPLITDLR = 181, STRING = 182, COMMA = 183,
            SEMICOLON = 184, QUESTION = 185, AT = 186, DOLLAR = 187, PERCENT = 188, EXCLAMATION = 189,
            HASH = 190, APOSTROPHE = 191, EXPONENT = 192, FLOAT_DIV = 193, INT_DIV = 194, MUL = 195,
            LPAREN = 196, RPAREN = 197, LBRACE = 198, RBRACE = 199, MOD = 200, RELEQ = 201, RELNEQ = 202,
            RELGT = 203, RELGE = 204, RELLT = 205, RELLE = 206, LOGAND = 207, LOGOR = 208, LOGNOT = 209,
            LOGXOR = 210, LOGEQV = 211, LOGIMP = 212, BWRSFT = 213, BWLSFT = 214, VARNAME = 215,
            LETTER = 216, PLUS = 217, MINUS = 218, DECIMAL = 219, HEXADECIMAL = 220, OCTAL = 221,
            FLOAT = 222, DOUBLE = 223, DOT = 224, NEWLINE = 225, WS = 226, SPACE = 227, TAB = 228;
    public static final int
            RULE_prog = 0, RULE_line = 1, RULE_linenum = 2, RULE_comment = 3, RULE_stmt = 4,
            RULE_variable = 5, RULE_leafvariable = 6, RULE_structvariable = 7, RULE_varname = 8,
            RULE_varsuffix = 9, RULE_expr = 10, RULE_func = 11, RULE_funcname = 12,
            RULE_gosubstmt = 13, RULE_gosublabelstmt = 14, RULE_returnstmt = 15, RULE_printhashusingstmt = 16,
            RULE_printusingstmt = 17, RULE_printhashstmt = 18, RULE_printstmt = 19,
            RULE_printlist = 20, RULE_writestmt = 21, RULE_writehashstmt = 22, RULE_letstmt = 23,
            RULE_autoletstmt = 24, RULE_ifstmt = 25, RULE_then = 26, RULE_elsestmt = 27,
            RULE_ifthenbeginstmt = 28, RULE_elsebeginstmt = 29, RULE_endifstmt = 30,
            RULE_stmtlist = 31, RULE_forstmt = 32, RULE_nextstmt = 33, RULE_gotostmt = 34,
            RULE_gotolabelstmt = 35, RULE_endstmt = 36, RULE_deffnstmt = 37, RULE_functionbeginstmt = 38,
            RULE_functionreturnstmt = 39, RULE_functionendstmt = 40, RULE_importstmt = 41,
            RULE_libtagstmt = 42, RULE_dimstmt = 43, RULE_reallocstmt = 44, RULE_whilestmt = 45,
            RULE_wendstmt = 46, RULE_lsetstmt = 47, RULE_rsetstmt = 48, RULE_swapstmt = 49,
            RULE_open1stmt = 50, RULE_open2stmt = 51, RULE_closestmt = 52, RULE_filemode1 = 53,
            RULE_filemode2 = 54, RULE_access = 55, RULE_lock = 56, RULE_putstmt = 57,
            RULE_getstmt = 58, RULE_fieldstmt = 59, RULE_inputstmt = 60, RULE_inputhashstmt = 61,
            RULE_lineinputstmt = 62, RULE_lineinputhashstmt = 63, RULE_readstmt = 64,
            RULE_datastmt = 65, RULE_restorestmt = 66, RULE_randomizestmt = 67, RULE_randomizetimerstmt = 68,
            RULE_defintstmt = 69, RULE_deflngstmt = 70, RULE_defsngstmt = 71, RULE_defdblstmt = 72,
            RULE_defstrstmt = 73, RULE_middlrstmt = 74, RULE_sleepstmt = 75, RULE_screenstmt = 76,
            RULE_repaintstmt = 77, RULE_circlestmt = 78, RULE_linestmt = 79, RULE_colorstmt = 80,
            RULE_paintstmt = 81, RULE_psetstmt = 82, RULE_drawstmt = 83, RULE_graphicsgetstmt = 84,
            RULE_graphicsputstmt = 85, RULE_graphicsbuffercopyhorstmt = 86, RULE_fontstmt = 87,
            RULE_drawstrstmt = 88, RULE_loadimgstmt = 89, RULE_saveimgstmt = 90, RULE_locatestmt = 91,
            RULE_clsstmt = 92, RULE_beepstmt = 93, RULE_arrayfillstmt = 94, RULE_arraycopystmt = 95,
            RULE_array1dsortstmt = 96, RULE_array1dcopystmt = 97, RULE_array2dshifthorstmt = 98,
            RULE_array2dshiftverstmt = 99, RULE_loadwavstmt = 100, RULE_playwavstmt = 101,
            RULE_stopwavstmt = 102, RULE_loopwavstmt = 103, RULE_labelstmt = 104,
            RULE_liststmt = 105, RULE_dictstmt = 106, RULE_setstmt = 107, RULE_structstmt = 108,
            RULE_compositetype = 109, RULE_structinstancestmt = 110, RULE_string = 111,
            RULE_number = 112, RULE_integer = 113;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\u0004\u0001\u00e4\u06de\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001" +
                    "\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004" +
                    "\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007" +
                    "\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b" +
                    "\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007" +
                    "\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007" +
                    "\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007" +
                    "\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007" +
                    "\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007" +
                    "\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007" +
                    "\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007" +
                    "\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007" +
                    "\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007" +
                    ",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007" +
                    "1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007" +
                    "6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007" +
                    ";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007" +
                    "@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007" +
                    "E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007" +
                    "J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007" +
                    "O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007" +
                    "T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007" +
                    "Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007" +
                    "^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007" +
                    "c\u0002d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007" +
                    "h\u0002i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007" +
                    "m\u0002n\u0007n\u0002o\u0007o\u0002p\u0007p\u0002q\u0007q\u0001\u0000" +
                    "\u0001\u0000\u0005\u0000\u00e7\b\u0000\n\u0000\f\u0000\u00ea\t\u0000\u0001" +
                    "\u0001\u0003\u0001\u00ed\b\u0001\u0001\u0001\u0003\u0001\u00f0\b\u0001" +
                    "\u0001\u0001\u0003\u0001\u00f3\b\u0001\u0001\u0001\u0001\u0001\u0001\u0002" +
                    "\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004" +
                    "\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u0156\b\u0004" +
                    "\u0001\u0005\u0001\u0005\u0003\u0005\u015a\b\u0005\u0001\u0006\u0001\u0006" +
                    "\u0003\u0006\u015e\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006" +
                    "\u0005\u0006\u0164\b\u0006\n\u0006\f\u0006\u0167\t\u0006\u0001\u0006\u0001" +
                    "\u0006\u0003\u0006\u016b\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0005" +
                    "\u0007\u0170\b\u0007\n\u0007\f\u0007\u0173\t\u0007\u0001\u0007\u0001\u0007" +
                    "\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u017b\b\u0007" +
                    "\n\u0007\f\u0007\u017e\t\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0182" +
                    "\b\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0003\n\u018a" +
                    "\b\n\u0001\n\u0001\n\u0003\n\u018e\b\n\u0001\n\u0001\n\u0003\n\u0192\b" +
                    "\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003" +
                    "\n\u019c\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001" +
                    "\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001" +
                    "\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u01b3\b\n\n\n\f\n\u01b6\t\n" +
                    "\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b" +
                    "\u0001\u000b\u0005\u000b\u01bf\b\u000b\n\u000b\f\u000b\u01c2\t\u000b\u0003" +
                    "\u000b\u01c4\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0003\u000b\u02a4\b\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0003\u000b\u02c7\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003" +
                    "\u000b\u02d2\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0003\u000b\u02fe\b\u000b\u0001\u000b\u0003\u000b\u0301" +
                    "\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003" +
                    "\u000b\u0380\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0003\u000b\u038e\b\u000b\u0001\f\u0001\f\u0001\f\u0001" +
                    "\f\u0003\f\u0394\b\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001" +
                    "\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001" +
                    "\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001" +
                    "\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001" +
                    "\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0003" +
                    "\u0013\u03b3\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0005" +
                    "\u0014\u03b9\b\u0014\n\u0014\f\u0014\u03bc\t\u0014\u0001\u0015\u0001\u0015" +
                    "\u0001\u0015\u0001\u0015\u0005\u0015\u03c2\b\u0015\n\u0015\f\u0015\u03c5" +
                    "\t\u0015\u0003\u0015\u03c7\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016" +
                    "\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u03cf\b\u0016\n\u0016" +
                    "\f\u0016\u03d2\t\u0016\u0001\u0017\u0003\u0017\u03d5\b\u0017\u0001\u0017" +
                    "\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018" +
                    "\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019" +
                    "\u03e3\b\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u03e7\b\u0019\u0001" +
                    "\u0019\u0001\u0019\u0003\u0019\u03eb\b\u0019\u0001\u001a\u0001\u001a\u0001" +
                    "\u001a\u0003\u001a\u03f0\b\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u03f4" +
                    "\b\u001a\u0001\u001b\u0001\u001b\u0003\u001b\u03f8\b\u001b\u0001\u001c" +
                    "\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d" +
                    "\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f" +
                    "\u0001\u001f\u0005\u001f\u0408\b\u001f\n\u001f\f\u001f\u040b\t\u001f\u0001" +
                    " \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u0415\b \u0001" +
                    "!\u0001!\u0003!\u0419\b!\u0001!\u0001!\u0005!\u041d\b!\n!\f!\u0420\t!" +
                    "\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001$\u0001$\u0001%\u0001" +
                    "%\u0001%\u0003%\u042d\b%\u0001%\u0001%\u0001%\u0001%\u0005%\u0433\b%\n" +
                    "%\f%\u0436\t%\u0003%\u0438\b%\u0001%\u0003%\u043b\b%\u0001%\u0001%\u0001" +
                    "%\u0001&\u0001&\u0001&\u0003&\u0443\b&\u0001&\u0001&\u0001&\u0001&\u0005" +
                    "&\u0449\b&\n&\f&\u044c\t&\u0003&\u044e\b&\u0001&\u0001&\u0001&\u0001\'" +
                    "\u0001\'\u0001\'\u0001(\u0001(\u0001)\u0001)\u0001)\u0001*\u0001*\u0001" +
                    "*\u0001+\u0001+\u0001+\u0003+\u0461\b+\u0001+\u0001+\u0001+\u0001+\u0005" +
                    "+\u0467\b+\n+\f+\u046a\t+\u0001+\u0001+\u0001,\u0001,\u0001,\u0003,\u0471" +
                    "\b,\u0001,\u0001,\u0001,\u0001,\u0005,\u0477\b,\n,\f,\u047a\t,\u0001," +
                    "\u0001,\u0001-\u0001-\u0001-\u0001.\u0001.\u0001/\u0001/\u0001/\u0001" +
                    "/\u0001/\u00010\u00010\u00010\u00010\u00010\u00011\u00011\u00011\u0001" +
                    "1\u00011\u00012\u00012\u00012\u00012\u00032\u0496\b2\u00012\u00012\u0001" +
                    "2\u00012\u00012\u00032\u049d\b2\u00013\u00013\u00013\u00013\u00033\u04a3" +
                    "\b3\u00013\u00013\u00033\u04a7\b3\u00013\u00033\u04aa\b3\u00013\u0001" +
                    "3\u00033\u04ae\b3\u00013\u00013\u00013\u00013\u00033\u04b4\b3\u00014\u0001" +
                    "4\u00034\u04b8\b4\u00014\u00014\u00014\u00034\u04bd\b4\u00014\u00054\u04c0" +
                    "\b4\n4\f4\u04c3\t4\u00034\u04c5\b4\u00015\u00015\u00016\u00016\u00017" +
                    "\u00017\u00017\u00017\u00037\u04cf\b7\u00018\u00018\u00018\u00018\u0001" +
                    "8\u00018\u00018\u00018\u00038\u04d9\b8\u00019\u00019\u00039\u04dd\b9\u0001" +
                    "9\u00019\u00019\u00039\u04e2\b9\u0001:\u0001:\u0003:\u04e6\b:\u0001:\u0001" +
                    ":\u0001:\u0003:\u04eb\b:\u0001;\u0001;\u0003;\u04ef\b;\u0001;\u0001;\u0001" +
                    ";\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0005;\u04fa\b;\n;\f;\u04fd" +
                    "\t;\u0001<\u0001<\u0003<\u0501\b<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001" +
                    "<\u0005<\u0509\b<\n<\f<\u050c\t<\u0001=\u0001=\u0001=\u0001=\u0001=\u0001" +
                    "=\u0005=\u0514\b=\n=\f=\u0517\t=\u0001>\u0001>\u0001>\u0003>\u051c\b>" +
                    "\u0001>\u0001>\u0001>\u0003>\u0521\b>\u0001>\u0001>\u0001?\u0001?\u0001" +
                    "?\u0001?\u0001?\u0001?\u0001@\u0001@\u0001@\u0001@\u0005@\u052f\b@\n@" +
                    "\f@\u0532\t@\u0001A\u0001A\u0001A\u0003A\u0537\bA\u0001A\u0001A\u0001" +
                    "A\u0003A\u053c\bA\u0005A\u053e\bA\nA\fA\u0541\tA\u0001B\u0001B\u0001C" +
                    "\u0001C\u0001C\u0001D\u0001D\u0001D\u0001E\u0001E\u0001E\u0001E\u0005" +
                    "E\u054f\bE\nE\fE\u0552\tE\u0001F\u0001F\u0001F\u0001F\u0005F\u0558\bF" +
                    "\nF\fF\u055b\tF\u0001G\u0001G\u0001G\u0001G\u0005G\u0561\bG\nG\fG\u0564" +
                    "\tG\u0001H\u0001H\u0001H\u0001H\u0005H\u056a\bH\nH\fH\u056d\tH\u0001I" +
                    "\u0001I\u0001I\u0001I\u0005I\u0573\bI\nI\fI\u0576\tI\u0001J\u0001J\u0001" +
                    "J\u0001J\u0001J\u0001J\u0001J\u0003J\u057f\bJ\u0001J\u0001J\u0001J\u0001" +
                    "J\u0001K\u0001K\u0001K\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001" +
                    "L\u0001L\u0001L\u0001L\u0001L\u0003L\u0593\bL\u0001L\u0001L\u0003L\u0597" +
                    "\bL\u0001L\u0001L\u0003L\u059b\bL\u0001M\u0001M\u0001N\u0001N\u0001N\u0001" +
                    "N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0003N\u05ab" +
                    "\bN\u0001N\u0001N\u0003N\u05af\bN\u0001N\u0003N\u05b2\bN\u0001N\u0003" +
                    "N\u05b5\bN\u0003N\u05b7\bN\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001" +
                    "O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0003O\u05c7\bO\u0001" +
                    "P\u0001P\u0001P\u0001P\u0001P\u0001P\u0001P\u0001Q\u0001Q\u0001Q\u0001" +
                    "Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001" +
                    "R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001" +
                    "R\u0001R\u0001R\u0003R\u05ea\bR\u0001S\u0001S\u0001S\u0001T\u0001T\u0001" +
                    "T\u0001T\u0001T\u0001T\u0001T\u0001T\u0001T\u0001T\u0001T\u0001T\u0001" +
                    "T\u0001T\u0001T\u0001T\u0003T\u05ff\bT\u0001U\u0001U\u0001U\u0001U\u0001" +
                    "U\u0001U\u0001U\u0001U\u0001U\u0001U\u0003U\u060b\bU\u0001U\u0001U\u0003" +
                    "U\u060f\bU\u0001V\u0001V\u0001V\u0001V\u0001V\u0001V\u0001V\u0001W\u0001" +
                    "W\u0001W\u0001W\u0001W\u0001W\u0001W\u0001X\u0001X\u0001X\u0001X\u0001" +
                    "X\u0001X\u0001X\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Z\u0001Z\u0001" +
                    "Z\u0001Z\u0001Z\u0001[\u0001[\u0001[\u0001[\u0003[\u0634\b[\u0001\\\u0001" +
                    "\\\u0001]\u0001]\u0001^\u0001^\u0001^\u0001^\u0001^\u0001_\u0001_\u0001" +
                    "_\u0001_\u0001_\u0001`\u0001`\u0001`\u0001a\u0001a\u0001a\u0001a\u0001" +
                    "a\u0001a\u0001a\u0001a\u0001a\u0001a\u0001a\u0001b\u0001b\u0001b\u0001" +
                    "b\u0001b\u0001c\u0001c\u0001c\u0001c\u0001c\u0001d\u0001d\u0001d\u0001" +
                    "d\u0001d\u0001e\u0001e\u0001e\u0001f\u0001f\u0001f\u0001g\u0001g\u0001" +
                    "g\u0001h\u0001h\u0001h\u0001i\u0001i\u0001i\u0001i\u0001i\u0001i\u0003" +
                    "i\u0673\bi\u0001i\u0001i\u0001i\u0001j\u0001j\u0001j\u0001j\u0001j\u0001" +
                    "j\u0003j\u067e\bj\u0001j\u0001j\u0001j\u0001k\u0001k\u0001k\u0001k\u0001" +
                    "k\u0001k\u0001l\u0001l\u0001l\u0001l\u0001l\u0001l\u0005l\u068f\bl\nl" +
                    "\fl\u0692\tl\u0001l\u0001l\u0001m\u0001m\u0003m\u0698\bm\u0001m\u0001" +
                    "m\u0001m\u0003m\u069d\bm\u0001m\u0001m\u0001m\u0001m\u0005m\u06a3\bm\n" +
                    "m\fm\u06a6\tm\u0001m\u0001m\u0001m\u0001m\u0001m\u0001m\u0001m\u0001m" +
                    "\u0001m\u0001m\u0001m\u0003m\u06b3\bm\u0001m\u0001m\u0001m\u0001m\u0001" +
                    "m\u0001m\u0001m\u0003m\u06bc\bm\u0001m\u0001m\u0001m\u0001m\u0001m\u0001" +
                    "m\u0001m\u0001m\u0001m\u0003m\u06c7\bm\u0001m\u0001m\u0001m\u0003m\u06cc" +
                    "\bm\u0001n\u0001n\u0001n\u0001n\u0001n\u0001o\u0001o\u0001p\u0001p\u0001" +
                    "p\u0003p\u06d8\bp\u0001q\u0001q\u0003q\u06dc\bq\u0001q\u0000\u0001\u0014" +
                    "r\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a" +
                    "\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082" +
                    "\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a" +
                    "\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2" +
                    "\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca" +
                    "\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2" +
                    "\u0000\f\u0001\u0000\u00ba\u00be\u0001\u0000\u00d9\u00da\u0001\u0000\u00c1" +
                    "\u00c3\u0001\u0000\u00c9\u00ce\u0002\u0000\u00cf\u00d0\u00d2\u00d4\u0001" +
                    "\u0000\u00d5\u00d6\u0002\u0000\f\f\u00b9\u00b9\u0002\u0000TTWY\u0001\u0000" +
                    "\u00b7\u00b8\u0001\u0000\u00b1\u00b2\u0001\u0000\u00db\u00dd\u0002\u0000" +
                    "\u00ba\u00ba\u00bc\u00be\u07a2\u0000\u00e8\u0001\u0000\u0000\u0000\u0002" +
                    "\u00ec\u0001\u0000\u0000\u0000\u0004\u00f6\u0001\u0000\u0000\u0000\u0006" +
                    "\u00f8\u0001\u0000\u0000\u0000\b\u0155\u0001\u0000\u0000\u0000\n\u0159" +
                    "\u0001\u0000\u0000\u0000\f\u015b\u0001\u0000\u0000\u0000\u000e\u016c\u0001" +
                    "\u0000\u0000\u0000\u0010\u0183\u0001\u0000\u0000\u0000\u0012\u0185\u0001" +
                    "\u0000\u0000\u0000\u0014\u019b\u0001\u0000\u0000\u0000\u0016\u038d\u0001" +
                    "\u0000\u0000\u0000\u0018\u0393\u0001\u0000\u0000\u0000\u001a\u0395\u0001" +
                    "\u0000\u0000\u0000\u001c\u0398\u0001\u0000\u0000\u0000\u001e\u039b\u0001" +
                    "\u0000\u0000\u0000 \u039d\u0001\u0000\u0000\u0000\"\u03a5\u0001\u0000" +
                    "\u0000\u0000$\u03ab\u0001\u0000\u0000\u0000&\u03b0\u0001\u0000\u0000\u0000" +
                    "(\u03b4\u0001\u0000\u0000\u0000*\u03bd\u0001\u0000\u0000\u0000,\u03c8" +
                    "\u0001\u0000\u0000\u0000.\u03d4\u0001\u0000\u0000\u00000\u03da\u0001\u0000" +
                    "\u0000\u00002\u03df\u0001\u0000\u0000\u00004\u03f3\u0001\u0000\u0000\u0000" +
                    "6\u03f7\u0001\u0000\u0000\u00008\u03f9\u0001\u0000\u0000\u0000:\u03fe" +
                    "\u0001\u0000\u0000\u0000<\u0401\u0001\u0000\u0000\u0000>\u0404\u0001\u0000" +
                    "\u0000\u0000@\u040c\u0001\u0000\u0000\u0000B\u0416\u0001\u0000\u0000\u0000" +
                    "D\u0421\u0001\u0000\u0000\u0000F\u0424\u0001\u0000\u0000\u0000H\u0427" +
                    "\u0001\u0000\u0000\u0000J\u0429\u0001\u0000\u0000\u0000L\u043f\u0001\u0000" +
                    "\u0000\u0000N\u0452\u0001\u0000\u0000\u0000P\u0455\u0001\u0000\u0000\u0000" +
                    "R\u0457\u0001\u0000\u0000\u0000T\u045a\u0001\u0000\u0000\u0000V\u045d" +
                    "\u0001\u0000\u0000\u0000X\u046d\u0001\u0000\u0000\u0000Z\u047d\u0001\u0000" +
                    "\u0000\u0000\\\u0480\u0001\u0000\u0000\u0000^\u0482\u0001\u0000\u0000" +
                    "\u0000`\u0487\u0001\u0000\u0000\u0000b\u048c\u0001\u0000\u0000\u0000d" +
                    "\u0491\u0001\u0000\u0000\u0000f\u049e\u0001\u0000\u0000\u0000h\u04b5\u0001" +
                    "\u0000\u0000\u0000j\u04c6\u0001\u0000\u0000\u0000l\u04c8\u0001\u0000\u0000" +
                    "\u0000n\u04ce\u0001\u0000\u0000\u0000p\u04d8\u0001\u0000\u0000\u0000r" +
                    "\u04da\u0001\u0000\u0000\u0000t\u04e3\u0001\u0000\u0000\u0000v\u04ec\u0001" +
                    "\u0000\u0000\u0000x\u04fe\u0001\u0000\u0000\u0000z\u050d\u0001\u0000\u0000" +
                    "\u0000|\u0518\u0001\u0000\u0000\u0000~\u0524\u0001\u0000\u0000\u0000\u0080" +
                    "\u052a\u0001\u0000\u0000\u0000\u0082\u0533\u0001\u0000\u0000\u0000\u0084" +
                    "\u0542\u0001\u0000\u0000\u0000\u0086\u0544\u0001\u0000\u0000\u0000\u0088" +
                    "\u0547\u0001\u0000\u0000\u0000\u008a\u054a\u0001\u0000\u0000\u0000\u008c" +
                    "\u0553\u0001\u0000\u0000\u0000\u008e\u055c\u0001\u0000\u0000\u0000\u0090" +
                    "\u0565\u0001\u0000\u0000\u0000\u0092\u056e\u0001\u0000\u0000\u0000\u0094" +
                    "\u0577\u0001\u0000\u0000\u0000\u0096\u0584\u0001\u0000\u0000\u0000\u0098" +
                    "\u0587\u0001\u0000\u0000\u0000\u009a\u059c\u0001\u0000\u0000\u0000\u009c" +
                    "\u059e\u0001\u0000\u0000\u0000\u009e\u05b8\u0001\u0000\u0000\u0000\u00a0" +
                    "\u05c8\u0001\u0000\u0000\u0000\u00a2\u05cf\u0001\u0000\u0000\u0000\u00a4" +
                    "\u05dc\u0001\u0000\u0000\u0000\u00a6\u05eb\u0001\u0000\u0000\u0000\u00a8" +
                    "\u05ee\u0001\u0000\u0000\u0000\u00aa\u0600\u0001\u0000\u0000\u0000\u00ac" +
                    "\u0610\u0001\u0000\u0000\u0000\u00ae\u0617\u0001\u0000\u0000\u0000\u00b0" +
                    "\u061e\u0001\u0000\u0000\u0000\u00b2\u0625\u0001\u0000\u0000\u0000\u00b4" +
                    "\u062a\u0001\u0000\u0000\u0000\u00b6\u062f\u0001\u0000\u0000\u0000\u00b8" +
                    "\u0635\u0001\u0000\u0000\u0000\u00ba\u0637\u0001\u0000\u0000\u0000\u00bc" +
                    "\u0639\u0001\u0000\u0000\u0000\u00be\u063e\u0001\u0000\u0000\u0000\u00c0" +
                    "\u0643\u0001\u0000\u0000\u0000\u00c2\u0646\u0001\u0000\u0000\u0000\u00c4" +
                    "\u0651\u0001\u0000\u0000\u0000\u00c6\u0656\u0001\u0000\u0000\u0000\u00c8" +
                    "\u065b\u0001\u0000\u0000\u0000\u00ca\u0660\u0001\u0000\u0000\u0000\u00cc" +
                    "\u0663\u0001\u0000\u0000\u0000\u00ce\u0666\u0001\u0000\u0000\u0000\u00d0" +
                    "\u0669\u0001\u0000\u0000\u0000\u00d2\u066c\u0001\u0000\u0000\u0000\u00d4" +
                    "\u0677\u0001\u0000\u0000\u0000\u00d6\u0682\u0001\u0000\u0000\u0000\u00d8" +
                    "\u0688\u0001\u0000\u0000\u0000\u00da\u06cb\u0001\u0000\u0000\u0000\u00dc" +
                    "\u06cd\u0001\u0000\u0000\u0000\u00de\u06d2\u0001\u0000\u0000\u0000\u00e0" +
                    "\u06d7\u0001\u0000\u0000\u0000\u00e2\u06d9\u0001\u0000\u0000\u0000\u00e4" +
                    "\u00e7\u0003\u0002\u0001\u0000\u00e5\u00e7\u0005\u00e1\u0000\u0000\u00e6" +
                    "\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e5\u0001\u0000\u0000\u0000\u00e7" +
                    "\u00ea\u0001\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e8" +
                    "\u00e9\u0001\u0000\u0000\u0000\u00e9\u0001\u0001\u0000\u0000\u0000\u00ea" +
                    "\u00e8\u0001\u0000\u0000\u0000\u00eb\u00ed\u0003\u0004\u0002\u0000\u00ec" +
                    "\u00eb\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed" +
                    "\u00ef\u0001\u0000\u0000\u0000\u00ee\u00f0\u0003>\u001f\u0000\u00ef\u00ee" +
                    "\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u00f2" +
                    "\u0001\u0000\u0000\u0000\u00f1\u00f3\u0003\u0006\u0003\u0000\u00f2\u00f1" +
                    "\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u00f4" +
                    "\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005\u00e1\u0000\u0000\u00f5\u0003" +
                    "\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005\u00db\u0000\u0000\u00f7\u0005" +
                    "\u0001\u0000\u0000\u0000\u00f8\u00f9\u0005\u0002\u0000\u0000\u00f9\u0007" +
                    "\u0001\u0000\u0000\u0000\u00fa\u0156\u0003\"\u0011\u0000\u00fb\u0156\u0003" +
                    " \u0010\u0000\u00fc\u0156\u0003&\u0013\u0000\u00fd\u0156\u0003$\u0012" +
                    "\u0000\u00fe\u0156\u0003*\u0015\u0000\u00ff\u0156\u0003,\u0016\u0000\u0100" +
                    "\u0156\u0003.\u0017\u0000\u0101\u0156\u00030\u0018\u0000\u0102\u0156\u0003" +
                    "2\u0019\u0000\u0103\u0156\u00038\u001c\u0000\u0104\u0156\u0003:\u001d" +
                    "\u0000\u0105\u0156\u0003<\u001e\u0000\u0106\u0156\u0003@ \u0000\u0107" +
                    "\u0156\u0003B!\u0000\u0108\u0156\u0003D\"\u0000\u0109\u0156\u0003F#\u0000" +
                    "\u010a\u0156\u0003H$\u0000\u010b\u0156\u0003J%\u0000\u010c\u0156\u0003" +
                    "L&\u0000\u010d\u0156\u0003N\'\u0000\u010e\u0156\u0003P(\u0000\u010f\u0156" +
                    "\u0003R)\u0000\u0110\u0156\u0003T*\u0000\u0111\u0156\u0003V+\u0000\u0112" +
                    "\u0156\u0003X,\u0000\u0113\u0156\u0003\u001a\r\u0000\u0114\u0156\u0003" +
                    "\u001c\u000e\u0000\u0115\u0156\u0003\u001e\u000f\u0000\u0116\u0156\u0003" +
                    "Z-\u0000\u0117\u0156\u0003\\.\u0000\u0118\u0156\u0003^/\u0000\u0119\u0156" +
                    "\u0003`0\u0000\u011a\u0156\u0003b1\u0000\u011b\u0156\u0003d2\u0000\u011c" +
                    "\u0156\u0003f3\u0000\u011d\u0156\u0003h4\u0000\u011e\u0156\u0003r9\u0000" +
                    "\u011f\u0156\u0003t:\u0000\u0120\u0156\u0003v;\u0000\u0121\u0156\u0003" +
                    "x<\u0000\u0122\u0156\u0003z=\u0000\u0123\u0156\u0003|>\u0000\u0124\u0156" +
                    "\u0003~?\u0000\u0125\u0156\u0003\u0080@\u0000\u0126\u0156\u0003\u0082" +
                    "A\u0000\u0127\u0156\u0003\u0084B\u0000\u0128\u0156\u0003\u0086C\u0000" +
                    "\u0129\u0156\u0003\u0088D\u0000\u012a\u0156\u0003\u008aE\u0000\u012b\u0156" +
                    "\u0003\u008cF\u0000\u012c\u0156\u0003\u008eG\u0000\u012d\u0156\u0003\u0090" +
                    "H\u0000\u012e\u0156\u0003\u0092I\u0000\u012f\u0156\u0003\u0094J\u0000" +
                    "\u0130\u0156\u0003\u0096K\u0000\u0131\u0156\u0003\u0098L\u0000\u0132\u0156" +
                    "\u0003\u009cN\u0000\u0133\u0156\u0003\u009eO\u0000\u0134\u0156\u0003\u00a0" +
                    "P\u0000\u0135\u0156\u0003\u00a2Q\u0000\u0136\u0156\u0003\u00a4R\u0000" +
                    "\u0137\u0156\u0003\u00a6S\u0000\u0138\u0156\u0003\u00a8T\u0000\u0139\u0156" +
                    "\u0003\u00aaU\u0000\u013a\u0156\u0003\u00acV\u0000\u013b\u0156\u0003\u00ae" +
                    "W\u0000\u013c\u0156\u0003\u00b0X\u0000\u013d\u0156\u0003\u00b2Y\u0000" +
                    "\u013e\u0156\u0003\u00b4Z\u0000\u013f\u0156\u0003\u00b6[\u0000\u0140\u0156" +
                    "\u0003\u00b8\\\u0000\u0141\u0156\u0003\u00ba]\u0000\u0142\u0156\u0003" +
                    "\u009aM\u0000\u0143\u0156\u0003\u00bc^\u0000\u0144\u0156\u0003\u00be_" +
                    "\u0000\u0145\u0156\u0003\u00c2a\u0000\u0146\u0156\u0003\u00c0`\u0000\u0147" +
                    "\u0156\u0003\u00c4b\u0000\u0148\u0156\u0003\u00c6c\u0000\u0149\u0156\u0003" +
                    "\u00c8d\u0000\u014a\u0156\u0003\u00cae\u0000\u014b\u0156\u0003\u00ccf" +
                    "\u0000\u014c\u0156\u0003\u00ceg\u0000\u014d\u0156\u0003\u00d0h\u0000\u014e" +
                    "\u0156\u0003\u00d2i\u0000\u014f\u0156\u0003\u00d4j\u0000\u0150\u0156\u0003" +
                    "\u00d6k\u0000\u0151\u0156\u0003\u00d8l\u0000\u0152\u0156\u0003\u00dcn" +
                    "\u0000\u0153\u0156\u0003\u0016\u000b\u0000\u0154\u0156\u0003\n\u0005\u0000" +
                    "\u0155\u00fa\u0001\u0000\u0000\u0000\u0155\u00fb\u0001\u0000\u0000\u0000" +
                    "\u0155\u00fc\u0001\u0000\u0000\u0000\u0155\u00fd\u0001\u0000\u0000\u0000" +
                    "\u0155\u00fe\u0001\u0000\u0000\u0000\u0155\u00ff\u0001\u0000\u0000\u0000" +
                    "\u0155\u0100\u0001\u0000\u0000\u0000\u0155\u0101\u0001\u0000\u0000\u0000" +
                    "\u0155\u0102\u0001\u0000\u0000\u0000\u0155\u0103\u0001\u0000\u0000\u0000" +
                    "\u0155\u0104\u0001\u0000\u0000\u0000\u0155\u0105\u0001\u0000\u0000\u0000" +
                    "\u0155\u0106\u0001\u0000\u0000\u0000\u0155\u0107\u0001\u0000\u0000\u0000" +
                    "\u0155\u0108\u0001\u0000\u0000\u0000\u0155\u0109\u0001\u0000\u0000\u0000" +
                    "\u0155\u010a\u0001\u0000\u0000\u0000\u0155\u010b\u0001\u0000\u0000\u0000" +
                    "\u0155\u010c\u0001\u0000\u0000\u0000\u0155\u010d\u0001\u0000\u0000\u0000" +
                    "\u0155\u010e\u0001\u0000\u0000\u0000\u0155\u010f\u0001\u0000\u0000\u0000" +
                    "\u0155\u0110\u0001\u0000\u0000\u0000\u0155\u0111\u0001\u0000\u0000\u0000" +
                    "\u0155\u0112\u0001\u0000\u0000\u0000\u0155\u0113\u0001\u0000\u0000\u0000" +
                    "\u0155\u0114\u0001\u0000\u0000\u0000\u0155\u0115\u0001\u0000\u0000\u0000" +
                    "\u0155\u0116\u0001\u0000\u0000\u0000\u0155\u0117\u0001\u0000\u0000\u0000" +
                    "\u0155\u0118\u0001\u0000\u0000\u0000\u0155\u0119\u0001\u0000\u0000\u0000" +
                    "\u0155\u011a\u0001\u0000\u0000\u0000\u0155\u011b\u0001\u0000\u0000\u0000" +
                    "\u0155\u011c\u0001\u0000\u0000\u0000\u0155\u011d\u0001\u0000\u0000\u0000" +
                    "\u0155\u011e\u0001\u0000\u0000\u0000\u0155\u011f\u0001\u0000\u0000\u0000" +
                    "\u0155\u0120\u0001\u0000\u0000\u0000\u0155\u0121\u0001\u0000\u0000\u0000" +
                    "\u0155\u0122\u0001\u0000\u0000\u0000\u0155\u0123\u0001\u0000\u0000\u0000" +
                    "\u0155\u0124\u0001\u0000\u0000\u0000\u0155\u0125\u0001\u0000\u0000\u0000" +
                    "\u0155\u0126\u0001\u0000\u0000\u0000\u0155\u0127\u0001\u0000\u0000\u0000" +
                    "\u0155\u0128\u0001\u0000\u0000\u0000\u0155\u0129\u0001\u0000\u0000\u0000" +
                    "\u0155\u012a\u0001\u0000\u0000\u0000\u0155\u012b\u0001\u0000\u0000\u0000" +
                    "\u0155\u012c\u0001\u0000\u0000\u0000\u0155\u012d\u0001\u0000\u0000\u0000" +
                    "\u0155\u012e\u0001\u0000\u0000\u0000\u0155\u012f\u0001\u0000\u0000\u0000" +
                    "\u0155\u0130\u0001\u0000\u0000\u0000\u0155\u0131\u0001\u0000\u0000\u0000" +
                    "\u0155\u0132\u0001\u0000\u0000\u0000\u0155\u0133\u0001\u0000\u0000\u0000" +
                    "\u0155\u0134\u0001\u0000\u0000\u0000\u0155\u0135\u0001\u0000\u0000\u0000" +
                    "\u0155\u0136\u0001\u0000\u0000\u0000\u0155\u0137\u0001\u0000\u0000\u0000" +
                    "\u0155\u0138\u0001\u0000\u0000\u0000\u0155\u0139\u0001\u0000\u0000\u0000" +
                    "\u0155\u013a\u0001\u0000\u0000\u0000\u0155\u013b\u0001\u0000\u0000\u0000" +
                    "\u0155\u013c\u0001\u0000\u0000\u0000\u0155\u013d\u0001\u0000\u0000\u0000" +
                    "\u0155\u013e\u0001\u0000\u0000\u0000\u0155\u013f\u0001\u0000\u0000\u0000" +
                    "\u0155\u0140\u0001\u0000\u0000\u0000\u0155\u0141\u0001\u0000\u0000\u0000" +
                    "\u0155\u0142\u0001\u0000\u0000\u0000\u0155\u0143\u0001\u0000\u0000\u0000" +
                    "\u0155\u0144\u0001\u0000\u0000\u0000\u0155\u0145\u0001\u0000\u0000\u0000" +
                    "\u0155\u0146\u0001\u0000\u0000\u0000\u0155\u0147\u0001\u0000\u0000\u0000" +
                    "\u0155\u0148\u0001\u0000\u0000\u0000\u0155\u0149\u0001\u0000\u0000\u0000" +
                    "\u0155\u014a\u0001\u0000\u0000\u0000\u0155\u014b\u0001\u0000\u0000\u0000" +
                    "\u0155\u014c\u0001\u0000\u0000\u0000\u0155\u014d\u0001\u0000\u0000\u0000" +
                    "\u0155\u014e\u0001\u0000\u0000\u0000\u0155\u014f\u0001\u0000\u0000\u0000" +
                    "\u0155\u0150\u0001\u0000\u0000\u0000\u0155\u0151\u0001\u0000\u0000\u0000" +
                    "\u0155\u0152\u0001\u0000\u0000\u0000\u0155\u0153\u0001\u0000\u0000\u0000" +
                    "\u0155\u0154\u0001\u0000\u0000\u0000\u0156\t\u0001\u0000\u0000\u0000\u0157" +
                    "\u015a\u0003\f\u0006\u0000\u0158\u015a\u0003\u000e\u0007\u0000\u0159\u0157" +
                    "\u0001\u0000\u0000\u0000\u0159\u0158\u0001\u0000\u0000\u0000\u015a\u000b" +
                    "\u0001\u0000\u0000\u0000\u015b\u015d\u0003\u0010\b\u0000\u015c\u015e\u0003" +
                    "\u0012\t\u0000\u015d\u015c\u0001\u0000\u0000\u0000\u015d\u015e\u0001\u0000" +
                    "\u0000\u0000\u015e\u016a\u0001\u0000\u0000\u0000\u015f\u0160\u0005\u00c4" +
                    "\u0000\u0000\u0160\u0165\u0003\u0014\n\u0000\u0161\u0162\u0005\u00b7\u0000" +
                    "\u0000\u0162\u0164\u0003\u0014\n\u0000\u0163\u0161\u0001\u0000\u0000\u0000" +
                    "\u0164\u0167\u0001\u0000\u0000\u0000\u0165\u0163\u0001\u0000\u0000\u0000" +
                    "\u0165\u0166\u0001\u0000\u0000\u0000\u0166\u0168\u0001\u0000\u0000\u0000" +
                    "\u0167\u0165\u0001\u0000\u0000\u0000\u0168\u0169\u0005\u00c5\u0000\u0000" +
                    "\u0169\u016b\u0001\u0000\u0000\u0000\u016a\u015f\u0001\u0000\u0000\u0000" +
                    "\u016a\u016b\u0001\u0000\u0000\u0000\u016b\r\u0001\u0000\u0000\u0000\u016c" +
                    "\u0171\u0003\u0010\b\u0000\u016d\u016e\u0005\u00e0\u0000\u0000\u016e\u0170" +
                    "\u0003\u0010\b\u0000\u016f\u016d\u0001\u0000\u0000\u0000\u0170\u0173\u0001" +
                    "\u0000\u0000\u0000\u0171\u016f\u0001\u0000\u0000\u0000\u0171\u0172\u0001" +
                    "\u0000\u0000\u0000\u0172\u0174\u0001\u0000\u0000\u0000\u0173\u0171\u0001" +
                    "\u0000\u0000\u0000\u0174\u0175\u0005\u00e0\u0000\u0000\u0175\u0181\u0003" +
                    "\f\u0006\u0000\u0176\u0177\u0005\u00c4\u0000\u0000\u0177\u017c\u0003\u0014" +
                    "\n\u0000\u0178\u0179\u0005\u00b7\u0000\u0000\u0179\u017b\u0003\u0014\n" +
                    "\u0000\u017a\u0178\u0001\u0000\u0000\u0000\u017b\u017e\u0001\u0000\u0000" +
                    "\u0000\u017c\u017a\u0001\u0000\u0000\u0000\u017c\u017d\u0001\u0000\u0000" +
                    "\u0000\u017d\u017f\u0001\u0000\u0000\u0000\u017e\u017c\u0001\u0000\u0000" +
                    "\u0000\u017f\u0180\u0005\u00c5\u0000\u0000\u0180\u0182\u0001\u0000\u0000" +
                    "\u0000\u0181\u0176\u0001\u0000\u0000\u0000\u0181\u0182\u0001\u0000\u0000" +
                    "\u0000\u0182\u000f\u0001\u0000\u0000\u0000\u0183\u0184\u0005\u00d7\u0000" +
                    "\u0000\u0184\u0011\u0001\u0000\u0000\u0000\u0185\u0186\u0007\u0000\u0000" +
                    "\u0000\u0186\u0013\u0001\u0000\u0000\u0000\u0187\u0189\u0006\n\uffff\uffff" +
                    "\u0000\u0188\u018a\u0007\u0001\u0000\u0000\u0189\u0188\u0001\u0000\u0000" +
                    "\u0000\u0189\u018a\u0001\u0000\u0000\u0000\u018a\u018b\u0001\u0000\u0000" +
                    "\u0000\u018b\u019c\u0003\u0016\u000b\u0000\u018c\u018e\u0007\u0001\u0000" +
                    "\u0000\u018d\u018c\u0001\u0000\u0000\u0000\u018d\u018e\u0001\u0000\u0000" +
                    "\u0000\u018e\u018f\u0001\u0000\u0000\u0000\u018f\u019c\u0003\u00e0p\u0000" +
                    "\u0190\u0192\u0007\u0001\u0000\u0000\u0191\u0190\u0001\u0000\u0000\u0000" +
                    "\u0191\u0192\u0001\u0000\u0000\u0000\u0192\u0193\u0001\u0000\u0000\u0000" +
                    "\u0193\u019c\u0003\n\u0005\u0000\u0194\u0195\u0005\u00c4\u0000\u0000\u0195" +
                    "\u0196\u0003\u0014\n\u0000\u0196\u0197\u0005\u00c5\u0000\u0000\u0197\u019c" +
                    "\u0001\u0000\u0000\u0000\u0198\u019c\u0003\u00deo\u0000\u0199\u019a\u0005" +
                    "\u00d1\u0000\u0000\u019a\u019c\u0003\u0014\n\u0003\u019b\u0187\u0001\u0000" +
                    "\u0000\u0000\u019b\u018d\u0001\u0000\u0000\u0000\u019b\u0191\u0001\u0000" +
                    "\u0000\u0000\u019b\u0194\u0001\u0000\u0000\u0000\u019b\u0198\u0001\u0000" +
                    "\u0000\u0000\u019b\u0199\u0001\u0000\u0000\u0000\u019c\u01b4\u0001\u0000" +
                    "\u0000\u0000\u019d\u019e\n\b\u0000\u0000\u019e\u019f\u0005\u00c0\u0000" +
                    "\u0000\u019f\u01b3\u0003\u0014\n\t\u01a0\u01a1\n\u0007\u0000\u0000\u01a1" +
                    "\u01a2\u0007\u0002\u0000\u0000\u01a2\u01b3\u0003\u0014\n\b\u01a3\u01a4" +
                    "\n\u0006\u0000\u0000\u01a4\u01a5\u0005\u00c8\u0000\u0000\u01a5\u01b3\u0003" +
                    "\u0014\n\u0007\u01a6\u01a7\n\u0005\u0000\u0000\u01a7\u01a8\u0007\u0001" +
                    "\u0000\u0000\u01a8\u01b3\u0003\u0014\n\u0006\u01a9\u01aa\n\u0004\u0000" +
                    "\u0000\u01aa\u01ab\u0007\u0003\u0000\u0000\u01ab\u01b3\u0003\u0014\n\u0005" +
                    "\u01ac\u01ad\n\u0002\u0000\u0000\u01ad\u01ae\u0007\u0004\u0000\u0000\u01ae" +
                    "\u01b3\u0003\u0014\n\u0003\u01af\u01b0\n\u0001\u0000\u0000\u01b0\u01b1" +
                    "\u0007\u0005\u0000\u0000\u01b1\u01b3\u0003\u0014\n\u0002\u01b2\u019d\u0001" +
                    "\u0000\u0000\u0000\u01b2\u01a0\u0001\u0000\u0000\u0000\u01b2\u01a3\u0001" +
                    "\u0000\u0000\u0000\u01b2\u01a6\u0001\u0000\u0000\u0000\u01b2\u01a9\u0001" +
                    "\u0000\u0000\u0000\u01b2\u01ac\u0001\u0000\u0000\u0000\u01b2\u01af\u0001" +
                    "\u0000\u0000\u0000\u01b3\u01b6\u0001\u0000\u0000\u0000\u01b4\u01b2\u0001" +
                    "\u0000\u0000\u0000\u01b4\u01b5\u0001\u0000\u0000\u0000\u01b5\u0015\u0001" +
                    "\u0000\u0000\u0000\u01b6\u01b4\u0001\u0000\u0000\u0000\u01b7\u01b8\u0003" +
                    "\n\u0005\u0000\u01b8\u01b9\u0005\u00e0\u0000\u0000\u01b9\u01ba\u0003\u0018" +
                    "\f\u0000\u01ba\u01c3\u0005\u00c4\u0000\u0000\u01bb\u01c0\u0003\u0014\n" +
                    "\u0000\u01bc\u01bd\u0005\u00b7\u0000\u0000\u01bd\u01bf\u0003\u0014\n\u0000" +
                    "\u01be\u01bc\u0001\u0000\u0000\u0000\u01bf\u01c2\u0001\u0000\u0000\u0000" +
                    "\u01c0\u01be\u0001\u0000\u0000\u0000\u01c0\u01c1\u0001\u0000\u0000\u0000" +
                    "\u01c1\u01c4\u0001\u0000\u0000\u0000\u01c2\u01c0\u0001\u0000\u0000\u0000" +
                    "\u01c3\u01bb\u0001\u0000\u0000\u0000\u01c3\u01c4\u0001\u0000\u0000\u0000" +
                    "\u01c4\u01c5\u0001\u0000\u0000\u0000\u01c5\u01c6\u0005\u00c5\u0000\u0000" +
                    "\u01c6\u038e\u0001\u0000\u0000\u0000\u01c7\u01c8\u0005!\u0000\u0000\u01c8" +
                    "\u01c9\u0005\u00c4\u0000\u0000\u01c9\u01ca\u0003\u0014\n\u0000\u01ca\u01cb" +
                    "\u0005\u00c5\u0000\u0000\u01cb\u038e\u0001\u0000\u0000\u0000\u01cc\u01cd" +
                    "\u0005\"\u0000\u0000\u01cd\u01ce\u0005\u00c4\u0000\u0000\u01ce\u01cf\u0003" +
                    "\u0014\n\u0000\u01cf\u01d0\u0005\u00c5\u0000\u0000\u01d0\u038e\u0001\u0000" +
                    "\u0000\u0000\u01d1\u01d2\u0005\u001c\u0000\u0000\u01d2\u01d3\u0005\u00c4" +
                    "\u0000\u0000\u01d3\u01d4\u0003\u0014\n\u0000\u01d4\u01d5\u0005\u00c5\u0000" +
                    "\u0000\u01d5\u038e\u0001\u0000\u0000\u0000\u01d6\u01d7\u0005\u001d\u0000" +
                    "\u0000\u01d7\u01d8\u0005\u00c4\u0000\u0000\u01d8\u01d9\u0003\u0014\n\u0000" +
                    "\u01d9\u01da\u0005\u00c5\u0000\u0000\u01da\u038e\u0001\u0000\u0000\u0000" +
                    "\u01db\u01dc\u0005\u001e\u0000\u0000\u01dc\u01dd\u0005\u00c4\u0000\u0000" +
                    "\u01dd\u01de\u0003\u0014\n\u0000\u01de\u01df\u0005\u00c5\u0000\u0000\u01df" +
                    "\u038e\u0001\u0000\u0000\u0000\u01e0\u01e1\u0005\u0083\u0000\u0000\u01e1" +
                    "\u01e2\u0005\u00c4\u0000\u0000\u01e2\u01e3\u0003\u0014\n\u0000\u01e3\u01e4" +
                    "\u0005\u00c5\u0000\u0000\u01e4\u038e\u0001\u0000\u0000\u0000\u01e5\u01e6" +
                    "\u0005\u0084\u0000\u0000\u01e6\u01e7\u0005\u00c4\u0000\u0000\u01e7\u01e8" +
                    "\u0003\u0014\n\u0000\u01e8\u01e9\u0005\u00c5\u0000\u0000\u01e9\u038e\u0001" +
                    "\u0000\u0000\u0000\u01ea\u01eb\u0005\u001f\u0000\u0000\u01eb\u01ec\u0005" +
                    "\u00c4\u0000\u0000\u01ec\u01ed\u0003\u0014\n\u0000\u01ed\u01ee\u0005\u00c5" +
                    "\u0000\u0000\u01ee\u038e\u0001\u0000\u0000\u0000\u01ef\u01f0\u0005\u0085" +
                    "\u0000\u0000\u01f0\u01f1\u0005\u00c4\u0000\u0000\u01f1\u01f2\u0003\u0014" +
                    "\n\u0000\u01f2\u01f3\u0005\u00c5\u0000\u0000\u01f3\u038e\u0001\u0000\u0000" +
                    "\u0000\u01f4\u01f5\u0005\u0086\u0000\u0000\u01f5\u01f6\u0005\u00c4\u0000" +
                    "\u0000\u01f6\u01f7\u0003\u0014\n\u0000\u01f7\u01f8\u0005\u00c5\u0000\u0000" +
                    "\u01f8\u038e\u0001\u0000\u0000\u0000\u01f9\u01fa\u0005\u0087\u0000\u0000" +
                    "\u01fa\u01fb\u0005\u00c4\u0000\u0000\u01fb\u01fc\u0003\u0014\n\u0000\u01fc" +
                    "\u01fd\u0005\u00c5\u0000\u0000\u01fd\u038e\u0001\u0000\u0000\u0000\u01fe" +
                    "\u01ff\u0005 \u0000\u0000\u01ff\u0200\u0005\u00c4\u0000\u0000\u0200\u0201" +
                    "\u0003\u0014\n\u0000\u0201\u0202\u0005\u00c5\u0000\u0000\u0202\u038e\u0001" +
                    "\u0000\u0000\u0000\u0203\u0204\u0005-\u0000\u0000\u0204\u0205\u0005\u00c4" +
                    "\u0000\u0000\u0205\u0206\u0003\u0014\n\u0000\u0206\u0207\u0005\u00c5\u0000" +
                    "\u0000\u0207\u038e\u0001\u0000\u0000\u0000\u0208\u0209\u0005.\u0000\u0000" +
                    "\u0209\u020a\u0005\u00c4\u0000\u0000\u020a\u020b\u0003\u0014\n\u0000\u020b" +
                    "\u020c\u0005\u00c5\u0000\u0000\u020c\u038e\u0001\u0000\u0000\u0000\u020d" +
                    "\u020e\u0005/\u0000\u0000\u020e\u020f\u0005\u00c4\u0000\u0000\u020f\u0210" +
                    "\u0003\u0014\n\u0000\u0210\u0211\u0005\u00c5\u0000\u0000\u0211\u038e\u0001" +
                    "\u0000\u0000\u0000\u0212\u0213\u00050\u0000\u0000\u0213\u0214\u0005\u00c4" +
                    "\u0000\u0000\u0214\u0215\u0003\u0014\n\u0000\u0215\u0216\u0005\u00c5\u0000" +
                    "\u0000\u0216\u038e\u0001\u0000\u0000\u0000\u0217\u0218\u00051\u0000\u0000" +
                    "\u0218\u0219\u0005\u00c4\u0000\u0000\u0219\u021a\u0003\u0014\n\u0000\u021a" +
                    "\u021b\u0005\u00c5\u0000\u0000\u021b\u038e\u0001\u0000\u0000\u0000\u021c" +
                    "\u021d\u00054\u0000\u0000\u021d\u021e\u0005\u00c4\u0000\u0000\u021e\u021f" +
                    "\u0003\u0014\n\u0000\u021f\u0220\u0005\u00c5\u0000\u0000\u0220\u038e\u0001" +
                    "\u0000\u0000\u0000\u0221\u0222\u00055\u0000\u0000\u0222\u0223\u0005\u00c4" +
                    "\u0000\u0000\u0223\u0224\u0003\u0014\n\u0000\u0224\u0225\u0005\u00c5\u0000" +
                    "\u0000\u0225\u038e\u0001\u0000\u0000\u0000\u0226\u0227\u00056\u0000\u0000" +
                    "\u0227\u0228\u0005\u00c4\u0000\u0000\u0228\u0229\u0003\u0014\n\u0000\u0229" +
                    "\u022a\u0005\u00c5\u0000\u0000\u022a\u038e\u0001\u0000\u0000\u0000\u022b" +
                    "\u022c\u00057\u0000\u0000\u022c\u022d\u0005\u00c4\u0000\u0000\u022d\u022e" +
                    "\u0003\u0014\n\u0000\u022e\u022f\u0005\u00c5\u0000\u0000\u022f\u038e\u0001" +
                    "\u0000\u0000\u0000\u0230\u0231\u00058\u0000\u0000\u0231\u0232\u0005\u00c4" +
                    "\u0000\u0000\u0232\u0233\u0003\u0014\n\u0000\u0233\u0234\u0005\u00c5\u0000" +
                    "\u0000\u0234\u038e\u0001\u0000\u0000\u0000\u0235\u0236\u00059\u0000\u0000" +
                    "\u0236\u0237\u0005\u00c4\u0000\u0000\u0237\u0238\u0003\u0014\n\u0000\u0238" +
                    "\u0239\u0005\u00c5\u0000\u0000\u0239\u038e\u0001\u0000\u0000\u0000\u023a" +
                    "\u023b\u0005:\u0000\u0000\u023b\u023c\u0005\u00c4\u0000\u0000\u023c\u023d" +
                    "\u0003\u0014\n\u0000\u023d\u023e\u0005\u00c5\u0000\u0000\u023e\u038e\u0001" +
                    "\u0000\u0000\u0000\u023f\u0240\u0005;\u0000\u0000\u0240\u0241\u0005\u00c4" +
                    "\u0000\u0000\u0241\u0242\u0003\u0014\n\u0000\u0242\u0243\u0005\u00c5\u0000" +
                    "\u0000\u0243\u038e\u0001\u0000\u0000\u0000\u0244\u0245\u0005<\u0000\u0000" +
                    "\u0245\u0246\u0005\u00c4\u0000\u0000\u0246\u0247\u0003\u0014\n\u0000\u0247" +
                    "\u0248\u0005\u00c5\u0000\u0000\u0248\u038e\u0001\u0000\u0000\u0000\u0249" +
                    "\u024a\u0005=\u0000\u0000\u024a\u024b\u0005\u00c4\u0000\u0000\u024b\u024c" +
                    "\u0003\u0014\n\u0000\u024c\u024d\u0005\u00c5\u0000\u0000\u024d\u038e\u0001" +
                    "\u0000\u0000\u0000\u024e\u024f\u0005>\u0000\u0000\u024f\u0250\u0005\u00c4" +
                    "\u0000\u0000\u0250\u0251\u0003\u0014\n\u0000\u0251\u0252\u0005\u00c5\u0000" +
                    "\u0000\u0252\u038e\u0001\u0000\u0000\u0000\u0253\u0254\u0005?\u0000\u0000" +
                    "\u0254\u0255\u0005\u00c4\u0000\u0000\u0255\u0256\u0003\u0014\n\u0000\u0256" +
                    "\u0257\u0005\u00c5\u0000\u0000\u0257\u038e\u0001\u0000\u0000\u0000\u0258" +
                    "\u0259\u0005@\u0000\u0000\u0259\u025a\u0005\u00c4\u0000\u0000\u025a\u025b" +
                    "\u0003\u0014\n\u0000\u025b\u025c\u0005\u00c5\u0000\u0000\u025c\u038e\u0001" +
                    "\u0000\u0000\u0000\u025d\u025e\u0005A\u0000\u0000\u025e\u025f\u0005\u00c4" +
                    "\u0000\u0000\u025f\u0260\u0003\u0014\n\u0000\u0260\u0261\u0005\u00c5\u0000" +
                    "\u0000\u0261\u038e\u0001\u0000\u0000\u0000\u0262\u0263\u0005\u008f\u0000" +
                    "\u0000\u0263\u0264\u0005\u00c4\u0000\u0000\u0264\u0265\u0003\u0014\n\u0000" +
                    "\u0265\u0266\u0005\u00c5\u0000\u0000\u0266\u038e\u0001\u0000\u0000\u0000" +
                    "\u0267\u0268\u0005\u0090\u0000\u0000\u0268\u0269\u0005\u00c4\u0000\u0000" +
                    "\u0269\u026a\u0003\u0014\n\u0000\u026a\u026b\u0005\u00c5\u0000\u0000\u026b" +
                    "\u038e\u0001\u0000\u0000\u0000\u026c\u026d\u0005\u0091\u0000\u0000\u026d" +
                    "\u026e\u0005\u00c4\u0000\u0000\u026e\u026f\u0003\u0014\n\u0000\u026f\u0270" +
                    "\u0005\u00c5\u0000\u0000\u0270\u038e\u0001\u0000\u0000\u0000\u0271\u0272" +
                    "\u0005\u0092\u0000\u0000\u0272\u0273\u0005\u00c4\u0000\u0000\u0273\u0274" +
                    "\u0003\u0014\n\u0000\u0274\u0275\u0005\u00c5\u0000\u0000\u0275\u038e\u0001" +
                    "\u0000\u0000\u0000\u0276\u0277\u0005\u0093\u0000\u0000\u0277\u0278\u0005" +
                    "\u00c4\u0000\u0000\u0278\u0279\u0003\u0014\n\u0000\u0279\u027a\u0005\u00c5" +
                    "\u0000\u0000\u027a\u038e\u0001\u0000\u0000\u0000\u027b\u027c\u0005\u008d" +
                    "\u0000\u0000\u027c\u027d\u0005\u00c4\u0000\u0000\u027d\u027e\u0003\u0014" +
                    "\n\u0000\u027e\u027f\u0005\u00c5\u0000\u0000\u027f\u038e\u0001\u0000\u0000" +
                    "\u0000\u0280\u0281\u0005\u008c\u0000\u0000\u0281\u0282\u0005\u00c4\u0000" +
                    "\u0000\u0282\u0283\u0003\u0014\n\u0000\u0283\u0284\u0005\u00c5\u0000\u0000" +
                    "\u0284\u038e\u0001\u0000\u0000\u0000\u0285\u0286\u0005\u008e\u0000\u0000" +
                    "\u0286\u0287\u0005\u00c4\u0000\u0000\u0287\u0288\u0003\u0014\n\u0000\u0288" +
                    "\u0289\u0005\u00c5\u0000\u0000\u0289\u038e\u0001\u0000\u0000\u0000\u028a" +
                    "\u028b\u0005\u008a\u0000\u0000\u028b\u028c\u0005\u00c4\u0000\u0000\u028c" +
                    "\u028d\u0003\u0014\n\u0000\u028d\u028e\u0005\u00b7\u0000\u0000\u028e\u028f" +
                    "\u0003\u0014\n\u0000\u028f\u0290\u0005\u00c5\u0000\u0000\u0290\u038e\u0001" +
                    "\u0000\u0000\u0000\u0291\u0292\u0005\u008b\u0000\u0000\u0292\u0293\u0005" +
                    "\u00c4\u0000\u0000\u0293\u0294\u0003\u0014\n\u0000\u0294\u0295\u0005\u00b7" +
                    "\u0000\u0000\u0295\u0296\u0003\u0014\n\u0000\u0296\u0297\u0005\u00c5\u0000" +
                    "\u0000\u0297\u038e\u0001\u0000\u0000\u0000\u0298\u0299\u0005\u0089\u0000" +
                    "\u0000\u0299\u029a\u0005\u00c4\u0000\u0000\u029a\u038e\u0005\u00c5\u0000" +
                    "\u0000\u029b\u029c\u0005\u0088\u0000\u0000\u029c\u029d\u0005\u00c4\u0000" +
                    "\u0000\u029d\u038e\u0005\u00c5\u0000\u0000\u029e\u029f\u0005B\u0000\u0000" +
                    "\u029f\u02a0\u0005\u00c4\u0000\u0000\u02a0\u02a3\u0003\u0014\n\u0000\u02a1" +
                    "\u02a2\u0005\u00b7\u0000\u0000\u02a2\u02a4\u0003\u0014\n\u0000\u02a3\u02a1" +
                    "\u0001\u0000\u0000\u0000\u02a3\u02a4\u0001\u0000\u0000\u0000\u02a4\u02a5" +
                    "\u0001\u0000\u0000\u0000\u02a5\u02a6\u0005\u00c5\u0000\u0000\u02a6\u038e" +
                    "\u0001\u0000\u0000\u0000\u02a7\u02a8\u0005G\u0000\u0000\u02a8\u02a9\u0005" +
                    "\u00c4\u0000\u0000\u02a9\u02aa\u0003\u0014\n\u0000\u02aa\u02ab\u0005\u00c5" +
                    "\u0000\u0000\u02ab\u038e\u0001\u0000\u0000\u0000\u02ac\u02ad\u0005H\u0000" +
                    "\u0000\u02ad\u02ae\u0005\u00c4\u0000\u0000\u02ae\u02af\u0003\u0014\n\u0000" +
                    "\u02af\u02b0\u0005\u00c5\u0000\u0000\u02b0\u038e\u0001\u0000\u0000\u0000" +
                    "\u02b1\u02b2\u0005C\u0000\u0000\u02b2\u02b3\u0005\u00c4\u0000\u0000\u02b3" +
                    "\u02b4\u0003\u0014\n\u0000\u02b4\u02b5\u0005\u00b7\u0000\u0000\u02b5\u02b6" +
                    "\u0003\u0014\n\u0000\u02b6\u02b7\u0005\u00c5\u0000\u0000\u02b7\u038e\u0001" +
                    "\u0000\u0000\u0000\u02b8\u02b9\u0005D\u0000\u0000\u02b9\u02ba\u0005\u00c4" +
                    "\u0000\u0000\u02ba\u02bb\u0003\u0014\n\u0000\u02bb\u02bc\u0005\u00b7\u0000" +
                    "\u0000\u02bc\u02bd\u0003\u0014\n\u0000\u02bd\u02be\u0005\u00c5\u0000\u0000" +
                    "\u02be\u038e\u0001\u0000\u0000\u0000\u02bf\u02c0\u0005E\u0000\u0000\u02c0" +
                    "\u02c1\u0005\u00c4\u0000\u0000\u02c1\u02c2\u0003\u0014\n\u0000\u02c2\u02c3" +
                    "\u0005\u00b7\u0000\u0000\u02c3\u02c6\u0003\u0014\n\u0000\u02c4\u02c5\u0005" +
                    "\u00b7\u0000\u0000\u02c5\u02c7\u0003\u0014\n\u0000\u02c6\u02c4\u0001\u0000" +
                    "\u0000\u0000\u02c6\u02c7\u0001\u0000\u0000\u0000\u02c7\u02c8\u0001\u0000" +
                    "\u0000\u0000\u02c8\u02c9\u0005\u00c5\u0000\u0000\u02c9\u038e\u0001\u0000" +
                    "\u0000\u0000\u02ca\u02cb\u0005F\u0000\u0000\u02cb\u02cc\u0005\u00c4\u0000" +
                    "\u0000\u02cc\u02cd\u0003\u0014\n\u0000\u02cd\u02ce\u0005\u00b7\u0000\u0000" +
                    "\u02ce\u02d1\u0003\u0014\n\u0000\u02cf\u02d0\u0005\u00b7\u0000\u0000\u02d0" +
                    "\u02d2\u0003\u0014\n\u0000\u02d1\u02cf\u0001\u0000\u0000\u0000\u02d1\u02d2" +
                    "\u0001\u0000\u0000\u0000\u02d2\u02d3\u0001\u0000\u0000\u0000\u02d3\u02d4" +
                    "\u0005\u00c5\u0000\u0000\u02d4\u038e\u0001\u0000\u0000\u0000\u02d5\u038e" +
                    "\u0005I\u0000\u0000\u02d6\u02d7\u0005J\u0000\u0000\u02d7\u02d8\u0005\u00c4" +
                    "\u0000\u0000\u02d8\u02d9\u0003\u0014\n\u0000\u02d9\u02da\u0005\u00c5\u0000" +
                    "\u0000\u02da\u038e\u0001\u0000\u0000\u0000\u02db\u02dc\u0005m\u0000\u0000" +
                    "\u02dc\u02dd\u0005\u00c4\u0000\u0000\u02dd\u02de\u0003\u0014\n\u0000\u02de" +
                    "\u02df\u0005\u00c5\u0000\u0000\u02df\u038e\u0001\u0000\u0000\u0000\u02e0" +
                    "\u038e\u0005K\u0000\u0000\u02e1\u038e\u0005L\u0000\u0000\u02e2\u02e3\u0005" +
                    "M\u0000\u0000\u02e3\u02e4\u0005\u00c4\u0000\u0000\u02e4\u02e5\u0003\u0014" +
                    "\n\u0000\u02e5\u02e6\u0005\u00b7\u0000\u0000\u02e6\u02e7\u0003\u0014\n" +
                    "\u0000\u02e7\u02e8\u0005\u00c5\u0000\u0000\u02e8\u038e\u0001\u0000\u0000" +
                    "\u0000\u02e9\u02ea\u0005b\u0000\u0000\u02ea\u02eb\u0005\u00c4\u0000\u0000" +
                    "\u02eb\u02ec\u0003\u0014\n\u0000\u02ec\u02ed\u0005\u00c5\u0000\u0000\u02ed" +
                    "\u038e\u0001\u0000\u0000\u0000\u02ee\u02ef\u0005c\u0000\u0000\u02ef\u02f0" +
                    "\u0005\u00c4\u0000\u0000\u02f0\u02f1\u0003\u0014\n\u0000\u02f1\u02f2\u0005" +
                    "\u00c5\u0000\u0000\u02f2\u038e\u0001\u0000\u0000\u0000\u02f3\u02f4\u0005" +
                    "d\u0000\u0000\u02f4\u02f5\u0005\u00c4\u0000\u0000\u02f5\u02f6\u0003\u0014" +
                    "\n\u0000\u02f6\u02f7\u0005\u00c5\u0000\u0000\u02f7\u038e\u0001\u0000\u0000" +
                    "\u0000\u02f8\u02f9\u0005V\u0000\u0000\u02f9\u02fa\u0005\u00c4\u0000\u0000" +
                    "\u02fa\u0300\u0003\u0014\n\u0000\u02fb\u02fd\u0005\u00b7\u0000\u0000\u02fc" +
                    "\u02fe\u0005\u00be\u0000\u0000\u02fd\u02fc\u0001\u0000\u0000\u0000\u02fd" +
                    "\u02fe\u0001\u0000\u0000\u0000\u02fe\u02ff\u0001\u0000\u0000\u0000\u02ff" +
                    "\u0301\u0003\u0014\n\u0000\u0300\u02fb\u0001\u0000\u0000\u0000\u0300\u0301" +
                    "\u0001\u0000\u0000\u0000\u0301\u0302\u0001\u0000\u0000\u0000\u0302\u0303" +
                    "\u0005\u00c5\u0000\u0000\u0303\u038e\u0001\u0000\u0000\u0000\u0304\u038e" +
                    "\u0005r\u0000\u0000\u0305\u0306\u0005\u0097\u0000\u0000\u0306\u0307\u0005" +
                    "\u00c4\u0000\u0000\u0307\u0308\u0003\n\u0005\u0000\u0308\u0309\u0005\u00c5" +
                    "\u0000\u0000\u0309\u038e\u0001\u0000\u0000\u0000\u030a\u030b\u0005\u0098" +
                    "\u0000\u0000\u030b\u030c\u0005\u00c4\u0000\u0000\u030c\u030d\u0003\n\u0005" +
                    "\u0000\u030d\u030e\u0005\u00c5\u0000\u0000\u030e\u038e\u0001\u0000\u0000" +
                    "\u0000\u030f\u0310\u0005\u0099\u0000\u0000\u0310\u0311\u0005\u00c4\u0000" +
                    "\u0000\u0311\u0312\u0003\n\u0005\u0000\u0312\u0313\u0005\u00c5\u0000\u0000" +
                    "\u0313\u038e\u0001\u0000\u0000\u0000\u0314\u0315\u0005\u009a\u0000\u0000" +
                    "\u0315\u0316\u0005\u00c4\u0000\u0000\u0316\u0317\u0003\n\u0005\u0000\u0317" +
                    "\u0318\u0005\u00c5\u0000\u0000\u0318\u038e\u0001\u0000\u0000\u0000\u0319" +
                    "\u031a\u0005\u009b\u0000\u0000\u031a\u031b\u0005\u00c4\u0000\u0000\u031b" +
                    "\u031c\u0003\n\u0005\u0000\u031c\u031d\u0005\u00c5\u0000\u0000\u031d\u038e" +
                    "\u0001\u0000\u0000\u0000\u031e\u031f\u0005\u009c\u0000\u0000\u031f\u0320" +
                    "\u0005\u00c4\u0000\u0000\u0320\u0321\u0003\n\u0005\u0000\u0321\u0322\u0005" +
                    "\u00c5\u0000\u0000\u0322\u038e\u0001\u0000\u0000\u0000\u0323\u0324\u0005" +
                    "\u009d\u0000\u0000\u0324\u0325\u0005\u00c4\u0000\u0000\u0325\u0326\u0003" +
                    "\n\u0005\u0000\u0326\u0327\u0005\u00b7\u0000\u0000\u0327\u0328\u0003\u0014" +
                    "\n\u0000\u0328\u0329\u0005\u00c5\u0000\u0000\u0329\u038e\u0001\u0000\u0000" +
                    "\u0000\u032a\u032b\u0005\u009f\u0000\u0000\u032b\u032c\u0005\u00c4\u0000" +
                    "\u0000\u032c\u032d\u0003\n\u0005\u0000\u032d\u032e\u0005\u00b7\u0000\u0000" +
                    "\u032e\u032f\u0003\u0014\n\u0000\u032f\u0330\u0005\u00c5\u0000\u0000\u0330" +
                    "\u038e\u0001\u0000\u0000\u0000\u0331\u0332\u0005\u00a0\u0000\u0000\u0332" +
                    "\u0333\u0005\u00c4\u0000\u0000\u0333\u0334\u0003\n\u0005\u0000\u0334\u0335" +
                    "\u0005\u00b7\u0000\u0000\u0335\u0336\u0003\u0014\n\u0000\u0336\u0337\u0005" +
                    "\u00b7\u0000\u0000\u0337\u0338\u0003\u0014\n\u0000\u0338\u0339\u0005\u00b7" +
                    "\u0000\u0000\u0339\u033a\u0003\u0014\n\u0000\u033a\u033b\u0005\u00b7\u0000" +
                    "\u0000\u033b\u033c\u0003\u0014\n\u0000\u033c\u033d\u0005\u00b7\u0000\u0000" +
                    "\u033d\u033e\u0003\u0014\n\u0000\u033e\u033f\u0005\u00c5\u0000\u0000\u033f" +
                    "\u038e\u0001\u0000\u0000\u0000\u0340\u0341\u0005\u00a1\u0000\u0000\u0341" +
                    "\u0342\u0005\u00c4\u0000\u0000\u0342\u0343\u0003\n\u0005\u0000\u0343\u0344" +
                    "\u0005\u00b7\u0000\u0000\u0344\u0345\u0003\u0014\n\u0000\u0345\u0346\u0005" +
                    "\u00b7\u0000\u0000\u0346\u0347\u0003\u0014\n\u0000\u0347\u0348\u0005\u00b7" +
                    "\u0000\u0000\u0348\u0349\u0003\u0014\n\u0000\u0349\u034a\u0005\u00b7\u0000" +
                    "\u0000\u034a\u034b\u0003\u0014\n\u0000\u034b\u034c\u0005\u00b7\u0000\u0000" +
                    "\u034c\u034d\u0003\u0014\n\u0000\u034d\u034e\u0005\u00c5\u0000\u0000\u034e" +
                    "\u038e\u0001\u0000\u0000\u0000\u034f\u0350\u0005\u00a6\u0000\u0000\u0350" +
                    "\u0351\u0005\u00c4\u0000\u0000\u0351\u0352\u0003\u0014\n\u0000\u0352\u0353" +
                    "\u0005\u00b7\u0000\u0000\u0353\u0354\u0003\u0014\n\u0000\u0354\u0355\u0005" +
                    "\u00b7\u0000\u0000\u0355\u0356\u0003\u0014\n\u0000\u0356\u0357\u0005\u00c5" +
                    "\u0000\u0000\u0357\u038e\u0001\u0000\u0000\u0000\u0358\u0359\u0005\u00a9" +
                    "\u0000\u0000\u0359\u035a\u0005\u00c4\u0000\u0000\u035a\u038e\u0005\u00c5" +
                    "\u0000\u0000\u035b\u035c\u0005\u00aa\u0000\u0000\u035c\u035d\u0005\u00c4" +
                    "\u0000\u0000\u035d\u038e\u0005\u00c5\u0000\u0000\u035e\u035f\u0005\u00ab" +
                    "\u0000\u0000\u035f\u0360\u0005\u00c4\u0000\u0000\u0360\u038e\u0005\u00c5" +
                    "\u0000\u0000\u0361\u0362\u0005\u00ac\u0000\u0000\u0362\u0363\u0005\u00c4" +
                    "\u0000\u0000\u0363\u038e\u0005\u00c5\u0000\u0000\u0364\u0365\u0005\u00ad" +
                    "\u0000\u0000\u0365\u0366\u0005\u00c4\u0000\u0000\u0366\u038e\u0005\u00c5" +
                    "\u0000\u0000\u0367\u0368\u0005\u00ae\u0000\u0000\u0368\u0369\u0005\u00c4" +
                    "\u0000\u0000\u0369\u038e\u0005\u00c5\u0000\u0000\u036a\u036b\u0005\u00af" +
                    "\u0000\u0000\u036b\u036c\u0005\u00c4\u0000\u0000\u036c\u038e\u0005\u00c5" +
                    "\u0000\u0000\u036d\u036e\u0005\u00b0\u0000\u0000\u036e\u036f\u0005\u00c4" +
                    "\u0000\u0000\u036f\u0370\u0003\u0014\n\u0000\u0370\u0371\u0005\u00c5\u0000" +
                    "\u0000\u0371\u038e\u0001\u0000\u0000\u0000\u0372\u0373\u0005\u00b5\u0000" +
                    "\u0000\u0373\u0374\u0005\u00c4\u0000\u0000\u0374\u0375\u0003\u0014\n\u0000" +
                    "\u0375\u0376\u0005\u00b7\u0000\u0000\u0376\u0377\u0003\u0014\n\u0000\u0377" +
                    "\u0378\u0005\u00c5\u0000\u0000\u0378\u038e\u0001\u0000\u0000\u0000\u0379" +
                    "\u037a\u0005%\u0000\u0000\u037a\u037b\u0003\u0012\t\u0000\u037b\u037c" +
                    "\u0005\u00c4\u0000\u0000\u037c\u037f\u0003\u0014\n\u0000\u037d\u037e\u0005" +
                    "\u00b7\u0000\u0000\u037e\u0380\u0003\u0014\n\u0000\u037f\u037d\u0001\u0000" +
                    "\u0000\u0000\u037f\u0380\u0001\u0000\u0000\u0000\u0380\u0381\u0001\u0000" +
                    "\u0000\u0000\u0381\u0382\u0005\u00c5\u0000\u0000\u0382\u038e\u0001\u0000" +
                    "\u0000\u0000\u0383\u0384\u0005\'\u0000\u0000\u0384\u0385\u0005\u00c4\u0000" +
                    "\u0000\u0385\u0386\u0003\u0014\n\u0000\u0386\u0387\u0005\u00c5\u0000\u0000" +
                    "\u0387\u038e\u0001\u0000\u0000\u0000\u0388\u0389\u0005(\u0000\u0000\u0389" +
                    "\u038a\u0005\u00c4\u0000\u0000\u038a\u038b\u0003\u0014\n\u0000\u038b\u038c" +
                    "\u0005\u00c5\u0000\u0000\u038c\u038e\u0001\u0000\u0000\u0000\u038d\u01b7" +
                    "\u0001\u0000\u0000\u0000\u038d\u01c7\u0001\u0000\u0000\u0000\u038d\u01cc" +
                    "\u0001\u0000\u0000\u0000\u038d\u01d1\u0001\u0000\u0000\u0000\u038d\u01d6" +
                    "\u0001\u0000\u0000\u0000\u038d\u01db\u0001\u0000\u0000\u0000\u038d\u01e0" +
                    "\u0001\u0000\u0000\u0000\u038d\u01e5\u0001\u0000\u0000\u0000\u038d\u01ea" +
                    "\u0001\u0000\u0000\u0000\u038d\u01ef\u0001\u0000\u0000\u0000\u038d\u01f4" +
                    "\u0001\u0000\u0000\u0000\u038d\u01f9\u0001\u0000\u0000\u0000\u038d\u01fe" +
                    "\u0001\u0000\u0000\u0000\u038d\u0203\u0001\u0000\u0000\u0000\u038d\u0208" +
                    "\u0001\u0000\u0000\u0000\u038d\u020d\u0001\u0000\u0000\u0000\u038d\u0212" +
                    "\u0001\u0000\u0000\u0000\u038d\u0217\u0001\u0000\u0000\u0000\u038d\u021c" +
                    "\u0001\u0000\u0000\u0000\u038d\u0221\u0001\u0000\u0000\u0000\u038d\u0226" +
                    "\u0001\u0000\u0000\u0000\u038d\u022b\u0001\u0000\u0000\u0000\u038d\u0230" +
                    "\u0001\u0000\u0000\u0000\u038d\u0235\u0001\u0000\u0000\u0000\u038d\u023a" +
                    "\u0001\u0000\u0000\u0000\u038d\u023f\u0001\u0000\u0000\u0000\u038d\u0244" +
                    "\u0001\u0000\u0000\u0000\u038d\u0249\u0001\u0000\u0000\u0000\u038d\u024e" +
                    "\u0001\u0000\u0000\u0000\u038d\u0253\u0001\u0000\u0000\u0000\u038d\u0258" +
                    "\u0001\u0000\u0000\u0000\u038d\u025d\u0001\u0000\u0000\u0000\u038d\u0262" +
                    "\u0001\u0000\u0000\u0000\u038d\u0267\u0001\u0000\u0000\u0000\u038d\u026c" +
                    "\u0001\u0000\u0000\u0000\u038d\u0271\u0001\u0000\u0000\u0000\u038d\u0276" +
                    "\u0001\u0000\u0000\u0000\u038d\u027b\u0001\u0000\u0000\u0000\u038d\u0280" +
                    "\u0001\u0000\u0000\u0000\u038d\u0285\u0001\u0000\u0000\u0000\u038d\u028a" +
                    "\u0001\u0000\u0000\u0000\u038d\u0291\u0001\u0000\u0000\u0000\u038d\u0298" +
                    "\u0001\u0000\u0000\u0000\u038d\u029b\u0001\u0000\u0000\u0000\u038d\u029e" +
                    "\u0001\u0000\u0000\u0000\u038d\u02a7\u0001\u0000\u0000\u0000\u038d\u02ac" +
                    "\u0001\u0000\u0000\u0000\u038d\u02b1\u0001\u0000\u0000\u0000\u038d\u02b8" +
                    "\u0001\u0000\u0000\u0000\u038d\u02bf\u0001\u0000\u0000\u0000\u038d\u02ca" +
                    "\u0001\u0000\u0000\u0000\u038d\u02d5\u0001\u0000\u0000\u0000\u038d\u02d6" +
                    "\u0001\u0000\u0000\u0000\u038d\u02db\u0001\u0000\u0000\u0000\u038d\u02e0" +
                    "\u0001\u0000\u0000\u0000\u038d\u02e1\u0001\u0000\u0000\u0000\u038d\u02e2" +
                    "\u0001\u0000\u0000\u0000\u038d\u02e9\u0001\u0000\u0000\u0000\u038d\u02ee" +
                    "\u0001\u0000\u0000\u0000\u038d\u02f3\u0001\u0000\u0000\u0000\u038d\u02f8" +
                    "\u0001\u0000\u0000\u0000\u038d\u0304\u0001\u0000\u0000\u0000\u038d\u0305" +
                    "\u0001\u0000\u0000\u0000\u038d\u030a\u0001\u0000\u0000\u0000\u038d\u030f" +
                    "\u0001\u0000\u0000\u0000\u038d\u0314\u0001\u0000\u0000\u0000\u038d\u0319" +
                    "\u0001\u0000\u0000\u0000\u038d\u031e\u0001\u0000\u0000\u0000\u038d\u0323" +
                    "\u0001\u0000\u0000\u0000\u038d\u032a\u0001\u0000\u0000\u0000\u038d\u0331" +
                    "\u0001\u0000\u0000\u0000\u038d\u0340\u0001\u0000\u0000\u0000\u038d\u034f" +
                    "\u0001\u0000\u0000\u0000\u038d\u0358\u0001\u0000\u0000\u0000\u038d\u035b" +
                    "\u0001\u0000\u0000\u0000\u038d\u035e\u0001\u0000\u0000\u0000\u038d\u0361" +
                    "\u0001\u0000\u0000\u0000\u038d\u0364\u0001\u0000\u0000\u0000\u038d\u0367" +
                    "\u0001\u0000\u0000\u0000\u038d\u036a\u0001\u0000\u0000\u0000\u038d\u036d" +
                    "\u0001\u0000\u0000\u0000\u038d\u0372\u0001\u0000\u0000\u0000\u038d\u0379" +
                    "\u0001\u0000\u0000\u0000\u038d\u0383\u0001\u0000\u0000\u0000\u038d\u0388" +
                    "\u0001\u0000\u0000\u0000\u038e\u0017\u0001\u0000\u0000\u0000\u038f\u0394" +
                    "\u0003\u0010\b\u0000\u0390\u0394\u0005a\u0000\u0000\u0391\u0394\u0005" +
                    "X\u0000\u0000\u0392\u0394\u0005`\u0000\u0000\u0393\u038f\u0001\u0000\u0000" +
                    "\u0000\u0393\u0390\u0001\u0000\u0000\u0000\u0393\u0391\u0001\u0000\u0000" +
                    "\u0000\u0393\u0392\u0001\u0000\u0000\u0000\u0394\u0019\u0001\u0000\u0000" +
                    "\u0000\u0395\u0396\u0005)\u0000\u0000\u0396\u0397\u0003\u0004\u0002\u0000" +
                    "\u0397\u001b\u0001\u0000\u0000\u0000\u0398\u0399\u0005)\u0000\u0000\u0399" +
                    "\u039a\u0003\u00deo\u0000\u039a\u001d\u0001\u0000\u0000\u0000\u039b\u039c" +
                    "\u0005*\u0000\u0000\u039c\u001f\u0001\u0000\u0000\u0000\u039d\u039e\u0005" +
                    "\r\u0000\u0000\u039e\u039f\u0003\u0014\n\u0000\u039f\u03a0\u0005\u00b7" +
                    "\u0000\u0000\u03a0\u03a1\u0005\u000e\u0000\u0000\u03a1\u03a2\u0003\u0014" +
                    "\n\u0000\u03a2\u03a3\u0005\u00b8\u0000\u0000\u03a3\u03a4\u0003(\u0014" +
                    "\u0000\u03a4!\u0001\u0000\u0000\u0000\u03a5\u03a6\u0005\f\u0000\u0000" +
                    "\u03a6\u03a7\u0005\u000e\u0000\u0000\u03a7\u03a8\u0003\u0014\n\u0000\u03a8" +
                    "\u03a9\u0005\u00b8\u0000\u0000\u03a9\u03aa\u0003(\u0014\u0000\u03aa#\u0001" +
                    "\u0000\u0000\u0000\u03ab\u03ac\u0005\r\u0000\u0000\u03ac\u03ad\u0003\u0014" +
                    "\n\u0000\u03ad\u03ae\u0005\u00b7\u0000\u0000\u03ae\u03af\u0003(\u0014" +
                    "\u0000\u03af%\u0001\u0000\u0000\u0000\u03b0\u03b2\u0007\u0006\u0000\u0000" +
                    "\u03b1\u03b3\u0003(\u0014\u0000\u03b2\u03b1\u0001\u0000\u0000\u0000\u03b2" +
                    "\u03b3\u0001\u0000\u0000\u0000\u03b3\'\u0001\u0000\u0000\u0000\u03b4\u03ba" +
                    "\u0003\u0014\n\u0000\u03b5\u03b9\u0005\u00b7\u0000\u0000\u03b6\u03b9\u0005" +
                    "\u00b8\u0000\u0000\u03b7\u03b9\u0003\u0014\n\u0000\u03b8\u03b5\u0001\u0000" +
                    "\u0000\u0000\u03b8\u03b6\u0001\u0000\u0000\u0000\u03b8\u03b7\u0001\u0000" +
                    "\u0000\u0000\u03b9\u03bc\u0001\u0000\u0000\u0000\u03ba\u03b8\u0001\u0000" +
                    "\u0000\u0000\u03ba\u03bb\u0001\u0000\u0000\u0000\u03bb)\u0001\u0000\u0000" +
                    "\u0000\u03bc\u03ba\u0001\u0000\u0000\u0000\u03bd\u03c6\u0005\\\u0000\u0000" +
                    "\u03be\u03c3\u0003\u0014\n\u0000\u03bf\u03c0\u0005\u00b7\u0000\u0000\u03c0" +
                    "\u03c2\u0003\u0014\n\u0000\u03c1\u03bf\u0001\u0000\u0000\u0000\u03c2\u03c5" +
                    "\u0001\u0000\u0000\u0000\u03c3\u03c1\u0001\u0000\u0000\u0000\u03c3\u03c4" +
                    "\u0001\u0000\u0000\u0000\u03c4\u03c7\u0001\u0000\u0000\u0000\u03c5\u03c3" +
                    "\u0001\u0000\u0000\u0000\u03c6\u03be\u0001\u0000\u0000\u0000\u03c6\u03c7" +
                    "\u0001\u0000\u0000\u0000\u03c7+\u0001\u0000\u0000\u0000\u03c8\u03c9\u0005" +
                    "]\u0000\u0000\u03c9\u03ca\u0003\u0014\n\u0000\u03ca\u03cb\u0005\u00b7" +
                    "\u0000\u0000\u03cb\u03d0\u0003\u0014\n\u0000\u03cc\u03cd\u0005\u00b7\u0000" +
                    "\u0000\u03cd\u03cf\u0003\u0014\n\u0000\u03ce\u03cc\u0001\u0000\u0000\u0000" +
                    "\u03cf\u03d2\u0001\u0000\u0000\u0000\u03d0\u03ce\u0001\u0000\u0000\u0000" +
                    "\u03d0\u03d1\u0001\u0000\u0000\u0000\u03d1-\u0001\u0000\u0000\u0000\u03d2" +
                    "\u03d0\u0001\u0000\u0000\u0000\u03d3\u03d5\u0005\n\u0000\u0000\u03d4\u03d3" +
                    "\u0001\u0000\u0000\u0000\u03d4\u03d5\u0001\u0000\u0000\u0000\u03d5\u03d6" +
                    "\u0001\u0000\u0000\u0000\u03d6\u03d7\u0003\n\u0005\u0000\u03d7\u03d8\u0005" +
                    "\u00c9\u0000\u0000\u03d8\u03d9\u0003\u0014\n\u0000\u03d9/\u0001\u0000" +
                    "\u0000\u0000\u03da\u03db\u0005\u000b\u0000\u0000\u03db\u03dc\u0003\u0010" +
                    "\b\u0000\u03dc\u03dd\u0005\u00c9\u0000\u0000\u03dd\u03de\u0003\u0014\n" +
                    "\u0000\u03de1\u0001\u0000\u0000\u0000\u03df\u03e0\u0005\u000f\u0000\u0000" +
                    "\u03e0\u03e2\u0003\u0014\n\u0000\u03e1\u03e3\u0005\u00b7\u0000\u0000\u03e2" +
                    "\u03e1\u0001\u0000\u0000\u0000\u03e2\u03e3\u0001\u0000\u0000\u0000\u03e3" +
                    "\u03e4\u0001\u0000\u0000\u0000\u03e4\u03e6\u00034\u001a\u0000\u03e5\u03e7" +
                    "\u0005\u00b7\u0000\u0000\u03e6\u03e5\u0001\u0000\u0000\u0000\u03e6\u03e7" +
                    "\u0001\u0000\u0000\u0000\u03e7\u03ea\u0001\u0000\u0000\u0000\u03e8\u03e9" +
                    "\u0005\u0011\u0000\u0000\u03e9\u03eb\u00036\u001b\u0000\u03ea\u03e8\u0001" +
                    "\u0000\u0000\u0000\u03ea\u03eb\u0001\u0000\u0000\u0000\u03eb3\u0001\u0000" +
                    "\u0000\u0000\u03ec\u03ef\u0005\u0010\u0000\u0000\u03ed\u03f0\u0003\u0004" +
                    "\u0002\u0000\u03ee\u03f0\u0003>\u001f\u0000\u03ef\u03ed\u0001\u0000\u0000" +
                    "\u0000\u03ef\u03ee\u0001\u0000\u0000\u0000\u03f0\u03f4\u0001\u0000\u0000" +
                    "\u0000\u03f1\u03f2\u0005\u0012\u0000\u0000\u03f2\u03f4\u0003\u0004\u0002" +
                    "\u0000\u03f3\u03ec\u0001\u0000\u0000\u0000\u03f3\u03f1\u0001\u0000\u0000" +
                    "\u0000\u03f45\u0001\u0000\u0000\u0000\u03f5\u03f8\u0003\u0004\u0002\u0000" +
                    "\u03f6\u03f8\u0003>\u001f\u0000\u03f7\u03f5\u0001\u0000\u0000\u0000\u03f7" +
                    "\u03f6\u0001\u0000\u0000\u0000\u03f87\u0001\u0000\u0000\u0000\u03f9\u03fa" +
                    "\u0005\u000f\u0000\u0000\u03fa\u03fb\u0003\u0014\n\u0000\u03fb\u03fc\u0005" +
                    "\u0010\u0000\u0000\u03fc\u03fd\u0005\u00a8\u0000\u0000\u03fd9\u0001\u0000" +
                    "\u0000\u0000\u03fe\u03ff\u0005\u0011\u0000\u0000\u03ff\u0400\u0005\u00a8" +
                    "\u0000\u0000\u0400;\u0001\u0000\u0000\u0000\u0401\u0402\u0005\u001b\u0000" +
                    "\u0000\u0402\u0403\u0005\u000f\u0000\u0000\u0403=\u0001\u0000\u0000\u0000" +
                    "\u0404\u0409\u0003\b\u0004\u0000\u0405\u0406\u0005\u0001\u0000\u0000\u0406" +
                    "\u0408\u0003\b\u0004\u0000\u0407\u0405\u0001\u0000\u0000\u0000\u0408\u040b" +
                    "\u0001\u0000\u0000\u0000\u0409\u0407\u0001\u0000\u0000\u0000\u0409\u040a" +
                    "\u0001\u0000\u0000\u0000\u040a?\u0001\u0000\u0000\u0000\u040b\u0409\u0001" +
                    "\u0000\u0000\u0000\u040c\u040d\u0005\u0013\u0000\u0000\u040d\u040e\u0003" +
                    "\n\u0005\u0000\u040e\u040f\u0005\u00c9\u0000\u0000\u040f\u0410\u0003\u0014" +
                    "\n\u0000\u0410\u0411\u0005\u0015\u0000\u0000\u0411\u0414\u0003\u0014\n" +
                    "\u0000\u0412\u0413\u0005\u0016\u0000\u0000\u0413\u0415\u0003\u0014\n\u0000" +
                    "\u0414\u0412\u0001\u0000\u0000\u0000\u0414\u0415\u0001\u0000\u0000\u0000" +
                    "\u0415A\u0001\u0000\u0000\u0000\u0416\u0418\u0005\u0014\u0000\u0000\u0417" +
                    "\u0419\u0003\n\u0005\u0000\u0418\u0417\u0001\u0000\u0000\u0000\u0418\u0419" +
                    "\u0001\u0000\u0000\u0000\u0419\u041e\u0001\u0000\u0000\u0000\u041a\u041b" +
                    "\u0005\u00b7\u0000\u0000\u041b\u041d\u0003\n\u0005\u0000\u041c\u041a\u0001" +
                    "\u0000\u0000\u0000\u041d\u0420\u0001\u0000\u0000\u0000\u041e\u041c\u0001" +
                    "\u0000\u0000\u0000\u041e\u041f\u0001\u0000\u0000\u0000\u041fC\u0001\u0000" +
                    "\u0000\u0000\u0420\u041e\u0001\u0000\u0000\u0000\u0421\u0422\u0005\u0012" +
                    "\u0000\u0000\u0422\u0423\u0003\u0004\u0002\u0000\u0423E\u0001\u0000\u0000" +
                    "\u0000\u0424\u0425\u0005\u0012\u0000\u0000\u0425\u0426\u0003\u00deo\u0000" +
                    "\u0426G\u0001\u0000\u0000\u0000\u0427\u0428\u0005\u001b\u0000\u0000\u0428" +
                    "I\u0001\u0000\u0000\u0000\u0429\u042a\u0005#\u0000\u0000\u042a\u042c\u0003" +
                    "\u0010\b\u0000\u042b\u042d\u0003\u0012\t\u0000\u042c\u042b\u0001\u0000" +
                    "\u0000\u0000\u042c\u042d\u0001\u0000\u0000\u0000\u042d\u043a\u0001\u0000" +
                    "\u0000\u0000\u042e\u0437\u0005\u00c4\u0000\u0000\u042f\u0434\u0003\n\u0005" +
                    "\u0000\u0430\u0431\u0005\u00b7\u0000\u0000\u0431\u0433\u0003\n\u0005\u0000" +
                    "\u0432\u0430\u0001\u0000\u0000\u0000\u0433\u0436\u0001\u0000\u0000\u0000" +
                    "\u0434\u0432\u0001\u0000\u0000\u0000\u0434\u0435\u0001\u0000\u0000\u0000" +
                    "\u0435\u0438\u0001\u0000\u0000\u0000\u0436\u0434\u0001\u0000\u0000\u0000" +
                    "\u0437\u042f\u0001\u0000\u0000\u0000\u0437\u0438\u0001\u0000\u0000\u0000" +
                    "\u0438\u0439\u0001\u0000\u0000\u0000\u0439\u043b\u0005\u00c5\u0000\u0000" +
                    "\u043a\u042e\u0001\u0000\u0000\u0000\u043a\u043b\u0001\u0000\u0000\u0000" +
                    "\u043b\u043c\u0001\u0000\u0000\u0000\u043c\u043d\u0005\u00c9\u0000\u0000" +
                    "\u043d\u043e\u0003\u0014\n\u0000\u043eK\u0001\u0000\u0000\u0000\u043f" +
                    "\u0440\u0005\u0018\u0000\u0000\u0440\u0442\u0003\u0010\b\u0000\u0441\u0443" +
                    "\u0003\u0012\t\u0000\u0442\u0441\u0001\u0000\u0000\u0000\u0442\u0443\u0001" +
                    "\u0000\u0000\u0000\u0443\u0444\u0001\u0000\u0000\u0000\u0444\u044d\u0005" +
                    "\u00c4\u0000\u0000\u0445\u044a\u0003\u00dam\u0000\u0446\u0447\u0005\u00b7" +
                    "\u0000\u0000\u0447\u0449\u0003\u00dam\u0000\u0448\u0446\u0001\u0000\u0000" +
                    "\u0000\u0449\u044c\u0001\u0000\u0000\u0000\u044a\u0448\u0001\u0000\u0000" +
                    "\u0000\u044a\u044b\u0001\u0000\u0000\u0000\u044b\u044e\u0001\u0000\u0000" +
                    "\u0000\u044c\u044a\u0001\u0000\u0000\u0000\u044d\u0445\u0001\u0000\u0000" +
                    "\u0000\u044d\u044e\u0001\u0000\u0000\u0000\u044e\u044f\u0001\u0000\u0000" +
                    "\u0000\u044f\u0450\u0005\u00c5\u0000\u0000\u0450\u0451\u0005\u00c6\u0000" +
                    "\u0000\u0451M\u0001\u0000\u0000\u0000\u0452\u0453\u0005*\u0000\u0000\u0453" +
                    "\u0454\u0003\u0014\n\u0000\u0454O\u0001\u0000\u0000\u0000\u0455\u0456" +
                    "\u0005\u00c7\u0000\u0000\u0456Q\u0001\u0000\u0000\u0000\u0457\u0458\u0005" +
                    "\u001a\u0000\u0000\u0458\u0459\u0003\u00deo\u0000\u0459S\u0001\u0000\u0000" +
                    "\u0000\u045a\u045b\u0005\u0019\u0000\u0000\u045b\u045c\u0003\u00deo\u0000" +
                    "\u045cU\u0001\u0000\u0000\u0000\u045d\u045e\u0005$\u0000\u0000\u045e\u0460" +
                    "\u0003\u0010\b\u0000\u045f\u0461\u0003\u0012\t\u0000\u0460\u045f\u0001" +
                    "\u0000\u0000\u0000\u0460\u0461\u0001\u0000\u0000\u0000\u0461\u0462\u0001" +
                    "\u0000\u0000\u0000\u0462\u0463\u0005\u00c4\u0000\u0000\u0463\u0468\u0003" +
                    "\u0014\n\u0000\u0464\u0465\u0005\u00b7\u0000\u0000\u0465\u0467\u0003\u0014" +
                    "\n\u0000\u0466\u0464\u0001\u0000\u0000\u0000\u0467\u046a\u0001\u0000\u0000" +
                    "\u0000\u0468\u0466\u0001\u0000\u0000\u0000\u0468\u0469\u0001\u0000\u0000" +
                    "\u0000\u0469\u046b\u0001\u0000\u0000\u0000\u046a\u0468\u0001\u0000\u0000" +
                    "\u0000\u046b\u046c\u0005\u00c5\u0000\u0000\u046cW\u0001\u0000\u0000\u0000" +
                    "\u046d\u046e\u0005&\u0000\u0000\u046e\u0470\u0003\u0010\b\u0000\u046f" +
                    "\u0471\u0003\u0012\t\u0000\u0470\u046f\u0001\u0000\u0000\u0000\u0470\u0471" +
                    "\u0001\u0000\u0000\u0000\u0471\u0472\u0001\u0000\u0000\u0000\u0472\u0473" +
                    "\u0005\u00c4\u0000\u0000\u0473\u0478\u0003\u0014\n\u0000\u0474\u0475\u0005" +
                    "\u00b7\u0000\u0000\u0475\u0477\u0003\u0014\n\u0000\u0476\u0474\u0001\u0000" +
                    "\u0000\u0000\u0477\u047a\u0001\u0000\u0000\u0000\u0478\u0476\u0001\u0000" +
                    "\u0000\u0000\u0478\u0479\u0001\u0000\u0000\u0000\u0479\u047b\u0001\u0000" +
                    "\u0000\u0000\u047a\u0478\u0001\u0000\u0000\u0000\u047b\u047c\u0005\u00c5" +
                    "\u0000\u0000\u047cY\u0001\u0000\u0000\u0000\u047d\u047e\u00052\u0000\u0000" +
                    "\u047e\u047f\u0003\u0014\n\u0000\u047f[\u0001\u0000\u0000\u0000\u0480" +
                    "\u0481\u00053\u0000\u0000\u0481]\u0001\u0000\u0000\u0000\u0482\u0483\u0005" +
                    "+\u0000\u0000\u0483\u0484\u0003\n\u0005\u0000\u0484\u0485\u0005\u00c9" +
                    "\u0000\u0000\u0485\u0486\u0003\u0014\n\u0000\u0486_\u0001\u0000\u0000" +
                    "\u0000\u0487\u0488\u0005,\u0000\u0000\u0488\u0489\u0003\n\u0005\u0000" +
                    "\u0489\u048a\u0005\u00c9\u0000\u0000\u048a\u048b\u0003\u0014\n\u0000\u048b" +
                    "a\u0001\u0000\u0000\u0000\u048c\u048d\u0005N\u0000\u0000\u048d\u048e\u0003" +
                    "\n\u0005\u0000\u048e\u048f\u0005\u00b7\u0000\u0000\u048f\u0490\u0003\n" +
                    "\u0005\u0000\u0490c\u0001\u0000\u0000\u0000\u0491\u0492\u0005O\u0000\u0000" +
                    "\u0492\u0493\u0003j5\u0000\u0493\u0495\u0005\u00b7\u0000\u0000\u0494\u0496" +
                    "\u0005\u00be\u0000\u0000\u0495\u0494\u0001\u0000\u0000\u0000\u0495\u0496" +
                    "\u0001\u0000\u0000\u0000\u0496\u0497\u0001\u0000\u0000\u0000\u0497\u0498" +
                    "\u0005\u00db\u0000\u0000\u0498\u0499\u0005\u00b7\u0000\u0000\u0499\u049c" +
                    "\u0003\u0014\n\u0000\u049a\u049b\u0005\u00b7\u0000\u0000\u049b\u049d\u0003" +
                    "\u0014\n\u0000\u049c\u049a\u0001\u0000\u0000\u0000\u049c\u049d\u0001\u0000" +
                    "\u0000\u0000\u049de\u0001\u0000\u0000\u0000\u049e\u049f\u0005O\u0000\u0000" +
                    "\u049f\u04a2\u0003\u0014\n\u0000\u04a0\u04a1\u0005\u0013\u0000\u0000\u04a1" +
                    "\u04a3\u0003l6\u0000\u04a2\u04a0\u0001\u0000\u0000\u0000\u04a2\u04a3\u0001" +
                    "\u0000\u0000\u0000\u04a3\u04a6\u0001\u0000\u0000\u0000\u04a4\u04a5\u0005" +
                    "Q\u0000\u0000\u04a5\u04a7\u0003n7\u0000\u04a6\u04a4\u0001\u0000\u0000" +
                    "\u0000\u04a6\u04a7\u0001\u0000\u0000\u0000\u04a7\u04a9\u0001\u0000\u0000" +
                    "\u0000\u04a8\u04aa\u0003p8\u0000\u04a9\u04a8\u0001\u0000\u0000\u0000\u04a9" +
                    "\u04aa\u0001\u0000\u0000\u0000\u04aa\u04ab\u0001\u0000\u0000\u0000\u04ab" +
                    "\u04ad\u0005R\u0000\u0000\u04ac\u04ae\u0005\u00be\u0000\u0000\u04ad\u04ac" +
                    "\u0001\u0000\u0000\u0000\u04ad\u04ae\u0001\u0000\u0000\u0000\u04ae\u04af" +
                    "\u0001\u0000\u0000\u0000\u04af\u04b3\u0005\u00db\u0000\u0000\u04b0\u04b1" +
                    "\u0005B\u0000\u0000\u04b1\u04b2\u0005\u00c9\u0000\u0000\u04b2\u04b4\u0003" +
                    "\u0014\n\u0000\u04b3\u04b0\u0001\u0000\u0000\u0000\u04b3\u04b4\u0001\u0000" +
                    "\u0000\u0000\u04b4g\u0001\u0000\u0000\u0000\u04b5\u04c4\u0005P\u0000\u0000" +
                    "\u04b6\u04b8\u0005\u00be\u0000\u0000\u04b7\u04b6\u0001\u0000\u0000\u0000" +
                    "\u04b7\u04b8\u0001\u0000\u0000\u0000\u04b8\u04b9\u0001\u0000\u0000\u0000" +
                    "\u04b9\u04c1\u0005\u00db\u0000\u0000\u04ba\u04bc\u0005\u00b7\u0000\u0000" +
                    "\u04bb\u04bd\u0005\u00be\u0000\u0000\u04bc\u04bb\u0001\u0000\u0000\u0000" +
                    "\u04bc\u04bd\u0001\u0000\u0000\u0000\u04bd\u04be\u0001\u0000\u0000\u0000" +
                    "\u04be\u04c0\u0005\u00db\u0000\u0000\u04bf\u04ba\u0001\u0000\u0000\u0000" +
                    "\u04c0\u04c3\u0001\u0000\u0000\u0000\u04c1\u04bf\u0001\u0000\u0000\u0000" +
                    "\u04c1\u04c2\u0001\u0000\u0000\u0000\u04c2\u04c5\u0001\u0000\u0000\u0000" +
                    "\u04c3\u04c1\u0001\u0000\u0000\u0000\u04c4\u04b7\u0001\u0000\u0000\u0000" +
                    "\u04c4\u04c5\u0001\u0000\u0000\u0000\u04c5i\u0001\u0000\u0000\u0000\u04c6" +
                    "\u04c7\u0005\u00b6\u0000\u0000\u04c7k\u0001\u0000\u0000\u0000\u04c8\u04c9" +
                    "\u0007\u0007\u0000\u0000\u04c9m\u0001\u0000\u0000\u0000\u04ca\u04cf\u0005" +
                    "[\u0000\u0000\u04cb\u04cf\u0005\\\u0000\u0000\u04cc\u04cd\u0005[\u0000" +
                    "\u0000\u04cd\u04cf\u0005\\\u0000\u0000\u04ce\u04ca\u0001\u0000\u0000\u0000" +
                    "\u04ce\u04cb\u0001\u0000\u0000\u0000\u04ce\u04cc\u0001\u0000\u0000\u0000" +
                    "\u04cfo\u0001\u0000\u0000\u0000\u04d0\u04d9\u0005^\u0000\u0000\u04d1\u04d2" +
                    "\u0005_\u0000\u0000\u04d2\u04d9\u0005[\u0000\u0000\u04d3\u04d4\u0005_" +
                    "\u0000\u0000\u04d4\u04d9\u0005\\\u0000\u0000\u04d5\u04d6\u0005_\u0000" +
                    "\u0000\u04d6\u04d7\u0005[\u0000\u0000\u04d7\u04d9\u0005\\\u0000\u0000" +
                    "\u04d8\u04d0\u0001\u0000\u0000\u0000\u04d8\u04d1\u0001\u0000\u0000\u0000" +
                    "\u04d8\u04d3\u0001\u0000\u0000\u0000\u04d8\u04d5\u0001\u0000\u0000\u0000" +
                    "\u04d9q\u0001\u0000\u0000\u0000\u04da\u04dc\u0005`\u0000\u0000\u04db\u04dd" +
                    "\u0005\u00be\u0000\u0000\u04dc\u04db\u0001\u0000\u0000\u0000\u04dc\u04dd" +
                    "\u0001\u0000\u0000\u0000\u04dd\u04de\u0001\u0000\u0000\u0000\u04de\u04e1" +
                    "\u0005\u00db\u0000\u0000\u04df\u04e0\u0005\u00b7\u0000\u0000\u04e0\u04e2" +
                    "\u0003\u0014\n\u0000\u04e1\u04df\u0001\u0000\u0000\u0000\u04e1\u04e2\u0001" +
                    "\u0000\u0000\u0000\u04e2s\u0001\u0000\u0000\u0000\u04e3\u04e5\u0005a\u0000" +
                    "\u0000\u04e4\u04e6\u0005\u00be\u0000\u0000\u04e5\u04e4\u0001\u0000\u0000" +
                    "\u0000\u04e5\u04e6\u0001\u0000\u0000\u0000\u04e6\u04e7\u0001\u0000\u0000" +
                    "\u0000\u04e7\u04ea\u0005\u00db\u0000\u0000\u04e8\u04e9\u0005\u00b7\u0000" +
                    "\u0000\u04e9\u04eb\u0003\u0014\n\u0000\u04ea\u04e8\u0001\u0000\u0000\u0000" +
                    "\u04ea\u04eb\u0001\u0000\u0000\u0000\u04ebu\u0001\u0000\u0000\u0000\u04ec" +
                    "\u04ee\u0005e\u0000\u0000\u04ed\u04ef\u0005\u00be\u0000\u0000\u04ee\u04ed" +
                    "\u0001\u0000\u0000\u0000\u04ee\u04ef\u0001\u0000\u0000\u0000\u04ef\u04f0" +
                    "\u0001\u0000\u0000\u0000\u04f0\u04f1\u0003\u0014\n\u0000\u04f1\u04f2\u0005" +
                    "\u00b7\u0000\u0000\u04f2\u04f3\u0005\u00db\u0000\u0000\u04f3\u04f4\u0005" +
                    "R\u0000\u0000\u04f4\u04fb\u0003\n\u0005\u0000\u04f5\u04f6\u0005\u00b7" +
                    "\u0000\u0000\u04f6\u04f7\u0005\u00db\u0000\u0000\u04f7\u04f8\u0005R\u0000" +
                    "\u0000\u04f8\u04fa\u0003\n\u0005\u0000\u04f9\u04f5\u0001\u0000\u0000\u0000" +
                    "\u04fa\u04fd\u0001\u0000\u0000\u0000\u04fb\u04f9\u0001\u0000\u0000\u0000" +
                    "\u04fb\u04fc\u0001\u0000\u0000\u0000\u04fcw\u0001\u0000\u0000\u0000\u04fd" +
                    "\u04fb\u0001\u0000\u0000\u0000\u04fe\u0500\u0005T\u0000\u0000\u04ff\u0501" +
                    "\u0005\u00b8\u0000\u0000\u0500\u04ff\u0001\u0000\u0000\u0000\u0500\u0501" +
                    "\u0001\u0000\u0000\u0000\u0501\u0502\u0001\u0000\u0000\u0000\u0502\u0503" +
                    "\u0003\u0014\n\u0000\u0503\u0504\u0007\b\u0000\u0000\u0504\u0505\u0001" +
                    "\u0000\u0000\u0000\u0505\u050a\u0003\n\u0005\u0000\u0506\u0507\u0005\u00b7" +
                    "\u0000\u0000\u0507\u0509\u0003\n\u0005\u0000\u0508\u0506\u0001\u0000\u0000" +
                    "\u0000\u0509\u050c\u0001\u0000\u0000\u0000\u050a\u0508\u0001\u0000\u0000" +
                    "\u0000\u050a\u050b\u0001\u0000\u0000\u0000\u050by\u0001\u0000\u0000\u0000" +
                    "\u050c\u050a\u0001\u0000\u0000\u0000\u050d\u050e\u0005U\u0000\u0000\u050e" +
                    "\u050f\u0003\u0014\n\u0000\u050f\u0510\u0005\u00b7\u0000\u0000\u0510\u0515" +
                    "\u0003\n\u0005\u0000\u0511\u0512\u0005\u00b7\u0000\u0000\u0512\u0514\u0003" +
                    "\n\u0005\u0000\u0513\u0511\u0001\u0000\u0000\u0000\u0514\u0517\u0001\u0000" +
                    "\u0000\u0000\u0515\u0513\u0001\u0000\u0000\u0000\u0515\u0516\u0001\u0000" +
                    "\u0000\u0000\u0516{\u0001\u0000\u0000\u0000\u0517\u0515\u0001\u0000\u0000" +
                    "\u0000\u0518\u0519\u0005S\u0000\u0000\u0519\u051b\u0005T\u0000\u0000\u051a" +
                    "\u051c\u0005\u00b8\u0000\u0000\u051b\u051a\u0001\u0000\u0000\u0000\u051b" +
                    "\u051c\u0001\u0000\u0000\u0000\u051c\u0520\u0001\u0000\u0000\u0000\u051d" +
                    "\u051e\u0003\u0014\n\u0000\u051e\u051f\u0005\u00b8\u0000\u0000\u051f\u0521" +
                    "\u0001\u0000\u0000\u0000\u0520\u051d\u0001\u0000\u0000\u0000\u0520\u0521" +
                    "\u0001\u0000\u0000\u0000\u0521\u0522\u0001\u0000\u0000\u0000\u0522\u0523" +
                    "\u0003\n\u0005\u0000\u0523}\u0001\u0000\u0000\u0000\u0524\u0525\u0005" +
                    "S\u0000\u0000\u0525\u0526\u0005U\u0000\u0000\u0526\u0527\u0003\u0014\n" +
                    "\u0000\u0527\u0528\u0005\u00b7\u0000\u0000\u0528\u0529\u0003\n\u0005\u0000" +
                    "\u0529\u007f\u0001\u0000\u0000\u0000\u052a\u052b\u0005[\u0000\u0000\u052b" +
                    "\u0530\u0003\n\u0005\u0000\u052c\u052d\u0005\u00b7\u0000\u0000\u052d\u052f" +
                    "\u0003\n\u0005\u0000\u052e\u052c\u0001\u0000\u0000\u0000\u052f\u0532\u0001" +
                    "\u0000\u0000\u0000\u0530\u052e\u0001\u0000\u0000\u0000\u0530\u0531\u0001" +
                    "\u0000\u0000\u0000\u0531\u0081\u0001\u0000\u0000\u0000\u0532\u0530\u0001" +
                    "\u0000\u0000\u0000\u0533\u0536\u0005f\u0000\u0000\u0534\u0537\u0005\u00b6" +
                    "\u0000\u0000\u0535\u0537\u0003\u00e0p\u0000\u0536\u0534\u0001\u0000\u0000" +
                    "\u0000\u0536\u0535\u0001\u0000\u0000\u0000\u0537\u053f\u0001\u0000\u0000" +
                    "\u0000\u0538\u053b\u0005\u00b7\u0000\u0000\u0539\u053c\u0005\u00b6\u0000" +
                    "\u0000\u053a\u053c\u0003\u00e0p\u0000\u053b\u0539\u0001\u0000\u0000\u0000" +
                    "\u053b\u053a\u0001\u0000\u0000\u0000\u053c\u053e\u0001\u0000\u0000\u0000" +
                    "\u053d\u0538\u0001\u0000\u0000\u0000\u053e\u0541\u0001\u0000\u0000\u0000" +
                    "\u053f\u053d\u0001\u0000\u0000\u0000\u053f\u0540\u0001\u0000\u0000\u0000" +
                    "\u0540\u0083\u0001\u0000\u0000\u0000\u0541\u053f\u0001\u0000\u0000\u0000" +
                    "\u0542\u0543\u0005g\u0000\u0000\u0543\u0085\u0001\u0000\u0000\u0000\u0544" +
                    "\u0545\u0005Z\u0000\u0000\u0545\u0546\u0003\u0014\n\u0000\u0546\u0087" +
                    "\u0001\u0000\u0000\u0000\u0547\u0548\u0005Z\u0000\u0000\u0548\u0549\u0005" +
                    "K\u0000\u0000\u0549\u0089\u0001\u0000\u0000\u0000\u054a\u054b\u0005h\u0000" +
                    "\u0000\u054b\u0550\u0005\t\u0000\u0000\u054c\u054d\u0005\u00b7\u0000\u0000" +
                    "\u054d\u054f\u0005\t\u0000\u0000\u054e\u054c\u0001\u0000\u0000\u0000\u054f" +
                    "\u0552\u0001\u0000\u0000\u0000\u0550\u054e\u0001\u0000\u0000\u0000\u0550" +
                    "\u0551\u0001\u0000\u0000\u0000\u0551\u008b\u0001\u0000\u0000\u0000\u0552" +
                    "\u0550\u0001\u0000\u0000\u0000\u0553\u0554\u0005i\u0000\u0000\u0554\u0559" +
                    "\u0005\t\u0000\u0000\u0555\u0556\u0005\u00b7\u0000\u0000\u0556\u0558\u0005" +
                    "\t\u0000\u0000\u0557\u0555\u0001\u0000\u0000\u0000\u0558\u055b\u0001\u0000" +
                    "\u0000\u0000\u0559\u0557\u0001\u0000\u0000\u0000\u0559\u055a\u0001\u0000" +
                    "\u0000\u0000\u055a\u008d\u0001\u0000\u0000\u0000\u055b\u0559\u0001\u0000" +
                    "\u0000\u0000\u055c\u055d\u0005j\u0000\u0000\u055d\u0562\u0005\t\u0000" +
                    "\u0000\u055e\u055f\u0005\u00b7\u0000\u0000\u055f\u0561\u0005\t\u0000\u0000" +
                    "\u0560\u055e\u0001\u0000\u0000\u0000\u0561\u0564\u0001\u0000\u0000\u0000" +
                    "\u0562\u0560\u0001\u0000\u0000\u0000\u0562\u0563\u0001\u0000\u0000\u0000" +
                    "\u0563\u008f\u0001\u0000\u0000\u0000\u0564\u0562\u0001\u0000\u0000\u0000" +
                    "\u0565\u0566\u0005k\u0000\u0000\u0566\u056b\u0005\t\u0000\u0000\u0567" +
                    "\u0568\u0005\u00b7\u0000\u0000\u0568\u056a\u0005\t\u0000\u0000\u0569\u0567" +
                    "\u0001\u0000\u0000\u0000\u056a\u056d\u0001\u0000\u0000\u0000\u056b\u0569" +
                    "\u0001\u0000\u0000\u0000\u056b\u056c\u0001\u0000\u0000\u0000\u056c\u0091" +
                    "\u0001\u0000\u0000\u0000\u056d\u056b\u0001\u0000\u0000\u0000\u056e\u056f" +
                    "\u0005l\u0000\u0000\u056f\u0574\u0005\t\u0000\u0000\u0570\u0571\u0005" +
                    "\u00b7\u0000\u0000\u0571\u0573\u0005\t\u0000\u0000\u0572\u0570\u0001\u0000" +
                    "\u0000\u0000\u0573\u0576\u0001\u0000\u0000\u0000\u0574\u0572\u0001\u0000" +
                    "\u0000\u0000\u0574\u0575\u0001\u0000\u0000\u0000\u0575\u0093\u0001\u0000" +
                    "\u0000\u0000\u0576\u0574\u0001\u0000\u0000\u0000\u0577\u0578\u0005E\u0000" +
                    "\u0000\u0578\u0579\u0005\u00c4\u0000\u0000\u0579\u057a\u0003\n\u0005\u0000" +
                    "\u057a\u057b\u0005\u00b7\u0000\u0000\u057b\u057e\u0003\u0014\n\u0000\u057c" +
                    "\u057d\u0005\u00b7\u0000\u0000\u057d\u057f\u0003\u0014\n\u0000\u057e\u057c" +
                    "\u0001\u0000\u0000\u0000\u057e\u057f\u0001\u0000\u0000\u0000\u057f\u0580" +
                    "\u0001\u0000\u0000\u0000\u0580\u0581\u0005\u00c5\u0000\u0000\u0581\u0582" +
                    "\u0005\u00c9\u0000\u0000\u0582\u0583\u0003\u0014\n\u0000\u0583\u0095\u0001" +
                    "\u0000\u0000\u0000\u0584\u0585\u0005p\u0000\u0000\u0585\u0586\u0003\u0014" +
                    "\n\u0000\u0586\u0097\u0001\u0000\u0000\u0000\u0587\u0588\u0005n\u0000" +
                    "\u0000\u0588\u0589\u0003\u0014\n\u0000\u0589\u058a\u0005\u00b7\u0000\u0000" +
                    "\u058a\u058b\u0003\u0014\n\u0000\u058b\u058c\u0005\u00b7\u0000\u0000\u058c" +
                    "\u0592\u0003\u0014\n\u0000\u058d\u058e\u0005\u00b7\u0000\u0000\u058e\u058f" +
                    "\u0003\u0014\n\u0000\u058f\u0590\u0005\u00b7\u0000\u0000\u0590\u0591\u0003" +
                    "\u0014\n\u0000\u0591\u0593\u0001\u0000\u0000\u0000\u0592\u058d\u0001\u0000" +
                    "\u0000\u0000\u0592\u0593\u0001\u0000\u0000\u0000\u0593\u0596\u0001\u0000" +
                    "\u0000\u0000\u0594\u0595\u0005\u00b7\u0000\u0000\u0595\u0597\u0005\u0080" +
                    "\u0000\u0000\u0596\u0594\u0001\u0000\u0000\u0000\u0596\u0597\u0001\u0000" +
                    "\u0000\u0000\u0597\u059a\u0001\u0000\u0000\u0000\u0598\u0599\u0005\u00b7" +
                    "\u0000\u0000\u0599\u059b\u0005\u0081\u0000\u0000\u059a\u0598\u0001\u0000" +
                    "\u0000\u0000\u059a\u059b\u0001\u0000\u0000\u0000\u059b\u0099\u0001\u0000" +
                    "\u0000\u0000\u059c\u059d\u0005\u0082\u0000\u0000\u059d\u009b\u0001\u0000" +
                    "\u0000\u0000\u059e\u059f\u0005o\u0000\u0000\u059f\u05a0\u0005\u00c4\u0000" +
                    "\u0000\u05a0\u05a1\u0003\u0014\n\u0000\u05a1\u05a2\u0005\u00b7\u0000\u0000" +
                    "\u05a2\u05a3\u0003\u0014\n\u0000\u05a3\u05a4\u0005\u00c5\u0000\u0000\u05a4" +
                    "\u05a5\u0005\u00b7\u0000\u0000\u05a5\u05a6\u0003\u0014\n\u0000\u05a6\u05a7" +
                    "\u0005\u00b7\u0000\u0000\u05a7\u05b6\u0003\u0014\n\u0000\u05a8\u05aa\u0005" +
                    "\u00b7\u0000\u0000\u05a9\u05ab\u0003\u0014\n\u0000\u05aa\u05a9\u0001\u0000" +
                    "\u0000\u0000\u05aa\u05ab\u0001\u0000\u0000\u0000\u05ab\u05ac\u0001\u0000" +
                    "\u0000\u0000\u05ac\u05ae\u0005\u00b7\u0000\u0000\u05ad\u05af\u0003\u0014" +
                    "\n\u0000\u05ae\u05ad\u0001\u0000\u0000\u0000\u05ae\u05af\u0001\u0000\u0000" +
                    "\u0000\u05af\u05b1\u0001\u0000\u0000\u0000\u05b0\u05b2\u0005\u00b7\u0000" +
                    "\u0000\u05b1\u05b0\u0001\u0000\u0000\u0000\u05b1\u05b2\u0001\u0000\u0000" +
                    "\u0000\u05b2\u05b4\u0001\u0000\u0000\u0000\u05b3\u05b5\u0003\u0014\n\u0000" +
                    "\u05b4\u05b3\u0001\u0000\u0000\u0000\u05b4\u05b5\u0001\u0000\u0000\u0000" +
                    "\u05b5\u05b7\u0001\u0000\u0000\u0000\u05b6\u05a8\u0001\u0000\u0000\u0000" +
                    "\u05b6\u05b7\u0001\u0000\u0000\u0000\u05b7\u009d\u0001\u0000\u0000\u0000" +
                    "\u05b8\u05b9\u0005S\u0000\u0000\u05b9\u05ba\u0005\u00c4\u0000\u0000\u05ba" +
                    "\u05bb\u0003\u0014\n\u0000\u05bb\u05bc\u0005\u00b7\u0000\u0000\u05bc\u05bd" +
                    "\u0003\u0014\n\u0000\u05bd\u05be\u0005\u00c5\u0000\u0000\u05be\u05bf\u0005" +
                    "\u00da\u0000\u0000\u05bf\u05c0\u0005\u00c4\u0000\u0000\u05c0\u05c1\u0003" +
                    "\u0014\n\u0000\u05c1\u05c2\u0005\u00b7\u0000\u0000\u05c2\u05c3\u0003\u0014" +
                    "\n\u0000\u05c3\u05c6\u0005\u00c5\u0000\u0000\u05c4\u05c5\u0005\u00b7\u0000" +
                    "\u0000\u05c5\u05c7\u0003\u0014\n\u0000\u05c6\u05c4\u0001\u0000\u0000\u0000" +
                    "\u05c6\u05c7\u0001\u0000\u0000\u0000\u05c7\u009f\u0001\u0000\u0000\u0000" +
                    "\u05c8\u05c9\u0005q\u0000\u0000\u05c9\u05ca\u0003\u0014\n\u0000\u05ca" +
                    "\u05cb\u0005\u00b7\u0000\u0000\u05cb\u05cc\u0003\u0014\n\u0000\u05cc\u05cd" +
                    "\u0005\u00b7\u0000\u0000\u05cd\u05ce\u0003\u0014\n\u0000\u05ce\u00a1\u0001" +
                    "\u0000\u0000\u0000\u05cf\u05d0\u0005s\u0000\u0000\u05d0\u05d1\u0005\u00c4" +
                    "\u0000\u0000\u05d1\u05d2\u0003\u0014\n\u0000\u05d2\u05d3\u0005\u00b7\u0000" +
                    "\u0000\u05d3\u05d4\u0003\u0014\n\u0000\u05d4\u05d5\u0005\u00c5\u0000\u0000" +
                    "\u05d5\u05d6\u0005\u00b7\u0000\u0000\u05d6\u05d7\u0003\u0014\n\u0000\u05d7" +
                    "\u05d8\u0005\u00b7\u0000\u0000\u05d8\u05d9\u0003\u0014\n\u0000\u05d9\u05da" +
                    "\u0005\u00b7\u0000\u0000\u05da\u05db\u0003\u0014\n\u0000\u05db\u00a3\u0001" +
                    "\u0000\u0000\u0000\u05dc\u05dd\u0005t\u0000\u0000\u05dd\u05de\u0005\u00c4" +
                    "\u0000\u0000\u05de\u05df\u0003\u0014\n\u0000\u05df\u05e0\u0005\u00b7\u0000" +
                    "\u0000\u05e0\u05e1\u0003\u0014\n\u0000\u05e1\u05e9\u0005\u00c5\u0000\u0000" +
                    "\u05e2\u05e3\u0005\u00b7\u0000\u0000\u05e3\u05e4\u0003\u0014\n\u0000\u05e4" +
                    "\u05e5\u0005\u00b7\u0000\u0000\u05e5\u05e6\u0003\u0014\n\u0000\u05e6\u05e7" +
                    "\u0005\u00b7\u0000\u0000\u05e7\u05e8\u0003\u0014\n\u0000\u05e8\u05ea\u0001" +
                    "\u0000\u0000\u0000\u05e9\u05e2\u0001\u0000\u0000\u0000\u05e9\u05ea\u0001" +
                    "\u0000\u0000\u0000\u05ea\u00a5\u0001\u0000\u0000\u0000\u05eb\u05ec\u0005" +
                    "u\u0000\u0000\u05ec\u05ed\u0003\u0014\n\u0000\u05ed\u00a7\u0001\u0000" +
                    "\u0000\u0000\u05ee\u05ef\u0005a\u0000\u0000\u05ef\u05f0\u0005\u00c4\u0000" +
                    "\u0000\u05f0\u05f1\u0003\u0014\n\u0000\u05f1\u05f2\u0005\u00b7\u0000\u0000" +
                    "\u05f2\u05f3\u0003\u0014\n\u0000\u05f3\u05f4\u0005\u00c5\u0000\u0000\u05f4" +
                    "\u05f5\u0005\u00da\u0000\u0000\u05f5\u05f6\u0005\u00c4\u0000\u0000\u05f6" +
                    "\u05f7\u0003\u0014\n\u0000\u05f7\u05f8\u0005\u00b7\u0000\u0000\u05f8\u05f9" +
                    "\u0003\u0014\n\u0000\u05f9\u05fa\u0005\u00c5\u0000\u0000\u05fa\u05fb\u0005" +
                    "\u00b7\u0000\u0000\u05fb\u05fe\u0003\n\u0005\u0000\u05fc\u05fd\u0005\u00b7" +
                    "\u0000\u0000\u05fd\u05ff\u0007\t\u0000\u0000\u05fe\u05fc\u0001\u0000\u0000" +
                    "\u0000\u05fe\u05ff\u0001\u0000\u0000\u0000\u05ff\u00a9\u0001\u0000\u0000" +
                    "\u0000\u0600\u0601\u0005`\u0000\u0000\u0601\u0602\u0005\u00c4\u0000\u0000" +
                    "\u0602\u0603\u0003\u0014\n\u0000\u0603\u0604\u0005\u00b7\u0000\u0000\u0604" +
                    "\u0605\u0003\u0014\n\u0000\u0605\u0606\u0005\u00c5\u0000\u0000\u0606\u0607" +
                    "\u0005\u00b7\u0000\u0000\u0607\u060a\u0003\n\u0005\u0000\u0608\u0609\u0005" +
                    "\u00b7\u0000\u0000\u0609\u060b\u0003\u0014\n\u0000\u060a\u0608\u0001\u0000" +
                    "\u0000\u0000\u060a\u060b\u0001\u0000\u0000\u0000\u060b\u060e\u0001\u0000" +
                    "\u0000\u0000\u060c\u060d\u0005\u00b7\u0000\u0000\u060d\u060f\u0007\t\u0000" +
                    "\u0000\u060e\u060c\u0001\u0000\u0000\u0000\u060e\u060f\u0001\u0000\u0000" +
                    "\u0000\u060f\u00ab\u0001\u0000\u0000\u0000\u0610\u0611\u0005\u00b3\u0000" +
                    "\u0000\u0611\u0612\u0003\u0014\n\u0000\u0612\u0613\u0005\u0006\u0000\u0000" +
                    "\u0613\u0614\u0003\u0014\n\u0000\u0614\u0615\u0005\u00b7\u0000\u0000\u0615" +
                    "\u0616\u0003\u0014\n\u0000\u0616\u00ad\u0001\u0000\u0000\u0000\u0617\u0618" +
                    "\u0005v\u0000\u0000\u0618\u0619\u0003\u0014\n\u0000\u0619\u061a\u0005" +
                    "\u00b7\u0000\u0000\u061a\u061b\u0003\u0014\n\u0000\u061b\u061c\u0005\u00b7" +
                    "\u0000\u0000\u061c\u061d\u0003\u0014\n\u0000\u061d\u00af\u0001\u0000\u0000" +
                    "\u0000\u061e\u061f\u0005w\u0000\u0000\u061f\u0620\u0003\u0014\n\u0000" +
                    "\u0620\u0621\u0005\u00b7\u0000\u0000\u0621\u0622\u0003\u0014\n\u0000\u0622" +
                    "\u0623\u0005\u00b7\u0000\u0000\u0623\u0624\u0003\u0014\n\u0000\u0624\u00b1" +
                    "\u0001\u0000\u0000\u0000\u0625\u0626\u0005x\u0000\u0000\u0626\u0627\u0003" +
                    "\u0014\n\u0000\u0627\u0628\u0005\u00b7\u0000\u0000\u0628\u0629\u0003\n" +
                    "\u0005\u0000\u0629\u00b3\u0001\u0000\u0000\u0000\u062a\u062b\u0005y\u0000" +
                    "\u0000\u062b\u062c\u0003\u0014\n\u0000\u062c\u062d\u0005\u00b7\u0000\u0000" +
                    "\u062d\u062e\u0003\n\u0005\u0000\u062e\u00b5\u0001\u0000\u0000\u0000\u062f" +
                    "\u0630\u0005\u0007\u0000\u0000\u0630\u0633\u0003\u0014\n\u0000\u0631\u0632" +
                    "\u0005\u00b7\u0000\u0000\u0632\u0634\u0003\u0014\n\u0000\u0633\u0631\u0001" +
                    "\u0000\u0000\u0000\u0633\u0634\u0001\u0000\u0000\u0000\u0634\u00b7\u0001" +
                    "\u0000\u0000\u0000\u0635\u0636\u0005~\u0000\u0000\u0636\u00b9\u0001\u0000" +
                    "\u0000\u0000\u0637\u0638\u0005\u007f\u0000\u0000\u0638\u00bb\u0001\u0000" +
                    "\u0000\u0000\u0639\u063a\u0005\u0096\u0000\u0000\u063a\u063b\u0003\n\u0005" +
                    "\u0000\u063b\u063c\u0005\u00b7\u0000\u0000\u063c\u063d\u0003\u0014\n\u0000" +
                    "\u063d\u00bd\u0001\u0000\u0000\u0000\u063e\u063f\u0005\u00a2\u0000\u0000" +
                    "\u063f\u0640\u0003\n\u0005\u0000\u0640\u0641\u0005\u00b7\u0000\u0000\u0641" +
                    "\u0642\u0003\n\u0005\u0000\u0642\u00bf\u0001\u0000\u0000\u0000\u0643\u0644" +
                    "\u0005\u009e\u0000\u0000\u0644\u0645\u0003\n\u0005\u0000\u0645\u00c1\u0001" +
                    "\u0000\u0000\u0000\u0646\u0647\u0005\u00a3\u0000\u0000\u0647\u0648\u0003" +
                    "\n\u0005\u0000\u0648\u0649\u0005\u00b7\u0000\u0000\u0649\u064a\u0003\u0014" +
                    "\n\u0000\u064a\u064b\u0005\u00b7\u0000\u0000\u064b\u064c\u0003\n\u0005" +
                    "\u0000\u064c\u064d\u0005\u00b7\u0000\u0000\u064d\u064e\u0003\u0014\n\u0000" +
                    "\u064e\u064f\u0005\u00b7\u0000\u0000\u064f\u0650\u0003\u0014\n\u0000\u0650" +
                    "\u00c3\u0001\u0000\u0000\u0000\u0651\u0652\u0005\u00a4\u0000\u0000\u0652" +
                    "\u0653\u0003\n\u0005\u0000\u0653\u0654\u0005\u00b7\u0000\u0000\u0654\u0655" +
                    "\u0003\u0014\n\u0000\u0655\u00c5\u0001\u0000\u0000\u0000\u0656\u0657\u0005" +
                    "\u00a5\u0000\u0000\u0657\u0658\u0003\n\u0005\u0000\u0658\u0659\u0005\u00b7" +
                    "\u0000\u0000\u0659\u065a\u0003\u0014\n\u0000\u065a\u00c7\u0001\u0000\u0000" +
                    "\u0000\u065b\u065c\u0005z\u0000\u0000\u065c\u065d\u0003\u0014\n\u0000" +
                    "\u065d\u065e\u0005\u00b7\u0000\u0000\u065e\u065f\u0003\n\u0005\u0000\u065f" +
                    "\u00c9\u0001\u0000\u0000\u0000\u0660\u0661\u0005{\u0000\u0000\u0661\u0662" +
                    "\u0003\n\u0005\u0000\u0662\u00cb\u0001\u0000\u0000\u0000\u0663\u0664\u0005" +
                    "|\u0000\u0000\u0664\u0665\u0003\n\u0005\u0000\u0665\u00cd\u0001\u0000" +
                    "\u0000\u0000\u0666\u0667\u0005}\u0000\u0000\u0667\u0668\u0003\n\u0005" +
                    "\u0000\u0668\u00cf\u0001\u0000\u0000\u0000\u0669\u066a\u0005\u00a7\u0000" +
                    "\u0000\u066a\u066b\u0003\u00deo\u0000\u066b\u00d1\u0001\u0000\u0000\u0000" +
                    "\u066c\u066d\u0005\u0003\u0000\u0000\u066d\u0672\u0005\u00cd\u0000\u0000" +
                    "\u066e\u0673\u0003\u0010\b\u0000\u066f\u0673\u0003\u0012\t\u0000\u0670" +
                    "\u0671\u0005$\u0000\u0000\u0671\u0673\u0003\u0012\t\u0000\u0672\u066e" +
                    "\u0001\u0000\u0000\u0000\u0672\u066f\u0001\u0000\u0000\u0000\u0672\u0670" +
                    "\u0001\u0000\u0000\u0000\u0673\u0674\u0001\u0000\u0000\u0000\u0674\u0675" +
                    "\u0005\u00cb\u0000\u0000\u0675\u0676\u0003\u0010\b\u0000\u0676\u00d3\u0001" +
                    "\u0000\u0000\u0000\u0677\u0678\u0005\u0004\u0000\u0000\u0678\u0679\u0005" +
                    "\u00cd\u0000\u0000\u0679\u067a\u0003\u0012\t\u0000\u067a\u067d\u0005\u00b7" +
                    "\u0000\u0000\u067b\u067e\u0003\u0010\b\u0000\u067c\u067e\u0003\u0012\t" +
                    "\u0000\u067d\u067b\u0001\u0000\u0000\u0000\u067d\u067c\u0001\u0000\u0000" +
                    "\u0000\u067e\u067f\u0001\u0000\u0000\u0000\u067f\u0680\u0005\u00cb\u0000" +
                    "\u0000\u0680\u0681\u0003\u0010\b\u0000\u0681\u00d5\u0001\u0000\u0000\u0000" +
                    "\u0682\u0683\u0005\u0005\u0000\u0000\u0683\u0684\u0005\u00cd\u0000\u0000" +
                    "\u0684\u0685\u0003\u0012\t\u0000\u0685\u0686\u0005\u00cb\u0000\u0000\u0686" +
                    "\u0687\u0003\u0010\b\u0000\u0687\u00d7\u0001\u0000\u0000\u0000\u0688\u0689" +
                    "\u0005\u00b4\u0000\u0000\u0689\u068a\u0003\u0010\b\u0000\u068a\u068b\u0005" +
                    "\u00c6\u0000\u0000\u068b\u0690\u0003\u00dam\u0000\u068c\u068d\u0005\u00b7" +
                    "\u0000\u0000\u068d\u068f\u0003\u00dam\u0000\u068e\u068c\u0001\u0000\u0000" +
                    "\u0000\u068f\u0692\u0001\u0000\u0000\u0000\u0690\u068e\u0001\u0000\u0000" +
                    "\u0000\u0690\u0691\u0001\u0000\u0000\u0000\u0691\u0693\u0001\u0000\u0000" +
                    "\u0000\u0692\u0690\u0001\u0000\u0000\u0000\u0693\u0694\u0005\u00c7\u0000" +
                    "\u0000\u0694\u00d9\u0001\u0000\u0000\u0000\u0695\u0697\u0003\u0010\b\u0000" +
                    "\u0696\u0698\u0003\u0012\t\u0000\u0697\u0696\u0001\u0000\u0000\u0000\u0697" +
                    "\u0698\u0001\u0000\u0000\u0000\u0698\u06cc\u0001\u0000\u0000\u0000\u0699" +
                    "\u069a\u0005$\u0000\u0000\u069a\u069c\u0003\u0010\b\u0000\u069b\u069d" +
                    "\u0003\u0012\t\u0000\u069c\u069b\u0001\u0000\u0000\u0000\u069c\u069d\u0001" +
                    "\u0000\u0000\u0000\u069d\u069e\u0001\u0000\u0000\u0000\u069e\u069f\u0005" +
                    "\u00c4\u0000\u0000\u069f\u06a4\u0005\u00db\u0000\u0000\u06a0\u06a1\u0005" +
                    "\u00b7\u0000\u0000\u06a1\u06a3\u0005\u00db\u0000\u0000\u06a2\u06a0\u0001" +
                    "\u0000\u0000\u0000\u06a3\u06a6\u0001\u0000\u0000\u0000\u06a4\u06a2\u0001" +
                    "\u0000\u0000\u0000\u06a4\u06a5\u0001\u0000\u0000\u0000\u06a5\u06a7\u0001" +
                    "\u0000\u0000\u0000\u06a6\u06a4\u0001\u0000\u0000\u0000\u06a7\u06a8\u0005" +
                    "\u00c5\u0000\u0000\u06a8\u06cc\u0001\u0000\u0000\u0000\u06a9\u06aa\u0003" +
                    "\u0010\b\u0000\u06aa\u06ab\u0003\u0010\b\u0000\u06ab\u06cc\u0001\u0000" +
                    "\u0000\u0000\u06ac\u06ad\u0005\u0003\u0000\u0000\u06ad\u06b2\u0005\u00cd" +
                    "\u0000\u0000\u06ae\u06b3\u0003\u0010\b\u0000\u06af\u06b3\u0003\u0012\t" +
                    "\u0000\u06b0\u06b1\u0005$\u0000\u0000\u06b1\u06b3\u0003\u0012\t\u0000" +
                    "\u06b2\u06ae\u0001\u0000\u0000\u0000\u06b2\u06af\u0001\u0000\u0000\u0000" +
                    "\u06b2\u06b0\u0001\u0000\u0000\u0000\u06b3\u06b4\u0001\u0000\u0000\u0000" +
                    "\u06b4\u06b5\u0005\u00cb\u0000\u0000\u06b5\u06b6\u0003\u0010\b\u0000\u06b6" +
                    "\u06cc\u0001\u0000\u0000\u0000\u06b7\u06b8\u0005\u0005\u0000\u0000\u06b8" +
                    "\u06bb\u0005\u00cd\u0000\u0000\u06b9\u06bc\u0003\u0010\b\u0000\u06ba\u06bc" +
                    "\u0003\u0012\t\u0000\u06bb\u06b9\u0001\u0000\u0000\u0000\u06bb\u06ba\u0001" +
                    "\u0000\u0000\u0000\u06bc\u06bd\u0001\u0000\u0000\u0000\u06bd\u06be\u0005" +
                    "\u00cb\u0000\u0000\u06be\u06bf\u0003\u0010\b\u0000\u06bf\u06cc\u0001\u0000" +
                    "\u0000\u0000\u06c0\u06c1\u0005\u0004\u0000\u0000\u06c1\u06c2\u0005\u00cd" +
                    "\u0000\u0000\u06c2\u06c3\u0003\u0012\t\u0000\u06c3\u06c6\u0005\u00b7\u0000" +
                    "\u0000\u06c4\u06c7\u0003\u0010\b\u0000\u06c5\u06c7\u0003\u0012\t\u0000" +
                    "\u06c6\u06c4\u0001\u0000\u0000\u0000\u06c6\u06c5\u0001\u0000\u0000\u0000" +
                    "\u06c7\u06c8\u0001\u0000\u0000\u0000\u06c8\u06c9\u0005\u00cb\u0000\u0000" +
                    "\u06c9\u06ca\u0003\u0010\b\u0000\u06ca\u06cc\u0001\u0000\u0000\u0000\u06cb" +
                    "\u0695\u0001\u0000\u0000\u0000\u06cb\u0699\u0001\u0000\u0000\u0000\u06cb" +
                    "\u06a9\u0001\u0000\u0000\u0000\u06cb\u06ac\u0001\u0000\u0000\u0000\u06cb" +
                    "\u06b7\u0001\u0000\u0000\u0000\u06cb\u06c0\u0001\u0000\u0000\u0000\u06cc" +
                    "\u00db\u0001\u0000\u0000\u0000\u06cd\u06ce\u0003\u0010\b\u0000\u06ce\u06cf" +
                    "\u0003\u0010\b\u0000\u06cf\u06d0\u0005\u00c6\u0000\u0000\u06d0\u06d1\u0005" +
                    "\u00c7\u0000\u0000\u06d1\u00dd\u0001\u0000\u0000\u0000\u06d2\u06d3\u0005" +
                    "\u00b6\u0000\u0000\u06d3\u00df\u0001\u0000\u0000\u0000\u06d4\u06d8\u0003" +
                    "\u00e2q\u0000\u06d5\u06d8\u0005\u00de\u0000\u0000\u06d6\u06d8\u0005\u00df" +
                    "\u0000\u0000\u06d7\u06d4\u0001\u0000\u0000\u0000\u06d7\u06d5\u0001\u0000" +
                    "\u0000\u0000\u06d7\u06d6\u0001\u0000\u0000\u0000\u06d8\u00e1\u0001\u0000" +
                    "\u0000\u0000\u06d9\u06db\u0007\n\u0000\u0000\u06da\u06dc\u0007\u000b\u0000" +
                    "\u0000\u06db\u06da\u0001\u0000\u0000\u0000\u06db\u06dc\u0001\u0000\u0000" +
                    "\u0000\u06dc\u00e3\u0001\u0000\u0000\u0000u\u00e6\u00e8\u00ec\u00ef\u00f2" +
                    "\u0155\u0159\u015d\u0165\u016a\u0171\u017c\u0181\u0189\u018d\u0191\u019b" +
                    "\u01b2\u01b4\u01c0\u01c3\u02a3\u02c6\u02d1\u02fd\u0300\u037f\u038d\u0393" +
                    "\u03b2\u03b8\u03ba\u03c3\u03c6\u03d0\u03d4\u03e2\u03e6\u03ea\u03ef\u03f3" +
                    "\u03f7\u0409\u0414\u0418\u041e\u042c\u0434\u0437\u043a\u0442\u044a\u044d" +
                    "\u0460\u0468\u0470\u0478\u0495\u049c\u04a2\u04a6\u04a9\u04ad\u04b3\u04b7" +
                    "\u04bc\u04c1\u04c4\u04ce\u04d8\u04dc\u04e1\u04e5\u04ea\u04ee\u04fb\u0500" +
                    "\u050a\u0515\u051b\u0520\u0530\u0536\u053b\u053f\u0550\u0559\u0562\u056b" +
                    "\u0574\u057e\u0592\u0596\u059a\u05aa\u05ae\u05b1\u05b4\u05b6\u05c6\u05e9" +
                    "\u05fe\u060a\u060e\u0633\u0672\u067d\u0690\u0697\u069c\u06a4\u06b2\u06bb" +
                    "\u06c6\u06cb\u06d7\u06db";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
    }

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public PuffinBasicParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
                "prog", "line", "linenum", "comment", "stmt", "variable", "leafvariable",
                "structvariable", "varname", "varsuffix", "expr", "func", "funcname",
                "gosubstmt", "gosublabelstmt", "returnstmt", "printhashusingstmt", "printusingstmt",
                "printhashstmt", "printstmt", "printlist", "writestmt", "writehashstmt",
                "letstmt", "autoletstmt", "ifstmt", "then", "elsestmt", "ifthenbeginstmt",
                "elsebeginstmt", "endifstmt", "stmtlist", "forstmt", "nextstmt", "gotostmt",
                "gotolabelstmt", "endstmt", "deffnstmt", "functionbeginstmt", "functionreturnstmt",
                "functionendstmt", "importstmt", "libtagstmt", "dimstmt", "reallocstmt",
                "whilestmt", "wendstmt", "lsetstmt", "rsetstmt", "swapstmt", "open1stmt",
                "open2stmt", "closestmt", "filemode1", "filemode2", "access", "lock",
                "putstmt", "getstmt", "fieldstmt", "inputstmt", "inputhashstmt", "lineinputstmt",
                "lineinputhashstmt", "readstmt", "datastmt", "restorestmt", "randomizestmt",
                "randomizetimerstmt", "defintstmt", "deflngstmt", "defsngstmt", "defdblstmt",
                "defstrstmt", "middlrstmt", "sleepstmt", "screenstmt", "repaintstmt",
                "circlestmt", "linestmt", "colorstmt", "paintstmt", "psetstmt", "drawstmt",
                "graphicsgetstmt", "graphicsputstmt", "graphicsbuffercopyhorstmt", "fontstmt",
                "drawstrstmt", "loadimgstmt", "saveimgstmt", "locatestmt", "clsstmt",
                "beepstmt", "arrayfillstmt", "arraycopystmt", "array1dsortstmt", "array1dcopystmt",
                "array2dshifthorstmt", "array2dshiftverstmt", "loadwavstmt", "playwavstmt",
                "stopwavstmt", "loopwavstmt", "labelstmt", "liststmt", "dictstmt", "setstmt",
                "structstmt", "compositetype", "structinstancestmt", "string", "number",
                "integer"
        };
    }

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "':'", null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, "','", "';'", "'?'", "'@'", "'$'", "'%'", "'!'", "'#'",
                "'''", "'^'", "'/'", "'\\'", "'*'", "'('", "')'", "'{'", "'}'", null,
                "'='", "'<>'", "'>'", "'>='", "'<'", "'<='", null, null, null, null,
                null, null, null, null, null, null, "'+'", "'-'", null, null, null, null,
                null, "'.'", null, null, "' '", "'\\t'"
        };
    }

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, "COMMENT", "LIST", "DICT", "SET", "EQGT", "LOCATE", "DEFAULT",
                "LETTERRANGE", "LET", "AUTO", "PRINT", "PRINTHASH", "USING", "IF", "THEN",
                "ELSE", "GOTO", "FOR", "NEXT", "TO", "STEP", "REM", "FUNCTION", "LIBTAG",
                "IMPORT", "END", "SIN", "COS", "TAN", "ATN", "SQR", "ABS", "ASC", "DEF",
                "DIM", "ALLOCARRAY", "REALLOCARRAY", "LTRIMDLR", "RTRIMDLR", "GOSUB",
                "RETURN", "LSET", "RSET", "CINT", "CLNG", "CSNG", "CDBL", "CHRDLR", "WHILE",
                "WEND", "MKIDLR", "MKLDLR", "MKSDLR", "MKDDLR", "CVI", "CVL", "CVS",
                "CVD", "SPACEDLR", "STRDLR", "VAL", "INT", "FIX", "LOG", "LEN", "RIGHTDLR",
                "LEFTDLR", "MIDDLR", "INSTR", "HEXDLR", "OCTDLR", "RND", "SGN", "TIMER",
                "TIMERMILLIS", "STRINGDLR", "SWAP", "OPEN", "CLOSE", "ACCESS", "AS",
                "LINE", "INPUT", "INPUTHASH", "INPUTDLR", "OUTPUT", "APPEND", "RANDOM",
                "RANDOMIZE", "READ", "WRITE", "WRITEHASH", "SHARED", "LOCK", "PUT", "GET",
                "EOFFN", "LOC", "LOF", "FIELD", "DATA", "RESTORE", "DEFINT", "DEFLNG",
                "DEFSNG", "DEFDBL", "DEFSTR", "ENVIRONDLR", "SCREEN", "CIRCLE", "SLEEP",
                "COLOR", "INKEYDLR", "PAINT", "PSET", "DRAW", "FONT", "DRAWSTR", "LOADIMG",
                "SAVEIMG", "LOADWAV", "PLAYWAV", "STOPWAV", "LOOPWAV", "CLS", "BEEP",
                "MANUAL_REPAINT", "DOUBLE_BUFFER", "REPAINT", "ASIN", "ACOS", "SINH",
                "COSH", "TANH", "EULERE", "PI", "MIN", "MAX", "FLOOR", "CEIL", "ROUND",
                "LOG10", "LOG2", "EXP", "TORAD", "TODEG", "TRUE", "FALSE", "ARRAYFILL",
                "ARRAY1DMIN", "ARRAY1DMAX", "ARRAY1DMEAN", "ARRAY1DSUM", "ARRAY1DSTD",
                "ARRAY1DMEDIAN", "ARRAY1DPCT", "ARRAY1DSORT", "ARRAY1DBINSEARCH", "ARRAY2DFINDROW",
                "ARRAY2DFINDCOLUMN", "ARRAYCOPY", "ARRAY1DCOPY", "ARRAY2DSHIFTHOR", "ARRAY2DSHIFTVER",
                "HSB2RGB", "LABEL", "BEGIN", "MOUSEMOVEDX", "MOUSEMOVEDY", "MOUSEDRAGGEDX",
                "MOUSEDRAGGEDY", "MOUSEBUTTONCLICKED", "MOUSEBUTTONPRESSED", "MOUSEBUTTONRELEASED",
                "ISKEYPRESSED", "FRONT", "BACK1", "BUFFERCOPYHOR", "STRUCT", "SPLITDLR",
                "STRING", "COMMA", "SEMICOLON", "QUESTION", "AT", "DOLLAR", "PERCENT",
                "EXCLAMATION", "HASH", "APOSTROPHE", "EXPONENT", "FLOAT_DIV", "INT_DIV",
                "MUL", "LPAREN", "RPAREN", "LBRACE", "RBRACE", "MOD", "RELEQ", "RELNEQ",
                "RELGT", "RELGE", "RELLT", "RELLE", "LOGAND", "LOGOR", "LOGNOT", "LOGXOR",
                "LOGEQV", "LOGIMP", "BWRSFT", "BWLSFT", "VARNAME", "LETTER", "PLUS",
                "MINUS", "DECIMAL", "HEXADECIMAL", "OCTAL", "FLOAT", "DOUBLE", "DOT",
                "NEWLINE", "WS", "SPACE", "TAB"
        };
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "PuffinBasic.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public final ProgContext prog() throws RecognitionException {
        ProgContext _localctx = new ProgContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_prog);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(232);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -14762820L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -3280338945L) != 0) || ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & 40109909302575103L) != 0) || ((((_la - 199)) & ~0x3f) == 0 && ((1L << (_la - 199)) & 68222977L) != 0)) {
                    {
                        setState(230);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 0, _ctx)) {
                            case 1: {
                                setState(228);
                                line();
                            }
                            break;
                            case 2: {
                                setState(229);
                                match(NEWLINE);
                            }
                            break;
                        }
                    }
                    setState(234);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LineContext line() throws RecognitionException {
        LineContext _localctx = new LineContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_line);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(236);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == DECIMAL) {
                    {
                        setState(235);
                        linenum();
                    }
                }

                setState(239);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -14762824L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -3280338945L) != 0) || ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & 40109909302575103L) != 0) || _la == RBRACE || _la == VARNAME) {
                    {
                        setState(238);
                        stmtlist();
                    }
                }

                setState(242);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COMMENT) {
                    {
                        setState(241);
                        comment();
                    }
                }

                setState(244);
                match(NEWLINE);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LinenumContext linenum() throws RecognitionException {
        LinenumContext _localctx = new LinenumContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_linenum);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(246);
                match(DECIMAL);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final CommentContext comment() throws RecognitionException {
        CommentContext _localctx = new CommentContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_comment);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(248);
                match(COMMENT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StmtContext stmt() throws RecognitionException {
        StmtContext _localctx = new StmtContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_stmt);
        try {
            setState(341);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 5, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(250);
                    printusingstmt();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(251);
                    printhashusingstmt();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(252);
                    printstmt();
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(253);
                    printhashstmt();
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(254);
                    writestmt();
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(255);
                    writehashstmt();
                }
                break;
                case 7:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(256);
                    letstmt();
                }
                break;
                case 8:
                    enterOuterAlt(_localctx, 8);
                {
                    setState(257);
                    autoletstmt();
                }
                break;
                case 9:
                    enterOuterAlt(_localctx, 9);
                {
                    setState(258);
                    ifstmt();
                }
                break;
                case 10:
                    enterOuterAlt(_localctx, 10);
                {
                    setState(259);
                    ifthenbeginstmt();
                }
                break;
                case 11:
                    enterOuterAlt(_localctx, 11);
                {
                    setState(260);
                    elsebeginstmt();
                }
                break;
                case 12:
                    enterOuterAlt(_localctx, 12);
                {
                    setState(261);
                    endifstmt();
                }
                break;
                case 13:
                    enterOuterAlt(_localctx, 13);
                {
                    setState(262);
                    forstmt();
                }
                break;
                case 14:
                    enterOuterAlt(_localctx, 14);
                {
                    setState(263);
                    nextstmt();
                }
                break;
                case 15:
                    enterOuterAlt(_localctx, 15);
                {
                    setState(264);
                    gotostmt();
                }
                break;
                case 16:
                    enterOuterAlt(_localctx, 16);
                {
                    setState(265);
                    gotolabelstmt();
                }
                break;
                case 17:
                    enterOuterAlt(_localctx, 17);
                {
                    setState(266);
                    endstmt();
                }
                break;
                case 18:
                    enterOuterAlt(_localctx, 18);
                {
                    setState(267);
                    deffnstmt();
                }
                break;
                case 19:
                    enterOuterAlt(_localctx, 19);
                {
                    setState(268);
                    functionbeginstmt();
                }
                break;
                case 20:
                    enterOuterAlt(_localctx, 20);
                {
                    setState(269);
                    functionreturnstmt();
                }
                break;
                case 21:
                    enterOuterAlt(_localctx, 21);
                {
                    setState(270);
                    functionendstmt();
                }
                break;
                case 22:
                    enterOuterAlt(_localctx, 22);
                {
                    setState(271);
                    importstmt();
                }
                break;
                case 23:
                    enterOuterAlt(_localctx, 23);
                {
                    setState(272);
                    libtagstmt();
                }
                break;
                case 24:
                    enterOuterAlt(_localctx, 24);
                {
                    setState(273);
                    dimstmt();
                }
                break;
                case 25:
                    enterOuterAlt(_localctx, 25);
                {
                    setState(274);
                    reallocstmt();
                }
                break;
                case 26:
                    enterOuterAlt(_localctx, 26);
                {
                    setState(275);
                    gosubstmt();
                }
                break;
                case 27:
                    enterOuterAlt(_localctx, 27);
                {
                    setState(276);
                    gosublabelstmt();
                }
                break;
                case 28:
                    enterOuterAlt(_localctx, 28);
                {
                    setState(277);
                    returnstmt();
                }
                break;
                case 29:
                    enterOuterAlt(_localctx, 29);
                {
                    setState(278);
                    whilestmt();
                }
                break;
                case 30:
                    enterOuterAlt(_localctx, 30);
                {
                    setState(279);
                    wendstmt();
                }
                break;
                case 31:
                    enterOuterAlt(_localctx, 31);
                {
                    setState(280);
                    lsetstmt();
                }
                break;
                case 32:
                    enterOuterAlt(_localctx, 32);
                {
                    setState(281);
                    rsetstmt();
                }
                break;
                case 33:
                    enterOuterAlt(_localctx, 33);
                {
                    setState(282);
                    swapstmt();
                }
                break;
                case 34:
                    enterOuterAlt(_localctx, 34);
                {
                    setState(283);
                    open1stmt();
                }
                break;
                case 35:
                    enterOuterAlt(_localctx, 35);
                {
                    setState(284);
                    open2stmt();
                }
                break;
                case 36:
                    enterOuterAlt(_localctx, 36);
                {
                    setState(285);
                    closestmt();
                }
                break;
                case 37:
                    enterOuterAlt(_localctx, 37);
                {
                    setState(286);
                    putstmt();
                }
                break;
                case 38:
                    enterOuterAlt(_localctx, 38);
                {
                    setState(287);
                    getstmt();
                }
                break;
                case 39:
                    enterOuterAlt(_localctx, 39);
                {
                    setState(288);
                    fieldstmt();
                }
                break;
                case 40:
                    enterOuterAlt(_localctx, 40);
                {
                    setState(289);
                    inputstmt();
                }
                break;
                case 41:
                    enterOuterAlt(_localctx, 41);
                {
                    setState(290);
                    inputhashstmt();
                }
                break;
                case 42:
                    enterOuterAlt(_localctx, 42);
                {
                    setState(291);
                    lineinputstmt();
                }
                break;
                case 43:
                    enterOuterAlt(_localctx, 43);
                {
                    setState(292);
                    lineinputhashstmt();
                }
                break;
                case 44:
                    enterOuterAlt(_localctx, 44);
                {
                    setState(293);
                    readstmt();
                }
                break;
                case 45:
                    enterOuterAlt(_localctx, 45);
                {
                    setState(294);
                    datastmt();
                }
                break;
                case 46:
                    enterOuterAlt(_localctx, 46);
                {
                    setState(295);
                    restorestmt();
                }
                break;
                case 47:
                    enterOuterAlt(_localctx, 47);
                {
                    setState(296);
                    randomizestmt();
                }
                break;
                case 48:
                    enterOuterAlt(_localctx, 48);
                {
                    setState(297);
                    randomizetimerstmt();
                }
                break;
                case 49:
                    enterOuterAlt(_localctx, 49);
                {
                    setState(298);
                    defintstmt();
                }
                break;
                case 50:
                    enterOuterAlt(_localctx, 50);
                {
                    setState(299);
                    deflngstmt();
                }
                break;
                case 51:
                    enterOuterAlt(_localctx, 51);
                {
                    setState(300);
                    defsngstmt();
                }
                break;
                case 52:
                    enterOuterAlt(_localctx, 52);
                {
                    setState(301);
                    defdblstmt();
                }
                break;
                case 53:
                    enterOuterAlt(_localctx, 53);
                {
                    setState(302);
                    defstrstmt();
                }
                break;
                case 54:
                    enterOuterAlt(_localctx, 54);
                {
                    setState(303);
                    middlrstmt();
                }
                break;
                case 55:
                    enterOuterAlt(_localctx, 55);
                {
                    setState(304);
                    sleepstmt();
                }
                break;
                case 56:
                    enterOuterAlt(_localctx, 56);
                {
                    setState(305);
                    screenstmt();
                }
                break;
                case 57:
                    enterOuterAlt(_localctx, 57);
                {
                    setState(306);
                    circlestmt();
                }
                break;
                case 58:
                    enterOuterAlt(_localctx, 58);
                {
                    setState(307);
                    linestmt();
                }
                break;
                case 59:
                    enterOuterAlt(_localctx, 59);
                {
                    setState(308);
                    colorstmt();
                }
                break;
                case 60:
                    enterOuterAlt(_localctx, 60);
                {
                    setState(309);
                    paintstmt();
                }
                break;
                case 61:
                    enterOuterAlt(_localctx, 61);
                {
                    setState(310);
                    psetstmt();
                }
                break;
                case 62:
                    enterOuterAlt(_localctx, 62);
                {
                    setState(311);
                    drawstmt();
                }
                break;
                case 63:
                    enterOuterAlt(_localctx, 63);
                {
                    setState(312);
                    graphicsgetstmt();
                }
                break;
                case 64:
                    enterOuterAlt(_localctx, 64);
                {
                    setState(313);
                    graphicsputstmt();
                }
                break;
                case 65:
                    enterOuterAlt(_localctx, 65);
                {
                    setState(314);
                    graphicsbuffercopyhorstmt();
                }
                break;
                case 66:
                    enterOuterAlt(_localctx, 66);
                {
                    setState(315);
                    fontstmt();
                }
                break;
                case 67:
                    enterOuterAlt(_localctx, 67);
                {
                    setState(316);
                    drawstrstmt();
                }
                break;
                case 68:
                    enterOuterAlt(_localctx, 68);
                {
                    setState(317);
                    loadimgstmt();
                }
                break;
                case 69:
                    enterOuterAlt(_localctx, 69);
                {
                    setState(318);
                    saveimgstmt();
                }
                break;
                case 70:
                    enterOuterAlt(_localctx, 70);
                {
                    setState(319);
                    locatestmt();
                }
                break;
                case 71:
                    enterOuterAlt(_localctx, 71);
                {
                    setState(320);
                    clsstmt();
                }
                break;
                case 72:
                    enterOuterAlt(_localctx, 72);
                {
                    setState(321);
                    beepstmt();
                }
                break;
                case 73:
                    enterOuterAlt(_localctx, 73);
                {
                    setState(322);
                    repaintstmt();
                }
                break;
                case 74:
                    enterOuterAlt(_localctx, 74);
                {
                    setState(323);
                    arrayfillstmt();
                }
                break;
                case 75:
                    enterOuterAlt(_localctx, 75);
                {
                    setState(324);
                    arraycopystmt();
                }
                break;
                case 76:
                    enterOuterAlt(_localctx, 76);
                {
                    setState(325);
                    array1dcopystmt();
                }
                break;
                case 77:
                    enterOuterAlt(_localctx, 77);
                {
                    setState(326);
                    array1dsortstmt();
                }
                break;
                case 78:
                    enterOuterAlt(_localctx, 78);
                {
                    setState(327);
                    array2dshifthorstmt();
                }
                break;
                case 79:
                    enterOuterAlt(_localctx, 79);
                {
                    setState(328);
                    array2dshiftverstmt();
                }
                break;
                case 80:
                    enterOuterAlt(_localctx, 80);
                {
                    setState(329);
                    loadwavstmt();
                }
                break;
                case 81:
                    enterOuterAlt(_localctx, 81);
                {
                    setState(330);
                    playwavstmt();
                }
                break;
                case 82:
                    enterOuterAlt(_localctx, 82);
                {
                    setState(331);
                    stopwavstmt();
                }
                break;
                case 83:
                    enterOuterAlt(_localctx, 83);
                {
                    setState(332);
                    loopwavstmt();
                }
                break;
                case 84:
                    enterOuterAlt(_localctx, 84);
                {
                    setState(333);
                    labelstmt();
                }
                break;
                case 85:
                    enterOuterAlt(_localctx, 85);
                {
                    setState(334);
                    liststmt();
                }
                break;
                case 86:
                    enterOuterAlt(_localctx, 86);
                {
                    setState(335);
                    dictstmt();
                }
                break;
                case 87:
                    enterOuterAlt(_localctx, 87);
                {
                    setState(336);
                    setstmt();
                }
                break;
                case 88:
                    enterOuterAlt(_localctx, 88);
                {
                    setState(337);
                    structstmt();
                }
                break;
                case 89:
                    enterOuterAlt(_localctx, 89);
                {
                    setState(338);
                    structinstancestmt();
                }
                break;
                case 90:
                    enterOuterAlt(_localctx, 90);
                {
                    setState(339);
                    func();
                }
                break;
                case 91:
                    enterOuterAlt(_localctx, 91);
                {
                    setState(340);
                    variable();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final VariableContext variable() throws RecognitionException {
        VariableContext _localctx = new VariableContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_variable);
        try {
            setState(345);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 6, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(343);
                    leafvariable();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(344);
                    structvariable();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LeafvariableContext leafvariable() throws RecognitionException {
        LeafvariableContext _localctx = new LeafvariableContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_leafvariable);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(347);
                varname();
                setState(349);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 7, _ctx)) {
                    case 1: {
                        setState(348);
                        varsuffix();
                    }
                    break;
                }
                setState(362);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 9, _ctx)) {
                    case 1: {
                        setState(351);
                        match(LPAREN);
                        setState(352);
                        expr(0);
                        setState(357);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == COMMA) {
                            {
                                {
                                    setState(353);
                                    match(COMMA);
                                    setState(354);
                                    expr(0);
                                }
                            }
                            setState(359);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                        setState(360);
                        match(RPAREN);
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StructvariableContext structvariable() throws RecognitionException {
        StructvariableContext _localctx = new StructvariableContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_structvariable);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(364);
                varname();
                setState(369);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 10, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(365);
                                match(DOT);
                                setState(366);
                                varname();
                            }
                        }
                    }
                    setState(371);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 10, _ctx);
                }
                setState(372);
                match(DOT);
                setState(373);
                leafvariable();
                setState(385);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 12, _ctx)) {
                    case 1: {
                        setState(374);
                        match(LPAREN);
                        setState(375);
                        expr(0);
                        setState(380);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == COMMA) {
                            {
                                {
                                    setState(376);
                                    match(COMMA);
                                    setState(377);
                                    expr(0);
                                }
                            }
                            setState(382);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                        setState(383);
                        match(RPAREN);
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final VarnameContext varname() throws RecognitionException {
        VarnameContext _localctx = new VarnameContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_varname);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(387);
                match(VARNAME);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final VarsuffixContext varsuffix() throws RecognitionException {
        VarsuffixContext _localctx = new VarsuffixContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_varsuffix);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(389);
                _la = _input.LA(1);
                if (!(((((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 31L) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ExprContext expr() throws RecognitionException {
        return expr(0);
    }

    private ExprContext expr(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ExprContext _localctx = new ExprContext(_ctx, _parentState);
        ExprContext _prevctx = _localctx;
        int _startState = 20;
        enterRecursionRule(_localctx, 20, RULE_expr, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(411);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 16, _ctx)) {
                    case 1: {
                        _localctx = new ExprFuncContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;

                        setState(393);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == PLUS || _la == MINUS) {
                            {
                                setState(392);
                                _la = _input.LA(1);
                                if (!(_la == PLUS || _la == MINUS)) {
                                    _errHandler.recoverInline(this);
                                } else {
                                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                    _errHandler.reportMatch(this);
                                    consume();
                                }
                            }
                        }

                        setState(395);
                        func();
                    }
                    break;
                    case 2: {
                        _localctx = new ExprNumberContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(397);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == PLUS || _la == MINUS) {
                            {
                                setState(396);
                                _la = _input.LA(1);
                                if (!(_la == PLUS || _la == MINUS)) {
                                    _errHandler.recoverInline(this);
                                } else {
                                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                    _errHandler.reportMatch(this);
                                    consume();
                                }
                            }
                        }

                        setState(399);
                        number();
                    }
                    break;
                    case 3: {
                        _localctx = new ExprVariableContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(401);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == PLUS || _la == MINUS) {
                            {
                                setState(400);
                                _la = _input.LA(1);
                                if (!(_la == PLUS || _la == MINUS)) {
                                    _errHandler.recoverInline(this);
                                } else {
                                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                    _errHandler.reportMatch(this);
                                    consume();
                                }
                            }
                        }

                        setState(403);
                        variable();
                    }
                    break;
                    case 4: {
                        _localctx = new ExprParenContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(404);
                        match(LPAREN);
                        setState(405);
                        expr(0);
                        setState(406);
                        match(RPAREN);
                    }
                    break;
                    case 5: {
                        _localctx = new ExprStringContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(408);
                        string();
                    }
                    break;
                    case 6: {
                        _localctx = new ExprLogNotContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(409);
                        match(LOGNOT);
                        setState(410);
                        expr(3);
                    }
                    break;
                }
                _ctx.stop = _input.LT(-1);
                setState(436);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 18, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(434);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 17, _ctx)) {
                                case 1: {
                                    _localctx = new ExprExpContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(413);
                                    if (!(precpred(_ctx, 8)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 8)");
                                    setState(414);
                                    match(EXPONENT);
                                    setState(415);
                                    expr(9);
                                }
                                break;
                                case 2: {
                                    _localctx = new ExprMulDivContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(416);
                                    if (!(precpred(_ctx, 7)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 7)");
                                    setState(417);
                                    _la = _input.LA(1);
                                    if (!(((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & 7L) != 0))) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(418);
                                    expr(8);
                                }
                                break;
                                case 3: {
                                    _localctx = new ExprModContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(419);
                                    if (!(precpred(_ctx, 6)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 6)");
                                    setState(420);
                                    match(MOD);
                                    setState(421);
                                    expr(7);
                                }
                                break;
                                case 4: {
                                    _localctx = new ExprPlusMinusContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(422);
                                    if (!(precpred(_ctx, 5)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 5)");
                                    setState(423);
                                    _la = _input.LA(1);
                                    if (!(_la == PLUS || _la == MINUS)) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(424);
                                    expr(6);
                                }
                                break;
                                case 5: {
                                    _localctx = new ExprRelationalContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(425);
                                    if (!(precpred(_ctx, 4)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                                    setState(426);
                                    _la = _input.LA(1);
                                    if (!(((((_la - 201)) & ~0x3f) == 0 && ((1L << (_la - 201)) & 63L) != 0))) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(427);
                                    expr(5);
                                }
                                break;
                                case 6: {
                                    _localctx = new ExprLogicalContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(428);
                                    if (!(precpred(_ctx, 2)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                    setState(429);
                                    _la = _input.LA(1);
                                    if (!(((((_la - 207)) & ~0x3f) == 0 && ((1L << (_la - 207)) & 59L) != 0))) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(430);
                                    expr(3);
                                }
                                break;
                                case 7: {
                                    _localctx = new ExprBitwiseContext(new ExprContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                    setState(431);
                                    if (!(precpred(_ctx, 1)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                    setState(432);
                                    _la = _input.LA(1);
                                    if (!(_la == BWRSFT || _la == BWLSFT)) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(433);
                                    expr(2);
                                }
                                break;
                            }
                        }
                    }
                    setState(438);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 18, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public final FuncContext func() throws RecognitionException {
        FuncContext _localctx = new FuncContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_func);
        int _la;
        try {
            setState(909);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case VARNAME:
                    _localctx = new FuncMemberMethodCallContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(439);
                    variable();
                    setState(440);
                    match(DOT);
                    setState(441);
                    funcname();
                    setState(442);
                    match(LPAREN);
                    setState(451);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (((((_la - 28)) & ~0x3f) == 0 && ((1L << (_la - 28)) & 289356276045847167L) != 0) || ((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & -1160802812544612345L) != 0) || ((((_la - 166)) & ~0x3f) == 0 && ((1L << (_la - 166)) & 286550323458312185L) != 0)) {
                        {
                            setState(443);
                            expr(0);
                            setState(448);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == COMMA) {
                                {
                                    {
                                        setState(444);
                                        match(COMMA);
                                        setState(445);
                                        expr(0);
                                    }
                                }
                                setState(450);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }

                    setState(453);
                    match(RPAREN);
                }
                break;
                case ABS:
                    _localctx = new FuncAbsContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(455);
                    match(ABS);
                    setState(456);
                    match(LPAREN);
                    setState(457);
                    expr(0);
                    setState(458);
                    match(RPAREN);
                }
                break;
                case ASC:
                    _localctx = new FuncAscContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(460);
                    match(ASC);
                    setState(461);
                    match(LPAREN);
                    setState(462);
                    expr(0);
                    setState(463);
                    match(RPAREN);
                }
                break;
                case SIN:
                    _localctx = new FuncSinContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(465);
                    match(SIN);
                    setState(466);
                    match(LPAREN);
                    setState(467);
                    expr(0);
                    setState(468);
                    match(RPAREN);
                }
                break;
                case COS:
                    _localctx = new FuncCosContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(470);
                    match(COS);
                    setState(471);
                    match(LPAREN);
                    setState(472);
                    expr(0);
                    setState(473);
                    match(RPAREN);
                }
                break;
                case TAN:
                    _localctx = new FuncTanContext(_localctx);
                    enterOuterAlt(_localctx, 6);
                {
                    setState(475);
                    match(TAN);
                    setState(476);
                    match(LPAREN);
                    setState(477);
                    expr(0);
                    setState(478);
                    match(RPAREN);
                }
                break;
                case ASIN:
                    _localctx = new FuncASinContext(_localctx);
                    enterOuterAlt(_localctx, 7);
                {
                    setState(480);
                    match(ASIN);
                    setState(481);
                    match(LPAREN);
                    setState(482);
                    expr(0);
                    setState(483);
                    match(RPAREN);
                }
                break;
                case ACOS:
                    _localctx = new FuncACosContext(_localctx);
                    enterOuterAlt(_localctx, 8);
                {
                    setState(485);
                    match(ACOS);
                    setState(486);
                    match(LPAREN);
                    setState(487);
                    expr(0);
                    setState(488);
                    match(RPAREN);
                }
                break;
                case ATN:
                    _localctx = new FuncAtnContext(_localctx);
                    enterOuterAlt(_localctx, 9);
                {
                    setState(490);
                    match(ATN);
                    setState(491);
                    match(LPAREN);
                    setState(492);
                    expr(0);
                    setState(493);
                    match(RPAREN);
                }
                break;
                case SINH:
                    _localctx = new FuncSinhContext(_localctx);
                    enterOuterAlt(_localctx, 10);
                {
                    setState(495);
                    match(SINH);
                    setState(496);
                    match(LPAREN);
                    setState(497);
                    expr(0);
                    setState(498);
                    match(RPAREN);
                }
                break;
                case COSH:
                    _localctx = new FuncCoshContext(_localctx);
                    enterOuterAlt(_localctx, 11);
                {
                    setState(500);
                    match(COSH);
                    setState(501);
                    match(LPAREN);
                    setState(502);
                    expr(0);
                    setState(503);
                    match(RPAREN);
                }
                break;
                case TANH:
                    _localctx = new FuncTanhContext(_localctx);
                    enterOuterAlt(_localctx, 12);
                {
                    setState(505);
                    match(TANH);
                    setState(506);
                    match(LPAREN);
                    setState(507);
                    expr(0);
                    setState(508);
                    match(RPAREN);
                }
                break;
                case SQR:
                    _localctx = new FuncSqrContext(_localctx);
                    enterOuterAlt(_localctx, 13);
                {
                    setState(510);
                    match(SQR);
                    setState(511);
                    match(LPAREN);
                    setState(512);
                    expr(0);
                    setState(513);
                    match(RPAREN);
                }
                break;
                case CINT:
                    _localctx = new FuncCintContext(_localctx);
                    enterOuterAlt(_localctx, 14);
                {
                    setState(515);
                    match(CINT);
                    setState(516);
                    match(LPAREN);
                    setState(517);
                    expr(0);
                    setState(518);
                    match(RPAREN);
                }
                break;
                case CLNG:
                    _localctx = new FuncClngContext(_localctx);
                    enterOuterAlt(_localctx, 15);
                {
                    setState(520);
                    match(CLNG);
                    setState(521);
                    match(LPAREN);
                    setState(522);
                    expr(0);
                    setState(523);
                    match(RPAREN);
                }
                break;
                case CSNG:
                    _localctx = new FuncCsngContext(_localctx);
                    enterOuterAlt(_localctx, 16);
                {
                    setState(525);
                    match(CSNG);
                    setState(526);
                    match(LPAREN);
                    setState(527);
                    expr(0);
                    setState(528);
                    match(RPAREN);
                }
                break;
                case CDBL:
                    _localctx = new FuncCdblContext(_localctx);
                    enterOuterAlt(_localctx, 17);
                {
                    setState(530);
                    match(CDBL);
                    setState(531);
                    match(LPAREN);
                    setState(532);
                    expr(0);
                    setState(533);
                    match(RPAREN);
                }
                break;
                case CHRDLR:
                    _localctx = new FuncChrDlrContext(_localctx);
                    enterOuterAlt(_localctx, 18);
                {
                    setState(535);
                    match(CHRDLR);
                    setState(536);
                    match(LPAREN);
                    setState(537);
                    expr(0);
                    setState(538);
                    match(RPAREN);
                }
                break;
                case MKIDLR:
                    _localctx = new FuncMkiDlrContext(_localctx);
                    enterOuterAlt(_localctx, 19);
                {
                    setState(540);
                    match(MKIDLR);
                    setState(541);
                    match(LPAREN);
                    setState(542);
                    expr(0);
                    setState(543);
                    match(RPAREN);
                }
                break;
                case MKLDLR:
                    _localctx = new FuncMklDlrContext(_localctx);
                    enterOuterAlt(_localctx, 20);
                {
                    setState(545);
                    match(MKLDLR);
                    setState(546);
                    match(LPAREN);
                    setState(547);
                    expr(0);
                    setState(548);
                    match(RPAREN);
                }
                break;
                case MKSDLR:
                    _localctx = new FuncMksDlrContext(_localctx);
                    enterOuterAlt(_localctx, 21);
                {
                    setState(550);
                    match(MKSDLR);
                    setState(551);
                    match(LPAREN);
                    setState(552);
                    expr(0);
                    setState(553);
                    match(RPAREN);
                }
                break;
                case MKDDLR:
                    _localctx = new FuncMkdDlrContext(_localctx);
                    enterOuterAlt(_localctx, 22);
                {
                    setState(555);
                    match(MKDDLR);
                    setState(556);
                    match(LPAREN);
                    setState(557);
                    expr(0);
                    setState(558);
                    match(RPAREN);
                }
                break;
                case CVI:
                    _localctx = new FuncCviContext(_localctx);
                    enterOuterAlt(_localctx, 23);
                {
                    setState(560);
                    match(CVI);
                    setState(561);
                    match(LPAREN);
                    setState(562);
                    expr(0);
                    setState(563);
                    match(RPAREN);
                }
                break;
                case CVL:
                    _localctx = new FuncCvlContext(_localctx);
                    enterOuterAlt(_localctx, 24);
                {
                    setState(565);
                    match(CVL);
                    setState(566);
                    match(LPAREN);
                    setState(567);
                    expr(0);
                    setState(568);
                    match(RPAREN);
                }
                break;
                case CVS:
                    _localctx = new FuncCvsContext(_localctx);
                    enterOuterAlt(_localctx, 25);
                {
                    setState(570);
                    match(CVS);
                    setState(571);
                    match(LPAREN);
                    setState(572);
                    expr(0);
                    setState(573);
                    match(RPAREN);
                }
                break;
                case CVD:
                    _localctx = new FuncCvdContext(_localctx);
                    enterOuterAlt(_localctx, 26);
                {
                    setState(575);
                    match(CVD);
                    setState(576);
                    match(LPAREN);
                    setState(577);
                    expr(0);
                    setState(578);
                    match(RPAREN);
                }
                break;
                case SPACEDLR:
                    _localctx = new FuncSpaceDlrContext(_localctx);
                    enterOuterAlt(_localctx, 27);
                {
                    setState(580);
                    match(SPACEDLR);
                    setState(581);
                    match(LPAREN);
                    setState(582);
                    expr(0);
                    setState(583);
                    match(RPAREN);
                }
                break;
                case STRDLR:
                    _localctx = new FuncStrDlrContext(_localctx);
                    enterOuterAlt(_localctx, 28);
                {
                    setState(585);
                    match(STRDLR);
                    setState(586);
                    match(LPAREN);
                    setState(587);
                    expr(0);
                    setState(588);
                    match(RPAREN);
                }
                break;
                case VAL:
                    _localctx = new FuncValContext(_localctx);
                    enterOuterAlt(_localctx, 29);
                {
                    setState(590);
                    match(VAL);
                    setState(591);
                    match(LPAREN);
                    setState(592);
                    expr(0);
                    setState(593);
                    match(RPAREN);
                }
                break;
                case INT:
                    _localctx = new FuncIntContext(_localctx);
                    enterOuterAlt(_localctx, 30);
                {
                    setState(595);
                    match(INT);
                    setState(596);
                    match(LPAREN);
                    setState(597);
                    expr(0);
                    setState(598);
                    match(RPAREN);
                }
                break;
                case FIX:
                    _localctx = new FuncFixContext(_localctx);
                    enterOuterAlt(_localctx, 31);
                {
                    setState(600);
                    match(FIX);
                    setState(601);
                    match(LPAREN);
                    setState(602);
                    expr(0);
                    setState(603);
                    match(RPAREN);
                }
                break;
                case LOG:
                    _localctx = new FuncLogContext(_localctx);
                    enterOuterAlt(_localctx, 32);
                {
                    setState(605);
                    match(LOG);
                    setState(606);
                    match(LPAREN);
                    setState(607);
                    expr(0);
                    setState(608);
                    match(RPAREN);
                }
                break;
                case LOG10:
                    _localctx = new FuncLog10Context(_localctx);
                    enterOuterAlt(_localctx, 33);
                {
                    setState(610);
                    match(LOG10);
                    setState(611);
                    match(LPAREN);
                    setState(612);
                    expr(0);
                    setState(613);
                    match(RPAREN);
                }
                break;
                case LOG2:
                    _localctx = new FuncLog2Context(_localctx);
                    enterOuterAlt(_localctx, 34);
                {
                    setState(615);
                    match(LOG2);
                    setState(616);
                    match(LPAREN);
                    setState(617);
                    expr(0);
                    setState(618);
                    match(RPAREN);
                }
                break;
                case EXP:
                    _localctx = new FuncExpContext(_localctx);
                    enterOuterAlt(_localctx, 35);
                {
                    setState(620);
                    match(EXP);
                    setState(621);
                    match(LPAREN);
                    setState(622);
                    expr(0);
                    setState(623);
                    match(RPAREN);
                }
                break;
                case TORAD:
                    _localctx = new FuncToRadContext(_localctx);
                    enterOuterAlt(_localctx, 36);
                {
                    setState(625);
                    match(TORAD);
                    setState(626);
                    match(LPAREN);
                    setState(627);
                    expr(0);
                    setState(628);
                    match(RPAREN);
                }
                break;
                case TODEG:
                    _localctx = new FuncToDegContext(_localctx);
                    enterOuterAlt(_localctx, 37);
                {
                    setState(630);
                    match(TODEG);
                    setState(631);
                    match(LPAREN);
                    setState(632);
                    expr(0);
                    setState(633);
                    match(RPAREN);
                }
                break;
                case CEIL:
                    _localctx = new FuncCeilContext(_localctx);
                    enterOuterAlt(_localctx, 38);
                {
                    setState(635);
                    match(CEIL);
                    setState(636);
                    match(LPAREN);
                    setState(637);
                    expr(0);
                    setState(638);
                    match(RPAREN);
                }
                break;
                case FLOOR:
                    _localctx = new FuncFloorContext(_localctx);
                    enterOuterAlt(_localctx, 39);
                {
                    setState(640);
                    match(FLOOR);
                    setState(641);
                    match(LPAREN);
                    setState(642);
                    expr(0);
                    setState(643);
                    match(RPAREN);
                }
                break;
                case ROUND:
                    _localctx = new FuncRoundContext(_localctx);
                    enterOuterAlt(_localctx, 40);
                {
                    setState(645);
                    match(ROUND);
                    setState(646);
                    match(LPAREN);
                    setState(647);
                    expr(0);
                    setState(648);
                    match(RPAREN);
                }
                break;
                case MIN:
                    _localctx = new FuncMinContext(_localctx);
                    enterOuterAlt(_localctx, 41);
                {
                    setState(650);
                    match(MIN);
                    setState(651);
                    match(LPAREN);
                    setState(652);
                    expr(0);
                    setState(653);
                    match(COMMA);
                    setState(654);
                    expr(0);
                    setState(655);
                    match(RPAREN);
                }
                break;
                case MAX:
                    _localctx = new FuncMaxContext(_localctx);
                    enterOuterAlt(_localctx, 42);
                {
                    setState(657);
                    match(MAX);
                    setState(658);
                    match(LPAREN);
                    setState(659);
                    expr(0);
                    setState(660);
                    match(COMMA);
                    setState(661);
                    expr(0);
                    setState(662);
                    match(RPAREN);
                }
                break;
                case PI:
                    _localctx = new FuncPIContext(_localctx);
                    enterOuterAlt(_localctx, 43);
                {
                    setState(664);
                    match(PI);
                    setState(665);
                    match(LPAREN);
                    setState(666);
                    match(RPAREN);
                }
                break;
                case EULERE:
                    _localctx = new FuncEContext(_localctx);
                    enterOuterAlt(_localctx, 44);
                {
                    setState(667);
                    match(EULERE);
                    setState(668);
                    match(LPAREN);
                    setState(669);
                    match(RPAREN);
                }
                break;
                case LEN:
                    _localctx = new FuncLenContext(_localctx);
                    enterOuterAlt(_localctx, 45);
                {
                    setState(670);
                    match(LEN);
                    setState(671);
                    match(LPAREN);
                    setState(672);
                    expr(0);
                    setState(675);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == COMMA) {
                        {
                            setState(673);
                            match(COMMA);
                            setState(674);
                            ((FuncLenContext) _localctx).axis = expr(0);
                        }
                    }

                    setState(677);
                    match(RPAREN);
                }
                break;
                case HEXDLR:
                    _localctx = new FuncHexDlrContext(_localctx);
                    enterOuterAlt(_localctx, 46);
                {
                    setState(679);
                    match(HEXDLR);
                    setState(680);
                    match(LPAREN);
                    setState(681);
                    expr(0);
                    setState(682);
                    match(RPAREN);
                }
                break;
                case OCTDLR:
                    _localctx = new FuncOctDlrContext(_localctx);
                    enterOuterAlt(_localctx, 47);
                {
                    setState(684);
                    match(OCTDLR);
                    setState(685);
                    match(LPAREN);
                    setState(686);
                    expr(0);
                    setState(687);
                    match(RPAREN);
                }
                break;
                case RIGHTDLR:
                    _localctx = new FuncRightDlrContext(_localctx);
                    enterOuterAlt(_localctx, 48);
                {
                    setState(689);
                    match(RIGHTDLR);
                    setState(690);
                    match(LPAREN);
                    setState(691);
                    expr(0);
                    setState(692);
                    match(COMMA);
                    setState(693);
                    expr(0);
                    setState(694);
                    match(RPAREN);
                }
                break;
                case LEFTDLR:
                    _localctx = new FuncLeftDlrContext(_localctx);
                    enterOuterAlt(_localctx, 49);
                {
                    setState(696);
                    match(LEFTDLR);
                    setState(697);
                    match(LPAREN);
                    setState(698);
                    expr(0);
                    setState(699);
                    match(COMMA);
                    setState(700);
                    expr(0);
                    setState(701);
                    match(RPAREN);
                }
                break;
                case MIDDLR:
                    _localctx = new FuncMidDlrContext(_localctx);
                    enterOuterAlt(_localctx, 50);
                {
                    setState(703);
                    match(MIDDLR);
                    setState(704);
                    match(LPAREN);
                    setState(705);
                    expr(0);
                    setState(706);
                    match(COMMA);
                    setState(707);
                    expr(0);
                    setState(710);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == COMMA) {
                        {
                            setState(708);
                            match(COMMA);
                            setState(709);
                            expr(0);
                        }
                    }

                    setState(712);
                    match(RPAREN);
                }
                break;
                case INSTR:
                    _localctx = new FuncInstrContext(_localctx);
                    enterOuterAlt(_localctx, 51);
                {
                    setState(714);
                    match(INSTR);
                    setState(715);
                    match(LPAREN);
                    setState(716);
                    expr(0);
                    setState(717);
                    match(COMMA);
                    setState(718);
                    expr(0);
                    setState(721);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == COMMA) {
                        {
                            setState(719);
                            match(COMMA);
                            setState(720);
                            expr(0);
                        }
                    }

                    setState(723);
                    match(RPAREN);
                }
                break;
                case RND:
                    _localctx = new FuncRndContext(_localctx);
                    enterOuterAlt(_localctx, 52);
                {
                    setState(725);
                    match(RND);
                }
                break;
                case SGN:
                    _localctx = new FuncSgnContext(_localctx);
                    enterOuterAlt(_localctx, 53);
                {
                    setState(726);
                    match(SGN);
                    setState(727);
                    match(LPAREN);
                    setState(728);
                    expr(0);
                    setState(729);
                    match(RPAREN);
                }
                break;
                case ENVIRONDLR:
                    _localctx = new FuncEnvironDlrContext(_localctx);
                    enterOuterAlt(_localctx, 54);
                {
                    setState(731);
                    match(ENVIRONDLR);
                    setState(732);
                    match(LPAREN);
                    setState(733);
                    expr(0);
                    setState(734);
                    match(RPAREN);
                }
                break;
                case TIMER:
                    _localctx = new FuncTimerContext(_localctx);
                    enterOuterAlt(_localctx, 55);
                {
                    setState(736);
                    match(TIMER);
                }
                break;
                case TIMERMILLIS:
                    _localctx = new FuncTimerMillisContext(_localctx);
                    enterOuterAlt(_localctx, 56);
                {
                    setState(737);
                    match(TIMERMILLIS);
                }
                break;
                case STRINGDLR:
                    _localctx = new FuncStringDlrContext(_localctx);
                    enterOuterAlt(_localctx, 57);
                {
                    setState(738);
                    match(STRINGDLR);
                    setState(739);
                    match(LPAREN);
                    setState(740);
                    expr(0);
                    setState(741);
                    match(COMMA);
                    setState(742);
                    expr(0);
                    setState(743);
                    match(RPAREN);
                }
                break;
                case EOFFN:
                    _localctx = new FuncEofContext(_localctx);
                    enterOuterAlt(_localctx, 58);
                {
                    setState(745);
                    match(EOFFN);
                    setState(746);
                    match(LPAREN);
                    setState(747);
                    expr(0);
                    setState(748);
                    match(RPAREN);
                }
                break;
                case LOC:
                    _localctx = new FuncLocContext(_localctx);
                    enterOuterAlt(_localctx, 59);
                {
                    setState(750);
                    match(LOC);
                    setState(751);
                    match(LPAREN);
                    setState(752);
                    expr(0);
                    setState(753);
                    match(RPAREN);
                }
                break;
                case LOF:
                    _localctx = new FuncLofContext(_localctx);
                    enterOuterAlt(_localctx, 60);
                {
                    setState(755);
                    match(LOF);
                    setState(756);
                    match(LPAREN);
                    setState(757);
                    expr(0);
                    setState(758);
                    match(RPAREN);
                }
                break;
                case INPUTDLR:
                    _localctx = new FuncInputDlrContext(_localctx);
                    enterOuterAlt(_localctx, 61);
                {
                    setState(760);
                    match(INPUTDLR);
                    setState(761);
                    match(LPAREN);
                    setState(762);
                    expr(0);
                    setState(768);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == COMMA) {
                        {
                            setState(763);
                            match(COMMA);
                            setState(765);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == HASH) {
                                {
                                    setState(764);
                                    match(HASH);
                                }
                            }

                            setState(767);
                            expr(0);
                        }
                    }

                    setState(770);
                    match(RPAREN);
                }
                break;
                case INKEYDLR:
                    _localctx = new FuncInkeyDlrContext(_localctx);
                    enterOuterAlt(_localctx, 62);
                {
                    setState(772);
                    match(INKEYDLR);
                }
                break;
                case ARRAY1DMIN:
                    _localctx = new FuncArray1DMinContext(_localctx);
                    enterOuterAlt(_localctx, 63);
                {
                    setState(773);
                    match(ARRAY1DMIN);
                    setState(774);
                    match(LPAREN);
                    setState(775);
                    variable();
                    setState(776);
                    match(RPAREN);
                }
                break;
                case ARRAY1DMAX:
                    _localctx = new FuncArray1DMaxContext(_localctx);
                    enterOuterAlt(_localctx, 64);
                {
                    setState(778);
                    match(ARRAY1DMAX);
                    setState(779);
                    match(LPAREN);
                    setState(780);
                    variable();
                    setState(781);
                    match(RPAREN);
                }
                break;
                case ARRAY1DMEAN:
                    _localctx = new FuncArray1DMeanContext(_localctx);
                    enterOuterAlt(_localctx, 65);
                {
                    setState(783);
                    match(ARRAY1DMEAN);
                    setState(784);
                    match(LPAREN);
                    setState(785);
                    variable();
                    setState(786);
                    match(RPAREN);
                }
                break;
                case ARRAY1DSUM:
                    _localctx = new FuncArray1DSumContext(_localctx);
                    enterOuterAlt(_localctx, 66);
                {
                    setState(788);
                    match(ARRAY1DSUM);
                    setState(789);
                    match(LPAREN);
                    setState(790);
                    variable();
                    setState(791);
                    match(RPAREN);
                }
                break;
                case ARRAY1DSTD:
                    _localctx = new FuncArray1DStdContext(_localctx);
                    enterOuterAlt(_localctx, 67);
                {
                    setState(793);
                    match(ARRAY1DSTD);
                    setState(794);
                    match(LPAREN);
                    setState(795);
                    variable();
                    setState(796);
                    match(RPAREN);
                }
                break;
                case ARRAY1DMEDIAN:
                    _localctx = new FuncArray1DMedianContext(_localctx);
                    enterOuterAlt(_localctx, 68);
                {
                    setState(798);
                    match(ARRAY1DMEDIAN);
                    setState(799);
                    match(LPAREN);
                    setState(800);
                    variable();
                    setState(801);
                    match(RPAREN);
                }
                break;
                case ARRAY1DPCT:
                    _localctx = new FuncArray1DPctContext(_localctx);
                    enterOuterAlt(_localctx, 69);
                {
                    setState(803);
                    match(ARRAY1DPCT);
                    setState(804);
                    match(LPAREN);
                    setState(805);
                    variable();
                    setState(806);
                    match(COMMA);
                    setState(807);
                    ((FuncArray1DPctContext) _localctx).p = expr(0);
                    setState(808);
                    match(RPAREN);
                }
                break;
                case ARRAY1DBINSEARCH:
                    _localctx = new FuncArray1DBinSearchContext(_localctx);
                    enterOuterAlt(_localctx, 70);
                {
                    setState(810);
                    match(ARRAY1DBINSEARCH);
                    setState(811);
                    match(LPAREN);
                    setState(812);
                    variable();
                    setState(813);
                    match(COMMA);
                    setState(814);
                    expr(0);
                    setState(815);
                    match(RPAREN);
                }
                break;
                case ARRAY2DFINDROW:
                    _localctx = new FuncArray2DFindRowContext(_localctx);
                    enterOuterAlt(_localctx, 71);
                {
                    setState(817);
                    match(ARRAY2DFINDROW);
                    setState(818);
                    match(LPAREN);
                    setState(819);
                    variable();
                    setState(820);
                    match(COMMA);
                    setState(821);
                    ((FuncArray2DFindRowContext) _localctx).x1 = expr(0);
                    setState(822);
                    match(COMMA);
                    setState(823);
                    ((FuncArray2DFindRowContext) _localctx).y1 = expr(0);
                    setState(824);
                    match(COMMA);
                    setState(825);
                    ((FuncArray2DFindRowContext) _localctx).x2 = expr(0);
                    setState(826);
                    match(COMMA);
                    setState(827);
                    ((FuncArray2DFindRowContext) _localctx).y2 = expr(0);
                    setState(828);
                    match(COMMA);
                    setState(829);
                    ((FuncArray2DFindRowContext) _localctx).search = expr(0);
                    setState(830);
                    match(RPAREN);
                }
                break;
                case ARRAY2DFINDCOLUMN:
                    _localctx = new FuncArray2DFindColumnContext(_localctx);
                    enterOuterAlt(_localctx, 72);
                {
                    setState(832);
                    match(ARRAY2DFINDCOLUMN);
                    setState(833);
                    match(LPAREN);
                    setState(834);
                    variable();
                    setState(835);
                    match(COMMA);
                    setState(836);
                    ((FuncArray2DFindColumnContext) _localctx).x1 = expr(0);
                    setState(837);
                    match(COMMA);
                    setState(838);
                    ((FuncArray2DFindColumnContext) _localctx).y1 = expr(0);
                    setState(839);
                    match(COMMA);
                    setState(840);
                    ((FuncArray2DFindColumnContext) _localctx).x2 = expr(0);
                    setState(841);
                    match(COMMA);
                    setState(842);
                    ((FuncArray2DFindColumnContext) _localctx).y2 = expr(0);
                    setState(843);
                    match(COMMA);
                    setState(844);
                    ((FuncArray2DFindColumnContext) _localctx).search = expr(0);
                    setState(845);
                    match(RPAREN);
                }
                break;
                case HSB2RGB:
                    _localctx = new FuncHsb2RgbContext(_localctx);
                    enterOuterAlt(_localctx, 73);
                {
                    setState(847);
                    match(HSB2RGB);
                    setState(848);
                    match(LPAREN);
                    setState(849);
                    expr(0);
                    setState(850);
                    match(COMMA);
                    setState(851);
                    expr(0);
                    setState(852);
                    match(COMMA);
                    setState(853);
                    expr(0);
                    setState(854);
                    match(RPAREN);
                }
                break;
                case MOUSEMOVEDX:
                    _localctx = new FuncMouseMovedXContext(_localctx);
                    enterOuterAlt(_localctx, 74);
                {
                    setState(856);
                    match(MOUSEMOVEDX);
                    setState(857);
                    match(LPAREN);
                    setState(858);
                    match(RPAREN);
                }
                break;
                case MOUSEMOVEDY:
                    _localctx = new FuncMouseMovedYContext(_localctx);
                    enterOuterAlt(_localctx, 75);
                {
                    setState(859);
                    match(MOUSEMOVEDY);
                    setState(860);
                    match(LPAREN);
                    setState(861);
                    match(RPAREN);
                }
                break;
                case MOUSEDRAGGEDX:
                    _localctx = new FuncMouseDraggedXContext(_localctx);
                    enterOuterAlt(_localctx, 76);
                {
                    setState(862);
                    match(MOUSEDRAGGEDX);
                    setState(863);
                    match(LPAREN);
                    setState(864);
                    match(RPAREN);
                }
                break;
                case MOUSEDRAGGEDY:
                    _localctx = new FuncMouseDraggedYContext(_localctx);
                    enterOuterAlt(_localctx, 77);
                {
                    setState(865);
                    match(MOUSEDRAGGEDY);
                    setState(866);
                    match(LPAREN);
                    setState(867);
                    match(RPAREN);
                }
                break;
                case MOUSEBUTTONCLICKED:
                    _localctx = new FuncMouseButtonClickedContext(_localctx);
                    enterOuterAlt(_localctx, 78);
                {
                    setState(868);
                    match(MOUSEBUTTONCLICKED);
                    setState(869);
                    match(LPAREN);
                    setState(870);
                    match(RPAREN);
                }
                break;
                case MOUSEBUTTONPRESSED:
                    _localctx = new FuncMouseButtonPressedContext(_localctx);
                    enterOuterAlt(_localctx, 79);
                {
                    setState(871);
                    match(MOUSEBUTTONPRESSED);
                    setState(872);
                    match(LPAREN);
                    setState(873);
                    match(RPAREN);
                }
                break;
                case MOUSEBUTTONRELEASED:
                    _localctx = new FuncMouseButtonReleasedContext(_localctx);
                    enterOuterAlt(_localctx, 80);
                {
                    setState(874);
                    match(MOUSEBUTTONRELEASED);
                    setState(875);
                    match(LPAREN);
                    setState(876);
                    match(RPAREN);
                }
                break;
                case ISKEYPRESSED:
                    _localctx = new FuncIsKeyPressedContext(_localctx);
                    enterOuterAlt(_localctx, 81);
                {
                    setState(877);
                    match(ISKEYPRESSED);
                    setState(878);
                    match(LPAREN);
                    setState(879);
                    expr(0);
                    setState(880);
                    match(RPAREN);
                }
                break;
                case SPLITDLR:
                    _localctx = new FuncSplitDlrContext(_localctx);
                    enterOuterAlt(_localctx, 82);
                {
                    setState(882);
                    match(SPLITDLR);
                    setState(883);
                    match(LPAREN);
                    setState(884);
                    ((FuncSplitDlrContext) _localctx).str = expr(0);
                    setState(885);
                    match(COMMA);
                    setState(886);
                    ((FuncSplitDlrContext) _localctx).regex = expr(0);
                    setState(887);
                    match(RPAREN);
                }
                break;
                case ALLOCARRAY:
                    _localctx = new FuncAllocArrayContext(_localctx);
                    enterOuterAlt(_localctx, 83);
                {
                    setState(889);
                    match(ALLOCARRAY);
                    setState(890);
                    varsuffix();
                    setState(891);
                    match(LPAREN);
                    setState(892);
                    expr(0);
                    setState(895);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == COMMA) {
                        {
                            setState(893);
                            match(COMMA);
                            setState(894);
                            expr(0);
                        }
                    }

                    setState(897);
                    match(RPAREN);
                }
                break;
                case LTRIMDLR:
                    _localctx = new FuncLTrimDlrContext(_localctx);
                    enterOuterAlt(_localctx, 84);
                {
                    setState(899);
                    match(LTRIMDLR);
                    setState(900);
                    match(LPAREN);
                    setState(901);
                    ((FuncLTrimDlrContext) _localctx).str = expr(0);
                    setState(902);
                    match(RPAREN);
                }
                break;
                case RTRIMDLR:
                    _localctx = new FuncRTrimDlrContext(_localctx);
                    enterOuterAlt(_localctx, 85);
                {
                    setState(904);
                    match(RTRIMDLR);
                    setState(905);
                    match(LPAREN);
                    setState(906);
                    ((FuncRTrimDlrContext) _localctx).str = expr(0);
                    setState(907);
                    match(RPAREN);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FuncnameContext funcname() throws RecognitionException {
        FuncnameContext _localctx = new FuncnameContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_funcname);
        try {
            setState(915);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case VARNAME:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(911);
                    varname();
                }
                break;
                case GET:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(912);
                    match(GET);
                }
                break;
                case APPEND:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(913);
                    match(APPEND);
                }
                break;
                case PUT:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(914);
                    match(PUT);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final GosubstmtContext gosubstmt() throws RecognitionException {
        GosubstmtContext _localctx = new GosubstmtContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_gosubstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(917);
                match(GOSUB);
                setState(918);
                linenum();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final GosublabelstmtContext gosublabelstmt() throws RecognitionException {
        GosublabelstmtContext _localctx = new GosublabelstmtContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_gosublabelstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(920);
                match(GOSUB);
                setState(921);
                string();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ReturnstmtContext returnstmt() throws RecognitionException {
        ReturnstmtContext _localctx = new ReturnstmtContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_returnstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(923);
                match(RETURN);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final PrinthashusingstmtContext printhashusingstmt() throws RecognitionException {
        PrinthashusingstmtContext _localctx = new PrinthashusingstmtContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_printhashusingstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(925);
                match(PRINTHASH);
                setState(926);
                ((PrinthashusingstmtContext) _localctx).filenum = expr(0);
                setState(927);
                match(COMMA);
                setState(928);
                match(USING);
                setState(929);
                ((PrinthashusingstmtContext) _localctx).format = expr(0);
                setState(930);
                match(SEMICOLON);
                setState(931);
                printlist();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final PrintusingstmtContext printusingstmt() throws RecognitionException {
        PrintusingstmtContext _localctx = new PrintusingstmtContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_printusingstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(933);
                match(PRINT);
                setState(934);
                match(USING);
                setState(935);
                ((PrintusingstmtContext) _localctx).format = expr(0);
                setState(936);
                match(SEMICOLON);
                setState(937);
                printlist();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final PrinthashstmtContext printhashstmt() throws RecognitionException {
        PrinthashstmtContext _localctx = new PrinthashstmtContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_printhashstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(939);
                match(PRINTHASH);
                setState(940);
                ((PrinthashstmtContext) _localctx).filenum = expr(0);
                setState(941);
                match(COMMA);
                setState(942);
                printlist();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final PrintstmtContext printstmt() throws RecognitionException {
        PrintstmtContext _localctx = new PrintstmtContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_printstmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(944);
                _la = _input.LA(1);
                if (!(_la == PRINT || _la == QUESTION)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(946);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (((((_la - 28)) & ~0x3f) == 0 && ((1L << (_la - 28)) & 289356276045847167L) != 0) || ((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & -1160802812544612345L) != 0) || ((((_la - 166)) & ~0x3f) == 0 && ((1L << (_la - 166)) & 286550323458312185L) != 0)) {
                    {
                        setState(945);
                        printlist();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final PrintlistContext printlist() throws RecognitionException {
        PrintlistContext _localctx = new PrintlistContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_printlist);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(948);
                expr(0);
                setState(954);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 31, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            setState(952);
                            _errHandler.sync(this);
                            switch (_input.LA(1)) {
                                case COMMA: {
                                    setState(949);
                                    match(COMMA);
                                }
                                break;
                                case SEMICOLON: {
                                    setState(950);
                                    match(SEMICOLON);
                                }
                                break;
                                case SIN:
                                case COS:
                                case TAN:
                                case ATN:
                                case SQR:
                                case ABS:
                                case ASC:
                                case ALLOCARRAY:
                                case LTRIMDLR:
                                case RTRIMDLR:
                                case CINT:
                                case CLNG:
                                case CSNG:
                                case CDBL:
                                case CHRDLR:
                                case MKIDLR:
                                case MKLDLR:
                                case MKSDLR:
                                case MKDDLR:
                                case CVI:
                                case CVL:
                                case CVS:
                                case CVD:
                                case SPACEDLR:
                                case STRDLR:
                                case VAL:
                                case INT:
                                case FIX:
                                case LOG:
                                case LEN:
                                case RIGHTDLR:
                                case LEFTDLR:
                                case MIDDLR:
                                case INSTR:
                                case HEXDLR:
                                case OCTDLR:
                                case RND:
                                case SGN:
                                case TIMER:
                                case TIMERMILLIS:
                                case STRINGDLR:
                                case INPUTDLR:
                                case EOFFN:
                                case LOC:
                                case LOF:
                                case ENVIRONDLR:
                                case INKEYDLR:
                                case ASIN:
                                case ACOS:
                                case SINH:
                                case COSH:
                                case TANH:
                                case EULERE:
                                case PI:
                                case MIN:
                                case MAX:
                                case FLOOR:
                                case CEIL:
                                case ROUND:
                                case LOG10:
                                case LOG2:
                                case EXP:
                                case TORAD:
                                case TODEG:
                                case ARRAY1DMIN:
                                case ARRAY1DMAX:
                                case ARRAY1DMEAN:
                                case ARRAY1DSUM:
                                case ARRAY1DSTD:
                                case ARRAY1DMEDIAN:
                                case ARRAY1DPCT:
                                case ARRAY1DBINSEARCH:
                                case ARRAY2DFINDROW:
                                case ARRAY2DFINDCOLUMN:
                                case HSB2RGB:
                                case MOUSEMOVEDX:
                                case MOUSEMOVEDY:
                                case MOUSEDRAGGEDX:
                                case MOUSEDRAGGEDY:
                                case MOUSEBUTTONCLICKED:
                                case MOUSEBUTTONPRESSED:
                                case MOUSEBUTTONRELEASED:
                                case ISKEYPRESSED:
                                case SPLITDLR:
                                case STRING:
                                case LPAREN:
                                case LOGNOT:
                                case VARNAME:
                                case PLUS:
                                case MINUS:
                                case DECIMAL:
                                case HEXADECIMAL:
                                case OCTAL:
                                case FLOAT:
                                case DOUBLE: {
                                    setState(951);
                                    expr(0);
                                }
                                break;
                                default:
                                    throw new NoViableAltException(this);
                            }
                        }
                    }
                    setState(956);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 31, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final WritestmtContext writestmt() throws RecognitionException {
        WritestmtContext _localctx = new WritestmtContext(_ctx, getState());
        enterRule(_localctx, 42, RULE_writestmt);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(957);
                match(WRITE);
                setState(966);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (((((_la - 28)) & ~0x3f) == 0 && ((1L << (_la - 28)) & 289356276045847167L) != 0) || ((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & -1160802812544612345L) != 0) || ((((_la - 166)) & ~0x3f) == 0 && ((1L << (_la - 166)) & 286550323458312185L) != 0)) {
                    {
                        setState(958);
                        expr(0);
                        setState(963);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 32, _ctx);
                        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                            if (_alt == 1) {
                                {
                                    {
                                        setState(959);
                                        match(COMMA);
                                        setState(960);
                                        expr(0);
                                    }
                                }
                            }
                            setState(965);
                            _errHandler.sync(this);
                            _alt = getInterpreter().adaptivePredict(_input, 32, _ctx);
                        }
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final WritehashstmtContext writehashstmt() throws RecognitionException {
        WritehashstmtContext _localctx = new WritehashstmtContext(_ctx, getState());
        enterRule(_localctx, 44, RULE_writehashstmt);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(968);
                match(WRITEHASH);
                setState(969);
                ((WritehashstmtContext) _localctx).filenum = expr(0);
                setState(970);
                match(COMMA);
                setState(971);
                expr(0);
                setState(976);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 34, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(972);
                                match(COMMA);
                                setState(973);
                                expr(0);
                            }
                        }
                    }
                    setState(978);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 34, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LetstmtContext letstmt() throws RecognitionException {
        LetstmtContext _localctx = new LetstmtContext(_ctx, getState());
        enterRule(_localctx, 46, RULE_letstmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(980);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LET) {
                    {
                        setState(979);
                        match(LET);
                    }
                }

                setState(982);
                variable();
                setState(983);
                match(RELEQ);
                setState(984);
                expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final AutoletstmtContext autoletstmt() throws RecognitionException {
        AutoletstmtContext _localctx = new AutoletstmtContext(_ctx, getState());
        enterRule(_localctx, 48, RULE_autoletstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(986);
                match(AUTO);
                setState(987);
                varname();
                setState(988);
                match(RELEQ);
                setState(989);
                expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final IfstmtContext ifstmt() throws RecognitionException {
        IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
        enterRule(_localctx, 50, RULE_ifstmt);
        int _la;
        try {
            _localctx = new IfThenElseContext(_localctx);
            enterOuterAlt(_localctx, 1);
            {
                setState(991);
                match(IF);
                setState(992);
                expr(0);
                setState(994);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COMMA) {
                    {
                        setState(993);
                        match(COMMA);
                    }
                }

                setState(996);
                then();
                setState(998);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 37, _ctx)) {
                    case 1: {
                        setState(997);
                        match(COMMA);
                    }
                    break;
                }
                setState(1002);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 38, _ctx)) {
                    case 1: {
                        setState(1000);
                        match(ELSE);
                        setState(1001);
                        elsestmt();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ThenContext then() throws RecognitionException {
        ThenContext _localctx = new ThenContext(_ctx, getState());
        enterRule(_localctx, 52, RULE_then);
        try {
            setState(1011);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case THEN:
                    enterOuterAlt(_localctx, 1);
                {
                    {
                        setState(1004);
                        match(THEN);
                        setState(1007);
                        _errHandler.sync(this);
                        switch (_input.LA(1)) {
                            case DECIMAL: {
                                setState(1005);
                                linenum();
                            }
                            break;
                            case LIST:
                            case DICT:
                            case SET:
                            case LOCATE:
                            case LET:
                            case AUTO:
                            case PRINT:
                            case PRINTHASH:
                            case IF:
                            case ELSE:
                            case GOTO:
                            case FOR:
                            case NEXT:
                            case FUNCTION:
                            case LIBTAG:
                            case IMPORT:
                            case END:
                            case SIN:
                            case COS:
                            case TAN:
                            case ATN:
                            case SQR:
                            case ABS:
                            case ASC:
                            case DEF:
                            case DIM:
                            case ALLOCARRAY:
                            case REALLOCARRAY:
                            case LTRIMDLR:
                            case RTRIMDLR:
                            case GOSUB:
                            case RETURN:
                            case LSET:
                            case RSET:
                            case CINT:
                            case CLNG:
                            case CSNG:
                            case CDBL:
                            case CHRDLR:
                            case WHILE:
                            case WEND:
                            case MKIDLR:
                            case MKLDLR:
                            case MKSDLR:
                            case MKDDLR:
                            case CVI:
                            case CVL:
                            case CVS:
                            case CVD:
                            case SPACEDLR:
                            case STRDLR:
                            case VAL:
                            case INT:
                            case FIX:
                            case LOG:
                            case LEN:
                            case RIGHTDLR:
                            case LEFTDLR:
                            case MIDDLR:
                            case INSTR:
                            case HEXDLR:
                            case OCTDLR:
                            case RND:
                            case SGN:
                            case TIMER:
                            case TIMERMILLIS:
                            case STRINGDLR:
                            case SWAP:
                            case OPEN:
                            case CLOSE:
                            case LINE:
                            case INPUT:
                            case INPUTHASH:
                            case INPUTDLR:
                            case RANDOMIZE:
                            case READ:
                            case WRITE:
                            case WRITEHASH:
                            case PUT:
                            case GET:
                            case EOFFN:
                            case LOC:
                            case LOF:
                            case FIELD:
                            case DATA:
                            case RESTORE:
                            case DEFINT:
                            case DEFLNG:
                            case DEFSNG:
                            case DEFDBL:
                            case DEFSTR:
                            case ENVIRONDLR:
                            case SCREEN:
                            case CIRCLE:
                            case SLEEP:
                            case COLOR:
                            case INKEYDLR:
                            case PAINT:
                            case PSET:
                            case DRAW:
                            case FONT:
                            case DRAWSTR:
                            case LOADIMG:
                            case SAVEIMG:
                            case LOADWAV:
                            case PLAYWAV:
                            case STOPWAV:
                            case LOOPWAV:
                            case CLS:
                            case BEEP:
                            case REPAINT:
                            case ASIN:
                            case ACOS:
                            case SINH:
                            case COSH:
                            case TANH:
                            case EULERE:
                            case PI:
                            case MIN:
                            case MAX:
                            case FLOOR:
                            case CEIL:
                            case ROUND:
                            case LOG10:
                            case LOG2:
                            case EXP:
                            case TORAD:
                            case TODEG:
                            case ARRAYFILL:
                            case ARRAY1DMIN:
                            case ARRAY1DMAX:
                            case ARRAY1DMEAN:
                            case ARRAY1DSUM:
                            case ARRAY1DSTD:
                            case ARRAY1DMEDIAN:
                            case ARRAY1DPCT:
                            case ARRAY1DSORT:
                            case ARRAY1DBINSEARCH:
                            case ARRAY2DFINDROW:
                            case ARRAY2DFINDCOLUMN:
                            case ARRAYCOPY:
                            case ARRAY1DCOPY:
                            case ARRAY2DSHIFTHOR:
                            case ARRAY2DSHIFTVER:
                            case HSB2RGB:
                            case LABEL:
                            case MOUSEMOVEDX:
                            case MOUSEMOVEDY:
                            case MOUSEDRAGGEDX:
                            case MOUSEDRAGGEDY:
                            case MOUSEBUTTONCLICKED:
                            case MOUSEBUTTONPRESSED:
                            case MOUSEBUTTONRELEASED:
                            case ISKEYPRESSED:
                            case BUFFERCOPYHOR:
                            case STRUCT:
                            case SPLITDLR:
                            case QUESTION:
                            case RBRACE:
                            case VARNAME: {
                                setState(1006);
                                stmtlist();
                            }
                            break;
                            default:
                                throw new NoViableAltException(this);
                        }
                    }
                }
                break;
                case GOTO:
                    enterOuterAlt(_localctx, 2);
                {
                    {
                        setState(1009);
                        match(GOTO);
                        setState(1010);
                        linenum();
                    }
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ElsestmtContext elsestmt() throws RecognitionException {
        ElsestmtContext _localctx = new ElsestmtContext(_ctx, getState());
        enterRule(_localctx, 54, RULE_elsestmt);
        try {
            setState(1015);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case DECIMAL:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1013);
                    linenum();
                }
                break;
                case LIST:
                case DICT:
                case SET:
                case LOCATE:
                case LET:
                case AUTO:
                case PRINT:
                case PRINTHASH:
                case IF:
                case ELSE:
                case GOTO:
                case FOR:
                case NEXT:
                case FUNCTION:
                case LIBTAG:
                case IMPORT:
                case END:
                case SIN:
                case COS:
                case TAN:
                case ATN:
                case SQR:
                case ABS:
                case ASC:
                case DEF:
                case DIM:
                case ALLOCARRAY:
                case REALLOCARRAY:
                case LTRIMDLR:
                case RTRIMDLR:
                case GOSUB:
                case RETURN:
                case LSET:
                case RSET:
                case CINT:
                case CLNG:
                case CSNG:
                case CDBL:
                case CHRDLR:
                case WHILE:
                case WEND:
                case MKIDLR:
                case MKLDLR:
                case MKSDLR:
                case MKDDLR:
                case CVI:
                case CVL:
                case CVS:
                case CVD:
                case SPACEDLR:
                case STRDLR:
                case VAL:
                case INT:
                case FIX:
                case LOG:
                case LEN:
                case RIGHTDLR:
                case LEFTDLR:
                case MIDDLR:
                case INSTR:
                case HEXDLR:
                case OCTDLR:
                case RND:
                case SGN:
                case TIMER:
                case TIMERMILLIS:
                case STRINGDLR:
                case SWAP:
                case OPEN:
                case CLOSE:
                case LINE:
                case INPUT:
                case INPUTHASH:
                case INPUTDLR:
                case RANDOMIZE:
                case READ:
                case WRITE:
                case WRITEHASH:
                case PUT:
                case GET:
                case EOFFN:
                case LOC:
                case LOF:
                case FIELD:
                case DATA:
                case RESTORE:
                case DEFINT:
                case DEFLNG:
                case DEFSNG:
                case DEFDBL:
                case DEFSTR:
                case ENVIRONDLR:
                case SCREEN:
                case CIRCLE:
                case SLEEP:
                case COLOR:
                case INKEYDLR:
                case PAINT:
                case PSET:
                case DRAW:
                case FONT:
                case DRAWSTR:
                case LOADIMG:
                case SAVEIMG:
                case LOADWAV:
                case PLAYWAV:
                case STOPWAV:
                case LOOPWAV:
                case CLS:
                case BEEP:
                case REPAINT:
                case ASIN:
                case ACOS:
                case SINH:
                case COSH:
                case TANH:
                case EULERE:
                case PI:
                case MIN:
                case MAX:
                case FLOOR:
                case CEIL:
                case ROUND:
                case LOG10:
                case LOG2:
                case EXP:
                case TORAD:
                case TODEG:
                case ARRAYFILL:
                case ARRAY1DMIN:
                case ARRAY1DMAX:
                case ARRAY1DMEAN:
                case ARRAY1DSUM:
                case ARRAY1DSTD:
                case ARRAY1DMEDIAN:
                case ARRAY1DPCT:
                case ARRAY1DSORT:
                case ARRAY1DBINSEARCH:
                case ARRAY2DFINDROW:
                case ARRAY2DFINDCOLUMN:
                case ARRAYCOPY:
                case ARRAY1DCOPY:
                case ARRAY2DSHIFTHOR:
                case ARRAY2DSHIFTVER:
                case HSB2RGB:
                case LABEL:
                case MOUSEMOVEDX:
                case MOUSEMOVEDY:
                case MOUSEDRAGGEDX:
                case MOUSEDRAGGEDY:
                case MOUSEBUTTONCLICKED:
                case MOUSEBUTTONPRESSED:
                case MOUSEBUTTONRELEASED:
                case ISKEYPRESSED:
                case BUFFERCOPYHOR:
                case STRUCT:
                case SPLITDLR:
                case QUESTION:
                case RBRACE:
                case VARNAME:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1014);
                    stmtlist();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final IfthenbeginstmtContext ifthenbeginstmt() throws RecognitionException {
        IfthenbeginstmtContext _localctx = new IfthenbeginstmtContext(_ctx, getState());
        enterRule(_localctx, 56, RULE_ifthenbeginstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1017);
                match(IF);
                setState(1018);
                expr(0);
                setState(1019);
                match(THEN);
                setState(1020);
                match(BEGIN);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ElsebeginstmtContext elsebeginstmt() throws RecognitionException {
        ElsebeginstmtContext _localctx = new ElsebeginstmtContext(_ctx, getState());
        enterRule(_localctx, 58, RULE_elsebeginstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1022);
                match(ELSE);
                setState(1023);
                match(BEGIN);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final EndifstmtContext endifstmt() throws RecognitionException {
        EndifstmtContext _localctx = new EndifstmtContext(_ctx, getState());
        enterRule(_localctx, 60, RULE_endifstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1025);
                match(END);
                setState(1026);
                match(IF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StmtlistContext stmtlist() throws RecognitionException {
        StmtlistContext _localctx = new StmtlistContext(_ctx, getState());
        enterRule(_localctx, 62, RULE_stmtlist);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1028);
                stmt();
                setState(1033);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 42, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1029);
                                match(T__0);
                                setState(1030);
                                stmt();
                            }
                        }
                    }
                    setState(1035);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 42, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ForstmtContext forstmt() throws RecognitionException {
        ForstmtContext _localctx = new ForstmtContext(_ctx, getState());
        enterRule(_localctx, 64, RULE_forstmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1036);
                match(FOR);
                setState(1037);
                variable();
                setState(1038);
                match(RELEQ);
                setState(1039);
                expr(0);
                setState(1040);
                match(TO);
                setState(1041);
                expr(0);
                setState(1044);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == STEP) {
                    {
                        setState(1042);
                        match(STEP);
                        setState(1043);
                        expr(0);
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final NextstmtContext nextstmt() throws RecognitionException {
        NextstmtContext _localctx = new NextstmtContext(_ctx, getState());
        enterRule(_localctx, 66, RULE_nextstmt);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1046);
                match(NEXT);
                setState(1048);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == VARNAME) {
                    {
                        setState(1047);
                        variable();
                    }
                }

                setState(1054);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 45, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1050);
                                match(COMMA);
                                setState(1051);
                                variable();
                            }
                        }
                    }
                    setState(1056);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 45, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final GotostmtContext gotostmt() throws RecognitionException {
        GotostmtContext _localctx = new GotostmtContext(_ctx, getState());
        enterRule(_localctx, 68, RULE_gotostmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1057);
                match(GOTO);
                setState(1058);
                linenum();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final GotolabelstmtContext gotolabelstmt() throws RecognitionException {
        GotolabelstmtContext _localctx = new GotolabelstmtContext(_ctx, getState());
        enterRule(_localctx, 70, RULE_gotolabelstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1060);
                match(GOTO);
                setState(1061);
                string();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final EndstmtContext endstmt() throws RecognitionException {
        EndstmtContext _localctx = new EndstmtContext(_ctx, getState());
        enterRule(_localctx, 72, RULE_endstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1063);
                match(END);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DeffnstmtContext deffnstmt() throws RecognitionException {
        DeffnstmtContext _localctx = new DeffnstmtContext(_ctx, getState());
        enterRule(_localctx, 74, RULE_deffnstmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1065);
                match(DEF);
                setState(1066);
                varname();
                setState(1068);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (((((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 31L) != 0)) {
                    {
                        setState(1067);
                        varsuffix();
                    }
                }

                setState(1082);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LPAREN) {
                    {
                        setState(1070);
                        match(LPAREN);
                        setState(1079);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == VARNAME) {
                            {
                                setState(1071);
                                variable();
                                setState(1076);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                                while (_la == COMMA) {
                                    {
                                        {
                                            setState(1072);
                                            match(COMMA);
                                            setState(1073);
                                            variable();
                                        }
                                    }
                                    setState(1078);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                }
                            }
                        }

                        setState(1081);
                        match(RPAREN);
                    }
                }

                setState(1084);
                match(RELEQ);
                setState(1085);
                expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FunctionbeginstmtContext functionbeginstmt() throws RecognitionException {
        FunctionbeginstmtContext _localctx = new FunctionbeginstmtContext(_ctx, getState());
        enterRule(_localctx, 76, RULE_functionbeginstmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1087);
                match(FUNCTION);
                setState(1088);
                ((FunctionbeginstmtContext) _localctx).fnname = varname();
                setState(1090);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (((((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 31L) != 0)) {
                    {
                        setState(1089);
                        ((FunctionbeginstmtContext) _localctx).fnrettype = varsuffix();
                    }
                }

                setState(1092);
                match(LPAREN);
                setState(1101);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 68719476792L) != 0) || _la == VARNAME) {
                    {
                        setState(1093);
                        compositetype();
                        setState(1098);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == COMMA) {
                            {
                                {
                                    setState(1094);
                                    match(COMMA);
                                    setState(1095);
                                    compositetype();
                                }
                            }
                            setState(1100);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }

                setState(1103);
                match(RPAREN);
                setState(1104);
                match(LBRACE);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FunctionreturnstmtContext functionreturnstmt() throws RecognitionException {
        FunctionreturnstmtContext _localctx = new FunctionreturnstmtContext(_ctx, getState());
        enterRule(_localctx, 78, RULE_functionreturnstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1106);
                match(RETURN);
                setState(1107);
                expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FunctionendstmtContext functionendstmt() throws RecognitionException {
        FunctionendstmtContext _localctx = new FunctionendstmtContext(_ctx, getState());
        enterRule(_localctx, 80, RULE_functionendstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1109);
                match(RBRACE);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ImportstmtContext importstmt() throws RecognitionException {
        ImportstmtContext _localctx = new ImportstmtContext(_ctx, getState());
        enterRule(_localctx, 82, RULE_importstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1111);
                match(IMPORT);
                setState(1112);
                ((ImportstmtContext) _localctx).filename = string();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LibtagstmtContext libtagstmt() throws RecognitionException {
        LibtagstmtContext _localctx = new LibtagstmtContext(_ctx, getState());
        enterRule(_localctx, 84, RULE_libtagstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1114);
                match(LIBTAG);
                setState(1115);
                ((LibtagstmtContext) _localctx).tag = string();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DimstmtContext dimstmt() throws RecognitionException {
        DimstmtContext _localctx = new DimstmtContext(_ctx, getState());
        enterRule(_localctx, 86, RULE_dimstmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1117);
                match(DIM);
                setState(1118);
                varname();
                setState(1120);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (((((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 31L) != 0)) {
                    {
                        setState(1119);
                        varsuffix();
                    }
                }

                setState(1122);
                match(LPAREN);
                setState(1123);
                expr(0);
                setState(1128);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(1124);
                            match(COMMA);
                            setState(1125);
                            expr(0);
                        }
                    }
                    setState(1130);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1131);
                match(RPAREN);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ReallocstmtContext reallocstmt() throws RecognitionException {
        ReallocstmtContext _localctx = new ReallocstmtContext(_ctx, getState());
        enterRule(_localctx, 88, RULE_reallocstmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1133);
                match(REALLOCARRAY);
                setState(1134);
                varname();
                setState(1136);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (((((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 31L) != 0)) {
                    {
                        setState(1135);
                        varsuffix();
                    }
                }

                setState(1138);
                match(LPAREN);
                setState(1139);
                expr(0);
                setState(1144);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(1140);
                            match(COMMA);
                            setState(1141);
                            expr(0);
                        }
                    }
                    setState(1146);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1147);
                match(RPAREN);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final WhilestmtContext whilestmt() throws RecognitionException {
        WhilestmtContext _localctx = new WhilestmtContext(_ctx, getState());
        enterRule(_localctx, 90, RULE_whilestmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1149);
                match(WHILE);
                setState(1150);
                expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final WendstmtContext wendstmt() throws RecognitionException {
        WendstmtContext _localctx = new WendstmtContext(_ctx, getState());
        enterRule(_localctx, 92, RULE_wendstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1152);
                match(WEND);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LsetstmtContext lsetstmt() throws RecognitionException {
        LsetstmtContext _localctx = new LsetstmtContext(_ctx, getState());
        enterRule(_localctx, 94, RULE_lsetstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1154);
                match(LSET);
                setState(1155);
                variable();
                setState(1156);
                match(RELEQ);
                setState(1157);
                expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final RsetstmtContext rsetstmt() throws RecognitionException {
        RsetstmtContext _localctx = new RsetstmtContext(_ctx, getState());
        enterRule(_localctx, 96, RULE_rsetstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1159);
                match(RSET);
                setState(1160);
                variable();
                setState(1161);
                match(RELEQ);
                setState(1162);
                expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final SwapstmtContext swapstmt() throws RecognitionException {
        SwapstmtContext _localctx = new SwapstmtContext(_ctx, getState());
        enterRule(_localctx, 98, RULE_swapstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1164);
                match(SWAP);
                setState(1165);
                variable();
                setState(1166);
                match(COMMA);
                setState(1167);
                variable();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Open1stmtContext open1stmt() throws RecognitionException {
        Open1stmtContext _localctx = new Open1stmtContext(_ctx, getState());
        enterRule(_localctx, 100, RULE_open1stmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1169);
                match(OPEN);
                setState(1170);
                filemode1();
                setState(1171);
                match(COMMA);
                setState(1173);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == HASH) {
                    {
                        setState(1172);
                        match(HASH);
                    }
                }

                setState(1175);
                ((Open1stmtContext) _localctx).filenum = match(DECIMAL);
                setState(1176);
                match(COMMA);
                setState(1177);
                ((Open1stmtContext) _localctx).filename = expr(0);
                setState(1180);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 58, _ctx)) {
                    case 1: {
                        setState(1178);
                        match(COMMA);
                        setState(1179);
                        ((Open1stmtContext) _localctx).reclen = expr(0);
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Open2stmtContext open2stmt() throws RecognitionException {
        Open2stmtContext _localctx = new Open2stmtContext(_ctx, getState());
        enterRule(_localctx, 102, RULE_open2stmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1182);
                match(OPEN);
                setState(1183);
                ((Open2stmtContext) _localctx).filename = expr(0);
                setState(1186);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == FOR) {
                    {
                        setState(1184);
                        match(FOR);
                        setState(1185);
                        filemode2();
                    }
                }

                setState(1190);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == ACCESS) {
                    {
                        setState(1188);
                        match(ACCESS);
                        setState(1189);
                        access();
                    }
                }

                setState(1193);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == SHARED || _la == LOCK) {
                    {
                        setState(1192);
                        lock();
                    }
                }

                setState(1195);
                match(AS);
                setState(1197);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == HASH) {
                    {
                        setState(1196);
                        match(HASH);
                    }
                }

                setState(1199);
                ((Open2stmtContext) _localctx).filenum = match(DECIMAL);
                setState(1203);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == LEN) {
                    {
                        setState(1200);
                        match(LEN);
                        setState(1201);
                        match(RELEQ);
                        setState(1202);
                        ((Open2stmtContext) _localctx).reclen = expr(0);
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ClosestmtContext closestmt() throws RecognitionException {
        ClosestmtContext _localctx = new ClosestmtContext(_ctx, getState());
        enterRule(_localctx, 104, RULE_closestmt);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1205);
                match(CLOSE);
                setState(1220);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == HASH || _la == DECIMAL) {
                    {
                        setState(1207);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == HASH) {
                            {
                                setState(1206);
                                match(HASH);
                            }
                        }

                        setState(1209);
                        match(DECIMAL);
                        setState(1217);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 66, _ctx);
                        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                            if (_alt == 1) {
                                {
                                    {
                                        setState(1210);
                                        match(COMMA);
                                        setState(1212);
                                        _errHandler.sync(this);
                                        _la = _input.LA(1);
                                        if (_la == HASH) {
                                            {
                                                setState(1211);
                                                match(HASH);
                                            }
                                        }

                                        setState(1214);
                                        match(DECIMAL);
                                    }
                                }
                            }
                            setState(1219);
                            _errHandler.sync(this);
                            _alt = getInterpreter().adaptivePredict(_input, 66, _ctx);
                        }
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Filemode1Context filemode1() throws RecognitionException {
        Filemode1Context _localctx = new Filemode1Context(_ctx, getState());
        enterRule(_localctx, 106, RULE_filemode1);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1222);
                match(STRING);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Filemode2Context filemode2() throws RecognitionException {
        Filemode2Context _localctx = new Filemode2Context(_ctx, getState());
        enterRule(_localctx, 108, RULE_filemode2);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1224);
                _la = _input.LA(1);
                if (!(((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & 57L) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final AccessContext access() throws RecognitionException {
        AccessContext _localctx = new AccessContext(_ctx, getState());
        enterRule(_localctx, 110, RULE_access);
        try {
            setState(1230);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 68, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1226);
                    match(READ);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1227);
                    match(WRITE);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1228);
                    match(READ);
                    setState(1229);
                    match(WRITE);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LockContext lock() throws RecognitionException {
        LockContext _localctx = new LockContext(_ctx, getState());
        enterRule(_localctx, 112, RULE_lock);
        try {
            setState(1240);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 69, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1232);
                    match(SHARED);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1233);
                    match(LOCK);
                    setState(1234);
                    match(READ);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1235);
                    match(LOCK);
                    setState(1236);
                    match(WRITE);
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(1237);
                    match(LOCK);
                    setState(1238);
                    match(READ);
                    setState(1239);
                    match(WRITE);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final PutstmtContext putstmt() throws RecognitionException {
        PutstmtContext _localctx = new PutstmtContext(_ctx, getState());
        enterRule(_localctx, 114, RULE_putstmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1242);
                match(PUT);
                setState(1244);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == HASH) {
                    {
                        setState(1243);
                        match(HASH);
                    }
                }

                setState(1246);
                ((PutstmtContext) _localctx).filenum = match(DECIMAL);
                setState(1249);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 71, _ctx)) {
                    case 1: {
                        setState(1247);
                        match(COMMA);
                        setState(1248);
                        expr(0);
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final GetstmtContext getstmt() throws RecognitionException {
        GetstmtContext _localctx = new GetstmtContext(_ctx, getState());
        enterRule(_localctx, 116, RULE_getstmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1251);
                match(GET);
                setState(1253);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == HASH) {
                    {
                        setState(1252);
                        match(HASH);
                    }
                }

                setState(1255);
                ((GetstmtContext) _localctx).filenum = match(DECIMAL);
                setState(1258);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 73, _ctx)) {
                    case 1: {
                        setState(1256);
                        match(COMMA);
                        setState(1257);
                        expr(0);
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FieldstmtContext fieldstmt() throws RecognitionException {
        FieldstmtContext _localctx = new FieldstmtContext(_ctx, getState());
        enterRule(_localctx, 118, RULE_fieldstmt);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1260);
                match(FIELD);
                setState(1262);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == HASH) {
                    {
                        setState(1261);
                        match(HASH);
                    }
                }

                setState(1264);
                ((FieldstmtContext) _localctx).filenum = expr(0);
                setState(1265);
                match(COMMA);
                setState(1266);
                match(DECIMAL);
                setState(1267);
                match(AS);
                setState(1268);
                variable();
                setState(1275);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 75, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1269);
                                match(COMMA);
                                setState(1270);
                                match(DECIMAL);
                                setState(1271);
                                match(AS);
                                setState(1272);
                                variable();
                            }
                        }
                    }
                    setState(1277);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 75, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final InputstmtContext inputstmt() throws RecognitionException {
        InputstmtContext _localctx = new InputstmtContext(_ctx, getState());
        enterRule(_localctx, 120, RULE_inputstmt);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1278);
                match(INPUT);
                setState(1280);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == SEMICOLON) {
                    {
                        setState(1279);
                        match(SEMICOLON);
                    }
                }

                {
                    setState(1282);
                    expr(0);
                    setState(1283);
                    _la = _input.LA(1);
                    if (!(_la == COMMA || _la == SEMICOLON)) {
                        _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                }
                setState(1285);
                variable();
                setState(1290);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 77, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1286);
                                match(COMMA);
                                setState(1287);
                                variable();
                            }
                        }
                    }
                    setState(1292);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 77, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final InputhashstmtContext inputhashstmt() throws RecognitionException {
        InputhashstmtContext _localctx = new InputhashstmtContext(_ctx, getState());
        enterRule(_localctx, 122, RULE_inputhashstmt);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1293);
                match(INPUTHASH);
                setState(1294);
                ((InputhashstmtContext) _localctx).filenum = expr(0);
                setState(1295);
                match(COMMA);
                setState(1296);
                variable();
                setState(1301);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 78, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1297);
                                match(COMMA);
                                setState(1298);
                                variable();
                            }
                        }
                    }
                    setState(1303);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 78, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LineinputstmtContext lineinputstmt() throws RecognitionException {
        LineinputstmtContext _localctx = new LineinputstmtContext(_ctx, getState());
        enterRule(_localctx, 124, RULE_lineinputstmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1304);
                match(LINE);
                setState(1305);
                match(INPUT);
                setState(1307);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == SEMICOLON) {
                    {
                        setState(1306);
                        match(SEMICOLON);
                    }
                }

                setState(1312);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 80, _ctx)) {
                    case 1: {
                        setState(1309);
                        expr(0);
                        setState(1310);
                        match(SEMICOLON);
                    }
                    break;
                }
                setState(1314);
                variable();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LineinputhashstmtContext lineinputhashstmt() throws RecognitionException {
        LineinputhashstmtContext _localctx = new LineinputhashstmtContext(_ctx, getState());
        enterRule(_localctx, 126, RULE_lineinputhashstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1316);
                match(LINE);
                setState(1317);
                match(INPUTHASH);
                setState(1318);
                ((LineinputhashstmtContext) _localctx).filenum = expr(0);
                setState(1319);
                match(COMMA);
                setState(1320);
                variable();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ReadstmtContext readstmt() throws RecognitionException {
        ReadstmtContext _localctx = new ReadstmtContext(_ctx, getState());
        enterRule(_localctx, 128, RULE_readstmt);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1322);
                match(READ);
                setState(1323);
                variable();
                setState(1328);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 81, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1324);
                                match(COMMA);
                                setState(1325);
                                variable();
                            }
                        }
                    }
                    setState(1330);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 81, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DatastmtContext datastmt() throws RecognitionException {
        DatastmtContext _localctx = new DatastmtContext(_ctx, getState());
        enterRule(_localctx, 130, RULE_datastmt);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1331);
                match(DATA);
                setState(1334);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case STRING: {
                        setState(1332);
                        ((DatastmtContext) _localctx).str = match(STRING);
                    }
                    break;
                    case DECIMAL:
                    case HEXADECIMAL:
                    case OCTAL:
                    case FLOAT:
                    case DOUBLE: {
                        setState(1333);
                        number();
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(1343);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 84, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1336);
                                match(COMMA);
                                setState(1339);
                                _errHandler.sync(this);
                                switch (_input.LA(1)) {
                                    case STRING: {
                                        setState(1337);
                                        ((DatastmtContext) _localctx).str = match(STRING);
                                    }
                                    break;
                                    case DECIMAL:
                                    case HEXADECIMAL:
                                    case OCTAL:
                                    case FLOAT:
                                    case DOUBLE: {
                                        setState(1338);
                                        number();
                                    }
                                    break;
                                    default:
                                        throw new NoViableAltException(this);
                                }
                            }
                        }
                    }
                    setState(1345);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 84, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final RestorestmtContext restorestmt() throws RecognitionException {
        RestorestmtContext _localctx = new RestorestmtContext(_ctx, getState());
        enterRule(_localctx, 132, RULE_restorestmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1346);
                match(RESTORE);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final RandomizestmtContext randomizestmt() throws RecognitionException {
        RandomizestmtContext _localctx = new RandomizestmtContext(_ctx, getState());
        enterRule(_localctx, 134, RULE_randomizestmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1348);
                match(RANDOMIZE);
                setState(1349);
                expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final RandomizetimerstmtContext randomizetimerstmt() throws RecognitionException {
        RandomizetimerstmtContext _localctx = new RandomizetimerstmtContext(_ctx, getState());
        enterRule(_localctx, 136, RULE_randomizetimerstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1351);
                match(RANDOMIZE);
                setState(1352);
                match(TIMER);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DefintstmtContext defintstmt() throws RecognitionException {
        DefintstmtContext _localctx = new DefintstmtContext(_ctx, getState());
        enterRule(_localctx, 138, RULE_defintstmt);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1354);
                match(DEFINT);
                setState(1355);
                match(LETTERRANGE);
                setState(1360);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 85, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1356);
                                match(COMMA);
                                setState(1357);
                                match(LETTERRANGE);
                            }
                        }
                    }
                    setState(1362);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 85, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DeflngstmtContext deflngstmt() throws RecognitionException {
        DeflngstmtContext _localctx = new DeflngstmtContext(_ctx, getState());
        enterRule(_localctx, 140, RULE_deflngstmt);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1363);
                match(DEFLNG);
                setState(1364);
                match(LETTERRANGE);
                setState(1369);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 86, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1365);
                                match(COMMA);
                                setState(1366);
                                match(LETTERRANGE);
                            }
                        }
                    }
                    setState(1371);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 86, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DefsngstmtContext defsngstmt() throws RecognitionException {
        DefsngstmtContext _localctx = new DefsngstmtContext(_ctx, getState());
        enterRule(_localctx, 142, RULE_defsngstmt);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1372);
                match(DEFSNG);
                setState(1373);
                match(LETTERRANGE);
                setState(1378);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 87, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1374);
                                match(COMMA);
                                setState(1375);
                                match(LETTERRANGE);
                            }
                        }
                    }
                    setState(1380);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 87, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DefdblstmtContext defdblstmt() throws RecognitionException {
        DefdblstmtContext _localctx = new DefdblstmtContext(_ctx, getState());
        enterRule(_localctx, 144, RULE_defdblstmt);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1381);
                match(DEFDBL);
                setState(1382);
                match(LETTERRANGE);
                setState(1387);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 88, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1383);
                                match(COMMA);
                                setState(1384);
                                match(LETTERRANGE);
                            }
                        }
                    }
                    setState(1389);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 88, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DefstrstmtContext defstrstmt() throws RecognitionException {
        DefstrstmtContext _localctx = new DefstrstmtContext(_ctx, getState());
        enterRule(_localctx, 146, RULE_defstrstmt);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1390);
                match(DEFSTR);
                setState(1391);
                match(LETTERRANGE);
                setState(1396);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 89, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1392);
                                match(COMMA);
                                setState(1393);
                                match(LETTERRANGE);
                            }
                        }
                    }
                    setState(1398);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 89, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final MiddlrstmtContext middlrstmt() throws RecognitionException {
        MiddlrstmtContext _localctx = new MiddlrstmtContext(_ctx, getState());
        enterRule(_localctx, 148, RULE_middlrstmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1399);
                match(MIDDLR);
                setState(1400);
                match(LPAREN);
                setState(1401);
                variable();
                setState(1402);
                match(COMMA);
                setState(1403);
                expr(0);
                setState(1406);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COMMA) {
                    {
                        setState(1404);
                        match(COMMA);
                        setState(1405);
                        expr(0);
                    }
                }

                setState(1408);
                match(RPAREN);
                setState(1409);
                match(RELEQ);
                setState(1410);
                expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final SleepstmtContext sleepstmt() throws RecognitionException {
        SleepstmtContext _localctx = new SleepstmtContext(_ctx, getState());
        enterRule(_localctx, 150, RULE_sleepstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1412);
                match(SLEEP);
                setState(1413);
                expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ScreenstmtContext screenstmt() throws RecognitionException {
        ScreenstmtContext _localctx = new ScreenstmtContext(_ctx, getState());
        enterRule(_localctx, 152, RULE_screenstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1415);
                match(SCREEN);
                setState(1416);
                ((ScreenstmtContext) _localctx).title = expr(0);
                setState(1417);
                match(COMMA);
                setState(1418);
                ((ScreenstmtContext) _localctx).w = expr(0);
                setState(1419);
                match(COMMA);
                setState(1420);
                ((ScreenstmtContext) _localctx).h = expr(0);
                setState(1426);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 91, _ctx)) {
                    case 1: {
                        setState(1421);
                        match(COMMA);
                        setState(1422);
                        ((ScreenstmtContext) _localctx).iw = expr(0);
                        setState(1423);
                        match(COMMA);
                        setState(1424);
                        ((ScreenstmtContext) _localctx).ih = expr(0);
                    }
                    break;
                }
                setState(1430);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 92, _ctx)) {
                    case 1: {
                        setState(1428);
                        match(COMMA);
                        setState(1429);
                        ((ScreenstmtContext) _localctx).mr = match(MANUAL_REPAINT);
                    }
                    break;
                }
                setState(1434);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 93, _ctx)) {
                    case 1: {
                        setState(1432);
                        match(COMMA);
                        setState(1433);
                        ((ScreenstmtContext) _localctx).db = match(DOUBLE_BUFFER);
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final RepaintstmtContext repaintstmt() throws RecognitionException {
        RepaintstmtContext _localctx = new RepaintstmtContext(_ctx, getState());
        enterRule(_localctx, 154, RULE_repaintstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1436);
                match(REPAINT);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final CirclestmtContext circlestmt() throws RecognitionException {
        CirclestmtContext _localctx = new CirclestmtContext(_ctx, getState());
        enterRule(_localctx, 156, RULE_circlestmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1438);
                match(CIRCLE);
                setState(1439);
                match(LPAREN);
                setState(1440);
                ((CirclestmtContext) _localctx).x = expr(0);
                setState(1441);
                match(COMMA);
                setState(1442);
                ((CirclestmtContext) _localctx).y = expr(0);
                setState(1443);
                match(RPAREN);
                setState(1444);
                match(COMMA);
                setState(1445);
                ((CirclestmtContext) _localctx).r1 = expr(0);
                setState(1446);
                match(COMMA);
                setState(1447);
                ((CirclestmtContext) _localctx).r2 = expr(0);
                setState(1462);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 98, _ctx)) {
                    case 1: {
                        setState(1448);
                        match(COMMA);
                        setState(1450);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (((((_la - 28)) & ~0x3f) == 0 && ((1L << (_la - 28)) & 289356276045847167L) != 0) || ((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & -1160802812544612345L) != 0) || ((((_la - 166)) & ~0x3f) == 0 && ((1L << (_la - 166)) & 286550323458312185L) != 0)) {
                            {
                                setState(1449);
                                ((CirclestmtContext) _localctx).s = expr(0);
                            }
                        }

                        setState(1452);
                        match(COMMA);
                        setState(1454);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 95, _ctx)) {
                            case 1: {
                                setState(1453);
                                ((CirclestmtContext) _localctx).e = expr(0);
                            }
                            break;
                        }
                        setState(1457);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 96, _ctx)) {
                            case 1: {
                                setState(1456);
                                match(COMMA);
                            }
                            break;
                        }
                        setState(1460);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (((((_la - 28)) & ~0x3f) == 0 && ((1L << (_la - 28)) & 289356276045847167L) != 0) || ((((_la - 98)) & ~0x3f) == 0 && ((1L << (_la - 98)) & -1160802812544612345L) != 0) || ((((_la - 166)) & ~0x3f) == 0 && ((1L << (_la - 166)) & 286550323458312185L) != 0)) {
                            {
                                setState(1459);
                                ((CirclestmtContext) _localctx).fill = expr(0);
                            }
                        }

                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LinestmtContext linestmt() throws RecognitionException {
        LinestmtContext _localctx = new LinestmtContext(_ctx, getState());
        enterRule(_localctx, 158, RULE_linestmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1464);
                match(LINE);
                setState(1465);
                match(LPAREN);
                setState(1466);
                ((LinestmtContext) _localctx).x1 = expr(0);
                setState(1467);
                match(COMMA);
                setState(1468);
                ((LinestmtContext) _localctx).y1 = expr(0);
                setState(1469);
                match(RPAREN);
                setState(1470);
                match(MINUS);
                setState(1471);
                match(LPAREN);
                setState(1472);
                ((LinestmtContext) _localctx).x2 = expr(0);
                setState(1473);
                match(COMMA);
                setState(1474);
                ((LinestmtContext) _localctx).y2 = expr(0);
                setState(1475);
                match(RPAREN);
                setState(1478);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 99, _ctx)) {
                    case 1: {
                        setState(1476);
                        match(COMMA);
                        setState(1477);
                        ((LinestmtContext) _localctx).bf = expr(0);
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ColorstmtContext colorstmt() throws RecognitionException {
        ColorstmtContext _localctx = new ColorstmtContext(_ctx, getState());
        enterRule(_localctx, 160, RULE_colorstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1480);
                match(COLOR);
                setState(1481);
                ((ColorstmtContext) _localctx).r = expr(0);
                setState(1482);
                match(COMMA);
                setState(1483);
                ((ColorstmtContext) _localctx).g = expr(0);
                setState(1484);
                match(COMMA);
                setState(1485);
                ((ColorstmtContext) _localctx).b = expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final PaintstmtContext paintstmt() throws RecognitionException {
        PaintstmtContext _localctx = new PaintstmtContext(_ctx, getState());
        enterRule(_localctx, 162, RULE_paintstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1487);
                match(PAINT);
                setState(1488);
                match(LPAREN);
                setState(1489);
                ((PaintstmtContext) _localctx).x = expr(0);
                setState(1490);
                match(COMMA);
                setState(1491);
                ((PaintstmtContext) _localctx).y = expr(0);
                setState(1492);
                match(RPAREN);
                setState(1493);
                match(COMMA);
                setState(1494);
                ((PaintstmtContext) _localctx).r = expr(0);
                setState(1495);
                match(COMMA);
                setState(1496);
                ((PaintstmtContext) _localctx).g = expr(0);
                setState(1497);
                match(COMMA);
                setState(1498);
                ((PaintstmtContext) _localctx).b = expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final PsetstmtContext psetstmt() throws RecognitionException {
        PsetstmtContext _localctx = new PsetstmtContext(_ctx, getState());
        enterRule(_localctx, 164, RULE_psetstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1500);
                match(PSET);
                setState(1501);
                match(LPAREN);
                setState(1502);
                ((PsetstmtContext) _localctx).x = expr(0);
                setState(1503);
                match(COMMA);
                setState(1504);
                ((PsetstmtContext) _localctx).y = expr(0);
                setState(1505);
                match(RPAREN);
                setState(1513);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 100, _ctx)) {
                    case 1: {
                        setState(1506);
                        match(COMMA);
                        setState(1507);
                        ((PsetstmtContext) _localctx).r = expr(0);
                        setState(1508);
                        match(COMMA);
                        setState(1509);
                        ((PsetstmtContext) _localctx).g = expr(0);
                        setState(1510);
                        match(COMMA);
                        setState(1511);
                        ((PsetstmtContext) _localctx).b = expr(0);
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DrawstmtContext drawstmt() throws RecognitionException {
        DrawstmtContext _localctx = new DrawstmtContext(_ctx, getState());
        enterRule(_localctx, 166, RULE_drawstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1515);
                match(DRAW);
                setState(1516);
                expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final GraphicsgetstmtContext graphicsgetstmt() throws RecognitionException {
        GraphicsgetstmtContext _localctx = new GraphicsgetstmtContext(_ctx, getState());
        enterRule(_localctx, 168, RULE_graphicsgetstmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1518);
                match(GET);
                setState(1519);
                match(LPAREN);
                setState(1520);
                ((GraphicsgetstmtContext) _localctx).x1 = expr(0);
                setState(1521);
                match(COMMA);
                setState(1522);
                ((GraphicsgetstmtContext) _localctx).y1 = expr(0);
                setState(1523);
                match(RPAREN);
                setState(1524);
                match(MINUS);
                setState(1525);
                match(LPAREN);
                setState(1526);
                ((GraphicsgetstmtContext) _localctx).x2 = expr(0);
                setState(1527);
                match(COMMA);
                setState(1528);
                ((GraphicsgetstmtContext) _localctx).y2 = expr(0);
                setState(1529);
                match(RPAREN);
                setState(1530);
                match(COMMA);
                setState(1531);
                variable();
                setState(1534);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 101, _ctx)) {
                    case 1: {
                        setState(1532);
                        match(COMMA);
                        setState(1533);
                        ((GraphicsgetstmtContext) _localctx).buffer = _input.LT(1);
                        _la = _input.LA(1);
                        if (!(_la == FRONT || _la == BACK1)) {
                            ((GraphicsgetstmtContext) _localctx).buffer = (Token) _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final GraphicsputstmtContext graphicsputstmt() throws RecognitionException {
        GraphicsputstmtContext _localctx = new GraphicsputstmtContext(_ctx, getState());
        enterRule(_localctx, 170, RULE_graphicsputstmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1536);
                match(PUT);
                setState(1537);
                match(LPAREN);
                setState(1538);
                ((GraphicsputstmtContext) _localctx).x = expr(0);
                setState(1539);
                match(COMMA);
                setState(1540);
                ((GraphicsputstmtContext) _localctx).y = expr(0);
                setState(1541);
                match(RPAREN);
                setState(1542);
                match(COMMA);
                setState(1543);
                variable();
                setState(1546);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 102, _ctx)) {
                    case 1: {
                        setState(1544);
                        match(COMMA);
                        setState(1545);
                        ((GraphicsputstmtContext) _localctx).action = expr(0);
                    }
                    break;
                }
                setState(1550);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 103, _ctx)) {
                    case 1: {
                        setState(1548);
                        match(COMMA);
                        setState(1549);
                        ((GraphicsputstmtContext) _localctx).buffer = _input.LT(1);
                        _la = _input.LA(1);
                        if (!(_la == FRONT || _la == BACK1)) {
                            ((GraphicsputstmtContext) _localctx).buffer = (Token) _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final GraphicsbuffercopyhorstmtContext graphicsbuffercopyhorstmt() throws RecognitionException {
        GraphicsbuffercopyhorstmtContext _localctx = new GraphicsbuffercopyhorstmtContext(_ctx, getState());
        enterRule(_localctx, 172, RULE_graphicsbuffercopyhorstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1552);
                match(BUFFERCOPYHOR);
                setState(1553);
                ((GraphicsbuffercopyhorstmtContext) _localctx).srcx = expr(0);
                setState(1554);
                match(EQGT);
                setState(1555);
                ((GraphicsbuffercopyhorstmtContext) _localctx).dstx = expr(0);
                setState(1556);
                match(COMMA);
                setState(1557);
                ((GraphicsbuffercopyhorstmtContext) _localctx).w = expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FontstmtContext fontstmt() throws RecognitionException {
        FontstmtContext _localctx = new FontstmtContext(_ctx, getState());
        enterRule(_localctx, 174, RULE_fontstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1559);
                match(FONT);
                setState(1560);
                ((FontstmtContext) _localctx).name = expr(0);
                setState(1561);
                match(COMMA);
                setState(1562);
                ((FontstmtContext) _localctx).style = expr(0);
                setState(1563);
                match(COMMA);
                setState(1564);
                ((FontstmtContext) _localctx).size = expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DrawstrstmtContext drawstrstmt() throws RecognitionException {
        DrawstrstmtContext _localctx = new DrawstrstmtContext(_ctx, getState());
        enterRule(_localctx, 176, RULE_drawstrstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1566);
                match(DRAWSTR);
                setState(1567);
                ((DrawstrstmtContext) _localctx).str = expr(0);
                setState(1568);
                match(COMMA);
                setState(1569);
                ((DrawstrstmtContext) _localctx).x = expr(0);
                setState(1570);
                match(COMMA);
                setState(1571);
                ((DrawstrstmtContext) _localctx).y = expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LoadimgstmtContext loadimgstmt() throws RecognitionException {
        LoadimgstmtContext _localctx = new LoadimgstmtContext(_ctx, getState());
        enterRule(_localctx, 178, RULE_loadimgstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1573);
                match(LOADIMG);
                setState(1574);
                ((LoadimgstmtContext) _localctx).path = expr(0);
                setState(1575);
                match(COMMA);
                setState(1576);
                variable();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final SaveimgstmtContext saveimgstmt() throws RecognitionException {
        SaveimgstmtContext _localctx = new SaveimgstmtContext(_ctx, getState());
        enterRule(_localctx, 180, RULE_saveimgstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1578);
                match(SAVEIMG);
                setState(1579);
                ((SaveimgstmtContext) _localctx).path = expr(0);
                setState(1580);
                match(COMMA);
                setState(1581);
                variable();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LocatestmtContext locatestmt() throws RecognitionException {
        LocatestmtContext _localctx = new LocatestmtContext(_ctx, getState());
        enterRule(_localctx, 182, RULE_locatestmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1583);
                match(LOCATE);
                setState(1584);
                ((LocatestmtContext) _localctx).row = expr(0);
                setState(1587);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 104, _ctx)) {
                    case 1: {
                        setState(1585);
                        match(COMMA);
                        setState(1586);
                        ((LocatestmtContext) _localctx).col = expr(0);
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ClsstmtContext clsstmt() throws RecognitionException {
        ClsstmtContext _localctx = new ClsstmtContext(_ctx, getState());
        enterRule(_localctx, 184, RULE_clsstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1589);
                match(CLS);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final BeepstmtContext beepstmt() throws RecognitionException {
        BeepstmtContext _localctx = new BeepstmtContext(_ctx, getState());
        enterRule(_localctx, 186, RULE_beepstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1591);
                match(BEEP);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ArrayfillstmtContext arrayfillstmt() throws RecognitionException {
        ArrayfillstmtContext _localctx = new ArrayfillstmtContext(_ctx, getState());
        enterRule(_localctx, 188, RULE_arrayfillstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1593);
                match(ARRAYFILL);
                setState(1594);
                variable();
                setState(1595);
                match(COMMA);
                setState(1596);
                expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ArraycopystmtContext arraycopystmt() throws RecognitionException {
        ArraycopystmtContext _localctx = new ArraycopystmtContext(_ctx, getState());
        enterRule(_localctx, 190, RULE_arraycopystmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1598);
                match(ARRAYCOPY);
                setState(1599);
                ((ArraycopystmtContext) _localctx).src = variable();
                setState(1600);
                match(COMMA);
                setState(1601);
                ((ArraycopystmtContext) _localctx).dst = variable();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Array1dsortstmtContext array1dsortstmt() throws RecognitionException {
        Array1dsortstmtContext _localctx = new Array1dsortstmtContext(_ctx, getState());
        enterRule(_localctx, 192, RULE_array1dsortstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1603);
                match(ARRAY1DSORT);
                setState(1604);
                variable();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Array1dcopystmtContext array1dcopystmt() throws RecognitionException {
        Array1dcopystmtContext _localctx = new Array1dcopystmtContext(_ctx, getState());
        enterRule(_localctx, 194, RULE_array1dcopystmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1606);
                match(ARRAY1DCOPY);
                setState(1607);
                ((Array1dcopystmtContext) _localctx).src = variable();
                setState(1608);
                match(COMMA);
                setState(1609);
                ((Array1dcopystmtContext) _localctx).src0 = expr(0);
                setState(1610);
                match(COMMA);
                setState(1611);
                ((Array1dcopystmtContext) _localctx).dst = variable();
                setState(1612);
                match(COMMA);
                setState(1613);
                ((Array1dcopystmtContext) _localctx).dst0 = expr(0);
                setState(1614);
                match(COMMA);
                setState(1615);
                ((Array1dcopystmtContext) _localctx).len = expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Array2dshifthorstmtContext array2dshifthorstmt() throws RecognitionException {
        Array2dshifthorstmtContext _localctx = new Array2dshifthorstmtContext(_ctx, getState());
        enterRule(_localctx, 196, RULE_array2dshifthorstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1617);
                match(ARRAY2DSHIFTHOR);
                setState(1618);
                variable();
                setState(1619);
                match(COMMA);
                setState(1620);
                ((Array2dshifthorstmtContext) _localctx).step = expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Array2dshiftverstmtContext array2dshiftverstmt() throws RecognitionException {
        Array2dshiftverstmtContext _localctx = new Array2dshiftverstmtContext(_ctx, getState());
        enterRule(_localctx, 198, RULE_array2dshiftverstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1622);
                match(ARRAY2DSHIFTVER);
                setState(1623);
                variable();
                setState(1624);
                match(COMMA);
                setState(1625);
                ((Array2dshiftverstmtContext) _localctx).step = expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LoadwavstmtContext loadwavstmt() throws RecognitionException {
        LoadwavstmtContext _localctx = new LoadwavstmtContext(_ctx, getState());
        enterRule(_localctx, 200, RULE_loadwavstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1627);
                match(LOADWAV);
                setState(1628);
                ((LoadwavstmtContext) _localctx).path = expr(0);
                setState(1629);
                match(COMMA);
                setState(1630);
                variable();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final PlaywavstmtContext playwavstmt() throws RecognitionException {
        PlaywavstmtContext _localctx = new PlaywavstmtContext(_ctx, getState());
        enterRule(_localctx, 202, RULE_playwavstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1632);
                match(PLAYWAV);
                setState(1633);
                variable();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StopwavstmtContext stopwavstmt() throws RecognitionException {
        StopwavstmtContext _localctx = new StopwavstmtContext(_ctx, getState());
        enterRule(_localctx, 204, RULE_stopwavstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1635);
                match(STOPWAV);
                setState(1636);
                variable();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LoopwavstmtContext loopwavstmt() throws RecognitionException {
        LoopwavstmtContext _localctx = new LoopwavstmtContext(_ctx, getState());
        enterRule(_localctx, 206, RULE_loopwavstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1638);
                match(LOOPWAV);
                setState(1639);
                variable();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LabelstmtContext labelstmt() throws RecognitionException {
        LabelstmtContext _localctx = new LabelstmtContext(_ctx, getState());
        enterRule(_localctx, 208, RULE_labelstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1641);
                match(LABEL);
                setState(1642);
                ((LabelstmtContext) _localctx).name = string();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ListstmtContext liststmt() throws RecognitionException {
        ListstmtContext _localctx = new ListstmtContext(_ctx, getState());
        enterRule(_localctx, 210, RULE_liststmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1644);
                match(LIST);
                setState(1645);
                match(RELLT);
                setState(1650);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case VARNAME: {
                        setState(1646);
                        ((ListstmtContext) _localctx).typename = varname();
                    }
                    break;
                    case AT:
                    case DOLLAR:
                    case PERCENT:
                    case EXCLAMATION:
                    case HASH: {
                        setState(1647);
                        ((ListstmtContext) _localctx).typesuffix = varsuffix();
                    }
                    break;
                    case DIM: {
                        setState(1648);
                        match(DIM);
                        setState(1649);
                        ((ListstmtContext) _localctx).dimtypesuffix = varsuffix();
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(1652);
                match(RELGT);
                setState(1653);
                ((ListstmtContext) _localctx).listname = varname();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DictstmtContext dictstmt() throws RecognitionException {
        DictstmtContext _localctx = new DictstmtContext(_ctx, getState());
        enterRule(_localctx, 212, RULE_dictstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1655);
                match(DICT);
                setState(1656);
                match(RELLT);
                {
                    setState(1657);
                    ((DictstmtContext) _localctx).dictk1 = varsuffix();
                }
                setState(1658);
                match(COMMA);
                setState(1661);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case VARNAME: {
                        setState(1659);
                        ((DictstmtContext) _localctx).dictv1 = varname();
                    }
                    break;
                    case AT:
                    case DOLLAR:
                    case PERCENT:
                    case EXCLAMATION:
                    case HASH: {
                        setState(1660);
                        ((DictstmtContext) _localctx).dictv2 = varsuffix();
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(1663);
                match(RELGT);
                setState(1664);
                ((DictstmtContext) _localctx).dictname = varname();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final SetstmtContext setstmt() throws RecognitionException {
        SetstmtContext _localctx = new SetstmtContext(_ctx, getState());
        enterRule(_localctx, 214, RULE_setstmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1666);
                match(SET);
                setState(1667);
                match(RELLT);
                {
                    setState(1668);
                    ((SetstmtContext) _localctx).typesuffix = varsuffix();
                }
                setState(1669);
                match(RELGT);
                setState(1670);
                ((SetstmtContext) _localctx).setname = varname();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StructstmtContext structstmt() throws RecognitionException {
        StructstmtContext _localctx = new StructstmtContext(_ctx, getState());
        enterRule(_localctx, 216, RULE_structstmt);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1672);
                match(STRUCT);
                setState(1673);
                ((StructstmtContext) _localctx).structname = varname();
                setState(1674);
                match(LBRACE);
                setState(1675);
                compositetype();
                setState(1680);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(1676);
                            match(COMMA);
                            setState(1677);
                            compositetype();
                        }
                    }
                    setState(1682);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1683);
                match(RBRACE);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final CompositetypeContext compositetype() throws RecognitionException {
        CompositetypeContext _localctx = new CompositetypeContext(_ctx, getState());
        enterRule(_localctx, 218, RULE_compositetype);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1739);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 114, _ctx)) {
                    case 1: {
                        setState(1685);
                        ((CompositetypeContext) _localctx).var1 = varname();
                        setState(1687);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (((((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 31L) != 0)) {
                            {
                                setState(1686);
                                ((CompositetypeContext) _localctx).var2 = varsuffix();
                            }
                        }

                    }
                    break;
                    case 2: {
                        setState(1689);
                        match(DIM);
                        setState(1690);
                        ((CompositetypeContext) _localctx).elem = varname();
                        setState(1692);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (((((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 31L) != 0)) {
                            {
                                setState(1691);
                                ((CompositetypeContext) _localctx).elemsuffix = varsuffix();
                            }
                        }

                        setState(1694);
                        match(LPAREN);
                        setState(1695);
                        ((CompositetypeContext) _localctx).dim = match(DECIMAL);
                        setState(1700);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == COMMA) {
                            {
                                {
                                    setState(1696);
                                    match(COMMA);
                                    setState(1697);
                                    ((CompositetypeContext) _localctx).dim = match(DECIMAL);
                                }
                            }
                            setState(1702);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                        setState(1703);
                        match(RPAREN);
                    }
                    break;
                    case 3: {
                        setState(1705);
                        ((CompositetypeContext) _localctx).struct1 = varname();
                        setState(1706);
                        ((CompositetypeContext) _localctx).elem = varname();
                    }
                    break;
                    case 4: {
                        setState(1708);
                        match(LIST);
                        setState(1709);
                        match(RELLT);
                        setState(1714);
                        _errHandler.sync(this);
                        switch (_input.LA(1)) {
                            case VARNAME: {
                                setState(1710);
                                ((CompositetypeContext) _localctx).list1 = varname();
                            }
                            break;
                            case AT:
                            case DOLLAR:
                            case PERCENT:
                            case EXCLAMATION:
                            case HASH: {
                                setState(1711);
                                ((CompositetypeContext) _localctx).list2 = varsuffix();
                            }
                            break;
                            case DIM: {
                                setState(1712);
                                match(DIM);
                                setState(1713);
                                ((CompositetypeContext) _localctx).list3 = varsuffix();
                            }
                            break;
                            default:
                                throw new NoViableAltException(this);
                        }
                        setState(1716);
                        match(RELGT);
                        setState(1717);
                        ((CompositetypeContext) _localctx).elem = varname();
                    }
                    break;
                    case 5: {
                        setState(1719);
                        match(SET);
                        setState(1720);
                        match(RELLT);
                        setState(1723);
                        _errHandler.sync(this);
                        switch (_input.LA(1)) {
                            case VARNAME: {
                                setState(1721);
                                ((CompositetypeContext) _localctx).set1 = varname();
                            }
                            break;
                            case AT:
                            case DOLLAR:
                            case PERCENT:
                            case EXCLAMATION:
                            case HASH: {
                                setState(1722);
                                ((CompositetypeContext) _localctx).set2 = varsuffix();
                            }
                            break;
                            default:
                                throw new NoViableAltException(this);
                        }
                        setState(1725);
                        match(RELGT);
                        setState(1726);
                        ((CompositetypeContext) _localctx).elem = varname();
                    }
                    break;
                    case 6: {
                        setState(1728);
                        match(DICT);
                        setState(1729);
                        match(RELLT);
                        {
                            setState(1730);
                            ((CompositetypeContext) _localctx).dictk1 = varsuffix();
                        }
                        setState(1731);
                        match(COMMA);
                        setState(1734);
                        _errHandler.sync(this);
                        switch (_input.LA(1)) {
                            case VARNAME: {
                                setState(1732);
                                ((CompositetypeContext) _localctx).dictv1 = varname();
                            }
                            break;
                            case AT:
                            case DOLLAR:
                            case PERCENT:
                            case EXCLAMATION:
                            case HASH: {
                                setState(1733);
                                ((CompositetypeContext) _localctx).dictv2 = varsuffix();
                            }
                            break;
                            default:
                                throw new NoViableAltException(this);
                        }
                        setState(1736);
                        match(RELGT);
                        setState(1737);
                        ((CompositetypeContext) _localctx).elem = varname();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StructinstancestmtContext structinstancestmt() throws RecognitionException {
        StructinstancestmtContext _localctx = new StructinstancestmtContext(_ctx, getState());
        enterRule(_localctx, 220, RULE_structinstancestmt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1741);
                varname();
                setState(1742);
                varname();
                setState(1743);
                match(LBRACE);
                setState(1744);
                match(RBRACE);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StringContext string() throws RecognitionException {
        StringContext _localctx = new StringContext(_ctx, getState());
        enterRule(_localctx, 222, RULE_string);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1746);
                match(STRING);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final NumberContext number() throws RecognitionException {
        NumberContext _localctx = new NumberContext(_ctx, getState());
        enterRule(_localctx, 224, RULE_number);
        try {
            setState(1751);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case DECIMAL:
                case HEXADECIMAL:
                case OCTAL:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1748);
                    integer();
                }
                break;
                case FLOAT:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1749);
                    match(FLOAT);
                }
                break;
                case DOUBLE:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1750);
                    match(DOUBLE);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final IntegerContext integer() throws RecognitionException {
        IntegerContext _localctx = new IntegerContext(_ctx, getState());
        enterRule(_localctx, 226, RULE_integer);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1753);
                _la = _input.LA(1);
                if (!(((((_la - 219)) & ~0x3f) == 0 && ((1L << (_la - 219)) & 7L) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(1755);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 116, _ctx)) {
                    case 1: {
                        setState(1754);
                        _la = _input.LA(1);
                        if (!(((((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 29L) != 0))) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 10:
                return expr_sempred((ExprContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean expr_sempred(ExprContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 8);
            case 1:
                return precpred(_ctx, 7);
            case 2:
                return precpred(_ctx, 6);
            case 3:
                return precpred(_ctx, 5);
            case 4:
                return precpred(_ctx, 4);
            case 5:
                return precpred(_ctx, 2);
            case 6:
                return precpred(_ctx, 1);
        }
        return true;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ProgContext extends ParserRuleContext {
        public ProgContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<LineContext> line() {
            return getRuleContexts(LineContext.class);
        }

        public LineContext line(int i) {
            return getRuleContext(LineContext.class, i);
        }

        public List<TerminalNode> NEWLINE() {
            return getTokens(PuffinBasicParser.NEWLINE);
        }

        public TerminalNode NEWLINE(int i) {
            return getToken(PuffinBasicParser.NEWLINE, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prog;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterProg(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitProg(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LineContext extends ParserRuleContext {
        public LineContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode NEWLINE() {
            return getToken(PuffinBasicParser.NEWLINE, 0);
        }

        public LinenumContext linenum() {
            return getRuleContext(LinenumContext.class, 0);
        }

        public StmtlistContext stmtlist() {
            return getRuleContext(StmtlistContext.class, 0);
        }

        public CommentContext comment() {
            return getRuleContext(CommentContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_line;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterLine(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitLine(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LinenumContext extends ParserRuleContext {
        public LinenumContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DECIMAL() {
            return getToken(PuffinBasicParser.DECIMAL, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_linenum;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterLinenum(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitLinenum(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class CommentContext extends ParserRuleContext {
        public CommentContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode COMMENT() {
            return getToken(PuffinBasicParser.COMMENT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_comment;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterComment(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitComment(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class StmtContext extends ParserRuleContext {
        public StmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public PrintusingstmtContext printusingstmt() {
            return getRuleContext(PrintusingstmtContext.class, 0);
        }

        public PrinthashusingstmtContext printhashusingstmt() {
            return getRuleContext(PrinthashusingstmtContext.class, 0);
        }

        public PrintstmtContext printstmt() {
            return getRuleContext(PrintstmtContext.class, 0);
        }

        public PrinthashstmtContext printhashstmt() {
            return getRuleContext(PrinthashstmtContext.class, 0);
        }

        public WritestmtContext writestmt() {
            return getRuleContext(WritestmtContext.class, 0);
        }

        public WritehashstmtContext writehashstmt() {
            return getRuleContext(WritehashstmtContext.class, 0);
        }

        public LetstmtContext letstmt() {
            return getRuleContext(LetstmtContext.class, 0);
        }

        public AutoletstmtContext autoletstmt() {
            return getRuleContext(AutoletstmtContext.class, 0);
        }

        public IfstmtContext ifstmt() {
            return getRuleContext(IfstmtContext.class, 0);
        }

        public IfthenbeginstmtContext ifthenbeginstmt() {
            return getRuleContext(IfthenbeginstmtContext.class, 0);
        }

        public ElsebeginstmtContext elsebeginstmt() {
            return getRuleContext(ElsebeginstmtContext.class, 0);
        }

        public EndifstmtContext endifstmt() {
            return getRuleContext(EndifstmtContext.class, 0);
        }

        public ForstmtContext forstmt() {
            return getRuleContext(ForstmtContext.class, 0);
        }

        public NextstmtContext nextstmt() {
            return getRuleContext(NextstmtContext.class, 0);
        }

        public GotostmtContext gotostmt() {
            return getRuleContext(GotostmtContext.class, 0);
        }

        public GotolabelstmtContext gotolabelstmt() {
            return getRuleContext(GotolabelstmtContext.class, 0);
        }

        public EndstmtContext endstmt() {
            return getRuleContext(EndstmtContext.class, 0);
        }

        public DeffnstmtContext deffnstmt() {
            return getRuleContext(DeffnstmtContext.class, 0);
        }

        public FunctionbeginstmtContext functionbeginstmt() {
            return getRuleContext(FunctionbeginstmtContext.class, 0);
        }

        public FunctionreturnstmtContext functionreturnstmt() {
            return getRuleContext(FunctionreturnstmtContext.class, 0);
        }

        public FunctionendstmtContext functionendstmt() {
            return getRuleContext(FunctionendstmtContext.class, 0);
        }

        public ImportstmtContext importstmt() {
            return getRuleContext(ImportstmtContext.class, 0);
        }

        public LibtagstmtContext libtagstmt() {
            return getRuleContext(LibtagstmtContext.class, 0);
        }

        public DimstmtContext dimstmt() {
            return getRuleContext(DimstmtContext.class, 0);
        }

        public ReallocstmtContext reallocstmt() {
            return getRuleContext(ReallocstmtContext.class, 0);
        }

        public GosubstmtContext gosubstmt() {
            return getRuleContext(GosubstmtContext.class, 0);
        }

        public GosublabelstmtContext gosublabelstmt() {
            return getRuleContext(GosublabelstmtContext.class, 0);
        }

        public ReturnstmtContext returnstmt() {
            return getRuleContext(ReturnstmtContext.class, 0);
        }

        public WhilestmtContext whilestmt() {
            return getRuleContext(WhilestmtContext.class, 0);
        }

        public WendstmtContext wendstmt() {
            return getRuleContext(WendstmtContext.class, 0);
        }

        public LsetstmtContext lsetstmt() {
            return getRuleContext(LsetstmtContext.class, 0);
        }

        public RsetstmtContext rsetstmt() {
            return getRuleContext(RsetstmtContext.class, 0);
        }

        public SwapstmtContext swapstmt() {
            return getRuleContext(SwapstmtContext.class, 0);
        }

        public Open1stmtContext open1stmt() {
            return getRuleContext(Open1stmtContext.class, 0);
        }

        public Open2stmtContext open2stmt() {
            return getRuleContext(Open2stmtContext.class, 0);
        }

        public ClosestmtContext closestmt() {
            return getRuleContext(ClosestmtContext.class, 0);
        }

        public PutstmtContext putstmt() {
            return getRuleContext(PutstmtContext.class, 0);
        }

        public GetstmtContext getstmt() {
            return getRuleContext(GetstmtContext.class, 0);
        }

        public FieldstmtContext fieldstmt() {
            return getRuleContext(FieldstmtContext.class, 0);
        }

        public InputstmtContext inputstmt() {
            return getRuleContext(InputstmtContext.class, 0);
        }

        public InputhashstmtContext inputhashstmt() {
            return getRuleContext(InputhashstmtContext.class, 0);
        }

        public LineinputstmtContext lineinputstmt() {
            return getRuleContext(LineinputstmtContext.class, 0);
        }

        public LineinputhashstmtContext lineinputhashstmt() {
            return getRuleContext(LineinputhashstmtContext.class, 0);
        }

        public ReadstmtContext readstmt() {
            return getRuleContext(ReadstmtContext.class, 0);
        }

        public DatastmtContext datastmt() {
            return getRuleContext(DatastmtContext.class, 0);
        }

        public RestorestmtContext restorestmt() {
            return getRuleContext(RestorestmtContext.class, 0);
        }

        public RandomizestmtContext randomizestmt() {
            return getRuleContext(RandomizestmtContext.class, 0);
        }

        public RandomizetimerstmtContext randomizetimerstmt() {
            return getRuleContext(RandomizetimerstmtContext.class, 0);
        }

        public DefintstmtContext defintstmt() {
            return getRuleContext(DefintstmtContext.class, 0);
        }

        public DeflngstmtContext deflngstmt() {
            return getRuleContext(DeflngstmtContext.class, 0);
        }

        public DefsngstmtContext defsngstmt() {
            return getRuleContext(DefsngstmtContext.class, 0);
        }

        public DefdblstmtContext defdblstmt() {
            return getRuleContext(DefdblstmtContext.class, 0);
        }

        public DefstrstmtContext defstrstmt() {
            return getRuleContext(DefstrstmtContext.class, 0);
        }

        public MiddlrstmtContext middlrstmt() {
            return getRuleContext(MiddlrstmtContext.class, 0);
        }

        public SleepstmtContext sleepstmt() {
            return getRuleContext(SleepstmtContext.class, 0);
        }

        public ScreenstmtContext screenstmt() {
            return getRuleContext(ScreenstmtContext.class, 0);
        }

        public CirclestmtContext circlestmt() {
            return getRuleContext(CirclestmtContext.class, 0);
        }

        public LinestmtContext linestmt() {
            return getRuleContext(LinestmtContext.class, 0);
        }

        public ColorstmtContext colorstmt() {
            return getRuleContext(ColorstmtContext.class, 0);
        }

        public PaintstmtContext paintstmt() {
            return getRuleContext(PaintstmtContext.class, 0);
        }

        public PsetstmtContext psetstmt() {
            return getRuleContext(PsetstmtContext.class, 0);
        }

        public DrawstmtContext drawstmt() {
            return getRuleContext(DrawstmtContext.class, 0);
        }

        public GraphicsgetstmtContext graphicsgetstmt() {
            return getRuleContext(GraphicsgetstmtContext.class, 0);
        }

        public GraphicsputstmtContext graphicsputstmt() {
            return getRuleContext(GraphicsputstmtContext.class, 0);
        }

        public GraphicsbuffercopyhorstmtContext graphicsbuffercopyhorstmt() {
            return getRuleContext(GraphicsbuffercopyhorstmtContext.class, 0);
        }

        public FontstmtContext fontstmt() {
            return getRuleContext(FontstmtContext.class, 0);
        }

        public DrawstrstmtContext drawstrstmt() {
            return getRuleContext(DrawstrstmtContext.class, 0);
        }

        public LoadimgstmtContext loadimgstmt() {
            return getRuleContext(LoadimgstmtContext.class, 0);
        }

        public SaveimgstmtContext saveimgstmt() {
            return getRuleContext(SaveimgstmtContext.class, 0);
        }

        public LocatestmtContext locatestmt() {
            return getRuleContext(LocatestmtContext.class, 0);
        }

        public ClsstmtContext clsstmt() {
            return getRuleContext(ClsstmtContext.class, 0);
        }

        public BeepstmtContext beepstmt() {
            return getRuleContext(BeepstmtContext.class, 0);
        }

        public RepaintstmtContext repaintstmt() {
            return getRuleContext(RepaintstmtContext.class, 0);
        }

        public ArrayfillstmtContext arrayfillstmt() {
            return getRuleContext(ArrayfillstmtContext.class, 0);
        }

        public ArraycopystmtContext arraycopystmt() {
            return getRuleContext(ArraycopystmtContext.class, 0);
        }

        public Array1dcopystmtContext array1dcopystmt() {
            return getRuleContext(Array1dcopystmtContext.class, 0);
        }

        public Array1dsortstmtContext array1dsortstmt() {
            return getRuleContext(Array1dsortstmtContext.class, 0);
        }

        public Array2dshifthorstmtContext array2dshifthorstmt() {
            return getRuleContext(Array2dshifthorstmtContext.class, 0);
        }

        public Array2dshiftverstmtContext array2dshiftverstmt() {
            return getRuleContext(Array2dshiftverstmtContext.class, 0);
        }

        public LoadwavstmtContext loadwavstmt() {
            return getRuleContext(LoadwavstmtContext.class, 0);
        }

        public PlaywavstmtContext playwavstmt() {
            return getRuleContext(PlaywavstmtContext.class, 0);
        }

        public StopwavstmtContext stopwavstmt() {
            return getRuleContext(StopwavstmtContext.class, 0);
        }

        public LoopwavstmtContext loopwavstmt() {
            return getRuleContext(LoopwavstmtContext.class, 0);
        }

        public LabelstmtContext labelstmt() {
            return getRuleContext(LabelstmtContext.class, 0);
        }

        public ListstmtContext liststmt() {
            return getRuleContext(ListstmtContext.class, 0);
        }

        public DictstmtContext dictstmt() {
            return getRuleContext(DictstmtContext.class, 0);
        }

        public SetstmtContext setstmt() {
            return getRuleContext(SetstmtContext.class, 0);
        }

        public StructstmtContext structstmt() {
            return getRuleContext(StructstmtContext.class, 0);
        }

        public StructinstancestmtContext structinstancestmt() {
            return getRuleContext(StructinstancestmtContext.class, 0);
        }

        public FuncContext func() {
            return getRuleContext(FuncContext.class, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterStmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitStmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class VariableContext extends ParserRuleContext {
        public VariableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public LeafvariableContext leafvariable() {
            return getRuleContext(LeafvariableContext.class, 0);
        }

        public StructvariableContext structvariable() {
            return getRuleContext(StructvariableContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_variable;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterVariable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitVariable(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LeafvariableContext extends ParserRuleContext {
        public LeafvariableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public VarnameContext varname() {
            return getRuleContext(VarnameContext.class, 0);
        }

        public VarsuffixContext varsuffix() {
            return getRuleContext(VarsuffixContext.class, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_leafvariable;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterLeafvariable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitLeafvariable(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class StructvariableContext extends ParserRuleContext {
        public StructvariableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<VarnameContext> varname() {
            return getRuleContexts(VarnameContext.class);
        }

        public VarnameContext varname(int i) {
            return getRuleContext(VarnameContext.class, i);
        }

        public List<TerminalNode> DOT() {
            return getTokens(PuffinBasicParser.DOT);
        }

        public TerminalNode DOT(int i) {
            return getToken(PuffinBasicParser.DOT, i);
        }

        public LeafvariableContext leafvariable() {
            return getRuleContext(LeafvariableContext.class, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_structvariable;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterStructvariable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitStructvariable(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class VarnameContext extends ParserRuleContext {
        public VarnameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode VARNAME() {
            return getToken(PuffinBasicParser.VARNAME, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_varname;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterVarname(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitVarname(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class VarsuffixContext extends ParserRuleContext {
        public VarsuffixContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DOLLAR() {
            return getToken(PuffinBasicParser.DOLLAR, 0);
        }

        public TerminalNode PERCENT() {
            return getToken(PuffinBasicParser.PERCENT, 0);
        }

        public TerminalNode AT() {
            return getToken(PuffinBasicParser.AT, 0);
        }

        public TerminalNode EXCLAMATION() {
            return getToken(PuffinBasicParser.EXCLAMATION, 0);
        }

        public TerminalNode HASH() {
            return getToken(PuffinBasicParser.HASH, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_varsuffix;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterVarsuffix(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitVarsuffix(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprContext extends ParserRuleContext {
        public ExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExprContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_expr;
        }

        public void copyFrom(ExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprLogNotContext extends ExprContext {
        public ExprLogNotContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode LOGNOT() {
            return getToken(PuffinBasicParser.LOGNOT, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterExprLogNot(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitExprLogNot(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprParenContext extends ExprContext {
        public ExprParenContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterExprParen(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitExprParen(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprStringContext extends ExprContext {
        public ExprStringContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public StringContext string() {
            return getRuleContext(StringContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterExprString(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitExprString(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprRelationalContext extends ExprContext {
        public ExprRelationalContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RELEQ() {
            return getToken(PuffinBasicParser.RELEQ, 0);
        }

        public TerminalNode RELNEQ() {
            return getToken(PuffinBasicParser.RELNEQ, 0);
        }

        public TerminalNode RELLT() {
            return getToken(PuffinBasicParser.RELLT, 0);
        }

        public TerminalNode RELGT() {
            return getToken(PuffinBasicParser.RELGT, 0);
        }

        public TerminalNode RELLE() {
            return getToken(PuffinBasicParser.RELLE, 0);
        }

        public TerminalNode RELGE() {
            return getToken(PuffinBasicParser.RELGE, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterExprRelational(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitExprRelational(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprMulDivContext extends ExprContext {
        public ExprMulDivContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode MUL() {
            return getToken(PuffinBasicParser.MUL, 0);
        }

        public TerminalNode FLOAT_DIV() {
            return getToken(PuffinBasicParser.FLOAT_DIV, 0);
        }

        public TerminalNode INT_DIV() {
            return getToken(PuffinBasicParser.INT_DIV, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterExprMulDiv(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitExprMulDiv(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprLogicalContext extends ExprContext {
        public ExprLogicalContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode LOGAND() {
            return getToken(PuffinBasicParser.LOGAND, 0);
        }

        public TerminalNode LOGOR() {
            return getToken(PuffinBasicParser.LOGOR, 0);
        }

        public TerminalNode LOGXOR() {
            return getToken(PuffinBasicParser.LOGXOR, 0);
        }

        public TerminalNode LOGEQV() {
            return getToken(PuffinBasicParser.LOGEQV, 0);
        }

        public TerminalNode LOGIMP() {
            return getToken(PuffinBasicParser.LOGIMP, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterExprLogical(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitExprLogical(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprBitwiseContext extends ExprContext {
        public ExprBitwiseContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode BWLSFT() {
            return getToken(PuffinBasicParser.BWLSFT, 0);
        }

        public TerminalNode BWRSFT() {
            return getToken(PuffinBasicParser.BWRSFT, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterExprBitwise(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitExprBitwise(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprNumberContext extends ExprContext {
        public ExprNumberContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public NumberContext number() {
            return getRuleContext(NumberContext.class, 0);
        }

        public TerminalNode PLUS() {
            return getToken(PuffinBasicParser.PLUS, 0);
        }

        public TerminalNode MINUS() {
            return getToken(PuffinBasicParser.MINUS, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterExprNumber(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitExprNumber(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprFuncContext extends ExprContext {
        public ExprFuncContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public FuncContext func() {
            return getRuleContext(FuncContext.class, 0);
        }

        public TerminalNode PLUS() {
            return getToken(PuffinBasicParser.PLUS, 0);
        }

        public TerminalNode MINUS() {
            return getToken(PuffinBasicParser.MINUS, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterExprFunc(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitExprFunc(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprExpContext extends ExprContext {
        public ExprExpContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode EXPONENT() {
            return getToken(PuffinBasicParser.EXPONENT, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterExprExp(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitExprExp(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprVariableContext extends ExprContext {
        public ExprVariableContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public TerminalNode PLUS() {
            return getToken(PuffinBasicParser.PLUS, 0);
        }

        public TerminalNode MINUS() {
            return getToken(PuffinBasicParser.MINUS, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterExprVariable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitExprVariable(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprPlusMinusContext extends ExprContext {
        public ExprPlusMinusContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode PLUS() {
            return getToken(PuffinBasicParser.PLUS, 0);
        }

        public TerminalNode MINUS() {
            return getToken(PuffinBasicParser.MINUS, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterExprPlusMinus(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitExprPlusMinus(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprModContext extends ExprContext {
        public ExprModContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode MOD() {
            return getToken(PuffinBasicParser.MOD, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterExprMod(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitExprMod(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncContext extends ParserRuleContext {
        public FuncContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public FuncContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_func;
        }

        public void copyFrom(FuncContext ctx) {
            super.copyFrom(ctx);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncArray1DStdContext extends FuncContext {
        public FuncArray1DStdContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ARRAY1DSTD() {
            return getToken(PuffinBasicParser.ARRAY1DSTD, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncArray1DStd(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncArray1DStd(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncArray1DMedianContext extends FuncContext {
        public FuncArray1DMedianContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ARRAY1DMEDIAN() {
            return getToken(PuffinBasicParser.ARRAY1DMEDIAN, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncArray1DMedian(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncArray1DMedian(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncCvlContext extends FuncContext {
        public FuncCvlContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode CVL() {
            return getToken(PuffinBasicParser.CVL, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncCvl(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncCvl(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncFloorContext extends FuncContext {
        public FuncFloorContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode FLOOR() {
            return getToken(PuffinBasicParser.FLOOR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncFloor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncFloor(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncTimerMillisContext extends FuncContext {
        public FuncTimerMillisContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode TIMERMILLIS() {
            return getToken(PuffinBasicParser.TIMERMILLIS, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncTimerMillis(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncTimerMillis(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncSinContext extends FuncContext {
        public FuncSinContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode SIN() {
            return getToken(PuffinBasicParser.SIN, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncSin(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncSin(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncCviContext extends FuncContext {
        public FuncCviContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode CVI() {
            return getToken(PuffinBasicParser.CVI, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncCvi(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncCvi(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncSqrContext extends FuncContext {
        public FuncSqrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode SQR() {
            return getToken(PuffinBasicParser.SQR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncSqr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncSqr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncMidDlrContext extends FuncContext {
        public FuncMidDlrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode MIDDLR() {
            return getToken(PuffinBasicParser.MIDDLR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncMidDlr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncMidDlr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncMouseButtonClickedContext extends FuncContext {
        public FuncMouseButtonClickedContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode MOUSEBUTTONCLICKED() {
            return getToken(PuffinBasicParser.MOUSEBUTTONCLICKED, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncMouseButtonClicked(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncMouseButtonClicked(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncSpaceDlrContext extends FuncContext {
        public FuncSpaceDlrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode SPACEDLR() {
            return getToken(PuffinBasicParser.SPACEDLR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncSpaceDlr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncSpaceDlr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncCvsContext extends FuncContext {
        public FuncCvsContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode CVS() {
            return getToken(PuffinBasicParser.CVS, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncCvs(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncCvs(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncSinhContext extends FuncContext {
        public FuncSinhContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode SINH() {
            return getToken(PuffinBasicParser.SINH, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncSinh(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncSinh(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncTimerContext extends FuncContext {
        public FuncTimerContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode TIMER() {
            return getToken(PuffinBasicParser.TIMER, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncTimer(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncTimer(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncArray1DMeanContext extends FuncContext {
        public FuncArray1DMeanContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ARRAY1DMEAN() {
            return getToken(PuffinBasicParser.ARRAY1DMEAN, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncArray1DMean(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncArray1DMean(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncMouseDraggedXContext extends FuncContext {
        public FuncMouseDraggedXContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode MOUSEDRAGGEDX() {
            return getToken(PuffinBasicParser.MOUSEDRAGGEDX, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncMouseDraggedX(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncMouseDraggedX(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncArray1DBinSearchContext extends FuncContext {
        public FuncArray1DBinSearchContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ARRAY1DBINSEARCH() {
            return getToken(PuffinBasicParser.ARRAY1DBINSEARCH, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncArray1DBinSearch(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncArray1DBinSearch(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncMkdDlrContext extends FuncContext {
        public FuncMkdDlrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode MKDDLR() {
            return getToken(PuffinBasicParser.MKDDLR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncMkdDlr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncMkdDlr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncLogContext extends FuncContext {
        public FuncLogContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode LOG() {
            return getToken(PuffinBasicParser.LOG, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncLog(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncLog(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncMinContext extends FuncContext {
        public FuncMinContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode MIN() {
            return getToken(PuffinBasicParser.MIN, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncMin(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncMin(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncCvdContext extends FuncContext {
        public FuncCvdContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode CVD() {
            return getToken(PuffinBasicParser.CVD, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncCvd(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncCvd(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncCeilContext extends FuncContext {
        public FuncCeilContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode CEIL() {
            return getToken(PuffinBasicParser.CEIL, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncCeil(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncCeil(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncHexDlrContext extends FuncContext {
        public FuncHexDlrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode HEXDLR() {
            return getToken(PuffinBasicParser.HEXDLR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncHexDlr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncHexDlr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncMouseDraggedYContext extends FuncContext {
        public FuncMouseDraggedYContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode MOUSEDRAGGEDY() {
            return getToken(PuffinBasicParser.MOUSEDRAGGEDY, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncMouseDraggedY(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncMouseDraggedY(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncMklDlrContext extends FuncContext {
        public FuncMklDlrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode MKLDLR() {
            return getToken(PuffinBasicParser.MKLDLR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncMklDlr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncMklDlr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncStrDlrContext extends FuncContext {
        public FuncStrDlrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode STRDLR() {
            return getToken(PuffinBasicParser.STRDLR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncStrDlr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncStrDlr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncCintContext extends FuncContext {
        public FuncCintContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode CINT() {
            return getToken(PuffinBasicParser.CINT, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncCint(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncCint(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncIsKeyPressedContext extends FuncContext {
        public FuncIsKeyPressedContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ISKEYPRESSED() {
            return getToken(PuffinBasicParser.ISKEYPRESSED, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncIsKeyPressed(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncIsKeyPressed(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncASinContext extends FuncContext {
        public FuncASinContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ASIN() {
            return getToken(PuffinBasicParser.ASIN, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncASin(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncASin(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncEofContext extends FuncContext {
        public FuncEofContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode EOFFN() {
            return getToken(PuffinBasicParser.EOFFN, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncEof(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncEof(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncArray2DFindColumnContext extends FuncContext {
        public ExprContext x1;
        public ExprContext y1;
        public ExprContext x2;
        public ExprContext y2;
        public ExprContext search;

        public FuncArray2DFindColumnContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ARRAY2DFINDCOLUMN() {
            return getToken(PuffinBasicParser.ARRAY2DFINDCOLUMN, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncArray2DFindColumn(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncArray2DFindColumn(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncOctDlrContext extends FuncContext {
        public FuncOctDlrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode OCTDLR() {
            return getToken(PuffinBasicParser.OCTDLR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncOctDlr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncOctDlr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncMouseButtonReleasedContext extends FuncContext {
        public FuncMouseButtonReleasedContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode MOUSEBUTTONRELEASED() {
            return getToken(PuffinBasicParser.MOUSEBUTTONRELEASED, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncMouseButtonReleased(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncMouseButtonReleased(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncMaxContext extends FuncContext {
        public FuncMaxContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode MAX() {
            return getToken(PuffinBasicParser.MAX, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncMax(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncMax(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncAbsContext extends FuncContext {
        public FuncAbsContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ABS() {
            return getToken(PuffinBasicParser.ABS, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncAbs(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncAbs(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncMemberMethodCallContext extends FuncContext {
        public FuncMemberMethodCallContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public TerminalNode DOT() {
            return getToken(PuffinBasicParser.DOT, 0);
        }

        public FuncnameContext funcname() {
            return getRuleContext(FuncnameContext.class, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncMemberMethodCall(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncMemberMethodCall(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncAscContext extends FuncContext {
        public FuncAscContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ASC() {
            return getToken(PuffinBasicParser.ASC, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncAsc(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncAsc(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncIntContext extends FuncContext {
        public FuncIntContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode INT() {
            return getToken(PuffinBasicParser.INT, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncInt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncInt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncMksDlrContext extends FuncContext {
        public FuncMksDlrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode MKSDLR() {
            return getToken(PuffinBasicParser.MKSDLR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncMksDlr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncMksDlr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncCsngContext extends FuncContext {
        public FuncCsngContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode CSNG() {
            return getToken(PuffinBasicParser.CSNG, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncCsng(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncCsng(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncRoundContext extends FuncContext {
        public FuncRoundContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ROUND() {
            return getToken(PuffinBasicParser.ROUND, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncRound(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncRound(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncLog10Context extends FuncContext {
        public FuncLog10Context(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode LOG10() {
            return getToken(PuffinBasicParser.LOG10, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncLog10(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncLog10(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncAtnContext extends FuncContext {
        public FuncAtnContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ATN() {
            return getToken(PuffinBasicParser.ATN, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncAtn(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncAtn(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncSgnContext extends FuncContext {
        public FuncSgnContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode SGN() {
            return getToken(PuffinBasicParser.SGN, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncSgn(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncSgn(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncInputDlrContext extends FuncContext {
        public FuncInputDlrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode INPUTDLR() {
            return getToken(PuffinBasicParser.INPUTDLR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public TerminalNode HASH() {
            return getToken(PuffinBasicParser.HASH, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncInputDlr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncInputDlr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncArray1DPctContext extends FuncContext {
        public ExprContext p;

        public FuncArray1DPctContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ARRAY1DPCT() {
            return getToken(PuffinBasicParser.ARRAY1DPCT, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncArray1DPct(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncArray1DPct(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncLeftDlrContext extends FuncContext {
        public FuncLeftDlrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode LEFTDLR() {
            return getToken(PuffinBasicParser.LEFTDLR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncLeftDlr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncLeftDlr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncFixContext extends FuncContext {
        public FuncFixContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode FIX() {
            return getToken(PuffinBasicParser.FIX, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncFix(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncFix(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncToRadContext extends FuncContext {
        public FuncToRadContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode TORAD() {
            return getToken(PuffinBasicParser.TORAD, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncToRad(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncToRad(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncLenContext extends FuncContext {
        public ExprContext axis;

        public FuncLenContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode LEN() {
            return getToken(PuffinBasicParser.LEN, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncLen(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncLen(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncArray2DFindRowContext extends FuncContext {
        public ExprContext x1;
        public ExprContext y1;
        public ExprContext x2;
        public ExprContext y2;
        public ExprContext search;

        public FuncArray2DFindRowContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ARRAY2DFINDROW() {
            return getToken(PuffinBasicParser.ARRAY2DFINDROW, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncArray2DFindRow(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncArray2DFindRow(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncArray1DMaxContext extends FuncContext {
        public FuncArray1DMaxContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ARRAY1DMAX() {
            return getToken(PuffinBasicParser.ARRAY1DMAX, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncArray1DMax(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncArray1DMax(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncTanContext extends FuncContext {
        public FuncTanContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode TAN() {
            return getToken(PuffinBasicParser.TAN, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncTan(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncTan(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncValContext extends FuncContext {
        public FuncValContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode VAL() {
            return getToken(PuffinBasicParser.VAL, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncVal(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncVal(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncPIContext extends FuncContext {
        public FuncPIContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode PI() {
            return getToken(PuffinBasicParser.PI, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncPI(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncPI(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncStringDlrContext extends FuncContext {
        public FuncStringDlrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode STRINGDLR() {
            return getToken(PuffinBasicParser.STRINGDLR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncStringDlr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncStringDlr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncExpContext extends FuncContext {
        public FuncExpContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode EXP() {
            return getToken(PuffinBasicParser.EXP, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncExp(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncExp(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncArray1DMinContext extends FuncContext {
        public FuncArray1DMinContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ARRAY1DMIN() {
            return getToken(PuffinBasicParser.ARRAY1DMIN, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncArray1DMin(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncArray1DMin(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncCosContext extends FuncContext {
        public FuncCosContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode COS() {
            return getToken(PuffinBasicParser.COS, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncCos(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncCos(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncCoshContext extends FuncContext {
        public FuncCoshContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode COSH() {
            return getToken(PuffinBasicParser.COSH, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncCosh(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncCosh(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncMouseButtonPressedContext extends FuncContext {
        public FuncMouseButtonPressedContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode MOUSEBUTTONPRESSED() {
            return getToken(PuffinBasicParser.MOUSEBUTTONPRESSED, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncMouseButtonPressed(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncMouseButtonPressed(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncSplitDlrContext extends FuncContext {
        public ExprContext str;
        public ExprContext regex;

        public FuncSplitDlrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode SPLITDLR() {
            return getToken(PuffinBasicParser.SPLITDLR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncSplitDlr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncSplitDlr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncRTrimDlrContext extends FuncContext {
        public ExprContext str;

        public FuncRTrimDlrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode RTRIMDLR() {
            return getToken(PuffinBasicParser.RTRIMDLR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncRTrimDlr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncRTrimDlr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncToDegContext extends FuncContext {
        public FuncToDegContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode TODEG() {
            return getToken(PuffinBasicParser.TODEG, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncToDeg(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncToDeg(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncArray1DSumContext extends FuncContext {
        public FuncArray1DSumContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ARRAY1DSUM() {
            return getToken(PuffinBasicParser.ARRAY1DSUM, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncArray1DSum(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncArray1DSum(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncInstrContext extends FuncContext {
        public FuncInstrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode INSTR() {
            return getToken(PuffinBasicParser.INSTR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncInstr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncInstr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncLog2Context extends FuncContext {
        public FuncLog2Context(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode LOG2() {
            return getToken(PuffinBasicParser.LOG2, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncLog2(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncLog2(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncLTrimDlrContext extends FuncContext {
        public ExprContext str;

        public FuncLTrimDlrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode LTRIMDLR() {
            return getToken(PuffinBasicParser.LTRIMDLR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncLTrimDlr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncLTrimDlr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncEnvironDlrContext extends FuncContext {
        public FuncEnvironDlrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ENVIRONDLR() {
            return getToken(PuffinBasicParser.ENVIRONDLR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncEnvironDlr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncEnvironDlr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncLofContext extends FuncContext {
        public FuncLofContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode LOF() {
            return getToken(PuffinBasicParser.LOF, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncLof(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncLof(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncChrDlrContext extends FuncContext {
        public FuncChrDlrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode CHRDLR() {
            return getToken(PuffinBasicParser.CHRDLR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncChrDlr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncChrDlr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncLocContext extends FuncContext {
        public FuncLocContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode LOC() {
            return getToken(PuffinBasicParser.LOC, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncLoc(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncLoc(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncInkeyDlrContext extends FuncContext {
        public FuncInkeyDlrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode INKEYDLR() {
            return getToken(PuffinBasicParser.INKEYDLR, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncInkeyDlr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncInkeyDlr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncRightDlrContext extends FuncContext {
        public FuncRightDlrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode RIGHTDLR() {
            return getToken(PuffinBasicParser.RIGHTDLR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncRightDlr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncRightDlr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncTanhContext extends FuncContext {
        public FuncTanhContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode TANH() {
            return getToken(PuffinBasicParser.TANH, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncTanh(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncTanh(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncEContext extends FuncContext {
        public FuncEContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode EULERE() {
            return getToken(PuffinBasicParser.EULERE, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncE(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncE(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncRndContext extends FuncContext {
        public FuncRndContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode RND() {
            return getToken(PuffinBasicParser.RND, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncRnd(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncRnd(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncClngContext extends FuncContext {
        public FuncClngContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode CLNG() {
            return getToken(PuffinBasicParser.CLNG, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncClng(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncClng(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncAllocArrayContext extends FuncContext {
        public FuncAllocArrayContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ALLOCARRAY() {
            return getToken(PuffinBasicParser.ALLOCARRAY, 0);
        }

        public VarsuffixContext varsuffix() {
            return getRuleContext(VarsuffixContext.class, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncAllocArray(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncAllocArray(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncACosContext extends FuncContext {
        public FuncACosContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode ACOS() {
            return getToken(PuffinBasicParser.ACOS, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncACos(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncACos(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncCdblContext extends FuncContext {
        public FuncCdblContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode CDBL() {
            return getToken(PuffinBasicParser.CDBL, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncCdbl(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncCdbl(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncMkiDlrContext extends FuncContext {
        public FuncMkiDlrContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode MKIDLR() {
            return getToken(PuffinBasicParser.MKIDLR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncMkiDlr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncMkiDlr(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncHsb2RgbContext extends FuncContext {
        public FuncHsb2RgbContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode HSB2RGB() {
            return getToken(PuffinBasicParser.HSB2RGB, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncHsb2Rgb(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncHsb2Rgb(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncMouseMovedYContext extends FuncContext {
        public FuncMouseMovedYContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode MOUSEMOVEDY() {
            return getToken(PuffinBasicParser.MOUSEMOVEDY, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncMouseMovedY(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncMouseMovedY(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncMouseMovedXContext extends FuncContext {
        public FuncMouseMovedXContext(FuncContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode MOUSEMOVEDX() {
            return getToken(PuffinBasicParser.MOUSEMOVEDX, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncMouseMovedX(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncMouseMovedX(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncnameContext extends ParserRuleContext {
        public FuncnameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public VarnameContext varname() {
            return getRuleContext(VarnameContext.class, 0);
        }

        public TerminalNode GET() {
            return getToken(PuffinBasicParser.GET, 0);
        }

        public TerminalNode APPEND() {
            return getToken(PuffinBasicParser.APPEND, 0);
        }

        public TerminalNode PUT() {
            return getToken(PuffinBasicParser.PUT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_funcname;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFuncname(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFuncname(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class GosubstmtContext extends ParserRuleContext {
        public GosubstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode GOSUB() {
            return getToken(PuffinBasicParser.GOSUB, 0);
        }

        public LinenumContext linenum() {
            return getRuleContext(LinenumContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_gosubstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterGosubstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitGosubstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class GosublabelstmtContext extends ParserRuleContext {
        public GosublabelstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode GOSUB() {
            return getToken(PuffinBasicParser.GOSUB, 0);
        }

        public StringContext string() {
            return getRuleContext(StringContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_gosublabelstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterGosublabelstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitGosublabelstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ReturnstmtContext extends ParserRuleContext {
        public ReturnstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode RETURN() {
            return getToken(PuffinBasicParser.RETURN, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_returnstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterReturnstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitReturnstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class PrinthashusingstmtContext extends ParserRuleContext {
        public ExprContext filenum;
        public ExprContext format;

        public PrinthashusingstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode PRINTHASH() {
            return getToken(PuffinBasicParser.PRINTHASH, 0);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public TerminalNode USING() {
            return getToken(PuffinBasicParser.USING, 0);
        }

        public TerminalNode SEMICOLON() {
            return getToken(PuffinBasicParser.SEMICOLON, 0);
        }

        public PrintlistContext printlist() {
            return getRuleContext(PrintlistContext.class, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_printhashusingstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterPrinthashusingstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitPrinthashusingstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class PrintusingstmtContext extends ParserRuleContext {
        public ExprContext format;

        public PrintusingstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode PRINT() {
            return getToken(PuffinBasicParser.PRINT, 0);
        }

        public TerminalNode USING() {
            return getToken(PuffinBasicParser.USING, 0);
        }

        public TerminalNode SEMICOLON() {
            return getToken(PuffinBasicParser.SEMICOLON, 0);
        }

        public PrintlistContext printlist() {
            return getRuleContext(PrintlistContext.class, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_printusingstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterPrintusingstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitPrintusingstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class PrinthashstmtContext extends ParserRuleContext {
        public ExprContext filenum;

        public PrinthashstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode PRINTHASH() {
            return getToken(PuffinBasicParser.PRINTHASH, 0);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public PrintlistContext printlist() {
            return getRuleContext(PrintlistContext.class, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_printhashstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterPrinthashstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitPrinthashstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class PrintstmtContext extends ParserRuleContext {
        public PrintstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode QUESTION() {
            return getToken(PuffinBasicParser.QUESTION, 0);
        }

        public TerminalNode PRINT() {
            return getToken(PuffinBasicParser.PRINT, 0);
        }

        public PrintlistContext printlist() {
            return getRuleContext(PrintlistContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_printstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterPrintstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitPrintstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class PrintlistContext extends ParserRuleContext {
        public PrintlistContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public List<TerminalNode> SEMICOLON() {
            return getTokens(PuffinBasicParser.SEMICOLON);
        }

        public TerminalNode SEMICOLON(int i) {
            return getToken(PuffinBasicParser.SEMICOLON, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_printlist;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterPrintlist(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitPrintlist(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class WritestmtContext extends ParserRuleContext {
        public WritestmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode WRITE() {
            return getToken(PuffinBasicParser.WRITE, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_writestmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterWritestmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitWritestmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class WritehashstmtContext extends ParserRuleContext {
        public ExprContext filenum;

        public WritehashstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode WRITEHASH() {
            return getToken(PuffinBasicParser.WRITEHASH, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_writehashstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterWritehashstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitWritehashstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LetstmtContext extends ParserRuleContext {
        public LetstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public TerminalNode RELEQ() {
            return getToken(PuffinBasicParser.RELEQ, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode LET() {
            return getToken(PuffinBasicParser.LET, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_letstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterLetstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitLetstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class AutoletstmtContext extends ParserRuleContext {
        public AutoletstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode AUTO() {
            return getToken(PuffinBasicParser.AUTO, 0);
        }

        public VarnameContext varname() {
            return getRuleContext(VarnameContext.class, 0);
        }

        public TerminalNode RELEQ() {
            return getToken(PuffinBasicParser.RELEQ, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_autoletstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterAutoletstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitAutoletstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IfstmtContext extends ParserRuleContext {
        public IfstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public IfstmtContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_ifstmt;
        }

        public void copyFrom(IfstmtContext ctx) {
            super.copyFrom(ctx);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IfThenElseContext extends IfstmtContext {
        public IfThenElseContext(IfstmtContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode IF() {
            return getToken(PuffinBasicParser.IF, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public ThenContext then() {
            return getRuleContext(ThenContext.class, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public TerminalNode ELSE() {
            return getToken(PuffinBasicParser.ELSE, 0);
        }

        public ElsestmtContext elsestmt() {
            return getRuleContext(ElsestmtContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterIfThenElse(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitIfThenElse(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ThenContext extends ParserRuleContext {
        public ThenContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode THEN() {
            return getToken(PuffinBasicParser.THEN, 0);
        }

        public LinenumContext linenum() {
            return getRuleContext(LinenumContext.class, 0);
        }

        public StmtlistContext stmtlist() {
            return getRuleContext(StmtlistContext.class, 0);
        }

        public TerminalNode GOTO() {
            return getToken(PuffinBasicParser.GOTO, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_then;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterThen(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitThen(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ElsestmtContext extends ParserRuleContext {
        public ElsestmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public LinenumContext linenum() {
            return getRuleContext(LinenumContext.class, 0);
        }

        public StmtlistContext stmtlist() {
            return getRuleContext(StmtlistContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_elsestmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterElsestmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitElsestmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IfthenbeginstmtContext extends ParserRuleContext {
        public IfthenbeginstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode IF() {
            return getToken(PuffinBasicParser.IF, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode THEN() {
            return getToken(PuffinBasicParser.THEN, 0);
        }

        public TerminalNode BEGIN() {
            return getToken(PuffinBasicParser.BEGIN, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ifthenbeginstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterIfthenbeginstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitIfthenbeginstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ElsebeginstmtContext extends ParserRuleContext {
        public ElsebeginstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ELSE() {
            return getToken(PuffinBasicParser.ELSE, 0);
        }

        public TerminalNode BEGIN() {
            return getToken(PuffinBasicParser.BEGIN, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_elsebeginstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterElsebeginstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitElsebeginstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EndifstmtContext extends ParserRuleContext {
        public EndifstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode END() {
            return getToken(PuffinBasicParser.END, 0);
        }

        public TerminalNode IF() {
            return getToken(PuffinBasicParser.IF, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_endifstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterEndifstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitEndifstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class StmtlistContext extends ParserRuleContext {
        public StmtlistContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<StmtContext> stmt() {
            return getRuleContexts(StmtContext.class);
        }

        public StmtContext stmt(int i) {
            return getRuleContext(StmtContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stmtlist;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterStmtlist(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitStmtlist(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ForstmtContext extends ParserRuleContext {
        public ForstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode FOR() {
            return getToken(PuffinBasicParser.FOR, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public TerminalNode RELEQ() {
            return getToken(PuffinBasicParser.RELEQ, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode TO() {
            return getToken(PuffinBasicParser.TO, 0);
        }

        public TerminalNode STEP() {
            return getToken(PuffinBasicParser.STEP, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_forstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterForstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitForstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class NextstmtContext extends ParserRuleContext {
        public NextstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode NEXT() {
            return getToken(PuffinBasicParser.NEXT, 0);
        }

        public List<VariableContext> variable() {
            return getRuleContexts(VariableContext.class);
        }

        public VariableContext variable(int i) {
            return getRuleContext(VariableContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_nextstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterNextstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitNextstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class GotostmtContext extends ParserRuleContext {
        public GotostmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode GOTO() {
            return getToken(PuffinBasicParser.GOTO, 0);
        }

        public LinenumContext linenum() {
            return getRuleContext(LinenumContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_gotostmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterGotostmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitGotostmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class GotolabelstmtContext extends ParserRuleContext {
        public GotolabelstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode GOTO() {
            return getToken(PuffinBasicParser.GOTO, 0);
        }

        public StringContext string() {
            return getRuleContext(StringContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_gotolabelstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterGotolabelstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitGotolabelstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EndstmtContext extends ParserRuleContext {
        public EndstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode END() {
            return getToken(PuffinBasicParser.END, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_endstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterEndstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitEndstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class DeffnstmtContext extends ParserRuleContext {
        public DeffnstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DEF() {
            return getToken(PuffinBasicParser.DEF, 0);
        }

        public VarnameContext varname() {
            return getRuleContext(VarnameContext.class, 0);
        }

        public TerminalNode RELEQ() {
            return getToken(PuffinBasicParser.RELEQ, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public VarsuffixContext varsuffix() {
            return getRuleContext(VarsuffixContext.class, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public List<VariableContext> variable() {
            return getRuleContexts(VariableContext.class);
        }

        public VariableContext variable(int i) {
            return getRuleContext(VariableContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_deffnstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterDeffnstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitDeffnstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FunctionbeginstmtContext extends ParserRuleContext {
        public VarnameContext fnname;
        public VarsuffixContext fnrettype;

        public FunctionbeginstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode FUNCTION() {
            return getToken(PuffinBasicParser.FUNCTION, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public TerminalNode LBRACE() {
            return getToken(PuffinBasicParser.LBRACE, 0);
        }

        public VarnameContext varname() {
            return getRuleContext(VarnameContext.class, 0);
        }

        public List<CompositetypeContext> compositetype() {
            return getRuleContexts(CompositetypeContext.class);
        }

        public CompositetypeContext compositetype(int i) {
            return getRuleContext(CompositetypeContext.class, i);
        }

        public VarsuffixContext varsuffix() {
            return getRuleContext(VarsuffixContext.class, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functionbeginstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFunctionbeginstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFunctionbeginstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FunctionreturnstmtContext extends ParserRuleContext {
        public FunctionreturnstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode RETURN() {
            return getToken(PuffinBasicParser.RETURN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functionreturnstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFunctionreturnstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFunctionreturnstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FunctionendstmtContext extends ParserRuleContext {
        public FunctionendstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode RBRACE() {
            return getToken(PuffinBasicParser.RBRACE, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functionendstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFunctionendstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFunctionendstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ImportstmtContext extends ParserRuleContext {
        public StringContext filename;

        public ImportstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode IMPORT() {
            return getToken(PuffinBasicParser.IMPORT, 0);
        }

        public StringContext string() {
            return getRuleContext(StringContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_importstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterImportstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitImportstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LibtagstmtContext extends ParserRuleContext {
        public StringContext tag;

        public LibtagstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode LIBTAG() {
            return getToken(PuffinBasicParser.LIBTAG, 0);
        }

        public StringContext string() {
            return getRuleContext(StringContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_libtagstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterLibtagstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitLibtagstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class DimstmtContext extends ParserRuleContext {
        public DimstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DIM() {
            return getToken(PuffinBasicParser.DIM, 0);
        }

        public VarnameContext varname() {
            return getRuleContext(VarnameContext.class, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public VarsuffixContext varsuffix() {
            return getRuleContext(VarsuffixContext.class, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dimstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterDimstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitDimstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ReallocstmtContext extends ParserRuleContext {
        public ReallocstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode REALLOCARRAY() {
            return getToken(PuffinBasicParser.REALLOCARRAY, 0);
        }

        public VarnameContext varname() {
            return getRuleContext(VarnameContext.class, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public VarsuffixContext varsuffix() {
            return getRuleContext(VarsuffixContext.class, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_reallocstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterReallocstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitReallocstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class WhilestmtContext extends ParserRuleContext {
        public WhilestmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode WHILE() {
            return getToken(PuffinBasicParser.WHILE, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_whilestmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterWhilestmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitWhilestmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class WendstmtContext extends ParserRuleContext {
        public WendstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode WEND() {
            return getToken(PuffinBasicParser.WEND, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_wendstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterWendstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitWendstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LsetstmtContext extends ParserRuleContext {
        public LsetstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode LSET() {
            return getToken(PuffinBasicParser.LSET, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public TerminalNode RELEQ() {
            return getToken(PuffinBasicParser.RELEQ, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_lsetstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterLsetstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitLsetstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class RsetstmtContext extends ParserRuleContext {
        public RsetstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode RSET() {
            return getToken(PuffinBasicParser.RSET, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public TerminalNode RELEQ() {
            return getToken(PuffinBasicParser.RELEQ, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rsetstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterRsetstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitRsetstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class SwapstmtContext extends ParserRuleContext {
        public SwapstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode SWAP() {
            return getToken(PuffinBasicParser.SWAP, 0);
        }

        public List<VariableContext> variable() {
            return getRuleContexts(VariableContext.class);
        }

        public VariableContext variable(int i) {
            return getRuleContext(VariableContext.class, i);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_swapstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterSwapstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitSwapstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Open1stmtContext extends ParserRuleContext {
        public Token filenum;
        public ExprContext filename;
        public ExprContext reclen;

        public Open1stmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode OPEN() {
            return getToken(PuffinBasicParser.OPEN, 0);
        }

        public Filemode1Context filemode1() {
            return getRuleContext(Filemode1Context.class, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public TerminalNode DECIMAL() {
            return getToken(PuffinBasicParser.DECIMAL, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode HASH() {
            return getToken(PuffinBasicParser.HASH, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_open1stmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterOpen1stmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitOpen1stmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Open2stmtContext extends ParserRuleContext {
        public ExprContext filename;
        public Token filenum;
        public ExprContext reclen;

        public Open2stmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode OPEN() {
            return getToken(PuffinBasicParser.OPEN, 0);
        }

        public TerminalNode AS() {
            return getToken(PuffinBasicParser.AS, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode DECIMAL() {
            return getToken(PuffinBasicParser.DECIMAL, 0);
        }

        public TerminalNode FOR() {
            return getToken(PuffinBasicParser.FOR, 0);
        }

        public Filemode2Context filemode2() {
            return getRuleContext(Filemode2Context.class, 0);
        }

        public TerminalNode ACCESS() {
            return getToken(PuffinBasicParser.ACCESS, 0);
        }

        public AccessContext access() {
            return getRuleContext(AccessContext.class, 0);
        }

        public LockContext lock() {
            return getRuleContext(LockContext.class, 0);
        }

        public TerminalNode HASH() {
            return getToken(PuffinBasicParser.HASH, 0);
        }

        public TerminalNode LEN() {
            return getToken(PuffinBasicParser.LEN, 0);
        }

        public TerminalNode RELEQ() {
            return getToken(PuffinBasicParser.RELEQ, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_open2stmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterOpen2stmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitOpen2stmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ClosestmtContext extends ParserRuleContext {
        public ClosestmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode CLOSE() {
            return getToken(PuffinBasicParser.CLOSE, 0);
        }

        public List<TerminalNode> DECIMAL() {
            return getTokens(PuffinBasicParser.DECIMAL);
        }

        public TerminalNode DECIMAL(int i) {
            return getToken(PuffinBasicParser.DECIMAL, i);
        }

        public List<TerminalNode> HASH() {
            return getTokens(PuffinBasicParser.HASH);
        }

        public TerminalNode HASH(int i) {
            return getToken(PuffinBasicParser.HASH, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_closestmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterClosestmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitClosestmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Filemode1Context extends ParserRuleContext {
        public Filemode1Context(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode STRING() {
            return getToken(PuffinBasicParser.STRING, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_filemode1;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFilemode1(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFilemode1(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Filemode2Context extends ParserRuleContext {
        public Filemode2Context(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode INPUT() {
            return getToken(PuffinBasicParser.INPUT, 0);
        }

        public TerminalNode OUTPUT() {
            return getToken(PuffinBasicParser.OUTPUT, 0);
        }

        public TerminalNode APPEND() {
            return getToken(PuffinBasicParser.APPEND, 0);
        }

        public TerminalNode RANDOM() {
            return getToken(PuffinBasicParser.RANDOM, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_filemode2;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFilemode2(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFilemode2(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class AccessContext extends ParserRuleContext {
        public AccessContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode READ() {
            return getToken(PuffinBasicParser.READ, 0);
        }

        public TerminalNode WRITE() {
            return getToken(PuffinBasicParser.WRITE, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_access;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterAccess(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitAccess(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LockContext extends ParserRuleContext {
        public LockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode SHARED() {
            return getToken(PuffinBasicParser.SHARED, 0);
        }

        public TerminalNode LOCK() {
            return getToken(PuffinBasicParser.LOCK, 0);
        }

        public TerminalNode READ() {
            return getToken(PuffinBasicParser.READ, 0);
        }

        public TerminalNode WRITE() {
            return getToken(PuffinBasicParser.WRITE, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_lock;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterLock(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitLock(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class PutstmtContext extends ParserRuleContext {
        public Token filenum;

        public PutstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode PUT() {
            return getToken(PuffinBasicParser.PUT, 0);
        }

        public TerminalNode DECIMAL() {
            return getToken(PuffinBasicParser.DECIMAL, 0);
        }

        public TerminalNode HASH() {
            return getToken(PuffinBasicParser.HASH, 0);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_putstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterPutstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitPutstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class GetstmtContext extends ParserRuleContext {
        public Token filenum;

        public GetstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode GET() {
            return getToken(PuffinBasicParser.GET, 0);
        }

        public TerminalNode DECIMAL() {
            return getToken(PuffinBasicParser.DECIMAL, 0);
        }

        public TerminalNode HASH() {
            return getToken(PuffinBasicParser.HASH, 0);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_getstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterGetstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitGetstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FieldstmtContext extends ParserRuleContext {
        public ExprContext filenum;

        public FieldstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode FIELD() {
            return getToken(PuffinBasicParser.FIELD, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public List<TerminalNode> DECIMAL() {
            return getTokens(PuffinBasicParser.DECIMAL);
        }

        public TerminalNode DECIMAL(int i) {
            return getToken(PuffinBasicParser.DECIMAL, i);
        }

        public List<TerminalNode> AS() {
            return getTokens(PuffinBasicParser.AS);
        }

        public TerminalNode AS(int i) {
            return getToken(PuffinBasicParser.AS, i);
        }

        public List<VariableContext> variable() {
            return getRuleContexts(VariableContext.class);
        }

        public VariableContext variable(int i) {
            return getRuleContext(VariableContext.class, i);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode HASH() {
            return getToken(PuffinBasicParser.HASH, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fieldstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFieldstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFieldstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class InputstmtContext extends ParserRuleContext {
        public InputstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode INPUT() {
            return getToken(PuffinBasicParser.INPUT, 0);
        }

        public List<VariableContext> variable() {
            return getRuleContexts(VariableContext.class);
        }

        public VariableContext variable(int i) {
            return getRuleContext(VariableContext.class, i);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public List<TerminalNode> SEMICOLON() {
            return getTokens(PuffinBasicParser.SEMICOLON);
        }

        public TerminalNode SEMICOLON(int i) {
            return getToken(PuffinBasicParser.SEMICOLON, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_inputstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterInputstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitInputstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class InputhashstmtContext extends ParserRuleContext {
        public ExprContext filenum;

        public InputhashstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode INPUTHASH() {
            return getToken(PuffinBasicParser.INPUTHASH, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public List<VariableContext> variable() {
            return getRuleContexts(VariableContext.class);
        }

        public VariableContext variable(int i) {
            return getRuleContext(VariableContext.class, i);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_inputhashstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterInputhashstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitInputhashstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LineinputstmtContext extends ParserRuleContext {
        public LineinputstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode LINE() {
            return getToken(PuffinBasicParser.LINE, 0);
        }

        public TerminalNode INPUT() {
            return getToken(PuffinBasicParser.INPUT, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public List<TerminalNode> SEMICOLON() {
            return getTokens(PuffinBasicParser.SEMICOLON);
        }

        public TerminalNode SEMICOLON(int i) {
            return getToken(PuffinBasicParser.SEMICOLON, i);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_lineinputstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterLineinputstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitLineinputstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LineinputhashstmtContext extends ParserRuleContext {
        public ExprContext filenum;

        public LineinputhashstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode LINE() {
            return getToken(PuffinBasicParser.LINE, 0);
        }

        public TerminalNode INPUTHASH() {
            return getToken(PuffinBasicParser.INPUTHASH, 0);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_lineinputhashstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterLineinputhashstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitLineinputhashstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ReadstmtContext extends ParserRuleContext {
        public ReadstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode READ() {
            return getToken(PuffinBasicParser.READ, 0);
        }

        public List<VariableContext> variable() {
            return getRuleContexts(VariableContext.class);
        }

        public VariableContext variable(int i) {
            return getRuleContext(VariableContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_readstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterReadstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitReadstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class DatastmtContext extends ParserRuleContext {
        public Token str;

        public DatastmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DATA() {
            return getToken(PuffinBasicParser.DATA, 0);
        }

        public List<NumberContext> number() {
            return getRuleContexts(NumberContext.class);
        }

        public NumberContext number(int i) {
            return getRuleContext(NumberContext.class, i);
        }

        public List<TerminalNode> STRING() {
            return getTokens(PuffinBasicParser.STRING);
        }

        public TerminalNode STRING(int i) {
            return getToken(PuffinBasicParser.STRING, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_datastmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterDatastmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitDatastmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class RestorestmtContext extends ParserRuleContext {
        public RestorestmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode RESTORE() {
            return getToken(PuffinBasicParser.RESTORE, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_restorestmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterRestorestmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitRestorestmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class RandomizestmtContext extends ParserRuleContext {
        public RandomizestmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode RANDOMIZE() {
            return getToken(PuffinBasicParser.RANDOMIZE, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_randomizestmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterRandomizestmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitRandomizestmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class RandomizetimerstmtContext extends ParserRuleContext {
        public RandomizetimerstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode RANDOMIZE() {
            return getToken(PuffinBasicParser.RANDOMIZE, 0);
        }

        public TerminalNode TIMER() {
            return getToken(PuffinBasicParser.TIMER, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_randomizetimerstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterRandomizetimerstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitRandomizetimerstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class DefintstmtContext extends ParserRuleContext {
        public DefintstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DEFINT() {
            return getToken(PuffinBasicParser.DEFINT, 0);
        }

        public List<TerminalNode> LETTERRANGE() {
            return getTokens(PuffinBasicParser.LETTERRANGE);
        }

        public TerminalNode LETTERRANGE(int i) {
            return getToken(PuffinBasicParser.LETTERRANGE, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_defintstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterDefintstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitDefintstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class DeflngstmtContext extends ParserRuleContext {
        public DeflngstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DEFLNG() {
            return getToken(PuffinBasicParser.DEFLNG, 0);
        }

        public List<TerminalNode> LETTERRANGE() {
            return getTokens(PuffinBasicParser.LETTERRANGE);
        }

        public TerminalNode LETTERRANGE(int i) {
            return getToken(PuffinBasicParser.LETTERRANGE, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_deflngstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterDeflngstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitDeflngstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class DefsngstmtContext extends ParserRuleContext {
        public DefsngstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DEFSNG() {
            return getToken(PuffinBasicParser.DEFSNG, 0);
        }

        public List<TerminalNode> LETTERRANGE() {
            return getTokens(PuffinBasicParser.LETTERRANGE);
        }

        public TerminalNode LETTERRANGE(int i) {
            return getToken(PuffinBasicParser.LETTERRANGE, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_defsngstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterDefsngstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitDefsngstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class DefdblstmtContext extends ParserRuleContext {
        public DefdblstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DEFDBL() {
            return getToken(PuffinBasicParser.DEFDBL, 0);
        }

        public List<TerminalNode> LETTERRANGE() {
            return getTokens(PuffinBasicParser.LETTERRANGE);
        }

        public TerminalNode LETTERRANGE(int i) {
            return getToken(PuffinBasicParser.LETTERRANGE, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_defdblstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterDefdblstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitDefdblstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class DefstrstmtContext extends ParserRuleContext {
        public DefstrstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DEFSTR() {
            return getToken(PuffinBasicParser.DEFSTR, 0);
        }

        public List<TerminalNode> LETTERRANGE() {
            return getTokens(PuffinBasicParser.LETTERRANGE);
        }

        public TerminalNode LETTERRANGE(int i) {
            return getToken(PuffinBasicParser.LETTERRANGE, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_defstrstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterDefstrstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitDefstrstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class MiddlrstmtContext extends ParserRuleContext {
        public MiddlrstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode MIDDLR() {
            return getToken(PuffinBasicParser.MIDDLR, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public TerminalNode RELEQ() {
            return getToken(PuffinBasicParser.RELEQ, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_middlrstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterMiddlrstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitMiddlrstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class SleepstmtContext extends ParserRuleContext {
        public SleepstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode SLEEP() {
            return getToken(PuffinBasicParser.SLEEP, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sleepstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterSleepstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitSleepstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ScreenstmtContext extends ParserRuleContext {
        public ExprContext title;
        public ExprContext w;
        public ExprContext h;
        public ExprContext iw;
        public ExprContext ih;
        public Token mr;
        public Token db;

        public ScreenstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode SCREEN() {
            return getToken(PuffinBasicParser.SCREEN, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode MANUAL_REPAINT() {
            return getToken(PuffinBasicParser.MANUAL_REPAINT, 0);
        }

        public TerminalNode DOUBLE_BUFFER() {
            return getToken(PuffinBasicParser.DOUBLE_BUFFER, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_screenstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterScreenstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitScreenstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class RepaintstmtContext extends ParserRuleContext {
        public RepaintstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode REPAINT() {
            return getToken(PuffinBasicParser.REPAINT, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_repaintstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterRepaintstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitRepaintstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class CirclestmtContext extends ParserRuleContext {
        public ExprContext x;
        public ExprContext y;
        public ExprContext r1;
        public ExprContext r2;
        public ExprContext s;
        public ExprContext e;
        public ExprContext fill;

        public CirclestmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode CIRCLE() {
            return getToken(PuffinBasicParser.CIRCLE, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_circlestmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterCirclestmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitCirclestmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LinestmtContext extends ParserRuleContext {
        public ExprContext x1;
        public ExprContext y1;
        public ExprContext x2;
        public ExprContext y2;
        public ExprContext bf;

        public LinestmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode LINE() {
            return getToken(PuffinBasicParser.LINE, 0);
        }

        public List<TerminalNode> LPAREN() {
            return getTokens(PuffinBasicParser.LPAREN);
        }

        public TerminalNode LPAREN(int i) {
            return getToken(PuffinBasicParser.LPAREN, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public List<TerminalNode> RPAREN() {
            return getTokens(PuffinBasicParser.RPAREN);
        }

        public TerminalNode RPAREN(int i) {
            return getToken(PuffinBasicParser.RPAREN, i);
        }

        public TerminalNode MINUS() {
            return getToken(PuffinBasicParser.MINUS, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_linestmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterLinestmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitLinestmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ColorstmtContext extends ParserRuleContext {
        public ExprContext r;
        public ExprContext g;
        public ExprContext b;

        public ColorstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode COLOR() {
            return getToken(PuffinBasicParser.COLOR, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_colorstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterColorstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitColorstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class PaintstmtContext extends ParserRuleContext {
        public ExprContext x;
        public ExprContext y;
        public ExprContext r;
        public ExprContext g;
        public ExprContext b;

        public PaintstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode PAINT() {
            return getToken(PuffinBasicParser.PAINT, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_paintstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterPaintstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitPaintstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class PsetstmtContext extends ParserRuleContext {
        public ExprContext x;
        public ExprContext y;
        public ExprContext r;
        public ExprContext g;
        public ExprContext b;

        public PsetstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode PSET() {
            return getToken(PuffinBasicParser.PSET, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_psetstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterPsetstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitPsetstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class DrawstmtContext extends ParserRuleContext {
        public DrawstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DRAW() {
            return getToken(PuffinBasicParser.DRAW, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_drawstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterDrawstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitDrawstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class GraphicsgetstmtContext extends ParserRuleContext {
        public ExprContext x1;
        public ExprContext y1;
        public ExprContext x2;
        public ExprContext y2;
        public Token buffer;

        public GraphicsgetstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode GET() {
            return getToken(PuffinBasicParser.GET, 0);
        }

        public List<TerminalNode> LPAREN() {
            return getTokens(PuffinBasicParser.LPAREN);
        }

        public TerminalNode LPAREN(int i) {
            return getToken(PuffinBasicParser.LPAREN, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public List<TerminalNode> RPAREN() {
            return getTokens(PuffinBasicParser.RPAREN);
        }

        public TerminalNode RPAREN(int i) {
            return getToken(PuffinBasicParser.RPAREN, i);
        }

        public TerminalNode MINUS() {
            return getToken(PuffinBasicParser.MINUS, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode FRONT() {
            return getToken(PuffinBasicParser.FRONT, 0);
        }

        public TerminalNode BACK1() {
            return getToken(PuffinBasicParser.BACK1, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_graphicsgetstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterGraphicsgetstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitGraphicsgetstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class GraphicsputstmtContext extends ParserRuleContext {
        public ExprContext x;
        public ExprContext y;
        public ExprContext action;
        public Token buffer;

        public GraphicsputstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode PUT() {
            return getToken(PuffinBasicParser.PUT, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode FRONT() {
            return getToken(PuffinBasicParser.FRONT, 0);
        }

        public TerminalNode BACK1() {
            return getToken(PuffinBasicParser.BACK1, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_graphicsputstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterGraphicsputstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitGraphicsputstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class GraphicsbuffercopyhorstmtContext extends ParserRuleContext {
        public ExprContext srcx;
        public ExprContext dstx;
        public ExprContext w;

        public GraphicsbuffercopyhorstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode BUFFERCOPYHOR() {
            return getToken(PuffinBasicParser.BUFFERCOPYHOR, 0);
        }

        public TerminalNode EQGT() {
            return getToken(PuffinBasicParser.EQGT, 0);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_graphicsbuffercopyhorstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterGraphicsbuffercopyhorstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitGraphicsbuffercopyhorstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FontstmtContext extends ParserRuleContext {
        public ExprContext name;
        public ExprContext style;
        public ExprContext size;

        public FontstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode FONT() {
            return getToken(PuffinBasicParser.FONT, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fontstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterFontstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitFontstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class DrawstrstmtContext extends ParserRuleContext {
        public ExprContext str;
        public ExprContext x;
        public ExprContext y;

        public DrawstrstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DRAWSTR() {
            return getToken(PuffinBasicParser.DRAWSTR, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_drawstrstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterDrawstrstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitDrawstrstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LoadimgstmtContext extends ParserRuleContext {
        public ExprContext path;

        public LoadimgstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode LOADIMG() {
            return getToken(PuffinBasicParser.LOADIMG, 0);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_loadimgstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterLoadimgstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitLoadimgstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class SaveimgstmtContext extends ParserRuleContext {
        public ExprContext path;

        public SaveimgstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode SAVEIMG() {
            return getToken(PuffinBasicParser.SAVEIMG, 0);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_saveimgstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterSaveimgstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitSaveimgstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LocatestmtContext extends ParserRuleContext {
        public ExprContext row;
        public ExprContext col;

        public LocatestmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode LOCATE() {
            return getToken(PuffinBasicParser.LOCATE, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_locatestmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterLocatestmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitLocatestmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ClsstmtContext extends ParserRuleContext {
        public ClsstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode CLS() {
            return getToken(PuffinBasicParser.CLS, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_clsstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterClsstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitClsstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class BeepstmtContext extends ParserRuleContext {
        public BeepstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode BEEP() {
            return getToken(PuffinBasicParser.BEEP, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_beepstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterBeepstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitBeepstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ArrayfillstmtContext extends ParserRuleContext {
        public ArrayfillstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ARRAYFILL() {
            return getToken(PuffinBasicParser.ARRAYFILL, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arrayfillstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterArrayfillstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitArrayfillstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ArraycopystmtContext extends ParserRuleContext {
        public VariableContext src;
        public VariableContext dst;

        public ArraycopystmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ARRAYCOPY() {
            return getToken(PuffinBasicParser.ARRAYCOPY, 0);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public List<VariableContext> variable() {
            return getRuleContexts(VariableContext.class);
        }

        public VariableContext variable(int i) {
            return getRuleContext(VariableContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arraycopystmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterArraycopystmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitArraycopystmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Array1dsortstmtContext extends ParserRuleContext {
        public Array1dsortstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ARRAY1DSORT() {
            return getToken(PuffinBasicParser.ARRAY1DSORT, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_array1dsortstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterArray1dsortstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitArray1dsortstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Array1dcopystmtContext extends ParserRuleContext {
        public VariableContext src;
        public ExprContext src0;
        public VariableContext dst;
        public ExprContext dst0;
        public ExprContext len;

        public Array1dcopystmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ARRAY1DCOPY() {
            return getToken(PuffinBasicParser.ARRAY1DCOPY, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public List<VariableContext> variable() {
            return getRuleContexts(VariableContext.class);
        }

        public VariableContext variable(int i) {
            return getRuleContext(VariableContext.class, i);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_array1dcopystmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterArray1dcopystmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitArray1dcopystmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Array2dshifthorstmtContext extends ParserRuleContext {
        public ExprContext step;

        public Array2dshifthorstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ARRAY2DSHIFTHOR() {
            return getToken(PuffinBasicParser.ARRAY2DSHIFTHOR, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_array2dshifthorstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterArray2dshifthorstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitArray2dshifthorstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Array2dshiftverstmtContext extends ParserRuleContext {
        public ExprContext step;

        public Array2dshiftverstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ARRAY2DSHIFTVER() {
            return getToken(PuffinBasicParser.ARRAY2DSHIFTVER, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_array2dshiftverstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterArray2dshiftverstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitArray2dshiftverstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LoadwavstmtContext extends ParserRuleContext {
        public ExprContext path;

        public LoadwavstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode LOADWAV() {
            return getToken(PuffinBasicParser.LOADWAV, 0);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_loadwavstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterLoadwavstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitLoadwavstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class PlaywavstmtContext extends ParserRuleContext {
        public PlaywavstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode PLAYWAV() {
            return getToken(PuffinBasicParser.PLAYWAV, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_playwavstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterPlaywavstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitPlaywavstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class StopwavstmtContext extends ParserRuleContext {
        public StopwavstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode STOPWAV() {
            return getToken(PuffinBasicParser.STOPWAV, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stopwavstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterStopwavstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitStopwavstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LoopwavstmtContext extends ParserRuleContext {
        public LoopwavstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode LOOPWAV() {
            return getToken(PuffinBasicParser.LOOPWAV, 0);
        }

        public VariableContext variable() {
            return getRuleContext(VariableContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_loopwavstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterLoopwavstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitLoopwavstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LabelstmtContext extends ParserRuleContext {
        public StringContext name;

        public LabelstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode LABEL() {
            return getToken(PuffinBasicParser.LABEL, 0);
        }

        public StringContext string() {
            return getRuleContext(StringContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_labelstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterLabelstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitLabelstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ListstmtContext extends ParserRuleContext {
        public VarnameContext typename;
        public VarsuffixContext typesuffix;
        public VarsuffixContext dimtypesuffix;
        public VarnameContext listname;

        public ListstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode LIST() {
            return getToken(PuffinBasicParser.LIST, 0);
        }

        public TerminalNode RELLT() {
            return getToken(PuffinBasicParser.RELLT, 0);
        }

        public TerminalNode RELGT() {
            return getToken(PuffinBasicParser.RELGT, 0);
        }

        public List<VarnameContext> varname() {
            return getRuleContexts(VarnameContext.class);
        }

        public VarnameContext varname(int i) {
            return getRuleContext(VarnameContext.class, i);
        }

        public TerminalNode DIM() {
            return getToken(PuffinBasicParser.DIM, 0);
        }

        public VarsuffixContext varsuffix() {
            return getRuleContext(VarsuffixContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_liststmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterListstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitListstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class DictstmtContext extends ParserRuleContext {
        public VarsuffixContext dictk1;
        public VarnameContext dictv1;
        public VarsuffixContext dictv2;
        public VarnameContext dictname;

        public DictstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DICT() {
            return getToken(PuffinBasicParser.DICT, 0);
        }

        public TerminalNode RELLT() {
            return getToken(PuffinBasicParser.RELLT, 0);
        }

        public TerminalNode COMMA() {
            return getToken(PuffinBasicParser.COMMA, 0);
        }

        public TerminalNode RELGT() {
            return getToken(PuffinBasicParser.RELGT, 0);
        }

        public List<VarnameContext> varname() {
            return getRuleContexts(VarnameContext.class);
        }

        public VarnameContext varname(int i) {
            return getRuleContext(VarnameContext.class, i);
        }

        public List<VarsuffixContext> varsuffix() {
            return getRuleContexts(VarsuffixContext.class);
        }

        public VarsuffixContext varsuffix(int i) {
            return getRuleContext(VarsuffixContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dictstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterDictstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitDictstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class SetstmtContext extends ParserRuleContext {
        public VarsuffixContext typesuffix;
        public VarnameContext setname;

        public SetstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode SET() {
            return getToken(PuffinBasicParser.SET, 0);
        }

        public TerminalNode RELLT() {
            return getToken(PuffinBasicParser.RELLT, 0);
        }

        public TerminalNode RELGT() {
            return getToken(PuffinBasicParser.RELGT, 0);
        }

        public VarnameContext varname() {
            return getRuleContext(VarnameContext.class, 0);
        }

        public VarsuffixContext varsuffix() {
            return getRuleContext(VarsuffixContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_setstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterSetstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitSetstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class StructstmtContext extends ParserRuleContext {
        public VarnameContext structname;

        public StructstmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode STRUCT() {
            return getToken(PuffinBasicParser.STRUCT, 0);
        }

        public TerminalNode LBRACE() {
            return getToken(PuffinBasicParser.LBRACE, 0);
        }

        public List<CompositetypeContext> compositetype() {
            return getRuleContexts(CompositetypeContext.class);
        }

        public CompositetypeContext compositetype(int i) {
            return getRuleContext(CompositetypeContext.class, i);
        }

        public TerminalNode RBRACE() {
            return getToken(PuffinBasicParser.RBRACE, 0);
        }

        public VarnameContext varname() {
            return getRuleContext(VarnameContext.class, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_structstmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterStructstmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitStructstmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class CompositetypeContext extends ParserRuleContext {
        public VarnameContext var1;
        public VarsuffixContext var2;
        public VarnameContext elem;
        public VarsuffixContext elemsuffix;
        public Token dim;
        public VarnameContext struct1;
        public VarnameContext list1;
        public VarsuffixContext list2;
        public VarsuffixContext list3;
        public VarnameContext set1;
        public VarsuffixContext set2;
        public VarsuffixContext dictk1;
        public VarnameContext dictv1;
        public VarsuffixContext dictv2;

        public CompositetypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DIM() {
            return getToken(PuffinBasicParser.DIM, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(PuffinBasicParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(PuffinBasicParser.RPAREN, 0);
        }

        public TerminalNode LIST() {
            return getToken(PuffinBasicParser.LIST, 0);
        }

        public TerminalNode RELLT() {
            return getToken(PuffinBasicParser.RELLT, 0);
        }

        public TerminalNode RELGT() {
            return getToken(PuffinBasicParser.RELGT, 0);
        }

        public TerminalNode SET() {
            return getToken(PuffinBasicParser.SET, 0);
        }

        public TerminalNode DICT() {
            return getToken(PuffinBasicParser.DICT, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(PuffinBasicParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(PuffinBasicParser.COMMA, i);
        }

        public List<VarnameContext> varname() {
            return getRuleContexts(VarnameContext.class);
        }

        public VarnameContext varname(int i) {
            return getRuleContext(VarnameContext.class, i);
        }

        public List<TerminalNode> DECIMAL() {
            return getTokens(PuffinBasicParser.DECIMAL);
        }

        public TerminalNode DECIMAL(int i) {
            return getToken(PuffinBasicParser.DECIMAL, i);
        }

        public List<VarsuffixContext> varsuffix() {
            return getRuleContexts(VarsuffixContext.class);
        }

        public VarsuffixContext varsuffix(int i) {
            return getRuleContext(VarsuffixContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_compositetype;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterCompositetype(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitCompositetype(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class StructinstancestmtContext extends ParserRuleContext {
        public StructinstancestmtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<VarnameContext> varname() {
            return getRuleContexts(VarnameContext.class);
        }

        public VarnameContext varname(int i) {
            return getRuleContext(VarnameContext.class, i);
        }

        public TerminalNode LBRACE() {
            return getToken(PuffinBasicParser.LBRACE, 0);
        }

        public TerminalNode RBRACE() {
            return getToken(PuffinBasicParser.RBRACE, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_structinstancestmt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterStructinstancestmt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitStructinstancestmt(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class StringContext extends ParserRuleContext {
        public StringContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode STRING() {
            return getToken(PuffinBasicParser.STRING, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_string;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterString(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitString(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class NumberContext extends ParserRuleContext {
        public NumberContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public IntegerContext integer() {
            return getRuleContext(IntegerContext.class, 0);
        }

        public TerminalNode FLOAT() {
            return getToken(PuffinBasicParser.FLOAT, 0);
        }

        public TerminalNode DOUBLE() {
            return getToken(PuffinBasicParser.DOUBLE, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_number;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterNumber(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitNumber(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IntegerContext extends ParserRuleContext {
        public IntegerContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DECIMAL() {
            return getToken(PuffinBasicParser.DECIMAL, 0);
        }

        public TerminalNode HEXADECIMAL() {
            return getToken(PuffinBasicParser.HEXADECIMAL, 0);
        }

        public TerminalNode OCTAL() {
            return getToken(PuffinBasicParser.OCTAL, 0);
        }

        public TerminalNode PERCENT() {
            return getToken(PuffinBasicParser.PERCENT, 0);
        }

        public TerminalNode AT() {
            return getToken(PuffinBasicParser.AT, 0);
        }

        public TerminalNode HASH() {
            return getToken(PuffinBasicParser.HASH, 0);
        }

        public TerminalNode EXCLAMATION() {
            return getToken(PuffinBasicParser.EXCLAMATION, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_integer;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).enterInteger(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PuffinBasicListener)
                ((PuffinBasicListener) listener).exitInteger(this);
        }
    }
}
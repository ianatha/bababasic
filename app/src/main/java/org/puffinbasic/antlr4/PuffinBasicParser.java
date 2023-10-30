// Generated from org/puffinbasic/antlr4/PuffinBasic.g4 by ANTLR 4.13.1
package org.puffinbasic.antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PuffinBasicParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, COMMENT=2, LIST=3, DICT=4, SET=5, EQGT=6, DEFAULT=7, LETTERRANGE=8, 
		LET=9, AUTO=10, PRINT=11, PRINTHASH=12, USING=13, IF=14, THEN=15, ELSE=16, 
		GOTO=17, FOR=18, NEXT=19, TO=20, STEP=21, REM=22, FUNCTION=23, LIBTAG=24, 
		IMPORT=25, END=26, SIN=27, COS=28, TAN=29, ATN=30, SQR=31, ABS=32, ASC=33, 
		DEF=34, DIM=35, ALLOCARRAY=36, REALLOCARRAY=37, LTRIMDLR=38, RTRIMDLR=39, 
		GOSUB=40, RETURN=41, LSET=42, RSET=43, CINT=44, CLNG=45, CSNG=46, CDBL=47, 
		CHRDLR=48, WHILE=49, WEND=50, MKIDLR=51, MKLDLR=52, MKSDLR=53, MKDDLR=54, 
		CVI=55, CVL=56, CVS=57, CVD=58, SPACEDLR=59, STRDLR=60, VAL=61, INT=62, 
		FIX=63, LOG=64, LEN=65, RIGHTDLR=66, LEFTDLR=67, MIDDLR=68, INSTR=69, 
		HEXDLR=70, OCTDLR=71, RND=72, SGN=73, TIMER=74, TIMERMILLIS=75, STRINGDLR=76, 
		SWAP=77, OPEN=78, CLOSE=79, ACCESS=80, AS=81, LINE=82, INPUT=83, INPUTHASH=84, 
		INPUTDLR=85, OUTPUT=86, APPEND=87, RANDOM=88, RANDOMIZE=89, READ=90, WRITE=91, 
		WRITEHASH=92, SHARED=93, LOCK=94, PUT=95, GET=96, EOFFN=97, LOC=98, LOF=99, 
		FIELD=100, DATA=101, RESTORE=102, DEFINT=103, DEFLNG=104, DEFSNG=105, 
		DEFDBL=106, DEFSTR=107, ENVIRONDLR=108, SCREEN=109, CIRCLE=110, SLEEP=111, 
		COLOR=112, INKEYDLR=113, PAINT=114, PSET=115, DRAW=116, FONT=117, DRAWSTR=118, 
		LOADIMG=119, SAVEIMG=120, LOADWAV=121, PLAYWAV=122, STOPWAV=123, LOOPWAV=124, 
		CLS=125, BEEP=126, MANUAL_REPAINT=127, DOUBLE_BUFFER=128, REPAINT=129, 
		ASIN=130, ACOS=131, SINH=132, COSH=133, TANH=134, EULERE=135, PI=136, 
		MIN=137, MAX=138, FLOOR=139, CEIL=140, ROUND=141, LOG10=142, LOG2=143, 
		EXP=144, TORAD=145, TODEG=146, TRUE=147, FALSE=148, ARRAYFILL=149, ARRAY1DMIN=150, 
		ARRAY1DMAX=151, ARRAY1DMEAN=152, ARRAY1DSUM=153, ARRAY1DSTD=154, ARRAY1DMEDIAN=155, 
		ARRAY1DPCT=156, ARRAY1DSORT=157, ARRAY1DBINSEARCH=158, ARRAY2DFINDROW=159, 
		ARRAY2DFINDCOLUMN=160, ARRAYCOPY=161, ARRAY1DCOPY=162, ARRAY2DSHIFTHOR=163, 
		ARRAY2DSHIFTVER=164, HSB2RGB=165, LABEL=166, BEGIN=167, MOUSEMOVEDX=168, 
		MOUSEMOVEDY=169, MOUSEDRAGGEDX=170, MOUSEDRAGGEDY=171, MOUSEBUTTONCLICKED=172, 
		MOUSEBUTTONPRESSED=173, MOUSEBUTTONRELEASED=174, ISKEYPRESSED=175, FRONT=176, 
		BACK1=177, BUFFERCOPYHOR=178, STRUCT=179, SPLITDLR=180, STRING=181, COMMA=182, 
		SEMICOLON=183, QUESTION=184, AT=185, DOLLAR=186, PERCENT=187, EXCLAMATION=188, 
		HASH=189, APOSTROPHE=190, EXPONENT=191, FLOAT_DIV=192, INT_DIV=193, MUL=194, 
		LPAREN=195, RPAREN=196, LBRACE=197, RBRACE=198, MOD=199, RELEQ=200, RELNEQ=201, 
		RELGT=202, RELGE=203, RELLT=204, RELLE=205, LOGAND=206, LOGOR=207, LOGNOT=208, 
		LOGXOR=209, LOGEQV=210, LOGIMP=211, BWRSFT=212, BWLSFT=213, VARNAME=214, 
		LETTER=215, PLUS=216, MINUS=217, DECIMAL=218, HEXADECIMAL=219, OCTAL=220, 
		FLOAT=221, DOUBLE=222, DOT=223, NEWLINE=224, WS=225, SPACE=226, TAB=227;
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
		RULE_drawstrstmt = 88, RULE_loadimgstmt = 89, RULE_saveimgstmt = 90, RULE_clsstmt = 91, 
		RULE_beepstmt = 92, RULE_arrayfillstmt = 93, RULE_arraycopystmt = 94, 
		RULE_array1dsortstmt = 95, RULE_array1dcopystmt = 96, RULE_array2dshifthorstmt = 97, 
		RULE_array2dshiftverstmt = 98, RULE_loadwavstmt = 99, RULE_playwavstmt = 100, 
		RULE_stopwavstmt = 101, RULE_loopwavstmt = 102, RULE_labelstmt = 103, 
		RULE_liststmt = 104, RULE_dictstmt = 105, RULE_setstmt = 106, RULE_structstmt = 107, 
		RULE_compositetype = 108, RULE_structinstancestmt = 109, RULE_string = 110, 
		RULE_number = 111, RULE_integer = 112;
	private static String[] makeRuleNames() {
		return new String[] {
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
			"drawstrstmt", "loadimgstmt", "saveimgstmt", "clsstmt", "beepstmt", "arrayfillstmt", 
			"arraycopystmt", "array1dsortstmt", "array1dcopystmt", "array2dshifthorstmt", 
			"array2dshiftverstmt", "loadwavstmt", "playwavstmt", "stopwavstmt", "loopwavstmt", 
			"labelstmt", "liststmt", "dictstmt", "setstmt", "structstmt", "compositetype", 
			"structinstancestmt", "string", "number", "integer"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
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
			null, null, "','", "';'", "'?'", "'@'", "'$'", "'%'", "'!'", "'#'", "'''", 
			"'^'", "'/'", "'\\'", "'*'", "'('", "')'", "'{'", "'}'", null, "'='", 
			"'<>'", "'>'", "'>='", "'<'", "'<='", null, null, null, null, null, null, 
			null, null, null, null, "'+'", "'-'", null, null, null, null, null, "'.'", 
			null, null, "' '", "'\\t'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "COMMENT", "LIST", "DICT", "SET", "EQGT", "DEFAULT", "LETTERRANGE", 
			"LET", "AUTO", "PRINT", "PRINTHASH", "USING", "IF", "THEN", "ELSE", "GOTO", 
			"FOR", "NEXT", "TO", "STEP", "REM", "FUNCTION", "LIBTAG", "IMPORT", "END", 
			"SIN", "COS", "TAN", "ATN", "SQR", "ABS", "ASC", "DEF", "DIM", "ALLOCARRAY", 
			"REALLOCARRAY", "LTRIMDLR", "RTRIMDLR", "GOSUB", "RETURN", "LSET", "RSET", 
			"CINT", "CLNG", "CSNG", "CDBL", "CHRDLR", "WHILE", "WEND", "MKIDLR", 
			"MKLDLR", "MKSDLR", "MKDDLR", "CVI", "CVL", "CVS", "CVD", "SPACEDLR", 
			"STRDLR", "VAL", "INT", "FIX", "LOG", "LEN", "RIGHTDLR", "LEFTDLR", "MIDDLR", 
			"INSTR", "HEXDLR", "OCTDLR", "RND", "SGN", "TIMER", "TIMERMILLIS", "STRINGDLR", 
			"SWAP", "OPEN", "CLOSE", "ACCESS", "AS", "LINE", "INPUT", "INPUTHASH", 
			"INPUTDLR", "OUTPUT", "APPEND", "RANDOM", "RANDOMIZE", "READ", "WRITE", 
			"WRITEHASH", "SHARED", "LOCK", "PUT", "GET", "EOFFN", "LOC", "LOF", "FIELD", 
			"DATA", "RESTORE", "DEFINT", "DEFLNG", "DEFSNG", "DEFDBL", "DEFSTR", 
			"ENVIRONDLR", "SCREEN", "CIRCLE", "SLEEP", "COLOR", "INKEYDLR", "PAINT", 
			"PSET", "DRAW", "FONT", "DRAWSTR", "LOADIMG", "SAVEIMG", "LOADWAV", "PLAYWAV", 
			"STOPWAV", "LOOPWAV", "CLS", "BEEP", "MANUAL_REPAINT", "DOUBLE_BUFFER", 
			"REPAINT", "ASIN", "ACOS", "SINH", "COSH", "TANH", "EULERE", "PI", "MIN", 
			"MAX", "FLOOR", "CEIL", "ROUND", "LOG10", "LOG2", "EXP", "TORAD", "TODEG", 
			"TRUE", "FALSE", "ARRAYFILL", "ARRAY1DMIN", "ARRAY1DMAX", "ARRAY1DMEAN", 
			"ARRAY1DSUM", "ARRAY1DSTD", "ARRAY1DMEDIAN", "ARRAY1DPCT", "ARRAY1DSORT", 
			"ARRAY1DBINSEARCH", "ARRAY2DFINDROW", "ARRAY2DFINDCOLUMN", "ARRAYCOPY", 
			"ARRAY1DCOPY", "ARRAY2DSHIFTHOR", "ARRAY2DSHIFTVER", "HSB2RGB", "LABEL", 
			"BEGIN", "MOUSEMOVEDX", "MOUSEMOVEDY", "MOUSEDRAGGEDX", "MOUSEDRAGGEDY", 
			"MOUSEBUTTONCLICKED", "MOUSEBUTTONPRESSED", "MOUSEBUTTONRELEASED", "ISKEYPRESSED", 
			"FRONT", "BACK1", "BUFFERCOPYHOR", "STRUCT", "SPLITDLR", "STRING", "COMMA", 
			"SEMICOLON", "QUESTION", "AT", "DOLLAR", "PERCENT", "EXCLAMATION", "HASH", 
			"APOSTROPHE", "EXPONENT", "FLOAT_DIV", "INT_DIV", "MUL", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "MOD", "RELEQ", "RELNEQ", "RELGT", "RELGE", "RELLT", 
			"RELLE", "LOGAND", "LOGOR", "LOGNOT", "LOGXOR", "LOGEQV", "LOGIMP", "BWRSFT", 
			"BWLSFT", "VARNAME", "LETTER", "PLUS", "MINUS", "DECIMAL", "HEXADECIMAL", 
			"OCTAL", "FLOAT", "DOUBLE", "DOT", "NEWLINE", "WS", "SPACE", "TAB"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
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
	public String getGrammarFileName() { return "PuffinBasic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PuffinBasicParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(PuffinBasicParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(PuffinBasicParser.NEWLINE, i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -7381444L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 9223372035214606335L) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & 40109909302575103L) != 0) || ((((_la - 198)) & ~0x3f) == 0 && ((1L << (_la - 198)) & 68222977L) != 0)) {
				{
				setState(228);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(226);
					line();
					}
					break;
				case 2:
					{
					setState(227);
					match(NEWLINE);
					}
					break;
				}
				}
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LineContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(PuffinBasicParser.NEWLINE, 0); }
		public LinenumContext linenum() {
			return getRuleContext(LinenumContext.class,0);
		}
		public StmtlistContext stmtlist() {
			return getRuleContext(StmtlistContext.class,0);
		}
		public CommentContext comment() {
			return getRuleContext(CommentContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DECIMAL) {
				{
				setState(233);
				linenum();
				}
			}

			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -7381448L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 9223372035214606335L) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & 40109909302575103L) != 0) || _la==RBRACE || _la==VARNAME) {
				{
				setState(236);
				stmtlist();
				}
			}

			setState(240);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMENT) {
				{
				setState(239);
				comment();
				}
			}

			setState(242);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LinenumContext extends ParserRuleContext {
		public TerminalNode DECIMAL() { return getToken(PuffinBasicParser.DECIMAL, 0); }
		public LinenumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linenum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterLinenum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitLinenum(this);
		}
	}

	public final LinenumContext linenum() throws RecognitionException {
		LinenumContext _localctx = new LinenumContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_linenum);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(DECIMAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CommentContext extends ParserRuleContext {
		public TerminalNode COMMENT() { return getToken(PuffinBasicParser.COMMENT, 0); }
		public CommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitComment(this);
		}
	}

	public final CommentContext comment() throws RecognitionException {
		CommentContext _localctx = new CommentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_comment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(COMMENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContext extends ParserRuleContext {
		public PrintusingstmtContext printusingstmt() {
			return getRuleContext(PrintusingstmtContext.class,0);
		}
		public PrinthashusingstmtContext printhashusingstmt() {
			return getRuleContext(PrinthashusingstmtContext.class,0);
		}
		public PrintstmtContext printstmt() {
			return getRuleContext(PrintstmtContext.class,0);
		}
		public PrinthashstmtContext printhashstmt() {
			return getRuleContext(PrinthashstmtContext.class,0);
		}
		public WritestmtContext writestmt() {
			return getRuleContext(WritestmtContext.class,0);
		}
		public WritehashstmtContext writehashstmt() {
			return getRuleContext(WritehashstmtContext.class,0);
		}
		public LetstmtContext letstmt() {
			return getRuleContext(LetstmtContext.class,0);
		}
		public AutoletstmtContext autoletstmt() {
			return getRuleContext(AutoletstmtContext.class,0);
		}
		public IfstmtContext ifstmt() {
			return getRuleContext(IfstmtContext.class,0);
		}
		public IfthenbeginstmtContext ifthenbeginstmt() {
			return getRuleContext(IfthenbeginstmtContext.class,0);
		}
		public ElsebeginstmtContext elsebeginstmt() {
			return getRuleContext(ElsebeginstmtContext.class,0);
		}
		public EndifstmtContext endifstmt() {
			return getRuleContext(EndifstmtContext.class,0);
		}
		public ForstmtContext forstmt() {
			return getRuleContext(ForstmtContext.class,0);
		}
		public NextstmtContext nextstmt() {
			return getRuleContext(NextstmtContext.class,0);
		}
		public GotostmtContext gotostmt() {
			return getRuleContext(GotostmtContext.class,0);
		}
		public GotolabelstmtContext gotolabelstmt() {
			return getRuleContext(GotolabelstmtContext.class,0);
		}
		public EndstmtContext endstmt() {
			return getRuleContext(EndstmtContext.class,0);
		}
		public DeffnstmtContext deffnstmt() {
			return getRuleContext(DeffnstmtContext.class,0);
		}
		public FunctionbeginstmtContext functionbeginstmt() {
			return getRuleContext(FunctionbeginstmtContext.class,0);
		}
		public FunctionreturnstmtContext functionreturnstmt() {
			return getRuleContext(FunctionreturnstmtContext.class,0);
		}
		public FunctionendstmtContext functionendstmt() {
			return getRuleContext(FunctionendstmtContext.class,0);
		}
		public ImportstmtContext importstmt() {
			return getRuleContext(ImportstmtContext.class,0);
		}
		public LibtagstmtContext libtagstmt() {
			return getRuleContext(LibtagstmtContext.class,0);
		}
		public DimstmtContext dimstmt() {
			return getRuleContext(DimstmtContext.class,0);
		}
		public ReallocstmtContext reallocstmt() {
			return getRuleContext(ReallocstmtContext.class,0);
		}
		public GosubstmtContext gosubstmt() {
			return getRuleContext(GosubstmtContext.class,0);
		}
		public GosublabelstmtContext gosublabelstmt() {
			return getRuleContext(GosublabelstmtContext.class,0);
		}
		public ReturnstmtContext returnstmt() {
			return getRuleContext(ReturnstmtContext.class,0);
		}
		public WhilestmtContext whilestmt() {
			return getRuleContext(WhilestmtContext.class,0);
		}
		public WendstmtContext wendstmt() {
			return getRuleContext(WendstmtContext.class,0);
		}
		public LsetstmtContext lsetstmt() {
			return getRuleContext(LsetstmtContext.class,0);
		}
		public RsetstmtContext rsetstmt() {
			return getRuleContext(RsetstmtContext.class,0);
		}
		public SwapstmtContext swapstmt() {
			return getRuleContext(SwapstmtContext.class,0);
		}
		public Open1stmtContext open1stmt() {
			return getRuleContext(Open1stmtContext.class,0);
		}
		public Open2stmtContext open2stmt() {
			return getRuleContext(Open2stmtContext.class,0);
		}
		public ClosestmtContext closestmt() {
			return getRuleContext(ClosestmtContext.class,0);
		}
		public PutstmtContext putstmt() {
			return getRuleContext(PutstmtContext.class,0);
		}
		public GetstmtContext getstmt() {
			return getRuleContext(GetstmtContext.class,0);
		}
		public FieldstmtContext fieldstmt() {
			return getRuleContext(FieldstmtContext.class,0);
		}
		public InputstmtContext inputstmt() {
			return getRuleContext(InputstmtContext.class,0);
		}
		public InputhashstmtContext inputhashstmt() {
			return getRuleContext(InputhashstmtContext.class,0);
		}
		public LineinputstmtContext lineinputstmt() {
			return getRuleContext(LineinputstmtContext.class,0);
		}
		public LineinputhashstmtContext lineinputhashstmt() {
			return getRuleContext(LineinputhashstmtContext.class,0);
		}
		public ReadstmtContext readstmt() {
			return getRuleContext(ReadstmtContext.class,0);
		}
		public DatastmtContext datastmt() {
			return getRuleContext(DatastmtContext.class,0);
		}
		public RestorestmtContext restorestmt() {
			return getRuleContext(RestorestmtContext.class,0);
		}
		public RandomizestmtContext randomizestmt() {
			return getRuleContext(RandomizestmtContext.class,0);
		}
		public RandomizetimerstmtContext randomizetimerstmt() {
			return getRuleContext(RandomizetimerstmtContext.class,0);
		}
		public DefintstmtContext defintstmt() {
			return getRuleContext(DefintstmtContext.class,0);
		}
		public DeflngstmtContext deflngstmt() {
			return getRuleContext(DeflngstmtContext.class,0);
		}
		public DefsngstmtContext defsngstmt() {
			return getRuleContext(DefsngstmtContext.class,0);
		}
		public DefdblstmtContext defdblstmt() {
			return getRuleContext(DefdblstmtContext.class,0);
		}
		public DefstrstmtContext defstrstmt() {
			return getRuleContext(DefstrstmtContext.class,0);
		}
		public MiddlrstmtContext middlrstmt() {
			return getRuleContext(MiddlrstmtContext.class,0);
		}
		public SleepstmtContext sleepstmt() {
			return getRuleContext(SleepstmtContext.class,0);
		}
		public ScreenstmtContext screenstmt() {
			return getRuleContext(ScreenstmtContext.class,0);
		}
		public CirclestmtContext circlestmt() {
			return getRuleContext(CirclestmtContext.class,0);
		}
		public LinestmtContext linestmt() {
			return getRuleContext(LinestmtContext.class,0);
		}
		public ColorstmtContext colorstmt() {
			return getRuleContext(ColorstmtContext.class,0);
		}
		public PaintstmtContext paintstmt() {
			return getRuleContext(PaintstmtContext.class,0);
		}
		public PsetstmtContext psetstmt() {
			return getRuleContext(PsetstmtContext.class,0);
		}
		public DrawstmtContext drawstmt() {
			return getRuleContext(DrawstmtContext.class,0);
		}
		public GraphicsgetstmtContext graphicsgetstmt() {
			return getRuleContext(GraphicsgetstmtContext.class,0);
		}
		public GraphicsputstmtContext graphicsputstmt() {
			return getRuleContext(GraphicsputstmtContext.class,0);
		}
		public GraphicsbuffercopyhorstmtContext graphicsbuffercopyhorstmt() {
			return getRuleContext(GraphicsbuffercopyhorstmtContext.class,0);
		}
		public FontstmtContext fontstmt() {
			return getRuleContext(FontstmtContext.class,0);
		}
		public DrawstrstmtContext drawstrstmt() {
			return getRuleContext(DrawstrstmtContext.class,0);
		}
		public LoadimgstmtContext loadimgstmt() {
			return getRuleContext(LoadimgstmtContext.class,0);
		}
		public SaveimgstmtContext saveimgstmt() {
			return getRuleContext(SaveimgstmtContext.class,0);
		}
		public ClsstmtContext clsstmt() {
			return getRuleContext(ClsstmtContext.class,0);
		}
		public BeepstmtContext beepstmt() {
			return getRuleContext(BeepstmtContext.class,0);
		}
		public RepaintstmtContext repaintstmt() {
			return getRuleContext(RepaintstmtContext.class,0);
		}
		public ArrayfillstmtContext arrayfillstmt() {
			return getRuleContext(ArrayfillstmtContext.class,0);
		}
		public ArraycopystmtContext arraycopystmt() {
			return getRuleContext(ArraycopystmtContext.class,0);
		}
		public Array1dcopystmtContext array1dcopystmt() {
			return getRuleContext(Array1dcopystmtContext.class,0);
		}
		public Array1dsortstmtContext array1dsortstmt() {
			return getRuleContext(Array1dsortstmtContext.class,0);
		}
		public Array2dshifthorstmtContext array2dshifthorstmt() {
			return getRuleContext(Array2dshifthorstmtContext.class,0);
		}
		public Array2dshiftverstmtContext array2dshiftverstmt() {
			return getRuleContext(Array2dshiftverstmtContext.class,0);
		}
		public LoadwavstmtContext loadwavstmt() {
			return getRuleContext(LoadwavstmtContext.class,0);
		}
		public PlaywavstmtContext playwavstmt() {
			return getRuleContext(PlaywavstmtContext.class,0);
		}
		public StopwavstmtContext stopwavstmt() {
			return getRuleContext(StopwavstmtContext.class,0);
		}
		public LoopwavstmtContext loopwavstmt() {
			return getRuleContext(LoopwavstmtContext.class,0);
		}
		public LabelstmtContext labelstmt() {
			return getRuleContext(LabelstmtContext.class,0);
		}
		public ListstmtContext liststmt() {
			return getRuleContext(ListstmtContext.class,0);
		}
		public DictstmtContext dictstmt() {
			return getRuleContext(DictstmtContext.class,0);
		}
		public SetstmtContext setstmt() {
			return getRuleContext(SetstmtContext.class,0);
		}
		public StructstmtContext structstmt() {
			return getRuleContext(StructstmtContext.class,0);
		}
		public StructinstancestmtContext structinstancestmt() {
			return getRuleContext(StructinstancestmtContext.class,0);
		}
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stmt);
		try {
			setState(338);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(248);
				printusingstmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(249);
				printhashusingstmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(250);
				printstmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(251);
				printhashstmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(252);
				writestmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(253);
				writehashstmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(254);
				letstmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(255);
				autoletstmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(256);
				ifstmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(257);
				ifthenbeginstmt();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(258);
				elsebeginstmt();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(259);
				endifstmt();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(260);
				forstmt();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(261);
				nextstmt();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(262);
				gotostmt();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(263);
				gotolabelstmt();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(264);
				endstmt();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(265);
				deffnstmt();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(266);
				functionbeginstmt();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(267);
				functionreturnstmt();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(268);
				functionendstmt();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(269);
				importstmt();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(270);
				libtagstmt();
				}
				break;
			case 24:
				enterOuterAlt(_localctx, 24);
				{
				setState(271);
				dimstmt();
				}
				break;
			case 25:
				enterOuterAlt(_localctx, 25);
				{
				setState(272);
				reallocstmt();
				}
				break;
			case 26:
				enterOuterAlt(_localctx, 26);
				{
				setState(273);
				gosubstmt();
				}
				break;
			case 27:
				enterOuterAlt(_localctx, 27);
				{
				setState(274);
				gosublabelstmt();
				}
				break;
			case 28:
				enterOuterAlt(_localctx, 28);
				{
				setState(275);
				returnstmt();
				}
				break;
			case 29:
				enterOuterAlt(_localctx, 29);
				{
				setState(276);
				whilestmt();
				}
				break;
			case 30:
				enterOuterAlt(_localctx, 30);
				{
				setState(277);
				wendstmt();
				}
				break;
			case 31:
				enterOuterAlt(_localctx, 31);
				{
				setState(278);
				lsetstmt();
				}
				break;
			case 32:
				enterOuterAlt(_localctx, 32);
				{
				setState(279);
				rsetstmt();
				}
				break;
			case 33:
				enterOuterAlt(_localctx, 33);
				{
				setState(280);
				swapstmt();
				}
				break;
			case 34:
				enterOuterAlt(_localctx, 34);
				{
				setState(281);
				open1stmt();
				}
				break;
			case 35:
				enterOuterAlt(_localctx, 35);
				{
				setState(282);
				open2stmt();
				}
				break;
			case 36:
				enterOuterAlt(_localctx, 36);
				{
				setState(283);
				closestmt();
				}
				break;
			case 37:
				enterOuterAlt(_localctx, 37);
				{
				setState(284);
				putstmt();
				}
				break;
			case 38:
				enterOuterAlt(_localctx, 38);
				{
				setState(285);
				getstmt();
				}
				break;
			case 39:
				enterOuterAlt(_localctx, 39);
				{
				setState(286);
				fieldstmt();
				}
				break;
			case 40:
				enterOuterAlt(_localctx, 40);
				{
				setState(287);
				inputstmt();
				}
				break;
			case 41:
				enterOuterAlt(_localctx, 41);
				{
				setState(288);
				inputhashstmt();
				}
				break;
			case 42:
				enterOuterAlt(_localctx, 42);
				{
				setState(289);
				lineinputstmt();
				}
				break;
			case 43:
				enterOuterAlt(_localctx, 43);
				{
				setState(290);
				lineinputhashstmt();
				}
				break;
			case 44:
				enterOuterAlt(_localctx, 44);
				{
				setState(291);
				readstmt();
				}
				break;
			case 45:
				enterOuterAlt(_localctx, 45);
				{
				setState(292);
				datastmt();
				}
				break;
			case 46:
				enterOuterAlt(_localctx, 46);
				{
				setState(293);
				restorestmt();
				}
				break;
			case 47:
				enterOuterAlt(_localctx, 47);
				{
				setState(294);
				randomizestmt();
				}
				break;
			case 48:
				enterOuterAlt(_localctx, 48);
				{
				setState(295);
				randomizetimerstmt();
				}
				break;
			case 49:
				enterOuterAlt(_localctx, 49);
				{
				setState(296);
				defintstmt();
				}
				break;
			case 50:
				enterOuterAlt(_localctx, 50);
				{
				setState(297);
				deflngstmt();
				}
				break;
			case 51:
				enterOuterAlt(_localctx, 51);
				{
				setState(298);
				defsngstmt();
				}
				break;
			case 52:
				enterOuterAlt(_localctx, 52);
				{
				setState(299);
				defdblstmt();
				}
				break;
			case 53:
				enterOuterAlt(_localctx, 53);
				{
				setState(300);
				defstrstmt();
				}
				break;
			case 54:
				enterOuterAlt(_localctx, 54);
				{
				setState(301);
				middlrstmt();
				}
				break;
			case 55:
				enterOuterAlt(_localctx, 55);
				{
				setState(302);
				sleepstmt();
				}
				break;
			case 56:
				enterOuterAlt(_localctx, 56);
				{
				setState(303);
				screenstmt();
				}
				break;
			case 57:
				enterOuterAlt(_localctx, 57);
				{
				setState(304);
				circlestmt();
				}
				break;
			case 58:
				enterOuterAlt(_localctx, 58);
				{
				setState(305);
				linestmt();
				}
				break;
			case 59:
				enterOuterAlt(_localctx, 59);
				{
				setState(306);
				colorstmt();
				}
				break;
			case 60:
				enterOuterAlt(_localctx, 60);
				{
				setState(307);
				paintstmt();
				}
				break;
			case 61:
				enterOuterAlt(_localctx, 61);
				{
				setState(308);
				psetstmt();
				}
				break;
			case 62:
				enterOuterAlt(_localctx, 62);
				{
				setState(309);
				drawstmt();
				}
				break;
			case 63:
				enterOuterAlt(_localctx, 63);
				{
				setState(310);
				graphicsgetstmt();
				}
				break;
			case 64:
				enterOuterAlt(_localctx, 64);
				{
				setState(311);
				graphicsputstmt();
				}
				break;
			case 65:
				enterOuterAlt(_localctx, 65);
				{
				setState(312);
				graphicsbuffercopyhorstmt();
				}
				break;
			case 66:
				enterOuterAlt(_localctx, 66);
				{
				setState(313);
				fontstmt();
				}
				break;
			case 67:
				enterOuterAlt(_localctx, 67);
				{
				setState(314);
				drawstrstmt();
				}
				break;
			case 68:
				enterOuterAlt(_localctx, 68);
				{
				setState(315);
				loadimgstmt();
				}
				break;
			case 69:
				enterOuterAlt(_localctx, 69);
				{
				setState(316);
				saveimgstmt();
				}
				break;
			case 70:
				enterOuterAlt(_localctx, 70);
				{
				setState(317);
				clsstmt();
				}
				break;
			case 71:
				enterOuterAlt(_localctx, 71);
				{
				setState(318);
				beepstmt();
				}
				break;
			case 72:
				enterOuterAlt(_localctx, 72);
				{
				setState(319);
				repaintstmt();
				}
				break;
			case 73:
				enterOuterAlt(_localctx, 73);
				{
				setState(320);
				arrayfillstmt();
				}
				break;
			case 74:
				enterOuterAlt(_localctx, 74);
				{
				setState(321);
				arraycopystmt();
				}
				break;
			case 75:
				enterOuterAlt(_localctx, 75);
				{
				setState(322);
				array1dcopystmt();
				}
				break;
			case 76:
				enterOuterAlt(_localctx, 76);
				{
				setState(323);
				array1dsortstmt();
				}
				break;
			case 77:
				enterOuterAlt(_localctx, 77);
				{
				setState(324);
				array2dshifthorstmt();
				}
				break;
			case 78:
				enterOuterAlt(_localctx, 78);
				{
				setState(325);
				array2dshiftverstmt();
				}
				break;
			case 79:
				enterOuterAlt(_localctx, 79);
				{
				setState(326);
				loadwavstmt();
				}
				break;
			case 80:
				enterOuterAlt(_localctx, 80);
				{
				setState(327);
				playwavstmt();
				}
				break;
			case 81:
				enterOuterAlt(_localctx, 81);
				{
				setState(328);
				stopwavstmt();
				}
				break;
			case 82:
				enterOuterAlt(_localctx, 82);
				{
				setState(329);
				loopwavstmt();
				}
				break;
			case 83:
				enterOuterAlt(_localctx, 83);
				{
				setState(330);
				labelstmt();
				}
				break;
			case 84:
				enterOuterAlt(_localctx, 84);
				{
				setState(331);
				liststmt();
				}
				break;
			case 85:
				enterOuterAlt(_localctx, 85);
				{
				setState(332);
				dictstmt();
				}
				break;
			case 86:
				enterOuterAlt(_localctx, 86);
				{
				setState(333);
				setstmt();
				}
				break;
			case 87:
				enterOuterAlt(_localctx, 87);
				{
				setState(334);
				structstmt();
				}
				break;
			case 88:
				enterOuterAlt(_localctx, 88);
				{
				setState(335);
				structinstancestmt();
				}
				break;
			case 89:
				enterOuterAlt(_localctx, 89);
				{
				setState(336);
				func();
				}
				break;
			case 90:
				enterOuterAlt(_localctx, 90);
				{
				setState(337);
				variable();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends ParserRuleContext {
		public LeafvariableContext leafvariable() {
			return getRuleContext(LeafvariableContext.class,0);
		}
		public StructvariableContext structvariable() {
			return getRuleContext(StructvariableContext.class,0);
		}
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitVariable(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variable);
		try {
			setState(342);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(340);
				leafvariable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(341);
				structvariable();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LeafvariableContext extends ParserRuleContext {
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public VarsuffixContext varsuffix() {
			return getRuleContext(VarsuffixContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public LeafvariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leafvariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterLeafvariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitLeafvariable(this);
		}
	}

	public final LeafvariableContext leafvariable() throws RecognitionException {
		LeafvariableContext _localctx = new LeafvariableContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_leafvariable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			varname();
			setState(346);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(345);
				varsuffix();
				}
				break;
			}
			setState(359);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(348);
				match(LPAREN);
				setState(349);
				expr(0);
				setState(354);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(350);
					match(COMMA);
					setState(351);
					expr(0);
					}
					}
					setState(356);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(357);
				match(RPAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructvariableContext extends ParserRuleContext {
		public List<VarnameContext> varname() {
			return getRuleContexts(VarnameContext.class);
		}
		public VarnameContext varname(int i) {
			return getRuleContext(VarnameContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(PuffinBasicParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(PuffinBasicParser.DOT, i);
		}
		public LeafvariableContext leafvariable() {
			return getRuleContext(LeafvariableContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public StructvariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structvariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterStructvariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitStructvariable(this);
		}
	}

	public final StructvariableContext structvariable() throws RecognitionException {
		StructvariableContext _localctx = new StructvariableContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_structvariable);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			varname();
			setState(366);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(362);
					match(DOT);
					setState(363);
					varname();
					}
					} 
				}
				setState(368);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(369);
			match(DOT);
			setState(370);
			leafvariable();
			setState(382);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(371);
				match(LPAREN);
				setState(372);
				expr(0);
				setState(377);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(373);
					match(COMMA);
					setState(374);
					expr(0);
					}
					}
					setState(379);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(380);
				match(RPAREN);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarnameContext extends ParserRuleContext {
		public TerminalNode VARNAME() { return getToken(PuffinBasicParser.VARNAME, 0); }
		public VarnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterVarname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitVarname(this);
		}
	}

	public final VarnameContext varname() throws RecognitionException {
		VarnameContext _localctx = new VarnameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_varname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(VARNAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarsuffixContext extends ParserRuleContext {
		public TerminalNode DOLLAR() { return getToken(PuffinBasicParser.DOLLAR, 0); }
		public TerminalNode PERCENT() { return getToken(PuffinBasicParser.PERCENT, 0); }
		public TerminalNode AT() { return getToken(PuffinBasicParser.AT, 0); }
		public TerminalNode EXCLAMATION() { return getToken(PuffinBasicParser.EXCLAMATION, 0); }
		public TerminalNode HASH() { return getToken(PuffinBasicParser.HASH, 0); }
		public VarsuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varsuffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterVarsuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitVarsuffix(this);
		}
	}

	public final VarsuffixContext varsuffix() throws RecognitionException {
		VarsuffixContext _localctx = new VarsuffixContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_varsuffix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			_la = _input.LA(1);
			if ( !(((((_la - 185)) & ~0x3f) == 0 && ((1L << (_la - 185)) & 31L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprLogNotContext extends ExprContext {
		public TerminalNode LOGNOT() { return getToken(PuffinBasicParser.LOGNOT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprLogNotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterExprLogNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitExprLogNot(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprParenContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public ExprParenContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterExprParen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitExprParen(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStringContext extends ExprContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public ExprStringContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterExprString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitExprString(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprRelationalContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RELEQ() { return getToken(PuffinBasicParser.RELEQ, 0); }
		public TerminalNode RELNEQ() { return getToken(PuffinBasicParser.RELNEQ, 0); }
		public TerminalNode RELLT() { return getToken(PuffinBasicParser.RELLT, 0); }
		public TerminalNode RELGT() { return getToken(PuffinBasicParser.RELGT, 0); }
		public TerminalNode RELLE() { return getToken(PuffinBasicParser.RELLE, 0); }
		public TerminalNode RELGE() { return getToken(PuffinBasicParser.RELGE, 0); }
		public ExprRelationalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterExprRelational(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitExprRelational(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprMulDivContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MUL() { return getToken(PuffinBasicParser.MUL, 0); }
		public TerminalNode FLOAT_DIV() { return getToken(PuffinBasicParser.FLOAT_DIV, 0); }
		public TerminalNode INT_DIV() { return getToken(PuffinBasicParser.INT_DIV, 0); }
		public ExprMulDivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterExprMulDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitExprMulDiv(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprLogicalContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LOGAND() { return getToken(PuffinBasicParser.LOGAND, 0); }
		public TerminalNode LOGOR() { return getToken(PuffinBasicParser.LOGOR, 0); }
		public TerminalNode LOGXOR() { return getToken(PuffinBasicParser.LOGXOR, 0); }
		public TerminalNode LOGEQV() { return getToken(PuffinBasicParser.LOGEQV, 0); }
		public TerminalNode LOGIMP() { return getToken(PuffinBasicParser.LOGIMP, 0); }
		public ExprLogicalContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterExprLogical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitExprLogical(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprBitwiseContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode BWLSFT() { return getToken(PuffinBasicParser.BWLSFT, 0); }
		public TerminalNode BWRSFT() { return getToken(PuffinBasicParser.BWRSFT, 0); }
		public ExprBitwiseContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterExprBitwise(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitExprBitwise(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprNumberContext extends ExprContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(PuffinBasicParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PuffinBasicParser.MINUS, 0); }
		public ExprNumberContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterExprNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitExprNumber(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprFuncContext extends ExprContext {
		public FuncContext func() {
			return getRuleContext(FuncContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(PuffinBasicParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PuffinBasicParser.MINUS, 0); }
		public ExprFuncContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterExprFunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitExprFunc(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprExpContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EXPONENT() { return getToken(PuffinBasicParser.EXPONENT, 0); }
		public ExprExpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterExprExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitExprExp(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprVariableContext extends ExprContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(PuffinBasicParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PuffinBasicParser.MINUS, 0); }
		public ExprVariableContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterExprVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitExprVariable(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprPlusMinusContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(PuffinBasicParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PuffinBasicParser.MINUS, 0); }
		public ExprPlusMinusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterExprPlusMinus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitExprPlusMinus(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprModContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MOD() { return getToken(PuffinBasicParser.MOD, 0); }
		public ExprModContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterExprMod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitExprMod(this);
		}
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
			setState(408);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new ExprFuncContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(390);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(389);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(392);
				func();
				}
				break;
			case 2:
				{
				_localctx = new ExprNumberContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(394);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(393);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(396);
				number();
				}
				break;
			case 3:
				{
				_localctx = new ExprVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(398);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PLUS || _la==MINUS) {
					{
					setState(397);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				setState(400);
				variable();
				}
				break;
			case 4:
				{
				_localctx = new ExprParenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(401);
				match(LPAREN);
				setState(402);
				expr(0);
				setState(403);
				match(RPAREN);
				}
				break;
			case 5:
				{
				_localctx = new ExprStringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(405);
				string();
				}
				break;
			case 6:
				{
				_localctx = new ExprLogNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(406);
				match(LOGNOT);
				setState(407);
				expr(3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(433);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(431);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new ExprExpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(410);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(411);
						match(EXPONENT);
						setState(412);
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new ExprMulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(413);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(414);
						_la = _input.LA(1);
						if ( !(((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & 7L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(415);
						expr(8);
						}
						break;
					case 3:
						{
						_localctx = new ExprModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(416);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(417);
						match(MOD);
						setState(418);
						expr(7);
						}
						break;
					case 4:
						{
						_localctx = new ExprPlusMinusContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(419);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(420);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(421);
						expr(6);
						}
						break;
					case 5:
						{
						_localctx = new ExprRelationalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(422);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(423);
						_la = _input.LA(1);
						if ( !(((((_la - 200)) & ~0x3f) == 0 && ((1L << (_la - 200)) & 63L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(424);
						expr(5);
						}
						break;
					case 6:
						{
						_localctx = new ExprLogicalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(425);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(426);
						_la = _input.LA(1);
						if ( !(((((_la - 206)) & ~0x3f) == 0 && ((1L << (_la - 206)) & 59L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(427);
						expr(3);
						}
						break;
					case 7:
						{
						_localctx = new ExprBitwiseContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(428);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(429);
						_la = _input.LA(1);
						if ( !(_la==BWRSFT || _la==BWLSFT) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(430);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(435);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncContext extends ParserRuleContext {
		public FuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func; }
	 
		public FuncContext() { }
		public void copyFrom(FuncContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncArray1DStdContext extends FuncContext {
		public TerminalNode ARRAY1DSTD() { return getToken(PuffinBasicParser.ARRAY1DSTD, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncArray1DStdContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncArray1DStd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncArray1DStd(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncArray1DMedianContext extends FuncContext {
		public TerminalNode ARRAY1DMEDIAN() { return getToken(PuffinBasicParser.ARRAY1DMEDIAN, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncArray1DMedianContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncArray1DMedian(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncArray1DMedian(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCvlContext extends FuncContext {
		public TerminalNode CVL() { return getToken(PuffinBasicParser.CVL, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncCvlContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncCvl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncCvl(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncFloorContext extends FuncContext {
		public TerminalNode FLOOR() { return getToken(PuffinBasicParser.FLOOR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncFloorContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncFloor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncFloor(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncTimerMillisContext extends FuncContext {
		public TerminalNode TIMERMILLIS() { return getToken(PuffinBasicParser.TIMERMILLIS, 0); }
		public FuncTimerMillisContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncTimerMillis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncTimerMillis(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncSinContext extends FuncContext {
		public TerminalNode SIN() { return getToken(PuffinBasicParser.SIN, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncSinContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncSin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncSin(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCviContext extends FuncContext {
		public TerminalNode CVI() { return getToken(PuffinBasicParser.CVI, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncCviContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncCvi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncCvi(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncSqrContext extends FuncContext {
		public TerminalNode SQR() { return getToken(PuffinBasicParser.SQR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncSqrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncSqr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncSqr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncMidDlrContext extends FuncContext {
		public TerminalNode MIDDLR() { return getToken(PuffinBasicParser.MIDDLR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncMidDlrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncMidDlr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncMidDlr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncMouseButtonClickedContext extends FuncContext {
		public TerminalNode MOUSEBUTTONCLICKED() { return getToken(PuffinBasicParser.MOUSEBUTTONCLICKED, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncMouseButtonClickedContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncMouseButtonClicked(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncMouseButtonClicked(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncSpaceDlrContext extends FuncContext {
		public TerminalNode SPACEDLR() { return getToken(PuffinBasicParser.SPACEDLR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncSpaceDlrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncSpaceDlr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncSpaceDlr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCvsContext extends FuncContext {
		public TerminalNode CVS() { return getToken(PuffinBasicParser.CVS, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncCvsContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncCvs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncCvs(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncSinhContext extends FuncContext {
		public TerminalNode SINH() { return getToken(PuffinBasicParser.SINH, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncSinhContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncSinh(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncSinh(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncTimerContext extends FuncContext {
		public TerminalNode TIMER() { return getToken(PuffinBasicParser.TIMER, 0); }
		public FuncTimerContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncTimer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncTimer(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncArray1DMeanContext extends FuncContext {
		public TerminalNode ARRAY1DMEAN() { return getToken(PuffinBasicParser.ARRAY1DMEAN, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncArray1DMeanContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncArray1DMean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncArray1DMean(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncMouseDraggedXContext extends FuncContext {
		public TerminalNode MOUSEDRAGGEDX() { return getToken(PuffinBasicParser.MOUSEDRAGGEDX, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncMouseDraggedXContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncMouseDraggedX(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncMouseDraggedX(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncArray1DBinSearchContext extends FuncContext {
		public TerminalNode ARRAY1DBINSEARCH() { return getToken(PuffinBasicParser.ARRAY1DBINSEARCH, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncArray1DBinSearchContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncArray1DBinSearch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncArray1DBinSearch(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncMkdDlrContext extends FuncContext {
		public TerminalNode MKDDLR() { return getToken(PuffinBasicParser.MKDDLR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncMkdDlrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncMkdDlr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncMkdDlr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncLogContext extends FuncContext {
		public TerminalNode LOG() { return getToken(PuffinBasicParser.LOG, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncLogContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncLog(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncLog(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncMinContext extends FuncContext {
		public TerminalNode MIN() { return getToken(PuffinBasicParser.MIN, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncMinContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncMin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncMin(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCvdContext extends FuncContext {
		public TerminalNode CVD() { return getToken(PuffinBasicParser.CVD, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncCvdContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncCvd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncCvd(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCeilContext extends FuncContext {
		public TerminalNode CEIL() { return getToken(PuffinBasicParser.CEIL, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncCeilContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncCeil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncCeil(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncHexDlrContext extends FuncContext {
		public TerminalNode HEXDLR() { return getToken(PuffinBasicParser.HEXDLR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncHexDlrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncHexDlr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncHexDlr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncMouseDraggedYContext extends FuncContext {
		public TerminalNode MOUSEDRAGGEDY() { return getToken(PuffinBasicParser.MOUSEDRAGGEDY, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncMouseDraggedYContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncMouseDraggedY(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncMouseDraggedY(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncMklDlrContext extends FuncContext {
		public TerminalNode MKLDLR() { return getToken(PuffinBasicParser.MKLDLR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncMklDlrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncMklDlr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncMklDlr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncStrDlrContext extends FuncContext {
		public TerminalNode STRDLR() { return getToken(PuffinBasicParser.STRDLR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncStrDlrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncStrDlr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncStrDlr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCintContext extends FuncContext {
		public TerminalNode CINT() { return getToken(PuffinBasicParser.CINT, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncCintContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncCint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncCint(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncIsKeyPressedContext extends FuncContext {
		public TerminalNode ISKEYPRESSED() { return getToken(PuffinBasicParser.ISKEYPRESSED, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncIsKeyPressedContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncIsKeyPressed(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncIsKeyPressed(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncASinContext extends FuncContext {
		public TerminalNode ASIN() { return getToken(PuffinBasicParser.ASIN, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncASinContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncASin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncASin(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncEofContext extends FuncContext {
		public TerminalNode EOFFN() { return getToken(PuffinBasicParser.EOFFN, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncEofContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncEof(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncEof(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncArray2DFindColumnContext extends FuncContext {
		public ExprContext x1;
		public ExprContext y1;
		public ExprContext x2;
		public ExprContext y2;
		public ExprContext search;
		public TerminalNode ARRAY2DFINDCOLUMN() { return getToken(PuffinBasicParser.ARRAY2DFINDCOLUMN, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FuncArray2DFindColumnContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncArray2DFindColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncArray2DFindColumn(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncOctDlrContext extends FuncContext {
		public TerminalNode OCTDLR() { return getToken(PuffinBasicParser.OCTDLR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncOctDlrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncOctDlr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncOctDlr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncMouseButtonReleasedContext extends FuncContext {
		public TerminalNode MOUSEBUTTONRELEASED() { return getToken(PuffinBasicParser.MOUSEBUTTONRELEASED, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncMouseButtonReleasedContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncMouseButtonReleased(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncMouseButtonReleased(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncMaxContext extends FuncContext {
		public TerminalNode MAX() { return getToken(PuffinBasicParser.MAX, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncMaxContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncMax(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncMax(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncAbsContext extends FuncContext {
		public TerminalNode ABS() { return getToken(PuffinBasicParser.ABS, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncAbsContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncAbs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncAbs(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncMemberMethodCallContext extends FuncContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PuffinBasicParser.DOT, 0); }
		public FuncnameContext funcname() {
			return getRuleContext(FuncnameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public FuncMemberMethodCallContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncMemberMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncMemberMethodCall(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncAscContext extends FuncContext {
		public TerminalNode ASC() { return getToken(PuffinBasicParser.ASC, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncAscContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncAsc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncAsc(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncIntContext extends FuncContext {
		public TerminalNode INT() { return getToken(PuffinBasicParser.INT, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncIntContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncInt(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncMksDlrContext extends FuncContext {
		public TerminalNode MKSDLR() { return getToken(PuffinBasicParser.MKSDLR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncMksDlrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncMksDlr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncMksDlr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCsngContext extends FuncContext {
		public TerminalNode CSNG() { return getToken(PuffinBasicParser.CSNG, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncCsngContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncCsng(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncCsng(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncRoundContext extends FuncContext {
		public TerminalNode ROUND() { return getToken(PuffinBasicParser.ROUND, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncRoundContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncRound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncRound(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncLog10Context extends FuncContext {
		public TerminalNode LOG10() { return getToken(PuffinBasicParser.LOG10, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncLog10Context(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncLog10(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncLog10(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncAtnContext extends FuncContext {
		public TerminalNode ATN() { return getToken(PuffinBasicParser.ATN, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncAtnContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncAtn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncAtn(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncSgnContext extends FuncContext {
		public TerminalNode SGN() { return getToken(PuffinBasicParser.SGN, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncSgnContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncSgn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncSgn(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncInputDlrContext extends FuncContext {
		public TerminalNode INPUTDLR() { return getToken(PuffinBasicParser.INPUTDLR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public TerminalNode HASH() { return getToken(PuffinBasicParser.HASH, 0); }
		public FuncInputDlrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncInputDlr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncInputDlr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncArray1DPctContext extends FuncContext {
		public ExprContext p;
		public TerminalNode ARRAY1DPCT() { return getToken(PuffinBasicParser.ARRAY1DPCT, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FuncArray1DPctContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncArray1DPct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncArray1DPct(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncLeftDlrContext extends FuncContext {
		public TerminalNode LEFTDLR() { return getToken(PuffinBasicParser.LEFTDLR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncLeftDlrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncLeftDlr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncLeftDlr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncFixContext extends FuncContext {
		public TerminalNode FIX() { return getToken(PuffinBasicParser.FIX, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncFixContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncFix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncFix(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncToRadContext extends FuncContext {
		public TerminalNode TORAD() { return getToken(PuffinBasicParser.TORAD, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncToRadContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncToRad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncToRad(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncLenContext extends FuncContext {
		public ExprContext axis;
		public TerminalNode LEN() { return getToken(PuffinBasicParser.LEN, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public FuncLenContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncLen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncLen(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncArray2DFindRowContext extends FuncContext {
		public ExprContext x1;
		public ExprContext y1;
		public ExprContext x2;
		public ExprContext y2;
		public ExprContext search;
		public TerminalNode ARRAY2DFINDROW() { return getToken(PuffinBasicParser.ARRAY2DFINDROW, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FuncArray2DFindRowContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncArray2DFindRow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncArray2DFindRow(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncArray1DMaxContext extends FuncContext {
		public TerminalNode ARRAY1DMAX() { return getToken(PuffinBasicParser.ARRAY1DMAX, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncArray1DMaxContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncArray1DMax(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncArray1DMax(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncTanContext extends FuncContext {
		public TerminalNode TAN() { return getToken(PuffinBasicParser.TAN, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncTanContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncTan(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncTan(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncValContext extends FuncContext {
		public TerminalNode VAL() { return getToken(PuffinBasicParser.VAL, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncValContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncVal(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncPIContext extends FuncContext {
		public TerminalNode PI() { return getToken(PuffinBasicParser.PI, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncPIContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncPI(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncPI(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncStringDlrContext extends FuncContext {
		public TerminalNode STRINGDLR() { return getToken(PuffinBasicParser.STRINGDLR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncStringDlrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncStringDlr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncStringDlr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncExpContext extends FuncContext {
		public TerminalNode EXP() { return getToken(PuffinBasicParser.EXP, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncExpContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncExp(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncArray1DMinContext extends FuncContext {
		public TerminalNode ARRAY1DMIN() { return getToken(PuffinBasicParser.ARRAY1DMIN, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncArray1DMinContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncArray1DMin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncArray1DMin(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCosContext extends FuncContext {
		public TerminalNode COS() { return getToken(PuffinBasicParser.COS, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncCosContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncCos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncCos(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCoshContext extends FuncContext {
		public TerminalNode COSH() { return getToken(PuffinBasicParser.COSH, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncCoshContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncCosh(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncCosh(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncMouseButtonPressedContext extends FuncContext {
		public TerminalNode MOUSEBUTTONPRESSED() { return getToken(PuffinBasicParser.MOUSEBUTTONPRESSED, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncMouseButtonPressedContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncMouseButtonPressed(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncMouseButtonPressed(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncSplitDlrContext extends FuncContext {
		public ExprContext str;
		public ExprContext regex;
		public TerminalNode SPLITDLR() { return getToken(PuffinBasicParser.SPLITDLR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FuncSplitDlrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncSplitDlr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncSplitDlr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncRTrimDlrContext extends FuncContext {
		public ExprContext str;
		public TerminalNode RTRIMDLR() { return getToken(PuffinBasicParser.RTRIMDLR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FuncRTrimDlrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncRTrimDlr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncRTrimDlr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncToDegContext extends FuncContext {
		public TerminalNode TODEG() { return getToken(PuffinBasicParser.TODEG, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncToDegContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncToDeg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncToDeg(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncArray1DSumContext extends FuncContext {
		public TerminalNode ARRAY1DSUM() { return getToken(PuffinBasicParser.ARRAY1DSUM, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncArray1DSumContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncArray1DSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncArray1DSum(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncInstrContext extends FuncContext {
		public TerminalNode INSTR() { return getToken(PuffinBasicParser.INSTR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncInstrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncInstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncInstr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncLog2Context extends FuncContext {
		public TerminalNode LOG2() { return getToken(PuffinBasicParser.LOG2, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncLog2Context(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncLog2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncLog2(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncLTrimDlrContext extends FuncContext {
		public ExprContext str;
		public TerminalNode LTRIMDLR() { return getToken(PuffinBasicParser.LTRIMDLR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FuncLTrimDlrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncLTrimDlr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncLTrimDlr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncEnvironDlrContext extends FuncContext {
		public TerminalNode ENVIRONDLR() { return getToken(PuffinBasicParser.ENVIRONDLR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncEnvironDlrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncEnvironDlr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncEnvironDlr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncLofContext extends FuncContext {
		public TerminalNode LOF() { return getToken(PuffinBasicParser.LOF, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncLofContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncLof(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncLof(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncChrDlrContext extends FuncContext {
		public TerminalNode CHRDLR() { return getToken(PuffinBasicParser.CHRDLR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncChrDlrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncChrDlr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncChrDlr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncLocContext extends FuncContext {
		public TerminalNode LOC() { return getToken(PuffinBasicParser.LOC, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncLocContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncLoc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncLoc(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncInkeyDlrContext extends FuncContext {
		public TerminalNode INKEYDLR() { return getToken(PuffinBasicParser.INKEYDLR, 0); }
		public FuncInkeyDlrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncInkeyDlr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncInkeyDlr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncRightDlrContext extends FuncContext {
		public TerminalNode RIGHTDLR() { return getToken(PuffinBasicParser.RIGHTDLR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncRightDlrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncRightDlr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncRightDlr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncTanhContext extends FuncContext {
		public TerminalNode TANH() { return getToken(PuffinBasicParser.TANH, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncTanhContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncTanh(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncTanh(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncEContext extends FuncContext {
		public TerminalNode EULERE() { return getToken(PuffinBasicParser.EULERE, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncEContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncE(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncRndContext extends FuncContext {
		public TerminalNode RND() { return getToken(PuffinBasicParser.RND, 0); }
		public FuncRndContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncRnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncRnd(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncClngContext extends FuncContext {
		public TerminalNode CLNG() { return getToken(PuffinBasicParser.CLNG, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncClngContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncClng(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncClng(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncAllocArrayContext extends FuncContext {
		public TerminalNode ALLOCARRAY() { return getToken(PuffinBasicParser.ALLOCARRAY, 0); }
		public VarsuffixContext varsuffix() {
			return getRuleContext(VarsuffixContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public FuncAllocArrayContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncAllocArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncAllocArray(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncACosContext extends FuncContext {
		public TerminalNode ACOS() { return getToken(PuffinBasicParser.ACOS, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncACosContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncACos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncACos(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCdblContext extends FuncContext {
		public TerminalNode CDBL() { return getToken(PuffinBasicParser.CDBL, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncCdblContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncCdbl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncCdbl(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncMkiDlrContext extends FuncContext {
		public TerminalNode MKIDLR() { return getToken(PuffinBasicParser.MKIDLR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncMkiDlrContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncMkiDlr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncMkiDlr(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncHsb2RgbContext extends FuncContext {
		public TerminalNode HSB2RGB() { return getToken(PuffinBasicParser.HSB2RGB, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncHsb2RgbContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncHsb2Rgb(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncHsb2Rgb(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncMouseMovedYContext extends FuncContext {
		public TerminalNode MOUSEMOVEDY() { return getToken(PuffinBasicParser.MOUSEMOVEDY, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncMouseMovedYContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncMouseMovedY(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncMouseMovedY(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncMouseMovedXContext extends FuncContext {
		public TerminalNode MOUSEMOVEDX() { return getToken(PuffinBasicParser.MOUSEMOVEDX, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public FuncMouseMovedXContext(FuncContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncMouseMovedX(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncMouseMovedX(this);
		}
	}

	public final FuncContext func() throws RecognitionException {
		FuncContext _localctx = new FuncContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_func);
		int _la;
		try {
			setState(906);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARNAME:
				_localctx = new FuncMemberMethodCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(436);
				variable();
				setState(437);
				match(DOT);
				setState(438);
				funcname();
				setState(439);
				match(LPAREN);
				setState(448);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 27)) & ~0x3f) == 0 && ((1L << (_la - 27)) & 289356276045847167L) != 0) || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & -1160802812544612345L) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & 286550323458312185L) != 0)) {
					{
					setState(440);
					expr(0);
					setState(445);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(441);
						match(COMMA);
						setState(442);
						expr(0);
						}
						}
						setState(447);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(450);
				match(RPAREN);
				}
				break;
			case ABS:
				_localctx = new FuncAbsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(452);
				match(ABS);
				setState(453);
				match(LPAREN);
				setState(454);
				expr(0);
				setState(455);
				match(RPAREN);
				}
				break;
			case ASC:
				_localctx = new FuncAscContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(457);
				match(ASC);
				setState(458);
				match(LPAREN);
				setState(459);
				expr(0);
				setState(460);
				match(RPAREN);
				}
				break;
			case SIN:
				_localctx = new FuncSinContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(462);
				match(SIN);
				setState(463);
				match(LPAREN);
				setState(464);
				expr(0);
				setState(465);
				match(RPAREN);
				}
				break;
			case COS:
				_localctx = new FuncCosContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(467);
				match(COS);
				setState(468);
				match(LPAREN);
				setState(469);
				expr(0);
				setState(470);
				match(RPAREN);
				}
				break;
			case TAN:
				_localctx = new FuncTanContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(472);
				match(TAN);
				setState(473);
				match(LPAREN);
				setState(474);
				expr(0);
				setState(475);
				match(RPAREN);
				}
				break;
			case ASIN:
				_localctx = new FuncASinContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(477);
				match(ASIN);
				setState(478);
				match(LPAREN);
				setState(479);
				expr(0);
				setState(480);
				match(RPAREN);
				}
				break;
			case ACOS:
				_localctx = new FuncACosContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(482);
				match(ACOS);
				setState(483);
				match(LPAREN);
				setState(484);
				expr(0);
				setState(485);
				match(RPAREN);
				}
				break;
			case ATN:
				_localctx = new FuncAtnContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(487);
				match(ATN);
				setState(488);
				match(LPAREN);
				setState(489);
				expr(0);
				setState(490);
				match(RPAREN);
				}
				break;
			case SINH:
				_localctx = new FuncSinhContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(492);
				match(SINH);
				setState(493);
				match(LPAREN);
				setState(494);
				expr(0);
				setState(495);
				match(RPAREN);
				}
				break;
			case COSH:
				_localctx = new FuncCoshContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(497);
				match(COSH);
				setState(498);
				match(LPAREN);
				setState(499);
				expr(0);
				setState(500);
				match(RPAREN);
				}
				break;
			case TANH:
				_localctx = new FuncTanhContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(502);
				match(TANH);
				setState(503);
				match(LPAREN);
				setState(504);
				expr(0);
				setState(505);
				match(RPAREN);
				}
				break;
			case SQR:
				_localctx = new FuncSqrContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(507);
				match(SQR);
				setState(508);
				match(LPAREN);
				setState(509);
				expr(0);
				setState(510);
				match(RPAREN);
				}
				break;
			case CINT:
				_localctx = new FuncCintContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(512);
				match(CINT);
				setState(513);
				match(LPAREN);
				setState(514);
				expr(0);
				setState(515);
				match(RPAREN);
				}
				break;
			case CLNG:
				_localctx = new FuncClngContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(517);
				match(CLNG);
				setState(518);
				match(LPAREN);
				setState(519);
				expr(0);
				setState(520);
				match(RPAREN);
				}
				break;
			case CSNG:
				_localctx = new FuncCsngContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(522);
				match(CSNG);
				setState(523);
				match(LPAREN);
				setState(524);
				expr(0);
				setState(525);
				match(RPAREN);
				}
				break;
			case CDBL:
				_localctx = new FuncCdblContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(527);
				match(CDBL);
				setState(528);
				match(LPAREN);
				setState(529);
				expr(0);
				setState(530);
				match(RPAREN);
				}
				break;
			case CHRDLR:
				_localctx = new FuncChrDlrContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(532);
				match(CHRDLR);
				setState(533);
				match(LPAREN);
				setState(534);
				expr(0);
				setState(535);
				match(RPAREN);
				}
				break;
			case MKIDLR:
				_localctx = new FuncMkiDlrContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(537);
				match(MKIDLR);
				setState(538);
				match(LPAREN);
				setState(539);
				expr(0);
				setState(540);
				match(RPAREN);
				}
				break;
			case MKLDLR:
				_localctx = new FuncMklDlrContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(542);
				match(MKLDLR);
				setState(543);
				match(LPAREN);
				setState(544);
				expr(0);
				setState(545);
				match(RPAREN);
				}
				break;
			case MKSDLR:
				_localctx = new FuncMksDlrContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(547);
				match(MKSDLR);
				setState(548);
				match(LPAREN);
				setState(549);
				expr(0);
				setState(550);
				match(RPAREN);
				}
				break;
			case MKDDLR:
				_localctx = new FuncMkdDlrContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(552);
				match(MKDDLR);
				setState(553);
				match(LPAREN);
				setState(554);
				expr(0);
				setState(555);
				match(RPAREN);
				}
				break;
			case CVI:
				_localctx = new FuncCviContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(557);
				match(CVI);
				setState(558);
				match(LPAREN);
				setState(559);
				expr(0);
				setState(560);
				match(RPAREN);
				}
				break;
			case CVL:
				_localctx = new FuncCvlContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(562);
				match(CVL);
				setState(563);
				match(LPAREN);
				setState(564);
				expr(0);
				setState(565);
				match(RPAREN);
				}
				break;
			case CVS:
				_localctx = new FuncCvsContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(567);
				match(CVS);
				setState(568);
				match(LPAREN);
				setState(569);
				expr(0);
				setState(570);
				match(RPAREN);
				}
				break;
			case CVD:
				_localctx = new FuncCvdContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(572);
				match(CVD);
				setState(573);
				match(LPAREN);
				setState(574);
				expr(0);
				setState(575);
				match(RPAREN);
				}
				break;
			case SPACEDLR:
				_localctx = new FuncSpaceDlrContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(577);
				match(SPACEDLR);
				setState(578);
				match(LPAREN);
				setState(579);
				expr(0);
				setState(580);
				match(RPAREN);
				}
				break;
			case STRDLR:
				_localctx = new FuncStrDlrContext(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(582);
				match(STRDLR);
				setState(583);
				match(LPAREN);
				setState(584);
				expr(0);
				setState(585);
				match(RPAREN);
				}
				break;
			case VAL:
				_localctx = new FuncValContext(_localctx);
				enterOuterAlt(_localctx, 29);
				{
				setState(587);
				match(VAL);
				setState(588);
				match(LPAREN);
				setState(589);
				expr(0);
				setState(590);
				match(RPAREN);
				}
				break;
			case INT:
				_localctx = new FuncIntContext(_localctx);
				enterOuterAlt(_localctx, 30);
				{
				setState(592);
				match(INT);
				setState(593);
				match(LPAREN);
				setState(594);
				expr(0);
				setState(595);
				match(RPAREN);
				}
				break;
			case FIX:
				_localctx = new FuncFixContext(_localctx);
				enterOuterAlt(_localctx, 31);
				{
				setState(597);
				match(FIX);
				setState(598);
				match(LPAREN);
				setState(599);
				expr(0);
				setState(600);
				match(RPAREN);
				}
				break;
			case LOG:
				_localctx = new FuncLogContext(_localctx);
				enterOuterAlt(_localctx, 32);
				{
				setState(602);
				match(LOG);
				setState(603);
				match(LPAREN);
				setState(604);
				expr(0);
				setState(605);
				match(RPAREN);
				}
				break;
			case LOG10:
				_localctx = new FuncLog10Context(_localctx);
				enterOuterAlt(_localctx, 33);
				{
				setState(607);
				match(LOG10);
				setState(608);
				match(LPAREN);
				setState(609);
				expr(0);
				setState(610);
				match(RPAREN);
				}
				break;
			case LOG2:
				_localctx = new FuncLog2Context(_localctx);
				enterOuterAlt(_localctx, 34);
				{
				setState(612);
				match(LOG2);
				setState(613);
				match(LPAREN);
				setState(614);
				expr(0);
				setState(615);
				match(RPAREN);
				}
				break;
			case EXP:
				_localctx = new FuncExpContext(_localctx);
				enterOuterAlt(_localctx, 35);
				{
				setState(617);
				match(EXP);
				setState(618);
				match(LPAREN);
				setState(619);
				expr(0);
				setState(620);
				match(RPAREN);
				}
				break;
			case TORAD:
				_localctx = new FuncToRadContext(_localctx);
				enterOuterAlt(_localctx, 36);
				{
				setState(622);
				match(TORAD);
				setState(623);
				match(LPAREN);
				setState(624);
				expr(0);
				setState(625);
				match(RPAREN);
				}
				break;
			case TODEG:
				_localctx = new FuncToDegContext(_localctx);
				enterOuterAlt(_localctx, 37);
				{
				setState(627);
				match(TODEG);
				setState(628);
				match(LPAREN);
				setState(629);
				expr(0);
				setState(630);
				match(RPAREN);
				}
				break;
			case CEIL:
				_localctx = new FuncCeilContext(_localctx);
				enterOuterAlt(_localctx, 38);
				{
				setState(632);
				match(CEIL);
				setState(633);
				match(LPAREN);
				setState(634);
				expr(0);
				setState(635);
				match(RPAREN);
				}
				break;
			case FLOOR:
				_localctx = new FuncFloorContext(_localctx);
				enterOuterAlt(_localctx, 39);
				{
				setState(637);
				match(FLOOR);
				setState(638);
				match(LPAREN);
				setState(639);
				expr(0);
				setState(640);
				match(RPAREN);
				}
				break;
			case ROUND:
				_localctx = new FuncRoundContext(_localctx);
				enterOuterAlt(_localctx, 40);
				{
				setState(642);
				match(ROUND);
				setState(643);
				match(LPAREN);
				setState(644);
				expr(0);
				setState(645);
				match(RPAREN);
				}
				break;
			case MIN:
				_localctx = new FuncMinContext(_localctx);
				enterOuterAlt(_localctx, 41);
				{
				setState(647);
				match(MIN);
				setState(648);
				match(LPAREN);
				setState(649);
				expr(0);
				setState(650);
				match(COMMA);
				setState(651);
				expr(0);
				setState(652);
				match(RPAREN);
				}
				break;
			case MAX:
				_localctx = new FuncMaxContext(_localctx);
				enterOuterAlt(_localctx, 42);
				{
				setState(654);
				match(MAX);
				setState(655);
				match(LPAREN);
				setState(656);
				expr(0);
				setState(657);
				match(COMMA);
				setState(658);
				expr(0);
				setState(659);
				match(RPAREN);
				}
				break;
			case PI:
				_localctx = new FuncPIContext(_localctx);
				enterOuterAlt(_localctx, 43);
				{
				setState(661);
				match(PI);
				setState(662);
				match(LPAREN);
				setState(663);
				match(RPAREN);
				}
				break;
			case EULERE:
				_localctx = new FuncEContext(_localctx);
				enterOuterAlt(_localctx, 44);
				{
				setState(664);
				match(EULERE);
				setState(665);
				match(LPAREN);
				setState(666);
				match(RPAREN);
				}
				break;
			case LEN:
				_localctx = new FuncLenContext(_localctx);
				enterOuterAlt(_localctx, 45);
				{
				setState(667);
				match(LEN);
				setState(668);
				match(LPAREN);
				setState(669);
				expr(0);
				setState(672);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(670);
					match(COMMA);
					setState(671);
					((FuncLenContext)_localctx).axis = expr(0);
					}
				}

				setState(674);
				match(RPAREN);
				}
				break;
			case HEXDLR:
				_localctx = new FuncHexDlrContext(_localctx);
				enterOuterAlt(_localctx, 46);
				{
				setState(676);
				match(HEXDLR);
				setState(677);
				match(LPAREN);
				setState(678);
				expr(0);
				setState(679);
				match(RPAREN);
				}
				break;
			case OCTDLR:
				_localctx = new FuncOctDlrContext(_localctx);
				enterOuterAlt(_localctx, 47);
				{
				setState(681);
				match(OCTDLR);
				setState(682);
				match(LPAREN);
				setState(683);
				expr(0);
				setState(684);
				match(RPAREN);
				}
				break;
			case RIGHTDLR:
				_localctx = new FuncRightDlrContext(_localctx);
				enterOuterAlt(_localctx, 48);
				{
				setState(686);
				match(RIGHTDLR);
				setState(687);
				match(LPAREN);
				setState(688);
				expr(0);
				setState(689);
				match(COMMA);
				setState(690);
				expr(0);
				setState(691);
				match(RPAREN);
				}
				break;
			case LEFTDLR:
				_localctx = new FuncLeftDlrContext(_localctx);
				enterOuterAlt(_localctx, 49);
				{
				setState(693);
				match(LEFTDLR);
				setState(694);
				match(LPAREN);
				setState(695);
				expr(0);
				setState(696);
				match(COMMA);
				setState(697);
				expr(0);
				setState(698);
				match(RPAREN);
				}
				break;
			case MIDDLR:
				_localctx = new FuncMidDlrContext(_localctx);
				enterOuterAlt(_localctx, 50);
				{
				setState(700);
				match(MIDDLR);
				setState(701);
				match(LPAREN);
				setState(702);
				expr(0);
				setState(703);
				match(COMMA);
				setState(704);
				expr(0);
				setState(707);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(705);
					match(COMMA);
					setState(706);
					expr(0);
					}
				}

				setState(709);
				match(RPAREN);
				}
				break;
			case INSTR:
				_localctx = new FuncInstrContext(_localctx);
				enterOuterAlt(_localctx, 51);
				{
				setState(711);
				match(INSTR);
				setState(712);
				match(LPAREN);
				setState(713);
				expr(0);
				setState(714);
				match(COMMA);
				setState(715);
				expr(0);
				setState(718);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(716);
					match(COMMA);
					setState(717);
					expr(0);
					}
				}

				setState(720);
				match(RPAREN);
				}
				break;
			case RND:
				_localctx = new FuncRndContext(_localctx);
				enterOuterAlt(_localctx, 52);
				{
				setState(722);
				match(RND);
				}
				break;
			case SGN:
				_localctx = new FuncSgnContext(_localctx);
				enterOuterAlt(_localctx, 53);
				{
				setState(723);
				match(SGN);
				setState(724);
				match(LPAREN);
				setState(725);
				expr(0);
				setState(726);
				match(RPAREN);
				}
				break;
			case ENVIRONDLR:
				_localctx = new FuncEnvironDlrContext(_localctx);
				enterOuterAlt(_localctx, 54);
				{
				setState(728);
				match(ENVIRONDLR);
				setState(729);
				match(LPAREN);
				setState(730);
				expr(0);
				setState(731);
				match(RPAREN);
				}
				break;
			case TIMER:
				_localctx = new FuncTimerContext(_localctx);
				enterOuterAlt(_localctx, 55);
				{
				setState(733);
				match(TIMER);
				}
				break;
			case TIMERMILLIS:
				_localctx = new FuncTimerMillisContext(_localctx);
				enterOuterAlt(_localctx, 56);
				{
				setState(734);
				match(TIMERMILLIS);
				}
				break;
			case STRINGDLR:
				_localctx = new FuncStringDlrContext(_localctx);
				enterOuterAlt(_localctx, 57);
				{
				setState(735);
				match(STRINGDLR);
				setState(736);
				match(LPAREN);
				setState(737);
				expr(0);
				setState(738);
				match(COMMA);
				setState(739);
				expr(0);
				setState(740);
				match(RPAREN);
				}
				break;
			case EOFFN:
				_localctx = new FuncEofContext(_localctx);
				enterOuterAlt(_localctx, 58);
				{
				setState(742);
				match(EOFFN);
				setState(743);
				match(LPAREN);
				setState(744);
				expr(0);
				setState(745);
				match(RPAREN);
				}
				break;
			case LOC:
				_localctx = new FuncLocContext(_localctx);
				enterOuterAlt(_localctx, 59);
				{
				setState(747);
				match(LOC);
				setState(748);
				match(LPAREN);
				setState(749);
				expr(0);
				setState(750);
				match(RPAREN);
				}
				break;
			case LOF:
				_localctx = new FuncLofContext(_localctx);
				enterOuterAlt(_localctx, 60);
				{
				setState(752);
				match(LOF);
				setState(753);
				match(LPAREN);
				setState(754);
				expr(0);
				setState(755);
				match(RPAREN);
				}
				break;
			case INPUTDLR:
				_localctx = new FuncInputDlrContext(_localctx);
				enterOuterAlt(_localctx, 61);
				{
				setState(757);
				match(INPUTDLR);
				setState(758);
				match(LPAREN);
				setState(759);
				expr(0);
				setState(765);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(760);
					match(COMMA);
					setState(762);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==HASH) {
						{
						setState(761);
						match(HASH);
						}
					}

					setState(764);
					expr(0);
					}
				}

				setState(767);
				match(RPAREN);
				}
				break;
			case INKEYDLR:
				_localctx = new FuncInkeyDlrContext(_localctx);
				enterOuterAlt(_localctx, 62);
				{
				setState(769);
				match(INKEYDLR);
				}
				break;
			case ARRAY1DMIN:
				_localctx = new FuncArray1DMinContext(_localctx);
				enterOuterAlt(_localctx, 63);
				{
				setState(770);
				match(ARRAY1DMIN);
				setState(771);
				match(LPAREN);
				setState(772);
				variable();
				setState(773);
				match(RPAREN);
				}
				break;
			case ARRAY1DMAX:
				_localctx = new FuncArray1DMaxContext(_localctx);
				enterOuterAlt(_localctx, 64);
				{
				setState(775);
				match(ARRAY1DMAX);
				setState(776);
				match(LPAREN);
				setState(777);
				variable();
				setState(778);
				match(RPAREN);
				}
				break;
			case ARRAY1DMEAN:
				_localctx = new FuncArray1DMeanContext(_localctx);
				enterOuterAlt(_localctx, 65);
				{
				setState(780);
				match(ARRAY1DMEAN);
				setState(781);
				match(LPAREN);
				setState(782);
				variable();
				setState(783);
				match(RPAREN);
				}
				break;
			case ARRAY1DSUM:
				_localctx = new FuncArray1DSumContext(_localctx);
				enterOuterAlt(_localctx, 66);
				{
				setState(785);
				match(ARRAY1DSUM);
				setState(786);
				match(LPAREN);
				setState(787);
				variable();
				setState(788);
				match(RPAREN);
				}
				break;
			case ARRAY1DSTD:
				_localctx = new FuncArray1DStdContext(_localctx);
				enterOuterAlt(_localctx, 67);
				{
				setState(790);
				match(ARRAY1DSTD);
				setState(791);
				match(LPAREN);
				setState(792);
				variable();
				setState(793);
				match(RPAREN);
				}
				break;
			case ARRAY1DMEDIAN:
				_localctx = new FuncArray1DMedianContext(_localctx);
				enterOuterAlt(_localctx, 68);
				{
				setState(795);
				match(ARRAY1DMEDIAN);
				setState(796);
				match(LPAREN);
				setState(797);
				variable();
				setState(798);
				match(RPAREN);
				}
				break;
			case ARRAY1DPCT:
				_localctx = new FuncArray1DPctContext(_localctx);
				enterOuterAlt(_localctx, 69);
				{
				setState(800);
				match(ARRAY1DPCT);
				setState(801);
				match(LPAREN);
				setState(802);
				variable();
				setState(803);
				match(COMMA);
				setState(804);
				((FuncArray1DPctContext)_localctx).p = expr(0);
				setState(805);
				match(RPAREN);
				}
				break;
			case ARRAY1DBINSEARCH:
				_localctx = new FuncArray1DBinSearchContext(_localctx);
				enterOuterAlt(_localctx, 70);
				{
				setState(807);
				match(ARRAY1DBINSEARCH);
				setState(808);
				match(LPAREN);
				setState(809);
				variable();
				setState(810);
				match(COMMA);
				setState(811);
				expr(0);
				setState(812);
				match(RPAREN);
				}
				break;
			case ARRAY2DFINDROW:
				_localctx = new FuncArray2DFindRowContext(_localctx);
				enterOuterAlt(_localctx, 71);
				{
				setState(814);
				match(ARRAY2DFINDROW);
				setState(815);
				match(LPAREN);
				setState(816);
				variable();
				setState(817);
				match(COMMA);
				setState(818);
				((FuncArray2DFindRowContext)_localctx).x1 = expr(0);
				setState(819);
				match(COMMA);
				setState(820);
				((FuncArray2DFindRowContext)_localctx).y1 = expr(0);
				setState(821);
				match(COMMA);
				setState(822);
				((FuncArray2DFindRowContext)_localctx).x2 = expr(0);
				setState(823);
				match(COMMA);
				setState(824);
				((FuncArray2DFindRowContext)_localctx).y2 = expr(0);
				setState(825);
				match(COMMA);
				setState(826);
				((FuncArray2DFindRowContext)_localctx).search = expr(0);
				setState(827);
				match(RPAREN);
				}
				break;
			case ARRAY2DFINDCOLUMN:
				_localctx = new FuncArray2DFindColumnContext(_localctx);
				enterOuterAlt(_localctx, 72);
				{
				setState(829);
				match(ARRAY2DFINDCOLUMN);
				setState(830);
				match(LPAREN);
				setState(831);
				variable();
				setState(832);
				match(COMMA);
				setState(833);
				((FuncArray2DFindColumnContext)_localctx).x1 = expr(0);
				setState(834);
				match(COMMA);
				setState(835);
				((FuncArray2DFindColumnContext)_localctx).y1 = expr(0);
				setState(836);
				match(COMMA);
				setState(837);
				((FuncArray2DFindColumnContext)_localctx).x2 = expr(0);
				setState(838);
				match(COMMA);
				setState(839);
				((FuncArray2DFindColumnContext)_localctx).y2 = expr(0);
				setState(840);
				match(COMMA);
				setState(841);
				((FuncArray2DFindColumnContext)_localctx).search = expr(0);
				setState(842);
				match(RPAREN);
				}
				break;
			case HSB2RGB:
				_localctx = new FuncHsb2RgbContext(_localctx);
				enterOuterAlt(_localctx, 73);
				{
				setState(844);
				match(HSB2RGB);
				setState(845);
				match(LPAREN);
				setState(846);
				expr(0);
				setState(847);
				match(COMMA);
				setState(848);
				expr(0);
				setState(849);
				match(COMMA);
				setState(850);
				expr(0);
				setState(851);
				match(RPAREN);
				}
				break;
			case MOUSEMOVEDX:
				_localctx = new FuncMouseMovedXContext(_localctx);
				enterOuterAlt(_localctx, 74);
				{
				setState(853);
				match(MOUSEMOVEDX);
				setState(854);
				match(LPAREN);
				setState(855);
				match(RPAREN);
				}
				break;
			case MOUSEMOVEDY:
				_localctx = new FuncMouseMovedYContext(_localctx);
				enterOuterAlt(_localctx, 75);
				{
				setState(856);
				match(MOUSEMOVEDY);
				setState(857);
				match(LPAREN);
				setState(858);
				match(RPAREN);
				}
				break;
			case MOUSEDRAGGEDX:
				_localctx = new FuncMouseDraggedXContext(_localctx);
				enterOuterAlt(_localctx, 76);
				{
				setState(859);
				match(MOUSEDRAGGEDX);
				setState(860);
				match(LPAREN);
				setState(861);
				match(RPAREN);
				}
				break;
			case MOUSEDRAGGEDY:
				_localctx = new FuncMouseDraggedYContext(_localctx);
				enterOuterAlt(_localctx, 77);
				{
				setState(862);
				match(MOUSEDRAGGEDY);
				setState(863);
				match(LPAREN);
				setState(864);
				match(RPAREN);
				}
				break;
			case MOUSEBUTTONCLICKED:
				_localctx = new FuncMouseButtonClickedContext(_localctx);
				enterOuterAlt(_localctx, 78);
				{
				setState(865);
				match(MOUSEBUTTONCLICKED);
				setState(866);
				match(LPAREN);
				setState(867);
				match(RPAREN);
				}
				break;
			case MOUSEBUTTONPRESSED:
				_localctx = new FuncMouseButtonPressedContext(_localctx);
				enterOuterAlt(_localctx, 79);
				{
				setState(868);
				match(MOUSEBUTTONPRESSED);
				setState(869);
				match(LPAREN);
				setState(870);
				match(RPAREN);
				}
				break;
			case MOUSEBUTTONRELEASED:
				_localctx = new FuncMouseButtonReleasedContext(_localctx);
				enterOuterAlt(_localctx, 80);
				{
				setState(871);
				match(MOUSEBUTTONRELEASED);
				setState(872);
				match(LPAREN);
				setState(873);
				match(RPAREN);
				}
				break;
			case ISKEYPRESSED:
				_localctx = new FuncIsKeyPressedContext(_localctx);
				enterOuterAlt(_localctx, 81);
				{
				setState(874);
				match(ISKEYPRESSED);
				setState(875);
				match(LPAREN);
				setState(876);
				expr(0);
				setState(877);
				match(RPAREN);
				}
				break;
			case SPLITDLR:
				_localctx = new FuncSplitDlrContext(_localctx);
				enterOuterAlt(_localctx, 82);
				{
				setState(879);
				match(SPLITDLR);
				setState(880);
				match(LPAREN);
				setState(881);
				((FuncSplitDlrContext)_localctx).str = expr(0);
				setState(882);
				match(COMMA);
				setState(883);
				((FuncSplitDlrContext)_localctx).regex = expr(0);
				setState(884);
				match(RPAREN);
				}
				break;
			case ALLOCARRAY:
				_localctx = new FuncAllocArrayContext(_localctx);
				enterOuterAlt(_localctx, 83);
				{
				setState(886);
				match(ALLOCARRAY);
				setState(887);
				varsuffix();
				setState(888);
				match(LPAREN);
				setState(889);
				expr(0);
				setState(892);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(890);
					match(COMMA);
					setState(891);
					expr(0);
					}
				}

				setState(894);
				match(RPAREN);
				}
				break;
			case LTRIMDLR:
				_localctx = new FuncLTrimDlrContext(_localctx);
				enterOuterAlt(_localctx, 84);
				{
				setState(896);
				match(LTRIMDLR);
				setState(897);
				match(LPAREN);
				setState(898);
				((FuncLTrimDlrContext)_localctx).str = expr(0);
				setState(899);
				match(RPAREN);
				}
				break;
			case RTRIMDLR:
				_localctx = new FuncRTrimDlrContext(_localctx);
				enterOuterAlt(_localctx, 85);
				{
				setState(901);
				match(RTRIMDLR);
				setState(902);
				match(LPAREN);
				setState(903);
				((FuncRTrimDlrContext)_localctx).str = expr(0);
				setState(904);
				match(RPAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncnameContext extends ParserRuleContext {
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public TerminalNode GET() { return getToken(PuffinBasicParser.GET, 0); }
		public TerminalNode APPEND() { return getToken(PuffinBasicParser.APPEND, 0); }
		public TerminalNode PUT() { return getToken(PuffinBasicParser.PUT, 0); }
		public FuncnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcname; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFuncname(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFuncname(this);
		}
	}

	public final FuncnameContext funcname() throws RecognitionException {
		FuncnameContext _localctx = new FuncnameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_funcname);
		try {
			setState(912);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARNAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(908);
				varname();
				}
				break;
			case GET:
				enterOuterAlt(_localctx, 2);
				{
				setState(909);
				match(GET);
				}
				break;
			case APPEND:
				enterOuterAlt(_localctx, 3);
				{
				setState(910);
				match(APPEND);
				}
				break;
			case PUT:
				enterOuterAlt(_localctx, 4);
				{
				setState(911);
				match(PUT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GosubstmtContext extends ParserRuleContext {
		public TerminalNode GOSUB() { return getToken(PuffinBasicParser.GOSUB, 0); }
		public LinenumContext linenum() {
			return getRuleContext(LinenumContext.class,0);
		}
		public GosubstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gosubstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterGosubstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitGosubstmt(this);
		}
	}

	public final GosubstmtContext gosubstmt() throws RecognitionException {
		GosubstmtContext _localctx = new GosubstmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_gosubstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(914);
			match(GOSUB);
			setState(915);
			linenum();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GosublabelstmtContext extends ParserRuleContext {
		public TerminalNode GOSUB() { return getToken(PuffinBasicParser.GOSUB, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public GosublabelstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gosublabelstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterGosublabelstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitGosublabelstmt(this);
		}
	}

	public final GosublabelstmtContext gosublabelstmt() throws RecognitionException {
		GosublabelstmtContext _localctx = new GosublabelstmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_gosublabelstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(917);
			match(GOSUB);
			setState(918);
			string();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnstmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(PuffinBasicParser.RETURN, 0); }
		public ReturnstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterReturnstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitReturnstmt(this);
		}
	}

	public final ReturnstmtContext returnstmt() throws RecognitionException {
		ReturnstmtContext _localctx = new ReturnstmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_returnstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(920);
			match(RETURN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrinthashusingstmtContext extends ParserRuleContext {
		public ExprContext filenum;
		public ExprContext format;
		public TerminalNode PRINTHASH() { return getToken(PuffinBasicParser.PRINTHASH, 0); }
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public TerminalNode USING() { return getToken(PuffinBasicParser.USING, 0); }
		public TerminalNode SEMICOLON() { return getToken(PuffinBasicParser.SEMICOLON, 0); }
		public PrintlistContext printlist() {
			return getRuleContext(PrintlistContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PrinthashusingstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printhashusingstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterPrinthashusingstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitPrinthashusingstmt(this);
		}
	}

	public final PrinthashusingstmtContext printhashusingstmt() throws RecognitionException {
		PrinthashusingstmtContext _localctx = new PrinthashusingstmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_printhashusingstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(922);
			match(PRINTHASH);
			setState(923);
			((PrinthashusingstmtContext)_localctx).filenum = expr(0);
			setState(924);
			match(COMMA);
			setState(925);
			match(USING);
			setState(926);
			((PrinthashusingstmtContext)_localctx).format = expr(0);
			setState(927);
			match(SEMICOLON);
			setState(928);
			printlist();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintusingstmtContext extends ParserRuleContext {
		public ExprContext format;
		public TerminalNode PRINT() { return getToken(PuffinBasicParser.PRINT, 0); }
		public TerminalNode USING() { return getToken(PuffinBasicParser.USING, 0); }
		public TerminalNode SEMICOLON() { return getToken(PuffinBasicParser.SEMICOLON, 0); }
		public PrintlistContext printlist() {
			return getRuleContext(PrintlistContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintusingstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printusingstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterPrintusingstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitPrintusingstmt(this);
		}
	}

	public final PrintusingstmtContext printusingstmt() throws RecognitionException {
		PrintusingstmtContext _localctx = new PrintusingstmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_printusingstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(930);
			match(PRINT);
			setState(931);
			match(USING);
			setState(932);
			((PrintusingstmtContext)_localctx).format = expr(0);
			setState(933);
			match(SEMICOLON);
			setState(934);
			printlist();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrinthashstmtContext extends ParserRuleContext {
		public ExprContext filenum;
		public TerminalNode PRINTHASH() { return getToken(PuffinBasicParser.PRINTHASH, 0); }
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public PrintlistContext printlist() {
			return getRuleContext(PrintlistContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrinthashstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printhashstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterPrinthashstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitPrinthashstmt(this);
		}
	}

	public final PrinthashstmtContext printhashstmt() throws RecognitionException {
		PrinthashstmtContext _localctx = new PrinthashstmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_printhashstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(936);
			match(PRINTHASH);
			setState(937);
			((PrinthashstmtContext)_localctx).filenum = expr(0);
			setState(938);
			match(COMMA);
			setState(939);
			printlist();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintstmtContext extends ParserRuleContext {
		public TerminalNode QUESTION() { return getToken(PuffinBasicParser.QUESTION, 0); }
		public TerminalNode PRINT() { return getToken(PuffinBasicParser.PRINT, 0); }
		public PrintlistContext printlist() {
			return getRuleContext(PrintlistContext.class,0);
		}
		public PrintstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterPrintstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitPrintstmt(this);
		}
	}

	public final PrintstmtContext printstmt() throws RecognitionException {
		PrintstmtContext _localctx = new PrintstmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_printstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(941);
			_la = _input.LA(1);
			if ( !(_la==PRINT || _la==QUESTION) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(943);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 27)) & ~0x3f) == 0 && ((1L << (_la - 27)) & 289356276045847167L) != 0) || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & -1160802812544612345L) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & 286550323458312185L) != 0)) {
				{
				setState(942);
				printlist();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintlistContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(PuffinBasicParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(PuffinBasicParser.SEMICOLON, i);
		}
		public PrintlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterPrintlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitPrintlist(this);
		}
	}

	public final PrintlistContext printlist() throws RecognitionException {
		PrintlistContext _localctx = new PrintlistContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_printlist);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(945);
			expr(0);
			setState(951);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(949);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case COMMA:
						{
						setState(946);
						match(COMMA);
						}
						break;
					case SEMICOLON:
						{
						setState(947);
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
					case DOUBLE:
						{
						setState(948);
						expr(0);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(953);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WritestmtContext extends ParserRuleContext {
		public TerminalNode WRITE() { return getToken(PuffinBasicParser.WRITE, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public WritestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writestmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterWritestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitWritestmt(this);
		}
	}

	public final WritestmtContext writestmt() throws RecognitionException {
		WritestmtContext _localctx = new WritestmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_writestmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(954);
			match(WRITE);
			setState(963);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 27)) & ~0x3f) == 0 && ((1L << (_la - 27)) & 289356276045847167L) != 0) || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & -1160802812544612345L) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & 286550323458312185L) != 0)) {
				{
				setState(955);
				expr(0);
				setState(960);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(956);
						match(COMMA);
						setState(957);
						expr(0);
						}
						} 
					}
					setState(962);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WritehashstmtContext extends ParserRuleContext {
		public ExprContext filenum;
		public TerminalNode WRITEHASH() { return getToken(PuffinBasicParser.WRITEHASH, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public WritehashstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writehashstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterWritehashstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitWritehashstmt(this);
		}
	}

	public final WritehashstmtContext writehashstmt() throws RecognitionException {
		WritehashstmtContext _localctx = new WritehashstmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_writehashstmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(965);
			match(WRITEHASH);
			setState(966);
			((WritehashstmtContext)_localctx).filenum = expr(0);
			setState(967);
			match(COMMA);
			setState(968);
			expr(0);
			setState(973);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(969);
					match(COMMA);
					setState(970);
					expr(0);
					}
					} 
				}
				setState(975);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LetstmtContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode RELEQ() { return getToken(PuffinBasicParser.RELEQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LET() { return getToken(PuffinBasicParser.LET, 0); }
		public LetstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterLetstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitLetstmt(this);
		}
	}

	public final LetstmtContext letstmt() throws RecognitionException {
		LetstmtContext _localctx = new LetstmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_letstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(977);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LET) {
				{
				setState(976);
				match(LET);
				}
			}

			setState(979);
			variable();
			setState(980);
			match(RELEQ);
			setState(981);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AutoletstmtContext extends ParserRuleContext {
		public TerminalNode AUTO() { return getToken(PuffinBasicParser.AUTO, 0); }
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public TerminalNode RELEQ() { return getToken(PuffinBasicParser.RELEQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AutoletstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_autoletstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterAutoletstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitAutoletstmt(this);
		}
	}

	public final AutoletstmtContext autoletstmt() throws RecognitionException {
		AutoletstmtContext _localctx = new AutoletstmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_autoletstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(983);
			match(AUTO);
			setState(984);
			varname();
			setState(985);
			match(RELEQ);
			setState(986);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfstmtContext extends ParserRuleContext {
		public IfstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifstmt; }
	 
		public IfstmtContext() { }
		public void copyFrom(IfstmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfThenElseContext extends IfstmtContext {
		public TerminalNode IF() { return getToken(PuffinBasicParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ThenContext then() {
			return getRuleContext(ThenContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public TerminalNode ELSE() { return getToken(PuffinBasicParser.ELSE, 0); }
		public ElsestmtContext elsestmt() {
			return getRuleContext(ElsestmtContext.class,0);
		}
		public IfThenElseContext(IfstmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterIfThenElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitIfThenElse(this);
		}
	}

	public final IfstmtContext ifstmt() throws RecognitionException {
		IfstmtContext _localctx = new IfstmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_ifstmt);
		int _la;
		try {
			_localctx = new IfThenElseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(988);
			match(IF);
			setState(989);
			expr(0);
			setState(991);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(990);
				match(COMMA);
				}
			}

			setState(993);
			then();
			setState(995);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				{
				setState(994);
				match(COMMA);
				}
				break;
			}
			setState(999);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(997);
				match(ELSE);
				setState(998);
				elsestmt();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ThenContext extends ParserRuleContext {
		public TerminalNode THEN() { return getToken(PuffinBasicParser.THEN, 0); }
		public LinenumContext linenum() {
			return getRuleContext(LinenumContext.class,0);
		}
		public StmtlistContext stmtlist() {
			return getRuleContext(StmtlistContext.class,0);
		}
		public TerminalNode GOTO() { return getToken(PuffinBasicParser.GOTO, 0); }
		public ThenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_then; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterThen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitThen(this);
		}
	}

	public final ThenContext then() throws RecognitionException {
		ThenContext _localctx = new ThenContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_then);
		try {
			setState(1008);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case THEN:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1001);
				match(THEN);
				setState(1004);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DECIMAL:
					{
					setState(1002);
					linenum();
					}
					break;
				case LIST:
				case DICT:
				case SET:
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
					{
					setState(1003);
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
				setState(1006);
				match(GOTO);
				setState(1007);
				linenum();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElsestmtContext extends ParserRuleContext {
		public LinenumContext linenum() {
			return getRuleContext(LinenumContext.class,0);
		}
		public StmtlistContext stmtlist() {
			return getRuleContext(StmtlistContext.class,0);
		}
		public ElsestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsestmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterElsestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitElsestmt(this);
		}
	}

	public final ElsestmtContext elsestmt() throws RecognitionException {
		ElsestmtContext _localctx = new ElsestmtContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_elsestmt);
		try {
			setState(1012);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1010);
				linenum();
				}
				break;
			case LIST:
			case DICT:
			case SET:
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
				setState(1011);
				stmtlist();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfthenbeginstmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(PuffinBasicParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(PuffinBasicParser.THEN, 0); }
		public TerminalNode BEGIN() { return getToken(PuffinBasicParser.BEGIN, 0); }
		public IfthenbeginstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifthenbeginstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterIfthenbeginstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitIfthenbeginstmt(this);
		}
	}

	public final IfthenbeginstmtContext ifthenbeginstmt() throws RecognitionException {
		IfthenbeginstmtContext _localctx = new IfthenbeginstmtContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_ifthenbeginstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1014);
			match(IF);
			setState(1015);
			expr(0);
			setState(1016);
			match(THEN);
			setState(1017);
			match(BEGIN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElsebeginstmtContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(PuffinBasicParser.ELSE, 0); }
		public TerminalNode BEGIN() { return getToken(PuffinBasicParser.BEGIN, 0); }
		public ElsebeginstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsebeginstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterElsebeginstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitElsebeginstmt(this);
		}
	}

	public final ElsebeginstmtContext elsebeginstmt() throws RecognitionException {
		ElsebeginstmtContext _localctx = new ElsebeginstmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_elsebeginstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1019);
			match(ELSE);
			setState(1020);
			match(BEGIN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EndifstmtContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(PuffinBasicParser.END, 0); }
		public TerminalNode IF() { return getToken(PuffinBasicParser.IF, 0); }
		public EndifstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endifstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterEndifstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitEndifstmt(this);
		}
	}

	public final EndifstmtContext endifstmt() throws RecognitionException {
		EndifstmtContext _localctx = new EndifstmtContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_endifstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1022);
			match(END);
			setState(1023);
			match(IF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtlistContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StmtlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterStmtlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitStmtlist(this);
		}
	}

	public final StmtlistContext stmtlist() throws RecognitionException {
		StmtlistContext _localctx = new StmtlistContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_stmtlist);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1025);
			stmt();
			setState(1030);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1026);
					match(T__0);
					setState(1027);
					stmt();
					}
					} 
				}
				setState(1032);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForstmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(PuffinBasicParser.FOR, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode RELEQ() { return getToken(PuffinBasicParser.RELEQ, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode TO() { return getToken(PuffinBasicParser.TO, 0); }
		public TerminalNode STEP() { return getToken(PuffinBasicParser.STEP, 0); }
		public ForstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterForstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitForstmt(this);
		}
	}

	public final ForstmtContext forstmt() throws RecognitionException {
		ForstmtContext _localctx = new ForstmtContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_forstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1033);
			match(FOR);
			setState(1034);
			variable();
			setState(1035);
			match(RELEQ);
			setState(1036);
			expr(0);
			setState(1037);
			match(TO);
			setState(1038);
			expr(0);
			setState(1041);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STEP) {
				{
				setState(1039);
				match(STEP);
				setState(1040);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NextstmtContext extends ParserRuleContext {
		public TerminalNode NEXT() { return getToken(PuffinBasicParser.NEXT, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public NextstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nextstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterNextstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitNextstmt(this);
		}
	}

	public final NextstmtContext nextstmt() throws RecognitionException {
		NextstmtContext _localctx = new NextstmtContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_nextstmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1043);
			match(NEXT);
			setState(1045);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARNAME) {
				{
				setState(1044);
				variable();
				}
			}

			setState(1051);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1047);
					match(COMMA);
					setState(1048);
					variable();
					}
					} 
				}
				setState(1053);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GotostmtContext extends ParserRuleContext {
		public TerminalNode GOTO() { return getToken(PuffinBasicParser.GOTO, 0); }
		public LinenumContext linenum() {
			return getRuleContext(LinenumContext.class,0);
		}
		public GotostmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gotostmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterGotostmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitGotostmt(this);
		}
	}

	public final GotostmtContext gotostmt() throws RecognitionException {
		GotostmtContext _localctx = new GotostmtContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_gotostmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1054);
			match(GOTO);
			setState(1055);
			linenum();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GotolabelstmtContext extends ParserRuleContext {
		public TerminalNode GOTO() { return getToken(PuffinBasicParser.GOTO, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public GotolabelstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gotolabelstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterGotolabelstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitGotolabelstmt(this);
		}
	}

	public final GotolabelstmtContext gotolabelstmt() throws RecognitionException {
		GotolabelstmtContext _localctx = new GotolabelstmtContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_gotolabelstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1057);
			match(GOTO);
			setState(1058);
			string();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EndstmtContext extends ParserRuleContext {
		public TerminalNode END() { return getToken(PuffinBasicParser.END, 0); }
		public EndstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterEndstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitEndstmt(this);
		}
	}

	public final EndstmtContext endstmt() throws RecognitionException {
		EndstmtContext _localctx = new EndstmtContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_endstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1060);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeffnstmtContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(PuffinBasicParser.DEF, 0); }
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public TerminalNode RELEQ() { return getToken(PuffinBasicParser.RELEQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarsuffixContext varsuffix() {
			return getRuleContext(VarsuffixContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public DeffnstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deffnstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterDeffnstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitDeffnstmt(this);
		}
	}

	public final DeffnstmtContext deffnstmt() throws RecognitionException {
		DeffnstmtContext _localctx = new DeffnstmtContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_deffnstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1062);
			match(DEF);
			setState(1063);
			varname();
			setState(1065);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 185)) & ~0x3f) == 0 && ((1L << (_la - 185)) & 31L) != 0)) {
				{
				setState(1064);
				varsuffix();
				}
			}

			setState(1079);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(1067);
				match(LPAREN);
				setState(1076);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VARNAME) {
					{
					setState(1068);
					variable();
					setState(1073);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==COMMA) {
						{
						{
						setState(1069);
						match(COMMA);
						setState(1070);
						variable();
						}
						}
						setState(1075);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(1078);
				match(RPAREN);
				}
			}

			setState(1081);
			match(RELEQ);
			setState(1082);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionbeginstmtContext extends ParserRuleContext {
		public VarnameContext fnname;
		public VarsuffixContext fnrettype;
		public TerminalNode FUNCTION() { return getToken(PuffinBasicParser.FUNCTION, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(PuffinBasicParser.LBRACE, 0); }
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public List<CompositetypeContext> compositetype() {
			return getRuleContexts(CompositetypeContext.class);
		}
		public CompositetypeContext compositetype(int i) {
			return getRuleContext(CompositetypeContext.class,i);
		}
		public VarsuffixContext varsuffix() {
			return getRuleContext(VarsuffixContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public FunctionbeginstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionbeginstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFunctionbeginstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFunctionbeginstmt(this);
		}
	}

	public final FunctionbeginstmtContext functionbeginstmt() throws RecognitionException {
		FunctionbeginstmtContext _localctx = new FunctionbeginstmtContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_functionbeginstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1084);
			match(FUNCTION);
			setState(1085);
			((FunctionbeginstmtContext)_localctx).fnname = varname();
			setState(1087);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 185)) & ~0x3f) == 0 && ((1L << (_la - 185)) & 31L) != 0)) {
				{
				setState(1086);
				((FunctionbeginstmtContext)_localctx).fnrettype = varsuffix();
				}
			}

			setState(1089);
			match(LPAREN);
			setState(1098);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34359738424L) != 0) || _la==VARNAME) {
				{
				setState(1090);
				compositetype();
				setState(1095);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1091);
					match(COMMA);
					setState(1092);
					compositetype();
					}
					}
					setState(1097);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1100);
			match(RPAREN);
			setState(1101);
			match(LBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionreturnstmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(PuffinBasicParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunctionreturnstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionreturnstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFunctionreturnstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFunctionreturnstmt(this);
		}
	}

	public final FunctionreturnstmtContext functionreturnstmt() throws RecognitionException {
		FunctionreturnstmtContext _localctx = new FunctionreturnstmtContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_functionreturnstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1103);
			match(RETURN);
			setState(1104);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionendstmtContext extends ParserRuleContext {
		public TerminalNode RBRACE() { return getToken(PuffinBasicParser.RBRACE, 0); }
		public FunctionendstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionendstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFunctionendstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFunctionendstmt(this);
		}
	}

	public final FunctionendstmtContext functionendstmt() throws RecognitionException {
		FunctionendstmtContext _localctx = new FunctionendstmtContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_functionendstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1106);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportstmtContext extends ParserRuleContext {
		public StringContext filename;
		public TerminalNode IMPORT() { return getToken(PuffinBasicParser.IMPORT, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public ImportstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterImportstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitImportstmt(this);
		}
	}

	public final ImportstmtContext importstmt() throws RecognitionException {
		ImportstmtContext _localctx = new ImportstmtContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_importstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1108);
			match(IMPORT);
			setState(1109);
			((ImportstmtContext)_localctx).filename = string();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LibtagstmtContext extends ParserRuleContext {
		public StringContext tag;
		public TerminalNode LIBTAG() { return getToken(PuffinBasicParser.LIBTAG, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public LibtagstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_libtagstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterLibtagstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitLibtagstmt(this);
		}
	}

	public final LibtagstmtContext libtagstmt() throws RecognitionException {
		LibtagstmtContext _localctx = new LibtagstmtContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_libtagstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1111);
			match(LIBTAG);
			setState(1112);
			((LibtagstmtContext)_localctx).tag = string();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DimstmtContext extends ParserRuleContext {
		public TerminalNode DIM() { return getToken(PuffinBasicParser.DIM, 0); }
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public VarsuffixContext varsuffix() {
			return getRuleContext(VarsuffixContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public DimstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterDimstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitDimstmt(this);
		}
	}

	public final DimstmtContext dimstmt() throws RecognitionException {
		DimstmtContext _localctx = new DimstmtContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_dimstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1114);
			match(DIM);
			setState(1115);
			varname();
			setState(1117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 185)) & ~0x3f) == 0 && ((1L << (_la - 185)) & 31L) != 0)) {
				{
				setState(1116);
				varsuffix();
				}
			}

			setState(1119);
			match(LPAREN);
			setState(1120);
			expr(0);
			setState(1125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1121);
				match(COMMA);
				setState(1122);
				expr(0);
				}
				}
				setState(1127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1128);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReallocstmtContext extends ParserRuleContext {
		public TerminalNode REALLOCARRAY() { return getToken(PuffinBasicParser.REALLOCARRAY, 0); }
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public VarsuffixContext varsuffix() {
			return getRuleContext(VarsuffixContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public ReallocstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reallocstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterReallocstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitReallocstmt(this);
		}
	}

	public final ReallocstmtContext reallocstmt() throws RecognitionException {
		ReallocstmtContext _localctx = new ReallocstmtContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_reallocstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1130);
			match(REALLOCARRAY);
			setState(1131);
			varname();
			setState(1133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 185)) & ~0x3f) == 0 && ((1L << (_la - 185)) & 31L) != 0)) {
				{
				setState(1132);
				varsuffix();
				}
			}

			setState(1135);
			match(LPAREN);
			setState(1136);
			expr(0);
			setState(1141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1137);
				match(COMMA);
				setState(1138);
				expr(0);
				}
				}
				setState(1143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1144);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhilestmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(PuffinBasicParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WhilestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whilestmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterWhilestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitWhilestmt(this);
		}
	}

	public final WhilestmtContext whilestmt() throws RecognitionException {
		WhilestmtContext _localctx = new WhilestmtContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_whilestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1146);
			match(WHILE);
			setState(1147);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WendstmtContext extends ParserRuleContext {
		public TerminalNode WEND() { return getToken(PuffinBasicParser.WEND, 0); }
		public WendstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wendstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterWendstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitWendstmt(this);
		}
	}

	public final WendstmtContext wendstmt() throws RecognitionException {
		WendstmtContext _localctx = new WendstmtContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_wendstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1149);
			match(WEND);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LsetstmtContext extends ParserRuleContext {
		public TerminalNode LSET() { return getToken(PuffinBasicParser.LSET, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode RELEQ() { return getToken(PuffinBasicParser.RELEQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LsetstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lsetstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterLsetstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitLsetstmt(this);
		}
	}

	public final LsetstmtContext lsetstmt() throws RecognitionException {
		LsetstmtContext _localctx = new LsetstmtContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_lsetstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1151);
			match(LSET);
			setState(1152);
			variable();
			setState(1153);
			match(RELEQ);
			setState(1154);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RsetstmtContext extends ParserRuleContext {
		public TerminalNode RSET() { return getToken(PuffinBasicParser.RSET, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode RELEQ() { return getToken(PuffinBasicParser.RELEQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RsetstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rsetstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterRsetstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitRsetstmt(this);
		}
	}

	public final RsetstmtContext rsetstmt() throws RecognitionException {
		RsetstmtContext _localctx = new RsetstmtContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_rsetstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1156);
			match(RSET);
			setState(1157);
			variable();
			setState(1158);
			match(RELEQ);
			setState(1159);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SwapstmtContext extends ParserRuleContext {
		public TerminalNode SWAP() { return getToken(PuffinBasicParser.SWAP, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public SwapstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_swapstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterSwapstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitSwapstmt(this);
		}
	}

	public final SwapstmtContext swapstmt() throws RecognitionException {
		SwapstmtContext _localctx = new SwapstmtContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_swapstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1161);
			match(SWAP);
			setState(1162);
			variable();
			setState(1163);
			match(COMMA);
			setState(1164);
			variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Open1stmtContext extends ParserRuleContext {
		public Token filenum;
		public ExprContext filename;
		public ExprContext reclen;
		public TerminalNode OPEN() { return getToken(PuffinBasicParser.OPEN, 0); }
		public Filemode1Context filemode1() {
			return getRuleContext(Filemode1Context.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public TerminalNode DECIMAL() { return getToken(PuffinBasicParser.DECIMAL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode HASH() { return getToken(PuffinBasicParser.HASH, 0); }
		public Open1stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open1stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterOpen1stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitOpen1stmt(this);
		}
	}

	public final Open1stmtContext open1stmt() throws RecognitionException {
		Open1stmtContext _localctx = new Open1stmtContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_open1stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1166);
			match(OPEN);
			setState(1167);
			filemode1();
			setState(1168);
			match(COMMA);
			setState(1170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH) {
				{
				setState(1169);
				match(HASH);
				}
			}

			setState(1172);
			((Open1stmtContext)_localctx).filenum = match(DECIMAL);
			setState(1173);
			match(COMMA);
			setState(1174);
			((Open1stmtContext)_localctx).filename = expr(0);
			setState(1177);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				setState(1175);
				match(COMMA);
				setState(1176);
				((Open1stmtContext)_localctx).reclen = expr(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Open2stmtContext extends ParserRuleContext {
		public ExprContext filename;
		public Token filenum;
		public ExprContext reclen;
		public TerminalNode OPEN() { return getToken(PuffinBasicParser.OPEN, 0); }
		public TerminalNode AS() { return getToken(PuffinBasicParser.AS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode DECIMAL() { return getToken(PuffinBasicParser.DECIMAL, 0); }
		public TerminalNode FOR() { return getToken(PuffinBasicParser.FOR, 0); }
		public Filemode2Context filemode2() {
			return getRuleContext(Filemode2Context.class,0);
		}
		public TerminalNode ACCESS() { return getToken(PuffinBasicParser.ACCESS, 0); }
		public AccessContext access() {
			return getRuleContext(AccessContext.class,0);
		}
		public LockContext lock() {
			return getRuleContext(LockContext.class,0);
		}
		public TerminalNode HASH() { return getToken(PuffinBasicParser.HASH, 0); }
		public TerminalNode LEN() { return getToken(PuffinBasicParser.LEN, 0); }
		public TerminalNode RELEQ() { return getToken(PuffinBasicParser.RELEQ, 0); }
		public Open2stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open2stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterOpen2stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitOpen2stmt(this);
		}
	}

	public final Open2stmtContext open2stmt() throws RecognitionException {
		Open2stmtContext _localctx = new Open2stmtContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_open2stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1179);
			match(OPEN);
			setState(1180);
			((Open2stmtContext)_localctx).filename = expr(0);
			setState(1183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FOR) {
				{
				setState(1181);
				match(FOR);
				setState(1182);
				filemode2();
				}
			}

			setState(1187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ACCESS) {
				{
				setState(1185);
				match(ACCESS);
				setState(1186);
				access();
				}
			}

			setState(1190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SHARED || _la==LOCK) {
				{
				setState(1189);
				lock();
				}
			}

			setState(1192);
			match(AS);
			setState(1194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH) {
				{
				setState(1193);
				match(HASH);
				}
			}

			setState(1196);
			((Open2stmtContext)_localctx).filenum = match(DECIMAL);
			setState(1200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEN) {
				{
				setState(1197);
				match(LEN);
				setState(1198);
				match(RELEQ);
				setState(1199);
				((Open2stmtContext)_localctx).reclen = expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClosestmtContext extends ParserRuleContext {
		public TerminalNode CLOSE() { return getToken(PuffinBasicParser.CLOSE, 0); }
		public List<TerminalNode> DECIMAL() { return getTokens(PuffinBasicParser.DECIMAL); }
		public TerminalNode DECIMAL(int i) {
			return getToken(PuffinBasicParser.DECIMAL, i);
		}
		public List<TerminalNode> HASH() { return getTokens(PuffinBasicParser.HASH); }
		public TerminalNode HASH(int i) {
			return getToken(PuffinBasicParser.HASH, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public ClosestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closestmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterClosestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitClosestmt(this);
		}
	}

	public final ClosestmtContext closestmt() throws RecognitionException {
		ClosestmtContext _localctx = new ClosestmtContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_closestmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1202);
			match(CLOSE);
			setState(1217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH || _la==DECIMAL) {
				{
				setState(1204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==HASH) {
					{
					setState(1203);
					match(HASH);
					}
				}

				setState(1206);
				match(DECIMAL);
				setState(1214);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1207);
						match(COMMA);
						setState(1209);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==HASH) {
							{
							setState(1208);
							match(HASH);
							}
						}

						setState(1211);
						match(DECIMAL);
						}
						} 
					}
					setState(1216);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Filemode1Context extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PuffinBasicParser.STRING, 0); }
		public Filemode1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filemode1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFilemode1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFilemode1(this);
		}
	}

	public final Filemode1Context filemode1() throws RecognitionException {
		Filemode1Context _localctx = new Filemode1Context(_ctx, getState());
		enterRule(_localctx, 106, RULE_filemode1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1219);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Filemode2Context extends ParserRuleContext {
		public TerminalNode INPUT() { return getToken(PuffinBasicParser.INPUT, 0); }
		public TerminalNode OUTPUT() { return getToken(PuffinBasicParser.OUTPUT, 0); }
		public TerminalNode APPEND() { return getToken(PuffinBasicParser.APPEND, 0); }
		public TerminalNode RANDOM() { return getToken(PuffinBasicParser.RANDOM, 0); }
		public Filemode2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filemode2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFilemode2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFilemode2(this);
		}
	}

	public final Filemode2Context filemode2() throws RecognitionException {
		Filemode2Context _localctx = new Filemode2Context(_ctx, getState());
		enterRule(_localctx, 108, RULE_filemode2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1221);
			_la = _input.LA(1);
			if ( !(((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & 57L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AccessContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(PuffinBasicParser.READ, 0); }
		public TerminalNode WRITE() { return getToken(PuffinBasicParser.WRITE, 0); }
		public AccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitAccess(this);
		}
	}

	public final AccessContext access() throws RecognitionException {
		AccessContext _localctx = new AccessContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_access);
		try {
			setState(1227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1223);
				match(READ);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1224);
				match(WRITE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1225);
				match(READ);
				setState(1226);
				match(WRITE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LockContext extends ParserRuleContext {
		public TerminalNode SHARED() { return getToken(PuffinBasicParser.SHARED, 0); }
		public TerminalNode LOCK() { return getToken(PuffinBasicParser.LOCK, 0); }
		public TerminalNode READ() { return getToken(PuffinBasicParser.READ, 0); }
		public TerminalNode WRITE() { return getToken(PuffinBasicParser.WRITE, 0); }
		public LockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterLock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitLock(this);
		}
	}

	public final LockContext lock() throws RecognitionException {
		LockContext _localctx = new LockContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_lock);
		try {
			setState(1237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1229);
				match(SHARED);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1230);
				match(LOCK);
				setState(1231);
				match(READ);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1232);
				match(LOCK);
				setState(1233);
				match(WRITE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1234);
				match(LOCK);
				setState(1235);
				match(READ);
				setState(1236);
				match(WRITE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PutstmtContext extends ParserRuleContext {
		public Token filenum;
		public TerminalNode PUT() { return getToken(PuffinBasicParser.PUT, 0); }
		public TerminalNode DECIMAL() { return getToken(PuffinBasicParser.DECIMAL, 0); }
		public TerminalNode HASH() { return getToken(PuffinBasicParser.HASH, 0); }
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PutstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_putstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterPutstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitPutstmt(this);
		}
	}

	public final PutstmtContext putstmt() throws RecognitionException {
		PutstmtContext _localctx = new PutstmtContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_putstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1239);
			match(PUT);
			setState(1241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH) {
				{
				setState(1240);
				match(HASH);
				}
			}

			setState(1243);
			((PutstmtContext)_localctx).filenum = match(DECIMAL);
			setState(1246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				{
				setState(1244);
				match(COMMA);
				setState(1245);
				expr(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GetstmtContext extends ParserRuleContext {
		public Token filenum;
		public TerminalNode GET() { return getToken(PuffinBasicParser.GET, 0); }
		public TerminalNode DECIMAL() { return getToken(PuffinBasicParser.DECIMAL, 0); }
		public TerminalNode HASH() { return getToken(PuffinBasicParser.HASH, 0); }
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public GetstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterGetstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitGetstmt(this);
		}
	}

	public final GetstmtContext getstmt() throws RecognitionException {
		GetstmtContext _localctx = new GetstmtContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_getstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1248);
			match(GET);
			setState(1250);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH) {
				{
				setState(1249);
				match(HASH);
				}
			}

			setState(1252);
			((GetstmtContext)_localctx).filenum = match(DECIMAL);
			setState(1255);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				{
				setState(1253);
				match(COMMA);
				setState(1254);
				expr(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldstmtContext extends ParserRuleContext {
		public ExprContext filenum;
		public TerminalNode FIELD() { return getToken(PuffinBasicParser.FIELD, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public List<TerminalNode> DECIMAL() { return getTokens(PuffinBasicParser.DECIMAL); }
		public TerminalNode DECIMAL(int i) {
			return getToken(PuffinBasicParser.DECIMAL, i);
		}
		public List<TerminalNode> AS() { return getTokens(PuffinBasicParser.AS); }
		public TerminalNode AS(int i) {
			return getToken(PuffinBasicParser.AS, i);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode HASH() { return getToken(PuffinBasicParser.HASH, 0); }
		public FieldstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFieldstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFieldstmt(this);
		}
	}

	public final FieldstmtContext fieldstmt() throws RecognitionException {
		FieldstmtContext _localctx = new FieldstmtContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_fieldstmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1257);
			match(FIELD);
			setState(1259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HASH) {
				{
				setState(1258);
				match(HASH);
				}
			}

			setState(1261);
			((FieldstmtContext)_localctx).filenum = expr(0);
			setState(1262);
			match(COMMA);
			setState(1263);
			match(DECIMAL);
			setState(1264);
			match(AS);
			setState(1265);
			variable();
			setState(1272);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1266);
					match(COMMA);
					setState(1267);
					match(DECIMAL);
					setState(1268);
					match(AS);
					setState(1269);
					variable();
					}
					} 
				}
				setState(1274);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InputstmtContext extends ParserRuleContext {
		public TerminalNode INPUT() { return getToken(PuffinBasicParser.INPUT, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(PuffinBasicParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(PuffinBasicParser.SEMICOLON, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public InputstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterInputstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitInputstmt(this);
		}
	}

	public final InputstmtContext inputstmt() throws RecognitionException {
		InputstmtContext _localctx = new InputstmtContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_inputstmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1275);
			match(INPUT);
			setState(1277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(1276);
				match(SEMICOLON);
				}
			}

			{
			setState(1279);
			expr(0);
			setState(1280);
			_la = _input.LA(1);
			if ( !(_la==COMMA || _la==SEMICOLON) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
			setState(1282);
			variable();
			setState(1287);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1283);
					match(COMMA);
					setState(1284);
					variable();
					}
					} 
				}
				setState(1289);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InputhashstmtContext extends ParserRuleContext {
		public ExprContext filenum;
		public TerminalNode INPUTHASH() { return getToken(PuffinBasicParser.INPUTHASH, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InputhashstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputhashstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterInputhashstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitInputhashstmt(this);
		}
	}

	public final InputhashstmtContext inputhashstmt() throws RecognitionException {
		InputhashstmtContext _localctx = new InputhashstmtContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_inputhashstmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1290);
			match(INPUTHASH);
			setState(1291);
			((InputhashstmtContext)_localctx).filenum = expr(0);
			setState(1292);
			match(COMMA);
			setState(1293);
			variable();
			setState(1298);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1294);
					match(COMMA);
					setState(1295);
					variable();
					}
					} 
				}
				setState(1300);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LineinputstmtContext extends ParserRuleContext {
		public TerminalNode LINE() { return getToken(PuffinBasicParser.LINE, 0); }
		public TerminalNode INPUT() { return getToken(PuffinBasicParser.INPUT, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(PuffinBasicParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(PuffinBasicParser.SEMICOLON, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LineinputstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lineinputstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterLineinputstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitLineinputstmt(this);
		}
	}

	public final LineinputstmtContext lineinputstmt() throws RecognitionException {
		LineinputstmtContext _localctx = new LineinputstmtContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_lineinputstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1301);
			match(LINE);
			setState(1302);
			match(INPUT);
			setState(1304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(1303);
				match(SEMICOLON);
				}
			}

			setState(1309);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				{
				setState(1306);
				expr(0);
				setState(1307);
				match(SEMICOLON);
				}
				break;
			}
			setState(1311);
			variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LineinputhashstmtContext extends ParserRuleContext {
		public ExprContext filenum;
		public TerminalNode LINE() { return getToken(PuffinBasicParser.LINE, 0); }
		public TerminalNode INPUTHASH() { return getToken(PuffinBasicParser.INPUTHASH, 0); }
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LineinputhashstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lineinputhashstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterLineinputhashstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitLineinputhashstmt(this);
		}
	}

	public final LineinputhashstmtContext lineinputhashstmt() throws RecognitionException {
		LineinputhashstmtContext _localctx = new LineinputhashstmtContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_lineinputhashstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1313);
			match(LINE);
			setState(1314);
			match(INPUTHASH);
			setState(1315);
			((LineinputhashstmtContext)_localctx).filenum = expr(0);
			setState(1316);
			match(COMMA);
			setState(1317);
			variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReadstmtContext extends ParserRuleContext {
		public TerminalNode READ() { return getToken(PuffinBasicParser.READ, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public ReadstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterReadstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitReadstmt(this);
		}
	}

	public final ReadstmtContext readstmt() throws RecognitionException {
		ReadstmtContext _localctx = new ReadstmtContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_readstmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1319);
			match(READ);
			setState(1320);
			variable();
			setState(1325);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1321);
					match(COMMA);
					setState(1322);
					variable();
					}
					} 
				}
				setState(1327);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,81,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DatastmtContext extends ParserRuleContext {
		public Token str;
		public TerminalNode DATA() { return getToken(PuffinBasicParser.DATA, 0); }
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public List<TerminalNode> STRING() { return getTokens(PuffinBasicParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(PuffinBasicParser.STRING, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public DatastmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datastmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterDatastmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitDatastmt(this);
		}
	}

	public final DatastmtContext datastmt() throws RecognitionException {
		DatastmtContext _localctx = new DatastmtContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_datastmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1328);
			match(DATA);
			setState(1331);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(1329);
				((DatastmtContext)_localctx).str = match(STRING);
				}
				break;
			case DECIMAL:
			case HEXADECIMAL:
			case OCTAL:
			case FLOAT:
			case DOUBLE:
				{
				setState(1330);
				number();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1340);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1333);
					match(COMMA);
					setState(1336);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case STRING:
						{
						setState(1334);
						((DatastmtContext)_localctx).str = match(STRING);
						}
						break;
					case DECIMAL:
					case HEXADECIMAL:
					case OCTAL:
					case FLOAT:
					case DOUBLE:
						{
						setState(1335);
						number();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					} 
				}
				setState(1342);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RestorestmtContext extends ParserRuleContext {
		public TerminalNode RESTORE() { return getToken(PuffinBasicParser.RESTORE, 0); }
		public RestorestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_restorestmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterRestorestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitRestorestmt(this);
		}
	}

	public final RestorestmtContext restorestmt() throws RecognitionException {
		RestorestmtContext _localctx = new RestorestmtContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_restorestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1343);
			match(RESTORE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RandomizestmtContext extends ParserRuleContext {
		public TerminalNode RANDOMIZE() { return getToken(PuffinBasicParser.RANDOMIZE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RandomizestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_randomizestmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterRandomizestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitRandomizestmt(this);
		}
	}

	public final RandomizestmtContext randomizestmt() throws RecognitionException {
		RandomizestmtContext _localctx = new RandomizestmtContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_randomizestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1345);
			match(RANDOMIZE);
			setState(1346);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RandomizetimerstmtContext extends ParserRuleContext {
		public TerminalNode RANDOMIZE() { return getToken(PuffinBasicParser.RANDOMIZE, 0); }
		public TerminalNode TIMER() { return getToken(PuffinBasicParser.TIMER, 0); }
		public RandomizetimerstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_randomizetimerstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterRandomizetimerstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitRandomizetimerstmt(this);
		}
	}

	public final RandomizetimerstmtContext randomizetimerstmt() throws RecognitionException {
		RandomizetimerstmtContext _localctx = new RandomizetimerstmtContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_randomizetimerstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1348);
			match(RANDOMIZE);
			setState(1349);
			match(TIMER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefintstmtContext extends ParserRuleContext {
		public TerminalNode DEFINT() { return getToken(PuffinBasicParser.DEFINT, 0); }
		public List<TerminalNode> LETTERRANGE() { return getTokens(PuffinBasicParser.LETTERRANGE); }
		public TerminalNode LETTERRANGE(int i) {
			return getToken(PuffinBasicParser.LETTERRANGE, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public DefintstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defintstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterDefintstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitDefintstmt(this);
		}
	}

	public final DefintstmtContext defintstmt() throws RecognitionException {
		DefintstmtContext _localctx = new DefintstmtContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_defintstmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1351);
			match(DEFINT);
			setState(1352);
			match(LETTERRANGE);
			setState(1357);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1353);
					match(COMMA);
					setState(1354);
					match(LETTERRANGE);
					}
					} 
				}
				setState(1359);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,85,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeflngstmtContext extends ParserRuleContext {
		public TerminalNode DEFLNG() { return getToken(PuffinBasicParser.DEFLNG, 0); }
		public List<TerminalNode> LETTERRANGE() { return getTokens(PuffinBasicParser.LETTERRANGE); }
		public TerminalNode LETTERRANGE(int i) {
			return getToken(PuffinBasicParser.LETTERRANGE, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public DeflngstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deflngstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterDeflngstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitDeflngstmt(this);
		}
	}

	public final DeflngstmtContext deflngstmt() throws RecognitionException {
		DeflngstmtContext _localctx = new DeflngstmtContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_deflngstmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1360);
			match(DEFLNG);
			setState(1361);
			match(LETTERRANGE);
			setState(1366);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1362);
					match(COMMA);
					setState(1363);
					match(LETTERRANGE);
					}
					} 
				}
				setState(1368);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefsngstmtContext extends ParserRuleContext {
		public TerminalNode DEFSNG() { return getToken(PuffinBasicParser.DEFSNG, 0); }
		public List<TerminalNode> LETTERRANGE() { return getTokens(PuffinBasicParser.LETTERRANGE); }
		public TerminalNode LETTERRANGE(int i) {
			return getToken(PuffinBasicParser.LETTERRANGE, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public DefsngstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defsngstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterDefsngstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitDefsngstmt(this);
		}
	}

	public final DefsngstmtContext defsngstmt() throws RecognitionException {
		DefsngstmtContext _localctx = new DefsngstmtContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_defsngstmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1369);
			match(DEFSNG);
			setState(1370);
			match(LETTERRANGE);
			setState(1375);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1371);
					match(COMMA);
					setState(1372);
					match(LETTERRANGE);
					}
					} 
				}
				setState(1377);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,87,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefdblstmtContext extends ParserRuleContext {
		public TerminalNode DEFDBL() { return getToken(PuffinBasicParser.DEFDBL, 0); }
		public List<TerminalNode> LETTERRANGE() { return getTokens(PuffinBasicParser.LETTERRANGE); }
		public TerminalNode LETTERRANGE(int i) {
			return getToken(PuffinBasicParser.LETTERRANGE, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public DefdblstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defdblstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterDefdblstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitDefdblstmt(this);
		}
	}

	public final DefdblstmtContext defdblstmt() throws RecognitionException {
		DefdblstmtContext _localctx = new DefdblstmtContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_defdblstmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1378);
			match(DEFDBL);
			setState(1379);
			match(LETTERRANGE);
			setState(1384);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1380);
					match(COMMA);
					setState(1381);
					match(LETTERRANGE);
					}
					} 
				}
				setState(1386);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefstrstmtContext extends ParserRuleContext {
		public TerminalNode DEFSTR() { return getToken(PuffinBasicParser.DEFSTR, 0); }
		public List<TerminalNode> LETTERRANGE() { return getTokens(PuffinBasicParser.LETTERRANGE); }
		public TerminalNode LETTERRANGE(int i) {
			return getToken(PuffinBasicParser.LETTERRANGE, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public DefstrstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defstrstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterDefstrstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitDefstrstmt(this);
		}
	}

	public final DefstrstmtContext defstrstmt() throws RecognitionException {
		DefstrstmtContext _localctx = new DefstrstmtContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_defstrstmt);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1387);
			match(DEFSTR);
			setState(1388);
			match(LETTERRANGE);
			setState(1393);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1389);
					match(COMMA);
					setState(1390);
					match(LETTERRANGE);
					}
					} 
				}
				setState(1395);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MiddlrstmtContext extends ParserRuleContext {
		public TerminalNode MIDDLR() { return getToken(PuffinBasicParser.MIDDLR, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public TerminalNode RELEQ() { return getToken(PuffinBasicParser.RELEQ, 0); }
		public MiddlrstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_middlrstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterMiddlrstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitMiddlrstmt(this);
		}
	}

	public final MiddlrstmtContext middlrstmt() throws RecognitionException {
		MiddlrstmtContext _localctx = new MiddlrstmtContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_middlrstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1396);
			match(MIDDLR);
			setState(1397);
			match(LPAREN);
			setState(1398);
			variable();
			setState(1399);
			match(COMMA);
			setState(1400);
			expr(0);
			setState(1403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1401);
				match(COMMA);
				setState(1402);
				expr(0);
				}
			}

			setState(1405);
			match(RPAREN);
			setState(1406);
			match(RELEQ);
			setState(1407);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SleepstmtContext extends ParserRuleContext {
		public TerminalNode SLEEP() { return getToken(PuffinBasicParser.SLEEP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SleepstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sleepstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterSleepstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitSleepstmt(this);
		}
	}

	public final SleepstmtContext sleepstmt() throws RecognitionException {
		SleepstmtContext _localctx = new SleepstmtContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_sleepstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1409);
			match(SLEEP);
			setState(1410);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
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
		public TerminalNode SCREEN() { return getToken(PuffinBasicParser.SCREEN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MANUAL_REPAINT() { return getToken(PuffinBasicParser.MANUAL_REPAINT, 0); }
		public TerminalNode DOUBLE_BUFFER() { return getToken(PuffinBasicParser.DOUBLE_BUFFER, 0); }
		public ScreenstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_screenstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterScreenstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitScreenstmt(this);
		}
	}

	public final ScreenstmtContext screenstmt() throws RecognitionException {
		ScreenstmtContext _localctx = new ScreenstmtContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_screenstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1412);
			match(SCREEN);
			setState(1413);
			((ScreenstmtContext)_localctx).title = expr(0);
			setState(1414);
			match(COMMA);
			setState(1415);
			((ScreenstmtContext)_localctx).w = expr(0);
			setState(1416);
			match(COMMA);
			setState(1417);
			((ScreenstmtContext)_localctx).h = expr(0);
			setState(1423);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				{
				setState(1418);
				match(COMMA);
				setState(1419);
				((ScreenstmtContext)_localctx).iw = expr(0);
				setState(1420);
				match(COMMA);
				setState(1421);
				((ScreenstmtContext)_localctx).ih = expr(0);
				}
				break;
			}
			setState(1427);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				{
				setState(1425);
				match(COMMA);
				setState(1426);
				((ScreenstmtContext)_localctx).mr = match(MANUAL_REPAINT);
				}
				break;
			}
			setState(1431);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				{
				setState(1429);
				match(COMMA);
				setState(1430);
				((ScreenstmtContext)_localctx).db = match(DOUBLE_BUFFER);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RepaintstmtContext extends ParserRuleContext {
		public TerminalNode REPAINT() { return getToken(PuffinBasicParser.REPAINT, 0); }
		public RepaintstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repaintstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterRepaintstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitRepaintstmt(this);
		}
	}

	public final RepaintstmtContext repaintstmt() throws RecognitionException {
		RepaintstmtContext _localctx = new RepaintstmtContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_repaintstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1433);
			match(REPAINT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
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
		public TerminalNode CIRCLE() { return getToken(PuffinBasicParser.CIRCLE, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public CirclestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_circlestmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterCirclestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitCirclestmt(this);
		}
	}

	public final CirclestmtContext circlestmt() throws RecognitionException {
		CirclestmtContext _localctx = new CirclestmtContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_circlestmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1435);
			match(CIRCLE);
			setState(1436);
			match(LPAREN);
			setState(1437);
			((CirclestmtContext)_localctx).x = expr(0);
			setState(1438);
			match(COMMA);
			setState(1439);
			((CirclestmtContext)_localctx).y = expr(0);
			setState(1440);
			match(RPAREN);
			setState(1441);
			match(COMMA);
			setState(1442);
			((CirclestmtContext)_localctx).r1 = expr(0);
			setState(1443);
			match(COMMA);
			setState(1444);
			((CirclestmtContext)_localctx).r2 = expr(0);
			setState(1459);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
			case 1:
				{
				setState(1445);
				match(COMMA);
				setState(1447);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 27)) & ~0x3f) == 0 && ((1L << (_la - 27)) & 289356276045847167L) != 0) || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & -1160802812544612345L) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & 286550323458312185L) != 0)) {
					{
					setState(1446);
					((CirclestmtContext)_localctx).s = expr(0);
					}
				}

				setState(1449);
				match(COMMA);
				setState(1451);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,95,_ctx) ) {
				case 1:
					{
					setState(1450);
					((CirclestmtContext)_localctx).e = expr(0);
					}
					break;
				}
				setState(1454);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,96,_ctx) ) {
				case 1:
					{
					setState(1453);
					match(COMMA);
					}
					break;
				}
				setState(1457);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 27)) & ~0x3f) == 0 && ((1L << (_la - 27)) & 289356276045847167L) != 0) || ((((_la - 97)) & ~0x3f) == 0 && ((1L << (_la - 97)) & -1160802812544612345L) != 0) || ((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & 286550323458312185L) != 0)) {
					{
					setState(1456);
					((CirclestmtContext)_localctx).fill = expr(0);
					}
				}

				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LinestmtContext extends ParserRuleContext {
		public ExprContext x1;
		public ExprContext y1;
		public ExprContext x2;
		public ExprContext y2;
		public ExprContext bf;
		public TerminalNode LINE() { return getToken(PuffinBasicParser.LINE, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(PuffinBasicParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(PuffinBasicParser.LPAREN, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(PuffinBasicParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(PuffinBasicParser.RPAREN, i);
		}
		public TerminalNode MINUS() { return getToken(PuffinBasicParser.MINUS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LinestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linestmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterLinestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitLinestmt(this);
		}
	}

	public final LinestmtContext linestmt() throws RecognitionException {
		LinestmtContext _localctx = new LinestmtContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_linestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1461);
			match(LINE);
			setState(1462);
			match(LPAREN);
			setState(1463);
			((LinestmtContext)_localctx).x1 = expr(0);
			setState(1464);
			match(COMMA);
			setState(1465);
			((LinestmtContext)_localctx).y1 = expr(0);
			setState(1466);
			match(RPAREN);
			setState(1467);
			match(MINUS);
			setState(1468);
			match(LPAREN);
			setState(1469);
			((LinestmtContext)_localctx).x2 = expr(0);
			setState(1470);
			match(COMMA);
			setState(1471);
			((LinestmtContext)_localctx).y2 = expr(0);
			setState(1472);
			match(RPAREN);
			setState(1475);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				{
				setState(1473);
				match(COMMA);
				setState(1474);
				((LinestmtContext)_localctx).bf = expr(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ColorstmtContext extends ParserRuleContext {
		public ExprContext r;
		public ExprContext g;
		public ExprContext b;
		public TerminalNode COLOR() { return getToken(PuffinBasicParser.COLOR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ColorstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_colorstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterColorstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitColorstmt(this);
		}
	}

	public final ColorstmtContext colorstmt() throws RecognitionException {
		ColorstmtContext _localctx = new ColorstmtContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_colorstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1477);
			match(COLOR);
			setState(1478);
			((ColorstmtContext)_localctx).r = expr(0);
			setState(1479);
			match(COMMA);
			setState(1480);
			((ColorstmtContext)_localctx).g = expr(0);
			setState(1481);
			match(COMMA);
			setState(1482);
			((ColorstmtContext)_localctx).b = expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PaintstmtContext extends ParserRuleContext {
		public ExprContext x;
		public ExprContext y;
		public ExprContext r;
		public ExprContext g;
		public ExprContext b;
		public TerminalNode PAINT() { return getToken(PuffinBasicParser.PAINT, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PaintstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paintstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterPaintstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitPaintstmt(this);
		}
	}

	public final PaintstmtContext paintstmt() throws RecognitionException {
		PaintstmtContext _localctx = new PaintstmtContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_paintstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1484);
			match(PAINT);
			setState(1485);
			match(LPAREN);
			setState(1486);
			((PaintstmtContext)_localctx).x = expr(0);
			setState(1487);
			match(COMMA);
			setState(1488);
			((PaintstmtContext)_localctx).y = expr(0);
			setState(1489);
			match(RPAREN);
			setState(1490);
			match(COMMA);
			setState(1491);
			((PaintstmtContext)_localctx).r = expr(0);
			setState(1492);
			match(COMMA);
			setState(1493);
			((PaintstmtContext)_localctx).g = expr(0);
			setState(1494);
			match(COMMA);
			setState(1495);
			((PaintstmtContext)_localctx).b = expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PsetstmtContext extends ParserRuleContext {
		public ExprContext x;
		public ExprContext y;
		public ExprContext r;
		public ExprContext g;
		public ExprContext b;
		public TerminalNode PSET() { return getToken(PuffinBasicParser.PSET, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PsetstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_psetstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterPsetstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitPsetstmt(this);
		}
	}

	public final PsetstmtContext psetstmt() throws RecognitionException {
		PsetstmtContext _localctx = new PsetstmtContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_psetstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1497);
			match(PSET);
			setState(1498);
			match(LPAREN);
			setState(1499);
			((PsetstmtContext)_localctx).x = expr(0);
			setState(1500);
			match(COMMA);
			setState(1501);
			((PsetstmtContext)_localctx).y = expr(0);
			setState(1502);
			match(RPAREN);
			setState(1510);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				{
				setState(1503);
				match(COMMA);
				setState(1504);
				((PsetstmtContext)_localctx).r = expr(0);
				setState(1505);
				match(COMMA);
				setState(1506);
				((PsetstmtContext)_localctx).g = expr(0);
				setState(1507);
				match(COMMA);
				setState(1508);
				((PsetstmtContext)_localctx).b = expr(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DrawstmtContext extends ParserRuleContext {
		public TerminalNode DRAW() { return getToken(PuffinBasicParser.DRAW, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DrawstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterDrawstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitDrawstmt(this);
		}
	}

	public final DrawstmtContext drawstmt() throws RecognitionException {
		DrawstmtContext _localctx = new DrawstmtContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_drawstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1512);
			match(DRAW);
			setState(1513);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GraphicsgetstmtContext extends ParserRuleContext {
		public ExprContext x1;
		public ExprContext y1;
		public ExprContext x2;
		public ExprContext y2;
		public Token buffer;
		public TerminalNode GET() { return getToken(PuffinBasicParser.GET, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(PuffinBasicParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(PuffinBasicParser.LPAREN, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(PuffinBasicParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(PuffinBasicParser.RPAREN, i);
		}
		public TerminalNode MINUS() { return getToken(PuffinBasicParser.MINUS, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode FRONT() { return getToken(PuffinBasicParser.FRONT, 0); }
		public TerminalNode BACK1() { return getToken(PuffinBasicParser.BACK1, 0); }
		public GraphicsgetstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphicsgetstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterGraphicsgetstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitGraphicsgetstmt(this);
		}
	}

	public final GraphicsgetstmtContext graphicsgetstmt() throws RecognitionException {
		GraphicsgetstmtContext _localctx = new GraphicsgetstmtContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_graphicsgetstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1515);
			match(GET);
			setState(1516);
			match(LPAREN);
			setState(1517);
			((GraphicsgetstmtContext)_localctx).x1 = expr(0);
			setState(1518);
			match(COMMA);
			setState(1519);
			((GraphicsgetstmtContext)_localctx).y1 = expr(0);
			setState(1520);
			match(RPAREN);
			setState(1521);
			match(MINUS);
			setState(1522);
			match(LPAREN);
			setState(1523);
			((GraphicsgetstmtContext)_localctx).x2 = expr(0);
			setState(1524);
			match(COMMA);
			setState(1525);
			((GraphicsgetstmtContext)_localctx).y2 = expr(0);
			setState(1526);
			match(RPAREN);
			setState(1527);
			match(COMMA);
			setState(1528);
			variable();
			setState(1531);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				{
				setState(1529);
				match(COMMA);
				setState(1530);
				((GraphicsgetstmtContext)_localctx).buffer = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==FRONT || _la==BACK1) ) {
					((GraphicsgetstmtContext)_localctx).buffer = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GraphicsputstmtContext extends ParserRuleContext {
		public ExprContext x;
		public ExprContext y;
		public ExprContext action;
		public Token buffer;
		public TerminalNode PUT() { return getToken(PuffinBasicParser.PUT, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode FRONT() { return getToken(PuffinBasicParser.FRONT, 0); }
		public TerminalNode BACK1() { return getToken(PuffinBasicParser.BACK1, 0); }
		public GraphicsputstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphicsputstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterGraphicsputstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitGraphicsputstmt(this);
		}
	}

	public final GraphicsputstmtContext graphicsputstmt() throws RecognitionException {
		GraphicsputstmtContext _localctx = new GraphicsputstmtContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_graphicsputstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1533);
			match(PUT);
			setState(1534);
			match(LPAREN);
			setState(1535);
			((GraphicsputstmtContext)_localctx).x = expr(0);
			setState(1536);
			match(COMMA);
			setState(1537);
			((GraphicsputstmtContext)_localctx).y = expr(0);
			setState(1538);
			match(RPAREN);
			setState(1539);
			match(COMMA);
			setState(1540);
			variable();
			setState(1543);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				{
				setState(1541);
				match(COMMA);
				setState(1542);
				((GraphicsputstmtContext)_localctx).action = expr(0);
				}
				break;
			}
			setState(1547);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				{
				setState(1545);
				match(COMMA);
				setState(1546);
				((GraphicsputstmtContext)_localctx).buffer = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==FRONT || _la==BACK1) ) {
					((GraphicsputstmtContext)_localctx).buffer = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GraphicsbuffercopyhorstmtContext extends ParserRuleContext {
		public ExprContext srcx;
		public ExprContext dstx;
		public ExprContext w;
		public TerminalNode BUFFERCOPYHOR() { return getToken(PuffinBasicParser.BUFFERCOPYHOR, 0); }
		public TerminalNode EQGT() { return getToken(PuffinBasicParser.EQGT, 0); }
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public GraphicsbuffercopyhorstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphicsbuffercopyhorstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterGraphicsbuffercopyhorstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitGraphicsbuffercopyhorstmt(this);
		}
	}

	public final GraphicsbuffercopyhorstmtContext graphicsbuffercopyhorstmt() throws RecognitionException {
		GraphicsbuffercopyhorstmtContext _localctx = new GraphicsbuffercopyhorstmtContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_graphicsbuffercopyhorstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1549);
			match(BUFFERCOPYHOR);
			setState(1550);
			((GraphicsbuffercopyhorstmtContext)_localctx).srcx = expr(0);
			setState(1551);
			match(EQGT);
			setState(1552);
			((GraphicsbuffercopyhorstmtContext)_localctx).dstx = expr(0);
			setState(1553);
			match(COMMA);
			setState(1554);
			((GraphicsbuffercopyhorstmtContext)_localctx).w = expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FontstmtContext extends ParserRuleContext {
		public ExprContext name;
		public ExprContext style;
		public ExprContext size;
		public TerminalNode FONT() { return getToken(PuffinBasicParser.FONT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FontstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fontstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterFontstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitFontstmt(this);
		}
	}

	public final FontstmtContext fontstmt() throws RecognitionException {
		FontstmtContext _localctx = new FontstmtContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_fontstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1556);
			match(FONT);
			setState(1557);
			((FontstmtContext)_localctx).name = expr(0);
			setState(1558);
			match(COMMA);
			setState(1559);
			((FontstmtContext)_localctx).style = expr(0);
			setState(1560);
			match(COMMA);
			setState(1561);
			((FontstmtContext)_localctx).size = expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DrawstrstmtContext extends ParserRuleContext {
		public ExprContext str;
		public ExprContext x;
		public ExprContext y;
		public TerminalNode DRAWSTR() { return getToken(PuffinBasicParser.DRAWSTR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public DrawstrstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drawstrstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterDrawstrstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitDrawstrstmt(this);
		}
	}

	public final DrawstrstmtContext drawstrstmt() throws RecognitionException {
		DrawstrstmtContext _localctx = new DrawstrstmtContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_drawstrstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1563);
			match(DRAWSTR);
			setState(1564);
			((DrawstrstmtContext)_localctx).str = expr(0);
			setState(1565);
			match(COMMA);
			setState(1566);
			((DrawstrstmtContext)_localctx).x = expr(0);
			setState(1567);
			match(COMMA);
			setState(1568);
			((DrawstrstmtContext)_localctx).y = expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoadimgstmtContext extends ParserRuleContext {
		public ExprContext path;
		public TerminalNode LOADIMG() { return getToken(PuffinBasicParser.LOADIMG, 0); }
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LoadimgstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loadimgstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterLoadimgstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitLoadimgstmt(this);
		}
	}

	public final LoadimgstmtContext loadimgstmt() throws RecognitionException {
		LoadimgstmtContext _localctx = new LoadimgstmtContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_loadimgstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1570);
			match(LOADIMG);
			setState(1571);
			((LoadimgstmtContext)_localctx).path = expr(0);
			setState(1572);
			match(COMMA);
			setState(1573);
			variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SaveimgstmtContext extends ParserRuleContext {
		public ExprContext path;
		public TerminalNode SAVEIMG() { return getToken(PuffinBasicParser.SAVEIMG, 0); }
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SaveimgstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_saveimgstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterSaveimgstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitSaveimgstmt(this);
		}
	}

	public final SaveimgstmtContext saveimgstmt() throws RecognitionException {
		SaveimgstmtContext _localctx = new SaveimgstmtContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_saveimgstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1575);
			match(SAVEIMG);
			setState(1576);
			((SaveimgstmtContext)_localctx).path = expr(0);
			setState(1577);
			match(COMMA);
			setState(1578);
			variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClsstmtContext extends ParserRuleContext {
		public TerminalNode CLS() { return getToken(PuffinBasicParser.CLS, 0); }
		public ClsstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clsstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterClsstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitClsstmt(this);
		}
	}

	public final ClsstmtContext clsstmt() throws RecognitionException {
		ClsstmtContext _localctx = new ClsstmtContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_clsstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1580);
			match(CLS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BeepstmtContext extends ParserRuleContext {
		public TerminalNode BEEP() { return getToken(PuffinBasicParser.BEEP, 0); }
		public BeepstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beepstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterBeepstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitBeepstmt(this);
		}
	}

	public final BeepstmtContext beepstmt() throws RecognitionException {
		BeepstmtContext _localctx = new BeepstmtContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_beepstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1582);
			match(BEEP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayfillstmtContext extends ParserRuleContext {
		public TerminalNode ARRAYFILL() { return getToken(PuffinBasicParser.ARRAYFILL, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ArrayfillstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayfillstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterArrayfillstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitArrayfillstmt(this);
		}
	}

	public final ArrayfillstmtContext arrayfillstmt() throws RecognitionException {
		ArrayfillstmtContext _localctx = new ArrayfillstmtContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_arrayfillstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1584);
			match(ARRAYFILL);
			setState(1585);
			variable();
			setState(1586);
			match(COMMA);
			setState(1587);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArraycopystmtContext extends ParserRuleContext {
		public VariableContext src;
		public VariableContext dst;
		public TerminalNode ARRAYCOPY() { return getToken(PuffinBasicParser.ARRAYCOPY, 0); }
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public ArraycopystmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arraycopystmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterArraycopystmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitArraycopystmt(this);
		}
	}

	public final ArraycopystmtContext arraycopystmt() throws RecognitionException {
		ArraycopystmtContext _localctx = new ArraycopystmtContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_arraycopystmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1589);
			match(ARRAYCOPY);
			setState(1590);
			((ArraycopystmtContext)_localctx).src = variable();
			setState(1591);
			match(COMMA);
			setState(1592);
			((ArraycopystmtContext)_localctx).dst = variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Array1dsortstmtContext extends ParserRuleContext {
		public TerminalNode ARRAY1DSORT() { return getToken(PuffinBasicParser.ARRAY1DSORT, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Array1dsortstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array1dsortstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterArray1dsortstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitArray1dsortstmt(this);
		}
	}

	public final Array1dsortstmtContext array1dsortstmt() throws RecognitionException {
		Array1dsortstmtContext _localctx = new Array1dsortstmtContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_array1dsortstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1594);
			match(ARRAY1DSORT);
			setState(1595);
			variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Array1dcopystmtContext extends ParserRuleContext {
		public VariableContext src;
		public ExprContext src0;
		public VariableContext dst;
		public ExprContext dst0;
		public ExprContext len;
		public TerminalNode ARRAY1DCOPY() { return getToken(PuffinBasicParser.ARRAY1DCOPY, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Array1dcopystmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array1dcopystmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterArray1dcopystmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitArray1dcopystmt(this);
		}
	}

	public final Array1dcopystmtContext array1dcopystmt() throws RecognitionException {
		Array1dcopystmtContext _localctx = new Array1dcopystmtContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_array1dcopystmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1597);
			match(ARRAY1DCOPY);
			setState(1598);
			((Array1dcopystmtContext)_localctx).src = variable();
			setState(1599);
			match(COMMA);
			setState(1600);
			((Array1dcopystmtContext)_localctx).src0 = expr(0);
			setState(1601);
			match(COMMA);
			setState(1602);
			((Array1dcopystmtContext)_localctx).dst = variable();
			setState(1603);
			match(COMMA);
			setState(1604);
			((Array1dcopystmtContext)_localctx).dst0 = expr(0);
			setState(1605);
			match(COMMA);
			setState(1606);
			((Array1dcopystmtContext)_localctx).len = expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Array2dshifthorstmtContext extends ParserRuleContext {
		public ExprContext step;
		public TerminalNode ARRAY2DSHIFTHOR() { return getToken(PuffinBasicParser.ARRAY2DSHIFTHOR, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Array2dshifthorstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array2dshifthorstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterArray2dshifthorstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitArray2dshifthorstmt(this);
		}
	}

	public final Array2dshifthorstmtContext array2dshifthorstmt() throws RecognitionException {
		Array2dshifthorstmtContext _localctx = new Array2dshifthorstmtContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_array2dshifthorstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1608);
			match(ARRAY2DSHIFTHOR);
			setState(1609);
			variable();
			setState(1610);
			match(COMMA);
			setState(1611);
			((Array2dshifthorstmtContext)_localctx).step = expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Array2dshiftverstmtContext extends ParserRuleContext {
		public ExprContext step;
		public TerminalNode ARRAY2DSHIFTVER() { return getToken(PuffinBasicParser.ARRAY2DSHIFTVER, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Array2dshiftverstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array2dshiftverstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterArray2dshiftverstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitArray2dshiftverstmt(this);
		}
	}

	public final Array2dshiftverstmtContext array2dshiftverstmt() throws RecognitionException {
		Array2dshiftverstmtContext _localctx = new Array2dshiftverstmtContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_array2dshiftverstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1613);
			match(ARRAY2DSHIFTVER);
			setState(1614);
			variable();
			setState(1615);
			match(COMMA);
			setState(1616);
			((Array2dshiftverstmtContext)_localctx).step = expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoadwavstmtContext extends ParserRuleContext {
		public ExprContext path;
		public TerminalNode LOADWAV() { return getToken(PuffinBasicParser.LOADWAV, 0); }
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LoadwavstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loadwavstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterLoadwavstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitLoadwavstmt(this);
		}
	}

	public final LoadwavstmtContext loadwavstmt() throws RecognitionException {
		LoadwavstmtContext _localctx = new LoadwavstmtContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_loadwavstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1618);
			match(LOADWAV);
			setState(1619);
			((LoadwavstmtContext)_localctx).path = expr(0);
			setState(1620);
			match(COMMA);
			setState(1621);
			variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PlaywavstmtContext extends ParserRuleContext {
		public TerminalNode PLAYWAV() { return getToken(PuffinBasicParser.PLAYWAV, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public PlaywavstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_playwavstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterPlaywavstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitPlaywavstmt(this);
		}
	}

	public final PlaywavstmtContext playwavstmt() throws RecognitionException {
		PlaywavstmtContext _localctx = new PlaywavstmtContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_playwavstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1623);
			match(PLAYWAV);
			setState(1624);
			variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StopwavstmtContext extends ParserRuleContext {
		public TerminalNode STOPWAV() { return getToken(PuffinBasicParser.STOPWAV, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public StopwavstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stopwavstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterStopwavstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitStopwavstmt(this);
		}
	}

	public final StopwavstmtContext stopwavstmt() throws RecognitionException {
		StopwavstmtContext _localctx = new StopwavstmtContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_stopwavstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1626);
			match(STOPWAV);
			setState(1627);
			variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopwavstmtContext extends ParserRuleContext {
		public TerminalNode LOOPWAV() { return getToken(PuffinBasicParser.LOOPWAV, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public LoopwavstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopwavstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterLoopwavstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitLoopwavstmt(this);
		}
	}

	public final LoopwavstmtContext loopwavstmt() throws RecognitionException {
		LoopwavstmtContext _localctx = new LoopwavstmtContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_loopwavstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1629);
			match(LOOPWAV);
			setState(1630);
			variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LabelstmtContext extends ParserRuleContext {
		public StringContext name;
		public TerminalNode LABEL() { return getToken(PuffinBasicParser.LABEL, 0); }
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public LabelstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labelstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterLabelstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitLabelstmt(this);
		}
	}

	public final LabelstmtContext labelstmt() throws RecognitionException {
		LabelstmtContext _localctx = new LabelstmtContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_labelstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1632);
			match(LABEL);
			setState(1633);
			((LabelstmtContext)_localctx).name = string();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ListstmtContext extends ParserRuleContext {
		public VarnameContext typename;
		public VarsuffixContext typesuffix;
		public VarsuffixContext dimtypesuffix;
		public VarnameContext listname;
		public TerminalNode LIST() { return getToken(PuffinBasicParser.LIST, 0); }
		public TerminalNode RELLT() { return getToken(PuffinBasicParser.RELLT, 0); }
		public TerminalNode RELGT() { return getToken(PuffinBasicParser.RELGT, 0); }
		public List<VarnameContext> varname() {
			return getRuleContexts(VarnameContext.class);
		}
		public VarnameContext varname(int i) {
			return getRuleContext(VarnameContext.class,i);
		}
		public TerminalNode DIM() { return getToken(PuffinBasicParser.DIM, 0); }
		public VarsuffixContext varsuffix() {
			return getRuleContext(VarsuffixContext.class,0);
		}
		public ListstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_liststmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterListstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitListstmt(this);
		}
	}

	public final ListstmtContext liststmt() throws RecognitionException {
		ListstmtContext _localctx = new ListstmtContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_liststmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1635);
			match(LIST);
			setState(1636);
			match(RELLT);
			setState(1641);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARNAME:
				{
				setState(1637);
				((ListstmtContext)_localctx).typename = varname();
				}
				break;
			case AT:
			case DOLLAR:
			case PERCENT:
			case EXCLAMATION:
			case HASH:
				{
				setState(1638);
				((ListstmtContext)_localctx).typesuffix = varsuffix();
				}
				break;
			case DIM:
				{
				setState(1639);
				match(DIM);
				setState(1640);
				((ListstmtContext)_localctx).dimtypesuffix = varsuffix();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1643);
			match(RELGT);
			setState(1644);
			((ListstmtContext)_localctx).listname = varname();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DictstmtContext extends ParserRuleContext {
		public VarsuffixContext dictk1;
		public VarnameContext dictv1;
		public VarsuffixContext dictv2;
		public VarnameContext dictname;
		public TerminalNode DICT() { return getToken(PuffinBasicParser.DICT, 0); }
		public TerminalNode RELLT() { return getToken(PuffinBasicParser.RELLT, 0); }
		public TerminalNode COMMA() { return getToken(PuffinBasicParser.COMMA, 0); }
		public TerminalNode RELGT() { return getToken(PuffinBasicParser.RELGT, 0); }
		public List<VarnameContext> varname() {
			return getRuleContexts(VarnameContext.class);
		}
		public VarnameContext varname(int i) {
			return getRuleContext(VarnameContext.class,i);
		}
		public List<VarsuffixContext> varsuffix() {
			return getRuleContexts(VarsuffixContext.class);
		}
		public VarsuffixContext varsuffix(int i) {
			return getRuleContext(VarsuffixContext.class,i);
		}
		public DictstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterDictstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitDictstmt(this);
		}
	}

	public final DictstmtContext dictstmt() throws RecognitionException {
		DictstmtContext _localctx = new DictstmtContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_dictstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1646);
			match(DICT);
			setState(1647);
			match(RELLT);
			{
			setState(1648);
			((DictstmtContext)_localctx).dictk1 = varsuffix();
			}
			setState(1649);
			match(COMMA);
			setState(1652);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VARNAME:
				{
				setState(1650);
				((DictstmtContext)_localctx).dictv1 = varname();
				}
				break;
			case AT:
			case DOLLAR:
			case PERCENT:
			case EXCLAMATION:
			case HASH:
				{
				setState(1651);
				((DictstmtContext)_localctx).dictv2 = varsuffix();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1654);
			match(RELGT);
			setState(1655);
			((DictstmtContext)_localctx).dictname = varname();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SetstmtContext extends ParserRuleContext {
		public VarsuffixContext typesuffix;
		public VarnameContext setname;
		public TerminalNode SET() { return getToken(PuffinBasicParser.SET, 0); }
		public TerminalNode RELLT() { return getToken(PuffinBasicParser.RELLT, 0); }
		public TerminalNode RELGT() { return getToken(PuffinBasicParser.RELGT, 0); }
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public VarsuffixContext varsuffix() {
			return getRuleContext(VarsuffixContext.class,0);
		}
		public SetstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterSetstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitSetstmt(this);
		}
	}

	public final SetstmtContext setstmt() throws RecognitionException {
		SetstmtContext _localctx = new SetstmtContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_setstmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1657);
			match(SET);
			setState(1658);
			match(RELLT);
			{
			setState(1659);
			((SetstmtContext)_localctx).typesuffix = varsuffix();
			}
			setState(1660);
			match(RELGT);
			setState(1661);
			((SetstmtContext)_localctx).setname = varname();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructstmtContext extends ParserRuleContext {
		public VarnameContext structname;
		public TerminalNode STRUCT() { return getToken(PuffinBasicParser.STRUCT, 0); }
		public TerminalNode LBRACE() { return getToken(PuffinBasicParser.LBRACE, 0); }
		public List<CompositetypeContext> compositetype() {
			return getRuleContexts(CompositetypeContext.class);
		}
		public CompositetypeContext compositetype(int i) {
			return getRuleContext(CompositetypeContext.class,i);
		}
		public TerminalNode RBRACE() { return getToken(PuffinBasicParser.RBRACE, 0); }
		public VarnameContext varname() {
			return getRuleContext(VarnameContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public StructstmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structstmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterStructstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitStructstmt(this);
		}
	}

	public final StructstmtContext structstmt() throws RecognitionException {
		StructstmtContext _localctx = new StructstmtContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_structstmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1663);
			match(STRUCT);
			setState(1664);
			((StructstmtContext)_localctx).structname = varname();
			setState(1665);
			match(LBRACE);
			setState(1666);
			compositetype();
			setState(1671);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1667);
				match(COMMA);
				setState(1668);
				compositetype();
				}
				}
				setState(1673);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1674);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
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
		public TerminalNode DIM() { return getToken(PuffinBasicParser.DIM, 0); }
		public TerminalNode LPAREN() { return getToken(PuffinBasicParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(PuffinBasicParser.RPAREN, 0); }
		public TerminalNode LIST() { return getToken(PuffinBasicParser.LIST, 0); }
		public TerminalNode RELLT() { return getToken(PuffinBasicParser.RELLT, 0); }
		public TerminalNode RELGT() { return getToken(PuffinBasicParser.RELGT, 0); }
		public TerminalNode SET() { return getToken(PuffinBasicParser.SET, 0); }
		public TerminalNode DICT() { return getToken(PuffinBasicParser.DICT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(PuffinBasicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PuffinBasicParser.COMMA, i);
		}
		public List<VarnameContext> varname() {
			return getRuleContexts(VarnameContext.class);
		}
		public VarnameContext varname(int i) {
			return getRuleContext(VarnameContext.class,i);
		}
		public List<TerminalNode> DECIMAL() { return getTokens(PuffinBasicParser.DECIMAL); }
		public TerminalNode DECIMAL(int i) {
			return getToken(PuffinBasicParser.DECIMAL, i);
		}
		public List<VarsuffixContext> varsuffix() {
			return getRuleContexts(VarsuffixContext.class);
		}
		public VarsuffixContext varsuffix(int i) {
			return getRuleContext(VarsuffixContext.class,i);
		}
		public CompositetypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compositetype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterCompositetype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitCompositetype(this);
		}
	}

	public final CompositetypeContext compositetype() throws RecognitionException {
		CompositetypeContext _localctx = new CompositetypeContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_compositetype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1730);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
			case 1:
				{
				setState(1676);
				((CompositetypeContext)_localctx).var1 = varname();
				setState(1678);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 185)) & ~0x3f) == 0 && ((1L << (_la - 185)) & 31L) != 0)) {
					{
					setState(1677);
					((CompositetypeContext)_localctx).var2 = varsuffix();
					}
				}

				}
				break;
			case 2:
				{
				setState(1680);
				match(DIM);
				setState(1681);
				((CompositetypeContext)_localctx).elem = varname();
				setState(1683);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 185)) & ~0x3f) == 0 && ((1L << (_la - 185)) & 31L) != 0)) {
					{
					setState(1682);
					((CompositetypeContext)_localctx).elemsuffix = varsuffix();
					}
				}

				setState(1685);
				match(LPAREN);
				setState(1686);
				((CompositetypeContext)_localctx).dim = match(DECIMAL);
				setState(1691);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1687);
					match(COMMA);
					setState(1688);
					((CompositetypeContext)_localctx).dim = match(DECIMAL);
					}
					}
					setState(1693);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1694);
				match(RPAREN);
				}
				break;
			case 3:
				{
				setState(1696);
				((CompositetypeContext)_localctx).struct1 = varname();
				setState(1697);
				((CompositetypeContext)_localctx).elem = varname();
				}
				break;
			case 4:
				{
				setState(1699);
				match(LIST);
				setState(1700);
				match(RELLT);
				setState(1705);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VARNAME:
					{
					setState(1701);
					((CompositetypeContext)_localctx).list1 = varname();
					}
					break;
				case AT:
				case DOLLAR:
				case PERCENT:
				case EXCLAMATION:
				case HASH:
					{
					setState(1702);
					((CompositetypeContext)_localctx).list2 = varsuffix();
					}
					break;
				case DIM:
					{
					setState(1703);
					match(DIM);
					setState(1704);
					((CompositetypeContext)_localctx).list3 = varsuffix();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1707);
				match(RELGT);
				setState(1708);
				((CompositetypeContext)_localctx).elem = varname();
				}
				break;
			case 5:
				{
				setState(1710);
				match(SET);
				setState(1711);
				match(RELLT);
				setState(1714);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VARNAME:
					{
					setState(1712);
					((CompositetypeContext)_localctx).set1 = varname();
					}
					break;
				case AT:
				case DOLLAR:
				case PERCENT:
				case EXCLAMATION:
				case HASH:
					{
					setState(1713);
					((CompositetypeContext)_localctx).set2 = varsuffix();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1716);
				match(RELGT);
				setState(1717);
				((CompositetypeContext)_localctx).elem = varname();
				}
				break;
			case 6:
				{
				setState(1719);
				match(DICT);
				setState(1720);
				match(RELLT);
				{
				setState(1721);
				((CompositetypeContext)_localctx).dictk1 = varsuffix();
				}
				setState(1722);
				match(COMMA);
				setState(1725);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VARNAME:
					{
					setState(1723);
					((CompositetypeContext)_localctx).dictv1 = varname();
					}
					break;
				case AT:
				case DOLLAR:
				case PERCENT:
				case EXCLAMATION:
				case HASH:
					{
					setState(1724);
					((CompositetypeContext)_localctx).dictv2 = varsuffix();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1727);
				match(RELGT);
				setState(1728);
				((CompositetypeContext)_localctx).elem = varname();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StructinstancestmtContext extends ParserRuleContext {
		public List<VarnameContext> varname() {
			return getRuleContexts(VarnameContext.class);
		}
		public VarnameContext varname(int i) {
			return getRuleContext(VarnameContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(PuffinBasicParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PuffinBasicParser.RBRACE, 0); }
		public StructinstancestmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structinstancestmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterStructinstancestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitStructinstancestmt(this);
		}
	}

	public final StructinstancestmtContext structinstancestmt() throws RecognitionException {
		StructinstancestmtContext _localctx = new StructinstancestmtContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_structinstancestmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1732);
			varname();
			setState(1733);
			varname();
			setState(1734);
			match(LBRACE);
			setState(1735);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PuffinBasicParser.STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitString(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1737);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ParserRuleContext {
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode FLOAT() { return getToken(PuffinBasicParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(PuffinBasicParser.DOUBLE, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_number);
		try {
			setState(1742);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL:
			case HEXADECIMAL:
			case OCTAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(1739);
				integer();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1740);
				match(FLOAT);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1741);
				match(DOUBLE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode DECIMAL() { return getToken(PuffinBasicParser.DECIMAL, 0); }
		public TerminalNode HEXADECIMAL() { return getToken(PuffinBasicParser.HEXADECIMAL, 0); }
		public TerminalNode OCTAL() { return getToken(PuffinBasicParser.OCTAL, 0); }
		public TerminalNode PERCENT() { return getToken(PuffinBasicParser.PERCENT, 0); }
		public TerminalNode AT() { return getToken(PuffinBasicParser.AT, 0); }
		public TerminalNode HASH() { return getToken(PuffinBasicParser.HASH, 0); }
		public TerminalNode EXCLAMATION() { return getToken(PuffinBasicParser.EXCLAMATION, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PuffinBasicListener ) ((PuffinBasicListener)listener).exitInteger(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1744);
			_la = _input.LA(1);
			if ( !(((((_la - 218)) & ~0x3f) == 0 && ((1L << (_la - 218)) & 7L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1746);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				{
				setState(1745);
				_la = _input.LA(1);
				if ( !(((((_la - 185)) & ~0x3f) == 0 && ((1L << (_la - 185)) & 29L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return expr_sempred((ExprContext)_localctx, predIndex);
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

	public static final String _serializedATN =
		"\u0004\u0001\u00e3\u06d5\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"+
		";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"+
		"@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"+
		"E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007"+
		"J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007"+
		"O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007"+
		"T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007"+
		"Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007"+
		"^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007"+
		"c\u0002d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007"+
		"h\u0002i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007"+
		"m\u0002n\u0007n\u0002o\u0007o\u0002p\u0007p\u0001\u0000\u0001\u0000\u0005"+
		"\u0000\u00e5\b\u0000\n\u0000\f\u0000\u00e8\t\u0000\u0001\u0001\u0003\u0001"+
		"\u00eb\b\u0001\u0001\u0001\u0003\u0001\u00ee\b\u0001\u0001\u0001\u0003"+
		"\u0001\u00f1\b\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u0004\u0153\b\u0004\u0001\u0005\u0001\u0005\u0003"+
		"\u0005\u0157\b\u0005\u0001\u0006\u0001\u0006\u0003\u0006\u015b\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u0161\b\u0006"+
		"\n\u0006\f\u0006\u0164\t\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0168"+
		"\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u016d\b\u0007"+
		"\n\u0007\f\u0007\u0170\t\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0178\b\u0007\n\u0007\f\u0007"+
		"\u017b\t\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u017f\b\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0003\n\u0187\b\n\u0001\n\u0001"+
		"\n\u0003\n\u018b\b\n\u0001\n\u0001\n\u0003\n\u018f\b\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0199\b\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0005\n\u01b0\b\n\n\n\f\n\u01b3\t\n\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u01bc\b\u000b\n\u000b\f\u000b\u01bf\t\u000b\u0003\u000b\u01c1\b"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u02a1\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u02c4\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u02cf"+
		"\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u02fb\b\u000b\u0001\u000b\u0003\u000b\u02fe\b\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u037d\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u038b\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0003\f\u0391\b\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u03b0\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0005"+
		"\u0014\u03b6\b\u0014\n\u0014\f\u0014\u03b9\t\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0005\u0015\u03bf\b\u0015\n\u0015\f\u0015\u03c2"+
		"\t\u0015\u0003\u0015\u03c4\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u03cc\b\u0016\n\u0016"+
		"\f\u0016\u03cf\t\u0016\u0001\u0017\u0003\u0017\u03d2\b\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019"+
		"\u03e0\b\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u03e4\b\u0019\u0001"+
		"\u0019\u0001\u0019\u0003\u0019\u03e8\b\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0003\u001a\u03ed\b\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u03f1"+
		"\b\u001a\u0001\u001b\u0001\u001b\u0003\u001b\u03f5\b\u001b\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0005\u001f\u0405\b\u001f\n\u001f\f\u001f\u0408\t\u001f\u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u0412\b \u0001"+
		"!\u0001!\u0003!\u0416\b!\u0001!\u0001!\u0005!\u041a\b!\n!\f!\u041d\t!"+
		"\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001$\u0001$\u0001%\u0001"+
		"%\u0001%\u0003%\u042a\b%\u0001%\u0001%\u0001%\u0001%\u0005%\u0430\b%\n"+
		"%\f%\u0433\t%\u0003%\u0435\b%\u0001%\u0003%\u0438\b%\u0001%\u0001%\u0001"+
		"%\u0001&\u0001&\u0001&\u0003&\u0440\b&\u0001&\u0001&\u0001&\u0001&\u0005"+
		"&\u0446\b&\n&\f&\u0449\t&\u0003&\u044b\b&\u0001&\u0001&\u0001&\u0001\'"+
		"\u0001\'\u0001\'\u0001(\u0001(\u0001)\u0001)\u0001)\u0001*\u0001*\u0001"+
		"*\u0001+\u0001+\u0001+\u0003+\u045e\b+\u0001+\u0001+\u0001+\u0001+\u0005"+
		"+\u0464\b+\n+\f+\u0467\t+\u0001+\u0001+\u0001,\u0001,\u0001,\u0003,\u046e"+
		"\b,\u0001,\u0001,\u0001,\u0001,\u0005,\u0474\b,\n,\f,\u0477\t,\u0001,"+
		"\u0001,\u0001-\u0001-\u0001-\u0001.\u0001.\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u00010\u00010\u00010\u00010\u00010\u00011\u00011\u00011\u0001"+
		"1\u00011\u00012\u00012\u00012\u00012\u00032\u0493\b2\u00012\u00012\u0001"+
		"2\u00012\u00012\u00032\u049a\b2\u00013\u00013\u00013\u00013\u00033\u04a0"+
		"\b3\u00013\u00013\u00033\u04a4\b3\u00013\u00033\u04a7\b3\u00013\u0001"+
		"3\u00033\u04ab\b3\u00013\u00013\u00013\u00013\u00033\u04b1\b3\u00014\u0001"+
		"4\u00034\u04b5\b4\u00014\u00014\u00014\u00034\u04ba\b4\u00014\u00054\u04bd"+
		"\b4\n4\f4\u04c0\t4\u00034\u04c2\b4\u00015\u00015\u00016\u00016\u00017"+
		"\u00017\u00017\u00017\u00037\u04cc\b7\u00018\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00038\u04d6\b8\u00019\u00019\u00039\u04da\b9\u0001"+
		"9\u00019\u00019\u00039\u04df\b9\u0001:\u0001:\u0003:\u04e3\b:\u0001:\u0001"+
		":\u0001:\u0003:\u04e8\b:\u0001;\u0001;\u0003;\u04ec\b;\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0005;\u04f7\b;\n;\f;\u04fa"+
		"\t;\u0001<\u0001<\u0003<\u04fe\b<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001"+
		"<\u0005<\u0506\b<\n<\f<\u0509\t<\u0001=\u0001=\u0001=\u0001=\u0001=\u0001"+
		"=\u0005=\u0511\b=\n=\f=\u0514\t=\u0001>\u0001>\u0001>\u0003>\u0519\b>"+
		"\u0001>\u0001>\u0001>\u0003>\u051e\b>\u0001>\u0001>\u0001?\u0001?\u0001"+
		"?\u0001?\u0001?\u0001?\u0001@\u0001@\u0001@\u0001@\u0005@\u052c\b@\n@"+
		"\f@\u052f\t@\u0001A\u0001A\u0001A\u0003A\u0534\bA\u0001A\u0001A\u0001"+
		"A\u0003A\u0539\bA\u0005A\u053b\bA\nA\fA\u053e\tA\u0001B\u0001B\u0001C"+
		"\u0001C\u0001C\u0001D\u0001D\u0001D\u0001E\u0001E\u0001E\u0001E\u0005"+
		"E\u054c\bE\nE\fE\u054f\tE\u0001F\u0001F\u0001F\u0001F\u0005F\u0555\bF"+
		"\nF\fF\u0558\tF\u0001G\u0001G\u0001G\u0001G\u0005G\u055e\bG\nG\fG\u0561"+
		"\tG\u0001H\u0001H\u0001H\u0001H\u0005H\u0567\bH\nH\fH\u056a\tH\u0001I"+
		"\u0001I\u0001I\u0001I\u0005I\u0570\bI\nI\fI\u0573\tI\u0001J\u0001J\u0001"+
		"J\u0001J\u0001J\u0001J\u0001J\u0003J\u057c\bJ\u0001J\u0001J\u0001J\u0001"+
		"J\u0001K\u0001K\u0001K\u0001L\u0001L\u0001L\u0001L\u0001L\u0001L\u0001"+
		"L\u0001L\u0001L\u0001L\u0001L\u0003L\u0590\bL\u0001L\u0001L\u0003L\u0594"+
		"\bL\u0001L\u0001L\u0003L\u0598\bL\u0001M\u0001M\u0001N\u0001N\u0001N\u0001"+
		"N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0003N\u05a8"+
		"\bN\u0001N\u0001N\u0003N\u05ac\bN\u0001N\u0003N\u05af\bN\u0001N\u0003"+
		"N\u05b2\bN\u0003N\u05b4\bN\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001"+
		"O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0003O\u05c4\bO\u0001"+
		"P\u0001P\u0001P\u0001P\u0001P\u0001P\u0001P\u0001Q\u0001Q\u0001Q\u0001"+
		"Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001"+
		"R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001"+
		"R\u0001R\u0001R\u0003R\u05e7\bR\u0001S\u0001S\u0001S\u0001T\u0001T\u0001"+
		"T\u0001T\u0001T\u0001T\u0001T\u0001T\u0001T\u0001T\u0001T\u0001T\u0001"+
		"T\u0001T\u0001T\u0001T\u0003T\u05fc\bT\u0001U\u0001U\u0001U\u0001U\u0001"+
		"U\u0001U\u0001U\u0001U\u0001U\u0001U\u0003U\u0608\bU\u0001U\u0001U\u0003"+
		"U\u060c\bU\u0001V\u0001V\u0001V\u0001V\u0001V\u0001V\u0001V\u0001W\u0001"+
		"W\u0001W\u0001W\u0001W\u0001W\u0001W\u0001X\u0001X\u0001X\u0001X\u0001"+
		"X\u0001X\u0001X\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Z\u0001Z\u0001"+
		"Z\u0001Z\u0001Z\u0001[\u0001[\u0001\\\u0001\\\u0001]\u0001]\u0001]\u0001"+
		"]\u0001]\u0001^\u0001^\u0001^\u0001^\u0001^\u0001_\u0001_\u0001_\u0001"+
		"`\u0001`\u0001`\u0001`\u0001`\u0001`\u0001`\u0001`\u0001`\u0001`\u0001"+
		"`\u0001a\u0001a\u0001a\u0001a\u0001a\u0001b\u0001b\u0001b\u0001b\u0001"+
		"b\u0001c\u0001c\u0001c\u0001c\u0001c\u0001d\u0001d\u0001d\u0001e\u0001"+
		"e\u0001e\u0001f\u0001f\u0001f\u0001g\u0001g\u0001g\u0001h\u0001h\u0001"+
		"h\u0001h\u0001h\u0001h\u0003h\u066a\bh\u0001h\u0001h\u0001h\u0001i\u0001"+
		"i\u0001i\u0001i\u0001i\u0001i\u0003i\u0675\bi\u0001i\u0001i\u0001i\u0001"+
		"j\u0001j\u0001j\u0001j\u0001j\u0001j\u0001k\u0001k\u0001k\u0001k\u0001"+
		"k\u0001k\u0005k\u0686\bk\nk\fk\u0689\tk\u0001k\u0001k\u0001l\u0001l\u0003"+
		"l\u068f\bl\u0001l\u0001l\u0001l\u0003l\u0694\bl\u0001l\u0001l\u0001l\u0001"+
		"l\u0005l\u069a\bl\nl\fl\u069d\tl\u0001l\u0001l\u0001l\u0001l\u0001l\u0001"+
		"l\u0001l\u0001l\u0001l\u0001l\u0001l\u0003l\u06aa\bl\u0001l\u0001l\u0001"+
		"l\u0001l\u0001l\u0001l\u0001l\u0003l\u06b3\bl\u0001l\u0001l\u0001l\u0001"+
		"l\u0001l\u0001l\u0001l\u0001l\u0001l\u0003l\u06be\bl\u0001l\u0001l\u0001"+
		"l\u0003l\u06c3\bl\u0001m\u0001m\u0001m\u0001m\u0001m\u0001n\u0001n\u0001"+
		"o\u0001o\u0001o\u0003o\u06cf\bo\u0001p\u0001p\u0003p\u06d3\bp\u0001p\u0000"+
		"\u0001\u0014q\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprt"+
		"vxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094"+
		"\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac"+
		"\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4"+
		"\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc"+
		"\u00de\u00e0\u0000\f\u0001\u0000\u00b9\u00bd\u0001\u0000\u00d8\u00d9\u0001"+
		"\u0000\u00c0\u00c2\u0001\u0000\u00c8\u00cd\u0002\u0000\u00ce\u00cf\u00d1"+
		"\u00d3\u0001\u0000\u00d4\u00d5\u0002\u0000\u000b\u000b\u00b8\u00b8\u0002"+
		"\u0000SSVX\u0001\u0000\u00b6\u00b7\u0001\u0000\u00b0\u00b1\u0001\u0000"+
		"\u00da\u00dc\u0002\u0000\u00b9\u00b9\u00bb\u00bd\u0798\u0000\u00e6\u0001"+
		"\u0000\u0000\u0000\u0002\u00ea\u0001\u0000\u0000\u0000\u0004\u00f4\u0001"+
		"\u0000\u0000\u0000\u0006\u00f6\u0001\u0000\u0000\u0000\b\u0152\u0001\u0000"+
		"\u0000\u0000\n\u0156\u0001\u0000\u0000\u0000\f\u0158\u0001\u0000\u0000"+
		"\u0000\u000e\u0169\u0001\u0000\u0000\u0000\u0010\u0180\u0001\u0000\u0000"+
		"\u0000\u0012\u0182\u0001\u0000\u0000\u0000\u0014\u0198\u0001\u0000\u0000"+
		"\u0000\u0016\u038a\u0001\u0000\u0000\u0000\u0018\u0390\u0001\u0000\u0000"+
		"\u0000\u001a\u0392\u0001\u0000\u0000\u0000\u001c\u0395\u0001\u0000\u0000"+
		"\u0000\u001e\u0398\u0001\u0000\u0000\u0000 \u039a\u0001\u0000\u0000\u0000"+
		"\"\u03a2\u0001\u0000\u0000\u0000$\u03a8\u0001\u0000\u0000\u0000&\u03ad"+
		"\u0001\u0000\u0000\u0000(\u03b1\u0001\u0000\u0000\u0000*\u03ba\u0001\u0000"+
		"\u0000\u0000,\u03c5\u0001\u0000\u0000\u0000.\u03d1\u0001\u0000\u0000\u0000"+
		"0\u03d7\u0001\u0000\u0000\u00002\u03dc\u0001\u0000\u0000\u00004\u03f0"+
		"\u0001\u0000\u0000\u00006\u03f4\u0001\u0000\u0000\u00008\u03f6\u0001\u0000"+
		"\u0000\u0000:\u03fb\u0001\u0000\u0000\u0000<\u03fe\u0001\u0000\u0000\u0000"+
		">\u0401\u0001\u0000\u0000\u0000@\u0409\u0001\u0000\u0000\u0000B\u0413"+
		"\u0001\u0000\u0000\u0000D\u041e\u0001\u0000\u0000\u0000F\u0421\u0001\u0000"+
		"\u0000\u0000H\u0424\u0001\u0000\u0000\u0000J\u0426\u0001\u0000\u0000\u0000"+
		"L\u043c\u0001\u0000\u0000\u0000N\u044f\u0001\u0000\u0000\u0000P\u0452"+
		"\u0001\u0000\u0000\u0000R\u0454\u0001\u0000\u0000\u0000T\u0457\u0001\u0000"+
		"\u0000\u0000V\u045a\u0001\u0000\u0000\u0000X\u046a\u0001\u0000\u0000\u0000"+
		"Z\u047a\u0001\u0000\u0000\u0000\\\u047d\u0001\u0000\u0000\u0000^\u047f"+
		"\u0001\u0000\u0000\u0000`\u0484\u0001\u0000\u0000\u0000b\u0489\u0001\u0000"+
		"\u0000\u0000d\u048e\u0001\u0000\u0000\u0000f\u049b\u0001\u0000\u0000\u0000"+
		"h\u04b2\u0001\u0000\u0000\u0000j\u04c3\u0001\u0000\u0000\u0000l\u04c5"+
		"\u0001\u0000\u0000\u0000n\u04cb\u0001\u0000\u0000\u0000p\u04d5\u0001\u0000"+
		"\u0000\u0000r\u04d7\u0001\u0000\u0000\u0000t\u04e0\u0001\u0000\u0000\u0000"+
		"v\u04e9\u0001\u0000\u0000\u0000x\u04fb\u0001\u0000\u0000\u0000z\u050a"+
		"\u0001\u0000\u0000\u0000|\u0515\u0001\u0000\u0000\u0000~\u0521\u0001\u0000"+
		"\u0000\u0000\u0080\u0527\u0001\u0000\u0000\u0000\u0082\u0530\u0001\u0000"+
		"\u0000\u0000\u0084\u053f\u0001\u0000\u0000\u0000\u0086\u0541\u0001\u0000"+
		"\u0000\u0000\u0088\u0544\u0001\u0000\u0000\u0000\u008a\u0547\u0001\u0000"+
		"\u0000\u0000\u008c\u0550\u0001\u0000\u0000\u0000\u008e\u0559\u0001\u0000"+
		"\u0000\u0000\u0090\u0562\u0001\u0000\u0000\u0000\u0092\u056b\u0001\u0000"+
		"\u0000\u0000\u0094\u0574\u0001\u0000\u0000\u0000\u0096\u0581\u0001\u0000"+
		"\u0000\u0000\u0098\u0584\u0001\u0000\u0000\u0000\u009a\u0599\u0001\u0000"+
		"\u0000\u0000\u009c\u059b\u0001\u0000\u0000\u0000\u009e\u05b5\u0001\u0000"+
		"\u0000\u0000\u00a0\u05c5\u0001\u0000\u0000\u0000\u00a2\u05cc\u0001\u0000"+
		"\u0000\u0000\u00a4\u05d9\u0001\u0000\u0000\u0000\u00a6\u05e8\u0001\u0000"+
		"\u0000\u0000\u00a8\u05eb\u0001\u0000\u0000\u0000\u00aa\u05fd\u0001\u0000"+
		"\u0000\u0000\u00ac\u060d\u0001\u0000\u0000\u0000\u00ae\u0614\u0001\u0000"+
		"\u0000\u0000\u00b0\u061b\u0001\u0000\u0000\u0000\u00b2\u0622\u0001\u0000"+
		"\u0000\u0000\u00b4\u0627\u0001\u0000\u0000\u0000\u00b6\u062c\u0001\u0000"+
		"\u0000\u0000\u00b8\u062e\u0001\u0000\u0000\u0000\u00ba\u0630\u0001\u0000"+
		"\u0000\u0000\u00bc\u0635\u0001\u0000\u0000\u0000\u00be\u063a\u0001\u0000"+
		"\u0000\u0000\u00c0\u063d\u0001\u0000\u0000\u0000\u00c2\u0648\u0001\u0000"+
		"\u0000\u0000\u00c4\u064d\u0001\u0000\u0000\u0000\u00c6\u0652\u0001\u0000"+
		"\u0000\u0000\u00c8\u0657\u0001\u0000\u0000\u0000\u00ca\u065a\u0001\u0000"+
		"\u0000\u0000\u00cc\u065d\u0001\u0000\u0000\u0000\u00ce\u0660\u0001\u0000"+
		"\u0000\u0000\u00d0\u0663\u0001\u0000\u0000\u0000\u00d2\u066e\u0001\u0000"+
		"\u0000\u0000\u00d4\u0679\u0001\u0000\u0000\u0000\u00d6\u067f\u0001\u0000"+
		"\u0000\u0000\u00d8\u06c2\u0001\u0000\u0000\u0000\u00da\u06c4\u0001\u0000"+
		"\u0000\u0000\u00dc\u06c9\u0001\u0000\u0000\u0000\u00de\u06ce\u0001\u0000"+
		"\u0000\u0000\u00e0\u06d0\u0001\u0000\u0000\u0000\u00e2\u00e5\u0003\u0002"+
		"\u0001\u0000\u00e3\u00e5\u0005\u00e0\u0000\u0000\u00e4\u00e2\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e8\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000"+
		"\u0000\u0000\u00e7\u0001\u0001\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000"+
		"\u0000\u0000\u00e9\u00eb\u0003\u0004\u0002\u0000\u00ea\u00e9\u0001\u0000"+
		"\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00ed\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ee\u0003>\u001f\u0000\u00ed\u00ec\u0001\u0000\u0000"+
		"\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee\u00f0\u0001\u0000\u0000"+
		"\u0000\u00ef\u00f1\u0003\u0006\u0003\u0000\u00f0\u00ef\u0001\u0000\u0000"+
		"\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f2\u0001\u0000\u0000"+
		"\u0000\u00f2\u00f3\u0005\u00e0\u0000\u0000\u00f3\u0003\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f5\u0005\u00da\u0000\u0000\u00f5\u0005\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f7\u0005\u0002\u0000\u0000\u00f7\u0007\u0001\u0000\u0000"+
		"\u0000\u00f8\u0153\u0003\"\u0011\u0000\u00f9\u0153\u0003 \u0010\u0000"+
		"\u00fa\u0153\u0003&\u0013\u0000\u00fb\u0153\u0003$\u0012\u0000\u00fc\u0153"+
		"\u0003*\u0015\u0000\u00fd\u0153\u0003,\u0016\u0000\u00fe\u0153\u0003."+
		"\u0017\u0000\u00ff\u0153\u00030\u0018\u0000\u0100\u0153\u00032\u0019\u0000"+
		"\u0101\u0153\u00038\u001c\u0000\u0102\u0153\u0003:\u001d\u0000\u0103\u0153"+
		"\u0003<\u001e\u0000\u0104\u0153\u0003@ \u0000\u0105\u0153\u0003B!\u0000"+
		"\u0106\u0153\u0003D\"\u0000\u0107\u0153\u0003F#\u0000\u0108\u0153\u0003"+
		"H$\u0000\u0109\u0153\u0003J%\u0000\u010a\u0153\u0003L&\u0000\u010b\u0153"+
		"\u0003N\'\u0000\u010c\u0153\u0003P(\u0000\u010d\u0153\u0003R)\u0000\u010e"+
		"\u0153\u0003T*\u0000\u010f\u0153\u0003V+\u0000\u0110\u0153\u0003X,\u0000"+
		"\u0111\u0153\u0003\u001a\r\u0000\u0112\u0153\u0003\u001c\u000e\u0000\u0113"+
		"\u0153\u0003\u001e\u000f\u0000\u0114\u0153\u0003Z-\u0000\u0115\u0153\u0003"+
		"\\.\u0000\u0116\u0153\u0003^/\u0000\u0117\u0153\u0003`0\u0000\u0118\u0153"+
		"\u0003b1\u0000\u0119\u0153\u0003d2\u0000\u011a\u0153\u0003f3\u0000\u011b"+
		"\u0153\u0003h4\u0000\u011c\u0153\u0003r9\u0000\u011d\u0153\u0003t:\u0000"+
		"\u011e\u0153\u0003v;\u0000\u011f\u0153\u0003x<\u0000\u0120\u0153\u0003"+
		"z=\u0000\u0121\u0153\u0003|>\u0000\u0122\u0153\u0003~?\u0000\u0123\u0153"+
		"\u0003\u0080@\u0000\u0124\u0153\u0003\u0082A\u0000\u0125\u0153\u0003\u0084"+
		"B\u0000\u0126\u0153\u0003\u0086C\u0000\u0127\u0153\u0003\u0088D\u0000"+
		"\u0128\u0153\u0003\u008aE\u0000\u0129\u0153\u0003\u008cF\u0000\u012a\u0153"+
		"\u0003\u008eG\u0000\u012b\u0153\u0003\u0090H\u0000\u012c\u0153\u0003\u0092"+
		"I\u0000\u012d\u0153\u0003\u0094J\u0000\u012e\u0153\u0003\u0096K\u0000"+
		"\u012f\u0153\u0003\u0098L\u0000\u0130\u0153\u0003\u009cN\u0000\u0131\u0153"+
		"\u0003\u009eO\u0000\u0132\u0153\u0003\u00a0P\u0000\u0133\u0153\u0003\u00a2"+
		"Q\u0000\u0134\u0153\u0003\u00a4R\u0000\u0135\u0153\u0003\u00a6S\u0000"+
		"\u0136\u0153\u0003\u00a8T\u0000\u0137\u0153\u0003\u00aaU\u0000\u0138\u0153"+
		"\u0003\u00acV\u0000\u0139\u0153\u0003\u00aeW\u0000\u013a\u0153\u0003\u00b0"+
		"X\u0000\u013b\u0153\u0003\u00b2Y\u0000\u013c\u0153\u0003\u00b4Z\u0000"+
		"\u013d\u0153\u0003\u00b6[\u0000\u013e\u0153\u0003\u00b8\\\u0000\u013f"+
		"\u0153\u0003\u009aM\u0000\u0140\u0153\u0003\u00ba]\u0000\u0141\u0153\u0003"+
		"\u00bc^\u0000\u0142\u0153\u0003\u00c0`\u0000\u0143\u0153\u0003\u00be_"+
		"\u0000\u0144\u0153\u0003\u00c2a\u0000\u0145\u0153\u0003\u00c4b\u0000\u0146"+
		"\u0153\u0003\u00c6c\u0000\u0147\u0153\u0003\u00c8d\u0000\u0148\u0153\u0003"+
		"\u00cae\u0000\u0149\u0153\u0003\u00ccf\u0000\u014a\u0153\u0003\u00ceg"+
		"\u0000\u014b\u0153\u0003\u00d0h\u0000\u014c\u0153\u0003\u00d2i\u0000\u014d"+
		"\u0153\u0003\u00d4j\u0000\u014e\u0153\u0003\u00d6k\u0000\u014f\u0153\u0003"+
		"\u00dam\u0000\u0150\u0153\u0003\u0016\u000b\u0000\u0151\u0153\u0003\n"+
		"\u0005\u0000\u0152\u00f8\u0001\u0000\u0000\u0000\u0152\u00f9\u0001\u0000"+
		"\u0000\u0000\u0152\u00fa\u0001\u0000\u0000\u0000\u0152\u00fb\u0001\u0000"+
		"\u0000\u0000\u0152\u00fc\u0001\u0000\u0000\u0000\u0152\u00fd\u0001\u0000"+
		"\u0000\u0000\u0152\u00fe\u0001\u0000\u0000\u0000\u0152\u00ff\u0001\u0000"+
		"\u0000\u0000\u0152\u0100\u0001\u0000\u0000\u0000\u0152\u0101\u0001\u0000"+
		"\u0000\u0000\u0152\u0102\u0001\u0000\u0000\u0000\u0152\u0103\u0001\u0000"+
		"\u0000\u0000\u0152\u0104\u0001\u0000\u0000\u0000\u0152\u0105\u0001\u0000"+
		"\u0000\u0000\u0152\u0106\u0001\u0000\u0000\u0000\u0152\u0107\u0001\u0000"+
		"\u0000\u0000\u0152\u0108\u0001\u0000\u0000\u0000\u0152\u0109\u0001\u0000"+
		"\u0000\u0000\u0152\u010a\u0001\u0000\u0000\u0000\u0152\u010b\u0001\u0000"+
		"\u0000\u0000\u0152\u010c\u0001\u0000\u0000\u0000\u0152\u010d\u0001\u0000"+
		"\u0000\u0000\u0152\u010e\u0001\u0000\u0000\u0000\u0152\u010f\u0001\u0000"+
		"\u0000\u0000\u0152\u0110\u0001\u0000\u0000\u0000\u0152\u0111\u0001\u0000"+
		"\u0000\u0000\u0152\u0112\u0001\u0000\u0000\u0000\u0152\u0113\u0001\u0000"+
		"\u0000\u0000\u0152\u0114\u0001\u0000\u0000\u0000\u0152\u0115\u0001\u0000"+
		"\u0000\u0000\u0152\u0116\u0001\u0000\u0000\u0000\u0152\u0117\u0001\u0000"+
		"\u0000\u0000\u0152\u0118\u0001\u0000\u0000\u0000\u0152\u0119\u0001\u0000"+
		"\u0000\u0000\u0152\u011a\u0001\u0000\u0000\u0000\u0152\u011b\u0001\u0000"+
		"\u0000\u0000\u0152\u011c\u0001\u0000\u0000\u0000\u0152\u011d\u0001\u0000"+
		"\u0000\u0000\u0152\u011e\u0001\u0000\u0000\u0000\u0152\u011f\u0001\u0000"+
		"\u0000\u0000\u0152\u0120\u0001\u0000\u0000\u0000\u0152\u0121\u0001\u0000"+
		"\u0000\u0000\u0152\u0122\u0001\u0000\u0000\u0000\u0152\u0123\u0001\u0000"+
		"\u0000\u0000\u0152\u0124\u0001\u0000\u0000\u0000\u0152\u0125\u0001\u0000"+
		"\u0000\u0000\u0152\u0126\u0001\u0000\u0000\u0000\u0152\u0127\u0001\u0000"+
		"\u0000\u0000\u0152\u0128\u0001\u0000\u0000\u0000\u0152\u0129\u0001\u0000"+
		"\u0000\u0000\u0152\u012a\u0001\u0000\u0000\u0000\u0152\u012b\u0001\u0000"+
		"\u0000\u0000\u0152\u012c\u0001\u0000\u0000\u0000\u0152\u012d\u0001\u0000"+
		"\u0000\u0000\u0152\u012e\u0001\u0000\u0000\u0000\u0152\u012f\u0001\u0000"+
		"\u0000\u0000\u0152\u0130\u0001\u0000\u0000\u0000\u0152\u0131\u0001\u0000"+
		"\u0000\u0000\u0152\u0132\u0001\u0000\u0000\u0000\u0152\u0133\u0001\u0000"+
		"\u0000\u0000\u0152\u0134\u0001\u0000\u0000\u0000\u0152\u0135\u0001\u0000"+
		"\u0000\u0000\u0152\u0136\u0001\u0000\u0000\u0000\u0152\u0137\u0001\u0000"+
		"\u0000\u0000\u0152\u0138\u0001\u0000\u0000\u0000\u0152\u0139\u0001\u0000"+
		"\u0000\u0000\u0152\u013a\u0001\u0000\u0000\u0000\u0152\u013b\u0001\u0000"+
		"\u0000\u0000\u0152\u013c\u0001\u0000\u0000\u0000\u0152\u013d\u0001\u0000"+
		"\u0000\u0000\u0152\u013e\u0001\u0000\u0000\u0000\u0152\u013f\u0001\u0000"+
		"\u0000\u0000\u0152\u0140\u0001\u0000\u0000\u0000\u0152\u0141\u0001\u0000"+
		"\u0000\u0000\u0152\u0142\u0001\u0000\u0000\u0000\u0152\u0143\u0001\u0000"+
		"\u0000\u0000\u0152\u0144\u0001\u0000\u0000\u0000\u0152\u0145\u0001\u0000"+
		"\u0000\u0000\u0152\u0146\u0001\u0000\u0000\u0000\u0152\u0147\u0001\u0000"+
		"\u0000\u0000\u0152\u0148\u0001\u0000\u0000\u0000\u0152\u0149\u0001\u0000"+
		"\u0000\u0000\u0152\u014a\u0001\u0000\u0000\u0000\u0152\u014b\u0001\u0000"+
		"\u0000\u0000\u0152\u014c\u0001\u0000\u0000\u0000\u0152\u014d\u0001\u0000"+
		"\u0000\u0000\u0152\u014e\u0001\u0000\u0000\u0000\u0152\u014f\u0001\u0000"+
		"\u0000\u0000\u0152\u0150\u0001\u0000\u0000\u0000\u0152\u0151\u0001\u0000"+
		"\u0000\u0000\u0153\t\u0001\u0000\u0000\u0000\u0154\u0157\u0003\f\u0006"+
		"\u0000\u0155\u0157\u0003\u000e\u0007\u0000\u0156\u0154\u0001\u0000\u0000"+
		"\u0000\u0156\u0155\u0001\u0000\u0000\u0000\u0157\u000b\u0001\u0000\u0000"+
		"\u0000\u0158\u015a\u0003\u0010\b\u0000\u0159\u015b\u0003\u0012\t\u0000"+
		"\u015a\u0159\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000\u0000\u0000"+
		"\u015b\u0167\u0001\u0000\u0000\u0000\u015c\u015d\u0005\u00c3\u0000\u0000"+
		"\u015d\u0162\u0003\u0014\n\u0000\u015e\u015f\u0005\u00b6\u0000\u0000\u015f"+
		"\u0161\u0003\u0014\n\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0161\u0164"+
		"\u0001\u0000\u0000\u0000\u0162\u0160\u0001\u0000\u0000\u0000\u0162\u0163"+
		"\u0001\u0000\u0000\u0000\u0163\u0165\u0001\u0000\u0000\u0000\u0164\u0162"+
		"\u0001\u0000\u0000\u0000\u0165\u0166\u0005\u00c4\u0000\u0000\u0166\u0168"+
		"\u0001\u0000\u0000\u0000\u0167\u015c\u0001\u0000\u0000\u0000\u0167\u0168"+
		"\u0001\u0000\u0000\u0000\u0168\r\u0001\u0000\u0000\u0000\u0169\u016e\u0003"+
		"\u0010\b\u0000\u016a\u016b\u0005\u00df\u0000\u0000\u016b\u016d\u0003\u0010"+
		"\b\u0000\u016c\u016a\u0001\u0000\u0000\u0000\u016d\u0170\u0001\u0000\u0000"+
		"\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016e\u016f\u0001\u0000\u0000"+
		"\u0000\u016f\u0171\u0001\u0000\u0000\u0000\u0170\u016e\u0001\u0000\u0000"+
		"\u0000\u0171\u0172\u0005\u00df\u0000\u0000\u0172\u017e\u0003\f\u0006\u0000"+
		"\u0173\u0174\u0005\u00c3\u0000\u0000\u0174\u0179\u0003\u0014\n\u0000\u0175"+
		"\u0176\u0005\u00b6\u0000\u0000\u0176\u0178\u0003\u0014\n\u0000\u0177\u0175"+
		"\u0001\u0000\u0000\u0000\u0178\u017b\u0001\u0000\u0000\u0000\u0179\u0177"+
		"\u0001\u0000\u0000\u0000\u0179\u017a\u0001\u0000\u0000\u0000\u017a\u017c"+
		"\u0001\u0000\u0000\u0000\u017b\u0179\u0001\u0000\u0000\u0000\u017c\u017d"+
		"\u0005\u00c4\u0000\u0000\u017d\u017f\u0001\u0000\u0000\u0000\u017e\u0173"+
		"\u0001\u0000\u0000\u0000\u017e\u017f\u0001\u0000\u0000\u0000\u017f\u000f"+
		"\u0001\u0000\u0000\u0000\u0180\u0181\u0005\u00d6\u0000\u0000\u0181\u0011"+
		"\u0001\u0000\u0000\u0000\u0182\u0183\u0007\u0000\u0000\u0000\u0183\u0013"+
		"\u0001\u0000\u0000\u0000\u0184\u0186\u0006\n\uffff\uffff\u0000\u0185\u0187"+
		"\u0007\u0001\u0000\u0000\u0186\u0185\u0001\u0000\u0000\u0000\u0186\u0187"+
		"\u0001\u0000\u0000\u0000\u0187\u0188\u0001\u0000\u0000\u0000\u0188\u0199"+
		"\u0003\u0016\u000b\u0000\u0189\u018b\u0007\u0001\u0000\u0000\u018a\u0189"+
		"\u0001\u0000\u0000\u0000\u018a\u018b\u0001\u0000\u0000\u0000\u018b\u018c"+
		"\u0001\u0000\u0000\u0000\u018c\u0199\u0003\u00deo\u0000\u018d\u018f\u0007"+
		"\u0001\u0000\u0000\u018e\u018d\u0001\u0000\u0000\u0000\u018e\u018f\u0001"+
		"\u0000\u0000\u0000\u018f\u0190\u0001\u0000\u0000\u0000\u0190\u0199\u0003"+
		"\n\u0005\u0000\u0191\u0192\u0005\u00c3\u0000\u0000\u0192\u0193\u0003\u0014"+
		"\n\u0000\u0193\u0194\u0005\u00c4\u0000\u0000\u0194\u0199\u0001\u0000\u0000"+
		"\u0000\u0195\u0199\u0003\u00dcn\u0000\u0196\u0197\u0005\u00d0\u0000\u0000"+
		"\u0197\u0199\u0003\u0014\n\u0003\u0198\u0184\u0001\u0000\u0000\u0000\u0198"+
		"\u018a\u0001\u0000\u0000\u0000\u0198\u018e\u0001\u0000\u0000\u0000\u0198"+
		"\u0191\u0001\u0000\u0000\u0000\u0198\u0195\u0001\u0000\u0000\u0000\u0198"+
		"\u0196\u0001\u0000\u0000\u0000\u0199\u01b1\u0001\u0000\u0000\u0000\u019a"+
		"\u019b\n\b\u0000\u0000\u019b\u019c\u0005\u00bf\u0000\u0000\u019c\u01b0"+
		"\u0003\u0014\n\t\u019d\u019e\n\u0007\u0000\u0000\u019e\u019f\u0007\u0002"+
		"\u0000\u0000\u019f\u01b0\u0003\u0014\n\b\u01a0\u01a1\n\u0006\u0000\u0000"+
		"\u01a1\u01a2\u0005\u00c7\u0000\u0000\u01a2\u01b0\u0003\u0014\n\u0007\u01a3"+
		"\u01a4\n\u0005\u0000\u0000\u01a4\u01a5\u0007\u0001\u0000\u0000\u01a5\u01b0"+
		"\u0003\u0014\n\u0006\u01a6\u01a7\n\u0004\u0000\u0000\u01a7\u01a8\u0007"+
		"\u0003\u0000\u0000\u01a8\u01b0\u0003\u0014\n\u0005\u01a9\u01aa\n\u0002"+
		"\u0000\u0000\u01aa\u01ab\u0007\u0004\u0000\u0000\u01ab\u01b0\u0003\u0014"+
		"\n\u0003\u01ac\u01ad\n\u0001\u0000\u0000\u01ad\u01ae\u0007\u0005\u0000"+
		"\u0000\u01ae\u01b0\u0003\u0014\n\u0002\u01af\u019a\u0001\u0000\u0000\u0000"+
		"\u01af\u019d\u0001\u0000\u0000\u0000\u01af\u01a0\u0001\u0000\u0000\u0000"+
		"\u01af\u01a3\u0001\u0000\u0000\u0000\u01af\u01a6\u0001\u0000\u0000\u0000"+
		"\u01af\u01a9\u0001\u0000\u0000\u0000\u01af\u01ac\u0001\u0000\u0000\u0000"+
		"\u01b0\u01b3\u0001\u0000\u0000\u0000\u01b1\u01af\u0001\u0000\u0000\u0000"+
		"\u01b1\u01b2\u0001\u0000\u0000\u0000\u01b2\u0015\u0001\u0000\u0000\u0000"+
		"\u01b3\u01b1\u0001\u0000\u0000\u0000\u01b4\u01b5\u0003\n\u0005\u0000\u01b5"+
		"\u01b6\u0005\u00df\u0000\u0000\u01b6\u01b7\u0003\u0018\f\u0000\u01b7\u01c0"+
		"\u0005\u00c3\u0000\u0000\u01b8\u01bd\u0003\u0014\n\u0000\u01b9\u01ba\u0005"+
		"\u00b6\u0000\u0000\u01ba\u01bc\u0003\u0014\n\u0000\u01bb\u01b9\u0001\u0000"+
		"\u0000\u0000\u01bc\u01bf\u0001\u0000\u0000\u0000\u01bd\u01bb\u0001\u0000"+
		"\u0000\u0000\u01bd\u01be\u0001\u0000\u0000\u0000\u01be\u01c1\u0001\u0000"+
		"\u0000\u0000\u01bf\u01bd\u0001\u0000\u0000\u0000\u01c0\u01b8\u0001\u0000"+
		"\u0000\u0000\u01c0\u01c1\u0001\u0000\u0000\u0000\u01c1\u01c2\u0001\u0000"+
		"\u0000\u0000\u01c2\u01c3\u0005\u00c4\u0000\u0000\u01c3\u038b\u0001\u0000"+
		"\u0000\u0000\u01c4\u01c5\u0005 \u0000\u0000\u01c5\u01c6\u0005\u00c3\u0000"+
		"\u0000\u01c6\u01c7\u0003\u0014\n\u0000\u01c7\u01c8\u0005\u00c4\u0000\u0000"+
		"\u01c8\u038b\u0001\u0000\u0000\u0000\u01c9\u01ca\u0005!\u0000\u0000\u01ca"+
		"\u01cb\u0005\u00c3\u0000\u0000\u01cb\u01cc\u0003\u0014\n\u0000\u01cc\u01cd"+
		"\u0005\u00c4\u0000\u0000\u01cd\u038b\u0001\u0000\u0000\u0000\u01ce\u01cf"+
		"\u0005\u001b\u0000\u0000\u01cf\u01d0\u0005\u00c3\u0000\u0000\u01d0\u01d1"+
		"\u0003\u0014\n\u0000\u01d1\u01d2\u0005\u00c4\u0000\u0000\u01d2\u038b\u0001"+
		"\u0000\u0000\u0000\u01d3\u01d4\u0005\u001c\u0000\u0000\u01d4\u01d5\u0005"+
		"\u00c3\u0000\u0000\u01d5\u01d6\u0003\u0014\n\u0000\u01d6\u01d7\u0005\u00c4"+
		"\u0000\u0000\u01d7\u038b\u0001\u0000\u0000\u0000\u01d8\u01d9\u0005\u001d"+
		"\u0000\u0000\u01d9\u01da\u0005\u00c3\u0000\u0000\u01da\u01db\u0003\u0014"+
		"\n\u0000\u01db\u01dc\u0005\u00c4\u0000\u0000\u01dc\u038b\u0001\u0000\u0000"+
		"\u0000\u01dd\u01de\u0005\u0082\u0000\u0000\u01de\u01df\u0005\u00c3\u0000"+
		"\u0000\u01df\u01e0\u0003\u0014\n\u0000\u01e0\u01e1\u0005\u00c4\u0000\u0000"+
		"\u01e1\u038b\u0001\u0000\u0000\u0000\u01e2\u01e3\u0005\u0083\u0000\u0000"+
		"\u01e3\u01e4\u0005\u00c3\u0000\u0000\u01e4\u01e5\u0003\u0014\n\u0000\u01e5"+
		"\u01e6\u0005\u00c4\u0000\u0000\u01e6\u038b\u0001\u0000\u0000\u0000\u01e7"+
		"\u01e8\u0005\u001e\u0000\u0000\u01e8\u01e9\u0005\u00c3\u0000\u0000\u01e9"+
		"\u01ea\u0003\u0014\n\u0000\u01ea\u01eb\u0005\u00c4\u0000\u0000\u01eb\u038b"+
		"\u0001\u0000\u0000\u0000\u01ec\u01ed\u0005\u0084\u0000\u0000\u01ed\u01ee"+
		"\u0005\u00c3\u0000\u0000\u01ee\u01ef\u0003\u0014\n\u0000\u01ef\u01f0\u0005"+
		"\u00c4\u0000\u0000\u01f0\u038b\u0001\u0000\u0000\u0000\u01f1\u01f2\u0005"+
		"\u0085\u0000\u0000\u01f2\u01f3\u0005\u00c3\u0000\u0000\u01f3\u01f4\u0003"+
		"\u0014\n\u0000\u01f4\u01f5\u0005\u00c4\u0000\u0000\u01f5\u038b\u0001\u0000"+
		"\u0000\u0000\u01f6\u01f7\u0005\u0086\u0000\u0000\u01f7\u01f8\u0005\u00c3"+
		"\u0000\u0000\u01f8\u01f9\u0003\u0014\n\u0000\u01f9\u01fa\u0005\u00c4\u0000"+
		"\u0000\u01fa\u038b\u0001\u0000\u0000\u0000\u01fb\u01fc\u0005\u001f\u0000"+
		"\u0000\u01fc\u01fd\u0005\u00c3\u0000\u0000\u01fd\u01fe\u0003\u0014\n\u0000"+
		"\u01fe\u01ff\u0005\u00c4\u0000\u0000\u01ff\u038b\u0001\u0000\u0000\u0000"+
		"\u0200\u0201\u0005,\u0000\u0000\u0201\u0202\u0005\u00c3\u0000\u0000\u0202"+
		"\u0203\u0003\u0014\n\u0000\u0203\u0204\u0005\u00c4\u0000\u0000\u0204\u038b"+
		"\u0001\u0000\u0000\u0000\u0205\u0206\u0005-\u0000\u0000\u0206\u0207\u0005"+
		"\u00c3\u0000\u0000\u0207\u0208\u0003\u0014\n\u0000\u0208\u0209\u0005\u00c4"+
		"\u0000\u0000\u0209\u038b\u0001\u0000\u0000\u0000\u020a\u020b\u0005.\u0000"+
		"\u0000\u020b\u020c\u0005\u00c3\u0000\u0000\u020c\u020d\u0003\u0014\n\u0000"+
		"\u020d\u020e\u0005\u00c4\u0000\u0000\u020e\u038b\u0001\u0000\u0000\u0000"+
		"\u020f\u0210\u0005/\u0000\u0000\u0210\u0211\u0005\u00c3\u0000\u0000\u0211"+
		"\u0212\u0003\u0014\n\u0000\u0212\u0213\u0005\u00c4\u0000\u0000\u0213\u038b"+
		"\u0001\u0000\u0000\u0000\u0214\u0215\u00050\u0000\u0000\u0215\u0216\u0005"+
		"\u00c3\u0000\u0000\u0216\u0217\u0003\u0014\n\u0000\u0217\u0218\u0005\u00c4"+
		"\u0000\u0000\u0218\u038b\u0001\u0000\u0000\u0000\u0219\u021a\u00053\u0000"+
		"\u0000\u021a\u021b\u0005\u00c3\u0000\u0000\u021b\u021c\u0003\u0014\n\u0000"+
		"\u021c\u021d\u0005\u00c4\u0000\u0000\u021d\u038b\u0001\u0000\u0000\u0000"+
		"\u021e\u021f\u00054\u0000\u0000\u021f\u0220\u0005\u00c3\u0000\u0000\u0220"+
		"\u0221\u0003\u0014\n\u0000\u0221\u0222\u0005\u00c4\u0000\u0000\u0222\u038b"+
		"\u0001\u0000\u0000\u0000\u0223\u0224\u00055\u0000\u0000\u0224\u0225\u0005"+
		"\u00c3\u0000\u0000\u0225\u0226\u0003\u0014\n\u0000\u0226\u0227\u0005\u00c4"+
		"\u0000\u0000\u0227\u038b\u0001\u0000\u0000\u0000\u0228\u0229\u00056\u0000"+
		"\u0000\u0229\u022a\u0005\u00c3\u0000\u0000\u022a\u022b\u0003\u0014\n\u0000"+
		"\u022b\u022c\u0005\u00c4\u0000\u0000\u022c\u038b\u0001\u0000\u0000\u0000"+
		"\u022d\u022e\u00057\u0000\u0000\u022e\u022f\u0005\u00c3\u0000\u0000\u022f"+
		"\u0230\u0003\u0014\n\u0000\u0230\u0231\u0005\u00c4\u0000\u0000\u0231\u038b"+
		"\u0001\u0000\u0000\u0000\u0232\u0233\u00058\u0000\u0000\u0233\u0234\u0005"+
		"\u00c3\u0000\u0000\u0234\u0235\u0003\u0014\n\u0000\u0235\u0236\u0005\u00c4"+
		"\u0000\u0000\u0236\u038b\u0001\u0000\u0000\u0000\u0237\u0238\u00059\u0000"+
		"\u0000\u0238\u0239\u0005\u00c3\u0000\u0000\u0239\u023a\u0003\u0014\n\u0000"+
		"\u023a\u023b\u0005\u00c4\u0000\u0000\u023b\u038b\u0001\u0000\u0000\u0000"+
		"\u023c\u023d\u0005:\u0000\u0000\u023d\u023e\u0005\u00c3\u0000\u0000\u023e"+
		"\u023f\u0003\u0014\n\u0000\u023f\u0240\u0005\u00c4\u0000\u0000\u0240\u038b"+
		"\u0001\u0000\u0000\u0000\u0241\u0242\u0005;\u0000\u0000\u0242\u0243\u0005"+
		"\u00c3\u0000\u0000\u0243\u0244\u0003\u0014\n\u0000\u0244\u0245\u0005\u00c4"+
		"\u0000\u0000\u0245\u038b\u0001\u0000\u0000\u0000\u0246\u0247\u0005<\u0000"+
		"\u0000\u0247\u0248\u0005\u00c3\u0000\u0000\u0248\u0249\u0003\u0014\n\u0000"+
		"\u0249\u024a\u0005\u00c4\u0000\u0000\u024a\u038b\u0001\u0000\u0000\u0000"+
		"\u024b\u024c\u0005=\u0000\u0000\u024c\u024d\u0005\u00c3\u0000\u0000\u024d"+
		"\u024e\u0003\u0014\n\u0000\u024e\u024f\u0005\u00c4\u0000\u0000\u024f\u038b"+
		"\u0001\u0000\u0000\u0000\u0250\u0251\u0005>\u0000\u0000\u0251\u0252\u0005"+
		"\u00c3\u0000\u0000\u0252\u0253\u0003\u0014\n\u0000\u0253\u0254\u0005\u00c4"+
		"\u0000\u0000\u0254\u038b\u0001\u0000\u0000\u0000\u0255\u0256\u0005?\u0000"+
		"\u0000\u0256\u0257\u0005\u00c3\u0000\u0000\u0257\u0258\u0003\u0014\n\u0000"+
		"\u0258\u0259\u0005\u00c4\u0000\u0000\u0259\u038b\u0001\u0000\u0000\u0000"+
		"\u025a\u025b\u0005@\u0000\u0000\u025b\u025c\u0005\u00c3\u0000\u0000\u025c"+
		"\u025d\u0003\u0014\n\u0000\u025d\u025e\u0005\u00c4\u0000\u0000\u025e\u038b"+
		"\u0001\u0000\u0000\u0000\u025f\u0260\u0005\u008e\u0000\u0000\u0260\u0261"+
		"\u0005\u00c3\u0000\u0000\u0261\u0262\u0003\u0014\n\u0000\u0262\u0263\u0005"+
		"\u00c4\u0000\u0000\u0263\u038b\u0001\u0000\u0000\u0000\u0264\u0265\u0005"+
		"\u008f\u0000\u0000\u0265\u0266\u0005\u00c3\u0000\u0000\u0266\u0267\u0003"+
		"\u0014\n\u0000\u0267\u0268\u0005\u00c4\u0000\u0000\u0268\u038b\u0001\u0000"+
		"\u0000\u0000\u0269\u026a\u0005\u0090\u0000\u0000\u026a\u026b\u0005\u00c3"+
		"\u0000\u0000\u026b\u026c\u0003\u0014\n\u0000\u026c\u026d\u0005\u00c4\u0000"+
		"\u0000\u026d\u038b\u0001\u0000\u0000\u0000\u026e\u026f\u0005\u0091\u0000"+
		"\u0000\u026f\u0270\u0005\u00c3\u0000\u0000\u0270\u0271\u0003\u0014\n\u0000"+
		"\u0271\u0272\u0005\u00c4\u0000\u0000\u0272\u038b\u0001\u0000\u0000\u0000"+
		"\u0273\u0274\u0005\u0092\u0000\u0000\u0274\u0275\u0005\u00c3\u0000\u0000"+
		"\u0275\u0276\u0003\u0014\n\u0000\u0276\u0277\u0005\u00c4\u0000\u0000\u0277"+
		"\u038b\u0001\u0000\u0000\u0000\u0278\u0279\u0005\u008c\u0000\u0000\u0279"+
		"\u027a\u0005\u00c3\u0000\u0000\u027a\u027b\u0003\u0014\n\u0000\u027b\u027c"+
		"\u0005\u00c4\u0000\u0000\u027c\u038b\u0001\u0000\u0000\u0000\u027d\u027e"+
		"\u0005\u008b\u0000\u0000\u027e\u027f\u0005\u00c3\u0000\u0000\u027f\u0280"+
		"\u0003\u0014\n\u0000\u0280\u0281\u0005\u00c4\u0000\u0000\u0281\u038b\u0001"+
		"\u0000\u0000\u0000\u0282\u0283\u0005\u008d\u0000\u0000\u0283\u0284\u0005"+
		"\u00c3\u0000\u0000\u0284\u0285\u0003\u0014\n\u0000\u0285\u0286\u0005\u00c4"+
		"\u0000\u0000\u0286\u038b\u0001\u0000\u0000\u0000\u0287\u0288\u0005\u0089"+
		"\u0000\u0000\u0288\u0289\u0005\u00c3\u0000\u0000\u0289\u028a\u0003\u0014"+
		"\n\u0000\u028a\u028b\u0005\u00b6\u0000\u0000\u028b\u028c\u0003\u0014\n"+
		"\u0000\u028c\u028d\u0005\u00c4\u0000\u0000\u028d\u038b\u0001\u0000\u0000"+
		"\u0000\u028e\u028f\u0005\u008a\u0000\u0000\u028f\u0290\u0005\u00c3\u0000"+
		"\u0000\u0290\u0291\u0003\u0014\n\u0000\u0291\u0292\u0005\u00b6\u0000\u0000"+
		"\u0292\u0293\u0003\u0014\n\u0000\u0293\u0294\u0005\u00c4\u0000\u0000\u0294"+
		"\u038b\u0001\u0000\u0000\u0000\u0295\u0296\u0005\u0088\u0000\u0000\u0296"+
		"\u0297\u0005\u00c3\u0000\u0000\u0297\u038b\u0005\u00c4\u0000\u0000\u0298"+
		"\u0299\u0005\u0087\u0000\u0000\u0299\u029a\u0005\u00c3\u0000\u0000\u029a"+
		"\u038b\u0005\u00c4\u0000\u0000\u029b\u029c\u0005A\u0000\u0000\u029c\u029d"+
		"\u0005\u00c3\u0000\u0000\u029d\u02a0\u0003\u0014\n\u0000\u029e\u029f\u0005"+
		"\u00b6\u0000\u0000\u029f\u02a1\u0003\u0014\n\u0000\u02a0\u029e\u0001\u0000"+
		"\u0000\u0000\u02a0\u02a1\u0001\u0000\u0000\u0000\u02a1\u02a2\u0001\u0000"+
		"\u0000\u0000\u02a2\u02a3\u0005\u00c4\u0000\u0000\u02a3\u038b\u0001\u0000"+
		"\u0000\u0000\u02a4\u02a5\u0005F\u0000\u0000\u02a5\u02a6\u0005\u00c3\u0000"+
		"\u0000\u02a6\u02a7\u0003\u0014\n\u0000\u02a7\u02a8\u0005\u00c4\u0000\u0000"+
		"\u02a8\u038b\u0001\u0000\u0000\u0000\u02a9\u02aa\u0005G\u0000\u0000\u02aa"+
		"\u02ab\u0005\u00c3\u0000\u0000\u02ab\u02ac\u0003\u0014\n\u0000\u02ac\u02ad"+
		"\u0005\u00c4\u0000\u0000\u02ad\u038b\u0001\u0000\u0000\u0000\u02ae\u02af"+
		"\u0005B\u0000\u0000\u02af\u02b0\u0005\u00c3\u0000\u0000\u02b0\u02b1\u0003"+
		"\u0014\n\u0000\u02b1\u02b2\u0005\u00b6\u0000\u0000\u02b2\u02b3\u0003\u0014"+
		"\n\u0000\u02b3\u02b4\u0005\u00c4\u0000\u0000\u02b4\u038b\u0001\u0000\u0000"+
		"\u0000\u02b5\u02b6\u0005C\u0000\u0000\u02b6\u02b7\u0005\u00c3\u0000\u0000"+
		"\u02b7\u02b8\u0003\u0014\n\u0000\u02b8\u02b9\u0005\u00b6\u0000\u0000\u02b9"+
		"\u02ba\u0003\u0014\n\u0000\u02ba\u02bb\u0005\u00c4\u0000\u0000\u02bb\u038b"+
		"\u0001\u0000\u0000\u0000\u02bc\u02bd\u0005D\u0000\u0000\u02bd\u02be\u0005"+
		"\u00c3\u0000\u0000\u02be\u02bf\u0003\u0014\n\u0000\u02bf\u02c0\u0005\u00b6"+
		"\u0000\u0000\u02c0\u02c3\u0003\u0014\n\u0000\u02c1\u02c2\u0005\u00b6\u0000"+
		"\u0000\u02c2\u02c4\u0003\u0014\n\u0000\u02c3\u02c1\u0001\u0000\u0000\u0000"+
		"\u02c3\u02c4\u0001\u0000\u0000\u0000\u02c4\u02c5\u0001\u0000\u0000\u0000"+
		"\u02c5\u02c6\u0005\u00c4\u0000\u0000\u02c6\u038b\u0001\u0000\u0000\u0000"+
		"\u02c7\u02c8\u0005E\u0000\u0000\u02c8\u02c9\u0005\u00c3\u0000\u0000\u02c9"+
		"\u02ca\u0003\u0014\n\u0000\u02ca\u02cb\u0005\u00b6\u0000\u0000\u02cb\u02ce"+
		"\u0003\u0014\n\u0000\u02cc\u02cd\u0005\u00b6\u0000\u0000\u02cd\u02cf\u0003"+
		"\u0014\n\u0000\u02ce\u02cc\u0001\u0000\u0000\u0000\u02ce\u02cf\u0001\u0000"+
		"\u0000\u0000\u02cf\u02d0\u0001\u0000\u0000\u0000\u02d0\u02d1\u0005\u00c4"+
		"\u0000\u0000\u02d1\u038b\u0001\u0000\u0000\u0000\u02d2\u038b\u0005H\u0000"+
		"\u0000\u02d3\u02d4\u0005I\u0000\u0000\u02d4\u02d5\u0005\u00c3\u0000\u0000"+
		"\u02d5\u02d6\u0003\u0014\n\u0000\u02d6\u02d7\u0005\u00c4\u0000\u0000\u02d7"+
		"\u038b\u0001\u0000\u0000\u0000\u02d8\u02d9\u0005l\u0000\u0000\u02d9\u02da"+
		"\u0005\u00c3\u0000\u0000\u02da\u02db\u0003\u0014\n\u0000\u02db\u02dc\u0005"+
		"\u00c4\u0000\u0000\u02dc\u038b\u0001\u0000\u0000\u0000\u02dd\u038b\u0005"+
		"J\u0000\u0000\u02de\u038b\u0005K\u0000\u0000\u02df\u02e0\u0005L\u0000"+
		"\u0000\u02e0\u02e1\u0005\u00c3\u0000\u0000\u02e1\u02e2\u0003\u0014\n\u0000"+
		"\u02e2\u02e3\u0005\u00b6\u0000\u0000\u02e3\u02e4\u0003\u0014\n\u0000\u02e4"+
		"\u02e5\u0005\u00c4\u0000\u0000\u02e5\u038b\u0001\u0000\u0000\u0000\u02e6"+
		"\u02e7\u0005a\u0000\u0000\u02e7\u02e8\u0005\u00c3\u0000\u0000\u02e8\u02e9"+
		"\u0003\u0014\n\u0000\u02e9\u02ea\u0005\u00c4\u0000\u0000\u02ea\u038b\u0001"+
		"\u0000\u0000\u0000\u02eb\u02ec\u0005b\u0000\u0000\u02ec\u02ed\u0005\u00c3"+
		"\u0000\u0000\u02ed\u02ee\u0003\u0014\n\u0000\u02ee\u02ef\u0005\u00c4\u0000"+
		"\u0000\u02ef\u038b\u0001\u0000\u0000\u0000\u02f0\u02f1\u0005c\u0000\u0000"+
		"\u02f1\u02f2\u0005\u00c3\u0000\u0000\u02f2\u02f3\u0003\u0014\n\u0000\u02f3"+
		"\u02f4\u0005\u00c4\u0000\u0000\u02f4\u038b\u0001\u0000\u0000\u0000\u02f5"+
		"\u02f6\u0005U\u0000\u0000\u02f6\u02f7\u0005\u00c3\u0000\u0000\u02f7\u02fd"+
		"\u0003\u0014\n\u0000\u02f8\u02fa\u0005\u00b6\u0000\u0000\u02f9\u02fb\u0005"+
		"\u00bd\u0000\u0000\u02fa\u02f9\u0001\u0000\u0000\u0000\u02fa\u02fb\u0001"+
		"\u0000\u0000\u0000\u02fb\u02fc\u0001\u0000\u0000\u0000\u02fc\u02fe\u0003"+
		"\u0014\n\u0000\u02fd\u02f8\u0001\u0000\u0000\u0000\u02fd\u02fe\u0001\u0000"+
		"\u0000\u0000\u02fe\u02ff\u0001\u0000\u0000\u0000\u02ff\u0300\u0005\u00c4"+
		"\u0000\u0000\u0300\u038b\u0001\u0000\u0000\u0000\u0301\u038b\u0005q\u0000"+
		"\u0000\u0302\u0303\u0005\u0096\u0000\u0000\u0303\u0304\u0005\u00c3\u0000"+
		"\u0000\u0304\u0305\u0003\n\u0005\u0000\u0305\u0306\u0005\u00c4\u0000\u0000"+
		"\u0306\u038b\u0001\u0000\u0000\u0000\u0307\u0308\u0005\u0097\u0000\u0000"+
		"\u0308\u0309\u0005\u00c3\u0000\u0000\u0309\u030a\u0003\n\u0005\u0000\u030a"+
		"\u030b\u0005\u00c4\u0000\u0000\u030b\u038b\u0001\u0000\u0000\u0000\u030c"+
		"\u030d\u0005\u0098\u0000\u0000\u030d\u030e\u0005\u00c3\u0000\u0000\u030e"+
		"\u030f\u0003\n\u0005\u0000\u030f\u0310\u0005\u00c4\u0000\u0000\u0310\u038b"+
		"\u0001\u0000\u0000\u0000\u0311\u0312\u0005\u0099\u0000\u0000\u0312\u0313"+
		"\u0005\u00c3\u0000\u0000\u0313\u0314\u0003\n\u0005\u0000\u0314\u0315\u0005"+
		"\u00c4\u0000\u0000\u0315\u038b\u0001\u0000\u0000\u0000\u0316\u0317\u0005"+
		"\u009a\u0000\u0000\u0317\u0318\u0005\u00c3\u0000\u0000\u0318\u0319\u0003"+
		"\n\u0005\u0000\u0319\u031a\u0005\u00c4\u0000\u0000\u031a\u038b\u0001\u0000"+
		"\u0000\u0000\u031b\u031c\u0005\u009b\u0000\u0000\u031c\u031d\u0005\u00c3"+
		"\u0000\u0000\u031d\u031e\u0003\n\u0005\u0000\u031e\u031f\u0005\u00c4\u0000"+
		"\u0000\u031f\u038b\u0001\u0000\u0000\u0000\u0320\u0321\u0005\u009c\u0000"+
		"\u0000\u0321\u0322\u0005\u00c3\u0000\u0000\u0322\u0323\u0003\n\u0005\u0000"+
		"\u0323\u0324\u0005\u00b6\u0000\u0000\u0324\u0325\u0003\u0014\n\u0000\u0325"+
		"\u0326\u0005\u00c4\u0000\u0000\u0326\u038b\u0001\u0000\u0000\u0000\u0327"+
		"\u0328\u0005\u009e\u0000\u0000\u0328\u0329\u0005\u00c3\u0000\u0000\u0329"+
		"\u032a\u0003\n\u0005\u0000\u032a\u032b\u0005\u00b6\u0000\u0000\u032b\u032c"+
		"\u0003\u0014\n\u0000\u032c\u032d\u0005\u00c4\u0000\u0000\u032d\u038b\u0001"+
		"\u0000\u0000\u0000\u032e\u032f\u0005\u009f\u0000\u0000\u032f\u0330\u0005"+
		"\u00c3\u0000\u0000\u0330\u0331\u0003\n\u0005\u0000\u0331\u0332\u0005\u00b6"+
		"\u0000\u0000\u0332\u0333\u0003\u0014\n\u0000\u0333\u0334\u0005\u00b6\u0000"+
		"\u0000\u0334\u0335\u0003\u0014\n\u0000\u0335\u0336\u0005\u00b6\u0000\u0000"+
		"\u0336\u0337\u0003\u0014\n\u0000\u0337\u0338\u0005\u00b6\u0000\u0000\u0338"+
		"\u0339\u0003\u0014\n\u0000\u0339\u033a\u0005\u00b6\u0000\u0000\u033a\u033b"+
		"\u0003\u0014\n\u0000\u033b\u033c\u0005\u00c4\u0000\u0000\u033c\u038b\u0001"+
		"\u0000\u0000\u0000\u033d\u033e\u0005\u00a0\u0000\u0000\u033e\u033f\u0005"+
		"\u00c3\u0000\u0000\u033f\u0340\u0003\n\u0005\u0000\u0340\u0341\u0005\u00b6"+
		"\u0000\u0000\u0341\u0342\u0003\u0014\n\u0000\u0342\u0343\u0005\u00b6\u0000"+
		"\u0000\u0343\u0344\u0003\u0014\n\u0000\u0344\u0345\u0005\u00b6\u0000\u0000"+
		"\u0345\u0346\u0003\u0014\n\u0000\u0346\u0347\u0005\u00b6\u0000\u0000\u0347"+
		"\u0348\u0003\u0014\n\u0000\u0348\u0349\u0005\u00b6\u0000\u0000\u0349\u034a"+
		"\u0003\u0014\n\u0000\u034a\u034b\u0005\u00c4\u0000\u0000\u034b\u038b\u0001"+
		"\u0000\u0000\u0000\u034c\u034d\u0005\u00a5\u0000\u0000\u034d\u034e\u0005"+
		"\u00c3\u0000\u0000\u034e\u034f\u0003\u0014\n\u0000\u034f\u0350\u0005\u00b6"+
		"\u0000\u0000\u0350\u0351\u0003\u0014\n\u0000\u0351\u0352\u0005\u00b6\u0000"+
		"\u0000\u0352\u0353\u0003\u0014\n\u0000\u0353\u0354\u0005\u00c4\u0000\u0000"+
		"\u0354\u038b\u0001\u0000\u0000\u0000\u0355\u0356\u0005\u00a8\u0000\u0000"+
		"\u0356\u0357\u0005\u00c3\u0000\u0000\u0357\u038b\u0005\u00c4\u0000\u0000"+
		"\u0358\u0359\u0005\u00a9\u0000\u0000\u0359\u035a\u0005\u00c3\u0000\u0000"+
		"\u035a\u038b\u0005\u00c4\u0000\u0000\u035b\u035c\u0005\u00aa\u0000\u0000"+
		"\u035c\u035d\u0005\u00c3\u0000\u0000\u035d\u038b\u0005\u00c4\u0000\u0000"+
		"\u035e\u035f\u0005\u00ab\u0000\u0000\u035f\u0360\u0005\u00c3\u0000\u0000"+
		"\u0360\u038b\u0005\u00c4\u0000\u0000\u0361\u0362\u0005\u00ac\u0000\u0000"+
		"\u0362\u0363\u0005\u00c3\u0000\u0000\u0363\u038b\u0005\u00c4\u0000\u0000"+
		"\u0364\u0365\u0005\u00ad\u0000\u0000\u0365\u0366\u0005\u00c3\u0000\u0000"+
		"\u0366\u038b\u0005\u00c4\u0000\u0000\u0367\u0368\u0005\u00ae\u0000\u0000"+
		"\u0368\u0369\u0005\u00c3\u0000\u0000\u0369\u038b\u0005\u00c4\u0000\u0000"+
		"\u036a\u036b\u0005\u00af\u0000\u0000\u036b\u036c\u0005\u00c3\u0000\u0000"+
		"\u036c\u036d\u0003\u0014\n\u0000\u036d\u036e\u0005\u00c4\u0000\u0000\u036e"+
		"\u038b\u0001\u0000\u0000\u0000\u036f\u0370\u0005\u00b4\u0000\u0000\u0370"+
		"\u0371\u0005\u00c3\u0000\u0000\u0371\u0372\u0003\u0014\n\u0000\u0372\u0373"+
		"\u0005\u00b6\u0000\u0000\u0373\u0374\u0003\u0014\n\u0000\u0374\u0375\u0005"+
		"\u00c4\u0000\u0000\u0375\u038b\u0001\u0000\u0000\u0000\u0376\u0377\u0005"+
		"$\u0000\u0000\u0377\u0378\u0003\u0012\t\u0000\u0378\u0379\u0005\u00c3"+
		"\u0000\u0000\u0379\u037c\u0003\u0014\n\u0000\u037a\u037b\u0005\u00b6\u0000"+
		"\u0000\u037b\u037d\u0003\u0014\n\u0000\u037c\u037a\u0001\u0000\u0000\u0000"+
		"\u037c\u037d\u0001\u0000\u0000\u0000\u037d\u037e\u0001\u0000\u0000\u0000"+
		"\u037e\u037f\u0005\u00c4\u0000\u0000\u037f\u038b\u0001\u0000\u0000\u0000"+
		"\u0380\u0381\u0005&\u0000\u0000\u0381\u0382\u0005\u00c3\u0000\u0000\u0382"+
		"\u0383\u0003\u0014\n\u0000\u0383\u0384\u0005\u00c4\u0000\u0000\u0384\u038b"+
		"\u0001\u0000\u0000\u0000\u0385\u0386\u0005\'\u0000\u0000\u0386\u0387\u0005"+
		"\u00c3\u0000\u0000\u0387\u0388\u0003\u0014\n\u0000\u0388\u0389\u0005\u00c4"+
		"\u0000\u0000\u0389\u038b\u0001\u0000\u0000\u0000\u038a\u01b4\u0001\u0000"+
		"\u0000\u0000\u038a\u01c4\u0001\u0000\u0000\u0000\u038a\u01c9\u0001\u0000"+
		"\u0000\u0000\u038a\u01ce\u0001\u0000\u0000\u0000\u038a\u01d3\u0001\u0000"+
		"\u0000\u0000\u038a\u01d8\u0001\u0000\u0000\u0000\u038a\u01dd\u0001\u0000"+
		"\u0000\u0000\u038a\u01e2\u0001\u0000\u0000\u0000\u038a\u01e7\u0001\u0000"+
		"\u0000\u0000\u038a\u01ec\u0001\u0000\u0000\u0000\u038a\u01f1\u0001\u0000"+
		"\u0000\u0000\u038a\u01f6\u0001\u0000\u0000\u0000\u038a\u01fb\u0001\u0000"+
		"\u0000\u0000\u038a\u0200\u0001\u0000\u0000\u0000\u038a\u0205\u0001\u0000"+
		"\u0000\u0000\u038a\u020a\u0001\u0000\u0000\u0000\u038a\u020f\u0001\u0000"+
		"\u0000\u0000\u038a\u0214\u0001\u0000\u0000\u0000\u038a\u0219\u0001\u0000"+
		"\u0000\u0000\u038a\u021e\u0001\u0000\u0000\u0000\u038a\u0223\u0001\u0000"+
		"\u0000\u0000\u038a\u0228\u0001\u0000\u0000\u0000\u038a\u022d\u0001\u0000"+
		"\u0000\u0000\u038a\u0232\u0001\u0000\u0000\u0000\u038a\u0237\u0001\u0000"+
		"\u0000\u0000\u038a\u023c\u0001\u0000\u0000\u0000\u038a\u0241\u0001\u0000"+
		"\u0000\u0000\u038a\u0246\u0001\u0000\u0000\u0000\u038a\u024b\u0001\u0000"+
		"\u0000\u0000\u038a\u0250\u0001\u0000\u0000\u0000\u038a\u0255\u0001\u0000"+
		"\u0000\u0000\u038a\u025a\u0001\u0000\u0000\u0000\u038a\u025f\u0001\u0000"+
		"\u0000\u0000\u038a\u0264\u0001\u0000\u0000\u0000\u038a\u0269\u0001\u0000"+
		"\u0000\u0000\u038a\u026e\u0001\u0000\u0000\u0000\u038a\u0273\u0001\u0000"+
		"\u0000\u0000\u038a\u0278\u0001\u0000\u0000\u0000\u038a\u027d\u0001\u0000"+
		"\u0000\u0000\u038a\u0282\u0001\u0000\u0000\u0000\u038a\u0287\u0001\u0000"+
		"\u0000\u0000\u038a\u028e\u0001\u0000\u0000\u0000\u038a\u0295\u0001\u0000"+
		"\u0000\u0000\u038a\u0298\u0001\u0000\u0000\u0000\u038a\u029b\u0001\u0000"+
		"\u0000\u0000\u038a\u02a4\u0001\u0000\u0000\u0000\u038a\u02a9\u0001\u0000"+
		"\u0000\u0000\u038a\u02ae\u0001\u0000\u0000\u0000\u038a\u02b5\u0001\u0000"+
		"\u0000\u0000\u038a\u02bc\u0001\u0000\u0000\u0000\u038a\u02c7\u0001\u0000"+
		"\u0000\u0000\u038a\u02d2\u0001\u0000\u0000\u0000\u038a\u02d3\u0001\u0000"+
		"\u0000\u0000\u038a\u02d8\u0001\u0000\u0000\u0000\u038a\u02dd\u0001\u0000"+
		"\u0000\u0000\u038a\u02de\u0001\u0000\u0000\u0000\u038a\u02df\u0001\u0000"+
		"\u0000\u0000\u038a\u02e6\u0001\u0000\u0000\u0000\u038a\u02eb\u0001\u0000"+
		"\u0000\u0000\u038a\u02f0\u0001\u0000\u0000\u0000\u038a\u02f5\u0001\u0000"+
		"\u0000\u0000\u038a\u0301\u0001\u0000\u0000\u0000\u038a\u0302\u0001\u0000"+
		"\u0000\u0000\u038a\u0307\u0001\u0000\u0000\u0000\u038a\u030c\u0001\u0000"+
		"\u0000\u0000\u038a\u0311\u0001\u0000\u0000\u0000\u038a\u0316\u0001\u0000"+
		"\u0000\u0000\u038a\u031b\u0001\u0000\u0000\u0000\u038a\u0320\u0001\u0000"+
		"\u0000\u0000\u038a\u0327\u0001\u0000\u0000\u0000\u038a\u032e\u0001\u0000"+
		"\u0000\u0000\u038a\u033d\u0001\u0000\u0000\u0000\u038a\u034c\u0001\u0000"+
		"\u0000\u0000\u038a\u0355\u0001\u0000\u0000\u0000\u038a\u0358\u0001\u0000"+
		"\u0000\u0000\u038a\u035b\u0001\u0000\u0000\u0000\u038a\u035e\u0001\u0000"+
		"\u0000\u0000\u038a\u0361\u0001\u0000\u0000\u0000\u038a\u0364\u0001\u0000"+
		"\u0000\u0000\u038a\u0367\u0001\u0000\u0000\u0000\u038a\u036a\u0001\u0000"+
		"\u0000\u0000\u038a\u036f\u0001\u0000\u0000\u0000\u038a\u0376\u0001\u0000"+
		"\u0000\u0000\u038a\u0380\u0001\u0000\u0000\u0000\u038a\u0385\u0001\u0000"+
		"\u0000\u0000\u038b\u0017\u0001\u0000\u0000\u0000\u038c\u0391\u0003\u0010"+
		"\b\u0000\u038d\u0391\u0005`\u0000\u0000\u038e\u0391\u0005W\u0000\u0000"+
		"\u038f\u0391\u0005_\u0000\u0000\u0390\u038c\u0001\u0000\u0000\u0000\u0390"+
		"\u038d\u0001\u0000\u0000\u0000\u0390\u038e\u0001\u0000\u0000\u0000\u0390"+
		"\u038f\u0001\u0000\u0000\u0000\u0391\u0019\u0001\u0000\u0000\u0000\u0392"+
		"\u0393\u0005(\u0000\u0000\u0393\u0394\u0003\u0004\u0002\u0000\u0394\u001b"+
		"\u0001\u0000\u0000\u0000\u0395\u0396\u0005(\u0000\u0000\u0396\u0397\u0003"+
		"\u00dcn\u0000\u0397\u001d\u0001\u0000\u0000\u0000\u0398\u0399\u0005)\u0000"+
		"\u0000\u0399\u001f\u0001\u0000\u0000\u0000\u039a\u039b\u0005\f\u0000\u0000"+
		"\u039b\u039c\u0003\u0014\n\u0000\u039c\u039d\u0005\u00b6\u0000\u0000\u039d"+
		"\u039e\u0005\r\u0000\u0000\u039e\u039f\u0003\u0014\n\u0000\u039f\u03a0"+
		"\u0005\u00b7\u0000\u0000\u03a0\u03a1\u0003(\u0014\u0000\u03a1!\u0001\u0000"+
		"\u0000\u0000\u03a2\u03a3\u0005\u000b\u0000\u0000\u03a3\u03a4\u0005\r\u0000"+
		"\u0000\u03a4\u03a5\u0003\u0014\n\u0000\u03a5\u03a6\u0005\u00b7\u0000\u0000"+
		"\u03a6\u03a7\u0003(\u0014\u0000\u03a7#\u0001\u0000\u0000\u0000\u03a8\u03a9"+
		"\u0005\f\u0000\u0000\u03a9\u03aa\u0003\u0014\n\u0000\u03aa\u03ab\u0005"+
		"\u00b6\u0000\u0000\u03ab\u03ac\u0003(\u0014\u0000\u03ac%\u0001\u0000\u0000"+
		"\u0000\u03ad\u03af\u0007\u0006\u0000\u0000\u03ae\u03b0\u0003(\u0014\u0000"+
		"\u03af\u03ae\u0001\u0000\u0000\u0000\u03af\u03b0\u0001\u0000\u0000\u0000"+
		"\u03b0\'\u0001\u0000\u0000\u0000\u03b1\u03b7\u0003\u0014\n\u0000\u03b2"+
		"\u03b6\u0005\u00b6\u0000\u0000\u03b3\u03b6\u0005\u00b7\u0000\u0000\u03b4"+
		"\u03b6\u0003\u0014\n\u0000\u03b5\u03b2\u0001\u0000\u0000\u0000\u03b5\u03b3"+
		"\u0001\u0000\u0000\u0000\u03b5\u03b4\u0001\u0000\u0000\u0000\u03b6\u03b9"+
		"\u0001\u0000\u0000\u0000\u03b7\u03b5\u0001\u0000\u0000\u0000\u03b7\u03b8"+
		"\u0001\u0000\u0000\u0000\u03b8)\u0001\u0000\u0000\u0000\u03b9\u03b7\u0001"+
		"\u0000\u0000\u0000\u03ba\u03c3\u0005[\u0000\u0000\u03bb\u03c0\u0003\u0014"+
		"\n\u0000\u03bc\u03bd\u0005\u00b6\u0000\u0000\u03bd\u03bf\u0003\u0014\n"+
		"\u0000\u03be\u03bc\u0001\u0000\u0000\u0000\u03bf\u03c2\u0001\u0000\u0000"+
		"\u0000\u03c0\u03be\u0001\u0000\u0000\u0000\u03c0\u03c1\u0001\u0000\u0000"+
		"\u0000\u03c1\u03c4\u0001\u0000\u0000\u0000\u03c2\u03c0\u0001\u0000\u0000"+
		"\u0000\u03c3\u03bb\u0001\u0000\u0000\u0000\u03c3\u03c4\u0001\u0000\u0000"+
		"\u0000\u03c4+\u0001\u0000\u0000\u0000\u03c5\u03c6\u0005\\\u0000\u0000"+
		"\u03c6\u03c7\u0003\u0014\n\u0000\u03c7\u03c8\u0005\u00b6\u0000\u0000\u03c8"+
		"\u03cd\u0003\u0014\n\u0000\u03c9\u03ca\u0005\u00b6\u0000\u0000\u03ca\u03cc"+
		"\u0003\u0014\n\u0000\u03cb\u03c9\u0001\u0000\u0000\u0000\u03cc\u03cf\u0001"+
		"\u0000\u0000\u0000\u03cd\u03cb\u0001\u0000\u0000\u0000\u03cd\u03ce\u0001"+
		"\u0000\u0000\u0000\u03ce-\u0001\u0000\u0000\u0000\u03cf\u03cd\u0001\u0000"+
		"\u0000\u0000\u03d0\u03d2\u0005\t\u0000\u0000\u03d1\u03d0\u0001\u0000\u0000"+
		"\u0000\u03d1\u03d2\u0001\u0000\u0000\u0000\u03d2\u03d3\u0001\u0000\u0000"+
		"\u0000\u03d3\u03d4\u0003\n\u0005\u0000\u03d4\u03d5\u0005\u00c8\u0000\u0000"+
		"\u03d5\u03d6\u0003\u0014\n\u0000\u03d6/\u0001\u0000\u0000\u0000\u03d7"+
		"\u03d8\u0005\n\u0000\u0000\u03d8\u03d9\u0003\u0010\b\u0000\u03d9\u03da"+
		"\u0005\u00c8\u0000\u0000\u03da\u03db\u0003\u0014\n\u0000\u03db1\u0001"+
		"\u0000\u0000\u0000\u03dc\u03dd\u0005\u000e\u0000\u0000\u03dd\u03df\u0003"+
		"\u0014\n\u0000\u03de\u03e0\u0005\u00b6\u0000\u0000\u03df\u03de\u0001\u0000"+
		"\u0000\u0000\u03df\u03e0\u0001\u0000\u0000\u0000\u03e0\u03e1\u0001\u0000"+
		"\u0000\u0000\u03e1\u03e3\u00034\u001a\u0000\u03e2\u03e4\u0005\u00b6\u0000"+
		"\u0000\u03e3\u03e2\u0001\u0000\u0000\u0000\u03e3\u03e4\u0001\u0000\u0000"+
		"\u0000\u03e4\u03e7\u0001\u0000\u0000\u0000\u03e5\u03e6\u0005\u0010\u0000"+
		"\u0000\u03e6\u03e8\u00036\u001b\u0000\u03e7\u03e5\u0001\u0000\u0000\u0000"+
		"\u03e7\u03e8\u0001\u0000\u0000\u0000\u03e83\u0001\u0000\u0000\u0000\u03e9"+
		"\u03ec\u0005\u000f\u0000\u0000\u03ea\u03ed\u0003\u0004\u0002\u0000\u03eb"+
		"\u03ed\u0003>\u001f\u0000\u03ec\u03ea\u0001\u0000\u0000\u0000\u03ec\u03eb"+
		"\u0001\u0000\u0000\u0000\u03ed\u03f1\u0001\u0000\u0000\u0000\u03ee\u03ef"+
		"\u0005\u0011\u0000\u0000\u03ef\u03f1\u0003\u0004\u0002\u0000\u03f0\u03e9"+
		"\u0001\u0000\u0000\u0000\u03f0\u03ee\u0001\u0000\u0000\u0000\u03f15\u0001"+
		"\u0000\u0000\u0000\u03f2\u03f5\u0003\u0004\u0002\u0000\u03f3\u03f5\u0003"+
		">\u001f\u0000\u03f4\u03f2\u0001\u0000\u0000\u0000\u03f4\u03f3\u0001\u0000"+
		"\u0000\u0000\u03f57\u0001\u0000\u0000\u0000\u03f6\u03f7\u0005\u000e\u0000"+
		"\u0000\u03f7\u03f8\u0003\u0014\n\u0000\u03f8\u03f9\u0005\u000f\u0000\u0000"+
		"\u03f9\u03fa\u0005\u00a7\u0000\u0000\u03fa9\u0001\u0000\u0000\u0000\u03fb"+
		"\u03fc\u0005\u0010\u0000\u0000\u03fc\u03fd\u0005\u00a7\u0000\u0000\u03fd"+
		";\u0001\u0000\u0000\u0000\u03fe\u03ff\u0005\u001a\u0000\u0000\u03ff\u0400"+
		"\u0005\u000e\u0000\u0000\u0400=\u0001\u0000\u0000\u0000\u0401\u0406\u0003"+
		"\b\u0004\u0000\u0402\u0403\u0005\u0001\u0000\u0000\u0403\u0405\u0003\b"+
		"\u0004\u0000\u0404\u0402\u0001\u0000\u0000\u0000\u0405\u0408\u0001\u0000"+
		"\u0000\u0000\u0406\u0404\u0001\u0000\u0000\u0000\u0406\u0407\u0001\u0000"+
		"\u0000\u0000\u0407?\u0001\u0000\u0000\u0000\u0408\u0406\u0001\u0000\u0000"+
		"\u0000\u0409\u040a\u0005\u0012\u0000\u0000\u040a\u040b\u0003\n\u0005\u0000"+
		"\u040b\u040c\u0005\u00c8\u0000\u0000\u040c\u040d\u0003\u0014\n\u0000\u040d"+
		"\u040e\u0005\u0014\u0000\u0000\u040e\u0411\u0003\u0014\n\u0000\u040f\u0410"+
		"\u0005\u0015\u0000\u0000\u0410\u0412\u0003\u0014\n\u0000\u0411\u040f\u0001"+
		"\u0000\u0000\u0000\u0411\u0412\u0001\u0000\u0000\u0000\u0412A\u0001\u0000"+
		"\u0000\u0000\u0413\u0415\u0005\u0013\u0000\u0000\u0414\u0416\u0003\n\u0005"+
		"\u0000\u0415\u0414\u0001\u0000\u0000\u0000\u0415\u0416\u0001\u0000\u0000"+
		"\u0000\u0416\u041b\u0001\u0000\u0000\u0000\u0417\u0418\u0005\u00b6\u0000"+
		"\u0000\u0418\u041a\u0003\n\u0005\u0000\u0419\u0417\u0001\u0000\u0000\u0000"+
		"\u041a\u041d\u0001\u0000\u0000\u0000\u041b\u0419\u0001\u0000\u0000\u0000"+
		"\u041b\u041c\u0001\u0000\u0000\u0000\u041cC\u0001\u0000\u0000\u0000\u041d"+
		"\u041b\u0001\u0000\u0000\u0000\u041e\u041f\u0005\u0011\u0000\u0000\u041f"+
		"\u0420\u0003\u0004\u0002\u0000\u0420E\u0001\u0000\u0000\u0000\u0421\u0422"+
		"\u0005\u0011\u0000\u0000\u0422\u0423\u0003\u00dcn\u0000\u0423G\u0001\u0000"+
		"\u0000\u0000\u0424\u0425\u0005\u001a\u0000\u0000\u0425I\u0001\u0000\u0000"+
		"\u0000\u0426\u0427\u0005\"\u0000\u0000\u0427\u0429\u0003\u0010\b\u0000"+
		"\u0428\u042a\u0003\u0012\t\u0000\u0429\u0428\u0001\u0000\u0000\u0000\u0429"+
		"\u042a\u0001\u0000\u0000\u0000\u042a\u0437\u0001\u0000\u0000\u0000\u042b"+
		"\u0434\u0005\u00c3\u0000\u0000\u042c\u0431\u0003\n\u0005\u0000\u042d\u042e"+
		"\u0005\u00b6\u0000\u0000\u042e\u0430\u0003\n\u0005\u0000\u042f\u042d\u0001"+
		"\u0000\u0000\u0000\u0430\u0433\u0001\u0000\u0000\u0000\u0431\u042f\u0001"+
		"\u0000\u0000\u0000\u0431\u0432\u0001\u0000\u0000\u0000\u0432\u0435\u0001"+
		"\u0000\u0000\u0000\u0433\u0431\u0001\u0000\u0000\u0000\u0434\u042c\u0001"+
		"\u0000\u0000\u0000\u0434\u0435\u0001\u0000\u0000\u0000\u0435\u0436\u0001"+
		"\u0000\u0000\u0000\u0436\u0438\u0005\u00c4\u0000\u0000\u0437\u042b\u0001"+
		"\u0000\u0000\u0000\u0437\u0438\u0001\u0000\u0000\u0000\u0438\u0439\u0001"+
		"\u0000\u0000\u0000\u0439\u043a\u0005\u00c8\u0000\u0000\u043a\u043b\u0003"+
		"\u0014\n\u0000\u043bK\u0001\u0000\u0000\u0000\u043c\u043d\u0005\u0017"+
		"\u0000\u0000\u043d\u043f\u0003\u0010\b\u0000\u043e\u0440\u0003\u0012\t"+
		"\u0000\u043f\u043e\u0001\u0000\u0000\u0000\u043f\u0440\u0001\u0000\u0000"+
		"\u0000\u0440\u0441\u0001\u0000\u0000\u0000\u0441\u044a\u0005\u00c3\u0000"+
		"\u0000\u0442\u0447\u0003\u00d8l\u0000\u0443\u0444\u0005\u00b6\u0000\u0000"+
		"\u0444\u0446\u0003\u00d8l\u0000\u0445\u0443\u0001\u0000\u0000\u0000\u0446"+
		"\u0449\u0001\u0000\u0000\u0000\u0447\u0445\u0001\u0000\u0000\u0000\u0447"+
		"\u0448\u0001\u0000\u0000\u0000\u0448\u044b\u0001\u0000\u0000\u0000\u0449"+
		"\u0447\u0001\u0000\u0000\u0000\u044a\u0442\u0001\u0000\u0000\u0000\u044a"+
		"\u044b\u0001\u0000\u0000\u0000\u044b\u044c\u0001\u0000\u0000\u0000\u044c"+
		"\u044d\u0005\u00c4\u0000\u0000\u044d\u044e\u0005\u00c5\u0000\u0000\u044e"+
		"M\u0001\u0000\u0000\u0000\u044f\u0450\u0005)\u0000\u0000\u0450\u0451\u0003"+
		"\u0014\n\u0000\u0451O\u0001\u0000\u0000\u0000\u0452\u0453\u0005\u00c6"+
		"\u0000\u0000\u0453Q\u0001\u0000\u0000\u0000\u0454\u0455\u0005\u0019\u0000"+
		"\u0000\u0455\u0456\u0003\u00dcn\u0000\u0456S\u0001\u0000\u0000\u0000\u0457"+
		"\u0458\u0005\u0018\u0000\u0000\u0458\u0459\u0003\u00dcn\u0000\u0459U\u0001"+
		"\u0000\u0000\u0000\u045a\u045b\u0005#\u0000\u0000\u045b\u045d\u0003\u0010"+
		"\b\u0000\u045c\u045e\u0003\u0012\t\u0000\u045d\u045c\u0001\u0000\u0000"+
		"\u0000\u045d\u045e\u0001\u0000\u0000\u0000\u045e\u045f\u0001\u0000\u0000"+
		"\u0000\u045f\u0460\u0005\u00c3\u0000\u0000\u0460\u0465\u0003\u0014\n\u0000"+
		"\u0461\u0462\u0005\u00b6\u0000\u0000\u0462\u0464\u0003\u0014\n\u0000\u0463"+
		"\u0461\u0001\u0000\u0000\u0000\u0464\u0467\u0001\u0000\u0000\u0000\u0465"+
		"\u0463\u0001\u0000\u0000\u0000\u0465\u0466\u0001\u0000\u0000\u0000\u0466"+
		"\u0468\u0001\u0000\u0000\u0000\u0467\u0465\u0001\u0000\u0000\u0000\u0468"+
		"\u0469\u0005\u00c4\u0000\u0000\u0469W\u0001\u0000\u0000\u0000\u046a\u046b"+
		"\u0005%\u0000\u0000\u046b\u046d\u0003\u0010\b\u0000\u046c\u046e\u0003"+
		"\u0012\t\u0000\u046d\u046c\u0001\u0000\u0000\u0000\u046d\u046e\u0001\u0000"+
		"\u0000\u0000\u046e\u046f\u0001\u0000\u0000\u0000\u046f\u0470\u0005\u00c3"+
		"\u0000\u0000\u0470\u0475\u0003\u0014\n\u0000\u0471\u0472\u0005\u00b6\u0000"+
		"\u0000\u0472\u0474\u0003\u0014\n\u0000\u0473\u0471\u0001\u0000\u0000\u0000"+
		"\u0474\u0477\u0001\u0000\u0000\u0000\u0475\u0473\u0001\u0000\u0000\u0000"+
		"\u0475\u0476\u0001\u0000\u0000\u0000\u0476\u0478\u0001\u0000\u0000\u0000"+
		"\u0477\u0475\u0001\u0000\u0000\u0000\u0478\u0479\u0005\u00c4\u0000\u0000"+
		"\u0479Y\u0001\u0000\u0000\u0000\u047a\u047b\u00051\u0000\u0000\u047b\u047c"+
		"\u0003\u0014\n\u0000\u047c[\u0001\u0000\u0000\u0000\u047d\u047e\u0005"+
		"2\u0000\u0000\u047e]\u0001\u0000\u0000\u0000\u047f\u0480\u0005*\u0000"+
		"\u0000\u0480\u0481\u0003\n\u0005\u0000\u0481\u0482\u0005\u00c8\u0000\u0000"+
		"\u0482\u0483\u0003\u0014\n\u0000\u0483_\u0001\u0000\u0000\u0000\u0484"+
		"\u0485\u0005+\u0000\u0000\u0485\u0486\u0003\n\u0005\u0000\u0486\u0487"+
		"\u0005\u00c8\u0000\u0000\u0487\u0488\u0003\u0014\n\u0000\u0488a\u0001"+
		"\u0000\u0000\u0000\u0489\u048a\u0005M\u0000\u0000\u048a\u048b\u0003\n"+
		"\u0005\u0000\u048b\u048c\u0005\u00b6\u0000\u0000\u048c\u048d\u0003\n\u0005"+
		"\u0000\u048dc\u0001\u0000\u0000\u0000\u048e\u048f\u0005N\u0000\u0000\u048f"+
		"\u0490\u0003j5\u0000\u0490\u0492\u0005\u00b6\u0000\u0000\u0491\u0493\u0005"+
		"\u00bd\u0000\u0000\u0492\u0491\u0001\u0000\u0000\u0000\u0492\u0493\u0001"+
		"\u0000\u0000\u0000\u0493\u0494\u0001\u0000\u0000\u0000\u0494\u0495\u0005"+
		"\u00da\u0000\u0000\u0495\u0496\u0005\u00b6\u0000\u0000\u0496\u0499\u0003"+
		"\u0014\n\u0000\u0497\u0498\u0005\u00b6\u0000\u0000\u0498\u049a\u0003\u0014"+
		"\n\u0000\u0499\u0497\u0001\u0000\u0000\u0000\u0499\u049a\u0001\u0000\u0000"+
		"\u0000\u049ae\u0001\u0000\u0000\u0000\u049b\u049c\u0005N\u0000\u0000\u049c"+
		"\u049f\u0003\u0014\n\u0000\u049d\u049e\u0005\u0012\u0000\u0000\u049e\u04a0"+
		"\u0003l6\u0000\u049f\u049d\u0001\u0000\u0000\u0000\u049f\u04a0\u0001\u0000"+
		"\u0000\u0000\u04a0\u04a3\u0001\u0000\u0000\u0000\u04a1\u04a2\u0005P\u0000"+
		"\u0000\u04a2\u04a4\u0003n7\u0000\u04a3\u04a1\u0001\u0000\u0000\u0000\u04a3"+
		"\u04a4\u0001\u0000\u0000\u0000\u04a4\u04a6\u0001\u0000\u0000\u0000\u04a5"+
		"\u04a7\u0003p8\u0000\u04a6\u04a5\u0001\u0000\u0000\u0000\u04a6\u04a7\u0001"+
		"\u0000\u0000\u0000\u04a7\u04a8\u0001\u0000\u0000\u0000\u04a8\u04aa\u0005"+
		"Q\u0000\u0000\u04a9\u04ab\u0005\u00bd\u0000\u0000\u04aa\u04a9\u0001\u0000"+
		"\u0000\u0000\u04aa\u04ab\u0001\u0000\u0000\u0000\u04ab\u04ac\u0001\u0000"+
		"\u0000\u0000\u04ac\u04b0\u0005\u00da\u0000\u0000\u04ad\u04ae\u0005A\u0000"+
		"\u0000\u04ae\u04af\u0005\u00c8\u0000\u0000\u04af\u04b1\u0003\u0014\n\u0000"+
		"\u04b0\u04ad\u0001\u0000\u0000\u0000\u04b0\u04b1\u0001\u0000\u0000\u0000"+
		"\u04b1g\u0001\u0000\u0000\u0000\u04b2\u04c1\u0005O\u0000\u0000\u04b3\u04b5"+
		"\u0005\u00bd\u0000\u0000\u04b4\u04b3\u0001\u0000\u0000\u0000\u04b4\u04b5"+
		"\u0001\u0000\u0000\u0000\u04b5\u04b6\u0001\u0000\u0000\u0000\u04b6\u04be"+
		"\u0005\u00da\u0000\u0000\u04b7\u04b9\u0005\u00b6\u0000\u0000\u04b8\u04ba"+
		"\u0005\u00bd\u0000\u0000\u04b9\u04b8\u0001\u0000\u0000\u0000\u04b9\u04ba"+
		"\u0001\u0000\u0000\u0000\u04ba\u04bb\u0001\u0000\u0000\u0000\u04bb\u04bd"+
		"\u0005\u00da\u0000\u0000\u04bc\u04b7\u0001\u0000\u0000\u0000\u04bd\u04c0"+
		"\u0001\u0000\u0000\u0000\u04be\u04bc\u0001\u0000\u0000\u0000\u04be\u04bf"+
		"\u0001\u0000\u0000\u0000\u04bf\u04c2\u0001\u0000\u0000\u0000\u04c0\u04be"+
		"\u0001\u0000\u0000\u0000\u04c1\u04b4\u0001\u0000\u0000\u0000\u04c1\u04c2"+
		"\u0001\u0000\u0000\u0000\u04c2i\u0001\u0000\u0000\u0000\u04c3\u04c4\u0005"+
		"\u00b5\u0000\u0000\u04c4k\u0001\u0000\u0000\u0000\u04c5\u04c6\u0007\u0007"+
		"\u0000\u0000\u04c6m\u0001\u0000\u0000\u0000\u04c7\u04cc\u0005Z\u0000\u0000"+
		"\u04c8\u04cc\u0005[\u0000\u0000\u04c9\u04ca\u0005Z\u0000\u0000\u04ca\u04cc"+
		"\u0005[\u0000\u0000\u04cb\u04c7\u0001\u0000\u0000\u0000\u04cb\u04c8\u0001"+
		"\u0000\u0000\u0000\u04cb\u04c9\u0001\u0000\u0000\u0000\u04cco\u0001\u0000"+
		"\u0000\u0000\u04cd\u04d6\u0005]\u0000\u0000\u04ce\u04cf\u0005^\u0000\u0000"+
		"\u04cf\u04d6\u0005Z\u0000\u0000\u04d0\u04d1\u0005^\u0000\u0000\u04d1\u04d6"+
		"\u0005[\u0000\u0000\u04d2\u04d3\u0005^\u0000\u0000\u04d3\u04d4\u0005Z"+
		"\u0000\u0000\u04d4\u04d6\u0005[\u0000\u0000\u04d5\u04cd\u0001\u0000\u0000"+
		"\u0000\u04d5\u04ce\u0001\u0000\u0000\u0000\u04d5\u04d0\u0001\u0000\u0000"+
		"\u0000\u04d5\u04d2\u0001\u0000\u0000\u0000\u04d6q\u0001\u0000\u0000\u0000"+
		"\u04d7\u04d9\u0005_\u0000\u0000\u04d8\u04da\u0005\u00bd\u0000\u0000\u04d9"+
		"\u04d8\u0001\u0000\u0000\u0000\u04d9\u04da\u0001\u0000\u0000\u0000\u04da"+
		"\u04db\u0001\u0000\u0000\u0000\u04db\u04de\u0005\u00da\u0000\u0000\u04dc"+
		"\u04dd\u0005\u00b6\u0000\u0000\u04dd\u04df\u0003\u0014\n\u0000\u04de\u04dc"+
		"\u0001\u0000\u0000\u0000\u04de\u04df\u0001\u0000\u0000\u0000\u04dfs\u0001"+
		"\u0000\u0000\u0000\u04e0\u04e2\u0005`\u0000\u0000\u04e1\u04e3\u0005\u00bd"+
		"\u0000\u0000\u04e2\u04e1\u0001\u0000\u0000\u0000\u04e2\u04e3\u0001\u0000"+
		"\u0000\u0000\u04e3\u04e4\u0001\u0000\u0000\u0000\u04e4\u04e7\u0005\u00da"+
		"\u0000\u0000\u04e5\u04e6\u0005\u00b6\u0000\u0000\u04e6\u04e8\u0003\u0014"+
		"\n\u0000\u04e7\u04e5\u0001\u0000\u0000\u0000\u04e7\u04e8\u0001\u0000\u0000"+
		"\u0000\u04e8u\u0001\u0000\u0000\u0000\u04e9\u04eb\u0005d\u0000\u0000\u04ea"+
		"\u04ec\u0005\u00bd\u0000\u0000\u04eb\u04ea\u0001\u0000\u0000\u0000\u04eb"+
		"\u04ec\u0001\u0000\u0000\u0000\u04ec\u04ed\u0001\u0000\u0000\u0000\u04ed"+
		"\u04ee\u0003\u0014\n\u0000\u04ee\u04ef\u0005\u00b6\u0000\u0000\u04ef\u04f0"+
		"\u0005\u00da\u0000\u0000\u04f0\u04f1\u0005Q\u0000\u0000\u04f1\u04f8\u0003"+
		"\n\u0005\u0000\u04f2\u04f3\u0005\u00b6\u0000\u0000\u04f3\u04f4\u0005\u00da"+
		"\u0000\u0000\u04f4\u04f5\u0005Q\u0000\u0000\u04f5\u04f7\u0003\n\u0005"+
		"\u0000\u04f6\u04f2\u0001\u0000\u0000\u0000\u04f7\u04fa\u0001\u0000\u0000"+
		"\u0000\u04f8\u04f6\u0001\u0000\u0000\u0000\u04f8\u04f9\u0001\u0000\u0000"+
		"\u0000\u04f9w\u0001\u0000\u0000\u0000\u04fa\u04f8\u0001\u0000\u0000\u0000"+
		"\u04fb\u04fd\u0005S\u0000\u0000\u04fc\u04fe\u0005\u00b7\u0000\u0000\u04fd"+
		"\u04fc\u0001\u0000\u0000\u0000\u04fd\u04fe\u0001\u0000\u0000\u0000\u04fe"+
		"\u04ff\u0001\u0000\u0000\u0000\u04ff\u0500\u0003\u0014\n\u0000\u0500\u0501"+
		"\u0007\b\u0000\u0000\u0501\u0502\u0001\u0000\u0000\u0000\u0502\u0507\u0003"+
		"\n\u0005\u0000\u0503\u0504\u0005\u00b6\u0000\u0000\u0504\u0506\u0003\n"+
		"\u0005\u0000\u0505\u0503\u0001\u0000\u0000\u0000\u0506\u0509\u0001\u0000"+
		"\u0000\u0000\u0507\u0505\u0001\u0000\u0000\u0000\u0507\u0508\u0001\u0000"+
		"\u0000\u0000\u0508y\u0001\u0000\u0000\u0000\u0509\u0507\u0001\u0000\u0000"+
		"\u0000\u050a\u050b\u0005T\u0000\u0000\u050b\u050c\u0003\u0014\n\u0000"+
		"\u050c\u050d\u0005\u00b6\u0000\u0000\u050d\u0512\u0003\n\u0005\u0000\u050e"+
		"\u050f\u0005\u00b6\u0000\u0000\u050f\u0511\u0003\n\u0005\u0000\u0510\u050e"+
		"\u0001\u0000\u0000\u0000\u0511\u0514\u0001\u0000\u0000\u0000\u0512\u0510"+
		"\u0001\u0000\u0000\u0000\u0512\u0513\u0001\u0000\u0000\u0000\u0513{\u0001"+
		"\u0000\u0000\u0000\u0514\u0512\u0001\u0000\u0000\u0000\u0515\u0516\u0005"+
		"R\u0000\u0000\u0516\u0518\u0005S\u0000\u0000\u0517\u0519\u0005\u00b7\u0000"+
		"\u0000\u0518\u0517\u0001\u0000\u0000\u0000\u0518\u0519\u0001\u0000\u0000"+
		"\u0000\u0519\u051d\u0001\u0000\u0000\u0000\u051a\u051b\u0003\u0014\n\u0000"+
		"\u051b\u051c\u0005\u00b7\u0000\u0000\u051c\u051e\u0001\u0000\u0000\u0000"+
		"\u051d\u051a\u0001\u0000\u0000\u0000\u051d\u051e\u0001\u0000\u0000\u0000"+
		"\u051e\u051f\u0001\u0000\u0000\u0000\u051f\u0520\u0003\n\u0005\u0000\u0520"+
		"}\u0001\u0000\u0000\u0000\u0521\u0522\u0005R\u0000\u0000\u0522\u0523\u0005"+
		"T\u0000\u0000\u0523\u0524\u0003\u0014\n\u0000\u0524\u0525\u0005\u00b6"+
		"\u0000\u0000\u0525\u0526\u0003\n\u0005\u0000\u0526\u007f\u0001\u0000\u0000"+
		"\u0000\u0527\u0528\u0005Z\u0000\u0000\u0528\u052d\u0003\n\u0005\u0000"+
		"\u0529\u052a\u0005\u00b6\u0000\u0000\u052a\u052c\u0003\n\u0005\u0000\u052b"+
		"\u0529\u0001\u0000\u0000\u0000\u052c\u052f\u0001\u0000\u0000\u0000\u052d"+
		"\u052b\u0001\u0000\u0000\u0000\u052d\u052e\u0001\u0000\u0000\u0000\u052e"+
		"\u0081\u0001\u0000\u0000\u0000\u052f\u052d\u0001\u0000\u0000\u0000\u0530"+
		"\u0533\u0005e\u0000\u0000\u0531\u0534\u0005\u00b5\u0000\u0000\u0532\u0534"+
		"\u0003\u00deo\u0000\u0533\u0531\u0001\u0000\u0000\u0000\u0533\u0532\u0001"+
		"\u0000\u0000\u0000\u0534\u053c\u0001\u0000\u0000\u0000\u0535\u0538\u0005"+
		"\u00b6\u0000\u0000\u0536\u0539\u0005\u00b5\u0000\u0000\u0537\u0539\u0003"+
		"\u00deo\u0000\u0538\u0536\u0001\u0000\u0000\u0000\u0538\u0537\u0001\u0000"+
		"\u0000\u0000\u0539\u053b\u0001\u0000\u0000\u0000\u053a\u0535\u0001\u0000"+
		"\u0000\u0000\u053b\u053e\u0001\u0000\u0000\u0000\u053c\u053a\u0001\u0000"+
		"\u0000\u0000\u053c\u053d\u0001\u0000\u0000\u0000\u053d\u0083\u0001\u0000"+
		"\u0000\u0000\u053e\u053c\u0001\u0000\u0000\u0000\u053f\u0540\u0005f\u0000"+
		"\u0000\u0540\u0085\u0001\u0000\u0000\u0000\u0541\u0542\u0005Y\u0000\u0000"+
		"\u0542\u0543\u0003\u0014\n\u0000\u0543\u0087\u0001\u0000\u0000\u0000\u0544"+
		"\u0545\u0005Y\u0000\u0000\u0545\u0546\u0005J\u0000\u0000\u0546\u0089\u0001"+
		"\u0000\u0000\u0000\u0547\u0548\u0005g\u0000\u0000\u0548\u054d\u0005\b"+
		"\u0000\u0000\u0549\u054a\u0005\u00b6\u0000\u0000\u054a\u054c\u0005\b\u0000"+
		"\u0000\u054b\u0549\u0001\u0000\u0000\u0000\u054c\u054f\u0001\u0000\u0000"+
		"\u0000\u054d\u054b\u0001\u0000\u0000\u0000\u054d\u054e\u0001\u0000\u0000"+
		"\u0000\u054e\u008b\u0001\u0000\u0000\u0000\u054f\u054d\u0001\u0000\u0000"+
		"\u0000\u0550\u0551\u0005h\u0000\u0000\u0551\u0556\u0005\b\u0000\u0000"+
		"\u0552\u0553\u0005\u00b6\u0000\u0000\u0553\u0555\u0005\b\u0000\u0000\u0554"+
		"\u0552\u0001\u0000\u0000\u0000\u0555\u0558\u0001\u0000\u0000\u0000\u0556"+
		"\u0554\u0001\u0000\u0000\u0000\u0556\u0557\u0001\u0000\u0000\u0000\u0557"+
		"\u008d\u0001\u0000\u0000\u0000\u0558\u0556\u0001\u0000\u0000\u0000\u0559"+
		"\u055a\u0005i\u0000\u0000\u055a\u055f\u0005\b\u0000\u0000\u055b\u055c"+
		"\u0005\u00b6\u0000\u0000\u055c\u055e\u0005\b\u0000\u0000\u055d\u055b\u0001"+
		"\u0000\u0000\u0000\u055e\u0561\u0001\u0000\u0000\u0000\u055f\u055d\u0001"+
		"\u0000\u0000\u0000\u055f\u0560\u0001\u0000\u0000\u0000\u0560\u008f\u0001"+
		"\u0000\u0000\u0000\u0561\u055f\u0001\u0000\u0000\u0000\u0562\u0563\u0005"+
		"j\u0000\u0000\u0563\u0568\u0005\b\u0000\u0000\u0564\u0565\u0005\u00b6"+
		"\u0000\u0000\u0565\u0567\u0005\b\u0000\u0000\u0566\u0564\u0001\u0000\u0000"+
		"\u0000\u0567\u056a\u0001\u0000\u0000\u0000\u0568\u0566\u0001\u0000\u0000"+
		"\u0000\u0568\u0569\u0001\u0000\u0000\u0000\u0569\u0091\u0001\u0000\u0000"+
		"\u0000\u056a\u0568\u0001\u0000\u0000\u0000\u056b\u056c\u0005k\u0000\u0000"+
		"\u056c\u0571\u0005\b\u0000\u0000\u056d\u056e\u0005\u00b6\u0000\u0000\u056e"+
		"\u0570\u0005\b\u0000\u0000\u056f\u056d\u0001\u0000\u0000\u0000\u0570\u0573"+
		"\u0001\u0000\u0000\u0000\u0571\u056f\u0001\u0000\u0000\u0000\u0571\u0572"+
		"\u0001\u0000\u0000\u0000\u0572\u0093\u0001\u0000\u0000\u0000\u0573\u0571"+
		"\u0001\u0000\u0000\u0000\u0574\u0575\u0005D\u0000\u0000\u0575\u0576\u0005"+
		"\u00c3\u0000\u0000\u0576\u0577\u0003\n\u0005\u0000\u0577\u0578\u0005\u00b6"+
		"\u0000\u0000\u0578\u057b\u0003\u0014\n\u0000\u0579\u057a\u0005\u00b6\u0000"+
		"\u0000\u057a\u057c\u0003\u0014\n\u0000\u057b\u0579\u0001\u0000\u0000\u0000"+
		"\u057b\u057c\u0001\u0000\u0000\u0000\u057c\u057d\u0001\u0000\u0000\u0000"+
		"\u057d\u057e\u0005\u00c4\u0000\u0000\u057e\u057f\u0005\u00c8\u0000\u0000"+
		"\u057f\u0580\u0003\u0014\n\u0000\u0580\u0095\u0001\u0000\u0000\u0000\u0581"+
		"\u0582\u0005o\u0000\u0000\u0582\u0583\u0003\u0014\n\u0000\u0583\u0097"+
		"\u0001\u0000\u0000\u0000\u0584\u0585\u0005m\u0000\u0000\u0585\u0586\u0003"+
		"\u0014\n\u0000\u0586\u0587\u0005\u00b6\u0000\u0000\u0587\u0588\u0003\u0014"+
		"\n\u0000\u0588\u0589\u0005\u00b6\u0000\u0000\u0589\u058f\u0003\u0014\n"+
		"\u0000\u058a\u058b\u0005\u00b6\u0000\u0000\u058b\u058c\u0003\u0014\n\u0000"+
		"\u058c\u058d\u0005\u00b6\u0000\u0000\u058d\u058e\u0003\u0014\n\u0000\u058e"+
		"\u0590\u0001\u0000\u0000\u0000\u058f\u058a\u0001\u0000\u0000\u0000\u058f"+
		"\u0590\u0001\u0000\u0000\u0000\u0590\u0593\u0001\u0000\u0000\u0000\u0591"+
		"\u0592\u0005\u00b6\u0000\u0000\u0592\u0594\u0005\u007f\u0000\u0000\u0593"+
		"\u0591\u0001\u0000\u0000\u0000\u0593\u0594\u0001\u0000\u0000\u0000\u0594"+
		"\u0597\u0001\u0000\u0000\u0000\u0595\u0596\u0005\u00b6\u0000\u0000\u0596"+
		"\u0598\u0005\u0080\u0000\u0000\u0597\u0595\u0001\u0000\u0000\u0000\u0597"+
		"\u0598\u0001\u0000\u0000\u0000\u0598\u0099\u0001\u0000\u0000\u0000\u0599"+
		"\u059a\u0005\u0081\u0000\u0000\u059a\u009b\u0001\u0000\u0000\u0000\u059b"+
		"\u059c\u0005n\u0000\u0000\u059c\u059d\u0005\u00c3\u0000\u0000\u059d\u059e"+
		"\u0003\u0014\n\u0000\u059e\u059f\u0005\u00b6\u0000\u0000\u059f\u05a0\u0003"+
		"\u0014\n\u0000\u05a0\u05a1\u0005\u00c4\u0000\u0000\u05a1\u05a2\u0005\u00b6"+
		"\u0000\u0000\u05a2\u05a3\u0003\u0014\n\u0000\u05a3\u05a4\u0005\u00b6\u0000"+
		"\u0000\u05a4\u05b3\u0003\u0014\n\u0000\u05a5\u05a7\u0005\u00b6\u0000\u0000"+
		"\u05a6\u05a8\u0003\u0014\n\u0000\u05a7\u05a6\u0001\u0000\u0000\u0000\u05a7"+
		"\u05a8\u0001\u0000\u0000\u0000\u05a8\u05a9\u0001\u0000\u0000\u0000\u05a9"+
		"\u05ab\u0005\u00b6\u0000\u0000\u05aa\u05ac\u0003\u0014\n\u0000\u05ab\u05aa"+
		"\u0001\u0000\u0000\u0000\u05ab\u05ac\u0001\u0000\u0000\u0000\u05ac\u05ae"+
		"\u0001\u0000\u0000\u0000\u05ad\u05af\u0005\u00b6\u0000\u0000\u05ae\u05ad"+
		"\u0001\u0000\u0000\u0000\u05ae\u05af\u0001\u0000\u0000\u0000\u05af\u05b1"+
		"\u0001\u0000\u0000\u0000\u05b0\u05b2\u0003\u0014\n\u0000\u05b1\u05b0\u0001"+
		"\u0000\u0000\u0000\u05b1\u05b2\u0001\u0000\u0000\u0000\u05b2\u05b4\u0001"+
		"\u0000\u0000\u0000\u05b3\u05a5\u0001\u0000\u0000\u0000\u05b3\u05b4\u0001"+
		"\u0000\u0000\u0000\u05b4\u009d\u0001\u0000\u0000\u0000\u05b5\u05b6\u0005"+
		"R\u0000\u0000\u05b6\u05b7\u0005\u00c3\u0000\u0000\u05b7\u05b8\u0003\u0014"+
		"\n\u0000\u05b8\u05b9\u0005\u00b6\u0000\u0000\u05b9\u05ba\u0003\u0014\n"+
		"\u0000\u05ba\u05bb\u0005\u00c4\u0000\u0000\u05bb\u05bc\u0005\u00d9\u0000"+
		"\u0000\u05bc\u05bd\u0005\u00c3\u0000\u0000\u05bd\u05be\u0003\u0014\n\u0000"+
		"\u05be\u05bf\u0005\u00b6\u0000\u0000\u05bf\u05c0\u0003\u0014\n\u0000\u05c0"+
		"\u05c3\u0005\u00c4\u0000\u0000\u05c1\u05c2\u0005\u00b6\u0000\u0000\u05c2"+
		"\u05c4\u0003\u0014\n\u0000\u05c3\u05c1\u0001\u0000\u0000\u0000\u05c3\u05c4"+
		"\u0001\u0000\u0000\u0000\u05c4\u009f\u0001\u0000\u0000\u0000\u05c5\u05c6"+
		"\u0005p\u0000\u0000\u05c6\u05c7\u0003\u0014\n\u0000\u05c7\u05c8\u0005"+
		"\u00b6\u0000\u0000\u05c8\u05c9\u0003\u0014\n\u0000\u05c9\u05ca\u0005\u00b6"+
		"\u0000\u0000\u05ca\u05cb\u0003\u0014\n\u0000\u05cb\u00a1\u0001\u0000\u0000"+
		"\u0000\u05cc\u05cd\u0005r\u0000\u0000\u05cd\u05ce\u0005\u00c3\u0000\u0000"+
		"\u05ce\u05cf\u0003\u0014\n\u0000\u05cf\u05d0\u0005\u00b6\u0000\u0000\u05d0"+
		"\u05d1\u0003\u0014\n\u0000\u05d1\u05d2\u0005\u00c4\u0000\u0000\u05d2\u05d3"+
		"\u0005\u00b6\u0000\u0000\u05d3\u05d4\u0003\u0014\n\u0000\u05d4\u05d5\u0005"+
		"\u00b6\u0000\u0000\u05d5\u05d6\u0003\u0014\n\u0000\u05d6\u05d7\u0005\u00b6"+
		"\u0000\u0000\u05d7\u05d8\u0003\u0014\n\u0000\u05d8\u00a3\u0001\u0000\u0000"+
		"\u0000\u05d9\u05da\u0005s\u0000\u0000\u05da\u05db\u0005\u00c3\u0000\u0000"+
		"\u05db\u05dc\u0003\u0014\n\u0000\u05dc\u05dd\u0005\u00b6\u0000\u0000\u05dd"+
		"\u05de\u0003\u0014\n\u0000\u05de\u05e6\u0005\u00c4\u0000\u0000\u05df\u05e0"+
		"\u0005\u00b6\u0000\u0000\u05e0\u05e1\u0003\u0014\n\u0000\u05e1\u05e2\u0005"+
		"\u00b6\u0000\u0000\u05e2\u05e3\u0003\u0014\n\u0000\u05e3\u05e4\u0005\u00b6"+
		"\u0000\u0000\u05e4\u05e5\u0003\u0014\n\u0000\u05e5\u05e7\u0001\u0000\u0000"+
		"\u0000\u05e6\u05df\u0001\u0000\u0000\u0000\u05e6\u05e7\u0001\u0000\u0000"+
		"\u0000\u05e7\u00a5\u0001\u0000\u0000\u0000\u05e8\u05e9\u0005t\u0000\u0000"+
		"\u05e9\u05ea\u0003\u0014\n\u0000\u05ea\u00a7\u0001\u0000\u0000\u0000\u05eb"+
		"\u05ec\u0005`\u0000\u0000\u05ec\u05ed\u0005\u00c3\u0000\u0000\u05ed\u05ee"+
		"\u0003\u0014\n\u0000\u05ee\u05ef\u0005\u00b6\u0000\u0000\u05ef\u05f0\u0003"+
		"\u0014\n\u0000\u05f0\u05f1\u0005\u00c4\u0000\u0000\u05f1\u05f2\u0005\u00d9"+
		"\u0000\u0000\u05f2\u05f3\u0005\u00c3\u0000\u0000\u05f3\u05f4\u0003\u0014"+
		"\n\u0000\u05f4\u05f5\u0005\u00b6\u0000\u0000\u05f5\u05f6\u0003\u0014\n"+
		"\u0000\u05f6\u05f7\u0005\u00c4\u0000\u0000\u05f7\u05f8\u0005\u00b6\u0000"+
		"\u0000\u05f8\u05fb\u0003\n\u0005\u0000\u05f9\u05fa\u0005\u00b6\u0000\u0000"+
		"\u05fa\u05fc\u0007\t\u0000\u0000\u05fb\u05f9\u0001\u0000\u0000\u0000\u05fb"+
		"\u05fc\u0001\u0000\u0000\u0000\u05fc\u00a9\u0001\u0000\u0000\u0000\u05fd"+
		"\u05fe\u0005_\u0000\u0000\u05fe\u05ff\u0005\u00c3\u0000\u0000\u05ff\u0600"+
		"\u0003\u0014\n\u0000\u0600\u0601\u0005\u00b6\u0000\u0000\u0601\u0602\u0003"+
		"\u0014\n\u0000\u0602\u0603\u0005\u00c4\u0000\u0000\u0603\u0604\u0005\u00b6"+
		"\u0000\u0000\u0604\u0607\u0003\n\u0005\u0000\u0605\u0606\u0005\u00b6\u0000"+
		"\u0000\u0606\u0608\u0003\u0014\n\u0000\u0607\u0605\u0001\u0000\u0000\u0000"+
		"\u0607\u0608\u0001\u0000\u0000\u0000\u0608\u060b\u0001\u0000\u0000\u0000"+
		"\u0609\u060a\u0005\u00b6\u0000\u0000\u060a\u060c\u0007\t\u0000\u0000\u060b"+
		"\u0609\u0001\u0000\u0000\u0000\u060b\u060c\u0001\u0000\u0000\u0000\u060c"+
		"\u00ab\u0001\u0000\u0000\u0000\u060d\u060e\u0005\u00b2\u0000\u0000\u060e"+
		"\u060f\u0003\u0014\n\u0000\u060f\u0610\u0005\u0006\u0000\u0000\u0610\u0611"+
		"\u0003\u0014\n\u0000\u0611\u0612\u0005\u00b6\u0000\u0000\u0612\u0613\u0003"+
		"\u0014\n\u0000\u0613\u00ad\u0001\u0000\u0000\u0000\u0614\u0615\u0005u"+
		"\u0000\u0000\u0615\u0616\u0003\u0014\n\u0000\u0616\u0617\u0005\u00b6\u0000"+
		"\u0000\u0617\u0618\u0003\u0014\n\u0000\u0618\u0619\u0005\u00b6\u0000\u0000"+
		"\u0619\u061a\u0003\u0014\n\u0000\u061a\u00af\u0001\u0000\u0000\u0000\u061b"+
		"\u061c\u0005v\u0000\u0000\u061c\u061d\u0003\u0014\n\u0000\u061d\u061e"+
		"\u0005\u00b6\u0000\u0000\u061e\u061f\u0003\u0014\n\u0000\u061f\u0620\u0005"+
		"\u00b6\u0000\u0000\u0620\u0621\u0003\u0014\n\u0000\u0621\u00b1\u0001\u0000"+
		"\u0000\u0000\u0622\u0623\u0005w\u0000\u0000\u0623\u0624\u0003\u0014\n"+
		"\u0000\u0624\u0625\u0005\u00b6\u0000\u0000\u0625\u0626\u0003\n\u0005\u0000"+
		"\u0626\u00b3\u0001\u0000\u0000\u0000\u0627\u0628\u0005x\u0000\u0000\u0628"+
		"\u0629\u0003\u0014\n\u0000\u0629\u062a\u0005\u00b6\u0000\u0000\u062a\u062b"+
		"\u0003\n\u0005\u0000\u062b\u00b5\u0001\u0000\u0000\u0000\u062c\u062d\u0005"+
		"}\u0000\u0000\u062d\u00b7\u0001\u0000\u0000\u0000\u062e\u062f\u0005~\u0000"+
		"\u0000\u062f\u00b9\u0001\u0000\u0000\u0000\u0630\u0631\u0005\u0095\u0000"+
		"\u0000\u0631\u0632\u0003\n\u0005\u0000\u0632\u0633\u0005\u00b6\u0000\u0000"+
		"\u0633\u0634\u0003\u0014\n\u0000\u0634\u00bb\u0001\u0000\u0000\u0000\u0635"+
		"\u0636\u0005\u00a1\u0000\u0000\u0636\u0637\u0003\n\u0005\u0000\u0637\u0638"+
		"\u0005\u00b6\u0000\u0000\u0638\u0639\u0003\n\u0005\u0000\u0639\u00bd\u0001"+
		"\u0000\u0000\u0000\u063a\u063b\u0005\u009d\u0000\u0000\u063b\u063c\u0003"+
		"\n\u0005\u0000\u063c\u00bf\u0001\u0000\u0000\u0000\u063d\u063e\u0005\u00a2"+
		"\u0000\u0000\u063e\u063f\u0003\n\u0005\u0000\u063f\u0640\u0005\u00b6\u0000"+
		"\u0000\u0640\u0641\u0003\u0014\n\u0000\u0641\u0642\u0005\u00b6\u0000\u0000"+
		"\u0642\u0643\u0003\n\u0005\u0000\u0643\u0644\u0005\u00b6\u0000\u0000\u0644"+
		"\u0645\u0003\u0014\n\u0000\u0645\u0646\u0005\u00b6\u0000\u0000\u0646\u0647"+
		"\u0003\u0014\n\u0000\u0647\u00c1\u0001\u0000\u0000\u0000\u0648\u0649\u0005"+
		"\u00a3\u0000\u0000\u0649\u064a\u0003\n\u0005\u0000\u064a\u064b\u0005\u00b6"+
		"\u0000\u0000\u064b\u064c\u0003\u0014\n\u0000\u064c\u00c3\u0001\u0000\u0000"+
		"\u0000\u064d\u064e\u0005\u00a4\u0000\u0000\u064e\u064f\u0003\n\u0005\u0000"+
		"\u064f\u0650\u0005\u00b6\u0000\u0000\u0650\u0651\u0003\u0014\n\u0000\u0651"+
		"\u00c5\u0001\u0000\u0000\u0000\u0652\u0653\u0005y\u0000\u0000\u0653\u0654"+
		"\u0003\u0014\n\u0000\u0654\u0655\u0005\u00b6\u0000\u0000\u0655\u0656\u0003"+
		"\n\u0005\u0000\u0656\u00c7\u0001\u0000\u0000\u0000\u0657\u0658\u0005z"+
		"\u0000\u0000\u0658\u0659\u0003\n\u0005\u0000\u0659\u00c9\u0001\u0000\u0000"+
		"\u0000\u065a\u065b\u0005{\u0000\u0000\u065b\u065c\u0003\n\u0005\u0000"+
		"\u065c\u00cb\u0001\u0000\u0000\u0000\u065d\u065e\u0005|\u0000\u0000\u065e"+
		"\u065f\u0003\n\u0005\u0000\u065f\u00cd\u0001\u0000\u0000\u0000\u0660\u0661"+
		"\u0005\u00a6\u0000\u0000\u0661\u0662\u0003\u00dcn\u0000\u0662\u00cf\u0001"+
		"\u0000\u0000\u0000\u0663\u0664\u0005\u0003\u0000\u0000\u0664\u0669\u0005"+
		"\u00cc\u0000\u0000\u0665\u066a\u0003\u0010\b\u0000\u0666\u066a\u0003\u0012"+
		"\t\u0000\u0667\u0668\u0005#\u0000\u0000\u0668\u066a\u0003\u0012\t\u0000"+
		"\u0669\u0665\u0001\u0000\u0000\u0000\u0669\u0666\u0001\u0000\u0000\u0000"+
		"\u0669\u0667\u0001\u0000\u0000\u0000\u066a\u066b\u0001\u0000\u0000\u0000"+
		"\u066b\u066c\u0005\u00ca\u0000\u0000\u066c\u066d\u0003\u0010\b\u0000\u066d"+
		"\u00d1\u0001\u0000\u0000\u0000\u066e\u066f\u0005\u0004\u0000\u0000\u066f"+
		"\u0670\u0005\u00cc\u0000\u0000\u0670\u0671\u0003\u0012\t\u0000\u0671\u0674"+
		"\u0005\u00b6\u0000\u0000\u0672\u0675\u0003\u0010\b\u0000\u0673\u0675\u0003"+
		"\u0012\t\u0000\u0674\u0672\u0001\u0000\u0000\u0000\u0674\u0673\u0001\u0000"+
		"\u0000\u0000\u0675\u0676\u0001\u0000\u0000\u0000\u0676\u0677\u0005\u00ca"+
		"\u0000\u0000\u0677\u0678\u0003\u0010\b\u0000\u0678\u00d3\u0001\u0000\u0000"+
		"\u0000\u0679\u067a\u0005\u0005\u0000\u0000\u067a\u067b\u0005\u00cc\u0000"+
		"\u0000\u067b\u067c\u0003\u0012\t\u0000\u067c\u067d\u0005\u00ca\u0000\u0000"+
		"\u067d\u067e\u0003\u0010\b\u0000\u067e\u00d5\u0001\u0000\u0000\u0000\u067f"+
		"\u0680\u0005\u00b3\u0000\u0000\u0680\u0681\u0003\u0010\b\u0000\u0681\u0682"+
		"\u0005\u00c5\u0000\u0000\u0682\u0687\u0003\u00d8l\u0000\u0683\u0684\u0005"+
		"\u00b6\u0000\u0000\u0684\u0686\u0003\u00d8l\u0000\u0685\u0683\u0001\u0000"+
		"\u0000\u0000\u0686\u0689\u0001\u0000\u0000\u0000\u0687\u0685\u0001\u0000"+
		"\u0000\u0000\u0687\u0688\u0001\u0000\u0000\u0000\u0688\u068a\u0001\u0000"+
		"\u0000\u0000\u0689\u0687\u0001\u0000\u0000\u0000\u068a\u068b\u0005\u00c6"+
		"\u0000\u0000\u068b\u00d7\u0001\u0000\u0000\u0000\u068c\u068e\u0003\u0010"+
		"\b\u0000\u068d\u068f\u0003\u0012\t\u0000\u068e\u068d\u0001\u0000\u0000"+
		"\u0000\u068e\u068f\u0001\u0000\u0000\u0000\u068f\u06c3\u0001\u0000\u0000"+
		"\u0000\u0690\u0691\u0005#\u0000\u0000\u0691\u0693\u0003\u0010\b\u0000"+
		"\u0692\u0694\u0003\u0012\t\u0000\u0693\u0692\u0001\u0000\u0000\u0000\u0693"+
		"\u0694\u0001\u0000\u0000\u0000\u0694\u0695\u0001\u0000\u0000\u0000\u0695"+
		"\u0696\u0005\u00c3\u0000\u0000\u0696\u069b\u0005\u00da\u0000\u0000\u0697"+
		"\u0698\u0005\u00b6\u0000\u0000\u0698\u069a\u0005\u00da\u0000\u0000\u0699"+
		"\u0697\u0001\u0000\u0000\u0000\u069a\u069d\u0001\u0000\u0000\u0000\u069b"+
		"\u0699\u0001\u0000\u0000\u0000\u069b\u069c\u0001\u0000\u0000\u0000\u069c"+
		"\u069e\u0001\u0000\u0000\u0000\u069d\u069b\u0001\u0000\u0000\u0000\u069e"+
		"\u069f\u0005\u00c4\u0000\u0000\u069f\u06c3\u0001\u0000\u0000\u0000\u06a0"+
		"\u06a1\u0003\u0010\b\u0000\u06a1\u06a2\u0003\u0010\b\u0000\u06a2\u06c3"+
		"\u0001\u0000\u0000\u0000\u06a3\u06a4\u0005\u0003\u0000\u0000\u06a4\u06a9"+
		"\u0005\u00cc\u0000\u0000\u06a5\u06aa\u0003\u0010\b\u0000\u06a6\u06aa\u0003"+
		"\u0012\t\u0000\u06a7\u06a8\u0005#\u0000\u0000\u06a8\u06aa\u0003\u0012"+
		"\t\u0000\u06a9\u06a5\u0001\u0000\u0000\u0000\u06a9\u06a6\u0001\u0000\u0000"+
		"\u0000\u06a9\u06a7\u0001\u0000\u0000\u0000\u06aa\u06ab\u0001\u0000\u0000"+
		"\u0000\u06ab\u06ac\u0005\u00ca\u0000\u0000\u06ac\u06ad\u0003\u0010\b\u0000"+
		"\u06ad\u06c3\u0001\u0000\u0000\u0000\u06ae\u06af\u0005\u0005\u0000\u0000"+
		"\u06af\u06b2\u0005\u00cc\u0000\u0000\u06b0\u06b3\u0003\u0010\b\u0000\u06b1"+
		"\u06b3\u0003\u0012\t\u0000\u06b2\u06b0\u0001\u0000\u0000\u0000\u06b2\u06b1"+
		"\u0001\u0000\u0000\u0000\u06b3\u06b4\u0001\u0000\u0000\u0000\u06b4\u06b5"+
		"\u0005\u00ca\u0000\u0000\u06b5\u06b6\u0003\u0010\b\u0000\u06b6\u06c3\u0001"+
		"\u0000\u0000\u0000\u06b7\u06b8\u0005\u0004\u0000\u0000\u06b8\u06b9\u0005"+
		"\u00cc\u0000\u0000\u06b9\u06ba\u0003\u0012\t\u0000\u06ba\u06bd\u0005\u00b6"+
		"\u0000\u0000\u06bb\u06be\u0003\u0010\b\u0000\u06bc\u06be\u0003\u0012\t"+
		"\u0000\u06bd\u06bb\u0001\u0000\u0000\u0000\u06bd\u06bc\u0001\u0000\u0000"+
		"\u0000\u06be\u06bf\u0001\u0000\u0000\u0000\u06bf\u06c0\u0005\u00ca\u0000"+
		"\u0000\u06c0\u06c1\u0003\u0010\b\u0000\u06c1\u06c3\u0001\u0000\u0000\u0000"+
		"\u06c2\u068c\u0001\u0000\u0000\u0000\u06c2\u0690\u0001\u0000\u0000\u0000"+
		"\u06c2\u06a0\u0001\u0000\u0000\u0000\u06c2\u06a3\u0001\u0000\u0000\u0000"+
		"\u06c2\u06ae\u0001\u0000\u0000\u0000\u06c2\u06b7\u0001\u0000\u0000\u0000"+
		"\u06c3\u00d9\u0001\u0000\u0000\u0000\u06c4\u06c5\u0003\u0010\b\u0000\u06c5"+
		"\u06c6\u0003\u0010\b\u0000\u06c6\u06c7\u0005\u00c5\u0000\u0000\u06c7\u06c8"+
		"\u0005\u00c6\u0000\u0000\u06c8\u00db\u0001\u0000\u0000\u0000\u06c9\u06ca"+
		"\u0005\u00b5\u0000\u0000\u06ca\u00dd\u0001\u0000\u0000\u0000\u06cb\u06cf"+
		"\u0003\u00e0p\u0000\u06cc\u06cf\u0005\u00dd\u0000\u0000\u06cd\u06cf\u0005"+
		"\u00de\u0000\u0000\u06ce\u06cb\u0001\u0000\u0000\u0000\u06ce\u06cc\u0001"+
		"\u0000\u0000\u0000\u06ce\u06cd\u0001\u0000\u0000\u0000\u06cf\u00df\u0001"+
		"\u0000\u0000\u0000\u06d0\u06d2\u0007\n\u0000\u0000\u06d1\u06d3\u0007\u000b"+
		"\u0000\u0000\u06d2\u06d1\u0001\u0000\u0000\u0000\u06d2\u06d3\u0001\u0000"+
		"\u0000\u0000\u06d3\u00e1\u0001\u0000\u0000\u0000t\u00e4\u00e6\u00ea\u00ed"+
		"\u00f0\u0152\u0156\u015a\u0162\u0167\u016e\u0179\u017e\u0186\u018a\u018e"+
		"\u0198\u01af\u01b1\u01bd\u01c0\u02a0\u02c3\u02ce\u02fa\u02fd\u037c\u038a"+
		"\u0390\u03af\u03b5\u03b7\u03c0\u03c3\u03cd\u03d1\u03df\u03e3\u03e7\u03ec"+
		"\u03f0\u03f4\u0406\u0411\u0415\u041b\u0429\u0431\u0434\u0437\u043f\u0447"+
		"\u044a\u045d\u0465\u046d\u0475\u0492\u0499\u049f\u04a3\u04a6\u04aa\u04b0"+
		"\u04b4\u04b9\u04be\u04c1\u04cb\u04d5\u04d9\u04de\u04e2\u04e7\u04eb\u04f8"+
		"\u04fd\u0507\u0512\u0518\u051d\u052d\u0533\u0538\u053c\u054d\u0556\u055f"+
		"\u0568\u0571\u057b\u058f\u0593\u0597\u05a7\u05ab\u05ae\u05b1\u05b3\u05c3"+
		"\u05e6\u05fb\u0607\u060b\u0669\u0674\u0687\u068e\u0693\u069b\u06a9\u06b2"+
		"\u06bd\u06c2\u06ce\u06d2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
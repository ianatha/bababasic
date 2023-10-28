grammar PuffinBasic;

prog
    : (line | NEWLINE)*
    ;

line
    : linenum? stmtlist? comment? NEWLINE
    ;

linenum
    : DECIMAL
    ;

comment
    : COMMENT
    ;

COMMENT
    : (REM SPACE | APOSTROPHE) ~[\r\n]*
    ;

stmt
    : printusingstmt
    | printhashusingstmt
    | printstmt
    | printhashstmt
    | writestmt
    | writehashstmt
    | letstmt
    | autoletstmt
    | ifstmt
    | ifthenbeginstmt
    | elsebeginstmt
    | endifstmt
    | forstmt
    | nextstmt
    | gotostmt
    | gotolabelstmt
    | endstmt
    | deffnstmt
    | functionbeginstmt
    | functionreturnstmt
    | functionendstmt
    | importstmt
    | libtagstmt
    | dimstmt
    | reallocstmt
    | gosubstmt
    | gosublabelstmt
    | returnstmt
    | whilestmt
    | wendstmt
    | lsetstmt
    | rsetstmt
    | swapstmt
    | open1stmt
    | open2stmt
    | closestmt
    | putstmt
    | getstmt
    | fieldstmt
    | inputstmt
    | inputhashstmt
    | lineinputstmt
    | lineinputhashstmt
    | readstmt
    | datastmt
    | restorestmt
    | randomizestmt
    | randomizetimerstmt
    | defintstmt
    | deflngstmt
    | defsngstmt
    | defdblstmt
    | defstrstmt
    | middlrstmt
    | sleepstmt
    | screenstmt
    | circlestmt
    | linestmt
    | colorstmt
    | paintstmt
    | psetstmt
    | drawstmt
    | graphicsgetstmt
    | graphicsputstmt
    | graphicsbuffercopyhorstmt
    | fontstmt
    | drawstrstmt
    | loadimgstmt
    | saveimgstmt
    | clsstmt
    | beepstmt
    | repaintstmt
    | arrayfillstmt
    | arraycopystmt
    | array1dcopystmt
    | array1dsortstmt
    | array2dshifthorstmt
    | array2dshiftverstmt
    | loadwavstmt
    | playwavstmt
    | stopwavstmt
    | loopwavstmt
    | labelstmt
    | liststmt
    | dictstmt
    | setstmt
    | structstmt
    | structinstancestmt
    | func
    | variable
    ;

variable
    : leafvariable | structvariable
    ;

leafvariable
    : varname varsuffix? (LPAREN expr (COMMA expr)* RPAREN)?
    ;

structvariable
    : varname (DOT varname)* DOT leafvariable (LPAREN expr (COMMA expr)* RPAREN)?
    ;

varname
    : VARNAME
    ;

varsuffix
    : DOLLAR | PERCENT | AT | EXCLAMATION | HASH
    ;

expr
    : (PLUS | MINUS)? func      # ExprFunc
    | (PLUS | MINUS)? number    # ExprNumber
    | (PLUS | MINUS)? variable  # ExprVariable
    | LPAREN expr RPAREN        # ExprParen
    | string                    # ExprString
    | expr EXPONENT expr        # ExprExp
    | expr (MUL|FLOAT_DIV|INT_DIV) expr # ExprMulDiv
    | expr MOD expr             # ExprMod
    | expr (PLUS|MINUS) expr    # ExprPlusMinus
    | expr (RELEQ|RELNEQ|RELLT|RELGT|RELLE|RELGE) expr # ExprRelational
    | LOGNOT expr               # ExprLogNot
    | expr (LOGAND|LOGOR|LOGXOR|LOGEQV|LOGIMP) expr    # ExprLogical
    | expr (BWLSFT|BWRSFT) expr # ExprBitwise
    ;

func
    : variable DOT funcname
        LPAREN (expr (COMMA expr)*)? RPAREN                 # FuncMemberMethodCall
    | ABS  LPAREN expr RPAREN                               # FuncAbs
    | ASC  LPAREN expr RPAREN                               # FuncAsc
    | SIN  LPAREN expr RPAREN                               # FuncSin
    | COS  LPAREN expr RPAREN                               # FuncCos
    | TAN  LPAREN expr RPAREN                               # FuncTan
    | ASIN  LPAREN expr RPAREN                              # FuncASin
    | ACOS  LPAREN expr RPAREN                              # FuncACos
    | ATN  LPAREN expr RPAREN                               # FuncAtn
    | SINH  LPAREN expr RPAREN                              # FuncSinh
    | COSH  LPAREN expr RPAREN                              # FuncCosh
    | TANH  LPAREN expr RPAREN                              # FuncTanh
    | SQR  LPAREN expr RPAREN                               # FuncSqr
    | CINT LPAREN expr RPAREN                               # FuncCint
    | CLNG LPAREN expr RPAREN                               # FuncClng
    | CSNG LPAREN expr RPAREN                               # FuncCsng
    | CDBL LPAREN expr RPAREN                               # FuncCdbl
    | CHRDLR LPAREN expr RPAREN                             # FuncChrDlr
    | MKIDLR LPAREN expr RPAREN                             # FuncMkiDlr
    | MKLDLR LPAREN expr RPAREN                             # FuncMklDlr
    | MKSDLR LPAREN expr RPAREN                             # FuncMksDlr
    | MKDDLR LPAREN expr RPAREN                             # FuncMkdDlr
    | CVI LPAREN expr RPAREN                                # FuncCvi
    | CVL LPAREN expr RPAREN                                # FuncCvl
    | CVS LPAREN expr RPAREN                                # FuncCvs
    | CVD LPAREN expr RPAREN                                # FuncCvd
    | SPACEDLR LPAREN expr RPAREN                           # FuncSpaceDlr
    | STRDLR LPAREN expr RPAREN                             # FuncStrDlr
    | VAL LPAREN expr RPAREN                                # FuncVal
    | INT LPAREN expr RPAREN                                # FuncInt
    | FIX LPAREN expr RPAREN                                # FuncFix
    | LOG LPAREN expr RPAREN                                # FuncLog
    | LOG10 LPAREN expr RPAREN                              # FuncLog10
    | LOG2 LPAREN expr RPAREN                               # FuncLog2
    | EXP LPAREN expr RPAREN                                # FuncExp
    | TORAD LPAREN expr RPAREN                              # FuncToRad
    | TODEG LPAREN expr RPAREN                              # FuncToDeg
    | CEIL LPAREN expr RPAREN                               # FuncCeil
    | FLOOR LPAREN expr RPAREN                              # FuncFloor
    | ROUND LPAREN expr RPAREN                              # FuncRound
    | MIN LPAREN expr COMMA expr RPAREN                     # FuncMin
    | MAX LPAREN expr COMMA expr RPAREN                     # FuncMax
    | PI LPAREN RPAREN                                      # FuncPI
    | EULERE LPAREN RPAREN                                  # FuncE
    | LEN LPAREN expr (COMMA axis=expr)? RPAREN             # FuncLen
    | HEXDLR LPAREN expr RPAREN                             # FuncHexDlr
    | OCTDLR LPAREN expr RPAREN                             # FuncOctDlr
    | RIGHTDLR LPAREN expr COMMA expr RPAREN                # FuncRightDlr
    | LEFTDLR LPAREN expr COMMA expr RPAREN                 # FuncLeftDlr
    | MIDDLR LPAREN expr COMMA expr (COMMA expr)? RPAREN    # FuncMidDlr
    | INSTR LPAREN expr COMMA expr (COMMA expr)? RPAREN     # FuncInstr
    | RND                                                   # FuncRnd
    | SGN LPAREN expr RPAREN                                # FuncSgn
    | ENVIRONDLR LPAREN expr RPAREN                         # FuncEnvironDlr
    | TIMER                                                 # FuncTimer
    | TIMERMILLIS                                           # FuncTimerMillis
    | STRINGDLR LPAREN expr COMMA expr RPAREN               # FuncStringDlr
    | EOFFN LPAREN expr RPAREN                              # FuncEof
    | LOC LPAREN expr RPAREN                                # FuncLoc
    | LOF LPAREN expr RPAREN                                # FuncLof
    | INPUTDLR LPAREN expr (COMMA HASH? expr)? RPAREN       # FuncInputDlr
    | INKEYDLR                                              # FuncInkeyDlr
    | ARRAY1DMIN LPAREN variable RPAREN                     # FuncArray1DMin
    | ARRAY1DMAX LPAREN variable RPAREN                     # FuncArray1DMax
    | ARRAY1DMEAN LPAREN variable RPAREN                    # FuncArray1DMean
    | ARRAY1DSUM LPAREN variable RPAREN                     # FuncArray1DSum
    | ARRAY1DSTD LPAREN variable RPAREN                     # FuncArray1DStd
    | ARRAY1DMEDIAN LPAREN variable RPAREN                  # FuncArray1DMedian
    | ARRAY1DPCT LPAREN variable COMMA p=expr RPAREN        # FuncArray1DPct
    | ARRAY1DBINSEARCH LPAREN variable COMMA expr RPAREN    # FuncArray1DBinSearch
    | ARRAY2DFINDROW LPAREN variable COMMA
        x1=expr COMMA y1=expr COMMA x2=expr COMMA
        y2=expr COMMA search=expr RPAREN                    # FuncArray2DFindRow
    | ARRAY2DFINDCOLUMN LPAREN variable COMMA
        x1=expr COMMA y1=expr COMMA x2=expr COMMA
        y2=expr COMMA search=expr RPAREN                    # FuncArray2DFindColumn
    | HSB2RGB LPAREN expr COMMA expr COMMA expr RPAREN      # FuncHsb2Rgb
    | MOUSEMOVEDX LPAREN RPAREN                             # FuncMouseMovedX
    | MOUSEMOVEDY LPAREN RPAREN                             # FuncMouseMovedY
    | MOUSEDRAGGEDX LPAREN RPAREN                           # FuncMouseDraggedX
    | MOUSEDRAGGEDY LPAREN RPAREN                           # FuncMouseDraggedY
    | MOUSEBUTTONCLICKED LPAREN RPAREN                      # FuncMouseButtonClicked
    | MOUSEBUTTONPRESSED LPAREN RPAREN                      # FuncMouseButtonPressed
    | MOUSEBUTTONRELEASED LPAREN RPAREN                     # FuncMouseButtonReleased
    | ISKEYPRESSED LPAREN expr RPAREN                       # FuncIsKeyPressed
    | SPLITDLR LPAREN str=expr COMMA regex=expr RPAREN      # FuncSplitDlr
    | ALLOCARRAY varsuffix LPAREN expr (COMMA expr)? RPAREN # FuncAllocArray
    ;

funcname
    : varname | GET | APPEND | PUT
    ;

gosubstmt
    : GOSUB linenum
    ;

gosublabelstmt
    : GOSUB string
    ;

returnstmt
    : RETURN
    ;

printhashusingstmt
    : PRINTHASH filenum=expr COMMA USING format=expr SEMICOLON printlist
    ;

printusingstmt
    : PRINT USING format=expr SEMICOLON printlist
    ;

printhashstmt
    : PRINTHASH filenum=expr COMMA printlist
    ;

printstmt
    : (QUESTION | PRINT) printlist?
    ;

printlist
    : expr (COMMA | SEMICOLON | expr)*
    ;

writestmt
    : WRITE (expr (COMMA expr)*)?
    ;

writehashstmt
    : WRITEHASH filenum=expr COMMA expr (COMMA expr)*
    ;

letstmt
    : LET? variable RELEQ expr
    ;

autoletstmt
    : AUTO varname RELEQ expr
    ;

ifstmt
    : IF expr COMMA? then COMMA? (ELSE elsestmt)?  # IfThenElse
    ;

then
    : (THEN (linenum | stmtlist)) | (GOTO linenum)
    ;

elsestmt
    : linenum | stmtlist
    ;

ifthenbeginstmt
    : IF expr THEN BEGIN
    ;

elsebeginstmt
    : ELSE BEGIN
    ;

endifstmt
    : END IF
    ;

stmtlist
    : stmt (':' stmt)*
    ;

forstmt
    : FOR variable RELEQ expr TO expr (STEP expr)?
    ;

nextstmt
    : NEXT variable? (COMMA variable)*
    ;

gotostmt
    : GOTO linenum
    ;

gotolabelstmt
    : GOTO string
    ;

endstmt
    : END
    ;

deffnstmt
    : DEF varname varsuffix? (LPAREN (variable (COMMA variable)*)? RPAREN)? RELEQ expr
    ;

functionbeginstmt
    : FUNCTION fnname=varname fnrettype=varsuffix? LPAREN (compositetype (COMMA compositetype)*)? RPAREN LBRACE
    ;

functionreturnstmt
    : RETURN expr
    ;

functionendstmt
    : RBRACE
    ;

importstmt
    : IMPORT filename=string
    ;

libtagstmt
    : LIBTAG tag=string
    ;

dimstmt
    : DIM varname varsuffix? LPAREN expr (COMMA expr)* RPAREN
    ;

reallocstmt
    : REALLOCARRAY varname varsuffix? LPAREN expr (COMMA expr)* RPAREN
    ;

whilestmt
    : WHILE expr
    ;

wendstmt
    : WEND
    ;

lsetstmt
    : LSET variable RELEQ expr
    ;

rsetstmt
    : RSET variable RELEQ expr
    ;

swapstmt
    : SWAP variable COMMA variable
    ;

open1stmt
    : OPEN filemode1 COMMA HASH? filenum=DECIMAL COMMA filename=expr (COMMA reclen=expr)?
    ;

open2stmt
    : OPEN filename=expr (FOR filemode2)? (ACCESS access)? lock? AS HASH? filenum=DECIMAL (LEN RELEQ reclen=expr)?
    ;

closestmt
    : CLOSE (HASH? DECIMAL (COMMA HASH? DECIMAL)*)?
    ;

filemode1
    : STRING
    ;

filemode2
    : INPUT | OUTPUT | APPEND | RANDOM
    ;

access
    : READ | WRITE | READ WRITE
    ;

lock
    : SHARED | LOCK READ | LOCK WRITE | LOCK READ WRITE
    ;

putstmt
    : PUT HASH? filenum=DECIMAL (COMMA expr)?
    ;

getstmt
    : GET HASH? filenum=DECIMAL (COMMA expr)?
    ;

fieldstmt
    : FIELD HASH? filenum=expr COMMA DECIMAL AS variable (COMMA DECIMAL AS variable)*
    ;

inputstmt
    : INPUT SEMICOLON? (expr (SEMICOLON | COMMA)) variable (COMMA variable)*
    ;

inputhashstmt
    : INPUTHASH filenum=expr COMMA variable (COMMA variable)*
    ;

lineinputstmt
    : LINE INPUT SEMICOLON? (expr SEMICOLON)? variable
    ;

lineinputhashstmt
    : LINE INPUTHASH filenum=expr COMMA variable
    ;

readstmt
    : READ variable (COMMA variable)*
    ;

datastmt
    : DATA (str=STRING | number) (COMMA (str=STRING | number))*
    ;

restorestmt
    : RESTORE
    ;

randomizestmt
    : RANDOMIZE expr
    ;

randomizetimerstmt
    : RANDOMIZE TIMER
    ;

defintstmt
    : DEFINT LETTERRANGE (COMMA LETTERRANGE)*
    ;

deflngstmt
    : DEFLNG LETTERRANGE (COMMA LETTERRANGE)*
    ;

defsngstmt
    : DEFSNG LETTERRANGE (COMMA LETTERRANGE)*
    ;

defdblstmt
    : DEFDBL LETTERRANGE (COMMA LETTERRANGE)*
    ;

defstrstmt
    : DEFSTR LETTERRANGE (COMMA LETTERRANGE)*
    ;

middlrstmt
    : MIDDLR LPAREN variable COMMA expr (COMMA expr)? RPAREN RELEQ expr
    ;

sleepstmt
    : SLEEP expr
    ;

screenstmt
    : SCREEN title=expr COMMA w=expr COMMA h=expr
        (COMMA iw=expr COMMA ih=expr)?
        (COMMA mr=MANUAL_REPAINT)? (COMMA db=DOUBLE_BUFFER)?
    ;

repaintstmt
    : REPAINT
    ;

circlestmt
    // CIRCLE (x, y), r1, r2, start, end, "F"
    : CIRCLE LPAREN x=expr COMMA y=expr RPAREN COMMA r1=expr COMMA r2=expr
        (COMMA s=expr? COMMA e=expr? COMMA? fill=expr?)?
    ;

linestmt
    : LINE LPAREN x1=expr COMMA y1=expr RPAREN MINUS LPAREN x2=expr COMMA y2=expr RPAREN
        (COMMA bf=expr)?
    ;

colorstmt
    : COLOR r=expr COMMA g=expr COMMA b=expr
    ;

paintstmt
    // PAINT (x, y), r, g, b
    : PAINT LPAREN x=expr COMMA y=expr RPAREN COMMA r=expr COMMA g=expr COMMA b=expr
    ;

psetstmt
    : PSET LPAREN x=expr COMMA y=expr RPAREN (COMMA r=expr COMMA g=expr COMMA b=expr)?
    ;

drawstmt
    : DRAW expr
    ;

graphicsgetstmt
    : GET LPAREN x1=expr COMMA y1=expr RPAREN MINUS LPAREN x2=expr COMMA y2=expr RPAREN
        COMMA variable (COMMA buffer=(FRONT|BACK1))?
    ;

graphicsputstmt
    : PUT LPAREN x=expr COMMA y=expr RPAREN COMMA variable (COMMA action=expr)? (COMMA buffer=(FRONT|BACK1))?
    ;

graphicsbuffercopyhorstmt
    : BUFFERCOPYHOR srcx=expr EQGT dstx=expr COMMA w=expr
    ;

fontstmt
    : FONT name=expr COMMA style=expr COMMA size=expr
    ;

drawstrstmt
    : DRAWSTR str=expr COMMA x=expr COMMA y=expr
    ;

loadimgstmt
    : LOADIMG path=expr COMMA variable
    ;

saveimgstmt
    : SAVEIMG path=expr COMMA variable
    ;

clsstmt
    : CLS
    ;

beepstmt
    : BEEP
    ;

arrayfillstmt
    : ARRAYFILL variable COMMA expr
    ;

arraycopystmt
    : ARRAYCOPY src=variable COMMA dst=variable
    ;

array1dsortstmt
    : ARRAY1DSORT variable
    ;

array1dcopystmt
    : ARRAY1DCOPY src=variable COMMA src0=expr COMMA dst=variable COMMA dst0=expr COMMA len=expr
    ;

array2dshifthorstmt
    : ARRAY2DSHIFTHOR variable COMMA step=expr
    ;

array2dshiftverstmt
    : ARRAY2DSHIFTVER variable COMMA step=expr
    ;

loadwavstmt
    : LOADWAV path=expr COMMA variable
    ;

playwavstmt
    : PLAYWAV variable
    ;

stopwavstmt
    : STOPWAV variable
    ;

loopwavstmt
    : LOOPWAV variable
    ;

labelstmt
    : LABEL name=string
    ;

liststmt
    : LIST RELLT (typename=varname|typesuffix=varsuffix|DIM dimtypesuffix=varsuffix) RELGT listname=varname
    ;

dictstmt
    : DICT RELLT (dictk1=varsuffix) COMMA (dictv1=varname|dictv2=varsuffix) RELGT dictname=varname
    ;

setstmt
    : SET RELLT (typesuffix=varsuffix) RELGT setname=varname
    ;

structstmt
    : STRUCT structname=varname LBRACE compositetype (COMMA compositetype)* RBRACE
    ;

compositetype
    : (var1=varname var2=varsuffix?
        | DIM elem=varname elemsuffix=varsuffix? LPAREN dim=DECIMAL (COMMA dim=DECIMAL)* RPAREN
        | struct1=varname elem=varname
        | LIST RELLT (list1=varname|list2=varsuffix|DIM list3=varsuffix) RELGT elem=varname
        | SET RELLT (set1=varname|set2=varsuffix) RELGT elem=varname
        | DICT RELLT (dictk1=varsuffix) COMMA (dictv1=varname|dictv2=varsuffix) RELGT elem=varname)
    ;

structinstancestmt
    : varname varname LBRACE RBRACE
    ;

LIST
    : L I S T
    ;
DICT
    : D I C T
    ;

SET
    : S E T
    ;

EQGT
    : '=' '>'
    ;

DEFAULT
    : D E F A U L T
    ;

LETTERRANGE
    : LETTER MINUS LETTER
    ;

LET
    : L E T
    ;

AUTO
    : A U T O
    ;

PRINT
    : P R I N T
    ;

PRINTHASH
    : P R I N T HASH
    ;

USING
    : U S I N G
    ;

IF
    : I F
    ;

THEN
    : T H E N
    ;

ELSE
    : E L S E
    ;

GOTO
    : G O T O
    ;

FOR
    : F O R
    ;

NEXT
    : N E X T
    ;

TO
    : T O
    ;

STEP
    : S T E P
    ;

REM
    : R E M
    ;

FUNCTION
    : F U N C T I O N
    ;

LIBTAG
    : L I B T A G
    ;

IMPORT
    : I M P O R T
    ;

END
    : E N D
    ;


SIN
    : S I N
    ;

COS
    : C O S
    ;

TAN
    : T A N
    ;

ATN
    : A T N
    ;

SQR
    : S Q R
    ;

ABS
    : A B S
    ;

ASC
    : A S C
    ;

DEF
    : D E F
    ;

DIM
    : D I M
    ;

ALLOCARRAY
    : A L L O C A R R A Y
    ;

REALLOCARRAY
    : R E A L L O C A R R A Y
    ;

GOSUB
    : G O S U B
    ;

RETURN
    : R E T U R N
    ;

LSET
    : L S E T
    ;

RSET
    : R S E T
    ;

CINT
    : C I N T
    ;

CLNG
    : C L N G
    ;

CSNG
    : C S N G
    ;

CDBL
    : C D B L
    ;

CHRDLR
    : C H R DOLLAR
    ;

WHILE
    : W H I L E
    ;

WEND
    : W E N D
    ;

MKIDLR
    : M K I DOLLAR
    ;

MKLDLR
    : M K L DOLLAR
    ;

MKSDLR
    : M K S DOLLAR
    ;

MKDDLR
    : M K D DOLLAR
    ;

CVI
    : C V I
    ;

CVL
    : C V L
    ;

CVS
    : C V S
    ;

CVD
    : C V D
    ;

SPACEDLR
    : S P A C E DOLLAR
    ;

STRDLR
    : S T R DOLLAR
    ;

VAL
    : V A L
    ;

INT
    : I N T
    ;

FIX
    : F I X
    ;

LOG
    : L O G
    ;

LEN
    : L E N
    ;

RIGHTDLR
    : R I G H T DOLLAR
    ;

LEFTDLR
    : L E F T DOLLAR
    ;

MIDDLR
    : M I D DOLLAR
    ;

INSTR
    : I N S T R
    ;

HEXDLR
    : H E X DOLLAR
    ;

OCTDLR
    : O C T DOLLAR
    ;

RND
    : R N D
    ;

SGN
    : S G N
    ;

TIMER
    : T I M E R
    ;

TIMERMILLIS
    : T I M E R M I L L I S
    ;

STRINGDLR
    : S T R I N G DOLLAR
    ;

SWAP
    : S W A P
    ;

OPEN
    : O P E N
    ;

CLOSE
    : C L O S E
    ;

ACCESS
    : A C C E S S
    ;

AS
    : A S
    ;

LINE
    : L I N E
    ;

INPUT
    : I N P U T
    ;

INPUTHASH
    : I N P U T HASH
    ;

INPUTDLR
    : I N P U T DOLLAR
    ;

OUTPUT
    : O U T P U T
    ;

APPEND
    : A P P E N D
    ;

RANDOM
    : R A N D O M
    ;

RANDOMIZE
    : R A N D O M I Z E
    ;

READ
    : R E A D
    ;

WRITE
    : W R I T E
    ;

WRITEHASH
    : W R I T E HASH
    ;

SHARED
    : S H A R E D
    ;

LOCK
    : L O C K
    ;

PUT
    : P U T
    ;

GET
    : G E T
    ;

EOFFN
    : E O F
    ;

LOC
    : L O C
    ;

LOF
    : L O F
    ;

FIELD
    : F I E L D
    ;

DATA
    : D A T A
    ;

RESTORE
    : R E S T O R E
    ;

DEFINT
    : D E F I N T
    ;

DEFLNG
    : D E F L N G
    ;

DEFSNG
    : D E F S N G
    ;

DEFDBL
    : D E F D B L
    ;

DEFSTR
    : D E F S T R
    ;

ENVIRONDLR
    : E N V I R O N DOLLAR
    ;

SCREEN
    : S C R E E N
    ;

CIRCLE
    : C I R C L E
    ;

SLEEP
    : S L E E P
    ;

COLOR
    : C O L O R
    ;

INKEYDLR
    : I N K E Y DOLLAR
    ;

PAINT
    : P A I N T
    ;

PSET
    : P S E T
    ;

DRAW
    : D R A W
    ;

FONT
    : F O N T
    ;

DRAWSTR
    : D R A W S T R
    ;

LOADIMG
    : L O A D I M G
    ;

SAVEIMG
    : S A V E I M G
    ;

LOADWAV
    : L O A D W A V
    ;

PLAYWAV
    : P L A Y W A V
    ;

STOPWAV
    : S T O P W A V
    ;

LOOPWAV
    : L O O P W A V
    ;

CLS
    : C L S
    ;

BEEP
    : B E E P
    ;

MANUAL_REPAINT
    : M A N U A L R E P A I N T
    ;

DOUBLE_BUFFER
    : D O U B L E B U F F E R
    ;

REPAINT
    : R E P A I N T
    ;

ASIN
    : A S I N
    ;

ACOS
    : A C O S
    ;

SINH
    : S I N H
    ;

COSH
    : C O S H
    ;

TANH
    : T A N H
    ;

EULERE
    : E U L E R E
    ;

PI
    : P I
    ;

MIN
    : M I N
    ;

MAX
    : M A X
    ;

FLOOR
    : F L O O R
    ;

CEIL
    : C E I L
    ;

ROUND
    : R O U N D
    ;

LOG10
    : L O G '1' '0'
    ;

LOG2
    : L O G '2'
    ;

EXP
    : E X P
    ;

TORAD
    : T O R A D
    ;

TODEG
    : T O D E G
    ;

TRUE
    : T R U E
    ;

FALSE
    : F A L S E
    ;

ARRAYFILL
    : A R R A Y F I L L
    ;

ARRAY1DMIN
    : A R R A Y '1' D M I N
    ;

ARRAY1DMAX
    : A R R A Y '1' D M A X
    ;

ARRAY1DMEAN
    : A R R A Y '1' D M E A N
    ;

ARRAY1DSUM
    : A R R A Y '1' D S U M
    ;

ARRAY1DSTD
    : A R R A Y '1' D S T D
    ;

ARRAY1DMEDIAN
    : A R R A Y '1' D M E D I A N
    ;

ARRAY1DPCT
    : A R R A Y '1' D P C T
    ;

ARRAY1DSORT
    : A R R A Y '1' D S O R T
    ;

ARRAY1DBINSEARCH
    : A R R A Y '1' D B I N S E A R C H
    ;

ARRAY2DFINDROW
    : A R R A Y '2' D F I N D R O W
    ;

ARRAY2DFINDCOLUMN
    : A R R A Y '2' D F I N D C O L U M N
    ;

ARRAYCOPY
    : A R R A Y C O P Y
    ;

ARRAY1DCOPY
    : A R R A Y '1' D C O P Y
    ;

ARRAY2DSHIFTHOR
    : A R R A Y '2' D S H I F T H O R
    ;

ARRAY2DSHIFTVER
    : A R R A Y '2' D S H I F T V E R
    ;

HSB2RGB
    : H S B '2' R G B
    ;

LABEL
    : L A B E L
    ;

BEGIN
    : B E G I N
    ;

MOUSEMOVEDX
    : M O U S E M O V E D X
    ;

MOUSEMOVEDY
    : M O U S E M O V E D Y
    ;

MOUSEDRAGGEDX
    : M O U S E D R A G G E D X
    ;

MOUSEDRAGGEDY
    : M O U S E D R A G G E D Y
    ;

MOUSEBUTTONCLICKED
    : M O U S E B U T T O N C L I C K E D
    ;

MOUSEBUTTONPRESSED
    : M O U S E B U T T O N P R E S S E D
    ;

MOUSEBUTTONRELEASED
    : M O U S E B U T T O N R E L E A S E D
    ;

ISKEYPRESSED
    : I S K E Y P R E S S E D
    ;

FRONT
    : F R O N T
    ;

BACK1
    : B A C K '1'
    ;

BUFFERCOPYHOR
    : B U F F E R C O P Y H O R
    ;

STRUCT
    : S T R U C T
    ;

SPLITDLR
    : S P L I T DOLLAR
    ;

string
    : STRING
    ;

STRING
    : '"' ~["\r\n]* '"'
    ;

COMMA
    : ','
    ;

SEMICOLON
    : ';'
    ;

QUESTION
    : '?'
    ;

AT
    : '@'
    ;

DOLLAR
    : '$'
    ;

PERCENT
    : '%'
    ;

EXCLAMATION
    : '!'
    ;

HASH
    : '#'
    ;

APOSTROPHE
    : '\''
    ;

EXPONENT
    : '^'
    ;

FLOAT_DIV
    : '/'
    ;

INT_DIV
    : '\\'
    ;

MUL
    : '*'
    ;

LPAREN
    : '('
    ;

RPAREN
    : ')'
    ;

LBRACE
    : '{'
    ;

RBRACE
    : '}'
    ;

MOD
    : M O D
    ;

RELEQ
    : '='
    ;

RELNEQ
    : '<>'
    ;

RELGT
    : '>'
    ;

RELGE
    : '>='
    ;

RELLT
    : '<'
    ;

RELLE
    : '<='
    ;

LOGAND
    : A N D
    ;

LOGOR
    : O R
    ;

LOGNOT
    : N O T
    ;

LOGXOR
    : X O R
    ;

LOGEQV
    : E Q V
    ;

LOGIMP
    : I M P
    ;

BWRSFT
    : '>' '>'
    ;

BWLSFT
    : '<' '<'
    ;

VARNAME
    : LETTER (LETTER | DECIMAL)*
    ;

LETTER
    : [a-zA-Z]
    ;

number
    : integer | FLOAT | DOUBLE
    ;

integer
    : (DECIMAL | HEXADECIMAL | OCTAL) (PERCENT | AT | HASH | EXCLAMATION)?
    ;

PLUS
    : '+'
    ;

MINUS
    : '-'
    ;

DECIMAL
    : DIGIT+
    ;

HEXADECIMAL
    : '&' H DECIMAL
    ;

OCTAL
    : '&' O? DECIMAL
    ;

FLOAT
    : ((DIGIT* '.' DIGIT+) (('e' | 'E') DIGIT+)? '!'?) | (DECIMAL '!')
    ;

DOUBLE
    : ((DIGIT* '.' DIGIT+) (('d' | 'D') DIGIT+)? '#'?) | (DECIMAL '#')
    ;

DOT
    : '.'
    ;

fragment DIGIT : [0-9] ;

fragment A : 'a' | 'A' ;
fragment B : 'b' | 'B' ;
fragment C : 'c' | 'C' ;
fragment D : 'd' | 'D' ;
fragment E : 'e' | 'E' ;
fragment F : 'f' | 'F' ;
fragment G : 'g' | 'G' ;
fragment H : 'h' | 'H' ;
fragment I : 'i' | 'I' ;
fragment J : 'j' | 'J' ;
fragment K : 'k' | 'K' ;
fragment L : 'l' | 'L' ;
fragment M : 'm' | 'M' ;
fragment N : 'n' | 'N' ;
fragment O : 'o' | 'O' ;
fragment P : 'p' | 'P' ;
fragment Q : 'q' | 'Q' ;
fragment R : 'r' | 'R' ;
fragment S : 's' | 'S' ;
fragment T : 't' | 'T' ;
fragment U : 'u' | 'U' ;
fragment V : 'v' | 'V' ;
fragment W : 'w' | 'W' ;
fragment X : 'x' | 'X' ;
fragment Y : 'y' | 'Y' ;
fragment Z : 'z' | 'Z' ;

NEWLINE
    : '\r'? '\n'
    ;

WS
    : (SPACE | TAB)+ -> channel(HIDDEN);

SPACE
    : ' '
    ;

TAB
    : '\t'
    ;

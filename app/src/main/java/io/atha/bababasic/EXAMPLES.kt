package io.atha.bababasic

val EXAMPLES = mapOf(
    "HELLO.bas" to """PRINT "Hello, world!"
PRINT "Καλημέρα, κόσμε!"
PRINT "ハロー, ワールド!"
PRINT
INPUT "Name? ", A$
PRINT "Hello, ", A$, "!"
INPUT "Year of birth? ", YOB%
CURRENTYEAR% = VAL(RIGHT${'$'}(DATE${'$'}, 4))
AGE% = CURRENTYEAR% - YOB% 
PRINT "Your age is", AGE%
""",
    "PRIME.bas" to """FOR I% = 1 TO 10000
  J% = 3
  N% = I% \ 2
  ISPRIME% = (I% > 1) AND ((I% MOD 2 <> 0) OR (I% = 2))
  WHILE J% <= N% AND ISPRIME% = -1
    ISPRIME% = I% MOD J% <> 0
    J% = J% + 2
  WEND
  IF ISPRIME% THEN PRINT STR$(I%), " is prime"
NEXT I%
""",
    "FIB.bas" to """10 LET A = 0
20 LET B = 1
30 LET C = A + B
40 PRINT C
50 LET A = B
60 LET B = C
65 SLEEP 0.5
70 GOTO 30
""",
    "INKEY.bas" to """PRINT "PRESS w,a,s,d TO MOVE THE STAR. PRESS q to QUIT."
X = 5
Y = 5
eventLoop:
LOCATE 2
FOR I = 0 TO 10
FOR J = 0 TO 10
   IF X = I AND Y = J THEN PRINT "*"; ELSE PRINT " ";
NEXT J
PRINT
NEXT I
A$ = INKEY$
IF A$ <> "" THEN BEGIN
   LOCATE 15
   PRINT "YOU PRESSED " + A$
   IF A$ = "a" THEN Y = Y - 1
   IF A$ = "d" THEN Y = Y + 1
   IF A$ = "w" THEN X = X - 1
   IF A$ = "s" THEN X = X + 1
   IF A$ = "q" THEN END
END IF
IF X < 0 THEN X = 0
IF X > 10 THEN X = 10
IF Y < 0 THEN Y = 0
IF Y > 10 THEN Y = 10
GOTO eventLoop"""
)
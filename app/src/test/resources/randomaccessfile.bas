10 FILE$ = ENVIRON$("TEST_TMP_DIR") + "/" + ENVIRON$("TEST_FILENAME")
30 OPEN "R", #1, FILE$, 24
40 FIELD#1, 8 AS A$, 8 AS B$, 8 AS C$
50 FOR I% = 1 TO 5
60 LSET A$ = STR$(I%)
70 LSET B$ = STR$(I% + 1)
80 LSET C$ = STR$(I% + 2)
90 PUT #1
100 PRINT LOC(1), LOF(1)
110 NEXT I%
120 FOR I% = 1 TO 5
130 GET #1, I% - 1
140 PRINT A$, B$, C$, LOC(1), LOF(1)
150 NEXT
160 CLOSE

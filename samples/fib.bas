10 A@ = 0 : B@ = 1
20 FOR I% = 1 TO 20
30   C@ = A@ + B@
40   PRINT C@,
50   A@ = B@ : B@ = C@
60 NEXT I%
70 PRINT ""

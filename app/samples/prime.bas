FOR I% = 1 TO 100
  J% = 3
  N% = I% \ 2
  ISPRIME% = (I% > 1) AND ((I% MOD 2 <> 0) OR (I% = 2))
  WHILE J% <= N% AND ISPRIME% = -1
    ISPRIME% = I% MOD J% <> 0
    J% = J% + 2
  WEND
  IF ISPRIME% THEN PRINT STR$(I%), " is prime"
NEXT I%

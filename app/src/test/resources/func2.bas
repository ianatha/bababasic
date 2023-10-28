PRINT "DECLARE FUNCTION"

FUNCTION fun1# (X, Y) {
  Z = X + Y
  RETURN Z
}

FUNCTION fun2 (X, Y) {
  IF Y = 0 THEN RETURN 0
  Z = X / Y
  RETURN Z
}

PRINT "CALL FUNCTION"
PRINT fun1#(2, 3)
PRINT fun2(2, 3)
PRINT fun2(2, 0)

PRINT "ARRAY TEST"

FUNCTION initArray (DIM X(0), n, v) {
  FOR I% = 0 TO n - 1
    X(I%) = v
  NEXT
  RETURN 0
}

DIM A%(10)
initArray(A%, LEN(A%), 10)

FOR I% = 0 TO LEN(A%) - 1
  PRINT A%(I%)
NEXT

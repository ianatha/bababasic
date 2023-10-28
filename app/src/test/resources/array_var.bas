10 DIM A%(3,4)
20 for I = 0 to 2
30 for J = 0 to 3
40 A%(I, J) = (I + 1) * (J + 1)
50 NEXT : NEXT
60 for I = 0 to 2
70 PRINT A%(I,0), A%(I,1), A%(I,2), A%(I,3)
80 NEXT
90 d1% = 5 : d2% = 2 : DIM B%(d1%, d2%)
100 PRINT LEN(B%), LEN(B%, 0), LEN(B%, 1)

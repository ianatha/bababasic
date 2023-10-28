10 ' Mandelbrot Set
20 DIM GRID%(400, 400)
30 DIM PALETTE%(101)
40 MAXITER% = 100
50 FOR I = 0 TO 100
60   h = I / MAXITER% : s = 1.0 : IF I < MAXITER% THEN v = 1.0 ELSE v = 0.0
70   PALETTE%(I) = HSB2RGB(h, s, v)
80 NEXT I
90 NX=400 : NY=400
100 SCALEX=8*NX : SCALEY=8*NY : SHIFTX=400 : SHIFTY=200 ' Zoomed view
110 'SCALEX=NX : SCALEY=NY : SHIFTX=NX/2 : SHIFTY=NY/2 ' Full view
120 SCREEN "Mandelbrot Set - Written in PuffinBASIC", NX, NY, MANUALREPAINT
130 FOR maxiter% = 10 TO MAXITER%
140   PRINT "Maxiter=", maxiter% : ARRAYFILL GRID%, 0
150   FOR x = 0 TO NX - 1
160     FOR y = 0 to NY - 1
170       cx = (x - SHIFTX) * 4 / SCALEX ' (r - nr/2) / nr * 4
180       cy = (y - SHIFTY) * 4 / SCALEY
190       zx = 0 : zy = 0 : iter% = 0
200       WHILE zx*zx + zy*zy <= 4 AND iter% < maxiter%
210         zx2 = zx*zx - zy*zy + cx
220         zy = 2*zx*zy + cy : zx = zx2
230         iter% = iter% + 1
240       WEND
250       GRID%(y, x) = PALETTE%(iter%)
260     NEXT y
270   NEXT x
280   PUT (0, 0), GRID%, "PSET"
290   REPAINT
300 NEXT maxiter%
980 SLEEP 10000
990 END

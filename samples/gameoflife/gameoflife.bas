10 ' GAME OF LIFE
20 DIM GRID1%(64, 64)
30 DIM GRID2%(64, 64)
50 DIM TILE0%(8, 8)
60 NROWS% = 64 : NCOLS% = 64 : TILER% = 8 : TILEC% = 8 : NITER% = 60
70 GOSUB 5000 ' CREATE SCREEN
80 GOSUB 2200 ' LOAD IMAGES
85 NSHAPE% = -1
90 WHILE -1
100     CLS : NSHAPE% = (NSHAPE% + 1) MOD 30
110     GOSUB 2000 ' INIT GRID
115     FOR I% = 0 TO NSHAPE%
120         p% = 1 + CINT(RND * 8) : R% = CINT(10 + RND * (NROWS% - 20)) : C% = CINT(10 + RND * (NCOLS% - 20))
130         IF p% = 1 THEN GOSUB 7000
140         IF p% = 2 THEN GOSUB 7100
150         IF p% = 3 THEN GOSUB 7200
160         IF p% = 4 THEN GOSUB 7300
170         IF p% = 5 THEN GOSUB 7400
180         IF p% = 6 THEN GOSUB 7500
190         IF p% = 7 THEN GOSUB 7600
200         IF p% = 8 THEN GOSUB 7700
205     NEXT I%
210     GOSUB 6000 ' DRAW INITIAL GRID
220     ITER% = 0
230     WHILE ITER% < NITER%
240        ARRAYCOPY GRID1%, GRID2%
250        ITER% = ITER% + 1
260        FOR row% = 0 TO NROWS% - 1
270            FOR col% = 0 TO NCOLS% - 1
280                GOSUB 6500 ' COUNT NEIGHBORS
290                alive% = GRID1%(row%, col%)
300                IF alive% = 1 AND (countnbr% < 2 OR countnbr% > 3) THEN GRID2%(row%, col%)=0 : PUT(col% * TILEC%, row% * TILER%), TILE0%
310                IF alive% = 0 AND countnbr% = 3 THEN GRID2%(row%, col%)=1 : PUT(col% * TILEC%, row% * TILER%), TILE0%, "PSET"
320            NEXT col%
330        NEXT row%
340        SLEEP 10 : REPAINT
350        ARRAYCOPY GRID2%, GRID1%
360     WEND
900 WEND
990 END
1000 ' GAME LOOP
2000 ' INIT GRID
2010 ARRAYFILL GRID1%, 0
2020 ARRAYFILL GRID2%, 0
2030 RETURN
2200 ' LOAD IMAGES
2210 LOADIMG "samples/gameoflife/images/green.png", TILE0%
2220 RETURN
5000 ' INIT SCREEN
5010 SCREEN "Game Of Life - Written in PuffinBASIC", NCOLS% * TILEC%, NROWS% * TILER%, MANUALREPAINT
5020 RETURN
6000 ' DRAW INITIAL GRID
6010 FOR R% = 0 TO NROWS% - 1
6020     FOR C% = 0 TO NCOLS% - 1
6030         IF GRID1%(R%, C%) = 1 THEN PUT(C% * TILEC%, R% * TILER%), TILE0%, "PSET"
6040     NEXT C%
6050 NEXT R%
6060 RETURN
6500 ' COUNT NEIGHBORS
6510 countnbr% = 0
6520 FOR DR% = -1 TO 1 ' ROW
6530     FOR DC% = -1 TO 1 ' COL
6540         ri% = row% + DR%
6550         ci% = col% + DC%
6560         IF DR% = 0 AND DC% = 0 THEN v% = 0 ELSE v% = 1
6570         IF ri% >= 0 AND ri% < NROWS% AND ci% >= 0 AND ci% < NCOLS% THEN countnbr% = countnbr% + v% * GRID1%(ri%, ci%)
6580     NEXT DC%
6590 NEXT DR%
6600 RETURN
7000 ' INIT PATTERN 1 - Oscillators - Blinker (period = 2)
7010 GRID1%(R%, C%) = 1 : GRID1%(R%, C%+1) = 1 : GRID1%(R%, C%+2) = 1
7020 RETURN
7100 ' INIT PATTERN 2 - Oscillators - Toad (period = 2)
7110 GRID1%(R%, C%+1) = 1 : GRID1%(R%, C%+2) = 1 : GRID1%(R%, C%+3) = 1
7120 GRID1%(R%+1, C%) = 1 : GRID1%(R%+1, C%+1) = 1 : GRID1%(R%+1, C%+2) = 1
7130 RETURN
7200 ' INIT PATTERN 3 - Oscillators - Beacon (period = 2)
7210 GRID1%(R%, C%) = 1 : GRID1%(R%, C%+1) = 1
7220 GRID1%(R%+1, C%) = 1 : GRID1%(R%+1, C%+1) = 1
7230 GRID1%(R%+2, C%+2) = 1 : GRID1%(R%+2, C%+3) = 1
7240 GRID1%(R%+3, C%+2) = 1 : GRID1%(R%+3, C%+3) = 1
7250 RETURN
7300 ' INIT PATTERN 4 - Spaceships - Glider
7310 GRID1%(R%, C%+2) = 1
7320 GRID1%(R%+1, C%) = 1 : GRID1%(R%+1, C%+2) = 1
7330 GRID1%(R%+2, C%+1) = 1 : GRID1%(R%+2, C%+2) = 1
7340 RETURN
7400 ' INIT PATTERN 5 - Spaceships - LWSS
7410 GRID1%(R%, C%+2) = 1 : GRID1%(R%, C%+3) = 1
7420 GRID1%(R%+1, C%) = 1 : GRID1%(R%+1, C%+1) = 1 : GRID1%(R%+1, C%+3) = 1 : GRID1%(R%+1, C%+4) = 1
7430 GRID1%(R%+2, C%) = 1 : GRID1%(R%+2, C%+1) = 1 : GRID1%(R%+2, C%+2) = 1 : GRID1%(R%+2, C%+3) = 1
7450 GRID1%(R%+3, C%+1) = 1 : GRID1%(R%+3, C%+2) = 1
7460 RETURN
7500 ' INIT PATTERN 6 - Spaceships - MWSS
7510 GRID1%(R%, C%+2) = 1
7520 GRID1%(R%+1, C%) = 1 : GRID1%(R%+1, C%+4) = 1
7530 GRID1%(R%+2, C%+5) = 1
7540 GRID1%(R%+3, C%) = 1 : GRID1%(R%+3, C%+5) = 1
7550 GRID1%(R%+4, C%+1) = 1 : GRID1%(R%+4, C%+2) = 1 : GRID1%(R%+4, C%+3) = 1 : GRID1%(R%+4, C%+4) = 1 : GRID1%(R%+4, C%+5) = 1
7560 RETURN
7600 ' INIT PATTERN 7 - Spaceships - LWSS
7610 GRID1%(R%, C%+2) = 1 : GRID1%(R%, C%+3) = 1
7620 GRID1%(R%+1, C%) = 1 : GRID1%(R%+1, C%+5) = 1
7630 GRID1%(R%+2, C%+6) = 1
7640 GRID1%(R%+3, C%) = 1 : GRID1%(R%+3, C%+6) = 1
7650 GRID1%(R%+4, C%+1) = 1 : GRID1%(R%+4, C%+2) = 1 : GRID1%(R%+4, C%+3) = 1 : GRID1%(R%+4, C%+4) = 1 : GRID1%(R%+4, C%+5) = 1 : GRID1%(R%+4, C%+6) = 1
7660 RETURN
7700 ' INIT PATTERN 8 - Oscillators - Penta-decathlon (period=15)
7710 GRID1%(R%, C%) = 1 : GRID1%(R%, C%+1) = 1 : GRID1%(R%, C%+2) = 1
7720 GRID1%(R%+1, C%) = 1 : GRID1%(R%+1, C%+2) = 1
7730 GRID1%(R%+2, C%) = 1 : GRID1%(R%+2, C%+1) = 1 : GRID1%(R%+2, C%+2) = 1
7740 GRID1%(R%+3, C%) = 1 : GRID1%(R%+3, C%+1) = 1 : GRID1%(R%+3, C%+2) = 1
7750 GRID1%(R%+4, C%) = 1 : GRID1%(R%+4, C%+1) = 1 : GRID1%(R%+4, C%+2) = 1
7760 GRID1%(R%+5, C%) = 1 : GRID1%(R%+5, C%+1) = 1 : GRID1%(R%+5, C%+2) = 1
7770 GRID1%(R%+6, C%) = 1 : GRID1%(R%+6, C%+2) = 1
7780 GRID1%(R%+7, C%) = 1 : GRID1%(R%+7, C%+1) = 1 : GRID1%(R%+7, C%+2) = 1
7790 RETURN

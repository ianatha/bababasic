' TESSEL - A Tile Builder Game

GRIDW% = 16 : GRIDH% = 24
DIM GRID%(24, 16)
DIM ROWS%(24)
DIM TILE0%(32, 32)
DIM TILE1%(32, 32)
DIM TILE2%(32, 32)
DIM TILE3%(32, 32)
DIM TILE4%(32, 32)
DIM TILE5%(32, 32)
DIM TILE6%(32, 32)
DIM TILE7%(32, 32)
DIM tile%(4, 4)

GOSUB "LOAD_IMAGES" ' LOAD IMAGES
GOSUB "CREATE_SCREEN" ' CREATE SCREEN
GOSUB "INIT_TILES" ' INIT TILES

WHILE -1
    PRINT "Starting New Game"
    GOSUB "CREATE_GRID" ' INIT GRID
    CLS
    GOSUB "GAME_LOOP" ' GAME LOOP
    PRINT "Waiting for a few seconds before starting new game ..."
    SLEEP 5000
WEND
END

LABEL "LOAD_IMAGES" ' LOAD IMAGES
LOADIMG "samples/tessel/images/tile0.png", TILE0%
LOADIMG "samples/tessel/images/tile1.png", TILE1%
LOADIMG "samples/tessel/images/tile2.png", TILE2%
LOADIMG "samples/tessel/images/tile3.png", TILE3%
LOADIMG "samples/tessel/images/tile4.png", TILE4%
LOADIMG "samples/tessel/images/tile5.png", TILE5%
LOADIMG "samples/tessel/images/tile6.png", TILE6%
LOADIMG "samples/tessel/images/tile7.png", TILE7%
TILEW% = 32 : TILEH% = 32
PRINT "Loaded images"
RETURN

LABEL "CREATE_GRID" ' CREATE GRID
FOR I% = 0 TO GRIDH% - 1
    FOR J% = 0 TO GRIDW% - 1
       GRID%(I%, J%) = 0
    NEXT : NEXT
PRINT "Initialized grid"
RETURN

LABEL "CREATE_SCREEN" ' CREATE SCREEN
OFFSETX% = 0
OFFSETY% = 2
SCRSIZEX% = GRIDW% * TILEW% + OFFSETX% * GRIDW%
SCRSIZEY% = GRIDH% * TILEH% + OFFSETY% * GRIDH%
SCREEN "TESSEL - A Tile Builder Game in PuffinBASIC", SCRSIZEX%, SCRSIZEY%, MANUALREPAINT
PRINT "Created Screen: ", SCRSIZEX%, SCRSIZEY%
RETURN

LABEL "DRAW_GRID" ' DRAW GRID
FOR Y% = 0 TO GRIDH% - 1
    FOR X% = 0 TO GRIDW% - 1
        t% = GRID%(Y%, X%)
        x% = X% * TILEW% : y% = Y% * TILEH% + OFFSETY% * GRIDH%
        IF t% = 1 THEN PUT (x%, y%), TILE0%, "PSET"
    NEXT
NEXT
COLOR 20, 25, 25
LINE (0, 0) - (GRIDW% * TILEW% - 1, OFFSETY% * GRIDH% - 1), "BF"
score$ = SPACE$(256)
LSET score$ = "Rotate: U arrow, Move: L/R/D arrow, SCORE: " + str$(points%)
FONT "Courier", "", 16
COLOR 0, 255, 255
DRAWSTR score$, 10, 32
RETURN

LABEL "INIT_TILES" ' tile1
DIM T11%(4, 4) : T11%(0, 2) = 1 : T11%(1, 0) = 1 : T11%(1, 1) = 1 : T11%(1, 2) = 1
DIM T12%(4, 4) : T12%(0, 0) = 1 : T12%(1, 0) = 1 : T12%(2, 0) = 1 : T12%(2, 1) = 1
DIM T13%(4, 4) : T13%(0, 0) = 1 : T13%(0, 1) = 1 : T13%(0, 2) = 1 : T13%(1, 0) = 1
DIM T14%(4, 4) : T14%(0, 0) = 1 : T14%(0, 1) = 1 : T14%(1, 1) = 1 : T14%(2, 1) = 1
' tile2
DIM T21%(4, 4) : T21%(0, 0) = 1 : T21%(0, 1) = 1 : T21%(0, 2) = 1 : T21%(0, 3) = 1
DIM T22%(4, 4) : T22%(0, 0) = 1 : T22%(1, 0) = 1 : T22%(2, 0) = 1 : T22%(3, 0) = 1
DIM T23%(4, 4) : T23%(0, 0) = 1 : T23%(0, 1) = 1 : T23%(0, 2) = 1 : T23%(0, 3) = 1
DIM T24%(4, 4) : T24%(0, 0) = 1 : T24%(1, 0) = 1 : T24%(2, 0) = 1 : T24%(3, 0) = 1
' tile3
DIM T31%(4, 4) : T31%(0, 0) = 1 : T31%(1, 0) = 1 : T31%(1, 1) = 1 : T31%(1, 2) = 1
DIM T32%(4, 4) : T32%(0, 0) = 1 : T32%(0, 1) = 1 : T32%(1, 0) = 1 : T32%(2, 0) = 1
DIM T33%(4, 4) : T33%(0, 0) = 1 : T33%(0, 1) = 1 : T33%(0, 2) = 1 : T33%(1, 2) = 1
DIM T34%(4, 4) : T34%(0, 1) = 1 : T34%(1, 1) = 1 : T34%(2, 0) = 1 : T34%(2, 1) = 1
' tile4
DIM T41%(4, 4) : T41%(0, 0) = 1 : T41%(0, 1) = 1 : T41%(1, 0) = 1 : T41%(1, 1) = 1
DIM T42%(4, 4) : T42%(0, 0) = 1 : T42%(0, 1) = 1 : T42%(1, 0) = 1 : T42%(1, 1) = 1
DIM T43%(4, 4) : T43%(0, 0) = 1 : T43%(0, 1) = 1 : T43%(1, 0) = 1 : T43%(1, 1) = 1
DIM T44%(4, 4) : T44%(0, 0) = 1 : T44%(0, 1) = 1 : T44%(1, 0) = 1 : T44%(1, 1) = 1
' tile5
DIM T51%(4, 4) : T51%(0, 1) = 1 : T51%(1, 0) = 1 : T51%(1, 1) = 1 : T51%(1, 2) = 1
DIM T52%(4, 4) : T52%(0, 0) = 1 : T52%(1, 0) = 1 : T52%(1, 1) = 1 : T52%(2, 0) = 1
DIM T53%(4, 4) : T53%(0, 0) = 1 : T53%(0, 1) = 1 : T53%(0, 2) = 1 : T53%(1, 1) = 1
DIM T54%(4, 4) : T54%(0, 1) = 1 : T54%(1, 0) = 1 : T54%(1, 1) = 1 : T54%(2, 1) = 1
' tile6
DIM T61%(4, 4) : T61%(0, 1) = 1 : T61%(1, 0) = 1 : T61%(1, 1) = 1 : T61%(2, 0) = 1
DIM T62%(4, 4) : T62%(0, 0) = 1 : T62%(0, 1) = 1 : T62%(1, 1) = 1 : T62%(1, 2) = 1
DIM T63%(4, 4) : T63%(0, 1) = 1 : T63%(1, 0) = 1 : T63%(1, 1) = 1 : T63%(2, 0) = 1
DIM T64%(4, 4) : T64%(0, 0) = 1 : T64%(0, 1) = 1 : T64%(1, 1) = 1 : T64%(1, 2) = 1
' tile7
DIM T71%(4, 4) : T71%(0, 0) = 1 : T71%(0, 1) = 1 : T71%(1, 0) = 1
DIM T72%(4, 4) : T72%(0, 0) = 1 : T72%(0, 1) = 1 : T72%(1, 1) = 1
DIM T73%(4, 4) : T73%(0, 1) = 1 : T73%(1, 0) = 1 : T73%(1, 1) = 1
DIM T74%(4, 4) : T74%(0, 0) = 1 : T74%(1, 0) = 1 : T74%(1, 1) = 1
RETURN

LABEL "GAME_LOOP" ' GAME LOOP
run% = -1 : points% = 0 : drawGrid% = 1' Draw Grid
tileid% = 0 : tilex% = 0 : tiley% = 0 : rot% = 0 : dStep% = 0 : nSteps% = 4 : sStep% = 1

WHILE run%
   IF tileid% = 0 THEN tileid% = 1 + int(RND * 7) : tiley% = 0 : tilex% = int(RND * (GRIDW% - 4)) : rot% = 0

   collision% = 0 : drot% = 0
   GOSUB "COPY_TILE" ' Set Tile

   IF drawGrid% <> 0 THEN drawGrid% = 0 : GOSUB "DRAW_GRID" ' Draw Grid
   GOSUB "DRAW_TILE" ' Draw Tile

   k$ = INKEY$
   dx% = 0 : dy% = 0 : drot% = 0
   IF k$ = CHR$(0) + CHR$(37) THEN dx% = -1
   IF k$ = CHR$(0) + CHR$(39) THEN dx% = 1
   IF k$ = CHR$(0) + CHR$(38) THEN drot% = 1
   IF k$ = CHR$(0) + CHR$(40) THEN dy% = 1

   ' Check for collision
   IF dStep% = nSteps% - 1 THEN dy% = 1 : dStep% = 0 ELSE dStep% = dStep% + sStep%
   GOSUB "CHECK_COLLISION" ' Check collision and hitbottom

   IF collision% <> 0 AND tiley% = 0 THEN run% = 0 : GOSUB "GAME_OVER"

   oldrot% = rot% : newrot% = rot%
   IF drot% = 1 AND collision% <> 2 THEN newrot% = (rot% + 1) MOD 4 ' Rotate if no collision
   IF (hitbottom% = -1 OR collision% <> 0) AND tiley% > 0 THEN tileid% = 0 : dy% = 0 : GOSUB "COPY_TILE_TO_GRID" ' Copy Tile to Grid
   IF hitbottom% = 0 AND collision% = 0 AND drot% = 1 THEN checkrot% = 1 ELSE checkrot% = 0 ' Check if rotation causes collision
   IF checkrot% = 1 THEN collision% = 0 : rot% = newrot% : GOSUB "COPY_TILE" : GOSUB "CHECK_COLLISION" ' Copy rotated tile and check for collision
   IF checkrot% = 1 THEN rot% = oldrot% : GOSUB "COPY_TILE" ' Revert rotated tile
   IF checkrot% = 1 AND collision% <> 0 THEN rot% = oldrot% ELSE IF checkrot% = 1 THEN rot% = newrot%
   REPAINT : SLEEP 40
   GOSUB "DRAW_TILE" ' Erase Tile and Update tile x,y
   tilex% = tilex% + dx%
   tiley% = tiley% + dy%
WEND
RETURN

LABEL "COPY_TILE" ' Copy tile
FOR I% = 0 TO 3
    FOR J% = 0 TO 3
       tile%(I%, J%) = 0
       IF tileid% = 1 AND rot% = 0 THEN tile%(I%, J%) = T11%(I%, J%)
       IF tileid% = 1 AND rot% = 1 THEN tile%(I%, J%) = T12%(I%, J%)
       IF tileid% = 1 AND rot% = 2 THEN tile%(I%, J%) = T13%(I%, J%)
       IF tileid% = 1 AND rot% = 3 THEN tile%(I%, J%) = T14%(I%, J%)
       IF tileid% = 2 AND rot% = 0 THEN tile%(I%, J%) = T21%(I%, J%)
       IF tileid% = 2 AND rot% = 1 THEN tile%(I%, J%) = T22%(I%, J%)
       IF tileid% = 2 AND rot% = 2 THEN tile%(I%, J%) = T23%(I%, J%)
       IF tileid% = 2 AND rot% = 3 THEN tile%(I%, J%) = T24%(I%, J%)
       IF tileid% = 3 AND rot% = 0 THEN tile%(I%, J%) = T31%(I%, J%)
       IF tileid% = 3 AND rot% = 1 THEN tile%(I%, J%) = T32%(I%, J%)
       IF tileid% = 3 AND rot% = 2 THEN tile%(I%, J%) = T33%(I%, J%)
       IF tileid% = 3 AND rot% = 3 THEN tile%(I%, J%) = T34%(I%, J%)
       IF tileid% = 4 AND rot% = 0 THEN tile%(I%, J%) = T41%(I%, J%)
       IF tileid% = 4 AND rot% = 1 THEN tile%(I%, J%) = T42%(I%, J%)
       IF tileid% = 4 AND rot% = 2 THEN tile%(I%, J%) = T43%(I%, J%)
       IF tileid% = 4 AND rot% = 3 THEN tile%(I%, J%) = T44%(I%, J%)
       IF tileid% = 5 AND rot% = 0 THEN tile%(I%, J%) = T51%(I%, J%)
       IF tileid% = 5 AND rot% = 1 THEN tile%(I%, J%) = T52%(I%, J%)
       IF tileid% = 5 AND rot% = 2 THEN tile%(I%, J%) = T53%(I%, J%)
       IF tileid% = 5 AND rot% = 3 THEN tile%(I%, J%) = T54%(I%, J%)
       IF tileid% = 6 AND rot% = 0 THEN tile%(I%, J%) = T61%(I%, J%)
       IF tileid% = 6 AND rot% = 1 THEN tile%(I%, J%) = T62%(I%, J%)
       IF tileid% = 6 AND rot% = 2 THEN tile%(I%, J%) = T63%(I%, J%)
       IF tileid% = 6 AND rot% = 3 THEN tile%(I%, J%) = T64%(I%, J%)
       IF tileid% = 7 AND rot% = 0 THEN tile%(I%, J%) = T71%(I%, J%)
       IF tileid% = 7 AND rot% = 1 THEN tile%(I%, J%) = T72%(I%, J%)
       IF tileid% = 7 AND rot% = 2 THEN tile%(I%, J%) = T73%(I%, J%)
       IF tileid% = 7 AND rot% = 3 THEN tile%(I%, J%) = T74%(I%, J%)
    NEXT
NEXT
RETURN

LABEL "DRAW_TILE" ' Draw tile
FOR Y% = 0 TO 3
    FOR X% = 0 TO 3
        v% = tile%(Y%, X%)
        y% = (tiley% + Y%) * TILEH% + OFFSETY% * GRIDH%
        x% = (tilex% + X%) * TILEW%
        IF v% = 1 AND tileid% = 1 THEN PUT (x%, y%), TILE1%, "XOR"
        IF v% = 1 AND tileid% = 2 THEN PUT (x%, y%), TILE2%, "XOR"
        IF v% = 1 AND tileid% = 3 THEN PUT (x%, y%), TILE3%, "XOR"
        IF v% = 1 AND tileid% = 4 THEN PUT (x%, y%), TILE4%, "XOR"
        IF v% = 1 AND tileid% = 5 THEN PUT (x%, y%), TILE5%, "XOR"
        IF v% = 1 AND tileid% = 6 THEN PUT (x%, y%), TILE6%, "XOR"
        IF v% = 1 AND tileid% = 7 THEN PUT (x%, y%), TILE7%, "XOR"
    NEXT
NEXT
RETURN

LABEL "CHECK_COLLISION" ' Check Collision
maxx% = 0 : maxy% = 0 : collision% = 0
FOR Y% = 0 TO 3
    FOR X% = 0 TO 3
        v% = tile%(Y%, X%)
        IF v% = 1 AND X% > maxx% THEN maxx% = X%
        IF v% = 1 AND Y% > maxy% THEN maxy% = Y%
    NEXT
NEXT
IF tilex% + dx% < 0 THEN dx% = 0
IF tilex% + dx% + maxx% >= GRIDW% THEN dx% = 0
IF tiley% + maxy% + 1 >= GRIDH% THEN hitbottom% = -1 ELSE hitbottom% = 0
FOR Y% = 0 TO maxy%
    FOR X% = 0 TO maxx%
        v% = tile%(Y%, X%)
        hgv% = GRID%(tiley% + Y%, tilex% + X%)
        gvdx% = GRID%(tiley% + Y%, tilex% + X% + dx%)
        IF hitbottom% = 0 THEN vgv% = GRID%(tiley% + Y% + 1, tilex% + X%) ELSE vgv% = 0
        IF v% = 1 AND vgv% = 1 THEN collision% = 1
        IF v% = 1 AND hgv% = 1 THEN collision% = 2
        IF v% = 1 AND gvdx% = 1 THEN dx% = 0
    NEXT
NEXT
RETURN

LABEL "COPY_TILE_TO_GRID" ' Copy Tile to Grid
drawGrid% = 1
FOR Y% = 0 TO maxy%
    FOR X% = 0 TO maxx%
        v% = tile%(Y%, X%)
        gv% = GRID%(tiley% + Y%, tilex% + X%)
        IF v% = 1 AND gv% = 0 THEN GRID%(tiley% + Y%, tilex% + X%) = 1 : points% = points% + 1
    NEXT
NEXT

FOR Y% = 0 TO GRIDH% - 1
    ROWS%(Y%) = 0
NEXT

minfilledy% = GRIDH%
FOR Y% = GRIDH% - 1 TO 0 STEP -1
    filled% = 1 : X% = 0
    WHILE X% < GRIDW%
        v% = GRID%(Y%, X%)
        IF v% = 0 THEN filled% = 0 : X% = GRIDW%
        X% = X% + 1
    WEND
    IF filled% = 1 THEN ROWS%(Y%) = 1 : points% = points% + GRIDW% * 2
    IF filled% = 1 AND Y% < minfilledy% THEN minfilledy% = Y%
NEXT

DESTY% = GRIDH% - 1 : SRCY1% = DESTY% - 1 : SRCY2% = 0
WHILE DESTY% >= minfilledy%
    r% = ROWS%(DESTY%)
    WHILE SRCY1% > 0 AND ROWS%(SRCY1%) = 1
       SRCY1% = SRCY1% - 1
    WEND
    SRCY2% = SRCY1% - 1
    WHILE SRCY2% > 0 AND ROWS%(SRCY2%) = 0
        SRCY2% = SRCY2% - 1
    WEND
    ' SHIFT
    DY% = DESTY% - SRCY1%
    FOR I% = SRCY1% to SRCY2% + 1 STEP -1
        FOR J% = 0 TO GRIDW% - 1
            GRID%(I% + DY%, J%) = GRID%(I%, J%)
            GRID%(I%, J%) = 0
        NEXT
    NEXT
    DESTY% = SRCY2%
WEND

FOR I% = 0 TO SRCY2% - 1
    FOR J% = 0 TO GRIDW% - 1
        GRID%(I%, J%) = 0
    NEXT
NEXT

IF minfilledy% < GRIDH% THEN CLS
RETURN

LABEL "GAME_OVER" ' GAME OVER
gover$ = "GAME OVER! Your Score=" + str$(points%) + ", try again" : PRINT gover$
FONT "Courier", "B", 24
COLOR 255, 0, 0
DRAWSTR gover$, 10, GRIDH% * TILEH% / 2
RETURN

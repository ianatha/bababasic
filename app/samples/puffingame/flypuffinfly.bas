' Fly Puffin Fly - A horizontal scrolling game

GRIDY% = 16 : GRIDX% = 30
TILEX% = 32 : TILEY% = 32
W% = GRIDX%*TILEX% : H% = GRIDY%*TILEY%

DIM PLAYER1%(32, 32) ' 1
DIM PLAYER2%(32, 32) ' 2
DIM BG1%(32, 32)     ' 11 (sky)
DIM BG2%(32, 32)     ' 12 (building)
DIM ENEMY1%(32, 32)  ' 21
DIM REWARD1%(32, 32) ' 31
DIM GRIDBG%(16, 30)
DIM GRID%(16, 30)
DIM GRIDPREV%(16, 30)

playery%=5 : playerx%=2 : playerspr%=1 : playerPrevSpr% = -1
MAXENEMY%=10 : MAXREWARD%=10

GOSUB "LOAD_IMAGES" : GOSUB "LOAD_SOUNDS" ' Load Images & Sounds
SCREEN "Fly Puffin Fly - A Scrolling Game Written in PuffinBASIC", W%, H%, MANUALREPAINT

hi% = 0
WHILE -1
  maxenemy% = 2 : maxreward% = 2
  speed% = 1 : speedstep% = 1 : nspeed% = 4

  ARRAYFILL  GRIDBG%, 11
  ARRAYFILL  GRID%, 0
  ARRAYFILL  GRIDPREV%, 0

  GOSUB "INIT_BG" ' Init Grid BG
  GOSUB "INIT_ENEMY" ' Init Enemy
  GOSUB "INIT_REWARD" ' Init Reward

  LOOPWAV SOUNDBG1%

  run% = 1 : points% = 0 : sound% = 1
  t1 = TIMER
  WHILE run% = 1
    GOSUB "DRAW_GRID_BG" ' Draw Grid BG
    GOSUB "DRAW_PLAYER" ' Draw Player
    GOSUB "DRAW_FG" ' Draw FG
    GOSUB "SHOW_POINTS" ' Draw Points
    GOSUB "CHECK_COLLISION" ' Check collision

    IF collenemy% <> 0 THEN BEGIN
      STOPWAV SOUNDBG1%
      STOPWAV SOUNDBG2%
      PLAYWAV SOUNDDEAD1%
      hi% = MAX(hi%, points%)
      run% = 0
      GOSUB "GAME_OVER"
    END IF
    IF collreward% = 1 THEN PLAYWAV SOUNDEAT1%

    REPAINT
    t2% = CINT(1000 * (TIMER - t1))
    t1 = TIMER
    st% = MAX(0, 100 - t2%)
    IF st% > 0 THEN SLEEP st%

    GOSUB "ERASE_PLAYER" ' Erase Player
    GOSUB "ERASE_FG" ' Erase FG
    playerspr% = (playerspr% + 1) MOD 4

    k$ = INKEY$
    IF k$ = CHR$(0) + CHR$(38) THEN playery% = MAX(0, playery% - 1)
    IF k$ = CHR$(0) + CHR$(40) THEN playery% = MIN(GRIDY% - 1, playery% + 1)

    speed% = speed% + speedstep%
    IF speed% >= nspeed% THEN BEGIN
      speed% = 0
      GOSUB "SCROLL"
      GOSUB "ADD_NEW_BG"
      GOSUB "ADD_NEW_ENEMY"
      GOSUB "ADD_NEW_REWARD" ' Scroll & Insert New Enemy
    END IF

    points% = points% + 1 : ptsstep% = points% \ 1000
    IF ptsstep% = 1 THEN speedstep% = 2 : maxenemy% = 3 : maxreward% = 3
    IF ptsstep% = 2 THEN speedstep% = 3 : maxenemy% = 4 : maxreward% = 4
    IF ptsstep% = 2 AND sound% = 1 THEN sound% = 2 : STOPWAV SOUNDBG1% : LOOPWAV SOUNDBG2%
    IF ptsstep% = 3 THEN speedstep% = 4 : maxenemy% = 5 : maxreward% = 5
    IF ptsstep% = 5 THEN maxenemy% = 6 : maxreward% = 6
    IF ptsstep% = 6 THEN maxenemy% = 7 : maxreward% = 7
    IF ptsstep% = 7 THEN maxenemy% = 8 : maxreward% = 8
    IF ptsstep% = 8 THEN maxenemy% = 9 : maxreward% = 9
    IF ptsstep% = 9 THEN maxenemy% = 10 : maxreward% = 10

  WEND

  SLEEP 5000 : CLS
WEND

END

LABEL "LOAD_IMAGES" ' LOAD IMAGES
LOADIMG "samples/puffingame/images/puffin1.png", PLAYER1%
LOADIMG "samples/puffingame/images/puffin2.png", PLAYER2%
LOADIMG "samples/puffingame/images/bg1.png", BG1%
LOADIMG "samples/puffingame/images/bg2.png", BG2%
LOADIMG "samples/puffingame/images/enemy1.png", ENEMY1%
LOADIMG "samples/puffingame/images/reward1.png", REWARD1%
RETURN

LABEL "LOAD_SOUNDS" ' LOAD SOUNDS
LOADWAV "samples/puffingame/sounds/eat2.wav", SOUNDEAT1%
LOADWAV "samples/puffingame/sounds/bg1.wav", SOUNDBG1%
LOADWAV "samples/puffingame/sounds/bg2.wav", SOUNDBG2%
LOADWAV "samples/puffingame/sounds/dead1.wav", SOUNDDEAD1%
RETURN

LABEL "DRAW_GRID_BG" ' DRAW GRID BG
FOR y% = 0 TO GRIDY% - 1
  FOR x% = 0 TO GRIDX% - 1
    v% = GRIDBG%(y%, x%) : xx% = x%*TILEX% : yy% = y%*TILEY%
    IF v% = 11 THEN PUT(xx%, yy%), BG1%, "PSET"
    IF v% = 12 THEN PUT(xx%, yy%), BG2%, "PSET"
  NEXT x%
NEXT y%
RETURN

LABEL "DRAW_PLAYER" ' Draw Player
x% = playerx% * TILEX% : y% = playery% * TILEY%
playerPrevSpr% = GRIDBG%(playery%, playerx%)
IF playerspr% \ 2 = 1 THEN PUT(x%, y%), PLAYER1%, "MIX" ELSE PUT(x%, y%), PLAYER2%, "MIX"
RETURN

LABEL "ERASE_PLAYER" ' Erase Player
x% = playerx% * TILEX% : y% = playery% * TILEY%
IF playerPrevSpr% = 11 THEN PUT(x%, y%), BG1%, "PSET"
IF playerPrevSpr% = 12 THEN PUT(x%, y%), BG2%, "PSET"
RETURN

LABEL "INIT_BG" ' Init BG
FOR x% = 0 TO GRIDX% - 1
  maxy% = cint(RND * 2)
  FOR y% = 0 TO maxy%
    yy% = GRIDY% - y% - 1
    GRIDBG%(yy%, x%) = 12
  NEXT y%
NEXT x%
RETURN

LABEL "SCROLL" ' Scroll
ARRAY2DSHIFTHOR GRIDBG%, -1
ARRAY2DSHIFTHOR GRIDPREV%, -1
ARRAY2DSHIFTHOR GRID%, -1
RETURN

LABEL "ADD_NEW_BG" ' Add BG in rightmost column
maxy% = cint(RND * 2) : xx% = GRIDX% - 1
FOR y% = 0 TO GRIDY% - 1
  GRIDBG%(y%, xx%) = 11
NEXT y%
FOR y% = 0 TO maxy%
  yy% = GRIDY% - y% - 1
  GRIDBG%(yy%, xx%) = 12
NEXT y%
RETURN

LABEL "INIT_ENEMY" ' Init Enemy
chance = maxenemy% / MAXENEMY%
FOR x% = 10 TO GRIDX% - 1
  v = RND
  IF v < chance THEN y%=MAX(0, cint(RND * GRIDY%) - 1) : GRID%(y%, x%)=21
NEXT x%
RETURN

LABEL "INIT_REWARD" ' Init Reward
chance = maxreward% / MAXREWARD%
FOR x% = 10 TO GRIDX% - 1
  v = RND : y%=MAX(0, cint(RND * GRIDY%) - 1) : g% = GRID%(y%, x%)
  IF v < chance AND g% = 0 THEN GRID%(y%, x%)=31
NEXT x%
RETURN
LABEL "SCROLL_FG" ' Scroll FG
ARRAY2DSHIFTHOR GRID%, -1
RETURN

LABEL "DRAW_FG" ' Draw FG
FOR y% = 0 TO GRIDY% - 1
  FOR x% = 0 TO GRIDX% - 1
    g% = GRIDBG%(y%, x%)
    v% = GRID%(y%, x%)
    GRIDPREV%(y%, x%) = g%
    IF v% = 21 THEN PUT(x%*TILEX%, y%*TILEY%), ENEMY1%, "MIX"
    IF v% = 31 THEN PUT(x%*TILEX%, y%*TILEY%), REWARD1%, "MIX"
  NEXT x%
NEXT y%
RETURN

LABEL "ERASE_FG" ' Erase FG
FOR y% = 0 TO GRIDY% - 1
  FOR x% = 0 TO GRIDX% - 1
    g% = GRIDPREV%(y%, x%)
    IF g% = 11 THEN PUT(x%*TILEX%, y%*TILEY%), BG1%, "PSET"
    IF g% = 12 THEN PUT(x%*TILEX%, y%*TILEY%), BG2%, "PSET"
  NEXT x%
NEXT y%
RETURN

LABEL "ADD_NEW_ENEMY" ' Add new enemy
chance = maxenemy% / MAXENEMY%
x% = GRIDX% - 1
v = RND
IF v < chance THEN y%=MAX(0, cint(RND * GRIDY%) - 1) : GRID%(y%, x%)=21
RETURN

LABEL "ADD_NEW_REWARD" ' Add new reward
chance = maxreward% / MAXREWARD%
x% = GRIDX% - 1
v = RND : y%=MAX(0, cint(RND * GRIDY%) - 1) : g% = GRID%(y%, x%)
IF v < chance AND g% = 0 THEN GRID%(y%, x%)=31
RETURN

LABEL "CHECK_COLLISION" ' Check collision
g% = GRID%(playery%, playerx%)
collenemy% = 0 : collreward% = 0
IF g% = 21 THEN collenemy% = 1
IF g% = 31 THEN collreward% = 1 : GRID%(playery%, playerx%) = 0 : points% = points% + 50
RETURN

LABEL "SHOW_POINTS" ' Show Points
pointsstr$ = SPACE$(64)
LSET pointsstr$ = STR$(points%) + "  " + STR$(MAX(hi%, points%))
FONT "Courier", "B", 16
COLOR 255, 255, 255
DRAWSTR pointsstr$, W% - 150, 20
RETURN

LABEL "GAME_OVER" ' GAME OVER
gover$ = "Oops! GAME OVER! Your Score=" + str$(points%) + " hi=" + STR$(hi%) + ", try again"
PRINT gover$
FONT "Courier", "B", 24
COLOR 255, 0, 0
DRAWSTR gover$, 10, H% / 2
RETURN

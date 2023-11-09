val HELP_CONTENT = mapOf("ABS Function" to """
■ Action

    Returns the absolute value of a numeric expression

■ Syntax

    ABS(numeric-expression)

■ Remarks

    The absolute value function returns the unsigned magnitude of its
    argument. For example, ABS(-1) and ABS(1) are both 1.

■ Example

    The following example finds an approximate value for a cube root. It uses
    ABS to find the difference between two guesses to see if the current guess
    is accurate enough.

    DEFDBL A-Z

    FUNCTION CubeRoot(Value,Precision) STATIC
    '  Make the first two guesses.
        X1=0.0# : X2=Value

    '  Go until the difference between two guesses is
    '  less than the required precision.

        DO UNTIL ABS(X1-X2) < Precision
        X=(X1+X2)/2.0#
        ' Adjust the guesses.
        IF X*X*X-Value < 0.0# THEN
            X1=X
        ELSE
            X2=X
        END IF
        LOOP
        CubeRoot=X
    END FUNCTION

    INPUT "Enter a value: ",X
    PRINT "The cube root is ";CubeRoot(X,.0000001#)

■ Output

    Enter a value: 27
    The cube root is  2.999999972060323

""","ASC Function" to """
■ Action

    Returns a numeric value that is the ASCII code for the first character in
    a string expression

■ Syntax

    ASC(stringexpression)

■ Remarks

    If stringexpression is null, ASC produces a run-time error message
    (Illegal function call).

■ See Also

    CHR$; Appendix A, "Keyboard Scan Codes and ASCII Character Codes"

■ Example

    The following example uses ASC to calculate a hash value──an index value
    for a table or file──from a string:

    CONST HASHTABSIZE=101

    FUNCTION HashValue(S$,Size) STATIC

        TmpVal=0
        FOR I=1 TO LEN(S$)
        ' Convert the string to a number by summing the values
        ' of individual letters.
        TmpVal=TmpVal+ASC(MID$(S$,I,1))
        NEXT I
        ' Divide the sum by the size of the table.
        HashValue=TmpVal MOD Size

    END FUNCTION

    INPUT "Enter a name: ",Nm$
    PRINT "The hash value is ";HashValue(Nm$,HASHTABSIZE)

■ Output

    Enter a name: Bafflegab
    The hash value is  66

""","ATN Function" to """
■ Action

    Returns the arctangent of a numeric expression (the angle whose tangent is
    equal to the numeric expression)

■ Syntax

    ATN(numeric-expression)

■ Remarks

    The numeric-expression can be of any numeric type.

    The result is given in radians and is in the range -π/2 to π/2 radians,
    where π=3.141593. ATN is evaluated by default in single precision unless
    numeric-expression is a double-precision value. Then ATN is evaluated in
    double precision.

■ Example

    The following example first finds the tangent of π/4 and then takes the
    arctangent of the value. The result is π/4.

    CONST PI=3.141592653

    PRINT ATN(TAN(PI/4.0)), PI/4.0

■ Output

    .78539816325  .78539816325

""","BEEP Statement" to """
■ Action

    Sounds the speaker

■ Syntax

    BEEP

■ Remarks

    The BEEP statement makes a sound through the loudspeaker. This statement
    makes the same sound as the following statement:

    PRINT CHR$(7)

■ Example

    The following example uses BEEP to indicate an error in the response:

    DO
        INPUT "Continue (Y or N)";Response$
        R$=UCASE$ (MID$ (Response$,1,1))
        IF R$="Y" OR R$="N" THEN EXIT DO
        BEEP
    LOOP

""","BLOAD Statement" to """
■ Action

    Loads a memory-image file, created by BSAVE, into memory from an input
    file or device

■ Syntax

    BLOAD filespec «,offset»

■ Remarks

    The BLOAD statement takes the following arguments:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    filespec                 A string expression containing the file
                            specification. Input devices other than the
                            keyboard (KYBD:) are supported.

    offset                   The offset of the address where loading is to
                            start.
    ──────────────────────────────────────────────────────────────────────────

    The BLOAD statement allows a program or data saved as a memory-image file
    to be loaded anywhere in memory. A memory-image file is a byte-for-byte
    copy of what was originally in memory.
""","BSAVE Statement" to """
■ Action

    Transfers the contents of an area of memory to an output file or device

■ Syntax

    BSAVE filespec,offset,length

■ Remarks

    The BSAVE statement has the following arguments:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    filespec                 A string expression containing the file or device
                            name. Output devices other than the console
                            (SCRN: and CONS:) are supported.

    offset                   The offset of the starting address of the area in
                            memory to be saved.

    length                   The number of bytes to save. This is a numeric
                            expression returning an unsigned integer in the
                            range 0-65,535.
    ──────────────────────────────────────────────────────────────────────────

    The BSAVE statement allows data or programs to be saved as memory-image
    files on disk. A memory-image file is a byte-for-byte copy of what is in
    memory along with control information used by BLOAD to load the file.
""","CALL ABSOLUTE Statement" to """
■ Action

    Transfers control to a machine-language procedure

■ Syntax

    CALL ABSOLUTE («argumentlist,»integervariable)

■ Remarks

    The CALL ABSOLUTE statement takes the following arguments:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    argumentlist             Optional arguments passed to a machine-language
                            procedure.

    integervariable          An integer variable containing a value that is
                            the offset from the beginning of the current code
                            segment, set by DEF SEG, to the starting location
                            of the procedure. The integervariable argument is
                            not passed to the procedure. Your program may
                            need to execute a DEF SEG statement before
                            executing CALL ABSOLUTE to set the code segment
                            for the called routine.

                            Using a noninteger value for integervariable
                            produces unpredictable results.
    ──────────────────────────────────────────────────────────────────────────

    Arguments in argumentlist are passed to the machine-language program as
    offsets (near pointers) from the current data segment. Although arguments
    are passed as offsets, the machine-language program is invoked with a far
    call.
""","CALL INT86OLD Statements" to """
■ Action

    Allows programs to perform DOS system calls

■ Syntax

    CALL INT86OLD (int_no,in_array(),out_array())
    CALL INT86XOLD (int_no,in_array(),out_array())

■ Remarks

    The CALL INTERRUPT statement provides an easier way to make DOS system
    calls. See the entry for CALL INTERRUPT for more information. The
    following list describes the arguments to INT86OLD and INT86XOLD:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    int_no                   The DOS interrupt to perform. It is an integer
                            between 0 and 255. See your DOS documentation for
                            the interrupt numbers.

    in_array()               An integer array specifying the register values
                            when the interrupt is performed.

                            INT86OLD uses an eight-element array, while
                            INT86XOLD uses a ten-element array. Table R.1
                            lists the array elements and the corresponding
                            registers.

    out_array()              Contains the postinterrupt register values. It
                            has the same structure as in_array.
    ──────────────────────────────────────────────────────────────────────────

    If an error occurs, int_no = -1 and values in out_array are unchanged.
    Errors are caused by int_no not being in the range 0-255.

    Table R.1   INT86OLD and INT86XOLD Register Values

    Array Element            Register
    ──────────────────────────────────────────────────────────────────────────
    in_array(x)              AX
    in_array(x+1)            BX
    in_array(x+2)            CX
    in_array(x+3)            DX
    in_array(x+4)            BP
    in_array(x+5)            SI
    in_array(x+6)            DI
    in_array(x+7)            FLAGS
    in_array(x+8)☼           DS
    in_array(x+9)☼           ES
    ──────────────────────────────────────────────────────────────────────────

    The INT86OLD and INT86XOLD routines alter all registers except BP and DS.

    INT86OLD and INT86XOLD provide compatibility with older programs using
    INT86 and INT86X. Like the INT86 and INT86X routines, INT86OLD and
    INT86XOLD are distributed in a Quick library (QB.QLB) and in a
    conventional library (QB.LIB) on the distribution disks. The disks also
    contain a header file (QB.BI) for use with the procedures. See the
    disk-contents list for specific information.

    Note that INT86OLD and INT86XOLD do not require the use of VARPTR. Also,
    the register values are stored in the arrays beginning with the first
    array element.

■ Example

    The following example uses INT86OLD to open a file and place some text in
    it:

    ' Include header file for INT86OLD, etc.
    ' ¢INCLUDE:'QB.BI'

    DIM INARY%(7),OUTARY%(7)          'Define input and output
                                    'arrays for INT86.
    '
    ' Define register-array indices to
    ' make program easier to understand.
    CONST AX=0, BX=1, CX=2, DX=3, BP=4, SI=5, DI=6, FL=7
    '
    INARY%(AX) = &H3C00               'DOS function to create a file.
    INARY%(CX) = 0                    'DOS attribute for created file.
    INARY%(DX) = SADD("FOO.TXT"+CHR$(0))
                                    'Pointer to file-name string
                                    'with zero byte termination.

    CALL INT86OLD(&H21,INARY%(),OUTARY%())
                                    'Perform the creation.
    '
    INARY%(BX) = OUTARY%(AX)   'Move created file handle for write.
    INARY%(AX) = &H4000
            'DOS function to write to file.
    TEXT$ = "hello, world"+CHR$(13)+CHR$(10)
                                    'Define text to write to file.

    INARY%(CX) = LEN(TEXT$)       'Get length of text string.
    INARY%(DX) = SADD(TEXT$)      'Get address of text string.
    CALL INT86OLD(&H21,INARY%(),OUTARY%())
                                    'Perform the write.
    '
    INARY%(AX) = &H3E00
            'DOS function to close a file.
    CALL INT86OLD(&H21,INARY%(),OUTARY%())
                                    'Perform the close.

""","CALL INTERRUPT Statements" to """
■ Action

    Allows BASIC programs to perform DOS system calls

■ Syntax

    CALL INTERRUPT (interruptnum,inregs,outregs)
    CALL INTERRUPTX (interruptnum,inregs,outregs)

■ Remarks

    The following list describes the arguments for the CALL INTERRUPT and CALL
    INTERRUPTX statements:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    interruptnum             The DOS interrupt number. It is an integer
                            between 0 and 255. See your DOS documentation for
                            information about interrupts.

    inregs                   The inregs variable contains the register values
                            used when the interrupt is performed. It is
                            declared as type RegType. The user-defined type
                            RegType is described below.

    outregs                  The outregs variable contains the register values
                            after the interrupt is performed. It is declared
                            as type RegType. The user-defined type RegType is
                            described below.
    ──────────────────────────────────────────────────────────────────────────

    The CALL INTERRUPT and CALL INTERRUPTX statements replace the INT86 and
    INT86X routines used in earlier versions of BASIC. They provide a more
    convenient way for BASIC programs to use DOS interrupts and services.

    The register values before and after the interrupt are passed in variables
    declared as type RegType. The following statement defines the RegType
    user-defined type:

    TYPE RegType
        AX AS INTEGER
        BX AS INTEGER
        CX AS INTEGER
        DX AS INTEGER
        BP AS INTEGER
        SI AS INTEGER

    DI AS INTEGER
        FLAGS AS INTEGER
        DS AS INTEGER
        ES AS INTEGER
    END TYPE

    Each element of the type corresponds to a CPU register.

    INTERRUPTX uses the values in the DS and ES registers. To use the current
    values of these registers, set the record elements to -1.

    CALL INTERRUPT and CALL INTERRUPTX are available in a Quick Library
    (QB.QLB) and in a conventional library (QB.LIB) on your distribution
    disks. There is also a header file (QB.BI) on the disks with the necessary
    declarations for using these procedures. See the disk-contents list for
    specific information.

    To use CALL INTERRUPT or CALL INTERRUPTX when running a program within the
    QuickBASIC environment, the Quick library QB.QLB must be loaded with
    QuickBASIC.

■ Example

    The following program uses CALL INTERRUPT to change a file's attribute
    list so the file does not appear when you use the DIR command from DOS:

    DECLARE SUB TestError (AXReg%, flags%)
    ' ¢INCLUDE: 'QB.BI'

    DEFINT A-Z
    DIM InRegs AS RegType, OutRegs AS RegType

    ' Get the file name and action to perform.
    CLS
    PRINT "Hidden File Program": PRINT
    INPUT "Enter file name: ", FileName$
    DO
        INPUT "Hide or unhide (H or U): ", Action$
        Action$ = UCASE$(Action$)
    LOOP WHILE Action$ <> "H" AND Action$ <> "U"

    ' Tack a null (zero) byte onto the end of the string for the
    ' DOS function.
    FileName$ = FileName$ + CHR$(0)

    ' Get the current file attribute.
    ' Current attribute comes back in OutRegs.AX.
    InRegs.ax = &H4300
    InRegs.dx = SADD(FileName$)
    CALL INTERRUPT(&H21, InRegs, OutRegs)
    CALL TestError(OutRegs.ax, OutRegs.flags)

    ' Change the hidden attribute bit in the old attribute value.
    IF Action$ = "U" THEN
        InRegs.cx = OutRegs.cx AND &HFD
    ELSE
        InRegs.cx = OutRegs.cx OR &H2
    END IF

    ' Set AX to indicate the Change Attribute DOS function.
    InRegs.ax = &H4301
    CALL INTERRUPT(&H21, InRegs, OutRegs)
    CALL TestError(OutRegs.ax, OutRegs.flags)

    END
    ' If carry flag set, print error message and end program.
    SUB TestError (AXReg, flags) STATIC
        IF (&H1 AND flags) <> 0 THEN
        ' Get the error number out of AX.
        SELECT CASE AXReg AND &HF
            CASE 2
                PRINT "File not found."
            CASE 3
                PRINT "Path not found."
            CASE 5
                PRINT "Access denied."
            CASE ELSE
                PRINT "Unrecognized error."
        END SELECT
        END
        END IF
    END SUB

""","CDBL Function" to """
■ Action

    Converts a numeric expression to a double-precision number

■ Syntax

    CDBL(numeric-expression)

■ Remarks

    The numeric-expression may be any numeric expression. This function has
    the same effect as assigning the numeric expression to a double-precision
    variable.

    Note that the results of CDBL are no more accurate than the original
    expression. The added digits of precision are not significant unless the
    expression is calculated with double-precision accuracy.

■ Example

    The following example demonstrates how the precision of the numeric
    expression affects the result of using CDBL:

    X = 7/9
    X# = 7/9
    PRINT X
    'Both X# and CDBL(X) will be accurate to only 7 decimal
    'places, because 7/9 is evaluated in single precision.
    PRINT X#
    PRINT CDBL(X)
    'Accurate to 15 decimal places.
    PRINT 7#/9#

■ Output

    .7777778
    .7777777910232544
    .7777777910232544
    .7777777777777778

""","CHAIN Statement" to """
■ Action

    Transfers control from the current program to another program

■ Syntax

    CHAIN filespec

■ Remarks

    The filespec is a string expression that identifies the program to which
    control is passed. The filespec may include a path specification. Programs
    running within the QuickBASIC environment assume a .BAS extension (if no
    extension is given) and cannot chain to executable files (files with a
    .COM or .EXE extension). Programs running outside the QuickBASIC
    environment assume an .EXE extension and cannot chain to QuickBASIC source
    files (files with a .BAS extension).

    You can pass variables between programs using the COMMON statement to set
    up a blank COMMON block. See the entry for COMMON.

    If you are compiling a program outside the QuickBASIC environment, note
    that the BCOM45.LIB library does not support COMMON. There are two ways to
    use COMMON with chained programs outside the environment:

    ■ Use the default (BRUN45.EXE) by compiling the programs using the option
    in the Make EXE dialog box called EXE Requiring BRUN45.EXE.

    ■ Use BRUN45.LIB by compiling from the command line without the /O option.

    The behavior of CHAIN and RUN is almost identical. The principal
    differences are that RUN closes all open files and does not support COMMON
    data blocks.
""","CHDIR Statement" to """
■ Action

    Changes the current default directory for the specified drive

■ Syntax

    CHDIR pathspec

■ Remarks

    The pathspec is a string expression identifying the directory that is to
    become the default directory. The pathspec must have fewer than 64
    characters. It has the following syntax:

    «drive:»«\»directory«\directory»...

    The argument drive: is an optional drive specification. If you omit drive,
    CHDIR changes the default directory on the current drive.

    CHDIR differs from the CHDIR command in DOS in two ways:

    1. The BASIC statement cannot be shortened to CD.

    2. There is no form of the CHDIR statement that returns the current
        directory.
""","CHR$ Function" to """
■ Action

    Returns a one-character string whose ASCII code is the argument

■ Syntax

    CHR$(code)

■ Remarks

    CHR$ is commonly used to send a special character to the screen or
    printer. For example, you can send a form feed (CHR$(12)) to clear the
    screen and return the cursor to the home position.

    CHR$ can also be used to include a double quote (") in a string:

    Msg$=CHR$(34)+"Quoted string"+CHR$(34)

    This line adds a double-quote character to the beginning and the end of
    the string.

■ See Also

    ASC; Appendix A, "Keyboard Scan Codes and ASCII Character Codes"

■ Example

    The following example uses CHR$ to display graphics characters in the
    extended character set:

    DEFINT A-Z
    ' Display two double-sided boxes.
    CALL DBox(5,22,18,40)
    CALL DBox(1,4,4,50)
    END

    ' Subroutine to display boxes on the screen.
    '
    ' Parameters
    '  Urow%, Ucol% : Row and column of upper-left corner.
    '  Lrow%, Lcol% : Row and column of lower-right corner.
    ' Use constants for the extended character set graphic
    ' characters.
    CONST ULEFTC=201, URIGHTC=187, VERTICAL=186, HORIZONTAL=205
    CONST LLEFTC=200, LRIGHTC=188

    SUB DBox (Urow%, Ucol%, Lrow%, Lcol%) STATIC

        ' Draw top of box, starting with the upper left corner.
        LOCATE Urow%, Ucol% : PRINT CHR$(ULEFTC);
        LOCATE ,Ucol%+1 : PRINT STRING$(Lcol%-Ucol%,CHR$(HORIZONTAL));
        LOCATE ,Lcol% : PRINT CHR$(URIGHTC);

        ' Draw the body of the box.
        FOR I=Urow%+1 TO Lrow%-1
        LOCATE I,Ucol% : PRINT CHR$(VERTICAL);
        LOCATE  ,Lcol% : PRINT CHR$(VERTICAL);
        NEXT I

        ' Draw the bottom of the box.
        LOCATE Lrow%, Ucol% : PRINT CHR$(LLEFTC);
        LOCATE ,Ucol%+1 : PRINT STRING$(Lcol%-Ucol%,CHR$(HORIZONTAL));
        LOCATE ,Lcol% : PRINT CHR$(LRIGHTC);

    END SUB

""","CINT Function" to """
■ Action

    Converts a numeric expression to an integer by rounding the expression's
    fractional part

■ Syntax

    CINT(numeric-expression)

■ Remarks

    If numeric-expression is not in the range -32,768 to 32,767, the function
    produces a run-time error message that reads Overflow.

    CINT differs from the FIX and INT functions, which truncate, rather than
    round, the fractional part. See the example for the INT function for an
    illustration of the differences among these functions.

■ See Also

    CDBL, CSNG, FIX, INT

■ Example

    The following example converts an angle in radians to an angle in degrees
    and minutes:

    'Set up constants for converting radians to degrees.
    CONST PI=3.141593, RADTODEG=180./PI
    INPUT "Angle in radians = ",Angle  'Get the angle in radians.
    Angle = Angle * RADTODEG    'Convert radian input to degrees.
    Min = Angle - INT(Angle)    'Get the fractional part.
    'Convert fraction to value between 0 and 60.
    Min = CINT(Min * 60)
    Angle = INT(Angle)          'Get whole number part.
    IF Min = 60 THEN       '60 minutes = 1 degree.
        Angle = Angle + 1
        Min = 0
    END IF
    PRINT "Angle equals" Angle "degrees" Min "minutes"

■ Output

    Angle in radians = 1.5708
    Angle equals 90 degrees 0 minutes

""","CIRCLE Statement" to """
■ Action

    Draws an ellipse or circle with a specified center and radius

■ Syntax

    CIRCLE «STEP» (x,y),radius«,«color»«,«start»«,«end»«,aspect»»»»

■ Remarks

    The following list describes the parts of the CIRCLE statement:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
    STEP                     The STEP option specifies that x and y are
                            offsets relative to the current graphics cursor
                            position.

    x,y                      The x- and y-coordinates for the center of the
    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
    x,y                      The x- and y-coordinates for the center of the
                            circle or ellipse.

    radius                   The radius of the circle or ellipse in the
                            current coordinate system.

    color                    The attribute of the desired color. See the
                            entries for the COLOR and SCREEN statements for
                            more information. The default color is the
                            foreground color.

    start, end               The start and end angles, in radians, for the arc
                            to draw. The start and end arguments are used to
                            draw partial circles or ellipses. The arguments
                            may range in value from -2π radians to 2π
                            radians, where π = appx. 3.141593. The default
                            value for start is 0 radians. The default value
                            for end is 2π radians.

    Part                     Description
    ──────────────────────────────────────────────────────────────────────────

                            If start or end is negative, then CIRCLE draws a
                            radius to that point on the arc and treats the
                            angle it were positive.

                            The start angle can be less than the end angle.
                            If you specify end but not start, the arc is
                            drawn from 2π to end; if you specify start but
                            not end, the statement draws an arc from start to
                            zero.

    aspect                   The aspect ratio, or the ratio of the y-radius to
                            the x-radius. The default value for aspect is the
                            value required to draw a round circle in the
                            screen mode. This value is calculated as follows:

                            4 * (ypixels/xpixels)/3

                            where xpixels by ypixels is the screen
    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
                            where xpixels by ypixels is the screen
                            resolution. For example, in screen mode 1, where
                            the resolution is 320 x 200, the default for
                            aspect is 4 * (200/320)/3, or 5/6.

                            If the aspect ratio is less than one, radius is
                            the x-radius. If aspect is greater than one,
                            radius is equal to the y-radius.
    ──────────────────────────────────────────────────────────────────────────


    To draw a radius to angle 0 (a horizontal line segment to the right), do
    not give the angle as -0; use a very small nonzero value instead as shown:

    ' Draws a pie-shaped one-quarter wedge of a circle:
    SCREEN 2
    CIRCLE (200,100),60,,-.0001,-1.57

    You may omit an argument in the middle of the statement, but you must
    include the argument's commas. In the following statement, the color
    argument has been omitted:

    CIRCLE STEP (150,200),94,,0.0,6.28

    If you omit the last argument, you do not include the commas.

    The last point that CIRCLE references, after drawing, is the center of the
    ellipse or circle. You may use coordinates that are outside the screen or
    viewport.

    You may show coordinates as absolutes, or you may use the STEP option to
    show the position of the center point in relation to the previous point of
    reference. For example, if the previous point of reference is (10,10),
    then the following statement causes a circle to be drawn with radius 75
    and center offset 10 from the current x coordinate and 5 from the current
    y coordinate. The circle's center is (20,15).

    CIRCLE STEP (10,5), 75

■ Example

    The following program first draws a circle with the upper left quarter
    missing. It then uses relative coordinates to position a second circle
    within the missing quarter circle. Finally, it uses a different aspect
    ratio to draw a small ellipse inside the small circle.

    CONST PI=3.141593
    SCREEN 2

    ' Draw a circle with the upper-left quarter missing.
    ' Use negative numbers so radii are drawn.
    CIRCLE (320,100), 200,, -PI, -PI/2

    ' Use relative coordinates to draw a circle within the missing
    ' quarter.
    CIRCLE STEP (-100,-42),100

    ' Draw a small ellipse inside the circle.
    CIRCLE STEP(0,0), 100,,,, 5/25

    ' Display the drawing until a key is pressed.
    LOCATE 25,1 : PRINT "Press any key to end.";
    DO
    LOOP WHILE INKEY$=""

""","CLEAR Statement" to """
■ Action

    Reinitializes all program variables, closes files, and sets the stack size

■ Syntax

    CLEAR «,,stack»

■ Remarks

    The CLEAR statement performs the following actions:

    ■ Closes all files and releases the file buffers

    ■ Clears all COMMON variables

    ■ Sets numeric variables and arrays to zero

    ■ Sets all string variables to null

    ■ Reinitializes the stack and, optionally, changes its size

    The stack parameter sets aside stack space for your program. QuickBASIC
    takes the amount of stack space it requires, adds the number of bytes
    specified by stack, and sets the stack size to the result.
""","CLNG Function" to """
■ Action

    Converts a numeric expression to a long (4-byte) integer by rounding the
    fractional part of the expression

■ Syntax

    CLNG(numeric-expression)

■ Remarks

    If numeric-expression is not in the range -2,147,483,648 to 2,147,483,647,
    the function produces an error message that reads Overflow.

■ Example

    The following example shows how CLNG rounds before converting the number:

    A=32767.45
    B=32767.55
    PRINT CLNG(A); CLNG(B)

■ Output

    32767  32768

""","CLOSE Statement" to """
■ Action

    Concludes I/O to a file or device

■ Syntax

    CLOSE ««#» filenumber «,«#» filenumber»...»

■ Remarks

    The CLOSE statement complements the OPEN statement.

    The filenumber is the number under which the file was opened. A CLOSE
    statement with no arguments closes all open files and devices.

    The association of a file with a file number ends when a CLOSE statement
    is executed. You may then reopen the file using the same or a different
    file number. Once you close a file, you may use that file's number for any
    unopened file.

    A CLOSE for a file or device that was opened for sequential output writes
    the final buffer of output to that file or device.

    CLOSE releases all buffer space associated with the closed file or files.

    The CLEAR, END, RESET, RUN, and SYSTEM statements automatically close all
    files.

■ Example

    See the example for CALL (BASIC).

""","CLS Statement" to """
■ Action

    Clears the screen

■ Syntax

    CLS «{0 | 1 | 2}»

■ Remarks

    There are several ways to use the CLS statement, as described in the
    following list:

    Statement                Description
    ──────────────────────────────────────────────────────────────────────────
    CLS 0                    Clears the screen of all text and graphics.

    CLS 1                    Clears only the graphics viewport if a VIEW
                            statement has been executed. Otherwise, CLS 1
                            clears the entire screen.

    CLS 2                    Clears only the text viewport, leaving the bottom
                            screen line (line 25, 30, 43, or 60 depending on
                            the screen mode) unchanged.

    CLS                      Clears either the graphics viewport or the text
                            viewport. If the graphics viewport is active,
                            then CLS with no argument clears only the
                            viewport. If the graphics viewport is inactive,
                            then CLS clears the text viewport and refreshes
                            the function key display line (the bottom screen
                            line).
    ──────────────────────────────────────────────────────────────────────────

    The CLS statement also returns the cursor to the home position in the top
    left corner of the screen.

■ See Also

    VIEW, VIEW PRINT, WINDOW

■ Example

    The following program draws random circles in a graphics viewport and
    prints in a text viewport. The graphics viewport is cleared after 30
    circles have been drawn. The program clears the text viewport after
    printing to it 45 times.

    RANDOMIZE TIMER
    SCREEN 1
    ' Set up a graphics viewport with a border.
    VIEW (5,5)-(100,80),3,1
    ' Set up a text viewport.
    VIEW PRINT 12 TO 24
    ' Print a message on the screen outside the text viewport.
    LOCATE 25,1 : PRINT "Press any key to stop."
    Count=0

    DO
        ' Draw a circle with a random radius.
        CIRCLE (50,40),INT((35-4)*RND+5),(Count MOD 4)
        ' Clear the graphics viewport every 30 times.
        IF (Count MOD 30)=0 THEN CLS 1
        PRINT "Hello. ";
        ' Clear the text viewport every 45 times.
        IF (Count MOD 45)=0 THEN CLS 2
        Count=Count+1
    LOOP UNTIL INKEY$<>""

""","COLOR Statement" to """
■ Action

    Selects display colors

■ Syntax

    COLOR «foreground»«,«background»«,border»»         Screen mode 0
    COLOR «background»«,palette»                       Screen mode 1
    COLOR «foreground»«,background»                    Screen modes 7-10
    COLOR «foreground»                                 Screen modes 12-13

■ Remarks

    With the COLOR statement, you can set the foreground and background colors
    for the display. In screen mode 0 a border color can also be selected. In
    screen mode 1 no foreground color can be selected, but one of two
    four-color palettes can be selected for use with graphics statements. In
    screen modes 12-13 only the foreground color can be set.

    The values of foreground in screen modes 7-10, 12, and 13 are attribute
    numbers (not color numbers) and display the color assigned to that
    attribute. See the PALETTE statement for a description of attributes.

    The COLOR statement does not determine the range of available colors. The
    combination of adapter, display, and the mode set by the SCREEN statement
    determine the color range. See the SCREEN statement for more information.

    The different syntaxes and their effects in different screen modes are
    described below:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Screen Mode              Description
    ──────────────────────────────────────────────────────────────────────────
    Screen Mode              Description
    ──────────────────────────────────────────────────────────────────────────
    0                        Modifies the current default text foreground and
                            background colors and the screen border. The
                            foreground color must be an integer expression in
                            the range 0-31. It determines the "foreground"
                            color in text mode──the default color of text.
                            Sixteen colors can be selected with the integers
                            0-15. You can select a blinking version of a
                            color by adding 16 to the color number. For
                            example, a blinking color 7 is equal to 7 + 16,
                            or 23.

                            The background color is an integer expression in
                            the range 0-7 and is the color of the background
                            for each text character. Blinking background
                            colors are not supported.

                            The border color──the color used to draw the
                            screen border──is an integer expression in the
                            range 0-15. The IBM Enhanced Graphics Adapter
    Screen Mode              Description
    ──────────────────────────────────────────────────────────────────────────
                            range 0-15. The IBM Enhanced Graphics Adapter
                            (EGA), the IBM Video Graphics Array adapter
                            (VGA), and the IBM Multicolor Graphics Array
                            adapter (MCGA) do not support the border
                            argument.

    1                        In mode 1, the COLOR statement has a unique
                            syntax that includes a palette argument that is
                            an odd or even integer expression in the range 0
                            to 255. This argument determines which of two
                            sets of colors to use when displaying particular
                            color numbers.

                            The default colors for the palette parameter are
                            equivalent to the following PALETTE statements on
                            a system equipped with an EGA:

                            COLOR ,0     'Same as the next three
                                        'PALETTE statements.
    Screen Mode              Description
    ──────────────────────────────────────────────────────────────────────────
                                        'PALETTE statements.
                            PALETTE 1,2  'Attribute 1 = color 2 (green)
                            PALETTE 2,4  'Attribute 2 = color 4 (red)
                            PALETTE 3,6  'Attribute 3 = color 6 (yellow)

                            COLOR ,1     'Same as the next three
                                        'PALETTE statements.
                            PALETTE 1,3  'Attribute 1 = color 3 (cyan)
                            PALETTE 2,5  'Attribute 2 = color 5 (magenta)
                            PALETTE 3,7  'Attribute 3 = color 7 (white)

                            Note that in screen mode 1, a COLOR statement
                            overrides previous PALETTE statements.

    2                        An Illegal function call message results if COLOR
                            is used in this mode.

    7-10                     In these modes, no border color can be specified.
                            The graphics background is given by the
    Screen Mode              Description
    ──────────────────────────────────────────────────────────────────────────
                            The graphics background is given by the
                            background color number, which must be in the
                            range of valid color numbers for the screen mode.
                            The foreground color argument is the default
                            line-drawing color. In screen modes 7 to 10
                            foreground is an attribute number, while
                            background is a color number. See the SCREEN
                            statement for more details.

    11                       Use the PALETTE statement to set color in screen
                            mode 11.

    12, 13                   No background color can be specified in these
                            modes. The foreground argument is the attribute
                            used for the foreground graphics color. The
                            attribute must be in the correct range for the
                            screen mode. See the SCREEN statement for more
                            information.
    ──────────────────────────────────────────────────────────────────────────
    Screen Mode              Description
    ──────────────────────────────────────────────────────────────────────────
    ──────────────────────────────────────────────────────────────────────────


    Arguments that are outside the valid ranges produce error messages that
    read Illegal function call.

    The foreground can be the same color as the background, making displayed
    characters invisible. The default background is black, or color number 0
    for all display hardware configurations and all screen modes.

    In screen modes 12 and 13 you can set the background color by assigning a
    color to attribute 0 with a PALETTE statement. For example, to make the
    background color 8224 (a light violet), you would use the following
    PALETTE statement:

    PALETTE 0,8224

    In screen mode 11 you can set both the foreground and background color by
    assigning a color to attribute 0 with a PALETTE statement.

    With an EGA, VGA, or MCGA installed, the PALETTE statement gives you
    flexibility in assigning different display colors to the actual
    color-number ranges for the foreground, background, and border colors
    discussed above. See the PALETTE statement reference pages for more
    details.

■ See Also

    PAINT, PALETTE, SCREEN

■ Examples

    The following series of examples show COLOR statements and their effects
    in the various screen modes:

    SCREEN 0
    'foreground=1, background=2, border=3
    COLOR  1, 2, 3

    SCREEN 1
    'background=1, even palette number
    COLOR  1,0
    'background=2, odd palette number
    COLOR  2,1

""","COM Statements" to """
■ Action

    Enables, disables, or inhibits event trapping of communications activity
    on a specified port

■ Syntax

    COM(n) ON
    COM(n) OFF
    COM(n) STOP

■ Remarks

    The parameter n is the number of the communications port; n can be either
    1 or 2.

    The COM ON statement enables communications event trapping. If a character
    arrives at a communications port after a COM ON statement, then the
    subroutine specified in the ON COM statement is executed.

    COM OFF disables communications event trapping. No communications trapping
    takes place until another COM ON statement is executed. Events occurring
    while trapping is off are ignored.

    COM STOP inhibits communications event trapping so no trapping takes place
    until a COM ON statement is executed. Events occurring while trapping is
    inhibited are remembered and processed when the next COM ON statement is
    executed.

    See Chapter 6, "Error and Event Trapping," in Programming in BASIC for an
    outline of event trapping.

■ See Also

    ON event

■ Example

    See the event-trapping examples in Chapter 6, "Error and Event Trapping,"
    in Programming in BASIC for an illustration of how to do event trapping.

""","COMMAND$ Function" to """
■ Action

    Returns the command line used to invoke the program

■ Syntax

    COMMAND$

■ Remarks

    The COMMAND$ function returns the complete command line entered after your
    BASIC program name, including optional parameters. COMMAND$ removes all
    leading blanks from the command line and converts all letters to uppercase
    (capital letters). The COMMAND$ function can be used in stand-alone
    executable files or, if you are executing from the QuickBASIC environment,
    by using the /CMD command line option or by selecting Modify COMMAND$ on
    the Run menu.

■ Example

    The Comline subprogram in the following example breaks the command line
    into separate arguments and stores them in an array. Each argument is
    separated from adjoining arguments by one or more blanks or tabs on the
    command line.

    ' Default variable type is integer in this module.
    DEFINT A-Z

    ' Declare the Comline subprogram, as well as the number and
    ' type of its parameters.
    DECLARE SUB Comline(N, A$(),Max)

    DIM A$(1 TO 15)
    ' Get what was typed on the command line.
    CALL Comline(N,A$(),10)
    ' Print out each part of the command line.
    PRINT "Number of arguments = ";N
    PRINT "Arguments are: "
    FOR I=1 TO N : PRINT A$(I) : NEXT I

    ' Subroutine to get command line and split into arguments.
    ' Parameters:  NumArgs : Number of command line args found.
    '              Args$() : Array in which to return arguments.
    '              MaxArgs : Maximum number of arguments array
    '                        can return.

    SUB Comline(NumArgs,Args$(),MaxArgs) STATIC
    CONST TRUE=-1, FALSE=0

        NumArgs=0 : In=FALSE
    ' Get the command line using the COMMAND$ function.
        Cl$=COMMAND$
        L=LEN(Cl$)

    ' Go through the command line a character at a time.
        FOR I=1 TO L
        C$=MID$(Cl$,I,1)
        'Test for character being a blank or a tab.
        IF (C$<>" " AND C$<>CHR$(9)) THEN
        ' Neither blank nor tab.
        ' Test to see if you're already
        ' inside an argument.
            IF NOT In THEN
        ' You've found the start of a new argument.
        ' Test for too many arguments.
                IF NumArgs=MaxArgs THEN EXIT FOR
                NumArgs=NumArgs+1
                In=TRUE
            END IF
        ' Add the character to the current argument.
            Args$(NumArgs)=Args$(NumArgs)+C$
        ELSE
        ' Found a blank or a tab.
        ' Set "Not in an argument" flag to FALSE.
            In=FALSE
        END IF
        NEXT I

    END SUB

    The following is a sample command line and output for a stand-alone
    executable file (assumes program name is arg.exe):

    arg one  two   three    four     five      six

■ Output

    Number of arguments =  6
    Arguments are:
    ONE
    TWO
    THREE
    FOUR
    FIVE
    SIX

""","COMMON Statement" to """
■ Action

    Defines global variables for sharing between modules or for chaining to
    another program

■ Syntax

    COMMON «SHARED»  «/blockname/» variablelist

■ Remarks

    The following list describes the parts of the COMMON statement:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
    SHARED                   An optional attribute indicating that the
                            variables are to be shared with all SUB or
                            FUNCTION procedures in the module. SHARED can
                            eliminate the need for a SHARED statement inside
                            SUB or FUNCTION procedures.

    blockname                A valid BASIC identifier (up to 40 characters)
                            used to identify a group of variables. Use a
                            blockname to share only specific groups of
                            variables. When a blockname is used, the COMMON
                            block is a named COMMON block. When blockname is
                            omitted, the block is a blank COMMON block. Items
                            in a named COMMON block are not preserved across
                            a chain to a new program. See "Using Named
                            COMMON" and "Using COMMON with Chain," below.

    Part                     Description
    ──────────────────────────────────────────────────────────────────────────

    variablelist             A list of variables to be shared between modules
                            or chained-to programs. The same variable may not
                            appear in more than one COMMON statement in a
                            module.
    ──────────────────────────────────────────────────────────────────────────


    A variablelist has the following syntax:

    variable«( )»«AS type»«, variable«( )»«AS type»»...

    The following list describes the parts of a variablelist:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    variable                 Any valid BASIC variable name.

    AS type                  Declares variable to be of type type. The type
                            may be INTEGER, LONG, SINGLE, DOUBLE, STRING, or
                            a user-defined type.
    ──────────────────────────────────────────────────────────────────────────
""","CONST Statement" to """
■ Action

    Declares symbolic constants for use in place of numeric or string values

■ Syntax

    CONST constantname = expression «,constantname = expression»...

■ Remarks

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    constantname             A name following the same rules as a BASIC
                            variable name. You may add to the name a
                            type-declaration character (%, &, !, #, or $) to
                            indicate its type, but this character is not part
                            of the name.

    expression               An expression consisting of literals (such as
                            1.0), other constants, or any of the arithmetic
                            and logical operators except exponentiation (^).
                            You may also use a single literal string such as
                            "Error on input". You cannot use string
                            concatenation, variables, user-defined functions,
                            or intrinsic functions like SIN or CHR$ in
                            expressions assigned to constants.
    ──────────────────────────────────────────────────────────────────────────

    If you use a type-declaration character in the name, you may omit the
    character when the name is used, as shown in the following example:

    CONST MAXDIM% = 250
    .
    .
    .
    DIM AccountNames$(MAXDIM)

    If you omit the type-declaration character, the constant is given a type
    based on the expression in the CONST statement. Strings always yield a
    string constant. With numeric expressions, the expression is evaluated and
    the constant is given the simplest type that can represent the constant.
    For example, if the expression gives a result that can be represented as
    an integer, the constant is given an integer type.
""","COS Function" to """
■ Action

    Returns the cosine of an angle given in radians

■ Syntax

    COS(numeric-expression)

■ Remarks

    The expression, numeric-expression, can be any numeric type.

    By default, the cosine is calculated in single precision. If
    numeric-expression is a double-precision value, the cosine is calculated
    in double precision.

    You can convert an angle measurement from degrees to radians by
    multiplying the degrees by π/180, where π = 3.141593.

■ See Also

    ATN, SIN, TAN

■ Example

    The following program plots the graph of the polar equation r = nq for
    values of n from 0.1-1.1. This program uses the conversion factors x =
    cos(q) and y = sin(q) to change polar coordinates to Cartesian x,y
    coordinates. The figure plotted is sometimes known as the Spiral of
    Archimedes.

    CONST PI = 3.141593
    'Gray background.
    SCREEN 1 : COLOR 7
    'Define window large enough for biggest spiral.
    WINDOW (-4,-6)-(8,2)
    'Draw line from origin to the right.
    LINE (0,0)-(2.2*PI,0),1
    'Draw ten spirals.
    FOR N = 1.1 TO .1 STEP -.1
        'Plot starting point.
        PSET (0,0)
        FOR Angle = 0 TO 2*PI STEP .04
        'Polar equation for spiral.
        R = N * Angle
        'Convert polar coordinates to Cartesian coordinates.
        X = R * COS(Angle)
        Y = R * SIN(Angle)
        'Draw line from previous point to new point.
        LINE -(X,Y),1
        NEXT
    NEXT

""","CSNG Function" to """
■ Action

    Converts a numeric expression to a single-precision value

■ Syntax

    CSNG(numeric-expression)

■ Remarks

    The CSNG function has the same effect as assigning the numeric-expression
    to a single-precision variable.

    CSNG rounds the value, if necessary, before converting it.

■ See Also

    CDBL, CINT

■ Example

    The following example shows how CSNG rounds before converting the value:

    A#=975.3421115#
    B#=975.3421555#
    PRINT A#; CSNG(A#); B#; CSNG(B#)

■ Output

    975.3421115  975.3421  975.3421555  975.3422

""","CSRLIN Function" to """
■ Action

    Returns the current line (row) position of the cursor

■ Syntax

    CSRLIN

■ Remarks

    To return the current column position, use the POS function.

■ See Also

    LOCATE, POS

■ Example

    The following program uses a subprogram that prints a message on the
    screen without disturbing the current cursor position:

    ' Move cursor to center of screen, then print message.
    ' Cursor returned to center of screen.
        LOCATE 12,40
        CALL MsgNoMove("A message not to be missed.",9,35)
        INPUT "Enter anything to end: ",A$

    ' Print a message without disturbing current
    ' cursor position.
    SUB MsgNoMove (Msg$,Row%,Col%) STATIC

        ' Save the current line.
        CurRow%=CSRLIN
        ' Save the current column.
        CurCol%=POS(0)
        ' Print the message at the given position.
        LOCATE Row%,Col% : PRINT Msg$;
        ' Move the cursor back to original position.
        LOCATE CurRow%, CurCol%

    END SUB

""","CVSMBF, CVDMBF Functions" to """
■ Action

    Converts strings containing Microsoft Binary format numbers to IEEE-format
    numbers

■ Syntax

    CVSMBF (4-byte-string)
    CVDMBF (8-byte-string)

■ Remarks

    The CVSMBF and CVDMBF functions allow you to read old random-access files
    containing real numbers stored as strings in Microsoft Binary format.
    These functions convert the string read from the old file to an
    IEEE-format number:

    Function                 Description
    ──────────────────────────────────────────────────────────────────────────
    CVSMBF                   Converts 4-byte-string containing a Microsoft
                            Binary format number to a single-precision
                            IEEE-format number.

    CVDMBF                   Converts 8-byte-string containing a Microsoft
                            Binary format number to a double-precision
                            IEEE-format number.
    ──────────────────────────────────────────────────────────────────────────

    The example below shows you how to read data from an old file by using
    CVSMBF and user-defined types for records. See Appendix B, "Differences
    from Previous Versions of QuickBASIC," in Programming in BASIC for more
    information about converting old data files.

■ See Also

    FIELD; MKSMBF$, MKDMBF$

■ Example

    The following program reads records from a random-access file containing
    Microsoft Binary format real numbers stored as strings. Each record
    contains a student's name and a test score.

    ' Define a user type for the data records.
    TYPE StudentRec
        NameField AS STRING*20
        Score AS STRING*4
    END TYPE

    ' Define a variable of the user type.
    DIM Rec AS StudentRec

    ' Open the file.
    OPEN "TESTDAT.DAT" FOR RANDOM AS #1 LEN=LEN(Rec)

    Max=LOF(1)/LEN(Rec)

    ' Read and print all of the records.
    FOR I=1 TO Max
        ' Read a record into the user-type variable Rec.
        GET #1,I,Rec
        ' Convert the score from a string containing a Microsoft
        ' Binary format number to an IEEE-format number.
        ScoreOut=CVSMBF(Rec.Score)
        ' Display the name and score.
        PRINT Rec.NameField,ScoreOut
    NEXT I

    CLOSE #1

""","CVI, CVS, CVL, CVD Functions" to """
■ Action

    Converts strings containing numeric values to numbers

■ Syntax

    CVI(2-byte-string)
    CVS(4-byte-string)
    CVL(4-byte-string)
    CVD(8-byte-string)

■ Remarks

    CVI, CVS, CVL, and CVD are used with a FIELD statement to read real
    numbers from a random-access file. The functions take strings defined in
    the FIELD statement and convert them to a value of the corresponding
    numeric type. The functions are the inverse of MKI$, MKS$, MKL$, and MKD$:

    Function                 Description
    ──────────────────────────────────────────────────────────────────────────
    CVI                      Converts 2-byte-string created with MKI$ back to
                            an integer.

    CVS                      Converts 4-byte-string created with MKS$ back to
                            a single-precision number.

    CVL                      Converts 4-byte-string created with MKL$ back to
                            a long integer.

    CVD                      Converts 8-byte-string created with MKD$ back to
                            a double-precision number.
    ──────────────────────────────────────────────────────────────────────────
""","DATA Statement" to """
■ Action

    Stores the numeric and string constants used by a program's READ
    statements

■ Syntax

    DATA constant1 «,constant2»...

■ Remarks

    The constant1, constant2, and so on in a DATA statement can be any valid
    numeric or string constant.

    Names of symbolic constants (defined in a CONST statement) appearing in
    DATA statements are interpreted as strings, rather than names of
    constants. For example, in the following program fragment the second data
    item is a string, "PI", and not the value 3.141593:

    CONST PI=3.141593
    .
    .
    .
    DATA 2.20, PI,45,7
    .
    .
    .

    A DATA statement may contain as many constants as will fit on a line. The
    constants are separated by commas. You may use any number of DATA
    statements.
""","DATE$ Function" to """
■ Action

    Returns a string containing the current date

■ Syntax

    DATE$

■ Remarks

    The DATE$ function returns a ten-character string in the form mm-dd-yyyy,
    where mm is the month (01-12), dd is the day (01-31), and yyyy is the year
    (1980-2099).

■ See Also

    DATE$ Statement

■ Example

    Note that the DATE$ function in the following example prints a zero in
    front of the month:

    PRINT DATE$

■ Output

    09-21-88

""","DATE$ Statement" to """
■ Action

    Sets the current date

■ Syntax

    DATE$ = stringexpression

■ Remarks

    The DATE$ statement is the complement of the DATE$ function.

    The stringexpression must have one of the following forms, where mm
    (01-12) and dd (01-31) are the month and day, and yy and yyyy (1980-2099)
    are the year:

    mm-dd-yy
    mm-dd-yyyy
    mm/dd/yy
    mm/dd/yyyy

■ Example

    The following program sets the current date from an input numeric date:

    PRINT "Enter the date below (default year is 1989)."
    INPUT "    Month:   ",Month$
    INPUT "    Date:    ",Day$
    INPUT "    Year:    ",Year$
    IF Year$ = "" THEN Year$ = "89"
    DATE$ = Month$ + "/" + Day$ + "/" + Year$

""","DEF FN Statement" to """
■ Action

    Defines and names a function

■ Syntax 1

    DEF FNname«(parameterlist)» = expression

■ Syntax 2

    DEF FNname«(parameterlist)»
    .
    .
    .
    FNname = expression
    .
    .
    .
    END DEF

■ Remarks

    The DEF FN statement takes the following arguments:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    name                     A legal variable name, up to 40 characters long.
                            This name, combined with FN, is the name of the
    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
                            This name, combined with FN, is the name of the
                            function. The name can include an explicit
                            type-declaration character to indicate the type
                            of value returned. Names that are the same except
                            for the type-declaration character are distinct
                            names. For example, the following are names of
                            three different DEF FN functions:

                            FNString$

                            FNString%

                            FNString#

                            To return a value from a DEF FN function, assign
                            the value to the full function name:

                            FNString$ = "No answer."

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────

    parameterlist            A list of variable names, separated by commas.
                            The syntax is explained below. When the function
                            is called, BASIC assigns the value of each
                            argument to its corresponding parameter. Function
                            arguments are passed by value. DEF FN functions
                            do not accept arrays, records, or fixed-length
                            strings as arguments.

    expression               In both syntaxes, expression is evaluated and the
                            result is the function's value. In Syntax 1,
                            expression is the entire body of the function and
                            is limited to one logical line.

                            When no expression is assigned to the name, the
                            default return values are zero for a numeric DEF
                            FN function, and the null string ("") for a
                            string DEF FN function.
    ──────────────────────────────────────────────────────────────────────────
    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    ──────────────────────────────────────────────────────────────────────────


    A parameterlist has the following syntax:

    variable «AS type» «, variable «AS type»»...

    A variable is any valid BASIC variable name. The type is INTEGER, LONG,
    SINGLE, DOUBLE, or STRING. You may also indicate a variable's type by
    including a type-declaration character (%, &, !, #, or $) in the name.
""","DEF SEG Statement" to """
■ Action

    Sets the current segment address for a subsequent PEEK function or a
    BLOAD, BSAVE, CALL ABSOLUTE, or POKE statement

■ Syntax

    DEF SEG «=address»

■ Remarks

    For BLOAD, BSAVE, CALL ABSOLUTE, PEEK, and POKE, address is used as the
    segment. The address is a numeric expression returning an unsigned integer
    in the range 0-65,535. A value outside this range produces the error
    message Illegal function call. The previous segment is retained if an
    error occurs. If you omit address, the BASIC data segment is used.

    Be sure to separate DEF and SEG with a space. Otherwise, BASIC interprets
    the statement to mean "assign a value to the variable DEFSEG."

■ Differences From Basica

    In QuickBASIC, the CALL and CALLS statements do not use the segment
    address set by DEF SEG.

■ Example

    The following program uses DEF SEG, PEEK, and POKE statements to turn the
    CAPS LOCK on and off:
""","DEFtype Statements" to """
■ Action

    Set the default data type for variables, DEF FN functions, and FUNCTION
    procedures

■ Syntax

    DEFINT letterrange «,letterrange»...
    DEFSNG letterrange «,letterrange»...
    DEFDBL letterrange «,letterrange»...
    DEFLNG letterrange «,letterrange»...
    DEFSTR letterrange «,letterrange»...

■ Remarks

    The letterrange has the form:

    letter1«-letter2»

    where letter1 and letter2 are any of the uppercase or lowercase letters of
    the alphabet. Names beginning with the letters in letterrange have the
    type specified by the last three letters of the statement: integer (INT),
    long integer (LNG), single precision (SNG), double precision (DBL), or
    string (STR). For example, in the following program fragment, Message is a
    string variable:

    DEFSTR A-Q
    .
    .
    .
    Message="Out of stack space."

    The case of the letters in letterrange is not significant. All of the
    following statements are equivalent:

    DEFINT I-N
    DEFINT i-n
    DEFINT i-N

    A type-declaration character (%, &, !, #, or $) always takes precedence
    over a DEFtype statement. DEFtype statements do not affect record
    elements.
""","DIM Statement" to """
■ Action

    Declares a variable and allocates storage space

■ Syntax

    DIM «SHARED» variable«(subscripts)»«AS type»«,variable«(subscripts)»«AStype

■ Remarks

    The following list describes the parts of the DIM statement:

    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
    SHARED                   The optional SHARED attribute allows all
                            procedures in a module to share arrays and simple
                            variables. This differs from the SHARED
                            statement, which affects only variables within a
                            single SUB or FUNCTION.

    variable                 A BASIC variable name.

    subscripts               The dimensions of the array. Multiple dimensions
                            can be declared. The subscript syntax is
                            described below.

    AS type                  Declares variable to be an elementary or
                            user-defined type. The elementary types are
                            INTEGER, LONG, SINGLE, DOUBLE, and STRING
                            (variable or fixed).
    ──────────────────────────────────────────────────────────────────────────

    Subscripts in DIM statements have the following form:

    «lower TO» upper «, «lower TO» upper»...

    The TO keyword provides a way to indicate both the lower and the upper
    bounds of an array's subscripts. The following statements are equivalent
    (if there is no OPTION BASE statement):

    DIM A(8,3)
    DIM A(0 TO 8, 0 TO 3)
    DIM A(8,0 TO 3)

    With the TO keyword, you are no longer restricted to positive subscripts.
    You can use TO to specify any range of subscripts from -32,768 to 32,767:

    DIM A(-4 TO 10)
    DIM B(-99 TO -5,-3 TO 0)

    If you use an array in your program without including the array in a DIM
    statement, the maximum value of each subscript of the array is 10. If you
    use a subscript that is greater than the specified maximum, an error
    message appears that says Subscript out of range.

    The DIM statement initializes all elements of numeric arrays to zero and
    all the elements of string arrays to null strings. The fields of record
    variables are initialized to zero, including fixed-string fields. The
    maximum number of dimensions allowed in a DIM statement is 60.

    If you try to dimension an array variable with a DIM statement after you
    have referred to the array, an error message results that reads Array
    already dimensioned. It is good programming practice to put the required
    DIM statements at the beginning of a program, outside of any loops.

    STATIC AND DYNAMIC ARRAYS

    How you declare an array also determines whether it is static (allocated
    when the program is translated) or dynamic (allocated when the program is
    run).

    ■ An array declared first in a COMMON statement is dynamic.

    ■ Implicitly dimensioned arrays are static.

    ■ Arrays dimensioned with numeric constants or CONST statement constants
    are static.

    ■ Arrays dimensioned with variables as subscripts are dynamic.

    The following list shows the different combinations and results:

    Statement                Result
    ──────────────────────────────────────────────────────────────────────────
    DIM A(0 TO 9)            The array A is allocated as a static array if
                            ¢DYNAMIC is not in effect.

    DIM A(MAXDIM)            If MAXDIM is defined in a CONST statement, A is a
                            static array. If MAXDIM is a variable, then the
                            array is a dynamic array and is only allocated
                            when the program reaches the DIM statement.
    ──────────────────────────────────────────────────────────────────────────

    See Appendix F, "Metacommands," in Programming in BASIC and Chapter 2,
    "Data Types," in this manual for more information about static and dynamic
    arrays.
""","DO...LOOP Statement" to """
■ Action

    Repeats a block of statements while a condition is true or until a
    condition becomes true

■ Syntax 1

    DO «statementblock » LOOP «{WHILE | UNTIL} booleanexpression»

■ Syntax 2

    DO «{WHILE | UNTIL} booleanexpression» «statementblock » LOOP

■ Remarks

    The following list describes the arguments of the DO...LOOP statement:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    statementblock           One or more BASIC statements to be repeated

    booleanexpression        Any expression that evaluates to true (nonzero)
                            or false (zero)
    ──────────────────────────────────────────────────────────────────────────

    You can use a DO...LOOP statement instead of a WHILE...WEND statement. The
    DO...LOOP is more versatile because it can test for a condition at the
    beginning or at the end of a loop.

■ Examples

    The first two examples below show you how placement of the condition
    affects the number of times the block of statements is executed. The third
    example illustrates testing at the end of a loop and presents a sort
    subprogram where an ending test is appropriate.

    In the following example, the test is done at the beginning of the loop.
    Because I is not less than 10, the body of the loop (the statement block)
    is never executed.

    ' DO...LOOP with test at the top of the loop.
    ' Output shows that loop was not executed.
    I = 10
    PRINT "Value of I at beginning of loop is  ";I
    DO WHILE I < 10
        I = I + 1
    LOOP
    PRINT "Value of I at end of loop is  ";I

■ Output

    Value of I at beginning of loop is  10
    Value of I at end of loop is  10

    The following example tests I at the end of the loop, so the statement
    block executes at least once.

    ' DO...LOOP with test at the bottom of the loop.
    ' Output shows loop was executed once.
    I = 10
        DO
        PRINT "Value of I at beginning of loop is  ";I
        I = I + 1
        LOOP WHILE I < 10
        PRINT "Value of I at end of loop is  ";I

■ Output

    Value of I at beginning of loop is  10
    Value of I at end of loop is 11

    The following sort subprogram tests at the end of the loop because the
    entire array must be examined at least once to see if it is in order. In
    general, test at the end of a loop only if you know that you always want
    the statement block executed at least once.

    ' Bubble sort subroutine
    '        Exes is array to sort
    '        N is number of elements in Exes
    '
    '        Note: sort assumes the first element of
    '              Exes is Exes(1).

    ' Set up a special value to indicate no exchanges.
    CONST NOEXCH=-1

    SUB sort(Exes(1),N) STATIC

    Limit=N
    DO

        Exchange=NOEXCH
        FOR I=1 TO Limit-1     ' Make one pass over the array.
        IF Exes(I) > Exes(I+1) THEN
            SWAP Exes(I),Exes(I+1)   'Exchange array elements.
            Exchange=I               'Record location of most
        END IF                      'recent exchange.
        NEXT I
        Limit=Exchange      'Sort on next pass only to where
                            'last exchange was done.
    LOOP UNTIL Exchange=NOEXCH  'Sort until no elements
                                'are exchanged.

    END SUB

""","DRAW Statement" to """
■ Action

    Draws an object defined by stringexpression

■ Syntax

    DRAW stringexpression

■ Remarks

    The DRAW statement combines many of the capabilities of the other graphics
    statements into a graphics macro language, as described below under
    "Cursor-Movement Commands" and "Angle, Color, and Scale-Factor Commands."
    This macro language defines a set of characteristics that can be used to
    describe an image. These characteristics include motion (up, down, left,
    right), color, rotation angle, and scale factor. The stringexpression
    consists of these macro commands.

    CURSOR-MOVEMENT COMMANDS

    The following prefix commands can precede any of the movement commands:

    Prefix                   Description
    ──────────────────────────────────────────────────────────────────────────
    B                        Move, but do not plot any points.
    N                        Move, but return to original position when done.
    ──────────────────────────────────────────────────────────────────────────

    The following commands specify movement in units. The default unit size is
    one point; this unit size can be modified by the S command, which sets the
    scale factor. (S is described in "Angle, Color, and Scale-Factor
    Commands.") If no argument is supplied, the cursor is moved one unit.

    Each of the movement commands initiates movement from the current graphics
    position, which is usually the coordinate of the last graphics point
    plotted with another graphics macro-language command. The current position
    defaults to the center of the screen when a program is run.

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Movement                 Description
    ──────────────────────────────────────────────────────────────────────────
    U «n»                    Move up n units.

    D «n»                    Move down n units.

    L «n»                    Move left n units.

    R «n»                    Move right n units.

    E «n»                    Move diagonally up and right n units.

    F «n»                    Move diagonally down and right n units.

    Movement                 Description
    ──────────────────────────────────────────────────────────────────────────

    G «n»                    Move diagonally down and left n units.

    H «n»                    Move diagonally up and left n units.

    M x,y                    Move absolute or relative. If x is preceded by a
                            plus (+) or minus (-), the movement is relative
                            to the current point; that is, x and y are added
                            to (or subtracted from) the coordinates of the
                            current graphics position and connected with that
                            position by a line.

                            If no sign precedes x, the movement is absolute;
                            that is, a line is drawn from the current cursor
                            position to the point with coordinates x,y.
    ──────────────────────────────────────────────────────────────────────────


    ANGLE, COLOR, AND SCALE-FACTOR COMMANDS

    The following commands let you change the appearance of a drawing by
    rotating it, changing colors, or scaling it:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Command                  Description
    ──────────────────────────────────────────────────────────────────────────
    A n                      Set angle of rotation n. The value of n may range
                            from 0 to 3, where 0 is 0°, 1 is 90°, 2 is 180°,
                            and 3 is 270°. Figures rotated 90° or 270° are
                            scaled so they appear the same size using 0° or
                            180° on a monitor screen with a standard screen
                            width-to-height ratio of 4/3.

    TA n                     Turn an angle of n degrees; n must be in the
                            range -360 to 360. If n is positive, rotation is
                            counterclockwise; if n is negative, rotation is
                            clockwise. The following example uses TA to draw
                            spokes:

                            SCREEN 1
    Command                  Description
    ──────────────────────────────────────────────────────────────────────────
                            SCREEN 1
                            FOR D=0 TO 360  STEP 10
                                DRAW "TA="+VARPTR$(D)+"NU50"
                            NEXT D

    C n                      Set color to n. See COLOR, PALETTE, and SCREEN
                            statements for discussions of valid colors,
                            numbers, and attributes.

    S n                      Set scale factor n, which may range from 1 to
                            255. The scale factor multiplied by the distances
                            given with U, D, L, R, or relative M commands
                            gives the actual distance traveled.

    P paintcolor,            The paintcolor is the paint color for a figure's
    bordercolor              interior, while bordercolor is the paint color
                            for the figure's border. Tile painting (painting
                            an area with a graphic pattern) is not supported
                            in DRAW.
    Command                  Description
    ──────────────────────────────────────────────────────────────────────────
                            in DRAW.

    X stringexpression       Execute substring. This powerful command allows
                            you to execute a second substring from a string.
                            You may have one string expression execute
                            another, which executes a third, and so on.
                            Numeric arguments can be constants like 123 or
                            variable names.
                            QuickBASIC requires the "X" +
                            VARPTR$(stringexpression) form of this command.
                            (See "Differences from BASICA" below.)
    ──────────────────────────────────────────────────────────────────────────


■ Differences From Basica

    The DRAW statement requires modification of BASICA programs when used with
    QuickBASIC. Specifically, the compiler requires the VARPTR$ form for
    variables. Statements such as the following:

    DRAW "XA$"

    DRAW "TA = ANGLE"

    (where A$ and ANGLE are variables) must be changed as follows:

    DRAW "X" + VARPTR$(A$)

    DRAW "TA =" + VARPTR$(ANGLE)

    when using the compiler.

    The compiler does not support the Xstringexpression command. However, you
    may execute a substring by appending the character form of the address to
    X. For example, the following two statements are equivalent. The first
    statement works when within the environment and when using the compiler;
    the second works only within the environment.

    DRAW "X" + VARPTR$(A$)
    DRAW "XA$"

■ Examples

    The following program draws a triangle's outline in magenta and paints the
    interior cyan:

    SCREEN 1
    DRAW "C2"             'Set color to magenta.
    DRAW "F60 L120 E60"   'Draw a triangle.
    DRAW "BD30"           'Move down into the triangle.
    DRAW "P1,2"           'Paint interior.

    The following example shows different ways of using the M macro command:
    with absolute movement and relative movement; using string-variable
    arguments; and using numeric-variable arguments:

    SCREEN 2
    'Absolute movement
    DRAW "M 50,80"
    DRAW "M 80,50"
    'Relative movement
    DRAW "M+40,-20"
    DRAW "M-40,-20"
    DRAW "M-40,+20"
    DRAW "M+40,+20"
    'Using a string variable.
    X$ = "400" : Y$ = "190"
    DRAW "M" + X$ + "," + Y$
    'Using numeric variables (note the two "=" signs).
    A = 300 : B = 120
    DRAW "M="+VARPTR$(A)+",="+VARPTR$(B)

    The following example draws a clock on the screen using the TIME$
    function:

    ' Declare procedure.
    DECLARE SUB Face (Min$)

    ' Select 640 x 200 pixel high-resolution graphics screen.
    SCREEN 2

    DO

        ' Clear the screen.
        CLS

        ' Get the string containing the minutes value.
        Min$ = MID$(TIME$,4,2)

        ' Draw the clock face.
        Face Min$

        ' Wait until the minute changes or a key is pressed.
        DO

        ' Print the time at the top of the screen.
        LOCATE 2,37
        PRINT TIME$

        ' Test for a key press.
        Test$ = INKEY$
        LOOP WHILE Min$ = MID$(TIME$,4,2) AND Test$ = ""

    ' End the program when a key is pressed.
    LOOP WHILE Test$ = ""
    END
    ' Draw the clock face.
    SUB Face (Min$) STATIC
        LOCATE 23,30
        PRINT "Press any key to end"
        CIRCLE (320,100),175

        ' Convert strings to numbers.
        Hr = VAL(TIME$)
        Min = VAL(Min$)

        ' Convert numbers to angles.
        Little = 360 - (30 * Hr + Min/2)
        Big = 360 - (6*Min)

        ' Draw the hands.
        DRAW "TA=" + VARPTR$(Little) + "NU40"
        DRAW "TA=" + VARPTR$(Big) + "NU70"
    END SUB

""","END Statement" to """
■ Action

    Ends a BASIC program, procedure, or block

■ Syntax

    END «{DEF | FUNCTION | IF | SELECT | SUB | TYPE}»

■ Remarks

    There are several ways to use the END statement, as described in the
    following list:

    Statement                Description
    ──────────────────────────────────────────────────────────────────────────
    END DEF                  Ends a multiline DEF FN function definition. You
                            must use END DEF with a multiline DEF FN.

    END FUNCTION             Ends a FUNCTION procedure definition. You must
                            use END FUNCTION with FUNCTION.

    END IF                   Ends a block IF...THEN...ELSE statement. You must
                            use END IF with block IF...THEN...ELSE.

    END SELECT               Ends a SELECT CASE block. You must use END SELECT
                            with a SELECT CASE statement.

    END SUB                  Ends a BASIC subprogram. You must use END SUB
                            with SUB.

    END TYPE                 Ends a user-defined type definition. You must use
                            END TYPE with TYPE.
    ──────────────────────────────────────────────────────────────────────────

    By itself, the END statement stops program execution and closes all files.
    In a stand-alone program, END returns control to the operating system.
    When running inside the QuickBASIC environment, END returns you to that
    environment.

    The compiler always assumes an END statement at the conclusion of any
    program, so omitting an END statement at the end of a program still
    produces proper program termination. You may place END statements anywhere
    in the program to end program execution.

■ See Also

    DEF FN; FUNCTION; IF...THEN...ELSE; SELECT CASE; SUB; TYPE

■ Example

    The following example uses a subprogram to query the user about continuing
    some action. If the user enters n or N the subprogram ends the program.

    DO
    .
    .
    .
    CALL ContinueQuery
    LOOP

    SUB ContinueQuery STATIC
        DO
        INPUT "Continue (Y or N)"; Response$
        R$=UCASE$(LEFT$(Response$,1))
        IF R$="N" THEN END
        IF R$="Y" THEN EXIT DO
        BEEP
        LOOP
    END SUB

""","ENVIRON Statement" to """
■ Action

    Modifies a parameter in the DOS environment-string table

■ Syntax

    ENVIRON stringexpression

■ Remarks

    The stringexpression must be of the form parameterid=text, or the form
    parameterid text. Everything to the left of the equal sign or space is
    assumed to be a parameter, and everything to the right, text.

    If the parameterid has not previously existed in the environment-string
    table, it is appended to the end of the table. If a parameterid exists in
    the table when the ENVIRON statement is executed, it is deleted and the
    new parameterid is appended to the end of the table.

    The text string is the new parameter text. If the text is a null string
    ("") or a semicolon (";"), then the existing parameter is removed from the
    environment-string table and the remaining body of the table is
    compressed.

    DOS discards the environment-string table modified by this function when
    your program ends. The environment-string table is the same as it was
    before your program ran.

    You may use this statement to change the PATH parameter for a "child"
    process (a program or command started by a SHELL statement) or to pass
    parameters to a child by inventing a new environment parameter.

    Errors in environment-string tables include parameters that are not
    strings and lack of free space. An Out of memory error message is printed
    when no more space can be allocated to the environment-string table. The
    amount of free space in the table is usually quite small.

■ See Also

    ENVIRON$, SHELL

■ Example

    The following example changes the value of the PATH environment variable
    to that shown:

    'Change value of PATH environment variable.
    ENVIRON "PATH=A:\SALES;A:\ACCOUNTING"

""","ENVIRON$ Function" to """
■ Action

    Retrieves an environment string from the DOS environment-string table

■ Syntax

    ENVIRON$ (environmentstring)
    ENVIRON$ (n)

■ Remarks

    The environmentstring is a string constant or variable containing the name
    of an environment variable. The argument n is a numeric expression.

    If you specify an environmentstring name, but it cannot be found in the
    environment-string table, or there is no text following it, then ENVIRON$
    returns a null string. Otherwise, ENVIRON$ returns the text following the
    equal sign in the environment-string table.

    If you specify a numeric argument (n), the nth string in the
    environment-string table is returned. In this case, the string includes
    all of the text, including the environmentstring name. If the nth string
    does not exist, ENVIRON$ returns a null string. The n argument can be any
    numeric expression; it is rounded to an integer.

■ Example

    The following example prints the current environment-string table
    settings:

    I = 1
    DO WHILE ENVIRON$(I) <> ""
        PRINT ENVIRON$(I)
        I = I + 1
    LOOP

■ Output

    COMSPEC=C:\COMMAND.COM
    TMP=c:\tmp
    PATH=C:\TOOLS;C:\BIN
    INIT=c:\tools
    LIB=c:\lib
    INCLUDE=c:\include

""","EOF Function" to """
■ Action

    Tests for the end-of-file condition

■ Syntax

    EOF(filenumber)

■ Remarks

    The EOF function returns -1 (true) if the end of a sequential file has
    been reached. Use the EOF function to test for end-of-file while inputting
    data. In this way you may avoid the Input past end error message.

    When EOF is used with random-access or binary files, it returns "true" if
    the last executed GET statement was unable to read an entire record. This
    happens because of an attempt to read beyond the end of the file.

    EOF cannot be used with the BASIC devices SCRN:, KYBD:, CONS:, and LPTn:.

    When you use EOF with a communications device, the definition of the
    end-of-file condition is dependent on the mode (ASCII or binary) in which
    you opened the device. In ASCII mode, EOF is false until you receive
    CTRL+Z, after which it remains true until you close the device. In binary
    mode, EOF is true when the input queue is empty (LOC(n)=0). It becomes
    "false" when the input queue is not empty.

■ Example

    The fragment below reads single-precision values from a file until all
    values have been read:

    DIM M(0 TO 2000)

    OPEN "DATA" FOR INPUT AS 1
    C = 0
    DO WHILE NOT EOF(1) AND C <= 2000
        INPUT #1, M(C)
        C = C+1
    LOOP
    .
    .
    .

""","ERASE Statement" to """
■ Action

    Reinitializes the elements of static arrays; deallocates dynamic arrays

■ Syntax

    ERASE arrayname «,arrayname...»

■ Remarks

    The arrayname arguments are the names of arrays to erase. ERASE has
    different effects on static and dynamic arrays.

    The ERASE statement sets the elements of a static array to zeros in the
    case of a numeric array or null strings ("") in the case of a string
    array. If the array is an array of records, the ERASE statement sets all
    elements of each record to zeros, including fixed-string elements.

    However, using ERASE on a dynamic array frees the memory used by the
    array. Before your program can refer to the dynamic array again, it must
    first redimension the array with a DIM or REDIM statement. Redimensioning
    an array with a DIM statement without first erasing it produces a
    duplicate definition run-time error message that reads Array already
    dimensioned. The ERASE statement is not required when arrays are
    redimensioned with REDIM.

    See Chapter 2, "Data Types," in this manual and Appendix F,
    "Metacommands," in Programming in BASIC for more information on declaring
    dynamic and static arrays.

■ See Also

    DIM, REDIM

■ Example

    The following program fragment shows the use of ERASE with the ¢DYNAMIC
    and ¢STATIC metacommands:

    REM ¢DYNAMIC
    DIM A(100,100)
    .
    .
    .

    'This deallocates array A.
    ERASE A
    'Redimension array A.
    REDIM A(5,5)
    REM ¢STATIC
    DIM B(50,50)
    .
    .
    .
    'This sets all elements of B equal to zero.
    'B still has the dimensions assigned by DIM.
    ERASE B

""","ERDEV, ERDEV$ Functions" to """
■ Action

    Provides device-specific status information after an error

■ Syntax

    ERDEV
    ERDEV$

■ Remarks

    ERDEV is an integer function that returns an error code from the last
    device to declare an error. ERDEV$ is a string function that returns the
    name of the device generating the error. Because ERDEV and ERDEV$ return
    meaningful information only after an error, they are usually used in error
    handlers specified by an ON ERROR statement.

    ERDEV and ERDEV$ cannot be used on the left side of an assignment.

    ERDEV is set by the critical error handler (interrupt 24H) when DOS
    detects an error that prevents continuing.

    The value of ERDEV is a bit-encoded value containing the DOS error
    information. The lower eight bits (first byte) contain the DOS error code,
    a value from 0 to 12. The upper eight bits (second byte) contain bits 15,
    14, 13, XX, 3, 2, 1, and 0, in that order, of the device-attribute word.
    XX indicates the bit is always zero. See the Microsoft MS-DOS Programmer's
    Reference for more information about device-attribute words.

■ See Also

    ERR, ERL; ON ERROR

■ Example

    The following example prints the values of ERDEV and ERDEV$ when an error
    occurs:

    DEFINT A-Z

    ' Indicate first line of error handler.
    ON ERROR GO TO ErrorHandler

    ' Attempt to open the file.
    OPEN "A:JUNK.DAT" FOR INPUT AS #1

    END

    ' Error handling routine.
    ' Prints values of ERDEV and ERDEV$ and dies.

    ErrorHandler:
        PRINT "ERDEV value is ";ERDEV
        PRINT "Device name is ";ERDEV$
        ON ERROR GOTO 0

■ Output

    Running the program with drive A unlatched produces the following output
    (2 is the error code for "Drive not ready"):

    ERDEV value is  2
    Device name is A:

""","ERR, ERL Functions" to """
■ Action

    Return error status

■ Syntax

    ERR
    ERL

■ Remarks

    After an error, the function ERR returns the code for the error, and the
    ERL function returns the line number where the error occurred. Because ERR
    and ERL return meaningful values only after an error, they are usually
    used in error-handling routines to determine the error and the corrective
    action.

    Because ERL and ERR are functions, you cannot use them on the left-hand
    side of an assignment statement. However, you may indirectly set them with
    the ERROR statement.

■ Differences From Basica

    The ERL function returns only the line number, not line label, located
    before the line producing the error. If your program has no line numbers,
    ERL always returns 0.

■ See Also

    ERDEV, ERROR, ON ERROR, RESUME

■ Example

    See the example for ON ERROR.

""","ERROR Statement" to """
■ Action

    Simulates the occurrence of a BASIC error or allows the user to define
    error codes

■ Syntax

    ERROR integerexpression

■ Remarks

    The integerexpression represents the error code. It must be greater than 0
    and less than or equal to 255. If the integerexpression is an error code
    already used by BASIC, then the ERROR statement simulates the occurrence
    of that error and prints the corresponding error message.

    To define your own error code, use a value that is greater than any used
    by the standard BASIC error codes. (Start at 255 and work down to maintain
    compatibility with future Microsoft BASIC error codes.)

    If an ERROR statement specifies a code for which no error message has been
    defined, the message Unprintable error is printed. Executing an ERROR
    statement for which there is no error-handling routine causes an error
    message to be printed and execution to halt.

■ See Also

    ERR, ERL; ON ERROR; RESUME

■ Example

    The following fragment uses an ERROR statement to trap a user input error:

    ON ERROR GOTO Handler
    OpenFile:
        INPUT "Name of file to update";FileSpec$
        IF FileSpec$ = "" THEN END
        OPEN FileSpec$ FOR INPUT AS #1
        PRINT "The first five lines of ";FILESPEC$;" are:" : PRINT
        FOR I = 1 TO 5
            LINE INPUT #1, Temp$
            PRINT Temp$
        NEXT
        PRINT : INPUT "Is this the correct file";R$
        'Define error 200.
        IF LEFT$(R$,1) <> "y" THEN ERROR 200
        .
        .
        .
        END

    Handler:        'Error-handling routine.
        Number = ERR
        'Run-time error for "file not found."
        IF Number = 53 THEN
            CLOSE #1
            PRINT "File not in this directory"
            PRINT "Enter new file spec ([d:]xxx...xxx) or"
            PRINT "press <RETURN> to end program"
            RESUME OpenFile
        ELSEIF Number = 200 THEN
    'User entered "n"
            CLOSE #1
            RESUME OpenFile
        ELSE
            ERROR Number       'Error other than 53 or 200.
            ON ERROR GOTO 0    'Print message, disable error
        END IF                 'handling, and stop program.

■ Output

    Name of file to update? c:novelallenadv.txt
    File not in this directory
    Enter new file spec ([d:]xxx...xxx) or
    press <RETURN> to end program
    Name of file to update? c:toryallenadv.txt
    The first five lines of c:toryallenadv.txt are:

    Allen gripped the microphone. Small beads
    of perspiration glistened on his forehead
    like cheap pearls. He knew that what he
    said would change his life and the lives
    of those he loved. In a trembling voice,

    Is this the correct file? y

""","EXIT Statement" to """
■ Action

    Exits a DEF FN function, DO...LOOP or FOR...NEXT loop, FUNCTION, or SUB

■ Syntax

    EXIT {DEF | DO | FOR | FUNCTION | SUB }

■ Remarks

    There are several ways to use the EXIT statement as described in the
    following list:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Statement                Description
    ──────────────────────────────────────────────────────────────────────────
    EXIT DEF                 Causes an immediate exit from the executing DEF
                            FN function. Program execution continues where
                            the DEF FN function was invoked.

    EXIT DO                  Provides an alternative exit from a DO...LOOP.
                            Can be used only inside a DO...LOOP statement;
                            EXIT DO transfers control to the statement
                            following the LOOP statement. When used within
                            nested DO...LOOP statements, transfers out of the
                            immediately enclosing loop.

    Statement                Description
    ──────────────────────────────────────────────────────────────────────────

    EXIT FOR                 Provides another way to exit a FOR...NEXT loop.
                            May appear only in a FOR...NEXT loop; transfers
                            control to the statement following the NEXT
                            statement. When used within nested FOR...NEXT
                            loops, transfers out of the immediately enclosing
                            loop.

    EXIT FUNCTION            Causes an immediate exit from a FUNCTION
                            procedure. Program execution continues where the
                            FUNCTION was invoked. Can only be used in a
                            FUNCTION procedure.

    EXIT SUB                 Immediately exits a SUB procedure. Program
                            execution continues with the statement after the
                            CALL statement. Can only be used in a SUB
                            procedure.
    ──────────────────────────────────────────────────────────────────────────

    Statement                Description
    ──────────────────────────────────────────────────────────────────────────


    None of the EXIT statements define the end of the structure in which they
    are used. EXIT statements only provide an alternative exit from the
    structure.

■ See Also

    DEF FN; DO...LOOP; FOR...NEXT; FUNCTION; SUB

■ Examples

    See the third example for STATIC for a use of EXIT SUB.

    The following subprogram is an extended RTRIM$ that removes trailing
    blanks, tabs, carriage returns, and line feeds from a string. The
    subprogram begins looking at the end of the string and uses EXIT FOR to
    jump out of the loop when the first printing character is found.

    ' Rtrim removes trailing blanks, tabs, carriage returns,
    ' and line feeds from a string.
    SUB Rtrim(S$) STATIC

    J=0

    ' Begin at the end of the string and find the first
    ' character that isn't a blank, tab, carriage return, or
    ' line feed.
    FOR I=LEN(S$) TO 1 STEP -1
        C$=MID$(S$,I,1)
        IF C$<>" " AND C$<>CHR$(9) AND C$<>CHR$(10) AND C$<>CHR$(13) THEN
        J=I
        EXIT FOR
        END IF
    NEXT I

    ' Remove the unwanted trailing characters.
    S$=LEFT$(S$,J)

    END SUB

""","EXP Function" to """
■ Action

    Calculates the exponential function

■ Syntax

    EXP(x)

■ Remarks

    The EXP function returns e (the base of natural logarithms) to the power
    of x. The exponent x must be less than or equal to 88.02969. A value of x
    greater than 88.02969 produces an Overflow error message.

    The calculation of EXP is performed in single precision by default; if the
    argument x is double precision, EXP is calculated in double precision.

■ See Also

    LOG

■ Example

    The following program uses the EXP function to calculate the growth of a
    bacterial colony over a 15-day period. Since the growth of the population
    is related to its ever-changing size, its growth is exponential.

    INPUT "Initial bacterial population"; Colony0
    INPUT "Growth rate per day as a percentage of population"; Rate
    R = Rate/100 : Form$="##          ###,###"
    PRINT : PRINT "Day        Population"
    FOR T = 0 TO 15 STEP 5
        PRINT USING Form$; T, Colony0 * EXP(R*T)
    NEXT

■ Output

    Initial bacterial population? 10000
    Growth rate per day as a percentage of population? 10

    Day        Population
    0           10,000
    5           16,487
    10           27,183
    15           44,817

""","FIELD Statement" to """
■ Action

    Allocates space for variables in a random-access file buffer

■ Syntax

    FIELD «#»filenumber, fieldwidth AS stringvariable...

■ Remarks

    The following list describes the FIELD statement's arguments:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    filenumber               The number used in the file's OPEN statement

    fieldwidth               The width of the field in the record

    stringvariable           The string variable that contains the date read
                            from a record or data that is used in an
                            assignment when information is written to a
                            record
    ──────────────────────────────────────────────────────────────────────────

    The total number of bytes that you allocate in a FIELD statement must not
    exceed the record length that you had specified when opening the file.
    Otherwise, an error message is generated that reads FIELD overflow. (The
    default record length is 128 bytes.)

    Any number of FIELD statements may be executed for the same file. All
    FIELD statements that have been executed remain in effect at the same
    time.

    All field definitions for a file are removed when the file is closed; that
    is, all strings defined as fields associated with the file are set to
    null.

    Do not use a variable name defined as a field in an INPUT or assignment
    statement if you wish the variable to remain a field. Once a variable name
    is a field, it points to the correct place in the random-access file
    buffer. If a subsequent INPUT or assignment statement with that variable
    name is executed, the variable's pointer no longer refers to the
    random-access record buffer, but to string space.
""","FILEATTR Function" to """
■ Action

    Returns information about an open file

■ Syntax

    FILEATTR(filenumber,attribute)

■ Remarks

    The FILEATTR function takes the following arguments:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    filenumber               The number of an open file. This is the same
                            number used in the OPEN statement. You can use a
                            numeric expression as long as it evaluates to the
                            number of an open file.

    attribute                Indicates the type of information to return. When
                            attribute is 1, FILEATTR returns a code
                            indicating a file's mode (see below). When
                            attribute is 2, FILEATTR returns the file's DOS
                            file handle.
    ──────────────────────────────────────────────────────────────────────────

    Table R.2 lists the return values and corresponding file modes when
    attribute is 1.

    Table R.2   FILEATTR Mode Codes

    Return Value             Mode
    ──────────────────────────────────────────────────────────────────────────
    1                        INPUT

    2                        OUTPUT

    4                        RANDOM

    8                        APPEND

    32                       BINARY
    ──────────────────────────────────────────────────────────────────────────

■ See Also

    OPEN

■ Example

    The following example opens two files and prints out the DOS file handles
    and modes returned by FILEATTR:


    OPEN "tempfile.dat" FOR APPEND AS #1
    OPEN "tempfl2.dat" FOR RANDOM AS #2

    PRINT "Number Handle Mode"
    PRINT TAB(2);1;TAB(10);FILEATTR(1,2);TAB(15);FILEATTR(1,1)
    PRINT TAB(2);2;TAB(10);FILEATTR(2,2);TAB(15);FILEATTR(2,1)
    END

■ Output

    Number Handle Mode
    1       5    8
    2       6    4

""","FILES Statement" to """
■ Action

    Prints the names of files residing on the specified disk

■ Syntax

    FILES «filespec»

■ Remarks

    The filespec is a string variable or constant that includes either a file
    name or a path name, and an optional device designation.

    If you omit filespec, the FILES statement lists all the files in the
    current directory. You may use the DOS wild card characters──question
    marks (?) or asterisks (*). A question mark matches any single character
    in the file name or extension. An asterisk matches one or more characters
    starting at that position.

    If you use a filespec without an explicit path, the current directory is
    the default.

    Note that, regardless of the path name contained in filespec, the header
    printed by FILES is always the current directory.

■ Examples

    The following statements illustrate the use of FILES:

    FILES              'Shows all files on the current directory.

    FILES "*.BAS"      'Shows all files with the extension .BAS.

    FILES "B:*.*"      'Shows all files on drive B.

    FILES "B:"         'Equivalent to "B:*.*".

    FILES "TEST?.BAS"  'Shows all five-letter files whose names
                        'start with "TEST" and end with the .BAS
                        'extension.

    FILES "\SALES"     'If SALES is a directory, this statement
                        'displays all files in SALES; if SALES is
                        'a file in the current directory, this
                        'statement displays the name SALES.

""","FIX Function" to """
■ Action

    Returns the truncated integer part of x

■ Syntax

    FIX(x)

■ Remarks

    The x is a numeric expression. FIX(x) is equivalent to SGN(x)*INT(ABS(x)).
    The difference between FIX and INT is that for negative x, FIX returns the
    first negative integer greater than x, while INT returns the first
    negative integer less than x.

■ See Also

    CINT, INT

■ Example

    The following four statements illustrate the differences between INT and
    FIX:


    PRINT INT(-99.8)
    PRINT FIX(-99.8)
    PRINT INT(-99.2)
    PRINT FIX(-99.2)

■ Output

    -100
    -99
    -100
    -99

""","FOR...NEXT Statement" to """
■ Action

    Repeats a group of instructions a specified number of times

■ Syntax

    FOR counter = start TO end «STEP increment»
    .
    .
    .
    NEXT «counter «,counter...»»

■ Remarks

    The FOR statement takes the following arguments:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    counter                  A numeric variable used as the loop counter. The
                            variable cannot be an array element or a record
                            element.

    start                    The initial value of the counter.

    end                      The final value of the counter.

    increment                The amount the counter is incremented each time
                            through the loop. If you do not specify STEP,
                            increment defaults to one.
    ──────────────────────────────────────────────────────────────────────────

    A FOR...NEXT loop executes only if start and end are consistent with
    increment. If end is greater than start, increment must be positive. If
    end is less than start, increment must be negative. This is checked at
    run-time by comparing the sign of (end - start) with the sign of step. If
    both have the same sign, the FOR...NEXT loop is entered. If not, the
    entire loop is skipped over.

    Within the FOR...NEXT loop, the program lines following the FOR statement
    are executed until the NEXT statement is encountered. Then counter is
    changed by the amount specified by STEP, and compared with the final
    value, end.

    If counter is less than or equal to end, control returns to the statement
    after the FOR statement and the process repeats. If counter is greater
    than end, the loop is exited; execution continues with the statement
    following the NEXT statement. (If STEP is negative, the loop repeats until
    counter is less than end.)

    If start and end have the same value, the loop executes once, regardless
    of the value of STEP. If STEP is zero, the loop repeats indefinitely.

    Avoid changing the value of counter within the loop. Changing the loop
    counter is poor programming practice; it makes the program more difficult
    to read and debug.

    You can nest FOR...NEXT loops; that is, you can place a FOR...NEXT loop
    within another FOR...NEXT loop. To ensure that nested loops work properly,
    give each loop a unique variable name as its counter. The NEXT statement
    for the inside loop must appear before the NEXT statement for the outside
    loop. The following construction is correct:

    FOR I = 1 TO 10
        FOR J = 1 TO 10
        FOR K = 1 TO 10
        .
        .
        .
        NEXT K
        NEXT J
    NEXT I

    A NEXT statement with the form

    NEXT K, J, I

    is equivalent to the following sequence of statements:

    NEXT K
    NEXT J
    NEXT I

    The EXIT FOR statement is a convenient alternative exit from FOR...NEXT
    loops. See the EXIT FOR statement.
""","FRE Function" to """
■ Action

    Returns the amount of available memory

■ Syntax 1

    FRE(numeric-expression)

■ Syntax 2

    FRE(stringexpression)

■ Remarks

    The FRE function returns the following values when it has a numeric
    argument (numeric-expression):

    Argument                 Value Returned
    ──────────────────────────────────────────────────────────────────────────
    -1                       The size, in bytes, of the largest nonstring
                            array that could be dimensioned

    -2                       The amount, in bytes, of unused stack space
                            available to the program

    Any other numeric value  The size of the next free block of string storage
    ──────────────────────────────────────────────────────────────────────────

    When the argument is a string expression (stringexpression), FRE returns
    the size, in bytes, of the free string storage. Before FRE returns the
    number of free bytes, it compacts the free string storage into a single
    block.
""","FREEFILE Function" to """
■ Action

    Returns the next free BASIC file number

■ Syntax

    FREEFILE

■ Remarks

    The FREEFILE function returns the next valid unused file number.

    You can use this function to avoid having SUB or FUNCTION procedures use
    file numbers that are already in use.

■ Example

    The example below uses FREEFILE to obtain a file number for opening a
    file:

    INPUT "Enter file name ", Filename$
    Filenum = FREEFILE
    OPEN Filename$ for Input as Filenum
    PRINT Filename$;" Opened as File # "; Filenum

■ Output

    Enter file name: Data.dat

    Data.dat Opened as File # 1

""","FUNCTION Statement" to """
■ Action

    Declares the name, the parameters, and the code that form the body of a
    FUNCTION procedure

■ Syntax

    FUNCTION name «(parameterlist)»«STATIC»
    .
    .
    .
    name = expression
    .
    .
    .
    END FUNCTION

■ Remarks

    The following list describes the parts of the FUNCTION statement:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Part                     Description
    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
    name                     The name of the function. FUNCTION names follow
                            the same rules as BASIC variable names and can
                            include a type-declaration character (%, &, !, #,
                            or $). Note that the type of the name determines
                            the type of value the function returns. For
                            example, to create a function that returns a
                            string, you would include a dollar sign in the
                            name or give it a name defined as a string name
                            by a DEFSTR statement.

    parameterlist            The list of variables, separated by commas,
                            passed to the FUNCTION. The parameters are passed
                            by reference, so any change to a parameter's
                            value inside the function changes its value in
                            the calling program.

    STATIC                   Indicates that the function's local variables are
                            to be saved between calls. Without STATIC, the
                            local variables are allocated each time the
    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
                            local variables are allocated each time the
                            function is invoked, and the variables' values
                            are lost when the function returns to the calling
                            program. The STATIC attribute does not affect
                            variables that are used in a FUNCTION but
                            declared outside the FUNCTION in DIM or COMMON
                            statements by use of the SHARED attribute.

    expression               The return value of the function. A FUNCTION
                            returns a value by assigning a value to the
                            function name. If no value is assigned to the
                            FUNCTION name, the FUNCTION returns a default
                            value: a numeric function returns a value of
                            zero, and a string function returns the null
                            string ("").
    ──────────────────────────────────────────────────────────────────────────


    A parameterlist has the following syntax:
    variable«( )»« AS type»«, variable«( )»« AS type»...»

    A variable is any valid BASIC variable. The optional type can be either
    INTEGER, LONG, SINGLE, DOUBLE, STRING, or a user-defined type.

    Earlier versions of BASIC required the number of dimensions in parentheses
    after an array name. The number of dimensions is no longer required. Only
    the parentheses are required to indicate the parameter is an array. For
    example, the following statement indicates that both Keywords$ and
    KeywordTypes are arrays:

    FUNCTION ParseLine(Keywords$(),KeywordTypes())

    A FUNCTION procedure is like a SUB procedure: it can accept parameters,
    perform a series of statements, and change the values of its parameters.
    Unlike a SUB, a FUNCTION is used in an expression in the same manner as a
    BASIC intrinsic function.

    Like SUB procedures, FUNCTION procedures use local variables. Any variable
    not in the parameter list is local to the FUNCTION unless it is declared
    as a shared variable in a SHARED statement, or unless the variable appears
    in a DIM or COMMON statement with the SHARED attribute.

    To return a value from a function, assign the value to the function name.
    For example, in a function named BinarySearch, you might assign the value
    of the constant FALSE to the name to indicate the value was not found:

    FUNCTION BinarySearch(...)
    CONST FALSE=0
    .
    .
    .

    ' Value not found. Return a value of FALSE.

        IF Lower>Upper THEN
        BinarySearch=FALSE
        EXIT FUNCTION
        END IF
    .
    .
    .
    END FUNCTION

    Using the STATIC keyword slightly increases execution speed. STATIC is not
    usually used with recursive FUNCTION procedures. See the examples below.

    The EXIT FUNCTION statement provides an alternative exit from a FUNCTION.
    See the EXIT statement.

    Because BASIC may rearrange arithmetic expressions to attain greater
    efficiency, avoid using FUNCTION procedures that change program variables
    in arithmetic expressions. Also avoid using FUNCTION procedures that
    perform I/O in I/O statements.

    QuickBASIC FUNCTION procedures are recursive──they can call themselves to
    perform a given task. See the second example below and Chapter 4,
    "Programs and Modules."

■ See Also

    DECLARE (BASIC), DEF FN, EXIT, STATIC, SUB

■ Examples

    The following example uses a function to count the number of vowels in a
    string:

    ' Function definition.
    FUNCTION NumVowels (A$) STATIC
        Num = 0
        ' Go through A$ a character at a time.
        FOR I = 1 TO LEN (A$)
        C$ = UCASE$ (MID$(A$,I,1))
        IF INSTR ("AEIOU",C$)<> 0 THEN
            ' Find a vowel--count it.
            Num = Num + 1
        END IF
        NEXT I
        NumVowels = Num
    END FUNCTION

    A$ = "The ultimate answer to the ultimate question is 42"
    PRINT CHR$(34)+A$+CHR$(34)
    PRINT "The number of vowels in the string is :";NumVowels (A$)

■ Output

    "The ultimate answer to the ultimate question is 42"
    The number of vowels in the string is : 18

    The following example uses a recursive function (a function that calls
    itself) to find the length of a string. Notice that the STATIC keyword is
    not used.

    FUNCTION StrLen(X$)
        IF X$ = "" THEN
        ' The length of a null string is zero.
        StrLen=0
        ELSE
        ' Non-null string--make a recursive call.
        ' The length of a non-null string is 1
        ' plus the length of the rest of the string.
        StrLen=1+StrLen(MID$(X$,2))
        END IF
    END FUNCTION

    LINE INPUT "Enter a string: ",InString$
    PRINT "The string length is"; StrLen(InString$)

■ Output

    Enter a string: Once upon a time
    The string length is 16

""","GET Statement──File I/O" to """
■ Action

    Reads from a disk file into a random-access buffer or variable

■ Syntax

    GET «#»filenumber«,«recordnumber»«,variable»»

■ Remarks

    The following list describes the GET statement's arguments:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    filenumber               The number used in the OPEN statement to open the
                            file.

    recordnumber             For random-access files, the number of the record
                            to be read. For binary-mode files, the byte
                            position in the file where reading starts. The
                            first record or byte position in a file is 1. If
                            you omit recordnumber, the next record or byte
                            (the one after the last GET or PUT, or the one
                            pointed to by the last SEEK) is read into the
                            buffer. The largest possible record number is
                            2^31-1, or 2,147,483,647.
    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
                            2^31-1, or 2,147,483,647.

    variable                 The variable used to receive input from the file.
                            If you use a variable, you do not need to use
                            CVD, CVL, CVI, or CVS to convert record fields to
                            numbers. You may not use a FIELD statement with
                            the file if you use the variable argument.

                            For random-access files, you can use any variable
                            as long as the length of the variable is less
                            than or equal to the length of the record.
                            Usually, a record variable defined to match the
                            fields in a data record is used. For binary-mode
                            files, you can use any variable. The GET
                            statement reads as many bytes as there are in the
                            variable.

                            When you use a variable-length string variable,
                            the statement reads as many bytes as there are
    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
                            the statement reads as many bytes as there are
                            characters in the string's value. For example,
                            the following two statements read 10 bytes from
                            file number 1:

                            VarStrings$=STRING$ (10, " ")

                            GET #1,,VarString$

                            See the examples and Chapter 3, "File and Device
                            I/O," in Programming in BASIC for more
                            information about using variables rather than
                            FIELD statements for random-access files. A
                            record cannot be longer than 32,767 bytes.
    ──────────────────────────────────────────────────────────────────────────


    You may omit the recordnumber, the variable, or both. If you omit the
    recordnumber but include the variable, you must still include the commas:

    GET #4,,FileBuffer

    If you omit both arguments, you do not include the commas:

    GET #4

    The GET and PUT statements allow fixed-length input and output for BASIC
    communications files. Use GET carefully because if there is a
    communications failure, GET waits indefinitely for recordnumber
    characters.
""","GET Statement──Graphics" to """
■ Action

    Stores graphic images from the screen

■ Syntax

    GET «STEP»(x1,y1) - «STEP»(x2,y2),arrayname«(indices)»

■ Remarks

    The list below describes the parts of the GET statement:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
    x1,y1,x2,y2              Coordinates marking a rectangular area on the
                            screen. The placeholders x1, y1, x2, and y2 are
                            numeric expressions that are the coordinates of
                            diagonally opposite corners of the rectangle.

    STEP                     Keyword indicating that coordinates are relative
                            to the most recently plotted point. For example,
                            if the last point plotted were (10,10), then the
                            actual coordinates referred to by STEP (5,10)
                            would be (5+10,10+10) or (15,20). If the second
                            coordinate pair in a GET statement has a STEP
                            argument, it is relative to the first coordinate
    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
                            argument, it is relative to the first coordinate
                            pair in the statement.

    arrayname                Name assigned to the array that holds the image.
                            This array can be of any numeric type; its
                            dimensions must be large enough to hold the
                            entire image.

    indices                  Numeric constants or variables indicating the
                            element of the array where the saved image
                            starts.
    ──────────────────────────────────────────────────────────────────────────


    The GET statement transfers a screen image into the array specified by
    arrayname. The PUT statement, associated with GET, transfers the image
    stored in the array onto the screen.

    The following formula gives the required size of the array in bytes:

    4 + INT(((x2 - x1 + 1) * (bits-per-pixel-per-plane) + 7)/8) * planes *
    ((y2 - y1) + 1)

    The bits-per-pixel-per-plane and planes values depend on the specification
    set in the SCREEN statement. Table R.3 shows the number of bits per pixel
    per plane and the number of planes for each screen mode.

    Table R.3   Values for Bits per Pixel per Plane and for Planes

╓┌─┌────────────────────────┌───────────────────────┌────────────────────────╖
                            Bits per Pixel
    Screen Mode              per Plane               Planes
    ──────────────────────────────────────────────────────────────────────────
    1                        2                       1

    2                        1                       1

    7                        1                       4

    8                        1                       4
                            Bits per Pixel
    Screen Mode              per Plane               Planes
    ──────────────────────────────────────────────────────────────────────────
    8                        1                       4

    9                        1                       2 (if 64K of EGA memory)

                                                    4 (if > 64K EGA memory)

    10                       1                       2

    11                       1                       1

    12                       1                       4

    13                       8                       1
    ──────────────────────────────────────────────────────────────────────────


    The bytes per element of an array are as follows:

    ■ Two bytes for an integer array element

    ■ Four bytes for a long-integer array element

    ■ Four bytes for a single-precision array element

    ■ Eight bytes for a double-precision array element

    For example, suppose you wanted to use the GET statement to store an image
    in high resolution (SCREEN 2). If the coordinates of the upper-left corner
    of the image are (0,0), and the coordinates of the lower- right corner are
    (32,32), then the required size of the array in bytes is 4 + INT((33 * 1 +
    7)/8) * 1 * (33), or 169. This means an integer array with 85 elements
    would be large enough to hold the image.

    Unless the array type is integer or long, the contents of an array after a
    GET appear meaningless when inspected directly. Examining or manipulating
    noninteger arrays containing graphics images may cause run-time errors.

    One of the most useful things that can be done with GET and PUT is
    animation. See Chapter 5, "Graphics," in Programming in BASIC for a
    discussion of animation.

■ See Also

    PUT (Graphics)

■ Example

    See the example for BSAVE.

""","GOSUB...RETURN Statements" to """
■ Action

    Branches to, and returns from, a subroutine

■ Syntax

    GOSUB {linelabel1 | linenumber1 }
    .
    .
    .
    RETURN «linelabel2 | linenumber2 »

■ Remarks

    The GOSUB...RETURN statements take the following arguments:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    linelabel1, linenumber1  The line number or line label that is the first
                            line of the subroutine.

    linelabel2, linenumber2  The line label or line number where the
                            subroutine returns.
    ──────────────────────────────────────────────────────────────────────────
""","GOTO Statement" to """
■ Action

    Branches unconditionally to the specified line

■ Syntax

    GOTO {linelabel | linenumber}

■ Remarks

    The GOTO statement provides a way to branch unconditionally to another
    line (linelabel or linenumber). A GOTO statement can branch only to
    another statement at the same level of a program. You cannot use GOTO to
    enter or exit a SUB, FUNCTION, or multiline DEF FN function. You can,
    however, use GOTO to control program flow within any of these program
    structures.

    It is good programming practice to use structured control statements
    (DO...LOOP, FOR, IF..THEN...ELSE, SELECT CASE) instead of GOTO statements
    because a program with many GOTO statements is difficult to read and
    debug.

■ Example

    The following program prints the area of the circle with the input radius:

    PRINT "Input 0 to end."
    Start:
        INPUT R
        IF R = 0 THEN
        END
        ELSE
        A = 3.14 * R^2
        PRINT "Area =";A
        END IF
    GOTO Start

■ Output

    Input 0 to end.
    ? 5
    Area = 78.5
    ? 0

""","HEX$ Function" to """
■ Action

    Returns a string that represents the hexadecimal value of the decimal
    argument expression

■ Syntax

    HEX$(expression)

■ Remarks

    The argument expression is rounded to an integer or, if the expression is
    outside the integer range, a long integer before the HEX$ function
    evaluates it.

■ See Also

    OCT$

■ Example

    The following example prints the hexadecimal representation of an input
    value:

    INPUT X
    A$ = HEX$(X)
    PRINT X "decimal is " A$ " hexadecimal"

■ Output

    ? 32
    32 decimal is 20 hexadecimal








""","IF...THEN...ELSE Statement" to """
■ Action

    Allows conditional execution, based on the evaluation of a Boolean
    expression

■ Syntax 1 (Single Line)

    IF booleanexpression THEN thenpart «ELSE elsepart»

■ Syntax 2 (Block)

    IF booleanexpression1 THEN
        «statementblock-1»
    «ELSEIF booleanexpression2 THEN
        «statementblock-2»»
    .
    .
    .
    «ELSE
        «statementblock-n»»
    END IF

■ Remarks

    The single-line form of the statement is best used for short,
    straightforward tests where only one action is taken.

    The block form provides several advantages:

    ■ The block form provides more structure and flexibility than the
    single-line form by allowing conditional branches across several lines.

    ■ With the block form, more complex conditions can be tested.

    ■ The block form lets you use longer statements and structures within the
    THEN...ELSE portion of the statement.

    ■ The block form allows your program's structure to be guided by logic
    rather than by how many statements fit on a line.

    Programs that use block-form IF...THEN...ELSE are usually easier to read,
    maintain, and debug.

    The single-line form is never required. Any program using single-line
    IF...THEN...ELSE statements can be written using block form.

    SINGLE-LINE IF...THEN...ELSE

    The following list describes the parts of the single-line form:

    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
    booleanexpression        Any expression that evaluates to true (nonzero)
                            or false (zero).

    thenpart, elsepart       The statements or branches performed when
                            booleanexpression is true (thenpart) or false
                            (elsepart). Both parts have the same syntax,
                            which is described below.
    ──────────────────────────────────────────────────────────────────────────

    The thenpart and the elsepart both have the following syntax:

    {statements | «GOTO» linenumber | GOTO linelabel }

    The following list describes the parts of the thenpart and elsepart
    syntax:

    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
    statements               One or more BASIC statements, separated by colons

    linenumber               A valid BASIC program line number

    linelabel                A valid BASIC line label
    ──────────────────────────────────────────────────────────────────────────

    Note that GOTO is optional with a line number but is required with a line
    label.

    The thenpart is executed if the booleanexpression is true; if the
    booleanexpression is false, the elsepart is executed. If the ELSE clause
    is not present, control passes to the next statement in the program.

    You can have multiple statements with a condition, but they must be on the
    same line and separated by colons:

    IF A > 10 THEN A=A+1:B=B+A:LOCATE 10,22:PRINT B,A

    BLOCK IF...THEN...ELSE

    The following list describes the parts of the block IF...THEN...ELSE:

    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
    booleanexpression1,      Any expression that evaluates to true (nonzero)
    booleanexpression2       or false (zero)

    statementblock-1,        One or more BASIC statements on one or more lines
    statementblock-2,
    statementblock-n
    ──────────────────────────────────────────────────────────────────────────

    In executing a block-form IF, QuickBASIC tests booleanexpression1, the
    first Boolean expression. If the Boolean expression is true (nonzero), the
    statements following THEN are executed. If the first Boolean expression is
    false (zero), QuickBASIC begins evaluating each ELSEIF condition in turn.
    When QuickBASIC finds a true condition, the statements following the
    associated THEN are executed. If none of the ELSEIF conditions are true,
    the statements following the ELSE are executed. After the statements
    following a THEN or ELSE are executed, the program continues with the
    statement following the END IF.

    The ELSE and ELSEIF blocks are both optional. You can have as many ELSEIF
    clauses as you would like in a block IF. Any of the statement blocks can
    contain nested block IF statements.

    QuickBASIC looks at what appears after the THEN keyword to determine
    whether or not an IF statement is a block IF. If anything other than a
    comment appears after THEN, the statement is treated as a single-line IF
    statement.

    A block IF statement must be the first statement on a line. The ELSE,
    ELSEIF, and END IF parts of the statement can only have a line number or
    line label in front of them. The block must end with an END IF statement.

    For more information, see Chapter 1, "Control-Flow Structures," in
    Programming in BASIC.

■ See Also

    SELECT CASE

■ Examples

    The following program fragments demonstrate the use of single-line and
    block IF...THEN...ELSE and illustrate the differences. The first example
    demonstrates the single-line IF...THEN...ELSE form:

    DO
    INPUT "Enter a number greater than 0 and less than 10,000:",X
    IF X>=0 AND X<10000 THEN EXIT DO ELSE PRINT X;"out of range"
    LOOP
    IF X<10 THEN Y=1 ELSE IF X<100 THEN Y=2 ELSE IF X<1000 THEN Y=3 ELSE
    Y=4
    PRINT "The number has";Y;"digits"

    In the second example the block IF...THEN...ELSE makes the code more
    readable and more powerful:

    DO
        INPUT "Enter a number greater than 0 and less than 100,000:",X
        IF X>0 AND X<100000 THEN
        EXIT DO
        ELSE
        PRINT X;"out of range"
        END IF
    LOOP
    IF X<10 THEN
        Y=1
    ELSEIF X<100 THEN
        Y=2
    ELSEIF X<1000 THEN
        Y=3
    ELSEIF X<10000 THEN
        Y=4
    ELSE
        Y=5
    END IF
    PRINT "The number has";Y;"digits"

""","INKEY$ Function" to """
■ Action

    Reads a character from the keyboard

■ Syntax

    INKEY$

■ Remarks

    The INKEY$ function returns a one- or two-byte string containing a
    character read from the standard input device. A null string is returned
    if no character is waiting there. A one-character string contains the
    actual character read from the keyboard, while a two-character string
    indicates an extended code, the first character of which is hexadecimal
    00. For a complete list of these codes, see Appendix A, "Keyboard Scan
    Codes and ASCII Character Codes."

    The standard input device is usually the keyboard. INKEY$ does not echo
    characters to the screen; instead, all characters are passed through to
    the program except for these:

    ■ CTRL+BREAK, which halts program execution

    ■ CTRL+ALT+DEL, which does a system reboot

    ■ CTRL+NUMLOCK, which causes program execution to pause

    ■ PRTSC, which prints the screen

■ Example

    The following program fragment shows a common use of INKEY$──pausing until
    the user presses a key:

    PRINT "Press any key to continue..."
    DO
    LOOP WHILE INKEY$=""

""","INP Function" to """
■ Action

    Returns the byte read from an I/O port

■ Syntax

    INP(port)

■ Remarks

    The port must be an integer in the range 0-65,535. The INP function
    complements the OUT statement.

    The INP and OUT statements give a BASIC program direct control over the
    hardware in a system through the I/O ports. These statements must be used
    carefully because they directly manipulate the system hardware.

■ See Also

    OUT, WAIT

■ Example

    See the example for the OUT statement.

""","INPUT$ Function" to """
■ Action

    Returns a string of characters read from the specified file

■ Syntax

    INPUT$(n«,«#»filenumber»)

■ Remarks

    The n is the number of characters (bytes) to read from the file. The
    filenumber is the number that was used in opening the file.

    If the file is opened for random access, the argument n must be less than
    or equal to the record length set by the LEN clause in the OPEN statement
    (or less than or equal to 128 if the record length is not set). If the
    given file is opened for binary or sequential access, then n must be less
    than or equal to 32,767.

    If the filenumber is not specified, the characters are read from the
    standard input device. (If input has not been redirected, the keyboard is
    the standard input device).

    You can use the DOS redirection symbols (<, >, or >>) or the pipe symbol
    (|) to redefine the standard input or standard output for an executable
    file created with BASIC. (See your operating system manual for a complete
    discussion of redirection and pipes.)

    No characters are echoed on the screen. All control characters are passed
    through except CTRL+BREAK, which interrupts execution of the function.

■ Example

    The following program prints a file on the screen. It uses INPUT$ to read
    one character at a time, then converts the character, as necessary, and
    displays it.

    'ASCII codes for tab, and line feed.
    CONST HTAB = 9, LFEED = 10

    INPUT "Display which file"; Filename$
    OPEN Filename$ FOR INPUT AS #1
    CLS
    DO WHILE NOT EOF(1)

        ' Input a single character from the file.
        S$=INPUT$(1,#1)
        ' Convert the character to an integer and
        ' turn off the high bit so WordStar(R) files
        ' can be displayed.
        C=ASC(S$) AND &H7F
        ' Is it a printable character?
        IF (C >= 32 AND C <= 126) OR C = HTAB OR C = LFEED THEN
            PRINT CHR$(C);
        END IF

    LOOP
    END

""","INPUT Statement" to """
■ Action

    Allows input from the keyboard during program execution

■ Syntax

    INPUT«;»«"promptstring"{; | ,}» variablelist

■ Remarks

    The following list describes the parts of the INPUT statement:

    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
    ;                        A semicolon immediately after INPUT keeps the
                            cursor on the same line after the user presses
                            ENTER.

    promptstring             A string constant printed before the prompt
                            character.

    ;                        Prints a question mark at the end of the
                            promptstring.

    ,                        Prints the promptstring without a question mark.

    variablelist             A list of variables, separated by commas, to
                            accept the input values. See the discussion
                            below.
    ──────────────────────────────────────────────────────────────────────────

    The INPUT statement causes the program to pause and wait for data. You can
    then enter the required data at the keyboard.

    The data that you enter is assigned to the variables in variablelist. The
    number of data items that you supply must be the same as the number of
    variables in the list. The first character encountered after a comma that
    is not a space, carriage return, or line feed is assumed to be the start
    of a new item.

    The variable names in the list may be numeric- or string-variable names
    (including subscripted variables), array elements, or elements of records.
    The type of each data item that you input must agree with the type of the
    variable. (Strings input to an INPUT statement need not be surrounded by
    quotation marks.) If this first character is a quotation mark ("), the
    string item will consist of all characters read between the first
    quotation mark and the second. This means a quoted string may not contain
    a quotation mark as a character. If the first character of the string is
    not a quotation mark, the string is an unquoted string and terminates on a
    comma, carriage return, or line feed.

    Input stored in elements of a record must be input as single elements:

    TYPE Demograph
        FullName AS STRING*25
        Age  AS INTEGER
    END TYPE

    DIM Person AS Demograph
    INPUT "Enter name and age: ";Person.FullName,Person.Age

    Responding to an INPUT statement with too many or too few items, or with
    the wrong type of value (for example, numeric instead of string), produces
    this error message:

    Redo from start

    No assignment of input values is made until you give an acceptable
    response.

    It is possible to edit a line of input before you press ENTER. The
    following list describes the key combinations that allow you to move the
    cursor, delete text, and insert text on the input line:


╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Keys                     Action
    ──────────────────────────────────────────────────────────────────────────
    CTRL+\ or RIGHT          Moves cursor one character to the right.

    Keys                     Action
    ──────────────────────────────────────────────────────────────────────────

    CTRL+] or LEFT           Moves cursor one character to the left.

    CTRL+F or CTRL+RIGHT     Moves cursor one word to the right.

    CTRL+B or CTRL+LEFT      Moves cursor one word to the left.

    CTRL+K or HOME           Moves cursor to the beginning of the input line.

    CTRL+N or END            Moves cursor to the end of the input line.

    CTRL+R or INS            Toggles insert mode on and off. When insert mode
                            is on, character above and those to the right of
                            the cursor are shifted to the right as new
                            characters are entered.

    CTRL+I or TAB            Tabs right and inserts (insert mode on), or
                            overwrites (insert mode off).

    Keys                     Action
    ──────────────────────────────────────────────────────────────────────────

    DEL                      Deletes the character at the cursor.

    CTRL+H or BACKSPACE      Deletes the character to the left of the cursor,
                            unless the cursor is at the beginning of the
                            input, in which case it deletes the character at
                            the cursor.

    CTRL+E or CTRL+END       Deletes to the end of the line.

    CTRL+U or ESC            Deletes entire line, regardless of cursor
                            position.

    CTRL+M or RETURN         Stores input line.

    CTRL+T                   Toggles function key label display on and off at
                            bottom of screen.

    CTRL+BREAK or CTRL+C     Terminates input (exits compiled program).
    Keys                     Action
    ──────────────────────────────────────────────────────────────────────────
    CTRL+BREAK or CTRL+C     Terminates input (exits compiled program).
    ──────────────────────────────────────────────────────────────────────────


■ Example

    The following example calculates the area of a circle from an input
    radius:

    PI = 3.141593 : R = -1
    PRINT "Enter radius (0 to end)."
    DO WHILE R
        PRINT
        INPUT;"If radius = ", R
        IF R > 0 THEN
            A = PI*R^2
            PRINT ", the area of the circle =" A
        END IF
    LOOP

■ Output

    Enter radius (0 to end).

    If radius = 3, the area of the circle = 28.27434

    If radius = 4, the area of the circle = 50.26549

    If radius = 0

""","INPUT # Statement" to """
■ Action

    Reads data items from a sequential device or file and assigns them to
    variables

■ Syntax

    INPUT #filenumber, variablelist

■ Remarks

    The filenumber is the number used when the file was opened for input. The
    variablelist contains the names of the variables that are assigned values
    read from the file. (The variable type must match the type specified by
    the variable name.)

    The data items in the file should appear just as they would if you were
    entering data in response to an INPUT statement. Separate numbers with a
    space, carriage return, line feed, or comma. Separate strings with a
    carriage return or linefeed (leading spaces are ignored). The end-of-file
    character will end either a numeric or string entry.

    If BASIC is scanning the sequential data file for a string item, it will
    also ignore leading spaces, carriage returns, and line feeds. If
    end-of-file is reached when a numeric or string item is being INPUT, the
    item is terminated.

■ See Also

    INPUT, INPUT$

■ Example

    The following program reads a series of test scores from a sequential file
    and calculates the average score:

    DEFINT A-Z

    OPEN "class.dat" FOR INPUT AS #1

    DO WHILE NOT EOF(1)
        Count=Count+1
        INPUT #1,Score
        Total=Total+Score
        PRINT Count;Score
    LOOP
    PRINT
    PRINT "Total students:";Count;" Average score:";Total/Count

    END

■ Output

    1  97
    2  84
    3  63
    4  89
    5  100

    Total students: 5  Average score: 86.6

""","INSTR Function" to """
■ Action

    Returns the character position of the first occurrence of a string in
    another string

■ Syntax

    INSTR(«start,»stringexpression1,stringexpression2)

■ Remarks

    The following list describes the INSTR function arguments:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    start                    An optional offset that sets the position for
                            starting the search; start must be in the range
                            1-32,767. If start is not given, the INSTR
                            function begins the search at the first character
                            of stringexpression1.

    stringexpression1        The string being searched.

    stringexpression2        The string to look for.
    ──────────────────────────────────────────────────────────────────────────

    The arguments stringexpression1 and stringexpression2 can be string
    variables, string expressions, or string literals. The value returned by
    INSTR depends on these conditions:

    Condition                            Value Returned
    ──────────────────────────────────────────────────────────────────────────
    stringexpression2 found in           The position at which the match is
    stringexpression1                    found

    start greater than length of         0
    stringexpression1
    stringexpression1 is null string     0

    stringexpression2 cannot be found    0

    stringexpression2 is null string     start (if given); otherwise, 1
    ──────────────────────────────────────────────────────────────────────────

    Use the LEN function to find the length of stringexpression1.

■ Example

    The following fragment uses INSTR and UCASE$ to look for Mr., Mrs., or Ms.
    in a name in order to deduce the person's sex:

    ' Get a name.
    DO
        INPUT "Enter name: ", Nm$
    LOOP UNTIL LEN(Nm$)>=3

    ' Convert lowercase letters to uppercase.
    Nm$ = UCASE$(Nm$)

    ' Look for MS., MRS., or MR. to set Sex$.
    IF INSTR(Nm$,"MS.") > 0 OR INSTR(Nm$,"MRS.") > 0 THEN
        Sex$ = "F"
    ELSEIF INSTR(Nm$,"MR.") > 0 THEN
        Sex$ = "M"
    ELSE
        ' Can't deduce sex, so query user.
        DO
            INPUT "Enter sex (M/F): ", Sex$
            Sex$ = UCASE$(Sex$)
        LOOP WHILE Sex$ <> "M" AND Sex$ <> "F"
    END IF

■ Output

    Enter name: Elspeth Brandtkeep
    Enter sex (M/F): x
    Enter sex (M/F): F

""","INT Function" to """
■ Action

    Returns the largest integer less than or equal to numeric-expression

■ Syntax

    INT(numeric-expression)

■ Remarks

    The INT function removes the fractional part of its argument.

■ See Also

    CINT, FIX

■ Example

    The following example compares the output from the three functions that
    convert numeric data to integers:

    PRINT "  N","INT(N)","CINT(N)","FIX(N)" : PRINT
    FOR I% = 1 TO 6
        READ N
        PRINT N, INT(N), CINT(N), FIX(N)
    NEXT
    DATA  99.3, 99.5, 99.7, -99.3, -99.5, -99.7

■ Output

    N           INT(N)        CINT(N)       FIX(N)

    99.3          99            99            99
    99.5          99            100           99
    99.7          99            100           99
    -99.3         -100          -99           -99
    -99.5         -100          -100          -99
    -99.7         -100          -100          -99

""","IOCTL$ Function" to """
■ Action

    Receives a control data string from a device driver

■ Syntax

    IOCTL$ («#» filenumber)

■ Remarks

    The filenumber is the BASIC file number used to open the device. The
    IOCTL$ function is most frequently used to test whether an IOCTL statement
    succeeded or failed or to obtain current status information.

    You could use IOCTL$ to ask a communications device to return the current
    baud rate, information on the last error, logical line width, and so on.
    The exact information returned would depend on the specific device driver.

    The IOCTL$ function works only if all three of the following conditions
    are met:

    1. The device driver is installed.

    2. The device driver states that it processes IOCTL strings. See the
        documentation for the driver. You can also test for IOCTL support
        through DOS function &H44 by using interrupt &H21 and the CALL
        INTERRUPT routine. See the CALL INTERRUPT statement for more
        information.

    3. BASIC performs an OPEN statement on a file on that device.
""","IOCTL Statement" to """
■ Action

    Transmits a control data string to a device driver

■ Syntax

    IOCTL «#»filenumber, string

■ Remarks

    The filenumber is the BASIC file number used to open the device. The
    string is the command sent to the device. Commands are specific to the
    device driver. See the documentation for the device driver to find out
    what the valid IOCTL commands are. An IOCTL control data string can be up
    to 32,767 bytes long.

    The IOCTL statement works only if all three of the following conditions
    are met:

    1. The device driver is installed.

    2. The device driver states that it processes IOCTL strings. See the
        documentation for the driver. You can also test for IOCTL support
        through DOS function &H44 by using interrupt &H21 and the CALL
        INTERRUPT routine. See the Microsoft MS-DOS Programmer's Reference and
        the CALL INTERRUPT statement for more information.

    3. BASIC performs an OPEN on a file on that device, and the file is still
        open.

    Most standard DOS device drivers do not process IOCTL strings, and you
    must determine if the specific driver accepts the command.

■ See Also

    IOCTL$

■ Example

    If you wanted to set the page length to 66 lines per page on LPT1, your
    statement might look like this:

    OPEN "\DEV\LPT1" FOR OUTPUT AS 1
    IOCTL #1, "PL66"

""","KEY (n) Statements" to """
■ Action

    Start or stop trapping of specified keys

■ Syntax

    KEY(n) ON
    KEY(n) OFF
    KEY(n) STOP

■ Remarks

    The argument n is the number of a FUNCTION key, a cursor-direction key, or
    a user-defined key. (See the KEY statement for information on assigning
    soft-key values to FUNCTION keys.) The values of n are as follows:

    Value                    Key
    ──────────────────────────────────────────────────────────────────────────
    1-10                     The FUNCTION keys F1-F10
    11                       UP
    12                       LEFT
    13                       RIGHT
    14                       DOWN
    15-25                    User-defined keys
    30-31                    The FUNCTION keys F11-F12 on 101-key keyboards
    ──────────────────────────────────────────────────────────────────────────

    LEFT, RIGHT, UP, and DOWN refer to the direction keys.

    You can enable trapping of combination keys by using a variation of the
    KEY statement:

    KEY n, CHR$(keyboardflag) + CHR$(scancode)

    The argument n is in the range 15-25 to indicate a user-defined key. The
    keyboardflag can be any combination of the following hexadecimal values:

    Value                    Key
    ──────────────────────────────────────────────────────────────────────────
    &H00                     No keyboard flag
    &H01-&H03                Either SHIFT key
    &H04                     CTRL
    &H08                     ALT
    &H20                     NUMLOCK
    &H40                     CAPSLOCK
    &H80                     101-key keyboard extended keys
    ──────────────────────────────────────────────────────────────────────────

    You can add the values together to test for multiple shift states. A
    keyboardflag value of &H12 would test for both CTRL and ALT being pressed,
    for example.

    Because key trapping assumes the left and right SHIFT keys are the same,
    you can use either &H01, &H02, or &H03 to indicate a SHIFT key. The
    scancode argument is a number identifying one of the 83 keys to trap, as
    shown in Table R.4.

    Table R.4   Keyboard Scan Codes


╓┌─┌───────────┌────────────┌───────────┌───────────┌────────────┌───────────╖
                Code                     Code                     Code
    Key         in Hex       Key         in Hex      Key          in Hex
    ──────────────────────────────────────────────────────────────────────────
    ESC         01           CTRL        1D          SPACEBAR     39
    ! or 1      02           A           1E          CAPS LOCK    3A
    # or 3      04           D           20          F2           3C
                Code                     Code                     Code
    Key         in Hex       Key         in Hex      Key          in Hex
    ──────────────────────────────────────────────────────────────────────────
    # or 3      04           D           20          F2           3C
    $ or 4      05           F           21          F3           3D
    % or 5      06           G           22          F4           3E
    ^ or 6      07           H           23          F5           3F
    & or 7      08           J           24          F6           40
    * or 8      09           K           25          F7           41
    ( or 9      0A           L           26          F8           42
    ) or 0      0B           : or ;      27          F9           43
    _ or -      0C           " or '      28          F10          44
    + or =      0D           ~ or `      29          NUM LOCK     45
    LEFT        0E           LEFT SHIFT  2A          SCROLL LOCK  46
    TAB         0F           | or \      2B          HOME or 7    47
    Q           10           Z           2C          UP or 8      48
    W           11           X           2D          PGUP or 9    49
    E           12           C           2E          -            4A
    R           13           V           2F          LEFT or 4    4B
    T           14           B           30          5            4C
    Y           15           N           31          RIGHT or 6   4D
                Code                     Code                     Code
    Key         in Hex       Key         in Hex      Key          in Hex
    ──────────────────────────────────────────────────────────────────────────
    Y           15           N           31          RIGHT or 6   4D
    U           16           M           32          +            4E
    I           17           < or ,      33          END or 1     4F
    O           18           > or .      34          DOWN or 2    50
    P           19           ? or /      35          PGDN or 3    51
    { or [      1A           RIGHT SHIFT 36          INS or 0     52
    } or ]      1B           PRTSC or *  37          DEL or .     53
    RETURN      1C           ALT         38
    ──────────────────────────────────────────────────────────────────────────

""","KEY Statements" to """
■ Action

    Assign soft-key string values to FUNCTION keys, then display the values
    and enable or disable the FUNCTION key display line

■ Syntax

    KEY n, stringexpression
    KEY LIST
    KEY ON
    KEY OFF

■ Remarks

    The placeholder n is a number representing the FUNCTION key. The values
    for n are 1 to 10 for the FUNCTION keys, and 30 and 31 for FUNCTION keys
    F11 and F12 on 101-key keyboards. The stringexpression is a string of up
    to 15 characters that is returned when the FUNCTION key is pressed. If the
    stringexpression is longer than 15 characters, the extra characters are
    ignored.

    The KEY statement allows you to designate special "soft-key"
    functions──strings that are returned when FUNCTION keys are pressed.

    Assigning a null string to a soft key disables the FUNCTION key as a soft
    key.

    If the FUNCTION key number is not in the correct range, an error message
    is displayed that reads Illegal function call, and the previous key string
    expression is retained.

    You may display soft keys with the KEY ON, KEY OFF, and KEY LIST
    statements:

    Statement                Action
    ──────────────────────────────────────────────────────────────────────────
    KEY ON                   Displays the first six characters of the soft-key
                            string values on the bottom line of the screen.

    KEY OFF                  Erases the soft-key display from the bottom line,
                            making that line available for program use. It
                            does not disable the FUNCTION keys.

    KEY LIST                 Displays all soft-key values on the screen, with
                            all 15 characters of each key displayed.
    ──────────────────────────────────────────────────────────────────────────

    If a soft key is pressed, the effect is the same as if the user typed the
    string associated with the soft key. INPUT$, INPUT, and INKEY$ can all be
    used to read the string produced by pressing the soft key.

■ Examples

    The following examples show how to assign a string to a soft key and how
    to disable a soft key:

    KEY 1,"MENU"+CHR$(13)  'Assigns to soft key 1 the string
                            '"MENU" followed by a carriage return.

    KEY 1,""
    'Disables soft key 1.

    The following program uses KEY statements to set up one-key equivalents of
    menu selections. For example, pressing F1 is the same as entering the
    string Add:

    DIM KeyText$(3)
    DATA Add, Delete, Quit
    ' Assign soft-key strings to F1 to F3.
    FOR I=1 TO 3
        READ KeyText$(I)
        KEY I, KeyText$(I)+CHR$(13)
    NEXT I
    ' Print menu.
    PRINT "                 Main Menu" : PRINT
    PRINT "           Add to list (F1)"
    PRINT "           Delete from list (F2)"
    PRINT "           Quit (F3)" : PRINT
    ' Get input and respond.
    DO
        LOCATE 7,1 : PRINT SPACE$(50);
        LOCATE 7,1 : INPUT "             Enter your choice:",R$
        SELECT CASE R$
        CASE "Add", "Delete"
            LOCATE 10,1 : PRINT SPACE$(15);
            LOCATE 10,1 : PRINT R$;
        CASE "Quit"
            EXIT DO
        CASE ELSE
            LOCATE 10,1 : PRINT "Enter first word or press key."
        END SELECT
    LOOP

""","KILL Statement" to """
■ Action

    Deletes a file from disk

■ Syntax

    KILL filespec

■ Remarks

    The KILL statement is similar to the DOS ERASE or DEL commands.

    KILL is used for all types of disk files: program files, random data
    files, and sequential data files. The filespec may contain question marks
    (?) or asterisks (*) used as wild cards. A question mark matches any
    single character in the file name or extension. An asterisk matches one or
    more characters starting at its position.

    You can use KILL only to delete files. To delete directories, use the
    RMDIR command. Using KILL to delete a file that is currently open produces
    an error message that reads File already open.
""","LBOUND Function" to """
■ Action

    Returns the lower bound (smallest available subscript) for the indicated
    dimension of an array

■ Syntax

    LBOUND(array«,dimension»)

■ Remarks

    The LBOUND function is used with the UBOUND function to determine the size
    of an array. LBOUND takes the following arguments:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    array                    The name of the array being dimensioned

    dimension                An integer ranging from 1 to the number of
                            dimensions in array: indicates which dimension's
                            lower bound is returned
    ──────────────────────────────────────────────────────────────────────────

    For an array dimensioned as follows, LBOUND returns the values listed
    below:

    DIM A(1 TO 100, 0 TO 50, -3 TO 4)

    Invocation               Value Returned
    ──────────────────────────────────────────────────────────────────────────
    LBOUND(A,1)              1
    LBOUND(A,2)              0
    LBOUND(A,3)              -3
    ──────────────────────────────────────────────────────────────────────────

    The default lower bound for any dimension is either 0 or 1, depending on
    the setting of the OPTION BASE statement. If OPTION BASE is 0, the default
    lower bound is 0, and if OPTION BASE is 1, the default lower bound is 1.

    Arrays dimensioned using the TO clause in the DIM statement may have any
    integer value as a lower bound.

    You may use the shortened syntax LBOUND(array) for one-dimensional arrays,
    since the default value for dimension is 1. Use the UBOUND function to
    find the upper limit of an array dimension.

■ See Also

    UBOUND

■ Example

    The LBOUND and UBOUND functions may be used to determine the size of an
    array passed to a subprogram, as in the following program fragment:

    CALL Prntmat(Array())
    .
    .
    .
    ' Print a matrix (two-dimensional array).
    SUB Prntmat(A(2)) STATIC
        ' Outer loop controls row (dimension 1).
        FOR I% = LBOUND(A,1) TO UBOUND(A,1)
        ' Inner loop controls column (dimension 2).
        FOR J% = LBOUND(A,2) TO UBOUND(A,2)
            PRINT A(I%,J%);" ";
        NEXT J%
        PRINT:PRINT
        NEXT I%
    END SUB

""","LCASE$ Function" to """
■ Action

    Returns a string expression with all letters in lowercase

■ Syntax

    LCASE$ (stringexpression)

■ Remarks

    The LCASE$ function takes a string variable, string constant, or string
    expression as its single argument. LCASE$ works with both variable- and
    fixed-length strings.

    LCASE$ and UCASE$ are helpful in string comparison operations where tests
    need to be case insensitive.

■ See Also

    UCASE$

■ Example

    The following example converts uppercase characters in a string to
    lowercase characters:

    ' Program to convert to lowercase.
        READ Word$
        PRINT LCASE$(Word$);
        DATA "THIS IS THE STRING in lowercase."

■ Output

    this is the string in lowercase.

""","LEFT$ Function" to """
■ Action

    Returns a string consisting of the leftmost n characters of a string

■ Syntax

    LEFT$(stringexpression,n)

■ Remarks

    The argument stringexpression can be any string variable, any string
    constant, or any string expression.

    The argument n is a numeric expression in the range 0-32,767 indicating
    how many characters are to be returned.

    If n is greater than the number of characters in stringexpression, the
    entire string is returned. To find the number of characters in
    stringexpression, use LEN(stringexpression).

    If n is zero, the null string (length zero) is returned.

■ See Also

    MID$, RIGHT$

■ Example

    The following example prints the leftmost five characters of A$:

    A$="BASIC LANGUAGE"
    B$=LEFT$(A$,5)
    PRINT B$

■ Output

    BASIC

""","LEN Function" to """
■ Action

    Returns the number of characters in a string or the number of bytes
    required by a variable

■ Syntax

    LEN(stringexpression)
    LEN(variable)

■ Remarks

    In the first form, LEN returns the number of characters in the argument
    stringexpression. The second syntax returns the number of bytes required
    by a BASIC variable. This syntax is particularly useful for determining
    the correct record size of a random-access file.

■ Example

    The following example prints the sizes of BASIC variables of several
    different types and also prints the length of a string:

    TYPE EmpRec
        EmpName AS STRING*20
        EmpNum AS INTEGER
    END TYPE
    DIM A AS INTEGER, B AS LONG, C AS SINGLE, D AS DOUBLE
    DIM E AS EmpRec

    PRINT "Integer:" LEN(A)
    PRINT "Long:" LEN(B)
    PRINT "Single:" LEN(C)
    PRINT "Double:" LEN(D)
    PRINT "EmpRec:" LEN(E)
    PRINT "A string:" LEN("A string.")
    END

■ Output

    Integer: 2
    Long: 4
    Single: 4
    Double: 8
    EmpRec: 22
    A string: 9

""","LET Statement" to """
■ Action

    Assigns the value of an expression to a variable

■ Syntax

    «LET»variable=expression

■ Remarks

    Notice that the word LET is optional. The equal sign in the statement is
    enough to inform QuickBASIC that the statement is an assignment statement.

    LET statements can be used with record variables only when both variables
    are the same user-defined type. Use the LSET statement for assigning
    record variables of different user-defined types.

■ See Also

    LSET

■ Examples

    Corresponding lines perform the same function in these two examples:

    LET D=12
    LET E=12-2
    LET F=12-4
    LET SUM=D+E+F
    .
    .
    .

    or

    D=12
    E=12-2
    F=12-4
    SUM=D+E+F
    .
    .
    .

""","LINE Statement" to """
■ Action

    Draws a line or box on the screen

■ Syntax

    LINE ««STEP» (x1,y1)»-«STEP» (x2,y2) «,«color»«,«B«F»»«,style»»»

■ Remarks

    The coordinates (x1,y1) and (x2,y2) specify the endpoints of the line;
    note that the order in which these endpoints appear is unimportant, since
    a line from (10,20) to (120,130) is the same as a line from (120,130) to
    (10,20).

    The STEP option makes the specified coordinates relative to the most
    recent point, instead of absolute, mapped coordinates. For example, if the
    most recent point referred to by the program is (10,10), then

    LINE -STEP (10,5)

    draws a line from (10,10) to the point with x-coordinate equal to 10 + 10
    and y-coordinate equal to 10 + 5, or (20,15).

    You may establish a new most recent point by initializing the screen with
    the CLS and SCREEN statements. Using the PSET, PRESET, CIRCLE, and DRAW
    statements will also establish a new most recent point.

    Variations of the STEP argument are shown below. For the following
    examples, assume that the last point plotted was (10,10):

╓┌─┌────────────────────────────────────────────────┌────────────────────────╖
    Statement                                        Description
    ──────────────────────────────────────────────────────────────────────────
    LINE -(50,50)                                    Draws from (10,10) to
                                                    (50,50)

    LINE -STEP(50,50)                                Draws from (10,10) to
                                                    (60,60); that is, to 10
                                                    plus offset 50

    LINE (25,25)-STEP(50,50)                         Draws from (25,25) to
                                                    (75,75); that is, to 25
                                                    plus offset 50

    Statement                                        Description
    ──────────────────────────────────────────────────────────────────────────

    LINE STEP(25,25)-STEP(50,50)                     Draws from (35,35) to
                                                    (85,85); that is, from 10
                                                    plus offset 25 to that
                                                    point plus offset 50

    LINE STEP(25,25)-(50,50)                         Draws from (35,35) to
                                                    (50,50); that is, from 10
                                                    plus offset 25 to
                                                    absolute 50
    ──────────────────────────────────────────────────────────────────────────


    The color is the number of the color in which the line is drawn. (If the B
    or BF options are used, the box is drawn in this color.) See the SCREEN
    statement for information on valid colors.

    The B option draws a box with the points (x1,y1) and (x2,y2) specifying
    diagonally opposite corners.

    The BF option draws a filled box. This option is similar to the B option;
    BF also paints the interior of the box with the selected color.

    The style is a 16-bit integer mask used to put pixels on the screen. Using
    the style argument is called "line styling." With line styling, LINE reads
    the bits in style from left to right. If a bit is 0, then no point is
    plotted; if the bit is 1, a point is plotted. After plotting a point, LINE
    selects the next bit position in style.

    Because a 0 bit in style does not change the point on the screen, you may
    want to draw a background line before using styling so you can have a
    known background. Style is used for normal lines and boxes, but has no
    effect on filled boxes.

    When coordinates specify a point that is not in the current viewport, the
    line segment is clipped to the viewport.

    See Chapter 5, "Graphics," in Programming in BASIC for more information on
    the LINE statement.

■ See Also

    SCREEN

■ Examples

    The following examples are different LINE statements that assume a screen
    320 pixels wide by 200 pixels high:

    SCREEN 1                          'Sets up the screen mode.

    LINE -(X2,Y2)                     'Draws a line (in the
                                    'foreground color) from
                                    'the most recent point
                                    'to  X2,Y2.

    LINE(0,0)-(319,199)               'Draws a diagonal line across
                                    'the screen (downward).


    LINE(0,100)-(319,100)             'Draws a horizontal line
                                    'across the screen.

    LINE(10,10)-(20,20),2             'Draws a line in color 2.

    FOR X=0 to 319                    'Draws an alternating pattern
        LINE(X,0)-(X,199),X AND 1     '(line on/line off) on mono-
    NEXT                              'chrome display.

    LINE (0,0)-(100,100),,B           'Draws a box in the fore-
                                    'ground color (note that the
                                    'color is not included).

    LINE STEP(0,0)-STEP(200,200),2,BF 'Draws a filled box in color
                                    '2 (coordinates are given as
                                    'offsets with the STEP option).

    LINE(0,0)-(160,100),3,,&HFF00     'Draws a dashed line from
                                    'the upper lefthand corner to
                                    'the center of the screen in
                                    'color 3.

""","LINE INPUT Statement" to """
■ Action

    Inputs an entire line (up to 255 characters) to a string variable, without
    the use of delimiters

■ Syntax

    LINE INPUT«;» «"promptstring";» stringvariable

■ Remarks

    The promptstring is a string constant displayed on the screen before input
    is accepted. A question mark is not printed unless it is part of the
    promptstring. All input from the end of promptstring to the carriage
    return is assigned to stringvariable.

    A semicolon immediately after the LINE INPUT statement keeps the cursor on
    the same line after the user presses ENTER.

    LINE INPUT uses the same editing characters as INPUT.

■ See Also

    INPUT

■ Example

    The following program enables the user to enter text in a notes file. The
    LINE INPUT statement allows you to enter any characters, including those
    (such as a comma) that are delimiters in a regular INPUT statement.

    'Opens and writes lines to a notes file until you
    'enter a blank line.
    DO
        CLS
        PRINT "Enter text. To stop, press <RETURN> without ";
        PRINT "entering any new text." : PRINT
        OPEN "NOTES.TXT" FOR OUTPUT AS #1

        ' Take lines until a blank line is entered.
        DO
            LINE INPUT "->";Inline$
            IF Inline$ <> "" THEN PRINT #1, Inline$
        LOOP WHILE Inline$ <> ""
        CLS : CLOSE #1

    ' Echo the notes back and see if they are correct.
        OPEN "NOTES.TXT" FOR INPUT AS #1
        PRINT "You entered: " : PRINT
        DO WHILE NOT EOF(1)
            LINE INPUT #1, Inline$
            PRINT Inline$
        LOOP
        CLOSE #1
        PRINT : INPUT "Is this correct (Y/N)"; R$

    LOOP WHILE UCASE$(R$)="N"
    END

""","LINE INPUT # Statement" to """
■ Action

    Reads an entire line without delimiters from a sequential file to a string
    variable

■ Syntax

    LINE INPUT #filenumber,stringvariable

■ Remarks

    The filenumber is the number used to open the file. The stringvariable is
    the variable the line is assigned to.

    The LINE INPUT # statement reads all characters in the sequential file up
    to a carriage return. It then skips over the carriage-return and line-feed
    sequence. The next LINE INPUT # reads all characters up to the next
    carriage return.

    LINE INPUT # is especially useful if each line of a data file has been
    broken into fields or a text file is being read a line at a time.

■ See Also

    INPUT$, LINE INPUT

■ Example

    The following uses LINE INPUT # to echo data input to a file:

    OPEN "LIST" FOR OUTPUT AS #1
    PRINT "CUSTOMER INFORMATION:"
    ' Get customer information.
    DO
        PRINT
        INPUT "   LAST NAME:  ", LName$
        INPUT "   FIRST NAME: ", FrName$
        INPUT "   AGE:        ", Age$
        INPUT "   SEX:        ", Sex$
        Sex$=UCASE$(Sex$)
        WRITE #1, LName$, FrName$, Age$, Sex$
        INPUT "Add another"; R$
    LOOP WHILE UCASE$(R$)="Y"
    CLOSE #1


    ' Echo the file back.
    OPEN "LIST" FOR INPUT AS #1
    CLS
    PRINT "Records in file:" : PRINT
    DO WHILE NOT EOF(1)
        LINE INPUT #1, REC$
    'Read records from file with
        PRINT REC$          'LINE INPUT #. Print the
                            'records on the screen.
    LOOP

■ Output

    CUSTOMER INFORMATION:


        LAST NAME:  Saintsbury
        FIRST NAME: Aloysius
        AGE:        35
        SEX:        m
    Add another? y

        LAST NAME:  Frangio
        FIRST NAME: Louisa
        AGE:        27
        SEX:        f
    Add another? n

    Records in file:

    "Saintsbury","Aloysius","35","M"
    "Frangio","Louisa","27","F"

""","LOC Function" to """
■ Action

    Returns the current position within the file

■ Syntax

    LOC(filenumber)

■ Remarks

    The filenumber is the number used in the OPEN statement to open the file.
    With random-access files, the LOC function returns the number of the last
    record read from or written to the file. With sequential files, LOC
    returns the current byte position in the file, divided by 128. With binary
    mode files, LOC returns the position of the last byte read or written.

    For a COM device, LOC(filenumber) returns the number of characters in the
    input queue waiting to be read. The value returned depends on whether the
    device was opened in ASCII or binary mode. In ASCII mode, the low-level
    routines stop queuing characters as soon as end-of-file is received. The
    end-of-file itself is not queued and cannot be read. An attempt to read
    the end-of-file produces an error message that reads Input past end of
    file. In binary mode, the end-of-file character is ignored and the entire
    file can therefore be read.

    The LOC function cannot be used on the SCRN:, KYBD:, or LPTn: devices.

■ See Also

    OPEN COM

■ Example

    The following line stops the program if the current file position is
    beyond 50:

    IF LOC(1) > 50 THEN STOP

""","LOCATE Statement" to """
■ Action

    Moves the cursor to the specified position

■ Syntax

    LOCATE«row»«,«column»«,«cursor»«,«start»«,stop»»»»

■ Remarks

    The following list describes the LOCATE statement's arguments:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Argument                 Description
    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    row                      The number of a row on the screen; row is a
                            numeric expression returning an integer. If row
                            is not specified, then the line (row) does not
                            change.

    column                   The number of a column on the screen; column is a
                            numeric expression returning an integer. If
                            column is not specified, then the column location
                            does not change.

    cursor                   A Boolean value indicating whether the cursor is
                            visible or not. A value of 0 (zero) indicates
                            cursor off; a value of 1 indicates cursor on.

    start                    The starting scan line of cursor on the screen.
                            It must be a numeric expression returning an
                            integer.

    stop                     The ending scan line of cursor on the screen. It
    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    stop                     The ending scan line of cursor on the screen. It
                            must be a numeric expression returning an
                            integer.
    ──────────────────────────────────────────────────────────────────────────


    You may omit any argument from the statement except that if stop is
    specified, start must also be specified. When you omit the row or column,
    LOCATE leaves the cursor at the row or column where it was moved by a
    previous LOCATE or a previous input or output statement, whichever
    occurred most recently. When you omit other arguments, QuickBASIC assumes
    the previous value for the argument.

    Note that the start and stop lines are the CRT scan lines that specify
    which pixels on the screen are lit. A wider range between the start and
    stop lines produces a taller cursor, such as one that occupies an entire
    character block. When start is greater than stop, LOCATE produces a
    two-part cursor. If the start line is given but the stop line is omitted,
    stop assumes the same value as start.

    The last line on the screen is reserved for the soft-key display and is
    not accessible to the cursor unless the soft-key display is off (KEY OFF)
    and LOCATE is used with PRINT to write on the line.

■ See Also

    CSRLIN, POS

■ Examples

    The following statements show the effects on the cursor of different
    LOCATE statements:

    LOCATE 1,1    'Moves cursor to upper-left corner of the screen.

    LOCATE,,1     'Makes the cursor visible; position remains
                'unchanged.

    LOCATE,,,7    'Position and cursor visibility remain unchanged;
                'sets the cursor to display at the bottom of
                'the character box starting and ending on
                'scan line 7.

    LOCATE 5,1,1,0,7     'Moves the cursor to line 5, column 1;
                        'turns cursor on; cursor covers entire
                        'character cell starting at scan line
                        '0 and ending on scan line 7.

    The following example prints a menu on the screen, then waits for input in
    the allowable range (1-4). If a number outside that range is entered, the
    program continues to prompt for a selection.

    CONST FALSE=0, TRUE=NOT FALSE
    DO
        CLS
        PRINT "MAIN MENU" : PRINT
        PRINT "1)  Add Records"
        PRINT "2)  Display/Update/Delete a Record"
        PRINT "3)  Print Out List of People Staying at Hotel"
        PRINT "4)  End Program"
        ' Change cursor to a block.
        LOCATE ,,1,1,12
        LOCATE 12,1
        PRINT "What is your selection?";
        DO
            CH$ = INPUT$(1)
        LOOP WHILE (CH$ < "1" OR CH$ > "4")
        PRINT CH$

    ' Call the appropriate subprogram.
        SELECT CASE VAL(CH$)
            CASE 1
            CALL Add
            CASE 2
            CALL Search
            CASE 3
            CALL Hotel
            CASE 4
            CALL Quit
        END SELECT
    LOOP WHILE NOT ENDPROG
    .
    .
    .
    END

""","LOCK...UNLOCK Statement" to """
■ Action

    Controls access by other processes to all or part of an opened file

■ Syntax

    LOCK «#» filenumber «,{record | «start» TO end}»
    .
    .
    .
    UNLOCK «#» filenumber «,{record | «start» TO end}»

■ Remarks

    These statements are used in networked environments where several
    processes might need access to the same file. The LOCK and UNLOCK
    statements take the following arguments:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    filenumber               The number with which the file was opened.

    record                   The number of the record or byte to be locked;
                            record can be any number from 1 to 2,147,483,647
                            (equivalent to 2^31-1). A record may be up to
                            32,767 bytes in length.

    start                    The number of the first record or byte to be
                            locked.

    end                      The number of the last record or byte to be
                            locked.
    ──────────────────────────────────────────────────────────────────────────

    For binary-mode files, the arguments record, start, and end represent the
    number of a byte relative to the beginning of the file. The first byte in
    a file is byte 1. For random-access files, the arguments record, start,
    and end are the number of a record relative to the beginning of the file.
    The first record is record 1.

    The LOCK and UNLOCK statements are always used in pairs. The arguments to
    LOCK and UNLOCK must match exactly when you use them. See the second
    example below.

    If you specify just one record, then only that record is locked or
    unlocked. If you specify a range of records and omit a starting record
    (start), then all records from the first record to the end of the range
    (end) are locked or unlocked. LOCK with no record arguments locks the
    entire file, while UNLOCK with no record arguments unlocks the entire
    file.

    If the file has been opened for sequential input or output, LOCK and
    UNLOCK affect the entire file, regardless of the range specified by start
    and end. LOCK and UNLOCK only function at run time if you are using
    versions of DOS that support networking (version 3.1 or later). In
    addition, each terminal (or the network setup programs) must run the DOS
    SHARE.EXE program to enable locking operations. Earlier versions of DOS
    return an error message that reads Advanced feature unavailable if LOCK
    and UNLOCK are executed.
""","LOF Function" to """
■ Action

    Returns the length of the named file in bytes

■ Syntax

    LOF(filenumber)

■ Remarks

    The argument filenumber is the number used in the OPEN statement. When a
    file is opened in any mode, the LOF function returns the size of the file
    in bytes.

    LOF cannot be used with the BASIC devices SCRN:, KYBD:, CONS:, and LPTn:.
    When used on a device opened as a file with the statement OPEN COM, the
    LOF function returns the number of bytes free in the output buffer.

■ Example

    See the example for the GET statement.

""","LOG Function" to """
■ Action

    Returns the natural logarithm of a numeric expression

■ Syntax

    LOG(n)

■ Remarks

    The numeric expression, n, must be greater than zero. The natural
    logarithm is the logarithm to the base e. The constant e is approximately
    equal to 2.718282.

    The LOG function calculates the natural logarithm with single-precision
    accuracy, unless the argument n is a double-precision value. In this case
    LOG is calculated with double-precision accuracy.

    You may calculate base-10 logarithms by dividing the natural logarithm of
    the number by the logarithm of 10. The following FUNCTION calculates
    base-10 logarithms:

    FUNCTION Log10(X) STATIC
        Log10=LOG(X)/LOG(10.#)
    END FUNCTION

■ Example

    The following example first prints the value of e and then prints the
    natural logarithms of e taken to the first, second, and third powers:

    PRINT EXP(1),
    FOR I = 1 TO 3
        PRINT LOG(EXP(1)^I),
    NEXT

■ Output

    2.718282       1       2       3

""","LPOS Function" to """
■ Action

    Returns the current position of the line printer's print head within the
    printer buffer

■ Syntax

    LPOS(n)

■ Remarks

    The argument n is the index of the printer being tested. For example,
    LPT1: would be tested with LPOS(1), while LPT2: would be tested with
    LPOS(2), and so on.

    The LPOS function does not necessarily give the physical position of the
    print head because it does not expand tab characters. In addition, some
    printers may buffer characters.

■ Example

    The following program prompts the user for team names and the names of
    players on each team. It then prints the players and their teams on the
    printer.

    LPRINT"Team Members"; TAB(76); "TEAM" : LPRINT
    INPUT "How many teams"; TEAMS
    INPUT "How many players per team";PPT
    PRINT
    FOR T = 1 TO TEAMS
        INPUT "Team name: ", TEAM$
        FOR P = 1 TO PPT
            INPUT "   Enter player name: ", PLAYER$
            LPRINT PLAYER$;
            IF P < PPT THEN
                IF LPOS(0) > 55 THEN     'Print a new line if print
                                        'head past column 55.
                    LPRINT : LPRINT "     ";
                ELSE
                    LPRINT ", ";           'Otherwise, print a comma.
                END IF
            END IF
        NEXT P
        LPRINT STRING$(80-LPOS(0)-LEN(TEAM$),"."); TEAM$
    NEXT T

""","LPRINT, LPRINT USING Statements" to """
■ Action

    Prints data on the printer LPT1:

■ Syntax 1

    LPRINT «expressionlist» «{;|,}»

■ Syntax 2

    LPRINT USING formatstring; expressionlist «{;|,}»

■ Remarks

    These statements function in the same way as the PRINT and PRINT USING
    statements except that output goes to the line printer and the filenumber
    option is not permitted.

    The LPRINT statement assumes an 80-character-wide printer. This width can
    be changed with a WIDTH LPRINT statement.
""","LSET Statement" to """
■ Action

    Moves data from memory to a random-access file buffer (in preparation for
    a PUT statement), copies one record variable to another, or left-justifies
    the value of a string in a string variable

■ Syntax

    LSET {stringvariable=stringexpression | stringexpression1=
    stringexpression2}

■ Remarks

    The stringvariable is usually a random-access file field defined in a
    FIELD statement, although it can be any string variable. The
    stringexpression is the value assigned to the variable.

    If stringexpression requires fewer bytes than were defined for
    stringvariable in the FIELD statement, the LSET function left-justifies
    the string in the field (RSET will right-justify the string). Spaces are
    used to pad the extra positions. If the string is too long for the field,
    both LSET and RSET truncate characters from the right. Numeric values must
    be converted to strings before they are justified with the LSET or RSET
    statements.
""","LTRIM$ Function" to """
■ Action

    Returns a copy of a string with leading spaces removed

■ Syntax

    LTRIM$(stringexpression)

■ Remarks

    The stringexpression can be any string expression.

■ See Also

    RTRIM$

■ Example

    This program copies a file to a new file, removing all leading and
    trailing spaces:

    CLS
    ' Get the file names.
    INPUT "Enter input file name:",InFile$
    INPUT "Enter output file name:",OutFile$

    OPEN InFile$ FOR INPUT AS #1
    OPEN OutFile$ FOR OUTPUT AS #2

    ' Read, trim, and write each line.
    DO WHILE NOT EOF(1)
        LINE INPUT #1,LineIn$
        ' Remove leading and trailing blanks.
        LineIn$=LTRIM$(RTRIM$(LineIn$))
        PRINT #2, LineIn$
    LOOP

    CLOSE #1,#2

    END

""","MID$ Function" to """
■ Action

    Returns a substring of a string

■ Syntax

    MID$(stringexpression,start«,length»)

■ Remarks

    The MID$ function takes the following arguments:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    stringexpression         The string expression that the substring is
                            extracted from. This can be any string
                            expression.

    start                    The character position in stringexpression where
                            the substring starts.

    length                   The number of characters to extract.
    ──────────────────────────────────────────────────────────────────────────

    The arguments start and length must be in the range 1 to 32,767. If length
    is omitted or if there are fewer than length characters to the right of
    the start character, the MID$ function returns all characters to the right
    of the start character.

    If start is greater than the number of characters in stringexpression,
    MID$ returns a null string.

    Use the LEN function to find the number of characters in stringexpression.

■ See Also

    LEFT$, LEN, MID$ Statement, RIGHT$

■ Example

    The following program converts a binary number to a decimal number. Digits
    are extracted from the binary number (input as a string) using MID$.

    INPUT "Binary number = ",Binary$   'Input binary number as
                                        'string.
    Length = LEN(Binary$)              'Get length of string.
    Decimal = 0

    FOR K = 1 TO Length
        'Get individual digits from string, from left to right.
        Digit$ = MID$(Binary$,K,1)
        'Test for valid binary digit.
        IF Digit$="0" OR Digit$="1" THEN
        'Convert digit characters to numbers.
        Decimal = 2*Decimal + VAL(Digit$)
        ELSE
        PRINT "Error--invalid binary digit: ";Digit$
        EXIT FOR
        END IF
    NEXT
    PRINT "Decimal number =" Decimal

■ Output

    Binary number = 10110
    Decimal number = 22

""","MID$ Statement" to """
■ Action

    Replaces a portion of a string variable with another string

■ Syntax

    MID$(stringvariable,start«,length»)=stringexpression

■ Remarks

    The MID$ statement has the following arguments:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    stringvariable           The string variable being modified.

    start                    A numeric expression giving the position in
                            stringvariable where the replacement starts.

    length                   The length of the string being replaced. The
                            length is a numeric expression.

    stringexpression         The string expression that replaces part of the
                            stringvariable.
    ──────────────────────────────────────────────────────────────────────────

    The arguments start and length are integer expressions. The argument
    stringvariable is a string variable, but stringexpression can be a string
    variable, a string constant, or a string expression.

    The optional length refers to the number of characters from the argument
    stringexpression that are used in the replacement. If length is omitted,
    all of stringexpression is used. However, regardless of whether length is
    omitted or included, the replacement of characters never goes beyond the
    original length of stringvariable.

■ See Also

    MID$ Function

■ Example

    The following example uses the MID$ statement to get characters from a
    string:

    Test$ = "Paris, France"
    PRINT Test$
    MID$(Test$,8)="Texas "
    PRINT Test$

■ Output

    Paris, France
    Paris, Texas

""","MKD$, MKI$, MKL$, MKS$ Functions" to """
■ Action

    Converts numeric values to string values

■ Syntax

    MKI$(integerexpression)
    MKS$(single-precision-expression)
    MKL$(long-integer-expression)
    MKD$(double-precision-expression)

■ Remarks

    The MKI$, MKS$, MKL$, and MKD$ functions are used with FIELD and PUT
    statements to write real numbers to a random-access file. The functions
    take numeric expressions and convert them to strings that can be stored in
    the strings defined in the FIELD statement. The functions are the inverse
    of CVI, CVS, CVL, and CVD.

    Function                 Description
    ──────────────────────────────────────────────────────────────────────────
    MKI$                     Converts an integer to a two-byte string

    MKS$                     Converts a single-precision value to a four-byte
                            string

    MKL$                     Converts a long-integer value to a four-byte
                            string

    MKD$                     Converts a double-precision value to an
                            eight-byte string
    ──────────────────────────────────────────────────────────────────────────
""","MKDIR Statement" to """
■ Action

    Creates a new directory

■ Syntax

    MKDIR pathname

■ Remarks

    The pathname is a string expression specifying the name of the directory
    to be created. The pathname must be a string of less than 128 characters.

    The MKDIR statement works like the DOS command MKDIR; the syntax in BASIC
    cannot, however, be shortened to MD, as in DOS.

■ See Also

    CHDIR, RMDIR

■ Example

    The following fragment creates a new directory (if the directory does not
    exist) and copies files into that directory:

    ON ERROR GOTO Errorhandler
    PRINT "This program creates a new directory named MONTHS"
    PRINT "in this directory, then creates files in that directory"
    MKDIR "MONTHS"
    DO
        INPUT "Filename"; File$
        IF File$ = "" THEN END
        OPEN "MONTHS\" + File$ FOR OUTPUT AS #1
        .
        .
        .
        CLOSE #1
    LOOP

    Errorhandler:
        'Error 75 means MONTHS directory already exists
        IF ERR = 75 THEN RESUME NEXT
        ON ERROR GOTO 0

""","MKSMBF$, MKDMBF$ Functions" to """
■ Action

    Converts an IEEE-format number to a string containing a Microsoft Binary
    format number.

■ Syntax

    MKSMBF$(single-precision-expression)
    MKDMBF$(double-precision-expression)

■ Remarks

    These functions are used to write real numbers to random-access files
    using Microsoft Binary format. They are particularly useful for
    maintaining data files created with older versions of BASIC.

    The MKSMBF$ and MKDMBF$ functions convert real numbers in IEEE-format to
    strings so they can be written to the random-access file.

    To write a real number to a random-access file in Microsoft Binary format,
    convert the number to a string using MKSMBF$ (for a single-precision
    number) or MKDMBF$ (for a double-precision number). Then store the result
    in the corresponding field (defined in the FIELD statement) and write the
    record to the file using the PUT statement.

■ Example

    The following example uses MKSMBF$ to store real values in a file as
    Microsoft Binary format numbers:

    ' Read a name and a test score from the console.
    ' Store as a record in a random-access file.
    ' Scores are written out as
    ' Microsoft Binary format single-precision values.

    TYPE Buffer
        NameField AS STRING * 20
        ScoreField AS STRING * 4
    END TYPE

    DIM RecBuffer AS Buffer
    OPEN "TESTDAT.DAT" FOR RANDOM AS #1 LEN=LEN(RecBuffer)

    PRINT "Enter names and scores, one name and score per line."
    PRINT "Enter END, 0 to end input."

    INPUT NameIn$, Score

    I=0

    ' Read pairs of names and scores from the console
    ' until the name is END.

    DO WHILE UCASE$(NameIn$) <> "END"
        I=I+1
        RecBuffer.NameField=NameIn$

    ' Convert the score to a string.
        RecBuffer.ScoreField=MKSMBF$(Score)
        PUT #1,I,RecBuffer
        INPUT NameIn$, Score
    LOOP

    PRINT I;" records written."

    CLOSE #1

""","NAME Statement" to """
■ Action

    Changes the name of a disk file or directory

■ Syntax

    NAME oldfilename AS newfilename

■ Remarks

    The NAME statement is similar to the DOS RENAME command. NAME can move a
    file from one directory to another but cannot move a directory.

    The arguments oldfilename and newfilename are string expressions each of
    which contains a file or directory name and an optional path. If the path
    in newfilename is different from the path in oldfilename, the NAME
    statement changes the pathname as well as renames the file as indicated.

    A file named oldfilename must exist and the newfilename must not be in
    use. Both files must be on the same drive. Using NAME with different drive
    designations in the old and new file names produces an error message that
    reads Rename across disks.

    After a NAME statement, the file or directory exists on the same disk, in
    the same disk space, but with the new name.

    Using NAME on an open file causes a run-time error message reading File
    already open. You must close an open file before renaming it.

■ Examples

    The following statements show NAME used with and without a path
    specification:

    'Changes the name of file ACCTS to LEDGER.
    NAME "ACCTS" AS "LEDGER"

    'Moves file CLIENTS from directory X to directory \XYZ\P.
    NAME "\X\CLIENTS" AS "\XYZ\P\CLIENTS"

""","OCT$ Function" to """
■ Action

    Returns a string representing the octal value of the numeric argument

■ Syntax

    OCT$(numeric-expression)

■ Remarks

    The numeric-expression may be of any type. The numeric-expression is
    rounded to an integer or long integer before the OCT$ function evaluates
    it.

■ See Also

    HEX$

■ Example

    The following line prints the octal representation of 24:

    PRINT OCT$(24)

■ Output

    30

""","ON ERROR Statement" to """
■ Action

    Enables error handling and specifies the first line of the error-handling
    routine

■ Syntax

    ON ERROR GOTO line

■ Remarks

    The line argument is the line number or line label of the first line in
    the error-handling routine. This line must appear in module-level code.

    If line cannot be found in the module where the error occurred, or if
    there is no ON ERROR GOTO statement, a backward search is made through the
    modules that invoked the module with the error. If an active error handler
    is found, it is used. If no active error handler is found, an error
    message is printed and program execution halts. The specific error message
    depends on the type of error.

    Only modules in the invocation path are searched. Modules outside the path
    are not searched, even if there is no active error handler in the search
    path.

    A line number of 0 disables error handling. It does not specify line 0 as
    the start of the error-handling code, even if the program contains a line
    numbered 0. Subsequent errors print an error message and halt the program.
    Once error handling is enabled, any error that can be trapped causes a
    jump to the specified error-handling routine.

    Inside an error handler, executing an ON ERROR statement with a line
    number of 0 halts program execution and prints the error message for the
    error that caused the trap. This is a convenient way to halt a program in
    response to errors that cannot be processed by the error-handling routine.

    Note that an error-handling routine is not a SUB or FUNCTION procedure or
    a DEF FN function. An error-handling routine is a module-level block of
    code marked by a line label or line number.
""","ON UEVENT GOSUB Statement" to """
■ Action

    Defines the event-handler for a user-defined event

■ Syntax

    ON UEVENT GOSUB { linenumber | linelabel }

■ Remarks

    The linenumber or linelabel argument is the number or label of the first
    line in the event-handling routine. ON UEVENT GOSUB lets your program
    branch to an event-handling routine when a user-defined event occurs. The
    event is usually a hardware interrupt.

    This gives user-defined events one of the features enjoyed by the COM,
    KEY, and other events in BASIC. Once these events have been defined with
    an ON event statement, they act like interrupts. The program does not need
    to poll for the event.

    Likewise, once ON UEVENT GOSUB and UEVENT ON have been executed, the
    user-defined event automatically triggers execution of the BASIC routine
    to handle it. The program does not have to poll.

    At least two (and sometimes three) pieces of code are needed to set up a
    user-defined event. The first is the interrupt service routine. The second
    is an initialization routine to insert the address of the service routine
    into the interrupt vector table. The third is the routine your BASIC
    program calls to retrieve the data (if any) collected by the interrupt
    service routine.

    If the initialization routine "steals" an interrupt used by another
    service routine, the original address must be restored before your program
    terminates.

    These routines are usually written in assembly language. However, any
    language whose compiler can generate interrupt service routines and whose
    object code can be linked with BASIC may be used.

    There are four steps in creating a user-defined event:

    1. Write an event-handling routine and add it to your BASIC program.

    2. Execute the ON UEVENT GOSUB statement to specify the user-event
        handling routine.

    3. Execute the UEVENT ON statement to enable user-event trapping.

    4. Call the interrupt-initialization routine to insert the address of the
        interrupt service routine into the interrupt vector table.

    You're now ready for the interrupt when it occurs. The interrupt transfers
    execution to the interrupt service routine. The service routine collects
    and stores the data the user wants. It then calls SetUEvent.

    SetUEvent sets a flag checked by QuickBASIC before going to the next BASIC
    statement (or label if executing compiled code using /W instead of /V).
    When the flag is set, control transfers to the event-handling routine
    designated in ON UEVENT GOSUB.

    The SetUEvent procedure is a part of BASIC, and is automatically included
    in compiled applications or when running QuickBASIC with the /L
    command-line option. Your interrupt service routine must call SetUEvent;
    it is the only way to alert your program that the event has occurred. You
    can call SetUEvent from any language, not just from assembly language.

    SetUEvent is not a function; it cannot return a value to BASIC. If you
    wish to return a value, you must write a function for your BASIC program
    to call. (It would usually be called by your event-handling routine.) This
    function must be described in a DECLARE statement so your BASIC program
    can find and use it.

    Although ON UEVENT GOSUB ties an event-handling routine to a user-defined
    event, it does not enable the event trap. The UEVENT statement is used to
    enable, disable, and suspend user-defined event trapping.

■ See Also

    UEVENT

■ Example

    The following example illustrates the use of ON UEVENT GOSUB:

    DECLARE SUB test (a)
    ON UEVENT GOSUB Event1
    UEVENT ON
    INPUT "Enter a number";a
    CALL test(a)
    END
    Event1:
    PRINT "Got to the event handler"
    RETURN
    SUB test(a)
    IF a=5 THEN CALL SetUEvent
    END SUB

""","OPEN Statement" to """
■ Action

    Enables I/O to a file or device

■ Syntax 1

    OPEN file «FOR mode1» «ACCESS access» «lock» AS
    «#» filenum «LEN=reclen»

■ Syntax 2

    OPEN  mode2,«#»filenum, file «,reclen»

■ Remarks

    The file is a string expression that specifies an optional device,
    followed by a file name or path name conforming to the DOS file-naming
    conventions.

    You must open a file before any I/O operation can be performed on it. OPEN
    allocates a buffer for I/O to the file or device and determines the mode
    of access used with the buffer.

    SYNTAX 1

    In the first syntax, mode1 is one of the following:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Mode                     Description
    ──────────────────────────────────────────────────────────────────────────
    OUTPUT                   Specifies sequential output mode.

    Mode                     Description
    ──────────────────────────────────────────────────────────────────────────

    INPUT                    Specifies sequential input mode.

    APPEND                   Specifies sequential output mode and sets the
                            file pointer to the end of file and the record
                            number to the last record of the file. A PRINT #
                            or WRITE # statement then extends (appends to)
                            the file.

    RANDOM                   Specifies random-access file mode, the default
                            mode. In RANDOM mode, if no ACCESS clause is
                            present, three attempts are made to open the file
                            when the OPEN statement is executed. Access is
                            attempted in the following order:

                            1. Read/write

                            2. Write-only

    Mode                     Description
    ──────────────────────────────────────────────────────────────────────────

                            3. Read-only

    BINARY                   Specifies binary file mode. In binary mode, you
                            may read or write information to any byte
                            position in the file using GET and PUT.
                            In binary mode, if no ACCESS clause is present,
                            three attempts are made to open the file. The
                            attempts follow the same order as those for
                            RANDOM files.
    ──────────────────────────────────────────────────────────────────────────


    If mode1 is omitted, the default random-access mode is assumed.

    The access expression specifies the operation performed on the opened
    file. If the file is already opened by another process and the specified
    type of access is not allowed, the OPEN fails and an error message is
    generated that reads Permission denied. The ACCESS clause works in an OPEN
    statement only if you are using a version of DOS that supports networking
    (DOS Versions 3.0 or later). In addition, you must run the SHARE.EXE
    program (or the network startup program must run it) to perform any
    locking operation. If ACCESS is used with OPEN, earlier versions of DOS
    return an error message that reads Advanced feature unavailable.

    The access argument can be one of the following:

    Access Type              Description
    ──────────────────────────────────────────────────────────────────────────
    READ                     Opens the file for reading only.

    WRITE                    Opens the file for writing only.

    READ WRITE               Opens the file for both reading and writing. This
                            mode is valid only for RANDOM and BINARY files
                            and files opened for APPEND.
    ──────────────────────────────────────────────────────────────────────────

    The lock clause works in a multiprocessing environment to restrict access
    by other processes to an open file. The lock types are as follows:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Lock Type                Description
    ──────────────────────────────────────────────────────────────────────────
    Default                  If locktype is not specified, the file may be
                            opened for reading and writing any number of
                            times by this process, but other processes are
                            denied access to the file while it is opened.

    SHARED                   Any process on any machine may read from or write
                            to this file. Do not confuse the SHARED lock type
                            with the SHARED statement or the SHARED attribute
                            appearing in other statements.

    LOCK READ                No other process is granted read access to this
                            file. This access is granted only if no other
                            process has a previous READ access to the file.

    LOCK WRITE               No other process is granted write access to this
                            file. This lock is granted only if no other
                            process has a previous WRITE access to the file.
    Lock Type                Description
    ──────────────────────────────────────────────────────────────────────────
                            process has a previous WRITE access to the file.

    LOCK READ WRITE          No other process is granted either read or write
                            access to this file. This access is granted only
                            if READ or WRITE access has not already been
                            granted to another process, or if a LOCK READ or
                            LOCK WRITE is not already in place.
    ──────────────────────────────────────────────────────────────────────────


    When the OPEN is restricted by a previous process, it generates error 70,
    Permission denied, under DOS.

    The filenum (file number) argument is an integer expression whose value is
    between 1 and 255. When an OPEN is executed, the file number is associated
    with the file as long as it is open. Other I/O statements may use the
    number to refer to the file.

    The reclen (record length) argument is an integer expression that, if
    included, sets the record length (number of characters in one record) for
    random-access files. For sequential files, the default length for records
    is 512 bytes; for random-access files, the default is 128 bytes. The value
    of reclen cannot exceed 32,767 bytes. If the file mode is binary, then the
    LEN clause is ignored.

    For sequential files, reclen need not correspond to an individual record
    size, since a sequential file may have records of different sizes. When
    used to open a sequential file, reclen specifies the number of characters
    to be loaded into the buffer before the buffer is written to, or read
    from, the disk. A larger buffer means more room taken from BASIC, but
    faster file I/O. A smaller buffer means more room in memory for BASIC, but
    slower I/O. The default buffer size is 512 bytes.

    SYNTAX 2

    In the second form of the OPEN syntax, mode2 is a string expression the
    first character of which must be one of the following:

    Mode                     Description
    ──────────────────────────────────────────────────────────────────────────
    O                        Specifies sequential output mode.

    I                        Specifies sequential input mode.

    R                        Specifies random-access file input/output mode.

    B                        Specifies binary file mode.

    A                        Specifies sequential output mode and sets the
                            file pointer to the end of the file and the
                            record number to the last record of the file. A
                            PRINT # or WRITE # statement extends (appends to)
                            the file.
    ──────────────────────────────────────────────────────────────────────────
""","OPEN COM Statement" to """
■ Action

    Opens and initializes a communications channel for I/O

■ Syntax

    OPEN "COMn: optlist1 optlist2" «FOR mode» AS «#»filenum «LEN=reclen»

■ Remarks

    COMn: is the name of the device to be opened. The n argument is the number
    of a legal communications device, such as COM1: or COM2:. The first list
    of options, optlist1, has the following form:

    «speed»«,«parity» «,«data»«,«stop»»»»

    The following list describes the possible options:

    Option                   Description
    ──────────────────────────────────────────────────────────────────────────
    speed                    The "baud" rate (baud means "bits per second") of
                            the device to be opened. Valid speeds are 75,
                            110, 150, 300, 600, 1200, 1800, 2400, 4800, and
                            9600. The default is 300 bps.

    parity                   The parity of the device to be opened. Valid
                            entries for parity are: N (none), E (even), O
                            (odd), S (space), or M (mark).

    data                     The number of data bits per byte. Valid entries
                            are 5, 6, 7, or 8.

    stop                     The number of stop bits. Valid entries are 1,
                            1.5, or 2.
    ──────────────────────────────────────────────────────────────────────────

    Options from this list must be entered in the order shown; moreover, if
    any options from optlist2 are chosen, comma placeholders must still be
    used even if none of the options from optlist1 are chosen. For example:

    OPEN "COM1: ,,,,CD1500" FOR INPUT AS #1

    If you set the data bits per byte to eight, you must specify no parity
    (N). Because QuickBASIC uses complete bytes (eight bits) for numbers, you
    must specify eight data bits when transmitting or receiving numeric data.

    The choices for optlist2 are described in the following list. The argument
    m is given in milliseconds; the default value for m is 1000.

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Option                   Description
    ──────────────────────────────────────────────────────────────────────────
    ASC                      Opens the device in ASCII mode. In ASCII mode,
    Option                   Description
    ──────────────────────────────────────────────────────────────────────────
    ASC                      Opens the device in ASCII mode. In ASCII mode,
                            tabs are expanded to spaces, carriage returns are
                            forced at end-of-line, and CTRL+Z is treated as
                            end-of-file. When the channel is closed, CTRL+Z
                            is sent over the RS-232 line.

    BIN                      Opens the device in binary mode. This option
                            supersedes the LF option. BIN is selected by
                            default unless ASC is specified.
                            In the BIN mode, tabs are not expanded to spaces,
                            a carriage return is not forced at the
                            end-of-line, and CTRL+Z is not treated as
                            end-of-file. When the channel is closed, CTRL+Z
                            will not be sent over the RS-232 line.

    CD«m»                    Controls the timeout on the Data Carrier Detect
                            line (DCD). If DCD is low for more than m
                            milliseconds, a device timeout occurs.

    Option                   Description
    ──────────────────────────────────────────────────────────────────────────

    CS«m»                    Controls the timeout on the Clear To Send line
                            (CTS). If CTS is low (there is no signal) for
                            more than m milliseconds, a device timeout
                            occurs.

    DS«m»                    Controls the timeout on the Data Set Ready line
                            (DSR). If DSR is low for more than m
                            milliseconds, a device timeout occurs.

    LF                       Allows communication files to be printed on a
                            serial line printer. When LF is specified, a
                            line-feed character (0AH) is automatically sent
                            after each carriage-return character (0DH). This
                            includes the carriage return sent as a result of
                            the width setting. Note that INPUT and LINE
                            INPUT, when used to read from a COM file that was
                            opened with the LF option, stop when they see a
                            carriage return, ignoring the line feed.
    Option                   Description
    ──────────────────────────────────────────────────────────────────────────
                            carriage return, ignoring the line feed.

    OP«m»                    Controls how long the statement waits for the
                            open to be successful. The parameter m is a value
                            in the range 0 to 65,535 representing the number
                            of milliseconds to wait for the communications
                            lines to become active. If OP is specified
                            without a value, the statement waits
                            indefinitely. If OP is omitted, OPEN COM waits
                            for ten times the maximum value of the CD or DS
                            timeout values.

    RB«n»                    Sets the size of the receive buffer to n bytes.
                            If n is omitted, or the option is omitted, the
                            current value is used. The current value can be
                            set by the /C option on the QuickBASIC or BC
                            command line. The default is 512 bytes. The
                            maximum size is 32,767 bytes.

    Option                   Description
    ──────────────────────────────────────────────────────────────────────────

    RS                       Suppresses detection of Request To Send (RTS).

    TB«n»                    Sets the size of the transmit buffer to n bytes.
                            If n is omitted, or the option is omitted, the
                            current value is used. The default size is 512
                            bytes.
    ──────────────────────────────────────────────────────────────────────────


    The options from the list above can be entered in any order, but they must
    be separated from one another by commas. For CS«m», DS«m», and CD«m», if
    there is no signal within m milliseconds, a timeout occurs. The value for
    m may range from 0 to 65,535, with 1000 as the default value. (The CD
    default is 0.) If m is equal to 0 for any of these options the option is
    ignored. The CTS line is checked whenever there is data in the transmit
    buffer if the CS option is specified. The DSR and DCD lines are
    continuously checked for timeouts if the corresponding options (DS, CD)
    are specified.

    The mode argument is one of the following string expressions:

    Mode                     Description
    ──────────────────────────────────────────────────────────────────────────
    OUTPUT                   Specifies sequential output mode
    INPUT                    Specifies sequential input mode
    RANDOM                   Specifies random-access mode
    ──────────────────────────────────────────────────────────────────────────

    If the mode expression is omitted, it is assumed to be random-access
    input/output. The filenum is the number used to open the file. The OPEN
    COM statement must be executed before a device can be used for
    communication using an RS-232 interface.

    If the device is opened in RANDOM mode, the LEN option specifies the
    length of an associated random-access buffer. The default value for length
    is 128. You can use any of the random-access I/O statements, such as GET
    and PUT, to treat the device as if it were a random-access file. The OPEN
    COM statement performs the following steps in opening a communications
    device:

    1. The communications buffers are allocated and interrupts are enabled.

    2. The Data Terminal Ready line (DTR) is set high.

    3. If either of the OP or DS options is nonzero, the statement waits up to
        the indicated time for the Data Set Ready line (DSR) to be high. If a
        timeout occurs, the process goes to step 6.

    4. The Request To Send line (RTS) is set high if the RS option is not
        specified.

    5. If either of the OP or CD options is nonzero, OPEN COM waits up to the
        indicated time for the Data Carrier Detect line (DCD) to be high. If a
        timeout occurs, the process goes to step 6. Otherwise, OPEN COM has
        succeeded.

    6. The open has failed due to a timeout. The process deallocates the
        buffers, disables interrupts, and clears all of the control lines.
""","OPTION BASE Statement" to """
■ Action

    Declares the default lower bound for array subscripts

■ Syntax

    OPTION BASE n

■ Remarks

    The OPTION BASE statement is never required. It is used to change the
    default lower bound for array subscripts.

    The value of n must be either 0 or 1. The default base is 0. If the
    following statement

    OPTION BASE 1

    is executed, the lowest value an array subscript can have is 1.
""","OUT Statement" to """
■ Action

    Sends a byte to a machine I/O port

■ Syntax

    OUT port, data

■ Remarks

    The following list describes the arguments of the OUT statement:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    port                     The number of the port. The number must be an
                            integer expression in the range 0-65,535.

    data                     The data to be sent to the port. It must be an
                            integer expression in the range 0-255.
    ──────────────────────────────────────────────────────────────────────────

    The OUT and INP statements give a BASIC program direct control over the
    hardware in a system through the I/O ports. These statements must be used
    carefully because they directly manipulate the hardware.

■ See Also

    INP, WAIT

■ Example

    The following example uses OUT and INP to control the timer and speaker to
    produce a note. (This example is specific to the IBM PC and close
    compatibles and produces unpredictable results on other machines.)

    ' Play a scale using the speaker and timer.
    CONST WHOLE=5000!, QRTR=WHOLE/4.
    CONST C=523.0, D=587.33, E=659.26, F=698.46, G=783.99, A=880.00
    CONST B=987.77, C1=1046.50
    CALL Sounds(C,QRTR) : CALL Sounds(D,QRTR)
    CALL Sounds(E,QRTR) : CALL Sounds(F,QRTR)
    CALL Sounds(G,QRTR) : CALL Sounds(A,QRTR)
    CALL Sounds(B,QRTR) : CALL Sounds(C1,WHOLE)

    ' Use ports 66, 67, and 97 to control the timer and speaker
    ' to produce a sound.
    SUB Sounds (Freq!,Length!) STATIC

    ' Divide the clock frequency by the sound frequency to
    ' get the number of "clicks" the clock must produce.
        Clicks%=CINT(1193280!/Freq!)
        LoByte%=Clicks% AND &H00FF
        HiByte%=Clicks%\256
    ' Tell timer that data is coming.
        OUT 67,182
    ' Send the low byte followed by the high byte of the count.
        OUT 66,LoByte%
        OUT 66,HiByte%
    ' Turn the speaker on by setting bits 0 and 1 of the PPI chip.
    ' Get the current value, and turn the bits on.
        SpkrOn%=INP(97) OR &H03
        OUT 97,SpkrOn%
    ' Leave the speaker on for a while.
        FOR I!=1 TO Length! : NEXT I!
    ' Turn the speaker off.
        SpkrOff%=INP(97) AND &HFC
        OUT 97,SpkrOff%

    END SUB

""","PAINT Statement" to """
■ Action

    Fills a graphics area with the color or pattern specified

■ Syntax

    PAINT «STEP» (x,y)«,«paint» «,«bordercolor» «,background»»»

■ Remarks

    The following list describes the parts of the PAINT statement:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
    STEP                     Defines coordinates to be relative to the most
                            recently plotted point. For example, if the last
                            point plotted were (10,10), then the coordinates
                            referred to by STEP (4,5) would be (4+10, 5+10)
                            or (14,15).

    (x,y)                    The coordinates where painting begins. The point
                            must be inside or outside a figure, not on the
                            border itself. If this point is inside, the
                            figure's interior is painted; if the point is on
                            the outside, the background is painted.

    paint                    A numeric or string expression. If paint is a
                            numeric expression, then the number must be a
                            valid color attribute. The corresponding color is
    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
                            valid color attribute. The corresponding color is
                            used to paint the area. If you do not specify
                            paint, the foreground color attribute is used.
                            (See the COLOR, PALETTE, and SCREEN statements
                            for discussions of valid colors, numbers, and
                            attributes.)

                            If the paint argument is a string expression,
                            then PAINT does "tiling," a process that paints a
                            pattern rather than a solid color. Tiling is
                            similar to "line styling," which creates dashed
                            lines rather than solid lines.

    bordercolor              A numeric expression identifying the color
                            attribute to use to paint the border of the
                            figure. When the border color is encountered,
                            painting of the current line stops. If the border
                            color is not specified, the paint argument is
                            used.
    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
                            used.

    background               A string value giving the "background tile slice"
                            to skip when checking for termination of the
                            boundary. Painting is terminated when adjacent
                            points display the paint color. Specifying a
                            background tile slice allows you to paint over an
                            already painted area. When you omit background
                            the default is CHR$ (0).
    ──────────────────────────────────────────────────────────────────────────


    Painting is complete when a line is painted without changing the color of
    any pixel, in other words, when the entire line is equal to the paint
    color. The PAINT command permits coordinates outside the screen or
    viewport.

    Tiling

    "Tiling" is the design of a PAINT pattern that is eight bits wide and up
    to 64 bytes long. In the tile string, each byte masks eight bits along the
    x-axis when putting down points. The syntax for constructing this tile
    mask is

    PAINT (x,y), CHR$(arg1)+CHR$(arg2)+...+CHR$(argn)

    The arguments to CHR$ are numbers between 0 and 255, represented in binary
    form across the x axis of the tile. There can be up to 64 of these CHR$
    elements; each generates an image not of the assigned character, but of
    the bit arrangement of the code for that character. For example, the
    decimal number 85 is binary 01010101; the graphic image line on a
    black-and-white screen generated by CHR$(85) is an eight-pixel line, with
    even-numbered points white and odd-numbered points black. That is, each
    bit equal to 1 turns the associated pixel on and each bit equal to 0 turns
    the associated bit off in a black-and-white system. The ASCII character
    CHR$(85), which is U, is not displayed in this case.

    When supplied, background defines the "background tile slice" to skip when
    checking for boundary termination. You cannot specify more than two
    consecutive bytes that match the tile string in the tile background slice.
    Specifying more than two consecutive bytes produces an error message that
    reads Illegal function call.

    Tiling can also be done to produce various patterns of different colors.
    See Chapter 5, "Graphics," in Programming in BASIC for a complete
    description of how to do tiling.

■ See Also

    CHR$, CIRCLE, DRAW, LINE, SCREEN

■ Example

    The following program draws a magenta fish with a cyan tail:

    CONST PI=3.1415926536
    CLS
    SCREEN 1

    CIRCLE (190,100),100,1,,,.3   'Outline fish body in cyan.
    CIRCLE (265,92),5,1,,,.7      'Outline fish eye in cyan.
    PAINT (190,100),2,1           'Fill in fish body with magenta.

    LINE (40,120)-STEP (0,-40),2  'Outline
    LINE -STEP (60,+20),2         '   tail in
    LINE -STEP (-60,+20),2        '      magenta.
    PAINT (50,100),1,2            'Paint tail cyan.

    CIRCLE (250,100),30,0,PI*3/4,PI* 5/4,1.5  'Draw
    gills in black.
    FOR Y = 90 TO 110 STEP 4
        LINE (40,Y)-(52,Y),0       'Draw comb in tail.
    NEXT

""","PALETTE, PALETTE USING Statements" to """
■ Action

    Changes one or more of the colors in the palette

■ Syntax

    PALETTE «attribute,color»
    PALETTE USING array-name «(array-index)»

■ Remarks

    The PALETTE statement takes the following arguments:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    attribute                The palette attribute to be changed.

    color                    The display color number to be assigned to the
                            attribute. The color must be a long integer
                            expression for the IBM Video Graphics Array
                            adapter (VGA) and IBM Multicolor Graphics Array
                            adapter (MCGA) in screen modes 11 to 13. Integer
                            or long-integer expressions may be used with the
    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
                            or long-integer expressions may be used with the
                            IBM Enhanced Graphics Adapter (EGA).

    array-name               An array containing the color numbers to be
                            assigned to the attributes available in the
                            current screen mode. The VGA and MCGA adapters
                            require a long integer array in screen modes 11
                            to 13. With the EGA this can be either an integer
                            or long-integer array.

    array-index              The index of the first array element to use in
                            setting the palette.
    ──────────────────────────────────────────────────────────────────────────


    The PALETTE statement works only on systems equipped with the EGA, VGA, or
    MCGA adapters.

    The statement provides a way of mapping display colors (the actual binary
    values used by the adapter) to color attributes (a smaller set of values).
    All BASIC graphics statements such as CIRCLE, COLOR, DRAW, or LINE use
    color attributes rather than display-color values.

    When a program enters a screen mode, the attributes are set to a series of
    default color values. (See the SCREEN statement for a list of the default
    colors.) In the EGA, VGA, and MCGA adapters these default values have been
    selected so the display shows the same colors, even though the EGA uses
    different color values.

    With the palette statement you can assign different colors to the
    attributes, giving you greater control over the colors on the display. A
    PALETTE statement with no arguments sets the palette back to the default
    color values.

    When you execute a PALETTE statement with arguments, the adapter
    subsequently uses the display color (indicated by color) whenever the
    value attribute appears in a statement like DRAW or LINE that specifies a
    color. Changing the display color assigned to an attribute changes the
    color on the screen immediately.

    For example, assume that the current palette contains colors 0, 1, 2, and
    3 in the four attributes numbered 0, 1, 2, and 3. The DRAW statement

    DRAW "C3L100"

    selects attribute 3, and draws a line of 100 pixels using the display
    color associated with attribute 3, in this case also 3. If the statement

    PALETTE 3,2

    is executed, then the color associated with attribute 3 is changed to
    color 2. All text or graphics currently on the screen displayed using
    attribute 3 are instantaneously changed to color 2. Text or graphics
    subsequently displayed with attribute 3 are also displayed in color 2. The
    new palette of colors contains 0, 1, 2, and 2.

    With the USING option, all entries in the palette can be modified in one
    PALETTE statement. The array-name argument is the name of an integer or
    long-integer array and the array-index specifies the index of the first
    array element in the array-name to use in setting the palette. Each
    attribute in the palette is assigned a corresponding color from this
    array. The array must be dimensioned large enough to set all the palette
    entries after array-index. For example, if you are assigning colors to all
    16 attributes, and the index of the first array element that is given in
    your PALETTE USING statement is 5, then the array must be dimensioned to
    hold at least 20 elements (since the number of elements from 5-20,
    inclusive, is 16):

    DIM PAL%(20)
    .
    .
    .
    PALETTE USING PAL%(5)

    A color argument of -1 in the array leaves the attribute unchanged. All
    other negative numbers are invalid values for color.

    You can use the COLOR statement to set the default foreground color and
    the background display color. The foreground color argument specifies the
    way text characters appear on the display screen. Under a common initial
    palette setting, points colored with the attribute 0 appear black on the
    display screen. Using the PALETTE statement, you could, for example,
    change the mapping of attribute 0 from black to white. Table R.5 lists
    attribute and color ranges for various adapter types and screen modes.

    Table R.5   Screen Color and Attribute Ranges

╓┌─┌───────────┌────────────────────────┌───────────┌────────────┌───────────╖
    Screen      Monitor                              Attribute    Color
    Mode        Attached                 Adapter     Range        Range
    ──────────────────────────────────────────────────────────────────────────
    0           Monochrome               MDPA        0-15         N/A☼
                Monochrome               EGA         0-15         0-2
                Color                    CGA         0-15         N/A
                Color/Enhanced☼          EGA         0-15         0-63
                N/A                      VGA         0-15         0-63
                N/A                      MCGA        0-15         N/A
    1           Color                    CGA         0-3          N/A
                Color/Enhanced☼          EGA         0-3          0-15
                N/A                      VGA         0-3          0-15
                N/A                      MCGA        0-3          N/A
    2           Color                    CGA         0-1          N/A
                Color/Enhanced☼          EGA         0-1          0-15
    Screen      Monitor                              Attribute    Color
    Mode        Attached                 Adapter     Range        Range
    ──────────────────────────────────────────────────────────────────────────
                Color/Enhanced☼          EGA         0-1          0-15
                N/A                      VGA         0-1          0-15
                N/A                      MCGA        0-1          N/A
    7           Color/Enhanced☼          EGA         0-15         0-15
                N/A                      VGA         0-15         0-15
    8           Color/Enhanced☼          EGA         0-15         0-15
                N/A                      VGA         0-15         0-15
    9           Enhanced☼                EGA☼        0-3          0-63
                Enhanced☼                EGA☼        0-15         0-63
                N/A                      VGA         0-16         0-63
    10          Monochrome               EGA         0-3          0-8
                N/A                      VGA         0-3          0-8
    11          N/A                      VGA         0-1          0-262,143☼
                N/A                      MCGA        0-1          0-262,143☼
    12          N/A                      VGA         0-15         0-262,143☼
    13          N/A                      VGA         0-255        0-262,143☼
                N/A                      MCGA        0-255        0-262,143☼
    ──────────────────────────────────────────────────────────────────────────
    Screen      Monitor                              Attribute    Color
    Mode        Attached                 Adapter     Range        Range
    ──────────────────────────────────────────────────────────────────────────
    ──────────────────────────────────────────────────────────────────────────


    The VGA uses a different way of calculating color values from the EGA. To
    calculate a color value, select the intensities of red, green, and blue.
    The intensity of a color is a number from 0 (low intensity) to 63 (high
    intensity). Then use the following formula to calculate the actual color
    number:

    color number = 65536 * blue + 256 * green + red

    Because there are gaps in the range of color numbers, you should use the
    formula rather than just select a number.

    When used with the IBM Analog Monochrome Monitor, the VGA color values are
    converted to a gray-scale value by taking a weighted sum of the red, blue,
    and green intensities as follows:

    gray value = 11% blue + 59% green + 30% red

    For example if the blue, green, and red intensities are 45, 20, and 20,
    the gray value would be .11*45+.59*20+.30*20 or 22 (the fraction in the
    result is dropped).

    See the SCREEN statement for the list of colors available for various
    screen-mode, monitor, and graphics-adapter combinations.
""","PCOPY Statement" to """
■ Action

    Copies one screen page to another

■ Syntax

    PCOPY sourcepage, destinationpage

■ Remarks

    The sourcepage is an integer expression in the range 0 to n, where n is
    the maximum number of pages determined by the current video-memory size
    and the size per page for the current screen mode.

    The destinationpage has the same requirements as the sourcepage.

    See the SCREEN statement for more information about the number of pages
    available in different modes.

■ See Also

    CLEAR, SCREEN

■ Example

    The following example copies the contents of page 1 to page 2:

    PCOPY 1,2

""","PEEK Function" to """
■ Action

    Returns the byte stored at a specified memory location

■ Syntax

    PEEK(address)

■ Remarks

    The returned value is an integer in the range 0-255. The argument address
    is a value in the range 0-65,535. The argument address is treated as the
    offset from the current default segment (as set by the DEF SEG statement).

    If the argument is a single- or double-precision floating-point value or a
    long integer, it is converted to a two-byte integer.

    The PEEK function complements the POKE statement.

■ See Also

    DEF SEG, POKE, VARPTR

■ Example

    See the example for DEF SEG.

""","PEN Function" to """
■ Action

    Reads the lightpen coordinates

■ Syntax

    PEN(n)

■ Remarks

    The argument n indicates what value is to be returned. It is a numeric
    expression in the range 0-9.
""","PEN ON, OFF, and STOP Statements" to """
■ Action

    Enables, disables, or suspends lightpen-event trapping

■ Syntax

    PEN ON
    PEN OFF
    PEN STOP

■ Remarks

    The PEN ON statement enables lightpen-event trapping by using an ON PEN
    statement. The pen is initially off. A lightpen event occurs whenever the
    lightpen is activated by pressing the tip to the screen or pressing the
    touch ring. A PEN ON statement must be executed before any read-pen
    function calls. If a read-pen function is called when the pen is off, an
    error message results that reads Illegal function call.

    The PEN OFF statement disables lightpen event trapping. The PEN STOP
    statement suspends lightpen event trapping; a pen event is remembered and
    trapped as soon as event trapping is enabled.

    To speed program execution, the pen should be turned off by using a PEN
    OFF statement when pen trapping is not needed.
""","PLAY Function" to """
■ Action

    Returns the number of notes currently in the background-music queue

■ Syntax

    PLAY (n)

■ Remarks

    The argument n is a dummy argument and may be any numeric value.

    PLAY(n) will return 0 when the user is in music-foreground mode.

■ See Also

    ON event; PLAY Statement; PLAY ON, OFF, and STOP

■ Example

    See the examples for the ON event statements.

""","PLAY Statement" to """
■ Action

    Plays music as specified by a string

■ Syntax

    PLAY commandstring

■ Remarks

    The commandstring is a string expression containing one or more of the
    commands listed below.

    The PLAY statement uses a concept similar to DRAW in that it embeds a
    music macro language (described below) in one statement. A set of
    commands, used as part of the PLAY statement, specifies a particular
    action.

    In compiled programs, you should use the VARPTR$(variable) form for
    variables. For example, the BASICA statements

    PLAY "XA$"
    PLAY "O=I"

    should be written for the compiler like this:

    PLAY "X" + VARPTR$(A$)
    PLAY "O=" + VARPTR$(I)

    The commandstring music macros are described as follows:

    Octave Commands          Action
    ──────────────────────────────────────────────────────────────────────────
    o n                      Sets the current octave. There are seven octaves,
                            numbered 0-6.

    >                        Increases octave by 1. Octave cannot go beyond 6.

    <                        Decreases octave by 1. Octave cannot drop below
                            0.

    Tone Commands            Action
    ──────────────────────────────────────────────────────────────────────────
    A-G                      Plays a note in the range A-G. The "#" symbol or
                            the "+" symbol after a note specifies sharp; a
                            "-" specifies flat.

    N n                      Plays note n. The range for n is 0-84 (in the
                            seven possible octaves, there are 84 notes); n =
                            0 means a rest.

    Duration Commands        Action
    ──────────────────────────────────────────────────────────────────────────
    L n                      Sets the length of each note. L4 is a quarter
                            note, L1 is a whole note, etc. The range for n is
                            1-64.
                            The length may also follow the note when a change
                            of length only is desired for a particular note.
                            In this case, A16 is equivalent to L16A.

    MN                       Sets "music normal" so that each note will play
                            7/8 of the time determined by the length (L).

    ML                       Sets "music legato" so that each note will play
                            the full period set by length (L).

    MS                       Sets "music staccato" so that each note will play
                            3/4 of the time determined by the length (L).

    Tempo Commands           Action
    ──────────────────────────────────────────────────────────────────────────
    P n                      Specifies a pause, ranging from 1-64. This option
                            corresponds to the length of each note, set with
                            L n.

    T n                      Sets the "tempo," or the number of L4 quarter
                            notes in one minute. The range for n is 32-255.
                            The default for n is 120.

    Operation Commands       Action
    ──────────────────────────────────────────────────────────────────────────
    MF                       Sets music (PLAY statement) and SOUND to run in
                            the foreground. That is, each subsequent note or
                            sound will not start until the previous note or
                            sound has finished. This is the default setting.

    MB                       Music (PLAY statement) and SOUND are set to run
                            in the background. That is, each note or sound is
                            placed in a buffer, allowing the BASIC program to
                            continue executing while the note or sound plays
                            in the background. The maximum number of notes
                            that can be played in the background at one time
                            is 32.

    Suffixes                 Action
    ──────────────────────────────────────────────────────────────────────────
    # or +                   Follows a specified note and turns it into a
                            sharp.

    -                        Follows a specified note and turns it into a
                            flat.

    .                        A period after a note causes the note to play 3/2
                            times the length determined by L (length) times T
                            (tempo). The period has the same meaning as in a
                            musical score. Multiple periods can appear after
                            a note. Each period adds a length equal to one
                            half the length of the previous period. The
                            command A. plays 1 + 1/2 or 3/2 times the length;
                            A.. plays 1 + 1/2 + 1/4 or 7/4 times the length;
                            and so on. Periods can appear after a pause (P).
                            In this case, the pause length is scaled in the
                            same way notes are scaled.

    Substring Command        Action
    ──────────────────────────────────────────────────────────────────────────
    "X" + VARPTR$(string)    Executes a substring.
    ──────────────────────────────────────────────────────────────────────────

    Because of the slow clock-interrupt rate, some notes will not play at
    higher tempos (L64 at T255, for example).

■ Examples

    The following example uses ">" to play the scales from octave 0 to octave
    6, then reverses with "<" to play the scales from octave 6 to octave 0:

    SCALE$ = "CDEFGAB"
    PLAY "o0 X" + VARPTR$(SCALE$)
    FOR I = 1 TO 6
        PLAY ">X" + VARPTR$(SCALE$)
    NEXT
    PLAY "o6 X" + VARPTR$(SCALE$)
    FOR I = 1 TO 6
        PLAY "<X" + VARPTR$(SCALE$)
    NEXT

    The following example plays the beginning of the first movement of
    Beethoven's Fifth Symphony:

    LISTEN$ = "T180 o2 P2 P8 L8 GGG L2 E-"
    FATE$ = "P24 P8 L8 FFF L2 D"
    PLAY LISTEN$ + FATE$

""","PMAP Function" to """
■ Action

    Maps view-coordinate expressions to physical locations or maps physical
    expressions to a view-coordinate location

■ Syntax

    PMAP (expression, function)

■ Remarks

    The argument expression indicates the coordinate of the point to be
    mapped. The argument function can have one of the four following values:

    Value                    Description
    ──────────────────────────────────────────────────────────────────────────
    0                        Maps view-coordinate expression to physical
                            x-coordinate

    1                        Maps view-coordinate expression to physical
                            y-coordinate

    2                        Maps physical expression to view x-coordinate

    3                        Maps physical expression to view y-coordinate
    ──────────────────────────────────────────────────────────────────────────

    The four PMAP functions allow the user to find equivalent point locations
    between the view coordinates created with the WINDOW statement and the
    physical coordinate system of the screen or viewport as defined by the
    VIEW statement.

■ See Also

    VIEW, WINDOW

■ Example

    The following fragment uses PMAP to convert coordinate values from view to
    screen coordinates and from screen coordinates to view coordinates:

    SCREEN 2
    'Coordinates of upper-left corner of window defined in follow-
    'ing statement are (80,100); coordinates of lower-right corner
    'are 200,200.
    WINDOW SCREEN (80,100) - (200,200)

    'If physical screen coordinates are (0,0) in the upper-left
    'corner and (639,199) in the lower-right corner, then the
    'following statements will return the screen coordinates
    'equivalent to the view coordinates 80,100.
    X = PMAP(80,0)          'X = 0
    Y = PMAP(100,1)         'Y = 0

    'The following statements will return the screen coordinates
    'equivalent to the view coordinates 200,200.
    X = PMAP(200,0)         'X = 639
    Y = PMAP(200,1)         'Y = 199

    'The following statements will return the view coordinates
    'equivalent to the screen coordinates 639,199.
    X = PMAP(639,2)         'X = 200
    Y = PMAP(199,3)         'Y = 200

""","POINT Function" to """
■ Action

    Reads the color number of a pixel from the screen or returns the pixel's
    coordinates

■ Syntax

    POINT (x,y)
    POINT (number)

■ Remarks

    The coordinates x and y refer to the pixel being evaluated by the POINT
    function. When called with two coordinates, POINT returns the color number
    of the indicated pixel. If the specified pixel is out of range, POINT
    returns the value -1.

    POINT with one argument (as explained in the list below) allows the user
    to retrieve the current graphics-cursor coordinates.

    Argument                 Value Returned
    ──────────────────────────────────────────────────────────────────────────
    0                        The current physical x-coordinate.

    1                        The current physical y-coordinate.

    2                        The current view x-coordinate. This returns the
                            same value as the POINT(0) function if the WINDOW
                            statement has not been used.

    3                        The current view y-coordinate. This returns the
                            same value as the POINT(1) function if the WINDOW
                            statement has not been used.
    ──────────────────────────────────────────────────────────────────────────

■ Example

    The following example redraws the ellipse drawn with the CIRCLE statement,
    using POINT to find the border of the ellipse by testing for a change in
    color:

    DEFINT X,Y
    INPUT "Enter angle of tilt in degrees (0 to 90): ",Ang
    SCREEN 1         'Medium resolution screen.
    Ang = (3.1415926#/180)*Ang      'Convert degrees to radians.
    Cs = COS(Ang) : Sn = SIN(Ang)
    CIRCLE (45,70),50,2,,,2         'Draw ellipse.
    PAINT (45,70),2                 'Paint interior of ellipse.

    FOR Y = 20 TO 120
        FOR X = 20 TO 70
        'Check each point in rectangle enclosing ellipse.
        IF POINT(X,Y) <> 0 THEN
            'If the point is in the ellipse, plot a corresponding
            'point in the "tilted" ellipse.
            Xnew = (X*Cs - Y*Sn) + 200 : Ynew = (X*Sn + Y*Cs)
            PSET(Xnew,Ynew),2
        END IF
        NEXT
    NEXT
    END

""","POKE Statement" to """
■ Action

    Writes a byte into a memory location

■ Syntax

    POKE address,byte

■ Remarks

    The expression address is a value that represents the address of the
    memory location; address must be in the range 0-65,535. The expression
    byte is the data byte to be written; it is an integer value in the range
    0-255.

    The address is treated as the offset from the current default segment (as
    set by the DEF SEG statement). If the argument is a single- or
    double-precision floating-point value or a long integer, it is converted
    to a two-byte integer.

    The complementary function to POKE is PEEK.
""","POS Function" to """
■ Action

    Returns the current horizontal position of the cursor

■ Syntax

    POS(0)

■ Remarks

    The leftmost cursor position is numbered 1. To return the current
    vertical-line position of the cursor, use the CSRLIN function.

■ See Also

    CSRLIN, LPOS

■ Example

    The following example uses POS to start input on a new line after every 40
    characters:

    PRINT "This program starts a new line after every forty"
    PRINT "characters are printed. Press <CTRL-C> to end."
    PRINT
    DO
        DO WHILE POS(0) < 41   'Stay on same line until 40 characters
        DO                  'printed.
            Char$=INKEY$
        LOOP WHILE Char$=""
        'If input is key combination CTRL-C then end; otherwise,
        'print the character.
        IF ASC(Char$) = 3 THEN END ELSE PRINT Char$;
        LOOP
        PRINT                  'Print a new line.
    LOOP

""","PRESET Statement" to """
■ Action

    Draws a specified point on the screen

■ Syntax

    PRESET «STEP»(xcoordinate,ycoordinate) «,color»

■ Remarks

    PRESET works exactly like PSET, except that if the color is not specified,
    the background color is selected. The following list describes the parts
    of the PRESET statement:

    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
    STEP                     Indicates that the given x- and y-coordinates are
                            relative, not absolute. The coordinates are
                            treated as distances from the most recent cursor
                            location, not distances from the (0,0) screen
                            coordinate.
                            For example, if the most recent point referenced
                            were (10,10),
                            PRESET STEP (10,5)
                            would reference the point at (20,15).

    xcoordinate              The x-coordinate of the pixel that is to be set.

    ycoordinate              The y-coordinate of the pixel that is to be set.

    color                    The color attribute for the specified point.
    ──────────────────────────────────────────────────────────────────────────

    If a coordinate is outside the current viewport, no action is taken, nor
    is an error message given.

■ See Also

    PSET

■ Example

    The following example draws a line 20 pixels long. The line then moves
    across the screen from left to right:


    SCREEN 1 : COLOR 1,1 : CLS
    FOR I = 0 TO 299 STEP 3
        FOR J = I TO 20+I
            PSET (J,50),2                  'Draw the line in new location.
        NEXT
        FOR J = I TO 20+I
            PRESET (J,50)                  'Erase the line.
        NEXT
    NEXT

""","PRINT Statement" to """
■ Action

    Outputs data on the screen

■ Syntax

    PRINT «expressionlist» «{, | ;}»

■ Remarks

    If expressionlist is omitted, a blank line is printed. If expressionlist
    is included, the values of the expressions are printed on the screen. The
    expressions in the list may be numeric or string expressions. (String
    literals must be enclosed in quotation marks.)

    A printed number is always followed by a space. If the number is positive,
    it is also preceded by a space; if the number is negative, it is preceded
    by a minus sign (-).

    There are two formats that PRINT uses to display single- and
    double-precision numbers: fixed point and floating point. If PRINT can
    represent a single-precision number in the fixed-point format with seven
    or fewer digits and no loss of accuracy, then it uses the fixed-point
    format; otherwise, it uses the floating-point format. For example, the
    number 1.1E-6 is output as .0000011, but the number 1.1E-7 is output as
    1.1E-7.

    Similarly, if PRINT can represent a double-precision number in the
    fixed-point format with 16 or fewer digits and no loss of accuracy, then
    it uses the fixed-point format; otherwise, it uses the floating-point
    format. For example, the number 1.1D-15 is output as .0000000000000011,
    but the number 1.1D-16 is output as 1.1D-16.

    The PRINT statement supports only elementary BASIC data types (integers,
    long integers, single-precision real numbers, double-precision real
    numbers, and strings). To print information in a record, use the PRINT
    statement with individual record elements as in the following fragment:

    TYPE MyType
        Word AS STRING*20
        Count AS LONG
    END TYPE
    DIM Myrec AS MyType

    PRINT Myrec.Word

    PRINT POSITIONS

    The position of each printed item is determined by the punctuation used to
    separate the items in the list. BASIC divides the line into print zones of
    14 spaces each. In the expression list, a comma makes the next value print
    at the start of the next zone. A semicolon makes the next value print
    immediately after the last value. Typing one or more spaces or tabs
    between expressions has the same effect as typing a semicolon.

    If a comma or a semicolon terminates the list of expressions, the next
    PRINT statement prints on the same line, after spacing accordingly. If the
    expression list ends without a comma or a semicolon, a carriage-return and
    line-feed sequence is printed at the end of the line. If the printed line
    is wider than the screen width, BASIC goes to the next physical line and
    continues printing.

■ Examples

    In the following example, the commas in the PRINT statement print each
    value at the beginning of the next print zone:

    X=5
    PRINT X+5, X-5, X*(-5), X^5
    END

■ Output

    10            0            -25            3125

    In the following example, the semicolon at the end of the first PRINT
    statement makes the first two PRINT statements print on the same line. The
    last PRINT statement prints a blank line before the next prompt.

    DO
        INPUT "Input X (input 0 to end): ", X
        IF X = 0 THEN
        EXIT DO
        ELSE
        PRINT X "squared is" X^2 "and";
        PRINT X "cubed is" X^3
        PRINT
        END IF
    LOOP

■ Output

    Input X (input 0 to end): 9
    9 squared is 81 and 9 cubed is 729

    Input X (input 0 to end): 21
    21 squared is 441 and 21 cubed is 9261

    Input X (input 0 to end): 0

    In the following example, the semicolons in the PRINT statement print each
    value immediately after the preceding value. (Remember, a space always
    follows a number and a space precedes a positive number.)

    FOR X=1 TO 5
    J=J+5
    K=K+10
    PRINT J;K;
    NEXT X

■ Output

    5  10  10  20  15  30  20  40  25  50

""","PRINT USING Statement" to """
■ Action

    Prints strings or numbers using a specified format

■ Syntax

    PRINT USING formatstring; expressionlist «{, | ;}»

■ Remarks

    The formatstring is a string literal (or variable) containing literal
    characters to print (such as labels) and special formatting characters.
    These formatting characters determine the field and the format of the
    printed strings or numbers. Spaces, commas, and semicolons in the
    expressionlist have the same meaning they do in a PRINT statement.

    The expressionlist contains the string expressions or numeric expressions
    to be printed, separated by semicolons.

    When PRINT USING is used to print strings, you may use one of three
    formatting characters to format the string field, as described in the
    following list:

    Character                Description
    ──────────────────────────────────────────────────────────────────────────
    !                        Only the first character in the given string is
                            to be printed.

    \    \                   Prints 2 + n characters from the string, where n
                            is the number of spaces between the two
                            backslashes. If the backslashes are typed with no
                            spaces, two characters are printed. With one
                            space, three characters are printed, and so on.
                            If the field is longer than the string, the
                            string is left-justified in the field and padded
                            with spaces on the right.

    &                        Indicates a variable-length string field. When
                            the field is specified with the ampersand (&),
                            the string is output without modification.
    ──────────────────────────────────────────────────────────────────────────

    When PRINT USING is used to print numbers, the following special
    characters can be used to format the numeric field:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Character                Description
    ──────────────────────────────────────────────────────────────────────────
    #                        Represents each digit position. Digit positions
                            are always filled. If the number to be printed
                            has fewer digits than positions specified, the
                            number is right-justified (preceded by spaces) in
                            the field.

    .                        Prints a decimal point. A decimal point may be
                            inserted at any position in the field. If the
                            format string specifies that a digit is to
                            precede the decimal point, the digit is always
                            printed (as 0, if necessary). If necessary,
    Character                Description
    ──────────────────────────────────────────────────────────────────────────
                            printed (as 0, if necessary). If necessary,
                            numbers are rounded.

    +                        Causes the sign of the number (plus or minus) to
                            be printed before the number (if it appears at
                            the beginning of the format string) or after (if
                            it appears at the end of the format string).

    -                        Causes a negative number to be printed with a
                            trailing minus sign if it appears at the end of
                            the format string.

    **                       Causes leading spaces in the numeric field to be
                            filled with asterisks. The double asterisk also
                            specifies positions for two more digits.

    $$                       Causes a dollar sign to be printed to the
                            immediate left of the formatted number. The $$
                            specifies two more digit positions, one of which
    Character                Description
    ──────────────────────────────────────────────────────────────────────────
                            specifies two more digit positions, one of which
                            is the dollar sign.

    **$                      Combines the effects of the double-asterisk and
                            double-dollar-sign symbols. Leading spaces are
                            asterisk-filled and a dollar sign is printed
                            before the number. The **$ symbols specify three
                            more digit positions, one of which is the dollar
                            sign. When negative numbers are printed, the
                            minus sign appears to the immediate left of the
                            dollar sign.

    ,                        If the comma appears to the left of the decimal
                            point in a format string, it causes a comma to be
                            printed to the left of every third digit left of
                            the decimal point. If it appears at the end of
                            the format string, it is printed as part of the
                            string. A comma specifies another digit position.
                            The comma has no effect if used with exponential
    Character                Description
    ──────────────────────────────────────────────────────────────────────────
                            The comma has no effect if used with exponential
                            (^^^^ or ^^^^^) format.

    ^^^^                     Specifies exponential format. You can also use
                            five carets (^^^^^) to allow E+xxx to be printed
                            for larger numbers. Any decimal point position
                            may be specified. The significant digits are
                            left-justified and the exponent is adjusted.
                            Unless a leading +, trailing +, or - is
                            specified, one digit position is used to the left
                            of the decimal point to print a space or a minus
                            sign.

    _                        An underscore in the format string prints the
                            next character as a literal character. A literal
                            underscore is printed as the result of two
                            underscores ( __ ) in the format string.

    %                        If the number to be printed is larger than the
    Character                Description
    ──────────────────────────────────────────────────────────────────────────
    %                        If the number to be printed is larger than the
                            specified numeric field, a percent sign (%) is
                            printed in front of the number. If rounding
                            causes the number to exceed the field, a percent
                            sign is printed in front of the rounded number.
                            If the number of digits specified exceeds 24, an
                            error message results that reads Illegal function
                            call.
    ──────────────────────────────────────────────────────────────────────────


■ Examples

    The following example shows the results of using the three
    string-formatting characters:

    'Using the three string-formatting characters to modify the
    'appearance of printed output.
    A$ = "LOOK" : B$ = "OUT"
    PRINT USING "!";A$;B$
    PRINT USING "\  \";A$;B$        'Two spaces between back-
                                    'slashes, will print four
                                    'characters from A$.
    PRINT USING "\   \";A$;B$;"!!"  'Three spaces, will print
    PRINT USING "!";A$;             'A$ and a blank.
    PRINT USING "&";B$

■ Output

    LO
    LOOKOUT
    LOOK OUT  !!
    LOUT

    The following example shows the effects of different combinations of
    numeric formatting characters:

    'Format and print numeric data.
    PRINT USING "##.##";.78
    PRINT USING "###.##";987.654
    PRINT USING "##.##   ";10.2,5.3,66.789,.234
    PRINT USING "+##.##   ";-68.95,2.4,55.6,-.9
    PRINT USING "##.##-   ";-68.95,22.449,-7.01
    PRINT USING "**#.#   ";12.39,-0.9,765.1
    PRINT USING "$$###.##";456.78
    PRINT USING "**$##.##";2.34
    PRINT USING "####,.##";1234.5
    PRINT USING "##.##^^^^";234.56
    PRINT USING ".####^^^^-";-888888
    PRINT USING "+.##^^^^";123
    PRINT USING "+.##^^^^^";123
    PRINT USING "_!##.##_!";12.34
    PRINT USING "##.##";111.22
    PRINT USING ".##";.999

■ Output

    0.78
    987.65
    10.20    5.30   66.79    0.23
    -68.95    +2.40   +55.60    -0.90
    68.95-   22.45     7.01-
    *12.4   *-0.9   765.1
    $456.78
    ***$2.34
    1,234.50
    2.35E+02
    .8889E+06-
    +.12E+03
    +.12E+003
    !12.34!
    %111.22
    %1.00

""","PRINT #, PRINT # USING Statements" to """
■ Action

    Writes data to a sequential file

■ Syntax

    PRINT #filenumber,«USING stringexpression;» expressionlist «{, | ;}»

■ Remarks

    The filenumber is the number specified when the file was opened for
    output. The stringexpression consists of formatting characters as
    described under PRINT USING. The expressions in expressionlist are the
    numeric or string expressions to be written to the file. Spaces, commas,
    and semicolons in the expressionlist have the same meaning they have in a
    PRINT statement.

    If you omit expressionlist, the PRINT # statement prints a blank line in
    the file.

    PRINT # works like PRINT and writes an image of the data to the file, just
    as the data would be displayed on the terminal screen. For this reason, be
    careful to delimit the data so it is output correctly. If you use commas
    as delimiters, the blanks between print fields are also written to the
    file.

    For more information, see Chapter 3, "File and Device I/O," in Programming
    in BASIC.

■ See Also

    PRINT; PRINT USING; WRITE#

■ Example

    The following example shows the effects of omitting and of including
    delimiters in data written out with PRINT #:

    A$ = "CAMERA, AUTOFOCUS" : B$= "September 20, 1985"
    : C$ = "42"
    Q$ = CHR$(34)
    OPEN "INVENT.DAT" FOR OUTPUT AS #1 'Open INVENT.DAT for writing
    'Write A$, B$, C$ without delimiters.
    PRINT #1, A$ B$ C$
    'Write A$, B$, C$ with delimiters.
    PRINT #1, Q$ A$ Q$ Q$ B$ Q$ Q$ C$ Q$
    CLOSE #1
    OPEN "INVENT.DAT" FOR INPUT AS #1  'Open INVENT.DAT for reading.
    FOR I% = 1 TO 2                    'Read first two records and
        INPUT #1, First$,Second$,Third$ 'print.
        PRINT First$ TAB(30) Second$ TAB(60) Third$ : PRINT
    NEXT
    CLOSE #1

■ Output

    CAMERA           AUTOFOCUSSeptember 20         198542

    CAMERA, AUTOFOCUS      September 20, 1985            42

""","PSET Statement" to """
■ Action

    Draws a point on the screen

■ Syntax

    PSET «STEP»(xcoordinate,ycoordinate) «,color»

■ Remarks

    The following list describes the parts of the PSET statement:

    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
    STEP                     Indicates that the given xcoordinate and
                            ycoordinate are relative, not absolute. The
                            coordinates are treated as distances from the
                            most recent cursor location, not distances from
                            the (0,0) screen coordinate.

                            For example, if the most recent point referenced
                            were (10,10) then

                            PSET STEP (10,5)

                            would reference the point at (20,15).

    xcoordinate              The x-coordinate of the pixel that is to be set.

    ycoordinate              The y-coordinate of the pixel that is to be set.

    color                    The color attribute for the specified point.
    ──────────────────────────────────────────────────────────────────────────

    If a coordinate is outside the current viewport, no action is taken nor is
    an error message given. PSET allows the color to be left off the command
    line. If it is omitted, the default is the foreground color.

■ See Also

    PRESET

■ Example

    The following example draws a line from (0,0) to (100,100) and then erases
    that line by writing over it with the background color:

    SCREEN 2  'Draw a line from (0,0) to (100,100).
    FOR I=0 TO 100
        PSET (I,I)
    NEXT I
    FOR I=0 TO 100 'Now erase that line.
        PSET STEP (-1,-1),0
    NEXT I

""","PUT Statement──File I/O" to """
■ Action

    Writes from a variable or a random-access buffer to a file

■ Syntax

    PUT «#»filenumber«,«recordnumber»«,variable»»
    PUT «#»filenumber«,{recordnumber|recordnumber, variable|,variable}»

■ Remarks

    The following list describes the parts of the PUT statement:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    filenumber               The number used in the OPEN statement to open the
                            file.

    recordnumber             For random-mode files, the number of the record
                            to be written. For binary-mode files, the byte
                            position in the file where writing is done. The
    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
                            position in the file where writing is done. The
                            first record in a file is record 1. If you omit
                            recordnumber, the next record or byte (the one
                            after the last GET or PUT statement, or the one
                            pointed to by the last SEEK) is written to. The
                            largest possible record number is 2^31-1 or
                            2,147,483,647.

    variable                 The variable containing the output to be written
                            to the file. The PUT statement writes as many
                            bytes to the file as there are bytes in the
                            variable.

                            If you use a variable, you do not need to use
                            MKI$, MKL$, MKS$, or MKD$ to convert numeric
                            fields before writing. You may not use a FIELD
                            statement with the file if you use the variable
                            argument.

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────

                            For random-access files, you can use any variable
                            as long as the length of the variable is less
                            than or equal to the length of the record.
                            Usually, a record variable defined to match the
                            fields in a data record is used.

                            For binary-mode files, you can use any variable.

                            When you use a variable-length string variable,
                            the statement writes as many bytes as there are
                            characters in the string's value. For example,
                            the following two statements write 15 bytes to
                            file number 1:

                            VarString$=STRING$ (15, "X") PUT #1,,VarString$

                            See the examples below and Chapter 3, "File and
                            Device I/O," in Programming in BASIC, for more
    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
                            Device I/O," in Programming in BASIC, for more
                            information about using variables rather than
                            FIELD statements for random-access files.

                            A record cannot contain more than 32,767 bytes.
    ──────────────────────────────────────────────────────────────────────────


    You can omit the recordnumber, the variable, or both. If you omit only the
    recordnumber, you must still include the commas:

    PUT #4,,FileBuffer

    If you omit both arguments, you do not include the commas:

    PUT #4

    The GET and PUT statements allow fixed-length input and output for BASIC
    communications files. Be careful using GET and PUT for communications
    because PUT writes a fixed number of characters and may wait indefinitely
    if there is a communications failure.
""","PUT Statement──Graphics" to """
■ Action

    Places a graphic image obtained by a GET statement onto the screen

■ Syntax

    PUT «STEP» (x, y), arrayname«(indices)» «,actionverb»

■ Remarks

    The parts of the PUT statement are described as follows:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
    STEP                     Indicates that the given x- and y-coordinates are
                            relative, not absolute. The coordinates are
                            treated as distances from the most recent cursor
                            location, not distances from the (0,0) screen
                            coordinate.

                            For example, if the most recent point referenced
                            were (10,10) then the statement

                            PUT STEP (10,5),Ball

                            would put the object stored in Ball at (20,15).
    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
                            would put the object stored in Ball at (20,15).

    (x,y)                    Coordinates specifying the top-left corner of the
                            rectangle enclosing the image to be placed in the
                            current output window.

    arrayname                The name of the array that holds the image. See
                            the entry for GET (Graphics) for the formula that
                            computes the size of this array. The array can be
                            a multidimensional array.

    indices                  Specifies that the image is retrieved starting
                            from the designated array element, rather than at
                            the first array element.

    actionverb               The actionverb determines the interaction between
                            the stored image and the one already on the
                            screen.
    ──────────────────────────────────────────────────────────────────────────
    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
    ──────────────────────────────────────────────────────────────────────────


    The different values for actionverb are described in the following list.
    The default for actionverb is XOR.

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Verb                     Description
    ──────────────────────────────────────────────────────────────────────────
    PSET                     Transfers the data point-by-point onto the
                            screen. Each point has the exact color attribute
                            it had when it was taken from the screen with
                            GET.

    PRESET                   The same as PSET except that a negative image
                            (for example, black on white) is produced.

    AND                      Used when the image is to be transferred over an
                            existing image on the screen. The resulting image
    Verb                     Description
    ──────────────────────────────────────────────────────────────────────────
                            existing image on the screen. The resulting image
                            is the result of a logical AND of the stored
                            image and the screen; points that had the same
                            color in both the existing image and the stored
                            image remain the same color, while those points
                            that do not have the same color in both the
                            existing image and the stored image do not.

    OR                       Used to superimpose the image onto an existing
                            image; the stored image does not erase the
                            previous screen contents. The resulting image is
                            the product of a logical OR of the stored image
                            and the screen image.

    XOR                      A special mode often used for animation. XOR
                            causes the points on the screen to be inverted
                            where a point exists in the array image. This
                            behavior is exactly like that of the cursor: when
                            an image is placed on the screen against a
    Verb                     Description
    ──────────────────────────────────────────────────────────────────────────
                            an image is placed on the screen against a
                            complex background twice, the background is
                            restored. This allows you to move an object
                            around the screen without erasing the background.
    ──────────────────────────────────────────────────────────────────────────


    See Chapter 5, "Graphics," in Programming in BASIC for a detailed
    description of doing animation with the PUT statement.

■ See Also

    GET (Graphics), PRESET, PRINT, PSET

■ Example

    The following example creates a moving white ball that ricochets off the
    sides of the screen until you press a key to end the program:

    DEFINT A-Z
    DIM Ball(84)     'Dimension integer array large enough
                    'to hold ball.
    SCREEN 2         '640 pixels by 200 pixels screen resolution.
    INPUT "Press any key to end; press <ENTER> to start",Test$
    CLS
    CIRCLE (16,16),14       'Draw and paint ball.
    PAINT (16,16),1
    GET (0,0)-(32,32),Ball
    X = 0 : Y = 0
    Xdelta = 2 : Ydelta = 1

    DO

        'Continue moving in same direction as long as ball is within
        'the boundaries of the screen - (0,0) to (640,200).

        X = X + Xdelta : Y = Y + Ydelta
        IF INKEY$<>"" THEN END  ' Test for key press.

        'Change X direction if ball hits left or right edge.
        IF (X < 1 OR X > 600) THEN
        Xdelta = -Xdelta
        BEEP
        END IF
        'Change Y direction if ball hits top or bottom edge.
        IF (Y < 1 OR Y > 160) THEN
        Ydelta = -Ydelta
        BEEP
        END IF
        'Put new image on screen, simultaneously erasing old image.
        PUT (X,Y),Ball,PSET

    LOOP
    END

""","RANDOMIZE Statement" to """
■ Action

    Initializes (reseeds) the random-number generator

■ Syntax

    RANDOMIZE«expression»

■ Remarks

    If you omit expression, BASIC pauses and asks for a value by printing

    Random Number Seed (-32768 to 32767)?

    before executing the RANDOMIZE statement. When you use the argument
    expression, QuickBASIC uses this value to initialize the random-number
    generator.

    If the random-number generator is not reseeded, the RND function returns
    the same sequence of random numbers each time the program is run. To
    change the sequence of random numbers every time the program is run, place
    a RANDOMIZE statement at the beginning of the program and change the
    argument with each run.

    A convenient way to initialize the random-number generator is to use the
    TIMER function. Using TIMER ensures a new series of random numbers each
    time you use the program. See the example below.

■ See Also

    RND, TIMER

■ Example

    The following program simulates rolling two dice. The RANDOMIZE statement
    initializes the random-number generator so the program produces different
    numbers each time.

    ' Use the timer as the seed for the number generator.
    RANDOMIZE TIMER

    DO
        ' Simulate rolling two dice using RND.
        D1=INT(RND*6)+1
        D2=INT(RND*6)+1
        ' Report the roll.
        PRINT "You rolled a";D1;"and a";D2;"for a total of";D1+D2
        INPUT "Roll again (Y/N)";Resp$
        PRINT
    LOOP UNTIL UCASE$(MID$(Resp$,1,1))="N"

    END

■ Output

    You rolled a 3 and a 5 for a total of 8
    Roll again (Y/N)? y

    You rolled a 4 and a 1 for a total of 5
    Roll again (Y/N)? y

    You rolled a 5 and a 6 for a total of 11
    Roll again (Y/N)? n

""","READ Statement" to """
■ Action

    Reads values from a DATA statement and assigns the values to variables

■ Syntax

    READ variablelist

■ Remarks

    A variablelist is a series of valid BASIC variables separated by commas.
    READ statements are always used with DATA statements. READ assigns DATA
    values to variables on a one-to-one basis. These variables may be numeric
    or string. Attempting to read a string value into a numeric variable
    produces a run-time syntax error. Reading a numeric value into a string
    variable does not produce an error, but stores the value as a string of
    numerals.

    Values read into integer variables are rounded before the value is
    assigned to the variable. Reading a numeric value too large for a variable
    produces a run-time error.

    String values read into fixed-length string variables are truncated if the
    string is too long. String values shorter than the string-variable length
    are left-justified and padded with blanks.

    Only individual elements of a record variable may appear in a READ
    statement. See example below.

    A single READ statement may use one or more DATA statements (they will be
    used in order); several READ statements may use the same DATA statement.
    If there are more variables in variablelist than there are values in the
    DATA statement or statements, an error message is printed that reads Out
    of DATA. If there are fewer variables than the number of elements in the
    DATA statement or statements, subsequent READ statements begin reading
    data at the first unread element. If there are no subsequent READ
    statements, the extra items are ignored.

    Use the RESTORE statement to reread DATA statements.

■ See Also

    DATA, RESTORE

■ Example

    The following fragment shows how a READ statement can be used to read
    information into the user-defined type named Employee:

    TYPE Employee
        FullName AS STRING*35
        SocSec AS STRING*9
        JobClass AS INTEGER
    END TYPE

    DIM ThisEmp AS Employee
    DATA "Julia Magruder","300-32-3403",3
    DATA "Amelie Reeves Troubetzkoy","777-29-3206",7
    .
    .
    .
    READ ThisEmp.FullName, ThisEmp.SocSec, ThisEmp.JobClass
    .
    .
    .

    See also the examples for DATA and RESTORE.

""","REDIM Statement" to """
■ Action

    Changes the space allocated to an array that has been declared ¢DYNAMIC

■ Syntax

    REDIM «SHARED» variable(subscripts)«AS type» «,variable(subscripts)«AS typ
    e»»...

■ Remarks

    The REDIM statement has the following arguments:

    Arguments                Description
    ──────────────────────────────────────────────────────────────────────────
    SHARED                   The optional SHARED attribute allows a module to
                            share variables with all the procedures in the
                            module; this differs from the SHARED statement,
                            which affects only the variables within a single
                            module. SHARED can only be used in REDIM
                            statements in the module-level code.

    variable                 A BASIC variable name.

    subscripts               The dimensions of the array. Multiple dimensions
                            can be declared. The subscript syntax is
                            described below.

    AS type                  Declares variable as an elementary or
                            user-defined type. The elementary types are
                            INTEGER, LONG, SINGLE, DOUBLE, and STRING.
    ──────────────────────────────────────────────────────────────────────────

    Subscripts in REDIM statements have the following form:

    «lower TO» upper «, «lower TO» upper»...

    The TO keyword provides a way to indicate both the lower and the upper
    bounds of an array's subscripts. The arguments lower and upper are numeric
    expressions specifying the lowest and highest value for the subscript. See
    the DIM statement for more information about using the TO keyword.

    The REDIM statement changes the space allocated to an array that has been
    declared dynamic. See Chapter 2, "Data Types," for more information about
    both static and dynamic arrays.

    When a REDIM statement is compiled, all arrays declared in the statement
    are treated as dynamic. At run time, when a REDIM statement is executed,
    the array is deallocated (if it is already allocated) and then reallocated
    with the new dimensions. Old array-element values are lost because all
    numeric elements are reset to 0 and all string elements are reset to null
    strings. Although you may change the size of an array's dimensions with
    the REDIM statement, you may not change the number of dimensions. For
    example, the following statements are legal:

    ' ¢DYNAMIC
    DIM A(50,50)
    ERASE A
    REDIM A(20,15)    'Array A still has two dimensions.

    However, the following statements are not legal and produce an error
    message that reads Wrong number of dimensions:

    ' ¢DYNAMIC
    DIM A(50,50)
    ERASE A
    REDIM A(5,5,5)   'Changed number of dimensions from
                    'two to three.

■ See Also

    DIM, ERASE, LBOUND, OPTION BASE, SHARED, UBOUND

■ Example

    The following program fragment shows one way to use REDIM to allocate an
    array of records when the records are needed and later to free the memory
    that the records use:

    TYPE KeyElement
        Word AS STRING*20
        Count AS INTEGER
    END TYPE

    ' Make arrays dynamic.
    ' ¢DYNAMIC
    .
    .
    .
    ' Allocate an array of records when you need it.
    REDIM Keywords(500) AS KeyElement
    Keywords(99).Word="ERASE"
    Keywords(99).Count=2
    PRINT Keywords(99).Word,Keywords(99).Count
    .
    .
    .
    ' Free the space taken by Keywords when you're finished.
    ERASE Keywords
    .
    .
    .
    END

""","REM Statement" to """
■ Action

    Allows explanatory remarks to be inserted in a program

■ Syntax 1

    REM remark

■ Syntax 2

    ' remark

■ Remarks

    REM statements are not compiled, but they appear exactly as entered when
    the program is listed. You may branch from a GOTO or GOSUB statement to a
    REM statement. Execution continues with the first executable statement
    after the REM statement.

    A single quotation mark can be used instead of the REM keyword. If the REM
    keyword follows other statements on a line, it must be separated from the
    statements by a colon.

    REM statements are also used to introduce metacommands (see Appendix F,
    "Metacommands," in Programming in BASIC for more information).
""","RESET Statement" to """
■ Action

    Closes all disk files

■ Syntax

    RESET

■ Remarks

    The RESET statement closes all open disk files and writes data still in
    the file buffers to disk. All files must be closed before a disk is
    removed from its drive.

■ See Also

    CLOSE, END, SYSTEM

■ Example

    There are no programming examples for the RESET statement.

""","RESTORE Statement" to """
■ Action

    Allows DATA statements to be reread from a specified line

■ Syntax

    RESTORE «{linenumber | linelabel }»

■ Remarks

    After executing a RESTORE statement without a specified linenumber or
    linelabel, the next READ statement gets the first item in the first DATA
    statement in the program.

    If linenumber or linelabel is specified, the next READ statement gets the
    first item in the specified DATA statement. If a line is specified, the
    line number or line label must be in the module-level code. (Note that in
    the QuickBASIC environment, DATA statements are automatically moved to the
    module-level code.)

■ See Also

    DATA, READ

■ Example

    The RESTORE statement in the following fragment (from a program that
    generates random bridge hands) allows the program to reread the prompts in
    the DATA statement so the user can enter new boundary conditions for the
    different suits:

    DEFINT A-Z
    DIM X(13), Param(5,2)
    DATA Spades, Hearts, Diamonds, Clubs, Points

    CALL GetParameters(Param())

    DO
    .
    .
    .
        INPUT "Repeat with same parameters"; Ch$
        IF UCASE$(Ch$) <> "Y" THEN
        INPUT "Repeat with new parameters"; Ch$
        IF UCASE$(Ch$) <> "Y" THEN
            EXIT DO
        ELSE
            RESTORE
            CALL GetParameters(Param())
        END IF
        END IF
    LOOP

    END

    SUB GetParameters(Param(2)) STATIC
        CLS
        FOR I = 0 TO 4
        READ SUIT$
        PRINT SUIT$ " (low, high)";
        INPUT Param(I,0), Param(I,1)
        NEXT
    END SUB

■ Output

    Spades (low, high)? 5,10
    Hearts (low, high)? 5,10
    Diamonds (low, high)? 6,8
    Clubs (low, high)? 6,8
    Points (low, high)? 5,15
    .
    .
    .
    Repeat with same parameters? n
    Repeat with new parameters? y
    Spades (low, high)? 4,8
    Hearts (low, high)? 4,8
    .
    .
    .

""","RESUME Statement" to """
■ Action

    Continues program execution after an error-trapping routine has been
    invoked

■ Syntax

    RESUME «0»
    RESUME NEXT
    RESUME  { linenumber | linelabel }

■ Remarks

    The different forms of the RESUME statement redirect program flow as
    described in the following list:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Statement                Where Execution Resumes
    ──────────────────────────────────────────────────────────────────────────
    RESUME «0»               At the last statement executed in the module
                            containing the error handler.

                            If an active error handler is found in the module
                            where the error occurs, execution resumes with
                            the statement that caused the error.

    RESUME NEXT              At the statement immediately following the last
                            statement executed in the module containing the
                            error handler.

                            If an active error handler is found in the module
                            where the error occurs, execution resumes with
                            the statement immediately following the statement
                            that caused the error.

    Statement                Where Execution Resumes
    ──────────────────────────────────────────────────────────────────────────

    RESUME linenumber        At linenumber.

    RESUME linelabel         At linelabel.
    ──────────────────────────────────────────────────────────────────────────


    A RESUME statement that is not in an error-handling routine produces the
    error message RESUME without error. Reaching the end of an error-handling
    routine without finding RESUME produces the error message No RESUME.

    The line specified in a RESUME { linenumber | linelabel } statement must
    be defined at module level. As a rule, avoid using a line number or line
    label with a RESUME statement. Omitting the line number allows your
    program to continue no matter where the error occurred.
""","RETURN Statement" to """
■ Action

    Returns control from a subroutine

■ Syntax

    RETURN «{linenumber | linelabel }»

■ Remarks

    Without a line label or number, RETURN continues execution where an event
    occurred (for event handling) or at the statement following the GOSUB (for
    subroutine calls). GOSUB and RETURN without a line number can be used
    anywhere in a program, but the GOSUB and corresponding RETURN must be at
    the same level.

    The linenumber or linelabel in the RETURN statement causes an
    unconditional return from a GOSUB subroutine to the specified line. RETURN
    with a line label or line number can only return control to a statement in
    the module-level code.

    A RETURN statement cannot be used to return control to a calling program
    from a subprogram defined by SUB. Use EXIT SUB.
""","RIGHT$ Function" to """
■ Action

    Returns the rightmost n characters of a string

■ Syntax

    RIGHT$(stringexpression,n)

■ Remarks

    The argument stringexpression can be any string variable, string constant,
    or string expression. If n is equal to the number of characters in the
    argument stringexpression, then the RIGHT$ function returns
    stringexpression. If n = 0, RIGHT$ returns the null string (length zero).

■ See Also

    LEFT$, MID$

■ Example

    This program converts names that have been input in the form "Firstname
    [Middlename] Lastname" to the form "Lastname, Firstname [Middlename]":

    LINE INPUT "Name: "; Nm$
    I = 1 : Sppos = 0
    DO WHILE I > 0
        I = INSTR(Sppos+1,Nm$," ")   'Get position of next space.
        IF I > 0 THEN Sppos = I
    LOOP

    'SPPOS now points to the position of the last space.
    IF Sppos = 0 THEN
        PRINT Nm$                    'There was just a last name.
    ELSE
        'Everything after last space.
        Lastname$ = RIGHT$(Nm$,LEN(Nm$)-Sppos)
        'Everything before last space.
        Firstname$ = LEFT$(Nm$,Sppos-1)
        PRINT Lastname$ ", " Firstname$
    END IF
    END

""","RMDIR Statement" to """
■ Action

    Removes an existing directory

■ Syntax

    RMDIR pathname

■ Remarks

    The pathname is the name of the directory that is to be deleted. The
    pathname must be a string of less than 128 characters. The directory to be
    removed must be empty except for the working directory ('.') and the
    parent directory ('..'); otherwise, one of two error messages is printed,
    either Path not found or Path/File access error.

    RMDIR works like the DOS command of the same name; the syntax in BASIC
    cannot be shortened to RD, as in DOS.

■ See Also

    CHDIR, MKDIR

■ Example

    The following example illustrates the use of the RMDIR statement:

    CHDIR "C:\SALES\TEMP"         'Move to \TEMP subdirectory in \SALES.
    KILL "*.*"                    'Remove all files in \TEMP.
    CHDIR ".."                    'Move back up to \SALES.
    RMDIR "TEMP"                  'Remove \TEMP subdirectory.

""","RND Function" to """
■ Action

    Returns a single-precision random number between 0 and 1

■ Syntax

    RND«(n)»

■ Remarks

    The value of n determines how RND generates the next random number:

    Argument                 Number Returned
    ──────────────────────────────────────────────────────────────────────────
    n < 0                    Always returns the same number for any given n

    n > 0 or n omitted       Returns the next random number in the sequence

    n = 0                    Returns the last number generated
    ──────────────────────────────────────────────────────────────────────────

    Even if n>0, the same sequence of random numbers is generated each time
    the program is run unless you initialize the random-number generator each
    time you run the program. (See the RANDOMIZE statement entry for more
    information about initializing the random-number generator.)

    To produce random integers in a given range, use the formula

    INT ((upperbound - lowerbound + 1)*RND + lowerbound)

    where upperbound is the highest number in the range, and lowerbound is the
    lowest number in the range.

■ Example

    See the examples for the RANDOMIZE and TYPE statements.

""","RSET Statement" to """
■ Action

    Moves data from memory to a random-access file buffer (in preparation for
    a PUT statement) or right-justifies the value of a string in a string
    variable

■ Syntax

    RSET stringvariable=stringexpression

■ Remarks

    The stringvariable is usually a random-access file field defined in a
    FIELD statement, although it can be any string variable. The
    stringexpression is the value assigned to the variable.

    If stringexpression requires fewer bytes than were defined for
    stringvariable in the FIELD statement, the RSET statement right-justifies
    the string in the field (LSET left-justifies the string). Spaces are used
    to pad the extra positions. If the string is too long for the field, both
    LSET and RSET truncate characters from the right. Numeric values must be
    converted to strings before they are justified with the RSET or LSET
    statements.

    The RSET statement can be used with string variables unrelated to FIELD
    statements. When used with a fixed-length string variable, the value is
    right-justified and left-padded with blanks.

    When RSET is used with a variable-length string, the string is treated as
    a fixed field. The length of the field is the length of the value the
    variable had before the RSET statement. See the example below.

■ See Also

    FIELD; LSET; MKD$, MKI$, MKL$, MKS$; PUT

■ Example

    The following example shows the effects of using RSET to assign values to
    fixed- and variable-length strings:

    DIM TmpStr2 AS STRING * 10
    PRINT "         1         2         3"
    PRINT "123456789012345678901234567890"
    ' Use RSET on null variable-length string of length.
    ' Nothing prints because TmpStr$ is a zero-length field.
    TmpStr$ = ""
    RSET TmpStr$ = "Another"
    PRINT TmpStr$
    ' Use RSET on variable-length string with a value.
    TmpStr$ = SPACE$(20)
    RSET TmpStr$ = "Another"
    PRINT TmpStr$

    ' Use RSET on fixed-length string of length 10.
    RSET TmpStr2 = "Another"
    PRINT TmpStr2

■ Output

    1         2         3
    123456789012345678901234567890

                Another
        Another

""","RTRIM$ Function" to """
■ Action

    Returns a string with trailing (right-hand) spaces removed

■ Syntax

    RTRIM$(stringexpression)

■ Remarks

    The stringexpression can be any string expression. The RTRIM$ function
    works with both fixed- and variable-length string variables.

■ See Also

    LTRIM$

■ Example

    The example shows the effects of the RTRIM$ function on fixed- and
    variable-length strings. See also the example for the LTRIM$ function.

    DIM FixStr AS STRING * 10
    PRINT "         1         2"
    PRINT "12345678901234567890"
    FixStr = "Twine"
    PRINT FixStr + "*"
    PRINT RTRIM$(FixStr) + "*"
    VarStr$ = "Braided" + SPACE$(10)
    PRINT VarStr$ + "*"
    PRINT RTRIM$(VarStr$) + "*"

■ Output

    1         2
    12345678901234567890
    Twine     *
    Twine*
    Braided          *
    Braided*

""","RUN Statement" to """
■ Action

    Restarts the program currently in memory or executes a specified program

■ Syntax

    RUN «{ linenumber | filespec }»

■ Remarks

    The RUN statement accepts the following arguments:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    linenumber               The numeric label of the line where execution
                            begins. If no argument is given, execution begins
                            at the first executable line of code.

    filespec                 A string expression naming the program file to
                            load and run. The current program is cleared from
                            memory before the specified program is loaded.
    ──────────────────────────────────────────────────────────────────────────

    The line where execution begins must be in the module-level code.
    Therefore, a RUN statement in a SUB or FUNCTION procedure must point to
    labels at module level. If no line label is given, execution always starts
    with the first executable line of the program's main module.

    During compilation, if linenumber cannot be found in the module-level
    code, compilation halts and the error message Label not defined appears.

    Program lines can have line numbers or alphanumeric labels, such as
    OpenWindow:. If an alphanumeric label is the target of a RUN statement,
    execution halts, and the error message Type mismatch appears. Note that
    the QuickBASIC syntax checker does not warn you if you give the RUN
    statement an alphanumeric label instead of a line number.

    You do not need to specify the file name extension in filespec. The .BAS
    extension is assumed in the QuickBASIC environment, and the .EXE extension
    is assumed when running compiled, stand-alone programs. If the program you
    wish to run has a different extension, you must give the extension. If the
    program name has no extension, the file name given must end with a period.

    For example,

    RUN "CATCHALL"

    would execute CATCHALL.EXE from a BC-compiled program, and CATCHALL.BAS
    from within QuickBASIC.

    Programs running within the QuickBASIC environment must call only
    QuickBASIC program files. The file is loaded and run as if it were a
    QuickBASIC program; if it is not in the QuickBASIC program format,
    execution halts. The error message that appears varies, depending on the
    file's contents. Likewise, programs compiled with BC must not invoke
    QuickBASIC source files, as these run only within the QuickBASIC
    environment.

    An executable file need not have been written in QuickBASIC. Any
    executable file may be run.

    When running a program under QuickBASIC, if an executable file matching
    the file name in filespec cannot be found, the error message File not
    found appears, and control returns to QuickBASIC. When running a program
    compiled by BC, the error message File not found in module programname
    appears, and control returns to DOS.

    When the invoked program completes execution, control does not return to
    the invoking program. If the invoking program ran outside QuickBASIC,
    control returns to DOS. If the invoking program ran under QuickBASIC,
    control returns to QuickBASIC.

    If you edit a QuickBASIC program containing a RUN statement, then run the
    program before saving the changes, QuickBASIC asks if you wish to save the
    new version of the program before RUN clears it from memory.

    RUN closes all files and clears program memory before loading the
    designated program.The BC compiler does not support the R option from
    BASICA. (This option keeps all open data files open.) If you want to run a
    different program, but leave open files open, use the CHAIN statement.

■ See Also

    CHAIN

■ Examples

    The following example shows how RUN linenumber resets all numeric
    variables to 0. As the line number following RUN increases in lines 60,
    70, 80, and 90, the variables in the earlier statements lose their
    assigned values.

    10 A = 9
    20 B = 7
    30 C = 5
    40 D = 4
    50 PRINT A,B,C,D
    60 IF A = 0 THEN 70 ELSE RUN 20
    70 IF B = 0 THEN 80 ELSE RUN 30
    80 IF C = 0 THEN 90 ELSE RUN 40
    90 IF D = 0 THEN END ELSE RUN 50

■ Output

    9   7   5   4
    0   7   5   4
    0   0   5   4
    0   0   0   4
    0   0   0   0

""","SADD Function" to """
■ Action

    Returns the address of the specified string expression

■ Syntax

    SADD(stringvariable)

■ Remarks

    The SADD function returns the address of a string as an offset (near
    pointer) from the current data segment. The offset is a two-byte integer.
    SADD is most often used in mixed-language programming.

    The argument may be a simple string variable or a single element of a
    string array. You may not use fixed-length string arguments.

    Use this function with care because strings can move in the BASIC string
    space (storage area) at any time. SADD works only with string variables
    stored in DGROUP.
""","SCREEN Function" to """
■ Action

    Reads a character's ASCII value or its color from a specified screen
    location

■ Syntax

    SCREEN(row,column«,colorflag»)

■ Remarks

    The following list describes the SCREEN function's arguments:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    row                      The row number of the screen location. The row is
                            a numeric expression that evaluates to an
                            unsigned integer.

    column                   The column number of the screen location. The
                            column is a numeric expression that evaluates to
                            an unsigned integer.

    colorflag                A numeric expression. When colorflag is nonzero,
                            SCREEN returns the number of the color at the
                            screen location. If the colorflag is zero or
                            absent, the ASCII code of the character at the
                            location is returned as an integer.
    ──────────────────────────────────────────────────────────────────────────

■ Examples

    If the character at (10,10) in the following examples is A, then the
    function would return 65, the ASCII code for A:

    X=SCREEN(10,10)

    The following example returns the color attribute of the character in the
    upper-left corner of the screen:

    X=SCREEN(1,1,1)

""","SCREEN Statement" to """
■ Action

    Sets the specifications for the display screen

■ Syntax

    SCREEN «mode» «,«colorswitch»
    »«,«apage» »«,«vpage»»

■ Remarks

    The SCREEN statement selects a screen mode appropriate for a particular
    combination of display and adapter. Later sections describe the available
    modes for specific adapters. The following list describes the arguments of
    the SCREEN statement:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    mode                     An integer constant or expression indicating the
                            screen mode. The valid modes are described below
                            for each of the supported adapters.

    colorswitch              Determines whether color is displayed on
                            composite monitors. The colorswitch is a numeric
                            expression in the range 0-255. When it is true
                            (nonzero), color is disabled and only
                            black-and-white images are displayed. When
                            colorswitch is false (zero), images are in color.
                            The colorswitch argument's meaning is inverted in
                            screen mode 0. In screen modes 2 and up,
                            colorswitch is ignored.

    apage                    A numeric expression that is the number of the
                            screen page that text output or graphics commands
                            write to. Tables below indicate valid values for
                            apage with various adapters.
    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
                            apage with various adapters.

    vpage                    A numeric expression that is the number of the
                            screen page being displayed. Tables below
                            indicate valid values for vpage with various
                            adapters.
    ──────────────────────────────────────────────────────────────────────────


    The next two subsections summarize the screen modes and discuss the modes
    available with specific combinations of adapters and displays. The final
    subsection summarizes attributes and colors.

    SUMMARY OF SCREEN MODES

    The following paragraphs briefly summarize each of the screen modes. The
    color adapters referred to are the IBM Color Graphics Adapter (CGA), the
    IBM Enhanced Graphics Adapter (EGA), the IBM Video Graphics Array (VGA)
    and the IBM Multicolor Graphics Array (MCGA). The Hercules(R) Graphics
    Card, Graphics Card Plus and InColor(R) adapters are supported, but only
    with monochrome monitors. The next subsection supplies detailed
    information about the effects of a screen mode when used with a specific
    combination of display and adapter.
""","SEEK Function" to """
■ Action

    Returns the current file position

■ Syntax

    SEEK(filenumber)

■ Remarks

    The filenumber is the number used in the OPEN statement to open the file.
    SEEK returns a value in the range 1 to 2,147,483,647 (equivalent to
    2^31-1).

    SEEK returns the number of the next record read or written when used on
    RANDOM mode files. For files opened in BINARY, OUTPUT, APPEND, or INPUT
    mode, SEEK returns the byte position in the file where the next operation
    is to take place. The first byte in a file is 1.

    When used on a device that does not support SEEK, the function returns
    zero. The BASIC devices (SCRN:, CONS:, KYBD:, COMn:, and LPTn:) do not
    support SEEK.

    See Chapter 3, "File and Device I/O," in Programming in BASIC for more
    information.

■ See Also

    GET (File I/O), OPEN, PUT (File I/O), SEEK Statement

■ Example

    The following code fragment prints a message indicating whether the last
    read or write was done in the first, second, or final third of the file:

    SELECT CASE (SEEK(1))
        CASE IS < .333*LOF(1)
        PRINT "In first third of file."
        CASE .333*LOF(1) TO .667*LOF(1)
        PRINT "In second third of file."
        CASE IS >= .667*LOF(1)
        PRINT "In last third of file."
        CASE ELSE
    END SELECT

""","SEEK Statement" to """
■ Action

    Sets the position in a file for the next read or write

■ Syntax

    SEEK «#»filenumber,position

■ Remarks

    The filenumber is an integer number used in the OPEN statement to open the
    file.

    The position is a numeric expression indicating where the next read or
    write is done. The position must be in the range 1 to 2,147,483,647
    (equivalent to 2^31-1). For files opened in RANDOM mode, position is the
    number of a record in the file.

    For files opened in BINARY, INPUT, OUTPUT, or APPEND modes, position is
    the number of a byte from the beginning of the file. The first byte in a
    file is 1. After a SEEK, the next file I/O operation starts at that byte
    in the file.
""","SELECT CASE Statement" to """
■ Action

    Executes one of several statement blocks depending on the value of an
    expression

■ Syntax

    SELECT CASE testexpression
    CASE expressionlist1

        «statementblock-1»

    «CASE expressionlist2

        «statementblock-2»»
    .
    .
    .

    «CASE ELSE

        «statementblock-n»»

    END SELECT

■ Remarks

    The following list describes the parts of the SELECT CASE statement:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    testexpression           Any numeric or string expression.

    statementblock-1,        The elements statementblock-1 to statementblock-n
    statementblock-2,        consist of any number of statements on one or
    statementblock-n         more lines.

    expressionlist1,         These elements can have any of the three
    expressionlist2          following forms: expression«,expression...»
                            expression TO expression IS relational-operator
                            expression
    ──────────────────────────────────────────────────────────────────────────

    The following list describes the parts of an expressionlist:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    expression               Any numeric or string expression. The type of the
                            expression must match the type of the expression
                            being tested.

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────

    relational-operator      Any of the following operators:

                            Symbol                  Meaning

                            <                       Less than

                            <=                      Less than or equal to

                            >                       Greater than

                            >=                      Greater than or equal to

                            <>                      Not equal

                            =                       Equal

    ──────────────────────────────────────────────────────────────────────────

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────


    If the testexpression matches the expressionlist associated with a CASE
    clause, then the statement block following that CASE clause is executed up
    to the next CASE clause or, for the last one, up to END SELECT. Control
    then passes to the statement following END SELECT.

    If you use the TO keyword to indicate a range of values, the smaller value
    must appear first. For example, the statements associated with the line
    CASE -1 TO -5 are not executed if the testexpression is -4. The line
    should be written as CASE -5 TO -1.

    You may use a relational operator only if the IS keyword appears. If CASE
    ELSE is used, its associated statements are executed only if the
    testexpression does not match any of the other CASE selections. It is a
    good idea to have a CASE ELSE statement in your SELECT CASE block to
    handle unforeseen testexpression values.

    When there is no CASE ELSE statement and no expression listed in the CASE
    clauses matches testexpression, program execution continues normally. No
    error occurs.

    You may use multiple expressions or ranges in each CASE clause. For
    example, the following line is valid:

    CASE 1 TO 4, 7 TO 9, 11, 13, IS > MaxNumber%

    You may also specify ranges and multiple expressions for strings:

    CASE "everything", "nuts" TO "soup", TestItem$

    CASE matches strings that are exactly equal to everything, the current
    value of TestItem$, or that fall between nuts and soup in alphabetical
    order.

    Strings are evaluated according to the ASCII values of their characters.
    Lowercase letters have larger ASCII values than uppercase letters, so

    nuts  >  Nuts  >  NUTS

    If an expression appears in more than one CASE clause, only the statements
    associated with the first appearance of the expression are executed.

    SELECT CASE statements may be nested. Each SELECT CASE statement must have
    a matching END SELECT statement.

■ Example

    In the following program, the SELECT CASE statement is used to take
    different actions based on the input value:

    ' Program demonstrates various forms of CASE items
        INPUT "Enter acceptable level of risk (1-10): ", Total
        SELECT CASE Total

            CASE IS >= 10
                PRINT "Maximum risk and potential return"
                PRINT "Choose stock investment plan"

            CASE  6 TO 9
                PRINT "High risk and potential return"
                PRINT "Choose corporate bonds"

            CASE  2 TO 5
                PRINT "Moderate risk and return"
                PRINT "Choose mutual fund"

            CASE 1
                PRINT "No risk, low return"
                PRINT "Choose IRA"

            CASE ELSE
                PRINT "RESPONSE OUT OF RANGE"

        END SELECT

■ Output

    Enter acceptable level of risk (1-10): 10
    Maximum risk and potential return
    Choose stock investment plan

    Enter acceptable level of risk (1-10): 0
    RESPONSE OUT OF RANGE

""","SETMEM Function" to """
■ Action

    Changes the amount of memory used by the far heap──the area where far
    objects and internal tables are stored

■ Syntax

    SETMEM(numeric-expression)

■ Remarks

    The SETMEM function increases or decreases the far heap by the number of
    bytes indicated by numeric-expression. If the numeric-expression is
    negative, SETMEM decreases the far heap by the indicated number of bytes.
    When the numeric-expression is positive, SETMEM attempts to increase the
    far heap space by the number of bytes.

    SETMEM returns the total number of bytes in the far heap. If the
    numeric-expression is zero, SETMEM returns the current size of the far
    heap. If SETMEM cannot change the far heap by the requested number of
    bytes, it reallocates as many bytes as possible.

    SETMEM can be used in mixed-language programming to decrease the far heap
    space so procedures in other languages can dynamically allocate far
    memory. A first call to SETMEM trying to increase the far heap has no
    effect because BASIC allocates as much memory as possible to the far heap
    when a program starts.

■ Example

    The following program outlines how SETMEM could be used to free memory for
    a C function that uses malloc to get dynamic memory. The C function is
    separately compiled and then put in a Quick library or linked to the BASIC
    program. The C function is compiled using the large memory model, so calls
    to malloc use the far space freed by the BASIC program.

    DEFINT A-Z
    DECLARE SUB CFunc CDECL (BYVAL X AS INTEGER)

    ' Decrease the size of the far heap so CFunc can use
    ' malloc to get dynamic memory.
    BeforeCall=SETMEM(-2048)

    ' Call the C function.
    CFunc(1024%)

    ' Return the memory to the far heap; use a larger value so
    ' all space goes back into the heap.
    AfterCall=SETMEM(3500)

    IF AfterCall <= BeforeCall THEN PRINT "Memory not reallocated."

    END

    void far cfunc(bytes)
    int bytes;
    {
        char *malloc();
        char *workspace;

        /* Allocate working memory using amount BASIC freed. */
        workspace=malloc((unsigned) bytes);

        /* Working space would be used here. */

        /* Free memory before returning to BASIC. */
        free(workspace);
    }

""","SGN Function" to """
■ Action

    Indicates the sign of a numeric expression

■ Syntax

    SGN(numeric-expression)

■ Remarks

    The SGN function returns a value depending on the sign of its argument:

    If numeric-expression > 0, then SGN(numeric-expression) returns 1.

    If numeric-expression = 0, then SGN(numeric-expression) returns 0.

    If numeric-expression < 0, then SGN(numeric-expression) returns -1.

■ Example

    The following program calculates and prints the solution for a quadratic
    (or for a second-degree) equation. The program uses the sign of a test
    expression to determine how to calculate the solution.

    CONST NoRealSoln=-1, OneSoln=0, TwoSolns=1
    ' Input coefficients of quadratic equation:
    ' ax^2 + bx + c = 0.
    INPUT;"a = ",   A
    INPUT;",  b = ",B
    INPUT ",  c = ",C
    Test = B^2 - 4*A*C
    SELECT CASE SGN(Test)
        CASE  NoRealSoln
        PRINT "This equation has no real-number solutions."
        CASE  OneSoln
        PRINT "This equation has one solution: ";
        PRINT -B/(2*A)
        CASE  TwoSolns
        PRINT "This equation has two solutions: ";
        PRINT (-B + SQR(Test))/(2*A) " and ";
        PRINT (-B - SQR(Test))/(2*A)
    END SELECT

■ Output

    a = 12,  b = -5,  c = -2
    This equation has two solutions:  .6666667          -.25

""","SHARED Statement" to """
■ Action

    Gives a SUB or FUNCTION procedure access to variables declared at the
    module level without passing them as parameters

■ Syntax

    SHARED variable «AS type» «, variable «AS type»»...

■ Remarks

    The argument variable is either an array name followed by () or a variable
    name. The AS clause can be used to indicate the variable's type. The type
    argument can be INTEGER, LONG, SINGLE, DOUBLE, STRING, fixed-length string
    (STRING*length), or a user-defined type.

    By using either the SHARED statement in a SUB or FUNCTION procedure, or
    the SHARED attribute with COMMON or DIM in the module-level code, you can
    use variables in a procedure without passing them as parameters. The
    SHARED attribute shares variables among all procedures in a module, while
    the SHARED statement shares variables between a single procedure and the
    module-level code.
""","SHELL Statement" to """
■ Action

    Exits the BASIC program, runs a .COM, .EXE, or .BAT program or a DOS
    command, and returns to the program at the line following the SHELL
    statement

■ Syntax

    SHELL «commandstring»

■ Remarks

    The commandstring must be a valid string expression containing the name of
    a program to run and any program options.

    Any .COM file, .EXE file, .BAT program, or DOS function that runs under
    the SHELL statement is called a "child process." Child processes are
    executed by the SHELL statement, loading and running a copy of COMMAND.COM
    with the /C option automatically; this option allows any parameters in
    commandstring to be passed to the child process. It also allows
    redirection of standard input and output, and execution of built-in
    commands such as DIR, PATH, and SORT.

    The program name in commandstring may have any extension you wish. If no
    extension is supplied, COMMAND.COM looks for a .COM file, then an .EXE
    file, and finally, a .BAT file. If COMMAND.COM is not found, SHELL issues
    an error message that reads File not found. BASIC does not generate an
    error if COMMAND.COM cannot find the file specified in commandstring.

    Any text separated from the program name by at least one blank is treated
    as program parameters by COMMAND.COM. BASIC remains in memory while the
    child process is running. When the child process finishes, BASIC
    continues.

    SHELL with no commandstring gives you a new COMMAND.COM shell. You may now
    do anything that COMMAND.COM allows. Enter the DOS command EXIT when you
    are ready to return to BASIC.

■ Examples

    This example shows how a SHELL statement starts up a new COMMAND.COM:

    SHELL   'Get a new COMMAND.COM.

■ Output

    The IBM Personal Computer DOS
    Version 3.20 (C)Copyright International
    Business Machines Corp 1981, 1986 (C)Copyright
    Microsoft Corp 1981, 1986

    D:\QB4>

    The following example copies all files modified on a certain date from a
    specified directory:

    ' This program copies all files in this directory modified
    ' on a certain date to the drive and directory you specify.

    DECLARE FUNCTION GetName$ (DirLine$)
    LINE INPUT "Enter target drive and directory: ",PathSpec$
    SHELL "DIR > DIRFILE"
    'Store directory listing in DIRFILE.
    DO
        OPEN "DIRFILE" FOR INPUT AS #1
        INPUT "Enter date (MM-DD-YY): ",MDate$
        PRINT

        ' Read DIRFILE, test for input date.
        DO
        LINE INPUT #1, DirLine$
        ' Test directory line to see if date matches and the line
        ' is not one of the special directories ( . or .. ).
        IF INSTR(DirLine$,MDate$) > 0 AND LEFT$(DirLine$,1) <> "." THEN
            FileSpec$ = GetName$(DirLine$)
            ' Make sure we don't move our temporary file.
            IF FileSpec$ <> "DIRFILE" THEN
                ' Build the DOS command line to copy the file.
                DoLine$ = "COPY " + FileSpec$ + "  " + PathSpec$
                PRINT DoLine$
                ' Copy the file.
                SHELL DoLine$
            END IF
        END IF
        LOOP UNTIL EOF(1)

    CLOSE #1
        PRINT "New date?"
        R$ = INPUT$(1)
        CLS
    LOOP UNTIL UCASE$(R$) <> "Y"
    ' KILL "DIRFILE".
    END

    ' This function gets the file name and extension from
    ' the directory-listing line.
    FUNCTION GetName$ (DirLine$) STATIC
        BaseName$ = RTRIM$(LEFT$(DirLine$,8))

        ' Check for extension.
        ExtName$  = RTRIM$(MID$(DirLine$,10,3))

        IF ExtName$ <> "" THEN
        BaseName$ = BaseName$ + "." + ExtName$
        END IF

        GetName$ = BaseName$
    END FUNCTION

■ Output

    Enter target drive and directory: c:\bas\temp
    Enter date (MM-DD-YY): 6-11-87

    COPY CONF.DAT  c:\bas\temp
    COPY TEST.BAS  c:\bas\temp
    COPY TEMPFILE  c:\bas\temp

    New date? n

""","SIN Function" to """
■ Action

    Returns the sine of the angle x, where x is in radians

■ Syntax

    SIN(x)

■ Remarks

    When x is a double-precision value, the SIN function is calculated with
    double-precision accuracy. When x is not double precision, SIN is
    calculated with single-precision accuracy.

■ See Also

    ATN, COS, TAN

■ Example

    The example plots the graph of the polar equation r = 1 + sin n (Θ). This
    figure is sometimes known as a cardioid, owing to its resemblance to a
    heart when n equals 1.

    CONST PI = 3.141593
    SCREEN 1 : COLOR 1,1      'Medium resolution, blue background.
    WINDOW (-3,-2)-(3,2)      'Convert screen to Cartesian
                            'coordinates.
    INPUT "Number of petals = ", N
    CLS
    PSET (1,0)         'Set initial point.
    FOR Angle = 0 TO 2*PI STEP .02
        R = 1 + SIN(N*Angle)   'Polar equation for "flower."
        X = R * COS(Angle)     'Convert polar coordinates to
        Y = R * SIN(Angle)     'Cartesian coordinates.
        LINE -(X,Y)         'Draw line from previous point to
                            'new point.
    NEXT

""","SLEEP Statement" to """
■ Action

    Suspends execution of the calling program

■ Syntax

    SLEEP  « seconds »

■ Remarks

    The optional argument seconds determines the number of seconds the program
    is suspended. The SLEEP statement suspends the program until one of the
    following events occurs:

    ■ The time period in the seconds argument elapses.

    ■ A key is pressed.

    ■ An enabled event occurs.

    If seconds is zero or not specified, the program is suspended
    indefinitely. Only an enabled event or a keystroke can interrupt an
    indefinite suspension.

    SLEEP responds only to keystrokes that occur after it executes. SLEEP
    ignores characters in the keyboard buffer that were typed before it
    executed.

    An event (such as ON COM or ON TIMER) cannot interrupt a SLEEP suspension
    unless its trapping is active when the event occurs. This means that
    trapping must have been initialized with an ON event statement, turned on
    with an event ON statement, and not have been disabled with an event OFF
    statement or an event STOP statement.

■ See Also

    WAIT

■ Example

    The following program suspends execution for 10 seconds. There is no ON
    event statement, so the only way to interrupt the suspension before 10
    seconds have passed is to press a key.

    PRINT "Taking a 10 second nap..."
    SLEEP 10
    PRINT "Awake!"
    END

""","SOUND Statement" to """
■ Action

    Generates sound through the speaker

■ Syntax

    SOUND frequency,duration

■ Remarks

    The frequency is the desired frequency in hertz (cycles/second). It must
    be a numeric expression returning an integer in the range 37-32,767.

    The duration is the duration in clock ticks. (There are 18.2 clock ticks
    per second regardless of CPU speed.) The duration must be a numeric
    expression returning an unsigned integer in the range 0-65,535.

    If the duration is zero, any current SOUND statement that is running is
    turned off. If no SOUND statement is running, a SOUND statement with a
    duration of zero has no effect.

■ SEE ALSO

    PLAY

■ Example

    This program fragment produces a rising and descending glissando:

    FOR I = 440 TO 1000 STEP 5
        SOUND I, I/1000
    NEXT
    FOR I = 1000 TO 440 STEP -5
    SOUND I, I/1000
    NEXT

""","SPACE$ Function" to """
■ Action

    Returns a string of spaces of length n

■ Syntax

    SPACE$(n)

■ Remarks

    The expression n is rounded to an integer and must be in the range
    0-32,767.

■ See Also

    SPC

■ Example

    This example illustrates the use of SPACE$:

    FOR I=1 TO 5
        X$=SPACE$(I)
        PRINT X$;I
    NEXT I

■ Output

    1
    2
        3
        4
        5

""","SPC Function" to """
■ Action

    Skips n spaces in a PRINT statement

■ Syntax

    SPC(n)

■ Remarks

    SPC may only be used with PRINT and LPRINT statements. The argument n must
    be in the range 0-32,767. A semicolon (;) is assumed to follow the SPC(n)
    command.

■ See Also

    SPACE$

■ Example

    This example illustrates the use of SPC:

    PRINT "OVER";SPC(15) "THERE"

■ Output

    OVER               THERE

""","SQR Function" to """
■ Action

    Returns the square root of n

■ Syntax

    SQR(n)

■ Remarks

    The argument n must be >= 0.

■ Example

    The following program plots the graphs of y = √-x for -9 <= x < 0 and of y
    = √x for 0 <= x <= 9:

    SCREEN 1 : COLOR 1         'Low-resolution color graphics mode.
    WINDOW (-9,-.25)-(9,3.25)  'Convert screen to Cartesian
                                'coordinates.
    LINE (-9,0)-(9,0)          'Draw X-axis.
    LINE (0,-.25)-(0,3.25)     'Draw Y-axis.

    FOR X = -9 TO 9
        LINE(X,.04)-(X,-.04)   'Put tick marks on X-axis.
    NEXT

    FOR Y = .25 TO 3.25 STEP .25
        LINE (-.08,Y)-(.12,Y)  'Put tick marks on Y-axis.
    NEXT

    PSET (-9,3)                'Plot the first point of function.
    FOR X = -9 TO 9 STEP .25
        Y = SQR(ABS(X))
        'SQR argument cannot be negative.
        LINE -(X,Y),2          'Draw a line to the next point.
    NEXT

""","STATIC Statement" to """
■ Action

    Makes simple variables or arrays local to either a DEF FN function, a
    FUNCTION, or a SUB and preserves values between calls

■ Syntax

    STATIC variablelist

■ Remarks

    A STATIC statement variablelist has the following syntax:

    variable«( )»«AS type» «, variable«( )»«AS type»»...

    The variablelist takes the following arguments:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    variable                 Either a variable name or an array name.

    AS type                  Declares the type of variable. The type argument
                            can be INTEGER, LONG, SINGLE, DOUBLE, STRING, or
                            a user-defined type.
    ──────────────────────────────────────────────────────────────────────────

    The STATIC statement can appear only in a SUB, FUNCTION, or DEF FN
    function. Earlier versions of BASIC required the number of dimensions in
    parentheses after an array name. In QuickBASIC, the number of dimensions
    is optional.

    Variables declared in a STATIC statement override variables of the same
    name shared by DIM or COMMON statements in the module-level code.
    Variables in a STATIC statement also override global constants of the same
    name.

    Usually, variables used in DEF FN functions are global to the module;
    however, you can use the STATIC statement inside a DEF FN statement to
    declare a variable as local to only that function.
""","STICK Function" to """
■ Action

    Returns the x- and y-coordinates of the two joysticks

■ Syntax

    STICK(n)

■ Remarks

    The argument n is a numeric expression whose value is an unsigned integer
    in the range 0 to 3:

    Argument                 Value Returned
    ──────────────────────────────────────────────────────────────────────────
    0                        The x-coordinate of joystick A

    1                        The y-coordinate of joystick A when STICK(0) was
                            last called

    2                        The x-coordinate of joystick B when STICK(0) was
                            last called

    3                        The y-coordinate of joystick B when STICK(0) was
                            last called
    ──────────────────────────────────────────────────────────────────────────

    The x- and y-coordinates have a range of 1 to 200. You must use STICK(0)
    before you use STICK(1), STICK(2), or STICK(3). STICK(0) not only returns
    the x-coordinate of joystick A, it also records the other joystick
    coordinates. These recorded coordinates are returned by calling
    STICK(1)-STICK(3).

■ Example

    The following fragment prints the coordinates of joystick B:

    TEMP = STICK(0)
    PRINT STICK(2), STICK(3)

""","STOP Statement" to """
■ Action

    Terminates the program

■ Syntax

    STOP

■ Remarks

    STOP statements can be used anywhere in a program to terminate execution.

    When running in the QuickBASIC environment, the STOP statement leaves
    files open and does not exit to the operating system. In contrast, a STOP
    statement in a stand-alone .EXE file does close all files and return to
    the operating system.

    If you use the /D, /E, or /X compile options on the bc command line, the
    STOP statement prints the number of the line where execution stopped, if
    your program has line numbers. If there is no line number associated with
    the STOP statement, the most recent line number is printed. If your
    program has no line numbers, then the line number printed is 0.

    In the past, STOP statements were used for debugging. QuickBASIC's new
    debugging features make this use of STOP unnecessary.

■ Example

    There is no programming example for the STOP statement.

""","STR$ Function" to """
■ Action

    Returns a string representation of the value of a numeric expression

■ Syntax

    STR$(numeric-expression)

■ Remarks

    If numeric-expression is positive, the string returned by the STR$
    function contains a leading blank. The VAL function complements STR$.

■ See Also

    VAL

■ Example

    The following example contains a FUNCTION that uses the STR$ function to
    convert a number to its string representation. The FUNCTION then strips
    out the leading and trailing blanks that BASIC prints with numeric output.

    FUNCTION NumRemBlanks$(X) STATIC
        X$ = STR$(X)
        NumRemBlanks$ = LTRIM$(RTRIM$(X$))
    END FUNCTION

    PRINT "Enter 0 to end."
    DO
        INPUT "Find cosine of: ",Num
        IF Num = 0 THEN EXIT DO
        PRINT "COS(" NumRemBlanks$(Num) ") = " COS(Num)
    LOOP

■ Output

    Enter 0 to end.
    Find cosine of: 3.1
    COS(3.1) = -.9991351
    Find cosine of: 0

""","STRIG Function and Statement" to """
■ Action

    Returns the status of a specified joystick trigger

■ Syntax 1 (Function)

    STRIG(n)

■ Syntax 2 (Statement)

    STRIG {ON | OFF}

■ Remarks

    The STRIG function is used to test the joystick trigger status. In
    previous versions of BASIC, the statement STRIG ON enables testing of the
    joystick triggers; STRIG OFF disables joystick trigger testing. QuickBASIC
    ignores STRIG ON and STRIG OFF statements──the statements are provided for
    compatibility with earlier versions.

    The numeric expression n is an unsigned integer in the range 0-7,
    indicating the joystick and trigger to check. The following list describes
    the values returned by the STRIG(n) function for different values of n:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Argument                 Value Returned
    ──────────────────────────────────────────────────────────────────────────
    0                        Returns -1 if the lower button on joystick A has
                            been pressed since the last STRIG(0) call;
                            otherwise returns 0

    1                        Returns -1 if the lower button on joystick A is
                            currently down; otherwise returns 0

    2                        Returns -1 if the lower button on joystick B has
    Argument                 Value Returned
    ──────────────────────────────────────────────────────────────────────────
    2                        Returns -1 if the lower button on joystick B has
                            been pressed since the last STRIG(2) call;
                            otherwise returns 0

    3                        Returns -1 if the lower button on joystick B is
                            currently down; otherwise returns 0

    4                        Returns -1 if the upper button on joystick A has
                            been pressed since the last STRIG(4) call;
                            otherwise returns 0

    5                        Returns -1 if the upper button on joystick A is
                            currently down; otherwise returns 0

    6                        Returns -1 if the upper button on joystick B has
                            been pressed since the last STRIG(6) call;
                            otherwise returns 0

    7                        Returns -1 if the upper button on joystick B is
    Argument                 Value Returned
    ──────────────────────────────────────────────────────────────────────────
    7                        Returns -1 if the upper button on joystick B is
                            currently down; otherwise returns 0
    ──────────────────────────────────────────────────────────────────────────


    You can also use event trapping to get information from the joystick by
    using the ON STRIG statement (see the ON event statement). You cannot use
    the STRIG function inside a joystick event trap because the event that
    caused the trap is destroyed.

■ Differences From Basica

    If you are compiling from the BC command line, you must use the /V or /W
    option if a program contains a STRIG statement.

■ See Also

    ON event; STRIG ON, OFF, and STOP

■ Example

    The following example illustrates STRIG:

    'Wait for trigger A to be pressed.
    DO
        GotATrig = STRIG(0)
    LOOP UNTIL GotATrig
    'As long as trigger A is down, beep.
    DO
        GotATrig = STRIG(1)
        BEEP
    LOOP WHILE GotATrig

""","STRIG ON, OFF, and STOP Statements" to """
■ Action

    Enables, disables, or inhibits trapping of joystick activity

■ Syntax

    STRIG(n) ON
    STRIG(n) OFF
    STRIG(n) STOP

■ Remarks

    The argument, n, is a numeric expression indicating the joystick button to
    trap:

    Value                    Button
    ──────────────────────────────────────────────────────────────────────────
    0                        Lower button, joystick A
    2                        Lower button, joystick B
    4                        Upper button, joystick A
    6                        Upper button, joystick B
    ──────────────────────────────────────────────────────────────────────────

    The STRIG(n) ON statement enables joystick event trapping by an ON STRIG
    statement (see the ON event statement). While trapping is enabled, and if
    a nonzero line number is specified in the ON STRIG statement, BASIC checks
    between every statement to see if the joystick trigger has been pressed.

    The STRIG(n) OFF statement disables event trapping. If a subsequent event
    occurs (i.e., if the trigger is pressed), it will not be remembered when
    the next STRIG ON is executed.

    The STRIG(n) STOP statement inhibits event trapping. If an event occurs it
    is remembered, and the event trap takes place as soon as trapping is
    reenabled.

■ See Also

    ON event, STRIG

■ Example

    There is no programming example for the STRIG statement.

""","STRING$ Function" to """
■ Action

    Returns a string whose characters all have a given ASCII code or whose
    characters are all the first character of a string expression

■ Syntax

    STRING$(m,n)
    STRING$(m,stringexpression)

■ Remarks

    The STRING$ function has the following arguments:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    m                        A numeric expression indicating the length of the
                            string to return.

    n                        The ASCII code of the character to use to build
                            the string. It is a numeric expression that
                            evaluates to an integer value in the range 0-255.

    stringexpression         The string expression whose first character is
                            used to build the return string.
    ──────────────────────────────────────────────────────────────────────────

■ Examples

    The following example uses STRING$ to create part of a report heading:

    Dash$ = STRING$(10,45)
    PRINT Dash$;"MONTHLY REPORT";Dash$

■ Output

    ----------MONTHLY REPORT----------

    The following program uses STRING$ to generate a bar graph:

    PRINT TAB(7);"Daily Mean Temperature in Seattle" :
    PRINT
    'Get data for each month and graph.
    FOR Month = 1 TO 12 STEP 2
        READ Month$, Temp
        'Print Temp-35 stars.
        PRINT Month$;" +"; STRING$(Temp-35,"*")
        PRINT "    |"
    NEXT Month

    'Print horizontal line.
    PRINT "    +";
    FOR X = 1 TO 7
        PRINT "----+";
    NEXT X
    PRINT

    'Print temperature labels.
    FOR X = 4 TO 39 STEP 5
        PRINT TAB(X); X+31;
    NEXT X
    PRINT

    DATA Jan, 40, Mar, 46, May, 56
    DATA Jul, 66, Sep, 61, Nov, 46

■ Output

    Daily Mean Temperature in Seattle

    Jan +*****
        |
    Mar +***********
        |
    May +*********************
        |
    Jul +*******************************
        |
    Sep +**************************
        |
    Nov +***********
        |
        +----+----+----+----+----+----+----+
        35   40   45   50   55   60   65   70

""","SUB Statements" to """
■ Action

    Marks the beginning and end of a subprogram

■ Syntax

    SUB globalname«(parameterlist)» «STATIC»
    .
    .
    .
    «EXIT SUB»
    .
    .
    .
    END SUB

■ Remarks

    The SUB statement takes the following arguments:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    globalname               A variable name up to 40 characters long. This
                            name cannot appear in any other FUNCTION or SUB
                            statement in the same program or the user
                            library.

    parameterlist            Contains the names of simple variables and arrays
                            passed to the subprogram when the SUB is invoked.
                            Each name is separated from the preceding name by
                            a comma. Note that these variables and arrays are
                            passed by reference, so any change to an
                            argument's value in the subprogram also changes
                            its value in the calling program. See below for a
                            complete description of the syntax.
    ──────────────────────────────────────────────────────────────────────────

    A SUB parameterlist has the following syntax:

    variable«( )» «AS type» «, variable«( )» «AS type»»...

    A variable is a BASIC variable name. Previous versions of BASIC required
    the number of dimensions in parentheses after an array name. In
    QuickBASIC, the number of dimensions is not required. The argument type is
    the type of the variable. The type argument can be INTEGER, LONG, SINGLE,
    DOUBLE, STRING, or a user-defined type. You may not use a fixed-length
    string, or an array of fixed-length strings, as a parameter. However, you
    may use a simple fixed-length string as an argument in a CALL
    statement──QuickBASIC converts a simple fixed-length string argument to a
    variable-length string argument before passing the string to a SUB.

    A subprogram is a separate procedure, like a FUNCTION. However, a SUB
    cannot be used in an expression, unlike a FUNCTION.

    SUB and END SUB mark the beginning and end of a subprogram. You may also
    use the optional EXIT SUB statement to exit a subprogram.

    Subprograms are called by a CALL statement or by using the subprogram name
    followed by the argument list. See the entry for the CALL statement.
    QuickBASIC subprograms can be recursive──they can call themselves to
    perform a given task. See the second example below and Section 4.4,
    "Recursion."

    The STATIC attribute indicates that all variables local to the SUB are
    static──their values are saved between calls. Using the STATIC keyword
    slightly increases execution speed. STATIC is not usually used with
    recursive subprograms. See the examples below.

    Any subprogram variables or arrays are considered local to that subprogram
    unless they are explicitly declared as shared variables in a SHARED
    statement. You cannot define SUB procedures, DEF FN functions, or FUNCTION
    procedures inside a SUB procedure.
""","SWAP Statement" to """
■ Action

    Exchanges the values of two variables

■ Syntax

    SWAP variable1,variable2

■ Remarks

    Any type of variable can be swapped (integer, long, single precision,
    double precision, string, or record). However, the two variables must be
    exactly the same type or an error message appears (Type mismatch). For
    example, trying to swap an integer with a single-precision value produces
    Type mismatch.

■ Example

    The following subroutine (ShellSort) sorts the elements of a string array
    in descending order using a Shell sort. ShellSort uses SWAP to exchange
    array elements that are out of order.

    ' Sort the word list using a Shell sort.
    SUB ShellSort (Array$(), Num%) STATIC
        Span% = Num% \ 2
        DO WHILE Span% > 0
        FOR I% = Span% TO Num% - 1

            J% = I% - Span% + 1
        FOR J% = (I% - Span% + 1) TO 1 STEP -Span%

        IF Array$(J%) <= Array$(J% + Span%) THEN EXIT FOR
        ' Swap array elements that are out of order.
        SWAP Array$(J%), Array$(J% + Span%)
    NEXT J%

        NEXT I%
        Span% = Span% \ 2
        LOOP
    END SUB

""","SYSTEM Statement" to """
■ Action

    Closes all open files and returns control to the operating system

■ Syntax

    SYSTEM

■ Remarks

    When a SYSTEM command is executed, all files are closed and BASIC exits to
    the operating system (for stand-alone executable programs) or stops
    program execution (if the program is run in the QuickBASIC environment).
""","TAB Function" to """
■ Action

    Moves the print position

■ Syntax

    TAB(column)

■ Remarks

    The argument, column, is a numeric expression that is the column number of
    the new print position. If the current print position is already beyond
    column, the TAB function moves the print position to that column on the
    next line. Column 1 is the leftmost position, and the rightmost position
    is the current line width of the output device minus one. If column is
    greater than the output width, TAB wraps the output and the print position
    becomes 1 + (column MOD width). If column is less than 1, TAB moves the
    print position to column 1.

    TAB can only be used in PRINT and LPRINT statements.

■ See Also

    WIDTH

■ Examples

    The following example uses TAB to locate columns of output:

    FOR I = 1 TO 4
        READ A$,B$
        PRINT A$ TAB(25) B$
    NEXT
    DATA NAME, AMOUNT,,, G.T. JONES, $25.00, H.L. STEVENS, $32.25

■ Output

    NAME                    AMOUNT

    G.T. JONES              $25.00
    H.L. STEVENS            $32.25

    The following example shows the effects of different values used as
    arguments to TAB:

    'Assumes 80-column screen width.
    PRINT TAB(1287); "one"
    PRINT TAB(255); "two"
    PRINT TAB(-5); "three"
    PRINT "123456789012345678901234567890" TAB(20) "four"

■ Output

        one
                two
    three
    123456789012345678901234567890
                        four

""","TAN Function" to """
■ Action

    Returns the tangent of the angle x, where x is in radians

■ Syntax

    TAN(x)

■ Remarks

    TAN is calculated with single-precision accuracy unless x is a
    double-precision value, in which case TAN is calculated with
    double-precision accuracy.

■ Differences From Basica

    In BASICA, if TAN overflows, the interpreter displays the Overflow error
    message, returns machine infinity as the result, and continues execution.

    If TAN overflows, QuickBASIC does not display machine infinity and
    execution halts (unless the program has an error-handling routine).

■ Example

    The following example computes the height of an object using the distance
    from the object and the angle of elevation. The program draws the triangle
    produced by the base and the computed height.

    SCREEN 2

    INPUT "LENGTH OF BASE: ",Baselen
    INPUT "ANGLE OF ELEVATION (DEGREES,MINUTES): ",Deg,Min

    Ang = (3.141593/180)*(Deg + Min/60)   'Convert to radians.
    Height = Baselen*TAN(Ang)      'Calculate height.
    PRINT "HEIGHT =" Height
    H = 180 - Height
    B = 15 + Baselen

    LINE (15,180)-(B,180):LINE -(B,H)       'Draw triangle.
    LINE -(10,180)
    LOCATE 24,1 : PRINT "Press any key to continue...";
    DO
    LOOP WHILE INKEY$=""

""","TIME$ Function" to """
■ Action

    Returns the current time from the operating system

■ Syntax

    TIME$

■ Remarks

    The TIME$ function returns an eight-character string in the pattern
    hh:mm:ss, where hh is the hour (00-23), mm is minutes (00-59), and ss is
    seconds (00-59). A 24-hour clock is used; therefore, 8:00 PM is shown as
    20:00:00.

    To set the time, use the TIME$ statement.

■ See Also

    TIME$ Statement, TIMER

■ Example

    The following example converts the 24-hour time returned by TIME$ to a
    12-hour time:

    'Convert the 24-hour clock used by TIME$ to
    '12-hour output followed by "AM" or "PM."
    T$ = TIME$
    Hr = VAL(T$)
    IF Hr < 12 THEN Ampm$ = " AM" ELSE Ampm$ = " PM"
    IF Hr > 12 THEN Hr = Hr - 12
    PRINT "The time is" STR$(Hr) RIGHT$(T$,6) Ampm$

■ Output

    The time is 11:26:31 AM

""","TIME$ Statement" to """
■ Action

    Sets the time

■ Syntax

    TIME$=stringexpression

■ Remarks

    The stringexpression must be in one of the following forms:

    Form                     Description
    ──────────────────────────────────────────────────────────────────────────
    hh                       Sets the hour; minutes and seconds default to 00
    hh:mm                    Sets the hour and minutes; seconds default to 00
    hh:mm:ss                 Sets the hour, minutes, and seconds
    ──────────────────────────────────────────────────────────────────────────

    A 24-hour clock is used, so 8:00 PM would be entered as 20:00:00.

    This statement complements the TIME$ function, which returns the current
    time.

■ See Also

    TIME$ Function

■ Example

    The following example sets the current time to 8:00 AM:

    TIME$="08:00:00"

""","TIMER Function" to """
■ Action

    Returns the number of seconds elapsed since midnight

■ Syntax

    TIMER

■ Remarks

    The TIMER function can be used with the RANDOMIZE statement to generate a
    random number. It can also be used to time programs or parts of programs.

■ Example

    The following program searches for the prime numbers from 3 to 10,000
    using a variation of the Sieve of Eratosthenes. The TIMER function is used
    to time the program.

    DEFINT A-Z
    CONST UNMARK = 0, MARKIT = NOT UNMARK
    DIM Mark(10000)
    Start! = TIMER
    Num = 0
    FOR N = 3 TO 10000 STEP 2
        IF NOT Mark(N) THEN
        'PRINT N,   'To print the primes, remove the
                    'remark delimiter in front of the
                    'PRINT statement.
        Delta = 2*N
        FOR I = 3*N TO 10000 STEP Delta
            Mark(I) = MARKIT
        NEXT
        Num = Num + 1
        END IF
    NEXT
    Finish! = TIMER
    PRINT : PRINT "Program took"; Finish!-Start!;
    PRINT "seconds to find the"; Num; "primes"
    END

■ Output

    Program took .1601563 seconds to find the 1228 primes

""","TIMER ON, OFF, and STOP Statements" to """
■ Action

    Enables, disables, or inhibits timer event trapping

■ Syntax

    TIMER ON
    TIMER OFF
    TIMER STOP

■ Remarks

    TIMER ON enables timer event trapping by an ON TIMER statement (see the
    statement ON event). While trapping is enabled, a check is made after
    every statement to see if the specified time has elapsed. If it has, the
    ON TIMER event-handling routine is executed.

    TIMER OFF disables timer event trapping. If an event takes place, it is
    not remembered if a subsequent TIMER ON is executed.

    TIMER STOP disables the timer event trapping. However, if an event occurs,
    it is remembered and the ON TIMER event-handling routine is executed as
    soon as trapping is reenabled with TIMER ON.

■ See Also

    ON event

■ Example

    The following example displays the time of day on line 1, and updates the
    display once a minute:

    TIMER ON
    ON TIMER(60) GOSUB Display
    DO WHILE INKEY$ = "" : LOOP
    END

    Display:
        Oldrow = CSRLIN       'Save current row.
        Oldcol = POS(0)       'Save current column.
        LOCATE 1,1 : PRINT TIME$;
        LOCATE Oldrow,Oldcol   'Restore row & column.
    RETURN

""","TRON/TROFF Statements" to """
■ Action

    Traces the execution of program statements

■ Syntax

    TRON
    TROFF

■ Remarks

    In the QuickBASIC environment, executing a TRON statement has the same
    effect as selecting Trace On from the Debug menu──each statement is
    highlighted on the screen as it executes.

    The TROFF statement turns off the program trace.

    The TRON and TROFF statements only display line numbers when compiled with
    the Debug option or the /D option on the BC command line.
""","TYPE Statement" to """
■ Action

    Defines a data type containing one or more elements

■ Syntax

    TYPE usertype
        elementname AS typename
        elementname AS typename
    .
    .
    .
    END TYPE

■ Remarks

    The TYPE statement takes the following arguments:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    usertype                 A name given to the user-defined data type.
                            Follows the same rules as a BASIC variable name.

    elementname              The name of an element of the user-defined data
                            type. Follows the same rules as a BASIC variable
                            name. Cannot be the name of an array.

    typename                 May be any of the following BASIC data types:
                            INTEGER, LONG, SINGLE, DOUBLE, fixed-length
                            string (see note below), or user-defined type.
    ──────────────────────────────────────────────────────────────────────────
""","UBOUND Function" to """
■ Action

    Returns the upper bound (largest available subscript) for the indicated
    dimension of an array

■ Syntax

    UBOUND(array«,dimension»)

■ Remarks

    The argument dimension is an integer from 1 to the number of dimensions in
    array. For an array dimensioned as follows, UBOUND returns the values
    listed below:

    DIM A(1 TO 100, 1 TO 50, -3 TO 4)

    Invocation               Value Returned
    ──────────────────────────────────────────────────────────────────────────
    UBOUND(A,1)              100
    UBOUND(A,2)              50
    UBOUND(A,3)              4
    ──────────────────────────────────────────────────────────────────────────

    You can use the shortened syntax UBOUND(array) for one-dimensional arrays
    since the default value for dimension is 1. Use the LBOUND function to
    find the lower limit of an array dimension.

■ See Also

    LBOUND

■ Example

    LBOUND and UBOUND can be used together to determine the size of an array
    passed to a subprogram, as in the following program fragment:

    CALL PRNTMAT(ARRAY())
    .
    .
    .
    SUB PRNTMAT(A()) STATIC
        FOR I% = LBOUND(A,1) TO UBOUND(A,1)
        FOR J% = LBOUND(A,2) TO UBOUND(A,2)
            PRINT A(I%,J%);" ";
            NEXT J%
        PRINT:PRINT
        NEXT I%
    END SUB

""","UCASE$ Function" to """
■ Action

    Returns a string expression with all letters in uppercase

■ Syntax

    UCASE$ (stringexpression)

■ Remarks

    The stringexpression argument can be any string expression. The UCASE$
    function works with both variable- and fixed-length strings. The UCASE$
    and LCASE$ statements are helpful in making string comparisons case
    insensitive.

■ See Also

    LCASE$

■ Example

    The following program contains a FUNCTION, YesQues, that returns a Boolean
    value depending on how the user responds. The program YesQues uses UCASE$
    to make a case-insensitive test of the user's response.

    DEFINT A-Z

    FUNCTION YesQues(Prompt$,Row,Col) STATIC
        OldRow=CSRLIN
        OldCol=POS(0)
        ' Print prompt at Row, Col.
        LOCATE Row,Col : PRINT Prompt$ "(Y/N):";
        DO
        ' Get the user to press a key.
        DO
            Resp$=INKEY$
        LOOP WHILE Resp$=""
        Resp$=UCASE$(Resp$)
        ' Test to see if it's yes or no.
        IF Resp$="Y" OR Resp$="N" THEN
            EXIT DO
        ELSE
            BEEP
        END IF
        LOOP
        ' Print the response on the line.
        PRINT Resp$;
        ' Move the cursor back to the old position.
        LOCATE OldRow,OldCol
        ' Return a Boolean value by returning the result of a test.
        YesQues=(Resp$="Y")
    END FUNCTION

    DO
    LOOP WHILE NOT YesQues("Do you know the frequency?",12,5)

""","UEVENT Statement" to """
■ Action

    Enables, disables, or suspends event trapping for a user-defined event

■ Syntax

    UEVENT ON
    UEVENT OFF
    UEVENT STOP

■ Remarks

    The effects of the UEVENT statements are like that of other event-trapping
    statements. When UEVENT ON is executed, the event-trapping routine is
    enabled. Occurrences of the event trigger execution of the event-handling
    routine.

    When UEVENT OFF is executed, the event-trapping routine is disabled. Any
    occurrences of the event are ignored.

    When UEVENT STOP is executed, the event-trapping routine is suspended. An
    event occurrence is remembered and the event-trapping routine performed as
    soon as a UEVENT ON statement is executed.

■ See Also

    ON UEVENT

■ Example

    See the example for ON UEVENT.

""","UNLOCK Statement" to """
■ Action

    Releases locks applied to parts of a file

■ Syntax

    UNLOCK «#» filenumber «,{record | «start» TO end}»

■ Remarks

    The UNLOCK statement is used only after a LOCK statement. See the LOCK
    statement for a complete discussion.

    For binary-mode files, the arguments record, start, and end represent the
    number of a byte relative to the beginning of the file. The first byte in
    a file is byte 1.

    For random-access files, these arguments are the number of a record
    relative to the beginning of the file. The first record is record 1.

■ See Also

    LOCK

■ Example

    See the example for LOCK.

""","VAL Function" to """
■ Action

    Returns the numeric value of a string of digits

■ Syntax

    VAL(stringexpression)

■ Remarks

    The stringexpression is a sequence of characters that can be interpreted
    as a numeric value. The VAL function stops reading the string at the first
    character that it cannot recognize as part of a number. The VAL function
    also strips leading blanks, tabs, and line feeds from the argument string.
    For example,

    VAL("    -33/LP")

    returns the value -33.

■ See Also

    STR$

■ Example

    The following program prints the names and addresses of people with
    specific telephone area codes:

    INPUT "Search for which area: ", Targetarea
    OPEN "MAIL.DAT" FOR INPUT AS #1
    DO WHILE NOT EOF(1)
        INPUT #1, Nm$, Phonenum$, Street$, Citystate$
        'VAL reads everything up to the first non-numeric
        'character ("-" in this case).
        Area = VAL(Phonenum$)
        IF Area = Targetarea THEN
        PRINT : PRINT Nm$
        PRINT Street$
        PRINT Citystate$
        END IF
    LOOP
    CLOSE : END


""","VARPTR, VARSEG Functions" to """
■ Action

    Returns the address of a variable

■ Syntax

    VARPTR(variablename)
    VARSEG(variablename)

■ Remarks

    The variablename may be any BASIC variable, including a record variable or
    record element. The VARPTR function returns an unsigned integer that is
    the offset of the variable within its segment. The VARSEG function returns
    an unsigned integer that is the segment part of the variable's address. If
    variablename is not defined before either VARPTR or VARSEG is called, the
    variable is created and its address is returned. When variablename is a
    string variable, VARPTR and VARSEG return the location of the first byte
    of the string descriptor.
""","VARPTR$ Function" to """
■ Action

    Returns a string representation of a variable's address as needed for use
    in DRAW and PLAY statements

■ Syntax

    VARPTR$(variablename)

■ Remarks

    The variablename is the name of a variable in the program. If variablename
    is an array element, then the array must be dimensioned before the VARPTR$
    function is used. The array must be an array of variable-length strings.
""","VIEW Statement" to """
■ Action

    Defines screen limits for graphics output

■ Syntax

    VIEW ««SCREEN» (x1,y1)-(x2,y2) «,«color» «,border»»»

■ Remarks

    The list below describes the parts of the VIEW statement:

╓┌─┌────────────────────────┌────────────────────────────────────────────────╖
    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
    SCREEN                   When SCREEN is used, the x-and y-coordinates are
                            absolute to the screen, not relative to the
                            border of the physical viewport. Only graphics
                            within the viewport are plotted. When SCREEN is
    Part                     Description
    ──────────────────────────────────────────────────────────────────────────
                            within the viewport are plotted. When SCREEN is
                            omitted, all points are plotted relative to the
                            viewport (x1 and x2 are added to coordinates
                            before plotting the point).

    (x1,y1) - (x2,y2)        Indicates a rectangular area on the screen. The
                            placeholders x1, y1, x2, and y2 are numeric
                            expressions that are the coordinates of
                            diagonally opposite corners of the area.

    color                    The color attribute of the color used to fill the
                            area. If you omit color, the area is not filled.

    border                   Any numeric expression in this area draws a line
                            around the viewport if space is available. If you
                            omit border, no border is drawn.
    ──────────────────────────────────────────────────────────────────────────


    The VIEW statement defines a "physical viewport," or a rectangular section
    of the screen into which graphics can be mapped. All coordinates used in
    the statement must be within the physical bounds of the screen.

    If VIEW is given with no arguments, the entire screen is defined as the
    viewport. RUN and SCREEN also define the entire screen as the viewport and
    disable any viewports defined with VIEW.

■ Examples

    The following example contrasts the output after VIEW and VIEW SCREEN are
    executed:

    SCREEN 1
    'SCREEN option makes all screen coordinates absolute.
    VIEW SCREEN (10,10)-(200,100)
    'This line will not be visible, since its end
    'points are outside the viewport.
    LINE (5,5)-(100,5)
    PRINT "Press any key to continue."
    SUSPEND$ = INPUT$(1)
    'Wait for a key to be pressed.

    'No SCREEN option - all screen coordinates relative to
    'this viewport.
    VIEW (10,10)-(200,100)
    'This line is now visible, since its end points
    'are added to (10,10).
    LINE (5,5)-(100,5)

    You may use multiple VIEW statements. If the newly described viewport is
    not wholly within the previous viewport, the screen can be reinitialized
    with the VIEW statement and the new viewport can be defined. If the new
    viewport is entirely within the previous one, as in the following example,
    the intermediate VIEW statement is not necessary. This example opens three
    viewports, each smaller than the previous one. In each case, the points of
    the line that lie outside the viewport borders are clipped and do not
    appear on the screen.

    SCREEN 1
    CLS
    VIEW
    'Make the viewport cover most of the screen.
    VIEW (10,10) - (300,180),,1
        CLS
        LINE (0,0) - (310,190),1
        LOCATE 1,11: PRINT "A big viewport"
    VIEW SCREEN (50,50)-(250,150),,1
        CLS
    'Note CLS clears only viewport.
        LINE (300,0)-(0,199),1
        LOCATE 9,9: PRINT "A medium viewport"
    VIEW SCREEN (80,80)-(200,125),,1
        CLS
        CIRCLE (150,100),20,1
        LOCATE 11,9: PRINT "A small viewport"

""","VIEW PRINT Statement" to """
■ Action

    Sets the boundaries of the screen text viewport

■ Syntax

    VIEW PRINT «topline TO bottomline»

■ Remarks

    The topline argument is the number of the upper line in the viewport; the
    bottomline is the number of the lower line.

    Without topline and bottomline parameters, the VIEW PRINT statement
    initializes the whole screen area as the text viewport. The number of
    lines in the screen depends on the screen mode and whether or not the /H
    option was used when QuickBASIC was started. See the entry for the WIDTH
    statement and Chapter 3, "File and Device I/O," in Programming in BASIC,
    for more information.

    Statements and functions that operate within the defined text viewport
    include CLS, LOCATE, PRINT, and the SCREEN function.

■ See Also

    CLS, LOCATE, PRINT, SCREEN Function, VIEW

■ Example

    See the example for CLS.

""","WAIT Statement" to """
■ Action

    Suspends program execution while monitoring the status of a machine input
    port

■ Syntax

    WAIT portnumber,and-expression«,xor-expression»

■ Remarks

    The following list describes the arguments of the WAIT statement:

    Argument                 Description
    ──────────────────────────────────────────────────────────────────────────
    portnumber               An integer expression in the range 0-255 that is
                            the number of the port

    and-expression           An integer expression combined with data from the
                            port through an AND operation

    xor-expression           An integer expression combined with data from the
                            port using an XOR operation
    ──────────────────────────────────────────────────────────────────────────

    The WAIT statement suspends execution until a specified bit pattern is
    read from a designated input port. The data read from the port is
    combined, using an XOR operation, with xor-expression, if it appears. The
    result is then combined with the and-expression using an AND operation. If
    the result is zero, BASIC loops back and reads the data at the port again.
    If the result is nonzero, execution continues with the next statement. If
    xor-expression is omitted, it is assumed to be 0.
""","WHILE...WEND Statement" to """
■ Action

    Executes a series of statements in a loop, as long as a given condition is
    true

■ Syntax

    WHILE condition
    .
    .
    .
    «statements»
    .
    .
    .
    WEND

■ Remarks

    If the condition is true (that is, if it does not equal zero), then any
    intervening statements are executed until the WEND statement is
    encountered. BASIC then returns to the WHILE statement and checks
    condition. If it is still true, the process is repeated. If it is not true
    (or if it equals zero), execution resumes with the statement following the
    WEND statement.
""","WIDTH Statement" to """
■ Action

    Assigns an output-line width to a file or device or changes the number of
    columns and lines displayed on the screen

■ Syntax

    WIDTH «columns»«,lines»
    WIDTH {#filenumber | device},width
    WIDTH LPRINT width

■ Remarks

    Both files and devices can be assigned an output-line width. The different
    forms of the WIDTH statement are explained in the following list:

╓┌─┌────────────────────────────────────┌────────────────────────────────────╖
    Syntax                               Description
    ──────────────────────────────────────────────────────────────────────────
    Syntax                               Description
    ──────────────────────────────────────────────────────────────────────────
    WIDTH «columns»«,lines»              Sets the number of columns and lines
                                        to display on the screen.

                                        The value of columns must be either
                                        40 or 80. The default value is 80.

                                        The value of lines may be 25, 30, 43,
                                        50, or 60, depending on both the
                                        display adapter used and the screen
                                        mode.

                                        The number of lines displayed when
                                        the program started will determine
                                        the default value. See the SCREEN
                                        statement for more information.

    WIDTH #filenumber, width             Sets to width the line width of an
                                        output device opened as a file (for
                                        example, LPT1: or CONS:). The
    Syntax                               Description
    ──────────────────────────────────────────────────────────────────────────
                                        example, LPT1: or CONS:). The
                                        filenumber argument is the number
                                        associated with the file in the OPEN
                                        statement.

                                        This form permits altering the width
                                        while a file is open, since the
                                        statement takes place immediately.

    WIDTH device,width                   Sets to width the line width of
                                        device (a device file name). The
                                        device should be a string expression
                                        (for example, "CONS:").

                                        Note that this width assignment is
                                        deferred until the next OPEN
                                        statement affecting the device; the
                                        assignment does not affect output for
                                        an already open file.
    Syntax                               Description
    ──────────────────────────────────────────────────────────────────────────
                                        an already open file.

    WIDTH LPRINT width                   Sets to width the line width of the
                                        line printer for use by subsequent
                                        LPRINT statements.
    ──────────────────────────────────────────────────────────────────────────


■ See Also

    SCREEN Statement

■ Example

    In the following example, the record width for file #1 (the lineprinter)
    is set to different widths:

    OPEN "LPT1:" FOR OUTPUT AS #1
    Test$ = "1234567890"
    WIDTH #1, 3
    PRINT #1, Test$
    WIDTH #1, 4
    PRINT #1, Test$
    CLOSE

■ Output

    123
    456
    789
    0
    1234
    5678
    90

""","WINDOW Statement" to """
■ Action

    Defines the dimensions of the current viewport

■ Syntax

    WINDOW ««SCREEN» (x1,y1)-(x2,y2)»

■ Remarks

    The WINDOW statement allows the user to create a customized coordinate
    system to draw lines, graphs, or objects without being constrained by the
    screen's physical coordinates (the dimensions of the screen). This is done
    by redefining the screen-border coordinates with the "view coordinates"
    (x1, y1) and (x2, y2). These view coordinates are single-precision
    numbers.

    WINDOW defines the section of the view coordinate system that is mapped to
    the physical coordinates of the screen. All subsequent graphics statements
    use these new view coordinates and are displayed within the current
    viewport. (The size of the viewport can be changed with the VIEW
    statement.)

    Either the RUN statement or WINDOW with no arguments disables the window
    transformation. The WINDOW SCREEN variant inverts the normal Cartesian
    direction of the y-coordinate, so y values go from negative to positive
    from top to bottom.

    Figure R.1 shows the effects of WINDOW and WINDOW SCREEN on a line drawn
    in screen mode 2. Notice the change in the coordinates of the screen
    corners.

■ Examples

    The following example illustrates two lines with the same end-point
    coordinates. The first is drawn on the default screen, and the second is
    on a redefined window.

    SCREEN 2
    LINE (100,100) - (150,150), 1
    LOCATE 2,20 : PRINT "The line on the default screen"
    WINDOW SCREEN (100,100) - (200,200)
    LINE (100,100) - (150,150), 1
    LOCATE 8,18 : PRINT"& the same line on a redefined window"

                                Increasing X
                            ─────────────────────────►
                        │ ┌─────────────────────────┐
                        │ │(0,0)             (639,0)│
                Increasing│ │                         │
                    Y     │ │                         │
                        │ │                         │
                        │ │                         │
                        │ │                         │
                        │ │                         │
                        │ │(0,199)         (639,199)│
                        ▼ └─────────────────────────┘
                                        /  \
                                    /       \
                                    /            \
            WINDOW (-25,-15)   /        WINDOW SCREEN (-25,-15)-(5,10)
            LINE (-15,-10)-(-5,-5)      LINE  (-15,-10)-(-5,-5)
                            /                           \
                        /                                \
                        /                                     \
                    /                                          \      Increas
                ┌─────────────────────────┐                     ───────────────
                │(-25,10)           (5,10)│                   │  ┌─────────────
            │ │                         │                   │  │(-25,-15)
    Increasing│ │                 (0,0)   │        Increasing │  │
        Y     │ │                         │            Y      │  │      ∙\(-15,
            │ │           (-5,-5)∙      │                   │  │         \
            │ │              /          │                   │  │           \∙
            │ │            /            │                   │  │
            │ │  (-15,-10)∙             │                   │  │
            │ │(-25,-15)         (5,-15)│                   │  │
                └─────────────────────────┘                   │  │(-25,10)
                ─────────────────────────►                    ▼  └─────────────
                        Increasing X

    Figure R.1 WINDOW and WINDOW SCREEN

    The following example shows how changing the window size changes the size
    of a figure drawn on the screen. The effect is one of zooming in and out;
    as the window gets smaller, the figure appears larger on the screen, until
    parts of it are finally clipped because they lie outside the window. As
    the window gets larger, the figure appears smaller on the screen.

    PRINT "Press ENTER to start."
    INPUT;"",A$
    SCREEN 1 : COLOR 7              'Grey screen.
    X = 500 : Xdelta = 50

    DO
        DO WHILE X < 525 AND X > 50
        X = X + Xdelta            'Change window size.
        CALL Zoom(X)
        FOR I = 1 TO 1000         'Delay loop.
            IF INKEY$ <> "" THEN END   'Stop if key pressed.
        NEXT
        LOOP
        X = X - Xdelta
        Xdelta = -Xdelta             'Reverse size change.
    LOOP

    SUB Zoom(X) STATIC
        CLS
        WINDOW (-X,-X)-(X,X)         'Define new window.
        LINE (-X,-X)-(X,X),1,B       'Draw window border.
        CIRCLE (0,0),60,1,,,.5       'Draw ellipse with x-radius 60.
        PAINT (0,0),1                'Paint ellipse.
    END SUB

""","WRITE Statement" to """
■ Action

    Sends data to the screen

■ Syntax

    WRITE «expressionlist»

■ Remarks

    If expressionlist is omitted, a blank line is written. If expressionlist
    is included, the values of the expressions are written to the screen. The
    expressions in the list may be numeric and/or string expressions. They
    must be separated by commas.

    When the printed items are written, each item is separated from the last
    by a comma. Printed strings are delimited by quotation marks. After the
    last item in the list is printed, BASIC inserts a carriage-return and
    line-feed. The WRITE statement writes numeric values without leading or
    trailing spaces.

■ See Also

    PRINT

■ Example

    The following example shows the difference between the PRINT and WRITE
    statements:

    A=80 : B=90 : C$="That's all." : D=-1.0E-13
    WRITE A,B,C$,D
    PRINT A,B,C$,D

■ Output

    80,90,"That's all.",-1E-13
    80            90           That's all.  -1E-13

""","WRITE # Statement" to """
■ Action

    Writes data to a sequential file

■ Syntax

    WRITE #filenumber,expressionlist

■ Remarks

    The filenumber is the number used in the OPEN statement. The file must be
    opened in OUTPUT or APPEND mode. The expressions in the argument
    expressionlist are string and/or numeric expressions, separated by commas.
    If you omit the expressionlist, the WRITE # statement writes a blank line
    to the file.

    The WRITE # statement, unlike the PRINT # statement, inserts commas
    between items as they are written to the file. You do not have to put
    explicit delimiters in the list. A new line is inserted once the last item
    in the list has been written to the file.

    If WRITE # attempts to write data to a sequential file restricted by a
    LOCK statement, an error message appears that reads Permission denied
    unless the error is trapped by the program. All of BASIC's usual
    error-handling routines can trap and examine this error.

■ See Also

    LOCK, OPEN, PRINT #, WRITE

■ Example

    The output from the following program illustrates the difference between
    the WRITE # and PRINT # statements:

    A$ = "VCR, remote control" : B$ = "$399.00"
    OPEN  "PRICES" FOR OUTPUT AS #1       'Open PRICES for writing.
    PRINT #1,A$,B$   'Store A$ and B$ in first record with PRINT #.
    WRITE #1,A$,B$   'Store A$ and B$ in second record with WRITE #.
    CLOSE #1

■ Output

    VCR, remote control         $399.00
    "VCR, remote control","$399.00"


════════════════════════════════════════════════════════════════════════════
Glossary


CONTROL FLOW

FOR...NEXT  Repeats statements between FOR and NEXT a specific number of
    times.

EXIT FOR  alternative exit from FOR...NEXT

DO...LOOP  Repeats statements between DO and LOOP, while (until) a condition
    is(becomes) true.

EXIT DO  alternative exit from DO...LOOP

WHILE...WEND  Repeats statements between WHILE and WEND while a given
    condition is true.

IF...THEN...ELSE... END IF  Conditionally executes or branches todifferent
    statements.

SELECT CASE  Conditionally executes statements based on value of a variable.

GOSUB...RETURN  Transfers contol to a specific line in a module; control
    returns to the line following GOSUB. (Old style; SUB is a more powerful
    alternative.)

RUN  Restarts current program, or loads and runs another program.

CHAIN "program"  Passes execution to program specified, then returns.

SLEEP  Suspends program execution.

WAIT  Suspends program execution while monitoring status of a machine input
    port.


PROCEDURES

SUB...END SUB  Mark the beginning and end of a SUBprocedure.

EXIT SUB  alternative exit from a SUB procedure

FUNCTION... END FUNCTION  Mark the beginning and end of aFUNCTION procedure.

EXIT FUNCTION  alternative exit from aFUNCTION procedure

DEF FN...END DEF  Mark the beginning and end of a DEF FN function. (Old
    style; FUNCTION is a more powerful alternative.)

EXIT DEF  alternative exit from aDEF FN function

CALL, CALLS  Transfers control to a BASIC SUB procedure, or a procedure
    written in another language and compiled separately.


STANDARD I/O

BEEP  Makes the speaker beep.

SOUND  Makes a sound of specified frequency and duration.

PRINT [USING]  Outputs [formatted] text to the screen.

WIDTH  Sets screen width and number of lines.

INKEY$  Reads a character from the keyboard.

INP (n)  Returns the value read from I/O port n.

INPUT  Reads string and/or numerical input from the keyboard and stores it
    in a list ofvariables.

INPUT$  Reads characters from the keyboard into a string variable.

LINE INPUT  Reads an entire line (up to 255 chars) into a string variable.

LOCATE  Moves cursor to a specified screen row and column.

SPC  Skips spaces in printed output.

TAB  Skips to a specified display column.

CSRLIN  Returns row number of cursor.

POS  Returns line number of cursor.

LPOS  Returns position of line printer's print head within the printer
    buffer.

VIEW PRINT  Sets top and bottom rows for displaying print.

LPRINT [USING]  Prints [formatted] data on LPT1: printer.

OPEN COMn:  Opens and initializes a communications channel for I/O.

OUT  Sends a byte to a machine I/O port.

PEN  Returns the light pen coordinates.

STICK  Returns the x and y coordinates of the two joysticks.

STRIG  Returns the status of a specified joystick trigger (fire button).

READ  Returns values from a DATA statement and assigns them to variables.

RESTORE  Allows DATA statements to be reread from a specified line.


FILE I/O

OPEN  Opens a file for reading or writing records.

CLOSE  Ends I/O operations to a file.

RESET  Closes all disk files.

PRINT [USING] #  Stores a [formatted] list of variables in a file.

WRITE #  Stores a list of variables as record fields in a file.

FIELD  Allocates space for variables in a random-access file buffer.

WIDTH  Specifies a standard length for each record in a file.

PUT  Stores contents of a variable in a file.

INPUT #  Reads fields from a record; assigns each to a variable.

INPUT$  Reads a string of characters from a file.

LINE INPUT #  Reads a record and stores it in a string variable.

GET  Reads data from a file; assigns data to elements of a variable.

FREEFILE  Returns the next available file number.

EOF  Tests whether the end of a disk file has been reached.

FILEATTR  Returns a number indicating the mode in which a file was opened.

LOC  Gives the current position within a file.

LOF  Gives the number of bytes in an open file.

SEEK (function)  Gives the location where the next file I/O operation will
    occur.

SEEK (statement)  Sets the byte position for the next file I/O operation.

IOCTL  Transmits a control data string to a device driver.

IOCTL$  Receives a control data string from a device driver.

LOCK...UNLOCK  Controls access by other processes to all or part of an open
    file.


STRING PROCESSING

LEFT$  Returns characters from the left side of the string.

RIGHT$  Returns characters from the right side of the string.

MID$ function  Returns characters from anywhere in the string.

MID$ statement  Replaces part of a string with another string.

LTRIM$  Strips leading blanks from string.

RTRIM$  Strips trailing blanks from string.

INSTR  Searches for a string within another string.

LCASE$  Converts a string to all lower-case letters.

UCASE$  Converts a string to all upper-case letters.

LSET  Left-justifies a fixed-length string.

RSET  Right-justifies a fixed-length string.

STR$  Returns the string representation of the decimal value of a numeric
    expression.

HEX$  Returns the string representation of the hex value of a numeric
    expression.

VAL  Returns the numeric value of a stringexpression.

SPACE$  Returns a string of blanks.

STRING$  Returns a string of one repeatedcharacter.

LEN  Returns the number of characters in a string.

ASC  Returns the ASCII value of a character.

CHR$  Returns the character with the given ASCII value.

SADD  Returns the address of the specifiedstring expression.


GRAPHICS

SCREEN  Specifies a BASIC screen mode.

PSET  Sets a pixel to the foreground color.

PRESET  Sets a pixel to the background color.

LINE  Draws a straight line or a box.

CIRCLE  Draws a circle or an ellipse.

DRAW  Combines BASIC graphics features into a graphics macro language.

WINDOW  Sets the logical coordinates for a screen viewport.

VIEW  Specifies a viewport rectangle for graphics output.

PMAP  Maps pixel physical coordinates to logical coordinates.

POINT  Returns physical or logical coordinates of cursor, or color number of
    pixel.

COLOR  Sets default colors for graphics output.

PALETTE  Assigns colors to color numbers.

PAINT  Fills an area with color or a pattern.

GET  Saves a rectangular area of graphics screen in memory.

PUT  Displays graphics stored by GET.

PCOPY  Copies one screen storage page to another.


ERROR AND EVENT TRAPPING

ON ERROR GOTO line  Program branches to line number or line label when error
    occurs.

RESUME  Returns control after executing error-handling routine.

ERR  Returns code for run-time error.

ERL  Returns line number on which erroroccurred.

ERDEV  Returns code for last device which caused an error.

ERDEV$  Returns name of last device which caused an error.

ERROR  Simulates occurrence of a BASIC error.

ON event GOSUB line  Branches to routine labelled with line, whenever event
    occurs.

event ON  Enables trapping of event.

event OFF


""",)
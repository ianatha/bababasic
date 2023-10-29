package org.puffinbasic.runtime;

import org.puffinbasic.domain.PuffinBasicSymbolTable;
import org.puffinbasic.parser.PuffinBasicIR.Instruction;

import java.util.List;
import java.util.regex.Pattern;
//import static org.puffinbasic.runtime.GraphicsUtil.PUT_XOR;

class GraphicsRuntime {

    private static final Pattern DRAW_ARG1 = Pattern.compile("([UDLREFGHA])([BN]+)?([0-9]+)");
    private static final Pattern DRAW_ARG2 = Pattern.compile("M([+\\-]?[0-9]+),([+\\-]?[0-9]+)");

    public static void saveimg(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
//        var path = symbolTable.get(instruction.op1).getValue().getString();
//        var entry = symbolTable.getVariable(instruction.op2);
//        var variableValue = entry.getValue();
//        if (variableValue.getNumArrayDimensions() != 2 || entry.getType().getAtomTypeId() != INT32) {
//            throw new PuffinBasicRuntimeError(
//                    GRAPHICS_ERROR,
//                    "Bad Array Variable, expected Int32 2D-Array Variable: " + entry
//            );
//        }
//
//        var dims = variableValue.getArrayDimensions();
//        final BufferedImage image = new BufferedImage(dims.getInt(0), dims.getInt(1), BufferedImage.TYPE_3BYTE_BGR);
//
//        image.setRGB(0, 0, image.getWidth(), image.getHeight(),
//                variableValue.getInt32Array1D(), 0, image.getWidth());
//
//        var ext = FilenameUtils.getExtension(path);
//        try {
//            ImageIO.write(image, ext, new File(path));
//        } catch (IOException e) {
//            throw new PuffinBasicRuntimeError(
//                    IO_ERROR,
//                    "Failed to save image: " + path + ", error: " + e.getMessage()
//            );
//        }
    }

    public static void loadimg(
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
//        var path = symbolTable.get(instruction.op1).getValue().getString();
//        var entry = symbolTable.getVariable(instruction.op2);
//        var variableValue = entry.getValue();
//        if (variableValue.getNumArrayDimensions() != 2 || entry.getType().getAtomTypeId() != INT32) {
//            throw new PuffinBasicRuntimeError(
//                    GRAPHICS_ERROR,
//                    "Bad Array Variable, expected Int32 2D-Array Variable: " + entry
//            );
//        }
//
//        final BufferedImage image;
//        try {
//            image = ImageIO.read(new File(path));
//        } catch (IOException e) {
//            throw new PuffinBasicRuntimeError(
//                    IO_ERROR,
//                    "Failed to load image: " + path + ", error: " + e.getMessage()
//            );
//        }
//
//        var dims = variableValue.getArrayDimensions();
//        if (image.getWidth() != dims.getInt(0) || image.getHeight() != dims.getInt(1)) {
//            throw new PuffinBasicRuntimeError(
//                    GRAPHICS_ERROR,
//                    "Image dimensions: " + image.getWidth() + ", " + image.getHeight()
//                            + " doesn't match with variable dimensions: "
//                            + dims.getInt(0) + ", " + dims.getInt(1)
//            );
//        }
//
//        image.getRGB(0, 0, image.getWidth(), image.getHeight(),
//                variableValue.getInt32Array1D(), 0, image.getWidth());
    }

    public static void screen(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            List<Instruction> instr0,
            Instruction instruction) {
//        var i0 = instr0.get(0);
//        var i1 = instr0.get(1);
//        var i2 = instr0.get(2);
//        var w = symbolTable.get(i0.op1).getValue().getInt32();
//        var h = symbolTable.get(i0.op2).getValue().getInt32();
//        var iw = symbolTable.get(i1.op1).getValue().getInt32();
//        var ih = symbolTable.get(i1.op2).getValue().getInt32();
//        var title = symbolTable.get(instruction.op1).getValue().getString();
//        if (w <= 0 || h <= 0 || w > GraphicsUtil.MAX_WIDTH || h > GraphicsUtil.MAX_HEIGHT) {
//            throw new PuffinBasicRuntimeError(
//                    GRAPHICS_ERROR,
//                    "Screen size out-of-bounds: " + w + ", " + h
//            );
//        }
//        if (iw <= 0 || ih <= 0 || iw > GraphicsUtil.MAX_WIDTH || ih > GraphicsUtil.MAX_HEIGHT) {
//            throw new PuffinBasicRuntimeError(
//                    GRAPHICS_ERROR,
//                    "Image size out-of-bounds: " + iw + ", " + ih
//            );
//        }
//        var autoRepaint = symbolTable.get(i2.op1).getValue().getInt32() == -1;
//        var doubleBuffer = symbolTable.get(i2.op2).getValue().getInt32() == -1;
//
//        graphicsState.setFrame(new BasicFrame(title, w, h, iw, ih, autoRepaint, doubleBuffer));
//        EventQueue.invokeLater(() -> graphicsState.getFrame().setVisible(true));
    }

    public static void hsb2rgb(
            PuffinBasicSymbolTable symbolTable,
            Instruction instr0,
            Instruction instruction) {
//        var h = symbolTable.get(instr0.op1).getValue().getFloat32();
//        var s = symbolTable.get(instr0.op2).getValue().getFloat32();
//        var b = symbolTable.get(instruction.op1).getValue().getFloat32();
//        var result = symbolTable.get(instruction.result).getValue();
//        result.setInt32(Color.HSBtoRGB(h, s, b));
    }

    public static void repaint(GraphicsState graphicsState) {
//        graphicsState.getFrame().getDrawingCanvas().renderAndRepaint();
    }

    public static void end(GraphicsState graphicsState) {
//        SwingUtilities.invokeLater(
//                () -> {
//                    if (graphicsState.isInitialized()) {
//                        var frame = graphicsState.getFrame();
//                        frame.dispatchEvent(
//                                new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
//                    }
//                });
    }

    public static void circle(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            List<Instruction> instr0,
            Instruction instruction) {
//        var i0 = instr0.get(0);
//        var i1 = instr0.get(1);
//        var i2 = instr0.get(2);
//
//        var x = symbolTable.get(i0.op1).getValue().getInt32();
//        var y = symbolTable.get(i0.op2).getValue().getInt32();
//        Integer s = i1.op1 != NULL_ID ? symbolTable.get(i1.op1).getValue().getInt32() : null;
//        Integer e = i1.op1 != NULL_ID ? symbolTable.get(i1.op2).getValue().getInt32() : null;
//        int r1 = Math.max(0, symbolTable.get(instruction.op1).getValue().getInt32());
//        int r2 = Math.max(0, symbolTable.get(instruction.op2).getValue().getInt32());
//        boolean fill = i2.op1 != NULL_ID && symbolTable.get(i2.op1).getValue().getString().equalsIgnoreCase("F");
//
//        int w = r1 * 2;
//        int h = r2 * 2;
//        int sx = x - r1;
//        int sy = y - r2;
//
//        var g = graphicsState.getGraphics2D();
//        if (s == null || e == null) {
//            if (fill) {
//                g.fillOval(sx, sy, w, h);
//            } else {
//                g.drawOval(sx, sy, w, h);
//            }
//        } else {
//            if (fill) {
//                g.fillArc(sx, sy, w, h, s, e);
//            } else {
//                g.drawArc(sx, sy, w, h, s, e);
//            }
//        }
    }

    public static void font(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            Instruction instr0,
            Instruction instruction) {
//        var style = symbolTable.get(instr0.op1).getValue().getString().toLowerCase();
//        var size = symbolTable.get(instr0.op2).getValue().getInt32();
//        var name = symbolTable.get(instruction.op1).getValue().getString();
//
//        if (name.isEmpty() || size <= 0 || size > GraphicsUtil.MAX_WIDTH) {
//            throw new PuffinBasicRuntimeError(
//                    GRAPHICS_ERROR,
//                    "Bad name/size: '" + name + "'/" + size
//            );
//        }
//
//        int styleVal = 0;
//        if (style.contains("i")) {
//            styleVal |= Font.ITALIC;
//        }
//        if (style.contains("b")) {
//            styleVal |= Font.BOLD;
//        }
//        graphicsState.getGraphics2D().setFont(new Font(name, styleVal, size));
    }

    public static void drawstr(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            Instruction instr0,
            Instruction instruction) {
//        var x = symbolTable.get(instr0.op1).getValue().getInt32();
//        var y = symbolTable.get(instr0.op2).getValue().getInt32();
//        var text = symbolTable.get(instruction.op1).getValue().getString();
//
//        graphicsState.getGraphics2D().drawString(text, x, y);
    }

    public static void draw(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
//        var str = symbolTable.get(instruction.op1).getValue().getString();
//        if (str.isEmpty()) {
//            throw new PuffinBasicRuntimeError(
//                    GRAPHICS_ERROR,
//                    "Found empty string in DRAW!"
//            );
//        }
//
//        var path = new GeneralPath();
//        int w = graphicsState.getImageWidth();
//        int h = graphicsState.getImageHeight();
//        path.moveTo(w / 2, h / 2);
//
//        for (var i : str.split(";")) {
//            i = i.trim();
//            if (i.isEmpty()) {
//                continue;
//            }
//
//            var curr = path.getCurrentPoint();
//            if (i.charAt(0) == 'M') {
//                var m = DRAW_ARG2.matcher(i);
//                m.find();
//                String x = m.group(1);
//                String y = m.group(2);
//                int newX = (int) curr.getX();
//                int newY = (int) curr.getY();
//                if (x.startsWith("+") || x.startsWith("-")) {
//                    newX += Integer.parseInt(x);
//                } else {
//                    newX = Integer.parseInt(x);
//                }
//                if (y.startsWith("+") || y.startsWith("-")) {
//                    newY += Integer.parseInt(y);
//                } else {
//                    newY = Integer.parseInt(y);
//                }
//                path.moveTo(newX, newY);
//            } else {
//                var m = DRAW_ARG1.matcher(i);
//                m.find();
//                char cmd = m.group(1).charAt(0);
//                String opts = m.group(2) != null ? m.group(2) : "";
//                int s = Integer.parseInt(m.group(3));
//
//                boolean penUp = opts.contains("B");
//                boolean back = opts.contains("N");
//
//                int newX = (int) curr.getX();
//                int newY = (int) curr.getY();
//                switch (cmd) {
//                    case 'U':
//                        newY -= s;
//                        break;
//                    case 'D':
//                        newY += s;
//                        break;
//                    case 'L':
//                        newX -= s;
//                        break;
//                    case 'R':
//                        newX += s;
//                        break;
//                    case 'E':
//                        newY -= s;
//                        newX += s;
//                        break;
//                    case 'F':
//                        newY += s;
//                        newX += s;
//                        break;
//                    case 'G':
//                        newY += s;
//                        newX -= s;
//                        break;
//                    case 'H':
//                        newY -= s;
//                        newX -= s;
//                        break;
//                }
//
//                if (penUp) {
//                    path.moveTo(newX, newY);
//                } else {
//                    path.lineTo(newX, newY);
//                }
//
//                if (back) {
//                    path.moveTo(curr.getX(), curr.getY());
//                }
//            }
//
//        }
//        graphicsState.getGraphics2D().draw(path);
    }

    public static void line(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            List<Instruction> instr0,
            Instruction instruction) {
//        var i0 = instr0.get(0);
//        var i1 = instr0.get(1);
//
//        var x1 = symbolTable.get(i0.op1).getValue().getInt32();
//        var y1 = symbolTable.get(i0.op2).getValue().getInt32();
//        var x2 = symbolTable.get(i1.op1).getValue().getInt32();
//        var y2 = symbolTable.get(i1.op2).getValue().getInt32();
//        String bf = instruction.op1 != NULL_ID
//                ? symbolTable.get(instruction.op1).getValue().getString().toUpperCase()
//                : "";
//
//        if (bf.isEmpty()) {
//            graphicsState.getGraphics2D().drawLine(x1, y1, x2, y2);
//        } else if (bf.equals("B")) {
//            graphicsState.getGraphics2D().drawRect(
//                    x1, y1, Math.abs(x1 - x2), Math.abs(y1 - y2)
//            );
//        } else if (bf.equals("BF")) {
//            graphicsState.getGraphics2D().fillRect(
//                    x1, y1, Math.abs(x1 - x2), Math.abs(y1 - y2)
//            );
//        } else {
//            throw new PuffinBasicRuntimeError(
//                    GRAPHICS_ERROR,
//                    "Bad options: " + bf
//            );
//        }
    }

    public static void color(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            Instruction instr0,
            Instruction instruction) {
//        var r = symbolTable.get(instr0.op1).getValue().getInt32();
//        var g = symbolTable.get(instr0.op2).getValue().getInt32();
//        var b = symbolTable.get(instruction.op1).getValue().getInt32();
//
//        r = applyColorBounds(r);
//        g = applyColorBounds(g);
//        b = applyColorBounds(b);
//
//        graphicsState.getGraphics2D().setColor(new Color(r, g, b));
    }

    private static int applyColorBounds(int c) {
        return Math.min(255, Math.max(0, c));
    }

    public static void paint(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            List<Instruction> instr0,
            Instruction instruction) {
//        var i0 = instr0.get(0);
//        var i1 = instr0.get(1);
//
//        var r = symbolTable.get(i0.op1).getValue().getInt32();
//        var g = symbolTable.get(i0.op2).getValue().getInt32();
//        var b = symbolTable.get(i1.op1).getValue().getInt32();
//        var x = symbolTable.get(instruction.op1).getValue().getInt32();
//        var y = symbolTable.get(instruction.op2).getValue().getInt32();
//
//        if (x < 0 || y < 0 || x > graphicsState.getImageWidth() || y > graphicsState.getImageHeight()) {
//            throw new PuffinBasicRuntimeError(
//                    GRAPHICS_ERROR,
//                    "x/y out-of-bounds: " + x + ", " + y
//            );
//        }
//
//        r = applyColorBounds(r);
//        g = applyColorBounds(g);
//        b = applyColorBounds(b);
//
//        graphicsState.getFrame().getDrawingCanvas().floodFill(x, y, r, g, b);
    }

    public static void pset(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            List<Instruction> instr0,
            Instruction instruction) {
//        var i0 = instr0.get(0);
//        var i1 = instr0.get(1);
//
//        var r = i0.op1 != NULL_ID ? symbolTable.get(i0.op1).getValue().getInt32() : -1;
//        var g = i0.op2 != NULL_ID ? symbolTable.get(i0.op2).getValue().getInt32() : -1;
//        var b = i1.op1 != NULL_ID ? symbolTable.get(i1.op1).getValue().getInt32() : -1;
//        var x = symbolTable.get(instruction.op1).getValue().getInt32();
//        var y = symbolTable.get(instruction.op2).getValue().getInt32();
//
//        r = applyColorBounds(r);
//        g = applyColorBounds(g);
//        b = applyColorBounds(b);
//
//        if (x < 0 || y < 0 || x > graphicsState.getImageWidth() || y > graphicsState.getImageHeight()) {
//            throw new PuffinBasicRuntimeError(
//                    GRAPHICS_ERROR,
//                    "x/y out-of-bounds: " + x + ", " + y
//            );
//        }
//
//        graphicsState.getFrame().getDrawingCanvas().point(x, y, r, g, b);
    }

    public static void bufferCopyHor(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            Instruction instr0,
            Instruction instruction) {
//        var srcx = symbolTable.get(instr0.op1).getValue().getInt32();
//        var dstx = symbolTable.get(instr0.op2).getValue().getInt32();
//        var w = symbolTable.get(instruction.op1).getValue().getInt32();
//
//        if (srcx < 0 || dstx < 0 || w < 0
//                || srcx > graphicsState.getImageWidth()
//                || dstx > graphicsState.getImageWidth()
//                || w > graphicsState.getImageWidth()) {
//            throw new PuffinBasicRuntimeError(
//                    GRAPHICS_ERROR,
//                    "srcx/dstx/w misaligned/out-of-bounds: ("
//                            + srcx + " -> " + dstx + "), " + w + ")"
//            );
//        }
//
//        graphicsState.getFrame().getDrawingCanvas().bufferCopyHor(srcx, dstx, w);
    }

    public static void get(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            List<Instruction> instr0,
            Instruction instruction) {
//        var i0 = instr0.get(0);
//        var i1 = instr0.get(1);
//
//        var x1 = symbolTable.get(i0.op1).getValue().getInt32();
//        var y1 = symbolTable.get(i0.op2).getValue().getInt32();
//        var x2 = symbolTable.get(i1.op1).getValue().getInt32();
//        var y2 = symbolTable.get(i1.op2).getValue().getInt32();
//
//        var variable = symbolTable.getVariable(instruction.op1);
//        if (variable.getType().getTypeId() != ARRAY
//                || variable.getValue().getNumArrayDimensions() != 2
//                || variable.getType().getAtomTypeId() != INT32)
//        {
//            throw new PuffinBasicRuntimeError(
//                    GRAPHICS_ERROR,
//                    "Bad variable! Expected Int32 2D-Array variable: " + variable
//            );
//        }
//        if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0
//                || x1 > x2
//                || y1 > y2
//                || x1 > graphicsState.getImageWidth()
//                || y1 > graphicsState.getImageHeight()
//                || x2 > graphicsState.getImageWidth()
//                || y2 > graphicsState.getImageHeight()) {
//            throw new PuffinBasicRuntimeError(
//                    GRAPHICS_ERROR,
//                    "x1/y1/x2/y2 misaligned/out-of-bounds: ("
//                            + x1 + ", " + y1 + "), " + x2 + ", " + y2 + ")"
//            );
//        }
//
//        final int bufferNumber = symbolTable.get(instruction.op2).getValue().getInt32();
//
//        graphicsState.getFrame().getDrawingCanvas().copyGraphicsToArray(
//                bufferNumber, x1, y1, x2, y2, variable.getValue().getInt32Array1D()
//        );
    }

    public static void put(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            Instruction instr0,
            Instruction instr1,
            Instruction instruction) {
//        var x = symbolTable.get(instr0.op1).getValue().getInt32();
//        var y = symbolTable.get(instr0.op2).getValue().getInt32();
//        var action = instruction.op1 != NULL_ID
//                ? symbolTable.get(instruction.op1).getValue().getString()
//                : PUT_XOR;
//        action = action.toUpperCase();
//        final int bufferNumber = symbolTable.get(instr1.op1).getValue().getInt32();
//
//        var variable = symbolTable.getVariable(instruction.op2);
//        var value = variable.getValue();
//        if (variable.getType().getTypeId() != ARRAY
//                || value.getNumArrayDimensions() != 2
//                || variable.getType().getAtomTypeId() != INT32)
//        {
//            throw new PuffinBasicRuntimeError(
//                    GRAPHICS_ERROR,
//                    "Bad variable! Expected Int32 2D-Array variable: " + variable
//            );
//        }
//
//        int CW = graphicsState.getImageWidth();
//        int CH = graphicsState.getImageHeight();
//
//        var dims = value.getArrayDimensions();
//        int iw = dims.getInt(0);
//        int ih = dims.getInt(1);
//
//        int offset = 0;
//        int w, h;
//        int xx, yy;
//        int srcx, srcy;
//        if (x >= 0) {
//            w = Math.min(iw, CW - x);
//            xx = x;
//            srcx = 0;
//        } else {
//            w = Math.min(iw, iw + x);
//            xx = 0;
//            srcx = Math.abs(x);
//        }
//        if (y >= 0) {
//            h = Math.min(ih, CH - y);
//            yy = y;
//            srcy = 0;
//        } else {
//            h = Math.min(ih, ih + y);
//            yy = 0;
//            srcy = Math.abs(y);
//        }
//
//        // draw only if the image falls on the screen
//        if (w > 0 && h > 0 && offset < iw * ih) {
//            graphicsState.getFrame().getDrawingCanvas().copyArrayToGraphics(
//                    bufferNumber, xx, yy, w, h, action, value.getInt32Array1D(), srcx, srcy, iw
//            );
//        }
    }

    public static void inkeydlr(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
//        var key = graphicsState.getFrame().getDrawingCanvas().takeNextKey();
//        symbolTable.get(instruction.result).getValue().setString(key);
    }

    public static void loadwav(
            SoundState soundState,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
//        var file = symbolTable.get(instruction.op1).getValue().getString();
//        var variable = symbolTable.getVariable(instruction.op2).getValue();
//        variable.setInt32(soundState.load(file));
    }

    public static void playwav(
            SoundState soundState,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
//        var id = symbolTable.get(instruction.op1).getValue().getInt32();
//        soundState.play(id);
    }

    public static void stopwav(
            SoundState soundState,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
//        var id = symbolTable.get(instruction.op1).getValue().getInt32();
//        soundState.stop(id);
    }

    public static void loopwav(
            SoundState soundState,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
//        var id = symbolTable.get(instruction.op1).getValue().getInt32();
//        soundState.loop(id);
    }

    public static void mouseMovedX(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
//        symbolTable.get(instruction.result).getValue().setInt32(
//                graphicsState.getFrame().getDrawingCanvas().getMouseState().getMovedX());
    }

    public static void mouseMovedY(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
//        symbolTable.get(instruction.result).getValue().setInt32(
//                graphicsState.getFrame().getDrawingCanvas().getMouseState().getMovedY());
    }

    public static void mouseDraggedX(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
//        symbolTable.get(instruction.result).getValue().setInt32(
//                graphicsState.getFrame().getDrawingCanvas().getMouseState().getDraggedX());
    }

    public static void mouseDraggedY(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
//        symbolTable.get(instruction.result).getValue().setInt32(
//                graphicsState.getFrame().getDrawingCanvas().getMouseState().getDraggedY());
    }

    public static void mouseButtonClicked(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
//        symbolTable.get(instruction.result).getValue().setInt32(
//                graphicsState.getFrame().getDrawingCanvas().getMouseState().getButtonClicked());
    }

    public static void mouseButtonPressed(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
//        symbolTable.get(instruction.result).getValue().setInt32(
//                graphicsState.getFrame().getDrawingCanvas().getMouseState().getButtonPressed());
    }

    public static void mouseButtonReleased(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
//        symbolTable.get(instruction.result).getValue().setInt32(
//                graphicsState.getFrame().getDrawingCanvas().getMouseState().getButtonReleased());
    }

    public static void isKeyPressed(
            GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            Instruction instruction) {
//        var key = symbolTable.get(instruction.op1).getValue().getString();
//        symbolTable.get(instruction.result).getValue().setInt32(
//                graphicsState.getFrame().getDrawingCanvas().isKeyPressed(key) ? -1 : 0);
    }

    static class GraphicsState {
//        private BasicFrame frame;

//        boolean isInitialized() {
//            return frame != null;
//        }

//        BasicFrame getFrame() {
//            assertScreenInitialized();
//            return frame;
//        }

//        Graphics2D getGraphics2D() {
//            return getFrame().getDrawingCanvas().getGraphics2D();
//        }

//        int getImageWidth() {
//            return getFrame().getDrawingCanvas().getImageWidth();
//        }

//        int getImageHeight() {
//            return getFrame().getDrawingCanvas().getImageHeight();
//        }

//        void setFrame(BasicFrame frame) {
//            assertNewScreen();
//            this.frame = frame;
//        }

//        private void assertNewScreen() {
//            if (frame != null) {
//                throw new PuffinBasicRuntimeError(
//                        GRAPHICS_ERROR,
//                        "Screen cannot be called again!"
//                );
//            }
//        }

//        private void assertScreenInitialized() {
//            if (frame == null) {
//                throw new PuffinBasicRuntimeError(
//                        GRAPHICS_ERROR,
//                        "Screen has already been created!"
//                );
//            }
//        }
//    }

        public static void cls(GraphicsState graphicsState) {
//        graphicsState.getFrame().getDrawingCanvas().clear();
        }

        public static void beep() {
//            Toolkit.getDefaultToolkit().beep();
        }
    }
}

package io.atha.bbasic.awt;

import static io.atha.libbababasic.domain.SymbolTable.NULL_ID;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

import io.atha.libbababasic.domain.PuffinBasicAtomTypeId;
import io.atha.libbababasic.domain.PuffinBasicTypeId;
import io.atha.libbababasic.domain.SymbolTable;
import io.atha.libbababasic.error.RuntimeError;
import io.atha.libbababasic.parser.IR;
import io.atha.libbababasic.runtime.GraphicsRuntime;
import io.atha.libbababasic.runtime.SoundState;

public class AWTGraphicsRuntime implements GraphicsRuntime {
    private static final Pattern DRAW_ARG1 = Pattern.compile("([UDLREFGHA])([BN]+)?([0-9]+)");
    private static final Pattern DRAW_ARG2 = Pattern.compile("M([+\\-]?[0-9]+),([+\\-]?[0-9]+)");
    protected final AWTGraphicsState graphicsState;

    public AWTGraphicsRuntime() {
        this.graphicsState = new AWTGraphicsState();
    }

    @Override
    public void saveimg(
            SymbolTable symbolTable,
            IR.Instruction instruction) {
        var path = symbolTable.get(instruction.op1).getValue().getString();
        var entry = symbolTable.getVariable(instruction.op2);
        var variableValue = entry.getValue();
        if (variableValue.getNumArrayDimensions() != 2 || entry.getType().getAtomTypeId() != PuffinBasicAtomTypeId.INT32) {
            throw new RuntimeError(
                    RuntimeError.ErrorCode.GRAPHICS_ERROR,
                    "Bad Array Variable, expected Int32 2D-Array Variable: " + entry
            );
        }

        var dims = variableValue.getArrayDimensions();
        final BufferedImage image = new BufferedImage(dims.get(0), dims.get(1), BufferedImage.TYPE_3BYTE_BGR);

        image.setRGB(0, 0, image.getWidth(), image.getHeight(),
                variableValue.getInt32Array1D(), 0, image.getWidth());

        var ext = org.apache.commons.io.FilenameUtils.getExtension(path);
        try {
            ImageIO.write(image, ext, new File(path));
        } catch (IOException e) {
            throw new RuntimeError(
                    RuntimeError.ErrorCode.IO_ERROR,
                    "Failed to save image: " + path + ", error: " + e.getMessage()
            );
        }
    }

    @Override
    public void loadimg(
            SymbolTable symbolTable,
            IR.Instruction instruction) {
        var path = symbolTable.get(instruction.op1).getValue().getString();
        var entry = symbolTable.getVariable(instruction.op2);
        var variableValue = entry.getValue();
        if (variableValue.getNumArrayDimensions() != 2 || entry.getType().getAtomTypeId() != PuffinBasicAtomTypeId.INT32) {
            throw new RuntimeError(
                    RuntimeError.ErrorCode.GRAPHICS_ERROR,
                    "Bad Array Variable, expected Int32 2D-Array Variable: " + entry
            );
        }
//
        final BufferedImage image;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeError(
                    RuntimeError.ErrorCode.IO_ERROR,
                    "Failed to load image: " + path + ", error: " + e.getMessage()
            );
        }

        var dims = variableValue.getArrayDimensions();
        if (image.getWidth() != dims.get(0) || image.getHeight() != dims.get(1)) {
            throw new RuntimeError(
                    RuntimeError.ErrorCode.GRAPHICS_ERROR,
                    "Image dimensions: " + image.getWidth() + ", " + image.getHeight()
                            + " doesn't match with variable dimensions: "
                            + dims.get(0) + ", " + dims.get(1)
            );
        }

        image.getRGB(0, 0, image.getWidth(), image.getHeight(),
                variableValue.getInt32Array1D(), 0, image.getWidth());
    }

    @Override
    public void screen(
            SymbolTable symbolTable,
            List<IR.Instruction> instr0,
            IR.Instruction instruction) {
        var i0 = instr0.get(0);
        var i1 = instr0.get(1);
        var i2 = instr0.get(2);
        var w = symbolTable.get(i0.op1).getValue().getInt32();
        var h = symbolTable.get(i0.op2).getValue().getInt32();
        var iw = symbolTable.get(i1.op1).getValue().getInt32();
        var ih = symbolTable.get(i1.op2).getValue().getInt32();
        var title = symbolTable.get(instruction.op1).getValue().getString();
        if (w <= 0 || h <= 0 || w > AWTGraphicsUtil.MAX_WIDTH || h > AWTGraphicsUtil.MAX_HEIGHT) {
            throw new RuntimeError(
                    RuntimeError.ErrorCode.GRAPHICS_ERROR,
                    "Screen size out-of-bounds: " + w + ", " + h
            );
        }
        if (iw <= 0 || ih <= 0 || iw > AWTGraphicsUtil.MAX_WIDTH || ih > AWTGraphicsUtil.MAX_HEIGHT) {
            throw new RuntimeError(
                    RuntimeError.ErrorCode.GRAPHICS_ERROR,
                    "Image size out-of-bounds: " + iw + ", " + ih
            );
        }
        var autoRepaint = symbolTable.get(i2.op1).getValue().getInt32() == -1;
        var doubleBuffer = symbolTable.get(i2.op2).getValue().getInt32() == -1;

        graphicsState.setFrame(new AWTGraphicsUtil.BasicFrame(title, w, h, iw, ih, autoRepaint, doubleBuffer));
        EventQueue.invokeLater(() -> graphicsState.getFrame().setVisible(true));
    }

    @Override
    public void hsb2rgb(
            SymbolTable symbolTable,
            IR.Instruction instr0,
            IR.Instruction instruction) {
        var h = symbolTable.get(instr0.op1).getValue().getFloat32();
        var s = symbolTable.get(instr0.op2).getValue().getFloat32();
        var b = symbolTable.get(instruction.op1).getValue().getFloat32();
        var result = symbolTable.get(instruction.result).getValue();
        result.setInt32(Color.HSBtoRGB(h, s, b));
    }

    @Override
    public void repaint() {
        graphicsState.getFrame().getDrawingCanvas().renderAndRepaint();
    }

    @Override
    public void end() {
        SwingUtilities.invokeLater(
                () -> {
                    if (graphicsState.isInitialized()) {
                        var frame = graphicsState.getFrame();
                        frame.dispatchEvent(
                                new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                    }
                });
    }

    @Override
    public void circle(
            SymbolTable symbolTable,
            List<IR.Instruction> instr0,
            IR.Instruction instruction) {
        var i0 = instr0.get(0);
        var i1 = instr0.get(1);
        var i2 = instr0.get(2);

        var x = symbolTable.get(i0.op1).getValue().getInt32();
        var y = symbolTable.get(i0.op2).getValue().getInt32();
        Integer s = i1.op1 != NULL_ID ? symbolTable.get(i1.op1).getValue().getInt32() : null;
        Integer e = i1.op1 != NULL_ID ? symbolTable.get(i1.op2).getValue().getInt32() : null;
        int r1 = Math.max(0, symbolTable.get(instruction.op1).getValue().getInt32());
        int r2 = Math.max(0, symbolTable.get(instruction.op2).getValue().getInt32());
        boolean fill = i2.op1 != NULL_ID && symbolTable.get(i2.op1).getValue().getString().equalsIgnoreCase("F");

        int w = r1 * 2;
        int h = r2 * 2;
        int sx = x - r1;
        int sy = y - r2;

        var g = graphicsState.getGraphics2D();
        if (s == null || e == null) {
            if (fill) {
                g.fillOval(sx, sy, w, h);
            } else {
                g.drawOval(sx, sy, w, h);
            }
        } else {
            if (fill) {
                g.fillArc(sx, sy, w, h, s, e);
            } else {
                g.drawArc(sx, sy, w, h, s, e);
            }
        }
    }

    @Override
    public void font(
            SymbolTable symbolTable,
            IR.Instruction instr0,
            IR.Instruction instruction) {
        var style = symbolTable.get(instr0.op1).getValue().getString().toLowerCase();
        var size = symbolTable.get(instr0.op2).getValue().getInt32();
        var name = symbolTable.get(instruction.op1).getValue().getString();

        if (name.isEmpty() || size <= 0 || size > AWTGraphicsUtil.MAX_WIDTH) {
            throw new RuntimeError(
                    RuntimeError.ErrorCode.GRAPHICS_ERROR,
                    "Bad name/size: '" + name + "'/" + size
            );
        }

        int styleVal = 0;
        if (style.contains("i")) {
            styleVal |= Font.ITALIC;
        }
        if (style.contains("b")) {
            styleVal |= Font.BOLD;
        }
        graphicsState.getGraphics2D().setFont(new Font(name, styleVal, size));
    }

    @Override
    public void drawstr(
            SymbolTable symbolTable,
            IR.Instruction instr0,
            IR.Instruction instruction) {
        var x = symbolTable.get(instr0.op1).getValue().getInt32();
        var y = symbolTable.get(instr0.op2).getValue().getInt32();
        var text = symbolTable.get(instruction.op1).getValue().getString();

        graphicsState.getGraphics2D().drawString(text, x, y);
    }

    @Override
    public void draw(
            SymbolTable symbolTable,
            IR.Instruction instruction) {
        var str = symbolTable.get(instruction.op1).getValue().getString();
        if (str.isEmpty()) {
            throw new RuntimeError(
                    RuntimeError.ErrorCode.GRAPHICS_ERROR,
                    "Found empty string in DRAW!"
            );
        }

        var path = new GeneralPath();
        int w = graphicsState.getImageWidth();
        int h = graphicsState.getImageHeight();
        path.moveTo(w / 2, h / 2);

        for (var i : str.split(";")) {
            i = i.trim();
            if (i.isEmpty()) {
                continue;
            }

            var curr = path.getCurrentPoint();
            if (i.charAt(0) == 'M') {
                var m = DRAW_ARG2.matcher(i);
                m.find();
                String x = m.group(1);
                String y = m.group(2);
                int newX = (int) curr.getX();
                int newY = (int) curr.getY();
                if (x.startsWith("+") || x.startsWith("-")) {
                    newX += Integer.parseInt(x);
                } else {
                    newX = Integer.parseInt(x);
                }
                if (y.startsWith("+") || y.startsWith("-")) {
                    newY += Integer.parseInt(y);
                } else {
                    newY = Integer.parseInt(y);
                }
                path.moveTo(newX, newY);
            } else {
                var m = DRAW_ARG1.matcher(i);
                m.find();
                char cmd = m.group(1).charAt(0);
                String opts = m.group(2) != null ? m.group(2) : "";
                int s = Integer.parseInt(m.group(3));

                boolean penUp = opts.contains("B");
                boolean back = opts.contains("N");

                int newX = (int) curr.getX();
                int newY = (int) curr.getY();
                switch (cmd) {
                    case 'U':
                        newY -= s;
                        break;
                    case 'D':
                        newY += s;
                        break;
                    case 'L':
                        newX -= s;
                        break;
                    case 'R':
                        newX += s;
                        break;
                    case 'E':
                        newY -= s;
                        newX += s;
                        break;
                    case 'F':
                        newY += s;
                        newX += s;
                        break;
                    case 'G':
                        newY += s;
                        newX -= s;
                        break;
                    case 'H':
                        newY -= s;
                        newX -= s;
                        break;
                }

                if (penUp) {
                    path.moveTo(newX, newY);
                } else {
                    path.lineTo(newX, newY);
                }

                if (back) {
                    path.moveTo(curr.getX(), curr.getY());
                }
            }

        }
        graphicsState.getGraphics2D().draw(path);
    }

    @Override
    public void line(
            SymbolTable symbolTable,
            List<IR.Instruction> instr0,
            IR.Instruction instruction) {
        var i0 = instr0.get(0);
        var i1 = instr0.get(1);

        var x1 = symbolTable.get(i0.op1).getValue().getInt32();
        var y1 = symbolTable.get(i0.op2).getValue().getInt32();
        var x2 = symbolTable.get(i1.op1).getValue().getInt32();
        var y2 = symbolTable.get(i1.op2).getValue().getInt32();
        String bf = instruction.op1 != NULL_ID
                ? symbolTable.get(instruction.op1).getValue().getString().toUpperCase()
                : "";

        if (bf.isEmpty()) {
            graphicsState.getGraphics2D().drawLine(x1, y1, x2, y2);
        } else if (bf.equals("B")) {
            graphicsState.getGraphics2D().drawRect(
                    x1, y1, Math.abs(x1 - x2), Math.abs(y1 - y2)
            );
        } else if (bf.equals("BF")) {
            graphicsState.getGraphics2D().fillRect(
                    x1, y1, Math.abs(x1 - x2), Math.abs(y1 - y2)
            );
        } else {
            throw new RuntimeError(
                    RuntimeError.ErrorCode.GRAPHICS_ERROR,
                    "Bad options: " + bf
            );
        }
    }

    @Override
    public void color(
            SymbolTable symbolTable,
            IR.Instruction instr0,
            IR.Instruction instruction) {
        var r = symbolTable.get(instr0.op1).getValue().getInt32();
        var g = symbolTable.get(instr0.op2).getValue().getInt32();
        var b = symbolTable.get(instruction.op1).getValue().getInt32();

        r = GraphicsRuntime.applyColorBounds(r);
        g = GraphicsRuntime.applyColorBounds(g);
        b = GraphicsRuntime.applyColorBounds(b);

        graphicsState.getGraphics2D().setColor(new Color(r, g, b));
    }

    @Override
    public void paint(
            SymbolTable symbolTable,
            List<IR.Instruction> instr0,
            IR.Instruction instruction) {
        var i0 = instr0.get(0);
        var i1 = instr0.get(1);

        var r = symbolTable.get(i0.op1).getValue().getInt32();
        var g = symbolTable.get(i0.op2).getValue().getInt32();
        var b = symbolTable.get(i1.op1).getValue().getInt32();
        var x = symbolTable.get(instruction.op1).getValue().getInt32();
        var y = symbolTable.get(instruction.op2).getValue().getInt32();

        if (x < 0 || y < 0 || x > graphicsState.getImageWidth() || y > graphicsState.getImageHeight()) {
            throw new RuntimeError(
                    RuntimeError.ErrorCode.GRAPHICS_ERROR,
                    "x/y out-of-bounds: " + x + ", " + y
            );
        }

        r = GraphicsRuntime.applyColorBounds(r);
        g = GraphicsRuntime.applyColorBounds(g);
        b = GraphicsRuntime.applyColorBounds(b);

        graphicsState.getFrame().getDrawingCanvas().floodFill(x, y, r, g, b);
    }

    @Override
    public void pset(
            SymbolTable symbolTable,
            List<IR.Instruction> instr0,
            IR.Instruction instruction) {
        var i0 = instr0.get(0);
        var i1 = instr0.get(1);

        var r = i0.op1 != NULL_ID ? symbolTable.get(i0.op1).getValue().getInt32() : -1;
        var g = i0.op2 != NULL_ID ? symbolTable.get(i0.op2).getValue().getInt32() : -1;
        var b = i1.op1 != NULL_ID ? symbolTable.get(i1.op1).getValue().getInt32() : -1;
        var x = symbolTable.get(instruction.op1).getValue().getInt32();
        var y = symbolTable.get(instruction.op2).getValue().getInt32();

        r = GraphicsRuntime.applyColorBounds(r);
        g = GraphicsRuntime.applyColorBounds(g);
        b = GraphicsRuntime.applyColorBounds(b);

        if (x < 0 || y < 0 || x > graphicsState.getImageWidth() || y > graphicsState.getImageHeight()) {
            throw new RuntimeError(
                    RuntimeError.ErrorCode.GRAPHICS_ERROR,
                    "x/y out-of-bounds: " + x + ", " + y
            );
        }

        graphicsState.getFrame().getDrawingCanvas().point(x, y, r, g, b);
    }

    @Override
    public void bufferCopyHor(
            SymbolTable symbolTable,
            IR.Instruction instr0,
            IR.Instruction instruction) {
        var srcx = symbolTable.get(instr0.op1).getValue().getInt32();
        var dstx = symbolTable.get(instr0.op2).getValue().getInt32();
        var w = symbolTable.get(instruction.op1).getValue().getInt32();

        if (srcx < 0 || dstx < 0 || w < 0
                || srcx > graphicsState.getImageWidth()
                || dstx > graphicsState.getImageWidth()
                || w > graphicsState.getImageWidth()) {
            throw new RuntimeError(
                    RuntimeError.ErrorCode.GRAPHICS_ERROR,
                    "srcx/dstx/w misaligned/out-of-bounds: ("
                            + srcx + " -> " + dstx + "), " + w + ")"
            );
        }

        graphicsState.getFrame().getDrawingCanvas().bufferCopyHor(srcx, dstx, w);
    }

    @Override
    public void get(
            SymbolTable symbolTable,
            List<IR.Instruction> instr0,
            IR.Instruction instruction) {
        var i0 = instr0.get(0);
        var i1 = instr0.get(1);

        var x1 = symbolTable.get(i0.op1).getValue().getInt32();
        var y1 = symbolTable.get(i0.op2).getValue().getInt32();
        var x2 = symbolTable.get(i1.op1).getValue().getInt32();
        var y2 = symbolTable.get(i1.op2).getValue().getInt32();

        var variable = symbolTable.getVariable(instruction.op1);
        if (variable.getType().getTypeId() != PuffinBasicTypeId.ARRAY
                || variable.getValue().getNumArrayDimensions() != 2
                || variable.getType().getAtomTypeId() != PuffinBasicAtomTypeId.INT32) {
            throw new RuntimeError(
                    RuntimeError.ErrorCode.GRAPHICS_ERROR,
                    "Bad variable! Expected Int32 2D-Array variable: " + variable
            );
        }
        if (x1 < 0 || y1 < 0 || x2 < 0 || y2 < 0
                || x1 > x2
                || y1 > y2
                || x1 > graphicsState.getImageWidth()
                || y1 > graphicsState.getImageHeight()
                || x2 > graphicsState.getImageWidth()
                || y2 > graphicsState.getImageHeight()) {
            throw new RuntimeError(
                    RuntimeError.ErrorCode.GRAPHICS_ERROR,
                    "x1/y1/x2/y2 misaligned/out-of-bounds: ("
                            + x1 + ", " + y1 + "), " + x2 + ", " + y2 + ")"
            );
        }

        final int bufferNumber = symbolTable.get(instruction.op2).getValue().getInt32();

        graphicsState.getFrame().getDrawingCanvas().copyGraphicsToArray(
                bufferNumber, x1, y1, x2, y2, variable.getValue().getInt32Array1D()
        );
    }

    @Override
    public void put(
            SymbolTable symbolTable,
            IR.Instruction instr0,
            IR.Instruction instr1,
            IR.Instruction instruction) {
        var x = symbolTable.get(instr0.op1).getValue().getInt32();
        var y = symbolTable.get(instr0.op2).getValue().getInt32();
        var action = instruction.op1 != NULL_ID
                ? symbolTable.get(instruction.op1).getValue().getString()
                : AWTGraphicsUtil.PUT_XOR;
        action = action.toUpperCase();
        final int bufferNumber = symbolTable.get(instr1.op1).getValue().getInt32();

        var variable = symbolTable.getVariable(instruction.op2);
        var value = variable.getValue();
        if (variable.getType().getTypeId() != PuffinBasicTypeId.ARRAY
                || value.getNumArrayDimensions() != 2
                || variable.getType().getAtomTypeId() != PuffinBasicAtomTypeId.INT32) {
            throw new RuntimeError(
                    RuntimeError.ErrorCode.GRAPHICS_ERROR,
                    "Bad variable! Expected Int32 2D-Array variable: " + variable
            );
        }

        int CW = graphicsState.getImageWidth();
        int CH = graphicsState.getImageHeight();

        var dims = value.getArrayDimensions();
        int iw = dims.get(0);
        int ih = dims.get(1);

        int offset = 0;
        int w, h;
        int xx, yy;
        int srcx, srcy;
        if (x >= 0) {
            w = Math.min(iw, CW - x);
            xx = x;
            srcx = 0;
        } else {
            w = Math.min(iw, iw + x);
            xx = 0;
            srcx = Math.abs(x);
        }
        if (y >= 0) {
            h = Math.min(ih, CH - y);
            yy = y;
            srcy = 0;
        } else {
            h = Math.min(ih, ih + y);
            yy = 0;
            srcy = Math.abs(y);
        }

        // draw only if the image falls on the screen
        if (w > 0 && h > 0 && offset < iw * ih) {
            graphicsState.getFrame().getDrawingCanvas().copyArrayToGraphics(
                    bufferNumber, xx, yy, w, h, action, value.getInt32Array1D(), srcx, srcy, iw
            );
        }
    }

    @Override
    public void inkeydlr(
            SymbolTable symbolTable,
            IR.Instruction instruction) {
        var key = graphicsState.getFrame().getDrawingCanvas().takeNextKey();
        symbolTable.get(instruction.result).getValue().setString(key);
    }

    @Override
    public void loadwav(
            SoundState soundState,
            SymbolTable symbolTable,
            IR.Instruction instruction) {
        var file = symbolTable.get(instruction.op1).getValue().getString();
        var variable = symbolTable.getVariable(instruction.op2).getValue();
        variable.setInt32(soundState.load(file));
    }

    @Override
    public void playwav(
            SoundState soundState,
            SymbolTable symbolTable,
            IR.Instruction instruction) {
        var id = symbolTable.get(instruction.op1).getValue().getInt32();
        soundState.play(id);
    }

    @Override
    public void stopwav(
            SoundState soundState,
            SymbolTable symbolTable,
            IR.Instruction instruction) {
        var id = symbolTable.get(instruction.op1).getValue().getInt32();
        soundState.stop(id);
    }

    @Override
    public void loopwav(
            SoundState soundState,
            SymbolTable symbolTable,
            IR.Instruction instruction) {
        var id = symbolTable.get(instruction.op1).getValue().getInt32();
        soundState.loop(id);
    }

    @Override
    public void mouseMovedX(
            SymbolTable symbolTable,
            IR.Instruction instruction) {
        symbolTable.get(instruction.result).getValue().setInt32(
                graphicsState.getFrame().getDrawingCanvas().getMouseState().getMovedX());
    }

    @Override
    public void mouseMovedY(
            SymbolTable symbolTable,
            IR.Instruction instruction) {
        symbolTable.get(instruction.result).getValue().setInt32(
                graphicsState.getFrame().getDrawingCanvas().getMouseState().getMovedY());
    }

    @Override
    public void mouseDraggedX(
            SymbolTable symbolTable,
            IR.Instruction instruction) {
        symbolTable.get(instruction.result).getValue().setInt32(
                graphicsState.getFrame().getDrawingCanvas().getMouseState().getDraggedX());
    }

    @Override
    public void mouseDraggedY(
            SymbolTable symbolTable,
            IR.Instruction instruction) {
        symbolTable.get(instruction.result).getValue().setInt32(
                graphicsState.getFrame().getDrawingCanvas().getMouseState().getDraggedY());
    }

    @Override
    public void mouseButtonClicked(
            SymbolTable symbolTable,
            IR.Instruction instruction) {
        symbolTable.get(instruction.result).getValue().setInt32(
                graphicsState.getFrame().getDrawingCanvas().getMouseState().getButtonClicked());
    }

    @Override
    public void mouseButtonPressed(
            SymbolTable symbolTable,
            IR.Instruction instruction) {
        symbolTable.get(instruction.result).getValue().setInt32(
                graphicsState.getFrame().getDrawingCanvas().getMouseState().getButtonPressed());
    }

    @Override
    public void mouseButtonReleased(
            SymbolTable symbolTable,
            IR.Instruction instruction) {
        symbolTable.get(instruction.result).getValue().setInt32(
                graphicsState.getFrame().getDrawingCanvas().getMouseState().getButtonReleased());
    }

    @Override
    public void isKeyPressed(
            SymbolTable symbolTable,
            IR.Instruction instruction) {
        var key = symbolTable.get(instruction.op1).getValue().getString();
        symbolTable.get(instruction.result).getValue().setInt32(
                graphicsState.getFrame().getDrawingCanvas().isKeyPressed(key) ? -1 : 0);
    }

    @Override
    public void cls() {
        graphicsState.getFrame().getDrawingCanvas().clear();
    }

    @Override
    public void locate(Integer row, Integer col) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public void beep() {
        Toolkit.getDefaultToolkit().beep();
    }


}

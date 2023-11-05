package org.puffinbasic.runtime;

import org.puffinbasic.domain.PuffinBasicSymbolTable;
import org.puffinbasic.parser.PuffinBasicIR;

import java.util.List;

public interface IGraphicsRuntime {
    static int applyColorBounds(int c) {
        return Math.min(255, Math.max(0, c));
    }

    void saveimg(
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instruction);

    void loadimg(
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instruction);

    void screen(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            List<PuffinBasicIR.Instruction> instr0,
            PuffinBasicIR.Instruction instruction);

    void hsb2rgb(
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instr0,
            PuffinBasicIR.Instruction instruction);

    void repaint(GraphicsRuntime.GraphicsState graphicsState);

    void end(GraphicsRuntime.GraphicsState graphicsState);

    void circle(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            List<PuffinBasicIR.Instruction> instr0,
            PuffinBasicIR.Instruction instruction);

    void font(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instr0,
            PuffinBasicIR.Instruction instruction);

    void drawstr(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instr0,
            PuffinBasicIR.Instruction instruction);

    void draw(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instruction);

    void line(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            List<PuffinBasicIR.Instruction> instr0,
            PuffinBasicIR.Instruction instruction);

    void color(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instr0,
            PuffinBasicIR.Instruction instruction);

    void paint(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            List<PuffinBasicIR.Instruction> instr0,
            PuffinBasicIR.Instruction instruction);

    void pset(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            List<PuffinBasicIR.Instruction> instr0,
            PuffinBasicIR.Instruction instruction);

    void bufferCopyHor(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instr0,
            PuffinBasicIR.Instruction instruction);

    void get(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            List<PuffinBasicIR.Instruction> instr0,
            PuffinBasicIR.Instruction instruction);

    void put(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instr0,
            PuffinBasicIR.Instruction instr1,
            PuffinBasicIR.Instruction instruction);

    void inkeydlr(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instruction);

    void loadwav(
            SoundState soundState,
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instruction);

    void playwav(
            SoundState soundState,
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instruction);

    void stopwav(
            SoundState soundState,
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instruction);

    void loopwav(
            SoundState soundState,
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instruction);

    void mouseMovedX(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instruction);

    void mouseMovedY(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instruction);

    void mouseDraggedX(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instruction);

    void mouseDraggedY(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instruction);

    void mouseButtonClicked(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instruction);

    void mouseButtonPressed(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instruction);

    void mouseButtonReleased(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instruction);

    void isKeyPressed(
            GraphicsRuntime.GraphicsState graphicsState,
            PuffinBasicSymbolTable symbolTable,
            PuffinBasicIR.Instruction instruction);

    void cls(GraphicsRuntime.GraphicsState graphicsState);

    void locate(GraphicsRuntime.GraphicsState graphicsState, Integer row, Integer col);

    void beep(GraphicsRuntime.GraphicsState graphicsState);
}

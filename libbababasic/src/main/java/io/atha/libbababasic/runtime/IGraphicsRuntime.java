package io.atha.libbababasic.runtime;

import java.util.List;

import io.atha.libbababasic.domain.SymbolTable;
import io.atha.libbababasic.parser.IR;

public interface IGraphicsRuntime {
    static int applyColorBounds(int c) {
        return Math.min(255, Math.max(0, c));
    }

    void saveimg(
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void loadimg(
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void screen(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            List<IR.Instruction> instr0,
            IR.Instruction instruction);

    void hsb2rgb(
            SymbolTable symbolTable,
            IR.Instruction instr0,
            IR.Instruction instruction);

    void repaint(GraphicsRuntime.GraphicsState graphicsState);

    void end(GraphicsRuntime.GraphicsState graphicsState);

    void circle(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            List<IR.Instruction> instr0,
            IR.Instruction instruction);

    void font(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            IR.Instruction instr0,
            IR.Instruction instruction);

    void drawstr(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            IR.Instruction instr0,
            IR.Instruction instruction);

    void draw(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void line(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            List<IR.Instruction> instr0,
            IR.Instruction instruction);

    void color(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            IR.Instruction instr0,
            IR.Instruction instruction);

    void paint(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            List<IR.Instruction> instr0,
            IR.Instruction instruction);

    void pset(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            List<IR.Instruction> instr0,
            IR.Instruction instruction);

    void bufferCopyHor(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            IR.Instruction instr0,
            IR.Instruction instruction);

    void get(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            List<IR.Instruction> instr0,
            IR.Instruction instruction);

    void put(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            IR.Instruction instr0,
            IR.Instruction instr1,
            IR.Instruction instruction);

    void inkeydlr(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void loadwav(
            SoundState soundState,
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void playwav(
            SoundState soundState,
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void stopwav(
            SoundState soundState,
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void loopwav(
            SoundState soundState,
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void mouseMovedX(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void mouseMovedY(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void mouseDraggedX(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void mouseDraggedY(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void mouseButtonClicked(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void mouseButtonPressed(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void mouseButtonReleased(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void isKeyPressed(
            GraphicsRuntime.GraphicsState graphicsState,
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void cls(GraphicsRuntime.GraphicsState graphicsState);

    void locate(GraphicsRuntime.GraphicsState graphicsState, Integer row, Integer col);

    void beep(GraphicsRuntime.GraphicsState graphicsState);
}

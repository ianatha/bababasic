package io.atha.libbababasic.runtime;

import java.util.List;

import io.atha.libbababasic.domain.SymbolTable;
import io.atha.libbababasic.parser.IR;

public interface GraphicsRuntime {
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
            SymbolTable symbolTable,
            List<IR.Instruction> instr0,
            IR.Instruction instruction);

    void hsb2rgb(
            SymbolTable symbolTable,
            IR.Instruction instr0,
            IR.Instruction instruction);

    void repaint();

    void end();

    void circle(
            SymbolTable symbolTable,
            List<IR.Instruction> instr0,
            IR.Instruction instruction);

    void font(
            SymbolTable symbolTable,
            IR.Instruction instr0,
            IR.Instruction instruction);

    void drawstr(
            SymbolTable symbolTable,
            IR.Instruction instr0,
            IR.Instruction instruction);

    void draw(
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void line(
            SymbolTable symbolTable,
            List<IR.Instruction> instr0,
            IR.Instruction instruction);

    void color(
            SymbolTable symbolTable,
            IR.Instruction instr0,
            IR.Instruction instruction);

    void paint(
            SymbolTable symbolTable,
            List<IR.Instruction> instr0,
            IR.Instruction instruction);

    void pset(
            SymbolTable symbolTable,
            List<IR.Instruction> instr0,
            IR.Instruction instruction);

    void bufferCopyHor(
            SymbolTable symbolTable,
            IR.Instruction instr0,
            IR.Instruction instruction);

    void get(
            SymbolTable symbolTable,
            List<IR.Instruction> instr0,
            IR.Instruction instruction);

    void put(
            SymbolTable symbolTable,
            IR.Instruction instr0,
            IR.Instruction instr1,
            IR.Instruction instruction);

    void inkeydlr(
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
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void mouseMovedY(
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void mouseDraggedX(
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void mouseDraggedY(
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void mouseButtonClicked(
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void mouseButtonPressed(
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void mouseButtonReleased(
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void isKeyPressed(
            SymbolTable symbolTable,
            IR.Instruction instruction);

    void cls();

    void locate(Integer row, Integer col);

    void beep();
}

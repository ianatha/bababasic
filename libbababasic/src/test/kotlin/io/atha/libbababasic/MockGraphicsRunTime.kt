package io.atha.libbababasic

import io.atha.libbababasic.domain.SymbolTable
import io.atha.libbababasic.file.SystemInputOutputFile
import io.atha.libbababasic.parser.IR
import io.atha.libbababasic.runtime.GraphicsRuntime
import io.atha.libbababasic.runtime.SoundState

class MockGraphicsRunTime(val stdio: SystemInputOutputFile) : GraphicsRuntime {
    override fun saveimg(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not yet implemented")
    }

    override fun loadimg(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not yet implemented")
    }

    override fun screen(
        symbolTable: SymbolTable?,
        instr0: MutableList<IR.Instruction>?,
        instruction: IR.Instruction?
    ) {
        TODO("Not yet implemented")
    }

    override fun hsb2rgb(
        symbolTable: SymbolTable?,
        instr0: IR.Instruction?,
        instruction: IR.Instruction?
    ) {
        TODO("Not yet implemented")
    }

    override fun repaint() {
        TODO("Not yet implemented")
    }

    override fun end() {

    }

    override fun circle(
        symbolTable: SymbolTable?,
        instr0: MutableList<IR.Instruction>?,
        instruction: IR.Instruction?
    ) {
        TODO("Not yet implemented")
    }

    override fun font(
        symbolTable: SymbolTable?,
        instr0: IR.Instruction?,
        instruction: IR.Instruction?
    ) {
        TODO("Not yet implemented")
    }

    override fun drawstr(
        symbolTable: SymbolTable?,
        instr0: IR.Instruction?,
        instruction: IR.Instruction?
    ) {
        TODO("Not yet implemented")
    }

    override fun draw(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not yet implemented")
    }

    override fun line(
        symbolTable: SymbolTable?,
        instr0: MutableList<IR.Instruction>?,
        instruction: IR.Instruction?
    ) {
        TODO("Not yet implemented")
    }

    override fun color(
        symbolTable: SymbolTable?,
        instr0: IR.Instruction?,
        instruction: IR.Instruction?
    ) {
        TODO("Not yet implemented")
    }

    override fun paint(
        symbolTable: SymbolTable?,
        instr0: MutableList<IR.Instruction>?,
        instruction: IR.Instruction?
    ) {
        TODO("Not yet implemented")
    }

    override fun pset(
        symbolTable: SymbolTable?,
        instr0: MutableList<IR.Instruction>?,
        instruction: IR.Instruction?
    ) {
        TODO("Not yet implemented")
    }

    override fun bufferCopyHor(
        symbolTable: SymbolTable?,
        instr0: IR.Instruction?,
        instruction: IR.Instruction?
    ) {
        TODO("Not yet implemented")
    }

    override fun get(
        symbolTable: SymbolTable?,
        instr0: MutableList<IR.Instruction>?,
        instruction: IR.Instruction?
    ) {
        TODO("Not yet implemented")
    }

    override fun put(
        symbolTable: SymbolTable?,
        instr0: IR.Instruction?,
        instr1: IR.Instruction?,
        instruction: IR.Instruction?
    ) {
        TODO("Not yet implemented")
    }

    override fun inkeydlr(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not yet implemented")
    }

    override fun loadwav(
        soundState: SoundState?,
        symbolTable: SymbolTable?,
        instruction: IR.Instruction?
    ) {
        TODO("Not yet implemented")
    }

    override fun playwav(
        soundState: SoundState?,
        symbolTable: SymbolTable?,
        instruction: IR.Instruction?
    ) {
        TODO("Not yet implemented")
    }

    override fun stopwav(
        soundState: SoundState?,
        symbolTable: SymbolTable?,
        instruction: IR.Instruction?
    ) {
        TODO("Not yet implemented")
    }

    override fun loopwav(
        soundState: SoundState?,
        symbolTable: SymbolTable?,
        instruction: IR.Instruction?
    ) {
        TODO("Not yet implemented")
    }

    override fun mouseMovedX(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not yet implemented")
    }

    override fun mouseMovedY(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not yet implemented")
    }

    override fun mouseDraggedX(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not yet implemented")
    }

    override fun mouseDraggedY(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not yet implemented")
    }

    override fun mouseButtonClicked(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not yet implemented")
    }

    override fun mouseButtonPressed(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not yet implemented")
    }

    override fun mouseButtonReleased(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not yet implemented")
    }

    override fun isKeyPressed(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not yet implemented")
    }

    override fun cls() {
        TODO("Not yet implemented")
    }

    override fun locate(row: Int?, col: Int?) {
        TODO("Not yet implemented")
    }

    override fun beep() {
        TODO("Not yet implemented")
    }

}
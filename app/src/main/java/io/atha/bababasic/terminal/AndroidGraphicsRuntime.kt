package io.atha.bababasic.terminal

import android.media.AudioManager
import android.media.ToneGenerator
import io.atha.libbababasic.domain.SymbolTable
import io.atha.libbababasic.file.BBUIFile
import io.atha.libbababasic.parser.IR
import io.atha.libbababasic.runtime.GraphicsRuntime
import io.atha.libbababasic.runtime.SoundState
import java.lang.Thread.sleep

class AndroidGraphicsRuntime(val stdio: BBUIFile) : GraphicsRuntime {
    override fun saveimg(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not supported")
    }

    override fun loadimg(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not supported")
    }

    override fun screen(
        symbolTable: SymbolTable?,
        instr0: MutableList<IR.Instruction>?,
        instruction: IR.Instruction?
    ) {
        TODO("Not supported")
    }

    override fun hsb2rgb(
        symbolTable: SymbolTable?,
        instr0: IR.Instruction?,
        instruction: IR.Instruction?
    ) {
        TODO("Not supported")
    }

    override fun repaint() {
        TODO("Not supported")
    }

    override fun end() {
    }

    override fun circle(
        symbolTable: SymbolTable?,
        instr0: MutableList<IR.Instruction>?,
        instruction: IR.Instruction?
    ) {
        TODO("Not supported")
    }

    override fun font(
        symbolTable: SymbolTable?,
        instr0: IR.Instruction?,
        instruction: IR.Instruction?
    ) {
        TODO("Not supported")
    }

    override fun drawstr(
        symbolTable: SymbolTable?,
        instr0: IR.Instruction?,
        instruction: IR.Instruction?
    ) {
        TODO("Not supported")
    }

    override fun draw(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not supported")
    }

    override fun line(
        symbolTable: SymbolTable?,
        instr0: MutableList<IR.Instruction>?,
        instruction: IR.Instruction?
    ) {
        TODO("Not supported")
    }

    override fun color(
        symbolTable: SymbolTable?,
        instr0: IR.Instruction?,
        instruction: IR.Instruction?
    ) {
        TODO("Not supported")
    }

    override fun paint(
        symbolTable: SymbolTable?,
        instr0: MutableList<IR.Instruction>?,
        instruction: IR.Instruction?
    ) {
        TODO("Not supported")
    }

    override fun pset(
        symbolTable: SymbolTable?,
        instr0: MutableList<IR.Instruction>?,
        instruction: IR.Instruction?
    ) {
        TODO("Not supported")
    }

    override fun bufferCopyHor(
        symbolTable: SymbolTable?,
        instr0: IR.Instruction?,
        instruction: IR.Instruction?
    ) {
        TODO("Not supported")
    }

    override fun get(
        symbolTable: SymbolTable?,
        instr0: MutableList<IR.Instruction>?,
        instruction: IR.Instruction?
    ) {
        TODO("Not supported")
    }

    override fun put(
        symbolTable: SymbolTable?,
        instr0: IR.Instruction?,
        instr1: IR.Instruction?,
        instruction: IR.Instruction?
    ) {
        TODO("Not supported")
    }

    override fun inkeydlr(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        val key = stdio.takeInputChar()
        symbolTable!![instruction!!.result]!!.value!!.string = key?.toString() ?: ""
    }

    override fun loadwav(
        soundState: SoundState?,
        symbolTable: SymbolTable?,
        instruction: IR.Instruction?
    ) {
        TODO("Not supported")
    }

    override fun playwav(
        soundState: SoundState?,
        symbolTable: SymbolTable?,
        instruction: IR.Instruction?
    ) {
        TODO("Not supported")
    }

    override fun stopwav(
        soundState: SoundState?,
        symbolTable: SymbolTable?,
        instruction: IR.Instruction?
    ) {
        TODO("Not supported")
    }

    override fun loopwav(
        soundState: SoundState?,
        symbolTable: SymbolTable?,
        instruction: IR.Instruction?
    ) {
        TODO("Not supported")
    }

    override fun mouseMovedX(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not supported")
    }

    override fun mouseMovedY(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not supported")
    }

    override fun mouseDraggedX(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not supported")
    }

    override fun mouseDraggedY(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not supported")
    }

    override fun mouseButtonClicked(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not supported")
    }

    override fun mouseButtonPressed(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not supported")
    }

    override fun mouseButtonReleased(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not supported")
    }

    override fun isKeyPressed(symbolTable: SymbolTable?, instruction: IR.Instruction?) {
        TODO("Not supported")
    }

    override fun cls() {
        stdio.print(VT100.CLEAR_SCREEN);
    }

    override fun locate(row: Int, col: Int?) {
        stdio.print(VT100.MOVE_TO(row, col))
    }

    override fun beep() {
        try {
            val toneGenerator = ToneGenerator(AudioManager.STREAM_MUSIC, 100);
            toneGenerator.startTone(ToneGenerator.TONE_CDMA_PIP, 100);
            sleep(100);
        } catch (e: Exception) {
            // ignore
        }
    }
}

object VT100 {
    internal const val ESC = "\u001b"
    internal const val CONTROL_SEQ_INTRODUCER = "$ESC["
    const val CLEAR_SCREEN = "${CONTROL_SEQ_INTRODUCER}2J"
    fun MOVE_TO(row: Int, col: Int?): String {
        require(row >= 1) { "LOCATE row must be >= 1" }
        return if (col == null) {
            "${CONTROL_SEQ_INTRODUCER}${row}H"
        } else {
            require(col >= 1) { "LOCATE col must be >= 1" }
            "${CONTROL_SEQ_INTRODUCER}${row};${col}H"
        }
    }
}
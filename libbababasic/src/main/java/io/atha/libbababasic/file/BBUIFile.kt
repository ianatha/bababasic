package io.atha.libbababasic.file

interface BBUIFile : BBFile {
    fun inputDialog(prompt: String): String?
    fun peekHasChar(): Boolean
    fun takeInputChar(): Char?
    fun outputText(text: String)
}
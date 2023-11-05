package io.atha.libbababasic.file

interface BBUIFile : BBFile {
    fun inputDialog(prompt: String): String?
    fun takeInputChar(): String
    fun outputText(text: String)
}
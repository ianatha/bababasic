package org.puffinbasic.file

interface PuffinUserInterfaceFile : PuffinBasicFile {
    fun inputDialog(prompt: String): String?
}
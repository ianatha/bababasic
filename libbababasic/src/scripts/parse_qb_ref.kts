import java.io.File

val file = File("../../../ref/QuickBASIC_Lang_Ref.md")
val lines = file.readLines()
val startLine = lines.indexOfFirst { it.contains("PART 2  STATEMENT AND FUNCTION REFERENCE") } + 1
val endLine = lines.indexOfFirst { it.contains("Appendix A  Keyboard Scan Codes and ASCII Character Codes") }

val topics = lines.subList(startLine, endLine).map { it.trim() }.filter {  it != "" }

fun filename(topic: String): String = topic.replace(Regex("[^A-Za-z0-9]"), "_")

val out = File("../main/java/io/atha/libbababasic/Help.kt")

out.writeText("val HELP_CONTENT = mapOf(")
val help = topics.forEach { topic ->
    println("####"  + topic)
    val contentStartLine = lines.indexOfLast { it == topic }
    if (contentStartLine == -1) {
        println("ERROR: $topic")
        return@forEach
    }
    var contentEndLine =  lines.subList(contentStartLine + 2, lines.size).indexOfFirst { it == "────────────────────────────────────────────────────────────────────────────" }
    if (contentEndLine < 0) {
        return@forEach
    }
    contentEndLine = contentStartLine + 2 + contentEndLine

    val content = lines.subList(contentStartLine + 2, contentEndLine).joinToString("\n")

    out.appendText("\"$topic\" to \"\"\""  + content + "\"\"\",")
}
out.appendText(")")
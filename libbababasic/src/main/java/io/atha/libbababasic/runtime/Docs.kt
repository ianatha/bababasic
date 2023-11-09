package io.atha.libbababasic.runtime

import HELP_CONTENT
import io.github.classgraph.ClassGraph
import java.io.File
import kotlin.reflect.KClass

annotation class QBDocs(val name: String, val docs: String)

@Throws(Exception::class)
fun getAllAnnotatedWith(annotation: KClass<out Annotation>): List<List<Any>> {
    val `package` = annotation.java.`package`.name
    val annotationName = annotation.java.canonicalName

    return ClassGraph()
        .enableAllInfo()
        .acceptPackages(`package`)
        .scan().use { scanResult ->
            scanResult.getClassesWithMethodAnnotation(annotationName).flatMap { routeClassInfo ->
                routeClassInfo.methodInfo
                    .filter{ function -> function.hasAnnotation(annotation.java) }
                    .mapNotNull { method ->
                        method.getAnnotationInfo(annotationName).parameterValues.map {
                            it.value
                        }
                    }
            }
        }
}


data class Topic(
    val topic: String,
    val sections: Map<String, String>,
) {
    fun filename(): String = topic.replace(Regex("[^A-Za-z0-9]"), "_")
}

fun sectionsFromRaw(text: String): Map<String, String> {
    val sectionsMap = mutableMapOf<String, String>()
    val pattern = Regex("■\\s*(\\w+)\\s*\\n\\n(.*?)(?=\\n■|$)", RegexOption.DOT_MATCHES_ALL)

    pattern.findAll(text).forEach { match ->
        val sectionTitle = match.groups[1]?.value?.trim() ?: ""
        val sectionContent = match.groups[2]?.value?.trim()?.replace("\n    ", "\n") ?: ""
        sectionsMap[sectionTitle] = sectionContent
    }

    return sectionsMap
}
val HELP_ITEMS = HELP_CONTENT.map { (topic, content) ->
    val lines = content.split("\n")
    val sections = sectionsFromRaw(content)
    val t = topic.split(" ")
    val topic_s = t[0]!!
    topic_s to sections
}.toMap()

fun helpFor(s: String?): String? {
    if (s == null) {
        return null
    }

    return "## Syntax\n\n" +  HELP_ITEMS[s]?.get("Syntax") + "\n\n## Action\n\n" + HELP_ITEMS[s]?.get("Action")
}
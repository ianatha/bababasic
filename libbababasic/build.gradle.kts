plugins {
    application
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    antlr
}

application {
    mainClass.set("io.atha.libbababasic.InterpreterMain")
}

tasks {
    val standaloneJar = register<Jar>("standaloneJar") {
        dependsOn.addAll(listOf("compileJava", "compileKotlin", "processResources"))
        archiveClassifier.set("standalone")
        duplicatesStrategy = DuplicatesStrategy.EXCLUDE
        manifest { attributes(mapOf("Main-Class" to application.mainClass)) }
        val sourcesMain = sourceSets.main.get()
        val contents = configurations.runtimeClasspath.get()
            .map { if (it.isDirectory) it else zipTree(it) } +
                sourcesMain.output
        from(contents)
    }
    build {
        dependsOn(standaloneJar)
    }
}

dependencies {
    antlr("org.antlr:antlr4:4.13.1")

    implementation("org.antlr:antlr4-runtime:4.13.1")
    implementation("com.google.guava:guava:29.0-jre")
    implementation("org.apache.commons:commons-csv:1.7")
    implementation("org.apache.commons:commons-math3:3.6.1")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.named("compileKotlin") {
    dependsOn(":libbababasic:generateGrammarSource")
}

tasks.named("compileTestKotlin") {
    dependsOn(":libbababasic:generateTestGrammarSource")
}

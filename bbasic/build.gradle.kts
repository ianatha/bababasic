plugins {
    application
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

application {
    mainClass.set("io.atha.libbababasic.InterpreterCLI")
}

tasks {
    val standaloneJar = register<Jar>("standaloneJar") {
        dependsOn(":libbababasic:jar")
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
    implementation(project(":libbababasic"))
    implementation("commons-io:commons-io:2.15.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
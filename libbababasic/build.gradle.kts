plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.antlr:antlr4-runtime:4.13.1")
    implementation("com.google.guava:guava:29.0-jre")
    implementation("it.unimi.dsi:fastutil:8.4.0")
    implementation("org.jetbrains:annotations:19.0.0")
    implementation("org.apache.commons:commons-csv:1.7")
    implementation("net.sourceforge.argparse4j:argparse4j:0.8.1")
    implementation("org.apache.commons:commons-math3:3.6.1")
    implementation("commons-io:commons-io:2.7")
    testImplementation("junit:junit:4.13.2")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
//    androidTestImplementation("androidx.test.uiautomator:uiautomator:2.3.0-alpha03")
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
//    debugImplementation("androidx.compose.ui:ui-tooling")
//    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
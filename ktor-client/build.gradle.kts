import org.jetbrains.kotlin.cli.common.isWindows

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "1.8.21"
    id("io.ktor.plugin") version "2.3.0"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.21"
}

group = "tools.samt"
version = "0.0.1"
application {
    mainClass.set("tools.samt.client.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-client-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}

task("generateSources") {
    doLast {
        exec {
            workingDir = File("../model")
            commandLine = if (isWindows) listOf("cmd.exe", "/c", "samtw.bat", "compile") else listOf("./samtw", "compile")
        }
    }
}
tasks.compileKotlin {
    dependsOn("generateSources")
}

sourceSets {
    named("main") {
        java.srcDir("$buildDir/generated/kotlin")
    }
}

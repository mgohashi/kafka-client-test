import org.jetbrains.kotlin.gradle.dsl.Coroutines

kotlin.experimental.coroutines = Coroutines.ENABLE

plugins {
    application
    kotlin("jvm") version "1.2.41"
}

application {
    mainClassName = "samples.Kafka"
}

dependencies {
    compile(kotlin("stdlib"))
    compile(kotlin("reflect"))
    testCompile(kotlin("test"))
    testCompile(kotlin("test-junit"))
}

repositories {
    jcenter()
}
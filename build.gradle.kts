import org.jetbrains.kotlin.gradle.dsl.Coroutines
kotlin.experimental.coroutines = Coroutines.ENABLE

group = "sample-client-test"
version = "0.1-SNAPSHOT"

repositories {
    jcenter()
}

plugins {
    application
    kotlin("jvm") version "1.2.41"
}

application {
    mainClassName = "samples.Kafka"
}

dependencies {
    compile("org.apache.kafka:kafka-clients:1.1.0")
    compile(kotlin("stdlib-jdk8"))
    testCompile(kotlin("test"))
    testCompile(kotlin("test-junit"))
}

val run by tasks.getting(JavaExec::class) {
    if (project.hasProperty("appArgs")) {
        args = project.property("appArgs").toString().split(",")
    }
}

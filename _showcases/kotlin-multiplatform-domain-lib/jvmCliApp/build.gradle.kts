import org.jetbrains.kotlin.ir.backend.js.compile

group = "fr.baldir.showcase"
version = "1.0-SNAPSHOT"

plugins {
    kotlin("jvm") version "1.5.30"
}


repositories {
    mavenCentral()
    gradlePluginPortal()
    google()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":sharedDomain"))
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}
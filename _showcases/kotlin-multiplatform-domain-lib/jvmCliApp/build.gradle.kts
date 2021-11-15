plugins {
    kotlin("jvm")
}
group = "fr.baldir.showcase"
version = "1.0-SNAPSHOT"
repositories {
    google()
    mavenCentral()
    mavenLocal()
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
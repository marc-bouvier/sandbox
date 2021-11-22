plugins {
    kotlin("multiplatform")
}
group = "fr.baldir.showcase"
version = "1.0-SNAPSHOT"
repositories {
    google()
    mavenCentral()
    mavenLocal()
}
kotlin {
    js {
        browser {
            testRuns["test"].executionTask.configure {
                useMocha()
            }
        }
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(project(":sharedDomain"))
                implementation(kotlin("stdlib-common"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-js"))
            }
        }
    }
}

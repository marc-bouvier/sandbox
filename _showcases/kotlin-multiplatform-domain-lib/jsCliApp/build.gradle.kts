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
        nodejs {
            testRuns["test"].executionTask.configure {
                useKarma{
                    useFirefox()
//                    useFirefoxHeadless()

                }
            }
        }

        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(project(":sharedDomain"))
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

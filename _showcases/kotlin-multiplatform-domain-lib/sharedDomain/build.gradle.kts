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
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}

kotlin {

    jvm {
        val main by compilations.getting{
            kotlinOptions{
                jvmTarget = "11"
            }
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    js {
        browser {
            testRuns["test"].executionTask.configure {
                useKarma {
                    // Note : to be used, browsers have to be installed on the machine
//                    useChrome()
//                    useChromeCanary()
//                    useChromeHeadless()
                    useFirefox()
                    useFirefoxHeadless()
//                    useOpera()
                }
            }
        }
        nodejs {
            testRuns["test"].executionTask.configure {
                useKarma{
                    useFirefox()
                    useFirefoxHeadless()
                }
            }
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
    }
}
plugins {
    kotlin("multiplatform") version "1.5.31"
}

group = "fr.baldir.showcase"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {

    jvm {
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
//        val jvmTest by getting {
//            dependencies{
//                implementation(kotlin("kotlin-test-junit"))
//            }
//        }
//        val jsTest by getting {
//            dependencies{
//                implementation(kotlin("kotlin-test-js"))
//            }
//        }

    }
}
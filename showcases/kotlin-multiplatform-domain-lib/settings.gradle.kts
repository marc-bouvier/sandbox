rootProject.name = "kotlin-multiplatform-domain-lib"

pluginManagement {
    val kotlinVersion: String by settings
    plugins {
        kotlin("multiplatform") version kotlinVersion
        kotlin("jvm") version kotlinVersion
        kotlin("js") version kotlinVersion
    }
}

include(":sharedDomain")
include(":jvmCliApp")
include(":jsBrowserApp")


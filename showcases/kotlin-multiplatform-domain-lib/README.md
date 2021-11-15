# Kotlin multiplatform code reuse

- [sharedDomain](sharedDomain/README.md) : common domain logic & orchestration
    - can generate reusable for jvm & js targets
    - unit tests are run against various targets (jvm, js : multiple browsers)
- [jsBrowserApp](jsBrowserApp/README.md) : browser application based on shared domain
- [jvmCliApp](jvmCliApp/README.md) : jvm CLI app based on shared domain
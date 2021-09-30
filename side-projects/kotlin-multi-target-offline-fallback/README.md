# kotlin-multi-target-offline-fallback
POC of business logic library written in Kotlin called on JVM as normal usage and falling back to koltinscript when offline

# Why

- Javascript in not easily maintainable
- We may want to transition from existing codebase stuck in JDK 7
- Calculator : We need to combine business rules
- most of the developers know java

# Todo

- this POC
- unit test
- maybe test on both platforms
- write pros/cons
- build to target JVM and Javascript
- fallback mechanism
- sync back mechanism (when server business logic remains the same)

# Pros/Cons

## pros

- business easier to test coming from java
- null safe by default
- can use java test tooling
- can convert java business logic automatically in kotlin
- can use lambdas and java 8ish feature on JVM7 target
- business logic can still be used in 
- ops know how to JAR (they don't have to learn and monitor nodejs yet)
- design patterns using functional style : appropriate for the calculator
- can allow to delay choices

## cons

- another language?
- maybe need gradle to compile multiple targets and deploy on nexus 3
- suffixed names by kotlin not useful in JS

## Resources
- [Intellij 2017.3 support multiplatform targets](https://blog.jetbrains.com/idea/2017/12/intellij-idea-2017-3-support-for-kotlin-multi-platform-projects/)
- [KotlinConf 2017 - Sharing [Kotlin code across platforms] is Caring! by Eugenio Marletti](https://www.youtube.com/watch?v=DctKvZOU56I)
- Js suffixed name annotation to name methods in javascript
- [Multiplatform projects with kotlin](https://kotlinlang.org/docs/reference/multiplatform.html)
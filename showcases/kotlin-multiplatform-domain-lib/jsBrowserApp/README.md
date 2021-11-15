# jsBrowserApp

A javascript Broswser app that relies on the shared core domain

[See it live](dist)

## Architecture

- `src/jsMain/kotlin/Main.kt` : js app entry point, when built is will be named `jsBrowserApp.js` (project name)
- `src/jsMain/resources/index.html` : HTML entrypoint. It initializes with the js app.

2 kinds of tests are possible
- Orchestration tests against test double (no frameworks).
- End to End tests against fraweworks and real I/O
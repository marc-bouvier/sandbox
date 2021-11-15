# Shared Domain

Multiplatform Core domain & domain orchestration

Can be published as library targeting
- js
  - browser
  - nodeJs
- jvm

## Architecture

Here, we only write common code (we should never use `actual` keyword in the `domain` package)

Only unit tests against no I/O.
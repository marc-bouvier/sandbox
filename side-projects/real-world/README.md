# real-world
Real world app as I would like to see it.

Inspirations : 
- https://github.com/ddd-by-examples/library
- https://github.com/ddd-by-examples/factory
- [DDD & Event Sourcing à la rescousse pour implémenter la RGPD ? (G. Lours, J. Avoustin)](https://www.youtube.com/watch?v=RK4mrpro2B4)

## Todo

- [ ] Living documentation
- [ ] Java jigsaw modules
- [ ] Gradle (modules)
    - [ ] Core domain model : kotlin (allows to transpile to javascript & native & jvm) 
    - [ ] Hexagonal architecture (Write)
    - [ ] CRUD (read)
- [ ] Quarkus
- [ ] Spring boot
  - modular (configurable, avoid using component scan). prefer declaring beans in @Configuration
- [ ] Authentication server : keycloak
- [ ] Docker compose
- [ ] Vavr, FP in java 
- [ ] Tests : groovy spock (DSL)
- [ ] TDD, BDD like syntax
- [ ] User Actions and business must be audited
- [ ] Consent and GDPR must be enforced (privacy by design)
  - 
  - Personal data must be inventoried
  - Right to be forgotten must be actionable
    - how to anonymize/obfuscate personal data (ex. in event store)
    - 
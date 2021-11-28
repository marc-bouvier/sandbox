# Documentation vivante

Aujourd'hui, il est souvent difficile de connaitre les motivations et les discussions qui ont entrainé certains choix technologiques. C'est vrai en particulier concernant les choix de structure de code et de dépendences. Certains de ces choix peuvent être périmés mais ils peuvent avoir été pertinents au moment où ils ont été faits. La documentation vivante peut répondre à cette problématique en automatisant au maximum la génération de documentation.

> Every technical decision should have an expiration label
>
> Venkat Subramaniam - [Qualities of a Highly Effective Architect Keynote - Devoxx 2019](https://youtu.be/QeKheNfO3Yg?t=2602)

> We embrace documentation, but not hundreds of pages of never-maintained and rarely-used tomes
>
> Martin Fowler and Jim Highsmith - [History - The Agile Manifesto](http://agilemanifesto.org/history.html)

Les décisions d'architecture initiales peuvent être synthétisées dans un Document d'Architecture Technique. Ce document permet d'avoir une idée générale de l'infrastructure, des interconnexions avec d'autres systèmes, des objectifs de performances, de sécurité ou encore d'expérience utilisateur. Il est très utile pour estimer les coûts initiaux ainsi que la mise en place des différents environnements nécessaires à l'équipe de développement pour travailler.

Cependant, ce document est souvent réalisé en amont des développements, c'est à dire au moment où on a le moins d'informations sur logiciel. L'architecturene, elle, est forcément amenée à être amendée à chaque fois que de nouvelles contraintes sont découvertes.

Cela peut être le cas lorsque de nouveaux systèmes interagissent avec le logiciel ou si de nouvelles contraintes apparaissent (montée à l'échelle, augmentation de la charge, application mobile, passage en SAAS, ...)

Il ne rentre pas dans les détails d'implémentation et laisse en général la latitude à l'équipe de développement de prendre ces décisions. Le logiciel évoluant, le document d'architecture technique, lui, peut devenir assez vite obsolète.

L'écosystème technologique évolue (plateformes, librairies). Les équipes peuvent aussi évoluer. Le détail de l'implémentation du logiciel est constitué des choix quotidiens que font les différents acteurs travaillant dessus. Ces choix plus fins sont rarement répertoriés dans un document d'architecture technique.

Dans cet article nous parlerons spécifiquement des décisions relatives aux choix d'implémentation.

Cela rend difficile l'arrivée de nouveaux développeurs. Ils ne savent en général pas quelles ont été les motivations qui ont amené à choisir la structure du logiciel, les conventions de nommage, l'utilisation de patrons de conception ou encore la stratégie de test qui est en place.

Dans le cas d'un wiki classique, l'information peut être à jour. Il peut y avoir un historique des motivations. Les motivations, les discussions qui ont amené à ces choix, elles, ne sont en général pas documentée.

C'est bien dommage car
* des choix peuvent être très anciens et avoir perdu leur pertinence
* des choix cachent des "non-chaix", des raisons pour lesquelles on a écarté d'autres possibilités
* des choix peuvent avoir remplacé des choix précédents
* certains choix sont fait parceque c'est le dernier truc brillant (au passage, ce n'est pas une mauvaise raison)
* certains choix peuvent paraitre discutables mais justifiés par la situation du moment
* des choix peuvent être temporaires

Toutes ces informations sont ignorées par la documentation traditionelle.

Le problème de la documentation "classique"
* ennuyeux
* pas à jour
* redondant
* induit en erreur
* écrire beaucoup de texte
* une activité séparée du code (silo)

Soyons réalistes, personne n'a envie de maintenir des documents Word sachant qu'ils sont rarement à jour et très rarement lus. L'informatique a fait beaucoup de progrès ces dernières années. Il est possible de commencer très rapidement des applications avec des outils comme Spring Boot, Ruby on Rail, JHipster. Alors pourquoi ne pas faire pareil pour la documentation?

A l'instar des commentaires qui agrémentent le code source, si la documentation est au plus près du code, elle reflète plus fidèlement la réalité du logiciel.

Les techniques de Documentation Vivante permettent de répondre à cette problématique.

Des exemples de documentation vivante:
* Javadoc
* Tests unitaires
* Swagger/Open Api
* Rapport de tests/couverture de code
* Rapport d'analyse statique de code
* Nommage de code utilisant le vocabulaire du métier (ex. Domain Driven Design)
* Annotations stéréotypes de frameworks comme Spring ou Java EE (ex. `@Service`, `@Inject`, `@Repository`, `@Controller`, ...)
* Issues GitHub
* Message de commit Git
* Commentaires sur une Pull Request

Ces outils sont souvent basés sur des générateurs qui utilisent des méta-données accolées au code source. Parmi ces méta-données on peut trouver :

* Des commentaires
* Des annotations de code
* Du code qui n'est pas présent dans le produit livré

Qualités généralement associées à de la documentation vivante

* Change au même rythme que le développement et l'architecture du logiciel
* Versionné avec le code source
* Générée automatiquement
* Permet d'apprendre les concepts utilisés dans l'application (Knowledge bomb)
    * Patrons de conceptions
    * Notions métier
    * But et raison d'être des fonctionalités

test

* Living documentation (https://leanpub.com/livingdocumentation, )
* ADR
* ArchUnit
* Wiki (si possible as code)
* Blog (si possible as code)
* README.md, CONTRIBUTE.md
* Gherkin (BDD) (https://support.smartbear.com/cucumberstudio/docs/bdd/living-doc.html)
* git release commit log -> avec une bonne convention on peut générer directement des release notes
* code-maat
* Commentaires échanges sur une Pull Request
* Conventional commits
* Mono repo

[mono-repo]:todo
[adr]:https://adr.github.io/
[living-doc-not-just-test-reports]:https://johnfergusonsmart.com/living-documentation-not-just-test-reports/
[cucumber-studio-living-doc]:https://support.smartbear.com/cucumberstudio/docs/bdd/living-doc.html
[book-living-doc-martraire]:https://www.amazon.fr/Living-Documentation-Cyrille-Martraire/dp/0134689321
[conventional-commits]:https://www.conventionalcommits.org/

Graphviz

draw.io (peut etre versionné avec les méta données permettant de modifier le diagramme)

## ADR

## Documentation vivante en général

## ArchUnit

## 
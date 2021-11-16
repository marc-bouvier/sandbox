---
marp: true
theme: uncover
paginate: true

---
<style>
:root {
\--color-background: #0e0e21 !important;
\--color-background-code: #422d47 !important;
\--color-background-paginate: rgba(114,114,114,0.05) !important;
\--color-foreground: #c9c9c9 !important;
\--color-highlight: #99c !important;
\--color-highlight-hover: #aaf !important;
\--color-highlight-heading: #99c !important;
\--color-header: #bbb !important;
\--color-header-shadow: transparent !important;
}
</style>

<!-- class: lead -->

# Living Documentation

## Tu ne le sais pas encore mais tu l'as deja documenté!

***

![bg 80% ](assets/hoken-landing.png)

***

## Qui suis-je?

Marc Bouvier

![bg w:200 right](assets/marc-bouvier-rnd-25.png)

***

## Living Documentation

<!-- _backgroundColor: "#170e21" -->

![bg w:200 right](assets/marc-bouvier-rnd-25.png)
![bg w:200 ](assets/marc-bouvier-rnd-25.png)
![bg w:200 right](assets/marc-bouvier-rnd-25.png)
![bg w:200 ](assets/marc-bouvier-rnd-25.png)
![bg w:200 right](assets/marc-bouvier-rnd-25.png)
![bg w:200 ](assets/marc-bouvier-rnd-25.png)
***

## La documentation c'est quoi pour vous?

<!-- _backgroundColor: "#1e0e21" -->

<div style="display: flex;"> <div style="margin: auto;display: flex;flex-flow: column;width: auto;flex-grow: 0.5;"> <textarea id="what_is_doc_1a" style="font-size: 1rem;height: 16rem;"></textarea> <div style="display: flex;"> <button onclick="localStorage.setItem('what_is_doc_1', document.getElementById('what_is_doc_1a').value)" style="width: 100%;">Save</button> <button onclick="document.getElementById('what_is_doc_1a').value = localStorage.getItem('what_is_doc_1')" style="width: 100%;">Load</button> </div> </div> </div>

***

## Antipatterns

<!-- _backgroundColor: "#210e19" -->

> Like cheap wine, paper documentation ages rapidly and leaves you with bad headache.

<p style="font-size: 1rem">Source : <a href="https://vuejs.org/v2/guide">https://vuejs.org/v2/guide</a></p>

***

### Activités séparées

<!-- _backgroundColor: "#210e0e" -->

TODO trouver GIF

***

***

### Mais au fait, elle fait quoi notre application?

<!-- _backgroundColor: "#0e211f" -->

* Manuel utilisateur
* OpenApi / Swagger
* Javadoc
* Site web
* Readme.md
* Demo site = documentation

***

### Pour qui?

<!-- _backgroundColor: "#11210e" -->

```kotlin
public class Test{
    fun test(): String = tetdsfg
}
```

***

### Pourquoi?

<!-- _backgroundColor: "#211e0e" -->

* Onboarding
  * Readme
  * Contribute
  * CodeTour

***

### Comment?

<!-- _backgroundColor: "#21130e" -->

* Ecrit? Non écrit?
* Conversations (ex. pour onboarding)
  * Conversations over Documentation
  * Travailer ensemble
    * Pair programming / Mob programmgin
  * Interviews métier, immersion
* Code
  * Commentaires -> refactor
  * Code = documentation
    * nommage : classes, packages, fonctions
    * annotations et métadonnées
    * DDD
    * tests
      * TDD
      * BDD

***

### Demo CodeTour

* Versionné
* Peut être validé quand le code change
* Json
  * Peut servir de base pour d'autres automatisations
    * Exemple

***

***

### Différentes caractéristiques

* Stable

TODO : tableau

* Statique, immuable, standard
* Dynamique, change souvent

***

Evergreen document Ce qui est stable = ce qui est toujours vrai

tout ce qui bouge ailleurs

* marketing
* noms de sociétés
* les dates
* les gens

***

Les comportements métiers

BDD

Documentation exécutable

***

Redondance

Quelle est la source de vérité?

Cucumber / Specflow -> réconciliation entre scénarios et code

***

![Désastre d'automatisation illustré par une usine automatique comportant des centaines de tapis roulant et des cheminées industrielles rejetant une épaisse fumée noire](assets/automation_mess.gif)

Automatisation : ça tourne mal

<p style="font-size: 1rem">Source : <a href="https://www.youtube.com/watch?v=t2X3wlvoShg">I Built a 600 Meter Human Cannon That Ends All Existence - Satisfactory</a> - Let's Game It Out - 2020</p>

***

## DRY - Aussi pour la documentation

* Single source of source
* Plusieurs cibles de documentation possibles

***

![A partir du code source de la classe Intr en Kotlin, la documentation interactive de l'IDE et l'API reference sur un site web sont générées | bg 100%](assets/one_source_of_truth_multiple_targets.png)

***

## Des nouvelles façons de documenter

***

### Contributif

Wiki as code

![VueJs propose de mettre à jour sa documentation par PR | bg fit right](assets/vuejs_fix_documentation_as_PR.png) <p style="font-size: 1rem">Source : <a href="https://vuejs.org/v2/guide">https://vuejs.org/v2/guide</a></p>

***

## Documenter pendant

* TDD
  * Documenter l'intention, le comportement

***

## Conclusion

Les slides

![bg left 50%](assets/qrcode_u.baldir.fr_AT2021LD.png)

### La documentation c'est quoi pour vous?

<div style="display: flex;"> <div style="margin: auto;display: flex;flex-flow: column;width: auto;flex-grow: 0.5;"> <textarea id="what_is_doc_1b" style="font-size: 1rem;height: 16rem;"></textarea> <div style="display: flex;"> <button onclick="localStorage.setItem('what_is_doc_1', document.getElementById('what_is_doc_1b').value)" style="width: 100%;">Save</button> <button onclick="document.getElementById('what_is_doc_1b').value = localStorage.getItem('what_is_doc_1')" style="width: 100%;">Load</button> </div> </div> <div style="margin: auto;display: flex;flex-flow: column;width: auto;flex-grow: 0.5;"> <textarea id="what_is_doc_2" style="font-size: 1rem;height: 16rem;"></textarea> <div style="display: flex;"> <button onclick="localStorage.setItem('what_is_doc_2', document.getElementById('what_is_doc_2').value)" style="width: 100%;">Save</button> <button onclick="document.getElementById('what_is_doc_2').value = localStorage.getItem('what_is_doc_2')" style="width: 100%;">Load</button> </div> </div> </div>

***

## Ressources

***

![Living Documentation - Cyrille Martraire](https://servimg.eyrolles.com/static/media/9326/9780134689326_internet_w290.jpg)

[Living Documentation](https://www.eyrolles.com/Informatique/Livre/living-documentation-9780134689326/) - Cyrille Martraire ([@cyriux](https://twitter.com/cyriux))

***

<div style="text-align: center"> <iframe width="720" height="480" src="https://www.youtube.com/embed/Tw-wcps7WqU" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe> </div>

[Living Documentation : vous allez aimer la documentation ! (Cyrille Martraire)](https://www.youtube.com/watch?v=Tw-wcps7WqU)

***

![Quelques livres de Gojko Adzic dont : "Impact Mapping", "Specification By Example", "Fifty Quick Ideas to Improve Your User Stories", "Bridging the Communication Gap: Specification by Example and Agile Acceptance Testing", 	"Fifty Quick Ideas To Improve Your Tests"](assets/Gojko_Adzic.png)

[Gojko Adzic](https://www.goodreads.com/author/show/1407215.Gojko_Adzic) ([@gojkoadzic](https://twitter.com/gojkoadzic=))

***

[Awesome Living Documentation](https://github.com/LivingDocumentation/awesome-living-documentation)

***

Gifs

***

<div style="text-align: center"> <iframe src="https://giphy.com/embed/xUOxeZy7TXZYptBMSA" width="480" height="270" frameBorder="0" class="giphy-embed" allowFullScreen></iframe> <p> <a href="https://giphy.com/gifs/brooklynninenine-brooklyn-99-xUOxeZy7TXZYptBMSA"> via GIPHY</a> </p> </div>

***

<iframe src="https://giphy.com/embed/iUR4qsCkrNHhe" width="480" height="452" frameBorder="0" class="giphy-embed" allowFullScreen></iframe><p><a href="https://giphy.com/gifs/cat-iUR4qsCkrNHhe">via GIPHY</a></p>

***

<iframe src="https://giphy.com/embed/HU6hWEApxYTgQ" width="461" height="480" frameBorder="0" class="giphy-embed" allowFullScreen></iframe><p><a href="https://giphy.com/gifs/jim-carrey-HU6hWEApxYTgQ">via GIPHY</a></p>

***

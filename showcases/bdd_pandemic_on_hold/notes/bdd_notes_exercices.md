# Notes exercices


## Exo 1 pour adapter la formation
Avec un chrono.

* Feuilles A5
* distributions d'un feutre coloré par personne
* 45s
* dessiner une étoile à 12 points

Debrief
Une petite pression : c'est important (le formateur indique que ca changera le cours de la formation) un temps très court.

On a foncé dans l'implémentation.

On n'a pas discuté.
On a tous notre interprétation du sujet.
On a tous dessiné quelque chose différent
On n'a pas faux, on a juste pas compris la même chose.

> Même sur des concepts très basique on peut avoir des interprétation très différentes.

> Personne n'a faux, on a juste compris différemment

## Exo 2 - Le déplacement du cavalier aux echecs

3 groupes

* connaitre la regle des echecs

A faire : écrire une spec - le mouvement du cavalier dans les echecs

### Réponse de notre groupe

> Dessin expliquant toutes les possibilités (y compris sauter par dessus un autre pion

* Il se déplace en "L"
* cas 1 - 2 cases dans une direction (vertical ou horizontal) puis une case dans une direction perpendiculaire
* cas 2 - 1 case dans une direction (vertical ou horizontal) puis 2 cases dans une direction perpendiculaire
* Il n'est pas bloqué par une autre pièce sur son chemin. Il "saute" une pièce
* Il a au max 8 mouvements possibles
* Il peut aller dans toutes les directions (pas limité à aller devant)
* Il se déplace toujours vers une case de la couleur opposée à celle de sa case initiale (propriétés, résultantes)

* Il ne peut pas sortir du plateau
* Il ne peut pas se déplacer sur une case ayant une pièce de sa couleur
* Pas de déplacement en diagonale

Le formateur. Dessine un plateau et fait preuve de mauvaise foi. Et nous prouve qu'on peut toujours mak interpréter.

> On a spécifié le chemin. Ca n'a pas vraiment d'intérêt. C'est déja un détail d'implémentation
> Ce qui intéresse ici c'est la case de destination.

Tout est sujet à interprétation. Plus les fonctionnels rajoutent des détails inutiles, plus ca va entrainer du overdesign ou des choses complexes.

> Une spec seule ne suffit pas.
### Une autre spec  - Wikipedia

> "A *knight* moves to the *nearest* squre not en the same *rank*, *file*, or *diagonal*.

Est-ce que c'est une bonne spec? C'est concis. Et infaillible. Elle n'est pas complète car en la lisant c'est difficile de la comprendre.

On risque de faire en permanence de faire la traduction.

Si on modélise le jeu ainsi, on s'oblige à traduire entre la technique et le métier.

```
  game = Chess[8][8]
  game[0,2] // En fait on veut dire  A3 
  game("A3")
```

### Aller plus loin - des exemples

> /!\ Si j'écris un document dans mon coin je partage une information mais pas une compréhension!
> Il faut les écrire ensemble.

Cucumber peut traduire

```
  Given a Knight located at D4
  When the Knight should be able to move to:
  B3,C2,B5,C6,E2,F3,E6,F5
```

Concret pour pouvoir s'appuyer dessus pour discuter.

* Qu'est ce qui peut faire en sorte que cet exemple ne marche pas?
* Et si on change le contexte?
* Est-ce toujours vrai?

But : faire echouer cet exemple. Et creuser les règles.

=> Deliberate discovery

On peut définir ensemble si on doit mettre en place un setup valide.
> Ex. doit on mettre les rois pour avoir un setup valable pour que les fixture technique soient réalistes?

```
  Given a white Knight located at D4
  And a white King located at C3
  And a black Bishop located at G7
  (And a black King located at E7) # A voir si c'est nécessaire pour le test
  When the (white) Knight attempts to move to F5
  Then the knight should not be able to move
```

Il peut y avoir des implicites sur tous les exemples. Si ce n'est pas précisé :
* ex. On part toujours sur un plateau de jeu vide
* ex. c'est au joueur blanc de jouer

==> /!\  /!\  /!\ Toujours faire une distinction : J'écris une règle ou un exemple concret?

> Essayer d'avoir les exemples les plus précis possible pour avoir le moins de choix à faire.

On essaye d'utiliser du conditionnel. "should / should not".

Tester l'incapacité de faire quelque chose est difficile à mettre en place. Le permet-on? L'empèche t-on?

> Vous ne pouvez pas être exhaustif sur les exemples

On n'est pas en train de créer une spec! On *illustre* une spec avec des exemples.

> L'essentiel est d'utiliser le business language tout le temps!!

### DSL

ex. DSL - Domain Specific Language
Langage pour nous simplifier la vie.

```
Given the following board
-- -- -- -- -- -- -- --
-- -- -- -- bK -- dB --
-- -- -- -- -- -- -- --
-- -- -- -- -- -- -- --
-- -- -- wN -- -- -- --
-- -- wK -- -- -- -- --
-- -- -- -- -- -- -- --
-- -- -- -- -- -- -- --
-- -- -- -- -- -- -- --
...
```

Ou encore

```
Given the following board
-- -- -- -- -- -- -- --
-- -- -- -- ♚  -- ♝  --
-- -- -- -- -- -- -- --
-- -- -- -- -- -- -- --
-- -- -- ♘  -- -- -- --
-- -- ♔  -- -- -- -- --
-- -- -- -- -- -- -- --
-- -- -- -- -- -- -- --
-- -- -- -- -- -- -- --
...
```

Il faut que les conversations soient fluides. Ne pas trop formaliser les exemples (given when then). Des exemples graphiques avec des photos. 

### Vocabulaire

* Règle : générique
  * Critère d'acceptance
* Exemple : précis

### 3 amigos

Les 3 rôles se réunissent pour *essayer* de trouver des exemples. Il faut que ca aille assez vite. Pour que les gens du métier se sentent à l'aise.

Il faut le faire le plus expéditif possible et le plus efficacement possible. On peut le formaliser après coup.

Les 3 rôles
* Développeur
* Expert métier
* Représentant des tests / QA (peut être un dev)

Les testeurs 
* aiment bien faire échouer les choses et trouver les cas à la marge. 
* Ils ont un état d'esprit différent
* Ils jouent avec l'app
* Ont une vision plus large de l'application (plus globale)

Developpeurs
* Comprendre
* Vérifier la faisabilité
* Anticiper un peu les contraintes techniques

Experts métiers
* Répondre aux questions
* trouver les exemples

Deliberate discovery
=> faire emerger des règles => on peut en parler plus tard.

> C'est bien d'avoir un *facilitateur* dans ces runions là.
* recadrer si on part sur de la formalisation
* repérer le langage non verbal
* faire en sorte que ce soit plus fluide et intéressant
* quand on veut mettre en place BDD essayer d'assister à toutes les réunions (on peut le faire car on a suivi cette formation)
### Conversations avec le métier - malédiction de la conaissance

> Avoir des conversations avec le métier. Mais ca ne suffit pas.

A cause de la mélédiciton de la connaissance

* L'expert a du mal à avoir de l'empathie pour les personnes qui ne connaissent pas le métier
* Il va ptetre omettre des choses ou être implicite sur certaines choses

=> Utiliser des exemples
=> compréhension commune
=> vocabulaire commun (ubiquitous language - DDD)
=> découvrir les inconnues

## exo 3 - password rules

* 3 groupes
* chaque groupe construit 3 règles de validation de mot de passe
* trouver les regles de vos adversaires
  * soumettre des mots de passe aux adversaires
    * valide 1, 2 ou 3 règles
    * valide regle A et B ...

Au final, on se rend compte que définir des notion s comme "caractère spécial" , "lettre" ...

On se rend compte qu'on veut pouvoir définir ces notions avec un expert métier.

Toutes les soumissions des mots de passe sont des exemples. Il est difficile de retrouver les règles à partir des exemples.

> /!\ les exemples ne remplaçent pas la règle !!!

Un bon test unitaire

* F - fast env à la ms
* I - isolé (de l'extérieur du SI, pas d'IO, pas de clock) / indépendant (des autres tests)
* R - repetable
* S - self validating. il s'auto evalue lui-même. Il dit s'il passe ou pas
* T - timely (effectué au moment opportun = pendant le dev, le dev n'est pas fini tant que le test n'est pas écrit) / thorough (minutieux et exhaustif), complet : tester tous les cas ou sous-cas)

BDD se base sur des **tests unitaires**



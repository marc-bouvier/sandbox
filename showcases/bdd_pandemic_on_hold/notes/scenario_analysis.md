# Analyse de scenarios

Recherche sur github => gherkin

Des projets on on trouve qu'il y a des erreurs. On critique le travail des personnes pas les personnes.

## Confluence

* Pas de métier
* Test d'un truc extérieur à toi : Confluence
* le behaviour n'est pas donnée par le `When`
* `Given` es juste un groupe nominal
* On teste qu'un serveur est up : c'est pas un comportement. C'est un sanity test.
* Gherkin n'est pas l'outil adapté pour ce travail.
* C'est inapproprié

=> PAS BDD pour ce test
=> Ici Sanity check

## Asset manager

* `Given` "I am testing. n'a aucun sens. Ce n'est pas un contexte de l'action. Pourrait être l'asset xxxx existe
* Ici on est pas vraiment en train de tester un comportement

=> Pas BDD
=> Technical test

> Un scénario BDD aurait pu être créé/lu par un PO / demandeur

## Forgot the rule - monopoly

* Dans l'exemple le retour au début à la fin du plateau aurait mérité son propre test. La regle est implicite
* on ne parle pas métier : case 3 ne parle pas. On devrait parler des noms de rue
* mais on peut imaginer qu'en début de développement ce soit pertinent
* Attention a ne pas vouloir tout mettre dans le même test dans le cas de tests paramétrés

## Deal with team invitations

* outline effect - déroule trop de choses
* il aurait fallu au moins 4 ou 8 scénarios
* pas de notion d'équipe
* 

## The A4 rule

* plein de données ne sont pas nécessaires
* ici au lieu de mettre toutes les données dans le scénario. On va faire des **personas** avec des données pré-enregistrées.

> Ask not what you can insclude in atest
> ask what you can leave out this test.
> 
> ...

## Enough details ?

* ca manque de should
* ce n'est pas un exemple, c'est la règle
* ce n'est pas du tout factuel. 
* c'est quoi la propriété? combien j'ai

> Un Exemple : pour l'implémenter, le développeur ne doit pas avoir à faire de choix

Si on a des données.
Les données peuvent être challengées.
On peut mettre un **automation check**. De temps en temps modifier le test à la main pour vérifier si l'automatisation foire.

## Real world Home loan example

Un bon exemple

Description de persona

Exemple de surcharge de persona

## Real example medicale care

pas bon exemple. On ne devrait rien choisir en tant que dev.

* alarm thresshold devrait etre da&ns le given. c'est du contexte
* "is greater than" : on devrait donner une valeur. "Atteint 38°"
* PascaleCase technical detail
* Then : on vérifie que le message a bien été envoyé au médecin

## Declaratif - impératif


Déclaratif : pas assez de détails
Impératif : trop de détails

```
Declaratif  =============== | ============= Impératif
(pas assez                                  (trop de
de détails)                                  détails)
```

Assez détaillé pour que le développeur n'ait pas de choix à faire.

## BDD - Sur comment le vendre

Pourquoi mettre du BDD?
Il faut partir des problèmes
* culture du blame?
* features pas utilisées? pas pertinentes
* Les fonctionalités sont mal comprises par les développeurs ou les testeurs et il en résulte des bugs fonctionnels
* Il n'est pas aisé de challenger le quoi vis à vis de l'expert métier
* TODO : identifier les problèmes d'organisation sur les projets
* Mesurer la **fréquence de rework** : est ce qu'on passe du temps à refaire des choses qu'on avait deja fait?
  * en prod
  * au moment de la démo
  * ...

Conditions pour que BBD soit pertinent
* avoir un coeur de métier suffisemment conséquent

Arguments Mesurer : 
* fréquence de rework : est ce qu'on passe du temps à refaire des choses qu'on avait deja fait?
  * truc oublié
  * truc mal compris 
* nombre de relivraisons
* nombre de bugs fonctionnels qui reviennent
* 

Ce que BDD apporte
* il faut qu'on se comprendre entre les différents persones
* ca peut aider à être un peu plus implicite sur les tests
* TODO : reprendre les différents arguments qu'on a vu dans la journée




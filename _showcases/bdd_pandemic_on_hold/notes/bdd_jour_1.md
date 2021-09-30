# Notes BDD training

Le plus important dans BDD c'est avoir des conversations.

## Constat d'un problème

> Trop souvent on met trop en avant l'aspect technique.


* Le bon - le dev
* Le moche (la brute) - le testeur
* Le mauvais (le truand) - le client

Bug : rejet du blame de l'un vers l'autre.

=> culture du blame

On va essayer de faire le lien entre ces 3 acteurs. Faire en sort qu'ils aient tous le même objectif.

> Ces 3 acteurs vont dans la même direction. Faire le meilleur produit possible.

BDD aide à ça.

## BDD et agile

> Privilégier les individus et leurs interactions plutôt que les outils et process

Avoir des conversations plutôt que privilégier cucumber...

ex. quand on explique un jeu de cartes
> no va faire un tour pour rien

ex. la FAC - et comme on s'est construit depuis tout petit

Cours magistral => on comprend comme on peut
Les exos => on intenalise les connaissances, par l'exemple d'application

ex. en entreprise - mode de fonctionnement surprenant

On te donne une spec => on se débrouille avec... :-(

## S'aligner sur la compréhension

> Partager un document ce n'est pas partage sa compréhension

La compréhension peut être déformée depuis la spec vers ce qui va en prod.

L'exact inverse arrive également. Ex. mauvaise maitrise de la langue


## Règles et exemples

Toutes les soumissions des mots de passe sont des exemples. Il est difficile de retrouver les règles à partir des exemples.

> /!\ les exemples ne remplaçent pas la règle !!!

## Conversations conversations conversations!!!

> *Having* conversations is more important than
> *capturing* conversations is more important than
> *automatic* conversations
> 
> Liz Keogh

## Astuces pour les conversations

Focus sur le quoi. Pas sur le comment (pas pendant ces réunions)

* Why => 5 whys rules => root cause
  * ne pas le faire systematiquement - peut être utilisé de temps en temps
* What/Intent => ce qu'on doit produire pour la personne. On ne peut pas questionner directement le what.

Le why est le levier pour atteindre le what

Illustration des 5 whys: histoire de la détérioration de la stature de Lincoln.
* Produits hyoer violenbts pour la nettoyer
* seuls produits efficaces contr les fiantes d'oiseuax
* fiantes sur cette statue
* araignées vers la statue et les oiseaux les mangents
* les araignes mangent des larves de mites
* mites ont 1 heure dans la journée pour pondre - c'est l'heure d'allumage de la statue

Décalage de l'heure d'allumage => plus de pb



> Dude's law : value = why / how
## Behavior - GIVEN WHEN THEN

> Behavior = context + action + outcome

Contexte, action , observation d'un résultat

```
Given a context                         Setup/arrange
When an event happens                   Exercice/act
Then an outcome should be observed      Verify/assert
```

conditionnel => créer le doute
Légitimer le **challenge**. Pouvoir poser des questions à l'expert métier.

Le noob est très utile car il pose les questions naives. Et si ces questions ne sont pas posées c'est des bugs. **Poser ces questions naives en tant que faciliateur**. "Admettons que je ne sache pas, qu'est ce que c'est ******? Il y a peut-être quelqu'un qui ne connait pas dans la salle" 

Très bon exercice pour les onboarding (avec les nouveaux)

Le **when** c'est a peu pres le sujet du scénario.


## Scenarion analysis

> !! **Le plus utile de cette formation**


Des exemples et on va dire ce qu'on en pense



```
  Scenario : A visitor can add an item to the basket
  Given I am viewing a product "product/id1"
  When I click "#addNowButton"
  Then I should see "Items added to basket"
```

* scenarios avec des éléments techniques
* valeur en dur
* le clic est un détail d'implementation (clic = appli web"
* "Items added to basket" = ne correspond pas au titre. A la limite changer le titre pour A visitor is notified ...
* Avoir des wordings pas toujours pratique. Multilingue? Cms externalisé?
* Un visiteur? authentifié? anonyme?...

Un scénario métier le rend portable. Tout le monde peut le comprendre. On va pouvoir poser des questions.

```
  In order to ease buying
  As a visitor
  I want to be able to add item to my basket

  Scenario : A non authenticated visitor can add item to its basket
  Given I was not yet authenticated
  And I had no item in my basket
  And I was looking at the book "Living Documentation"
  When I add the book in my basket
  Then my basket should contain de book "Living Documentation"

```
Qu'est-ce qui peut faire que ca peut échouer?
* plus de stock? => voir ce qu'on fait avec le métier
* si c'est un ebook?
* Si le livre est deja dans le panier
* si c'est la 2eme fois que je visite le site anonymement
* ...


### Personas

Personne type. Ce sont des donées de test pour simplifier.

* peut factoriser certaines données.Ex. du code de test relatif au personna (adresse, ...)


> If it **isn't essential** to conveying the essence of the behavior, it is essential to **not include it**
>
> Gerard Meszaros

##

Warning !! ce n'est pas grave si on a plusieurs phrases qui veulent dire la même chose. Ne pas mettre trop d'énéergie pour rationaliser tout ca.


```
                can become
  Examples ----------
      \             \---> TESTS
        \                  /   / 
 clarify \                / verify
          \>             /         
           REQUIREMENTS </    
                          

```

## Personas

* Attention à ne pas créer de personas/standards
* Faire en sorte de pouvoir surcharger les personas

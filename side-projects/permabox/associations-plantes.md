## Concept

Système permettant de connaître la qualité des associations de plantes sur un plan. Prenant en compte les associations de plantes et leur distance.

Mettre en place une carte de ce qu'on plante. Avec certains emplacements figés. Le reste des emplacements peut être deviné par le système a l'aide d'un algorithme. Le système peut proposer des emplacements optimums ou moins optimums. Le système peut connaitre certains patterns de plantation (milpa, butte, lasagne ...)

Fonctionnalité principale :
* positionner des noeuds sur une carte sur une échelle de plusieurs mètres
* à partir d'un graphe de plantes (coordonnées géographine = variété) score pour chaque noeud (plante) en fonction de l'association de plante avec les plantes à proximité.


Plus tard, 
* detection de patterns (milpa ...)
* Génération automatique de plan de semis à partir des données du plan
* prise en compte de la précédence de cultures ou de jachère. 
* prise en compte de la nature du sol.
* prise en compte des points d'eau
* associations via arbres et champignons
* prise en compte de l'ombrage
* représentation visuelle 2D sur un canvas
* représentation 3D
* simulation de pousse et de récolte
* simulation de nuisibles ou de sécechesse trop de gel ou d'inondation
* suivi des semis dans le temps et alertes indiquant quand semer et récolter

## MVP
Pas de MVP à priori car aucun client potentiel.
A moins de tenter de le mettre en place sur une petite parcelle proche.

## Technos possibles

### Cartographie

Pouvoir cartographier dans un espace de la planete ou en sandboxé sur des surfaces allant de quelques metres carrés à plusieurs centaines de m carrés.

* GeoJson
* PostGIS






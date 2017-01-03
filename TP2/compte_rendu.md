Compte rendu TP2 : Tortue
=========================

1.1 : Objectif 1
----------------

### 1.1.1 Question 1
**1.**
La second solution va déplacer la tortue jusqu'au bord de l'écran si jamais il fait un déplacement qui allait le faire sortir. La troisième solution ne va quand à elle pas faire de déplacement car va le considérer comme invalide.

La deuxième solution implique que le service ne va remplir son contrat car ne va pas déplacer la tortue comme il devait le faire. A l'opposé,  la troisème solution implique que c'est l'utilisateur qui ne remplit pas son contrat et donc le programme va lever une exception.

**2.**
On pourrait envisager un thor. Dans le cas ou la tortue sort de l'écran, on la fait réapparaitre de l'autre coté.

**3.**
En utilisant les fonctions getWidth et getHeight, il est possible de d'assurer que les coordonnées en X et Y de la tortue sont bien comprises dans l'espace affiché.


----------------


### 1.1.2 Question 2

**1.**
On a définit l'invariant visible. Cet invariant est vérifié si la fonction visible retourne true. On a aussi défini la fonction testInvariants qui retourne des exceptions si les invariants de la classes ne sont pas vérifiés.


**2.**
Cette fonction est appelé à la fin des fonctions avancer et reculer.


----------------


### 1.1.3 Question 3
**1.**
La responsabilité porte sur le client. En effet, l'utilisateur ne devrait pas essayer de sortir la tortue de l'espace visible.

**2.**
Dans le cas ou la version 3 serait implémenté, la responsabilité porterait sur le service. En effet, selon les spécifications, le service devrait alors empécher les mouvements qui ne sont pas possible.

**3.**
Utiliser les types Invariant, Require, Ensure, permettent de pouvoir lever des exceptions et de les "catcher" avec plus de précisions. En effet, il sera alors possible de faire plusieurs catchs permettant de gérer les comportements anormaux.

**4.**
Require car c'est une erreur sur "l'entreé". Le problème vient du fait que le déplacement demandé (donnée en paramètre) n'est pas possible.

**5.**
Pour tester que le mouvement est possible, on crée un point temporaire, comme une copie du point actuel et on le déplace. Tester si le déplacement de la tortue est possible est donc presque aussi couteux que le déplacement lui même. Il y a donc un coup à l'éxécution non négligeable.


----------------


### 1.1.4 Question 4
**1.**
La fonction calculVecteurReel va calculer le vecteur permettant le plus grand déplacement possible d'un point donnée dans une direction donnée sans sortir de la fenêtre. Elle va retourner le vecteur décrivant ce déplacement.

La fonction a donc le prototype suivant :
```java
/**
 * Calcul du vecteur de déplacement maximum sans sortir de la fenêtre
 * @param aVecteur : direction du déplacement
 * @return Vecteur de déplacement maximum
 */
private Vecteur calculVecteurReel(Vecteur aVecteur)
```

**2.**
Pour calculer le vecteur de déplacement réel, on a besoin de connaitre la position de la tortue. La méthode calculVecteurReel doit donc se trouver dans la classe Tortue.

**3.**
**4.**
Dans la classe TurtleTrip, on a rajouté la gestion des exceptions "Require" et et "Invariant" lors du click sur les boutons Avancer et Reculer. Dans le cas ou l'exception Require est levé, alors on effectue un déplacement avant la fonction avancerMax ou reculerMax. Ces fonctions vont calculer le vecteur réel de déplacement et l'appliquer.



----------------

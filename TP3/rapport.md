Compte rendu TP3 : ANNUAIRE
===========================

Brought to you by Aymeric VIAL-GRELIER & Rémi GATTAZ

1ère partie : Elaboration de classes
-------------------------------------
### 1. Réalisation de la classe Personne
### 2. Réalisation de la classe Numeros
Les numéros sont stockés dans une attribut de la classe Numéros qui est un objet ```List```. De ce fait, remplacer ```ArrayList``` par ```Linkedlist``` se résume à changer le constructeur. Il s'agit de Polymorphisme.

Etant donnée que nous nous n'essayons jamais d'accéder à un élément selon un indice, l'utilisation d'une ```ArrayList``` ne se justifie pas par rapport à une ```LinkedList```.

2ème Partie : Modélisation de l’application Annuaire
-----------------------------------------------------

### 3. Spécification de la classe Annuaire
### 4. Scénario 1 : Réalisation d’une version de la classe Annuaire
### 5. Scénario 2 : Réalisation d’une version de la classe Annuaire
Nous avons encore utilisé le polymorphisme pour l'implémentation de cette classe. Remplacer la ```HashMap``` par une ```TreeMap``` se résume donc encore à modifier le constructeur.



### 6. Scénario 3 : Compléter la classe annuaire
Le TreeMap est un arbre rouge noir. Il est donc trié. Si on utilise la fonction ```headMap``` de ```TreeMap```. En utilisant cela, il est possible de retrouver rapidement le premier élement satisfaisant notre condition (car elle est directement lié au tri) et de parcourir tant que notre condition est vérifiée.

Pour pouvoir faire cela, il a fallu implémenter la classe ```Comparable<Personne>``` dans la classe ```Personne```. De ce fait, il a fallu implémenter la fonction ```compareTo```.

### 7. Scénario 4 : Adaptation d’une solution

Pour éviter les doublons, on a créé dans ```Annuaire``` une nouvelle fonction addEntry qui prend en paramètre une ```Personne``` et un ```Numeros```.

```java
/**
 * Ajoute une nouvelle entrée dans l'annuaire. Si la Personne n'existe pas: on crée une nouvelle
 * entrée dans l'annuaire ; sinon : on ajoute les numéros dans aNumeros à la Personne
 * @param aPersonne Personne
 * @param aNumeros Numéros à lier
 */
public void addEntry(Personne aPersonne, Numeros aNumeros){
    Numeros wNumeros = this.pAnnuaire.get(aPersonne);
    if(wNumeros == null){
        this.pAnnuaire.put(aPersonne, aNumeros);
    }else{
        Numeros wNewNumeros = new Numeros(wNumeros);
        wNewNumeros.merge(aNumeros);
        this.pAnnuaire.replace(aPersonne, wNumeros, wNewNumeros);
    }
}
```

Dans ```Numeros```, une fonction ```merge```a été rajouté.
```java
/**
 * Effectue la fusion entre la liste de numéros de cet objet et celle donnée en paramètre
 * @param aNumeros
 */
public void merge(Numeros aNumeros){
    for(String wNumero : aNumeros.pNumeros){
        this.add(wNumero);
    }
}
```

Enfin, la fonction ```add``` a été modifié pour que le numéro à rajouter dans la liste ne soit rajouts que si il ne s'y trouve pas déja.

```java
/**
 * ajoute un numéro à la liste
 * @param aNumero numéro à rajouter
 */
public void add(String aNumero){
    if(!has(aNumero)) {
        this.pNumeros.add(aNumero);
    }
}
```

package jus.aoo.annuaire;

import jus.util.assertion.Require;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
//import java.util.ArrayList;

/**
 * Created by gattazr on 11/02/15.
 * @invariant non_vide : count() > 0
 */
public class Numeros {

	private List<String> pNumeros;

	/**
	 * Constructeur d'une liste à un seul numéro
	 * @param aNumero numéro
	 */
	public Numeros(String aNumero){
		this.pNumeros = new LinkedList<String>();
		//pNumeros = new ArrayList<String>();
		this.add(aNumero);
	}

	/**
	 * Création d'un objet numéro comme étant la copie de celui passé en paramètre
	 * @param aNumeros Numéros à copier
	 */
	public Numeros(Numeros aNumeros){
		this.pNumeros = new LinkedList<String>();

		for(String wNumero : aNumeros.pNumeros){
			this.add(wNumero);
		}
	}

	/**
	 * Ajoute un numéro à la liste
	 * @param aNumero numéro à rajouter
	 */
	public void add(String aNumero){
		if(!has(aNumero)) {
			this.pNumeros.add(aNumero);
		}
	}

	/**
	 * Enlève le numéro donné de la liste.
	 * @param aNumero numéro a retirer
	 * @require: count() > 1
	 */
	public void remove(String aNumero){
		// on teste que si le numéro est présent avant le test de l'assertion @require.
		// Ceci afin de lever l'exception uniquement si on essaye de supprimer le dernier numéro
		if(has(aNumero)){
			if(!(count() > 1)) throw new Require("Impossible de supprimer le seul numéro restant");
			this.pNumeros.remove(aNumero);
		}
	}

	/**
	 * @return le premier numéro de la liste (il existe forcément)
	 */
	public String numero(){
		return this.pNumeros.get(0);
	}

	/**
	 * @return true si la liste contient le numéro donné. False sinon
	 */
	public boolean has(String aNumero){
		return this.pNumeros.contains(aNumero);
	}

	/**
	 * retourne le nombre de numéros de la liste (>=1)
	 * @ensure cont() >=1
	 */
	public int count(){
		return pNumeros.size();
	}

	/**
	 * effectue la fusion entre la liste de numéros de cet objet et celle donnée en paramètre
	 * @param aNumeros
	 */
	public void merge(Numeros aNumeros){
		for(String wNumero : aNumeros.pNumeros){
			this.add(wNumero);
		}
	}

	/**
	 * retourne la séquence des numéros séparés par des virgules dans une chaîne
	 */
	@Override
	public String toString(){
		StringBuilder wString = new StringBuilder();
		Iterator<String> aIterator = this.pNumeros.iterator();

		// Il y a forcément au moin 1 élément (invariant)
		wString.append(aIterator.next());

		while(aIterator.hasNext()){
			wString.append("," + aIterator.next());
		}

		return wString.toString();
	}

	/**
	 * Programme principal de tests des numéros
	 * @param aArgs
	 */
	public static void main(String [] aArgs){

		System.out.println("Création du numéro avec le numéro 476565432");
		Numeros wNumeros = new Numeros("476565432");
		System.out.println("premier: " + wNumeros.numero());
		System.out.println("tous   : " +wNumeros.toString()+"\n");

		System.out.println("Ajout du numéro 677543678");
		wNumeros.add("677543678");
		System.out.println("premier: " + wNumeros.numero());
		System.out.println("tous   : " +wNumeros.toString()+"\n");

		System.out.println("Suppréssion du numéro 677543678");
		try{
			wNumeros.remove("677543678");
			System.out.println("premier: " + wNumeros.numero());
			System.out.println("tous   : " +wNumeros.toString()+"\n");
		}catch(Require aRequire){
			System.out.println("Erreur non prévue.");
		}

		try{
			System.out.println("Suppréssion du numéro 476565432");
			wNumeros.remove("476565432");
			System.out.println("premier: " + wNumeros.numero());
			System.out.println("tous   : " +wNumeros.toString()+"\n");
		}catch(Require aRequire){
			System.out.println("Erreur prévue. Impossible de supprimer le dernier numéro");
		}
	}
}

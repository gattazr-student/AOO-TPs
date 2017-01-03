package jus.aoo.annuaire;

import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.SortedMap;
import jus.util.assertion.Require;

/**
 * notion d'annuaire : ensemble d'associations Personne-Numero
 * Created by gattazr on 11/02/15.
 */
public class Annuaire {

	private Map<Personne, Numeros> pAnnuaire;

	/**
	 * constructeur d'annuaire vide
	 */
	public Annuaire(){
		// aucune différence puisque on utilise uniquement les fonctions de Map et que les deux classes héritent de Map.
		//pAnnuaire = new HashMap<Personne, Numeros>();
		pAnnuaire = new TreeMap<Personne, Numeros>();
	}

	/**
	 * Ajoute une nouvelle entrée dans l'annuaire. Si la Personne n'existe pas: on crée une nouvelle
	 * entrée dans l'annuaire ; sinon : on ajoute le numéro à la Personne
	 * Correspondance interface: BOUTON Ajouter
	 * @param aPersonne
	 * @param aNumero
	 */
	public void addEntry(Personne aPersonne, String aNumero){
		Numeros wNumeros = this.pAnnuaire.get(aPersonne);
		if(wNumeros == null){
			this.pAnnuaire.put(aPersonne, new Numeros(aNumero));
		}else{
			Numeros wNewNumeros = new Numeros(wNumeros);
			wNewNumeros.add(aNumero);
			this.pAnnuaire.replace(aPersonne, wNumeros, wNewNumeros);
		}
	}

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

	/**
	 * Chargement de l'annuaire depuis un fichier texte (le contenu de l'annuaire est remplacé)
	 * chaque ligne du fichier est de la forme :
	 * Civilite Nom Prenom "Numero1" "Numero2" .... <CR> (Civilite = Mr ou Mme ou Melle)
	 * Correspondance interface: BOUTON Charger
	 * @param aFile
	 */
	public void loadEntryFromFile(String aFile){
		pAnnuaire.clear();

		// assure que la Map dans this.pAnnuaire est bien du type de l'initialisation et pas celui dans importFromFile.
		Map<Personne, Numeros> wEntries = Util.importFromFile(aFile);
		for (Map.Entry<Personne, Numeros> wEntry : wEntries.entrySet()){
			this.pAnnuaire.put(wEntry.getKey(), wEntry.getValue());
		}
	}

	/**
	 * ajout des entrées contenues dans un fichier texte chaque ligne du fichier est de la forme :
	 * Civilite Nom Prenom "Numero1" "Numero2" ....
	 * Correspondance interface: BOUTON Importer
	 */
	public void addEntryFromFile(String aFile){
		Map<Personne, Numeros> wEntries = Util.importFromFile(aFile);
		for (Map.Entry<Personne, Numeros> wEntry : wEntries.entrySet()){
			addEntry(wEntry.getKey(), wEntry.getValue());
		}
	}

	/**
	 * retourne le premier numéro de la personne, si la personne est absente retourne null
	 * Correspondance interface: BOUTON Numéro
	 * @param aPersonne
	 */
	public String getNumber(Personne aPersonne){
		Numeros wNumbers = this.pAnnuaire.get(aPersonne);
		if(wNumbers != null){
			return wNumbers.numero();
		}else {
			return null;
		}
	}

	/**
	 * retourne les numéros de la personne, si la personne est absente retourne null
	 * Correspondance interface: BOUTON Numéros
	 * @param aPersonne
	 */
	public String getNumbers(Personne aPersonne){
		Numeros wNumbers = this.pAnnuaire.get(aPersonne);
		if(wNumbers != null){
			return wNumbers.toString();
		}else {
			return null;
		}
	}

	/**
	 * retourne la première personne ayant le numero donné, null si aucune personne
	 * Correspondance interface: BOUTON Personne
	 * @param aNumber
	 * @return La première personne associé à ce numéro. null sinon
	 */
	public Personne annuInverse(String aNumber){
		for (Map.Entry<Personne, Numeros> wEntry : this.pAnnuaire.entrySet()){
			if (wEntry.getValue().equals(aNumber)){
				return wEntry.getKey();
			}
		}
		return null;
	}

	/**
	 * supprime la personne de l'annuaire, si elle est présente
	 * Correspondance interface: BOUTON Supprimer (si le champ "numero" est vide)
	 * @param aPersonne
	 */
	public void remove(Personne aPersonne){
		this.pAnnuaire.remove(aPersonne);
	}

	/**
	 * supprime le numero donné de la personne, s'il n'y a plus qu'un numéro dans la liste supprime la personne
	 * Correspondance interface: BOUTON Supprimer (si le champ "numero" est rempli)
	 * @param aPersonne
	 * @param aNumber
	 */
	public void remove(Personne aPersonne,String aNumber){
		Numeros wNumeros = this.pAnnuaire.get(aPersonne);
		try{
			wNumeros.remove(aNumber);
		}catch(Require aExRequire){
			// La personne n'avait qu'un seul numéro
			remove(aPersonne);
		}
	}

	/**
	 * retourne l'intégralité de l'annuaire dans un ordre quelconque : une personne par ligne
	 * suivie de ses numéros de téléphone
	 * Correspondance interface: BOUTON Print Répertoire
	 */
	public String toString(){
		StringBuilder wString = new StringBuilder();

		for (Map.Entry<Personne, Numeros> wEntry : this.pAnnuaire.entrySet()){
			wString.append(String.format("%s %s\n", wEntry.getKey().toString(), wEntry.getValue().toString()));
		}
		return wString.toString();
	}

	/**
	 * retourne la liste des personnes dont le nom commence par la lettre donnée (minuscule ou majuscule)
	 * (une personne par ligne, avec ses numéros)
	 */
	public String toString(char aChar){
		StringBuilder wString = new StringBuilder();

		// Si pAnnuaire est une TreeMap
		if (this.pAnnuaire instanceof TreeMap){
			TreeMap<Personne, Numeros> wTreeMap = (TreeMap)this.pAnnuaire;
			SortedMap<Personne, Numeros> wMap = wTreeMap.headMap(new Personne("c", "Inconnu"));
			for (Map.Entry<Personne, Numeros> wEntry : wMap.entrySet()){
				// quand on a parcouru trop loin
				if(!wEntry.getKey().startsWith(aChar)){
					break;
				}
				wString.append(String.format("%s %s\n", wEntry.getKey().toString(), wEntry.getValue().toString()));
			}
		}else{
			// Sinon
			for (Map.Entry<Personne, Numeros> wEntry : this.pAnnuaire.entrySet()){
				if(wEntry.getKey().startsWith(aChar)){
					wString.append(String.format("%s %s\n", wEntry.getKey().toString(), wEntry.getValue().toString()));
				}
			}
		}

		return wString.toString();
	}

	/**
	 * Programme de tests de l'annuaire
	 * @param aArgs
	 */
	public static void main(String [] aArgs){
		System.out.println("Bonjour :-)");
		File wFileAnnuaire = new File("res/annuaire.txt");

		boolean wExists = wFileAnnuaire.exists();

		System.out.println(String.format("Le fichier %s existe ? -> %b\n", wFileAnnuaire.getPath(), wExists));
		if(wExists){
			Annuaire wAnnuaire = new Annuaire();
			wAnnuaire.loadEntryFromFile(wFileAnnuaire.getPath());
			System.out.println(wAnnuaire.toString() + "\n");
			System.out.println(wAnnuaire.toString('b'));

			File wFileAnnuaire2 = new File("res/annuaire2.txt");
			boolean wExists2 = wFileAnnuaire.exists();
			System.out.println(String.format("Le fichier %s existe ? -> %b\n", wFileAnnuaire2.getPath(), wExists2));

			if(wExists2){
				wAnnuaire.addEntryFromFile(wFileAnnuaire2.getPath());
				System.out.println(wAnnuaire.toString() + "\n");
			}
		}
	}
}

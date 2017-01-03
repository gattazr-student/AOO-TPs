
package jus.aoo.annuaire;

import jus.util.assertion.Require;

/**
 * Created by gattazr on 11/02/15.
 * @invariant not_empty: getNom() != "" && getPrenom() != ""
 */
public class Personne implements Comparable<Personne> {

	private Civilite pCivilite; //civilité
	private String pNom; // nom
	private String pPrenom; // prénom

	/**
	 *
	 * @param aNom nom de la personne
	 * @param aPrenom prénom de la personne
	 */
	public Personne(String aNom, String aPrenom){
		setNom(aNom);
		setPrenom(aPrenom);
		setCivilite(new Civilite(Civilite.Civ.INCONNU));
	}

	/**
	 *
	 * @param aCivilite civilité de la personne (0 -> INCONNU, 1 -> MELLE, 2 - >MME, 3 -> MR)
	 * @param aNom nom de la personne
	 * @param aPrenom prénom de la personne
	 */
	public Personne(int aCivilite, String aNom, String aPrenom){
		setNom(aNom);
		setPrenom(aPrenom);
		setCivilite(new Civilite(aCivilite));
	}

	/**
	 *
	 * @return civilité de la Personne
	 */
	public Civilite getCivilite(){
		return this.pCivilite;
	}

	/**
	 *
	 * @param aCivilite civilité de la Personne
	 */
	public void setCivilite(Civilite aCivilite){
		this.pCivilite = aCivilite;
	}

	/**
	 *
	 * @return nom de la Personne
	 */
	public String getNom(){
		return new String(this.pNom);
	}

	/**
	 *
	 * @require name_not_empty : !aNom.equals("")
	 * @param aNom nom de la Personne
	 */
	public void setNom(String aNom){
		if(aNom.equals("")) throw new Require("Le nom ne doit pas être vide");
		this.pNom = new String(aNom);
	}

	/**
	 *
	 * @return prénom de la Personne
	 */
	public String getPrenom(){
		return new String(this.pPrenom);
	}

	/**
	 * @require name_not_empty : !aNom.equals("")
	 * @param aPrenom prénom de la Personne
	 */
	public void setPrenom(String aPrenom){
		if(aPrenom.equals("")) throw new Require("Le prénom ne doit pas être vide");
		this.pPrenom = new String(aPrenom);
	}

	/**
	 * @param aChar Initiale à tester
	 * @return vrai si le nom de famille de la personne commence par le charactère donnée
	 */
	public boolean startsWith(char aChar){
		return Character.toLowerCase(this.getNom().charAt(0)) == Character.toLowerCase(aChar);
	}

	/**
	 * Compare la Personne avec la Personne passé en paramètre. Deux personnes sont considérer comme équivalentes si
	 * elles ont le même nom et le même prénom.
	 * @require not_null : aPersonne != null
	 * @param aPersonne Objet de type Personne avec qui comparer la Personne courante
	 * @return vrai si la Personne passé en paramètre est équivalente à la Personne courante
	 */
	@Override
	public boolean equals(Object aPersonne) {
		if( aPersonne == null ) throw new Require("L'objet Personne avec qui comparer doit être définie");
		// Vérifie que aPersonne est bien du type Personne
		if (aPersonne instanceof Personne) {
			Personne wPersonne = (Personne) aPersonne;
			return wPersonne.getNom().equals(this.getNom()) && wPersonne.getPrenom().equals(this.getPrenom());
		}
		return false;
	}


	@Override
	public int hashCode(){
		return this.pNom.hashCode() + this.pPrenom.hashCode();
	}

	@Override
	public String toString(){
		return String.format("%s %s %s", this.getCivilite().toString(), this.getNom(), this.getPrenom());
	}

	@Override
	public int compareTo(Personne aPersonne) {
		int wValue;

		wValue = this.getNom().compareTo(aPersonne.getNom());
		if(wValue == 0){
			wValue = this.getPrenom().compareTo(aPersonne.getPrenom());
		}
		return wValue;
	}

}

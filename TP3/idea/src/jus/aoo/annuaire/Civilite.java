package jus.aoo.annuaire;

import jus.util.assertion.Require;

/**
 *
 * @invariant valide: 	getCivilite() == INCONNU && getCivilite() == MELLE &&
 *		 				getCivilite() == MME  && getCivilite() == MR
 *
 * L'invariant est vérifé gràce à l'énumération
 * Created by gattazr on 12/02/15.
 */
public class Civilite {

	public static enum Civ {
		INCONNU,
		MELLE,
		MME,
		MR;
	}

	private Civ pCivilite;

	/**
	 *
	 * @param aCivilite la civilité
	 */
	public Civilite(Civ aCivilite){
		this.pCivilite = aCivilite;
	}

	/**
	 * @require civilite: aCivilite >= 1 && aCivilite <= 3
	 * @param aCivilite la civilité
	 */
	public Civilite(int aCivilite){
		if (! (aCivilite >= 1 && aCivilite <= 3)) throw new Require("civilite_incorrect");

		switch (aCivilite){
			case 0:
				this.pCivilite = Civ.INCONNU;
				break;
			case 1:
				this.pCivilite = Civ.MELLE;
				break;
			case 2:
				this.pCivilite = Civ.MME;
				break;
			case 3:
				this.pCivilite = Civ.MR;
				break;
		}
	}

	/**
	 *
	 * @return la civilité
	 */
	public Civ getCivilite(){
		return this.pCivilite;
	}

	/**
	 * Retourne une String correspondant à la Civilité de la Personne
	 * @return String correspondant à la Civilité
	 */
	@Override
	public String toString(){
		switch (this.getCivilite()){
			case MELLE:
				return new String("Mademoiselle");
			case MME:
				return new String("Madame");
			case MR:
				return new String("Monsieur");
			default:
				return new String("Monsieur ou Madame");
		}
	}
}

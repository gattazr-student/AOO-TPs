package jus.aoo.tri;

import java.util.Comparator;

/**
 * Created by gattazr on 14/03/15.
 */
public abstract class TriMaximum extends Tri {


	@Override
	protected final <T> T[] sort(T[] aTab, Comparator<T> aComparator) {
		if(aTab.length > 1) {
			init(aTab, aComparator); // initilise si besoin les données avant le début du tri

			for(int wEnd = aTab.length-1; wEnd > 0 ; wEnd--){
				step(aTab, aComparator, wEnd); // effectue une opération du tri
			}
		}
		return aTab;
	}

	/**
	 * init
	 * Etape d'intiliasitation du tableau aTav avant le début du tri
	 * @param aTab Tableau à initialiser
	 * @param aComparator outil de comparaison
	 */
	public abstract <T> void init(T[] aTab, Comparator<T> aComparator);

	/**
	 * step
	 * Effectue une pas dans le tri
	 * @param aTab Tableau à trier
	 * @param aComparator outil de comparaison
	 * @param aEndUnsorted Indice du dernier élément non trié
	 */
	public abstract <T>void step(T[] aTab, Comparator<T> aComparator, int aEndUnsorted);

}

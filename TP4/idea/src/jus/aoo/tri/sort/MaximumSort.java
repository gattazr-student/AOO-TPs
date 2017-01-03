package jus.aoo.tri.sort;

import java.util.Comparator;
import jus.aoo.tri.TriMaximum;

/**
 * Created by gattazr on 04/03/15.
 */
public class MaximumSort extends TriMaximum {

	@Override
	public <T> void init(T[] aTab, Comparator<T> aComparator) {
		// Nothing to do
	}

	@Override
	public <T> void step(T[] aTab, Comparator<T> aComparator, int aEndUnsorted) {
		int wIndiceMax = getIndiceMax(aTab, aComparator, aEndUnsorted); // Rechercher de l'indice du maximum
		swap(aTab, wIndiceMax, aEndUnsorted); // on echange le courant et le maximum
	}

	/**
	 * Récupère l'indice du maximum dans le tableau entre les indices à et l'indice aIndiceMax compris.
	 * @param aTab Tableau d'objets à trier
	 * @param aComparator Comparateur entre deux object de type T
	 * @param aIndiceMax indice maximum que peut avoir le maximum dans le tableau
	 * @param <T>
	 * @return indice du max compris entre les indices 0 et aIndiceMax
	 */
	private <T> int getIndiceMax(T[] aTab, Comparator<T> aComparator, int aIndiceMax){
		int wI;
		int wIMax = 0;

		for(wI=1; wI <= aIndiceMax; wI++){
			if(aComparator.compare(aTab[wI], aTab[wIMax]) > 0){
				wIMax = wI;
			}
		}

		return wIMax;
	}

}

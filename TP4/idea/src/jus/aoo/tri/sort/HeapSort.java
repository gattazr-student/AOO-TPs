package jus.aoo.tri.sort;

import java.util.Comparator;
import jus.aoo.tri.TriMaximum;

/**
 * Created by gattazr on 05/03/15.
 */
public class HeapSort extends TriMaximum {

	@Override
	public <T> void init(T[] aTab, Comparator<T> aComparator) {
		constHeap(aTab, 1, aTab.length, aComparator);
	}

	@Override
	public <T> void step(T[] aTab, Comparator<T> aComparator, int aEndUnsorted) {
		swap(aTab, 0, aEndUnsorted);
		fixHeap(aTab, 1, aEndUnsorted, aComparator);
	}

	private int getGauche(int aRacine) {
		return aRacine * 2;
	}

	private int getDroit(int aRacine){
		return aRacine*2+1;
	}

	private <T> void fixHeap(T[] aTableau, int aRacine, int aEndHeap, Comparator<T> aComparator){
		if (getGauche(aRacine) > aEndHeap){return;}


		if (getDroit(aRacine) > aEndHeap){
			/* Il y a un enfant gauche mais pas d'enfant droit */

			if(aComparator.compare(aTableau[getGauche(aRacine)-1], aTableau[aRacine-1]) > 0){
				/* L'en fant gauche est plus grand que la racine */
				swap(aTableau, getGauche(aRacine)-1, aRacine-1);// Echange racine avec enfant gauche
			}else{
				/* La racine est plus grande ou égale que l'enfant gauche */
				return;
			}
		}else{
			/* Il y a un enfant gauche et un enfant droit */
			if(aComparator.compare(aTableau[aRacine-1], aTableau[getGauche(aRacine)-1]) >= 0
				&& aComparator.compare(aTableau[aRacine-1], aTableau[getDroit(aRacine)-1]) >= 0 ){
				/* La racine est plus grande ou égale que les deux enfants */
				return;
			}
			else if(aComparator.compare(aTableau[aRacine-1], aTableau[getGauche(aRacine)-1]) < 0
					&& aComparator.compare(aTableau[getGauche(aRacine)-1], aTableau[getDroit(aRacine)-1]) >= 0 ){
				/* La racine est inférieure à l'enfant gauche et enfant gauche supérieur ou égale à enfant droit */
				swap(aTableau, getGauche(aRacine)-1, aRacine-1);// Echange racine avec enfant gauche
				fixHeap(aTableau, getGauche(aRacine), aEndHeap, aComparator); // fixHeap sur enfant gauche
			}
			else if(aComparator.compare(aTableau[aRacine-1], aTableau[getDroit(aRacine)-1]) < 0
					&& aComparator.compare(aTableau[getDroit(aRacine)-1], aTableau[getGauche(aRacine)-1]) >= 0 ){
				/* La racine est inférieur à l'enfant droit et enfant droit supérieur à enfant gauche */
				swap(aTableau, getDroit(aRacine)-1, aRacine-1);// Echange racine avec enfant droite
				fixHeap(aTableau, getDroit(aRacine), aEndHeap, aComparator); //fixheap sur enfant droite
			}
		}
	}

	/**
	 *
	 * @param aTableau
	 * @param aRacine
	 * @param aEndHeap
	 * @param aComparator
	 * @param <T>
	 */
	private <T> void constHeap(T[] aTableau, int aRacine, int aEndHeap, Comparator<T> aComparator) {
		if (getGauche(aRacine) > aEndHeap) {
			//System.out.println("aRacine = " + aRacine + " -> Pas d'enfant");
			/* La racine n'a pas d'enfant */
			return;
		}else if (getDroit(aRacine) > aEndHeap) {
			//System.out.println("aRacine = " + aRacine + " -> Pas d'enfant droite");
			/* Il y a un enfant gauche mais pas d'enfant droit */
			constHeap(aTableau, getGauche(aRacine), aEndHeap, aComparator);
			fixHeap(aTableau, aRacine, aEndHeap, aComparator);
		}else{
			/* Il y a un enfant gauche et un enfant droit */
			//System.out.println("aRacine = " + aRacine + " -> Deux enfants");
			constHeap(aTableau, getGauche(aRacine), aEndHeap, aComparator);
			constHeap(aTableau, getDroit(aRacine), aEndHeap, aComparator);
			fixHeap(aTableau, aRacine, aEndHeap, aComparator);
		}
	}
}

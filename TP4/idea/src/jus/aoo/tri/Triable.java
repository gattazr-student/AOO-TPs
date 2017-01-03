package jus.aoo.tri;
import java.util.Comparator ;

public interface Triable <T> {

	/**
	 * générateur aléatoire d'un élément du type
	 * @return une valeur d'un type
	 */
	public T newInstance();

	/**
	 * restitue l'opérateur de comparaison du Triable
	 * @return un comparator
	 */
	public Comparator<T> comparator();

	/**
	 * restitue la représentation textuelle de la
	 * valeur servant dans la relation d'ordre.
	 * @return une chaine
	 */
	public String toString(T o);

	/**
	 * restitue le nombre d'appels au comparator
	 */
	public long count();

	/**
	 * réinitialise le nombre d'appels au comparator
	 */
	public void resetCount();
}

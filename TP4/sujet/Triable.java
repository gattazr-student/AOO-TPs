package jus.aoo.tri;
import java.util.Comparator ;

public interface Triable {
  /** générateur aléatoire d'un élément du type
   * @return une valeur d'un type
   */
  public Object newInstance();
  /** restitue l'opérateur de comparaison du Triable
   * @return un comparator
   */
  public Comparator comparator();
  /** restitue la représentation textuelle de la
   * valeur servant dans la relation d'ordre.
   * @return une chaine
   */
  public String toString(Object o);
	/** restitue le nombre d'appels au comparator
	 */
	public long count();
	/** réinitialise le nombre d'appels au comparator
	 */
	public void resetCount();
}

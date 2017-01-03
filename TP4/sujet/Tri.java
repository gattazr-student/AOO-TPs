package jus.aoo.tri;
import java.util.Comparator;

public abstract class Tri {
    /**le nom du tri*/
    private String name;
    /** Le nombre d'affectations (significatives) engendrées par le tri.*/
    private long count;
    /** le temps CPU mis par le tri.
     * Attention celui-ci peut être profondément altéré par des conditions externes.
     */
    private long time;
    /**  restitue le nom du tri.
     * @return le nom du tri
     */
    public String name(){return name;}
    /** restitue le comptage du nombre d'affectation
     * @return le nombre d'affectation
     */
    public long count(){return count;}
    /** restitue le temps passé pour le tri.
     * @return la durée du tri.
     */
    public long time(){return time;}
    /** renvoie un tableau trié.
     * @param t le tableau à trier
     * @return le tableau trié
     */
    public Object[] trier(Object[] t,Comparator c){
    	count=0;
    	Object[] tab = t.clone();        
    	time=System.nanoTime();
    	Object[] res = sort(tab,c);
    	time=System.nanoTime()-time;
    	return res;        
    }
    /** version assurant le tri selon un algorithme particulier **/
    protected abstract Object[] sort(Object[] t,Comparator c) ;
    /*-----------------------------------------------------------------------------
 	  la suite de méthodes sont utiles pour faire la mise en œuvre de l’algorithme
 	  et assurer le décompte des affectations
 	 -----------------------------------------------------------------------------*/
    /** Effectue un échange de 2 valeurs dans le tableau
     * @param t le tableau de valeurs
     * @param a l'index de la première valeur
     * @param b l'index de la seconde valeur
     */
    protected void swap(Object[] t, int a, int b) {
    	Object[] x = new Object[1] ;
    	copy(t,a,x,0,1); copy(t,b,t,a,1); copy(x,0,t,b,1);
    }
    /** Réalise un décalage circulaire d'une suite contiguë de valeurs d'un tableau.
     * @param t le tableau de valeurs
     * @param start l'index minimum du sous-tableau
     * @param end l'index maximum du soius-tableau
     */ 
    protected void circularSwap(Object[] t, int start, int end){
    	Object[] x = new Object[1] ;
    	copy(t,end,x,0,1);
    	if(start<end)copy(t,start,t,start+1, end-start);
    	else{copy(t,0,t,1,end-1); copy(t,t.length-1,t,0,1); copy(x,0,t,start,1);}
    }
    /** Effectue une copie de sous-tableau.
     * @param src le tableau source
     * @param srcPos la position dans la source
     * @param dest le tableau destination
     * @param destPos la position dans la destination
     * @param length le nombre d'éléments à copier
     */
    protected void copy(Object[] src,int srcPos,Object[] dest,int destPos,int length){
    	System.arraycopy(src,srcPos,dest,destPos,length);
    	count+=length;
    }
    /** Vérifie que le tableau t est trié en ordre croissant.
     * @param t le tableau à vérifier
     * @param c le comparator de la relation d’ordre
     * @return t.length si le tableau est ordonné ou l’indice de violation de l’ordre. 
     */
    protected static int verifier(Object[] t,Comparator c){
    	for(int i=1 ;i<t.length ;i++) if(c.compare(t[i],t[i-1])<0) return i ;
    	return t.length;
    } 
}

package jus.aoo.tri;

/**
 * Created by gattazr on 14/03/15.
 */
public class PointCartesien {

	private double pAbscisse;
	private double pOrdonnee;

	public PointCartesien(){
		setabscisse(0.0);
		setordonnee(0.0);
	}

	public PointCartesien(double x,double y){
		setabscisse(x);
		setordonnee(y);
	}

	public double getAbscisse(){
		return pAbscisse;
	}

	public double getOrdonnee(){
		return pOrdonnee;
	}

	public void setabscisse(double aAbscisse){
		pAbscisse = aAbscisse;

	}

	public void setordonnee(double aOrdonnee){
		pOrdonnee = aOrdonnee;
	}

	public PointCartesien(PointCartesien aPoint){
		this(aPoint.getAbscisse(), aPoint.getOrdonnee());
	}

	public String toString(){
		return "[ " + getAbscisse() + " ," + getOrdonnee() + "]";
	}

	public double distance(){
		return Math.sqrt(pAbscisse*pAbscisse+pOrdonnee*pOrdonnee);
	}
}

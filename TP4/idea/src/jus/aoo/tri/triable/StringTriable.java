package jus.aoo.tri.triable;

import jus.aoo.tri.Triable;
import java.util.Comparator;
//import java.lang.Math;
import java.util.Random;

/**
 * Created by gattazr on 04/03/15.
 */
public class StringTriable implements Triable<String>{

	@Override
	public String newInstance() {
		//return "" + (int)(Math.random()*10000000);
		return "" + new Random().nextInt(10000000);
	}

	@Override
	public Comparator<String> comparator() {
		return String.CASE_INSENSITIVE_ORDER;
	}

	@Override
	public String toString(String aString) {
		return aString;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public void resetCount() {
		// Il n'y a pas encore de compteur, cette methode ne fait donc rien
	}

}

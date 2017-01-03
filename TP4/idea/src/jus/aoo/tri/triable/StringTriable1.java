package jus.aoo.tri.triable;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Comparator;

/**
 * Created by gattazr on 04/03/15.
 */
class StringTriable1$Comparator implements Comparator<String> {

	private long pCount;

	@Override
	public int compare(String aString1, String aString2) {
		int wRes = 0;

		if(aString1.length() == aString2.length()){
			wRes = aString1.compareTo(aString2);
		}
		else if(aString1.length() < aString2.length()){
			wRes = -1;
		}
		else{
			wRes = 1;
		}
		this.pCount++;
		return wRes;
	}

	public long count() {
		return this.pCount;
	}

	public void resetCount(){
		this.pCount = 0;
	}

}

public class StringTriable1 extends StringTriable {

	private StringTriable1$Comparator pComparator;

	public StringTriable1(){
		this.pComparator = new StringTriable1$Comparator();
	}
	/**
	 * restitue l'opérateur de comparaison du Triable
	 * @return un comparator
	 */
	@Override
	public Comparator<String> comparator(){
		return this.pComparator;
	}

	@Override
	public long count() {
		return this.pComparator.count();
	}

	@Override
	public void resetCount() {
		this.pComparator.resetCount();
	}
}





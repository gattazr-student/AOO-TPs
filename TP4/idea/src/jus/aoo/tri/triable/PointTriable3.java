package jus.aoo.tri.triable;

import java.util.Comparator;
import java.util.Random;
import jus.aoo.tri.PointCartesien ;
import jus.aoo.tri.Triable;

/**
 * Created by gattazr on 14/03/15.
 */
public class PointTriable3 implements Triable<PointCartesien> {

	private long pCount;

	@Override
	public PointCartesien newInstance() {
		return new PointCartesien(new Random().nextDouble(), new Random().nextDouble());
	}

	@Override
	public Comparator<PointCartesien> comparator() {
		return new Comparator<PointCartesien>() {
			@Override
			public int compare(PointCartesien aPoint1, PointCartesien aPoint2) {
				pCount++;
				if (aPoint1.distance() < aPoint2.distance()){
					return -1;
				}else if (aPoint1.distance() > aPoint2.distance()) {
					return 1;
				}
				return 0;
			}
		};
	}

	@Override
	public String toString(PointCartesien aPoint) {
		return aPoint.toString();
	}

	@Override
	public long count() {
		return pCount;
	}

	@Override
	public void resetCount() {
		pCount = 0;
	}
}

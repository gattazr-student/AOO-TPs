package jus.aoo.tri.triable;

import java.util.Comparator;
import java.util.Random;
import jus.aoo.tri.PointCartesien;
import jus.aoo.tri.Triable;

/**
 * Created by gattazr on 14/03/15.
 */
public class PointTriable2 implements Triable<PointCartesien> {

	private class PointTriable1$Comparator implements Comparator<PointCartesien>{

		private long pCount;

		@Override
		public int compare(PointCartesien aPoint1, PointCartesien aPoint2) {
			this.pCount++;
			if (aPoint1.getAbscisse() < aPoint2.getAbscisse()){
				return -1;
			} else if (aPoint1.getAbscisse() > aPoint2.getAbscisse()) {
				return 1;
			}
			return 0;
		}

		public long count() {
			return pCount;
		}

		public void resetCount() {
			pCount = 0;
		}
	}

	private PointTriable1$Comparator pComparator = new PointTriable1$Comparator();

	@Override
	public PointCartesien newInstance() {
		return new PointCartesien(new Random().nextDouble(), new Random().nextDouble());
	}

	@Override
	public Comparator<PointCartesien> comparator() {
		return pComparator;
	}

	@Override
	public String toString(PointCartesien aPoint) {
		return aPoint.toString();
	}

	@Override
	public long count() {
		return pComparator.count();
	}

	@Override
	public void resetCount() {
		pComparator.resetCount();
	}

}
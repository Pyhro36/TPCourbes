package curves;

/**
 * Classe de contruction d'une ligne polygonale definie par ces sommets
 * 
 * @author Pierre-Louis
 * @version 1.0
 */

public class APolygonalLine extends AOpenCurve {

	private APoint[] tops;

	/**
	 * Constructeur par defaut d'une ligne polygonale, ligne de 0 points, distance 0
	 */

	public APolygonalLine() {

		this.tops = new APoint[0];
		System.out.println("A polygone has been created");

	}

	public APolygonalLine(APoint[] tops) {

		this.tops = tops.clone();
		System.out.println("A " + this.tops.length + " tops polygone has been created");

	}

	/*
	 * (non-Javadoc)
	 * @see curves.AOpenCurve#length()
	 */

	@Override
	public double length() {

		double length = 0;

		for (int i = 0; i < this.tops.length - 1; i++) {

			length += this.tops[i].distance(this.tops[i + 1]);
		}

		return length;
	}

	/*
	 * (non-Javadoc)
	 * @see curves.AOpenCurve#barycenter()
	 */

	@Override
	public APoint barycenter() {

		int x = 0, y = 0;

		for (int i = 0; i < this.tops.length; i++) {

			x += this.tops[i].getX();
			y += this.tops[i].getY();
		}

		return new APoint((x / this.tops.length), (y / this.tops.length));
	}

	/*
	 * (non-Javadoc)
	 * @see curves.AOpenCurve#distanceExtrem()
	 */

	@Override
	public double distanceExtrem() {

		return this.tops[0].distance(this.tops[this.tops.length - 1]);
	}

	/*
	 * (non-Javadoc)
	 * @see curves.AOpenCurve#isConvexe()
	 */

	@Override
	public boolean isConvexe() {

		return false;
	}

}

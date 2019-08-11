package curves;

/**
 * Classe de definition d'un polygone
 * 
 * @author Pierre-Louis
 * @version 1.0
 */

public class APolygon extends ACloseCurve {

	protected APoint[] tops;

	/**
	 * Constructeur par defaut dun polygone (0 cote)
	 */

	public APolygon() {

		super();

		this.tops = new APoint[0];
		System.out.println("A polygone has been created");

	}

	/**
	 * Constructeur parametre d'un polygone
	 * 
	 * @param tops
	 *            le tableau de points contenant les sommets du polygone
	 */

	public APolygon(APoint[] tops) {

		super();

		this.tops = tops.clone();
		System.out.println("A " + this.tops.length + " tops polygone has been created");

	}

	public double length() {

		double length = 0;

		for (int i = 0; i < this.tops.length - 1; i++) {

			length += this.tops[i].distance(this.tops[i + 1]);
		}

		length += this.tops[this.tops.length - 1].distance(this.tops[0]);
		return length;
	}

	public double area() {

		double area = 0.0;

		for (int i = 0; i < this.tops.length - 1; i++) {

			area += ((this.tops[i].getX() * this.tops[i + 1].getY()) - (this.tops[i + 1]
			        .getX() * this.tops[i].getY()));
		}

		area += ((this.tops[this.tops.length - 1].getX() * this.tops[0].getY()) - (this.tops[0]
		        .getX() * this.tops[this.tops.length - 1].getY()));

		return 0.5 * Math.abs(area);
	}

	public APoint barycenter() {

		double area = this.area();
		double xg = 0, yg = 0;

		for (int i = 0; i < this.tops.length - 1; i++) {

			xg += (1.0 / (6.0 * area))
			        * ((this.tops[i].getX() + this.tops[i + 1].getX()) * ((this.tops[i]
			                .getX() * this.tops[i + 1].getY()) - (this.tops[i + 1]
			                .getX() * this.tops[i].getY())));
			yg += (1.0 / (6.0 * area))
			        * ((this.tops[i].getY() + this.tops[i + 1].getY()) * ((this.tops[i]
			                .getX() * this.tops[i + 1].getY()) - (this.tops[i + 1]
			                .getX() * this.tops[i].getY())));
		}

		xg += (1.0 / (6.0 * area))
		        * ((this.tops[this.tops.length - 1].getX() + this.tops[0].getX()) * ((this.tops[0]
		                .getX() * this.tops[this.tops.length - 1].getY()) - (this.tops[this.tops.length - 1]
		                .getX() * this.tops[0].getY())));
		yg += (1.0 / (6.0 * area))
		        * ((this.tops[0].getY() + this.tops[this.tops.length - 1].getY()) * ((this.tops[0]
		                .getX() * this.tops[this.tops.length - 1].getY()) - (this.tops[this.tops.length - 1]
		                .getX() * this.tops[0].getY())));

		return new APoint(xg, yg);

	}

	/*
	 * (non-Javadoc)
	 * @see curves.ACurve#isConvexe()
	 */

	@Override
	public boolean isConvexe() {

		return false;
	}
}

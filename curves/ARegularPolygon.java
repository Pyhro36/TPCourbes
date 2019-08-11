package curves;

/**
 * Classe de description d'un polgone regulier
 * 
 * @author Pierre-Louis
 * @version 1.0
 */

public class ARegularPolygon extends APolygon {

	private APoint center;

	/**
	 * Constructeur par defaut d'un polygone regulier de 0 cote
	 */

	public ARegularPolygon() {

		super();
		System.out.println("The 0 side regular polygon has been created");
	}

	/**
	 * Constructeur parametre d'un polygone regulier
	 * 
	 * @param center
	 *            le centre du polygone regulier
	 * @param aPoint
	 *            sommet du polygone regulier
	 * @param nSides
	 *            le nombre de cote du polygone reulier
	 */

	public ARegularPolygon(APoint center, APoint aPoint, int nSides) {

		super();

		APoint[] tops = new APoint[nSides];
		tops[0] = aPoint;

		for (int i = 1; i < nSides; i++) {

			tops[i] = new APoint(
			        center.distance(aPoint)// r*
			                *
			                Math.cos(i * (2 * Math.PI / nSides) + // cos(i*a +
			                        Math.atan2(
			                                tops[i - 1].getY() - center.getY(),
			                                tops[i - 1].getX() - center.getX() // b)
			                        )
			                        ) + center.getX(), // + cx)
			        center.distance(aPoint)// r*
			                *
			                Math.sin(i * (2 * Math.PI / nSides) + // cos(i*a +
			                        Math.atan2(
			                                tops[i - 1].getY() - center.getY(),
			                                tops[i - 1].getX() - center.getX() // b)
			                        )
			                        ) + center.getY()// + cy)
			);
		}

		super.tops = tops.clone();
		this.center = center;

		System.out.println("A " + nSides
		        + " sides regular polygon has been created");
	}

	public double length() {

		return super.tops.length * super.tops[0].distance(super.tops[1]);
	}

	public double area() {

		return (super.tops.length * super.tops[0].distance(super.tops[1]) * super.tops[0]
		        .distance(super.tops[1]))
		        / (4 * Math.tan(Math.PI / super.tops.length));
	}

	public APoint barycenter() {

		return center;
	}
}

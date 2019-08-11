package curves;

/**
 * classe de descrpition d'un cercle
 * 
 * @author Pierre-Louis
 * @version 1.0
 */

public class ACircle extends ACloseCurve {

	private APoint center;
	private double rayon;

	/**
	 * contructeur par defaut du cercle de centre (0,0) de rayon 0
	 */

	public ACircle() {

		super();

		this.center = new APoint(0.0, 0.0);
		this.rayon = 0.0;
		System.out.println("The circle center : " + this.center + ", rayon : " + this.rayon + " has been created");

	}

	/**
	 * contrsucteur parametre d'un cercle
	 * 
	 * @param centerX
	 *            la premiere coordonnee du centre du cercle
	 * @param centerY
	 *            la deuxieme coordonnee du centree du cercle
	 * @param rayon
	 *            le rayon du cercle
	 */

	public ACircle(double centerX, double centerY, double rayon) {

		super();

		this.center = new APoint(centerX, centerY);
		this.rayon = rayon;
		System.out.println("The circle center : " + this.center + ", rayon : " + this.rayon + " has been created");

	}

	public double getRayon() {

		return rayon;
	}

	public double length() {

		return 2.0 * Math.PI * rayon;
	}

	public double area() {

		return Math.PI * rayon * rayon;
	}

	public APoint barycenter() {

		return center;
	}

	/*
	 * (non-Javadoc)
	 * @see curves.ACurve#isConvexe()
	 */

	@Override
	public boolean isConvexe() {

		return true;
	}

}

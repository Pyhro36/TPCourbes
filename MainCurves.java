import curves.*;

/**
 * Classe principale de test du package courbes
 * 
 * @author Pierre-Louis
 * @version 1.1
 */
public class MainCurves {

	/**
	 * methode main principale de test
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		// creation de differentes courbes exemples
		ACircle aCircle = new ACircle(1, 2, 5);
		APoint[] tops = new APoint[4];
		ARegularPolygon square = new ARegularPolygon(new APoint(1, 1),
		        new APoint(2, 2), 4);

		tops[0] = new APoint(0, 0);
		tops[1] = new APoint(2, 0);
		tops[2] = new APoint(2, 2);
		tops[3] = new APoint(0, 2);

		APolygon aPolygon = new APolygon(tops);
		APoint PolygonBarycenter = aPolygon.barycenter(), CircleBarycenter = aCircle.barycenter();

		// affichage des caracteristique de ces premieres courbes
		System.out.println("Circle length :" + aCircle.length()
		        + "\n  polygon length " + aPolygon.length() + "\n"
		        + "Circle area " + aCircle.area() + "\n polygon area "
		        + aPolygon.area() + "\n" + "Circle barycenter "
		        + CircleBarycenter + " \n Polygon barycenter "
		        + PolygonBarycenter + "\n" + "sqare " + square.length()
		        + "\n square area " + square.area() + "\n square barycenter "
		        + square.barycenter());

		// creation d'un tableau de courbes
		ACloseCurve[] curves = new ACloseCurve[5];

		curves[0] = new ACircle(0, 0, 3);
		curves[1] = aPolygon;
		curves[2] = aCircle;
		curves[3] = new ARegularPolygon(tops[1], tops[2], 4);
		curves[4] = square;

		for (int i = 0; i < curves.length; i++) {

			System.out.println("curve " + i + "\n length : " + curves[i].length() + "\n area : " + curves[i].area());
		}

		// caclul des moyennes sur cette liste de courbes
		System.out.println("Average area : " + areaAverage(curves) + " \n Average length " + lengthAverage(curves));

		// approximation d'un cercle par un polygone regulier
		int nSides = 1000000; // le nombre de cotes du polygone regulier
		ARegularPolygon approxCircle = circleApprox(aCircle, nSides);

		System.out.println("Approximation of Circle rayon = 3 by regular polygon of " + nSides + " sides " +
		        "\n" + "the difference of areas is : " + Math.abs((aCircle.area() - approxCircle.area())));
	}

	/**
	 * methode de calcul de l'aire moyenne d'une liste de courbes quelconques
	 * 
	 * @param curves
	 *            la liste de courbes sous forme d'un tableau de courbes
	 * @return l'aire moyenne
	 */

	public static double areaAverage(ACloseCurve[] curves) {

		double areaSum = 0.0;

		for (int i = 0; i < curves.length; i++) {

			areaSum += curves[i].area();
		}

		return areaSum / (double) curves.length;
	}

	/**
	 * methode de calcul de la longueur moyenne d'une liste de courbes
	 * 
	 * @param curves
	 *            le liste de courbes sous la forme d'un tableau de courbes
	 * @return la longueur moyenne
	 */

	public static double lengthAverage(ACurve[] curves) {

		double lengthSum = 0.0;

		for (int i = 0; i < curves.length; i++) {

			lengthSum += curves[i].length();
		}

		return lengthSum / (double) curves.length;
	}

	/**
	 * methode d'approximation d'un cercle par un polygone regulier
	 * 
	 * @param circle
	 *            le cercle a approximation
	 * @param nSides
	 *            le nombre de cote du polygone regulier approximation
	 * @return la polygone regulier approximation
	 */

	public static ARegularPolygon circleApprox(ACircle circle, int nSides) {

		return new ARegularPolygon(circle.barycenter(), new APoint(circle.barycenter().getX() + circle.getRayon(), circle.barycenter().getY()),
		        nSides);
	}

}

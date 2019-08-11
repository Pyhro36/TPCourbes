package curves;

/**
 * classe abstraite de description d'un courbe en general
 * 
 * @author Pierre-Louis
 * @version 1.0
 */

public abstract class ACurve {

	/**
	 * methode de calcul de la longueur de la courbe
	 * 
	 * @return la longueur de la courbe
	 */

	public abstract double length();

	/**
	 * methode renvoyant le barycentre de la courbe
	 * 
	 * @return le centre, sous forme de point
	 */

	public abstract APoint barycenter();

	/**
	 * methode de calcul de la distance euclidienne entre la courbe et une autre (distance entre les barycentres des courbes)
	 * 
	 * @param otherCurve
	 *            l'autre coubre
	 * @return la distance euclidienne entre les deux courbes
	 */

	public double distance(ACurve otherCurve) {

		return this.barycenter().distance(otherCurve.barycenter());
	}

	/**
	 * methode qui teste si la courbe est convexe ou concave
	 * 
	 * @return true si la courbe est convexe, false sinon (bouleen)
	 */

	public abstract boolean isConvexe();

}

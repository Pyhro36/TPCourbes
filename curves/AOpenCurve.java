package curves;

/**
 * @author Pierre-Louis
 * @version 1.0
 */

public abstract class AOpenCurve extends ACurve {

	/*
	 * (non-Javadoc)
	 * @see curves.ACurve#length()
	 */
	@Override
	public abstract double length();

	/*
	 * (non-Javadoc)
	 * @see curves.ACurve#barycenter()
	 */
	@Override
	public abstract APoint barycenter();

	/**
	 * methode de calcul de la distance euclidienne entre les extremites de la courbe ouverte s
	 * 
	 * @return la distance euclidienne entre les extremites de la courbe ouverte
	 */

	public abstract double distanceExtrem();

	public abstract boolean isConvexe();
}

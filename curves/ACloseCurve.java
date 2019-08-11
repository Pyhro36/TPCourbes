package curves;

/**
 * @author Pierre-Louis
 * @version 1.0
 */

public abstract class ACloseCurve extends ACurve {

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
	 * methode renvoyant l'aire de la courbe fermee
	 * 
	 * @return l'aire du polygone
	 */

	public abstract double area();

}

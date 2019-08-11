package curves;

/**
 * 
 * @author Pierre-Louis
 * @version 1.0
 */

public class APoint {
	 
	private double x, y;

	 public APoint(double ax, double ay){
		 
		 x = ax;
		 y = ay;
	 }
	 
	 public double getX(){
		 
		 return this.x;
	 }
	 
	 public double getY(){
		 
		 return this.y;
	 }

	 public double distance( APoint otherPoint ) {
	 
		 double dx = x - otherPoint.x;
		 double dy = y - otherPoint.y;
		 return Math.sqrt(dx * dx + dy * dy);
	 }

	 public String toString() {
	 
		 return "[x=" + x + ",y=" + y + "]";
	 }
}
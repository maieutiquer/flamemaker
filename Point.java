package ch.epfl.flamemaker.geometry2d;

public class Point {
  private final double x;
	private final double y;
	public static final Point ORIGIN = new Point(0, 0);
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double x() {
		return this.x;
	}
	
	public double y() {
		return this.y;
	}
	
	public double r() {
		double r=0;
		r=Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		return r;
	}
	
	public double theta() {
		double theta=0;
		theta = Math.atan2(y, x);
		return theta;
	}
	
	public String toString() {
		return "("+x+", "+y+")";
	}	
}

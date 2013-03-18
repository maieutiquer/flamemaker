package ch.epfl.flamemaker.geometry2d;

public class AffineTransformation implements Transformation {
  
	public final double a, b, c, d, e, f;
	
	public AffineTransformation(double a, double b, double c, 
								double d, double e, double f) {
		this.a = a;	this.b = b;	this.c = c;
		this.d = d;	this.e = e;	this.f = f;
	}
	
	@Override
	public Point transformPoint(Point p) {
		double x = p.x();
		double y = p.y();
		double a = this.a;
		double b = this.b;
		double c = this.c;
		return new Point(a*x+b*y+c, d*x+e*y+f);
	}
	
	public static final AffineTransformation IDENTITY = new AffineTransformation(1, 0, 0, 0, 1, 0);
	
	/**
	 * Creates an affine transformation that is a translation. 
	 * Translates a point with dx units in parallel width the horizontal axis 
	 * and dy units in parallel width the vertical axis.
	 * 
	 * @param dx
	 * @param dy
	 * @return an affine translation
	 */
	public static AffineTransformation newTranslation(double dx, double dy) {
		return new AffineTransformation(1, 0, dx, 
										0, 1, dy);
	}
	
	public static AffineTransformation newRotation(double theta) {
		return new AffineTransformation(Math.cos(theta), -Math.sin(theta), 0, 
										Math.sin(theta),  Math.cos(theta), 0);
	}
	
	public static AffineTransformation newScaling(double sx, double sy) {
		return new AffineTransformation(sx,  0, 0, 
										 0, sy, 0);
	}
	
	public static AffineTransformation newShearX(double sx) {
		return new AffineTransformation(1, sx, 0, 
										0,  1, 0);
	}
	
	public static AffineTransformation newShearY(double sy) {
		return new AffineTransformation( 1, 0, 0, 
										sy, 1, 0);
	}
	
	public double translationX() {
		return this.c;
	}
	
	public double translationY() {
		return this.f;
	}
	
	public AffineTransformation composeWith(AffineTransformation that) {
		double a = this.a*that.a + this.b*that.d;
		double b = this.a*that.b + this.b*that.e;
		double c = this.a*that.c + this.b*that.f + this.c;
		double d = this.d*that.a + this.e*that.d;
		double e = this.d*that.b + this.e*that.e;
		double f = this.d*that.c + this.e*that.f + this.f;
		return new AffineTransformation(a, b, c, d, e, f);
	}
	
}

package ch.epfl.flamemaker.geometry2d;

public class Rectangle {
  private final Point center;
	private final double width;
	private final double height; 
	
	public Rectangle(Point center, double width, double height) throws IllegalArgumentException {
		this.center = center;
		this.width = width;
		this.height = height;
		if (width<=0 || height<=0) {
			throw new IllegalArgumentException();
		}
	}
	
	public double left() {
		return center.x() - (this.width/2);
	}
	
	public double right() {
		return center.x() + (this.width/2);
	}
	
	public double bottom() {
		return center.y() - (this.height/2);
	}
	
	public double top() {
		return center.y() + (this.height/2);
	}
	
	public double width() {
		return this.width;
	}
	
	public double height() {
		return this.height;
	}
	
	public Point center() {
		return this.center;
	}
	
	public boolean contains(Point p) {
		return (p.x()>=this.left() && p.x()<this.right() 
				&& p.y()>=this.bottom() && p.y()<this.top());
	}
	
}



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
	
	public double aspectRatio() {
		return width/height;
	}
	
	public Rectangle expandToAspectRatio(double aspectRatio) throws IllegalArgumentException {
		Point center = new Point(this.center().x(), this.center().y());
		double width = 0;
		double height = 0;
		
		if (aspectRatio <= 0) {
			throw new IllegalArgumentException();
		}else if (aspectRatio > this.aspectRatio()) {
			width = this.height*aspectRatio;
			height = this.height;
		}else if (aspectRatio < this.aspectRatio()) {
			width = this.width;
			height = this.width/aspectRatio;
		}
		Rectangle rectangle = new Rectangle(center, width, height);
		return rectangle;
	}
	
	public String toString() {
		return "("+center.toString()+", "+this.width+", "+this.height+")";
	}
	
}


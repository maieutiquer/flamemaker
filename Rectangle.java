package ch.epfl.flamemaker.geometry2d;

public class Rectangle {
	private final Point center;
	private final double width;
	private final double height; 
	
	public Rectangle(Point center, double width, double height) throws IllegalArgumentException {
		if (width<=0 || height<=0) {
			throw new IllegalArgumentException("width or height less than or equal to 0");
		}
		this.center = center;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * 
	 * @return the smallest coordinate x of the rectangle
	 */
	public double left() {
		return this.center.x() - this.width/2;
	}
	
	public double right() {
		return this.center.x() + this.width/2;
	}
	
	public double bottom() {
		return this.center.y() - this.height/2;
	}
	
	public double top() {
		return this.center.y() + this.height/2;
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
	
	/**
	 * Determines of a given point is inside the rectangle.
	 * 
	 * @param p
	 * @return true if the point is inside the rectangle
	 */
	public boolean contains(Point p) {
		return (p.x()>=this.left() && p.x()<this.right() 
				&& p.y()>=this.bottom() && p.y()<this.top());
	}
	
	/**
	 * 
	 * @return the width/height ratio of the rectangle
	 */
	public double aspectRatio() {
		return this.width/this.height;
	}
	
	public Rectangle expandToAspectRatio(double aspectRatio) throws IllegalArgumentException {
		Point newCenter = new Point(this.center().x(), this.center().y());
		double newWidth = 0;
		double newHeight = 0;
		
		if (aspectRatio <= 0) {
			throw new IllegalArgumentException("aspect ratio is negative or zero");
		}
		/* not working code
		else if (aspectRatio > this.aspectRatio()) {
			newWidth = this.height*aspectRatio;
			newHeight = this.height;
		}else if (aspectRatio < this.aspectRatio()) {
			newWidth = this.width;
			newHeight = this.width/aspectRatio;
			System.out.println(newHeight + " " + newWidth); //testing
		}
		*/
		
		newHeight = this.height;
		newWidth = newHeight*aspectRatio;
		newWidth = Math.max(this.width(), newWidth);
		newHeight = newWidth/aspectRatio;
		newHeight = Math.max(this.height(), newHeight);
		
		return new Rectangle(newCenter, newWidth, newHeight);
	}
	
	public String toString() {
		return "("+this.center.toString()+", "+this.width+", "+this.height+")";
	}
	
}


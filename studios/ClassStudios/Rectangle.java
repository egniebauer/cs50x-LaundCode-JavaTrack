package ClassStudios;

/**
 * A class intended to represent a rectangle. Provides height, width, area,
 * and perimeter. Can compare its size to other rectangles. Can determine
 * whether or not it's a square.
 * @author sexybeast
 *
 */
public class Rectangle {
	
	//Fields
	private int height;
	private int width;
	private int area;
	private int perimeter;
	
	//Methods
	public Rectangle (int height, int width) {
		this.height = height;
		this.width = width;
		this.area = (height * width);
		this.perimeter = ((height * 2) + (width * 2));
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setHeight(int newHeight) {
		this.height = newHeight;
		this.area = newHeight * this.width;
		this.perimeter = ((newHeight * 2) + (this.width * 2));
	}
	
	public void setWidth(int newWidth) {
		this.width = newWidth;
		this.area = this.height * newWidth;
		this.perimeter = ((this.height * 2) + (newWidth * 2));
	}
	
	public int getArea() {
		return area;
	}
	
	public int getPerimeter() {
		return perimeter;
	}
	/**
	 * Compares two rectangles sizes
	 * @param h - height of a different rectangle
	 * @param w - width of a different rectangle
	 * @return - whether this rectangle is smaller, same, or larger
	 */
	public String compare(int h, int w) {
		int otherArea = (h * w);
		
		if (this.area == otherArea) {
			return "same";
		}
		else {
			String answer = (this.area > otherArea) ? "larger":"smaller";
			return answer;
		}
	}
	/**
	 * Compares two rectangles sizes
	 * @param other - Rectangle object
	 * @return - whether this rectangle is smaller, same, or larger
	 */
	public String compare(Rectangle other) {
		
		if (this.area == other.area) {
			return "same";
		}
		else {
			String answer = (this.area > other.area) ? "larger":"smaller";
			return answer;
		}
	}

	/**
	 * Determines whether a rectangle is a square
	 * @return - true if this rectangle is a square
	 */
	public Boolean square() {
		Boolean answer = (this.height == this.width) ? true : false;
		return answer;
	}
	
	public String toString() {
		return "Height: " + this.height + ", Width: " + this.width + ", Area: " + this.area + ", Perimeter: " + this.perimeter + ".";
	}
	
	//Instance
	public static void main (String[] args) {
		
		Rectangle flag = new Rectangle(3, 4);
		System.out.println("This is FLAG: "
				+ flag);
		
		Rectangle square =  new Rectangle(3, 3);
		System.out.println("This is SQUARE: "
				+ square);
		
		if (flag.square() == true) {
			System.out.println("FLAG rectangle is a square!");
		}
		else {
			System.out.println("FLAG rectangle is not a square!");
		}
		
		if (square.square() == true) {
			System.out.println("SQUARE rectangle is a square!");
		}
		else {
			System.out.println("SQUARE rectangle is not a square!");
		}
		
		System.out.println("FLAG comparing SQUARE: "
				+ flag.compare(square));
		
		flag.setWidth(3);
		System.out.println("FLAG width set to 3: "
				+ flag);
		
		System.out.println("FLAG comparing SQUARE: "
				+ flag.compare(square));
		
		flag.setHeight(2);
		System.out.println("FLAG height set to 2: "
				+ flag);
		
		System.out.println("FLAG comparing SQUARE: "
				+ flag.compare(square));
		
		System.out.println("Is SQUARE a square: "
				+ square.square());
		System.out.println("Is FLAG a square: "
				+ flag.square());

	}
}

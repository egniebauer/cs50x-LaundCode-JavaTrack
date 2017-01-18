package Robot;
/**
 * Robot is a class intended to represent a robot. It has a name, location, speed,
 * and orientation. It can move, rotate, and knows its location relative to that
 * of other robots.
 * @author sexybeast
 *
 */
public class Robot {
	
	protected String name;
	protected int x;
	protected int y;
	protected int speed;
	protected String orientation;
	protected int batteryLife;
	protected int shield; 
	
	public Robot (String name, int x, int y, int speed, String orientation)
	{
		this.name = name;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.orientation = orientation;
		this.batteryLife = 100;
		this.shield = 100;
	}
	public String getName() {
		return name;
	}
	public int getSpeed() {
		return speed;
	}
	public String getOrientation() {
		return orientation;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public String getLocation() {
		return Integer.toString(this.getX()) + ", " + Integer.toString(this.getY());
	}
	public int getBatteryLife() {
		return batteryLife;
	}
	public int getShield() {
		return shield;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	/**
	 * The robot moved a number of spaces based on its speed and orientation.
	 * @param move - How far the robot should move.
	 */
	public void move (int move)
	{
		int spaces = (this.getSpeed() * move);
		
		switch (this.orientation)
		{
			case "north" :
				this.y += spaces;
				break;
			case "south" :
				this.y -= spaces;
				break;
			case "east" :
				this.x += spaces;
				break;
			case "west" :
				this.x -= spaces;
				break;
			default :
				return;
		}
	}
	/**
	 * The robot rotates based on its current orientation
	 * @param direction - The robot can turn left (l) or right (r).
	 */
	public void rotate (char direction)
	{
		if (direction == 'l')
		{
			switch (this.orientation)
			{
				case "north" :
					this.orientation = "west";
					break;
				case "south" :
					this.orientation = "east";
					break;
				case "east" :
					this.orientation = "north";
					break;
				case "west" :
					this.orientation = "south";
					break;
				default :
					return;
			}
		}
		else if (direction == 'r')
		{
			switch (this.orientation)
			{
				case "north" :
					this.orientation = "east";
					break;
				case "south" :
					this.orientation = "west";
					break;
				case "east" :
					this.orientation = "south";
					break;
				case "west" :
					this.orientation = "north";
					break;
				default :
					return;
			}
		}
		else
		{
			return;
		}
	}
	/**
	 * Provides the distance between itself and another robot
	 * @param otherX - the x coordinate of another robot
	 * @param otherY - the y coordinate of another robot
	 * @return - the distance between the two robots
	 */
	public int location (int otherX, int otherY)
	{
		int rise = (otherY - this.y); 
		int run = (otherX - this.x);
		int slope = rise / run;
		return slope;
	}
	public String toString()
	{
		return "Robot: [name: " + this.name + ", position: " + this.x + ", " + this.y + ", speed: " + this.speed + ", orientation: " + this.orientation + ", battery life: " + this.batteryLife + ", shield: " + this.shield + "]";
	}
	public static void main (String[] args)
	{
		Robot bb8 = new Robot("BB-8", 0, 0, 3, "west");
		Robot r2d2 = new Robot("R2D2", 1, 1, 2, "north");
		System.out.println(bb8);
		System.out.println(r2d2);
		
		//move BB-8 six spaces
		System.out.println("Moving " + bb8.getName() + " six spaces further west.");
		bb8.move(3);
		System.out.println(bb8);
		
		//rotate R2-D2 to face west
		System.out.println("Rotating " + r2d2.getName() + " to face west.");
		r2d2.rotate('l');
		System.out.println(r2d2);
		
		//distance between our robots
		System.out.print("The distance between " + bb8.getName() + " and " + r2d2.getName() + " is ");
		int distance = bb8.location(r2d2.getX(), r2d2.getY());
		System.out.println(distance);
	}
}

package Robot;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class intends to display an interactive menu for users to 
 * create and work with Robot objects.
 *  1. Create a robot
 *  2. Display the list of available robots
 *  3. Move a robot
 *  4. Rotate a robot
 *  5. Compute the distance between two robots
 *  6. Exit
 * @author sexybeast
 *
 */
public class RobotMenu {
	
	//Fields
	private ArrayList<Robot> robotList;
	private Scanner in;
	
	public RobotMenu() {
		this.robotList = new ArrayList<Robot>();
		this.in = new Scanner(System.in);
	}

	public static void main(String[] args) {
		
		int x = 0;
		RobotMenu rm = new RobotMenu();
		
		do {
			x = rm.startMenu();
			rm.processMenu(x);
		} while (x != 6);
	}
	
	public int startMenu() {
		// display menu
		System.out.println("Welcome to the Robot Menu!");
		System.out.println("1. Create a robot");
		System.out.println("2. Display the list of available robots");
		System.out.println("3. Move a robot");
		System.out.println("4. Rotate a robot");
		System.out.println("5. Compute the distance between two robots");
		System.out.println("6. Exit\n");
		
		// receive input from user
		int choice = in.nextInt();
		
		// validate user's choice
		while (choice < 0 || choice > 6) {
			System.out.println("That was an invaid selection. Please try again:");
			choice = in.nextInt();
		}
		return choice;
	}
	
	public void processMenu(int choice) {
		//int choice = startMenu();
		if (choice == 1) {
			createRobot();
		}
		else if (choice == 2) {
			displayRobots();
		}
		else if (choice == 3) {
			moveRobot();
		}
		else if (choice == 4) {
			rotateRobot();
		}
		else if (choice == 5) {
			distanceRobots();
		}
	}
	public void createRobot() {
		// Retrieve necessary inputs for fields
		System.out.println("What is the name of this robot?");
		String name = in.next();
		
		System.out.println("Where is " + name + " located on the x-axis?");
		int x = in.nextInt();
		
		System.out.println("Where is " + name + " located on the y-axis?");
		int y = in.nextInt();
		
		System.out.println("What is " + name + "'s speed?");
		int speed = in.nextInt();
		
		System.out.println("What is " + name + "'s orientation? (north, south, east, or west)");
		String orientation = in.next();
//		while (!orientation.equals("north") || !orientation.equals("south") || !orientation.equals("east") || !orientation.equals("west")) {
//			System.out.println("That was not a valid orientation. Please type: north, south, east, or west.");
//			orientation = in.next();
//		}
//		while ((orientation != "north") || (orientation != "south") || (orientation != "east") || (orientation != "west")) {
//			System.out.println("That was not a valid orientation. Please type: north, south, east, or west.");
//			orientation = in.next();
//		}
		if (orientation.equals("north") || orientation.equals("south") || orientation.equals("east") || orientation.equals("west")) {
			robotList.add(new Robot(name, x, y, speed, orientation));
		}
		else {
			System.out.println("That was not a valid orientation. Please type: north, south, east, or west.");
			orientation = in.next();
		}
		System.out.println("Done! " + name + " has successfully been created.");
	}
//		
//		robotList.add(new Robot(name, x, y, speed, orientation));
//	}
	public void displayRobots() {
		for (int i = 0; i < robotList.size(); i++) {
			System.out.println((i + 1) + ". " + robotList.get(i) + "\n");
		}
	}
	public Robot selectRobot() {
		System.out.println("Please select a Robot:");
		int choice = in.nextInt();
		
		// validate user's choice
		while (choice < 0 || choice > robotList.size()) {
			System.out.println("That was an invaid selection. Please try again:");
			choice = in.nextInt();
		}
		return robotList.get(choice - 1);
	}
	public void moveRobot() {
		displayRobots();
		Robot selectedRobot = selectRobot();
		
		System.out.println("How far would you like to move " + selectedRobot.getName() +"?");
		int move = in.nextInt();
		
		while (move < 0) {
			System.out.println("Please provide a positive integer");
			move = in.nextInt();
		}
		
		selectedRobot.move(move);
		
		System.out.println(selectedRobot.getName() + "'s location is now: " + selectedRobot.getLocation());
	}
	public void rotateRobot() {
		displayRobots();
		Robot selectedRobot = selectRobot();
		
		System.out.println("Would you like to rotate " + selectedRobot.getName() + " left (l) or right (r)?");
		char direction = in.findInLine(".").charAt(0);
		
		while (direction != 'l' || direction != 'r') {
			System.out.println("The only valid options are 'l' or 'r'");
			direction = in.findInLine(".").charAt(0);
		}
		
		selectedRobot.rotate(direction);
		
		System.out.println(selectedRobot.getName() + "'s orientation is now: " + selectedRobot.getOrientation());
	}
	public void distanceRobots() {
		displayRobots();
		Robot selectedRobot = selectRobot();
		
		System.out.println("What robot would you like to compare " + selectedRobot.getName() + "'s distance with?");
		displayRobots();
		Robot otherRobot = selectRobot();
		
		if (selectedRobot == otherRobot) {
			System.out.println(selectedRobot.getName() + " is in the same location as itself!");
		}
		else {
			System.out.println("Great we'll compare " + selectedRobot.getName() + "'s location to " + otherRobot.getName() + "'s location.");
			int distance = selectedRobot.location(otherRobot.getX(), otherRobot.getY());
			System.out.println("The distance between these two is " + distance);
		}
	}
}

package Robot;

public class AttackBot extends Robot{
	
	//Fields
	private Weapon weapon;
	
	//Constructors
	public AttackBot(String name, int x, int y, int speed, String orientation, Weapon weapon) {
		super(name, x,y,speed,orientation);
		this.weapon = weapon;
	}

	//Behaviors
	public Weapon getWeapon() {
		return weapon;
	}

	public void attackRobot(Robot enemyRobot) {
		int distance = enemyRobot.location(this.getX(), this.getY());
		
		if (distance > 2) {
			System.out.println(enemyRobot + " is too far to attack.");
		}
		int batteryDrain = weapon.getBatteryDrain();
		this.batteryLife -= batteryDrain;
		
		int hitPoints = weapon.getHitPoints();
		enemyRobot.shield -= hitPoints;
	}
	
	public void dropWeapon() {
		this.weapon = Weapon.NONE;
	}
	
	public void grabWeapon(Weapon newWeapon) {
		if (this.weapon == Weapon.NONE) {
			this.weapon = newWeapon;
		}
		else {
			System.out.println(this.getWeapon() + " is currently equipped. Please drop it before grabbing " + newWeapon);
		}
	}
	
	
	public static void main (String[] args){
		AttackBot grr = new AttackBot("grr", 0, 0, 3, "north", Weapon.LIGHTSABER);
		Robot ahh = new Robot("ahh", 1, 1, 2, "north");
		
		System.out.println(grr);
		System.out.println(ahh);
		
		System.out.println(grr.getName() + " attacks " + ahh.getName() + " with " + grr.getWeapon());
		grr.attackRobot(ahh);
		
		System.out.println(grr);
		System.out.println(ahh);

	}
}

package Robot;

public enum Weapon {
	NONE (0, 0),
	SELF (5, 10),
	LIGHTSABER (25, 50),
	NERFGUN (1, 3),
	MACE (25, 25),
	SQUIRTGUN (15, 15);
	
	private int batteryDrain;
	private int hitPoints;
	
	Weapon(int batteryDrain, int hitPoints){
		this.batteryDrain = batteryDrain;
		this.hitPoints = hitPoints;
	}

	public int getBatteryDrain() {
		return batteryDrain;
	}

	public int getHitPoints() {
		return hitPoints;
	}
	
};
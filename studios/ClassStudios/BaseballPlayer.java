package ClassStudios;

import java.util.ArrayList;

/**
 * This class is intended to represent a baseball player. It provides the player's
 * name, jersey number, hitting preference, as well as their total runs, RBIs, and 
 * games played. The player's statistics are updated following a game played.
 * @author sexybeast
 *
 */
public class BaseballPlayer {
	
/*	
 * Fields
*/	
	private String name;
	private int jerseyNumber;
	private String hitPreference;
	private ArrayList runs;
	private ArrayList RBIs;
//	private ArrayList<runs, RBIs> totalGames;
/*
 * Methods
 */
	public BaseballPlayer (String name, int jerseyNumber, String hitPreference){
		this.name = name;
		this.jerseyNumber = jerseyNumber;
		this.hitPreference = hitPreference;
//		this.totalRuns = 0;
//		this.totalRBIs = 0;
//		this.totalGames = {{Runs[]}, {RBIs[]}};
	}
	public BaseballPlayer (String name, int jerseyNumber, String hitPreference, int totalRuns, int totalRBIs, int totalGames){
		this.name = name;
		this.jerseyNumber = jerseyNumber;
		this.hitPreference = hitPreference;
//		this.totalRuns = totalRuns;
//		this.totalRBIs = totalRBIs;
//		this.totalGames = totalGames;
	}
	//Getters and Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJerseyNumber() {
		return jerseyNumber;
	}
	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}
	public String getHitPreference() {
		return hitPreference;
	}
	public void setHitPreference(String hitPreference) {
		this.hitPreference = hitPreference;
	}
//	public int getTotalRuns() {
//		return totalRuns;
//	}
//	public int getTotalRBIs() {
//		return totalRBIs;
//	}
//	public int getTotalGames() {
//		return totalGames;
//	}
	/**
	 * Updates the player's total stats following completion of a new game.
	 * @param newRuns - Runs completed by this player in a new game.
	 * @param newRBIs - RBIs completed by this player in a new game.
	 */
//	public void gameUpdate(int newRuns, int newRBIs) {
//		this.totalRuns += newRuns;
//		this.totalRBIs += newRBIs;
//		this.totalGames += 1;
//	}
//	public String toString() {
//		return "Name: " + this.getName() + ", Jersey Number: " + this.getJerseyNumber() + ", Hitting Preference: " + this.getHitPreference() + ", Total Runs: " + this.getTotalRuns() + ", Total RBIs: " + this.getTotalRBIs() + ", Total Games: " + this.getTotalGames() + ".";
//	}
	
	//Main
	public static void main (String[] args) {
		
	}
}

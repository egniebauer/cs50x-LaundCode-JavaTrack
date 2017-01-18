package banking;

import java.util.ArrayList;

public class Bank {

	
	/*
	 * Fields
	 * 
	 * Routing Number
	 * Name
	 * Accounts
	 * amount of money
	 * Location
	 * 
	 */
	private int routingNumber;
	private String name;
	private String location;
	private ArrayList<Account> accounts;

	public Bank (int routingNumber, String name, String location) {
		accounts = new ArrayList<Account>();
		this.routingNumber = routingNumber;
		this.name = name;
		this.location = location;
	}
	
	public void createAccount(double balance, String owner, boolean isChecking) {
		int accountNum = accounts.size();
		Account a;
		if (isChecking) {
			//checking
			a = new CheckingAccount(balance, accountNum, owner, true);
		}
		else {
			//savings
			ContinuousStrategy cs = new ContinuousStrategy(.5);
			a = new SavingsAccount(balance, accountNum, owner, cs);

		}
		accounts.add(a);
	}
	
	public void deposit(float amount, int accountNum) {
		Account a = accounts.get(accountNum);
		a.deposit(amount);
	}
	
	
	
	/*
	 * Behaviors
	 * 
	 * rob
	 * deposit
	 * withdraw
	 * create a accounts
	 * close accounts
	 * 
	 */
	
//	this.routingNumber = 100987612;
}

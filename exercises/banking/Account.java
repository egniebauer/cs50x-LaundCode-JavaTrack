package banking;
/**
 * A class intended to represent a bank account. Provides
 * withdrawals, deposits, and transfers.
 * @author sexybeast
 *
 */
public class Account {
	
	/*
	 * An Account has-a:
	 * 
	 * balance
	 * account number
	 * type
	 * owner
	 * routing number
	 * signature card
	 */
	protected double balance;
	private int accountNumber;
	private String owner;
	private boolean active;
	private double minBalance;
	
	public Account(double balance, int accountNumber, String owner, double d) {
		if (balance < 0) {
			throw new IllegalArgumentException();
		}
		this.balance = balance;
		this.setAccountNumber(accountNumber);
		this.setOwner(owner);
		this.minBalance = d;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	/**
	 * Withdraws money from this account
	 * @param amount - the amount to be withdrawn
	 * @return - true if the withdrawal was successful
	 */
	public boolean withdraw(double amount) {
		if(this.balance - this.minBalance >= amount) {
			this.balance -= amount;
			return true;
		}
		return false;
	}
	
	public void deposit(double deposit) {
		this.balance += deposit;
	}
	/*
	 * Behaviors
	 * 
	 * deposit
	 * overdraft
	 * withdrawl
	 * transfer
	 * balance check
	 * 
	 */
	
	public static void main(String[] args) {
		Account lizsAccount = new Account(123, 112200983, "Elizabeth Niebauer", 5);
		System.out.println("Original Balance: " + lizsAccount.getBalance());
		lizsAccount.withdraw(20);
		System.out.println("New Balance: " + lizsAccount.getBalance());
		lizsAccount.withdraw(120);
		System.out.println("New Balance: " + lizsAccount.getBalance());

	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}

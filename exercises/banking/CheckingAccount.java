package banking;

public class CheckingAccount extends Account {
	
	//Fields
	private boolean overdraftProtection;
	
	public CheckingAccount(double balance, int accountNumber, String owner, boolean overdraftProtection) {
		
		super(balance, accountNumber, owner, 5.00);
		this.setOverdraftProtection(overdraftProtection);
	}

	public boolean isOverdraftProtection() {
		return overdraftProtection;
	}

	public void setOverdraftProtection(boolean overdraftProtection) {
		this.overdraftProtection = overdraftProtection;
	}
	
	//modify withdraw

}

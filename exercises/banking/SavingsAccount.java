package banking;

public class SavingsAccount extends Account {
	
	private final int MAX_WITHDRAWALS = 6;
	private int currentWithdrawals;
	private Compoundable interestStrategy;
	
	public SavingsAccount(double balance, int accountNumber, String owner, Compoundable strategy) {
		super(balance, accountNumber, owner, 500.00);
		this.currentWithdrawals = 0;
		this.interestStrategy = strategy;
		}
	
	public void compoundInterest() {
		this.balance = this.interestStrategy.compoundInterest(this.balance);
	}
	
	public boolean withdraw(double amount) {
		
		if(this.currentWithdrawals < this.MAX_WITHDRAWALS) {
			
			boolean result = super.withdraw(amount);
			
			if (result == true) {
				
				this.currentWithdrawals++;
			}
			return result;
		}
		return false;
	}
	
	public int getMaxWithdrawals() {
		return MAX_WITHDRAWALS;
	}
	public int getCurrentWithdrawals() {
		return currentWithdrawals;
	}
	
	public static void main (String[] args) {
		ContinuousStrategy cs = new ContinuousStrategy(0.1);
		SavingsAccount lizAccount = new SavingsAccount(1000, 1, "Liz Nie", cs);
		
		NonContinuousStrategy ncs = new NonContinuousStrategy(12, 0.1);
		SavingsAccount lizAccount2 = new SavingsAccount(1000, 2, "Liz Nie", ncs);
		
		lizAccount.compoundInterest();
		lizAccount2.compoundInterest();
		
		System.out.println("Continuous: " + lizAccount.getBalance());
		System.out.println("Noncontinuous: " + lizAccount2.getBalance());
	}

}

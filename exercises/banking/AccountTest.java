package banking;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	
	private Account lizsAccount;
	
	@Before
	public void seUp() {
		this.lizsAccount = new Account(123, 112200983, "Elizabeth Niebauer", 123);
	}
	
//	@Test
//	public void testWithdrawSuccess() {
//		assertTrue("Initial balance incorrect" lizsAccount.getBalance() == 123); 	//check original balance
//		assertTrue("Successful withdraw does not return true" lizsAccount.withdraw(23));			//check withdraw return
//		assertTrue("Successful withdraw does not properly update" lizsAccount.getBalance() == 100);	//check withdraw balance
//		
//	}
	@Test
	public void testNegativeBalance() {
		try
		{
			Account a = new Account(-100, 1, "Liz Nie", 50);
		}
		catch (IllegalArgumentException e)
		{
			assertTrue(true);
		}
		catch (Exception e)
		{
			fail("Didn't throw correct exception type");
		}
	}
}

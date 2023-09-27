package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testingJUnit.BankAccount;


public class BankAccountTest {
	
	@Test
	@DisplayName("Withdraw 300 successfully")
	public void testWithdraw() {
		BankAccount bankAccount = new BankAccount(500, -1000);
	bankAccount.withdraw(300);
	assertEquals(200, bankAccount.getBalance());
	}
	
	@Test
	@DisplayName("Deposit 500 successfully")
	public void testDeposit() {
		BankAccount bankAccount = new BankAccount(400,0);
		bankAccount.deposit(500);
		assertEquals(900, bankAccount.getBalance());
		
	}
}

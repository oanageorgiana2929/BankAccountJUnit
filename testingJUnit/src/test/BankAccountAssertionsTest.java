package test;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testingJUnit.BankAccount;


public class BankAccountAssertionsTest {
	
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
	
	@Test
	@DisplayName("Withdraw will become negative")
	public void testWithdrawNotStuckAtZero() {
		BankAccount bankAccount = new BankAccount(500, -1000);
		bankAccount.withdraw(800);
		assertNotEquals(0, bankAccount.getBalance());
	}
	
	@Test
	@DisplayName("Bank account is active")
	public void testActive() {
		BankAccount bankAccount = new BankAccount(500,0);
		bankAccount.setActive(true);
		assertTrue(bankAccount.isActive());
	}
	
	@Test
	@DisplayName("Test set holder name")
	public void testHolderNameSet() {
		BankAccount bankAccount = new BankAccount(500,0);
		bankAccount.setHolderName("Maaike");
		assertNotNull(bankAccount.getHolderName());
	}
	
	@Test
	@DisplayName("Test that we can't withdraw below minimum")
	public void testNoWithdrawBelowMinimum() {
		BankAccount bankAccount = new BankAccount(500,-1000);
		assertThrows(RuntimeException.class, () -> bankAccount.withdraw(2000));
	}
	
	@Test
	@DisplayName("Test no exceptions for withdraw and deposit")
	public void testWithdrawAndDepositWithoutExceptions() {
		BankAccount bankAccount = new BankAccount(500,-1000);
		assertAll( () -> bankAccount.deposit(200), () -> bankAccount.withdraw(450));
	}
	
	@Test
	@DisplayName("Test speed deposit")
	public void testDepositTimeout() {
		BankAccount bankAccount = new BankAccount(500,-1000);
		assertTimeout(Duration.ofNanos(1), () -> bankAccount.deposit(200));
	}
}

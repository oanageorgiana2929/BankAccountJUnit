package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import testingJUnit.BankAccount;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParallelExecution {

	@Test
	@DisplayName("Deposit 300 successfully")
	public void testDeposit(BankAccount bankAccount) {
		try {
			Thread.sleep(200);
			
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		bankAccount.deposit(300);
		assertEquals(300, bankAccount.getBalance());
		
	}
	
	@Test
	@DisplayName("Deposit 400 successfully")
	public void testDeposit2(BankAccount bankAccount) {
		try {
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		bankAccount.deposit(400);
		assertEquals(400, bankAccount.getBalance());
		
	}
	
	@Test
	@DisplayName("Deposit 500 successfully")
	public void testDeposit3(BankAccount bankAccount) {
		try {
			Thread.sleep(1200);
			
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		bankAccount.deposit(500);
		assertEquals(500, bankAccount.getBalance());
		
	}
}

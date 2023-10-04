package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import testingJUnit.BankAccount;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParameterizedTest {

	@ParameterizedTest
	@ValueSource(ints = {100,400,800,1000})
	@DisplayName("Deposit 500 successfully")
	public void testDeposit(int amount, BankAccount bankAccount) {
		bankAccount.deposit(amount);
		assertEquals(amount, bankAccount.getBalance());
		
	}

	@ParameterizedTest
	//@CsvSource({"100,Alexandru", "200, Ioana", "150, George"})
	@CsvFileSource(resources = "/details.csv")
	public void depositAndNameTest(double amount, String name, BankAccount bankAccount) {
		bankAccount.deposit(amount);
		bankAccount.setHolderName(name);
		assertEquals(amount, bankAccount.getBalance());
		assertEquals(name, bankAccount.getHolderName());
	}
}	

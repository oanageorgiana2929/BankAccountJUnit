package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import testingJUnit.BankAccount;

public class BankAccountAssumptionsTest {

	//This test is skipped because assumption is not met
@Test
@DisplayName("Test activation account after creation")
public void testActive() {
	BankAccount bankAccount = new BankAccount(500,0);
	assumeTrue(bankAccount == null, "Account is null");
	assertTrue(bankAccount.isActive());
   }

//This test is not abort if the condition is false
@Test
@DisplayName("Test activation account after creation 2")
public void testActive2() {
	BankAccount bankAccount = new BankAccount(500,0);
	assumingThat(bankAccount == null, () -> assertTrue(bankAccount.isActive()));

   }

}

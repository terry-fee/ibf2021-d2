package ibf2021.d2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BankAccountTest 
{
    @Test
    public void testGetName() {
        BankAccount account = new BankAccount("Pink Panther");
        assertTrue(account.getName().equals("Pink Panther"));
        System.out.println("testGetName successful");
    }

    @Test
    public void testGetBalance() {
        float initBalance = (float) 123.45;
        BankAccount account =  new BankAccount("John Smith", initBalance);
        assertTrue(123.45f - Math.abs(account.getAccountBalance()) < 0.001);
        System.out.println("testGetBalance successful");
    }

    @Test
    public void testDeposit() {
        float initBalance = (float) 12.34;
        float depositAmount = (float) 2.47;
        BankAccount account =  new BankAccount("John Smith", initBalance);
        account.deposit(depositAmount);
        assertTrue(14.81f - Math.abs(account.getAccountBalance()) < 0.001);
        System.out.println("testDeposit successful");
    }

    @Test
    public void testWithdraw() {
        float initBalance = (float) 34.56;
        float withdrawAmount = (float) 24.7;
        BankAccount account =  new BankAccount("John Smith", initBalance);
        account.withdraw(withdrawAmount);
        assertTrue(9.86f - Math.abs(account.getAccountBalance()) < 0.001);
        System.out.println("testWithdraw successful");
    }

    @Test 
    public void testGetTransactions() {
        BankAccount account =  new BankAccount("Johann Schmidt");
        account.deposit(100f);
        account.deposit(50f);
        account.withdraw(45.67f);
        assertTrue(account.getTransactions().size() == 3);
        System.out.println("testGetTransactions successful");
    }

    @Test
    public void testGetAccountNumber() {
        // Has a non-zero chance of getting the same value
        BankAccount account1 =  new BankAccount("What");
        BankAccount account2 =  new BankAccount("ever");
        assertTrue(!account1.getAccountNumber().equals(
                account2.getAccountNumber()));
        System.out.println("testGetAccountNumber successful");
    }

    @Test
    public void testCreateDateNotBlank() {
        BankAccount account = new BankAccount("Blah");
        assertTrue(account.getAccountCreateDate() != null);
        System.out.println("testCreateDateNotBlank successful");
    }

    @Test
    public void testCloseDateNotBlank() {
        BankAccount account = new BankAccount("Blah");
        account.setIsClosed(true);
        assertTrue(account.getAccountClosedDate() != null);
        System.out.println("testCloseDateNotBlank successful");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawMoreThanBalance() {
        BankAccount account =  new BankAccount("Blah", 123.45f);
        account.withdraw(200f);
        System.out.println("testWithdrawMoreThanBalance successful");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawFromClosedAccount() {
        BankAccount account =  new BankAccount("Blah", 123.45f);
        account.setIsClosed(true);
        account.withdraw(50f);
        System.out.println("testWithdrawFromClosedAccount successful");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegativeAmount() {
        BankAccount account =  new BankAccount("Blah", 123.45f);
        account.deposit(-49.99f);
        System.out.println("testDepositNegativeAmount successful");
    }

}

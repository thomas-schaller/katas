import bank.Account;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void shouldDeposit500()
    {
        int depositAmount= 500;
        Account a = new Account();
        a.deposit(depositAmount);
        Assert.assertEquals(depositAmount,a.getBalance());
    }

    @Test
    public void shouldWithdraw100()
    {
        int withdrawAmount= 100;
        Account a = new Account();
        a.withdraw(withdrawAmount);
        Assert.assertEquals(-withdrawAmount,a.getBalance());
    }

    @Test
    public void printDepositStatement()
    {
        Account a = new Account();
        a.withdraw(200);
        Assert.assertEquals("Date\tAmount\tBalance\n12.20.2025\t+200\t200",a.printStatement());
    }
}

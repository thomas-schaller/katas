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


}

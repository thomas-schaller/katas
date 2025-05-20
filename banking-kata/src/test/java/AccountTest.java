import bank.Account;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void shouldDeposit500()
    {
        Account a = new Account();
        a.deposit(500);
        Assert.assertEquals(500,a.getBalance());
    }
}

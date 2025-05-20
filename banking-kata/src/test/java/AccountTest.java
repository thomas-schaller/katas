import bank.Account;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalDate;


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
        LocalDate date = LocalDate.of(2024, 1, 1);
        try(MockedStatic<LocalDate> mockStatic = Mockito.mockStatic(LocalDate.class)) {
            mockStatic.when(LocalDate::now).thenReturn(date);
            Account a = new Account();
            a.deposit(200);

            Assert.assertEquals("Date\tAmount\tBalance\n01.01.2024\t+200\t200", a.printStatement());
        }
    }

    @Test
    public void printWithdrawStatement()
    {

        LocalDate date = LocalDate.of(2024, 10, 1);
        try(MockedStatic<LocalDate> mockStatic = Mockito.mockStatic(LocalDate.class)) {
            mockStatic.when(LocalDate::now).thenReturn(date);

            Account a = new Account();
            a.withdraw(100);
            Assert.assertEquals("Date\tAmount\tBalance\n10.01.2024\t-100\t-100", a.printStatement());
        }
    }
}

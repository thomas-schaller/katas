import bank.Account;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalDate;

import static bank.Account.COLUMN_SEPARATOR;
import static bank.Account.HEADER_STATEMENT;


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
        int depositAmount= 200;
        try(MockedStatic<LocalDate> mockStatic = Mockito.mockStatic(LocalDate.class)) {
            mockStatic.when(LocalDate::now).thenReturn(date);
            Account a = new Account();
            a.deposit(depositAmount);

            Assert.assertEquals(HEADER_STATEMENT+"01.01.2024"+COLUMN_SEPARATOR+"+"+depositAmount+COLUMN_SEPARATOR+depositAmount, a.printStatement());
        }
    }

    @Test
    public void printWithdrawStatement()
    {
        int withdrawAmount= 100;
        LocalDate date = LocalDate.of(2024, 10, 1);
        try(MockedStatic<LocalDate> mockStatic = Mockito.mockStatic(LocalDate.class)) {
            mockStatic.when(LocalDate::now).thenReturn(date);
            Account a = new Account();
            a.withdraw(withdrawAmount);
            Assert.assertEquals(HEADER_STATEMENT+"10.01.2024"+COLUMN_SEPARATOR+"-"+withdrawAmount+COLUMN_SEPARATOR+"-"+withdrawAmount, a.printStatement());
        }
    }
}

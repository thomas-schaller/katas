import bank.Account;
import bank.BankOperation;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.LocalDate;

import static bank.Account.COLUMN_SEPARATOR;
import static bank.Account.HEADER_STATEMENT;


public class AccountTest {

    @Test
    public void cantWithdrawMoreThanBalance() {
        int withdrawAmount = 100;
        Account a = new Account();
        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> a.withdraw(withdrawAmount));
        Assert.assertEquals("Impossible to withdraw more than you have: " + withdrawAmount + " is more than " + a.getBalance(), exception.getMessage());
    }

    @Test
    public void shouldWithdraw100() {
        int initialAmount = 200;
        int withdrawAmount = 100;
        Account a = new Account();
        a.deposit(initialAmount);
        a.withdraw(withdrawAmount);
        Assert.assertEquals(initialAmount - withdrawAmount, a.getBalance());
    }

    @Test
    public void printDepositStatement() {
        LocalDate date = LocalDate.of(2024, 1, 1);
        int depositAmount = 200;
        try (MockedStatic<LocalDate> mockStatic = Mockito.mockStatic(LocalDate.class)) {
            mockStatic.when(LocalDate::now).thenReturn(date);
            Account a = new Account();
            a.deposit(depositAmount);

            Assert.assertEquals(HEADER_STATEMENT + "\n01.01.2024" + COLUMN_SEPARATOR + "+" + depositAmount + COLUMN_SEPARATOR + depositAmount, a.printStatement());
        }
    }

    @Test
    public void depositAndWithdrawPrintStatement() {
        Account a = new Account();
        int depositAmount = 500;
        int withdrawAmount = 100;
        LocalDate dateDeposit = LocalDate.of(2015, 12, 24);
        LocalDate dateWithdraw = LocalDate.of(2016, 8, 23);
        try (MockedStatic<LocalDate> mockStatic = Mockito.mockStatic(LocalDate.class)) {
            mockStatic.when(LocalDate::now).thenReturn(dateDeposit);
            a.deposit(depositAmount);
        }
        try (MockedStatic<LocalDate> mockStatic = Mockito.mockStatic(LocalDate.class)) {
            mockStatic.when(LocalDate::now).thenReturn(dateWithdraw);
            a.withdraw(withdrawAmount);
            Assert.assertEquals(HEADER_STATEMENT + "\n" + dateDeposit.format(BankOperation.DATE_FORMATER) + COLUMN_SEPARATOR + "+" + depositAmount + COLUMN_SEPARATOR + depositAmount + "\n" +
                            "23.08.2016" + COLUMN_SEPARATOR + "-" + withdrawAmount + COLUMN_SEPARATOR + (depositAmount - withdrawAmount),
                    a.printStatement());
        }

    }
}

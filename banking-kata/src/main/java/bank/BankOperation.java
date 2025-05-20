package bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static bank.Account.COLUMN_SEPARATOR;

public class BankOperation {

    public static final DateTimeFormatter DATE_FORMATER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    int amount = 0;
    int finalBalance = 0;
    LocalDate dateOperation;

    BankOperation(int amount, int finalBalance) {
        this.amount = amount;
        this.finalBalance = finalBalance;
        dateOperation = LocalDate.now();
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getDateOperation() {
        return dateOperation;
    }

    public String printStatement() {
        String operationType = "+";
        if (amount < 0) {
            operationType = "";
        }
        return dateOperation.format(DATE_FORMATER) + COLUMN_SEPARATOR + operationType + amount + COLUMN_SEPARATOR + finalBalance;

    }
}

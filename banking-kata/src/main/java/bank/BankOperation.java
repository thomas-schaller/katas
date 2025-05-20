package bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static bank.Account.COLUMN_SEPARATOR;

public class BankOperation {
    int amount=0;
    LocalDate dateOperation;
    private static final DateTimeFormatter DATE_FORMATER =  DateTimeFormatter.ofPattern("MM.dd.yyyy");

    BankOperation(int amount)
    {
        this.amount=amount;
        dateOperation = LocalDate.now();
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getDateOperation() {
        return dateOperation;
    }

    public String printStatement()
    {
        String operationType ="+";
        if (amount < 0)
        {
            operationType ="";
        }
        return dateOperation.format(DATE_FORMATER)+COLUMN_SEPARATOR+operationType+amount+COLUMN_SEPARATOR+amount;

    }
}

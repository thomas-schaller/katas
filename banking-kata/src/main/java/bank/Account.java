package bank;

import java.util.ArrayList;
import java.util.List;


public class Account {

    public static final String COLUMN_SEPARATOR = "\t";
    public static final String HEADER_STATEMENT = "Date" + COLUMN_SEPARATOR + "Amount" + COLUMN_SEPARATOR + "Balance";
    List<BankOperation> operationList = new ArrayList<>();
    int balance = 0;

    public void deposit(int depositAmount) {
        addBankOperation(depositAmount);
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int withdrawAmount) {
        addBankOperation(-withdrawAmount);
    }

    private void addBankOperation(int amount) {
        balance += amount;
        operationList.add(new BankOperation(amount, balance));

    }

    public String printStatement() {
        StringBuilder statement = new StringBuilder(HEADER_STATEMENT);
        operationList.forEach(operation -> {
            statement.append("\n");
            statement.append(operation.printStatement());
        });
        return statement.toString();
    }
}

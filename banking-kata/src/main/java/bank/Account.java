package bank;

import java.util.ArrayList;
import java.util.List;


public class Account {

    public static final String COLUMN_SEPARATOR="\t";
    public static final String HEADER_STATEMENT = "Date"+COLUMN_SEPARATOR+"Amount"+COLUMN_SEPARATOR+"Balance\n";
    List<BankOperation> operationList = new ArrayList<>();
    int balance=0;

    public void deposit(int depositAmount) {
        balance += depositAmount;
        operationList.add(new BankOperation(depositAmount));

    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int withdrawAmount) {
        balance -= withdrawAmount;
        operationList.add(new BankOperation(-withdrawAmount));
    }

    public String printStatement() {
        StringBuilder statement = new StringBuilder(HEADER_STATEMENT);
        operationList.forEach(operation-> statement.append(operation.printStatement()));
        return statement.toString();
    }
}

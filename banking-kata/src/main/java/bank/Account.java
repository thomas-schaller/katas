package bank;

public class Account {
int balance=0;

    public void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int withdrawAmount) {
        balance -= withdrawAmount;
    }

    public String printStatement() {
        return "Date\tAmount\tBalance\n12.20.2025\t+200\t200";
    }
}

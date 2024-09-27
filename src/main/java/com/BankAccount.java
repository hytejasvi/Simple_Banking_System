package src.main.java.com;

import java.util.Optional;

public class BankAccount implements AccountOperations{
    private final String accountNumber;

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double balance;
    private final String BANK_NAME = "AccNo";
    private static int number = 1;

    private final String accountHolderName;

    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountNumber = BANK_NAME.concat(String.valueOf(number++));
        this.balance = initialBalance;
        this.accountHolderName = accountHolderName;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public Optional<String> getAccountHolderName() {
        return Optional.ofNullable(this.accountHolderName);
    }

    public double deposit(double amount) {
        this.balance = this.balance+amount;
        return checkBalance();
    }
    public double withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance = this.balance - amount;
        } else {
            System.out.println("Insufficient balance");
        }
        return checkBalance();
    }

    @Override
    public double checkBalance() {
        return this.balance;
    }
}

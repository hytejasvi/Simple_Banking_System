package src.main.java.com;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CurrentAccount extends BankAccount {


    private double overDraftAmountLimit;
    private double overDraftLimitPercentage;

    private List<String> transactionalLogs = new ArrayList<>();

    public double getOverDraftLimitPercentage() {
        return overDraftLimitPercentage;
    }

    public void setOverDraftLimitPercentage(double overDraftLimitPercentage) {
        this.overDraftLimitPercentage = overDraftLimitPercentage;
    }

    public double getOverDraftAmountLimit() {
        return overDraftAmountLimit;
    }

    public void setOverDraftAmountLimit(double overDraftLimitPercentage) {
        double currentBalance = this.checkBalance();
        if (currentBalance > 0) {
            this.overDraftAmountLimit = overDraftLimitPercentage * currentBalance;
        }
    }

    public CurrentAccount(String accountHolderName, double initialBalance, double overDraftLimitPercentage) {
        super(accountHolderName, initialBalance);
        setOverDraftLimitPercentage(overDraftLimitPercentage);
        setOverDraftAmountLimit(overDraftLimitPercentage);
    }

    @Override
    public double withdraw(double amount) {
        double maxAvailableAmount = this.checkBalance() + this.overDraftAmountLimit;
        if (amount > maxAvailableAmount) {
            System.out.println("Cannot withdraw, ! Entered Amount is exceeding the overdraft limit");
        } else {
            this.balance = this.balance-amount;
            setOverDraftAmountLimit(this.getOverDraftLimitPercentage());
            this.transactionalLogs.add("Withdrawn: " + amount + " | Balance: " + this.balance);
        }
        return checkBalance();
    }

    @Override
    public double deposit(double amount) {
        double balance = super.deposit(amount);
        setOverDraftAmountLimit(overDraftLimitPercentage);
        this.transactionalLogs.add("Deposited: " + amount + " | Balance: " + this.balance);
        return balance;
    }

    public List<String> getTransactionHistory() {
        return this.transactionalLogs;
    }

    /*public List<String> filterTransactions(String filter) {
        List<String> list = new ArrayList<>();
        for (String log : transactionalLogs) {
            if (log.startsWith(filter)) {
                list.add(log);
            }
        }
        return list;
    }*/ //traditional loop implememtation

    public List<String> filterTransactions(String filter) {
        //streams implementation of the above method
        return transactionalLogs.stream().filter(log->log.startsWith(filter)).collect(Collectors.toList());
    }
}

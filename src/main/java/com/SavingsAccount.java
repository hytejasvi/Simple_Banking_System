package src.main.java.com;

public class SavingsAccount extends BankAccount{

    public double interestRate;

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public SavingsAccount(String accountHolderName, double initialBalance, double intreseRate) {
        super(accountHolderName, initialBalance);
        setInterestRate(intreseRate);
    }


    public double calculateInterest() {
        double currentBalance = this.checkBalance();
        double newBalance = currentBalance + (currentBalance * (this.interestRate/100));
        this.setBalance(newBalance);
        return balance;
    }

}

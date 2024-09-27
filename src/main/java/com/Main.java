package src.main.java.com;

public class Main {
    public static void main(String[] args) {
        /*BankAccount account = new BankAccount("Tejas", 5000);
        System.out.println("Account Holder Name: "+account.getAccountHolderName());
        System.out.println("Account Number: "+account.getAccountNumber());
        System.out.println("Current Balance: "+account.checkBalance());
        System.out.println("withdraw amount 3500, current balance is: "+account.withdraw(3500));

        BankAccount account2 = new BankAccount("Karuna", 10000);
        System.out.println("Account Holder Name: "+account2.getAccountHolderName());
        System.out.println("Account Number: "+account2.getAccountNumber());
        System.out.println("Current Balance: "+account2.checkBalance());
        System.out.println("deposit amount 25000, current balance is: "+account2.deposit(25000));*/

        /*SavingsAccount sb = new SavingsAccount("Tejas", 5000, 6.5);
        System.out.println("Account Holder Name: "+sb.getAccountHolderName());
        System.out.println("Account Number: "+sb.getAccountNumber());
        System.out.println("Account deposit of 15000, balance: "+sb.deposit(15000));
        System.out.println("Balance without interest : "+sb.checkBalance());
        System.out.println("Balance with interest : "+sb.calculateInterest());*/

        CurrentAccount ca = new CurrentAccount("Tejas", 20000, 2);
        System.out.println("Account Holder Name: "+ca.getAccountHolderName());
        System.out.println("Account Number: "+ca.getAccountNumber());
        System.out.println("Overdraft Limit: "+ca.getOverDraftAmountLimit());
        System.out.println("Account deposit of 15000, balance: "+ca.deposit(15000));
        System.out.println("Overdraft Limit: "+ca.getOverDraftAmountLimit());
        ca.withdraw(5000);
        ca.withdraw(5001);
        ca.withdraw(5002);
        ca.withdraw(5003);
        ca.withdraw(5004);
        ca.withdraw(50000);
        //System.out.println("Account Withdrawal: "+ca.withdraw(60000));
        System.out.println(ca.getTransactionHistory());
        System.out.println(ca.filterTransactions("Withdraw"));
    }
}

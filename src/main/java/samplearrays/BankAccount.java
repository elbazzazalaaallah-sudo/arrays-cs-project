package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    double[] transaction = new double[1000];
    int numOfTransactions = 0;

    public BankAccount(String name, int startingBalance){
        System.out.println(name + " has "+startingBalance);
        this.name = name;
        currentBalance = startingBalance;
    }

    public void deposit(double amount){
        if (amount <0){
            System.out.println("Unsuccessful deposit");
        }else{
            transaction[numOfTransactions] = amount;
            numOfTransactions++;
            currentBalance += amount;
            System.out.println("Depositor's name : " +name+", deposited amount: "+amount+", new balance: "+currentBalance);
        }
    }

    public void withdraw(double amount){
        if (amount > currentBalance){
            System.out.println("Unsuccessful withdrawal");
        }else{
            transaction[numOfTransactions] = -amount;
            numOfTransactions++;
            currentBalance -= amount;
            System.out.println("Depositor's name : " +name+", withdrawn amount: "+amount+", new balance: "+currentBalance);
        }
    }

    public void displayTransactions(){
        for(int i=0; i<numOfTransactions; i++){
            System.out.println(transaction[i]);
        }
    }

    public void displayBalance(){
        System.out.println("Current balance : "+currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}

package com.ScottHorsburgh;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

class BankAccount {
    private Scanner input = new Scanner(System.in);
    private double balance = 0;
    private double expectedBalance;
    private double amount;
    private float interestRate = 10F;
    private String userCorrection;
    private NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);

    /**Constructor to initialize beginning balance.
     * @param initialBalance gives starting balance
     */
    public BankAccount(double initialBalance){
        balance =  initialBalance;
        customerMenu();
    }

    /*********** Public methods *************/
    public void makeDeposit(){
        deposit();
    }
    public void makeWithdraw(){
        withdraw();
    }
    public void checkBalance(){
        getBalance();
    }
    public void menuSelection(){
        customerMenu();
    }

    /***********  Private methods **************/

    /**Verifies deposit amount with user before proceeding.
     * Deposits amount into account.
     * Checks if deposit amount is a positive number else gives message to user.
     */
    private void deposit(){
        setAmountFormat();
        System.out.print("\nEnter deposit amount (e.g. xxx.xx): ");
        amount = input.nextDouble();
        System.out.println("Deposit amount: $" + nf.format(amount));
        System.out.print("Is this the correct amount? (Y/N) ");
        userCorrection = input.next();
        if(amount >= 0 && userCorrection.equals("Y".toLowerCase())) {
            balance += amount;
            System.out.println("\nNew balance: $" + nf.format(showNewBalance()));
        }
        else{
            System.out.println("**Invalid amount to deposit");
        }
    }

    /**Verifies withdraw amount with account balance.
     * Ask user if amount is correct before proceeding with withdraw.
     * Shows message to user if withdraw exceeds account balance.
     */
    private void withdraw(){
       setAmountFormat();
        System.out.print("\nEnter withdraw amount (e.g. xxx.xx): ");
        amount = input.nextDouble();
        System.out.println("Withdraw amount: $" + nf.format(amount));
        System.out.print("Is this the correct amount? (Y/N) ");
        userCorrection = input.next();
        if (balance > amount && userCorrection.equals("Y".toLowerCase())) {
            balance -= amount;
            System.out.println("\nNew balance: $" + nf.format(showNewBalance()));
        }
        else{
            System.out.println("Insufficient funds please try again...");
        }
    }

    /**Gets current balance and expected balance with interest of account.
     * @return the current account balance
     */
    private void getBalance(){
        System.out.println("\nCurrent balance: $" + nf.format(balance));
        System.out.println("Expected balance with interest: $" + nf.format(balanceWithInterest()));
        System.out.println("Current interest rate: " + interestRate + "%");
    }

    /**gets updated balance after a deposit or withdraw.
     * @return returns new balance
     */
    private double showNewBalance(){
        return balance;
    }

    /**balance of account with current interest applied.
     * @return the balance with current interest
     */
    private double balanceWithInterest(){
        expectedBalance = balance + (balance * interestRate / 100);
        return expectedBalance;
    }

    /** prints out the main menu for user selection.
     */
    private void customerMenu(){
        System.out.println("\nWelcome to Banking");
        System.out.println("-----------------------------");
        System.out.println("[1] Make deposit\n[2] Make withdraw\n[3] Check balance");
        System.out.println("-----------------------------");
    }

    /** Sets currency amounts in U.S format for user.
     * Example of currency format $000,000,000.00
      */
    private void setAmountFormat(){
        // for trailing zeros:
        nf.setMinimumFractionDigits(2);
        // round to 2 digits:
        nf.setMaximumFractionDigits(2);
    }
}

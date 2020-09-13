package com.ScottHorsburgh;

import java.util.Scanner;

public class BankAccountTester extends BankAccount {

    /**
     * Constructor to initialize beginning balance.
     *
     * @param initialBalance gives starting balance
     */
    public BankAccountTester(double initialBalance) {
        super(initialBalance);
    }

    public static void main(String[] args) {

        /** ------ testing --------*/

        /*
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.ENGLISH);
	    BankAccount bankAccount = new BankAccount(1000);
	    bankAccount.withdraw(500);
	    bankAccount.withdraw(400);
        System.out.println("Balance: $" + nf.format(bankAccount.getBalance()));
        */

        Scanner input = new Scanner(System.in);
        BankAccount momsSavings = new BankAccount(1000);
        int userMenuSelection;
        String selection;

        do {
            System.out.print("Enter a number: ");
            userMenuSelection = input.nextInt();
            switch (userMenuSelection) {
                case 1:
                    momsSavings.makeDeposit();
                    break;
                case 2:
                    momsSavings.makeWithdraw();
                    break;
                case 3:
                    momsSavings.checkBalance();
                    break;
                case 4:
                    System.out.println("Thanks for your business!\n");
                    break;
                default:
                    System.out.println("** Enter a number 1 - 3 from menu");
            }
            System.out.print("\nWould you like to make another selection? (Y/N) ");
            selection = input.next();
            if(selection.equals("Y".toLowerCase()))
                momsSavings.menuSelection();
        } while (selection.equals("Y".toLowerCase()));
        input.close();
    }
}

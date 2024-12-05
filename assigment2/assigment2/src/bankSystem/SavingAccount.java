package bankSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SavingAccount extends Bankaccount implements Reportable{
    Scanner scanner = new Scanner(System.in);
    private double minimumBalance = 1000 ;


    public SavingAccount() {

        super();
    }
    public SavingAccount(int accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void withdraw() {
        double value = 0;
        while (true) {
            try {
                System.out.print("Enter amount to withdraw: ");
                value = scanner.nextDouble();
                if (value <= 0) {
                    System.out.println("Please enter a valid withdrawal amount greater than zero.");
                } else if (getBalance() - value < minimumBalance) {
                    System.out.println("Error: New balance cannot go below the minimum balance of " + minimumBalance);
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.nextLine();
            }
        }
        setBalance(getBalance() - value);
        recordtransactionHistory("Withdraw", value);
        System.out.println("Withdrawal successful, Remaining Balance: " + getBalance());
    }


    public void accountsummaries() {
        System.out.println(" FOR The Saving Account , the account summaries is ");
        displaydetails();
        System.out.println("Minimum Balance: " + minimumBalance);
    }


    ///////////////////////////////////////////////////////////////////////////////
    public void calculateAndAddInterest() {

        System.out.print("Enter annual interest rate (as a percentage, e.g., 5 for 5%): ");
        double annualInterestRate;
        double years;
        while (true) {
            try {
                annualInterestRate = scanner.nextDouble();
                if (annualInterestRate <= 0) {
                    System.out.println("Please enter a valid positive interest rate.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.nextLine();
            }
        }

        System.out.print("Enter the time period in years: ");
        while (true) {
            try {
                years = scanner.nextDouble();
                if (years <= 0) {
                    System.out.println("Please enter a valid positive time period.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.nextLine();
            }
        }


        double interest = (getBalance() * annualInterestRate * years) / 100;
        setBalance(getBalance() + interest);


        recordtransactionHistory("Interest Added", interest);

        System.out.println("Interest of " + interest + " added for " + years +
                " years at an annual rate of " + annualInterestRate + "%.");
        System.out.println("Updated Balance: " + getBalance());
    }
}


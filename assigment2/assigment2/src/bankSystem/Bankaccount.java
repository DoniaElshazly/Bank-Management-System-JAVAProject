package bankSystem;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bankaccount implements Reportable {
    Scanner scanner = new Scanner(System.in);
    private int accountNumber;
    private String accountHolderName ;
    private double balance;
    private ArrayList<String>transaction= new ArrayList<String>();
//////////////////////////////////////////////////////////////////////

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<String> getTransaction() {
        return transaction;
    }

    ////////////////////////////////////////////////////////////////////////////////
public Bankaccount(){

}
    public Bankaccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    ///////////////////////////////////////////////////////////////////////////////
    public void displaydetails(){
        System.out.println("The account number : "+ accountNumber);
        System.out.println("The account holder name : "+ accountHolderName);
        System.out.println("The balance is : "+ balance);

    }


//////////////////////////////////////////////////////////////////////////////
    public void checkBalance(){

            System.out.println("the balance is "+ balance);
    }

///////////////////////////////////////////////////////////////////////////
public void deposit() {
    double value = 0;
    while (true) {
        try {
            System.out.print("Enter amount to deposit: ");
            value = scanner.nextDouble();
            if (value <= 0) {
                System.out.println("Please enter a valid deposit amount greater than zero.");
            } else {
                break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a numeric value.");
            scanner.nextLine();
        }
    }
    this.balance = this.balance + value;
    recordtransactionHistory("Deposit", value);
    System.out.println("Deposit added successfully, Account Balance: " + balance);
}


////////////////////////////////////////////////////////////////////////////////

    public void withdraw() {
        double value = 0;
        while (true) {
            try {
                System.out.print("Enter amount to withdraw: ");
                value = scanner.nextDouble();
                if (value <= 0) {
                    System.out.println("Please enter a valid withdrawal amount greater than zero.");
                } else if (value > balance) {
                    System.out.println("Insufficient funds. Available balance: " + balance);
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.nextLine();
            }
        }
        this.balance -= value;
        recordtransactionHistory("Withdraw", value);
        System.out.println("Withdrawal successful, Remaining Balance: " + balance);
    }


///////////////////////////////////////////////////////////////////////////////////

        public void recordtransactionHistory(String transactionType,double value){

            String arrayData = "The Ttransaction Type is " + transactionType + " with value " + value + " tha Total Balance is " + balance;
            transaction.add(arrayData);


        }

/////////////////////////////////////////////////////////////////////////////////////

        public void displayTransactionHistory(){
            if (transaction.isEmpty()){
                System.out.println(" There Is No Transaction yet ");
            }
            else {
                System.out.println(" The Transactions is : ");
                for (int i = 0; i < transaction.size(); i++) {
                    System.out.println(transaction.get(i));
                }
            }

        }
    public void accountsummaries() {
        System.out.println("FOR Current Account , the account summaries is ");
        displaydetails();

    }

}

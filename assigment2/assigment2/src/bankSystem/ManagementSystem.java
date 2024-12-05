package bankSystem;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManagementSystem {
    private Bankaccount selectedAccount;

    public ManagementSystem(int accountNumber, String accountHolderName, double balance) {
        Scanner scan = new Scanner(System.in);

        System.out.println("For current account press 1:");
        System.out.println("For saving account press 2 :");
        String accountType = scan.nextLine();
        if (accountType.equals("2")) {
            selectedAccount = new SavingAccount(accountNumber, accountHolderName, balance);

        } else {
            selectedAccount = new Bankaccount(accountNumber, accountHolderName, balance);

        }
    }

    public void displayMenu() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("- To deposit press 1");
                System.out.println("- To withdraw press 2");
                System.out.println("- To check the Balance press 3");
                System.out.println("- To view transaction history press 4");
                System.out.println("- To view Account summaries press 5");
                System.out.println("- To calculate and add interest (Savings Account only) press 6");
                System.out.println("- To exit press 7");
                System.out.print("Please enter one of these options: ");

                int option = scan.nextInt();

                switch (option) {
                    case 1 :
                        selectedAccount.deposit();
                        System.out.println(" ");
                        break;

                    case 2 :
                        selectedAccount.withdraw();
                        System.out.println(" ");

                        break;
                    case 3 :
                        selectedAccount.checkBalance();
                        System.out.println(" ");

                        break;
                    case 4 :
                        selectedAccount.displayTransactionHistory();
                        System.out.println(" ");

                        break;
                    case 5 :
                        selectedAccount.accountsummaries();
                        System.out.println(" ");

                        break;
                    case 6 :
                    {
                        if (selectedAccount instanceof SavingAccount savingAccount) {
                            savingAccount.calculateAndAddInterest();
                        } else {
                            System.out.println("Interest calculation is only available for Savings Accounts.");
                            System.out.println(" ");

                        }
                        break;
                    }
                    case 7 :
                    {
                        System.out.println("Thank you for using our banking system!");
                        return; // Exit the method
                    }
                    default :
                        System.out.println("Invalid option, please enter a number between 1 and 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value for the menu option.");
                scan.nextLine(); // Clear invalid input
            }
        }
    }

}

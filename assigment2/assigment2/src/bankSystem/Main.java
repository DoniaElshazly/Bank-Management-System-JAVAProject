package bankSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bankaccount A = new Bankaccount();
        Scanner scanner = new Scanner(System.in);

        System.out.println("- Enter The account number:");
        int accountNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("- Enter The account holder name:");
        String accountHolderName = scanner.nextLine();

        System.out.println("- Enter The initial balance:");
        double balance = scanner.nextDouble();

        ManagementSystem managementSystem = new ManagementSystem(accountNumber, accountHolderName, balance);
        managementSystem.displayMenu();

    }
}

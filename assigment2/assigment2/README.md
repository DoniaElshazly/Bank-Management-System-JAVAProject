# Bank Management System

This is a simple Bank Management System built using Java. It allows users to create a bank account (current or savings), deposit and withdraw money, view transaction history, and calculate interest for savings accounts. The system uses object-oriented programming principles to model accounts and transactions.

## Features

- **Create Bank Accounts**: Users can create a bank account (current or savings).
- **Deposit and Withdraw Funds**: Users can deposit or withdraw money from their account.
- **Check Balance**: Users can view the current balance of their account.
- **Transaction History**: Users can view all transactions that have been made on the account.
- **Account Summaries**: Displays basic account details.
- **Interest Calculation**: Only available for savings accounts. It calculates and adds interest to the balance.
- **Exception Handling**: The system handles invalid inputs and exceptions (e.g., non-numeric input or withdrawal of more money than the balance).

## Classes

- **BankAccount**: The base class that represents a general bank account with basic functionalities like deposit, withdraw, and check balance.
- **SavingAccount**: A subclass of `BankAccount` that adds interest calculation functionality for savings accounts.
- **ManagementSystem**: Manages the user's interactions with the bank system. It handles the menu options and delegates tasks to the `BankAccount` or `SavingAccount` classes.
- **Main**: The entry point of the program, where the user is prompted to create a bank account and interact with the system.

import java.util.Scanner;

public class BankingApp {
    private double balance;
    private final Scanner scanner;

    public BankingApp() {
        balance = 0.0;
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n=== Simple Banking Menu ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using our banking services!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private void checkBalance() {
        System.out.printf("Your current balance is: $%.2f\n", balance);
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited $%.2f\n", amount);
        } else {
            System.out.println("Invalid amount! Please enter a positive number.");
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Successfully withdrew $%.2f\n", amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            System.out.println("Invalid amount! Please enter a positive number.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Simple Banking App!");
        BankingApp bank = new BankingApp();
        bank.showMenu();
    }
}

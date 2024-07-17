import java.util.Scanner;

public class ATMSystem {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // initial balance
        ATM atm = new ATM(account);
        atm.displayMenu();
    }

    static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public double getBalance() {
            return balance;
        }

        public boolean deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                return true;
            } else {
                return false;
            }
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                return true;
            } else {
                return false;
            }
        }
    }

    static class ATM {
        private BankAccount account;

        public ATM(BankAccount account) {
            this.account = account;
        }

        public void displayMenu() {
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;

            while (!exit) {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit(scanner);
                        break;
                    case 3:
                        withdraw(scanner);
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }

            System.out.println("Thank you for using the ATM. Goodbye!");
            scanner.close();
        }

        private void checkBalance() {
            System.out.printf("Your current balance is: $%.2f\n", account.getBalance());
        }

        private void deposit(Scanner scanner) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            if (account.deposit(amount)) {
                System.out.printf("Successfully deposited $%.2f. Your new balance is: $%.2f\n", amount, account.getBalance());
            } else {
                System.out.println("Invalid deposit amount. Please try again.");
            }
        }

        private void withdraw(Scanner scanner) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            if (account.withdraw(amount)) {
                System.out.printf("Successfully withdrew $%.2f. Your new balance is: $%.2f\n", amount, account.getBalance());
            } else {
                System.out.println("Insufficient balance or invalid withdrawal amount. Please try again.");
            }
        }
    }
}

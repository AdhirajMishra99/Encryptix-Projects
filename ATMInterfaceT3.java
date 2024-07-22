import java.util.Scanner;
public class ATMInterfaceT3 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("ATM Interface:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("5. Transfer");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.printf("Your current balance is: %.2f\n", atm.checkBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye, Have A Nice day!");
                    scanner.close();
                    System.exit(0);
                case 5:
                System.out.print("Enter the account number to transfer to: ");
                int transferAccountNumber = scanner.nextInt();
                System.out.print("Enter the amount to transfer: ");
                double transferAmount = scanner.nextDouble();
                atm.transferAmount(transferAmount, transferAccountNumber);
                break;
                default:
                    System.out.println("Invalid choice!. Please try again.");
            }
        }
    }
}
class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return;
        }
        balance -= amount;
        System.out.printf("Successfully withdrew %.2f. Your new balance is: %.2f\n", amount, balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.printf("Successfully deposited %.2f. Your new balance is: %.2f\n", amount, balance);
    }

    public double getBalance() {
        return balance;
    }
}
class ATM {
    private BankAccount account;
    public ATM(BankAccount account) {
        this.account = account;
    }
    public void withdraw(double amount) {
        account.withdraw(amount);
    }
    public void deposit(double amount) {
        account.deposit(amount);
    }
    public double checkBalance() {
        return account.getBalance();
    }
    public void transferAmount(double amount, int accountNumber) {
        if (amount > account.getBalance()) {
            System.out.println("Insufficient balance.");
            return;
        }
        account.withdraw(amount);
        System.out.printf("Successfully transferred %.2f to account %d. Your new balance is: %.2f\n", amount, accountNumber, account.getBalance());
    }
}
import java.util.*;

class ATM {
    private double balance = 1000.0; // initial balance
    private final int PIN = 1234;

    public boolean checkPin(int enteredPin) {
        return enteredPin == PIN;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("₹" + amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        if (atm.checkPin(pin)) {
            int choice;
            do {
                System.out.println("\n1.Deposit  2.Withdraw  3.Balance  4.Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter amount to deposit: ");
                        atm.deposit(sc.nextDouble());
                    }
                    case 2 -> {
                        System.out.print("Enter amount to withdraw: ");
                        atm.withdraw(sc.nextDouble());
                    }
                    case 3 -> atm.checkBalance();
                    case 4 -> System.out.println("Thank you! Goodbye.");
                    default -> System.out.println("Invalid choice!");
                }
            } while (choice != 4);
        } else {
            System.out.println("Incorrect PIN!");
        }

        sc.close();
    }
}

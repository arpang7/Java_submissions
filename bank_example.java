package lab.assignments;

/* Demonstrates method overriding using a simple banking domain. */

class BankAccount {
    /**
     * Returns the annual interest rate as a fraction.
     * Example: 0.05 means 5%
     */
    public double interestRate() {
        return 0.0; // Default for generic bank account
    }
}

class SavingsAccount extends BankAccount {
    @Override
    public double interestRate() {
        return 0.05; // 5% annual interest
    }
}

class CurrentAccount extends BankAccount {
    @Override
    public double interestRate() {
        return 0.02; // 2% annual interest
    }
}

public class bank_example {
    public static void main(String[] args) {
        // Polymorphism: base-class reference pointing to derived objects
        BankAccount[] accounts = {
                new SavingsAccount(),
                new CurrentAccount()
        };

        for (BankAccount account : accounts) {
            String type = account.getClass().getSimpleName();
            System.out.printf("%s interest rate: %.2f%%%n", type, account.interestRate() * 100);
        }
    }
}


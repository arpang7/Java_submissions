package lab.assignments;

/**
 * BankAccountFinal - Demonstrates using the 'final' keyword for an account number
 * that cannot be changed after object creation.
 * 
 * Key Concepts:
 * 1. final instance variable (accountNumber) - assigned once in constructor
 * 2. No setter for the final field - compiler enforces immutability
 * 3. Attempting to reassign the final field causes a compile-time error
 */
public class BankAccountFinal {

    // ============================================================
    // INSTANCE VARIABLES
    // ============================================================
    
    // FINAL field: account number can only be set once (in constructor)
    private final String accountNumber;
    
    // Non-final fields: can be modified after creation
    private String accountHolderName;
    private double balance;

    // ============================================================
    // CONSTRUCTOR
    // ============================================================
    
    /**
     * Constructor - initializes all fields including the final accountNumber.
     * The final field MUST be assigned exactly once, either at declaration
     * or in every constructor.
     */
    public BankAccountFinal(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;   // Final field assigned here
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // ============================================================
    // GETTERS (No setter for accountNumber - it's final!)
    // ============================================================
    
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // ============================================================
    // SETTERS (Only for non-final fields)
    // ============================================================
    
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    // ============================================================
    // BUSINESS METHODS
    // ============================================================
    
    /**
     * Deposits the specified amount into the account.
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount: " + amount);
        }
    }

    /**
     * Withdraws the specified amount if sufficient balance exists.
     */
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Available: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount: " + amount);
        }
    }

    /**
     * Displays complete account information.
     */
    public void displayAccountInfo() {
        System.out.println("=====================================");
        System.out.println("      BANK ACCOUNT DETAILS");
        System.out.println("=====================================");
        System.out.println("Account Number    : " + accountNumber);
        System.out.println("Account Holder    : " + accountHolderName);
        System.out.println("Balance           : $" + balance);
        System.out.println("Account # is final: " + isImmutable());
        System.out.println("=====================================");
    }

    /**
     * Demonstrates that the account number reference is immutable.
     */
    private String isImmutable() {
        return "YES (cannot be changed after creation)";
    }

    // ============================================================
    // MAIN METHOD - DEMONSTRATION
    // ============================================================
    
    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println("  BANK ACCOUNT — DEMONSTRATING final KEYWORD");
        System.out.println("================================================\n");

        // ---- 1. Create a new bank account (account number is set via constructor) ----
        System.out.println(">>> CREATING ACCOUNT...");
        BankAccountFinal account = new BankAccountFinal("ACC-1001-2024", "Alice Johnson", 5000.0);
        account.displayAccountInfo();
        System.out.println();

        // ---- 2. Demonstrate that account number CANNOT be changed ----
        System.out.println(">>> DEMONSTRATING final FIELD BEHAVIOR:");
        System.out.println("    - accountNumber is declared 'final', so it cannot be reassigned.");
        System.out.println("    - There is NO setter for accountNumber — the compiler enforces this.");
        System.out.println("    - The account number remains: " + account.getAccountNumber());
        System.out.println();

        /* 
         *  COMPILE ERROR DEMONSTRATION (uncomment to see the error):
         *  
         *  account.accountNumber = "NEW-ACCOUNT";  
         *  // ERROR: cannot assign a value to final variable accountNumber
         *  
         *  OR if we had a setter:
         *  account.setAccountNumber("NEW-ACCOUNT"); 
         *  // ERROR: cannot find symbol (no setter exists)
         * 
         *  The 'final' keyword guarantees the account number
         *  remains constant throughout the object's lifetime.
         */

        // ---- 3. Modify non-final fields (these are allowed!) ----
        System.out.println(">>> MODIFYING NON-FINAL FIELDS (allowed):");
        account.setAccountHolderName("Alice Johnson-Smith");  // Name change is allowed
        System.out.println("    Account holder updated to: " + account.getAccountHolderName());
        System.out.println();

        // ---- 4. Perform transactions ----
        System.out.println(">>> PERFORMING TRANSACTIONS:");
        account.deposit(1500.0);
        account.withdraw(2000.0);
        account.withdraw(5000.0);  // Should show insufficient balance
        System.out.println();

        // ---- 5. Display final state ----
        account.displayAccountInfo();
        System.out.println();

        // ---- 6. Create a second account to show different final values ----
        System.out.println(">>> SECOND ACCOUNT (different final account number):");
        BankAccountFinal account2 = new BankAccountFinal("ACC-1002-2024", "Bob Williams", 10000.0);
        account2.displayAccountInfo();
        System.out.println();

        // ---- 7. final local variable example ----
        System.out.println(">>> FINAL LOCAL VARIABLE DEMO:");
        final String bankName = "National Bank";
        System.out.println("    Bank: " + bankName);
        // bankName = "Other Bank";  // Would cause compile error!
        System.out.println("    (bankName is a 'final' local variable — also immutable)");
        System.out.println();

        // ---- Summary ----
        System.out.println("================================================");
        System.out.println("  SUMMARY: final KEYWORD BEHAVIOR");
        System.out.println("================================================");
        System.out.println("  ✓ accountNumber is declared as 'private final String'");
        System.out.println("  ✓ It is assigned once in the constructor");
        System.out.println("  ✓ No setter method exists for accountNumber");
        System.out.println("  ✓ Any reassignment attempt causes a compile-time error");
        System.out.println("  ✓ Non-final fields (name, balance) remain modifiable");
        System.out.println("================================================");
    }
}
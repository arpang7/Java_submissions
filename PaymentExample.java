package lab.assignments;

import java.util.UUID;

abstract class Payment {
    protected String transactionId;
    protected double amount;
    protected String status;

    public Payment(double amount) {
        this.transactionId = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.amount = amount;
        this.status = "PENDING";
    }

    // Abstract method to be implemented by subclasses
    abstract void processPayment();

    // Concrete method to get transaction details
    public String getTransactionDetails() {
        return "Transaction ID: " + transactionId +
               "\nAmount: $" + String.format("%.2f", amount) +
               "\nStatus: " + status;
    }
}

class CreditCard extends Payment {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;

    public CreditCard(double amount, String cardNumber, String cardHolderName, String expiryDate) {
        super(amount);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
    }

    @Override
    void processPayment() {
        // Basic card validation
        if (cardNumber == null || cardNumber.length() != 16) {
            this.status = "FAILED";
            System.out.println("Credit Card Payment Failed: Invalid card number (must be 16 digits).");
            return;
        }
        if (cardHolderName == null || cardHolderName.isEmpty()) {
            this.status = "FAILED";
            System.out.println("Credit Card Payment Failed: Card holder name is required.");
            return;
        }
        if (expiryDate == null || !expiryDate.matches("\\d{2}/\\d{2}")) {
            this.status = "FAILED";
            System.out.println("Credit Card Payment Failed: Invalid expiry date (use MM/YY format).");
            return;
        }

        this.status = "SUCCESS";
        System.out.println("Credit Card Payment Successful!");
        System.out.println("Card Holder: " + cardHolderName);
        System.out.println("Card Number: **** **** **** " + cardNumber.substring(cardNumber.length() - 4));
    }
}

class UPI extends Payment {
    private String upiId;

    public UPI(double amount, String upiId) {
        super(amount);
        this.upiId = upiId;
    }

    @Override
    void processPayment() {
        // Basic UPI ID validation
        if (upiId == null || !upiId.matches("[a-zA-Z0-9._-]+@[a-zA-Z]+")) {
            this.status = "FAILED";
            System.out.println("UPI Payment Failed: Invalid UPI ID format (e.g., name@bank).");
            return;
        }

        this.status = "SUCCESS";
        System.out.println("UPI Payment Successful!");
        System.out.println("UPI ID: " + upiId);
    }
}

public class PaymentExample {
    public static void main(String[] args) {
        System.out.println("=== Payment Processing System ===\n");

        // Test Credit Card Payment
        System.out.println("--- Credit Card Payment ---");
        Payment creditCardPayment = new CreditCard(250.75, "1234567890123456", "Arpan Gupta", "12/26");
        creditCardPayment.processPayment();
        System.out.println(creditCardPayment.getTransactionDetails());
        System.out.println();

        // Test UPI Payment
        System.out.println("--- UPI Payment ---");
        Payment upiPayment = new UPI(89.50, "arpan.gupta@oksbi");
        upiPayment.processPayment();
        System.out.println(upiPayment.getTransactionDetails());
        System.out.println();

        // Test invalid Credit Card
        System.out.println("--- Invalid Credit Card Payment ---");
        Payment invalidCard = new CreditCard(100.00, "1234", "John Doe", "13/25");
        invalidCard.processPayment();
        System.out.println(invalidCard.getTransactionDetails());
        System.out.println();

        // Test invalid UPI
        System.out.println("--- Invalid UPI Payment ---");
        Payment invalidUPI = new UPI(50.00, "invalid-upi");
        invalidUPI.processPayment();
        System.out.println(invalidUPI.getTransactionDetails());
    }
}
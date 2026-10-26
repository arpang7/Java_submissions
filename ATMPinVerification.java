package lab.assignments;

import java.util.Scanner;

// Custom Exception for Invalid PIN
class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}

public class ATMPinVerification {
    private static final String VALID_PIN = "4821";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Insert ATM Card. Enter 4-digit PIN: ");
            String enteredPin = scanner.nextLine();

            if (!VALID_PIN.equals(enteredPin)) {
                throw new InvalidPinException("Incorrect PIN entered. Transaction denied.");
            }

            System.out.println("PIN verified successfully! Access granted to account.");

        } catch (InvalidPinException e) {
            System.err.println("Security Alert: " + e.getMessage());
        } finally {
            // Guaranteed to run, providing explicit completion feedback
            scanner.close();
            System.out.println("Verification process has completed. Please take your card.");
        }
    }
}
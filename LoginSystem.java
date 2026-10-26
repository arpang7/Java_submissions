package lab.assignments;

import java.util.Scanner;

// Custom Exception for Invalid Password
class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

public class LoginSystem {
    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "Password@123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (!CORRECT_USERNAME.equals(username) || !CORRECT_PASSWORD.equals(password)) {
                throw new InvalidPasswordException("Authentication failed: Incorrect username or password.");
            }

            System.out.println("Login successful! Welcome, " + username + ".");

        } catch (InvalidPasswordException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            // Closes resource and always runs regardless of exceptions
            scanner.close();
            System.out.println("Session closed. Resources cleaned up.");
        }
    }
}
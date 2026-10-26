package lab.assignments;

import java.util.Scanner;

class InvalidAgeForDriverLicense extends Exception {
    public InvalidAgeForDriverLicense(String message) {
        super(message);
    }
}

public class Driver_License {
    public static void validateAge(int age) throws InvalidAgeForDriverLicense {
        if (age < 18) {
            throw new InvalidAgeForDriverLicense("Age must be at least 18 to apply for a driver's license.");
        } else {
            System.out.println("Valid age: " + age);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        try {
            validateAge(age);
        } catch (InvalidAgeForDriverLicense e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Age validation completed.");
        }

        sc.close();
    }
}
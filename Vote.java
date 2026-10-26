package lab.assignments;

import java.util.Scanner;

class InvalidAge extends Exception {
    public InvalidAge(String message) {
        super(message);
    }
}

public class Vote {
    public static void validateAge(int age) throws InvalidAge {
        if (age < 18) {
            throw new InvalidAge("Age must be at least 18.");
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
        } catch (InvalidAge e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Age validation completed.");
        }

        sc.close();
    }
}
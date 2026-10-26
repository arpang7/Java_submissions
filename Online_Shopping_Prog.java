package lab.practice;

import java.util.Scanner;

public class Online_Shopping_Prog {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter product quantity: ");
            int quantity = sc.nextInt();

            if (quantity <= 0) {
                throw new IllegalArgumentException(
                    "Product quantity must be greater than zero."
                );
            }

            System.out.println("Product quantity: " + quantity);
            System.out.println("Order placed successfully.");
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
package lab.assignments;

/**
 * StudentMarks - Demonstrates converting student marks from String format 
 * to Integer objects using Wrapper class (Integer.valueOf()) and 
 * calculating total marks via auto-unboxing.
 */

public class StudentMarks {
    public static void main(String[] args) {
        // Step 1: Student marks in String format (as received from input/DB)
        String[] marksInString = {"85", "90", "78", "92", "88"};

        // Step 2: Convert String marks to Integer objects using Wrapper class
        Integer[] marksInInteger = new Integer[marksInString.length];
        for (int i = 0; i < marksInString.length; i++) {
            marksInInteger[i] = Integer.valueOf(marksInString[i]); // String → Integer
        }

        // Step 3: Calculate total marks (auto-unboxing Integer → int)
        int totalMarks = 0;
        for (Integer mark : marksInInteger) {
            totalMarks += mark; // Auto-unboxing: Integer.intValue() called automatically
        }

        // Step 4: Display results
        System.out.println("=== Student Marks Report ===");
        System.out.println("Original String marks:");
        for (String mark : marksInString) {
            System.out.print(mark + "  ");
        }

        System.out.println("\n\nConverted Integer objects:");
        for (Integer mark : marksInInteger) {
            System.out.print(mark + "  ");
        }

        System.out.println("\n\nTotal Marks (via Wrapper conversion + unboxing): " + totalMarks);

        // Bonus: Demonstrate explicit unboxing using intValue()
        System.out.println("\n--- Explicit Unboxing Demo ---");
        Integer explicitInteger = Integer.valueOf("97");
        int explicitInt = explicitInteger.intValue(); // Explicit unboxing
        System.out.println("String \"97\" → Integer object: " + explicitInteger);
        System.out.println("Integer object → int via intValue(): " + explicitInt);
    }
}
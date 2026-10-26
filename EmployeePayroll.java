package lab.assignments;

import java.util.Scanner;

/**
 * EmployeePayroll - Demonstrates the use of Wrapper classes (Integer, Double)
 * for converting user input, validating salary values, and calculating net salary
 * with auto-unboxing and explicit unboxing.
 */

public class EmployeePayroll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========== Employee Payroll System ==========\n");

        // ---------- Step 1: Accept Employee ID ----------
        System.out.print("Enter Employee ID: ");
        String empIdStr = scanner.nextLine();
        Integer employeeId = Integer.valueOf(empIdStr); // String → Integer wrapper
        System.out.println("✓ Employee ID (Wrapper Integer): " + employeeId);
        System.out.println("  (Using intValue() explicitly: " + employeeId.intValue() + ")\n");

        // ---------- Step 2: Accept Basic Salary ----------
        System.out.print("Enter Basic Salary: ");
        String basicSalaryStr = scanner.nextLine();
        Double basicSalary = Double.valueOf(basicSalaryStr); // String → Double wrapper

        // ---------- Step 3: Validate Basic Salary ----------
        if (basicSalary <= 0) {
            System.out.println("✗ ERROR: Basic salary must be greater than 0.");
            scanner.close();
            return;
        }
        System.out.println("✓ Basic Salary (Wrapper Double): " + basicSalary);
        System.out.println("  (Using doubleValue() explicitly: " + basicSalary.doubleValue() + ")\n");

        // ---------- Step 4: Accept Bonus Amount ----------
        System.out.print("Enter Bonus Amount: ");
        String bonusStr = scanner.nextLine();
        Double bonus = Double.valueOf(bonusStr); // String → Double wrapper

        // ---------- Step 5: Validate Bonus ----------
        if (bonus < 0) {
            System.out.println("✗ ERROR: Bonus amount cannot be negative.");
            System.out.println("  Setting bonus to 0.0 (default).");
            bonus = Double.valueOf(0.0);
        }
        System.out.println("✓ Bonus (Wrapper Double): " + bonus);
        System.out.println("  (Using doubleValue() explicitly: " + bonus.doubleValue() + ")\n");

        // ---------- Step 6: Calculate Net Salary (auto-unboxing) ----------
        double netSalary = basicSalary + bonus; // Auto-unboxing: Double → double
        System.out.println("--- Calculation (auto-unboxing) ---");
        System.out.println("  Net Salary = Basic Salary + Bonus");
        System.out.println("  Net Salary = " + basicSalary + " + " + bonus + " = " + netSalary + "\n");

        // ---------- Step 7: Display Payroll Summary ----------
        System.out.println("========== Payroll Summary ==========");
        System.out.println("Employee ID            : " + employeeId);
        System.out.println("Basic Salary           : ₹ " + String.format("%.2f", basicSalary));
        System.out.println("Bonus                  : ₹ " + String.format("%.2f", bonus));
        System.out.println("------------------------------------");
        System.out.println("Net Salary             : ₹ " + String.format("%.2f", netSalary));
        System.out.println("====================================\n");

        // ---------- Step 8: Bonus Demo - Explicit Unboxing ----------
        System.out.println("--- Explicit Unboxing Demo ---");
        int rawEmpId = employeeId.intValue();       // Integer → int
        double rawBasic = basicSalary.doubleValue(); // Double → double
        double rawBonus = bonus.doubleValue();       // Double → double
        double rawNet = rawBasic + rawBonus;
        System.out.println("Employee ID (int)          : " + rawEmpId);
        System.out.println("Basic Salary (double)      : " + rawBasic);
        System.out.println("Bonus (double)             : " + rawBonus);
        System.out.println("Net Salary (double)        : " + rawNet);

        scanner.close();
    }
}
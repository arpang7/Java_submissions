package lab.assignments;

public class Try_Catch {
    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 0;
        try {
            int a = num1 / num2; // This will throw an ArithmeticException
            System.out.println("Result: " + a);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
            System.out.println("Exception Message: " + e.getMessage());
        } finally {
            System.out.println("Execution completed.");
        }
    }
}
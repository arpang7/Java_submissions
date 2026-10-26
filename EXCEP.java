package lab.assignments;

public class EXCEP {
    public static void main(String[] args) {
        try {
            int[] n = new int[5];
            int divisor = 0;

            for (int i = 0; i < n.length; i++) {
                int result = n[i] / divisor; // This will throw an ArithmeticException
                System.out.println("Result: " + result);
            }
        } catch (ArithmeticException e) {
            throw new RuntimeException("Error: Division by zero is not allowed.", e);
        }
    }
}
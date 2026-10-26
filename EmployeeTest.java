package lab.assignments;

// =====================================
// Driver Class to Demonstrate Polymorphism
// =====================================
public class EmployeeTest {
    public static void main(String[] args) {
        System.out.println("========== PRINTABLE INTERFACE DEMONSTRATION ==========");
        System.out.println("Demonstrating Interface Implementation & Polymorphism\n");

        // Creating Student and Employee objects
        Student student = new Student("John", 20);
        Employee employee = new Employee(1001, "Alice", "Engineering", 75000.00);

        // Using Printable interface reference (polymorphism)
        Printable[] printableItems = {student, employee};

        for (Printable item : printableItems) {
            item.printDetails();
            System.out.println("-----------------------------");
        }

        System.out.println("\n========== DEMONSTRATED SUCCESSFULLY ==========");
        System.out.println("Interface: Printable");
        System.out.println("Implementations: Student, Employee");
        System.out.println("Polymorphism: Both stored as Printable references");
    }
}
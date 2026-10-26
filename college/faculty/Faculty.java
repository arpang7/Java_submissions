package lab.college.faculty;

/**
 * Faculty class representing a college faculty member.
 * Part of the lab.college.faculty package.
 */
public class Faculty {

    // --- Instance Variables ---
    private String name;
    private String empId;
    private String department;
    private String designation;
    private double salary;

    // --- Static variable to track total faculty ---
    private static int totalFaculty = 0;

    // --- Constructors ---

    // Parameterized Constructor
    public Faculty(String name, String empId, String department, 
                   String designation, double salary) {
        this.name = name;
        this.empId = empId;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        totalFaculty++;
    }

    // Default Constructor
    public Faculty() {
        this("Unknown", "N/A", "General", "Assistant Professor", 0.0);
    }

    //Copy Constructor
    public Faculty(Faculty f) {
        this(f.name, f.empId, f.department, f.designation, f.salary);
    }

    // --- Getter & Setter Methods ---
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static int getTotalFaculty() {
        return totalFaculty;
    }

    // --- Display Method ---

    // Displays complete faculty information
    public void displayInfo() {
        System.out.println("======================================");
        System.out.println("          FACULTY DETAILS");
        System.out.println("======================================");
        System.out.println("Name        : " + name);
        System.out.println("Employee ID : " + empId);
        System.out.println("Department  : " + department);
        System.out.println("Designation : " + designation);
        System.out.println("Salary      : $" + String.format("%.2f", salary));
        System.out.println("======================================\n");
    }

    @Override
    public String toString() {
        return "Faculty [Name=" + name + ", EmpID=" + empId + 
               ", Department=" + department + ", Designation=" + designation + 
               ", Salary=" + String.format("%.2f", salary) + "]";
    }
}
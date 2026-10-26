package lab.college.student;

/**
 * Student class representing a college student.
 * Part of the lab.college.student package.
 */
public class Student {

    // --- Instance Variables ---
    private String name;
    private String rollNo;
    private String branch;
    private int year;

    // --- Static variable to track total students ---
    private static int totalStudents = 0;

    // --- Constructors ---

    /**
     * Parameterized Constructor
     */
    public Student(String name, String rollNo, String branch, int year) {
        this.name = name;
        this.rollNo = rollNo;
        this.branch = branch;
        this.year = year;
        totalStudents++;
    }

    /**
     * Default Constructor
     */
    public Student() {
        this("Unknown", "N/A", "General", 1);
    }

    /**
     * Copy Constructor
     */
    public Student(Student s) {
        this(s.name, s.rollNo, s.branch, s.year);
    }

    // --- Getter & Setter Methods ---

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static int getTotalStudents() {
        return totalStudents;
    }

    // --- Display Method ---

    /**
     * Displays complete student information
     */
    public void displayInfo() {
        System.out.println("======================================");
        System.out.println("          STUDENT DETAILS");
        System.out.println("======================================");
        System.out.println("Name   : " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Branch : " + branch);
        System.out.println("Year   : " + year);
        System.out.println("======================================\n");
    }

    @Override
    public String toString() {
        return "Student [Name=" + name + ", RollNo=" + rollNo + 
               ", Branch=" + branch + ", Year=" + year + "]";
    }
}
package lab.college;

import lab.college.student.Student;
import lab.college.faculty.Faculty;

/**
 * CollegeManagementSystem - Main class demonstrating user-defined packages.
 * 
 * This program creates and displays information about students and faculty
 * using classes from the custom packages:
 *   - lab.college.student  (Student class)
 *   - lab.college.faculty  (Faculty class)
 */
public class CollegeManagementSystem {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("    COLLEGE MANAGEMENT SYSTEM");
        System.out.println("========================================\n");

        // ---------------------------------------------------------
        // 1. Create Student objects (from lab.college.student package)
        // ---------------------------------------------------------
        System.out.println("--- STUDENT INFORMATION ---");

        // Student 1: using parameterized constructor
        Student student1 = new Student("Arpan Gupta", "25070122046", "Computer Science", 2);

        // Student 2: using default constructor + setters
        Student student2 = new Student();
        student2.setName("Atharv Shukla");
        student2.setRollNo("25070122053");
        student2.setBranch("Computer Science");
        student2.setYear(2);

        // Student 3: using copy constructor (copy of student1)
        Student student3 = new Student(student1);
        student3.setName("Siddharth Apte");       // Change name for copy
        student3.setRollNo("25070122044");

        // Display all student details
        student1.displayInfo();
        student2.displayInfo();
        student3.displayInfo();

        // Display total student count (using static method)
        System.out.println("Total Students Enrolled : " + Student.getTotalStudents() + "\n");

        // ---------------------------------------------------------
        // 2. Create Faculty objects (from lab.college.faculty package)
        // ---------------------------------------------------------
        System.out.println("--- FACULTY INFORMATION ---");

        // Faculty 1: using parameterized constructor
        Faculty faculty1 = new Faculty("Dr. Meena Iyer", "FAC001", 
                                       "Computer Science", "Professor", 95000.00);

        // Faculty 2: using default constructor + setters
        Faculty faculty2 = new Faculty();
        faculty2.setName("Prof. Rajesh Kumar");
        faculty2.setEmpId("FAC002");
        faculty2.setDepartment("Mathematics");
        faculty2.setDesignation("Associate Professor");
        faculty2.setSalary(78000.00);

        // Faculty 3: using copy constructor
        Faculty faculty3 = new Faculty(faculty1);
        faculty3.setName("Dr. Suresh Patel");
        faculty3.setEmpId("FAC003");
        faculty3.setDepartment("Physics");
        faculty3.setDesignation("Assistant Professor");
        faculty3.setSalary(67000.00);

        // Display all faculty details
        faculty1.displayInfo();
        faculty2.displayInfo();
        faculty3.displayInfo();

        // Display total faculty count (using static method)
        System.out.println("Total Faculty Members : " + Faculty.getTotalFaculty() + "\n");

        // ---------------------------------------------------------
        // 3. Summary
        // ---------------------------------------------------------
        System.out.println("========================================");
        System.out.println("   SYSTEM SUMMARY");
        System.out.println("========================================");
        System.out.println("Total Students : " + Student.getTotalStudents());
        System.out.println("Total Faculty  : " + Faculty.getTotalFaculty());
        System.out.println("========================================");
        System.out.println("   PROGRAM ENDED SUCCESSFULLY");
        System.out.println("========================================");
    }
}
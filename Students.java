package lab.assignments;

class Student implements Printable {
    String name;
    int age;

    //Default Constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Copy Constructor
    Student(Student s) {
        this.name = s.name;
        this.age = s.age;
    }

    @Override
    public void printDetails() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}


public class Students {
    public static void main(String[] args) {
        // Using Student reference
        Student student1 = new Student("Arpan", 19);
        Student student2 = new Student(student1);
        student1.printDetails();
        student2.printDetails();

        System.out.println();

        // Using Printable interface reference (polymorphism)
        Printable printableStudent = new Student("Riya", 22);
        printableStudent.printDetails();
    }
}
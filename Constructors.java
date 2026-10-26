package lab.practice;
class Student {
    String name;
    int roll;

    //Default Constructor
    Student() {
        name = "Arpan Gupta";
        roll = 46;
    }

    //Copy Constructor
    Student(String n, int r) {
        name = n;
        roll = r;
    }

    void display() {
        System.out.println("Name: " + name + ", Roll Number: " + roll);
    }
}


public class Constructors {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student("Siddharth Apte", 44);
        student1.display();
        student2.display();
    }
}

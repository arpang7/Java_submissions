package lab.assignments;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistration {
    public static void main(String args[]) {
        ArrayList<String> courses = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("===== STUDENT COURSE REGISTRATION SYSTEM =====");

        do {
            // Display menu using StringBuffer
            StringBuffer menu = new StringBuffer();
            menu.append("\n--- Menu ---\n");
            menu.append("1. Add Course\n");
            menu.append("2. Remove Course\n");
            menu.append("3. View Registered Courses\n");
            menu.append("4. Exit\n");
            menu.append("Enter your choice: ");
            System.out.print(menu);

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Add course
                    System.out.print("Enter course name to register: ");
                    String newCourse = scanner.nextLine();
                    courses.add(newCourse);
                    System.out.println("Course \"" + newCourse + "\" registered successfully!");
                    break;

                case 2:
                    // Remove course
                    if (courses.isEmpty()) {
                        System.out.println("No courses registered to remove.");
                    } else {
                        // Display courses with index using StringBuffer
                        StringBuffer courseList = new StringBuffer();
                        courseList.append("Registered Courses:\n");
                        for (int i = 0; i < courses.size(); i++) {
                            courseList.append(i + 1).append(". ").append(courses.get(i)).append("\n");
                        }
                        System.out.print(courseList);
                        System.out.print("Enter course number to remove: ");
                        int courseNum = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        if (courseNum >= 1 && courseNum <= courses.size()) {
                            String removedCourse = courses.remove(courseNum - 1);
                            System.out.println("Removed course: " + removedCourse);
                        } else {
                            System.out.println("Invalid course number!");
                        }
                    }
                    break;

                case 3:
                    // View all registered courses using StringBuffer
                    if (courses.isEmpty()) {
                        System.out.println("No courses registered yet.");
                    } else {
                        StringBuffer displayCourses = new StringBuffer();
                        displayCourses.append("\n====================================\n");
                        displayCourses.append("     REGISTERED COURSES\n");
                        displayCourses.append("====================================\n");
                        for (int i = 0; i < courses.size(); i++) {
                            displayCourses.append(i + 1).append(". ");
                            displayCourses.append(courses.get(i));
                            displayCourses.append("\n");
                        }
                        displayCourses.append("====================================\n");
                        displayCourses.append("Total courses registered: ").append(courses.size()).append("\n");
                        displayCourses.append("====================================\n");
                        System.out.print(displayCourses);
                    }
                    break;

                case 4:
                    System.out.println("Exiting Student Course Registration System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
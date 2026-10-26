package lab.assignments;

import java.util.ArrayList;
import java.util.Scanner;

public class todolist_example {
    public static void main(String args[]) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("===== TO-DO LIST APPLICATION =====");

        do {
            // Display menu using StringBuffer
            StringBuffer menu = new StringBuffer();
            menu.append("\n--- Menu ---\n");
            menu.append("1. Add Task\n");
            menu.append("2. Remove Task\n");
            menu.append("3. List All Tasks\n");
            menu.append("4. Exit\n");
            menu.append("Enter your choice: ");
            System.out.print(menu);

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // Add task
                    System.out.print("Enter task to add: ");
                    String newTask = scanner.nextLine();
                    tasks.add(newTask);
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    // Remove task
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to remove.");
                    } else {
                        // Display tasks with index
                        StringBuffer taskList = new StringBuffer();
                        taskList.append("Current Tasks:\n");
                        for (int i = 0; i < tasks.size(); i++) {
                            taskList.append(i + 1).append(". ").append(tasks.get(i)).append("\n");
                        }
                        System.out.print(taskList);
                        System.out.print("Enter task number to remove: ");
                        int taskNum = scanner.nextInt();
                        scanner.nextLine(); // consume newline

                        if (taskNum >= 1 && taskNum <= tasks.size()) {
                            String removedTask = tasks.remove(taskNum - 1);
                            System.out.println("Removed: " + removedTask);
                        } else {
                            System.out.println("Invalid task number!");
                        }
                    }
                    break;

                case 3:
                    // List all tasks using StringBuffer
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks in the list.");
                    } else {
                        StringBuffer displayTasks = new StringBuffer();
                        displayTasks.append("\n===== YOUR TASKS =====\n");
                        for (int i = 0; i < tasks.size(); i++) {
                            displayTasks.append(i + 1).append(". ");
                            displayTasks.append(tasks.get(i));
                            displayTasks.append("\n");
                        }
                        displayTasks.append("======================\n");
                        displayTasks.append("Total tasks: ").append(tasks.size()).append("\n");
                        System.out.print(displayTasks);
                    }
                    break;

                case 4:
                    System.out.println("Exiting To-Do List Application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
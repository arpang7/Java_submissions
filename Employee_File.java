package lab.practice;

import java.io.*;

public class Employee_File {
    public static void main(String[] args) {
        try {
            // Writing employee details to the file
            FileWriter fw = new FileWriter("employee.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Employee ID: 101");
            bw.newLine();
            bw.write("Name: Arjun");
            bw.newLine();
            bw.write("Department: Computer Science");
            bw.newLine();
            bw.write("Salary: 50000");
            bw.newLine();

            bw.close();

            // Reading employee details from the file
            FileReader fr = new FileReader("employee.txt");
            BufferedReader br = new BufferedReader(fr);

            String line;
            System.out.println("Employee Details:");

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        } 
        catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
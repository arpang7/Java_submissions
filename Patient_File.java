package lab.practice;

import java.io.*;

public class Patient_File {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("patient.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write("Patient ID: 101");
            bw.newLine();
            bw.write("Name: Rahul");
            bw.newLine();
            bw.write("Age: 35");
            bw.newLine();
            bw.write("Disease: Fever");
            bw.newLine();
            bw.write("Doctor: Dr. Sharma");
            bw.newLine();

            bw.close();

            System.out.println("Patient details written successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
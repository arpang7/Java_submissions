package lab.assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandling {
    static File f0 = new File("C:\\Users\\SBUP\\OneDrive - Sri Balaji University\\Desktop\\filename.txt");

    public static void main(String args[]) {
        FileHandling.filecreator();
        FileHandling.fileinfo();
        FileHandling.filewriter();
        FileHandling.filereader();
        FileHandling.fileappend();
        FileHandling.filereader();
        //FileHandling.filedelete();
    }

    static void filecreator() {
        try {
            if (f0.createNewFile()) {
                System.out.println("File " + f0.getName() + " is created successfully.");
            } else {
                System.out.println("File is already exist in the directory.");
            }
        } catch (IOException exception) {
            System.out.println("An unexpected error is occurred.");
            exception.printStackTrace();
        }
    }

    static void fileinfo() {
        if (f0.exists()) {
            System.out.println("The name of the file is: " + f0.getName());
            System.out.println("The absolute path of the file is: " + f0.getAbsolutePath());
            System.out.println("Is file writeable?: " + f0.canWrite());
            System.out.println("Is file readable " + f0.canRead());
            System.out.println("The size of the file in bytes is: " + f0.length());
        } else {
            System.out.println("The file does not exist.");
        }
    }

    static void filewriter() {
        try {
            FileWriter fwrite = new FileWriter(f0);
            fwrite.write("A named location used to store related information is referred to as a File.");
            fwrite.close();
            System.out.println("Content is successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Unexpected error occurred");
            e.printStackTrace();
        }
    }

    static void filereader() {
        try {
            Scanner dataReader = new Scanner(f0);
            while (dataReader.hasNextLine()) {
                String fileData = dataReader.nextLine();
                System.out.println(fileData);
            }
            dataReader.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Unexpected error occurred!");
            exception.printStackTrace();
        }
    }

    static void filedelete() {
        if (f0.delete()) {
            System.out.println(f0.getName() + " file is deleted successfully.");
        } else {
            System.out.println("Unexpected error found in deletion of the file.");
        }
    }

    static void fileappend() {
        try {
            FileWriter fr = new FileWriter(f0, true);
            fr.write("\nA named location used to store related information is referred to as a File.");
            fr.close();
        } catch (IOException e) {
            System.out.println("Unexpected error occurred");
            e.printStackTrace();
        }
    }
}
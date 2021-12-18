package Lab9;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner; // Import the Scanner class to read text files

public class AvgCalc {

    public static void main(String[] args) {

        File input_file = null;
        Scanner input_reader = null;
        File output_file = null;
        FileWriter output_writer = null;

        try {
            input_file = new File("src/Lab9/students.txt");
            input_reader = new Scanner(input_file);
            output_writer = new FileWriter("src/Lab9/output.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to output.txt");
            System.exit(1);
        }


        while (input_reader.hasNextLine()) {
            String[] data = input_reader.nextLine().split(" ");

            double avg =(Double.parseDouble(data[1]) +
                         Double.parseDouble(data[2]) +
                         Double.parseDouble(data[3]) ) / 3;

            try {
                output_writer.write(data[0] + " " + avg + "\n");
            } catch (IOException e) {
                System.out.println("Error writing data of student " + data[0] + " to output.txt");
                System.exit(1);
            }
            System.out.println(avg);
        }


        input_reader.close();
        try {
            output_writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
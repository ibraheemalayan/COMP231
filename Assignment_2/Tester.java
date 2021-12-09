package Assignment_2;

import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of classes: ");

        int classes_count = input.nextInt();

        Classroom[] classes = new Classroom[classes_count];

        for (int i = 0; i < classes_count; i++) {

            System.out.print("\n\nEnter students' number in class #" + (i+1) + " : ");
            int std_count = input.nextInt();

            if(std_count < 2 || std_count > 99){
                i --;
                System.out.println("!!! Must be between 1 and 100 (exclusive)");
                continue;

            }

            input.nextLine(); // to skip the count line

            Student[] stds = new Student[std_count];

            for (int j = 0; j < std_count; j++) {

                String full_name = input.nextLine();
                stds[j] = new Student(full_name, j);

            }

            classes[i] = new Classroom(stds);

        }


        System.out.println("\n\n------------- ENTERING MARKS -------------\n\n");

        for (int i = 0; i < classes_count; i++) {
            System.out.println("Enter marks for Class #" + (i+1) + " :\n");
            classes[i].set_marks(input);
        }

        input.close();

        display_classes(classes);

    }

    public static double calculate_avg(Classroom c){
        return c.getClass_avg();
    }

    public static void display_classes(Classroom[] classes){
        for (int i = 0; i < classes.length; i++) {
            System.out.println("\n-----------\nClass #" + (i+1) + " ordering :\n");

            System.out.println(classes[i] + "\n-----------\n");

        }
    }

}

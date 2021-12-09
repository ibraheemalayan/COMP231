package Lab4;

import java.util.Scanner;

public class Q3 {



    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Student[] arr = new Student[4];

        for (int i = 0; i < arr.length; i++){

            System.out.println("\n\nEnter Student's Name: ");
            String name = input.next();

            System.out.println("Enter Student's ID: ");
            int ID = input.nextInt();

            System.out.println("Enter Student's Grade: ");
            double grade = input.nextDouble();

            arr[i] = new Student();

            arr[i].setAge(5);

            int age = 0;

            age =5;


            arr[i].setStudentId(ID);
            arr[i].setStudentName(name);
            arr[i].setGrade(grade);

        }
        System.out.println("\n\nEntered Students :\n");

        for (int i = 0; i < arr.length; i++) {
            System.out.println(" > " + arr[i]);
        }

        System.out.println("\n\nStudent with highest grade is :\n" + Test.Smartest(arr));

    }
}

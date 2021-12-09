package Lab4;

import java.util.Scanner;

public class Q1_B {

    static int[] get_floor( int people_count , Scanner input){

        int [] floor = new int[people_count];

        for (int i = 0; i < people_count; i++) {
            System.out.println("Enter age of person number ()" + (i+1) + " : ");
            floor[i] = input.nextInt();
        }

        return floor;
    }

    static double avgAge( int [][] building ){

        int number_of_people = 0;
        int sum_of_ages = 0;
        for (int i = 0; i < building.length; i++) {
            number_of_people += building[i].length;
            for (int j = 0; j < building[i].length; j++) {
                sum_of_ages += building[i][j];
            }
        }

        return sum_of_ages / (double) number_of_people;

    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of floors: ");

        int n = input.nextInt();

        int[][] building = new int[n][];

        int people_sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter number of people who live in floor " + (i+1) + " : ");
            int num_of_people_in_floor = input.nextInt();
            building[i] = get_floor(num_of_people_in_floor, input);
            people_sum += num_of_people_in_floor;
        }

        System.out.println("\n> Number of people in the building is " + people_sum);

        System.out.println("\n> avg age in the building is " + avgAge(building));







    }
}

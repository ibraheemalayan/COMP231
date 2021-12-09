package Lab4;

import java.util.Scanner;

public class Q1_A {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of floors: ");

        int n = input.nextInt();

        int[] building = new int[n];

        int people_sum = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter number of people who live in floor " + (i+1) + " : ");
            building[i] = input.nextInt();
            people_sum += building[i];
        }

        System.out.println("\n> Number of people in the building is " + people_sum);

        double avg = people_sum / (double) n;

        System.out.println("> Avg number of people per floor is " + avg );

        int floors_above_avg = 0;
        int floors_below_avg = 0;
        int floors_equal_avg = 0;

        for (int i = 0; i < n; i++) {
            if(building[i] < avg){
                floors_below_avg ++;
            }else if(building[i] > avg){
                floors_above_avg ++;
            }else{
                floors_equal_avg ++;
            }
        }

        System.out.println("> Floors that has more people than the avg : " + floors_above_avg );
        System.out.println("> Floors that has less people than the avg : " + floors_below_avg );
        System.out.println("> Floors that has a number of people equal to the avg : " + floors_equal_avg );






    }
}

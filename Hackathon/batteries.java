package Hackathon;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class batteries {

    public static void print_schedule(boolean[][] schedule){

        System.out.println("\n-------\n");

        System.out.println("Schedule: \n");
        for (int i = 0; i < schedule.length; i++) {

            for (int j = 0; j < schedule[i].length; j++) {
                if (schedule[i][j]){
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.print("\n");
        }

        System.out.println("\n-------\n");
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] inital = input.nextLine().split(" ");

        int machines = Integer.parseInt(inital[0]); // machines
        int bats_per_chip = Integer.parseInt(inital[1]); // bats_per_chips

        int battery_c = 2 * machines * bats_per_chip;

        boolean[] assigned = new boolean[battery_c];
        int[] batteries = new int[battery_c];

        String[] bats = input.nextLine().split(" ");

        for (int i = 0; i < battery_c; i++) {
            batteries[i] = Integer.parseInt(bats[i]);
        }


        Arrays.sort(batteries);
//
//        System.out.println( "Bats >>> " + Arrays.toString(batteries));


        int max_machine_d = 0;

        for (int i = 0; i < batteries.length; i+=2) {

            int machine_d = Math.abs(batteries[i] - batteries[i+1]);

            if ( machine_d > max_machine_d){
                max_machine_d = machine_d;
            }


        }

        System.out.println(max_machine_d);









//        for (int i = 0; i < 10; i++) {
//            System.out.println("Enter day:");
//            int day_i = input.nextInt();
//
//            System.out.println("Enter hour:");
//            int hour_i = input.nextInt();
//
//            System.out.println("Benefit: " + benefit_of_skip(schedule[day_i], hour_i));
//        }



    }

    public static int sc_len(boolean[][] schedule){
        int len = 0;
        for (int i = 0; i < schedule.length; i++) {
                len += get_day_length(schedule[i]);
        }
        return len;
    }

    public static void delete_hour(boolean[][] schedule){

        int[][] benefits = new int[schedule.length * 2][];


        int max_i = -1;
        int max_j = -1;
        int max_benefit = -1;


        for (int i = 0; i < schedule.length; i++) {

            if (get_day_length(schedule[i]) == 0){
                continue;
            }

            int index_of_first = get_index_of_first(schedule[i]);
            int index_of_last = get_index_of_last(schedule[i]);

            int ben_of_first = benefit_of_skip(schedule[i], index_of_first);
            if (ben_of_first > max_benefit){
                max_benefit = ben_of_first;
                max_i = i;
                max_j = index_of_first;
            }

            int ben_of_last = benefit_of_skip(schedule[i], index_of_last);
            if (ben_of_last > max_benefit){
                max_benefit = ben_of_last;
                max_i = i;
                max_j = index_of_last;
            }

        }

        if( max_i != -1 && max_j != -1){

            schedule[max_i][max_j] = false;
        }

    }

    public static int get_index_of_last(boolean[] day){
        for (int i = day.length - 1; i > 0 ; i--) {
            if ( day[i] ){
                return i;
            }
        }
        return -1;
    }

    public static int get_index_of_first(boolean[] day){
        for (int i = 0; i < day.length; i++) {
            if ( day[i] ){
                return i;
            }
        }
        return -1;
    }

    public static int get_day_length(boolean[] day){
        if (get_index_of_last(day) == -1){
            return 0;
        }
        else {
            return (get_index_of_last(day) - get_index_of_first(day) ) + 1;
        }
    }

    public static int benefit_of_skip(boolean[] day, int to_skip){

        boolean[] new_day = new boolean[day.length];
        for (int i = 0; i < day.length; i++) {
            new_day[i] = day[i];
        }
        new_day[to_skip] = false;


        return (get_day_length(day) - get_day_length(new_day) );
    }



}

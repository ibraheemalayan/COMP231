package Hackathon;

import java.util.*;

public class saeed {

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

        int N = Integer.parseInt(inital[0]); // days
        int M = Integer.parseInt(inital[1]); // hours_per_day
        int K = Integer.parseInt(inital[2]); // skipabble

        boolean[][] schedule = new boolean[N][M];

        for (int i = 0; i < N; i++) {

            String day_sc = input.nextLine();
            for (int j = 0; j < M; j++) {
                schedule[i][j] = day_sc.charAt(j) == '1';
            }
        }

//        print_schedule(schedule);

        for (int i = 0; i < K; i++) {
//            System.out.println("Deleting an hour");

            delete_hour(schedule);



//            System.out.println("Schedule len: " + sc_len(schedule));
//            print_schedule(schedule);
        }

        System.out.println(sc_len(schedule));



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

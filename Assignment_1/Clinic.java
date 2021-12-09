package Assignment_1;

// The code is self-explaining, unclear parts are documented

import java.util.Arrays;
import java.util.Scanner;

public class Clinic {

    public static void main(String[] args) {

        int days, reads;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of days that a patient has entered the hospital: ");
        days = input.nextInt();

        double[][] temps = new double[days][];

        for (int i = 0; i < temps.length; i++) {
            System.out.print("Enter the number of times that nurse read the temperature of the patient in day " + (i+1) + ": ");
            reads = input.nextInt();

            temps[i] = new double[reads];

            for (int j = 0; j < reads; j++) {
                System.out.print("\nEnter the temperature number " + (j + 1) + ", in Celsius: ");

                double temp = input.nextDouble();

                if (temp <= 45 && temp >= 30){
                    temps[i][j] = temp;
                }else{
                    System.out.println(" ❗️ Invalid Input\n temperature must be between 30 and 45 (inclusive)");
                    j--;
                }
            }
        }

        double[] summary = Summary(temps);

        System.out.println("\n\n> minimum temperature : " + summary[0]);
        System.out.println("> average temperature : " + summary[1]);
        System.out.println("> maximum temperature : " + summary[2]);

        double[] counts = CountBelowAboveAverage(temps);

        System.out.println("> count below avg : " + counts[0]);
        System.out.println("> count equal avg : " + counts[1]);
        System.out.println("> count above avg : " + counts[2]);

        System.out.println("\n\n> Temps :");
        printArray(temps);

        double[][] sorted_temps = sortArray(temps);

        System.out.println("\n\n> Sorted Temps :");
        printArray(sorted_temps);

        if (leaveHospital(sorted_temps)){
            System.out.println("\nPatient can leave the hospital\n");
        }else{
            System.out.println("\n! Patient cannot leave the hospital\n");
        }




    }

    static double[] Summary(double[][] temps){

        if (temps.length == 0){
            return new double[]{0.0, 0.0, 0.0};
        }

        int count = 0;
        double sum = 0;

        double min = 46;
        double max = 29;

        for (int i = 0; i < temps.length; i++) {

            for (int j = 0; j < temps[i].length; j++) {

                count ++;
                sum += temps[i][j];

                if ( temps[i][j] < min ){
                    min = temps[i][j];
                }

                if ( temps[i][j] > max ){
                    max = temps[i][j];
                }

            }

        }

        // the array to return, contains the result as [ minimum_temperature, average_temperature, maximum_temperature ]
       return new double[] { min, (sum / count) , max};

    }

    static double[] CountBelowAboveAverage(double [][] temps){

        double avg = Summary(temps)[1];

        double above_avg = 0;
        double equal_avg = 0;
        double below_avg = 0;

        for (int i = 0; i < temps.length; i++) {

            for (int j = 0; j < temps[i].length; j++) {


                if ( temps[i][j] > avg ){
                    above_avg ++;
                } else if( temps[i][j] < avg ){
                    below_avg ++;
                }else{
                    equal_avg ++;
                }

            }

        }

        // the array to return, contains the result as [ count_below_avg, count_equal_avg, count_above_avg ]
        return new double[] { below_avg, equal_avg , above_avg};

    }

    static double[][] sortArray(double [][] temps){

        double[][] sorted_temps = new double[temps.length][];

        for (int i = 0; i < temps.length; i++) {

            sorted_temps[i] = new double[temps[i].length];

            for (int j = 0; j < temps[i].length; j++) {

                sorted_temps[i][j] = temps[i][j];
            }

        }

        for (int i = 0; i < temps.length; i++) {

            Arrays.sort(sorted_temps[i]);
        }

        return sorted_temps;

    }

    static void printArray(double[][] temps){

        for (int i = 0; i < temps.length; i++) {

            System.out.println("\nday " + (i+1));

            for (int j = 0; j < temps[i].length; j++) {
                System.out.print(" " + temps[i][j]);
            }

        }
    }

    static double avg_of_highest_2_in_day(double[] day){

        return (day[day.length - 1] + day[day.length - 2]) / 2;

    }

    static Boolean leaveHospital(double[][] sorted_temps){

        if (sorted_temps.length < 2){
            System.out.println("\n\n\n> Cannot determine if the patient can leave, at least 2 days data is needed");
            return false;
        }

        if (sorted_temps[sorted_temps.length - 1].length < 2){
            System.out.println("\n\n\n> Cannot determine if the patient can leave, at least 2 reads data is required in the last day");
            return false;
        }

        if (sorted_temps[sorted_temps.length - 2].length < 2){
            System.out.println("\n\n\n> Cannot determine if the patient can leave, at least 2 reads data is required in the pre-last day");
            return false;
        }

        double last_day_highest_2_avg = avg_of_highest_2_in_day(sorted_temps[sorted_temps.length - 1]);
        double day_before_last_highest_2_avg = avg_of_highest_2_in_day(sorted_temps[sorted_temps.length - 2]);

        double avg = (last_day_highest_2_avg + day_before_last_highest_2_avg ) / 2;

        System.out.println("\n\n\n> Average of last two highest read temperatures in the last two days is : " + avg + "\n\n");


        return ( ( avg <= 36.5) && ( avg >= 35.5) );

    }
}

package Hackathon;

import java.util.Scanner;

public class race {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T =  Integer.parseInt(input.nextLine());
        for (int i = 0; i < T; i++) {

            String[] init =  input.nextLine().split(" ");

            int cars = Integer.parseInt(init[0]);
            double distance = Double.parseDouble(init[1]);

            String[] speeds =  input.nextLine().split(" ");
            String[] accelerations =  input.nextLine().split(" ");

            double min_time = -1;

            for (int j = 0; j < cars; j++) {
                double Vi = Double.parseDouble(speeds[j]);
                double a =  Double.parseDouble(accelerations[j]);
                double Vf = Math.sqrt(
                        (Vi * Vi )+ (2 * a * distance)
                );

                double t = (Vf - Vi) / a;

                if ( min_time == -1 || t < min_time ){
                    min_time = t;
                }

            }

            System.out.println(String.format("%.2f", min_time));

        }
    }
}

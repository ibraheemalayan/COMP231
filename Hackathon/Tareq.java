package Hackathon;

import java.util.Scanner;

public class Tareq {

    public static long pow(long first, long second){
        long res = 1;
        for(int i = 1; i <= second; i++){
            res *= first;
        }
        return res;
    }


        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);

            int test_cases = Integer.parseInt(input.nextLine());

            for (long i = 0; i < test_cases; i++) {

                String[] line =  input.nextLine().split(" ");

                long N = Long.parseLong(line[0]);
                long M = Long.parseLong(line[1]);

                long A = N / 2;
                long B = N - A;

//                long B_pow_M_min_2 = pow(B, M - 2);
//
//                System.out.println("A > " + A);
//                System.out.println("B > " + B);
//                System.out.println("M > " + M);
//                System.out.println("N > " + N);
//                System.out.println("B_pow_M_min_2 > " + B_pow_M_min_2);

//                long res =( ( B * ( B_pow_M_min_2 * A * (M-1) ) ) + (B_pow_M_min_2 * B * B) ) % 100000007;

//                System.out.println(" pow(B, M - 1) > " +  pow(B, M - 1));
                long res =( pow(B, M - 1) * ( B + (A * (M-1)) ) ) % 100000007;


                System.out.println(res);

            }
        }

}


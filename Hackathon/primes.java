package Hackathon;

import java.util.Scanner;

public class primes {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int a, b, i, j,flag;

        a = sc.nextInt();
        b = sc.nextInt();

        int sum = 0;
        // Explicitly handling the cases when a is less than 2
        if (a == 1) {
            sum ++;
            a++;
            if (b >= 2) {
                sum ++;
                a++;
            }
        }
        if (a == 2)
            sum ++;

        // MAKING SURE THAT a IS ODD BEFORE WE BEGIN
        // THE LOOP
        if (a % 2 == 0)
            a++;

        // NOTE : WE TRAVERSE THROUGH ODD NUMBERS ONLY
        for (i = a; i <= b; i = i + 2) {

            // flag variable to tell
            // if i is prime or not
            flag = 1;

            // WE TRAVERSE TILL SQUARE ROOT OF j only.
            // (LARGEST POSSIBLE VALUE OF A PRIME FACTOR)
            for (j = 2; j * j <= i; ++j) {
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }

            // flag = 1 means i is prime
            // and flag = 0 means i is not prime
            if (flag == 1)
                sum ++;
        }

        System.out.println(sum);

    }

}

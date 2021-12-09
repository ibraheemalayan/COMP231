package Quiz2;

import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("enter a :");
        int a = input.nextInt();

        System.out.println("enter b :");
        int b = input.nextInt();

        System.out.println("enter c :");
        int c = input.nextInt();

        System.out.println("enter d :");
        int d = input.nextInt();

        System.out.println("enter e :");
        int e = input.nextInt();

        System.out.println("enter f :");
        int f = input.nextInt();

        LinearEquation eq = new LinearEquation(a,b,c,d,e,f);

        if (eq.isSolvable()){
            System.out.println("X is " + eq.getX());
            System.out.println("Y is " + eq.getY());
        }else{
            System.out.println("equation is unsolvable");
        }

    }


}

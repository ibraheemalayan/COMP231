package Quiz3;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<Integer>();




        for (int i = 0; i < 10; i++) {
            System.out.println("Enter Integer: ");
            list.add(input.nextInt());
        }

        print_list(list);

        removeDuplicate(list);

        System.out.println("\nAfter removing duplicates : ");

        print_list(list);



    }

    public static void removeDuplicate(ArrayList<Integer> list){

        int size = list.size();

        for (int i = 0; i < size; i++) {
            Integer num = list.get(i);

            if ( list.indexOf((int) num) != list.lastIndexOf((int) num) && list.indexOf((int) num) != -1 ){
                list.remove(num);
                size --;
                i--;
            }
        }



    }

    public static void print_list(ArrayList<Integer> list){

        for ( int i : list ) {
            System.out.print(i + " ");
        }



    }



}

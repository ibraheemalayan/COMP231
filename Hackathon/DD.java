package Hackathon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DD {

    static class Book{
        int height, price, index;

        public Book(int height, int price, int index) {
            this.height = height;
            this.price = price;
            this.index = index + 1;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "height=" + height +
                    ", price=" + price +
                    ", index=" + index +
                    '}';
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int N =  Integer.parseInt(input.nextLine().split(" ")[0]);

        String[] prices_of_back =  input.nextLine().split(" ");
        String[] height_of_back =  input.nextLine().split(" ");
        String[] prices_of_front =  input.nextLine().split(" ");
        String[] height_of_front =  input.nextLine().split(" ");

        Book[] back = new Book[N];
        Book[] front = new Book[N];

        for (int i = 0; i < N; i++) {
            back[i] = new Book(Integer.parseInt(height_of_back[i]), Integer.parseInt(prices_of_back[i]), i);
            front[i] = new Book(Integer.parseInt(height_of_front[i]), Integer.parseInt(prices_of_front[i]), i);
        }

        Arrays.sort(back, new Comparator() {

            public int compare(Object o1, Object o2) {

                Integer x1 = ((Book) o1).price;
                Integer x2 = ((Book) o2).price;
                int sComp = x1.compareTo(x2) * -1;

                if (sComp != 0) {
                    return sComp;
                }

                Integer x3 = ((Book) o1).height;
                Integer x4 = ((Book) o2).height;
                return x3.compareTo(x4) * -1;
            }});

        Arrays.sort(front, new Comparator() {

            public int compare(Object o1, Object o2) {

                Integer x1 = ((Book) o1).price;
                Integer x2 = ((Book) o2).price;
                int sComp = x1.compareTo(x2) * -1;

                if (sComp != 0) {
                    return sComp;
                }

                Integer x3 = ((Book) o1).height;
                Integer x4 = ((Book) o2).height;
                return x3.compareTo(x4) * -1;
            }});

        System.out.print("\n Back \n");

        for (int i = 0; i < N; i++) {
            System.out.print(","  + back[i]);
        }

        System.out.print("\n Front \n");

        for (int i = 0; i < N; i++) {
            System.out.print(","  + front[i]);
        }

        for (int i = 0; i < N; i++) {
            if ( front[i].height > back[i].height ){
                System.out.println("impossible");
                return;
            }

        }

        for (int i = 0; i < N; i++) {
            System.out.print(back[i].index + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < N; i++) {
            System.out.print(front[i].index + " ");
        }


    }
}

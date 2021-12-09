package Lab8.Q2;

import Lab8.Q1.Employee;

public class Tester {

    public static void main(String[] args) {

        Shape[] arr = new Shape[5];

        arr[0] = new Circle("red",true, 5.0);
        arr[1] = new Circle("red",true, 25.0);
        arr[2] = new Rectangle("red",true, 5.0, 10.0);
        arr[3] = new Rectangle("red",true, 10.0, 50.0);
        arr[4] = new Rectangle("red",true, 5.0, 20.0);

        for (int i = 0; i < 5; i++) {
            System.out.println("\n" + arr[i]);
            System.out.println(arr[i].getArea() +"\n");
        }

        System.out.println("\n----------------------------\n");

        Shape.sort(arr);

        for (int i = 0; i < 5; i++) {
            System.out.println("\n" + arr[i]);
            System.out.println(arr[i].getArea() +"\n");
        }



    }


}

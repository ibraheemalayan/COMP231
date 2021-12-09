package Lab5;

import java.util.Date;

public class MyArray_Tester {

    public static void main(String[] args) {

        int[] test_arr = {0,1,2,3,7,6,4,2,-1};

        MyArray m = new MyArray(test_arr);

        System.out.println("max :" + m.max());
        System.out.println("min :" + m.min());
        System.out.println("avg :" + m.average());
        System.out.println("size :" + m.getSize());
        m.printArray();


    }


}

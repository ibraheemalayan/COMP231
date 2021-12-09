package Lab5;

import java.util.Arrays;

public class MyArray {

    int[] arr;

    public MyArray(int[] arr) {

        this.arr = Arrays.copyOf(arr, arr.length);
    }

    public int max(){
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]){
                max = arr[i];
            }
        }

        return max;
    }

    public int min(){
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if(min > arr[i]){
                min = arr[i];
            }
        }

        return min;
    }

    public int average(){
        int sum = arr[0];

        for (int i = 0; i < arr.length; i++) {
           sum += arr[i];
        }

        return sum/arr.length;
    }

    public void printArray(){
        System.out.println(this);
     }

    @Override
    public String toString() {
        return "MyArray{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    public int getSize(){
        return arr.length;
    }
}

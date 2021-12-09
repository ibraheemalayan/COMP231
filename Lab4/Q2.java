package Lab4;

public class Q2 {
    public static int linearSearch( int [] myArray, int num){
        for (int i = 0; i < myArray.length; i++) {
            if(num == myArray[i]){
                return i;
            }
        }
        return -1;
    }
}

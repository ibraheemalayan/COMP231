package Lab4;

public class Test {

    public static Student Smartest(Student [] arr){

        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getGrade() > arr[max].getGrade()){
                max = i;
            }
        }

        return arr[max];
    }

}

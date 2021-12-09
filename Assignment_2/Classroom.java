package Assignment_2;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Classroom {

    private Student[] students;
    private int count;

    private void shift_after_i(int n){
        for (int i = count; i > n; i--) {
            students[i] = students[i-1];
        }
    }

    private void insert_student_sorted(Student s){

        boolean added = false;

        int i;

        for (i = 0; i < count; i++) {

            int comp = compare_students(s, students[i]);

            if ( comp == 1 ) {

                shift_after_i(i);
                students[i] = s;
                added = true;
                break;

            }

        }

        if ( ! added ) {
            students[i] = s;
        }

        count ++;

    }

    public Classroom(Student[] students) {

        this.count = 0; // to be incremented after adding every student

        this.students = new Student[students.length];

        for (Student student : students) {
            insert_student_sorted(student);
        }

    }

    private static int count_char(char c, String str){

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                count++;
            }
        }

        return count;
    }

    // returns 1 if s1 is greater than s2 | returns -1 if s1 is less than s2
    private static int compare_students(Student s1, Student s2){

        String name1 = s1.getLast_name().toUpperCase();
        String name2 = s2.getLast_name().toUpperCase();

        for (char c = 'A'; c <= 'Z' ; c++) {

            int count1 = count_char(c, name1);
            int count2 = count_char(c, name2);

            if ( count1 == count2 ){
                continue;
            }else if( count1 > count2 ){
                return 1;
            }else{
                return -1;
            }

        }

        return -1; // this should never happen
    }

    public void set_marks(Scanner input){

        for (int i = 0; i < count; i++) {

            System.out.println("Enter mark of student \"" + students[i].getFull_name() + "\": ");

            double mark = input.nextDouble();

            students[i].setGrade(mark);
            
        }
    }

    public double getClass_avg(){
        double sum = 0.0;

        for (int i = 0; i < count; i++) {
            sum += students[i].getGrade();
        }

        return sum / count;
    }

    @Override
    public String toString() {

        String res = "students:\n\n";

        for (int i = 0; i < count; i++) {
            res += students[i];
        }
        return res + "\n\nCount of students is " + count + "\nAvg of Class is " + getClass_avg() + "\n";
    }
}

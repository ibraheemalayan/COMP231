package Revision.types;

public class Immutablity {

    // A mutable object can be changed after it's created, and an immutable object can't.

    public static void main(String[] args) {

        String first = "my string";
        String second = first; // to skip string pool

        System.out.println(first);
        System.out.println(second);
        System.out.println("are equal ? > " + (first == second));

         second = first + " hello"; // to skip string pool

        System.out.println("are equal ? > " + (first == second));
        System.out.println(first);
        System.out.println(second);

        System.out.println("\n\n");

        first = first + " is changed";

        System.out.println(first);
        System.out.println(second);


        // Mutable Strings ( String Builder )
        System.out.println("\n-----------\n");



        StringBuilder first_sb = new StringBuilder("my string");
        StringBuilder second_sb = first_sb;

        System.out.println(first_sb);
        System.out.println(second_sb);
        System.out.println("\n\n");

        first_sb.append(" is changed");
        first_sb.replace(0,2,"My");

        System.out.println(first_sb);
        System.out.println(second_sb);
        System.out.println("are equal ? > " + (first_sb == second_sb));

        // Solve questions : Midterm7:Q1:6


    }
}

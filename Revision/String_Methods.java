package Revision;

public class String_Methods {

    public static void main(String[] args) {

        String str = "hello world";

        System.out.println("str: " + str);

        System.out.println("> " +
                str.replaceAll("hello", "hi"));
        System.out.println("> " + str.concat("!"));
        System.out.println("> " + str.toUpperCase());

        System.out.println("str: " + str);

        System.out.println("\n\n");


        StringBuilder str_b = new StringBuilder("My String");

        System.out.println("str_b: " + str_b);
        System.out.println("str_b: " + str_b.insert(3,"Nice "));
        System.out.println("str_b: " + str_b.replace(8,14,"Text"));

        System.out.println("str_b: " + str_b);

    }
}

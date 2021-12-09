package Lab6;

public class Tester {

    public static void main(String[] args) {

        System.out.println("reverse of \"hello There\" > " + MyString.reverseString("hello There") );

        System.out.println("\n\nisPalindrome(\"hello There\") > " + MyString.isPalindrome("hello There") );
        System.out.println("isPalindrome(\"qWer tre'wq\") > " + MyString.isPalindrome("qWer tre'wq") );

        String str = "Hi there how are you and welcome to the party for some words SoIs I u are good yu";
        System.out.println("\n\nStr       > " + str );
        System.out.println("Shorthand > " + MyString.ShortHnaded(str) );

        str = "Hello There, mister hi there. how are you I am good";
        System.out.println("\n\nSentences > " + MyString.numberOfSentences(str) );

        System.out.println("\n\nWords > " + MyString.numberOfWords(str) );

        System.out.println("\n\nEncrypt " + str + " > " + MyString.encrypt(str) );

    }
}

package Lab6;

import java.util.Locale;

public class MyString {

    public static String reverseString(String str){

        int L = str.length();

        char[] new_str = new char[L];

        for (int i = 0; i < str.length(); i++) {
            new_str[L-i-1] = str.charAt(i);
        }

        return new String(new_str);

    }

    private static String clean(String str){
        return str.replaceAll("[\\s.,'\"/?\\-_+()*&^%$#@!`]", "").toLowerCase();
    }

    public static boolean isPalindrome(String str){

        str = clean(str);
        return str.equals( reverseString( str ) );
    }

    public static String ShortHnaded(String str){

        String[] filters = {
                "and", "&",
                "to", "2",
                "you", "U",
                "for", "4",
                "[aeioAEOU]", "",
                "[^\\s][uI][^\\s]", "",
                "[^\\s][uI]", "",
                "[uI][^\\s]", ""
        };

        String res = str;

        for (int i = 0; i < filters.length; i += 2) {
            res = res.replaceAll(filters[i], filters[i+1]);
        }

        return res;
    }

    public static int numberOfSentences(String str){
        return str.split("[.,?!]").length;
    }

    public static int numberOfWords(String str){

        String[] tokens = str.split("\\s?[ ,.?!]");

        int count = tokens.length;

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].length() < 3){
                count --;
            }
        }

        return count;
    }

    public static String encrypt(String str){
        String res = reverseString(str.toUpperCase());
        return "**" + res + "**";
    }

    private static String toNumber(String str){
        return str.replaceAll("O", "0").replaceAll("S", "$").replaceAll("L", "1");
    }
}

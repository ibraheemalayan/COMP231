package Hackathon;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;

public class main {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String str = input.nextLine();

        HashMap<Character,
                Integer> counting = new HashMap<>();
        for(char ch : str.toCharArray())
        {
            if (counting.containsKey(ch))
            {
                counting.put(ch, counting.get(ch) + 1);
            }
            else
            {
                counting.put(ch, 1);
            }
        }

        int oddCount = 0;
        char oddChar = 0;

        for(Entry<Character,
                Integer> itr : counting.entrySet())
        {
            if (itr.getValue() % 2 != 0)
            {
                oddCount++;
                oddChar = itr.getKey();
            }
        }

        if (oddCount > 1 || oddCount == 1 &&
                str.length() % 2 == 0)
        {
            System.out.println("NO");
            return;
        }

        String firstHalf = "", lastHalf = "";
        for(Entry<Character, Integer> itr : counting.entrySet())
        {

            String ss = "";
            for(int i = 0; i < itr.getValue() / 2; i++)
            {
                ss += itr.getKey();
            }
            firstHalf = firstHalf + ss;
            lastHalf = ss + lastHalf;
        }

        // Print the plaindrome
//        System.out.println(
//
//                (oddCount == 1) ?
//                        (firstHalf + oddChar + lastHalf) :
//                        (firstHalf + lastHalf)
//
//        );

        System.out.println("YES");


    }



}

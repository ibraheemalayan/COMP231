package Hackathon;

import java.util.Scanner;

public class subs_in_rang {

    class TrieNode{
        TrieNode children[];
        boolean isEnd;

        TrieNode(){
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }

    TrieNode root;

    public subs_in_rang() {
        this.root = new TrieNode();
    }

    void insert(String str){
        TrieNode cur = root;
        for(char ch : str.toCharArray()){
            int idx = ch - 'a';

            if(cur.children[idx] == null)
                cur.children[idx] = new TrieNode();

            cur = cur.children[idx];
        }
        cur.isEnd = true;
    }

    public int distinctSubstringCount(String str){
        //will hold the count of unique substrings
        int cnt = 0;
        for (int i = 0; i <= str.length(); i++){
            //start from root of trie each time as new starting point
            TrieNode temp = root;
            for (int j = i; j < str.length(); j++){
                char ch = str.charAt(j);
                //when char not present add it to the trie
                if(temp.children[ch - 'a'] == null){
                    temp.children[ch - 'a'] = new TrieNode();
                    temp.isEnd = true;
                    cnt++;
                }
                //move on to the next char
                temp = temp.children[ch - 'a'];
            }
        }
        return cnt;
    }

    public static void main (String[] args) {

        Scanner input = new Scanner(System.in);

        int k =  Integer.parseInt(input.nextLine().split(" ")[1]);
        String str =  input.nextLine();

        for (int i = 0; i < k; i++) {

            String[] line =  input.nextLine().split(" ");

            int l = Integer.parseInt(line[0]);
            int r = Integer.parseInt(line[1]);

            String sub = str.substring(l,r+1);

            subs_in_rang t = new subs_in_rang();

//            System.out.println(sub);
            System.out.println(t.distinctSubstringCount(sub));

        }
    }

}

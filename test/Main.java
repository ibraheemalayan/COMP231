package test;

public class Main {

    int id;

    public static void changeString(String s){
        s= "new";

    }

    public static void main(String[] args) {


        Main m = new Main();
        m.id = 2;

        Main m2 = new Main();
        m2.id = 2;

        String s = "old";

        changeString(s);

        System.out.println(s);
    }
}

package Revision;

import Revision.oop.Modifiers;

public class Tester {

    static void bar(){
        System.out.println("Raw Bar");
    }
    static void bar(int x){
        System.out.println("Bar " + x);
    }
    static void foo(float x){
        System.out.println("Foo 1 " + x);
    }
    static void foo(double x){
        System.out.println("Foo 2 " + x);
    }

    public static void main(String[] args) {

        bar();
        foo(2.0);

        bar(10);
        foo(3); // 3 is int

    }

}

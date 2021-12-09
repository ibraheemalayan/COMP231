
package aa;

class Grandfather {

    String name = "Grand ";

    String doStuff() {
        return "GRAND_F ";
    }
}

class Father extends Grandfather {
    String name = "Father ";

    String doStuff() {
        return "FATHER >" + name;
    }
}

public class Child extends Father {
    String name = "CH ";

    String doStuff() {
        return "CHILD ";
    }

    public static void main(String[] args) {
        Father f = new Father();
        System.out.println(((Grandfather) f).name + ((Grandfather) f).doStuff());
        Child c = new Child();
        System.out.println(((Grandfather) c).name + ((Grandfather) c).doStuff() + ((Father) c).doStuff());
    }
}

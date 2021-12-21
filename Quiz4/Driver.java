package Quiz4;

public class Driver {

    public static void main(String[] args) {

        try{
            Triangle t1 = new Triangle(1,1,1); // works fine
            Triangle t2 = new Triangle(2,10,14); // throws exception
        }catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
        }





    }
}

package Revision.inheritance;

public class Tester {

    public static void main(String[] args) {

        Bicycle normal_bike = new Bicycle();

        normal_bike.accelerate(); // speed of normal_bike is 10
        normal_bike.brake();// speed of normal_bike is 0

        ElectricBicycle e_bike = new ElectricBicycle();
        // battery is 30, speed is 0

        e_bike.accelerate();
        // speed of e_bike is 20 , battery is 25

        e_bike.brake();// speed of e_bike is 10

        e_bike.charge_one_hour();
        // battery is 65


        ElectricBicycle b = new ElectricBicycle();
        Bicycle b2 = new ElectricBicycle();
//        ElectricBicycle b3 = new Bicycle();
        

    }
    
}

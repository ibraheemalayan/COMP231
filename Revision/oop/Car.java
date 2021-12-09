package Revision.oop;

public class Car {

    private double speed = 0;

    private double Acceleration;
    private String Model;

    public Car(double acceleration, String model) {
        Acceleration = acceleration;
        Model = model;
    }

    public void accelerate_for_one_second(){

        speed += Acceleration;

    }

    public void brake_for_one_second(){
        speed -= Acceleration;
    }

    public double getSpeed(){
        return speed;
    }

    public String getModel() {
        return Model;
    }
}

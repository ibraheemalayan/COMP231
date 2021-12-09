package Revision.inheritance;

public class Bicycle {

    protected double speed, acceleration = 10.0;

//    public Bicycle(double speed) {
//        this.speed = speed;
//    }

    public void brake(){
        this.speed -= acceleration;
    }

    public void accelerate(){
        this.speed += acceleration;
    }

    
}
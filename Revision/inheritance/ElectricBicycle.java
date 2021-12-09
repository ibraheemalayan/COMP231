package Revision.inheritance;

public class ElectricBicycle extends Bicycle{

    //                      override
    protected double battery = 30.0, acceleration = 20;

    @Override
    public void accelerate(){
        super.accelerate();
        this.battery -= 5;
    }

    public void charge_one_hour(){
        this.battery += 40;
    }

//    public ElectricBicycle(){
//        super(0.0);
//        this.battery = 5;
//    }
//    public ElectricBicycle(double speed){
//        super(speed);
//        this.battery = 5;
//    }
}

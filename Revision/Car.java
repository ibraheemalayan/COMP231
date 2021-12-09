package Revision;

public class Car {

    double current_speed;
    int current_number_of_passengers;

    String color;

    static double max_speed=200.0;
    static double number_of_doors=4;

    public Car() {
        System.out.println("Car() invoked");
        this.current_speed = 0.0;
        this.current_number_of_passengers = 0;
        this.color = "Black";
    }

    public Car(double current_speed, int current_number_of_passengers, String color) {
        System.out.println("Car(double current_speed, int current_number_of_passengers, String color) invoked");
        this.current_speed = current_speed;
        this.current_number_of_passengers = current_number_of_passengers;
        this.color = color;
    }



    void brake(){
        this.current_speed -= 10;
    }

    void gas(){
        this.current_speed += 10;
    }

    void add_passenger(){
        this.current_number_of_passengers ++;
    }

    void paint_car(String new_color){
        this.color = new_color;
    }
}
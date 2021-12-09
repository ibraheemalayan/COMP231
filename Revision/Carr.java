package Revision;

public class Carr {

    double current_speed=0.0;
    double current_number_of_passengers=0;

    String color="Black";

    double max_speed=200.0;


    

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
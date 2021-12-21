package Final_Project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

enum PlanType {
    LIMITED,
    UNLIMITED
}

public class Customer implements Serializable {

    public static int limited_plan_limit = 2;

    private String name, address;
    private PlanType plan;

    private ArrayList<Media> rented, cart;

    public Customer(String name, String address, String plan) throws IllegalArgumentException {
        this.name = name;
        this.address = address;
        this.plan = PlanType.valueOf(plan.toUpperCase());

        this.rented = new ArrayList<Media>();
        this.cart = new ArrayList<Media>();
    }

    public Customer(String name, String address, PlanType plan) {
        this.name = name;
        this.address = address;
        this.plan = plan;

        this.rented = new ArrayList<Media>();
        this.cart = new ArrayList<Media>();
    }

    public boolean canRent(){
        if( plan.equals(PlanType.LIMITED) ) {
            return rented.size() < limited_plan_limit;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public PlanType getPlan() {
        return plan;
    }

    public void RentMedia(Media m){
        if ( this.canRent() && m.available() ){
            rented.add(m);
        }
//        TODO throw exception on failure
    }

    public void AddToCart(Media m){
        cart.add(m);
    }

    public String proccess_requests(){

        String res = "";
        for ( Media m : cart ) {

            if ( m.available() && this.canRent() ){
                m.rent_media();
                this.rented.add(m);
                res += "Sending " + m.getTitle() + " to " + this.getName() + "\n";
            }

        }
        return res;
    }

    public void return_media(Media m){

//        for ( Media m : cart ) {
//
//            if ( m.available() && this.canRent() ){
//                m.rent_media();
//                this.rented.add(m);
//                res += "Sending " + m.getTitle() + " to " + this.getName() + "\n";
//            }
//
//        }
//        return res;
    }

    private int searchMediaByTitle(String Title, ArrayList<Media> media){

        return Collections.binarySearch(media, new Media(Title, 0), Comparator.comparing(Media::getTitle));

    }

    public void RemoveFromCart(Media m){
        cart.add(m);
    }

    public int count_rented(){
        return rented.size();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", plan=" + plan +
                ", rented=" + rented +
                ", cart=" + cart +
                '}';
    }
}

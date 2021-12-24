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
    public boolean RemoveFromCart(String media_title){

        int index = searchMediaByTitle(media_title, this.cart);
        if ( index >= 0 ){
            this.cart.remove(index);
            return true;
        }
        return false;

    }

    public String proccess_requests(){

        String res = "";
        for (int i = 0; i < cart.size(); i++) {
            Media m = cart.get(i);
            if ( m.available() && this.canRent() ){
                m.rent_media();
                this.rented.add(m);
                res += "Sending " + m.getTitle() + " to " + this.getName() + "\n";
                this.cart.remove(m);
            }

        }
        return res;
    }

    public boolean ReturnMedia(String media_title){

        int index = searchMediaByTitle(media_title, this.rented);
        if ( index >= 0 ){
            this.rented.get(index).return_media();
            this.rented.remove(index);
            return true;
        }
        return false;


    }

    private int searchMediaByTitle(String Title, ArrayList<Media> media){

        return Collections.binarySearch(media, new Media(Title, 0), Comparator.comparing(Media::getTitle));

    }

    public int count_rented(){
        return rented.size();
    }

    @Override
    public String toString() {
        return "Customer{\n\t" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", plan=" + plan +
                ", \n\trented=" + rented +
                ", \n\tcart=  " + cart +
                "}\n";
    }
}

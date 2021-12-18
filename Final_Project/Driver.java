package Final_Project;

import org.junit.Test;

import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {

        MediaRental m = new MediaRental();

//        m.addCustomer();
//        m.addAlbum();

    }

    @Test(expected = IllegalArgumentException.class)
    public void InvalidPlanTest() {

        String illegal_plan = "Unlimited Pro";
        Customer c = new Customer("Some Name", "Some address", illegal_plan);
    }

    @Test
    public void CanRentTest() {

        Customer c = new Customer("Some Name", "Some address", PlanType.LIMITED);

        c.RentMedia(new Game("COD MW3", 2, 23.2));
        assert c.canRent() == true;
        c.RentMedia(new Game("COD MW3", 2, 23.2));
        assert c.canRent() == false;

        Customer c2 = new Customer("Some Name", "Some address", PlanType.UNLIMITED);

        c2.RentMedia(new Game("COD MW3", 2, 23.2));
        c2.RentMedia(new Game("COD MW3", 2, 23.2));
        c2.RentMedia(new Game("COD MW3", 2, 23.2));
        c2.RentMedia(new Game("COD MW3", 2, 23.2));

        assert c2.canRent() == true;

    }

    @Test
    public void testAddingCustomers(){
        MediaRental sys = new MediaRental();

        sys.addCustomer("Ahmad","Jerusalem","limited" );
        sys.addCustomer("Asad","Ramallah","limited" );
        sys.addCustomer("Saeed","Jerusalem","unlimited" );
        sys.addCustomer("Mohammad","Hebron","limited" );
        sys.addCustomer("Rami","Yafa","unlimited" );

        System.out.println(sys.getAllCustomersInfo());
    }

    @Test
    public void testAddingMedia(){

        MediaRental sys = new MediaRental();

        sys.addAlbum("New Album", 6, "John", "song1,song2,song3");
        sys.addAlbum("Second Album", 65, "John", "the long song");
        sys.addAlbum("The Album", 36, "BigSam", "songA,songB,songC");

        sys.addGame("Call Of Duty", 90, 30.6);
        sys.addGame("Need For Speed", 8, 28.1);
        sys.addGame("Rocket League", 327, 40);

        sys.addMovie("White House Down", 50, "HQ");
        sys.addMovie("London Has Fallen", 12, "RB");
        sys.addMovie("Angel Has Fallen", 75, "RB");
        sys.addMovie("Hitman", 50, "LD");

        System.out.println(sys.getAllMediaInfo());

    }

    @Test
    public void testingAddingToCart(){

        MediaRental sys = new MediaRental();

        sys.addAlbum("New Album", 6, "John", "song1,song2,song3");
        sys.addAlbum("Second Album", 65, "John", "the long song");
        sys.addAlbum("The Album", 36, "BigSam", "songA,songB,songC");

        sys.addGame("Call Of Duty", 90, 30.6);
        sys.addGame("Need For Speed", 8, 28.1);
        sys.addGame("Rocket League", 327, 40);

        sys.addCustomer("Ahmad","Jerusalem","limited" );
        sys.addCustomer("Asad","Ramallah","limited" );
        sys.addCustomer("Saeed","Jerusalem","unlimited" );

        assert sys.addToCart("Asad", "Call Of Duty");
        assert sys.addToCart("Rami", "Call Of Duty") == false;
        assert sys.addToCart("Asad", "New Game") == false;

        System.out.println(sys.getAllCustomersInfo());

    }



    public void testingRemovingFromCart(){}
    public void testProcessingRequestsOne(){}
    public void testProcessingRequestsTwo(){}
    public void testReturnMedia(){}


    @Test
    public void testSearchMedia(){

        MediaRental sys = new MediaRental();

        sys.addAlbum("New Album", 6, "John", "song1,song2,song3");
        sys.addAlbum("Second Album", 65, "John", "the long song");
        sys.addAlbum("The Album", 36, "BigSam", "songA,songB,song1");

        sys.addGame("Call Of Duty", 90, 30.6);
        sys.addGame("Need For Speed", 8, 28.1);
        sys.addGame("Rocket League", 327, 40);

        sys.addMovie("White House Down", 50, "HQ");
        sys.addMovie("London Has Fallen", 12, "RB");
        sys.addMovie("Angel Has Fallen", 75, "RB");
        sys.addMovie("Hitman", 50, "LD");

        ArrayList<String> search = sys.searchMedia(null,null,null,null);

        assert search.size() == 10;

        ArrayList<String> search2 = sys.searchMedia("White House Down",null,null,null);

        assert search2.size() == 1;
        assert search2.get(0).equals("White House Down");

        ArrayList<String> search3 = sys.searchMedia("Non Existing thing",null,null,null);

        assert search3.size() == 0;

        ArrayList<String> search4 = sys.searchMedia(null,null,"John",null);

        assert search4.size() == 2;
        assert search4.get(1).equals("Second Album");

        ArrayList<String> search5 = sys.searchMedia(null,"L",null,null);

        assert search5.size() == 0;

        ArrayList<String> search6 = sys.searchMedia(null,"RB",null,null);

        assert search6.size() == 2;
        assert search6.get(0).equals("Angel Has Fallen");
        assert search6.get(1).equals("London Has Fallen");

        ArrayList<String> search7 = sys.searchMedia("New Album",null,"John",null);

        assert search7.size() == 1;
        assert search7.get(0).equals("New Album");

        ArrayList<String> search8 = sys.searchMedia("New Album",null,"SAMM",null);

        assert search8.size() == 0;

        ArrayList<String> search9 = sys.searchMedia("New Album","RB",null,null);

        assert search9.size() == 0;

        ArrayList<String> search10 = sys.searchMedia(null,null,null,"song1");

        assert search10.size() == 2;
        assert search10.get(0).equals("New Album");

        ArrayList<String> search11 = sys.searchMedia("New Album",null,"John","songy");

        assert search11.size() == 0;

//        for(int i = 0; i < search10.size(); i++){
//            System.out.print("\n\t" + search10.get(i));
//        }

    }
}

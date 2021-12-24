package Final_Project;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public class Driver {

    static MediaRental loadFile(){
        MediaRental sys2 = null;

        // Deserialization
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("RentalSystemState.save");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            sys2 = (MediaRental) in.readObject();

            in.close();
            file.close();

            System.out.println("\nObject has been deserialized \n\n");
        }

        catch(FileNotFoundException ex)
        {
            System.out.println("FileNotFoundException is caught");
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }

        if ( sys2 == null ){
            sys2 = new MediaRental();
        }

        return sys2;
    }

    public static void main(String[] args) {

        // To use data saved in the file
        MediaRental m = loadFile();

        // To construct a new empty system
        MediaRental m2 = new MediaRental();

        // Run Tests



    }

    @Test(expected = IllegalArgumentException.class)
    public void InvalidPlanTest() {

        String illegal_plan = "Unlimited Pro";
        new Customer("Some Name", "Some address", illegal_plan);
    }


    @Test
    public void testFileIO(){

        MediaRental sys = new MediaRental();

        sys.addAlbum("New Album", 6, "John", "song1,song2,song3");
        sys.addAlbum("Second Album", 65, "John", "the long song");
        sys.addAlbum("The Album", 36, "BigSam", "songA,songB,songC");

        sys.addGame("Call Of Duty", 2, 30.6);
        sys.addGame("Need For Speed", 8, 28.1);
        sys.addGame("Rocket League", 327, 40);

        sys.addCustomer("Ahmad","Jerusalem","limited" );
        sys.addCustomer("Asad","Ramallah","limited" );
        sys.addCustomer("Saeed","Jerusalem","unlimited" );

        sys.addToCart("Asad", "Call Of Duty");
        sys.addToCart("Ahmad", "Second Album");
        sys.addToCart("Ahmad", "The Album");
        sys.addToCart("Ahmad", "Call Of Duty");
        sys.addToCart("Saeed", "Call Of Duty");
        sys.addToCart("Rami", "Call Of Duty");
        sys.addToCart("Asad", "New Game");

        System.out.println(sys.processRequests());

        System.out.println("Data to be written >> \n");

        System.out.println(sys.getAllCustomersInfo());

        System.out.println("\n\n--------------- \n File Was Written, reading data in a new object \n---------------\n\n");

        MediaRental sys2 = loadFile();

        System.out.println("Read Data >> \n");

        System.out.println(sys2.getAllCustomersInfo());

        // Must be same data
        assert sys2.getAllCustomersInfo().equals( sys.getAllCustomersInfo() );

    }

    @Test
    public void CanRentTest() {

        (new MediaRental()).setLimitedPlanLimit(2);

        Customer c = new Customer("Some Name", "Some address", PlanType.LIMITED);

        c.RentMedia(new Game("COD MW2", 2, 23.2));
        assert c.canRent();
        c.RentMedia(new Game("COD MW3", 6, 23.2));
        assert !c.canRent();

        Customer c2 = new Customer("Some Name", "Some address", PlanType.UNLIMITED);

        c2.RentMedia(new Game("COD MW3", 2, 23.2));
        c2.RentMedia(new Game("COD MW3", 2, 23.2));
        c2.RentMedia(new Game("COD MW3", 2, 23.2));
        c2.RentMedia(new Game("COD MW3", 2, 23.2));

        assert c2.canRent();

    }

    @Test
    public void changeLimit() {

        MediaRental sys = new MediaRental();

        sys.addCustomer("Ahmad","Jerusalem","limited" );
        sys.addCustomer("Asad","Ramallah","limited" );

        sys.addMovie("London Has Fallen", 12, "RB");
        sys.addMovie("Angel Has Fallen", 75, "RB");
        sys.addGame("Call Of Duty", 90, 30.6);

        sys.addToCart("Ahmad", "London Has Fallen");
        sys.addToCart("Ahmad", "Angel Has Fallen");
        sys.addToCart("Ahmad", "Call Of Duty"); // shouldn't be rented



        String pr1 = sys.processRequests();

        System.out.println(pr1);

        assert ("Sending London Has Fallen to Ahmad\n" +
                "Sending Call Of Duty to Ahmad\n").equals(pr1);

        System.out.println("\n------------------------\n" + sys.getAllCustomersInfo() + "\n\n" );
        System.out.println(sys.getAllMediaInfo() + "\n" );
        System.out.println("\n------------------------\n");

        sys.setLimitedPlanLimit(5);

        MediaRental sys2 = loadFile();

        String pr2 = sys2.processRequests();

        assert "Sending Angel Has Fallen to Ahmad\n".equals(pr2);

        System.out.println(pr2);

        System.out.println("\n------------------------\n" + sys2.getAllCustomersInfo() + "\n\n" );
        System.out.println(sys2.getAllMediaInfo() + "\n" );
        System.out.println("\n------------------------\n");


    }

    @Test
    public void testAddingCustomers(){
        MediaRental sys = new MediaRental();



        sys.addCustomer("Ahmad","Jerusalem","limited" );
        sys.addCustomer("Asad","Ramallah","limited" );
        sys.addCustomer("Saeed","Jerusalem","unlimited" );
        sys.addCustomer("Mohammad","Hebron","limited" );
        sys.addCustomer("Rami","Yafa","unlimited" );

        System.out.println("\n------------------------\n" + sys.getAllCustomersInfo() + "\n\n" );
        System.out.println(sys.getAllMediaInfo() + "\n" );
        System.out.println("\n------------------------\n");
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


        System.out.println("\n------------------------\n" + sys.getAllCustomersInfo() + "\n\n" );
        System.out.println(sys.getAllMediaInfo() + "\n" );
        System.out.println("\n------------------------\n");

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
        assert !sys.addToCart("Rami", "Call Of Duty");
        assert !sys.addToCart("Asad", "New Game");

        System.out.println("\n------------------------\n" + sys.getAllCustomersInfo() + "\n\n" );
        System.out.println(sys.getAllMediaInfo() + "\n" );
        System.out.println("\n------------------------\n");

    }


    @Test
    public void testingRemovingFromCart(){

        MediaRental sys = new MediaRental();

        sys.addAlbum("New Album", 6, "John", "song1,song2,song3");
        sys.addAlbum("Second Album", 65, "John", "the long song");
        sys.addAlbum("The Album", 36, "BigSam", "songA,songB,songC");

        sys.addGame("Call Of Duty", 2, 30.6);
        sys.addGame("Need For Speed", 8, 28.1);
        sys.addGame("Rocket League", 327, 40);

        sys.addCustomer("Ahmad","Jerusalem","limited" );
        sys.addCustomer("Asad","Ramallah","limited" );
        sys.addCustomer("Saeed","Jerusalem","unlimited" );

        sys.addToCart("Asad", "Call Of Duty");

        sys.removeFromCart("Asad", "Call Of Duty");

        sys.addToCart("Ahmad", "Second Album");
        sys.addToCart("Ahmad", "The Album");
        sys.addToCart("Ahmad", "Call Of Duty");
        sys.addToCart("Saeed", "Call Of Duty");

        sys.addToCart("Rami", "Call Of Duty");

        sys.removeFromCart("Rami", "Call Of Duty");

        sys.addToCart("Asad", "New Game");

        System.out.println("\n------------------------\n" + sys.getAllCustomersInfo() + "\n\n" );
        System.out.println(sys.getAllMediaInfo() + "\n" );
        System.out.println("\n------------------------\n");

        System.out.println(sys.processRequests());

        System.out.println("\n------------------------\n" + sys.getAllCustomersInfo() + "\n\n" );
        System.out.println(sys.getAllMediaInfo() + "\n" );
        System.out.println("\n------------------------\n");

    }

    @Test
    public void testProcessingRequestsOne(){

        MediaRental sys = new MediaRental();

        sys.addAlbum("New Album", 6, "John", "song1,song2,song3");
        sys.addAlbum("Second Album", 65, "John", "the long song");
        sys.addAlbum("The Album", 36, "BigSam", "songA,songB,songC");

        sys.addGame("Call Of Duty", 2, 30.6);
        sys.addGame("Need For Speed", 8, 28.1);
        sys.addGame("Rocket League", 327, 40);

        sys.addCustomer("Ahmad","Jerusalem","limited" );
        sys.addCustomer("Asad","Ramallah","limited" );
        sys.addCustomer("Saeed","Jerusalem","unlimited" );

        sys.addToCart("Asad", "Call Of Duty");
        sys.addToCart("Ahmad", "Second Album");
        sys.addToCart("Ahmad", "The Album");
        sys.addToCart("Ahmad", "Call Of Duty");
        sys.addToCart("Saeed", "Call Of Duty");
        sys.addToCart("Rami", "Call Of Duty");
        sys.addToCart("Asad", "New Game");

        System.out.println("\n------------------------\n" + sys.getAllCustomersInfo() + "\n\n" );
        System.out.println(sys.getAllMediaInfo() + "\n" );
        System.out.println("\n------------------------\n");

        System.out.println(sys.processRequests());

        System.out.println("\n------------------------\n" + sys.getAllCustomersInfo() + "\n\n" );
        System.out.println(sys.getAllMediaInfo() + "\n" );
        System.out.println("\n------------------------\n");
    }

    @Test
    public void testProcessingRequestsTwo(){

        MediaRental sys = loadFile();

        sys.addAlbum("New Album", 6, "John", "song1,song2,song3");
        sys.addAlbum("Second Album", 65, "John", "the long song");
        sys.addAlbum("The Album", 36, "BigSam", "songA,songB,songC");

        sys.addGame("Call Of Duty", 2, 30.6);
        sys.addGame("Need For Speed", 8, 28.1);
        sys.addGame("Rocket League", 327, 40);

        sys.addCustomer("Ahmad","Jerusalem","limited" );
        sys.addCustomer("Asad","Ramallah","limited" );
        sys.addCustomer("Saeed","Jerusalem","unlimited" );

        sys.addToCart("Asad", "Call Of Duty");
        sys.addToCart("Ahmad", "Second Album");
        sys.addToCart("Ahmad", "The Album");
        sys.addToCart("Ahmad", "Call Of Duty");
        sys.addToCart("Saeed", "Call Of Duty");
        sys.addToCart("Rami", "Call Of Duty");
        sys.addToCart("Asad", "New Game");

        System.out.println(sys.getAllCustomersInfo() + "\n\n" );

        System.out.println(sys.processRequests());

        System.out.println(sys.getAllCustomersInfo());

    }

    @Test
    public void testReturnMedia(){

        MediaRental sys = new MediaRental();

        sys.addAlbum("New Album", 6, "John", "song1,song2,song3");
        sys.addAlbum("Second Album", 65, "John", "the long song");
        sys.addAlbum("The Album", 36, "BigSam", "songA,songB,songC");

        sys.addGame("Call Of Duty", 2, 30.6);
        sys.addGame("Need For Speed", 8, 28.1);
        sys.addGame("Rocket League", 327, 40);

        sys.addCustomer("Ahmad","Jerusalem","limited" );
        sys.addCustomer("Asad","Ramallah","limited" );
        sys.addCustomer("Saeed","Jerusalem","unlimited" );

        sys.addToCart("Asad", "Call Of Duty");
        sys.addToCart("Ahmad", "Second Album");
        sys.addToCart("Ahmad", "The Album");
        sys.addToCart("Ahmad", "Call Of Duty");
        sys.addToCart("Saeed", "Call Of Duty");
        sys.addToCart("Rami", "Call Of Duty");
        sys.addToCart("Asad", "New Game");

        System.out.println(sys.processRequests());

        System.out.println("\n------------------------\n" + sys.getAllCustomersInfo() + "\n\n" );
        System.out.println(sys.getAllMediaInfo() + "\n" );
        System.out.println("\n------------------------\n");

        sys.returnMedia("Ahmad", "Second Album");
        sys.returnMedia("Saeed", "Call Of Duty");
        sys.returnMedia("Rami", "Second Album");

        System.out.println("\n------------------------\n" + sys.getAllCustomersInfo() + "\n\n" );
        System.out.println(sys.getAllMediaInfo() + "\n" );
        System.out.println("\n------------------------\n");


    }


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

        ArrayList<String> search8 = sys.searchMedia("New Album",null,"SAM",null);

        assert search8.size() == 0;

        ArrayList<String> search9 = sys.searchMedia("New Album","RB",null,null);

        assert search9.size() == 0;

        ArrayList<String> search10 = sys.searchMedia(null,null,null,"song1");

        assert search10.size() == 2;
        assert search10.get(0).equals("New Album");

        ArrayList<String> search11 = sys.searchMedia("New Album",null,"John","song Y");

        assert search11.size() == 0;

//        for(int i = 0; i < search10.size(); i++){
//            System.out.print("\n\t" + search10.get(i));
//        }

    }
}

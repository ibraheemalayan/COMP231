package Final_Project;

import java.util.ArrayList;

public interface MediaRentalInt {

    /**
     * Adds the specified customer to the database. The address is a physical address (not e-mail). The plan options available
     * are: LIMITED and UNLIMITED. LIMITED defines a default maximum of two media that can be rented.
     * @param name
     * @param address
     * @param plan
     */
    void addCustomer(String name,String address,String plan);

    /**
     * Adds the specified movie to the database. The possible values for rating are "DR", "HR", "AC".
     * @param title
     * @param copiesAvailable
     * @param rating
     */
    void addMovie(String title, int copiesAvailable,String rating);

    /**
     * Adds the specified game to the database.
     * @param title
     * @param copiesAvailable
     * @param weight
     */
    void addGame(String title, int copiesAvailable,double weight);

    /**
     * Adds the specified album to the database.
     * The songs String includes a list of the title of songs on the album
     * (song titles are separated by commas).
     * @param title
     * @param copiesAvailable
     * @param artist
     * @param songs
     */
    void addAlbum(String title,int copiesAvailable,String artist,String songs);

    /**
     * This set the number of media associated with the LIMITED plan.
     * @param value
     */
    void setLimitedPlanLimit(int value);

    /**
     * @return information about the customers in the database. The information is presented sorted by customer name.
     */
    String getAllCustomersInfo();


    /**
     * @return information about all the media (movies, albums, and games) that are part of the database
     * The information is presented sorted by media title.
     */
    String getAllMediaInfo();


    /**
     * Adds the specified media title to the cart associated with a customer.
     * @param customerName
     * @param mediaTitle
     * @return false if the mediaTitle is already part of the cart (it will not be added)
     */
    boolean addToCart(String customerName,String mediaTitle);


    /**
     * Removes the specified media title from the customer's cart.
     * @param customerName
     * @param mediaTitle
     * @return false if removal failed for any reason (e.g., customerName not found)
     */
    boolean removeFromCart(String customerName, String mediaTitle);

    /**
     *  Processes the requests cart of each customer.
     *  The customers will be processed in alphabetical order.
     *  For each customer, the requests cart will be checked and media will be added to the rented cart,
     *  if the plan associated with the customer allows it, and if there is a copy of the media available.
     *  For UNLIMITED plans the media will be added to the rented cart always,
     *  as long as there are copies associated with the media available.
     *  For LIMITED plans,
     *  the number of entries moved from the requests cart to the rented cart will depend on the number of currently rented media,
     *  and whether copies associated with the media are available.
     *    For each media that is rented, the following message will be generated:
     * "Sending [mediaTitle] to [customerName]"
     * @return the message log
     */
    String processRequests();



    /**
     * This is how a customer returns a rented media. This method will remove the item from the rented cart and adjust any
     * other values that are necessary (e.g., copiesAvailable)
     * @param customerName
     * @param mediaTitle
     * @return
     */
    boolean returnMedia(String customerName,String mediaTitle);


    /**
     * @param title
     * @param rating
     * @param artist
     * @param songs
     * @return a SORTED ArrayList with media titles that satisfy the provided parameter values. If null is specified for a parameter,
     * then that parameter should be ignore in the search. Providing null for all parameters will return all media titles.
     */
    ArrayList<String> searchMedia(String title, String rating, String artist, String songs);

}

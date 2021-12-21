package Final_Project;

import java.io.Serializable;

public class Media implements Comparable<Media>, Serializable {

//    private static final long serialVersionUID = 628789568975888436L;

    protected String title;
    protected int num_of_available_copies;

    public Media(String title, int num_of_available_copies) {
        this.title = title;
        this.num_of_available_copies = num_of_available_copies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean available() {
        return num_of_available_copies > 0;
    }

    public void rent_media() {
        this.num_of_available_copies -= 1;
    }

    public void return_media() {
        this.num_of_available_copies += 1;
    }

    @Override
    public int compareTo(Media o) {
        return this.title.compareTo( ( (Media) o ).getTitle() );
    }

    @Override
    public boolean equals(Object o){

        if (! (o instanceof Media) ){
            throw new ClassCastException("Given object cannot be compared with a media object");
        }

        return this.compareTo( (Media) o ) == 0;
    }

}

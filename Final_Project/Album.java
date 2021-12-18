package Final_Project;

import java.util.ArrayList;

public class Album extends Media{

    private String artist;
    private String songs;

    public Album(String title, int num_of_available_copies, String artist, String songs) {
        super(title, num_of_available_copies);
        this.artist = artist;
        this.songs = songs;
    }

    public String getArtist() {
        return artist;
    }

    public String getSongs() {
        return songs;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", songs='" + songs + '\'' +
                ", artist='" + artist + '\'' +
                ", num_of_available_copies=" + num_of_available_copies +
                '}';
    }
}

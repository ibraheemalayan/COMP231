package Final_Project;

public class Game extends Media{

    private double weight;

    public Game(String title, int num_of_available_copies, double weight) {
        super(title, num_of_available_copies);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", weight=" + weight +
                ", num_of_available_copies=" + num_of_available_copies +
                '}';
    }
}

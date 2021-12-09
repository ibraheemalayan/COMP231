package Lab5;

public class City {

    private String cityName;
    private double longitude;
    private double latitude;
    private int temperature;

    public City(String cityName, double longitude, double latitude, int temperature) {
        this.cityName = cityName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.temperature = temperature;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", temperature=" + temperature +
                '}';
    }

    public void printCityInfo(){
        System.out.println(this);
    }
}

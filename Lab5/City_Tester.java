package Lab5;

import java.util.Date;

public class City_Tester {

    public static void main(String[] args) {

        City[] cities = new City[4];

        cities[0] = new City("Jerusalem",33.443435434,33.443435434, 35);
        cities[1] = new City("Hebron",43.465435434,33.443435434, 37);
        cities[2] = new City("Ramallah",33.443435434,33.443435434, 42);
        cities[3] = new City("Nabuls",33.443435434,33.443435434, 22);

        belowAverage(cities, 40);



    }

    public static void belowAverage( City [ ] cities , int avgTemp){


        for (int i = 0; i < 4; i++) {

            if (cities[i].getTemperature() < avgTemp){
                cities[i].printCityInfo();
            }

        }
    }


}

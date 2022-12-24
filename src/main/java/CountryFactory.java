import java.util.ArrayList;
import java.util.List;

public class CountryFactory {

    private static CountryFactory countryFactory = null;

    public static synchronized CountryFactory getCountryFactory() {

        if (countryFactory == null)
            countryFactory = new CountryFactory();
        return countryFactory;
    }

    public Country createCountry(String countryName, String ...citizensAndSoldiers) {
        List<City> cities = new ArrayList<>();
        for (int i = 0; i < citizensAndSoldiers.length; i+=2) {
            City city = new City(citizensAndSoldiers[i+1], citizensAndSoldiers[i]);
            cities.add(city);
        }

        Country country = new Country(countryName, cities);

        return country;

    }

}

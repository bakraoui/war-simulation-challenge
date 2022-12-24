import java.util.List;

public class PowerCalculator {

    private static PowerCalculator instance;

    private PowerCalculator() {}

    public static synchronized PowerCalculator getInstance() {
        if (instance == null)
            instance = new PowerCalculator();
        return instance;
    }

    public Long getcurrentPower(KingDom kingDom) {
        Long result = 0l;
        List<Country> countries = kingDom.getCountries();

        for (Country country : countries ) {

            List<City> cities = country.getCities();
            for (City city: cities)
                result += Integer.parseInt(city.getNumberOfSoldiers());

        }


        return result;
    }
}

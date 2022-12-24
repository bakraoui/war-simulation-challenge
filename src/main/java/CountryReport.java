import java.util.List;

public class CountryReport {

    public static CountryReport countryReport = null;

    public static synchronized CountryReport getInstance() {
        if (countryReport == null)
            countryReport = new CountryReport();
        return countryReport;
    }

    public String getReport(Country country) {

        StringBuilder result = new StringBuilder();
        List<City> cities = country.getCities();
        String firstLetter = country.getName().substring(0,1);
        result.append(firstLetter).append(":<");
        int cityIndex = 1;
        for (City city: cities){
            if (cityIndex != 1)
                result.append(",");
            result.append(firstLetter)
                    .append("c")
                    .append(cityIndex)
                    .append(":")
                    .append(city.getNumberOfSoldiers())
                    .append("-")
                    .append(city.getNumberOfCitizens());

            cityIndex++;
        }

        result.append(">");
        if (country.getSoldiersOnEdges() != null && !country.getSoldiersOnEdges().equals(""))
            result.append("-").append(country.getSoldiersOnEdges());


        return result.toString();
    }
}

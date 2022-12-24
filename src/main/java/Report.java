import java.util.List;

public class Report {

    private static Report instance;

    private Report() {}

    public static synchronized Report getInstance() {

        if (instance == null)
            instance = new Report();
        return instance;
    }

    public String getReport(KingDom kingDom) {
        StringBuilder result = new StringBuilder();

        String kingName = kingDom.getKing().getName();
        result.append(kingName).append(":|");

        List<Country> countries = kingDom.getCountries();

        int countryIndex = 1;
        for (Country country: countries) {
            String report = country.getReport();
            if (countryIndex != 1)
                result.append(",");
            result.append(report);
            countryIndex++;
        }

        result.append("|");
        return result.toString();
    }


}

import java.util.ArrayList;
import java.util.List;

public class Country {
    private String name;
    private List<City> cities = new ArrayList<>();
    private String soldiersOnEdges;

    private CountryReport countryReport = CountryReport.getInstance();

    public Country(String name, List<City> cities) {
        this.name = name;
        this.cities = cities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public String getSoldiersOnEdges() {
        return soldiersOnEdges;
    }

    public void setSoldiersOnEdges(String soldiersOnEdges) {
        this.soldiersOnEdges = soldiersOnEdges;
    }


    public String getReport() {
        return countryReport.getReport(this);
    }
}

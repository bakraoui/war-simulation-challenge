import java.util.ArrayList;
import java.util.List;

public class KingDom {

    private King king;
    private List<Country> countries = new ArrayList<>();


    private final Report report = Report.getInstance();
    private final PowerCalculator powerCalculator = PowerCalculator.getInstance();

    public King getKing() {
        return king;
    }

    public void setKing(King king) {
        this.king = king;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }


    /*
    * this method to get a report about the kingdom power/statistics
    * @params no parameter
    * @return string
    * */

    public String report() {
        return report.getReport(this);
    }

    /*
     * this method to get the current power of the kingdom
     * @params no parameter
     * @return string
     * */

    public Long currentPower() {
        return powerCalculator.getcurrentPower(this);
    }
}

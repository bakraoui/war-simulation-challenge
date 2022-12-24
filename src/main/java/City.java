public class City {
    private String numberOfCitizens;
    private String numberOfSoldiers;

    public City(String numberOfCitizens, String numberOfSoldiers) {
        this.numberOfCitizens = numberOfCitizens;
        this.numberOfSoldiers = numberOfSoldiers;
    }

    public String getNumberOfCitizens() {
        return numberOfCitizens;
    }

    public void setNumberOfCitizens(String numberOfCitizens) {
        this.numberOfCitizens = numberOfCitizens;
    }

    public String getNumberOfSoldiers() {
        return numberOfSoldiers;
    }

    public void setNumberOfSoldiers(String numberOfSoldiers) {
        this.numberOfSoldiers = numberOfSoldiers;
    }
}

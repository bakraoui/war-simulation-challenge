import java.util.List;

public class KingDomBuilder {

    private final KingDom kingDom = new KingDom();
    private final CountryFactory countryFactory = CountryFactory.getCountryFactory();

    public KingDomBuilder() {}

    public KingDomBuilder addKing(String kingName){
        King king = new King(kingName);
        kingDom.setKing(king);
        return this;
    }

    public KingDomBuilder addSoldiersOnEdges(String soldiersOnEdges){
        List<Country> countries = kingDom.getCountries();
        countries.forEach(country -> country.setSoldiersOnEdges(soldiersOnEdges));
        return this;
    }

    public KingDomBuilder addCountry(String countryName, String ...citizensAndSoldiers){

        // create country
        Country country = countryFactory.createCountry(countryName, citizensAndSoldiers);

        // add the country to the list of countries
        List<Country> countries = this.kingDom.getCountries();
        countries.add(country);
        this.kingDom.setCountries(countries);

        return this;
    }

    public KingDom build() {
        return this.kingDom;
    }

}

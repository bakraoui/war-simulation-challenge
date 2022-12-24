import java.util.*;

public class Attack {

    private static Attack attack = null;

    private Attack() {}

    public static synchronized Attack getInstance() {
        if (attack == null) attack = new Attack();
        return attack;
    }

    public void prepareAttack(War war) {
        List<KingDom> kingDomList = war.getKingDomList();
        String[] map = war.getMap().split(",");

        Long powerKingdomOne = kingDomList.get(0).currentPower();
        Long powerKingdomTwo = kingDomList.get(1).currentPower();

        Map<String, Integer> countriesFromDifferentKingdoms = new HashMap<>();

        // France:100:spain,France:1000:USA,Spain:1500:USA

        for (String str : map) {

            String[] mapDistance = str.split(":");
            String countryOne = mapDistance[0];
            String countryTwo = mapDistance[2];
            String distance = mapDistance[1];

            boolean fromSameKingdom = doesCountriesOfSameKingdom(countryOne, countryTwo, kingDomList);
            if (!fromSameKingdom)
                countriesFromDifferentKingdoms
                        .put(countryOne.concat(":")
                        .concat(countryTwo), Integer.parseInt(distance));

        }

        Map.Entry<String,Integer> min =  Collections.min(countriesFromDifferentKingdoms.entrySet(),
                Map.Entry.comparingByValue());

        System.out.println(min);

    }

    public boolean doesCountriesOfSameKingdom(String countryOne, String countryTwo, List<KingDom> kingDomList) {
        KingDom firstKingdom = kingDomList.get(0);
        List<Country> countries = firstKingdom.getCountries();

        boolean sameKingdom = true;

        for (Country country: countries){
            if (country.getName().equals(countryOne)) sameKingdom = !sameKingdom;
            if (country.getName().equals(countryTwo)) sameKingdom = !sameKingdom;
        }

        return sameKingdom;

    }
}

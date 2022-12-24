import java.util.List;

public class WarBuilder {

    private War war = new War();


    public WarBuilder() {}

    public WarBuilder addKingdom(KingDom kingDom) {
        List<KingDom> kingDomList = war.getKingDomList();
        kingDomList.add(kingDom);

        return this;
    }

    public WarBuilder addMap(String map) {
        war.setMap(map);

        return this;
    }

    public War build() {
        return war;
    }


}

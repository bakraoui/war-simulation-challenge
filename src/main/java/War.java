import java.util.ArrayList;
import java.util.List;

public class War {

    private List<KingDom> kingDomList = new ArrayList<>();
    private String map;
    private Attack attack = Attack.getInstance();

    public List<KingDom> getKingDomList() {
        return kingDomList;
    }

    public void setKingDomList(List<KingDom> kingDomList) {
        this.kingDomList = kingDomList;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public void prepareAttack() {
        attack.prepareAttack(this);
    }
}

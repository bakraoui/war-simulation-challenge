
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WarSimulationTest {

    @Test
    public void showKingDom(){
        KingDom kingDom = new KingDomBuilder()
                .addKing("Younes")
                .addCountry("France","20","100","50","200","100","100")
                .addCountry("Spain","30","200","40","300")
                .build();
        assertThat(kingDom.report())
                .isEqualTo("Younes:|F:<Fc1:20-100,Fc2:50-200,Fc3:100-100>,S:<Sc1:30-200,Sc2:40-300>|");

    }

    @Test
    public void showKingDomPower(){
        KingDom kingDom = new KingDomBuilder()
                .addKing("Younes")
                .addCountry("France","20","100","50","200","100","100")
                .addCountry("Spain","30","200","40","300")
                .build();
        assertThat(240L)
                .isEqualTo(kingDom.currentPower());
    }

    @Test
    public void aKingDomHaveSoldiersOnEdges(){
        KingDom kingDom1 = new KingDomBuilder()
                .addKing("Younes")
                .addCountry("France","20","100","50","200","100","100")
                .addCountry("Spain","30","200","40","300")
                .addSoldiersOnEdges("500")
                .build();

        KingDom kingDom2 = new KingDomBuilder()
                .addKing("Amine")
                .addCountry("USA","500","1000","400","500","200","300","2000","300")
                .build();

        assertThat("Younes:|F:<Fc1:20-100,Fc2:50-200,Fc3:100-100>-500,S:<Sc1:30-200,Sc2:40-300>-500|")
                .isEqualTo(kingDom1.report());

        assertThat("Amine:|U:<Uc1:500-1000,Uc2:400-500,Uc3:200-300,Uc4:2000-300>|").isEqualTo(kingDom2.report());
        assertThat(kingDom1.currentPower()).isEqualTo(240);
        assertThat(kingDom2.currentPower()).isEqualTo(3100L);

    }

    @Test
    public void aKingDomCanPrepareAnAttackAnOther(){
        KingDom kingdom1 = new KingDomBuilder()
                .addKing("Younes")
                .addCountry("France", "20","100","50","200","100","100")
                .addCountry("Spain", "30", "200", "40", "300")
                .addSoldiersOnEdges("500")
                .build();

        KingDom kingdom2 = new KingDomBuilder()
                .addKing("Amine")
                .addCountry("USA", "30","200","40","300")
                .addSoldiersOnEdges("200")
                .build();

        assertThat(kingdom1.report())
                .isEqualTo("Younes:|F:<Fc1:20-100,Fc2:50-200,Fc3:100-100>-500,S:<Sc1:30-200,Sc2:40-300>-500|");
        assertThat(kingdom2.report()).isEqualTo("Amine:|U:<Uc1:30-200,Uc2:40-300>-200|" );

        assertThat(kingdom1.currentPower()).isEqualTo(240L );
        assertThat(kingdom2.currentPower()).isEqualTo( 70L);

        War war = new WarBuilder()
                .addKingdom(kingdom1)
                .addKingdom(kingdom2)
                .addMap("France:100:spain, France:1000:USA, Spain:1500:USA")
                .build();

        war.prepareAttack();

        assertThat(kingdom1.report())
                .isEqualTo("Younes:|F:<Fc1:20-100,Fc2:50-200,Fc3:100-100>-535,S:<Sc1:15-200,Sc2:20-300>-500|" );
        assertThat( kingdom2.report()).isEqualTo("Amine:|U:<Uc1:30-200,Uc2:40-300>-200|");
        assertThat(kingdom1.currentPower()).isEqualTo(205L );
        assertThat(kingdom2.currentPower()).isEqualTo(70L );
    }

    @Test
    public void aKingDomCanAttackAnOther(){
        KingDom kingdom1 = new KingDomBuilder()
                .addKing("Younes")
                .addCountry("France", "20", "100", "50", "200", "100", "100")
                .addCountry("Spain", "30", "200", "40", "300")
                .addSoldiersOnEdges("500")
                .build();

        KingDom kingdom2 = new KingDomBuilder()
                .addKing("Amine")
                .addCountry("USA", "30", "200", "40", "300")
                .addSoldiersOnEdges("200")
                .build();

        assertThat(240L).isEqualTo( kingdom1.currentPower());
        assertThat(70L).isEqualTo( kingdom2.currentPower());

        War war = new WarBuilder()
                .addKingdom(kingdom1)
                .addKingdom(kingdom2)
                .addMap("France:100:Spain,France:1000:USA,Spain:1500:USA")
                .build();

        // the kingdom which has more power prepare Attack on the nearest kingdoms
        // when a kingdom prepare an attack he moves 50% of his army on each city to the country's edge which
        // is the nearest to the other kingdom
        war.prepareAttack();

        assertThat(kingdom1.report()).isEqualTo("Younes:|F:<Fc1:20-100,Fc2:50-200,Fc3:100-100>-535,S:<Sc1:15-200,Sc2:20-300>-500|");
        assertThat(kingdom2.report()).isEqualTo("Amine:|U:<Uc1:30-200,Uc2:40-300>-200|");
        assertThat(kingdom1.currentPower()).isEqualTo(205L );
        assertThat( kingdom2.currentPower()).isEqualTo(70L);
        // the kingdom attack the soldiers on edgeS of the nearest country
        // war.start();

        assertThat(kingdom1.report()).isEqualTo("Younes:|F:<Fc1:20-100,Fc2:50-200,Fc3:100-100>-335,S:<Sc1:15-200,Sc2:20-300>-500|");
        assertThat(kingdom2.report()).isEqualTo("Amine:|U:<Uc1:30-200,Uc2:40-300>|");
        assertThat(kingdom1.currentPower()).isEqualTo( 205L);
        assertThat(kingdom2.currentPower()).isEqualTo(70L );



    }

}

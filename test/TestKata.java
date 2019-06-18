import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;


public class TestKata {

    FirstClass firstSolution = new FirstClass();

    @ParameterizedTest
    @CsvSource({
            "HERO:HERO:HERO:CAPITAINE:SOLDAT:SOLDAT:SOLDAT, 14",
            "HERO:HERO:CAPITAINE:CAPITAINE:CAPITAINE:CAPITAINE:TRAITRE, 12",
            "HERO:HERO:HERO:CAPITAINE:CAPITAINE:CAPITAINE:MAUDIT, 14",
            "HERO:HERO:HERO:HERO:SOLDAT:TRAITRE:MAUDIT, 10",
            "SOLDAT:SOLDAT:SOLDAT:SOLDAT:SOLDAT:SOLDAT:MAGE, 12",
            "HERO:HERO:CAPITAINE:SOLDAT:SOLDAT:SOLDAT:MAGE, 17",
            "HERO:HERO:CAPITAINE:SOLDAT:SOLDAT:MAUDIT:MAGE, 15",
            "HERO:CAPITAINE:CAPITAINE:CAPITAINE:MAUDIT:MAUDIT:MAGE, 13",
            "HERO:HERO:CAPITAINE:CAPITAINE:SOLDAT:TRAITRE:MAGE, 15",
            "HERO:HERO:CAPITAINE:TRAITRE:TRAITRE:TRAITRE:MAGE, 11",
            "HERO:HERO:CAPITAINE:CAPITAINE:TRAITRE:MAUDIT:MAGE, 13",
            "HERO:HERO:SOLDAT:SOLDAT:TRAITRE:MAGE:MAGE, 16",
            "SOLDAT:MAUDIT:MAUDIT:MAGE:MAGE:MAGE:MAGE, 11",
            "HERO:CAPITAINE:CAPITAINE:TRAITRE:MAGE:MAGE:MAGE, 17",
            "HERO:SOLDAT:TRAITRE:TRAITRE:MAGE:MAGE:MAGE, 15"
    })
    public void testSumGurriers(String guerriers,int sum){

        String[] spl = guerriers.split(":");

        int exceptSum = firstSolution.getSumValue(spl);
        assertEquals(exceptSum,sum);
    }

    @ParameterizedTest
    @CsvSource({
            "HERO:HERO:HERO:CAPITAINE:SOLDAT:SOLDAT:SOLDAT",
            "HERO:HERO:CAPITAINE:CAPITAINE:CAPITAINE:CAPITAINE:TRAITRE",
            "HERO:HERO:HERO:CAPITAINE:CAPITAINE:CAPITAINE:MAUDIT",
            "HERO:HERO:HERO:HERO:SOLDAT:TRAITRE:MAUDIT",
            "SOLDAT:SOLDAT:SOLDAT:SOLDAT:SOLDAT:SOLDAT:MAGE",
            "HERO:HERO:CAPITAINE:SOLDAT:SOLDAT:SOLDAT:MAGE",
            "HERO:HERO:CAPITAINE:SOLDAT:SOLDAT:MAUDIT:MAGE",
            "HERO:CAPITAINE:CAPITAINE:CAPITAINE:MAUDIT:MAUDIT:MAGE",
            "HERO:HERO:CAPITAINE:CAPITAINE:SOLDAT:TRAITRE:MAGE",
            "HERO:HERO:CAPITAINE:TRAITRE:TRAITRE:TRAITRE:MAGE",
            "HERO:HERO:CAPITAINE:CAPITAINE:TRAITRE:MAUDIT:MAGE",
            "HERO:HERO:SOLDAT:SOLDAT:TRAITRE:MAGE:MAGE",
            "SOLDAT:MAUDIT:MAUDIT:MAGE:MAGE:MAGE:MAGE",
            "HERO:CAPITAINE:CAPITAINE:TRAITRE:MAGE:MAGE:MAGE",
            "HERO:SOLDAT:TRAITRE:TRAITRE:MAGE:MAGE:MAGE"

    })
    public void testSolution(String guerriers){
        String[] spl = guerriers.split(":");
        Solution solution = firstSolution.getSolution(spl);

        assertEquals(solution.ifSumEquels(),true);
        System.out.println(Arrays.toString(solution.getFirstArray())+" : "+Arrays.toString(solution.getSecondArray()));
    }

}

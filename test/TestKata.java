import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


public class TestKata {
    String guerriers_1[] = {"HERO", "HERO", "HERO", "CAPITAINE", "SOLDAT", "SOLDAT", "SOLDAT"};
    String guerriers_2[] = {"HERO", "HERO", "CAPITAINE", "CAPITAINE", "CAPITAINE", "CAPITAINE", "TRAITRE"};
    String guerriers_3[] = {"HERO", "HERO", "HERO", "CAPITAINE", "CAPITAINE", "CAPITAINE", "MAUDIT"};
    String guerriers_4[] = {"HERO", "HERO", "HERO", "HERO", "SOLDAT", "TRAITRE", "MAUDIT"};
    String guerriers_5[] = {"SOLDAT", "SOLDAT", "SOLDAT", "SOLDAT", "SOLDAT", "SOLDAT", "MAGE"};
    String guerriers_6[] = {"HERO", "HERO", "CAPITAINE", "SOLDAT", "SOLDAT", "SOLDAT", "MAGE"};
    String guerriers_7[] = {"HERO", "HERO", "CAPITAINE", "SOLDAT", "SOLDAT", "MAUDIT", "MAGE"};
    String guerriers_8[] = {"HERO", "CAPITAINE", "CAPITAINE", "CAPITAINE", "MAUDIT", "MAUDIT", "MAGE"};
    String guerriers_9[] = {"HERO", "HERO", "CAPITAINE", "CAPITAINE", "SOLDAT", "TRAITRE", "MAGE"};
    String guerriers_10[] = {"HERO", "HERO", "CAPITAINE", "TRAITRE", "TRAITRE", "TRAITRE", "MAGE"};
    String guerriers_11[] = {"HERO", "HERO", "CAPITAINE", "CAPITAINE", "TRAITRE", "MAUDIT", "MAGE"};
    String guerriers_12[] = {"HERO", "HERO", "SOLDAT", "SOLDAT", "TRAITRE", "MAGE", "MAGE"};
    String guerriers_13[] = {"SOLDAT", "MAUDIT", "MAUDIT", "MAGE", "MAGE", "MAGE", "MAGE"};
    String guerriers_14[] = {"HERO", "CAPITAINE", "CAPITAINE", "TRAITRE", "MAGE", "MAGE", "MAGE"};
    String guerriers_15[] = {"HERO", "SOLDAT", "TRAITRE", "TRAITRE", "MAGE", "MAGE", "MAGE"};


    FirstClass firstSolution = new FirstClass();

    @ParameterizedTest
    @CsvSource({
            "HERO:HERO:HERO:CAPITAINE:SOLDAT:SOLDAT:SOLDAT, 14",
            "HERO:HERO:CAPITAINE:CAPITAINE:CAPITAINE:CAPITAINE:TRAITRE, 11",
            "HERO:HERO:HERO:CAPITAINE:CAPITAINE:CAPITAINE:MAUDIT, 14",
            "HERO:HERO:HERO:HERO:SOLDAT:TRAITRE:MAUDIT, 9",
            "SOLDAT:SOLDAT:SOLDAT:SOLDAT:SOLDAT:SOLDAT:MAGE, 12",
            "HERO:HERO:CAPITAINE:SOLDAT:SOLDAT:SOLDAT:MAGE, 17",
            "HERO:HERO:CAPITAINE:SOLDAT:SOLDAT:MAUDIT:MAGE, 15",
            "HERO:CAPITAINE:CAPITAINE:CAPITAINE:MAUDIT:MAUDIT:MAGE, 13",
            "HERO:HERO:CAPITAINE:CAPITAINE:SOLDAT:TRAITRE:MAGE, 14",
            "HERO:HERO:CAPITAINE:TRAITRE:TRAITRE:TRAITRE:MAGE, 9",
            "HERO:HERO:CAPITAINE:CAPITAINE:TRAITRE:MAUDIT:MAGE, 12",
            "HERO:HERO:SOLDAT:SOLDAT:TRAITRE:MAGE:MAGE, 15",
            "SOLDAT:MAUDIT:MAUDIT:MAGE:MAGE:MAGE:MAGE, 11",
            "HERO:CAPITAINE:CAPITAINE:TRAITRE:MAGE:MAGE:MAGE, 16",
            "HERO:SOLDAT:TRAITRE:TRAITRE:MAGE:MAGE:MAGE, 14"
    })
    public void testSumGurriers(String guerriers,int sum){

        String[] spl = guerriers.split(":");

        int exceptSum = firstSolution.getSumValue(spl);
        assertEquals(exceptSum,sum);
    }

    public double getSolution(){
        return -1;
    }

    @ParameterizedTest
    @CsvSource({
            "HERO:HERO:HERO:CAPITAINE:SOLDAT:SOLDAT:SOLDAT, HERO:HERO:SOLDAT:, HERO:CAPITAINE:SOLDAT:SOLDAT:"
    })
    public void testSolution(String guerriers, String solutionArray1, String solutionArray2){
        String[] spl = guerriers.split(":");
        Solution solution = firstSolution.getSolution(spl);
        String[] firstArray = solution.getFirstArray();
        String[] secondArray = solution.getSecondArray();

        String firstSolution = "";
        for (int i=0;i<firstArray.length;i++){
            firstSolution = firstSolution + firstArray[i]+":";
        }
        String secondSolution = "";
        for (int i=0;i<secondArray.length;i++){
            secondSolution = secondSolution + secondArray[i]+":";
        }
        assertEquals(solutionArray2,firstSolution);
        assertEquals(solutionArray1,secondSolution);
    }

}

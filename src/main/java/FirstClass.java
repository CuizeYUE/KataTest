import java.util.ArrayList;

public class FirstClass {
//    public enum Guerrier{
//        HERO("HERO",3),
//        CAPITAINE("CAPITAINE",2),
//        SOLDAT("SOLDAT",1);
//
//        Guerrier(String name, int value){
//            this.name = name;
//            this.value = value;
//        }
//        private String name;
//        private int value;
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public int getValue() {
//            return value;
//        }
//
//        public void setValue(int value) {
//            this.value = value;
//        }
//    }

    public int getSumValue(String[] guerriers){
        int sumHero = 0;
        int sumTraitre = 0;
        int sumMage = 0;
        int sum = 0;
        for (int i=0; i<guerriers.length; i++){
            switch (guerriers[i]){
                case "HERO":
                    sumHero++;
                    sum+=3;
                    break;
                case "CAPITAINE":
                    sum+=2;
                    break;
                case "SOLDAT":
                    sum+=1;
                    break;
                case "TRAITRE":
                    sum+=1;
                    sumTraitre++;
                    break;
                case "MAUDIT":
                    sum-=1;
                    break;
                case "MAGE":
                    sumMage++;
                    break;
            }
        }
        sum = sumHero>sumTraitre?
                sum - sumTraitre*4:
                sum - sumHero*4;

        if(sumMage>0){
            sum = sum+(guerriers.length-sumMage)*sumMage;
        }
        return sum;
    }

    public Solution getSolution(String[] guerriers){
        Solution solution = new Solution();

        ArrayList<String> arrayList_a = new ArrayList<>();
        ArrayList<String> arrayList_b = new ArrayList<>();

        for(int i=0;i<guerriers.length;i++){
//arrayListToArray
           if(getSumValue(arrayList_a.toArray(new String[0])) < getSumValue(arrayList_b.toArray(new String[0]))){
                arrayList_a.add(guerriers[i]);
            }else{
                arrayList_b.add(guerriers[i]);
            }
        }
        solution.setFirstArray(arrayList_a.toArray(new String[0]));
        solution.setSecondArray(arrayList_b.toArray(new String[0]));
        return solution;
    }

}

import java.util.ArrayList;
import java.util.Arrays;

public class FirstClass {

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
                sum - sumTraitre*3:
                sum - sumHero*3;

        if(sumMage>0){
            sum = sum+(guerriers.length-sumMage)*sumMage;
        }
        return sum;
    }

    public Solution getSolution(String[] guerriers){
        ArrayList<String> arrayList_a = new ArrayList<>();
        ArrayList<String> arrayList_b = new ArrayList<>();
        ArrayList<String> guerrierList = new ArrayList<String>(Arrays.asList(guerriers));
        Solution solution = this.methodLazy(guerrierList, arrayList_a, arrayList_b);

        return solution;
    }

    public Solution methodLazy(ArrayList<String> guerrierList, ArrayList<String>arrayList_a, ArrayList<String>arrayList_b){
        Solution solution = new Solution();
        //lazy algorithm
        for(int i=0;i<guerrierList.size();i++){
            if(getSumValue(arrayList_a.toArray(new String[0])) < getSumValue(arrayList_b.toArray(new String[0]))){
                arrayList_a.add(guerrierList.get(i));
            }else{
                arrayList_b.add(guerrierList.get(i));
            }
        }
        solution.setFirstArray(arrayList_a.toArray(new String[0]));
        solution.setSecondArray(arrayList_b.toArray(new String[0]));
        if(!solution.ifSumEquels()){
            return this.findAllSolution(guerrierList);
        }
        return solution;
    }

    public Solution findAllSolution(ArrayList<String> gurrieurs){
        Solution solution = this.find1_6(gurrieurs);
        if(solution != null) {
            return solution;
        }
        solution = this.find2_5(gurrieurs);
        if(solution != null) {
            return solution;
        }
        solution = this.find3_4(gurrieurs);
        if(solution != null) {
            return solution;
        }

        return solution;
    }

    public Solution find1_6(ArrayList<String> gurriers){
        Solution solution = new Solution();
        for (int i = 0; i <7; i++) {
            ArrayList<String> arrayList_a = new ArrayList<>();
            ArrayList<String> gurriers_copy = new ArrayList<>(gurriers);
            arrayList_a.add(gurriers.get(i));
            gurriers_copy.remove(i);
            solution.setFirstArray(arrayList_a.toArray(new String[0]));
            solution.setSecondArray(gurriers_copy.toArray(new String[0]));
            if(solution.ifSumEquels()){
                return solution;
            }
        }
        return null;
    }

    public Solution find2_5(ArrayList<String> gurriers){
        Solution solution = new Solution();
        for(int i=0;i<7;i++){
            ArrayList<String> arrayList_a = new ArrayList<>();
            arrayList_a.add(gurriers.get(i));
            for(int j=0;j<6;j++){
                ArrayList<String> gurriers_copy = new ArrayList<>(gurriers);
                gurriers_copy.remove(i);
                arrayList_a.add(gurriers.get(j));
                gurriers_copy.remove(j);
                solution.setFirstArray(arrayList_a.toArray(new String[0]));
                solution.setSecondArray(gurriers_copy.toArray(new String[0]));
                if(solution.ifSumEquels()){
                    return solution;
                }
            }
        }
        return null;
    }

    public Solution find3_4(ArrayList<String> gurriers){
        Solution solution = new Solution();
        for(int i=0;i<7;i++){
            ArrayList<String> arrayList_a = new ArrayList<>();
            arrayList_a.add(gurriers.get(i));
            for(int j=0;j<6;j++){
                ArrayList<String> gurriers_copy = new ArrayList<>(gurriers);
                gurriers_copy.remove(i);
                arrayList_a.add(gurriers.get(j));
                    for(int k=0;k<5;k++){
                        ArrayList<String> gurriers_copy_2 = new ArrayList<>(gurriers_copy);
                        gurriers_copy_2.remove(j);
                        arrayList_a.add(gurriers_copy_2.get(k));
                        gurriers_copy_2.remove(k);
                        solution.setFirstArray(arrayList_a.toArray(new String[0]));
                        solution.setSecondArray(gurriers_copy_2.toArray(new String[0]));
                        if(solution.ifSumEquels()){
                            return solution;
                    }
                }
            }
        }
        return null;
    }
}

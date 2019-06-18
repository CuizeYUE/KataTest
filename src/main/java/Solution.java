public class Solution {
    private String[] firstArray;
    private String[] secondArray;
    private FirstClass firstClass;

    public Solution(){
        this.firstClass = new FirstClass();
    }

    public String[] getFirstArray() {
        return firstArray;
    }

    public void setFirstArray(String[] firstArray) {
        this.firstArray = firstArray;
    }

    public String[] getSecondArray() {
        return secondArray;
    }

    public void setSecondArray(String[] secondArray) {
        this.secondArray = secondArray;
    }

    public boolean ifSumEquels(){
        return (this.firstClass.getSumValue(firstArray) == this.firstClass.getSumValue(secondArray));
    }
}

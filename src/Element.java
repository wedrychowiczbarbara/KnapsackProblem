import java.util.Random;

public class Element {

    private int weight;
    private int value;

    public Element(int maxWeight, int maxValue){
        Random r=new Random();
        weight=r.nextInt(maxWeight)+1;
        value = r.nextInt(maxValue)+1;
    }

    public Element(){}

    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}

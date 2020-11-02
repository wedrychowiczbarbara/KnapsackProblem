import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Problem {

    List<Element> problem = new ArrayList<>();
    int problemTotalValue=0;
    int knapsackCapacity;

    public Problem(int problemSize, int knapsackCapacty, int maxElementWeight, int maxElementValue){
        this.knapsackCapacity = knapsackCapacty;
        Random r = new Random();
        for(int i=0; i<problemSize; i++){
            int newElementValue = r.nextInt(maxElementValue)+1;
            problem.add(new Element(r.nextInt(maxElementWeight)+1, newElementValue));
            problemTotalValue+=newElementValue;
        }
    }

    public void printProblem(){
        System.out.println("knapsack capacity: "+knapsackCapacity+"\ntotal value: "+problemTotalValue);
        System.out.print("weight:   ");
        for(int i=0; i<problem.size(); i++){
            System.out.print(problem.get(i).getWeight()+" ");
        }
        System.out.print("\nvalue:    ");
        for(int i=0; i<problem.size(); i++){
            System.out.print(problem.get(i).getValue()+" ");
        }
        System.out.println();
    }


    public int getProblemSize(){
        return problem.size();
    }
    public int getProblemTotalValue() {
        return problemTotalValue;
    }
    public int getKnapsackCapacity() {
        return knapsackCapacity;
    }
}

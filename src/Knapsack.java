import java.util.Random;

public class Knapsack implements Comparable<Knapsack>{
    private int knapsackWeight=0;
    private int knapsackValue=0;
    int[] knapsackElements;
    int knapsackFitness;
    private Problem problem;

    public Knapsack(Problem problem){
        this.problem=problem;
        Random r = new Random();
        knapsackElements=new int[problem.getProblemSize()];
        for(int i=0; i<problem.getProblemSize(); i++){
            int gene=r.nextInt(2);
            knapsackElements[i]=gene;
            knapsackWeight+=(problem.problem.get(i).getWeight()*gene);
            knapsackValue+=(problem.problem.get(i).getValue()*gene);
        }
        knapsackFitness=fitness();
    }

    public Knapsack(Problem problem, Knapsack parent1, Knapsack parent2){
        this.problem=problem;
        knapsackElements=new int[problem.getProblemSize()];
        int n=problem.getProblemSize()/2;
        for(int i=0; i<n; i++){
            knapsackElements[i]=parent1.knapsackElements[i];
            knapsackWeight+=(problem.problem.get(i).getWeight()*parent1.knapsackElements[i]);
            knapsackValue+=(problem.problem.get(i).getValue()*parent1.knapsackElements[i]);

            knapsackElements[i+n]=parent2.knapsackElements[i+n];
            knapsackWeight+=(problem.problem.get(i+n).getWeight()*parent2.knapsackElements[i+n]);
            knapsackValue+=(problem.problem.get(i+n).getValue()*parent2.knapsackElements[i+n]);
        }
        knapsackFitness=fitness();
    }


    private int fitness(){
        if(knapsackWeight<=problem.getKnapsackCapacity())
            return (int)((double)knapsackValue/problem.getProblemTotalValue()*100);
        else
            return 0;
    }

    public void printKanpsack(){
        System.out.print("\n"+"          ");
        for(int i=0; i<knapsackElements.length; i++){
            System.out.print(knapsackElements[i]+" ");
        }
        System.out.print("      w:"+knapsackWeight+", v:"+knapsackValue+", f:"+knapsackFitness);
    }
    private int getKnapsackLength(){
        return knapsackElements.length;
    }
    public void flipElement(int posioton){
        if(knapsackElements[posioton]==0) {
            knapsackElements[posioton] = 1;
            knapsackWeight+=problem.problem.get(posioton).getWeight();
            knapsackValue+=problem.problem.get(posioton).getValue();
        }else {
            knapsackElements[posioton] = 0;
            knapsackWeight-=problem.problem.get(posioton).getWeight();
            knapsackValue-=problem.problem.get(posioton).getValue();
        }

        knapsackFitness=fitness();
    }
    public int getKnapsackFitness() {
        return knapsackFitness;
    }


    @Override
    public int compareTo(Knapsack compare) {
        int comp=((Knapsack)compare).getKnapsackFitness();
        /* For Ascending order*/
        return comp-this.knapsackFitness;
    }



}

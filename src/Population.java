import java.util.*;

public class Population {
    int populationSize;
    int mutationProbability;
    int crossoverProbability;

    List<Knapsack> population = new ArrayList<>();

    private Problem problem;
    private int averagePopulationFitness;

    public Population(int populationSize, int mutationProbability, int crossoverProbability, Problem problem) {
        this.populationSize = populationSize;
        this.mutationProbability = mutationProbability;
        this.crossoverProbability = crossoverProbability;
        this.problem=problem;
        Knapsack k;
        for(int i=0; i<populationSize; i++){
            k=new Knapsack(problem);
            population.add(k);
            averagePopulationFitness+=k.knapsackFitness;
        }
    }


    public void printPopulation(){
        for(int i=0; i<populationSize; i++){
            population.get(i).printKanpsack();
        }
    }
    public void randomCrossover(){
        Random r = new Random();
        Knapsack parent1;
        Knapsack parent2;
        int number = (int) ((double)populationSize*crossoverProbability/100)/2;
//        System.out.print("\n\nRandom Crossover: ("+number+")");
        List<Knapsack> newPopulation = new ArrayList<>();
        for(int i=0; i<number; i++){
            parent1=population.get(r.nextInt(populationSize));
            parent2=population.get(r.nextInt(populationSize));
            Knapsack child1 = new Knapsack(problem, parent1, parent2);
            Knapsack child2 = new Knapsack(problem, parent2, parent1);
            newPopulation.add(parent1);
            newPopulation.add(parent2);
            newPopulation.add(child1);
            newPopulation.add(child2);
        }
        for(int i=populationSize-(number*2); i>0; i--){
            newPopulation.add(population.get(r.nextInt(populationSize)));
        }
        population=newPopulation;
    }

    public void bestCrossover(){
        sortPopulationByFitness();
        Random r = new Random();
        Knapsack parent1;
        Knapsack parent2;
        int number = (int) ((double)populationSize*crossoverProbability/100)/2;
//        System.out.print("\n\nRandom Crossover: ("+number+")");
        List<Knapsack> newPopulation = new ArrayList<>();
        for(int i=0; i<number; i++){
            parent1=population.get(r.nextInt(number));
            parent2=population.get(r.nextInt(number));
            Knapsack child1 = new Knapsack(problem, parent1, parent2);
            Knapsack child2 = new Knapsack(problem, parent2, parent1);
            newPopulation.add(parent1);
            newPopulation.add(parent2);
            newPopulation.add(child1);
            newPopulation.add(child2);
        }
        for(int i=populationSize-(number*2); i>0; i--){
            newPopulation.add(population.get(r.nextInt(populationSize)));
        }
        population=newPopulation;
    }


    public void sortPopulationByFitness(){
        Collections.sort(population);
    }

    public void flipMutation(){
        Random r = new Random();
        int number = (int) ((double)populationSize*mutationProbability/100);
        Knapsack k;
        for(int i=0; i<number; i++){
            int r1 =r.nextInt(populationSize);
            int r2 = r.nextInt(problem.getProblemSize());
            population.get(r1).flipElement(r2);
//            System.out.print("\n"+number+", mutated knapsack nr: "+r1+" in gene nr: "+r2);
        }

    }
    public int averagePopulationFitness(){
        for(int i=0 ; i<populationSize; i++){
            averagePopulationFitness+=population.get(i).knapsackFitness;
        }
        return averagePopulationFitness/=populationSize;
    }

}

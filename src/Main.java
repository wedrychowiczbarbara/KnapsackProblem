public class Main {

    static int problemSize = 20;
    static int populationSize = 10;
    static int numberOfPopulation = 100;
    static int knapsackCapacity=60;
    static int mutationProbability=10; //in %
    static int crossoverProbability=50; //in %
    static int maxElementWeight=7;
    static int maxElementValue=10;


    public static void main(String[] args) {
        Problem problem = new Problem(problemSize, knapsackCapacity, maxElementWeight, maxElementValue);
        problem.printProblem();

        Population population = new Population(populationSize, mutationProbability, crossoverProbability, problem);
        population.printPopulation();
        System.out.println();
        for(int i=0; i<numberOfPopulation; i++){
//            population.randomCrossover();
            population.bestCrossover();
//            population.printPopulation();
            population.flipMutation();
            System.out.println(population.averagePopulationFitness());

        }
    }
}

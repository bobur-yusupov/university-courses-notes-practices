package wildlifesimulation;

import wildlifesimulation.model.Animal;

public class Simulation {
    public static void main(String[] args) {
        Animal lion = new Animal("Lion");

        System.out.println(lion.getSpecies());
    }
    
}

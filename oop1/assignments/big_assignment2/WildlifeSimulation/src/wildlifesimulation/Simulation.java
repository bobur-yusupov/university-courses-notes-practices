package wildlifesimulation;

import wildlifesimulation.util.SimulationUtil;

public class Simulation {
    /**
     * The main method to run the wildlife simulation.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SimulationUtil.runFirstScenario();
        System.out.println("\n----------------------------------------");
        System.out.println("\n");
        SimulationUtil.runSecondScenario();
    }
}
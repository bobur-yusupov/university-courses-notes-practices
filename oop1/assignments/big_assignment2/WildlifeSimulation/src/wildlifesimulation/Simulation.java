package wildlifesimulation;

import wildlifesimulation.model.*;
import wildlifesimulation.model.person.*;
import wildlifesimulation.util.SimulationUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Simulation {
    static List<Animal> animalsList = new ArrayList<>();
    static List<Habitat> habitatsList = new ArrayList<>();
    static List<Vehicle> vehiclesList = new ArrayList<>();
    static List<Ranger> rangersList = new ArrayList<>();
    static List<Poacher> poachersList = new ArrayList<>();

    /**
     * Reads data from various files and populates the respective lists.
     */
    private static void readDataFromFiles() {
        readFile("src/wildlifesimulation/data/animals.txt", animalsList, parts -> 
            new Animal(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), TemperamentProfile.PASSIVE)
        );
        readFile("src/wildlifesimulation/data/habitats.txt", habitatsList, parts -> 
            new Habitat(parts[0], Integer.parseInt(parts[1]))
        );
        readFile("src/wildlifesimulation/data/vehicles.txt", vehiclesList, parts -> 
            new Vehicle(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]))
        );
        readFile("src/wildlifesimulation/data/rangers.txt", rangersList, parts -> 
            new Ranger(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]))
        );
        readFile("src/wildlifesimulation/data/poachers.txt", poachersList, parts -> 
            new Poacher(parts[0], Integer.parseInt(parts[1]))
        );
    }

    /**
     * Reads a file and maps its content to objects, adding them to the provided list.
     *
     * @param filePath The path of the file to read.
     * @param list The list to populate with mapped objects.
     * @param mapper A function to map file lines to objects.
     * @param <T> The type of objects to map.
     */
    private static <T> void readFile(String filePath, List<T> list, Function<String[], T> mapper) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            SimulationUtil.readLinesFromFile(reader, list, mapper);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        }
    }

    /**
     * Assigns animals to random habitats if the habitat has available capacity.
     */
    private static void assignAnimalsToHabitats() {
        if (habitatsList.isEmpty()) {
            System.out.println("No habitats available to assign animals.");
            return;
        }
        animalsList.forEach(animal -> {
            Habitat randomHabitat = SimulationUtil.getRandomElement(habitatsList, 0, habitatsList.size() - 1);
            if (SimulationUtil.isAvailableHabitat(randomHabitat)) {
                randomHabitat.addAnimal(animal);
            }
        });
    }

    /**
     * The main entry point of the simulation. Reads data, assigns animals to habitats,
     * and runs the simulation for 5 days.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        readDataFromFiles();
        assignAnimalsToHabitats();

        for (int day = 1; day <= 5; day++) {
            System.out.println("Day " + day);
            SimulationUtil.runDay(animalsList, habitatsList, vehiclesList, rangersList, poachersList);
        }
    }
}

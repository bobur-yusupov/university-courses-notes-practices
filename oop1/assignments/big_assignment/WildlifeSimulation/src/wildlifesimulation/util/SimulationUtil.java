package wildlifesimulation.util;

import wildlifesimulation.model.*;
import wildlifesimulation.model.person.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;

public class SimulationUtil {
    /**
     * Checks if a habitat has available capacity for more animals.
     *
     * @param habitat The habitat to check.
     * @return True if the habitat has available capacity, false otherwise.
     */
    public static boolean isAvailableHabitat(Habitat habitat) {
        return habitat.getAnimals().size() < habitat.getCapacity();
    }

    /**
     * Moves an animal from one habitat to another if the target habitat has capacity.
     *
     * @param animal The animal to move.
     * @param from The habitat to move the animal from.
     * @param to The habitat to move the animal to.
     * @throws UnavailableHabitatException If the target habitat is full.
     */
    public static void moveAnimal(Animal animal, Habitat from, Habitat to) throws UnavailableHabitatException {
        if (isAvailableHabitat(to)) {
            from.removeAnimal(animal);
            to.addAnimal(animal);
        } else {
            throw new UnavailableHabitatException("The habitat " + to.getName() + " is full.");
        }
    }

    /**
     * Reads lines from a file and maps them to objects, adding them to the provided list.
     *
     * @param reader The BufferedReader to read from.
     * @param listToWrite The list to populate with mapped objects.
     * @param mapper A function to map file lines to objects.
     * @param <E> The type of objects to map.
     */
    public static <E> void readLinesFromFile(BufferedReader reader, List<E> listToWrite, Function<String[], E> mapper) {
        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                listToWrite.add(mapper.apply(parts));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Retrieves a random element from a list within the specified range.
     *
     * @param list The list to retrieve the element from.
     * @param min The minimum index (inclusive).
     * @param max The maximum index (inclusive).
     * @param <T> The type of elements in the list.
     * @return A random element from the list, or null if the list is empty.
     */
    public static <T> T getRandomElememt(List<T> list, int min, int max) {
        return list.isEmpty() ? null : list.get(RandomUtil.getRandomInt(min, max));
    }

    /**
     * Retrieves a random element from a list, excluding a specified element.
     *
     * @param list The list to retrieve the element from.
     * @param exclude The element to exclude.
     * @param <T> The type of elements in the list.
     * @return A random element from the list, or null if the list has one or fewer elements.
     */
    public static <T> T getRandomElementExcept(List<T> list, T exclude) {
        if (list.size() <= 1) return null;
        List<T> filteredList = new ArrayList<>(list);
        filteredList.remove(exclude);
        return getRandomElememt(filteredList, 0, filteredList.size() - 1);
    }

    /**
     * Simulates a single day in the wildlife simulation, including animal movements,
     * poacher activities, and ranger patrols.
     *
     * @param animalsList The list of animals.
     * @param habitatsList The list of habitats.
     * @param vehiclesList The list of vehicles.
     * @param rangersList The list of rangers.
     * @param poachersList The list of poachers.
     */
    public static void runDay(
            List<Animal> animalsList,
            List<Habitat> habitatsList,
            List<Vehicle> vehiclesList,
            List<Ranger> rangersList,
            List<Poacher> poachersList) {
        Set<Animal> processedAnimals = new HashSet<>();
        moveAnimalsBetweenHabitats(animalsList, habitatsList);
        handlePoachers(poachersList, habitatsList);
        handleRangerActivities(rangersList, vehiclesList, habitatsList, poachersList, processedAnimals);
    }

    /**
     * Moves animals between habitats randomly, ensuring the target habitat has capacity.
     *
     * @param animalsList The list of animals to move.
     * @param habitatsList The list of habitats.
     */
    private static void moveAnimalsBetweenHabitats(List<Animal> animalsList, List<Habitat> habitatsList) {
        for (Animal animal : animalsList) {
            Habitat currentHabitat = habitatsList.stream()
                    .filter(habitat -> habitat.getAnimals().contains(animal))
                    .findFirst().orElse(null);

            if (currentHabitat != null) {
                Habitat newHabitat = getRandomElementExcept(habitatsList, currentHabitat);
                if (newHabitat != null && isAvailableHabitat(newHabitat)) {
                    try {
                        moveAnimal(animal, currentHabitat, newHabitat);
                    } catch (UnavailableHabitatException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    /**
     * Handles poacher activities, including invading habitats and removing defeated poachers.
     *
     * @param poachersList The list of poachers.
     * @param habitatsList The list of habitats.
     */
    private static void handlePoachers(List<Poacher> poachersList, List<Habitat> habitatsList) {
        List<Poacher> poachersToRemove = new ArrayList<>();
        for (Poacher poacher : poachersList) {
            if (poacher.isDefeated()) {
                poachersToRemove.add(poacher);
                continue;
            }
            Habitat target = getRandomElememt(habitatsList, 0, habitatsList.size() - 1);
            if (target != null) {
                poacher.invade(target);
            }
        }
        poachersList.removeAll(poachersToRemove);
    }

    /**
     * Handles ranger activities, including patrolling habitats, treating animals,
     * and fighting poachers.
     *
     * @param rangersList The list of rangers.
     * @param vehiclesList The list of vehicles.
     * @param habitatsList The list of habitats.
     * @param poachersList The list of poachers.
     * @param processedAnimals A set of animals already processed during the day.
     */
    private static void handleRangerActivities(
            List<Ranger> rangersList,
            List<Vehicle> vehiclesList,
            List<Habitat> habitatsList,
            List<Poacher> poachersList,
            Set<Animal> processedAnimals) {
        int vehiclesRefueled = 0, rangerPatrols = 0, poachersDefeated = 0;
        int totalHealth = 0, totalStress = 0, totalAnimals = 0, animalsNeedingHelp = 0, animalsTreated = 0;

        for (int i = 0; i < rangersList.size(); i++) {
            Ranger ranger = rangersList.get(i);
            Vehicle vehicle = vehiclesList.get(i % vehiclesList.size());

            if (vehicle.getFuelLevel() < 10) {
                vehicle.refuel(20);
                vehiclesRefueled++;
            }

            if (vehicle.deploy()) {
                Habitat patrolArea = getRandomElememt(habitatsList, 0, habitatsList.size() - 1);
                if (patrolArea != null) {
                    rangerPatrols++;
                    for (Animal animal : patrolArea.getAnimals()) {
                        if (processedAnimals.add(animal)) {
                            totalAnimals++;
                            totalHealth += animal.getHealth();
                            totalStress += animal.getStressLevel();
                            if (animal.needsHelp()) animalsNeedingHelp++;
                        }
                    }

                    int before = (int) poachersList.stream().filter(Poacher::isDefeated).count();
                    ranger.patrol(patrolArea, poachersList);
                    poachersList.removeIf(Poacher::isDefeated);
                    poachersDefeated += (int) poachersList.stream().filter(Poacher::isDefeated).count() - before;

                    for (Animal animal : patrolArea.getAnimals()) {
                        if (!animal.needsHelp()) animalsTreated++;
                    }
                }
            }
        }

        generateDailyReport(
                totalAnimals, totalHealth, totalStress,
                animalsNeedingHelp, animalsTreated,
                poachersDefeated, poachersList.size(),
                vehiclesRefueled, rangerPatrols
        );
    }

    /**
     * Generates a daily report summarizing the simulation's activities and statistics.
     *
     * @param totalAnimals The total number of animals.
     * @param totalHealth The total health of all animals.
     * @param totalStress The total stress level of all animals.
     * @param animalsNeedingHelp The number of animals needing help.
     * @param animalsTreated The number of animals treated.
     * @param poachersDefeated The number of poachers defeated.
     * @param totalPoachers The total number of active poachers.
     * @param vehiclesRefueled The number of vehicles refueled.
     * @param rangerPatrols The number of ranger patrols conducted.
     */
    private static void generateDailyReport(
            int totalAnimals, int totalHealth, int totalStress,
            int animalsNeedingHelp, int animalsTreated,
            int poachersDefeated, int totalPoachers,
            int vehiclesRefueled, int rangerPatrols) {
        double avgHealth = totalAnimals > 0 ? (double) totalHealth / totalAnimals : 0;
        double avgStress = totalAnimals > 0 ? (double) totalStress / totalAnimals : 0;

        System.out.println("\n=== DAILY REPORT ===");
        System.out.println("Total Animals: " + totalAnimals);
        System.out.printf("Average Health: %.2f, Average Stress: %.2f\n", avgHealth, avgStress);
        System.out.println("Animals needing help: " + animalsNeedingHelp);
        System.out.println("Animals treated today: " + animalsTreated);
        System.out.println("Active Poachers: " + totalPoachers);
        System.out.println("Poachers defeated: " + poachersDefeated);
        System.out.println("Ranger patrols: " + rangerPatrols);
        System.out.println("Vehicles refueled: " + vehiclesRefueled);
        System.out.println("=====================\n");
    }
}

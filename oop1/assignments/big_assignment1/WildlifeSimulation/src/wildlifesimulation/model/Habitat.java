package wildlifesimulation.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a habitat in the wildlife simulation.
 * A habitat has a name, a capacity, and a list of animals it can contain.
 */
public class Habitat {
    /**
     * The name of the habitat.
     */
    private final String name;

    /**
     * The maximum number of animals the habitat can hold.
     */
    private int capacity;

    /**
     * The list of animals currently in the habitat.
     */
    private List<Animal> animals = new ArrayList<>();

    public Habitat(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    /**
     * Adds an animal to the habitat if there is available capacity.
     *
     * @param animal The animal to add.
     * @return True if the animal was added, false otherwise.
     */
    public boolean addAnimal(Animal animal) {
        if (animals.size() < capacity) {
            animals.add(animal);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Removes an animal from the habitat.
     *
     * @param animal The animal to remove.
     * @return True if the animal was removed, false otherwise.
     */
    public boolean removeAnimal(Animal animal) {
        return animals.remove(animal);
    }
}

package wildlifesimulation.model;

import java.util.ArrayList;
import java.util.List;

public class Habitat {
    private final String name;
    private int capacity;
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

    public boolean addAnimal(Animal animal) {
        if (animals.size() < capacity) {
            animals.add(animal);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean removeAnimal(Animal animal) {
        return animals.remove(animal);
    }
}

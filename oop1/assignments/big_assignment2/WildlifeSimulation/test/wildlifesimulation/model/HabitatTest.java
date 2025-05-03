package wildlifesimulation.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class HabitatTest {
    
    public HabitatTest() {
    }

    @Test
    public void testAddAnimal() {
        Animal animal = new Animal("Lion", 5, 0, TemperamentProfile.PASSIVE);
        Habitat habitat = new Habitat("Savannah", 1000);

        habitat.addAnimal(animal);
        assertTrue(habitat.getAnimals().contains(animal));
    }

    @Test
    public void testRemoveAnimal() {
        Animal animal = new Animal("Lion", 5, 0, TemperamentProfile.PASSIVE);
        Habitat habitat = new Habitat("Savannah", 1000);

        habitat.addAnimal(animal);
        assertTrue(habitat.getAnimals().contains(animal));
        
        habitat.removeAnimal(animal);
        assertFalse(habitat.getAnimals().contains(animal));
    }
    
}

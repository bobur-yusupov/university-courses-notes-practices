package wildlifesimulation.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class HabitatTest {
    
    public HabitatTest() {
    }

    @Test
    public void testAddAnimal() {
        PassiveAnimal passive = new PassiveAnimal();
        Animal animal = new Animal("Lion", 5, 0, passive);
        Habitat habitat = new Habitat("Savannah", 1000);

        habitat.addAnimal(animal);
        assertTrue(habitat.getAnimals().contains(animal));
    }

    @Test
    public void testRemoveAnimal() {
        PassiveAnimal passive = new PassiveAnimal();
        Animal animal = new Animal("Lion", 5, 0, passive);
        Habitat habitat = new Habitat("Savannah", 1000);

        habitat.addAnimal(animal);
        assertTrue(habitat.getAnimals().contains(animal));
        
        habitat.removeAnimal(animal);
        assertFalse(habitat.getAnimals().contains(animal));
    }
    
}

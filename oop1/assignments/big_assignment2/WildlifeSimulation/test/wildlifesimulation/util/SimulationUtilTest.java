package wildlifesimulation.util;

import org.junit.Test;
import static org.junit.Assert.*;
import wildlifesimulation.model.*;

public class SimulationUtilTest {
    
    public SimulationUtilTest() {
    }

    @Test
    public void testIsAvailableHabitat() {
        Habitat habitat = new Habitat("Savanna", 1);
        Animal animal = new Animal("Lion", 100, 0, TemperamentProfile.PASSIVE);

        assertTrue(SimulationUtil.isAvailableHabitat(habitat));

        habitat.addAnimal(animal);
        assertFalse(SimulationUtil.isAvailableHabitat(habitat));
    }

    @Test
    public void testMoveAnimal() {
        Habitat habitat1 = new Habitat("Savanna", 1);
        Habitat habitat2 = new Habitat("Forest", 2);
        Animal animal = new Animal("Lion", 100, 0, TemperamentProfile.PASSIVE);

        habitat1.addAnimal(animal);
        assertTrue(habitat1.getAnimals().contains(animal));
        assertFalse(habitat2.getAnimals().contains(animal));

        SimulationUtil.moveAnimal(animal, habitat1, habitat2);

        assertFalse(habitat1.getAnimals().contains(animal));
        assertTrue(habitat2.getAnimals().contains(animal));
    }
    
}

package wildlifesimulation.model.person;

import org.junit.Test;
import static org.junit.Assert.*;
import wildlifesimulation.model.*;

public class PoacherTest {
    
    public PoacherTest() {
    }

    @Test
    public void testIsDefeated() {
        Poacher poacher = new Poacher("Elephant", 5);
        poacher.setDefeated(true);
        assertTrue(poacher.isDefeated());
    }

    @Test
    public void testInvade() {
        Habitat habitat = new Habitat("Savannah", 10);
        Animal animal = new Animal("Elephant", 10, 0, TemperamentProfile.PASSIVE);
        habitat.addAnimal(animal);

        Poacher poacher = new Poacher("Elephant", 5);
        poacher.invade(habitat);

        assertEquals(AnimalState.CRITICAL, animal.getState());
    }
}

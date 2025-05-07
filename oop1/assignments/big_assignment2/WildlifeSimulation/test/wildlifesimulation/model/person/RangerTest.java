package wildlifesimulation.model.person;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import wildlifesimulation.model.*;

public class RangerTest {
    
    public RangerTest() {
    }

    @Test
    public void testGetters() {
        Ranger ranger = new Ranger("Daniel", 5, 10);
        
        assertEquals("Daniel", ranger.getName());
        assertEquals(5, ranger.getExperience());
        assertEquals(10, ranger.getEfficiency());
    }
    
    @Test
    public void testTreatAnimal() {
        PassiveAnimal passive = new PassiveAnimal();
        Animal animal = new Animal("Elephant", 60, 3, passive);
        Ranger ranger = new Ranger("Daniel", 5, 10);
        
        ranger.treatAnimal(animal);
        assertEquals(70, animal.getHealth());
        assertEquals(0, animal.getStressLevel());
    }
    
    @Test
    public void testFightPoacher() {
        Poacher poacher = new Poacher("Elephant", 5);
        Ranger ranger = new Ranger("Daniel", 10, 10);

        if (ranger.getPower() > poacher.getPower()) {
            ranger.fightPoacher(poacher);
            assertTrue(poacher.isDefeated());
        } else {
            ranger.fightPoacher(poacher);
            assertFalse(poacher.isDefeated());
        }
    }

    @Test
    public void testPatrolHabitat() {
        Habitat habitat = new Habitat("Savannah", 10);
        PassiveAnimal passive = new PassiveAnimal();
        Animal animal = new Animal("Lion", 50, 2, passive);
        Poacher poacher = new Poacher("Elephant", 5);
        habitat.addAnimal(animal);
        poacher.setHabitat(habitat);

        Ranger ranger = new Ranger("Daniel", 5, 10);

        ranger.patrol(habitat, List.of(poacher));

        assertEquals(60, animal.getHealth());
        assertEquals(0, animal.getStressLevel());
        if (ranger.getPower() > poacher.getPower()) {
            assertTrue(poacher.isDefeated());
        } else {
            assertFalse(poacher.isDefeated());
        }
    }
    
    
}

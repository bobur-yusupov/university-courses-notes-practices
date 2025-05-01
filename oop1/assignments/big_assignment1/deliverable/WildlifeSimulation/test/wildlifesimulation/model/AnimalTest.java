package wildlifesimulation.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class AnimalTest {
    
    public AnimalTest() {
    }

    @Test
    public void testIncreaseStress() {
        Animal animal = new Animal("Elephant", 5, 0);

        animal.increaseStress(10);
        assertEquals(10, animal.getStressLevel());
    }

    @Test
    public void testDecreaseStress() {
        Animal animal = new Animal("Elephant", 5, 10);

        animal.decreaseStress(5);
        assertEquals(5, animal.getStressLevel());
    }

    @Test
    public void testHeal() {
        Animal animal = new Animal("Elephant", 5, 10);

        animal.heal(5);
        assertEquals(10, animal.getHealth());
    }

    @Test
    public void testHurtAnimal() {
        Animal animal = new Animal("Elephant", 100, 10);

        animal.hurtAnimal(5);
        assertEquals(95, animal.getHealth());
    }

    @Test
    public void testNeedsHelp() {
        Animal animal1 = new Animal("Elephant", 5, 10);
        Animal animal2 = new Animal("Lion", 100, 0);

        assertTrue(animal1.needsHelp());
        assertFalse(animal2.needsHelp());
    }
    
}

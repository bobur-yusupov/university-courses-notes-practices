package wildlifesimulation.model;

import org.junit.Test;
import static org.junit.Assert.*;
import wildlifesimulation.model.TemperamentProfile;
import wildlifesimulation.model.person.Ranger;

public class AnimalTest {
    
    public AnimalTest() {
    }

    @Test
    public void testIncreaseStress() {
        Animal animal = new Animal("Elephant", 5, 0, TemperamentProfile.PASSIVE);

        animal.increaseStress(10);
        assertEquals(10, animal.getStressLevel());
    }

    @Test
    public void testDecreaseStress() {
        Animal animal = new Animal("Elephant", 5, 10, TemperamentProfile.PASSIVE);

        animal.decreaseStress(5);
        assertEquals(5, animal.getStressLevel());
    }

    @Test
    public void testHeal() {
        Animal animal = new Animal("Elephant", 5, 10, TemperamentProfile.PASSIVE);

        animal.heal(5);
        assertEquals(10, animal.getHealth());
    }

    @Test
    public void testHurtAnimal() {
        Animal animal = new Animal("Elephant", 100, 10, TemperamentProfile.PASSIVE);

        animal.hurtAnimal(5);
        assertEquals(95, animal.getHealth());
    }

    @Test
    public void testNeedsHelp() {
        Animal animal1 = new Animal("Elephant", 5, 10, TemperamentProfile.PASSIVE);
        Animal animal2 = new Animal("Lion", 100, 0, TemperamentProfile.PASSIVE);

        assertTrue(animal1.needsHelp());
        assertFalse(animal2.needsHelp());
    }
    
    @Test
    public void testReactToRanger() {
        Animal animal = new Animal("Elephant", 5, 10, TemperamentProfile.PASSIVE);
        Ranger ranger = new Ranger("John", 5, 8);

        animal.reactToRanger(ranger);
        assertEquals(AnimalState.ALERTED, animal.getState());
    }
    
    @Test
    public void testStabilizeAnimal() {
        Animal animal = new Animal("Elephant", 5, 10, TemperamentProfile.PASSIVE);

        animal.injure();
        animal.stabilize(5, 20);
        
        assertEquals(AnimalState.STABILIZED, animal.getState());
    }
    
    @Test
    public void testApplyInjury() {
        Animal animal = new Animal("Elephant", 100, 0, TemperamentProfile.PASSIVE);

        animal.applyInjury();

        assertEquals(AnimalState.CRITICAL, animal.getState());
        assertEquals(80, animal.getHealth());
    }
    
    @Test
    public void testInjure() {
        Animal animal = new Animal("Elephant", 100, 0, TemperamentProfile.PASSIVE);

        animal.injure();

        assertEquals(AnimalState.CRITICAL, animal.getState());
        assertEquals(80, animal.getHealth());
    }
}

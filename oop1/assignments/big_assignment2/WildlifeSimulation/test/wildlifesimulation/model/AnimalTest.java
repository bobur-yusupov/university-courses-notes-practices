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
        PassiveAnimal passive = new PassiveAnimal();
        Animal animal = new Animal("Elephant", 5, 0, passive);

        animal.increaseStress(10);
        assertEquals(10, animal.getStressLevel());
    }

    @Test
    public void testDecreaseStress() {
        PassiveAnimal passive = new PassiveAnimal();
        Animal animal = new Animal("Elephant", 100, 10, passive);

        animal.decreaseStress(5);
        assertEquals(5, animal.getStressLevel());
    }

    @Test
    public void testHeal() {
        PassiveAnimal passive = new PassiveAnimal();
        Animal animal = new Animal("Elephant", 5, 0, passive);

        animal.heal(5);
        assertEquals(10, animal.getHealth());
    }

    @Test
    public void testHurtAnimal() {
        PassiveAnimal passive = new PassiveAnimal();
        Animal animal = new Animal("Elephant", 100, 0, passive);

        animal.hurtAnimal(5);
        assertEquals(95, animal.getHealth());
    }

    @Test
    public void testNeedsHelp() {
        PassiveAnimal passive = new PassiveAnimal();
        Animal animal1 = new Animal("Elephant", 5, 10, passive);
        Animal animal2 = new Animal("Lion", 100, 0, passive);

        assertTrue(animal1.needsHelp());
        assertFalse(animal2.needsHelp());
    }
    
    @Test
    public void testReactToRanger() {
        PassiveAnimal passive = new PassiveAnimal();
        Animal animal = new Animal("Elephant", 100, 0, passive);
        Ranger ranger = new Ranger("John", 5, 8);

        animal.reactToRanger(ranger);
        assertEquals(AnimalState.ALERTED, animal.getState());
    }
    
    @Test
    public void testStabilizeAnimal() {
        PassiveAnimal passive = new PassiveAnimal();
        Animal animal = new Animal("Elephant", 100, 0, passive);

        animal.injure();
        animal.stabilize(5, 20);
        
        assertEquals(AnimalState.STABILIZED, animal.getState());
    }
    
    @Test
    public void testApplyInjury() {
        PassiveAnimal passive = new PassiveAnimal();
        Animal animal = new Animal("Elephant", 100, 0, passive);

        animal.applyInjury();

        assertEquals(AnimalState.CRITICAL, animal.getState());
        assertEquals(80, animal.getHealth());
    }
    
    @Test
    public void testInjure() {
        PassiveAnimal passive = new PassiveAnimal();
        Animal animal = new Animal("Elephant", 100, 0, passive);

        animal.injure();

        assertEquals(AnimalState.CRITICAL, animal.getState());
        assertEquals(80, animal.getHealth());
    }
}

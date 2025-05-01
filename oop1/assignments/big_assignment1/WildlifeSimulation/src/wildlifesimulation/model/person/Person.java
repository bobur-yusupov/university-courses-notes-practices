package wildlifesimulation.model.person;

import wildlifesimulation.util.RandomUtil;

/**
 * Abstract class representing a person in the wildlife simulation.
 * This class serves as a base for different types of persons (e.g., Ranger, Poacher).
 */
public abstract class Person {
    protected int power;

    public Person() {
        this.power = RandomUtil.getRandomInt(1, 10);
    }

    public int getPower() {
        return power;
    }
}

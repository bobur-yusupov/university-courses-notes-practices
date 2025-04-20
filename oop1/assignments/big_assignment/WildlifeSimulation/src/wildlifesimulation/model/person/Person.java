package wildlifesimulation.model.person;

import wildlifesimulation.util.RandomUtil;

public abstract class Person {
    protected int power;

    /**
     * Constructs a Person with a random power level between 1 and 10.
     */
    public Person() {
        this.power = RandomUtil.getRandomInt(1, 10);
    }

    public int getPower() {
        return power;
    }
}

package wildlifesimulation.model.person;

import wildlifesimulation.util.RandomUtil;

public abstract class Person {
    protected int power;

    public Person() {
        this.power = RandomUtil.getRandomInt(1, 10);
    }

    public int getPower() {
        return power;
    }
}

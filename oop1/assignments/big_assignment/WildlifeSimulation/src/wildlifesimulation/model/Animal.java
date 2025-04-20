package wildlifesimulation.model;

public class Animal {
    private final String species;
    private int health;
    private int stressLevel;

    public Animal(String species, int health, int stressLevel) {
        this.species = species;
        this.health = health;
        this.stressLevel = stressLevel;
    }

    public String getSpecies() {
        return species;
    }

    public int getHealth() {
        return health;
    }

    public int getStressLevel() {
        return stressLevel;
    }

    /**
     * Increases the stress level of the animal by a specified amount.
     *
     * @param amount The amount to increase the stress level by.
     */
    public void increaseStress(int amount) {
        this.stressLevel += amount;

        if (this.stressLevel > 100) {
            this.stressLevel = 100;
        }
    }

    /**
     * Decreases the stress level of the animal by a specified amount.
     *
     * @param amount The amount to decrease the stress level by.
     */
    public void decreaseStress(int amount) {
        this.stressLevel -= amount;

        if (this.stressLevel < 0) {
            this.stressLevel = 0;
        }
    }

    /**
     * Heals the animal by a specified amount, increasing its health.
     *
     * @param amount The amount to heal the animal by.
     */
    public void heal(int amount) {
        this.health += amount;

        if (this.health > 100) {
            this.health = 100;
        }
    }

    /**
     * Hurts the animal by a specified amount, decreasing its health.
     *
     * @param amount The amount to hurt the animal
     * */

    public void hurtAnimal(int amount) {
        this.health -= amount;

        if (this.health < 0) {
            this.health = 0;
        }
    }

    /**
     * Checks if the animal needs help based on its health and stress level.
     *
     * @return true if the animal needs help, false otherwise.
     */
    public boolean needsHelp() {
        return this.health < 100 || this.stressLevel > 50;
    }
}

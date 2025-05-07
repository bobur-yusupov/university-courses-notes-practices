package wildlifesimulation.model;

import wildlifesimulation.model.person.Ranger;

/**
 * Represents an animal in the wildlife simulation.
 * Each animal has a species, health level, and stress level.
 */
public class Animal {
    /**
     * The species of the animal.
     */
    private final String species;

    /**
     * The health level of the animal, ranging from 0 to 100.
     */
    private int health;

    /**
     * The stress level of the animal, ranging from 0 to 10.
     */
    private int stressLevel;
    /**
     * The state of the animal, which can influence its behavior.
     */
    private AnimalState state;
    /**
     * The temperament profile of the animal, which can influence its behavior.
     */
    private Temperament temperament;

    public Animal(String species, int health, int stressLevel, Temperament temperament) {
        this.species = species;
        this.health = health;
        this.stressLevel = stressLevel;
        this.temperament = temperament;
        this.state = AnimalState.CALM;
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
        this.stressLevel = Math.min(10, this.stressLevel + amount);
    }

    /**
     * Decreases the stress level of the animal by a specified amount.
     *
     * @param amount The amount to decrease the stress level by.
     */
    public void decreaseStress(int amount) {
        this.stressLevel = Math.max(0, this.stressLevel - amount);
    }

    /**
     * Gets the current state of the animal.
     * @return The current state of the animal.
     */
    public AnimalState getState() {
        return state;
    }

    /**
     * Sets the state of the animal.
     * @param state The new state of the animal.
     */
    public void setState(AnimalState state) {
        this.state = state;
    }

    /**
     * Gets the temperament profile of the animal.
     * @return The temperament profile of the animal.
     */
    public AnimalState getTemperament() {
        return temperament.getAnimalState();
    }

    /**
     * Heals the animal by a specified amount, increasing its health.
     *
     * @param amount The amount to heal the animal by.
     */
    public void heal(int amount) {
        this.health = Math.min(100, this.health + amount);
    }

    /**
     * Hurts the animal by a specified amount, decreasing its health.
     *
     * @param amount The amount to hurt the animal
     * */

    public void hurtAnimal(int amount) {
        this.health = Math.max(0, this.health - amount);
    }

    /**
     * Checks if the animal needs help based on its health and stress level.
     *
     * @return true if the animal needs help, false otherwise.
     */
    public boolean needsHelp() {
        return this.health < 100 || this.stressLevel > 5;
    }

    /**
     * Injures the animal, changing its state to CRITICAL and reducing its health.
     */
    public void injure() {
        this.state = AnimalState.CRITICAL;
        this.hurtAnimal(20);
    }

    /**
     * Applies an injury to the animal, changing its state and increasing its stress level.
     */
    public void applyInjury() {
        if (this.state == AnimalState.FLEEING || this.state == AnimalState.ATTACKING) {
            this.state = AnimalState.CRITICAL;
            this.increaseStress(2);
        } else {
            this.state = AnimalState.ATTACKING;
        }
        injure();
    }

    /**
     * Reacts to a ranger based on the animal's temperament.
     *
     * @param ranger The ranger that is interacting with the animal.
     */
    public void reactToRanger(Ranger ranger) {
        this.state = this.temperament.getAnimalState();
    }

    /**
     * Stabilizes the animal by healing it and decreasing its stress level.
     *
     * @param efficiency The efficiency of the ranger treating the animal.
     * @param experience The experience of the ranger treating the animal.
     */
    public void stabilize(int efficiency, int experience) {
        if (this.state == AnimalState.CRITICAL || this.state == AnimalState.ATTACKING) {
            this.heal(experience);
            this.decreaseStress(efficiency);
            this.state = AnimalState.STABILIZED;
        }
    }


}

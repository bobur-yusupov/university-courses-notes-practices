package wildlifesimulation.model;

public class Animal {
    private final String species;
    private int health;
    private int stressLevel;

    public Animal(String species) {
        this.species = species;
        this.health = 100;
        this.stressLevel = 0;
    }

    public String getSpecies() {
        return species;
    }

    public void increaseStress(int amount) {
        this.stressLevel += amount;

        if (this.stressLevel > 100) {
            this.stressLevel = 100;
        }
    }

    public void decreaseStress(int amount) {
        this.stressLevel -= amount;

        if (this.stressLevel < 0) {
            this.stressLevel = 0;
        }
    }

    public void heal(int amount) {
        this.health += amount;

        if (this.health > 100) {
            this.health = 100;
        }
    }

    public void hurtAnimal(int amount) {
        this.health -= amount;

        if (this.health < 0) {
            this.health = 0;
        }
    }

    public boolean needsHelp() {
        return this.health < 100 || this.stressLevel > 50;
    }
}

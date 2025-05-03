/**
 * The `Ranger` class represents a ranger in the wildlife simulation.
 * A ranger is responsible for protecting animals, treating injured or stressed animals,
 * and fighting poachers to maintain the safety of habitats.
 *
 * This class extends the `Person` class and adds specific behavior
 * related to the ranger's duties.
 */

package wildlifesimulation.model.person;

import wildlifesimulation.model.Animal;
import wildlifesimulation.model.Habitat;

import java.util.List;

/**
 * Represents a ranger in the wildlife simulation.
 */
public class Ranger extends Person {
    private String name;
    private int experience;
    private int efficiency; // Efficiency range should be between 1 and 10
    private int stressLevel;
    private boolean isAvailable;

    /**
     * Constructs a new `Ranger` with the specified name, experience, and efficiency.
     *
     * @param name The name of the ranger.
     * @param experience The experience level of the ranger.
     * @param efficiency The efficiency level of the ranger, which determines
     *                   how effectively they can treat animals and fight poachers.
     */
    public Ranger(String name, int experience, int efficiency) {
        super();
        this.name = name;
        this.experience = experience;
        this.efficiency = efficiency;
        this.stressLevel = 0;
        isAvailable = true;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public int getStressLevel() {
        return stressLevel;
    }

    /**
     * Treats an animal by healing it and reducing its stress level.
     *
     * @param animal The animal to treat.
     */
    public void treatAnimal(Animal animal) {
        if (!isAvailable) {
            System.out.println("Ranger " + this.name + " is not available to treat the animal.");
            return;
        }

        boolean treatmentSuccessful = false;

        switch (animal.getState()) {
            case CALM:
                treatmentSuccessful = attemptToTreatAnimal(animal);
                break;

            case CURIOUS:
                treatmentSuccessful = attemptToTreatAnimal(animal);
                break;

            case DEFENSIVE:
                if (efficiency > 5) {
                    treatmentSuccessful = attemptToTreatAnimal(animal);
                } else {
                    System.out.println("Ranger " + this.name + " is not experienced enough to treat a defensive animal.");
                }
                break;

            case AGGRESSIVE:
                if (efficiency > 5) {
                    treatmentSuccessful = attemptToTreatAnimal(animal);
                } else {
                    System.out.println("Ranger " + this.name + " is not experienced enough to treat an aggressive animal.");
                }
                break;

            case FLEEING:
                if (efficiency > 7) {
                    treatmentSuccessful = attemptToTreatAnimal(animal);
                } else {
                    System.out.println("Ranger " + this.name + " is not experienced enough to treat a fleeing animal.");
                }
                break;

            case ATTACKING:
                if (efficiency > 8) {
                    treatmentSuccessful = attemptToTreatAnimal(animal);
                } else {
                    System.out.println("Ranger " + this.name + " is not experienced enough to treat an attacking animal.");
                }
                break;
        }

        if (treatmentSuccessful) {
            animal.stabilize(this.efficiency, this.experience);
            stressLevel = Math.max(stressLevel - 2, 0);
            animal.heal(efficiency);
            animal.decreaseStress(efficiency);
            System.out.println("Ranger " + this.name + " treated the animal successfully.");
        } else {
            this.stressLevel = Math.min(10, this.stressLevel + 1);
            System.out.println("Ranger " + this.name + " failed to treat the animal.");
        }
    }

    private boolean attemptToTreatAnimal(Animal animal) {
        return efficiency > 3;
    }

    /**
     * Fights a poacher, potentially defeating them based on the ranger's power.
     *
     * @param poacher The poacher to fight.
     */
    public void fightPoacher(Poacher poacher) {
        if (this.power > poacher.getPower()) {
            poacher.setDefeated(true);
        } else {
            poacher.setDefeated(false);
        }
    }

    /**
     * Patrols a habitat, treating animals in need and fighting poachers present in the habitat.
     *
     * @param habitat The habitat to patrol.
     * @param poachers The list of poachers to check for in the habitat.
     */
    public void patrol(Habitat habitat, List<Poacher> poachers) {
        if (habitat == null || poachers == null) return;
        for (Animal animal : habitat.getAnimals()) {
            if (animal.needsHelp()) {
                treatAnimal(animal);
            }
        }

        for (Poacher poacher : poachers) {
            if (poacher.getHabitat() == habitat) {
                fightPoacher(poacher);
            }
        }
    }

    /**
     * Increases the ranger's stress level of the ranger.
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
     * Decreases the ranger's stress level of the ranger.
     *
     * @param amount The amount to decrease the stress level by.
     */
    public void decreaseStress(int amount) {
        this.stressLevel -= amount;
        if (this.stressLevel < 0) {
            this.stressLevel = 0;
        }
    }

    public void retreat() {
        
    }
}


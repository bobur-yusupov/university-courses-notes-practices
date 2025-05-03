/**
 * The `Poacher` class represents a poacher in the wildlife simulation.
 * A poacher targets a specific species of animal and invades habitats,
 * increasing the stress level of all animals in the habitat and harming
 * the target species.
 *
 * This class extends the `Person` class and adds specific behavior
 * related to poaching activities.
 */

package wildlifesimulation.model.person;

import wildlifesimulation.model.Animal;
import wildlifesimulation.model.Habitat;

/**
 * Represents a poacher in the wildlife simulation.
 */
public class Poacher extends Person {
    private String target;
    private int dangerLevel;
    private Habitat habitat;
    private boolean defeated;

    /**
     * Constructs a new `Poacher` with the specified target species and danger level.
     *
     * @param target The species of animal the poacher is targeting.
     * @param dangerLevel The danger level of the poacher, which determines the
     *                    stress and harm caused to animals.
     */
    public Poacher(String target, int dangerLevel) {
        super();
        this.target = target;
        this.dangerLevel = dangerLevel;
    }

    public String getTarget() {
        return target;
    }

    public int getDangerLevel() {
        return dangerLevel;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public void setHabitat(Habitat habitat) {
        this.habitat = habitat;
    }

    public boolean isDefeated() {
        return defeated;
    }

    public void setDefeated(boolean defeated) {
        this.defeated = defeated;
    }

    /**
     * Invades the specified habitat and increases the stress level of all animals
     * in the habitat. If the target species is found, it will be hurt by the
     * poacher's danger level.
     *
     * @param habitat The habitat to invade.
     */
    public void invade(Habitat habitat) {
        this.habitat = habitat;

        for (Animal animal : habitat.getAnimals()) {
            animal.increaseStress(this.dangerLevel);

            if (animal.getSpecies().equalsIgnoreCase(target)) {
                animal.injure();
            }
        }
    }

    /**
     * Injures the specified animal, reducing its health.
     *
     * @param animal The animal to injure.
     */
    public void injureAnimal(Animal animal) {
        animal.injure();
    }
}

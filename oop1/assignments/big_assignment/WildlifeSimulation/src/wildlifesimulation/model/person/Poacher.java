package wildlifesimulation.model.person;

import wildlifesimulation.model.Animal;
import wildlifesimulation.model.Habitat;

public class Poacher extends Person {
    private String target;
    private int dangerLevel;
    private Habitat habitat;
    private boolean defeated;

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

    public void invade(Habitat habitat) {
        this.habitat = habitat;

        for (Animal animal : habitat.getAnimals()) {
            animal.increaseStress(this.dangerLevel);

            if (animal.getSpecies().equals(target)) {
                animal.hurtAnimal(dangerLevel);
            }
        }
    }
}

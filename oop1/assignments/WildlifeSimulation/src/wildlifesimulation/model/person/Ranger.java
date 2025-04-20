package wildlifesimulation.model.person;

import wildlifesimulation.model.Animal;
import wildlifesimulation.model.Habitat;

import java.util.List;

public class Ranger extends Person {
    private String name;
    private int experience;
    private int efficiency;

    public Ranger(String name, int experience, int efficiency) {
        super();
        this.name = name;
        this.experience = experience;
        this.efficiency = efficiency;
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

    /**
     * Treats an animal by healing it and reducing its stress level.
     *
     * @param animal The animal to treat.
     */
    public void treatAnimal(Animal animal) {
        animal.heal(efficiency);
        animal.decreaseStress(efficiency);
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
}


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

    public void treatAnimal(Animal animal) {
        animal.heal(efficiency);
        animal.decreaseStress(efficiency);
    }

    public void fightPoacher(Poacher poacher) {
        if (this.power > poacher.getPower()) {
            poacher.setDefeated(true);
        } else {
            poacher.setDefeated(false);
        }
    }

    public void Patrol(Habitat habitat, List<Poacher> poachers) {
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

package wildlifesimulation.util;

import wildlifesimulation.model.*;
import wildlifesimulation.model.person.*;

public class SimulationUtil {
    public static void runFirstScenario() {
        Ranger ranger = new Ranger("John Doe", 40, 8);
        Animal animal = new Animal("Lion", 80, 5, TemperamentProfile.AGGRESSIVE);
        Habitat habitat = new Habitat("Savannah", 20);
        habitat.addAnimal(animal);

        System.out.println("Scenario 1: Hostile Animal Encounter");
        System.out.println("Ranger " + ranger.getName() + " encounters a " + animal.getSpecies() + " with temperament " + animal.getTemperament());
        System.out.println("Ranger approaches the animal cautiously...");

        // Animal reacts aggressively to ranger's presence
        animal.reactToRanger(ranger);
        System.out.println("Animal's state after encounter: " + animal.getState());

        // Animal becomes hostile and bites the ranger
        System.out.println("Animal becomes hostile and bites the ranger!");
        animal.applyInjury();
        ranger.increaseStress(2); // Bite incident increases ranger's stress
        System.out.println("Animal state after injury: " + animal.getState());
        System.out.println("Animal health: " + animal.getHealth());

        // Ranger realizes it's too dangerous and retreats
        System.out.println("Ranger realizes it's too dangerous to continue and retreats.");
        ranger.retreat();

        // Ranger calls for help (e.g., backup, medical team)
        System.out.println("Ranger calls for help and reports the incident.");

        // Habitat is marked unsafe
        habitat.setSafe(false);
        System.out.println("Habitat '" + habitat.getName() + "' is marked as temporarily unsafe for intervention.");

        // Final status
        System.out.println("Final animal state: " + animal.getState());
        System.out.println("Final animal health: " + animal.getHealth());
        System.out.println("Final animal stress: " + animal.getStressLevel());
        System.out.println("Ranger stress level: " + ranger.getStressLevel());
        System.out.println("Ranger availability: " + ranger.isAvailable);
    }

    public static void runSecondScenario() {
        System.out.println("Scenario 2: Poacher Attack and Emergency Rescue");

        // Setup
        Habitat savannah = new Habitat("Savannah", 20);
        Animal zebra = new Animal("Zebra", 100, 3, TemperamentProfile.PASSIVE);
        savannah.addAnimal(zebra);

        // Poacher enters
        Poacher poacher = new Poacher("Zebra", 7);
        System.out.println("\nPoacher invades the habitat...");
        poacher.invade(savannah);

        System.out.println("Zebra's health after poacher attack: " + zebra.getHealth());
        System.out.println("Zebra's state: " + zebra.getState());

        // Ranger is dispatched in a med-equipped vehicle
        Ranger ranger = new Ranger("Jane Carter", 30, 9);
        Vehicle medVehicle = new Vehicle("Medical Jeep", 100, 5);
        medVehicle.addEquipment(Equipment.MEDICAL_KIT);

        System.out.println("\nRanger " + ranger.getName() + " rushes to the location with a medical unit...");

        if (medVehicle.hasEquipment(Equipment.MEDICAL_KIT)) {
            System.out.println("Medical vehicle is equipped. Ranger begins emergency treatment on site.");

            if (zebra.getState() == AnimalState.CRITICAL) {
                zebra.stabilize(ranger.getEfficiency(), ranger.getExperience());
                zebra.heal(ranger.getEfficiency());
                zebra.decreaseStress(ranger.getEfficiency());
                System.out.println("Ranger stabilized the Zebra on site.");
            }

            // Transport to rehabilitation zone
            Habitat rehabZone = new Habitat("Rehabilitation Zone", 20);
            System.out.println("Transporting animal to rehabilitation zone...");
            savannah.removeAnimal(zebra);
            rehabZone.addAnimal(zebra);

            System.out.println("Zebra is now safe in rehabilitation.");
        } else {
            System.out.println("No medical equipment available. Emergency rescue aborted.");
        }

        // Final state
        System.out.println("\n--- Final Status ---");
        System.out.println("Zebra Health: " + zebra.getHealth());
        System.out.println("Zebra State: " + zebra.getState());
        System.out.println("Zebra Stress Level: " + zebra.getStressLevel());
        System.out.println("Ranger Stress Level: " + ranger.getStressLevel());
    }
}

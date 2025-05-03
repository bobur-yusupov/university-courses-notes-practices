package wildlifesimulation.model;

import java.util.HashMap;

/**
 * Represents a vehicle in the wildlife simulation.
 * Each vehicle has an ID, a fuel level, and a capacity.
 */
public class Vehicle {
    /**
     * The unique identifier of the vehicle.
     */
    private final String id;

    /**
     * The current fuel level of the vehicle, ranging from 0 to 100.
     */
    private int fuelLevel;

    /**
     * The maximum capacity of the vehicle.
     */
    private final int capacity;

    /**
     * A map of equipment associated with the vehicle and their quantities.
     */
    private HashMap<Equipment, Integer> equipment;

    public Vehicle(String id, int fuelLevel, int capacity) {
        this.id = id;
        this.fuelLevel = fuelLevel;
        this.capacity = capacity;
        this.equipment = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public int getCapacity() {
        return capacity;
    }

    /**
     * Refuels the vehicle by a specified amount, up to a maximum of 100.
     *
     * @param amount The amount of fuel to add.
     */
    public void refuel(int amount) {
        this.fuelLevel += amount;

        if (this.fuelLevel > 100) {
            this.fuelLevel = 100;
        }
    }

    /**
     * Deploys the vehicle for use, reducing its fuel level by 10.
     *
     * @return True if the vehicle was successfully deployed, false otherwise.
     */
    public boolean deploy() {
        if (this.fuelLevel > 10) {
            this.fuelLevel -= 10;
            return true;
        }

        return false;
    }

    public HashMap<Equipment, Integer> getEquipment() {
        return equipment;
    }

    /**
     * Adds equipment to the vehicle.
     *
     * @param equipment The equipment to add.
     */
    public void addEquipment(Equipment equipment) {
        this.equipment.put(equipment, this.equipment.getOrDefault(equipment, 0) + 1);
    }

    /**
     * Removes equipment from the vehicle.
     *
     * @param equipment The equipment to remove.
     */
    public void removeEquipment(Equipment equipment) {
        if (this.equipment.containsKey(equipment)) {
            int quantity = this.equipment.get(equipment);
            if (quantity > 1) {
                this.equipment.put(equipment, quantity - 1);
            } else {
                this.equipment.remove(equipment);
            }
        }
    }

    /**
     * Checks if the vehicle has a specific type of equipment.
     *
     * @param equipment The equipment to check for.
     * @return True if the vehicle has the equipment, false otherwise.
     */
    public boolean hasEquipment(Equipment equipment) {
        return this.equipment.containsKey(equipment);
    }


}

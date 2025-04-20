package wildlifesimulation.model;

public class Vehicle {
    private final String id;
    private int fuelLevel;
    private final int capacity;

    public Vehicle(String id, int fuelLevel, int capacity) {
        this.id = id;
        this.fuelLevel = fuelLevel;
        this.capacity = capacity;
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
}

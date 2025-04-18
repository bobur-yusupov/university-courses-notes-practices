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

    public void refuel(int amount) {
        this.fuelLevel += amount;

        if (this.fuelLevel > 100) {
            this.fuelLevel = 100;
        }
    }

    public boolean deploy() {
        if (this.fuelLevel > 10) {
            this.fuelLevel -= 10;
            return true;
        }

        return false;
    }
}

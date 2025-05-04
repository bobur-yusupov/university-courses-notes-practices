package parking.facility;

import vehicle.*;

public class Space {
    private final int floorNumber; // The floor number of the parking space
    private final int spaceNumber; // The space number of the parking space
    private Car occupyingCar; // The car occupying this parking space

    // Constructor to initialize the parking space with its floor and space numbers
    public Space(int floorNumber, int spaceNumber) {
        this.floorNumber = floorNumber;
        this.spaceNumber = spaceNumber;
        this.occupyingCar = null; // Initially, the space is empty
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getSpaceNumber() {
        return spaceNumber;
    }

    // Method to check if the parking space is occupied by a car
    public boolean isTaken() {
        return occupyingCar != null; // Returns true if a car is occupying the space
    }

    // Method to assign a car to this parking space
    public void addOccupyingCar(Car c) {
        this.occupyingCar = c; // Assigns the reference of the given car to this space
    }

    // Method to remove the car from this parking space
    public void removeOccupyingCar() {
                this.occupyingCar = null; // Sets the occupying car reference to null
    }

    // Method to get the license plate of the car occupying this parking space
    public String getCarLicensePlate() {
        return (occupyingCar != null) ? occupyingCar.getLicensePlate() : null;
    }

    public Size getOccupyingCarSize() {
        return (occupyingCar != null) ? occupyingCar.getSpotOccupation() : null;
    }
}
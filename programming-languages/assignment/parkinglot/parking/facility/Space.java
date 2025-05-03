package parkinglot.parking.facility;

import parkinglot.vehicle.Car;
/**
 * The Space class enables the creation of a ParkingLot by serving as the structure that holds a reference to its assigned Car.

Operations
addOccupyingCar(): Assigns the reference of the given Car without creating a copy.
removeOccupyingCar(): Sets its Car reference to null, effectively removing the occupying car.
isTaken(): Checks whether a Car is already assigned, returns true if so.
Remember that in the case of a large Car, it will occupy two adjacent spaces by storing the same Car reference in both spaces.
 * 
 */

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
        return (occupyingCar != null) ? occupyingCar.getLicensePlate() : null; // Returns the license plate or null if no car is present
    }

    public Size getOccupyingCarSize() {
        return (occupyingCar != null) ? occupyingCar.getSize() : null; // Returns the size of the occupying car or null if no car is present
    }
}
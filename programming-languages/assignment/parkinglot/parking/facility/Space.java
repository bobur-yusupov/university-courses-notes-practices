package parking.facility;

import vehicle.*;

public class Space {
    private final int floorNumber;
    private final int spaceNumber;
    private Car occupyingCar;

    public Space(int floorNumber, int spaceNumber) {
        this.floorNumber = floorNumber;
        this.spaceNumber = spaceNumber;
        this.occupyingCar = null;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public int getSpaceNumber() {
        return spaceNumber;
    }

    public boolean isTaken() {
        return occupyingCar != null;
    }

    public void addOccupyingCar(Car c) {
        if (isTaken()) {
            System.out.println("Space is already occupied by " + occupyingCar.getLicensePlate());
        } else {
            this.occupyingCar = c;
            System.out.println("Car " + c.getLicensePlate() + " parked in space " + floorNumber + "-" + spaceNumber);
        }
    }

    public void removeOccupyingCar() {
        if (!isTaken()) {
            System.out.println("Space is already empty");
            return;
        }
        System.out.println("Car " + occupyingCar.getLicensePlate() + " left space " + floorNumber + "-" + spaceNumber);
        this.occupyingCar = null;
    }

    public String getCarLicensePlate() {
        if (occupyingCar != null) {
            return occupyingCar.getLicensePlate();
        } else {
            return null;
        }
    }

    public Size getOccupyingCarSize() {
        if (occupyingCar != null) {
            return occupyingCar.getSpotOccupation();
        } else {
            return null;
        }
    }
}
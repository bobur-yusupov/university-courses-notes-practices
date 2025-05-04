package parking.facility;

import java.util.ArrayList;
import java.util.List;

import vehicle.Size;
import vehicle.Car;
import parking.ParkingLot;

public class Gate {
    private final ArrayList<Car> cars;
    private final ParkingLot parkingLot;

    public Gate(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        this.cars = new ArrayList<>();
    }

    private Space findTakenSpaceByCar(Car car) {
        for (Space[] floor : parkingLot.getFloorPlan()) {
            for (Space space : floor) {
                if (space.isTaken() && space.getCarLicensePlate().equals(car.getLicensePlate())) {
                    return space;
                }
            }
        }
        return null;
    }

    private Space findAvailableSpaceOnFloor(int floor, Car car) {
        Space[] floorSpaces = parkingLot.getFloorPlan()[floor];
        for (int i = 0; i < floorSpaces.length; i++) {
            Space space = floorSpaces[i];
            if (!space.isTaken()) {
                if (car.getSpotOccupation() == Size.LARGE) {
                    if (i + 1 < floorSpaces.length && !floorSpaces[i + 1].isTaken()) {
                        return space;
                    }
                } else {
                    return space;
                }
            }
        }
        return null;
    }

    public Space findAnyAvailableSpaceForCar(Car car) {
        for (Space[] spaces : parkingLot.getFloorPlan()) {
            for (int i = 0; i < spaces.length; i++) {
                Space space = spaces[i];
                if (!space.isTaken()) {
                    if (car.getSpotOccupation() == Size.LARGE) {
                        if (i + 1 < spaces.length && !spaces[i + 1].isTaken()) {
                            return space;
                        }
                    } else {
                        return space;
                    }
                }
            }
        }
        return null;
    }

    public Space findPreferredAvailableSpaceForCar(Car car) {
        int preferredFloor = car.getPreferredFloor();
        int totalFloors = parkingLot.getFloorPlan().length;

        for (int offset = 0; offset < totalFloors; offset++) {
            int floor = (preferredFloor + offset) % totalFloors;
            Space space = findAvailableSpaceOnFloor(floor, car);
            if (space != null) return space;
        }
        return null;
    }

    public boolean registerCar(Car car) {
        Space space = findPreferredAvailableSpaceForCar(car);
        if (space == null) return false;
        if (space.isTaken()) return false;

        int floor = space.getFloorNumber();
        int spaceNumber = space.getSpaceNumber();
        space.addOccupyingCar(car);

        if (car.getSpotOccupation() == Size.LARGE) {
            Space nextSpace = parkingLot.getFloorPlan()[floor][spaceNumber + 1];
            nextSpace.addOccupyingCar(car);
        }

        car.setTicketId(floor + "-" + spaceNumber);
        cars.add(car);
        return true;
    }

    public void registerCars(Car... cars) {
        for (Car car : cars) {
            boolean success = registerCar(car);
            String plate = car.getLicensePlate();

            if (success) {
                System.out.println("Car registered: " + plate);
            } else {
                System.err.println("No available space for car: " + plate);
            }
        }
    }

    public void deRegisterCar(String ticketId) {
        String[] parts = ticketId.split("-");
        int floorNumber = Integer.parseInt(parts[0]);
        int spaceNumber = Integer.parseInt(parts[1]);

        Space space = parkingLot.getFloorPlan()[floorNumber][spaceNumber];
        if (!space.isTaken()) {
            System.err.println("No car found in the specified space.");
            return;
        }
        
        String licensePlate = space.getCarLicensePlate();
        if (space.getOccupyingCarSize() == Size.LARGE) {
            parkingLot.getFloorPlan()[floorNumber][spaceNumber].removeOccupyingCar();
            parkingLot.getFloorPlan()[floorNumber][spaceNumber + 1].removeOccupyingCar();
        } else {
            space.removeOccupyingCar();
        }

        cars.removeIf(car -> car.getLicensePlate().equals(licensePlate));
        System.out.println("Car " + licensePlate + " deregistered from space " + ticketId);
    }
}
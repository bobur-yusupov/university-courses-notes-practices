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
        for (Space[] spaces : parkingLot.getFloorPlan()) {
            for (Space space : spaces) {
                if (space.isTaken() && space.getCarLicensePlate().equals(car.getLicensePlate())) {
                    return space;
                }
            }
        }
        return null;
    }

    private Space findAvailableSpaceOnFloor(int floor, Car car) {
        for (int i = 0; i < parkingLot.getFloorPlan()[floor].length; i++) {
            Space space = parkingLot.getFloorPlan()[floor][i];
            if (!space.isTaken()) {
                if (car.getSpotOccupation() == Size.LARGE) {
                    if (i + 1 < parkingLot.getFloorPlan()[floor].length && !parkingLot.getFloorPlan()[floor][i + 1].isTaken()) {
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
            for (Space space : spaces) {
                if (!space.isTaken() && space.getOccupyingCarSize().equals(car.getSpotOccupation())) {
                    return space;
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
            if (space != null) {
                return space;
            }
        }
        return null;
    }

    public boolean registerCar(Car car) {
        Space space = findPreferredAvailableSpaceForCar(car);

        if (space != null) {
            space.addOccupyingCar(car);
            if (car.getSpotOccupation() == Size.LARGE) {
                parkingLot.getFloorPlan()[space.getFloorNumber()][space.getSpaceNumber() + 1].addOccupyingCar(car);
            }
            car.setTicketId(space.getFloorNumber() + "-" + space.getSpaceNumber());
            cars.add(car);
            return true;
        }
        return false;
    }

    public void registerCars(Car... cars) {
        for (Car car : cars) {
            if (!registerCar(car)) {
                System.err.println("No available space for car: " + car.getLicensePlate());
            } else {
                System.out.println("Car registered: " + car.getLicensePlate());
            }
        }
    }

    public void deRegisterCar(String ticketId) {
        String[] parts = ticketId.split("-");
        int floorNumber = Integer.parseInt(parts[0]);
        int spaceNumber = Integer.parseInt(parts[1]);

        Space space = parkingLot.getFloorPlan()[floorNumber][spaceNumber];
        if (space.isTaken() && space.getCarLicensePlate() != null) {
            String licensePlate = space.getCarLicensePlate();
            if (parkingLot.getFloorPlan()[floorNumber][spaceNumber].getOccupyingCarSize() == Size.LARGE) {
                parkingLot.getFloorPlan()[floorNumber][spaceNumber].removeOccupyingCar();
                parkingLot.getFloorPlan()[floorNumber][spaceNumber + 1].removeOccupyingCar();
            } else {
                parkingLot.getFloorPlan()[floorNumber][spaceNumber].removeOccupyingCar();
            }
            cars.removeIf(car -> car.getLicensePlate().equals(licensePlate));
            System.out.println("Car deregistered: " + licensePlate);
        } else {
            System.err.println("No car found in the specified space.");
        }
    }
}
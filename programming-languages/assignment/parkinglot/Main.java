import parking.facility.*;
import parking.ParkingLot;
import vehicle.*;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(3, 10); // 3 floors, 10 spaces per floor
        Gate gate = new Gate(parkingLot);

        // Example usage of the Gate class methods
        Car car1 = new Car("ABC123", Size.SMALL, 0);
        Car car2 = new Car("XYZ789", Size.LARGE, 1);
        Car car3 = new Car("LMN456", Size.LARGE, 2);
        Car car4 = new Car("DEF012", Size.LARGE, 0);

        gate.registerCar(car1); // Register car1
        gate.registerCar(car2); // Register car2
        
        System.out.println(parkingLot);
        gate.deRegisterCar(car2.getTicketId()); // Deregister car1

        gate.registerCar(car2); // Register car1 again
        gate.registerCar(car3); // Register car2 again
        gate.registerCar(car4); // Register car3 again

        System.out.println(parkingLot);
    }
}
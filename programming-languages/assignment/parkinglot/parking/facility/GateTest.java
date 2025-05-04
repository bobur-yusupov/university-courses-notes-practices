package parking.facility;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import vehicle.*;
import parking.ParkingLot;

public class GateTest {
    private ParkingLot parkingLot;
    private Gate gate;

    @BeforeEach
    public void init() {
        parkingLot = new ParkingLot(2, 2);
        gate = new Gate(parkingLot);
    }

    @Test
    public void testFindAnyAvailableSpaceForCar() {
        Car car = new Car("ABC123", Size.SMALL, 0);
        Space space = gate.findAnyAvailableSpaceForCar(car);
    
        assertNotNull(space, "Expected to find an available space for the car.");
    }

    @ParameterizedTest
    @CsvSource({
        "ABC123, SMALL, 0",
        "XYZ789, LARGE, 1",
    })
    public void testFindPreferredAvailableSpaceForCar(String plate, Size size, int preferredFloor) {
        Car car = new Car("ABC123", Size.SMALL, preferredFloor);
        Space space = gate.findPreferredAvailableSpaceForCar(car);
    
        assertNotNull(space, "Expected to find a preferred available space for the car.");
        assertEquals(preferredFloor, space.getFloorNumber(), "Expected the space to be on the preferred floor.");
    }

    @ParameterizedTest
    @CsvSource({
        "ABC123, SMALL, 0",
        "XYZ789, LARGE, 2"

    })
    public void testRegisterCar(String plate, Size size, int preferredFloor) {
        Car car = new Car(plate, size, preferredFloor);
        boolean result = gate.registerCar(car);
    
        assertTrue(result, "Expected registration result to match.");
    }

    @ParameterizedTest
    @CsvSource({
        "ABC123, SMALL, 0",
        "XYZ789, LARGE, 2"

    })
    public void testDeRegisterCar(String plate, Size size, int preferredFloor) {
        Car car = new Car(plate, size, preferredFloor);
        assertTrue(gate.registerCar(car));
        String ticketId = car.getTicketId();
        assertNotNull(ticketId, "Expected car to have a ticket ID after registration.");

        gate.deRegisterCar(car.getTicketId());
        
        String[] parts = ticketId.split("-");
        int floor = Integer.parseInt(parts[0]);
        int spaceNumber = Integer.parseInt(parts[1]);

        Space space = parkingLot.getFloorPlan()[floor][spaceNumber];
        Space nextSpace = parkingLot.getFloorPlan()[floor][spaceNumber + 1];
        assertFalse(space.isTaken(), "Expected space to be available after deregistration.");
        assertFalse(nextSpace.isTaken(), "Expected next space to be available after deregistration.");
    }
}
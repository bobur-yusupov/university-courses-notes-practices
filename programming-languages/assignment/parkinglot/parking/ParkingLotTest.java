package parking;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ParkingLotTest {
    @Test
    public void testConstructorWithInvalidValues() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new ParkingLot(0, 5);
        });
        assertEquals("Floor number and space number must at least 1.", exception.getMessage());

        exception = assertThrows(IllegalArgumentException.class, () -> {
            new ParkingLot(5, 0);
        });
        assertEquals("Floor number and space number must at least 1.", exception.getMessage());
    }

    @Test
    public void testTextualRepresentation() {
        ParkingLot parkingLot = new ParkingLot(2, 3);
        String expected = "X X X \nX X X \n";
        assertEquals(expected, parkingLot.toString());
    }
}
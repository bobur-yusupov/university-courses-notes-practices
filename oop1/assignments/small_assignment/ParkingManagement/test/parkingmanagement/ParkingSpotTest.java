/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package parkingmanagement;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the ParkingSpot class.
 *
 * @author Yusupov Boburjon
 */
public class ParkingSpotTest {
    
    private ParkingSpot spot1;
    
    @Before
    public void setUp() {
        spot1 = new ParkingSpot(ParkingSpotSize.STANDARD, 5);
    }
    
    @Test
    public void occupyTest() {
        spot1.occupy();
        assertFalse(spot1.getAvailability());
    }

    @Test
    public void vacateTest() {
        spot1.occupy();
        spot1.vacate();
        assertTrue(spot1.getAvailability());
    }
}

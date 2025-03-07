/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package parkingmanagement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Yusupov Boburjon
 */
public class ParkingSpotTest {
    
    public ParkingSpotTest() {
    }
       
    ParkingSpot spot1;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        spot1 = new ParkingSpot(ParkingSpotSize.MEDIUM, 5);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void getSizeTest() {
        assertEquals(ParkingSpotSize.MEDIUM, spot1.getSize());
    }

    @Test
    public void getHourlyRateTest() {
        assertEquals(5, spot1.getHourlyRate(), 0);
    }

    @Test
    public void getAvailabilityTest() {
        assertTrue(spot1.getAvailability());
    }

    @Test
    public void setSizeTest() {
        spot1.setSize(ParkingSpotSize.LARGE);
        assertEquals(ParkingSpotSize.LARGE, spot1.getSize());
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

    @Test
    public void setHourlyRateTest() {
        spot1.setHourlyRate(10);
        assertEquals(10, spot1.getHourlyRate(), 0);
    }

}

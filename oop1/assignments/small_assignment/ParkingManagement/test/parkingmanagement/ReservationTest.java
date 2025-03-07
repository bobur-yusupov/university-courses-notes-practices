/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package parkingmanagement;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Reservation class.
 *
 * @author Yusupov Boburjon
 */
public class ReservationTest {
    
    private ParkingSpot spot;
    private Reservation reservation;

    @Before
    public void setUp() {
        spot = new ParkingSpot(ParkingSpotSize.STANDARD, 5);
        reservation = new Reservation(2, spot);
    }

    @Test
    public void getRemainingHoursTest() {
        assertEquals(2, reservation.getRemainingPeriod());
    }

    @Test
    public void calculatePenaltyTest() {
        assertEquals(0, reservation.calculatePenalty(), 0);
    }

    @Test
    public void calculatePenaltyTest2() {
        reservation.setStartDate(new Date(System.currentTimeMillis() - 3 * 3600000));
        assertEquals(10, reservation.calculatePenalty(), 0);
    }

    @Test
    public void calculatePenaltyTest3() {
        reservation.setStartDate(new Date(System.currentTimeMillis() - 4 * 3600000));
        assertEquals(20, reservation.calculatePenalty(), 0);
    }

    @Test
    public void calculateCostTest() {
        assertEquals(10, reservation.calculateCost(), 0);
    }
}

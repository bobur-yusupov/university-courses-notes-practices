/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package parkingmanagement;

import java.util.Date;
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
public class ReservationTest {
    
    public ReservationTest() {
    }

    ParkingSpot spot;
    Reservation reservation;

    @Before
    public void setUp() {
        spot = new ParkingSpot(ParkingSpotSize.MEDIUM, 5);
        reservation = new Reservation(2, spot);
    }

    @Test
    public void getPeriodTest() {
        assertEquals(2, reservation.getPeriod());
    }

    @Test
    public void getStartDateTest() {
        assertNotNull(reservation.getStartDate());
    }

    @Test
    public void getSpotTest() {
        assertEquals(spot, reservation.getSpot());
    }

    @Test
    public void setPeriodTest() {
        reservation.setPeriod(3);
        assertEquals(3, reservation.getPeriod());
    }

    @Test
    public void setStartDateTest() {
        reservation.setStartDate(new Date());
        assertNotNull(reservation.getStartDate());
    }

    @Test
    public void setSpotTest() {
        ParkingSpot newSpot = new ParkingSpot(ParkingSpotSize.LARGE, 10);
        reservation.setSpot(newSpot);
        assertEquals(newSpot, reservation.getSpot());
    }

    @Test
    public void getRemainingHoursTest() {
        assertEquals(2, reservation.getRemainingHours());
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

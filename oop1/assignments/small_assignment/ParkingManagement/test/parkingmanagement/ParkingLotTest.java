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
public class ParkingLotTest {
    
    public ParkingLotTest() {
    }

    ParkingLot lot;
    ParkingSpot spot1;
    ParkingSpot spot2;
    ParkingSpot spot3;

    @Before
    public void setUp() {
        lot = new ParkingLot();
        spot1 = new ParkingSpot(ParkingSpotSize.COMPACT, 10);
        spot2 = new ParkingSpot(ParkingSpotSize.STANDARD, 15);
        spot3 = new ParkingSpot(ParkingSpotSize.LARGE, 20);
    }

    @Test
    public void registerSpotTest() {
        lot.registerSpot(spot1);
        lot.registerSpot(spot2);
        lot.registerSpot(spot3);

        assertEquals(3, lot.getAllAvailableSpots().size());
        assertEquals(spot1, lot.getAllAvailableSpots().get(0));
        assertEquals(spot2, lot.getAllAvailableSpots().get(1));
        assertEquals(spot3, lot.getAllAvailableSpots().get(2));
    }

    @Test
    public void filterParkingSpotTest() {
        lot.registerSpot(spot1);
        lot.registerSpot(spot2);
        lot.registerSpot(spot3);

        assertEquals(1, lot.filterParkingSpot(ParkingSpotSize.COMPACT, 10).size());
        assertEquals(spot1, lot.filterParkingSpot(ParkingSpotSize.COMPACT, 10).get(0));
    }

    @Test
    public void getAllAvailableSpotsTest() {
        lot.registerSpot(spot1);
        lot.registerSpot(spot2);
        lot.registerSpot(spot3);

        lot.parkCar(spot1, 2);

        assertEquals(2, lot.getAllAvailableSpots().size());
        assertEquals(spot2, lot.getAllAvailableSpots().get(0));
        assertEquals(spot3, lot.getAllAvailableSpots().get(1));
    }

    @Test
    public void getReservedSpotsTest() {
        lot.registerSpot(spot1);
        lot.registerSpot(spot2);
        lot.registerSpot(spot3);

        lot.parkCar(spot1, 2);
        lot.parkCar(spot2, 3);

        assertEquals(2, lot.getReservedSpots().size());
        assertEquals(spot1, lot.getReservedSpots().get(0));
        assertEquals(spot2, lot.getReservedSpots().get(1));
    }

    @Test
    public void getReservationsTest() {
        lot.registerSpot(spot1);
        lot.registerSpot(spot2);
        lot.registerSpot(spot3);

        lot.parkCar(spot1, 2);
        lot.parkCar(spot2, 3);

        assertEquals(2, lot.getReservations().size());
        assertEquals(spot1, lot.getReservations().get(0).getSpot());
        assertEquals(spot2, lot.getReservations().get(1).getSpot());
    }

    @Test
    public void parkCarTest() {
        lot.registerSpot(spot1);
        lot.registerSpot(spot2);
        lot.registerSpot(spot3);

        lot.parkCar(spot1, 2);
        lot.parkCar(spot2, 3);

        assertEquals(2, lot.getReservations().size());
        assertEquals(spot1, lot.getReservations().get(0).getSpot());
        assertEquals(spot2, lot.getReservations().get(1).getSpot());
    }

    @Test
    public void removeCarTest() {
        lot.registerSpot(spot1);
        lot.registerSpot(spot2);
        lot.registerSpot(spot3);

        lot.parkCar(spot1, 2);
        lot.parkCar(spot2, 3);

        assertEquals(2, lot.getReservations().size());
        assertEquals(spot1, lot.getReservations().get(0).getSpot());
        assertEquals(spot2, lot.getReservations().get(1).getSpot());

        double cost = lot.removeCar(lot.getReservations().get(0));

        assertEquals(20, cost, 0);
        assertEquals(1, lot.getReservations().size());
        assertEquals(spot2, lot.getReservations().get(0).getSpot());
    }

    @Test
    public void removeCarTest2() {
        lot.registerSpot(spot1);
        lot.registerSpot(spot2);
        lot.registerSpot(spot3);

        lot.parkCar(spot1, 2);
        lot.parkCar(spot2, 3);

        assertEquals(2, lot.getReservations().size());
        assertEquals(spot1, lot.getReservations().get(0).getSpot());
        assertEquals(spot2, lot.getReservations().get(1).getSpot());

        double cost = lot.removeCar(lot.getReservations().get(1));

        assertEquals(45, cost, 0);
        assertEquals(1, lot.getReservations().size());
        assertEquals(spot1, lot.getReservations().get(0).getSpot());
    }

}

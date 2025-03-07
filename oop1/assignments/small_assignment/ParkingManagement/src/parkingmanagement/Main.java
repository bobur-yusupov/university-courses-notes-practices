package parkingmanagement;

/**
 *
 * @author Yusupov Boburjon
 */
public class Main {
    // Implementation of Parking Lot Management System
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();

        ParkingSpot spot1 = new ParkingSpot(ParkingSpotSize.COMPACT, 10);
        ParkingSpot spot2 = new ParkingSpot(ParkingSpotSize.STANDARD, 15);
        ParkingSpot spot3 = new ParkingSpot(ParkingSpotSize.LARGE, 20);

        parkingLot.registerSpot(spot1);
        parkingLot.registerSpot(spot2);
        parkingLot.registerSpot(spot3);

        System.out.println("All available spots: ");
        parkingLot.getAllAvailableSpots().forEach(spot -> System.out.println(spot.getSize()));

        System.out.println("Filter spots by size and hourly rate: ");
        parkingLot.filterParkingSpot(ParkingSpotSize.COMPACT, 10).forEach(spot -> System.out.println(spot.getSize()));

        parkingLot.parkCar(spot1, 2);
        parkingLot.parkCar(spot2, 3);

        System.out.println("All reserved spots: ");
        parkingLot.getReservedSpots().forEach(spot -> System.out.println(spot.getSize()));

        System.out.println("All reservations: ");
        parkingLot.getReservations().forEach(reservation -> System.out.println(reservation.getSpot().getSize()));

        System.out.println("Remove car from spot 1");
        double cost = parkingLot.removeCar(parkingLot.getReservations().getFirst());

        System.out.println("Cost: " + cost);

        System.out.println("All available spots: ");
        parkingLot.getAllAvailableSpots().forEach(spot -> System.out.println(spot.getSize()));
    }
    
}

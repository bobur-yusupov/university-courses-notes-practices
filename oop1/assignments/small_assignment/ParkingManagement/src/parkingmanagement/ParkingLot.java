package parkingmanagement;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingSpot> spots;
    private List<Reservation> reservations;
    private double totalRevenue;

    public ParkingLot() {
        this.spots = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.totalRevenue = 0;
    }

    /**
     * Registers a parking spot to the parking lot. Adds new ParkingSpot object to the spots list
     * @param spot parking spot to be registered
     */
    public void registerSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    /**
     * Filters parking spots by size and hourly rate
     * @param size size of the parking spot
     * @param cost hourly rate of the parking spot
     * @return list of parking spots that match the criteria
     */
    public List<ParkingSpot> filterParkingSpot(ParkingSpotSize size, double cost) {

        return this.spots.stream()
                .filter(spot -> spot.getSize().equals(size) && spot.getHourlyRate() == cost)
                .toList();
    }

    /**
     * Returns all available parking spots
     * @return list of available parking spots
     */
    public List<ParkingSpot> getAllAvailableSpots() {
        return this.spots.stream()
                .filter(spot -> spot.getAvailability())
                .toList();
    }

    public List<ParkingSpot> getReservedSpots() {
        List<ParkingSpot> reservedSpots = new ArrayList<>();

        for (Reservation reservation : reservations) {
            reservedSpots.add(reservation.getSpot());
        }

        return reservedSpots;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Parks a car in the parking lot. Creates a new Reservation object and adds it to the reservations list
     * @param spot parking spot to park the car
     * @param period period of parking in hours
     */
    public void parkCar(ParkingSpot spot, int period) {
        if (!spot.getAvailability()) {
            System.out.println("Spot is not available");
            return;
        }

        Reservation reservation = new Reservation(period, spot);
        reservations.add(reservation);
    }

    /**
     * Removes a car from the parking lot. Removes the reservation from the reservations list and vacates the parking spot
     * @param reservation reservation to be removed
     * @return cost of the reservation
     */
    public double removeCar(Reservation reservation) {
        if (!reservations.contains(reservation)) {
            System.out.println("Reservation not found");
            return 0;
        }

        reservations.remove(reservation);
        reservation.getSpot().vacate();

        double cost = reservation.calculateCost();

        totalRevenue += cost;

        return cost;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }
}

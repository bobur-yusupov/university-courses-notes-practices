package parkingmanagement;

public class ParkingSpot {
    private int spotNumber;
    private ParkingSpotSize size;
    private double hourlyRate;
    private boolean availability;

    public ParkingSpot(ParkingSpotSize size, double hourlyRate) {
        this.size = size;
        this.hourlyRate = hourlyRate;
        this.availability = true;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public ParkingSpotSize getSize() {
        return size;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public void setSize(ParkingSpotSize newSize) {
        this.size = newSize;
    }

    /**
     * Occupies the parking spot
     * Changes isAvailable to false
     */
    public void occupy() {
        if (availability) {
            availability = false;
        }
    }

    /**
     * Vacates the parking spot
     * Changes isAvailable to true
     */
    public void vacate() {
        if (!availability) {
            availability = true;
        }
    }
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
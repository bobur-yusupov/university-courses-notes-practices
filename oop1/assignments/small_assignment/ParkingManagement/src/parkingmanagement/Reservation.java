package parkingmanagement;

import java.util.Date;

public class Reservation {
    private int period; // in hours
    private Date startDate;
    private ParkingSpot spot;

    public Reservation(int period, ParkingSpot spot) {
        this.period = period;
        this.startDate = new Date();
        this.spot = spot;

        spot.occupy();
    }

    public int getPeriod() {
        return period;
    }

    public Date getStartDate() {
        return startDate;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setSpot(ParkingSpot spot) {
        this.spot = spot;
    }

    /**
     * Returns the remaining hours of the reservation
     * @return remaining hours
     */
    public int getRemainingHours() {
        Date now = new Date();
        long diff = now.getTime() - startDate.getTime();
        return period - (int) (diff / 3600000);
    }

    /**
     * Returns the penalty amount if the reservation is not cancelled within the period
     * @return penalty amount
     */
    public double calculatePenalty() {
        Date now = new Date();
        long diff = now.getTime() - startDate.getTime();
        int hours = (int) (diff / 3600000);

        if (hours <= period) {
            return 0;
        }

        return (hours - period) * spot.getHourlyRate() * 2;
    }

    /**
     * Returns the cost of the reservation
     * @return cost of the reservation
     */
    public double calculateCost() {
        int periodInDays = period / 24;

        if (periodInDays > 10) {
            double discounted = (period - 10 * 24) * spot.getHourlyRate() * 0.5;
            return 10 * 24 * spot.getHourlyRate() + discounted;
        }

        return period * spot.getHourlyRate();
    }
}

import java.util.ArrayDeque;

public class ParcelLocker {
    private final int capacity;
    private final ArrayDeque<String> parcels = new ArrayDeque<>();

    public ParcelLocker(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("capacity must be at least 1: " + capacity);
        }
        this.capacity = capacity;
    }

    public synchronized void put(String parcel) throws InterruptedException {
        if (parcel == null) {
            throw new IllegalArgumentException("parcel must not be null");
        }
        while (parcels.size() == capacity) {
            wait();
        }
        parcels.addLast(parcel);
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        while (parcels.isEmpty()) {
            wait();
        }
        String parcel = parcels.removeFirst();
        notifyAll();
        return parcel;
    }

    public synchronized String poll(long timeoutMillis) throws InterruptedException {
        long millis = Math.min(Math.max(0, timeoutMillis), Long.MAX_VALUE / 4_000_000L);
        long deadline = System.nanoTime() + millis * 1_000_000L;
        while (parcels.isEmpty()) {
            long remainingNanos = deadline - System.nanoTime();
            if (remainingNanos <= 0) {
                return null;
            }
            wait((remainingNanos + 999_999) / 1_000_000);
        }
        String parcel = parcels.removeFirst();
        notifyAll();
        return parcel;
    }

    public synchronized int size() {
        return parcels.size();
    }
}

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TicketOffice {
    private final ConcurrentHashMap<String, AtomicInteger> remaining = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> reservations = new ConcurrentHashMap<>();

    public TicketOffice(Map<String, Integer> capacities) {
        if (capacities == null) {
            throw new IllegalArgumentException("capacities must not be null");
        }
        for (Map.Entry<String, Integer> entry : capacities.entrySet()) {
            String event = entry.getKey();
            Integer capacity = entry.getValue();
            if (event == null || capacity == null || capacity < 0) {
                throw new IllegalArgumentException("invalid capacity entry: " + event + " -> " + capacity);
            }
            remaining.put(event, new AtomicInteger(capacity));
        }
    }

    public boolean reserve(String event, String customer, int count) {
        AtomicInteger tickets = ticketsOf(event);
        if (customer == null) {
            throw new IllegalArgumentException("customer must not be null");
        }
        if (count <= 0) {
            throw new IllegalArgumentException("count must be positive: " + count);
        }

        while (true) {
            int current = tickets.get();
            if (current < count) {
                return false;
            }
            if (tickets.compareAndSet(current, current - count)) {
                break;
            }
        }

        reservations
                .computeIfAbsent(customer, c -> new ConcurrentHashMap<>())
                .merge(event, count, Integer::sum);
        return true;
    }

    public int remaining(String event) {
        return ticketsOf(event).get();
    }

    public int reservedBy(String customer, String event) {
        ticketsOf(event);
        if (customer == null) {
            throw new IllegalArgumentException("customer must not be null");
        }
        Map<String, Integer> byEvent = reservations.get(customer);
        if (byEvent == null) {
            return 0;
        }
        return byEvent.getOrDefault(event, 0);
    }

    private AtomicInteger ticketsOf(String event) {
        AtomicInteger tickets = event == null ? null : remaining.get(event);
        if (tickets == null) {
            throw new IllegalArgumentException("unknown event: " + event);
        }
        return tickets;
    }
}

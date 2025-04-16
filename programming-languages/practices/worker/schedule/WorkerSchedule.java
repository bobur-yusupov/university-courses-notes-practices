package worker.schedule;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class WorkerSchedule {
    private HashMap<Integer, HashSet<String>> weekToWorkers;

    public WorkerSchedule() {
        weekToWorkers = new HashMap<>();
    }

    public void add(int week, HashSet<String> workers) {
        HashSet set = weekToWorkers.getOrDefault(week, new HashSet<>());

        set.addAll(workers);

        weekToWorkers.put(week, set);
    }

    public void add(HashSet<Integer> weeks, ArrayList<String> workers) {
        for (int week : weeks) {
            HashSet<String> workerSet = new HashSet<>(workers);

            add(week, workerSet);
        }
    }

    public boolean isWorkingOnWeek(String worker, int week) {
        if (!weekToWorkers.containsKey(week)) {
            return false;
        }

        HashSet workers = weekToWorkers.get(week);

        return workers.contains(worker);
    }

    public HashSet<Integer> getWorkWeeks(String worker) {
        HashSet<Integer> weeks = new HashSet<>();

        for (Map.Entry<Integer, HashSet<String>> entry : weekToWorkers.entrySet()) {
            if (entry.getValue().contains(worker)) {
                weeks.add(entry.getKey());
            }
        }

        return weeks;
    }
}

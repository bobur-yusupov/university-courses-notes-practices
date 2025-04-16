package worker.schedule;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class WorkerScheduleTest {
    private static WorkerSchedule workerSchedule;

    @BeforeEach
    public void setUp() {
        workerSchedule = new WorkerSchedule();
    }

    @Test
    public void emptySchedule() {
        assertFalse(workerSchedule.isWorkingOnWeek("Xoji", 1));
    }

    @Test
    public void testAddWorkersSingleWeek() {
        HashSet<String> workers = new HashSet<>(new ArrayList<>(List.of("Bob", "John", "Michael")));
        workerSchedule.add(1, workers);

        assertTrue(workerSchedule.isWorkingOnWeek("Bob", 1));
        assertTrue(workerSchedule.isWorkingOnWeek("John", 1));
        assertTrue(workerSchedule.isWorkingOnWeek("Michael", 1));
    }

    @Test
    public void testAddWorkersMultipleWeeks() {
        ArrayList<String> workers = new ArrayList<>(List.of("Bob", "John", "Michael"));
        HashSet<Integer> weeks = new HashSet<>(new ArrayList<>(List.of(2, 3)));

        workerSchedule.add(weeks, workers);

        assertTrue(workerSchedule.isWorkingOnWeek("John", 2));
        assertTrue(workerSchedule.isWorkingOnWeek("Michael", 3));
        assertFalse(workerSchedule.isWorkingOnWeek("Bob", 1));
    }

    @Test
    public void testGetWorkWeeks() {
        HashSet<Integer> workWeeks = new HashSet<>(Set.of(1, 2));
        workerSchedule.add(workWeeks, new ArrayList<>(List.of("Bob", "John")));

        assertEquals(workWeeks, workerSchedule.getWorkWeeks("Bob"));
    }

    @ParameterizedTest
    @CsvSource({
        "Bob,2,true",
        "John,3,false",
    })
    public void isWorkingOnWeekParameterized(String worker, int week, boolean expected) {
        ArrayList<String> workers = new ArrayList<>(List.of("Bob", "John"));
        HashSet<Integer> weeks = new HashSet<>(new ArrayList<>(List.of(2)));

        workerSchedule.add(weeks, workers);

        assertEquals(expected, workerSchedule.isWorkingOnWeek(worker, week));
    }
}

package data.structure;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.*;

public class MultiSetTest {
    private MultiSet<Integer> multiSetInteger;
    private MultiSet<String> multiSetString;

    @BeforeEach
    public void setUp() {
        multiSetInteger = new MultiSet<>(1, 2, 3);
        multiSetString = new MultiSet<>("te", "st");

    }
    @Test
    public void testAddElement() {
        multiSetInteger.add(1);
        multiSetString.add("test");

        assertEquals(2, multiSetInteger.getCount(1));
        assertEquals(1, multiSetString.getCount("test"));
    }

    @Test
    public void testIntersection() {
        MultiSet<Integer> otherInteger = new MultiSet<>(2, 3, 4);

        MultiSet<Integer> result = multiSetInteger.intersect(otherInteger);

        assertEquals(0, result.getCount(1));
        assertEquals(1, result.getCount(2));
        assertEquals(1, result.getCount(3));
        assertEquals(0, result.getCount(4));
    }

    @Test
    public void testCountExcept() {
        for (int i = 0; i < 5; i++) {
            multiSetInteger.add(2);
        }

        int result = multiSetInteger.countExcept(Set.of(1));

        assertEquals(7, result);
    }
}

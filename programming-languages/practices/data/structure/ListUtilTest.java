package data.structure;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import data.structure.ListUtil;

public class ListUtilTest {
    @ParameterizedTest
    @CsvSource({
        "6, 1 2 3",
        "64, 1 2 4 8 16 32"
    })
    public void testDivisors(int number, String expectedNumbers) {
        List<Integer> expected;
        
        expected = Arrays.stream(expectedNumbers.split(" "))
                .map(Integer::parseInt)
                .toList();

        List<Integer> result = ListUtil.divisors(number);

        assertEquals(expected, result);
    }

    @Test
    public void testDivisorsZero() {
        List expected = List.of();

        assertEquals(expected, ListUtil.divisors(0));
    }

    @Test
    public void testDivisorsOne() {
        List expected = List.of();

        assertEquals(expected, ListUtil.divisors(0));
    }

    @Test
    public void testWithSameStartEnd() {
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();
        
        assertTrue(ListUtil.withSameStartEnd(words).isEmpty());

        words.add("");
        assertEquals(List.of(), ListUtil.withSameStartEnd(words));

        words.add(null);
        assertEquals(List.of(), ListUtil.withSameStartEnd(words));

        words.add(" ");
        assertEquals(List.of(" "), ListUtil.withSameStartEnd(words));
        
        words.add("x");
        assertEquals(List.of(" ", "x"), ListUtil.withSameStartEnd(words));

        words.add("");
        assertEquals(List.of(" ", "x"), ListUtil.withSameStartEnd(words));

        words.add("different start and end?");
        assertEquals(List.of(" ", "x"), ListUtil.withSameStartEnd(words));

        words.add("ends and starts the same");
        assertEquals(List.of(" ", "x", "ends and starts the same"), ListUtil.withSameStartEnd(words));
    }

    @Test
    public void testMoveToFront() {
        ArrayList<String> testWords;
        ArrayList<String> expected;

        testWords = new ArrayList<>(List.of("Test"));
        expected = new ArrayList<>(List.of("Test"));
        ListUtil.maxToFront(testWords);
        assertEquals(expected, testWords);

        testWords = new ArrayList<>(List.of("can", "you", "succeed"));
        expected = new ArrayList<>(List.of("you", "can", "succeed"));
        ListUtil.maxToFront(testWords);
        assertEquals(expected, testWords);

        testWords = new ArrayList<>(List.of("-123", "2000", "100"));
        expected = new ArrayList<>(List.of("2000", "-123", "100"));
        ListUtil.maxToFront(testWords);
        assertEquals(expected, testWords);
    }

}
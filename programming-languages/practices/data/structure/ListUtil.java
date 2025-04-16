package data.structure;

import java.util.ArrayList;
import java.util.Collections;

public class ListUtil {
    public static ArrayList divisors(int number) {
        if (number < 0) {
            return null;
        }

        ArrayList<Integer> divisors = new ArrayList<>();

        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                divisors.add(i);
            }
        }

        return divisors;
    }

    private static boolean isStartEndSameLetter(String word) {
        return word.charAt(0) == word.charAt(word.length() - 1);
    }

    public static ArrayList<String> withSameStartEnd(ArrayList<String> words) {
        ArrayList<String> filteredWords = new ArrayList<>();

        for (String word : words) {
            if (word != null && !word.isEmpty()) {
                if (isStartEndSameLetter(word)) {
                    filteredWords.add(word);
                }
            }
        }

        return filteredWords;
    }

    public static void maxToFront(ArrayList<String> words) {
        if (words == null || words.isEmpty()) {
            return;
        }

        String maximum = Collections.max(words);

        words.remove(maximum);
        words.add(0, maximum);
    }
}
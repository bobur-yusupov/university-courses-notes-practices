package data.structure;

import java.util.*;

public class MultiSet<E> {
    private HashMap<E, Integer> elemToCount = new HashMap<>();

    @SafeVarargs
    public MultiSet(E... elements) {
        for (E e : elements) {
            add(e);
        }
    }

    public int add(E element) {
        int key = elemToCount.getOrDefault(element, 0) + 1;
        elemToCount.put(element, key);
        return key;
    }

    public int getCount(E element) {
        int key = elemToCount.getOrDefault(element, 0);

        return key;
    }

    public MultiSet<E> intersect(MultiSet<E> other) {
        MultiSet<E> result = new MultiSet<>();

        for (E e : this.elemToCount.keySet()) {
            if (other.elemToCount.containsKey(e)) {
                int minCount = Math.min(this.getCount(e), other.getCount(e));
                for (int i = 0; i < minCount; i++) {
                    result.add(e);
                }
            }
        }

        return result;
    }

    public int countExcept(Set<E> elements) {
        int sum = 0;

        for (Map.Entry<E, Integer> entry : elemToCount.entrySet()) {
            if (!elements.contains(entry.getKey())) {
                sum += entry.getValue();
            }
        }

        return sum;
    }

    public int size() {
        return 0;
    }
}

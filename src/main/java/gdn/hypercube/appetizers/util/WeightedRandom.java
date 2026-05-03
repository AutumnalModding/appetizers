package gdn.hypercube.appetizers.util;

import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

public class WeightedRandom<T> {
    private final NavigableMap<Double, T> map = new TreeMap<>();
    private final Random random = new Random();
    private double total = 0;

    public void add(T item, double weight) {
        map.put(total, item);
        total += weight;
    }

    public T next() {
        double roll = random.nextDouble() * total;
        return map.floorEntry(roll).getValue();
    }
}
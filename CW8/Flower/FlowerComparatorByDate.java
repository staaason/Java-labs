package Flower;

import java.util.Comparator;

public class FlowerComparatorByDate implements Comparator<Flower> {
    @Override
    public int compare(Flower o1, Flower o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}

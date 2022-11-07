package Vagon;

import java.util.Comparator;

public class ComparatorByComfort implements Comparator<Vagon> {
    @Override
    public int compare(Vagon o1, Vagon o2) {
        Comparator<Vagon> comparator = Comparator.comparingDouble(Vagon::getComfort);
        return comparator.compare(o1, o2);
    }
}

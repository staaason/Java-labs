package Vagon;

import java.util.Objects;

public class LuggageVagon extends Vagon{
    private int capacity;
    public LuggageVagon(double comfort, String type, int capacity) {
        super(comfort, type);
        setType("Luggage");
        setComfort(0);
        this.capacity = capacity;
    }


    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LuggageVagon)) return false;
        if (!super.equals(o)) return false;
        LuggageVagon that = (LuggageVagon) o;
        return getCapacity() == that.getCapacity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCapacity());
    }

    @Override
    public String toString() {
        return "LuggageVagon{" +
                "capacity=" + capacity +
                '}';
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
}

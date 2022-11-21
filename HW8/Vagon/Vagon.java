package Vagon;

import java.util.Objects;

public abstract class Vagon {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;
    public Vagon(double comfort, String type) {
        this.comfort = comfort;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vagon)) return false;
        Vagon vagon = (Vagon) o;
        return getComfort() == vagon.getComfort();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getComfort());
    }

    @Override
    public String toString() {
        return "Vagon{" +
                "number=" + comfort +
                '}';
    }

    public abstract int   getCapacity();

    public double getComfort() {
        return comfort;
    }

    public void setComfort(int comfort) {
        this.comfort = comfort;
    }

    private double comfort;



}

package Tree;

import java.util.Objects;

public class Leaf {
    Boolean isLeaf;
    Boolean coveredWithFrost;
    Boolean bloomed;

    public Leaf() {
        this.isLeaf = true;
        this.bloomed = false;
        this.coveredWithFrost = false;
    }

    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Boolean getCoveredWithFrost() {
        return coveredWithFrost;
    }

    public void setCoveredWithFrost(Boolean coveredWithFrost) {
        this.coveredWithFrost = coveredWithFrost;
    }

    public Boolean getBloomed() {
        return bloomed;
    }

    public void setBloomed(Boolean bloomed) {
        this.bloomed = bloomed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Leaf)) return false;
        Leaf leaf = (Leaf) o;
        return getIsLeaf().equals(leaf.getIsLeaf()) && getCoveredWithFrost().equals(leaf.getCoveredWithFrost()) && getBloomed().equals(leaf.getBloomed());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsLeaf(), getCoveredWithFrost(), getBloomed());
    }

    @Override
    public String toString() {
        return "Leaf{" +
                "isPresent=" + isLeaf +
                ", coveredWithFrost=" + coveredWithFrost +
                ", bloomed=" + bloomed +
                '}';
    }
}

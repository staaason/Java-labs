package Tree;

import java.util.List;
import java.util.Objects;

public class Branch {
    Boolean coveredWithFrost;
    List<Leaf> leaves;

    @Override
    public String toString() {
        return "Branch{" +
                "coveredWithFrost=" + coveredWithFrost +
                ", leaves=" + leaves +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Branch)) return false;
        Branch branch = (Branch) o;
        return getCoveredWithFrost().equals(branch.getCoveredWithFrost()) && getLeaves().equals(branch.getLeaves());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoveredWithFrost(), getLeaves());
    }

    public Boolean getCoveredWithFrost() {
        return coveredWithFrost;
    }

    public void setCoveredWithFrost(Boolean coveredWithFrost) {
        for (Leaf leaf:leaves) {
            leaf.setCoveredWithFrost(true);
        }
        this.coveredWithFrost = coveredWithFrost;
    }

    public List<Leaf> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<Leaf> leaves) {
        this.leaves = leaves;
    }

    public Branch(List<Leaf> leaves) {
        this.coveredWithFrost = false;
        this.leaves = leaves;
    }
}

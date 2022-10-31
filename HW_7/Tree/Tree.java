package Tree;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Tree {
    List<Branch> branches;


    public Tree(List<Branch> branches) {
        this.branches = branches;
    }

    public void bloom(){
        for (Branch branch : branches) {
            Stream<Leaf> stream = branch.leaves.stream();
            stream.forEach(leaf -> {leaf.setBloomed(true);
                leaf.setIsLeaf(true);
            });
        }
    }

    public void coverWithFrost(){
        for (Branch branch : branches) {
            branch.setCoveredWithFrost(true);
        }
    }

    public void defoliation(){
        for (Branch branch : branches) {
            Stream<Leaf> stream = branch.leaves.stream();
            stream.forEach(leaf -> {leaf.setIsLeaf(false);
                leaf.setCoveredWithFrost(false);
                leaf.setBloomed(false);
            });
        }
    }

    public void turnYellow(){
        for (Branch branch : branches) {
            Stream<Leaf> stream = branch.leaves.stream();
            stream.forEach(leaf -> {leaf.setBloomed(true);
                leaf.setCoveredWithFrost(false);
            });
        }
    }


    @Override
    public String toString() {
        return "Tree{" +
                "branches=" + branches +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tree)) return false;
        Tree tree = (Tree) o;
        return Objects.equals(branches, tree.branches);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branches);
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }
}

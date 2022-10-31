import Tree.Branch;
import Tree.Leaf;
import Tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class l7_5_17 {
    public static void main(String[] args){
        Leaf leaf1 = new Leaf();
        Leaf leaf2 = new Leaf();
        Leaf leaf3 = new Leaf();
        Leaf leaf4 = new Leaf();
        List<Leaf> leaves1 = new ArrayList<>(){{
            add(leaf1);
            add(leaf2);
        }};
        List<Leaf> leaves2 = new ArrayList<>(){{
            add(leaf3);
            add(leaf4);
        }};
        Branch branch1 = new Branch(leaves1);
        Branch branch2 = new Branch(leaves2);
        List<Branch> branches = new ArrayList<>(){
            {
            add(branch1);
            add(branch2);
            }
        };
        Tree tree = new Tree(branches);
        tree.bloom();
        System.out.println(tree);
        tree.coverWithFrost();
        System.out.println(tree);
        tree.turnYellow();
        System.out.println(tree);
        tree.defoliation();
        System.out.println(tree);


    }
}

import java.io.*;
import java.util.*;

public class Solution {
    
    public static final class Tree {
        private int ordinal;
        Boolean even;
        private List<Tree> children;
        
        public Tree(int ordinal) {
            this.ordinal = ordinal;
            children = new ArrayList<>();
        }
        
        public Tree(int ordinal, Tree child) {
            this.ordinal = ordinal;
            children = new ArrayList<>();
            children.add(child);
        }
        
        public Tree addEdge(int childOrd, int parentOrd) {
            //System.out.println("Adding " + childOrd + " to " + parentOrd);
            Tree newRoot = null;
            if (parentOrd == ordinal) {
                //System.out.println("Adding " + childOrd + " to " + children);
                children.add(new Tree(childOrd));
            } else if (childOrd == ordinal) {
                //System.out.println("Adding a newRoot with ordinal " + parentOrd + " and child " + ordinal);
                //newRoot = new Tree(parentOrd, this);
            } else {
                for (Tree child: children) {
                    child.addEdge(childOrd, parentOrd);
                    if (child.ordinal == parentOrd) {
                        break;
                    }
                }
            }
            return newRoot;
        }
        
        public boolean isEven() {
            if (even == null) {
                even = false;
                for (Tree child: children) {
                    even = !(even ^ child.isEven());
                }
            }
            //System.out.println(ordinal + " is " + (even? "even": "odd"));
            return even;
        }
        
        public int resolve() {
            int removed = 0;
            //System.out.println("Resolving " + children);
            List<Tree> toRemove = new ArrayList<>();
            for (Tree child: children) {
                //System.out.println("Resolving child " + child.ordinal + " of ordinal " + ordinal);
                removed += child.resolve();
                //System.out.println("Child " + child.ordinal + " removed " + removed);
                boolean childEven = child.isEven();
                if (childEven) {
                    //System.out.println("Removing even child " + child.ordinal);
                    toRemove.add(child);
                    removed++;
                }
            }
            for (Tree remove: toRemove) {
                children.remove(remove);
            }
            return removed;
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int nodes = in.nextInt();
        int edges = in.nextInt();
        
        Tree root = null;
        for (int edge = 0; edge < edges; edge++) {
            int child = in.nextInt();
            int parent = in.nextInt();
            //System.out.println("child = " + child + ", parent = " + parent);
            if (root == null) {
                root = new Tree(parent, new Tree(child));
            } else {
                Tree newRoot = root.addEdge(child, parent);
                if (newRoot != null) {
                    root = newRoot;
                }
            }
        }
        
        System.out.println(root.resolve());
    }
}

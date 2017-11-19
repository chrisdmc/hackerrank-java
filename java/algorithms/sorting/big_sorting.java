import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static final class Tree {
        String value;
        int count;
        Tree left, right;
        
        public Tree (String value) {
            this.value = value;
            count = 1;
        }
        
        public void add(String value) {
            if (this.value.equals(value)) {
                count++;
            } else {
                if (value.length() < this.value.length()) {
                    addLeft(value);
                } else if (value.length() > this.value.length()) {
                    addRight(value);
                } else {
                    for (int i = 0; i < value.length(); i++) {
                        if ((int) value.charAt(i) < (int)this.value.charAt(i)) {
                            addLeft(value);
                            break;
                        } else if ((int) value.charAt(i) > (int)this.value.charAt(i)) {
                            addRight(value);
                            break;
                        }
                    }
                }
            }
        }
        
        private void addLeft(String value) {
            if (left == null) {
                left = new Tree(value);
            } else {
                left.add(value);
            }
        }
        
        private void addRight(String value) {
            if (right == null) {
                right = new Tree(value);
            } else {
                right.add(value);
            }
        }
        
        public void setLeft(Tree left) {
            this.left = left;
        }
        
        public void setRight(Tree right) {
            this.right = right;
        }
        
        public void traverse() {
            if (left != null) {
                left.traverse();
            }
            for (int i = 0; i < count; i++) {
                System.out.println(value);
            }
            if (right != null) {
                right.traverse();
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Tree root = new Tree(in.next());
        for(int unsorted_i=1; unsorted_i < n; unsorted_i++){
            root.add(in.next());
        }
        // your code goes here
        root.traverse();
    }
    
    
}


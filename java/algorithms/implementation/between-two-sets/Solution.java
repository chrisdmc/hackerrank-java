import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int getTotalX(int[] a, int[] b) {
        // Complete this function
        int max_a = 0;
        int min_a = Integer.MAX_VALUE;
        for (int a_i: a) {
            if (a_i > max_a) {
                max_a = a_i;
            }
            if (a_i < min_a) {
                min_a = a_i;
            }
        }
        int min_b = Integer.MAX_VALUE;
        for (int b_i: b) {
            if (b_i < min_b) {
                min_b = b_i;
            }
        }
        
        int totalx = 0;
        for (int x_i = max_a; x_i <= min_b; x_i += min_a) {
            boolean inx = true;
            for (int a_i: a) {
                if (x_i % a_i != 0) {
                    inx = false;
                    break;
                }
            }
            if (inx) {
                for (int b_i: b) {
                    if (b_i % x_i != 0) {
                        inx = false;
                        break;
                    }
                }
            }
            if (inx) totalx++;
        }
        return totalx;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i = 0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }
}


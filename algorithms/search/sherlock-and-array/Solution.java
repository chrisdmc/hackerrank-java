import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String solve(int[] a){
        int i = 0;
        int j = a.length-1;
        int sumLeft = a[i];
        int sumRight = a[j];
        while (j - i > 2) {
            if (sumRight > sumLeft) {
                sumLeft += a[++i];
            } else {
                sumRight += a[--j];
            }
        }
        if (sumLeft == sumRight) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            String result = solve(a);
            System.out.println(result);
        }
    }
}


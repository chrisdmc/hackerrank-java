import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] icecreamParlor(int m, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < m) {
                int change = m - arr[i];
                for (int j = i+1; j < arr.length; j++) {
                    if (arr[j] == change) {
                        return new int[] {i+1, j+1};
                    }
                }
            }
        }
        throw new RuntimeException("Could not find a pair");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int[] result = icecreamParlor(m, arr);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
            }
            System.out.println("");


        }
        in.close();
    }
}


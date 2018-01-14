import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static List<Integer> closestNumbers(int[] arr) {
        List<Integer> output = new ArrayList<>();
        Arrays.sort(arr);
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            int distance = Math.abs(arr[i+1]-arr[i]);
            if (distance < minDistance) {
                minDistance = distance;
                output.clear();
            }
            if (distance <= minDistance) {
                output.add(arr[i]);
                output.add(arr[i+1]);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        List<Integer> result = closestNumbers(arr);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + (i != result.size() - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}


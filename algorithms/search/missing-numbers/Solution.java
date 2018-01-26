import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] missingNumbers(int[] arr, int[] brr) {        
        SortedMap<Integer, Integer> aNums = new TreeMap<Integer, Integer>();
        SortedMap<Integer, Integer> bNums = new TreeMap<Integer, Integer>();
        int[] missing = new int[100];
        
        for (int a: arr) {
            Integer count = aNums.get(a);
            if (count == null) {
                count = 0;
            }
            aNums.put(a, count+1);
        }
        
        for (int b: brr) {
            Integer count = bNums.get(b);
            if (count == null) {
                count = 0;
            }
            bNums.put(b, count+1);
        }
        
        int numMissing = 0;
        for (Map.Entry<Integer, Integer> entry: bNums.entrySet()) {
            if (!aNums.get(entry.getKey()).equals(entry.getValue())) {
                missing[numMissing++] = entry.getKey();
            }
        }
        
        int[] returnVal = new int[numMissing];
        System.arraycopy(missing, 0, returnVal, 0, numMissing);
        Arrays.sort(returnVal);
        return returnVal;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] brr = new int[m];
        for(int brr_i = 0; brr_i < m; brr_i++){
            brr[brr_i] = in.nextInt();
        }
        int[] result = missingNumbers(arr, brr);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


        in.close();
    }
}


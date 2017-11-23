import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] getRecord(int[] s){
        int currentHigh = s[0];
        int currentLow = s[0];
        int timesBeatHigh = 0, timesBeatLow = 0;
        for (int s_i: s) {
            if (s_i > currentHigh) {
                timesBeatHigh++;
                currentHigh = s_i;
            } else if (s_i < currentLow) {
                timesBeatLow++;
                currentLow = s_i;
            }
        }
        return new int[] {timesBeatHigh, timesBeatLow};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
        int[] result = getRecord(s);
        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println("");
    }
}


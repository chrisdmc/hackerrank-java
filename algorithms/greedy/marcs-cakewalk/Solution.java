import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long marcsCakewalk(int[] calorie) {
        long miles = 0L;
        Arrays.sort(calorie);
        for (int i = calorie.length-1; i >= 0; i--) {
            miles += calorie[i] * Math.pow(2, calorie.length-i-1);
        }
        return miles;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] calorie = new int[n];
        for(int calorie_i = 0; calorie_i < n; calorie_i++){
            calorie[calorie_i] = in.nextInt();
        }
        long result = marcsCakewalk(calorie);
        System.out.println(result);
        in.close();
    }
}


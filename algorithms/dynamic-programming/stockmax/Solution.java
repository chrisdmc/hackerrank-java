import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static long stockmax(int[] prices) {
        Map<Integer, Integer> maxPriceSeenByDay = new HashMap<>();
        int maxPrice = 0;
        for (int i = prices.length-1; i >= 0; i--) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
            }
            maxPriceSeenByDay.put(i, maxPrice);
        }
        
        long stockOwned = 0;
        long profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < maxPriceSeenByDay.get(i)) {
                profit -= prices[i];
                stockOwned++;
            } else if (prices[i] == maxPriceSeenByDay.get(i)) {
                profit += prices[i]*stockOwned;
                stockOwned = 0;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] prices = new int[n];
            for(int prices_i = 0; prices_i < n; prices_i++){
                prices[prices_i] = in.nextInt();
            }
            long result = stockmax(prices);
            System.out.println(result);
        }
        in.close();
    }
}


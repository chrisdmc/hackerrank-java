import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int maximumToys(int[] prices, int k) {
        int totalSpend = 0, numToys = 0;
        int[] spent = new int[prices.length];
        for (int price: prices) {
            if (price <= k) {
                if (k - totalSpend >= price) {
                    spent[spent.length - numToys - 1] = price;
                    numToys++;
                    totalSpend += price;
                    Arrays.sort(spent);
                } else if (spent[spent.length-1] > price) {
                    totalSpend -= spent[spent.length-1] - price;
                    spent[spent.length-1] = price;
                    Arrays.sort(spent);
                }
            }
        }
        return numToys;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] prices = new int[n];
        for(int prices_i = 0; prices_i < n; prices_i++){
            prices[prices_i] = in.nextInt();
        }
        int result = maximumToys(prices, k);
        System.out.println(result);
        in.close();
    }
}


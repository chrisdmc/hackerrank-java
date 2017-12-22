import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
        }
        
        int p = ar[0];
        int pCount = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (ar[i] < p) {
                System.out.print(ar[i] + " ");
            } else if (ar[i] == p) {
                pCount++;
            } else {
                sb.append(ar[i]).append(" ");
            }
        }
        for (int i = 1; i <= pCount; i++) {
            sb.insert(0, " ").insert(0, p);
        }
        System.out.println(sb.toString().trim());
    }
}

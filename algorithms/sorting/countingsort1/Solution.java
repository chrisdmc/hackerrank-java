import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        int[] counts = new int[100];
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            counts[scanner.nextInt()]++;
        }
        for (int count: counts) {
            System.out.printf("%d ", count);
        }
    }
}

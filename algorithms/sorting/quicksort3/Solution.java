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
        
        quickSort(ar, 0, ar.length);
    }
    
    private static void quickSort(int[] ar, int start, int end) {
        if (end-start > 1) {
            int pivot = ar[end-1];
            int firstAvailable = start;
            for (int i = start; i < end-1; i++) {
                if (ar[i] < pivot) {
                    swap(ar, i, firstAvailable++);
                }
            }
            
            swap(ar, firstAvailable, end-1);
            
            printArray(ar);
            
            quickSort(ar, start, firstAvailable);
            quickSort(ar, firstAvailable+1, end);
        }
    }
    
    private static void swap(int[] ar, int src, int dst) {
        if (src != dst) {
            int tmp = ar[dst];
            ar[dst] = ar[src];
            ar[src] = tmp;
        }
    }
    
    private static void printArray(int[] ar) {
        boolean first = true;
        for (int i: ar) {
            if (first) {
                first = false;
            } else {
                System.out.print(" ");
            }
            System.out.print(String.valueOf(i));
        }
        System.out.println();
    }
}

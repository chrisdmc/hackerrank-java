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
        
        quickSort(ar);
    }
    
    private static void quickSort(int[] ar) {
        if (ar.length > 1) {
            int pivot = ar[0];
            int[] left = new int[ar.length-1];
            int leftHead = 0;
            int[] right = new int[ar.length-1];
            int rightHead = 0;
            for (int i = 1; i < ar.length; i++) {
                if (ar[i] < pivot) {
                    left[leftHead++] = ar[i];
                } else {
                    right[rightHead++] = ar[i];
                }
            }
            left = Arrays.copyOf(left, leftHead);
            right = Arrays.copyOf(right, rightHead);
            quickSort(left);
            quickSort(right);
            System.arraycopy(left, 0, ar, 0, left.length);
            ar[left.length] = pivot;
            System.arraycopy(right, 0, ar, left.length+1, right.length);
            printArray(ar);
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

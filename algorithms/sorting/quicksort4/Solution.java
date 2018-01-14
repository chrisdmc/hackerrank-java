import java.io.*;
import java.util.*;

public class Solution {

    public static int insertionSortPart2(int[] ar)
    {   
        int shifts = 0;
        for (int i = 1; i < ar.length; i++) {
            shifts += insertionSort(ar[i], i, ar);
        }
        return shifts;
    }  
    
    private static int insertionSort(int e, int start, int[] ar) {
        int shifts = 0;
        for (int i = start-1; i >= 0; i--) {
            if (ar[i] > e) {
                ar[i+1] = ar[i];
                shifts++;
                if (i == 0) {
                    ar[i] = e;
                }
            } else {
                ar[i+1] = e;
                break;
            }
        }
        return shifts;
    }
    
    private static int quickSort(int[] ar, int start, int end) {
        int swaps = 0;
        if (end-start > 1) {
            int pivot = ar[end-1];
            int firstAvailable = start;
            for (int i = start; i < end-1; i++) {
                if (ar[i] < pivot) {
                    swap(ar, i, firstAvailable++);
                    swaps++;
                }
            }
            
            swap(ar, firstAvailable, end-1);
            swaps++;
            
            swaps += quickSort(ar, start, firstAvailable);
            swaps += quickSort(ar, firstAvailable+1, end);
        }
        return swaps;
    }
    
    private static void swap(int[] ar, int src, int dst) {
        if (src != dst) {
            int tmp = ar[dst];
            ar[dst] = ar[src];
            ar[src] = tmp;
        }
    }
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
        }
        int insertShifts = insertionSortPart2(Arrays.copyOf(ar, s));
        int quickShifts = quickSort(Arrays.copyOf(ar, s), 0, s);
        System.out.println(String.valueOf(insertShifts-quickShifts));
    }
    
}

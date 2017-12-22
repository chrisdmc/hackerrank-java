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
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       int shifts = insertionSortPart2(ar);
       System.out.println(shifts);
                    
    }
}

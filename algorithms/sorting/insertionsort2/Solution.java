import java.io.*;
import java.util.*;

public class Solution {

    public static void insertionSortPart2(int[] ar)
    {       
        for (int i = 1; i < ar.length; i++) {
            insertionSort(ar[i], i, ar);
            printArray(ar);
        }
    }  
    
    private static void insertionSort(int e, int start, int[] ar) {
        for (int i = start-1; i >= 0; i--) {
            if (ar[i] > e) {
                ar[i+1] = ar[i];
                if (i == 0) {
                    ar[i] = e;
                }
            } else {
                ar[i+1] = e;
                break;
            }
        }
    }
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       insertionSortPart2(ar);    
                    
    }    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
}


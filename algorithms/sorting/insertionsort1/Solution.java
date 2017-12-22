import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static String toString(int[] ar) {
        StringBuilder sb = new StringBuilder();
        for (int e: ar) {
            sb.append(e).append(" ");
        }
        return sb.toString().trim();
    }

    public static void insertIntoSorted(int[] ar) {
        int e = ar[ar.length-1];
        for (int i = ar.length-2; i >= 0; i--) {
            if (ar[i] > e) {
                ar[i+1] = ar[i];
                System.out.println(toString(ar));
                if (i == 0) {
                    ar[i] = e;
                    System.out.println(toString(ar));
                }
            } else {
                ar[i+1] = e;
                System.out.println(toString(ar));
                break;
            }
        }
    }
    
    
/* Tail starts here */
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
         for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
         }
         insertIntoSorted(ar);
    }
    
    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
    
    
}


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static int[] initMedianIndices(int d) {
        int[] medianIndices;
        if (d % 2 == 0) {
            medianIndices = new int[] {(d/2)-1, d/2};
        } else {
            medianIndices = new int[] {d/2};
        }
        return medianIndices;
    }
    
    private static void update(int[] priorDays, int[] changes) {
        //System.out.println("BEFORE: priorDays = " + Arrays.toString(priorDays) + ", changes = " + Arrays.toString(changes));
        
        int removeIdx = Arrays.binarySearch(priorDays, changes[0]);        
        int insertionPoint = Arrays.binarySearch(priorDays, changes[1]);
        
        if (insertionPoint < 0) {
            insertionPoint = -(insertionPoint + 2);
        } else {
            insertionPoint--;
        }
        if (removeIdx == insertionPoint) {
            priorDays[removeIdx] = changes[1];
        } else if (removeIdx < insertionPoint) {
            for (int i = removeIdx; i < insertionPoint; i++) {
                priorDays[i] = priorDays[i+1];
            }
            priorDays[insertionPoint] = changes[1];
        } else {
            for (int i = removeIdx; i > insertionPoint; i--) {
                priorDays[i] = priorDays[i-1];
            }
            priorDays[insertionPoint] = changes[1];
        }
        
        //System.out.println("AFTER: priorDays = " + Arrays.toString(priorDays));
    }
    
    static int activityNotifications(int[] expenditure, int d) {
        int activityNotifications = 0;
        int[] medianIndices = initMedianIndices(d);
        
        int[] priorDays = new int[d];
        for (int i = d; i < expenditure.length; i++) {
            if (i == d) {
                for (int j = 0; j < d; j++) {
                    priorDays[j] = expenditure[j];
                }
                Arrays.sort(priorDays);
            } else {
                int[] changes = new int[] {expenditure[(i-d)-1], expenditure[i-1]};
                if (changes[0] != changes[1]) {
                    update(priorDays, changes);
                }
            }
            
            int sum = 0;
            for (int j = 0; j < medianIndices.length; j++) {
                sum += priorDays[medianIndices[j]];
            }
            //System.out.println("sum = " + sum);
            float median = sum / (float) medianIndices.length;
            //System.out.println("median = " + median);
            //System.out.println("expenditure[" + i + "] = " + expenditure[i]);
            if (expenditure[i] >= Math.round(median*2)) {
                //System.out.println("incrementing...");
                activityNotifications++;
            }
        }
        return activityNotifications;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] expenditure = new int[n];
        for(int expenditure_i = 0; expenditure_i < n; expenditure_i++){
            expenditure[expenditure_i] = in.nextInt();
        }
        int result = activityNotifications(expenditure, d);
        System.out.println(result);
        in.close();
    }
}


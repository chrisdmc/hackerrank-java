import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int half = n/2;
        StringBuilder[] data = new StringBuilder[100];
        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            String s = in.next();
            if (data[x] == null) {
                data[x] = new StringBuilder();
            }
            if (a0 < half) {
                data[x].append("- ");
            } else {
                data[x].append(s).append(" ");
            }
        }
        in.close();
        
        StringBuilder output = new StringBuilder();
        for (StringBuilder data_i: data) {
            if (data_i != null) {
               output.append(data_i.toString().trim()).append(" ");
            }
        }
        
        System.out.println(output.toString());
    }
}


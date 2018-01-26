import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String funnyString(String s){
        for (int i = 1; i < s.length(); i++) {
            int j = s.length()-i;
            int fwdVal = (int) Math.abs(s.charAt(i)-s.charAt(i-1));
            int bwdVal = (int) Math.abs(s.charAt(j-1)-s.charAt(j));
            if (fwdVal != bwdVal) {
                return "Not Funny";
            }
        }
        return "Funny";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = funnyString(s);
            System.out.println(result);
        }
    }
}


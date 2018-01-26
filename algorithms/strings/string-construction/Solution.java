import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int stringConstruction(String s) {
        int cost = 0;
        char[] alphabet = new char[26];
        for (char c: s.toCharArray()) {
            int ordinal = c - 'a';
            if (alphabet[ordinal] == 0) {
                cost++;
                alphabet[ordinal] = 1;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = stringConstruction(s);
            System.out.println(result);
        }
        in.close();
    }
}


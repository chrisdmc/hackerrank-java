import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());
        String text = scan.nextLine();
        int k = Integer.valueOf(scan.nextLine());
        int offset = k % 26;
        
        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                int ordinal;
                if (Character.isUpperCase(c)) {
                    ordinal = c - 64;
                } else {
                    ordinal = c - 96;
                }
                ordinal = (ordinal + offset) % 26;
                if (Character.isUpperCase(c)) {
                    c = (char) (ordinal + 64);
                } else {
                    c = (char) (ordinal + 96);
                }
            }
            System.out.print(c);
        }
    }
}

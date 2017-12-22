import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().toLowerCase();
        for (char c = 'a'; c < 'z'; c++) {
            if (!s.contains(String.valueOf(c))) {
                System.out.println("not pangram");
                return;
            }
        }
        System.out.println("pangram");
    }
}


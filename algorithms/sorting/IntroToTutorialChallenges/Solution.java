import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int nextVal = scanner.nextInt();
            if (nextVal == v) {
                System.out.println(i);
            }
        }
    }
}

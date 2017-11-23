import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static Map<Long, Map<Long, Long>> solutions = new HashMap<>();

    static long getWays(long n, long[] c, long maxSeen){        
        Long solution = 0L;
        if (n == 0) {
            solution = 1L;
        } else if (n > 0 && maxSeen <= n) {
            Map<Long, Long> solutionsByMaxSeen = solutions.get(n);
            if (solutionsByMaxSeen == null) {
                solutionsByMaxSeen = new HashMap<>();
                solutions.put(n, solutionsByMaxSeen);
            }
            solution = solutionsByMaxSeen.get(maxSeen);
            if (solution == null) {
                solution = 0L;
                
                for (int i = 0; i < c.length; i++) {
                    long c_i = c[i];
                    if (c_i >= maxSeen) {
                        long ways = getWays(n-c_i, c, c_i);
                        solution += ways;
                    }
                }
                solutionsByMaxSeen.put(maxSeen, solution);
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c, 0L);
        System.out.println(ways);
    }
}

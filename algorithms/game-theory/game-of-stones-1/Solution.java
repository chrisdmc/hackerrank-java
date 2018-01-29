import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static final int[] VALID_MOVES = {2, 3, 5};
    private static final Map<Integer, Boolean> WINNERS = new HashMap<>();

    static String gameOfStones(int n) {
        if (gameOfStonesInternal(n)) {
            return "First";
        } else {
            return "Second";
        }
    }
    
    private static boolean gameOfStonesInternal(int n) {
        Boolean winner = WINNERS.get(n);
        if (winner != null) {
            return winner;
        }
        if (n <= 1) {
            winner = Boolean.FALSE;
        } else if (n <= 6) {
            winner = Boolean.TRUE;
        } else {
            for (int i = 0; i < VALID_MOVES.length; i++) {
                boolean tmpWinner = !gameOfStonesInternal(n - VALID_MOVES[i]);
                if (tmpWinner) {
                    winner = Boolean.TRUE;
                    break;
                }
            }
        
            if (winner == null) {
                winner = Boolean.FALSE;
            }
        }
        
        WINNERS.put(n, winner);
        return winner;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            String result = gameOfStones(n);
            System.out.println(result);
        }
        in.close();
    }
}

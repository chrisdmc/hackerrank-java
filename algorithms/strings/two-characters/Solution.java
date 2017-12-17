import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static final class CharPair {
        private char primary, secondary;
        private int primaryCount, secondaryCount;
        
        public CharPair(char primary, char secondary) {
            this.primary = primary;
            this.secondary = secondary;
        }
        
        public boolean seen(char seenChar) {
            boolean valid = true;
            if (seenChar == primary) {
                primaryCount++;
                if (primaryCount != secondaryCount + 1) {
                    valid = false;
                }
            } else {
                secondaryCount++;
                if (secondaryCount != primaryCount) {
                    valid = false;
                }
            }
            return valid;
        }
        
        public int getSize() {
            return primaryCount + secondaryCount;
        }
    }
    
    private static Map<Character, Integer> charMaster = new HashMap<>();
    private static Map<Character, List<CharPair>> charPairsMaster = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        
        for (char c: s.toCharArray()) {
            Integer charCount = charMaster.get(c);
            if (charCount == null) {
                charCount = 0;
                List<CharPair> charPairs = new ArrayList<>();
                for (Map.Entry<Character, Integer> entry: charMaster.entrySet()) {
                    Character other = entry.getKey();
                    Integer otherCount = entry.getValue();
                    if (otherCount == 1) {
                        CharPair charPair = new CharPair(other, c);
                        charPair.seen(other);
                        charPair.seen(c);
                        List<CharPair> otherPairs = charPairsMaster.get(other);
                        otherPairs.add(charPair);
                        charPairs.add(charPair);
                    }
                }
                charPairsMaster.put(c, charPairs);
            } else {
                List<CharPair> charPairs = charPairsMaster.get(c);
                Set<CharPair> toRemove = new HashSet<>();
                for (CharPair charPair: charPairs) {
                    if (!charPair.seen(c)) {
                        toRemove.add(charPair);
                        char other = (charPair.primary == c ? charPair.secondary: charPair.primary);
                        List<CharPair> otherPairs = charPairsMaster.get(other);
                        otherPairs.remove(charPair);
                    }
                }
                charPairs.removeAll(toRemove);
            }
            charMaster.put(c, charCount+1);
        }
        
        CharPair maxPair = new CharPair('!', '$');
        for (Map.Entry<Character, List<CharPair>> entry: charPairsMaster.entrySet()) {
            for (CharPair charPair: entry.getValue()) {
                if (charPair.getSize() > maxPair.getSize()) {
                    maxPair = charPair;
                }
            }
        }
        
        System.out.println(maxPair.getSize());
    }
}


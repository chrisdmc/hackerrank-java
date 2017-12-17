import java.io.*;
import java.util.*;

public class Solution {
    
    public static final class Matrix {
        private int rows;
        private int columns;
        
        private char[][] matrix;
        
        public Matrix(int length) {
            int sqrtFloor = (int) Math.round(Math.floor(Math.sqrt(length)));
            int sqrtCeil = (int) Math.round(Math.ceil(Math.sqrt(length)));
            if (sqrtFloor == sqrtCeil) {
                rows = columns = sqrtFloor;
            } else {
                rows = sqrtFloor;
                columns = sqrtCeil;
                if (rows*columns < length) {
                    rows++;
                }
            }
            matrix = new char[columns][rows];
        }
        
        public void addText(String text) {
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    int charAt = row*columns + column;
                    if (text.length() > charAt) {
                        matrix[column][row] = text.charAt(charAt);
                    }
                }
            }
        }
        
        public String getEncodedText() {
            StringBuilder bldr = new StringBuilder();
            for (int column = 0; column < columns; column++) {
                for (int row = 0; row < rows; row++) {
                    char c = matrix[column][row];
                    if (c > 0) {
                        bldr.append(matrix[column][row]);
                    }
                }
                bldr.append(" ");
            }
            return bldr.toString().trim();
        }
    }
    
    public static String removeSpaces(String input) {
        return input.replaceAll("\\s+", "");
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = removeSpaces(input);
        int length = input.length();
        Matrix m = new Matrix(length);
        m.addText(input);
        System.out.println(m.getEncodedText());
    }
}

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Solution {

    static int digitSum(String n) {
      if (n.length() == 1) {
        return Integer.parseInt(n);
      }
      return digitSum(Integer.toString(Character.getNumericValue(n.charAt(0)) + digitSum(n.substring(1))));
    }
    static int superDigit(String n, int k) {
        int digitAfterSum = digitSum(n) * k;
        return digitSum(Integer.toString(digitAfterSum));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("random.txt"));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

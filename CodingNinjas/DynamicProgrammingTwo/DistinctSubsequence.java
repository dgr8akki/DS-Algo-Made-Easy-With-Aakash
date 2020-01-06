package CodingNinjas.DynamicProgrammingTwo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * DistinctSubsequence
 */
public class DistinctSubsequence {
  static int M = 1_000_000_000 + 7;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      String input = in.next();
      System.out.println(getDistinctSubsequences(input));
    }
    in.close();
  }

  private static int getDistinctSubsequences(String input) {
    int len = input.length();
    int[] lastOccurance = new int[256];
    Arrays.fill(lastOccurance, -1);
    long[] dp = new long[len + 1];
    dp[0] = 1;
    for (int i = 1; i <= len; i++) {
      dp[i] = 2 * dp[i - 1];
      if (dp[i] >= M) dp[i] -= M;
      if (lastOccurance[(int) input.charAt(i - 1)] != -1)
        dp[i] = (dp[i] % M - dp[lastOccurance[(int) input.charAt(i - 1)]] % M ) % M;
        if (dp[i] < 0) dp[i] += M;
      lastOccurance[(int) input.charAt(i - 1)] = (i - 1);
    }
    return (int)dp[len] % M;
  }
}

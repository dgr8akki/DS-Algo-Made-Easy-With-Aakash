package CodingNinjas.DynamicProgrammingTwo;

import java.util.Scanner;

/**
 * BalikaVadhu
 */
public class BalikaVadhu {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      String s1 = in.next();
      String s2 = in.next();
      int k = in.nextInt();
      System.out.println(solve(s1, s2, k));
    }
    in.close();

    // System.out.println(solve("ram", "shyam", 2));
  }

  private static int solve(String s1, String s2, int K) {
    int s1s = s1.length(), s2s = s2.length();
    int[][][] dp = new int[s1s + 1][s2s + 1][K + 1];
    for (int i = 1; i <= s1s; i++) {
      for (int j = 1; j <= s2s; j++) {
        for (int k = 0; k <= K; k++) {
          if(k == 0) {
            dp[i][j][k] = 0;
            continue;
          }

          if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            dp[i][j][k] = Math.max(s2.charAt(j - 1) + dp[i + 1][j + 1][k - 1], Math.max(dp[i + 1][j][k], dp[i][j + 1][k]));
          } else {
            dp[i][j][k] = Math.max(dp[i + 1][j][k], dp[i][j + 1][k]);
          }
        }
      }
    }
    return dp[s1s][s2s][K];
  }
}

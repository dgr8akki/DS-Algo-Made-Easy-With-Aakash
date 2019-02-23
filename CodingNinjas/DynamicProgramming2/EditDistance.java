/**
 * EditDistance
 */

public class EditDistance {

  public static int editDistance(String s1, String s2) {
    int s1s = s1.length(), s2s = s2.length();
    int[][] dp = new int[s1s + 1][s2s + 1];
    for (int i = 0; i <= s1s; i++)
      for (int j = 0; j <= s2s; j++) {
        if (i == 0) {
          dp[i][j] = j;
          continue;
        }
        if (j == 0) {
          dp[i][j] = i;
          continue;
        }

        if (s1.charAt(i - 1) == s2.charAt(j - 1))
          dp[i][j] = dp[i - 1][j - 1];
        else
          dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], (dp[i][j - 1])));
      }
    return dp[s1s][s2s];
  }
}

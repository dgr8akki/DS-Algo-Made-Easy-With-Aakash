package Leetcode;

class Solution {
  public boolean isInterleave(String s1, String s2, String s3) {
    int m = s1.length(), n = s2.length();
    if (s3.length() != m + n) {
      return false;
    }
    char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
    char[] c3 = s3.toCharArray();
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    for (int i = 1; i <= m; i++) {
      dp[i][0] = dp[i - 1][0] && c1[i - 1] == c3[i - 1];
    }
    for (int j = 1; j <= n; j++) {
      dp[0][j] = dp[0][j - 1] && c2[j - 1] == c3[j - 1];
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        char target = c3[i + j - 1];
        dp[i][j] = dp[i - 1][j] && c1[i - 1] == target || dp[i][j - 1] && c2[j - 1] == target;
      }
    }

    return dp[m][n];
  }
}

package Leetcode;

class Solution_1143_LCS {
  public int longestCommonSubsequence(String s1, String s2) {
    if (s1.length() == 0 || s2.length() == 0)
      return 0;
    int s1Size = s1.length(), s2Size = s2.length();
    int[][] dp = new int[s1Size + 1][s2Size + 1];
    for (int i = 1; i <= s1Size; i++)
      for (int j = 1; j <= s2Size; j++)
        dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? 1 + dp[i - 1][j - 1] : Math.max(dp[i - 1][j], dp[i][j - 1]);
    return dp[s1Size][s2Size];
  }
}

package Leetcode;

class Solution_516_LongestPalindromicSubsequence {
  public int longestPalindromeSubseq(String s) {
    int n = s.length();
    int[][] dp = new int[n + 1][n + 1];
    return longestPalindromeSubseqUtil(s, n, 0, n - 1, dp);
  }

  private int longestPalindromeSubseqUtil(String s, int n, int i, int j, int[][] dp) {
    if (i > j)
      return 0;
    if (i == j)
      return 1;
    if (dp[i][j] > 0)
      return dp[i][j];
    if (s.charAt(i) == s.charAt(j))
      return dp[i][j] = 2 + longestPalindromeSubseqUtil(s, n, i + 1, j - 1, dp);
    else {
      int option1 = longestPalindromeSubseqUtil(s, n, i + 1, j, dp);
      int option2 = longestPalindromeSubseqUtil(s, n, i, j - 1, dp);
      return dp[i][j] = Math.max(option1, option2);
    }
  }
}

package CodingNinjas.DynamicProgrammingTwo;

/**
 * LCS
 */
public class LCS {
  public static int lcs(String s1, String s2) {
    // return lcsRecursive(s1, s2);
    // int[][] dp = new int[s1.length() + 1][s2.length() + 1];
    // return lcsMemoized(s1, s2, 0, 0, dp);
    return lcsIterative(s1, s2);
	}

  private static int lcsRecursive(String s1, String s2) {
    if(s1.length() == 0 || s2.length() == 0) return 0;
    if(s1.charAt(0) == s2.charAt(0))
      return 1 + lcsRecursive(s1.substring(1), s2.substring(1));
    return Math.max(lcsRecursive(s1.substring(1), s2), lcsRecursive(s1, s2.substring(1)));
  }

  private static int lcsMemoized(String s1, String s2, int s1Index, int s2Index, int[][] dp) {
    if(s1.length() == 0 || s2.length() == 0) return 0;
    if(s1Index == s1.length() || s2.length() == s2Index) return 0;
    if(dp[s1Index][s2Index] != 0)
      return dp[s1Index][s2Index];
    if(s1.charAt(s1Index) == s2.charAt(s2Index)) {
      dp[s1Index][s2Index] = 1 + lcsMemoized(s1,s2,s1Index + 1, s2Index + 1, dp);
      return dp[s1Index][s2Index];
    }
    dp[s1Index][s2Index] = Math.max(lcsMemoized(s1,s2,s1Index + 1, s2Index, dp), lcsMemoized(s1, s2, s1Index, s2Index + 1, dp));
    return dp[s1Index][s2Index];
  }

  private static int lcsIterative(String s1, String s2) {
    if(s1.length() == 0 || s2.length() == 0) return 0;
    int s1Size = s1.length(), s2Size = s2.length();
    int[][] dp = new int[s1Size + 1][s2Size + 1];
    for(int i = 1; i <= s1Size; i++)
      for(int j = 1; j <= s2Size; j++)
        dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ? 1 + dp[i - 1][j - 1] : Math.max(dp[i - 1][j], dp[i][j - 1]);
    return dp[s1Size][s2Size];
  }

  public static void main(String[] args) {
    String s1 = "My Name is Aakash.";
    String s2 = "Tasmekh";
    System.out.println(lcs(s1, s2));
  }
}

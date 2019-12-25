package CodingNinjas.DynamicProgrammingTwo;

/**
 * ShortestSubsequence
 */
public class ShortestSubsequence {
  public int solve(String S, String V) {
    int m = S.length();
    int n = V.length();
    int[][] dp = new int[m + 1][n + 1];
    int sol = shortestSubsequenceUtil(S, V, 0, 0, dp);
    if (sol == S.length()) {
      return Integer.MAX_VALUE - 1001;
    }
    return sol;
  }

  private int shortestSubsequenceUtil(String S, String V, int sIndex, int vIndex, int[][] dp) {
    if (sIndex == S.length())
      return Integer.MAX_VALUE - 1001;
    if (vIndex >= V.length())
      return 1;
    if (dp[sIndex][vIndex] != 0) {
      return dp[sIndex][vIndex];
    }
    int notTakeCurrentCharacter = shortestSubsequenceUtil(S, V, sIndex + 1, vIndex, dp);
    int locationOfCurrentSCharacterInTString = V.indexOf(S.charAt(sIndex), vIndex);
    if (locationOfCurrentSCharacterInTString < 0)
      return 1;
    int takeCurrentCharacter = 1
        + shortestSubsequenceUtil(S, V, sIndex + 1, locationOfCurrentSCharacterInTString + 1, dp);
    return dp[sIndex][vIndex] = Math.min(notTakeCurrentCharacter, takeCurrentCharacter);
  }
}

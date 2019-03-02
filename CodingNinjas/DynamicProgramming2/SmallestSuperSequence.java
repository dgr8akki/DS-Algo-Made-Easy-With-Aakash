/**
 * SmallestSuperSequence
 */
public class SmallestSuperSequence {

	public static int smallestSuperSequence(String str1, String str2) {
    // return smallestSuperSequenceRecursive(str1, str2, 0, 0);
    int[][] dp = new int[str1.length() + 1][str2.length() + 1];
    return smallestSuperSequenceMemoized(str1, str2, 0, 0, dp);
	}

  private static int smallestSuperSequenceMemoized(String s1, String s2, int s1Idx, int s2Idx, int[][] dp) {
    if(s1Idx == s1.length() && s2.length() == s2Idx) return 0;
    if(s1Idx == s1.length()) return s2.length() - s2Idx;
    if(s2Idx == s2.length()) return s1.length() - s1Idx;
    if(dp[s1Idx][s2Idx] > 0) return dp[s1Idx][s2Idx];
    if(s1.charAt(s1Idx) == s2.charAt(s2Idx)) {
      return dp[s1Idx][s2Idx] = 1 + smallestSuperSequenceMemoized(s1, s2, s1Idx + 1, s2Idx + 1, dp);
    } else {
      int incrimentS1Index = smallestSuperSequenceMemoized(s1, s2, s1Idx + 1, s2Idx, dp);
      int incrimentS2Index = smallestSuperSequenceMemoized(s1, s2, s1Idx, s2Idx + 1, dp);
      return dp[s1Idx][s2Idx] = 1 + Math.min(incrimentS1Index, incrimentS2Index);
    }
  }

  private static int smallestSuperSequenceRecursive(String s1, String s2, int s1Idx, int s2Idx) {
    if(s1Idx == s1.length() && s2.length() == s2Idx) return 0;
    if(s1Idx == s1.length()) return s2.length() - s2Idx;
    if(s2Idx == s2.length()) return s1.length() - s1Idx;
    if(s1.charAt(s1Idx) == s2.charAt(s2Idx)) {
      return 1 + smallestSuperSequenceRecursive(s1, s2, s1Idx + 1, s2Idx + 1);
    } else {
      int incrimentS1Index = smallestSuperSequenceRecursive(s1, s2, s1Idx + 1, s2Idx);
      int incrimentS2Index = smallestSuperSequenceRecursive(s1, s2, s1Idx, s2Idx + 1);
      return 1 + Math.min(incrimentS1Index, incrimentS2Index);
    }
  }
  public static void main(String[] args) {
    System.out.println(smallestSuperSequence("str1", "str2"));
  }
}

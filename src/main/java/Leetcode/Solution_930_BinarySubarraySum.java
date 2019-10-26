package Leetcode;

class Solution {
  public int numSubarraysWithSum(int[] A, int S) {
    int[] dp = new int[A.length + 1];
    for (int i = 0; i < A.length; i++)
      dp[i + 1] = dp[i] + A[i];
    Map<Integer, Integer> count = new HashMap<>();
    int ans = 0;
    for (int c : dp) {
      ans += count.getOrDefault(c, 0);
      count.put(c + S, count.getOrDefault(c + S, 0) + 1);
    }
    return ans;
  }
}

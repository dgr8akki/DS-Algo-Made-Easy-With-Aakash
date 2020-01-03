class Solution_1218_LongestArithmeticSubsequenceOfDiff {
  public int longestSubsequence(int[] arr, int difference) {
    HashMap<Integer, Integer> dp = new HashMap<>();
    int longest = 0;
    for (int i = 0; i < arr.length; i++) {
      dp.put(arr[i], dp.getOrDefault(arr[i] - difference, 0) + 1);
      longest = Math.max(longest, dp.get(arr[i]));
    }
    return longest;
  }
}

class Solution {
  public int longestArithSeqLength(int[] A) {

    int maxlen = 0;
    Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
    for (int i = 1; i < A.length; i++) {
      int max = 1;
      Map<Integer, Integer> diffs = new HashMap<>();
      for (int j = 0; j < i; j++) {
        int d = A[i] - A[j];
        int prevd = dp.getOrDefault(j, new HashMap<>()).getOrDefault(d, 1);
        max = Math.max(max, prevd);
        diffs.put(d, prevd + 1);
      }
      maxlen = Math.max(max + 1, maxlen);
      dp.put(i, diffs);
    }
    return maxlen;
  }
}

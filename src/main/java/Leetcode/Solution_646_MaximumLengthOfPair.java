package Leetcode;

class Solution {
  public int findLongestChain(int[][] pairs) {
    Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
    int sum = 0, n = pairs.length, i = -1;
    while (++i < n) {
      sum++;
      int curEnd = pairs[i][1];
      while (i + 1 < n && pairs[i + 1][0] <= curEnd)
        i++;
    }
    return sum;
  }
}

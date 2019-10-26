package Leetcode;

class Solution {
  public int twoCitySchedCost(int[][] costs) {
    int len = costs.length;
    Arrays.sort(costs, (a, b) -> {
      int da = a[1] - a[0];
      int db = b[1] - b[0];
      return -Integer.compare(da, db);
    });

    int sum = 0;
    for (int i = 0; i < len; i++)
      sum += (i < (len >> 1)) ? costs[i][0] : costs[i][1];

    return sum;
  }
}

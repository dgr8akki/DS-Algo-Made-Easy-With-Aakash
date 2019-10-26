package Leetcode;

class Solution {
  public int maxDistToClosest(int[] seats) {
    int i, j, res = 0, n = seats.length;
    for (i = j = 0; j < n; ++j)
      if (seats[j] == 1) {
        if (i == 0)
          res = j;
        else
          res = Math.max(res, (j - i + 1) / 2);
        i = j + 1;
      }
    res = Math.max(res, n - i);
    return res;
  }
}

package Leetcode;

class Solution {
  public boolean checkStraightLine(int[][] co) {
    int p = co[0][0], q = co[0][1], u = co[1][0], v = co[1][1];
    for (int[] c : co)
      if ((c[0] - p) * (c[1] - v) != (c[0] - u) * (c[1] - q))
        return false;

    return true;
  }
}

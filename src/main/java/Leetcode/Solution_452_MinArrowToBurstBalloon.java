package Leetcode;

class Solution {
  public int findMinArrowShots(int[][] points) {
    if (points == null || points.length == 0)
      return 0;
    int count = 0, minEnd = Integer.MAX_VALUE;
    Arrays.sort(points, (a, b) -> (a[0] - b[0]));
    for (int[] point : points)
      if (point[0] > minEnd) {
        count++;
        minEnd = point[1];
      } else
        minEnd = Math.min(minEnd, point[1]);

    return count + 1;
  }
}

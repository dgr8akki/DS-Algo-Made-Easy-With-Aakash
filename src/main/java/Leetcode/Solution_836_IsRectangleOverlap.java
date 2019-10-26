package Leetcode;

class Solution {
  private int[] findRangeOverlap(int point1, int length1, int point2, int length2) {
    int[] res = new int[2];
    int highestStartPoint = Math.max(point1, point2);
    int lowestEndPoint = Math.min(point1 + length1, point2 + length2);

    if (highestStartPoint < lowestEndPoint) {
      res[1] = lowestEndPoint - highestStartPoint;
      res[0] = highestStartPoint;
    }

    return res;
  }

  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    int[] xOverlap = findRangeOverlap(rec1[0], rec1[2] - rec1[0], rec2[0], rec2[2] - rec2[0]);
    int[] yOverlap = findRangeOverlap(rec1[1], rec1[3] - rec1[1], rec2[1], rec2[3] - rec2[1]);

    if (xOverlap[1] == 0 || yOverlap[1] == 0) {
      return false;
    }
    return true;
  }
}

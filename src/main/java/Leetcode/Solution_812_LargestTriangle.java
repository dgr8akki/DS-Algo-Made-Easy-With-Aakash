package Leetcode;

class Solution_812_LargestTriangle {
  public double largestTriangleArea(int[][] points) {
    double area = 0;

    for (int i = 0; i < points.length - 2; ++i)
      for (int j = i + 1; j < points.length - 1; ++j)
        for (int k = i + 2; k < points.length; ++k) {
          double ax = points[i][0];
          double ay = points[i][1];
          double bx = points[j][0];
          double by = points[j][1];
          double cx = points[k][0];
          double cy = points[k][1];
          area = Math.max(area, Math.abs((ax * (by - cy) + bx * (cy - ay) + cx * (ay - by)) / 2));
        }
    return area;
  }
}

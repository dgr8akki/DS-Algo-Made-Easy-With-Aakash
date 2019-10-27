package Leetcode;

class Solution_492_ConstructRectangle {
  public int[] constructRectangle(int area) {
    int width = (int) Math.sqrt(area);
    while (area % width != 0)
      width--;
    int[] res = new int[2];
    res[0] = area / width;
    res[1] = width;
    return res;
  }
}

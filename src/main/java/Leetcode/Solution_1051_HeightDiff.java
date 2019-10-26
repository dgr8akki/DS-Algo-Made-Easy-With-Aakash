package Leetcode;

class Solution {
  public int heightChecker(int[] heights) {
    int count = 0;
    int[] copiedArray = heights.clone();
    Arrays.sort(copiedArray);
    for (int i = 0; i < heights.length; i++)
      if (heights[i] != copiedArray[i])
        count++;
    return count;
  }
}

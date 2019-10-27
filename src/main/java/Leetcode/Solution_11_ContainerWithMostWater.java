package Leetcode;

class Solution_11_ContainerWithMostWater {
  public int maxArea(int[] height) {
    int maxArea = 0;
    if (height == null || height.length == 1)
      return maxArea;

    for (int leftIdx = 0, rightIdx = height.length - 1; leftIdx < rightIdx;) {
      maxArea = Math.max(maxArea, (rightIdx - leftIdx) * Math.min(height[leftIdx], height[rightIdx]));
      if (height[leftIdx] > height[rightIdx])
        rightIdx--;
      else
        leftIdx++;
    }
    return maxArea;
  }
}

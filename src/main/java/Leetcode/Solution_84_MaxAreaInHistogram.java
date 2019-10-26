package Leetcode;

class Solution {
  public int largestRectangleArea(int[] input) {
    Deque<Integer> stack = new LinkedList<Integer>();
    int maxArea = 0;
    int area = 0;
    int i;
    for (i = 0; i < input.length;) {
      if (stack.isEmpty() || input[stack.peekFirst()] <= input[i])
        stack.offerFirst(i++);
      else {
        int top = stack.pollFirst();
        area = stack.isEmpty() ? input[top] * i : input[top] * (i - stack.peekFirst() - 1);

        if (area > maxArea)
          maxArea = area;
      }
    }
    while (!stack.isEmpty()) {
      int top = stack.pollFirst();
      area = stack.isEmpty() ? input[top] * i : input[top] * (i - stack.peekFirst() - 1);
      if (area > maxArea)
        maxArea = area;
    }
    return maxArea;
  }
}

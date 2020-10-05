package Leetcode;

class Solution_503_NextGreaterNumber2 {
  public int[] nextGreaterElements(int[] nums) {
    int[] res = new int[nums.length];
    int max = Integer.MIN_VALUE;
    for (int num : nums)
      max = Math.max(max, num);
    Stack<Integer> stack = new Stack();
    HashSet<Integer> visited = new HashSet();
    int index = 0;
    while (visited.size() < nums.length) {
      while (!stack.isEmpty() && nums[index] > nums[stack.peek()]) {
        int resIndex = stack.pop();
        res[resIndex] = nums[index];
        visited.add(resIndex);
      }
      if (nums[index] == max) {
        res[index] = -1;
        visited.add(index);
      } else if (!visited.contains(index)) {
        stack.push(index);
      }
      index = index < nums.length - 1 ? index + 1 : 0;
    }
    return res;
  }
}

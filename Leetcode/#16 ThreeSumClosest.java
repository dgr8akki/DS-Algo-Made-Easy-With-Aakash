class Solution {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int dist = Integer.MAX_VALUE, minSum = 0;
    for (int i = 0; i < nums.length - 2; i++) {
      int leftRunner = i + 1;
      int rightRunner = nums.length - 1;
      while (leftRunner < rightRunner) {
        int currentDist = Math.abs(target - (nums[i] + nums[leftRunner] + nums[rightRunner]));
        int currentSum = (nums[i] + nums[leftRunner] + nums[rightRunner]);
        if (currentSum == target)
          return target;
        if (currentDist < dist) {
          dist = currentDist;
          minSum = currentSum;
        }
        if (currentSum < target)
          leftRunner++;
        else if (currentSum > target)
          rightRunner--;
      }
    }
    return minSum;

  }
}

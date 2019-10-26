package Leetcode;

class Solution {
  public int triangleNumber(int[] nums) {
    Arrays.sort(nums);
    int cnt = 0;
    for (int i = nums.length - 1; i >= 2; --i) {
      int start = 0;
      int end = i - 1;
      while (start < end) {
        if (nums[start] + nums[end] <= nums[i]) {
          ++start;
          continue;
        }

        cnt += (end - start);
        --end;
      }
    }

    return cnt;
  }
}

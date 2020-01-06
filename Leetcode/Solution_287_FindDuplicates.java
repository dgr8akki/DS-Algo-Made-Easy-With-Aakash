package Leetcode;

class Solution_287_FindDuplicates {
  public int findDuplicate(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;
    int slow = nums[0], fast = nums[0];
    while (true) {
      slow = nums[slow];
      fast = nums[nums[fast]];
      if (slow == fast) {
        fast = nums[0];
        while (fast != slow) {
          slow = nums[slow];
          fast = nums[fast];
        }
        return fast;
      }
    }
  }
}

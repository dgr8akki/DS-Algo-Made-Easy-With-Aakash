package Leetcode;

class Solution_169_MajorityElement {
  public int majorityElement(int[] nums) {
    int maj = nums[0];
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (count == 0) {
        maj = nums[i];
        count++;
      } else if (nums[i] == maj) {
        count++;
      } else {
        count--;
      }
    }

    return maj;
  }
}

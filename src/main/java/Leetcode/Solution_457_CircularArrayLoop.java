package Leetcode;

public class Solution {
  public boolean circularArrayLoop(int[] nums) {
    boolean found = false;

    for (int n = 0; n < nums.length; n++) {
      Integer ps = n;
      Integer pf = next(nums, 0, n);
      int dir = nums[n];

      while (ps != null && pf != null && ps != pf) {
        ps = next(nums, dir, ps);
        pf = next(nums, dir, next(nums, dir, pf));
      }

      if (ps != null && ps == pf) {
        found = true;
        break;
      }
    }

    return found;
  }

  Integer next(int[] nums, int dir, Integer pos) {
    if (pos == null)
      return null;
    if (dir * nums[pos] < 0)
      return null;

    Integer next = (pos + nums[pos]) % nums.length;
    if (next < 0)
      next += nums.length;

    if (next == pos)
      next = null;
    return next;
  }
}

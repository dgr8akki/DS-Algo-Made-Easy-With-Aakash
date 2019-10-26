package Leetcode;

public class Solution {
  Map<Integer, Integer> map = new HashMap<>();

  public int combinationSum4(int[] nums, int target) {
    int count = 0;
    if (nums == null || nums.length == 0 || target < 0)
      return 0;
    if (target == 0)
      return 1;
    if (map.containsKey(target))
      return map.get(target);
    for (int num : nums)
      count += combinationSum4(nums, target - num);
    map.put(target, count);
    return count;
  }
}

package Leetcode;

class Solution_740_DeleteAndEarn {
  public int deleteAndEarn(int[] nums) {
    int n = 10001;
    int[] buckets = new int[n];
    for (int num : nums)
      buckets[num] += num;

    int take = 0, skip = 0;
    for (int i = 0; i < n; i++) {
      int takei = skip + buckets[i];
      int skipi = Math.max(skip, take);
      take = takei;
      skip = skipi;
    }
    return Math.max(take, skip);
  }
}

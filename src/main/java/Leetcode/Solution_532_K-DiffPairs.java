package Leetcode;

class Solution {
  public int findPairs(int[] nums, int k) {
    if (k < 0)
      return 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums)
      map.put(num, map.getOrDefault(num, 0) + 1);
    int count = 0;
    for (Integer i : map.keySet()) {
      if (k != 0 && map.get(i) != null && map.get(i + k) != null)
        count++;
      else if (k == 0 && map.get(i) != null && map.get(i) > 1)
        count++;
    }
    return count;
  }
}

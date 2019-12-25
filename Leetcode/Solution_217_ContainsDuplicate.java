package Leetcode;

class Solution_217_ContainsDuplicate {
  Set<Integer> set = new HashSet<>();

  public boolean containsDuplicate(int[] nums) {
    for (int i : nums) {
      if (set.contains(i))
        return true;
      set.add(i);
    }
    return false;
  }
}

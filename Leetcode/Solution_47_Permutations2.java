package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_47_Permutations2 {
  private static void backtrack(
    List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
    if (tempList.size() == nums.length) {
      list.add(new ArrayList<>(tempList));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
          continue;
        }
        used[i] = true;
        tempList.add(nums[i]);
        Solution_47_Permutations2.backtrack(list, tempList, nums, used);
        used[i] = false;
        tempList.remove(tempList.size() - 1);
      }
    }
  }

  public static List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    Solution_47_Permutations2.backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
    return list;
  }
}

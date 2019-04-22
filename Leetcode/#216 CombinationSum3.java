class Solution {
  public List<List<Integer>> combinationSum3(int k, int n) {
    int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    List<List<Integer>> list = new ArrayList<>();
    backtrack(list, new ArrayList<>(), nums, n, 0, k);
    return list;
  }

  private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start, int k) {
    if (remain < 0)
      return;
    else if (remain == 0 && tempList.size() == k)
      list.add(new ArrayList<>(tempList));
    else {
      for (int i = start; i < nums.length; i++) {
        if (i > start && nums[i] == nums[i - 1])
          continue;
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, remain - nums[i], i + 1, k);
        tempList.remove(tempList.size() - 1);
      }
    }
  }
}

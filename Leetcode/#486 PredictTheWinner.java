class Solution {
  public boolean PredictTheWinner(int[] nums) {
    return firstPlayerCanWin(0, 0, nums, 0, nums.length - 1);
  }

  private boolean firstPlayerCanWin(int s1, int s2, int[] nums, int start, int end) {
    if (start > end)
      return s1 >= s2;
    return !secondPlayerCanWin(s1 + nums[start], s2, nums, start + 1, end)
        || !secondPlayerCanWin(s1 + nums[end], s2, nums, start, end - 1);
  }

  private boolean secondPlayerCanWin(int s1, int s2, int[] nums, int start, int end) {
    if (start > end)
      return s1 < s2;
    return !firstPlayerCanWin(s1, s2 + nums[start], nums, start + 1, end)
        || !firstPlayerCanWin(s1, s2 + nums[end], nums, start, end - 1);
  }
}

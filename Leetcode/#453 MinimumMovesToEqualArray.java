class Solution {
  public int minMoves(int[] nums) {
    int n = nums.length;
    int minimum = Integer.MAX_VALUE;
    int sum = 0;
    for (int i : nums) {
      minimum = Math.min(i, minimum);
      sum += i;
    }
    return sum - (n * minimum);
  }
}

class Solution {
  public double findMaxAverage(int[] nums, int k) {
    double sum = 0, max = Integer.MIN_VALUE;
    int n = nums.length;
    for (int i = 0; i < k; i++)
      sum += nums[i];
    max = sum;
    for (int i = k; i < n; i++) {
      sum -= nums[i - k];
      sum += nums[i];
      max = Math.max(max, sum);
    }

    return max / k;
  }
}

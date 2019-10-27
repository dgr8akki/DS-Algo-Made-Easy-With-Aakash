package Leetcode;

public class Solution_327_CountRangeSum {
  int count = 0;
  int lower;
  int upper;

  public int countRangeSum(int[] nums, int lower, int upper) {
    long[] sum = new long[nums.length + 1];
    long[] temp = new long[nums.length + 1];
    sum[0] = 0;
    this.lower = lower;
    this.upper = upper;
    for (int i = 1; i <= nums.length; i++) {
      sum[i] = sum[i - 1] + (long) nums[i - 1];
    }

    mergesort(sum, 0, sum.length - 1, temp);
    return count;
  }

  private void mergesort(long[] sum, int start, int end, long[] temp) {
    if (start >= end) {
      return;
    }
    int mid = start + (end - start) / 2;
    mergesort(sum, start, mid, temp);
    mergesort(sum, mid + 1, end, temp);
    merge(sum, start, mid, end, temp);
  }

  private void merge(long[] sum, int start, int mid, int end, long[] temp) {
    int right = mid + 1;
    int index = start;
    int low = mid + 1, high = mid + 1;
    for (int left = start; left <= mid; left++) {
      while (low <= end && sum[low] - sum[left] < lower) {
        low++;
      }
      while (high <= end && sum[high] - sum[left] <= upper) {
        high++;
      }
      while (right <= end && sum[right] < sum[left]) {
        temp[index++] = sum[right++];
      }
      temp[index++] = sum[left];
      count += high - low;
    }
    while (right <= end) {
      temp[index++] = sum[right++];
    }

    for (int i = start; i <= end; i++) {
      sum[i] = temp[i];
    }
  }
}

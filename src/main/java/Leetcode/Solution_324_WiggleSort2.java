package Leetcode;

class Solution {
  public void wiggleSort(int[] nums) {
    if (nums == null || nums.length <= 1)
      return;
    int n = nums.length;
    int[] tmp = new int[n];
    for (int i = 0; i < n; ++i)
      tmp[i] = nums[i];

    int mid = partition(tmp, 0, n - 1, n / 2);
    Arrays.fill(nums, mid);
    int l = 1;
    int r = (n % 2 == 0) ? n - 2 : n - 1;
    for (int i = 0; i < n; ++i) {
      if (tmp[i] < mid) {
        nums[r] = tmp[i];
        r -= 2;
      } else if (tmp[i] > mid) {
        nums[l] = tmp[i];
        l += 2;
      }
    }
  }

  private int partition(int[] A, int s, int e, int rank) {
    int l = s;
    int r = e;
    int now = A[l];
    while (l <= r) {
      while (l <= r && A[l] < now)
        l++;

      while (l <= r && A[r] > now)
        r--;
      if (l <= r)
        swap(A, l++, r--);

    }
    if (l == rank)
      return now;
    if (l < rank)
      return partition(A, l, e, rank);
    return partition(A, s, l - 1, rank);
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
}

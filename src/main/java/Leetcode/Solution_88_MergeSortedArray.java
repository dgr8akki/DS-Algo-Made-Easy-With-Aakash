package Leetcode;

class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int lPtr = m - 1, rPtr = n - 1, mPtr = m + n - 1;
    while (lPtr >= 0 && rPtr >= 0) {
      if (nums1[lPtr] > nums2[rPtr]) {
        nums1[mPtr--] = nums1[lPtr--];
      } else {
        nums1[mPtr--] = nums2[rPtr--];
      }
    }
    while (lPtr >= 0) {
      nums1[mPtr--] = nums1[lPtr--];
    }
    while (rPtr >= 0) {
      nums1[mPtr--] = nums2[rPtr--];
    }
  }
}

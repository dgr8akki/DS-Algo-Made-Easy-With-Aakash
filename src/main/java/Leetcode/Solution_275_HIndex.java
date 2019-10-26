package Leetcode;

public class Solution {
  public int hIndex(int[] citations) {
    if (citations == null || citations.length == 0)
      return 0;
    int l = 0, r = citations.length;
    int n = citations.length;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (citations[mid] == n - mid)
        return n - mid;
      if (citations[mid] < citations.length - mid)
        l = mid + 1;
      else
        r = mid;
    }
    return n - l;
  }
}

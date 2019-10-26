package Leetcode;

class Solution {
  // O(n^2)
  public int maxWidthRamp2(int[] A) {
    int max = 0;
    int n = A.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (A[i] <= A[j]) {
          max = Math.max(max, j - i);
        }
      }
    }
    return max;
  }

  // O(nLogn)
  public int maxWidthRamp(int[] A) {
    List<Integer> s = new ArrayList<>();
    int res = 0, n = A.length;
    for (int i = 0; i < n; ++i) {
      if (s.size() == 0 || A[i] < A[s.get(s.size() - 1)]) {
        s.add(i);
      } else {
        int left = 0, right = s.size() - 1, mid = 0;
        while (left < right) {
          mid = (left + right) / 2;
          if (A[s.get(mid)] > A[i]) {
            left = mid + 1;
          } else {
            right = mid;
          }
        }
        res = Math.max(res, i - s.get(left));
      }
    }
    return res;
  }
}

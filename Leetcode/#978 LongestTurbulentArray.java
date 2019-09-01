class Solution {
  public int maxTurbulenceSize(int[] A) {
    int pre = 0, cur = 0, len = 1, res = 1;
    for (int i = 1; i < A.length; i++) {
      cur = Integer.compare(A[i], A[i - 1]);
      if (cur * pre == -1)
        len++;
      else if (cur == 0)
        len = 1;
      else
        len = 2;
      res = Math.max(res, len);
      pre = cur;
    }
    return res;
  }
}

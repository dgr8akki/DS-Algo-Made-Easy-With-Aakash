package Leetcode;

class Solution_944_DeleteColumnToSort {
  public int minDeletionSize(String[] A) {
    if (A.length <= 1 || A[0].length() <= 1)
      return 0;
    int res = 0;
    for (int i = 0; i < A[0].length(); i++) {
      for (int j = 1; j < A.length; j++) {
        if (A[j].charAt(i) < A[j - 1].charAt(i)) {
          res++;
          break;
        }
      }
    }
    return res;
  }
}

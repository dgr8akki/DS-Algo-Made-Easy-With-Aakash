package Leetcode;

class Solution_941_ValidMountains {
  public boolean validMountainArray(int[] A) {
    int n = A.length, i = 0, j = n - 1;
    while (i + 1 < n && A[i] < A[i + 1])
      i++;
    while (j > 0 && A[j - 1] > A[j])
      j--;
    return i > 0 && i == j && j < n - 1;
  }
}

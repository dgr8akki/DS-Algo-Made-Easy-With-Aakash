class Solution {
  public int pivotIndex(int[] A) {
    int lSum = 0, rSum = 0;
    for (int i : A)
      rSum += i;
    for (int i = 0; i < A.length; i++) {
      rSum -= A[i];
      if (lSum == rSum)
        return i;
      lSum += A[i];
    }
    return -1;
  }
}

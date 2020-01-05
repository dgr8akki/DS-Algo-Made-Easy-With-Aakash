class Solution_1304_UniqueArraySumZero {
  public int[] sumZero(int n) {
    int[] res = new int[n];
    int index = 0;
    for (int i = n / 2; i > 0; i--) {
      res[index++] = i;
      res[index++] = -1 * i;
    }
    if (n % 2 != 0)
      res[index++] = 0;
    return res;
  }
}

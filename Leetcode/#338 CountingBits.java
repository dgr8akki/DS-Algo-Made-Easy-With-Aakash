class Solution {
  public int[] countBits(int num) {
    int[] res = new int[num + 1];
    for (int i = 0; i <= num; i++)
      res[i] = onesInNumber(i);
    return res;
  }

  private int onesInNumber(int n) {
    int count = 0;
    while (n > 0) {
      if (n % 2 == 1)
        count++;
      n /= 2;
    }
    return count;
  }
}

class Solution {
  public int brokenCalc(int X, int Y) {
    int minNumberOfOperations = 0;
    while (Y > X) {
      if (Y % 2 == 1)
        Y += 1;
      else
        Y /= 2;
      minNumberOfOperations++;
    }

    return minNumberOfOperations + X - Y;
  }
}

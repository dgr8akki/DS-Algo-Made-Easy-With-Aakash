package Leetcode;

public class Solution_201_BiwiseANDofNumberRange {
  public int rangeBitwiseAnd(int m, int n) {
    int diffBits = 0;
    while (m != n) {
      m >>= 1;
      n >>= 1;
      diffBits++;
    }
    return n << diffBits;
  }
}

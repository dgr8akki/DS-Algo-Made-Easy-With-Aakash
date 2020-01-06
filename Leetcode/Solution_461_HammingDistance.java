package Leetcode;

class Solution_461_HammingDistance {
  public int hammingDistance(int x, int y) {
    return Integer.bitCount(x ^ y);
  }
}

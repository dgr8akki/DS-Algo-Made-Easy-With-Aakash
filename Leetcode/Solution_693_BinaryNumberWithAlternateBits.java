package Leetcode;

class Solution_693_BinaryNumberWithAlternateBits {
  public boolean hasAlternatingBits(int n) {
    String s = Integer.toBinaryString(n);
    return !(s.contains("11") || s.contains("00"));
  }
}

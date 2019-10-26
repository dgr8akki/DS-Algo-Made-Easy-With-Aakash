package Leetcode;

class Solution {
  public boolean hasAlternatingBits(int n) {
    String s = Integer.toBinaryString(n);
    return !(s.contains("11") || s.contains("00"));
  }
}

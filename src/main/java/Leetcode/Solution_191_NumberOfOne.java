package Leetcode;

public class Solution_191_NumberOfOne {
  public int hammingWeight(int n) {
    return Integer.toBinaryString(n).replaceAll("0", "").length();
  }
}

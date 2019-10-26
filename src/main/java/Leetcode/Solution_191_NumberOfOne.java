package Leetcode;

public class Solution {
  public int hammingWeight(int n) {
    return Integer.toBinaryString(n).replaceAll("0", "").length();
  }
}

package Leetcode;

class Solution {
  public String baseNeg2(int N) {
    String ans = "";
    while (N != 0) {
      ans = Integer.toString(N & 1) + ans;
      N = -(N >> 1);
    }
    return ans == "" ? "0" : ans;
  }

  public String base2(int N) {
    String ans = "";
    while (N != 0) {
      ans = Integer.toString(N & 1) + ans;
      N >>= 1;
    }
    return ans == "" ? "0" : ans;
  }
}

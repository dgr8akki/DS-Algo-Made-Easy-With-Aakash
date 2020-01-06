package Leetcode;

class Solution_1016_BinaryStringWithSubstring {
  public boolean queryString(String S, int N) {
    for (int i = 1; i <= N; i++)
      if (S.indexOf(Integer.toBinaryString(i)) < 0)
        return false;
    return true;
  }
}

package Leetcode;

class Solution_1111_MaxNestedParanthesis {
  public int[] maxDepthAfterSplit(String seq) {
    int n = seq.length(), res[] = new int[n];
    for (int i = 0; i < n; ++i)
      res[i] = seq.charAt(i) == '(' ? i & 1 : (1 - i & 1);
    return res;
  }
}

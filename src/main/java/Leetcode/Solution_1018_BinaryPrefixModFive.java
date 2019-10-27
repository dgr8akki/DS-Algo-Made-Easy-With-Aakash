package Leetcode;

class Solution_1018_BinaryPrefixModFive {
  public List<Boolean> prefixesDivBy5(int[] A) {
    List<Boolean> res = new ArrayList<>();
    int num = 0;
    for (int i : A) {
      num = num << 1;
      if (i == 1)
        num ^= 1;
      res.add(num % 5 == 0);
      num %= 5;
    }
    return res;
  }
}

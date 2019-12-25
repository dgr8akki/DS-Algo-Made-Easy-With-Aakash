package Leetcode;

class Solution_926_FlipStringToMonotonicIncreasing {
  public int minFlipsMonoIncr(String S) {
    if (S == null || S.length() <= 0)
      return 0;

    int flipCount = 0;
    int onesCount = 0;

    for (char c : S.toCharArray()) {
      if (c == '0')
        if (onesCount == 0)
          continue;
        else
          flipCount++;
      else
        onesCount++;
      flipCount = Math.min(onesCount, flipCount);
    }
    return flipCount;
  }
}

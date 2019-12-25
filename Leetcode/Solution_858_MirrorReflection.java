package Leetcode;

class Solution_858_MirrorReflection {
  public int mirrorReflection(int p, int q) {
    return (p & -p) > (q & -q) ? 2 : (p & -p) < (q & -q) ? 0 : 1;
  }
}

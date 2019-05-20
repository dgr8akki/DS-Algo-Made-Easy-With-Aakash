class Solution {
  public int mirrorReflection(int p, int q) {
    return (p & -p) > (q & -q) ? 2 : (p & -p) < (q & -q) ? 0 : 1;
  }
}

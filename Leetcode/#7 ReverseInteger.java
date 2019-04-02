class Solution {
  public int reverse(int x) {
    if (x <= Integer.MIN_VALUE)
      return 0;
    if (x < 0)
      return -1 * reverse(-1 * x);
    long v = Long.parseLong(new StringBuilder(Integer.toString(x)).reverse().toString());
    return v > Integer.MAX_VALUE ? 0 : (int) v;
  }
}

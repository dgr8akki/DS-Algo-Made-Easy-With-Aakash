package Leetcode;

class Solution_365_WaterJugProblem {
  public boolean canMeasureWater(int x, int y, int z) {
    return z == 0 || (long) x + y >= z && z % gcd(x, y) == 0;
  }

  public int gcd(int x, int y) {
    return y == 0 ? x : gcd(y, x % y);
  }
}

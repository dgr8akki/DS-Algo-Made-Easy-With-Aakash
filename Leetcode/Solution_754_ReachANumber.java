package Leetcode;

class Solution_754_ReachANumber {
  public int reachNumber(int tar) {
    int target = Math.abs(target), step = 0, sum = 0;
    while (sum < target) {
      step++;
      sum += step;
    }
    while ((sum - target) % 2 != 0) {
      step++;
      sum += step;
    }
    return step;
  }
}

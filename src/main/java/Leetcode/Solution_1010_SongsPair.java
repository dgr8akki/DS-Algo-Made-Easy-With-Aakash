package Leetcode;

class Solution_1010_SongsPair {
  public static int numPairsDivisibleBy60(int[] time) {
    int[] temp = new int[60];
    int count = 0;
    for (int t : time) {
      count += temp[(60 - t % 60) % 60];
      temp[t % 60] += 1;
    }
    return count;
  }
}

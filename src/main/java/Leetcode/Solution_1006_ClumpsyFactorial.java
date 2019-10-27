package Leetcode;

class Solution_1006_ClumpsyFactorial {
  public int clumsy(int N) {
    int[] magic = { 1, 2, 2, -1, 0, 0, 3, 3 };
    if (N > 4)
      return N + magic[N % 4];
    return N + magic[N + 3];
  }
}

class Solution {
  public int minCostToMoveChips(int[] chips) {
    int odd = 0, even = 0;
    for (int c : chips)
      if (c % 2 == 0)
        even++;
      else
        odd++;
    return Math.min(odd, even);
  }
}

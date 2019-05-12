class Solution {
  public int[] prisonAfterNDays(int[] cells, int N) {
    for (N = (N - 1) % 14 + 1; N > 0; --N) {
      int[] cells2 = new int[8];
      for (int i = 1; i < 7; ++i)
        cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
      cells = cells2;
    }
    return cells;
  }
}

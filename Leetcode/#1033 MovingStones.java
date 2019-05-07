class Solution {
  public int[] numMovesStones(int a, int b, int c) {
    int[] in = new int[] { a, b, c };
    Arrays.sort(in);
    int min = in[1] - in[0] == 2 || in[2] - in[1] == 2 ? 1
        : (in[0] == in[1] - 1 ? 0 : 1) + (in[2] == in[1] + 1 ? 0 : 1);
    int max = in[2] - in[0] - 2;
    return new int[] { min, max };
  }
}

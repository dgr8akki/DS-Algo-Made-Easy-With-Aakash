class Solution {
  int count, n;
  int[] f;

  public int regionsBySlashes(String[] grid) {
    n = grid.length;
    f = new int[n * n * 4];
    count = n * n * 4;
    for (int i = 0; i < n * n * 4; ++i)
      f[i] = i;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < n; ++j) {
        if (i > 0)
          union(g(i - 1, j, 2), g(i, j, 0));
        if (j > 0)
          union(g(i, j - 1, 1), g(i, j, 3));
        if (grid[i].charAt(j) != '/') {
          union(g(i, j, 0), g(i, j, 1));
          union(g(i, j, 2), g(i, j, 3));
        }
        if (grid[i].charAt(j) != '\\') {
          union(g(i, j, 0), g(i, j, 3));
          union(g(i, j, 2), g(i, j, 1));
        }
      }
    }
    return count;
  }

  public int find(int x) {
    if (x != f[x]) {
      f[x] = find(f[x]);
    }
    return f[x];
  }

  public void union(int x, int y) {
    x = find(x);
    y = find(y);
    if (x != y) {
      f[x] = y;
      count--;
    }
  }

  public int g(int i, int j, int k) {
    return (i * n + j) * 4 + k;
  }
}

class Solution {
  public Node construct(int[][] grid) {
    return construct(grid, 0, 0, grid.length);
  }

  public Node construct(int[][] grid, int startR, int startC, int n) {
    if (sameSection(grid, startR, startC, n)) {
      Node root = new Node(grid[startR][startC] == 1, true, null, null, null, null);
      return root;
    } else {
      Node topLeft = construct(grid, startR, startC, n / 2);
      Node topRight = construct(grid, startR, startC + n / 2, n / 2);
      Node bottomLeft = construct(grid, startR + n / 2, startC, n / 2);
      Node bottomRight = construct(grid, startR + n / 2, startC + n / 2, n / 2);
      Node root = new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
      return root;
    }
  }

  public boolean sameSection(int[][] sect, int startR, int startC, int n) {
    if (n == 1)
      return true;
    for (int i = startR; i < startR + n; i++)
      for (int j = startC; j < startC + n; j++)
        if (sect[startR][startC] != sect[i][j])
          return false;
    return true;
  }
}

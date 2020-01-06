package Leetcode;

class Solution_1030_MatrixDistance {
  private class Pair {
    int x;
    int y;
    int dist;

    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }

  }

  public int[][] allCellsDistOrder(int m, int n, int r0, int c0) {

    PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
      return Integer.compare(a.dist, b.dist);
    });

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        Pair p = new Pair(i, j);
        p.dist = Math.abs(i - r0) + Math.abs(j - c0);
        pq.offer(p);
      }
    }

    int s = pq.size();
    int[][] res = new int[s][2];
    for (int i = 0; i < s; i++) {
      Pair cur = pq.poll();
      res[i][0] = cur.x;
      res[i][1] = cur.y;

    }
    return res;

  }
}

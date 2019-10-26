package Leetcode;

class Solution {
  static class Node {
    int vertex;
    int distance;

    Node(int v, int d) {
      this.vertex = v;
      this.distance = d;
    }
  }

  public int snakesAndLadders(int[][] b) {
    int n = b.length, l = n * n;
    int[] board = new int[l];

    int k = l - 1;
    for (int i = 0; i < n; i++)
      if (i % 2 == 0)
        for (int j = 0; j < n; j++)
          board[k--] = b[i][j] - 1;
      else
        for (int j = n - 1; j >= 0; j--)
          board[k--] = b[i][j] - 1;

    Queue<Node> q = new LinkedList<>();
    System.out.println(Arrays.toString(board));
    boolean[] visited = new boolean[l];
    visited[0] = true;
    q.add(new Node(0, 0));

    Node current = new Node(0, 0);
    while (!q.isEmpty()) {
      current = q.remove();

      if (current.vertex == l - 1)
        break;

      for (int i = current.vertex + 1; (i <= current.vertex + 6) && i < l; i++) {
        if (!visited[i]) {
          Node temp = new Node(i, current.distance + 1);

          if (board[i] != -2)
            temp.vertex = board[i];
          visited[i] = true;
          q.add(temp);
        }
      }
    }
    if (current.vertex == l - 1)
      return current.distance;
    return -1;
  }
}

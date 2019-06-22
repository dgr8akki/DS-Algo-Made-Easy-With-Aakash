class Solution {
  public boolean isBipartite(int[][] graph) {
    int len = graph.length;
    int[] colors = new int[len];

    for (int i = 0; i < len; i++) {
      if (colors[i] != 0)
        continue;
      Queue<Integer> queue = new LinkedList<>();
      queue.offer(i);
      colors[i] = 1;

      while (!queue.isEmpty()) {
        int cur = queue.poll();
        for (int next : graph[cur]) {
          if (colors[next] == 0) {
            colors[next] = -colors[cur];
            queue.offer(next);
          } else if (colors[next] != -colors[cur])
            return false;
        }
      }
    }

    return true;
  }
}

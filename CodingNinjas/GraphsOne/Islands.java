package CodingNinjas.GraphsOne;

public class Islands {

  private static int isConnected(int[][] graph) {
    boolean[] isVisited = new boolean[graph.length];
    int count = 0;
    for (int i = 1; i < graph.length; i++) {
      if (!isVisited[i]) {
        count++;
        DFSUtil(graph, i, isVisited);
      }
    }

    return count;
  }

  private static void DFSUtil(int[][] graph, int startNode, boolean[] isVisited) {
    isVisited[startNode] = true;
    for (int i = 1; i < graph.length; i++) {
      if (graph[i][startNode] == 1 && !isVisited[i]) {
        DFSUtil(graph, i, isVisited);
      }
    }
  }

  public static int solve(int n, int m, int[] U, int[] V) {
    int[][] graph = new int[n + 1][n + 1];
    for (int i = 0; i < m; i++) {
      graph[U[i]][V[i]] = 1;
      graph[V[i]][U[i]] = 1;
    }

    return isConnected(graph);
  }
}

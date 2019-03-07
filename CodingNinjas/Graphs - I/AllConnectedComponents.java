import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * AllConnectedComponents
 */
public class AllConnectedComponents {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
		int V = in.nextInt();
		int E = in.nextInt();

		int[][] graph = new int[V][V];
    for(int i = 0; i < E; i++) {
      int s = in.nextInt();
      int e = in.nextInt();
      graph[s][e] = 1;
      graph[e][s] = 1;
    }
    in.close();
    solve(graph);
  }

  private static void solve(int[][] graph) {
    boolean[] isVisited = new boolean[graph.length];
    List<Integer> path = new ArrayList<>();
    for(int i = 0; i < graph.length; i++) {
      if(!isVisited[i]) {
        DFSUtil(graph, i, isVisited, path);
        Collections.sort(path);
        for(int p : path)
          System.out.print(p + " ");
        System.out.println();
        path.clear();
      }
    }
  }

  private static void DFSUtil(int[][] graph, int startNode, boolean[] isVisited, List<Integer> path) {
    path.add(startNode);
    isVisited[startNode] = true;
    for(int i = 0; i < graph.length; i++)
      if(graph[i][startNode] == 1 && !isVisited[i])
        DFSUtil(graph, i, isVisited, path);
  }
}

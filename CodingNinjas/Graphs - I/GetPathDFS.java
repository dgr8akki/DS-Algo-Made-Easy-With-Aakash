import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * GetPathDFS
 */
public class GetPathDFS {
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
    int s = in.nextInt();
    int e = in.nextInt();
    in.close();
    if(graph[s][e] == 1) {
      System.out.println(e);
      return;
    }
    boolean[] isVisited = new boolean[V];
    List<Integer> path = new ArrayList<>();
    if(!getPathDFSUtil(graph, s, e, isVisited, path)) {
      System.out.println();
      return;
    }
    Collections.reverse(path);
    for(int i : path)
      System.out.print(i + " ");
	}

  private static boolean getPathDFSUtil(int[][] graph, int startNode, int endNode, boolean[] isVisited, List<Integer> path) {
    path.add(startNode);
    if(startNode == endNode) return true;
    for(int i = 0; i < graph.length; i++) {
      if(graph[i][startNode] == 1 && !path.contains(i))
        if(getPathDFSUtil(graph, i, endNode, isVisited, path)) {
          return true;
        }
    }

    path.remove(path.size() - 1);
    return false;
  }
}

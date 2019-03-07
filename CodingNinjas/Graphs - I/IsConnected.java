import java.util.Scanner;

/**
 * IsConnected
 */
public class IsConnected {

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
    if(isConnected(graph))
      System.out.println("true");
    else
      System.out.println("false");
  }

  private static boolean isConnected(int[][] graph) {
    boolean[] isVisited = new boolean[graph.length];
    DFSUtil(graph, 0, isVisited);
    for(boolean isReachedCurrentNode : isVisited)
      if(!isReachedCurrentNode)
        return false;
    return true;
  }

  private static void DFSUtil(int[][] graph, int startNode, boolean[] isVisited) {
    isVisited[startNode] = true;
    for(int i = 0; i < graph.length; i++)
      if(graph[i][startNode] == 1 && !isVisited[i])
        DFSUtil(graph, i, isVisited);
  }
}

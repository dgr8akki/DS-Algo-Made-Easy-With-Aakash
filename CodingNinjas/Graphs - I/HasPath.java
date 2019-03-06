import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * HasPath
 */
public class HasPath {

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
      System.out.println("true");
      return;
    }
    boolean[] isVisited = new boolean[V];
    // hasPath(V, graph, isVisited, s, e);
    Queue<Integer> q = new LinkedList<>();
    q.add(s);

    while(!q.isEmpty()) {
      int current = q.remove();
      if(current == e) {
        System.out.println("true");
        return;
      }
      if(isVisited[current]) continue;
      isVisited[current] = true;

      for(int i = 0; i < V; i++) {
        if(graph[current][i] == 1 && !isVisited[i]) {
          q.add(i);
        }
      }
    }
    System.out.println("false");
	}
}

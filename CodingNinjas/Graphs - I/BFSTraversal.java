import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * BFSTraversal
 */
public class BFSTraversal {

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
    boolean[] isVisited = new boolean[V];
    Queue<Integer> q = new LinkedList<>();
    q.add(0);

    while(!q.isEmpty()) {
      int current = q.remove();
      if(isVisited[current]) continue;
      System.out.print(current + " ");
      isVisited[current] = true;

      for(int i = 0; i < V; i++) {
        if(graph[current][i] == 1 && !isVisited[i]) {
          q.add(i);
        }
      }
    }
	}
}

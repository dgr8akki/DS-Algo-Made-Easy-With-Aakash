import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * GetPathBFS
 */
public class GetPathBFS {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int V = in.nextInt();
    int E = in.nextInt();

    int[][] graph = new int[V][V];
    for (int i = 0; i < E; i++) {
      int s = in.nextInt();
      int e = in.nextInt();
      graph[s][e] = 1;
      graph[e][s] = 1;
    }
    int s = in.nextInt();
    int e = in.nextInt();
    in.close();
    if (graph[s][e] == 1) {
      System.out.println(e);
      return;
    }
    getPathBFSUtil(graph, s, e, V);
  }

  private static void getPathBFSUtil(int[][] graph, int startNode, int endNode, int V) {
    Queue<Integer> q = new LinkedList<>();
    Map<Integer, Integer> path = new HashMap<>();
    boolean isVisited[] = new boolean[V];
    boolean pathFound = false;
    q.add(startNode);
    while (!q.isEmpty()) {
      int currentNode = q.remove();
      if (currentNode == endNode) {
        pathFound = true;
        break;
      }
      isVisited = processNode(currentNode, isVisited);
      for (int i = 0; i < V; i++)
        if (graph[currentNode][i] == 1 && !isVisited[i]) {
          if (!path.containsKey(i))
            path.put(i, currentNode);
          q.add(i);
        }
    }

    if (pathFound) {
      printPath(path, startNode, endNode);
    } else {
      System.out.println();
    }
  }

  private static void printPath(Map<Integer, Integer> path, int startNode, int endNode) {
    int currentNode = endNode;
    while (currentNode != startNode) {
      System.out.print(currentNode + " ");
      currentNode = path.get(currentNode);
    }
    System.out.print(startNode);
  }

  private static boolean[] processNode(int node, boolean[] isVisited) {
    if (!isVisited[node]) {
      isVisited[node] = true;
    }
    return isVisited;
  }
}

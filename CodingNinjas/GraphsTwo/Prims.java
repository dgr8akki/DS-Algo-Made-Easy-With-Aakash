package CodingNinjas.GraphsTwo;

import java.util.Arrays;
import java.util.Scanner;

/** Prims */
public class Prims {
  public static void main(String[] args) {
    // Inputs
    Scanner in = new Scanner(System.in);
    int V = in.nextInt();
    int E = in.nextInt();
    int[][] graph = new int[V][V];
    for (int i = 0; i < E; i++) {
      int s = in.nextInt();
      int e = in.nextInt();
      int w = in.nextInt();
      graph[s][e] = w;
      graph[e][s] = w;
    }
    in.close();

    // Initialization
    int[] parent = new int[V];
    int[] weight = new int[V];
    boolean[] visited = new boolean[V];

    Arrays.fill(parent, -1);
    Arrays.fill(weight, Integer.MAX_VALUE);
    int currentVertext = 0;
    weight[currentVertext] = 0;

    // Processing
    for (int i = 0; i < V - 1; i++) {
      int minVertex = getMinVertex(visited, weight, V);
      visited[minVertex] = true;

      for (int j = 0; j < V; j++) {
        if (graph[j][minVertex] != 0 && !visited[j]) {
          if (weight[j] > graph[j][minVertex]) {
            weight[j] = graph[j][minVertex];
            parent[j] = minVertex;
          }
        }
      }
    }
    // Output
    for (int i = 1; i < V; i++) {
      if (parent[i] < i) {
        System.out.println(parent[i] + " " + i + " " + graph[i][parent[i]]);
      } else {
        System.out.println(i + " " + parent[i] + " " + graph[i][parent[i]]);
      }
    }
  }

  private static int getMinVertex(boolean[] visited, int[] weight, int v) {
    int min = -1;
    int minWeight = Integer.MAX_VALUE;
    for (int i = 0; i < v; i++) {
      if (minWeight > weight[i] && !visited[i]) {
        minWeight = weight[i];
        min = i;
      }
    }
    return min;
  }
}

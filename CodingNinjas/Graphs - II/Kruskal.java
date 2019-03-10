import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Kruskal
 */
public class Kruskal {
  static class Edge implements Comparable<Edge> {
    int src;
    int dest;
    int weight;

    public Edge(int src, int dest, int weight) {
      this.src = src;
      this.dest = dest;
      this.weight = weight;
    }

    @Override
    public String toString() {
      if (src <= dest)
        return src + " " + dest + " " + weight;
      return dest + " " + src + " " + weight;
    }

    @Override
    public int compareTo(Edge other) {
      return Integer.compare(this.weight, other.weight);
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int V = in.nextInt();
    int E = in.nextInt();
    int count = 0;
    int[] parent = new int[V];
    for (int i = 0; i < V; i++)
      parent[i] = i;
    Edge[] input = new Edge[E];
    List<Edge> output = new ArrayList<>(V - 1);
    // Take input
    for (int i = 0; i < E; i++)
      input[i] = new Edge(in.nextInt(), in.nextInt(), in.nextInt());
    in.close();

    // Sort Edges
    Arrays.sort(input);

    // Process
    for (Edge edge : input) {
      if (!isCycleFormed(edge, parent)) {
        output.add(edge);
        count++;
      }
      if (count == V - 1)
        break;
    }

    // Print output
    for (Edge edge : output)
      System.out.println(edge);
  }

  private static boolean isCycleFormed(Edge edge, int[] parent) {
    int srcParent = findParent(edge.src, parent);
    int destParent = findParent(edge.dest, parent);

    if (srcParent == destParent)
      return true;
    union(edge.src, edge.dest, parent);
    return false;
  }

  private static void union(int src, int dest, int[] parent) {
    int srcParent = findParent(src, parent);
    int destParent = findParent(dest, parent);
    if (srcParent == destParent)
      return;
    parent[srcParent] = destParent;
  }

  private static int findParent(int src, int[] parent) {
    if (src == parent[src])
      return src;
    return findParent(parent[src], parent);
  }
}

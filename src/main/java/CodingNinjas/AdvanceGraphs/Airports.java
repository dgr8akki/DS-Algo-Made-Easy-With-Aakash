package CodingNinjas.AdvanceGraphs;
import java.util.*;

/**
 * Airports
 */
public class Airports {
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
    int T = in.nextInt();
    for (int t = 0; t < T; t++) {
      int V = in.nextInt();
      int E = in.nextInt();
      int airportCost = in.nextInt();
      int count = 0;
      int[] parent = new int[V];
      for (int i = 0; i < V; i++)
        parent[i] = i;
      Edge[] input = new Edge[E];
      List<Edge> output = new ArrayList<>(V - 1);
      // Take input
      for (int i = 0; i < E; i++)
        input[i] = new Edge(in.nextInt() - 1, in.nextInt() - 1, in.nextInt());

      // Sort Edges
      Arrays.sort(input);

      // Process
      for (Edge edge : input) {
        if (edge.weight < airportCost && !isCycleFormed(edge, parent)) {
          output.add(edge);
          count++;
        }
        if (count == V - 1)
          break;
      }

      long cost = 0;
      int numberOfairports = 0;
      //GET COMPONENTS
      for (int i = 0; i < V; i++)
        if(parent[i] == i) numberOfairports++;

      // Print output
      for (Edge edge : output)
        cost+=edge.weight;

      cost+=(numberOfairports * airportCost);

      System.out.println("Case #" + (t + 1) + ": " + cost + " " + numberOfairports);
    }
    in.close();
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

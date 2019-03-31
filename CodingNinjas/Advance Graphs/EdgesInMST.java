import java.util.*;

/**
 * EdgesInMST
 */
public class EdgesInMST {
  static class Edge implements Comparable<Edge> {
    public int src;
    public int dest;
    public int weight;
    public String status;
    public int id;

    public Edge(int src, int dest, int weight, int id) {
      this.src = src;
      this.dest = dest;
      this.weight = weight;
      this.status = "none";
      this.id = id;
    }

    @Override
    public String toString() {
      return status;
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
      input[i] = new Edge(in.nextInt() - 1, in.nextInt() - 1, in.nextInt(), i);

    in.close();

    // Sort Edges
    Arrays.sort(input);

    // Process
    int currentWeight = input[0].weight;
    List<Edge> sameWeightedEdges = new ArrayList<>();
    for (int i = 0; i < input.length; i++) {
      Edge edge = input[i];
      if (currentWeight == edge.weight) {
        sameWeightedEdges.add(edge);
      } else {
        processEdges(sameWeightedEdges, parent, output, count, V);
        sameWeightedEdges.clear();
        currentWeight = edge.weight;
        sameWeightedEdges.add(edge);
      }
    }

    // Output
    // Sort Edges according to id.
    Arrays.sort(input, new Comparator<Edge>() {
      @Override
      public int compare(Edge o1, Edge o2) {
        return Integer.compare(o1.id, o2.id);
      }
    });
    for (Edge edge : input)
      System.out.println(edge);
  }

  private static void processEdges(List<Edge> sameWeightedEdges, int[] parent, List<Edge> output, int count, int V) {
    if (sameWeightedEdges.size() == 1) {
      Edge edge = sameWeightedEdges.get(0);
      if (!isCycleFormed(edge, parent)) {
        output.add(edge);
        count++;
        edge.status = "any";
      } else
        edge.status = "none";
      if (count == V - 1)
        return;
    } else {
      for (Edge edge : sameWeightedEdges) {
        edge.status = "at least one";
        if (!isCycleFormed(edge, parent)) {
          output.add(edge);
          count++;
        } else
          edge.status = "none";
        if (count == V - 1)
          return;
      }
    }
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

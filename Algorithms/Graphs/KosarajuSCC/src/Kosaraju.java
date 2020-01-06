package Algorithms.Graphs.KosarajuSCC.src;

public class Kosaraju {
  private int[] id;
  private boolean[] marked;
  private int count;

  public Kosaraju(Graph graph) {
    DepthFirstOrder dfs = new DepthFirstOrder(graph.getTransposedGraph());
    marked = new boolean[graph.getVertexList().size()];
    id = new int[graph.getVertexList().size()];

    for (Vertex vertex : dfs.getStack())
      if (!marked[vertex.getId()]) {
        dfs(vertex);
        count++;
      }
  }

  private void dfs(Vertex vertex) {
    marked[vertex.getId()] = true;
    id[vertex.getId()] = count;
    vertex.setComponentId(count);

    for (Vertex v : vertex.getAdjacencyList())
      if (!marked[v.getId()])
        dfs(v);
  }

  public int[] getId() {
    return id;
  }

  public void setId(int[] id) {
    this.id = id;
  }

  public boolean[] getMarked() {
    return marked;
  }

  public void setMarked(boolean[] marked) {
    this.marked = marked;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}

class GraphUsingAdjacencyMatrix {
  private int vertices;
  private boolean[][] adjMatrix;

  GraphUsingAdjacencyMatrix(int vertices) {
    this.vertices = vertices;
    adjMatrix = new boolean[vertices][vertices];
    // for(int i = 1; i <= vertices; i++) adjMatrix[i][i] = true;
  }

  public void addEdge(int src, int dest) {
    if((src >= 0 && src < vertices)
      && (dest >= 0 && dest < vertices)) {
      if (!adjMatrix[src][dest] || !adjMatrix[dest][src]) {
        adjMatrix[src][dest] = true;
        adjMatrix[dest][src] = true;
      }
    }
  }

  public void removeEdge(int src, int dest) {
    if((src >= 0 && src < vertices)
      && (dest >= 0 && dest < vertices)) {
      if (adjMatrix[src][dest] || adjMatrix[dest][src]) {
        adjMatrix[src][dest] = false;
        adjMatrix[dest][src] = false;
      }
    }
  }

  public boolean isEdge(int src, int dest) {
    if((src >= 0 && src < vertices)
      && (dest >= 0 && dest < vertices)) {
      return (adjMatrix[src][dest] || adjMatrix[dest][src]);
    }
    return false;
  }

  public void print() {
    for(int i = -1; i < vertices; i++) {
      for(int j = -1; j < vertices; j++) {
        if (i == -1 && j == -1) {
          System.out.print("  ");
          continue;
        }
        if (i == -1) {
          System.out.print(j +" ");
          continue;
        }
        if (j == -1) {
          System.out.print(i + " ");
          continue;
        }
        System.out.print(adjMatrix[i][j] ? "1 " : "0" + " ");
      }
      System.out.println();
    }
  }
  public static void main(String[] args) {
    GraphUsingAdjacencyMatrix graph = new GraphUsingAdjacencyMatrix(5);
    graph.addEdge(1, 2);
    graph.print();
  }
}
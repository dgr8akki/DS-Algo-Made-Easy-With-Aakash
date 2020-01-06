package Algorithms.Graphs.KosarajuSCC.src;

import java.util.Stack;

public class DepthFirstOrder {

  private Stack<Vertex> stack;

  public Stack<Vertex> getStack() {
    return stack;
  }

  public void setStack(Stack<Vertex> stack) {
    this.stack = stack;
  }

  public DepthFirstOrder(Graph graph) {
    stack = new Stack<>();

    for(Vertex vertex: graph.getVertexList()) {
      if(!vertex.isVisited())
        dfs(vertex);
    }
  }

  private void dfs(Vertex vertex) {
    vertex.setVisited(true);
    for (Vertex neighbour: vertex.getAdjacencyList()) {
      if(!neighbour.isVisited())
        dfs(neighbour);
    }

    stack.push(vertex);
  }
}

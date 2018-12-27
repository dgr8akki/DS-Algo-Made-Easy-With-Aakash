import java.util.ArrayList;
import java.util.List;

public class Graph {
  private List<Edge> edgeList;
  private List<Vertex> vertexList;

  public List<Edge> getEdgeList() {
    return edgeList;
  }

  public void setEdgeList(List<Edge> edgeList) {
    this.edgeList = edgeList;
  }

  public List<Vertex> getVertexList() {
    return vertexList;
  }

  public void setVertexList(List<Vertex> vertexList) {
    this.vertexList = vertexList;
  }

  public Graph(List<Edge> edgeList, List<Vertex> vertexList) {
    this.edgeList = edgeList;
    this.vertexList = vertexList;
  }

  public Graph getTransposedGraph() {
    List<Vertex> transposedVertexList = new ArrayList<>(vertexList);

    for (Edge edge: edgeList)
      transposedVertexList
        .get(transposedVertexList
              .indexOf(edge
                        .getDestinationVertex()
                      )
            )
        .addNeighbour(edge.getSourceVertex());
    return new Graph(edgeList, transposedVertexList);
  }
}

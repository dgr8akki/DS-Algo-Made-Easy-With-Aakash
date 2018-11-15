import java.util.ArrayList;

public class GraphUsingObjects {
  class Vertex {
    int data;
    ArrayList<Integer> neighbours;

    Vertex(int data) {
      this.data = data;
      neighbours = new ArrayList<>();
    }
  }
  private int verticesCount;
  private ArrayList<Vertex> vertices;

  GraphUsingObjects(int verticesCount) {
    this.verticesCount = verticesCount;
    vertices = new ArrayList<>();

    for(int i = 0; i < verticesCount; i++) {
      vertices.add(new Vertex(i));
    }
  }

  public void addEdge(int src, int dest) {
    vertices.get(src).neighbours.add(dest);
    vertices.get(dest).neighbours.add(src);
  }

  public void removeEdge(int src, int dest) {
    vertices.get(src).neighbours.remove((Object)dest);
    vertices.get(dest).neighbours.remove((Object)src);
  }

    public void print() {
    for(int index = 0; index < vertices.size(); index++) {
      for(int jindex = -1; jindex < vertices.get(index).neighbours.size(); jindex++) {
        if(jindex == -1) {
          System.out.print(index + " => ");
          continue;
        }
        if(jindex == 0) {
          System.out.print(vertices.get(index).neighbours.get(jindex));
          continue;
        }
        System.out.print(" , " + vertices.get(index).neighbours.get(jindex));
      }
      System.out.println();
    }
  }
  public static void main(String[] args) {
    GraphUsingObjects graph = new GraphUsingObjects(5);
      graph.addEdge(1, 2);
      graph.addEdge(1, 3);
      graph.addEdge(1, 4);
      graph.addEdge(3, 2);
      graph.addEdge(4, 3);
      graph.addEdge(2, 4);
      graph.removeEdge(2, 4);
      graph.print();
  }
}
import java.util.ArrayList;
import java.util.List;

public class Vertex {
  private String data;
  private boolean isVisited;
  private boolean isBeingVisited;
  private List<Vertex> neighbours;

  public List<Vertex> getNeighbours() {
    return neighbours;
  }

  public void setNeighbours(List<Vertex> neighbours) {
    this.neighbours = neighbours;
  }

  public void addNeighbour(Vertex neighbour) {
    this.neighbours.add(neighbour);
  }

  Vertex(String data) {
    this.data = data;
    isBeingVisited = false;
    isVisited = false;
    this.neighbours = new ArrayList<>();
  }

  public boolean isVisited() {
    return isVisited;
  }

  public void setVisited(boolean visited) {
    isVisited = visited;
  }

  public boolean isBeingVisited() {
    return isBeingVisited;
  }

  public void setBeingVisited(boolean beingVisited) {
    isBeingVisited = beingVisited;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return this.data;
  }
}

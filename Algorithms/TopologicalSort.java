package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class TopologicalSort {
  class Vertex {
    private String data;
    private boolean isVisited;
    private List<Vertex> neighbours;

    Vertex(String data) {
      this.data = data;
      isVisited = false;
      neighbours = new ArrayList<>();
    }

    /**
     * @return the data
     */
    public String getData() {
      return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
      this.data = data;
    }

    /**
     * @return the isVisited
     */
    public boolean isVisited() {
      return isVisited;
    }

    /**
     * @param isVisited the isVisited to set
     */
    public void setVisited(boolean isVisited) {
      this.isVisited = isVisited;
    }

    /**
     * @return the neighbours
     */
    public List<Vertex> getNeighbours() {
      return neighbours;
    }

    /**
     * @param neighbours the neighbours to set
     */
    public void setNeighbours(List<Vertex> neighbours) {
      this.neighbours = neighbours;
    }

    /**
     * @param neighbour the neighbour to set
     */
    public void setNeighbour(Vertex neighbour) {
      this.neighbours.add(neighbour);
    }

    @Override
    public String toString() {
      return this.data;
    }
  }

  public void dfs(Vertex currentVertex) {
    currentVertex.setVisited(true);
    for (Vertex adjacentVertex : currentVertex.getNeighbours())
      if (!adjacentVertex.isVisited())
        dfs(adjacentVertex);
  }
}

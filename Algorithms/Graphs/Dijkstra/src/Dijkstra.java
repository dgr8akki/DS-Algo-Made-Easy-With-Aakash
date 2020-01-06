package Algorithms.Graphs.Dijkstra.src;

import java.util.*;

public class Dijkstra {
  public void computePath(Vertex source) {
    source.setDistance(0);

    PriorityQueue<Vertex> queue = new PriorityQueue<>();

    queue.add(source);

    while (!queue.isEmpty()) {
      Vertex actualVertex = queue.poll();

      for(Edge currentEgde : actualVertex.getAdjacencyList()) {
        Vertex currentVertex = currentEgde.getDestinationVertex();

        double newDistance = actualVertex.getDistance() + currentEgde.getWeight();

        if(newDistance < currentVertex.getDistance()) {
          queue.remove(currentVertex);
          currentVertex.setDistance(newDistance);
          currentVertex.setPredecessor(actualVertex);
          queue.add(currentVertex);
        }
      }
    }
  }

  public List<Vertex> getShortestPathTo(Vertex target) {
    List<Vertex> shortestPathToTarget = new ArrayList<>();

    for (Vertex vertex = target; vertex != null; vertex = vertex.getPredecessor())
      shortestPathToTarget.add(vertex);

    Collections.reverse(shortestPathToTarget);
    return shortestPathToTarget;
  }
}

package Algorithms.BackTracking;

import java.util.Arrays;

class Graph {
  private int totalVertices;
  private int colors[];

  private Graph(int verticesCount) {
    totalVertices = verticesCount;
    colors = new int[verticesCount];
  }

  public static void main(String[] args) {
    int[][] graphMatrix = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 } };
    int colorsCount = 3;

    Graph graph = new Graph(4);
    graph.isGraphColorable(graphMatrix, colorsCount);
  }

  private boolean isGraphColorable(int[][] graph, int numberOfColors) {
    if (!graphColoringUtils(graph, numberOfColors, colors, 0)) {
      System.out.println("Solution does not exist");
      return false;
    }

    System.out.println("Color alloted are as follows:");
    System.out.println(Arrays.toString(colors));
    return true;
  }

  private boolean graphColoringUtils(int[][] graph, int numberOfColors, int[] colors, int currentVertex) {
    if (currentVertex == totalVertices)
      return true;

    for (int color = 1; color <= numberOfColors; color++) {
      if (isSafeToAllotColor(graph, colors, color, currentVertex)) {
        colors[currentVertex] = color;

        if (graphColoringUtils(graph, numberOfColors, colors, currentVertex + 1)) {
          return true;
        }
        colors[currentVertex] = 0;
      }
    }
    return false;
  }

  private boolean isSafeToAllotColor(int[][] graph, int[] colors, int currentColor, int currentVertex) {
    for (int i = 0; i < totalVertices; i++) {
      if (graph[currentVertex][i] == 1 && colors[i] == currentColor) {
        return false;
      }
    }
    return true;
  }
}

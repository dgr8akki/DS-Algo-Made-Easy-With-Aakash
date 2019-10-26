package Hackerrank.Practise;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
  static class Node {
    int vertex;
    int distance;

    Node(int v, int d) {
      this.vertex = v;
      this.distance = d;
    }
  }

  // Complete the quickestWayUp function below.
  static int quickestWayUp(int[][] ladders, int[][] snakes) {
    int[] board = new int[100];
    for (int i = 0; i < 100; i++)
      board[i] = -1;
    for (int[] ladder : ladders)
      board[ladder[0] - 1] = ladder[1] - 1;
    for (int[] ladder : snakes)
      board[ladder[0] - 1] = ladder[1] - 1;
    Queue<Node> q = new LinkedList<>();
    boolean[] visited = new boolean[100];
    visited[0] = true;
    q.add(new Node(0, 0));

    Node current = new Node(0, 0);
    while (!q.isEmpty()) {
      current = q.remove();

      if (current.vertex == 99)
        break;

      for (int i = current.vertex + 1; (i <= current.vertex + 6) && i < 100; i++) {
        if (!visited[i]) {
          Node temp = new Node(i, current.distance + 1);

          if (board[i] != -1)
            temp.vertex = board[i];
          visited[i] = true;
          q.add(temp);
        }
      }
    }
    if (current.vertex == 99)
      return current.distance;
    return -1;
  }

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int t = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int tItr = 0; tItr < t; tItr++) {
      int n = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[][] ladders = new int[n][2];

      for (int i = 0; i < n; i++) {
        String[] laddersRowItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int j = 0; j < 2; j++) {
          int laddersItem = Integer.parseInt(laddersRowItems[j]);
          ladders[i][j] = laddersItem;
        }
      }

      int m = scanner.nextInt();
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      int[][] snakes = new int[m][2];

      for (int i = 0; i < m; i++) {
        String[] snakesRowItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int j = 0; j < 2; j++) {
          int snakesItem = Integer.parseInt(snakesRowItems[j]);
          snakes[i][j] = snakesItem;
        }
      }

      int result = quickestWayUp(ladders, snakes);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();
    }

    bufferedWriter.close();

    scanner.close();
  }
}

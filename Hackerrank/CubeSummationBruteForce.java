import java.io.*;
import java.util.*;

class Solution {

  static void query (int[][][] mat, int x1, int y1, int z1, int x2, int y2, int z2) {
    int sum = 0;
    for(int i = x1; i <= x2; i++)
      for (int j = y1; j <= y2; j++)
        for (int k = z1; k <= z2; k++)
          sum += mat[i][j][k];
    System.out.println(sum);
  }

  static void update(int[][][] mat, int x, int y, int z, int w) {
    mat[x][y][z] = w;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();

    for(int i = 0; i < T; i++) {
      int N = scanner.nextInt();
      int M = scanner.nextInt();
      int arr[][][] = new int[N + 1][N + 1][N + 1];

      for (int j = 0; j < M; j++) {
        String type = scanner.next();

        if( type.equals("UPDATE")) {
          int x = scanner.nextInt();
          int y = scanner.nextInt();
          int z = scanner.nextInt();
          int w = scanner.nextInt();
          update(arr,x,y,z,w);
        } else {
          int x1 = scanner.nextInt();
          int y1 = scanner.nextInt();
          int z1 = scanner.nextInt();
          int x2 = scanner.nextInt();
          int y2 = scanner.nextInt();
          int z2 = scanner.nextInt();
          query(arr,x1,y1,z1,x2,y2,z2);
        }
      }
    }

    scanner.close();
  }
}

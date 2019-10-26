package CodingNinjas.DynamicProgrammingOne;

import java.util.Scanner;

/**
 * AlyonaAndSpreadSheet
 */
public class AlyonaAndSpreadSheet {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int r = in.nextInt();
    int c = in.nextInt();
    int[][] arr = new int[r][c];
    int[][] dp = new int[r][c];
    for(int i = 0; i < r; i++)
      for(int j = 0; j < c; j++)
        arr[i][j] = in.nextInt();
    for(int i = 1; i < r; i++)
      for(int j = 0; j < c; j++)
        dp[i][j] = arr[i - 1][j] <= arr[i][j] ? dp[i - 1][j] : i;

    int queries = in.nextInt();
    while(queries-- > 0) {
      int s = in.nextInt() - 1;
      int e = in.nextInt() - 1;
      for(int col = 0; col < c; col++) {
        if(dp[e][col] <= s) {
          System.out.println("Yes");
          break;
        }
      }
      System.out.println("No");
    }


    in.close();
  }
}
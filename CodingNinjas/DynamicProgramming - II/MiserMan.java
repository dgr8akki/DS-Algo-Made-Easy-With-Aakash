import java.util.Scanner;

/**
 * MiserMan
 */
public class MiserMan {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int[][] input = new int[n][m];
    for(int i = 0 ; i < n; i++)
      for(int j = 0; j < m; j++)
        input[i][j] = in.nextInt();
    in.close();
    System.out.println(solve(input, n, m));
  }

  private static int solve(int[][] input, int n, int m) {
    int[][] dp = new int[n + 1][m + 1];
    return dp[n][m];
  }
}

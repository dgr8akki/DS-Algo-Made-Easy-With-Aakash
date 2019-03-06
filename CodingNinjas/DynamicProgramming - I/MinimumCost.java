/**
 * MinimumCost
 *
 * Reach from (0,0) to (m-1,n-1) in m x n matrix with min cost.
 */
public class MinimumCost {
  public static long getMinCost(int[][] arr) {
    int m = arr.length;
    int n = arr[0].length;
    // long[][] store = new long[m][n];
    // return getMinCostRecursive(arr, 0, 0, m - 1, n - 1);
    // return getMinCostMemoized(arr, 0, 0, m - 1, n - 1,store);
    return getMinCostIterative(arr, m, n);
  }

  public static long getMinCostRecursive(int[][] arr, int startingX, int startingY, int endingX, int endingY) {
    if(startingX == endingX && startingY == endingY)
      return arr[endingX][endingY];
    if(startingX > endingX || startingY > endingY)
      return Long.MAX_VALUE;
    return arr[startingX][startingY]
    + Math.min(
        getMinCostRecursive(arr, startingX + 1, startingY, endingX, endingY),
        Math.min(
          getMinCostRecursive(arr, startingX + 1, startingY + 1, endingX, endingY),
          getMinCostRecursive(arr, startingX, startingY + 1, endingX, endingY)
        )
      );
  }

  public static long getMinCostIterative(int[][] arr, int m, int n) {
    long[][] dp = new long[m][n];
    dp[m - 1][ n - 1] = arr[m - 1][n - 1];

    for(int i = m - 2; i >= 0; i--) {
      dp[i][n - 1] = arr[i][n - 1] + dp[i + 1][n - 1];
    }

    for(int j = n - 2; j >= 0; j--) {
      dp[m - 1][j] = arr[m - 1][j] + dp[m - 1][j + 1];
    }

    for(int i = m - 2; i >= 0; i--) {
      for(int j = n - 2; j >= 0; j--) {
        dp[i][j] = arr[i][j] + Math.min(dp[i + 1][j], Math.min(dp[i + 1][j + 1], dp[i][j + 1]));
      }
    }

    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++)
        System.out.print(dp[i][j] + " ");
      System.out.println();
      }

    return dp[0][0];
  }

  public static long getMinCostMemoized(int[][] arr, int startingX, int startingY, int endingX, int endingY, long[][] store) {
    if(startingX == endingX && startingY == endingY) {
      store[startingX][startingY] = arr[endingX][endingY];
      return store[startingX][startingY];
    }
    if(startingX > endingX || startingY > endingY)
      return Long.MAX_VALUE;
    store[startingX][startingY] = arr[startingX][startingY]
      + Math.min(
        getMinCostMemoized(arr, startingX + 1, startingY, endingX, endingY, store),
        Math.min(
          getMinCostMemoized(arr, startingX + 1, startingY + 1, endingX, endingY, store),
          getMinCostMemoized(arr, startingX, startingY + 1, endingX, endingY, store)
        )
      );
    return store[startingX][startingY];
  }

  public static void main(String[] args) {
    int[][] arr = {
      {4,3,2},
      {1,8,9},
      {1,1,8}
    };

    System.out.println(getMinCost(arr));
  }
}
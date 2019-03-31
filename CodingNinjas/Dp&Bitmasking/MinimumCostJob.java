import java.util.Arrays;

/**
 * MinimumCostJob
 */
public class MinimumCostJob {

  public static void main(String[] args) {
    int[][] cost = {
      {10, 2, 6, 5},
      {1, 15, 12, 8},
      {7, 8, 9, 3},
      {15, 13, 4, 10}
    };

    System.out.println(minCost(cost));
  }

  private static int minCost(int[][] cost) {
    int n = cost.length;
    int mask = 0;
    int currentJobIdx = 0;
    System.out.println(minCostRecursive(cost, n, currentJobIdx, mask));
    int[] dp = new int[(1 << n) - 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    System.out.println( minCostMemoized(cost, n, currentJobIdx, mask, dp));
    return minCostIterative(cost, n);
  }

  private static int minCostIterative(int[][] cost, int n) {
    int[] dp = new int[(1 << n)];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for(int mask = 0; mask < ((1 << n) - 1); mask++) {
      int temp = mask;
      int maskSetBitCount = 0;
      while(temp > 0) {
        if(temp % 2 == 1) maskSetBitCount++;
        temp /= 2;
      }

      for(int i = 0; i < n; i++) {
        if((mask & (1 << i)) == 0) {
          dp[mask | (1 << i)] = Math.min(dp[mask | (1 << i)], dp[mask] + cost[maskSetBitCount][i]);
        }
      }
    }
    return dp[(1 << n) - 1];
  }

  private static int minCostMemoized(int[][] cost, int n, int currentJobIdx, int mask, int[] dp) {
    if(currentJobIdx >= n)
      return 0;

    if(dp[mask] != Integer.MAX_VALUE) return dp[mask];
    int min = Integer.MAX_VALUE;
    for(int i = 0; i < n; i++) {
      if((mask & (1 << i)) == 0) {
        int ans = minCostMemoized(cost, n, currentJobIdx + 1, mask | (1 << i), dp) + cost[currentJobIdx][i];
        min = Math.min(min, ans);
      }
    }
    return dp[mask] = min;
  }

  private static int minCostRecursive(int[][] cost, int n, int currentJobIdx, int mask) {
    if(currentJobIdx >= n)
      return 0;

    int min = Integer.MAX_VALUE;
    for(int i = 0; i < n; i++) {
      if((mask & (1 << i)) == 0) {
        int ans = minCostRecursive(cost, n, currentJobIdx + 1, mask | (1 << i)) + cost[currentJobIdx][i];
        min = Math.min(min, ans);
      }
    }
    return min;
  }
}

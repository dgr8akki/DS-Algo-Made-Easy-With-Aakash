/**
 * KnapSack
 */
public class KnapSack {

  public static int knapsack(int[] weight, int value[], int maxWeight) {
    // return knapsackRecursive(weight, value, maxWeight, 0);
    // int[][] dp = new int[weight.length + 1][maxWeight + 1];
    // return knapsackMemoized(weight, value, maxWeight, 0, dp);
    return knapSackIterative(weight, value, maxWeight);
  }

  private static int knapsackRecursive(int[] weight, int value[], int maxWeight, int currentItemIdx) {
    if (currentItemIdx >= value.length)
      return 0;
    int option1 = knapsackRecursive(weight, value, maxWeight, currentItemIdx + 1);
    int option2 = Integer.MIN_VALUE;
    if (maxWeight - weight[currentItemIdx] >= 0)
      option2 = value[currentItemIdx]
          + knapsackRecursive(weight, value, maxWeight - weight[currentItemIdx], currentItemIdx + 1);
    return Math.max(option1, option2);
  }

  private static int knapsackMemoized(int[] weight, int value[], int maxWeight, int currentItemIdx, int[][] dp) {
    if (currentItemIdx >= value.length || maxWeight == 0)
      return 0;
    if (dp[currentItemIdx][maxWeight] > 0)
      return dp[currentItemIdx][maxWeight];
    int option1 = knapsackMemoized(weight, value, maxWeight, currentItemIdx + 1, dp);
    if (maxWeight - weight[currentItemIdx] >= 0) {
      int option2 = value[currentItemIdx]
          + knapsackMemoized(weight, value, maxWeight - weight[currentItemIdx], currentItemIdx + 1, dp);
      dp[currentItemIdx][maxWeight] = Math.max(option1, option2);
    } else {
      dp[currentItemIdx][maxWeight] = option1;
    }

    return dp[currentItemIdx][maxWeight];
  }

  private static int knapSackIterative(int[] weight, int value[], int maxWeight) {
    int[] dp = new int[maxWeight + 1];
    for (int i = 0; i < value.length; i++)
      for (int j = maxWeight; j >= weight[i]; j--)
        dp[j] = Math.max(dp[j], value[i] + dp[j - weight[i]]);
    return dp[maxWeight];
  }

  public static void main(String[] args) {
    int[] w = { 1, 2, 4, 5 };
    int[] val = { 5, 4, 8, 6 };
    int cap = 5;
    System.out.println(knapsack(w, val, cap));
  }
}

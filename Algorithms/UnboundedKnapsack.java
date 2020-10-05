package Algorithms;

public class UnboundedKnapsack {
  public static int solve(int[] weights, int[] values, int capacity) {
    int[] result = new int[capacity + 1];

    for (int i = 0; i <= capacity; i++)
      for (int j = 0; j < weights.length; j++)
        if (weights[j] <= i)
          result[i] = Math.max(result[i], result[i - weights[j]] + values[j]);
    return result[capacity];
  }

  public static void main(String[] args) {
    int W = 10;
    int val[] = { 2, 3, 4 };
    int wt[] = { 4, 5, 6 };
    System.out.println(solve(wt, val, W));
  }
}

public class MinimumNumberOfChocolates {

  public static int getMin(int arr[], int N) {
    int[] dp = new int[N];
    dp[0] = 1;
    for (int i = 1; i < N; i++) {
      if (arr[i - 1] < arr[i]) {
        dp[i] = dp[i - 1] + 1;
      } else {
        dp[i] = 1;
      }
    }

    int sum = dp[N - 1];
    for (int i = N - 2; i >= 0; i--) {
      if (arr[i] > arr[i + 1] && dp[i] <= dp[i + 1]) {
        dp[i] = dp[i + 1] + 1;
      }
      sum += dp[i];
    }

    return sum;
  }
}

package CodingNinjas.DynamicProgrammingOne;

/**
 * CountBST
 */

public class CountBST {
  final static int M = 1_000_000_000 + 7;

  public static int countTrees(int n) {
    // return countTreesRecursive(n);
    long[] arr = new long[n + 1];
    countTreesMemoized(n, arr);
    return countTreesIterative(n);
  }

  private static long countTreesMemoized(int n, long[] arr) {
    if (n == 0 || n == 1)
      return 1;
    if (n == 2)
      return 2;
    if (arr[n] > 0)
      return arr[n];
    int count = 0;
    for (int i = 1; i <= n; i++) {
      int leftBST = countTreesRecursive(i - 1);
      int rightBST = countTreesRecursive(n - i);
      count += (leftBST * rightBST);
    }
    arr[n] = count;
    return arr[n];
  }

  private static int countTreesRecursive(int n) {
    if (n == 0 || n == 1)
      return 1;
    if (n == 2)
      return 2;
    int count = 0;
    for (int i = 1; i <= n; i++) {
      int leftBST = countTreesRecursive(i - 1);
      int rightBST = countTreesRecursive(n - i);
      count += (leftBST * rightBST);
    }
    return count;
  }

  public static int countTreesIterative(int n) {
    if (n == 0 || n == 1)
      return 1;
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
      for (int k = 1; k <= i; k++) {
        dp[i] = ((dp[i] % M) + ((dp[i - k]) % M * (dp[k - 1]) % M) % M) % M;
      }
    }
    return dp[n];
  }

  public static void main(String[] args) {
    int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
    for (int n : arr)
      System.out.println("Total BSTs with nodes: " + n + " will be: " + countTrees(n));
  }
}
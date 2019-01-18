import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        arr[i][j] = in.nextInt();

    System.out.println(solve(arr, n));
  }

  private static int solve(int[][] arr, int n) {
    int sum = 0;
    // Adding first row's elements
    for (int i = 1; i < n - 1; i++)
      sum += arr[0][i];

    // Adding last row's elements
    for (int i = 1; i < n - 1; i++)
      sum += arr[n - 1][i];

    // Adding first column
    for (int i = 1; i < n - 1; i++)
      sum += arr[i][0];

    // Adding last column
    for (int i = 1; i < n - 1; i++)
      sum += arr[i][n - 1];

    // Adding first diag
    for (int i = 0; i < n; i++)
      sum += arr[i][i];

    // Adding second diag
    for (int i = 0; i < n; i++)
      sum += arr[i][(n - 1) - i];

    // Removing duplicates
    if (n % 2 != 0)
      sum -= arr[n / 2][n / 2];

    return sum;
  }
}

import java.util.*;

/**
 * GhostType
 */
public class GhostType {
  static long solve(int n, List<List<Integer>> submask) {
    int currentRowIdx = 0;
    int mask = 0;
    long[] dp = new long[(1 << 22)];
    Arrays.fill(dp, -1);
    // return ghostTypeCountRecursive(n, currentRowIdx, mask, submask);
    return ghostTypeCountMemoized(n, currentRowIdx, mask, submask, dp);
  }

  private static long ghostTypeCountMemoized(int n, int currentRowIdx, int mask, List<List<Integer>> submask, long[] dp) {
    if (mask == ((1 << n) - 1))
      return 1;
    if(dp[mask] != -1) return dp[mask];
    long count = 0;
    int x = 0;
    for (int i = 1; i <= n; i++) {
      // Check if any bit is already set. If unset, then do work.
      if ((mask & (1 << i)) == 0) {
        boolean ok = true;

        for (int j = 0; j < submask.get(i).size(); j++) {
          x = submask.get(i).get(j);
          if ((mask & (1 << x)) == 0)
            ok = false;
        }
        if (ok) {
          count += ghostTypeCountMemoized(n, currentRowIdx, mask | (1 << i), submask, dp);
        }
      }
    }
    return dp[mask] = count;
  }

  private static long ghostTypeCountRecursive(int n, int currentRowIdx, int mask, List<List<Integer>> submask) {
    if (mask == ((1 << n) - 1))
      return 1;
    long count = 0;
    int x = 0;
    for (int i = 1; i <= n; i++) {
      // Check if any bit is already set. If unset, then do work.
      if ((mask & (1 << i)) == 0) {
        boolean ok = true;

        for (int j = 0; j < submask.get(i).size(); j++) {
          x = submask.get(i).get(j);
          if ((mask & (1 << x)) == 0)
            ok = false;
        }
        if (ok) {
          count += ghostTypeCountRecursive(n, currentRowIdx, mask | (1 << i), submask);
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.close();
    List<List<Integer>> submask = new ArrayList<>();
    for (int i = 0; i < 22; i++)
      submask.add(new ArrayList<>());
    for (int i = 1; i <= 20; i++) {
      for (int j = i - 1; j >= 1; j--) {
        if ((i & j) == j)
          submask.get(i).add(j);
      }
    }
    System.out.println(solve(n, submask));
  }
}

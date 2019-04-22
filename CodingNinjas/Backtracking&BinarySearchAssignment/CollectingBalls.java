import java.util.Scanner;

public class CollectingBalls {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    long n = in.nextLong();
    in.close();
    System.out.println(solve(n, 1, n - 1));
  }

  private static long solve(long n, long start, long end) {
    long solution = 1;
    while (start <= end) {
      long mid = start + (end - start) / 2;
      if (!isSolvable(n, mid)) {
        start = mid + 1;
      }
      else {
        end = mid - 1;
        solution = mid;
      }
    }
    return solution;
  }

  private static boolean isSolvable(long n, long k) {
    long sum = 0, current = n;
    while (current > 0) {
      sum += Math.min(k, current);
      current -= k;
      current -= current / 10;
    }
    return (2 * sum) >= n;
  }
}

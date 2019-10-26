package CodingNinjas.SearchingAndSortingApplications;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int i = 0; i < t; i++) {
      int n = in.nextInt();
      int c = in.nextInt();
      long[] stalls = new long[n];

      for (int j = 0; j < n; j++) {
        stalls[j] = in.nextLong();
      }

      System.out.println(solve(stalls, n, c));
    }
    in.close();
  }

  private static long solve(long[] stalls, int n, int c) {
    Arrays.sort(stalls);
    return solve(stalls, n, c, 0, stalls[n - 1] - stalls[0]);
  }

  private static long solve(long[] arr, int n, int c, long min, long max) {
    long maxValidDistance = -1;
    while (min <= max) {
      long mid = min + (max - min) / 2;
      if (isSolvable(arr, n, mid, c)) {
        maxValidDistance = mid;
        min = mid + 1;
      } else {
        max = mid - 1;
      }
    }
    return maxValidDistance;
  }

  private static boolean isSolvable(long[] arr, int n, long d, int c) {
    int count = 1;
    long lastPos = arr[0];

    for (int i = 1; i < n; i++) {
      if (arr[i] - lastPos >= d) {
        lastPos = arr[i];
        count++;
      }

      if (count == c) {
        return true;
      }
    }
    return false;
  }
}

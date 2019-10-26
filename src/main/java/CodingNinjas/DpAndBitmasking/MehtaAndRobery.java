package CodingNinjas.DpAndBitmasking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MehtaAndRobery {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int w = in.nextInt();
    List<Item> items = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      items.add(new Item(in.nextLong(), in.nextLong()));
    }
    in.close();
    Collections.sort(items);

    System.out.println(solve(n, items, w));
  }

  private static long solve(int n, List<Item> items, int capacity) {
    long[][][] dp = new long[2][n + 1][capacity + 1];
    short[] primes = new short[] { 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= capacity; j++) {
        dp[0][i][j] = dp[0][i - 1][j];
        if (j >= items.get(i - 1).w) {
          dp[0][i][j] = Math.max(dp[0][i][j], dp[0][i - 1][j - (int) items.get(i - 1).w] + items.get(i - 1).p);
        }
      }
    }

    for (int prime = 1; prime <= 10; prime++) {
      int p = prime % 2;
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= capacity; j++) {
          dp[p][i][j] = dp[p][i - 1][j];
          if (j >= items.get(i - 1).w) {
            dp[p][i][j] = Math.max(dp[p][i][j], Math.max(dp[p][i - 1][j - (int) items.get(i - 1).w] + items.get(i - 1).p,
              dp[p ^ 1][i - 1][j - (int) items.get(i - 1).w] + items.get(i - 1).p * primes[prime]));
          }
        }
      }
    }

    return dp[0][n][capacity];
  }

  static class Item implements Comparable<Item> {
    long p;
    long w;

    Item(long p, long w) {
      this.p = p;
      this.w = w;
    }

    @Override
    public int compareTo(Item o) {
      return Long.compare(p, o.p);
    }
  }
}

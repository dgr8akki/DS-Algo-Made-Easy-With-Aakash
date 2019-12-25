package CodingNinjas.FenwickTree;

import java.util.*;

/**
 * ShilAndWave
 */
public class ShilAndWave {
  static long fenAsc[];
  static long fenDesc[];
  static long mod = 1_000_000_000 + 7;

  public static void main(String args[]) throws Exception {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int ar[] = new int[n];
    for (int i = 0; i < n; i++)
      ar[i] = in.nextInt();
    in.close();
    fenAsc = new long[100000 + 1];
    fenDesc = new long[100000 + 1];
    long ans = 0;
    for (int i = n - 1; i >= 0; i--) {
      long val1 = query(fenAsc, 100000) - query(fenAsc, ar[i]);
      long val2 = query(fenDesc, ar[i] - 1);
      if (val1 < 0)
        val1 += mod;
      if (val2 < 0)
        val2 += mod;
      update(fenDesc, ar[i], val1 + 1);
      update(fenAsc, ar[i], val2 + 1);
      ans = ans + val1 + val2;
      if (ans < 0)
        ans += mod;
      ans = ans % mod;
    }
    System.out.println(ans);
  }

  static void update(long fen[], int idx, long val) {
    for (; idx < 100001; idx = idx + (idx & -idx)) {
      fen[idx] += val;
      fen[idx] = fen[idx] % mod;
    }
  }

  static long query(long fen[], int idx) {
    long ans = 0;
    for (; idx > 0; idx = idx - (idx & -idx)) {
      ans += fen[idx];
      ans = ans % mod;
    }
    return ans;
  }
}

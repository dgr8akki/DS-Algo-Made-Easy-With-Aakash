import java.util.Scanner;

/**
 * INCSEQ
 */
public class INCSEQ {
  static final int MAX = 100000;
  static final int MOD = 5000000;

  static int[][] BIT = new int[51][MAX];

  private static int value(int[] B, int index) {
    int res = 0;
    for (; index >= 0; index = (index & (index + 1)) - 1) {
      res += B[index];
      if (res >= MOD)
        res -= MOD;
    }
    return res;
  }

  private static void update(int[] B, int index, int value) {
    for (; index < MAX; index |= index + 1) {
      B[index] += value;
      if (B[index] >= MOD)
        B[index] -= MOD;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    while (n-- > 0) {
      int x = in.nextInt();
      update(BIT[1], x, 1);
      for (int i = 2; i <= k; i++) {
        update(BIT[i], x, value(BIT[i - 1], x - 1));
      }
    }
    in.close();
    System.out.println(value(BIT[k], 99999));
  }
}

import java.util.Scanner;

/**
 * AdjacentBitCounts
 */
public class AdjacentBitCounts {
  int M = 1_000_000_000 + 7;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int dataSetCount = in.nextInt();
    while(dataSetCount-- > 0) {
      int dataSetNumber = in.nextInt();
      int n = in.nextInt();
      int k = in.nextInt();
      System.out.println(dataSetNumber + " " + solve(n, k));
    }
    in.close();
  }

  private static long solve(int n, int k) {
    long result = bitCountUtil(n, k, false) + bitCountUtil(n, k, true);
    return result;
  }

  private static long bitCountUtil(int n, int k, boolean isFirstBitSet) {
    if(k < 0)
      return 0;
    if(n == 1) {
      if(k == 0) return 1;
      return 0;
    }
    if(isFirstBitSet)
      return bitCountUtil(n - 1, k - 1, true) + bitCountUtil(n - 1, k, false);
    return bitCountUtil(n - 1, k, true) + bitCountUtil(n - 1, k, false);
  }
}

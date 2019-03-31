import java.util.Arrays;
import java.util.Scanner;

public class Dilemma {
  public static int minimumTouchRequired(int n, String[] input) {
    int[][] dp = new int[input[0].length()][(1 << (n+1))];
    for(int i  = 0; i < input[0].length(); i++)
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    return minimumTouchRequiredUtil(n, input, input[0].length() - 1, (1 << n) - 1, dp);
  }

  private static boolean isPowerOfTwo(int n) {
    return (n & (n - 1) ) == 0;
  }

  private static int minimumTouchRequiredUtil(int n, String[] input, int currentIdx, int mask, int[][] dp) {
    if (isPowerOfTwo(mask))
      return 0;
    if (currentIdx < 0)
      return 10000;
    if(dp[currentIdx][mask] != Integer.MAX_VALUE) return dp[currentIdx][mask];

    int subMask1 = 0;
    int subMask2 = 0;
    int currentTouches = 0;

    for(int i = 0; i < input.length; i++)
      if((mask & (1 << i)) != 0) {
        currentTouches++;
        if(input[i].charAt(currentIdx) == '0')
          subMask1 |= (1 << i);
        else
          subMask2 |= (1 << i);
      }

    int option1 = minimumTouchRequiredUtil(n, input, currentIdx - 1, subMask1, dp);
    int option2 = minimumTouchRequiredUtil(n, input, currentIdx - 1, subMask2, dp);

    // Not touching at all.
    int option3 = minimumTouchRequiredUtil(n, input, currentIdx - 1, mask, dp);

    return dp[currentIdx][mask] = Math.min(option1 + option2 + currentTouches, option3);
  }


  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String[] inp = new String[n];
    for(int i = 0; i < n; i++)
      inp[i] = in.next();

    System.out.println(minimumTouchRequired(n, inp));
    in.close();
  }
}
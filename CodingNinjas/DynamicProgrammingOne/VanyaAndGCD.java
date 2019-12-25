package CodingNinjas.DynamicProgrammingOne;

import java.util.Scanner;

/**
 * VanyaAndGCD
 */
public class VanyaAndGCD {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] input = new int[n];
    for (int i = 0; i < n; i++)
      input[i] = in.nextInt();
    in.close();
    int[][] dp = new int[n][101];
    for (int i = 0; i < 101; i++)
      if(i == input[0])
        dp[0][i] = 1;
    for (int i = 1; i < n; i++) {
      for (int k = i; k >= 0; k--) {
        if (input[k] < input[i]) {
          for (int g = 1; g <= 100; g++) {
            int newGCD = getGCD(input[i], g);
            dp[i][newGCD] += dp[k][g];
          }
        }
      }
    }
    int count = 0;
    for (int i = 0; i < n; i++) {
      count += dp[i][1];
    }

    System.out.println(count);
  }

  private static int getGCD(int a, int b) {
    // if(a < b) return getGCD(b, a);
    if (b == 0) return a;
    return getGCD(b, a % b);
  }
}
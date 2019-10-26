package CodingNinjas.DynamicProgrammingOne;

import java.util.Scanner;

/**
 * Boredom
 *
 * Gary is bored and wants to play an interesting but tough game . So he figured
 * out a new board game called "destroy the neighbours" . In this game there are
 * N integers on a board. In one move, he can pick any integer x from the board
 * and then all the integers with value x+1 or x-1 gets destroyed. This move
 * will give him x points. He plays the game until the board becomes empty. But
 * as he want show this game to his friend Steven, he wants to learn techniques
 * to maximise the points to show off. Can you help Gary in finding out the
 * maximum points he receive grab from the game?
 *
 */
public class Boredom {
  public static int solve(int n, int A[]) {
    int max = Integer.MIN_VALUE;
    for (int el : A)
      max = Math.max(el, max);
    int[] freq = new int[max + 1];
    for (int el : A)
      freq[el]++;
    int[] dp = new int[max + 1];
    dp[0] = 0;
    dp[1] = freq[1];
    for (int i = 2; i < freq.length; i++) {
      dp[i] = Math.max(i * freq[i] + dp[i - 2], dp[i - 1]);
    }
    for (int el : dp)
      max = Math.max(el, max);
    return max;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = in.nextInt();
    System.out.println(solve(n, arr));
    in.close();
  }
}

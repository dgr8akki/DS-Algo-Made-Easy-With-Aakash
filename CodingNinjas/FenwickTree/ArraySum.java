package CodingNinjas.FenwickTree;

import java.util.Scanner;

/**
 * ArraySum
 */
public class ArraySum {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n + 1];
    int[] BIT = new int[n + 1];

    for (int i = 1; i <= n; i++) {
      arr[i] = in.nextInt();
      update(i, arr[i], BIT, n);
    }

    System.out.println("Sum of first 4 elements: " + query(4, BIT));
    in.close();
  }

  private static int query(int index, int[] BIT) {
    int sum = 0;
    for (; index > 0; index -= (index & -index))
      sum += BIT[index];
    return sum;
  }

  private static void update(int index, int value, int[] BIT, int n) {
    for (; index <= n; index += (index & -index))
      BIT[index] += value;
  }
}

import java.util.*;

public class TwoDimensionalArrays {
  static int[][] A;

  public static void main(String[] args) {
    A = new int[6][6];
    int max = Integer.MIN_VALUE;
    int sum = 0;
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < 6; i++)
      for (int j = 0; j < 6; j++)
        A[i][j] = sc.nextInt();
    for (int i = 1; i < 5; i++)
      for (int j = 1; j < 5; j++) {
        sum = getHourGlassSum(i, j);
        if (max < sum)
          max = sum;
      }
    System.out.print(max);
  }

  public static int getHourGlassSum(int i, int j) {
    return A[i - 1][j - 1] + A[i - 1][j] + A[i - 1][j + 1] + A[i][j] + A[i + 1][j - 1] + A[i + 1][j] + A[i + 1][j + 1];
  }
}

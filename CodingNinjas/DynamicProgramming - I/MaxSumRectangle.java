import java.util.Scanner;

/**
 * MaxSumRectangle
 */
public class MaxSumRectangle {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int m = in.nextInt();
    int n = in.nextInt();
    int[][] rect = new int[m][n];
    for(int i = 0; i < m; i++)
      for(int j = 0; j < n; j++)
        rect[i][j] = in.nextInt();
    System.out.println(getMaxSum(rect, m, n));
    in.close();
  }

  private static int getMaxSum(int[][] rect, int m, int n) {
    int currentLeft = 0, currentRight = 0, maxSum = Integer.MIN_VALUE;
    while(currentLeft < n) {
      int[] row = new int[n];
      currentRight = currentLeft;
      while(currentRight < n) {
        for(int i = 0; i < m; i++)
          row[i] += rect[i][currentRight];
        maxSum = Math.max(maxSum, maxSumSubArray(row));
        currentRight++;
      }
      currentLeft++;
    }
    return maxSum;
  }

  private static int maxSumSubArray (int[] arr) {
    int maxSumGlobal = Integer.MIN_VALUE, localSum = 0, maxNegative = Integer.MIN_VALUE;
    boolean isAllNegtive = true;
    for(int element: arr) {
      if(element < 0 && isAllNegtive) {
        maxNegative = Math.max(maxNegative, element);
      }
      if(element >= 0) isAllNegtive = false;
      localSum += element;
      maxSumGlobal = Math.max(maxSumGlobal, localSum);
      if(localSum < 0) localSum = 0;
    }
    if(isAllNegtive) return maxNegative;
    return maxSumGlobal;
  }
}

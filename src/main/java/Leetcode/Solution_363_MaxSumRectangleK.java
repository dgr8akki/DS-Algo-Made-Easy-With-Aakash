package Leetcode;

public class Solution {
  public int maxSumSubmatrix(int[][] matrix, int k) {
    int row = matrix.length;
    int col = matrix[0].length;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < row; i++) {
      int[] colSum = new int[col];
      for (int j = i; j < row; j++) {
        for (int c = 0; c < col; c++) {
          colSum[c] += matrix[j][c];
        }
        max = Math.max(max, findMax(colSum, k));
      }
    }
    return max;
  }

  private int findMax(int[] nums, int k) {
    int max = Integer.MIN_VALUE;
    int sum = 0;
    TreeSet<Integer> s = new TreeSet();
    s.add(0);

    for (int i = 0; i < nums.length; i++) {
      int t = sum + nums[i];
      sum = t;
      Integer gap = s.ceiling(sum - k);
      if (gap != null)
        max = Math.max(max, sum - gap);
      s.add(t);
    }

    return max;
  }
}

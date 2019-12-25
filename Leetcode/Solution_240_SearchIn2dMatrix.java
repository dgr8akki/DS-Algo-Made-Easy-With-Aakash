package Leetcode;

public class Solution_240_SearchIn2dMatrix {
  public static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
      return false;
    }
    int col = matrix[0].length - 1;
    int row = 0;
    while (col >= 0 && row <= matrix.length - 1) {
      if (target == matrix[row][col]) {
        return true;
      } else if (target < matrix[row][col]) {
        col--;
      } else if (target > matrix[row][col]) {
        row++;
      }
    }
    return false;
  }
}

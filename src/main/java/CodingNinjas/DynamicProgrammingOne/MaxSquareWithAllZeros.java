package CodingNinjas.DynamicProgrammingOne;

public class MaxSquareWithAllZeros {

	public static int findMaxSquareWithAllZeros(int[][] input) {
      int m = input.length;
      int n = input[0].length;
      int[][] dp = new int[m][n];
      int max = Integer.MIN_VALUE;
      //Fill first row and col with 0 or 1 as compared to original array;
      for(int row = 0; row < m; row++) {
        dp[row][0] = (input[row][0] == 0) ? 1 : 0;
      }
      for(int c = 0; c < n; c++) {
        dp[0][c] = (input[0][c] == 0) ? 1 : 0;
      }

      for(int i = 1; i < m; i++) {
        for(int j = 1; j < n; j++) {
          if(input[i][j] == 0) {
          	dp[i][j] = 1 + (Math.min(dp[i - 1][j -1], Math.min(dp[i - 1][j], dp[i][j -1])));
          } else {
            dp[i][j] = 0;
          }
        }
      }

      for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
          if (dp[i][j] > max) {
            max = dp[i][j];
          }
        }
      }

      return max;
	}
}
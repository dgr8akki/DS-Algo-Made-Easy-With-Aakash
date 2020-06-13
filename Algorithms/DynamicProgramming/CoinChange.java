package Algorithms.DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
  private int[] denomenations;
  private int totalDenomenations;
  private int totalValue;
  private int[][] solution;

  public CoinChange(int[] denomenations, int totalValue) {
    this.totalValue = totalValue;
    this.denomenations = denomenations;
    this.totalDenomenations = denomenations.length;
    this.solution = new int[totalDenomenations + 1][totalValue + 1];
  }

  public void solve() {
    for (int i = 0; i <= totalDenomenations; i++)
      solution[i][0] = 1;
    for (int i = 1; i <= totalDenomenations; i++)
      for (int j = 1; j < totalValue + 1; j++) {
        int notToIncludeCurrentCoin = solution[i - 1][j];
        int mustIncludeCurrentCoin = 0;
        if (denomenations[i - 1] <= j)
          mustIncludeCurrentCoin = solution[i][j - denomenations[i - 1]];

        solution[i][j] = notToIncludeCurrentCoin + mustIncludeCurrentCoin;
      }

    System.out.println("In " + solution[totalDenomenations][totalValue] + " different ways.");

    // for(int i = 0; i < totalDenomenations + 1; i++) {
    // for(int j = 0; j < totalValue + 1; j++)
    // System.out.print((solution[i][j] > 9 ? solution[i][j] : (" " +
    // solution[i][j]))+ " ");
    // System.out.println();
    // }
  }

  public static void main(String[] args) {
    int[] denomenations = { 1, 2, 3 };
    int totalValue = 100;
    CoinChange coinChange = new CoinChange(denomenations, totalValue);
    coinChange.solve();
  }
}

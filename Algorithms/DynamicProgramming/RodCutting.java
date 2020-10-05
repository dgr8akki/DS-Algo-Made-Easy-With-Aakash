package Algorithms.DynamicProgramming;

public class RodCutting {
  private int[] values;
  private int totalValues;
  private int sizeOfRod;
  private int[][] solution;

  public RodCutting(int[] values, int sizeOfRod) {
    this.values = values;
    this.totalValues = values.length;
    this.sizeOfRod = sizeOfRod;
    this.solution = new int[totalValues + 1][sizeOfRod + 1];
  }

  public void solve() {
    for (int i = 1; i < totalValues; i++)
      for (int j = 1; j <= sizeOfRod; j++) {
        int notToIncludeCurrentCut = solution[i - 1][j];
        int mustIncludeCurrentCut = Integer.MIN_VALUE;
        if (i <= j)
          mustIncludeCurrentCut = values[i] + solution[i - 1][j - i];

        solution[i][j] = Math.max(notToIncludeCurrentCut, mustIncludeCurrentCut);
      }

    System.out.println("Max Profit : " + solution[totalValues - 1][sizeOfRod]);

    for (int n = totalValues - 1, w = sizeOfRod; n > 0;) {
      if (solution[n][w] != 0 && solution[n][w] != solution[n - 1][w]) {
        System.out.println("Make cut at " + n + " meter.");
        w -= n;
      } else {
        n--;
      }
    }
  }

  public static void main(String[] args) {
    int[] values = { 0, 2, 5, 7, 3 };
    int sizeOfRod = 4;
    RodCutting cutting = new RodCutting(values, sizeOfRod);
    cutting.solve();
  }
}

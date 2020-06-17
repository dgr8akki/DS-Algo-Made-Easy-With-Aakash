package Algorithms.DynamicProgramming;

public class SubsetSum {
  private int[] setOfNumbers;
  private int setSize;
  private int sum;
  private boolean[][] solution;

  public SubsetSum(int[] setOfNumbers, int sum) {
    this.setOfNumbers = setOfNumbers;
    this.setSize = setOfNumbers.length;
    this.sum = sum;
    this.solution = new boolean[setSize + 1][sum + 1];
  }

  public void solve() {
    for (int i = 0; i <= setSize; i++)
      solution[i][0] = true;

    for (int i = 1; i <= setSize; i++)
      for (int j = 1; j <= sum; j++) {
        if (setOfNumbers[i - 1] <= j)
          solution[i][j] = solution[i - 1][j] ? solution[i - 1][j] : solution[i - 1][j - setOfNumbers[i - 1]];
        else
          solution[i][j] = solution[i - 1][j];
      }

    System.out.println(solution[setSize][sum] ? "Solution exists" : "Solution not exists");

    System.out.println();
    System.out.print("[  ");

    for (int row = setSize, col = sum; col > 0 || row > 0; row--)
      if (solution[row][col] && solution[row][col] != solution[row - 1][col]) {
        System.out.print(setOfNumbers[row - 1] + "  ");
        col -= setOfNumbers[row - 1];
      }
    System.out.print("]");
  }

  public static void main(String[] args) {
    int[] setOfNumbers = { 1, 2, 5, 3 };
    int sum = 9;
    SubsetSum subsetSum = new SubsetSum(setOfNumbers, sum);
    subsetSum.solve();
  }
}

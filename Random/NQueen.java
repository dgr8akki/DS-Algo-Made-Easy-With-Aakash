import java.util.Arrays;

public class NQueen {
  class Position {
    int row;
    int col;

    Position(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  public Position[] solveForNQueens(int n) {
    Position[] positions = new Position[n];
    return isSolvableForNQueens(n, 0, positions) ? positions : new Position[0];
  }

  private boolean isSolvableForNQueens(int n, int currentRowIndex, Position[] positions) {
    if(n == currentRowIndex) return true;

    for(int colIndex = 0; colIndex < n; colIndex++) {
      boolean gotSafePosition = true;

      for(int queen = 0; queen < currentRowIndex; queen++) {
        if(positions[queen].col == colIndex ||
        positions[queen].row == currentRowIndex ||
        positions[queen].row - positions[queen].col == currentRowIndex - colIndex ||
        positions[queen].row + positions[queen].col == currentRowIndex + colIndex) {
          gotSafePosition = false;
          break;
        }
      }
      if(gotSafePosition) {
        positions[currentRowIndex] = new Position(currentRowIndex, colIndex);
        if(isSolvableForNQueens(n, currentRowIndex + 1, positions)) return true;
      }
    }
    return false;
  }
  public static void main(String args[]) {
    NQueen nQueenProblem = new NQueen();
    Position[] positions = nQueenProblem.solveForNQueens(4);
    Arrays.stream(positions).forEach(position -> System.out.println(position.row + " " + position.col));
  }
}

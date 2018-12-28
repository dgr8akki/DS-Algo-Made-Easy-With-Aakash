public class KnightTour {
  private int boardSize;
  private int[][] chessBoard;
  private int[] xOffset = {2, 1, -1 , -2, -2, -1, 1, 2};
  private int[] yOffset = {1, 2, 2, 1, -1, -2, -2, -1};

  public KnightTour(int size) {
    this.boardSize = size;
    this.chessBoard = new int[size][size];
    for(int i = 0; i < boardSize; i++)
      for(int j = 0; j < boardSize; j++)
        chessBoard[i][j] = -1;
    chessBoard[0][0] = 1;
  }

  public void solve() {
    if(isPathPossible(0, 0, 2))
      printResult();
    else
      System.out.println("Not possible");
  }

  private boolean isPathPossible(int x, int y, int step) {
    if(step == (boardSize * boardSize ) + 1) return true;

    for(int direction = 0; direction < xOffset.length; direction++) {
      int xNew = x + xOffset[direction];
      int yNew = y + yOffset[direction];

      if(isFeasible(xNew, yNew, step)) {
        chessBoard[xNew][yNew] = step;

        if(isPathPossible(xNew, yNew, step + 1))
          return true;
        chessBoard[xNew][yNew] = -1;
      }
    }
    return false;
  }

  private boolean isFeasible(int x, int y, int step) {
    return (!(x < 0 || y < 0 || x >= boardSize || y >= boardSize || chessBoard[x][y] != -1));
  }

  private void printResult() {
    for(int i = 0; i < boardSize; i++) {
      for(int j = 0; j < boardSize; j++)
        if(chessBoard[i][j] < 10)
          System.out.print(" "+ chessBoard[i][j] + " ");
        else
          System.out.print(chessBoard[i][j] + " ");
      System.out.println();
      }
  }
  public static void main(String[] args) {
    KnightTour tour = new KnightTour(80);
    tour.solve();
  }
}

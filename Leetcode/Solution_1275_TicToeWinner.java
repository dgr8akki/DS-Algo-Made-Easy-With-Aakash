class Solution_1275_TicToeWinner {
  public String tictactoe(int[][] moves) {
    char[][] board = new char[3][3];
    for (char[] carr : board)
      Arrays.fill(carr, 'X');
    for (int i = 0; i < moves.length; i++) {
      int[] move = moves[i];

      if (i % 2 == 0) {
        board[move[0]][move[1]] = 'A';
      } else {
        board[move[0]][move[1]] = 'B';
      }
    }

    char c = 'X';

    // Check rows
    for (int i = 0; i < 3; i++) {
      c = board[i][0];
      if (c != 'X')
        if (c == board[i][1] && c == board[i][2])
          return Character.toString(c);
    }

    // Check cols
    for (int i = 0; i < 3; i++) {
      c = board[0][i];
      if (c != 'X')
        if (c == board[1][i] && c == board[2][i])
          return Character.toString(c);
    }

    // Check diag 1
    c = board[0][0];
    if (c != 'X')
      if (c == board[1][1] && c == board[2][2])
        return Character.toString(c);

    // Check diag 2
    c = board[0][2];
    if (c != 'X')
      if (c == board[1][1] && c == board[2][0])
        return Character.toString(c);

    return (moves.length == 9) ? "Draw" : "Pending";
  }
}

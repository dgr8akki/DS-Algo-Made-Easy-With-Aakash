package Leetcode;

class Solution_1222_QueensThatCanAttackKing {
  public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
    List<List<Integer>> result = new ArrayList<>();
    int kx = king[0], ky = king[1], i = kx, j = ky;
    int[][] board = new int[8][8];
    for (int[] q : queens)
      board[q[0]][q[1]] = 1;
    board[kx][ky] = 2;

    // Check top left diagonal side.
    while (i >= 0 && j >= 0) {
      if (board[i][j] == 1) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        result.add(list);
        break;
      }
      i--;
      j--;
    }

    i = kx;
    j = ky;

    // Check top right diagonal side.
    while (i >= 0 && j < 8) {
      if (board[i][j] == 1) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        result.add(list);
        break;
      }
      i--;
      j++;
    }

    i = kx;
    j = ky;

    // Check top side.
    while (i >= 0 && j >= 0) {
      if (board[i][j] == 1) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        result.add(list);
        break;
      }
      j--;
    }

    i = kx;
    j = ky;

    // Check left side.
    while (i >= 0 && j >= 0) {
      if (board[i][j] == 1) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        result.add(list);
        break;
      }
      i--;
      ;
    }

    i = kx;
    j = ky;

    // Check right side.
    while (i < 8 && j >= 0) {
      if (board[i][j] == 1) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        result.add(list);
        break;
      }
      i++;
    }

    i = kx;
    j = ky;

    // Check down side.
    while (i >= 0 && j < 8) {
      if (board[i][j] == 1) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        result.add(list);
        break;
      }
      j++;
    }

    i = kx;
    j = ky;

    // Check down left diagonal side.
    while (i < 8 && j >= 0) {
      if (board[i][j] == 1) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        result.add(list);
        break;
      }
      i++;
      j--;
    }

    i = kx;
    j = ky;

    // Check down right diagonal side.
    while (i < 8 && j < 8) {
      if (board[i][j] == 1) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        list.add(j);
        result.add(list);
        break;
      }
      i++;
      j++;
    }

    return result;
  }
}

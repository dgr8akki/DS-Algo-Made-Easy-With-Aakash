package Practise;

import java.util.*;

public class SudokuGenerator {
  int[][] sudokuBoard;
  int emptySpaces;

  SudokuGenerator(int emptySpaces) {
    this.emptySpaces = emptySpaces;
    sudokuBoard = new int[9][9];
  }

  public void fillValues() {
    fillDiagonal();
    fillRemaining(0, 3);
    removeKDigits();
  }

  void fillDiagonal() {
    for (int i = 0; i < 9; i += 3)
      fillBox(i, i);
  }

  boolean unUsedInCurrentBox(int rowStart, int colStart, int num) {
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        if (sudokuBoard[rowStart + i][colStart + j] == num)
          return false;

    return true;
  }

  void fillBox(int row, int col) {
    int num;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        do {
          num = randomGenerator(9);
        } while (!unUsedInCurrentBox(row, col, num));

        sudokuBoard[row + i][col + j] = num;
      }
    }
  }

  int randomGenerator(int upperBound) {
    return (int) Math.floor((Math.random() * upperBound + 1));
  }

  boolean CheckIfSafe(int i, int j, int num) {
    return (unUsedInRow(i, num) && unUsedInCol(j, num) && unUsedInCurrentBox(i - i % 3, j - j % 3, num));
  }

  boolean unUsedInRow(int i, int num) {
    for (int currentNum : sudokuBoard[i])
      if (currentNum == num)
        return false;
    return true;
  }

  boolean unUsedInCol(int j, int num) {
    for (int i = 0; i < 9; i++)
      if (sudokuBoard[i][j] == num)
        return false;
    return true;
  }

  boolean fillRemaining(int i, int j) {
    if (j >= 9 && i < 8) {
      i = i + 1;
      j = 0;
    }
    if (i >= 9 && j >= 9)
      return true;

    if (i < 3) {
      if (j < 3)
        j = 3;
    } else if (i < 6) {
      if (j == (int) (i / 3) * 3)
        j = j + 3;
    } else {
      if (j == 6) {
        i = i + 1;
        j = 0;
        if (i >= 9)
          return true;
      }
    }

    for (int num = 1; num <= 9; num++) {
      if (CheckIfSafe(i, j, num)) {
        sudokuBoard[i][j] = num;
        if (fillRemaining(i, j + 1))
          return true;

        sudokuBoard[i][j] = 0;
      }
    }
    return false;
  }

  public void removeKDigits() {
    int count = emptySpaces;
    while (count != 0) {
      int cellId = randomGenerator(80);
      int i = (cellId / 9);
      int j = cellId % 9;
      if (j != 0)
        j = j - 1;
      if (sudokuBoard[i][j] != 0) {
        count--;
        sudokuBoard[i][j] = 0;
      }
    }
  }

  public void printSudoku() {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++)
        System.out.print(sudokuBoard[i][j] + " ");
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args) {
    SudokuGenerator sudoku = new SudokuGenerator(40);
    sudoku.fillValues();
    sudoku.printSudoku();
  }
}

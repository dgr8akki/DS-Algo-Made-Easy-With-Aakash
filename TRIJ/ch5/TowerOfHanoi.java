package com.trijs.ch5;

public class TowerOfHanoi {
  private int moves = 0;
  void solve(int numberOfRings, String from, String to, String aux) {
    if (numberOfRings == 1) {
      System.out.println("Move disk " + numberOfRings + " from " + from + " to " + to);
      moves++;
      return;
    }

    solve(numberOfRings - 1, from, aux, to);
    System.out.println("Move disk " + numberOfRings + " from " + from + " to " + to);
    moves++;
    solve(numberOfRings - 1, aux, to, from);
  }

  void solveWithZeroAsBaseCase(int numberOfRings, String from, String to, String aux) {
    if (numberOfRings == 0) {
      return;
    }

    solveWithZeroAsBaseCase(numberOfRings - 1, from, aux, to);
    System.out.println("Move disk " + numberOfRings + " from " + from + " to " + to);
    moves++;
    solveWithZeroAsBaseCase(numberOfRings - 1, aux, to, from);
  }

  void nHanoiMoves() {
    System.out.println("Number of steps needed are: " + moves);
    moves = 0;
  }

  public static void main(String[] args) {
    TowerOfHanoi hanoi = new TowerOfHanoi();
    hanoi.solve(3, "SRC", "DEST", "HELPER");
    hanoi.nHanoiMoves();
    hanoi.solveWithZeroAsBaseCase(3, "SRC", "DEST", "HELPER");
    hanoi.nHanoiMoves();
  }
}

package com.trijs.ch4;

public class DigitSum {
  int solve(int n) {
    int sum = 0;
    return solve(n, sum);
  }

  private int solve(int n, int sum) {
    if(n <= 0) return 0;
    return sum + (n % 10) + solve(n / 10, sum);
  }

  public static void main(String[] args) {
    DigitSum digitSum = new DigitSum();
    System.out.println(digitSum.solve(499918));
  }
}

package com.trijs.ch3;

public class SumOfFirstNOddNumbers {
  long solve(int n) {
    if(n == 0) return 0;
    if(n==1) return 1;
    if((2 * n) == 1) return 0;
    return ((2*n)-1) + solve(n - 1);
  }

  public static void main(String[] args) {
    SumOfFirstNOddNumbers sumOfFirstNOddNumbers = new SumOfFirstNOddNumbers();
    System.out.println(sumOfFirstNOddNumbers.solve(3));
  }
}

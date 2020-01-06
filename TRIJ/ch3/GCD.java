package com.trijs.ch3;

public class GCD {
  long solve(int first, int second) {
    if(second == 0) return first;
    if(first == 0) return 0;
    return solve(second, first % second);
  }

  public static void main(String[] args) {
    GCD gcd = new GCD();
    System.out.println(gcd.solve(270, 16));
  }
}

package com.trijs.ch3;

public class Combination {
  long compute(int n, int k) {
    if(n == k) return 1;
    if(k == 0) return 1;
    return compute(n - 1, k) + compute(n - 1, k - 1);
  }

  public static void main(String[] args) {
    Combination combination = new Combination();
    System.out.println(combination.compute(27, 16));
  }
}

package com.trijs.ch3;

public class Permutation {
  long permute(int n, int r) {
//    if(n < r) return 0;
    if(n == r) return 1;
    if(r == 0) return 1;
    return n * permute(n - 1, r - 1);
  }

  public static void main(String[] args) {
    Permutation permutation = new Permutation();
    System.out.println(permutation.permute(4, 2));
  }
}

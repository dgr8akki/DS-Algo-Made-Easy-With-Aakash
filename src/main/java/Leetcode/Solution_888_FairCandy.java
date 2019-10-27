package Leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

class Solution_888_FairCandy {
  public static int[] fairCandySwap(int[] A, int[] B) {
    int diff = (IntStream.of(A).sum() - IntStream.of(B).sum()) / 2;
    Set<Integer> S = new HashSet<>();
    for (int a : A) {
      S.add(a);
    }
    for (int b : B) {
      if (S.contains(b + diff)) {
        return new int[] {b + diff, b};
      }
    }
    return new int[0];
  }
}

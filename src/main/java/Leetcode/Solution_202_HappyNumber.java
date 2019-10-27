package Leetcode;

import java.util.*;

class Solution_202_HappyNumber {
  public static boolean isHappy(int n) {
    Set<Integer> set = new HashSet<>();
    return isHappyUtil(n, set);
  }

  private static boolean isHappyUtil(int n, Set<Integer> set) {
    int newNum = 0;
    int temp = n;
    while (temp > 0) {
      int digit = temp % 10;
      newNum += (digit * digit);
      temp /= 10;
    }
    // System.out.println(n + " , " + newNum);
    if (newNum == 1)
      return true;
    if (set.contains(newNum))
      return false;
    set.add(newNum);
    return isHappyUtil(newNum, set);
  }

  public static void main(String[] args) {
    int n = 19;
    System.out.println("is " + n + " Happy? : " + isHappy(n));
  }
}

package Leetcode;

class Solution_326_IsPowerOfThree {
    public boolean isPowerOfThree(int n) {
        if(n <= 0) return false;
        // while(n % 3 == 0)
        //   n/=3;
        // return n == 1;
        // 1162261467 is 3^19,  3^20 is bigger than int
      return 1162261467 % n == 0;
    }
}
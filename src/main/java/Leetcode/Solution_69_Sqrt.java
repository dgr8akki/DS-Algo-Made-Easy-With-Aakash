package Leetcode;

class Solution {
    public int mySqrt(int x) {
        long n = x;
        while( n * n > x)
          n = (n + x / n) >> 1;
        return (int)n;
    }
}

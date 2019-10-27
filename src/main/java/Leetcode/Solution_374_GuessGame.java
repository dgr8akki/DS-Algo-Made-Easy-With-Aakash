package Leetcode;/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution_374_GuessGame extends GuessGame {
    public int guessNumber(int n) {
        int start = 1;
        int mid = 0;
        int end = n;
        while(start <= end) {
          mid = end + (start - end) / 2;
          int g = guess(mid);
          if(g == 0) return mid;
          if(g == -1)
            end = mid - 1;
          else
            start = mid + 1;
        }
      return -1;
    }
}
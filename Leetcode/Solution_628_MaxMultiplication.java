package Leetcode;

class Solution_628_MaxMultiplication {
    public int maximumProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for(int n : nums) {
          if(n > firstMax) {
            thirdMax = secondMax;
            secondMax = firstMax;
            firstMax = n;
          } else if(n > secondMax) {
            thirdMax = secondMax;
            secondMax = n;            
          } else if(n > thirdMax) {
            thirdMax = n;
          }
          
          if(n < firstMin) {
            secondMin = firstMin;
            firstMin = n;
          } else if(n < secondMin) {
            secondMin = n;
          }
        }
      
      return Math.max(firstMax * secondMax * thirdMax, firstMin * secondMin * firstMax);
    }
}
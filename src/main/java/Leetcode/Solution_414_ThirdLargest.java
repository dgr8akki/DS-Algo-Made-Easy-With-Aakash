package Leetcode;

class Solution_414_ThirdLargest {
    public int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE;
        long secMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
          if(set.contains(num)) continue;
          if(num > firstMax) {
            thirdMax = secMax;
            secMax = firstMax;
            firstMax = num;
          } else if(num > secMax) {
            thirdMax = secMax;
            secMax = num;
          } else if(num > thirdMax) {
            thirdMax = num;
          }
          set.add(num);
          // System.out.println(firstMax + " , " + secMax + " , " + thirdMax);
        }
      
      return (int)(thirdMax == Long.MIN_VALUE ? firstMax : thirdMax);
    }
}
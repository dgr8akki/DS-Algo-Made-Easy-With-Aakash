package Leetcode;

class Solution_167_TwoSumII {
    public int[] twoSum(int[] A, int target) {
       int n = A.length;
        int[] res = new int[2];
       for(int i = 0; i < n; i++) {
         if(A[i] > target) break;
         res[0] = i + 1;
         int expected = Arrays.binarySearch(A, i + 1, n, target - A[i]);
         if(expected >= 0) {
           res[1] = expected + 1;
           return res;
         }
       }
      
      return res;
    }
}
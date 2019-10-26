package Leetcode;

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int start = 0;
        int end = A.length - 1;
        int mid = 0;
        while(start < end) {
          mid = (start + end) / 2;
          if(A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) return mid;
          if(A[mid - 1] < A[mid] && A[mid] < A[mid + 1])
            start = mid;
          else if(A[mid - 1] > A[mid] && A[mid] > A[mid + 1])
            end = mid + 1;
        }
      
      return -1;
    }
}
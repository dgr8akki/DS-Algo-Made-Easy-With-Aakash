class Solution {
    public int arrangeCoins(int n) {
        if(n == 1 || n == 0) return n;
        long start = 1;
        long end = n;
        long mid = end + (start - end) / 2;
        while(start <= end) {
          
          if(isSolvable(mid, n) == -1) {
            start = mid + 1;
          } else if(isSolvable(mid, n) == 1) {
            end = mid - 1;
          } else if(isSolvable(mid, n) == 0) {
            return (int)mid;
          }
          
          mid = end + (start - end) / 2;
        }
      return (int)mid;
    }
  
  private int isSolvable(long n, int target) {
    long sum = 0;
    sum = (n * (n + 1)) / 2;
    if(sum < target) return -1;
    if(sum > target) return 1;
    if(sum == target) return 0;
    return -2;
  }
}
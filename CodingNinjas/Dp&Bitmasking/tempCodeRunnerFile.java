ate static int minCostIterative(int[][] cost, int n) {
  //   if(currentJobIdx >= n)
  //     return 0;

  //   int min = Integer.MAX_VALUE;
  //   for(int i = 0; i < n; i++) {
  //     if((mask & (1 << i)) == 0) {
  //       int ans = minCostIterative(cost, n, currentJobIdx + 1, mask | (1 << i)) + cost[currentJobIdx][i];
  //       min = Math.min(min, ans);
  //     }
  //   }
  //   return min;
  // }
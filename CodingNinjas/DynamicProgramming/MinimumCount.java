public class MinimumCount {

	public static int minCount(int n) {
      int sqrtOfN = (int) Math.floor(Math.sqrt(n));
      if((sqrtOfN * sqrtOfN) == n) return 1;
      if(n < 4) return n;
      int[] dp = new int[n + 1];
      dp[0] = 0;
      dp[1] = 1;
      dp[2] = 2;
      dp[3] = 3;
      for(int i = 4; i <=n; i++) {
        int sqrtOfI = (int) Math.floor(Math.sqrt(i));
        if((sqrtOfI * sqrtOfI) == i) dp[i] = 1;
        else {
          dp[i] = Integer.MAX_VALUE;
          for(int j = 1; j <= sqrtOfI; j++)
          	dp[i] = Math.min(dp[i], dp[j*j] + dp[i - (j * j)]);
        }
      }
      return dp[n];
    }
}

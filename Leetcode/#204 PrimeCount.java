class Solution {
  public int countPrimes(int n) {
    int count = 0;
    boolean prime[] = new boolean[n + 1];
    Arrays.fill(prime, true);
    for (int p = 2; p < Math.sqrt(n); p++) {
      if (prime[p] == true) {
        for (int i = p * p; i <= n; i += p)
          prime[i] = false;
      }
    }

    for (int i = 2; i <= n; i++) {
      if (prime[i] == true)
        count++;
    }
    return count;
  }

}

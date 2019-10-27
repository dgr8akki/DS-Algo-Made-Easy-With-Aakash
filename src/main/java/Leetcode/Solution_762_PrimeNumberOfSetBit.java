package Leetcode;

class Solution_762_PrimeNumberOfSetBit {
  public int countPrimeSetBits(int L, int R) {
    int count = 0;
    Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29));
    for (int num = L; num <= R; num++)
      if (primes.contains(Integer.bitCount(num)))
        count++;
    return count;
  }
}

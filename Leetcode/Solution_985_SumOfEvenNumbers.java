package Leetcode;

class Solution_985_SumOfEvenNumbers {
  public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
    int[] result = new int[queries.length];
    int sum = 0;
    for (int i : A) {
      if (i % 2 == 0)
        sum += i;
    }
    for (int i = 0; i < queries.length; i++) {
      int index = queries[i][1], prev = A[index];
      if (prev % 2 == 0)
        sum -= prev;
      int num = A[index] += queries[i][0];
      if (num % 2 == 0)
        sum += num;
      result[i] = sum;
    }
    return result;
  }
}

package Leetcode;

class Solution_526_BeautifulArrangement {
  int count = 0;

  public int countArrangement(int N) {
    if (N == 0)
      return 0;
    countArrangementUtil(N, 1, new int[N + 1]);
    return count;
  }

  private void countArrangementUtil(int N, int currentNumber, int[] visited) {
    if (currentNumber > N) {
      count++;
      return;
    }

    for (int i = 1; i <= N; i++) {
      if (visited[i] == 0 && (i % currentNumber == 0 || currentNumber % i == 0)) {
        visited[i] = 1;
        countArrangementUtil(N, currentNumber + 1, visited);
        visited[i] = 0;
      }
    }
  }
}

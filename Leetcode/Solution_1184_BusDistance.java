package Leetcode;

class Solution_1184_BusDistance {
  public int distanceBetweenBusStops(int[] distance, int start, int destination) {
    int n = distance.length;
    int[] left = new int[n];
    int[] right = new int[n];

    left[0] = right[0] = 0;
    int sum = distance[0];
    for (int i = 1; i < n; i++) {
      left[i] = distance[i - 1] + left[i - 1];
      sum += distance[i];
    }

    right[n - 1] = distance[n - 1];
    for (int i = n - 2; i >= 1; i--) {
      right[i] = right[i + 1] + distance[i];
    }

    if (start == 0) {
      return Math.min(left[destination], right[destination]);
    } else {
      int min = Math.min(start, destination);
      int max = Math.max(start, destination);
      return Math.min((left[min] + right[max]), (sum - (left[min] + right[max])));
    }
  }
}

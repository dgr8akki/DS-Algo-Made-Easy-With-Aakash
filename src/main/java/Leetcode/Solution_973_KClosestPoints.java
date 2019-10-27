package Leetcode;

class Solution_973_KClosestPoints {
  public int[][] kClosest(int[][] points, int K) {
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
        (a, b) -> Double.compare(Math.sqrt(a[0] * a[0] + a[1] * a[1]), Math.sqrt(b[0] * b[0] + b[1] * b[1])));
    for (int[] point : points)
      priorityQueue.add(point);
    int[][] result = new int[K][2];
    for (int i = 0; i < K; i++)
      result[i] = priorityQueue.remove();
    return result;
  }
}

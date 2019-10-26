package Leetcode;

class Solution {
  public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        heap.add(matrix[i][j]);
        if (heap.size() > k)
          heap.poll();
      }
    }
    return heap.poll();
  }
}

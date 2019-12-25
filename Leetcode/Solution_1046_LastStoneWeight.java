package Leetcode;

class Solution_1046_LastStoneWeight {
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
    for (int stone : stones) {
      heap.add(stone);
    }

    while (heap.size() > 1) {
      int x = heap.remove();
      int y = heap.remove();

      if (x != y) {
        heap.add(Math.abs(x - y));
      }
    }

    if (heap.size() == 1)
      return heap.remove();
    return 0;
  }
}

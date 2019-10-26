package Leetcode;

class KthLargest {
  PriorityQueue<Integer> q;
  int k;

  public KthLargest(int k, int[] nums) {
    q = new PriorityQueue<>(k);
    this.k = k;
    for (int num : nums)
      add(num);
  }

  public int add(int val) {
    if (q.size() < k)
      q.offer(val);
    else if (q.peek() < val) {
      q.poll();
      q.offer(val);
    }
    return q.peek();
  }
}

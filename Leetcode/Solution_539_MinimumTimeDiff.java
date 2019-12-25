package Leetcode;

class Solution_539_MinimumTimeDiff {
  public int findMinDifference(List<String> timePoints) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (String time : timePoints) {
      pq.offer(format(time));
    }
    int first = pq.peek(), pre = pq.poll(), min = Integer.MAX_VALUE;
    while (!pq.isEmpty()) {
      min = Math.min(min, pq.peek() - pre);
      pre = pq.poll();
    }
    if (pre - first > 12 * 60) {
      min = Math.min(1440 + first - pre, min);
    }
    return min;
  }

  public int format(String time) {
    int digit1 = time.charAt(0) - '0';
    int digit2 = time.charAt(1) - '0';
    int digit3 = time.charAt(3) - '0';
    int digit4 = time.charAt(4) - '0';
    return (digit1 * 10 + digit2) * 60 + digit3 * 10 + digit4;

  }
}

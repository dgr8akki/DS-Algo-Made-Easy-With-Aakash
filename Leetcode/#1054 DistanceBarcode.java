class Solution {
  public int[] rearrangeBarcodes(int[] barcodes) {
    Map<Integer, Integer> m = new HashMap<>();
    for (int c : barcodes) {
      m.put(c, 1 + m.getOrDefault(c, 0));
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>((i, j) -> m.get(j) - m.get(i));
    pq.addAll(m.keySet());
    int[] ans = new int[barcodes.length];
    int index = 0;
    while (!pq.isEmpty()) {
      int code = pq.poll(), freq = m.remove(code);
      while (freq-- > 0) {
        if (index >= barcodes.length) {
          index = 1;
        }
        ans[index] = code;
        index += 2;
      }
    }
    return ans;
  }
}

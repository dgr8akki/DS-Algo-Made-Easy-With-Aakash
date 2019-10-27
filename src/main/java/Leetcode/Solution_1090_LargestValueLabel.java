package Leetcode;

class Solution_1090_LargestValueLabel {
  public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
    List<int[]> pairs = new ArrayList<>();
    Map<Integer, Integer> limits = new HashMap<>();
    for (int i = 0; i < labels.length; i++) {
      if (!limits.containsKey(labels[i]))
        limits.put(labels[i], 0);

      pairs.add(new int[] { values[i], labels[i] });
    }
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o2[0] - o1[0];
      }
    });
    int max = 0;
    pq.addAll(pairs);
    for (int i = 0; i < num_wanted && !pq.isEmpty();) {
      int[] pair = pq.remove();
      if (limits.get(pair[1]) < use_limit) {
        max += pair[0];
        limits.put(pair[1], limits.get(pair[1]) + 1);
        i++;
      }
    }
    return max;
  }
}

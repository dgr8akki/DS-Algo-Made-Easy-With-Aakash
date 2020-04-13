package Leetcode;

class RecentCounter {

  TreeSet<Integer> ts;

  public RecentCounter() {
    ts = new TreeSet<>();
  }

  public int ping(int t) {
    ts.add(t);
    return ts.tailSet(t - 3000).size();
  }
}

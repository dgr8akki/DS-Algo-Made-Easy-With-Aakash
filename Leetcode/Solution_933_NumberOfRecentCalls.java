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

/**
* Your RecentCounter object will be instantiated and called as such:
* RecentCounter obj = new RecentCounter();
* int param_1 = obj.ping(t);
*/

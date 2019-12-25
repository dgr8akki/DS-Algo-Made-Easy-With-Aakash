package Leetcode;

class ExamRoom {
  int N;
  ArrayList<Integer> L = new ArrayList<>();

  public ExamRoom(int n) {
    N = n;
  }

  public int seat() {
    if (L.size() == 0) {
      L.add(0);
      return 0;
    }
    int d = Math.max(L.get(0), N - 1 - L.get(L.size() - 1));
    for (int i = 0; i < L.size() - 1; ++i)
      d = Math.max(d, (L.get(i + 1) - L.get(i)) / 2);
    if (L.get(0) == d) {
      L.add(0, 0);
      return 0;
    }
    for (int i = 0; i < L.size() - 1; ++i)
      if ((L.get(i + 1) - L.get(i)) / 2 == d) {
        L.add(i + 1, (L.get(i + 1) + L.get(i)) / 2);
        return L.get(i + 1);
      }
    L.add(N - 1);
    return N - 1;
  }

  public void leave(int p) {
    for (int i = 0; i < L.size(); ++i)
      if (L.get(i) == p)
        L.remove(i);
  }
}

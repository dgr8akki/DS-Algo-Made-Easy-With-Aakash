class Solution_898_BitwiseORArray {
  public int subarrayBitwiseORs(int[] A) {
    Set<Integer> res = new HashSet<>(), cur = new HashSet<>(), cur2;
    for (Integer i : A) {
      cur2 = new HashSet<>();
      cur2.add(i);
      for (Integer j : cur)
        cur2.add(i | j);
      res.addAll(cur = cur2);
    }
    return res.size();
  }
}

class Solution_1238_CircularRepresentationBinaryString {
  public List<Integer> circularPermutation(int n, int start) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < 1 << n; ++i)
      res.add(start ^ i ^ i >> 1);
    return res;
  }
}

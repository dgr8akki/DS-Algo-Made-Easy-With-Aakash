class Solution_1276_NumberOfBurger {
  public List<Integer> numOfBurgers(int T, int C) {
    List<Integer> result = new ArrayList<>();
    int J = T / 2 - C;
    int S = C - J;
    if (T % 2 == 0 && J >= 0 && S >= 0) {
      result.add(J);
      result.add(S);
    }
    return result;
  }
}

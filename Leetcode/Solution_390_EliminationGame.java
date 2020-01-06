class Solution_390_EliminationGame {
  public int lastRemaining(int n) {
    return leftToRight(n);
  }

  private static int leftToRight(int n) {
    if (n <= 2)
      return n;
    return 2 * rightToLeft(n / 2);
  }

  private static int rightToLeft(int n) {
    if (n <= 2)
      return 1;
    if (n % 2 == 1)
      return 2 * leftToRight(n / 2);
    return 2 * leftToRight(n / 2) - 1;
  }
}

class StockSpanner {
  Stack<int[]> stack;

  public StockSpanner() {
    stack = new Stack<>();
  }

  public int next(int price) {
    int res = 1;
    while (!stack.isEmpty() && stack.peek()[0] <= price)
      res += stack.pop()[1];
    stack.push(new int[] { price, res });
    return res;
  }
}

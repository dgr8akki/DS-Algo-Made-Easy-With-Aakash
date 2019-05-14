public class NestedIterator implements Iterator<Integer> {
  Stack<NestedInteger> stack;

  public NestedIterator(List<NestedInteger> nestedList) {
    stack = new Stack();
    addElems(nestedList);
  }

  private void addElems(List<NestedInteger> nestedList) {
    for (int i = nestedList.size() - 1; i >= 0; i--)
      stack.push(nestedList.get(i));
  }

  @Override
  public Integer next() {
    return stack.pop().getInteger();
  }

  @Override
  public boolean hasNext() {
    while (!stack.isEmpty() && !stack.peek().isInteger())
      addElems(stack.pop().getList());
    return !stack.isEmpty();
  }
}

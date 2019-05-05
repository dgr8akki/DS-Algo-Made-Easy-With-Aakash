class MyQueue {

  /** Initialize your data structure here. */
  Stack<Integer> insertionStack, deletionStack;

  public MyQueue() {
    insertionStack = new Stack<>();
    deletionStack = new Stack<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    insertionStack.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    if (!deletionStack.isEmpty())
      return deletionStack.pop();
    while (!insertionStack.isEmpty())
      deletionStack.push(insertionStack.pop());
    return deletionStack.pop();
  }

  /** Get the front element. */
  public int peek() {
    if (!deletionStack.isEmpty())
      return deletionStack.peek();
    while (!insertionStack.isEmpty())
      deletionStack.push(insertionStack.pop());
    return deletionStack.peek();

  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return insertionStack.isEmpty() && deletionStack.isEmpty();
  }
}

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
        if(!deletionStack.isEmpty())
          return deletionStack.pop();
        while(!deletionStack.isEmpty())
          deletionStack.push(insertionStack.pop());
      return deletionStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
       if(!deletionStack.isEmpty())
          return deletionStack.peek();
        while(!deletionStack.isEmpty())
          deletionStack.push(insertionStack.pop());
      return deletionStack.peek();
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return insertionStack.isEmpty() && deletionStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
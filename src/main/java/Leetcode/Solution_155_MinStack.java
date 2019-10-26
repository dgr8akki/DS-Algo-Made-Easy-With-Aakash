package Leetcode;

class MinStack {

    /** initialize your data structure here. */
  Stack<Node> st;
    class Node {
      int data;
      int min;
      Node(int data, int min) {
        this.data = data;
        this.min = min;
      }
    }
    public MinStack() {
      st = new Stack<>();
    }
    
    public void push(int x) {
        if(st.isEmpty())
          st.push(new Node(x,x));
        else {
          int lastMin = st.peek().min;
          st.push(new Node(x, Math.min(lastMin, x)));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().data;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
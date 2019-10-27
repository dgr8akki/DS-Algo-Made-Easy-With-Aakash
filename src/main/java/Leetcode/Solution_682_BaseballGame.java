package Leetcode;

class Solution_682_BaseballGame {
  public int calPoints(String[] ops) {
    Stack<Integer> st = new Stack<>();
    int sum = 0;
    for (String op : ops) {
      switch (op) {
      case "C":
        sum -= st.pop();
        break;
      case "D":
        int res = st.peek();
        st.push(2 * res);
        sum += (2 * res);
        break;
      case "+":
        int s = st.pop();
        int m = st.peek();
        st.push(s);
        st.push(s + m);
        sum += (s + m);
        break;
      default:
        st.push(Integer.parseInt(op));
        sum += Integer.parseInt(op);
        break;
      }
      // System.out.println("TOP :" + st.peek() + " , Sum: " + sum);
    }

    return sum;
  }
}

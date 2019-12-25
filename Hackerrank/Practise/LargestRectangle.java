package Hackerrank.Practise;

import java.util.*;

class LargestRectangle {
  static long largestRectangle(int[] h) {
    long area = 0;
    Stack<Integer> st = new Stack<>();
    long maxArea = 0;
    int i;
    for (i = 0; i < h.length;) {
      if(st.isEmpty() || h[i] >= h[st.peek()]) {
        st.push(i++);
      } else {
        int top = st.pop();
        if(st.isEmpty()) {
          area = h[top] * i;
        } else {
          area = h[top] * (i - st.peek() - 1);
        }
        if(area > maxArea) maxArea = area;
      }
    }
    while(!st.isEmpty()) {
      int top = st.pop();
      if(st.isEmpty()) {
        area = h[top] * i;
      } else {
        area = h[top] * (i - st.peek() - 1);
      }
      if(area > maxArea) maxArea = area;
    }
    return maxArea;
  }

  public static void main(String args[]) {
    int[] heights = {8979,4570,6436,5083,7780,3269,5400,7579,2324,2116};
    System.out.println(largestRectangle(heights));
  }
}

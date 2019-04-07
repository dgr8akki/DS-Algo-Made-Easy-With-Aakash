/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
      if(head == null) return new int[0];
      Map<ListNode, Integer> map = new HashMap<>();
      Stack<ListNode> st = new Stack<>();
      // st.push(head.val);
      ListNode temp = head;
      while(temp != null) {
        int num = temp.val;
        if(!st.isEmpty() && num < st.peek().val)
          st.push(temp);
        else {
          while(!st.isEmpty() && num > st.peek().val) {
            map.put(st.pop(), num);
          }
          st.push(temp);
        }
        temp = temp.next;
      }
      while(!st.isEmpty()) {
        map.put(st.pop(), 0);
      }
      int[] res = new int[map.size()];
      temp = head;
      for(int i = 0; i < map.size(); i++) {
        res[i] = map.get(temp);
        temp = temp.next;
      }
      
      return res;
    }
}
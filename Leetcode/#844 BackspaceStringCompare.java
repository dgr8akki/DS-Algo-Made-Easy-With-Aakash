class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for(int i = 0; i < S.length(); i++) {
          char c = S.charAt(i);
          if(c != '#') {
            st1.push(c);
          } else if(!st1.isEmpty())
            st1.pop();
        }
      for(int i = 0; i < T.length(); i++) {
          char c = T.charAt(i);
          if(c != '#') {
            st2.push(c);
          } else if(!st2.isEmpty())
            st2.pop();
        }
      
      if(st1.size() != st2.size()) return false;
      for(int i = 0; i < st1.size(); i++) {
        if(st1.pop() != st2.pop()) return false;
      }
      
      return true;
    }
}
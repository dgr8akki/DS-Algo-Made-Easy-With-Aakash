import java.util.Stack;

public class ValidString {

  public static boolean isValid(String s) {
    if(s.length() == 0) return true;
    Stack<Character> stack = new Stack<>();
    for(char currentCharacter : s.toCharArray()) {
      try {
        switch(currentCharacter) {
          case '(':
          case '{':
          case '[':
          stack.push(currentCharacter); break;
          case ')':
          if(stack.peek() == '(') stack.pop(); break;
          case '}':
          if(stack.peek() == '{') stack.pop(); break;
          case ']':
          if(stack.peek() == '[') stack.pop(); break;
        }
      } catch(Exception e) {
        return false;
      }
    }
    if(stack.size() > 0) return false;
    return true;
  }
  public static void main(String[] args) {
    String[] test = {"abc(ava){a(ad)we}", "))))", "abc(ava){a(ad)we", ")))((("};
    for(String current : test) {
      System.out.println("Is string '" + current + "' denotes a valid string?");
      System.out.println(isValid(current));
    }
  }
}

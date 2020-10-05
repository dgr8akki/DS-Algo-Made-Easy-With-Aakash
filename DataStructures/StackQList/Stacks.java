/**
 * Stacks
 */
public class Stacks {
  private final static int SIZE = 10000;
  private static int top = 0;
  private static int[] s = new int[SIZE];

  public static void push(int val) {
    if (top == SIZE)
      return;
    s[top++] = val;
    System.out.println("Inserted: " + val);
  }

  public static int pop() {
    if (top == -1)
      return -1;
    System.out.println("Value popped out");
    return s[top--];
  }

  public static int getSize() {
    return top;
  }

  public static int peek() {
    if (top == -1)
      return -1;
    return s[top];
  }

  public static void main(String[] args) {
    System.out.println(getSize());
    push(10);
    push(9);
    push(8);
    push(7);
    System.out.println(getSize());
    pop();
    System.out.println(getSize());
    pop();
    System.out.println(getSize());
  }
}

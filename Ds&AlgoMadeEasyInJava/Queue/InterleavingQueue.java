import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleavingQueue {
  public static void printInterleavingQueue(Queue<Integer> q) {
    System.out.println("Original Queue:");
    System.out.println(Arrays.toString(q.toArray()));
    Stack<Integer> stack = new Stack<>();
    int halfSize = q.size() / 2;
    for(int i = 1; i <= halfSize; i++)
      stack.push(q.remove());
    for(int i = 1; i <= halfSize; i++) {
      q.add(stack.pop());
    }
    for(int i = 1; i <= halfSize; i++)
      stack.push(q.remove());
    System.out.println("\nStack:");
    System.out.println(Arrays.toString(stack.toArray()));
    System.out.println("\nStack TOP: " + stack.peek());
    System.out.println("\nInterleaving Queue:");
    System.out.println(Arrays.toString(q.toArray()));
  }
  public static void main(String[] args) {
    int n = 10;
    Queue<Integer> q = new LinkedList<>();
    for(int i = 1; i <= n; i++)
      q.add(i);
    printInterleavingQueue(q);
  }
}
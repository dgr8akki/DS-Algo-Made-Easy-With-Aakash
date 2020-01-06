package CodeChef;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HussainSet {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Queue<Long> queue = new LinkedList<>();
    int n = in.nextInt();
    int m = in.nextInt();
    long[] multiset = new long[n];
    int multisetLastRunner = n - 1;
    int queryCount = 0;

    for (int i = 0; i < n; i++) {
      multiset[i] = in.nextInt();
    }

    Arrays.sort(multiset);

    while (m-- > 0) {
      int currentQueryRequested = in.nextInt();
      long currentElement = 0;
      for (; queryCount < currentQueryRequested; queryCount++) {
        if (multisetLastRunner >= 0 && (queue.isEmpty() || multiset[multisetLastRunner] >= queue.peek())) {
          currentElement = multiset[multisetLastRunner];
          multisetLastRunner--;
        } else {
          currentElement = queue.poll();
        }
        queue.add(currentElement / 2);
      }
      System.out.println(currentElement);
    }
    in.close();
  }
}

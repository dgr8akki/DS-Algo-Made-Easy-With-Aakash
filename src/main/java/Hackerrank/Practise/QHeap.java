package Hackerrank.Practise;

import java.io.*;
import java.util.*;

public class QHeap {

    public static void main(String[] args) {
      PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer c1, Integer c2) {
          return Integer.compare(c1, c2);
        }
      });
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      for(int i = 0; i < n; i++) {
        int query = sc.nextInt();
        switch(query) {
          case 1:
            queue.add(sc.nextInt());
            break;
          case 2:
            queue.remove(sc.nextInt());
            break;
          case 3:
            System.out.println(queue.peek()); break;
        }
      }
    }
}


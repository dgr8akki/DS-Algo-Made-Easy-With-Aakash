import java.io.*;
import java.util.*;

class Solution {

  static void query (Map<Integer, Integer> hm, int x1, int y1, int z1, int x2, int y2, int z2) {
    long sum = 0;
    int i = 0;
    for (int key : hm.keySet() ) {
      if (x1 * 1000000 + y1 * 1000 + z1 <= key && key <= x2 * 1000000 + y2 * 1000 + z2 ) {
        sum += hm.get(key);
      }
    }

    System.out.println(sum);
  }

  static void update(Map<Integer, Integer> hm, int x, int y, int z, int w) {
    hm.put(x * 1000000 + y * 1000 + z, w);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();

    for(int i = 0; i < T; i++) {
      int N = scanner.nextInt();
      int M = scanner.nextInt();

      Map<Integer,Integer> hm = new HashMap<>();

      for (int j = 0; j < M; j++) {
        String type = scanner.next();

        if( type.equals("UPDATE")) {
          int x = scanner.nextInt();
          int y = scanner.nextInt();
          int z = scanner.nextInt();
          int w = scanner.nextInt();
          update(hm,x,y,z,w);
        } else {
          int x1 = scanner.nextInt();
          int y1 = scanner.nextInt();
          int z1 = scanner.nextInt();
          int x2 = scanner.nextInt();
          int y2 = scanner.nextInt();
          int z2 = scanner.nextInt();
          query(hm,x1,y1,z1,x2,y2,z2);
        }
      }
    }
    scanner.close();
  }
}

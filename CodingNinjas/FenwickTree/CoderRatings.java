package CodingNinjas.FenwickTree;

import java.util.Arrays;
import java.util.Scanner;

/**
 * CoderRatings
 */
public class CoderRatings {
  static class Coder implements Comparable<Coder> {
    int x, y, idx;

    @Override
    public int compareTo(Coder other) {
      if (this.x == other.x)
        return Integer.compare(this.y, other.y);
      return Integer.compare(this.x, other.x);
    }

  }

  static int[] BIT = new int[100001];

  static void update(int index) {
    for (; index <= 100000; index += index & (-index))
      BIT[index]++;
  }

  static int query(int index) {
    int value = 0;
    for (; index > 0; index -= index & (-index))
      value += BIT[index];
    return value;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    Coder[] arr = new Coder[n];
    for (int i = 0; i < n; i++) {
      arr[i] = new Coder();
      arr[i].x = in.nextInt();
      arr[i].y = in.nextInt();
      arr[i].idx = i;
    }
    in.close();
    Arrays.sort(arr);
    int[] res = new int[n];

    for (int i = 0; i < n;) {
      int endIndex = i;
      while (endIndex < n && arr[endIndex].x == arr[i].x && arr[endIndex].y == arr[i].y) {
        endIndex++;
      }

      for (int j = i; j < endIndex; j++)
        res[arr[j].idx] = query(arr[j].y);

      for (int j = i; j < endIndex; j++)
        update(arr[j].y);

      i = endIndex;
    }
    for (int i = 0; i < n; i++)
      System.out.println(res[i]);
  }
}

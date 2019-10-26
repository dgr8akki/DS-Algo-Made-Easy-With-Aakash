package CodingNinjas.FenwickTree;

import java.util.Arrays;
import java.util.Scanner;

/**
 * DistinctQueries
 */
public class DistinctQueries {
  static int[] BIT = new int[30001];

  static class Query implements Comparable<Query> {
    int start, end, idx;

    @Override
    public int compareTo(Query o) {
      return Integer.compare(this.end, o.end);
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n + 1];
    for (int i = 1; i <= n; i++)
      arr[i] = in.nextInt();
    int q = in.nextInt();
    Query[] queries = new Query[q];
    for (int i = 0; i < q; i++) {
      Query query = new Query();
      query.start = in.nextInt();
      query.end = in.nextInt();
      query.idx = i;
      queries[i] = query;
    }
    in.close();
    Arrays.sort(queries);

    int[] last = new int[n + 1];
    int[] res = new int[q];
    int total = 0, k = 0;
    Arrays.fill(last, -1);
    for (int i = 1; i <= n; i++) {
      if (last[arr[i]] != -1) {
        update(last[arr[i]], -1, n);
      } else
        total++;

      update(i, 1, n);

      last[arr[i]] = i;
      while (k < q && queries[k].end == i) {
        res[queries[k].idx] = total - value(queries[k].start - 1);
        k++;
      }
    }

    for (int i = 0; i < q; i++)
      System.out.println(res[i]);
  }

  private static int value(int index) {
    int res = 0;
    for (; index > 0; index -= index & (-index))
      res += BIT[index];
    return res;
  }

  private static void update(int index, int value, int n) {
    for (; index <= n; index += index & (-index))
      BIT[index] += value;
  }
}

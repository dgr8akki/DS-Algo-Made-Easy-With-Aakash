package CodingNinjas.FenwickTree;

import java.util.*;

public class KQuery {
  public static class Query implements Comparable<Query> {
    int val, start, end, index;

    @Override
    public int compareTo(Query o) {
      if (this.val == o.val)
        return Integer.compare(o.end, this.end);
      return Integer.compare(o.val, this.val);
    }
  }

  static int[] BIT = new int[30001];
  static Query[] queries = new Query[230000];
  static Map<Integer, Integer> map = new HashMap<>();
  static Integer[] array;
  static List<Integer> arr;
  static int max_val;

  static void update(int index) {
    for (; index <= max_val; index += index & (-index))
      BIT[index]++;
  }

  static int query(int index) {
    int value = 0;
    for (; index > 0; index -= index & (-index))
      value += BIT[index];
    return value;
  }

  static int x = 0;

  static int query(int start, int end, int value) {
    int sQ = query(start - 1);
    int eQ = query(end);
    int res = eQ - sQ;
    return res;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    max_val = n;
    for (int i = 0; i < n; i++) {
      Query qry = new Query();
      qry.val = in.nextInt();
      qry.start = i + 1;
      qry.end = -1;
      qry.index = -1;
      queries[i] = qry;
    }
    int q = in.nextInt();
    int[] res = new int[q];
    for (int i = 0; i < q; i++) {
      Query qry = new Query();
      qry.start = in.nextInt();
      qry.end = in.nextInt();
      qry.val = in.nextInt();
      qry.index = i;
      queries[i + n] = qry;
    }
    in.close();
    Arrays.sort(queries, 0, n + q);
    for (int i = 0; i < n + q; i++) {
      Query cur = queries[i];
      if (cur.end == -1)
        update(cur.start);
      else
        res[cur.index] = query(cur.start, cur.end, cur.val);
    }
    for (int i = 0; i < q; i++)
      System.out.println(res[i]);
  }
}

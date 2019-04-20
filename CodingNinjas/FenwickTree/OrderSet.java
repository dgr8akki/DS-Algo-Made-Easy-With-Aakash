import java.util.*;

/**
 * OrderSet
 */
public class OrderSet {
  public static class Query {
    char type;
    int val;
  }

  static int[] BIT = new int[1000001];
  static Query[] queries;
  static Map<Integer, Integer> map = new HashMap<>();
  static Integer[] array;

  private static void kthSmallest(int k) {
    int start = 0;
    int end = map.size();
    while (start < end) {
      int mid = (start + end) / 2;
      if (k <= query(mid))
        end = mid;
      else
        start = mid + 1;
    }

    System.out.println(array[start]);
  }

  private static void delete(int val) {
    int mappedIdx = map.get(val);
    if (query(mappedIdx) != query(mappedIdx - 1)) {
      update(mappedIdx, -1);
    }
  }

  private static void update(int index, int val) {
    for (; index < BIT.length; index += (index & (-index)))
      BIT[index] += val;
  }

  private static void count(int val) {
    System.out.println(val);

    // while (!map.containsValue(val)) {
    // val++;
    // System.out.println(val);
    // }
    int mappedIdx = map.get(val);
    System.out.println(query(mappedIdx - 1));
  }

  private static int query(int index) {
    int ans = 0;
    for (; index > 0; index -= (index & (-index)))
      ans += BIT[index];
    return ans;
  }

  private static void insert(int val) {
    int mappedIdx = map.get(val);
    if (mappedIdx != 0 && (query(mappedIdx) == query(mappedIdx - 1))) {
      update(mappedIdx, 1);
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int q = in.nextInt();
    Set<Integer> set = new TreeSet<>();
    queries = new Query[q];
    for (int i = 0; i < q; i++) {
      Query qry = new Query();
      qry.type = in.next().charAt(0);
      qry.val = in.nextInt();
      queries[i] = qry;
    }
    in.close();
    for (Query cur : queries) {
      if (cur.type == 'I')
        set.add(cur.val);
    }
    int k = 0;
    array = new Integer[set.size()];
    for (Integer i : set) {
      map.put(i, k);
      array[k] = i;
      k++;
    }
    for (int i = 0; i < q; i++) {
      Query current = queries[i];
      char choice = current.type;
      int val = current.val;
      switch (choice) {
      case 'I':
        insert(val);
        break;
      case 'C':
        count(val);
        break;
      case 'D':
        delete(val);
        break;
      case 'K':
        kthSmallest(val);
        break;
      }
    }
  }
}

import java.util.*;

public class RowAndCoinBoxes {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int[] boxes = new int[n + 2];
    int[] count = new int[n + 1];
    for (int i = 0; i < m; i++) {
      int l = in.nextInt();
      int r = in.nextInt();
      boxes[l]++;
      boxes[r + 1]--;
    }
    for (int i = 1; i <= n; i++) {
      boxes[i] += boxes[i - 1];
      count[boxes[i]]++;
    }
    for (int i = n - 1; i >= 0; i--) {
      count[i] += count[i + 1];
    }
    int q = in.nextInt();
    while (q-- > 0) {
      int x = in.nextInt();
      System.out.println(x > n ? 0 : count[x]);
    }
    in.close();
  }
}

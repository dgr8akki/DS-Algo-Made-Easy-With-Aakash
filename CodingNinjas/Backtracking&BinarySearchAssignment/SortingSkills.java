import java.util.*;

public class SortingSkills {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++)
        arr[i] = in.nextInt();
      solve(arr, n);
    }
  }

  private static void solve(int[] arr, int n) {
    for (int i = 0; i < n; i++) {
      if (Math.abs(arr[i] - i) > 1) {
        System.out.println("No");
        return;
      }
    }
    System.out.println("Yes");
  }
}

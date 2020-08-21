import java.util.Arrays;

/**
 * BubbleSort
 */
public class BubbleSort {

  public static void sorter(int[] a) {
    int n = a.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (a[j] > a[j + 1]) {
          int temp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] ar = { 1, 3, 4, 5, 2, 0 };
    System.out.println(Arrays.toString(ar));
    sorter(ar);
    System.out.println(Arrays.toString(ar));
  }
}

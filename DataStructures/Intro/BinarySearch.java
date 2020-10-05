import java.util.Arrays;

/**
 * BinarySearch
 */
public class BinarySearch {

  public static int search(int[] a, int target) {
    int start = 0, n = a.length, end = n - 1;

    while (start <= end) {
      int mid = start + ((end - start) / 2);

      if (a[mid] == target)
        return mid;

      if (a[mid] < target)
        start = mid + 1;
      else
        end = mid - 1;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] ar = { 1, 3, 4, 5, 12, 20 };
    System.out.println(Arrays.toString(ar));
    System.out.println(search(ar, 1));
  }
}

import java.util.Arrays;

public class ArrayCopy {
  public static void main(String[] args) {
    int[] a = { 1, 2, 3, 4, -1, -1 };
    for (int i = 0; i < 4; i++) {
      if (a[i] % 2 == 0) {
        for (int j = a.length - 2; j >= i; j--) {
          a[j + 1] = a[j];
        }
        i++;
      }
    }

    System.out.println(Arrays.toString(a));
  }
}

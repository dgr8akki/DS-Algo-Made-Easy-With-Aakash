import java.util.Arrays;

/**
 * SelectionSort
 */
public class SelectionSort {

    public static void sorter(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            swap(minIndex, i, a);
        }
    }

    public static void swap(int i, int j, int[] ar) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static void main(String[] args) {
        int[] ar = { 1, 3, 4, 5, 2, 0 };
        System.out.println(Arrays.toString(ar));
        sorter(ar);
        System.out.println(Arrays.toString(ar));
    }
}

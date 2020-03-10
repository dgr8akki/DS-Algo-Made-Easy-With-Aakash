import java.util.Arrays;

/**
 * LinearSearch
 */
public class LinearSearch {

    public static int search(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ar = { 1, 3, 4, 5, 2, 0 };
        System.out.println(Arrays.toString(ar));
        System.out.println(search(ar, 0));
    }
}

import java.util.Arrays;

public class MergeSort {

  public static void main(String[] args) {
    int[] ar = {5,4,3,2,1,-1,-2,-3};
    System.out.println(Arrays.toString(ar));
    mergeSort(ar);
    System.out.println(Arrays.toString(ar));
  }

  public static void mergeSort(int[] input) {
    mergeSort(input, 0, input.length - 1);
  }

  private static void mergeSort(int[] input, int start, int end) {
    if (start < end) {
      int mid = start + (end - start) / 2;
      mergeSort(input, start, mid);
      mergeSort(input, mid + 1, end);
      merge(input, start, mid, end);
    }
  }

  private static void merge(int[] input, int start, int mid, int end) {
    int[] temp = new int[end - start + 1];
    int lr = start, rr = mid + 1, mr = 0;
    while (lr <= mid && rr <= end) {
      temp[mr++] = (input[lr] < input[rr]) ? input[lr++] : input[rr++];
    }
    while (lr <= mid) {
      temp[mr++] = input[lr++];
    }
    while (rr <= end) {
      temp[mr++] = input[rr++];
    }

    for (int i = 0, k = start; i < temp.length; i++, k++) {
      input[k] = temp[i];
    }
  }
}

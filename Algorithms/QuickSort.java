package Algorithms;

import java.util.Arrays;

public class QuickSort {
  public void sort(int[] input) {
    sort(input, 0, input.length - 1);
  }

  public void sort(int[] input, int start, int end) {
    if (start < end) {
      int pivotIndex = partition(input, start, end);
      sort(input, start, pivotIndex - 1);
      sort(input, pivotIndex + 1, end);
    }
  }

  private int partition(int[] input, int start, int end) {
    int pivot = input[end];
    int leftRunner = start - 1, rightRunner = end;

    while (true) {
      while (leftRunner < input.length && input[++leftRunner] < pivot)
        ;
      while (rightRunner > 0 && input[--rightRunner] > pivot)
        ;

      if (leftRunner >= rightRunner)
        break;
      else
        swapInArray(input, leftRunner, rightRunner);
    }
    swapInArray(input, leftRunner, end);
    return leftRunner;
  }

  private void swapInArray(int[] ar, int a, int b) {
    int temp = ar[a];
    ar[a] = ar[b];
    ar[b] = temp;
  }

  public static void main(String[] args) {
    int[] ar = { -5, 4, 3, 2, 1, -1, -2, -3 };
    QuickSort qs = new QuickSort();
    qs.sort(ar);
    System.out.println(Arrays.toString(ar));
  }
}

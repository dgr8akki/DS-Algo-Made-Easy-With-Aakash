package Practise;

import java.util.Arrays;

public class QuickSort {
  public static int[] sort(int[] arr) {
    quickSortUtil(arr, 0, arr.length - 1);
    return arr;
  }

  private static void quickSortUtil(int[] arr, int start, int end) {
    if (start >= end)
      return;
    int pivot = partition(arr, start, end);
    quickSortUtil(arr, 0, pivot - 1);
    quickSortUtil(arr, pivot + 1, end);
  }

  private static int partition(int[] arr, int start, int end) {
    swap(arr, (start + end) / 2, end);
    int leftRunner = start;
    for (int rightRunner = start; rightRunner < end; rightRunner++) {
      if (arr[rightRunner] < arr[end]) {
        swap(arr, leftRunner, rightRunner);
        leftRunner++;
      }
    }

    swap(arr, leftRunner, end);
    return leftRunner;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    int[] a = { 1, 2, 9, 8, 7, 5, 3 };
    System.out.println("Array before sorted: " + Arrays.toString(a));
    System.out.println("Array After sorted: " + Arrays.toString(sort(a)));
  }
}

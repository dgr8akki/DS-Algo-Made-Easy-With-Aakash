package Algorithms.Sorting.src;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    int[] arr = { 10, 11, -1, 2, 5, 45 };
    new BogoSort(Arrays.copyOf(arr, arr.length)).sort();
    new BubbleSort(Arrays.copyOf(arr, arr.length)).sort();
    new SelectionSort(Arrays.copyOf(arr, arr.length)).sort();
    new InsertionSort(Arrays.copyOf(arr, arr.length)).sort();
    new QuickSort(Arrays.copyOf(arr, arr.length)).sort();
    new MergeSort(Arrays.copyOf(arr, arr.length)).sort();
  }
}

package com.trijs.ch7;

import java.util.Arrays;

public class MergeSort {
  int[] sort (int[] arr) {
    mergeSort(arr, 0, arr.length - 1);
    return arr;
  }

  void mergeSort (int[] arr, int start, int end) {
    if(start >= end) return;
    int mid = (start + end) / 2;
    mergeSort(arr, start, mid);
    mergeSort(arr, mid + 1, end);
    merge(arr, start,  mid, end);
  }

  private void merge(int[] arr, int start, int mid, int end) {
    int[] temp = Arrays.copyOf(arr, arr.length);
    int leftArrayRunner = start, rightArrayRunner = mid + 1, mergedArrayIndex = start;
    while (leftArrayRunner <= mid && rightArrayRunner <= end)
      arr[mergedArrayIndex++] = temp[leftArrayRunner] < temp[rightArrayRunner] ? temp[leftArrayRunner++] : temp[rightArrayRunner++];
    while (leftArrayRunner <= mid)
      arr[mergedArrayIndex++] = temp[leftArrayRunner++];
    while (rightArrayRunner <= end)
      arr[mergedArrayIndex++] = temp[rightArrayRunner++];
  }

  public static void main(String[] args) {
    MergeSort mergeSort = new MergeSort();
    int[] arr = {5,4,1,9,8,6,7};
    System.out.println("Array Before Sort: " + Arrays.toString(arr));
    System.out.println("Array After Sort: " + Arrays.toString(mergeSort.sort(Arrays.copyOf(arr, arr.length))));

  }
}

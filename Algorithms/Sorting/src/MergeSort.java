package Algorithms.Sorting.src;

import java.util.Arrays;

public class MergeSort extends Sorter {
  MergeSort(int[] arr) {
    super(arr);
  }

  @Override
  public void sort() {
    mergeSort(this.getArr(), 0, this.getArr().length - 1);
    printResult();
  }

  private void mergeSort(int[] arr, int low, int high) {
    if(low >= high) return;
    int mid = (low + high) / 2;
    mergeSort(arr, low, mid);
    mergeSort(arr, mid + 1, high);
    merge(arr, low, mid, high);
  }

  private void merge(int[] arr, int low, int mid, int high) {
    int[] temp = Arrays.copyOf(arr, arr.length);
    int leftArrayIndex = low, rightArrayIndex = mid + 1, mergedArrayIndex = low;
    while (leftArrayIndex <= mid && rightArrayIndex <= high) {
      if(temp[leftArrayIndex] < temp[rightArrayIndex]) {
        arr[mergedArrayIndex] = temp[leftArrayIndex];
        leftArrayIndex++;
      } else {
        arr[mergedArrayIndex] = temp[rightArrayIndex];
        rightArrayIndex++;
      }
      mergedArrayIndex++;
    }

    while (leftArrayIndex <= mid) {
      arr[mergedArrayIndex] = temp[leftArrayIndex];
      leftArrayIndex++;
      mergedArrayIndex++;
    }
    while (rightArrayIndex <= high) {
      arr[mergedArrayIndex] = temp[rightArrayIndex];
      rightArrayIndex++;
      mergedArrayIndex++;
    }
  }
}
